package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.ae.a.a.a;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class WXBizEntryActivity
  extends AutoLoginActivity
{
  private c<com.tencent.mm.plugin.appbrand.service.d> nNh = null;
  private int nNi;
  private boolean nNj;
  private boolean nNk = false;
  
  private static void a(Bundle paramBundle, BaseResp paramBaseResp, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(22211);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramg.field_packageName;
    paramBaseResp.bundle = paramBundle;
    q.bb(paramBundle);
    q.bc(paramBundle);
    MMessageActV2.send(aj.getContext(), paramBaseResp);
    AppMethodBeat.o(22211);
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(22210);
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.m(getIntent().getStringExtra("key_app_id"), true, false);
    if (localg == null)
    {
      ad.e("MicroMsg.WXBizEntryActivity", "launchMiniProgramBackToApp info is null");
      AppMethodBeat.o(22210);
      return;
    }
    Bundle localBundle = new Bundle();
    if (paramBoolean) {}
    WXLaunchMiniProgram.Resp localResp;
    for (paramString1 = new WXLaunchMiniProgramWithToken.Resp(localBundle);; paramString1 = localResp)
    {
      paramString1.errStr = paramString2;
      paramString1.openId = localg.field_openId;
      paramString1.errCode = paramInt;
      a(localBundle, paramString1, localg);
      AppMethodBeat.o(22210);
      return;
      localResp = new WXLaunchMiniProgram.Resp(localBundle);
      ((WXLaunchMiniProgram.Resp)localResp).extMsg = bt.bI(paramString1, "{}");
    }
  }
  
  private static void eF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22212);
    paramString1 = com.tencent.mm.pluginsdk.model.app.h.m(paramString1, true, false);
    if (paramString1 == null)
    {
      AppMethodBeat.o(22212);
      return;
    }
    Object localObject = new WXAppExtendObject();
    ((WXAppExtendObject)localObject).extInfo = paramString2;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).sdkVer = 637928960;
    ((WXMediaMessage)localObject).messageExt = paramString2;
    com.tencent.mm.pluginsdk.model.app.h.a(aj.getContext(), paramString1.field_appId, (WXMediaMessage)localObject, 2, null, null);
    AppMethodBeat.o(22212);
  }
  
  private void jd(final boolean paramBoolean)
  {
    AppMethodBeat.i(22213);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193147);
        View localView = WXBizEntryActivity.this.findViewById(2131302340);
        if (localView != null) {
          if (!paramBoolean) {
            break label39;
          }
        }
        label39:
        for (int i = 0;; i = 8)
        {
          localView.setVisibility(i);
          AppMethodBeat.o(193147);
          return;
        }
      }
    });
    AppMethodBeat.o(22213);
  }
  
  public final void a(final AutoLoginActivity.a parama, final Intent paramIntent)
  {
    AppMethodBeat.i(22209);
    ad.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    if (getIntent() != null) {
      this.nNi = getIntent().getIntExtra("key_command_id", 0);
    }
    switch (WXBizEntryActivity.2.nNm[parama.ordinal()])
    {
    default: 
      ad.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
    }
    for (;;)
    {
      f.yO(3);
      finish();
      AppMethodBeat.o(22209);
      return;
      ad.i("MicroMsg.WXBizEntryActivity", "req type = %d", new Object[] { Integer.valueOf(this.nNi) });
      if ((f.bMd()) && (this.nNj))
      {
        ad.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry dealRequest isInConsumedSet finished");
        finish();
      }
      for (;;)
      {
        f.yO(4);
        AppMethodBeat.o(22209);
        return;
        Object localObject1;
        Object localObject2;
        final String str1;
        switch (this.nNi)
        {
        case 10: 
        case 18: 
        case 20: 
        case 21: 
        case 22: 
        case 23: 
        case 27: 
        case 28: 
        default: 
          finish();
          break;
        case 9: 
          com.tencent.mm.bs.d.c(this, "card", ".ui.CardAddEntranceUI", getIntent());
          finish();
          break;
        case 16: 
          com.tencent.mm.bs.d.c(this, "card", ".ui.CardListSelectedUI", getIntent());
          finish();
          break;
        case 7: 
        case 8: 
          parama = getIntent();
          parama.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
          parama = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
          com.tencent.mm.hellhoundlib.a.a.a(this, parama.ahp(), "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)parama.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          break;
        case 11: 
          parama = getIntent();
          parama.putExtra("device_type", 1);
          com.tencent.mm.bs.d.c(this, "exdevice", ".ui.ExdeviceRankInfoUI", parama);
          finish();
          break;
        case 13: 
          parama = getIntent();
          parama.putExtra("key_static_from_scene", 100001);
          com.tencent.mm.bs.d.c(this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parama);
          finish();
          break;
        case 14: 
        case 15: 
          new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new d.a()
          {
            public final void jc(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22189);
              if (paramAnonymousBoolean) {
                com.tencent.mm.bs.d.c(WXBizEntryActivity.this, "game", ".ui.CreateOrJoinChatroomUI", WXBizEntryActivity.this.getIntent());
              }
              for (;;)
              {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.o(22189);
                return;
                ad.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
              }
            }
          }).bMa();
          break;
        case 17: 
          try
          {
            parama = getIntent().getData();
            paramIntent = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(22195);
                WXBizEntryActivity.this.findViewById(2131302340).setVisibility(8);
                AppMethodBeat.o(22195);
              }
            };
            localObject1 = getIntent().getStringExtra("key_package_name");
            localObject2 = getIntent().getStringExtra("key_package_signature");
            f.a(this, parama, getIntent().getIntExtra("translate_link_scene", 1), (String)localObject1, (String)localObject2, paramIntent);
          }
          catch (Exception parama)
          {
            ad.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", new Object[] { parama.getMessage() });
          }
          break;
        case 12: 
          try
          {
            parama = getIntent().getData();
            if ((parama != null) && (com.tencent.mm.pluginsdk.g.aLk(parama.toString())))
            {
              y.aBq().AG("key_data_center_session_id");
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22197);
                  ad.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
                  {
                    paramAnonymousString = ((ab)paramAnonymousn).aLd();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bt.bI(paramAnonymousString.HDY, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          AppMethodBeat.i(22196);
                          WXBizEntryActivity.a(WXBizEntryActivity.this);
                          WXBizEntryActivity.this.finish();
                          AppMethodBeat.o(22196);
                        }
                      });
                      AppMethodBeat.o(22197);
                      return;
                    }
                    WXBizEntryActivity.this.finish();
                    AppMethodBeat.o(22197);
                    return;
                  }
                  WXBizEntryActivity.this.finish();
                  AppMethodBeat.o(22197);
                }
              }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              ad.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        case 25: 
          try
          {
            parama = getIntent().getData();
            if ((parama != null) && (com.tencent.mm.pluginsdk.g.aLl(parama.toString())))
            {
              y.aBq().AG("key_data_center_session_id");
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22199);
                  ad.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
                  {
                    paramAnonymousString = ((ab)paramAnonymousn).aLd();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bt.bI(paramAnonymousString.HDY, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          AppMethodBeat.i(22198);
                          WXBizEntryActivity.b(WXBizEntryActivity.this);
                          WXBizEntryActivity.this.finish();
                          AppMethodBeat.o(22198);
                        }
                      });
                      AppMethodBeat.o(22199);
                      return;
                    }
                    WXBizEntryActivity.this.finish();
                    AppMethodBeat.o(22199);
                    return;
                  }
                  WXBizEntryActivity.this.finish();
                  AppMethodBeat.o(22199);
                }
              }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              ad.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        case 19: 
        case 29: 
          try
          {
            parama = getIntent().getData();
            if (parama != null)
            {
              localObject1 = parama.toString();
              paramIntent = (Intent)localObject1;
              if (getIntent().getBooleanExtra("key_launch_mini_program_is_used_token", false))
              {
                str1 = getIntent().getStringExtra("key_launch_mini_program_token");
                paramIntent = com.tencent.mm.plugin.ext.b.crZ().afG(str1);
                if (paramIntent == null) {
                  com.tencent.mm.ui.base.h.a(this, bt.nullAsNil(getString(2131760671)), getString(2131755906), getString(2131755835), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                    {
                      AppMethodBeat.i(22200);
                      WXBizEntryActivity.a(WXBizEntryActivity.this, "", "invalid_token");
                      WXBizEntryActivity.this.finish();
                      AppMethodBeat.o(22200);
                    }
                  });
                }
              }
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              ad.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
            localObject2 = paramIntent.field_username;
            paramIntent = (Intent)localObject2;
            if (((String)localObject2).endsWith("@app")) {
              paramIntent = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("@app"));
            }
            paramIntent = ((String)localObject1).replace(str1, paramIntent);
            ad.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogramWithToken, url with username=".concat(String.valueOf(paramIntent)));
            f.yO(5);
            parama = parama.getQueryParameter("invokeData");
            final long l = System.currentTimeMillis();
            com.tencent.mm.pluginsdk.g.a(this, paramIntent, getIntent().getIntExtra("translate_link_scene", 1), new g.a()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(22202);
                ad.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                WXBizEntryActivity.a(WXBizEntryActivity.this, paramAnonymousInt2, paramAnonymousn, (int)(System.currentTimeMillis() - l));
                if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
                {
                  f.yO(7);
                  paramAnonymousString = ((ab)paramAnonymousn).aLd();
                  if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                  {
                    com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bt.bI(paramAnonymousString.HDY, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(22201);
                        paramAnonymous2DialogInterface = WXBizEntryActivity.this;
                        String str1 = WXBizEntryActivity.7.this.nNr;
                        String str2 = paramAnonymousString.HDY;
                        if (WXBizEntryActivity.c(WXBizEntryActivity.this) == 29) {}
                        for (boolean bool = true;; bool = false)
                        {
                          WXBizEntryActivity.a(paramAnonymous2DialogInterface, str1, str2, bool);
                          WXBizEntryActivity.this.finish();
                          AppMethodBeat.o(22201);
                          return;
                        }
                      }
                    });
                    AppMethodBeat.o(22202);
                    return;
                  }
                  WXBizEntryActivity.this.finish();
                  AppMethodBeat.o(22202);
                  return;
                }
                f.yO(6);
                WXBizEntryActivity.this.finish();
                AppMethodBeat.o(22202);
              }
            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
          }
          break;
        case 26: 
          try
          {
            parama = getIntent().getData();
            if (parama != null) {
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new a(), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              ad.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch fake native miniprogram failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        case 30: 
          paramIntent = getIntent();
          ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).aYx();
          String str2;
          for (;;)
          {
            try
            {
              localObject2 = paramIntent.getData();
              if (localObject2 == null)
              {
                parama = null;
                int i = paramIntent.getIntExtra("translate_link_scene", 1);
                str1 = paramIntent.getStringExtra("key_package_name");
                str2 = paramIntent.getStringExtra("key_package_signature");
                localObject1 = paramIntent.getBundleExtra("key_launch_wxa_redirecting_page_req");
                if (localObject1 == null) {
                  continue;
                }
                paramIntent = new WXLaunchWxaRedirectingPage.Req();
                paramIntent.fromBundle((Bundle)localObject1);
                if (paramIntent != null) {
                  break label1377;
                }
                localObject1 = "null";
                ad.i("MicroMsg.WXBizEntryActivity", "dealRequest COMMAND_LAUNCH_WX_WXA_REDIRECTING_PAGE, deepLink[%s] translateLinkScene[%d], appPackage[%s | %s], req.ticket[%s]", new Object[] { localObject2, Integer.valueOf(i), str1, str2, localObject1 });
                if ((localObject2 != null) && (i > 0) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (paramIntent != null)) {
                  break label1386;
                }
                finish();
                break;
              }
              parama = ((Uri)localObject2).getQueryParameter("appid");
              continue;
              paramIntent = null;
              continue;
            }
            catch (Exception parama)
            {
              ad.printErrStackTrace("MicroMsg.WXBizEntryActivity", parama, "dealRequest COMMAND_LAUNCH_WX_WXA_REDIRECTING_PAGE", new Object[0]);
              finish();
            }
            localObject1 = paramIntent.invokeTicket;
          }
          localObject1 = new dpw();
          ((dpw)localObject1).link = ((Uri)localObject2).toString();
          ((dpw)localObject1).scene = 1;
          localObject2 = new du();
          ((du)localObject2).signature = str2;
          ((du)localObject2).pkf = str1;
          ((dpw)localObject1).HDW.add(localObject2);
          localObject2 = new b.a();
          ((b.a)localObject2).hNM = ((com.tencent.mm.bx.a)localObject1);
          ((b.a)localObject2).hNN = new dpx();
          ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/translatelink";
          ((b.a)localObject2).funcId = 1200;
          f.yP(3);
          x.a(((b.a)localObject2).aDC(), new x.a()
          {
            public final int a(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
            {
              AppMethodBeat.i(193146);
              paramAnonymousb = (dpx)paramAnonymousb.hNL.hNQ;
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                ad.e("MicroMsg.WXBizEntryActivity", "doLaunchWxaRedirectingPage, with ticket[%s] hostAppId[%s], cgi failed, errType[%d] errCode[%d] errMsg[%s]", new Object[] { paramIntent.invokeTicket, parama, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                f.yP(5);
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(193144);
                    String str;
                    if (paramAnonymousb != null)
                    {
                      str = paramAnonymousb.HDY;
                      if (!TextUtils.isEmpty(str)) {
                        break label114;
                      }
                      if (TextUtils.isEmpty(paramAnonymousString)) {
                        break label98;
                      }
                      str = paramAnonymousString;
                    }
                    label98:
                    label114:
                    for (;;)
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, str, WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(193143);
                          f.a(WXBizEntryActivity.this, WXBizEntryActivity.9.this.nNv, WXBizEntryActivity.9.this.nNx, WXBizEntryActivity.9.1.this.val$errCode, WXBizEntryActivity.9.1.this.val$errMsg);
                          AppMethodBeat.o(193143);
                        }
                      });
                      AppMethodBeat.o(193144);
                      return;
                      str = null;
                      break;
                      str = WXBizEntryActivity.this.getString(2131761811);
                    }
                  }
                });
                AppMethodBeat.o(193146);
                return 0;
              }
              if ((paramAnonymousb.HEb == null) || (paramAnonymousb.HEb.zr.length <= 0))
              {
                f.yP(6);
                ad.e("MicroMsg.WXBizEntryActivity", "doLaunchWxaRedirectingPage, with ticket[%s] hostAppId[%s], get invalid wxa_runtime_buff from cgi", new Object[] { paramIntent.invokeTicket, parama });
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(193145);
                    Toast.makeText(aj.getContext(), 2131767050, 0).show();
                    AppMethodBeat.o(193145);
                  }
                });
                f.a(WXBizEntryActivity.this, paramIntent, str1, -1, "Invalid wxa_runtime_buff");
                AppMethodBeat.o(193146);
                return 0;
              }
              f.yP(4);
              paramAnonymousString = paramAnonymousb.HDX;
              paramAnonymousString = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).a(WXBizEntryActivity.this, paramIntent, ((du)this.nNy.HDW.getFirst()).pkf, paramAnonymousString, paramAnonymousb.HEb.ffY());
              if (((Integer)paramAnonymousString.first).intValue() != 0) {
                f.a(WXBizEntryActivity.this, paramIntent, str1, ((Integer)paramAnonymousString.first).intValue(), (String)paramAnonymousString.second);
              }
              for (;;)
              {
                AppMethodBeat.o(193146);
                return 0;
                a.a.b(paramIntent.invokeTicket, WXBizEntryActivity.this);
              }
            }
          }, true);
          break;
        case 24: 
          try
          {
            label1377:
            label1386:
            parama = getIntent().getData();
            if (parama != null) {
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22204);
                  ad.i("MicroMsg.WXBizEntryActivity", "offline pay, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
                  {
                    paramAnonymousString = ((ab)paramAnonymousn).aLd();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bt.bI(paramAnonymousString.HDY, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          AppMethodBeat.i(22203);
                          WXBizEntryActivity.f(WXBizEntryActivity.this);
                          WXBizEntryActivity.this.finish();
                          AppMethodBeat.o(22203);
                        }
                      });
                      AppMethodBeat.o(22204);
                      return;
                    }
                    WXBizEntryActivity.this.finish();
                    AppMethodBeat.o(22204);
                    return;
                  }
                  WXBizEntryActivity.this.finish();
                  AppMethodBeat.o(22204);
                }
              }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              ad.e("MicroMsg.WXBizEntryActivity", "get data from intent for offline pay failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        }
      }
      ad.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
    }
  }
  
  public final boolean ab(Intent paramIntent)
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131493200;
  }
  
  public void hideAllManagedDialogs()
  {
    AppMethodBeat.i(22214);
    super.hideAllManagedDialogs();
    jd(false);
    AppMethodBeat.o(22214);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22208);
    this.nNj = f.ae(getIntent());
    com.tencent.mm.kernel.g.ajA();
    if ((com.tencent.mm.kernel.a.aiJ()) && (!com.tencent.mm.kernel.a.aiE())) {
      f.ad(getIntent());
    }
    setTheme(2131821150);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.WXBizEntryActivity", "onCreate");
    if (f.bMd())
    {
      boolean bool = getIntent().getBooleanExtra("__BIZ_ENTRY_FROM_RETRY", false);
      if (this.nNj)
      {
        if (bool) {}
        for (i = 32;; i = 33)
        {
          f.yO(i);
          ad.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry isInConsumedSet finished");
          finish();
          AppMethodBeat.o(22208);
          return;
        }
      }
      if (!bool) {
        break label144;
      }
    }
    label144:
    for (int i = 34;; i = 35)
    {
      f.yO(i);
      setTitleVisibility(0);
      AppMethodBeat.o(22208);
      return;
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(22207);
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(9);
    AppMethodBeat.o(22207);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(22215);
    super.onNewIntent(paramIntent);
    ad.i("MicroMsg.WXBizEntryActivity", "onNewIntent");
    this.nNk = false;
    if (this.nNh != null)
    {
      this.nNh.dead();
      this.nNh = null;
    }
    jd(true);
    AppMethodBeat.o(22215);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22217);
    super.onPause();
    ad.i("MicroMsg.WXBizEntryActivity", "onPause");
    AppMethodBeat.o(22217);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22216);
    super.onResume();
    ad.i("MicroMsg.WXBizEntryActivity", "onResume, mDoFinishOnNextResume[%b]", new Object[] { Boolean.valueOf(this.nNk) });
    if (this.nNk) {
      finish();
    }
    AppMethodBeat.o(22216);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements o.a, g.a
  {
    a() {}
    
    public final void a(int paramInt1, int paramInt2, final String paramString, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(22192);
      ad.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
      if ((paramn != null) && (((!paramBoolean) && (!bt.isNullOrNil(paramString))) || ((paramInt1 != 0) && (paramInt2 != 0) && ((paramn instanceof ab)))))
      {
        paramn = ((ab)paramn).aLd();
        if ((paramn != null) && (!WXBizEntryActivity.this.isFinishing()))
        {
          paramString = bt.bI(bt.bI(paramn.HDY, paramString), WXBizEntryActivity.this.getString(2131761811));
          com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, paramString, WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(22190);
              WXBizEntryActivity.a(WXBizEntryActivity.this, paramString);
              WXBizEntryActivity.this.finish();
              AppMethodBeat.o(22190);
            }
          });
          AppMethodBeat.o(22192);
          return;
        }
        WXBizEntryActivity.this.finish();
        AppMethodBeat.o(22192);
        return;
      }
      if ((paramn instanceof ab))
      {
        paramString = ((ab)paramn).aLc();
        ad.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback transUri[%s]", new Object[] { paramString });
        if (!bt.nullAsNil(paramString).startsWith("weixin://dl/jumpFakeWxa/")) {
          WXBizEntryActivity.this.finish();
        }
        AppMethodBeat.o(22192);
        return;
      }
      ad.e("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, scene is not NetSceneTranslateLink, finish activity");
      WXBizEntryActivity.this.finish();
      AppMethodBeat.o(22192);
    }
    
    public final void brK()
    {
      AppMethodBeat.i(22193);
      if (WXBizEntryActivity.d(WXBizEntryActivity.this) != null)
      {
        WXBizEntryActivity.d(WXBizEntryActivity.this).dead();
        WXBizEntryActivity.a(WXBizEntryActivity.this, null);
      }
      WXBizEntryActivity.a(WXBizEntryActivity.this, new c() {});
      WXBizEntryActivity.d(WXBizEntryActivity.this).alive();
      WXBizEntryActivity.e(WXBizEntryActivity.this);
      AppMethodBeat.o(22193);
    }
    
    public final void brL()
    {
      AppMethodBeat.i(22194);
      WXBizEntryActivity.this.finish();
      AppMethodBeat.o(22194);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity
 * JD-Core Version:    0.7.0.1
 */