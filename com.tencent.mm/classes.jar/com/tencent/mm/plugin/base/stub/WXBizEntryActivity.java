package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.a.az;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.aj.a.a.a;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.appbrand.service.t.a;
import com.tencent.mm.plugin.ext.SubCoreExt;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fqh;
import com.tencent.mm.protocal.protobuf.fqi;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import java.util.LinkedList;

public class WXBizEntryActivity
  extends AutoLoginActivity
{
  private boolean aBh;
  private IListener<d> vrq;
  private int vrr;
  private IListener<az> vrs;
  private boolean vrt;
  
  public WXBizEntryActivity()
  {
    AppMethodBeat.i(269024);
    this.vrq = null;
    this.vrs = new WXBizEntryActivity.10(this, com.tencent.mm.app.f.hfK);
    this.vrt = false;
    AppMethodBeat.o(269024);
  }
  
  private void GF(final int paramInt)
  {
    AppMethodBeat.i(269034);
    Object localObject1 = null;
    try
    {
      localObject2 = getIntent().getData();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        String str1;
        String str2;
        Bundle localBundle;
        Log.e("MicroMsg.WXBizEntryActivity", "get data from intent for finder task failed : %s", new Object[] { localException.getMessage() });
      }
    }
    localObject2 = getIntent().getStringExtra("key_finder_video_path");
    str1 = getIntent().getStringExtra("key_finder_share_video_jump_info_string");
    str2 = getIntent().getStringExtra("key_finder_share_video_jump_info_extra_data");
    localBundle = new Bundle();
    localBundle.putString("key_app_id", getIntent().getStringExtra("key_app_id"));
    localBundle.putString("key_finder_video_path", (String)localObject2);
    if (paramInt == 33)
    {
      localBundle.putString("key_finder_share_video_jump_info_string", str1);
      localBundle.putString("key_finder_share_video_jump_info_extra_data", str2);
    }
    if (localObject1 != null) {
      com.tencent.mm.pluginsdk.g.a(this, localObject1.toString(), getIntent().getIntExtra("translate_link_scene", 1), localBundle, new g.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(269020);
          Log.i("MicroMsg.WXBizEntryActivity", "handleFinderTask, type = %d, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousp instanceof com.tencent.mm.modelsimple.ad)))
          {
            f.GG(7);
            paramAnonymousString = ((com.tencent.mm.modelsimple.ad)paramAnonymousp).bMA();
            if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
            {
              k.a(WXBizEntryActivity.this, Util.nullAs(paramAnonymousString.abQg, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed)), WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(268996);
                  WXBizEntryActivity.a(WXBizEntryActivity.this, WXBizEntryActivity.12.this.val$type);
                  WXBizEntryActivity.this.finish();
                  AppMethodBeat.o(268996);
                }
              });
              AppMethodBeat.o(269020);
              return;
            }
            WXBizEntryActivity.this.finish();
            AppMethodBeat.o(269020);
            return;
          }
          WXBizEntryActivity.this.finish();
          AppMethodBeat.o(269020);
        }
      }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
    }
    AppMethodBeat.o(269034);
  }
  
  private static void a(Bundle paramBundle, BaseResp paramBaseResp, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(22211);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramg.field_packageName;
    paramBaseResp.bundle = paramBundle;
    u.bS(paramBundle);
    u.bT(paramBundle);
    MMessageActV2.send(MMApplicationContext.getContext(), paramBaseResp);
    AppMethodBeat.o(22211);
  }
  
  private void c(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(22210);
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.s(getIntent().getStringExtra("key_app_id"), true, false);
    if (localg == null)
    {
      Log.e("MicroMsg.WXBizEntryActivity", "launchMiniProgramBackToApp info is null");
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
      ((WXLaunchMiniProgram.Resp)localResp).extMsg = Util.nullAs(paramString1, "{}");
    }
  }
  
  private static void fE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22212);
    paramString1 = com.tencent.mm.pluginsdk.model.app.h.s(paramString1, true, false);
    if (paramString1 == null)
    {
      AppMethodBeat.o(22212);
      return;
    }
    Object localObject = new WXAppExtendObject();
    ((WXAppExtendObject)localObject).extInfo = paramString2;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).sdkVer = 638058496;
    ((WXMediaMessage)localObject).messageExt = paramString2;
    com.tencent.mm.pluginsdk.model.app.h.a(MMApplicationContext.getContext(), paramString1.field_appId, (WXMediaMessage)localObject, 2, null, null);
    AppMethodBeat.o(22212);
  }
  
  private void mD(boolean paramBoolean)
  {
    AppMethodBeat.i(22213);
    runOnUiThread(new WXBizEntryActivity.3(this, paramBoolean));
    AppMethodBeat.o(22213);
  }
  
  public final void a(final AutoLoginActivity.a parama, final Intent paramIntent)
  {
    AppMethodBeat.i(22209);
    Log.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    if (getIntent() != null) {
      this.vrr = getIntent().getIntExtra("key_command_id", 0);
    }
    switch (WXBizEntryActivity.4.vrD[parama.ordinal()])
    {
    default: 
      Log.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
    }
    for (;;)
    {
      f.GG(3);
      finish();
      AppMethodBeat.o(22209);
      return;
      Log.i("MicroMsg.WXBizEntryActivity", "req type = %d", new Object[] { Integer.valueOf(this.vrr) });
      if ((f.daa()) && (this.aBh))
      {
        Log.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry dealRequest isInConsumedSet finished");
        finish();
      }
      for (;;)
      {
        f.GG(4);
        AppMethodBeat.o(22209);
        return;
        Object localObject1;
        Object localObject2;
        final String str1;
        switch (this.vrr)
        {
        case 10: 
        case 18: 
        case 20: 
        case 21: 
        case 22: 
        case 23: 
        case 27: 
        case 28: 
        case 31: 
        case 32: 
        case 39: 
        case 40: 
        default: 
          finish();
          break;
        case 9: 
          com.tencent.mm.br.c.c(this, "card", ".ui.CardAddEntranceUI", getIntent());
          finish();
          break;
        case 16: 
          com.tencent.mm.br.c.c(this, "card", ".ui.CardListSelectedUI", getIntent());
          finish();
          break;
        case 7: 
        case 8: 
          parama = getIntent();
          parama.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
          parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
          com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)parama.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          break;
        case 11: 
          parama = getIntent();
          parama.putExtra("device_type", 1);
          com.tencent.mm.br.c.c(this, "exdevice", ".ui.ExdeviceRankInfoUI", parama);
          finish();
          break;
        case 13: 
          parama = getIntent();
          parama.putExtra("key_static_from_scene", 100001);
          com.tencent.mm.br.c.c(this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parama);
          finish();
          break;
        case 14: 
        case 15: 
          new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new d.a()
          {
            public final void mC(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22189);
              if (paramAnonymousBoolean) {
                com.tencent.mm.br.c.c(WXBizEntryActivity.this, "game", ".ui.CreateOrJoinChatroomUI", WXBizEntryActivity.this.getIntent());
              }
              for (;;)
              {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.o(22189);
                return;
                Log.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
              }
            }
          }).cZW();
          break;
        case 17: 
          try
          {
            parama = getIntent().getData();
            paramIntent = new WXBizEntryActivity.5(this);
            localObject1 = getIntent().getStringExtra("key_package_name");
            localObject2 = getIntent().getStringExtra("key_package_signature");
            f.a(this, parama, getIntent().getIntExtra("translate_link_scene", 1), (String)localObject1, (String)localObject2, paramIntent);
          }
          catch (Exception parama)
          {
            Log.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", new Object[] { parama.getMessage() });
          }
          break;
        case 12: 
          try
          {
            parama = getIntent().getData();
            if ((parama != null) && (com.tencent.mm.pluginsdk.g.boU(parama.toString())))
            {
              com.tencent.mm.model.ad.bCb().Jn("key_data_center_session_id");
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22197);
                  Log.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousp != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousp instanceof com.tencent.mm.modelsimple.ad)))
                  {
                    paramAnonymousString = ((com.tencent.mm.modelsimple.ad)paramAnonymousp).bMA();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      k.a(WXBizEntryActivity.this, Util.nullAs(paramAnonymousString.abQg, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed)), WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
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
              Log.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        case 25: 
          try
          {
            parama = getIntent().getData();
            if ((parama != null) && (com.tencent.mm.pluginsdk.g.boW(parama.toString())))
            {
              com.tencent.mm.model.ad.bCb().Jn("key_data_center_session_id");
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22199);
                  Log.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousp != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousp instanceof com.tencent.mm.modelsimple.ad)))
                  {
                    paramAnonymousString = ((com.tencent.mm.modelsimple.ad)paramAnonymousp).bMA();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      k.a(WXBizEntryActivity.this, Util.nullAs(paramAnonymousString.abQg, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed)), WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
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
              Log.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        case 33: 
          GF(33);
          break;
        case 34: 
          GF(34);
          break;
        case 35: 
          GF(35);
          break;
        case 36: 
          GF(36);
          break;
        case 41: 
          GF(41);
          break;
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
                paramIntent = SubCoreExt.dNU().atu(str1);
                if (paramIntent == null) {
                  k.a(this, Util.nullAsNil(getString(R.l.gMB)), getString(R.l.app_tip), getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
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
              Log.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
            localObject2 = paramIntent.field_username;
            paramIntent = (Intent)localObject2;
            if (((String)localObject2).endsWith("@app")) {
              paramIntent = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("@app"));
            }
            paramIntent = ((String)localObject1).replace(str1, paramIntent);
            Log.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogramWithToken, url with username=".concat(String.valueOf(paramIntent)));
            f.GG(5);
            parama = parama.getQueryParameter("invokeData");
            final long l = System.currentTimeMillis();
            com.tencent.mm.pluginsdk.g.a(this, paramIntent, getIntent().getIntExtra("translate_link_scene", 1), new g.a()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(22202);
                Log.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                WXBizEntryActivity.a(WXBizEntryActivity.this, paramAnonymousInt2, paramAnonymousp, (int)(System.currentTimeMillis() - l));
                if ((paramAnonymousp != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousp instanceof com.tencent.mm.modelsimple.ad)))
                {
                  f.GG(7);
                  paramAnonymousString = ((com.tencent.mm.modelsimple.ad)paramAnonymousp).bMA();
                  if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                  {
                    k.a(WXBizEntryActivity.this, Util.nullAs(paramAnonymousString.abQg, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed)), WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(22201);
                        paramAnonymous2DialogInterface = WXBizEntryActivity.this;
                        String str1 = WXBizEntryActivity.9.this.vrI;
                        String str2 = paramAnonymousString.abQg;
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
                f.GG(6);
                WXBizEntryActivity.this.finish();
                AppMethodBeat.o(22202);
              }
            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
          }
          break;
        case 26: 
          parama = null;
          try
          {
            paramIntent = getIntent().getData();
            parama = paramIntent;
          }
          catch (Exception paramIntent)
          {
            for (;;)
            {
              Log.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch fake native miniprogram failed : %s", new Object[] { paramIntent.getMessage() });
              continue;
              paramIntent = paramIntent.getString("key_open_business_view_ext_info", "");
            }
          }
          if (parama != null)
          {
            paramIntent = com.tencent.mm.model.ad.bCb().M("key_data_center_session_id", false);
            if (paramIntent == null)
            {
              paramIntent = "";
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new a(paramIntent), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
            }
          }
          break;
        case 30: 
          paramIntent = getIntent();
          ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).a(ab.tTV);
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
                  break label1499;
                }
                localObject1 = "null";
                Log.i("MicroMsg.WXBizEntryActivity", "dealRequest COMMAND_LAUNCH_WX_WXA_REDIRECTING_PAGE, deepLink[%s] translateLinkScene[%d], appPackage[%s | %s], req.ticket[%s], activity[%d]", new Object[] { localObject2, Integer.valueOf(i), str1, str2, localObject1, Integer.valueOf(hashCode()) });
                if ((localObject2 != null) && (i > 0) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (paramIntent != null)) {
                  break label1508;
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
              Log.printErrStackTrace("MicroMsg.WXBizEntryActivity", parama, "dealRequest COMMAND_LAUNCH_WX_WXA_REDIRECTING_PAGE", new Object[0]);
              finish();
            }
            localObject1 = paramIntent.invokeTicket;
          }
          localObject1 = new fqh();
          ((fqh)localObject1).link = ((Uri)localObject2).toString();
          ((fqh)localObject1).scene = 1;
          localObject2 = new ez();
          ((ez)localObject2).signature = str2;
          ((ez)localObject2).xlr = str1;
          ((fqh)localObject1).abQd.add(localObject2);
          localObject2 = new c.a();
          ((c.a)localObject2).otE = ((com.tencent.mm.bx.a)localObject1);
          ((c.a)localObject2).otF = new fqi();
          ((c.a)localObject2).uri = "/cgi-bin/mmbiz-bin/translatelink";
          ((c.a)localObject2).funcId = 1200;
          f.GI(3);
          z.a(((c.a)localObject2).bEF(), new z.a()
          {
            public final int callback(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
            {
              AppMethodBeat.i(269049);
              paramAnonymousc = (fqi)c.c.b(paramAnonymousc.otC);
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                Log.e("MicroMsg.WXBizEntryActivity", "doLaunchWxaRedirectingPage, with ticket[%s] hostAppId[%s], cgi failed, errType[%d] errCode[%d] errMsg[%s]", new Object[] { paramIntent.invokeTicket, parama, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                f.GI(5);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(269023);
                    String str;
                    if (paramAnonymousc != null)
                    {
                      str = paramAnonymousc.abQg;
                      if (!TextUtils.isEmpty(str)) {
                        break label117;
                      }
                      if (TextUtils.isEmpty(paramAnonymousString)) {
                        break label100;
                      }
                      str = paramAnonymousString;
                    }
                    label100:
                    label117:
                    for (;;)
                    {
                      k.a(WXBizEntryActivity.this, str, WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(268981);
                          f.a(WXBizEntryActivity.this, WXBizEntryActivity.2.this.vrw, WXBizEntryActivity.2.this.vry, WXBizEntryActivity.2.1.this.val$errCode, WXBizEntryActivity.2.1.this.val$errMsg);
                          AppMethodBeat.o(268981);
                        }
                      });
                      AppMethodBeat.o(269023);
                      return;
                      str = null;
                      break;
                      str = WXBizEntryActivity.this.getString(R.l.openapi_jump_failed);
                    }
                  }
                });
                AppMethodBeat.o(269049);
                return 0;
              }
              if ((paramAnonymousc.abQj == null) || (paramAnonymousc.abQj.Op.length <= 0))
              {
                f.GI(6);
                Log.e("MicroMsg.WXBizEntryActivity", "doLaunchWxaRedirectingPage, with ticket[%s] hostAppId[%s], get invalid wxa_runtime_buff from cgi", new Object[] { paramIntent.invokeTicket, parama });
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(269019);
                    Toast.makeText(MMApplicationContext.getContext(), R.l.wxa_redirecting_page_deep_link_return_invalid_runtime_buffer, 0).show();
                    AppMethodBeat.o(269019);
                  }
                });
                f.a(WXBizEntryActivity.this, paramIntent, str1, -1, "Invalid wxa_runtime_buff");
                AppMethodBeat.o(269049);
                return 0;
              }
              f.GI(4);
              paramAnonymousString = paramAnonymousc.abQf;
              paramAnonymousString = ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).a(WXBizEntryActivity.this, paramIntent, ((ez)this.vrz.abQd.getFirst()).xlr, paramAnonymousString, paramAnonymousc.abQj.ZV());
              if (((Integer)paramAnonymousString.first).intValue() != 0) {
                f.a(WXBizEntryActivity.this, paramIntent, str1, ((Integer)paramAnonymousString.first).intValue(), (String)paramAnonymousString.second);
              }
              for (;;)
              {
                AppMethodBeat.o(269049);
                return 0;
                a.a.b(paramIntent.invokeTicket, WXBizEntryActivity.this);
              }
            }
          }, true);
          break;
        case 24: 
          try
          {
            parama = getIntent().getData();
            if (parama != null) {
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22204);
                  Log.i("MicroMsg.WXBizEntryActivity", "offline pay, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousp != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousp instanceof com.tencent.mm.modelsimple.ad)))
                  {
                    paramAnonymousString = ((com.tencent.mm.modelsimple.ad)paramAnonymousp).bMA();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      k.a(WXBizEntryActivity.this, Util.nullAs(paramAnonymousString.abQg, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed)), WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
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
              Log.e("MicroMsg.WXBizEntryActivity", "get data from intent for offline pay failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        case 37: 
          try
          {
            parama = getIntent().getData();
            if (parama != null) {
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(269021);
                  Log.i("MicroMsg.WXBizEntryActivity", "handleOpenCustomerServiceChat, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousp instanceof com.tencent.mm.modelsimple.ad)))
                  {
                    f.GG(7);
                    paramAnonymousString = ((com.tencent.mm.modelsimple.ad)paramAnonymousp).bMA();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      paramAnonymousString = Util.nullAs(paramAnonymousString.abQg, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed));
                      k.a(WXBizEntryActivity.this, paramAnonymousString, WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          AppMethodBeat.i(269056);
                          WXBizEntryActivity.b(WXBizEntryActivity.this, paramAnonymousString);
                          WXBizEntryActivity.this.finish();
                          AppMethodBeat.o(269056);
                        }
                      });
                      AppMethodBeat.o(269021);
                      return;
                    }
                    WXBizEntryActivity.this.finish();
                    AppMethodBeat.o(269021);
                    return;
                  }
                  WXBizEntryActivity.this.finish();
                  AppMethodBeat.o(269021);
                }
              }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              Log.e("MicroMsg.WXBizEntryActivity", "get data from intent for finder task failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        case 38: 
          label1499:
          label1508:
          getIntent().getStringExtra("key_app_id");
          getIntent().getStringExtra("key_package_name");
          getIntent().getStringExtra("key_package_signature");
          parama = getIntent().getStringExtra("key_qr_code_pay_code_centent");
          paramIntent = getIntent().getStringExtra("key_qr_code_pay_extra_msg");
          this.vrs.alive();
          com.tencent.mm.pluginsdk.wallet.f.a(this, 1, parama, 71, paramIntent, null);
        }
      }
      Log.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
    }
  }
  
  public final boolean ad(Intent paramIntent)
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return R.i.geK;
  }
  
  public void hideAllManagedDialogs()
  {
    AppMethodBeat.i(22214);
    super.hideAllManagedDialogs();
    mD(false);
    AppMethodBeat.o(22214);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22208);
    this.aBh = f.ag(getIntent());
    com.tencent.mm.kernel.h.baC();
    if ((com.tencent.mm.kernel.b.aZM()) && (!com.tencent.mm.kernel.b.aZG())) {
      f.af(getIntent());
    }
    setTheme(R.m.MMTheme_NoWindowAnim);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.WXBizEntryActivity", "onCreate");
    if (f.daa())
    {
      boolean bool = getIntent().getBooleanExtra("__BIZ_ENTRY_FROM_RETRY", false);
      if (this.aBh)
      {
        if (bool) {}
        for (i = 32;; i = 33)
        {
          f.GG(i);
          Log.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry isInConsumedSet finished");
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
      f.GG(i);
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
  
  public void onDestroy()
  {
    AppMethodBeat.i(269129);
    Log.i("MicroMsg.WXBizEntryActivity", "onDestroy()");
    super.onDestroy();
    this.vrs.dead();
    if (this.vrq != null) {
      this.vrq.dead();
    }
    AppMethodBeat.o(269129);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(22215);
    super.onNewIntent(paramIntent);
    Log.i("MicroMsg.WXBizEntryActivity", "onNewIntent");
    this.vrt = false;
    if (this.vrq != null)
    {
      this.vrq.dead();
      this.vrq = null;
    }
    mD(true);
    AppMethodBeat.o(22215);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22217);
    super.onPause();
    Log.i("MicroMsg.WXBizEntryActivity", "onPause");
    AppMethodBeat.o(22217);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22216);
    super.onResume();
    Log.i("MicroMsg.WXBizEntryActivity", "onResume, mDoFinishOnNextResume[%b]", new Object[] { Boolean.valueOf(this.vrt) });
    if (this.vrt) {
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
    implements t.a, g.a
  {
    public final void a(int paramInt1, int paramInt2, final String paramString, p paramp, boolean paramBoolean)
    {
      AppMethodBeat.i(22192);
      Log.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
      if ((paramp != null) && (((!paramBoolean) && (!Util.isNullOrNil(paramString))) || ((paramInt1 != 0) && (paramInt2 != 0) && ((paramp instanceof com.tencent.mm.modelsimple.ad)))))
      {
        paramp = ((com.tencent.mm.modelsimple.ad)paramp).bMA();
        if ((paramp != null) && (!this.vru.isFinishing()))
        {
          paramString = Util.nullAs(Util.nullAs(paramp.abQg, paramString), this.vru.getString(R.l.openapi_jump_failed));
          k.a(this.vru, paramString, this.vru.getString(R.l.app_tip), this.vru.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(22190);
              WXBizEntryActivity.a(WXBizEntryActivity.a.this.vru, paramString);
              WXBizEntryActivity.a.this.vru.finish();
              AppMethodBeat.o(22190);
            }
          });
          AppMethodBeat.o(22192);
          return;
        }
        this.vru.finish();
        AppMethodBeat.o(22192);
        return;
      }
      if ("nativeOpenAdCanvas".equals(this.vru.getIntent().getStringExtra("key_business_type"))) {
        com.tencent.mm.plugin.sns.ad.i.a.gN(com.tencent.mm.plugin.sns.ad.i.a.lO(this.vru.getIntent().getStringExtra("key_app_id"), paramIntent), 2);
      }
      if ((paramp instanceof com.tencent.mm.modelsimple.ad))
      {
        paramString = ((com.tencent.mm.modelsimple.ad)paramp).bMz();
        Log.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback transUri[%s]", new Object[] { paramString });
        if (!Util.nullAsNil(paramString).startsWith("weixin://dl/jumpFakeWxa/")) {
          this.vru.finish();
        }
        AppMethodBeat.o(22192);
        return;
      }
      Log.e("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, scene is not NetSceneTranslateLink, finish activity");
      this.vru.finish();
      AppMethodBeat.o(22192);
    }
    
    public final void cAA()
    {
      AppMethodBeat.i(22194);
      this.vru.finish();
      AppMethodBeat.o(22194);
    }
    
    public final void cAz()
    {
      AppMethodBeat.i(22193);
      if (WXBizEntryActivity.d(this.vru) != null)
      {
        WXBizEntryActivity.d(this.vru).dead();
        WXBizEntryActivity.a(this.vru, null);
      }
      WXBizEntryActivity.a(this.vru, new WXBizEntryActivity.1DeepLinkCallback.2(this, com.tencent.mm.app.f.hfK));
      WXBizEntryActivity.d(this.vru).alive();
      WXBizEntryActivity.e(this.vru);
      AppMethodBeat.o(22193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity
 * JD-Core Version:    0.7.0.1
 */