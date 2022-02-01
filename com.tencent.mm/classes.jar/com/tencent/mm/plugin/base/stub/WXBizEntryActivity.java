package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Resp;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public class WXBizEntryActivity
  extends AutoLoginActivity
{
  private c<com.tencent.mm.plugin.appbrand.service.d> nmA = null;
  private int nmB;
  private boolean nmC;
  private boolean nmD = false;
  
  private static void a(Bundle paramBundle, BaseResp paramBaseResp, g paramg)
  {
    AppMethodBeat.i(22211);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramg.field_packageName;
    paramBaseResp.bundle = paramBundle;
    q.aW(paramBundle);
    q.aX(paramBundle);
    MMessageActV2.send(ai.getContext(), paramBaseResp);
    AppMethodBeat.o(22211);
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(22210);
    g localg = com.tencent.mm.pluginsdk.model.app.h.k(getIntent().getStringExtra("key_app_id"), true, false);
    if (localg == null)
    {
      ac.e("MicroMsg.WXBizEntryActivity", "launchMiniProgramBackToApp info is null");
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
      ((WXLaunchMiniProgram.Resp)localResp).extMsg = bs.bG(paramString1, "{}");
    }
  }
  
  private static void ew(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22212);
    paramString1 = com.tencent.mm.pluginsdk.model.app.h.k(paramString1, true, false);
    if (paramString1 == null)
    {
      AppMethodBeat.o(22212);
      return;
    }
    Object localObject = new WXAppExtendObject();
    ((WXAppExtendObject)localObject).extInfo = paramString2;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).sdkVer = 637927424;
    ((WXMediaMessage)localObject).messageExt = paramString2;
    com.tencent.mm.pluginsdk.model.app.h.a(ai.getContext(), paramString1.field_appId, (WXMediaMessage)localObject, 2, null, null);
    AppMethodBeat.o(22212);
  }
  
  private void iU(final boolean paramBoolean)
  {
    AppMethodBeat.i(22213);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22205);
        View localView = WXBizEntryActivity.this.findViewById(2131302340);
        if (localView != null) {
          if (!paramBoolean) {
            break label41;
          }
        }
        label41:
        for (int i = 0;; i = 8)
        {
          localView.setVisibility(i);
          AppMethodBeat.o(22205);
          return;
        }
      }
    });
    AppMethodBeat.o(22213);
  }
  
  public final boolean Z(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    String str1 = null;
    String str2 = null;
    paramIntent = null;
    AppMethodBeat.i(22209);
    ac.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    if (getIntent() != null) {
      this.nmB = getIntent().getIntExtra("key_command_id", 0);
    }
    switch (WXBizEntryActivity.9.nmN[parama.ordinal()])
    {
    default: 
      ac.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
    }
    for (;;)
    {
      f.yf(3);
      finish();
      AppMethodBeat.o(22209);
      return;
      ac.i("MicroMsg.WXBizEntryActivity", "req type = %d", new Object[] { Integer.valueOf(this.nmB) });
      if ((f.bHS()) && (this.nmC))
      {
        ac.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry dealRequest isInConsumedSet finished");
        finish();
      }
      for (;;)
      {
        f.yf(4);
        AppMethodBeat.o(22209);
        return;
        switch (this.nmB)
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
          parama = new com.tencent.mm.hellhoundlib.b.a().ba(parama);
          com.tencent.mm.hellhoundlib.a.a.a(this, parama.aeD(), "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)parama.lR(0));
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
            public final void iT(boolean paramAnonymousBoolean)
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
                ac.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
              }
            }
          }).bHP();
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
            str1 = getIntent().getStringExtra("key_package_name");
            str2 = getIntent().getStringExtra("key_package_signature");
            f.a(this, parama, getIntent().getIntExtra("translate_link_scene", 1), str1, str2, paramIntent);
          }
          catch (Exception parama)
          {
            ac.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", new Object[] { parama.getMessage() });
          }
          break;
        case 12: 
          try
          {
            parama = getIntent().getData();
            if ((parama != null) && (com.tencent.mm.pluginsdk.f.aFK(parama.toString())))
            {
              y.ayq().xI("key_data_center_session_id");
              com.tencent.mm.pluginsdk.f.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new f.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22197);
                  ac.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
                  {
                    paramAnonymousString = ((ab)paramAnonymousn).aHS();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bs.bG(paramAnonymousString.FTm, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
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
              ac.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
              parama = paramIntent;
            }
          }
        case 25: 
          try
          {
            parama = getIntent().getData();
            if ((parama != null) && (com.tencent.mm.pluginsdk.f.aFL(parama.toString())))
            {
              y.ayq().xI("key_data_center_session_id");
              com.tencent.mm.pluginsdk.f.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new f.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22199);
                  ac.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
                  {
                    paramAnonymousString = ((ab)paramAnonymousn).aHS();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bs.bG(paramAnonymousString.FTm, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
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
              ac.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
              parama = str1;
            }
          }
        case 19: 
        case 29: 
          try
          {
            parama = getIntent().getData();
            if (parama != null)
            {
              str1 = parama.toString();
              paramIntent = str1;
              if (getIntent().getBooleanExtra("key_launch_mini_program_is_used_token", false))
              {
                str3 = getIntent().getStringExtra("key_launch_mini_program_token");
                paramIntent = com.tencent.mm.plugin.ext.b.cmu().abR(str3);
                if (paramIntent == null) {
                  com.tencent.mm.ui.base.h.a(this, bs.nullAsNil(getString(2131760671)), getString(2131755906), getString(2131755835), false, new DialogInterface.OnClickListener()
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
            String str3;
            for (;;)
            {
              ac.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
            str2 = paramIntent.field_username;
            paramIntent = str2;
            if (str2.endsWith("@app")) {
              paramIntent = str2.substring(0, str2.lastIndexOf("@app"));
            }
            paramIntent = str1.replace(str3, paramIntent);
            ac.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogramWithToken, url with username=".concat(String.valueOf(paramIntent)));
            f.yf(5);
            parama = parama.getQueryParameter("invokeData");
            final long l = System.currentTimeMillis();
            com.tencent.mm.pluginsdk.f.a(this, paramIntent, getIntent().getIntExtra("translate_link_scene", 1), new f.a()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(22202);
                ac.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                WXBizEntryActivity.a(WXBizEntryActivity.this, paramAnonymousInt2, paramAnonymousn, (int)(System.currentTimeMillis() - l));
                if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
                {
                  f.yf(7);
                  paramAnonymousString = ((ab)paramAnonymousn).aHS();
                  if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                  {
                    com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bs.bG(paramAnonymousString.FTm, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(22201);
                        paramAnonymous2DialogInterface = WXBizEntryActivity.this;
                        String str1 = WXBizEntryActivity.6.this.nmJ;
                        String str2 = paramAnonymousString.FTm;
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
                f.yf(6);
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
              com.tencent.mm.pluginsdk.f.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new a(), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              ac.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch fake native miniprogram failed : %s", new Object[] { parama.getMessage() });
              parama = str2;
            }
          }
        case 24: 
          try
          {
            parama = getIntent().getData();
            if (parama != null) {
              com.tencent.mm.pluginsdk.f.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new f.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22204);
                  ac.i("MicroMsg.WXBizEntryActivity", "offline pay, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
                  {
                    paramAnonymousString = ((ab)paramAnonymousn).aHS();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, bs.bG(paramAnonymousString.FTm, WXBizEntryActivity.this.getString(2131761811)), WXBizEntryActivity.this.getString(2131755906), WXBizEntryActivity.this.getString(2131755835), false, new DialogInterface.OnClickListener()
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
              ac.e("MicroMsg.WXBizEntryActivity", "get data from intent for offline pay failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        }
      }
      ac.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
    }
  }
  
  public int getLayoutId()
  {
    return 2131493200;
  }
  
  public void hideAllManagedDialogs()
  {
    AppMethodBeat.i(22214);
    super.hideAllManagedDialogs();
    iU(false);
    AppMethodBeat.o(22214);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22208);
    this.nmC = f.ac(getIntent());
    f.ab(getIntent());
    setTheme(2131821150);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.WXBizEntryActivity", "onCreate");
    if (f.bHS())
    {
      boolean bool = getIntent().getBooleanExtra("__BIZ_ENTRY_FROM_RETRY", false);
      if (this.nmC)
      {
        if (bool) {}
        for (i = 32;; i = 33)
        {
          f.yf(i);
          ac.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry isInConsumedSet finished");
          finish();
          AppMethodBeat.o(22208);
          return;
        }
      }
      if (!bool) {
        break label128;
      }
    }
    label128:
    for (int i = 34;; i = 35)
    {
      f.yf(i);
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
    ac.i("MicroMsg.WXBizEntryActivity", "onNewIntent");
    this.nmD = false;
    if (this.nmA != null)
    {
      this.nmA.dead();
      this.nmA = null;
    }
    iU(true);
    AppMethodBeat.o(22215);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22217);
    super.onPause();
    ac.i("MicroMsg.WXBizEntryActivity", "onPause");
    AppMethodBeat.o(22217);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22216);
    super.onResume();
    ac.i("MicroMsg.WXBizEntryActivity", "onResume, mDoFinishOnNextResume[%b]", new Object[] { Boolean.valueOf(this.nmD) });
    if (this.nmD) {
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
    implements n.a, f.a
  {
    a() {}
    
    public final void a(int paramInt1, int paramInt2, final String paramString, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(22192);
      ac.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
      if ((paramn != null) && (((!paramBoolean) && (!bs.isNullOrNil(paramString))) || ((paramInt1 != 0) && (paramInt2 != 0) && ((paramn instanceof ab)))))
      {
        paramn = ((ab)paramn).aHS();
        if ((paramn != null) && (!WXBizEntryActivity.this.isFinishing()))
        {
          paramString = bs.bG(bs.bG(paramn.FTm, paramString), WXBizEntryActivity.this.getString(2131761811));
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
        paramString = ((ab)paramn).aHR();
        ac.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback transUri[%s]", new Object[] { paramString });
        if (!bs.nullAsNil(paramString).startsWith("weixin://dl/jumpFakeWxa/")) {
          WXBizEntryActivity.this.finish();
        }
        AppMethodBeat.o(22192);
        return;
      }
      ac.e("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, scene is not NetSceneTranslateLink, finish activity");
      WXBizEntryActivity.this.finish();
      AppMethodBeat.o(22192);
    }
    
    public final void bnS()
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
    
    public final void bnT()
    {
      AppMethodBeat.i(22194);
      WXBizEntryActivity.this.finish();
      AppMethodBeat.o(22194);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity
 * JD-Core Version:    0.7.0.1
 */