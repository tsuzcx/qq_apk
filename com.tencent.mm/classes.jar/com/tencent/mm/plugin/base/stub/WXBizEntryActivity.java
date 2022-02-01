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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.ac.a.a.a;
import com.tencent.mm.plugin.appbrand.service.p.a;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.dqt;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public class WXBizEntryActivity
  extends AutoLoginActivity
{
  private c<com.tencent.mm.plugin.appbrand.service.d> nSM = null;
  private int nSN;
  private boolean nSO;
  private boolean nSP = false;
  
  private static void a(Bundle paramBundle, BaseResp paramBaseResp, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(22211);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramg.field_packageName;
    paramBaseResp.bundle = paramBundle;
    q.bc(paramBundle);
    q.bd(paramBundle);
    MMessageActV2.send(ak.getContext(), paramBaseResp);
    AppMethodBeat.o(22211);
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(22210);
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.m(getIntent().getStringExtra("key_app_id"), true, false);
    if (localg == null)
    {
      ae.e("MicroMsg.WXBizEntryActivity", "launchMiniProgramBackToApp info is null");
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
      ((WXLaunchMiniProgram.Resp)localResp).extMsg = bu.bI(paramString1, "{}");
    }
  }
  
  private static void eI(String paramString1, String paramString2)
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
    com.tencent.mm.pluginsdk.model.app.h.a(ak.getContext(), paramString1.field_appId, (WXMediaMessage)localObject, 2, null, null);
    AppMethodBeat.o(22212);
  }
  
  private void jc(final boolean paramBoolean)
  {
    AppMethodBeat.i(22213);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186405);
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
          AppMethodBeat.o(186405);
          return;
        }
      }
    });
    AppMethodBeat.o(22213);
  }
  
  public final void a(final AutoLoginActivity.a parama, final Intent paramIntent)
  {
    AppMethodBeat.i(22209);
    ae.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    if (getIntent() != null) {
      this.nSN = getIntent().getIntExtra("key_command_id", 0);
    }
    switch (WXBizEntryActivity.2.nSR[parama.ordinal()])
    {
    default: 
      ae.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
    }
    for (;;)
    {
      f.yX(3);
      finish();
      AppMethodBeat.o(22209);
      return;
      ae.i("MicroMsg.WXBizEntryActivity", "req type = %d", new Object[] { Integer.valueOf(this.nSN) });
      if ((f.bNb()) && (this.nSO))
      {
        ae.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry dealRequest isInConsumedSet finished");
        finish();
      }
      for (;;)
      {
        f.yX(4);
        AppMethodBeat.o(22209);
        return;
        Object localObject1;
        Object localObject2;
        final String str1;
        switch (this.nSN)
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
          com.tencent.mm.br.d.c(this, "card", ".ui.CardAddEntranceUI", getIntent());
          finish();
          break;
        case 16: 
          com.tencent.mm.br.d.c(this, "card", ".ui.CardListSelectedUI", getIntent());
          finish();
          break;
        case 7: 
        case 8: 
          parama = getIntent();
          parama.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
          parama = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
          com.tencent.mm.hellhoundlib.a.a.a(this, parama.ahE(), "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)parama.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          break;
        case 11: 
          parama = getIntent();
          parama.putExtra("device_type", 1);
          com.tencent.mm.br.d.c(this, "exdevice", ".ui.ExdeviceRankInfoUI", parama);
          finish();
          break;
        case 13: 
          parama = getIntent();
          parama.putExtra("key_static_from_scene", 100001);
          com.tencent.mm.br.d.c(this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parama);
          finish();
          break;
        case 14: 
        case 15: 
          new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new d.a()
          {
            public final void jb(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22189);
              if (paramAnonymousBoolean) {
                com.tencent.mm.br.d.c(WXBizEntryActivity.this, "game", ".ui.CreateOrJoinChatroomUI", WXBizEntryActivity.this.getIntent());
              }
              for (;;)
              {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.o(22189);
                return;
                ae.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
              }
            }
          }).bMY();
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
            ae.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", new Object[] { parama.getMessage() });
          }
          break;
        case 12: 
          try
          {
            parama = getIntent().getData();
            if ((parama != null) && (com.tencent.mm.pluginsdk.g.aMG(parama.toString())))
            {
              z.aBG().Bq("key_data_center_session_id");
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22197);
                  ae.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ac)))
                  {
                    paramAnonymousString = ((ac)paramAnonymousn).aLA();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bu.bI(paramAnonymousString.HXL, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
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
              ae.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        case 25: 
          try
          {
            parama = getIntent().getData();
            if ((parama != null) && (com.tencent.mm.pluginsdk.g.aMH(parama.toString())))
            {
              z.aBG().Bq("key_data_center_session_id");
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22199);
                  ae.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ac)))
                  {
                    paramAnonymousString = ((ac)paramAnonymousn).aLA();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bu.bI(paramAnonymousString.HXL, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
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
              ae.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
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
                paramIntent = com.tencent.mm.plugin.ext.b.ctB().agC(str1);
                if (paramIntent == null) {
                  com.tencent.mm.ui.base.h.a(this, bu.nullAsNil(getString(2131760671)), getString(2131755906), getString(2131755835), false, new DialogInterface.OnClickListener()
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
              ae.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
            localObject2 = paramIntent.field_username;
            paramIntent = (Intent)localObject2;
            if (((String)localObject2).endsWith("@app")) {
              paramIntent = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("@app"));
            }
            paramIntent = ((String)localObject1).replace(str1, paramIntent);
            ae.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogramWithToken, url with username=".concat(String.valueOf(paramIntent)));
            f.yX(5);
            parama = parama.getQueryParameter("invokeData");
            final long l = System.currentTimeMillis();
            com.tencent.mm.pluginsdk.g.a(this, paramIntent, getIntent().getIntExtra("translate_link_scene", 1), new g.a()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(22202);
                ae.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                WXBizEntryActivity.a(WXBizEntryActivity.this, paramAnonymousInt2, paramAnonymousn, (int)(System.currentTimeMillis() - l));
                if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ac)))
                {
                  f.yX(7);
                  paramAnonymousString = ((ac)paramAnonymousn).aLA();
                  if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                  {
                    com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bu.bI(paramAnonymousString.HXL, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(22201);
                        paramAnonymous2DialogInterface = WXBizEntryActivity.this;
                        String str1 = WXBizEntryActivity.7.this.nSW;
                        String str2 = paramAnonymousString.HXL;
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
                f.yX(6);
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
              ae.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch fake native miniprogram failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        case 30: 
          paramIntent = getIntent();
          ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).aYS();
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
                ae.i("MicroMsg.WXBizEntryActivity", "dealRequest COMMAND_LAUNCH_WX_WXA_REDIRECTING_PAGE, deepLink[%s] translateLinkScene[%d], appPackage[%s | %s], req.ticket[%s]", new Object[] { localObject2, Integer.valueOf(i), str1, str2, localObject1 });
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
              ae.printErrStackTrace("MicroMsg.WXBizEntryActivity", parama, "dealRequest COMMAND_LAUNCH_WX_WXA_REDIRECTING_PAGE", new Object[0]);
              finish();
            }
            localObject1 = paramIntent.invokeTicket;
          }
          localObject1 = new dqt();
          ((dqt)localObject1).link = ((Uri)localObject2).toString();
          ((dqt)localObject1).scene = 1;
          localObject2 = new du();
          ((du)localObject2).signature = str2;
          ((du)localObject2).pqK = str1;
          ((dqt)localObject1).HXJ.add(localObject2);
          localObject2 = new b.a();
          ((b.a)localObject2).hQF = ((com.tencent.mm.bw.a)localObject1);
          ((b.a)localObject2).hQG = new dqu();
          ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/translatelink";
          ((b.a)localObject2).funcId = 1200;
          f.yY(3);
          x.a(((b.a)localObject2).aDS(), new x.a()
          {
            public final int a(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
            {
              AppMethodBeat.i(186404);
              paramAnonymousb = (dqu)paramAnonymousb.hQE.hQJ;
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                ae.e("MicroMsg.WXBizEntryActivity", "doLaunchWxaRedirectingPage, with ticket[%s] hostAppId[%s], cgi failed, errType[%d] errCode[%d] errMsg[%s]", new Object[] { paramIntent.invokeTicket, parama, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                f.yY(5);
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(186402);
                    String str;
                    if (paramAnonymousb != null)
                    {
                      str = paramAnonymousb.HXL;
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
                          AppMethodBeat.i(186401);
                          f.a(WXBizEntryActivity.this, WXBizEntryActivity.9.this.nTa, WXBizEntryActivity.9.this.nTc, WXBizEntryActivity.9.1.this.val$errCode, WXBizEntryActivity.9.1.this.val$errMsg);
                          AppMethodBeat.o(186401);
                        }
                      });
                      AppMethodBeat.o(186402);
                      return;
                      str = null;
                      break;
                      str = WXBizEntryActivity.this.getString(2131761811);
                    }
                  }
                });
                AppMethodBeat.o(186404);
                return 0;
              }
              if ((paramAnonymousb.HXO == null) || (paramAnonymousb.HXO.zr.length <= 0))
              {
                f.yY(6);
                ae.e("MicroMsg.WXBizEntryActivity", "doLaunchWxaRedirectingPage, with ticket[%s] hostAppId[%s], get invalid wxa_runtime_buff from cgi", new Object[] { paramIntent.invokeTicket, parama });
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(186403);
                    Toast.makeText(ak.getContext(), 2131767050, 0).show();
                    AppMethodBeat.o(186403);
                  }
                });
                f.a(WXBizEntryActivity.this, paramIntent, str1, -1, "Invalid wxa_runtime_buff");
                AppMethodBeat.o(186404);
                return 0;
              }
              f.yY(4);
              paramAnonymousString = paramAnonymousb.HXK;
              paramAnonymousString = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).a(WXBizEntryActivity.this, paramIntent, ((du)this.nTd.HXJ.getFirst()).pqK, paramAnonymousString, paramAnonymousb.HXO.fjO());
              if (((Integer)paramAnonymousString.first).intValue() != 0) {
                f.a(WXBizEntryActivity.this, paramIntent, str1, ((Integer)paramAnonymousString.first).intValue(), (String)paramAnonymousString.second);
              }
              for (;;)
              {
                AppMethodBeat.o(186404);
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
                  ae.i("MicroMsg.WXBizEntryActivity", "offline pay, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ac)))
                  {
                    paramAnonymousString = ((ac)paramAnonymousn).aLA();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bu.bI(paramAnonymousString.HXL, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
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
              ae.e("MicroMsg.WXBizEntryActivity", "get data from intent for offline pay failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        }
      }
      ae.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
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
    jc(false);
    AppMethodBeat.o(22214);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22208);
    this.nSO = f.ae(getIntent());
    com.tencent.mm.kernel.g.ajP();
    if ((com.tencent.mm.kernel.a.aiY()) && (!com.tencent.mm.kernel.a.aiT())) {
      f.ad(getIntent());
    }
    setTheme(2131821150);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.WXBizEntryActivity", "onCreate");
    if (f.bNb())
    {
      boolean bool = getIntent().getBooleanExtra("__BIZ_ENTRY_FROM_RETRY", false);
      if (this.nSO)
      {
        if (bool) {}
        for (i = 32;; i = 33)
        {
          f.yX(i);
          ae.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry isInConsumedSet finished");
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
      f.yX(i);
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
    ae.i("MicroMsg.WXBizEntryActivity", "onNewIntent");
    this.nSP = false;
    if (this.nSM != null)
    {
      this.nSM.dead();
      this.nSM = null;
    }
    jc(true);
    AppMethodBeat.o(22215);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22217);
    super.onPause();
    ae.i("MicroMsg.WXBizEntryActivity", "onPause");
    AppMethodBeat.o(22217);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22216);
    super.onResume();
    ae.i("MicroMsg.WXBizEntryActivity", "onResume, mDoFinishOnNextResume[%b]", new Object[] { Boolean.valueOf(this.nSP) });
    if (this.nSP) {
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
    implements p.a, g.a
  {
    a() {}
    
    public final void a(int paramInt1, int paramInt2, final String paramString, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(22192);
      ae.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
      if ((paramn != null) && (((!paramBoolean) && (!bu.isNullOrNil(paramString))) || ((paramInt1 != 0) && (paramInt2 != 0) && ((paramn instanceof ac)))))
      {
        paramn = ((ac)paramn).aLA();
        if ((paramn != null) && (!WXBizEntryActivity.this.isFinishing()))
        {
          paramString = bu.bI(bu.bI(paramn.HXL, paramString), WXBizEntryActivity.this.getString(2131761811));
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
      if ((paramn instanceof ac))
      {
        paramString = ((ac)paramn).aLz();
        ae.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback transUri[%s]", new Object[] { paramString });
        if (!bu.nullAsNil(paramString).startsWith("weixin://dl/jumpFakeWxa/")) {
          WXBizEntryActivity.this.finish();
        }
        AppMethodBeat.o(22192);
        return;
      }
      ae.e("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, scene is not NetSceneTranslateLink, finish activity");
      WXBizEntryActivity.this.finish();
      AppMethodBeat.o(22192);
    }
    
    public final void bsv()
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
    
    public final void bsw()
    {
      AppMethodBeat.i(22194);
      WXBizEntryActivity.this.finish();
      AppMethodBeat.o(22194);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity
 * JD-Core Version:    0.7.0.1
 */