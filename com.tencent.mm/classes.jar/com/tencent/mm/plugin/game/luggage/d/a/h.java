package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.a.nm;
import com.tencent.mm.autogen.a.nm.b;
import com.tencent.mm.b.g;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.pluginsdk.model.app.aq.a;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.ddi;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class h
  extends e
{
  public final void a(final String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277098);
    paramString = paramJSONObject.optString("appID");
    final String str1 = paramJSONObject.optString("schemeUrl");
    final String str2 = paramJSONObject.optString("parameter");
    final String str3 = paramJSONObject.optString("packageName");
    final String str4 = paramJSONObject.optString("signature");
    int i = paramJSONObject.optInt("alertType");
    final String str5 = paramJSONObject.optString("extInfo");
    Object localObject1 = paramJSONObject.optString("sourceInfo");
    Object localObject2 = paramJSONObject.optString("bizInfo");
    Log.i("LiteAppJsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { paramString, str1, str5, str2, str3, str4 });
    if ((Util.isNullOrNil(paramString)) && (Util.isNullOrNil(str1)) && (Util.isNullOrNil(str3)))
    {
      Log.e("LiteAppJsApiLaunchApplication", "appid and scheme is null or nil");
      this.JZj.aJV("fail");
      AppMethodBeat.o(277098);
      return;
    }
    String str6 = paramJSONObject.optString("preVerifyAppId");
    paramJSONObject = paramJSONObject.optString("currentUrl");
    final Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
      label199:
      localBundle.putString("current_page_appid", str6);
      localBundle.putString("current_page_biz_info", (String)localObject2);
      localBundle.putString("current_page_source_info", (String)localObject1);
      localObject1 = new c.a();
      ((c.a)localObject1).otE = new ddi();
      ((c.a)localObject1).otF = new ddj();
      ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((c.a)localObject1).funcId = 1125;
      localObject1 = ((c.a)localObject1).bEF();
      localObject2 = (ddi)c.b.b(((c)localObject1).otB);
      ((ddi)localObject2).appid = str6;
      ((ddi)localObject2).aaIV = paramString;
      ((ddi)localObject2).scene = 0;
      ((ddi)localObject2).url = paramJSONObject;
      ((ddi)localObject2).aaIW = str1;
      ((ddi)localObject2).wYK = i;
      ((ddi)localObject2).ZFJ = 0;
      ((ddi)localObject2).packageName = str3;
      Log.i("LiteAppJsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(((ddi)localObject2).scene), ((ddi)localObject2).url, ((ddi)localObject2).aaIW, Integer.valueOf(((ddi)localObject2).wYK) });
      z.a((c)localObject1, new z.a()
      {
        public final int callback(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(277077);
          s.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(277110);
              Log.d("LiteAppJsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                h.a(h.this).aJV("check fail");
                AppMethodBeat.o(277110);
                return;
              }
              Object localObject3 = (ddj)c.c.b(paramAnonymousc.otC);
              switch (((ddj)localObject3).hGE)
              {
              case 1: 
              default: 
                h.c(h.this).aJV("check fail");
                AppMethodBeat.o(277110);
                return;
              case 2: 
                h.b(h.this).aJV("check fail forbidden scene");
                AppMethodBeat.o(277110);
                return;
              }
              aq localaq = new aq(new aq.a()
              {
                public final void C(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2)
                {
                  AppMethodBeat.i(277102);
                  Log.i("LiteAppJsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous3Boolean1), Boolean.valueOf(paramAnonymous3Boolean2) });
                  if (paramAnonymous3Boolean1)
                  {
                    h.d(h.this).fTW();
                    AppMethodBeat.o(277102);
                    return;
                  }
                  h.e(h.this).aJV("fail");
                  AppMethodBeat.o(277102);
                }
              });
              Log.i("LiteAppJsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((ddj)localObject3).show_type), Integer.valueOf(((ddj)localObject3).hGE) });
              Context localContext = MMApplicationContext.getContext();
              Object localObject1;
              if (!Util.isNullOrNil(h.1.this.ryu))
              {
                localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(h.1.this.ryu));
                ((Intent)localObject4).addFlags(268435456);
                localObject1 = Util.queryIntentActivities(localContext, (Intent)localObject4);
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
                  for (localObject1 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject1).get(0)); !Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
                  {
                    localaq.iY(com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject4, null, ((ddj)localObject3).show_type, localaq, h.1.this.ryv));
                    AppMethodBeat.o(277110);
                    return;
                  }
                }
              }
              if ((!Util.isNullOrNil(h.1.this.bJT)) && (!Util.isNullOrNil(h.1.this.ryw)))
              {
                localObject1 = u.cG(localContext, h.1.this.bJT);
                if ((localObject1 != null) && (localObject1[0] != null))
                {
                  localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
                  if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(h.1.this.ryw))) {
                    break label897;
                  }
                  try
                  {
                    localObject1 = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(h.1.this.bJT);
                    if (localObject1 != null)
                    {
                      localObject4 = new Bundle();
                      u.l((Bundle)localObject4, h.1.this.ryx);
                      ((Intent)localObject1).putExtras((Bundle)localObject4);
                      ((Intent)localObject1).addFlags(268435456);
                      localaq.iY(com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject1, null, localaq, h.1.this.ryv));
                      AppMethodBeat.o(277110);
                      return;
                    }
                  }
                  catch (Exception localException)
                  {
                    Log.e("LiteAppJsApiLaunchApplication", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
                  }
                }
              }
              Object localObject2 = new WXAppExtendObject();
              ((WXAppExtendObject)localObject2).extInfo = h.1.this.ryy;
              localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
              ((WXMediaMessage)localObject2).sdkVer = 638058496;
              ((WXMediaMessage)localObject2).messageExt = h.1.this.ryy;
              Object localObject4 = new nm();
              ((nm)localObject4).hPP.hzF = ((WXMediaMessage)localObject2);
              ((nm)localObject4).hPP.appId = h.1.this.qyB;
              ((nm)localObject4).hPP.hAN = ((ddj)localObject3).show_type;
              ((nm)localObject4).hPP.context = localContext;
              ((nm)localObject4).hPP.hDf = h.1.this.ryv;
              ((nm)localObject4).hPP.hPR = localaq;
              ((nm)localObject4).publish();
              boolean bool = ((nm)localObject4).hPQ.hPS;
              if ((!bool) && (!Util.isNullOrNil(h.1.this.qyB)) && (!Util.isNullOrNil(h.1.this.ryx)))
              {
                localObject2 = h.1.this.qyB + "://" + h.1.this.ryx;
                localObject3 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
                Log.i("LiteAppJsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject2 });
                ((Intent)localObject3).addFlags(268435456);
                localObject2 = Util.queryIntentActivities(localContext, (Intent)localObject3);
                if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                  if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject2).size() == 1))
                  {
                    localObject2 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject2).get(0));
                    label852:
                    if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject2)) {
                      break label917;
                    }
                    localaq.reset();
                    bool = com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject3, null, localaq, h.1.this.ryv);
                  }
                }
              }
              label897:
              label917:
              for (;;)
              {
                localaq.iY(bool);
                AppMethodBeat.o(277110);
                return;
                Log.i("LiteAppJsApiLaunchApplication", "launchApplication signature not match");
                break;
                localObject2 = ((Intent)localObject3).getPackage();
                break label852;
              }
            }
          });
          AppMethodBeat.o(277077);
          return 0;
        }
      });
      AppMethodBeat.o(277098);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label199;
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.h
 * JD-Core Version:    0.7.0.1
 */