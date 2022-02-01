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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.a.kz.b;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(final String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193034);
    paramString = paramJSONObject.optString("appID");
    final String str1 = paramJSONObject.optString("schemeUrl");
    final String str2 = paramJSONObject.optString("parameter");
    final String str3 = paramJSONObject.optString("packageName");
    final String str4 = paramJSONObject.optString("signature");
    int i = paramJSONObject.optInt("alertType");
    final String str5 = paramJSONObject.optString("extInfo");
    ae.i("LiteAppJsApiLaunchMiniProgram", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { paramString, str1, str5, str2, str3, str4 });
    if ((bu.isNullOrNil(paramString)) && (bu.isNullOrNil(str1)) && (bu.isNullOrNil(str3)))
    {
      ae.e("LiteAppJsApiLaunchMiniProgram", "appid and scheme is null or nil");
      this.vko.ZC("fail");
      AppMethodBeat.o(193034);
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
      ((b.a)localObject).hQF = new brg();
      ((b.a)localObject).hQG = new brh();
      ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((b.a)localObject).funcId = 1125;
      localObject = ((b.a)localObject).aDS();
      brg localbrg = (brg)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
      localbrg.dwb = str6;
      localbrg.Heu = paramString;
      localbrg.scene = 0;
      localbrg.url = paramJSONObject;
      localbrg.Hev = str1;
      localbrg.phg = i;
      localbrg.Hew = 0;
      localbrg.packageName = str3;
      ae.i("LiteAppJsApiLaunchMiniProgram", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(localbrg.scene), localbrg.url, localbrg.Hev, Integer.valueOf(localbrg.phg) });
      x.a((com.tencent.mm.ak.b)localObject, new x.a()
      {
        public final int a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(193033);
          p.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193032);
              ae.d("LiteAppJsApiLaunchMiniProgram", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                h.a(h.this).ZC("check fail");
                AppMethodBeat.o(193032);
                return;
              }
              Object localObject3 = (brh)paramAnonymousb.hQE.hQJ;
              switch (((brh)localObject3).drN)
              {
              case 1: 
              default: 
                h.c(h.this).ZC("check fail");
                AppMethodBeat.o(193032);
                return;
              case 2: 
                h.b(h.this).ZC("check fail forbidden scene");
                AppMethodBeat.o(193032);
                return;
              }
              am localam = new am(new am.a()
              {
                public final void u(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2)
                {
                  AppMethodBeat.i(193031);
                  ae.i("LiteAppJsApiLaunchMiniProgram", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous3Boolean1), Boolean.valueOf(paramAnonymous3Boolean2) });
                  if (paramAnonymous3Boolean1)
                  {
                    h.d(h.this).cZN();
                    AppMethodBeat.o(193031);
                    return;
                  }
                  h.e(h.this).ZC("fail");
                  AppMethodBeat.o(193031);
                }
              });
              ae.i("LiteAppJsApiLaunchMiniProgram", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((brh)localObject3).uoi), Integer.valueOf(((brh)localObject3).drN) });
              Context localContext = ak.getContext();
              Object localObject1;
              if (!bu.isNullOrNil(h.1.this.kvG))
              {
                localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(h.1.this.kvG));
                ((Intent)localObject4).addFlags(268435456);
                localObject1 = bu.ac(localContext, (Intent)localObject4);
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
                  for (localObject1 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject1).get(0)); !bu.nullAsNil(ak.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
                  {
                    localam.gm(com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject4, null, ((brh)localObject3).uoi, localam, h.1.this.kvH));
                    AppMethodBeat.o(193032);
                    return;
                  }
                }
              }
              if ((!bu.isNullOrNil(h.1.this.LI)) && (!bu.isNullOrNil(h.1.this.kvI)))
              {
                localObject1 = q.bP(localContext, h.1.this.LI);
                if ((localObject1 != null) && (localObject1[0] != null))
                {
                  localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
                  if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(h.1.this.kvI))) {
                    break label900;
                  }
                  try
                  {
                    localObject1 = ak.getContext().getPackageManager().getLaunchIntentForPackage(h.1.this.LI);
                    if (localObject1 != null)
                    {
                      localObject4 = new Bundle();
                      q.j((Bundle)localObject4, h.1.this.kvJ);
                      ((Intent)localObject1).putExtras((Bundle)localObject4);
                      ((Intent)localObject1).addFlags(268435456);
                      localam.gm(com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject1, null, localam, h.1.this.kvH));
                      AppMethodBeat.o(193032);
                      return;
                    }
                  }
                  catch (Exception localException)
                  {
                    ae.e("LiteAppJsApiLaunchMiniProgram", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
                  }
                }
              }
              Object localObject2 = new WXAppExtendObject();
              ((WXAppExtendObject)localObject2).extInfo = h.1.this.kvK;
              localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
              ((WXMediaMessage)localObject2).sdkVer = 637928960;
              ((WXMediaMessage)localObject2).messageExt = h.1.this.kvK;
              Object localObject4 = new kz();
              ((kz)localObject4).dzg.dve = ((WXMediaMessage)localObject2);
              ((kz)localObject4).dzg.appId = h.1.this.jEl;
              ((kz)localObject4).dzg.dmr = ((brh)localObject3).uoi;
              ((kz)localObject4).dzg.context = localContext;
              ((kz)localObject4).dzg.doz = h.1.this.kvH;
              ((kz)localObject4).dzg.dzi = localam;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject4);
              boolean bool = ((kz)localObject4).dzh.dzj;
              if ((!bool) && (!bu.isNullOrNil(h.1.this.jEl)) && (!bu.isNullOrNil(h.1.this.kvJ)))
              {
                localObject2 = h.1.this.jEl + "://" + h.1.this.kvJ;
                localObject3 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
                ae.i("LiteAppJsApiLaunchMiniProgram", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject2 });
                ((Intent)localObject3).addFlags(268435456);
                localObject2 = bu.ac(localContext, (Intent)localObject3);
                if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                  if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject2).size() == 1))
                  {
                    localObject2 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject2).get(0));
                    label855:
                    if (bu.nullAsNil(ak.getPackageName()).equals(localObject2)) {
                      break label920;
                    }
                    localam.reset();
                    bool = com.tencent.mm.pluginsdk.model.app.h.a(localContext, (Intent)localObject3, null, localam, h.1.this.kvH);
                  }
                }
              }
              label900:
              label920:
              for (;;)
              {
                localam.gm(bool);
                AppMethodBeat.o(193032);
                return;
                ae.i("LiteAppJsApiLaunchMiniProgram", "launchApplication signature not match");
                break;
                localObject2 = ((Intent)localObject3).getPackage();
                break label855;
              }
            }
          });
          AppMethodBeat.o(193033);
          return 0;
        }
      });
      AppMethodBeat.o(193034);
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