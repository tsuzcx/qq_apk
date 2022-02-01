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
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.mg;
import com.tencent.mm.f.a.mg.b;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class h
  extends b
{
  public final void a(final String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(231489);
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
      this.Ega.aNa("fail");
      AppMethodBeat.o(231489);
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
      localObject1 = new d.a();
      ((d.a)localObject1).lBU = new cmu();
      ((d.a)localObject1).lBV = new cmv();
      ((d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((d.a)localObject1).funcId = 1125;
      localObject1 = ((d.a)localObject1).bgN();
      localObject2 = (cmu)d.b.b(((d)localObject1).lBR);
      ((cmu)localObject2).appid = str6;
      ((cmu)localObject2).Tur = paramString;
      ((cmu)localObject2).scene = 0;
      ((cmu)localObject2).url = paramJSONObject;
      ((cmu)localObject2).Tus = str1;
      ((cmu)localObject2).tVq = i;
      ((cmu)localObject2).SEl = 0;
      ((cmu)localObject2).packageName = str3;
      Log.i("LiteAppJsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(((cmu)localObject2).scene), ((cmu)localObject2).url, ((cmu)localObject2).Tus, Integer.valueOf(((cmu)localObject2).tVq) });
      aa.a((d)localObject1, new aa.a()
      {
        public final int a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final d paramAnonymousd, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(231499);
          s.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(231222);
              Log.d("LiteAppJsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                h.a(h.this).aNa("check fail");
                AppMethodBeat.o(231222);
                return;
              }
              Object localObject3 = (cmv)d.c.b(paramAnonymousd.lBS);
              switch (((cmv)localObject3).fBP)
              {
              case 1: 
              default: 
                h.c(h.this).aNa("check fail");
                AppMethodBeat.o(231222);
                return;
              case 2: 
                h.b(h.this).aNa("check fail forbidden scene");
                AppMethodBeat.o(231222);
                return;
              }
              am localam = new am(new am.a()
              {
                public final void x(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2)
                {
                  AppMethodBeat.i(231973);
                  Log.i("LiteAppJsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous3Boolean1), Boolean.valueOf(paramAnonymous3Boolean2) });
                  if (paramAnonymous3Boolean1)
                  {
                    h.d(h.this).eLC();
                    AppMethodBeat.o(231973);
                    return;
                  }
                  h.e(h.this).aNa("fail");
                  AppMethodBeat.o(231973);
                }
              });
              Log.i("LiteAppJsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((cmv)localObject3).CKC), Integer.valueOf(((cmv)localObject3).fBP) });
              Context localContext = MMApplicationContext.getContext();
              Object localObject1;
              if (!Util.isNullOrNil(h.1.this.ova))
              {
                localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(h.1.this.ova));
                ((Intent)localObject4).addFlags(268435456);
                localObject1 = Util.queryIntentActivities(localContext, (Intent)localObject4);
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
                  for (localObject1 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject1).get(0)); !Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
                  {
                    localam.hZ(com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject4, null, ((cmv)localObject3).CKC, localam, h.1.this.ovb));
                    AppMethodBeat.o(231222);
                    return;
                  }
                }
              }
              if ((!Util.isNullOrNil(h.1.this.ack)) && (!Util.isNullOrNil(h.1.this.ovc)))
              {
                localObject1 = com.tencent.mm.pluginsdk.model.app.q.cv(localContext, h.1.this.ack);
                if ((localObject1 != null) && (localObject1[0] != null))
                {
                  localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
                  if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(h.1.this.ovc))) {
                    break label900;
                  }
                  try
                  {
                    localObject1 = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(h.1.this.ack);
                    if (localObject1 != null)
                    {
                      localObject4 = new Bundle();
                      com.tencent.mm.pluginsdk.model.app.q.l((Bundle)localObject4, h.1.this.ovd);
                      ((Intent)localObject1).putExtras((Bundle)localObject4);
                      ((Intent)localObject1).addFlags(268435456);
                      localam.hZ(com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject1, null, localam, h.1.this.ovb));
                      AppMethodBeat.o(231222);
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
              ((WXAppExtendObject)localObject2).extInfo = h.1.this.ove;
              localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
              ((WXMediaMessage)localObject2).sdkVer = 637992960;
              ((WXMediaMessage)localObject2).messageExt = h.1.this.ove;
              Object localObject4 = new mg();
              ((mg)localObject4).fKj.fvl = ((WXMediaMessage)localObject2);
              ((mg)localObject4).fKj.appId = h.1.this.nzB;
              ((mg)localObject4).fKj.fwp = ((cmv)localObject3).CKC;
              ((mg)localObject4).fKj.context = localContext;
              ((mg)localObject4).fKj.fyw = h.1.this.ovb;
              ((mg)localObject4).fKj.fKl = localam;
              EventCenter.instance.publish((IEvent)localObject4);
              boolean bool = ((mg)localObject4).fKk.fKm;
              if ((!bool) && (!Util.isNullOrNil(h.1.this.nzB)) && (!Util.isNullOrNil(h.1.this.ovd)))
              {
                localObject2 = h.1.this.nzB + "://" + h.1.this.ovd;
                localObject3 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
                Log.i("LiteAppJsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject2 });
                ((Intent)localObject3).addFlags(268435456);
                localObject2 = Util.queryIntentActivities(localContext, (Intent)localObject3);
                if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                  if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject2).size() == 1))
                  {
                    localObject2 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject2).get(0));
                    label855:
                    if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject2)) {
                      break label920;
                    }
                    localam.reset();
                    bool = com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject3, null, localam, h.1.this.ovb);
                  }
                }
              }
              label900:
              label920:
              for (;;)
              {
                localam.hZ(bool);
                AppMethodBeat.o(231222);
                return;
                Log.i("LiteAppJsApiLaunchApplication", "launchApplication signature not match");
                break;
                localObject2 = ((Intent)localObject3).getPackage();
                break label855;
              }
            }
          });
          AppMethodBeat.o(231499);
          return 0;
        }
      });
      AppMethodBeat.o(231489);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label199;
    }
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.h
 * JD-Core Version:    0.7.0.1
 */