package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.ky.b;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.protocal.protobuf.bqn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(final String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211645);
    paramString = paramJSONObject.optString("appID");
    final String str1 = paramJSONObject.optString("schemeUrl");
    final String str2 = paramJSONObject.optString("parameter");
    final String str3 = paramJSONObject.optString("packageName");
    final String str4 = paramJSONObject.optString("signature");
    int i = paramJSONObject.optInt("alertType");
    final String str5 = paramJSONObject.optString("extInfo");
    ad.i("LiteAppJsApiLaunchMiniProgram", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { paramString, str1, str5, str2, str3, str4 });
    if ((bt.isNullOrNil(paramString)) && (bt.isNullOrNil(str1)) && (bt.isNullOrNil(str3)))
    {
      ad.e("LiteAppJsApiLaunchMiniProgram", "appid and scheme is null or nil");
      this.uYz.YL("fail");
      AppMethodBeat.o(211645);
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
      Object localObject = new b.a();
      ((b.a)localObject).hNM = new bqm();
      ((b.a)localObject).hNN = new bqn();
      ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((b.a)localObject).funcId = 1125;
      localObject = ((b.a)localObject).aDC();
      bqm localbqm = (bqm)((com.tencent.mm.al.b)localObject).hNK.hNQ;
      localbqm.duW = str6;
      localbqm.GKT = paramString;
      localbqm.scene = 0;
      localbqm.url = paramJSONObject;
      localbqm.GKU = str1;
      localbqm.paC = i;
      localbqm.GKV = 0;
      localbqm.packageName = str3;
      ad.i("LiteAppJsApiLaunchMiniProgram", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(localbqm.scene), localbqm.url, localbqm.GKU, Integer.valueOf(localbqm.paC) });
      x.a((com.tencent.mm.al.b)localObject, new x.a()
      {
        public final int a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(211644);
          p.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(211643);
              ad.d("LiteAppJsApiLaunchMiniProgram", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                h.a(h.this).YL("check fail");
                AppMethodBeat.o(211643);
                return;
              }
              Object localObject3 = (bqn)paramAnonymousb.hNL.hNQ;
              switch (((bqn)localObject3).dqI)
              {
              case 1: 
              default: 
                h.c(h.this).YL("check fail");
                AppMethodBeat.o(211643);
                return;
              case 2: 
                h.b(h.this).YL("check fail forbidden scene");
                AppMethodBeat.o(211643);
                return;
              }
              am localam = new am(new am.a()
              {
                public final void u(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2)
                {
                  AppMethodBeat.i(211642);
                  ad.i("LiteAppJsApiLaunchMiniProgram", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous3Boolean1), Boolean.valueOf(paramAnonymous3Boolean2) });
                  if (paramAnonymous3Boolean1)
                  {
                    h.d(h.this).cXe();
                    AppMethodBeat.o(211642);
                    return;
                  }
                  h.e(h.this).YL("fail");
                  AppMethodBeat.o(211642);
                }
              });
              ad.i("LiteAppJsApiLaunchMiniProgram", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((bqn)localObject3).uda), Integer.valueOf(((bqn)localObject3).dqI) });
              Context localContext = aj.getContext();
              Object localObject1;
              if (!bt.isNullOrNil(h.1.this.ksq))
              {
                localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(h.1.this.ksq));
                ((Intent)localObject4).addFlags(268435456);
                localObject1 = bt.ac(localContext, (Intent)localObject4);
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
                  for (localObject1 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject1).get(0)); !bt.nullAsNil(aj.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
                  {
                    localam.go(com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject4, null, ((bqn)localObject3).uda, localam, h.1.this.ksr));
                    AppMethodBeat.o(211643);
                    return;
                  }
                }
              }
              if ((!bt.isNullOrNil(h.1.this.LI)) && (!bt.isNullOrNil(h.1.this.kss)))
              {
                localObject1 = q.bO(localContext, h.1.this.LI);
                if ((localObject1 != null) && (localObject1[0] != null))
                {
                  localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
                  if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(h.1.this.kss))) {
                    break label900;
                  }
                  try
                  {
                    localObject1 = aj.getContext().getPackageManager().getLaunchIntentForPackage(h.1.this.LI);
                    if (localObject1 != null)
                    {
                      localObject4 = new Bundle();
                      q.j((Bundle)localObject4, h.1.this.kst);
                      ((Intent)localObject1).putExtras((Bundle)localObject4);
                      ((Intent)localObject1).addFlags(268435456);
                      localam.go(com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject1, null, localam, h.1.this.ksr));
                      AppMethodBeat.o(211643);
                      return;
                    }
                  }
                  catch (Exception localException)
                  {
                    ad.e("LiteAppJsApiLaunchMiniProgram", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
                  }
                }
              }
              Object localObject2 = new WXAppExtendObject();
              ((WXAppExtendObject)localObject2).extInfo = h.1.this.ksu;
              localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
              ((WXMediaMessage)localObject2).sdkVer = 637928960;
              ((WXMediaMessage)localObject2).messageExt = h.1.this.ksu;
              Object localObject4 = new ky();
              ((ky)localObject4).dyb.dtZ = ((WXMediaMessage)localObject2);
              ((ky)localObject4).dyb.appId = h.1.this.jBr;
              ((ky)localObject4).dyb.dlp = ((bqn)localObject3).uda;
              ((ky)localObject4).dyb.context = localContext;
              ((ky)localObject4).dyb.dnx = h.1.this.ksr;
              ((ky)localObject4).dyb.dyd = localam;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject4);
              boolean bool = ((ky)localObject4).dyc.dye;
              if ((!bool) && (!bt.isNullOrNil(h.1.this.jBr)) && (!bt.isNullOrNil(h.1.this.kst)))
              {
                localObject2 = h.1.this.jBr + "://" + h.1.this.kst;
                localObject3 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
                ad.i("LiteAppJsApiLaunchMiniProgram", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject2 });
                ((Intent)localObject3).addFlags(268435456);
                localObject2 = bt.ac(localContext, (Intent)localObject3);
                if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                  if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject2).size() == 1))
                  {
                    localObject2 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject2).get(0));
                    label855:
                    if (bt.nullAsNil(aj.getPackageName()).equals(localObject2)) {
                      break label920;
                    }
                    localam.reset();
                    bool = com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject3, null, localam, h.1.this.ksr);
                  }
                }
              }
              label900:
              label920:
              for (;;)
              {
                localam.go(bool);
                AppMethodBeat.o(211643);
                return;
                ad.i("LiteAppJsApiLaunchMiniProgram", "launchApplication signature not match");
                break;
                localObject2 = ((Intent)localObject3).getPackage();
                break label855;
              }
            }
          });
          AppMethodBeat.o(211644);
          return 0;
        }
      });
      AppMethodBeat.o(211645);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label182;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.h
 * JD-Core Version:    0.7.0.1
 */