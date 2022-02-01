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
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.a.lp.b;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ceb;
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
  public final void a(final String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186914);
    paramString = paramJSONObject.optString("appID");
    final String str1 = paramJSONObject.optString("schemeUrl");
    final String str2 = paramJSONObject.optString("parameter");
    final String str3 = paramJSONObject.optString("packageName");
    final String str4 = paramJSONObject.optString("signature");
    int i = paramJSONObject.optInt("alertType");
    final String str5 = paramJSONObject.optString("extInfo");
    Log.i("LiteAppJsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { paramString, str1, str5, str2, str3, str4 });
    if ((Util.isNullOrNil(paramString)) && (Util.isNullOrNil(str1)) && (Util.isNullOrNil(str3)))
    {
      Log.e("LiteAppJsApiLaunchApplication", "appid and scheme is null or nil");
      this.yEn.aCS("fail");
      AppMethodBeat.o(186914);
      return;
    }
    String str6 = paramJSONObject.optString("preVerifyAppId");
    paramJSONObject = paramJSONObject.optString("currentUrl");
    final Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
      label182:
      localBundle.putString("current_page_appid", str6);
      Object localObject = new d.a();
      ((d.a)localObject).iLN = new cea();
      ((d.a)localObject).iLO = new ceb();
      ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((d.a)localObject).funcId = 1125;
      localObject = ((d.a)localObject).aXF();
      cea localcea = (cea)((d)localObject).iLK.iLR;
      localcea.dNI = str6;
      localcea.MjD = paramString;
      localcea.scene = 0;
      localcea.url = paramJSONObject;
      localcea.MjE = str1;
      localcea.qwp = i;
      localcea.LEg = 0;
      localcea.packageName = str3;
      Log.i("LiteAppJsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(localcea.scene), localcea.url, localcea.MjE, Integer.valueOf(localcea.qwp) });
      aa.a((d)localObject, new aa.a()
      {
        public final int a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final d paramAnonymousd, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(186913);
          p.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186912);
              Log.d("LiteAppJsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                h.a(h.this).aCS("check fail");
                AppMethodBeat.o(186912);
                return;
              }
              Object localObject3 = (ceb)paramAnonymousd.iLL.iLR;
              switch (((ceb)localObject3).dIZ)
              {
              case 1: 
              default: 
                h.c(h.this).aCS("check fail");
                AppMethodBeat.o(186912);
                return;
              case 2: 
                h.b(h.this).aCS("check fail forbidden scene");
                AppMethodBeat.o(186912);
                return;
              }
              am localam = new am(new am.a()
              {
                public final void u(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2)
                {
                  AppMethodBeat.i(186911);
                  Log.i("LiteAppJsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous3Boolean1), Boolean.valueOf(paramAnonymous3Boolean2) });
                  if (paramAnonymous3Boolean1)
                  {
                    h.d(h.this).ecz();
                    AppMethodBeat.o(186911);
                    return;
                  }
                  h.e(h.this).aCS("fail");
                  AppMethodBeat.o(186911);
                }
              });
              Log.i("LiteAppJsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((ceb)localObject3).xGz), Integer.valueOf(((ceb)localObject3).dIZ) });
              Context localContext = MMApplicationContext.getContext();
              Object localObject1;
              if (!Util.isNullOrNil(h.1.this.lzK))
              {
                localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(h.1.this.lzK));
                ((Intent)localObject4).addFlags(268435456);
                localObject1 = Util.queryIntentActivities(localContext, (Intent)localObject4);
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
                  for (localObject1 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject1).get(0)); !Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
                  {
                    localam.hj(com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject4, null, ((ceb)localObject3).xGz, localam, h.1.this.lzL));
                    AppMethodBeat.o(186912);
                    return;
                  }
                }
              }
              if ((!Util.isNullOrNil(h.1.this.LS)) && (!Util.isNullOrNil(h.1.this.lzM)))
              {
                localObject1 = com.tencent.mm.pluginsdk.model.app.q.cj(localContext, h.1.this.LS);
                if ((localObject1 != null) && (localObject1[0] != null))
                {
                  localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
                  if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(h.1.this.lzM))) {
                    break label900;
                  }
                  try
                  {
                    localObject1 = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(h.1.this.LS);
                    if (localObject1 != null)
                    {
                      localObject4 = new Bundle();
                      com.tencent.mm.pluginsdk.model.app.q.k((Bundle)localObject4, h.1.this.lzN);
                      ((Intent)localObject1).putExtras((Bundle)localObject4);
                      ((Intent)localObject1).addFlags(268435456);
                      localam.hj(com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject1, null, localam, h.1.this.lzL));
                      AppMethodBeat.o(186912);
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
              ((WXAppExtendObject)localObject2).extInfo = h.1.this.lzO;
              localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
              ((WXMediaMessage)localObject2).sdkVer = 637928960;
              ((WXMediaMessage)localObject2).messageExt = h.1.this.lzO;
              Object localObject4 = new lp();
              ((lp)localObject4).dQT.dCE = ((WXMediaMessage)localObject2);
              ((lp)localObject4).dQT.appId = h.1.this.kFU;
              ((lp)localObject4).dQT.dDG = ((ceb)localObject3).xGz;
              ((lp)localObject4).dQT.context = localContext;
              ((lp)localObject4).dQT.dFP = h.1.this.lzL;
              ((lp)localObject4).dQT.dQV = localam;
              EventCenter.instance.publish((IEvent)localObject4);
              boolean bool = ((lp)localObject4).dQU.dQW;
              if ((!bool) && (!Util.isNullOrNil(h.1.this.kFU)) && (!Util.isNullOrNil(h.1.this.lzN)))
              {
                localObject2 = h.1.this.kFU + "://" + h.1.this.lzN;
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
                    bool = com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject3, null, localam, h.1.this.lzL);
                  }
                }
              }
              label900:
              label920:
              for (;;)
              {
                localam.hj(bool);
                AppMethodBeat.o(186912);
                return;
                Log.i("LiteAppJsApiLaunchApplication", "launchApplication signature not match");
                break;
                localObject2 = ((Intent)localObject3).getPackage();
                break label855;
              }
            }
          });
          AppMethodBeat.o(186913);
          return 0;
        }
      });
      AppMethodBeat.o(186914);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label182;
    }
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.h
 * JD-Core Version:    0.7.0.1
 */