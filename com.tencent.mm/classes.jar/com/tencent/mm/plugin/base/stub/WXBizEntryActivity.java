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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.by.c;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
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
import com.tencent.mm.plugin.appbrand.ai.a.a.a;
import com.tencent.mm.plugin.appbrand.service.r.a;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.protocal.protobuf.euu;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class WXBizEntryActivity
  extends AutoLoginActivity
{
  private IListener<com.tencent.mm.plugin.appbrand.service.d> sfC = null;
  private int sfD;
  private boolean sfE;
  private boolean sfF = false;
  
  private void Gg(final int paramInt)
  {
    AppMethodBeat.i(283862);
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
        Bundle localBundle;
        Log.e("MicroMsg.WXBizEntryActivity", "get data from intent for finder task failed : %s", new Object[] { localException.getMessage() });
      }
    }
    localObject2 = getIntent().getStringExtra("key_finder_video_path");
    localBundle = new Bundle();
    localBundle.putString("key_finder_video_path", (String)localObject2);
    if (localObject1 != null) {
      com.tencent.mm.pluginsdk.g.a(this, localObject1.toString(), getIntent().getIntExtra("translate_link_scene", 1), localBundle, new g.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(274289);
          Log.i("MicroMsg.WXBizEntryActivity", "handleFinderTask, type = %d, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousq instanceof ac)))
          {
            f.Gh(7);
            paramAnonymousString = ((ac)paramAnonymousq).boT();
            if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
            {
              com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, Util.nullAs(paramAnonymousString.Uwz, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed)), WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(242523);
                  WXBizEntryActivity.a(WXBizEntryActivity.this, WXBizEntryActivity.10.this.val$type);
                  WXBizEntryActivity.this.finish();
                  AppMethodBeat.o(242523);
                }
              });
              AppMethodBeat.o(274289);
              return;
            }
            WXBizEntryActivity.this.finish();
            AppMethodBeat.o(274289);
            return;
          }
          WXBizEntryActivity.this.finish();
          AppMethodBeat.o(274289);
        }
      }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
    }
    AppMethodBeat.o(283862);
  }
  
  private static void a(Bundle paramBundle, BaseResp paramBaseResp, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(22211);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramg.field_packageName;
    paramBaseResp.bundle = paramBundle;
    com.tencent.mm.pluginsdk.model.app.q.bm(paramBundle);
    com.tencent.mm.pluginsdk.model.app.q.bn(paramBundle);
    MMessageActV2.send(MMApplicationContext.getContext(), paramBaseResp);
    AppMethodBeat.o(22211);
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(22210);
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(getIntent().getStringExtra("key_app_id"), true, false);
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
  
  private static void fn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22212);
    paramString1 = com.tencent.mm.pluginsdk.model.app.h.o(paramString1, true, false);
    if (paramString1 == null)
    {
      AppMethodBeat.o(22212);
      return;
    }
    Object localObject = new WXAppExtendObject();
    ((WXAppExtendObject)localObject).extInfo = paramString2;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).sdkVer = 637992960;
    ((WXMediaMessage)localObject).messageExt = paramString2;
    com.tencent.mm.pluginsdk.model.app.h.a(MMApplicationContext.getContext(), paramString1.field_appId, (WXMediaMessage)localObject, 2, null, null);
    AppMethodBeat.o(22212);
  }
  
  private void ll(final boolean paramBoolean)
  {
    AppMethodBeat.i(22213);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(230389);
        View localView = WXBizEntryActivity.this.findViewById(R.h.dMz);
        if (localView != null) {
          if (!paramBoolean) {
            break label40;
          }
        }
        label40:
        for (int i = 0;; i = 8)
        {
          localView.setVisibility(i);
          AppMethodBeat.o(230389);
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
  
  public final void a(final AutoLoginActivity.a parama, final Intent paramIntent)
  {
    AppMethodBeat.i(22209);
    Log.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    if (getIntent() != null) {
      this.sfD = getIntent().getIntExtra("key_command_id", 0);
    }
    switch (3.sfH[parama.ordinal()])
    {
    default: 
      Log.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
    }
    for (;;)
    {
      f.Gh(3);
      finish();
      AppMethodBeat.o(22209);
      return;
      Log.i("MicroMsg.WXBizEntryActivity", "req type = %d", new Object[] { Integer.valueOf(this.sfD) });
      if ((f.cxm()) && (this.sfE))
      {
        Log.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry dealRequest isInConsumedSet finished");
        finish();
      }
      for (;;)
      {
        f.Gh(4);
        AppMethodBeat.o(22209);
        return;
        Object localObject1;
        Object localObject2;
        final String str1;
        switch (this.sfD)
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
        default: 
          finish();
          break;
        case 9: 
          c.c(this, "card", ".ui.CardAddEntranceUI", getIntent());
          finish();
          break;
        case 16: 
          c.c(this, "card", ".ui.CardListSelectedUI", getIntent());
          finish();
          break;
        case 7: 
        case 8: 
          parama = getIntent();
          parama.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
          parama = new com.tencent.mm.hellhoundlib.b.a().bm(parama);
          com.tencent.mm.hellhoundlib.a.a.b(this, parama.aFh(), "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)parama.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          break;
        case 11: 
          parama = getIntent();
          parama.putExtra("device_type", 1);
          c.c(this, "exdevice", ".ui.ExdeviceRankInfoUI", parama);
          finish();
          break;
        case 13: 
          parama = getIntent();
          parama.putExtra("key_static_from_scene", 100001);
          c.c(this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parama);
          finish();
          break;
        case 14: 
        case 15: 
          new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new d.a()
          {
            public final void lk(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22189);
              if (paramAnonymousBoolean) {
                c.c(WXBizEntryActivity.this, "game", ".ui.CreateOrJoinChatroomUI", WXBizEntryActivity.this.getIntent());
              }
              for (;;)
              {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.o(22189);
                return;
                Log.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
              }
            }
          }).cxi();
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
                WXBizEntryActivity.this.findViewById(R.h.dMz).setVisibility(8);
                AppMethodBeat.o(22195);
              }
            };
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
            if ((parama != null) && (com.tencent.mm.pluginsdk.g.bpa(parama.toString())))
            {
              ad.beh().Ro("key_data_center_session_id");
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22197);
                  Log.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousq != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousq instanceof ac)))
                  {
                    paramAnonymousString = ((ac)paramAnonymousq).boT();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, Util.nullAs(paramAnonymousString.Uwz, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed)), WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
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
            if ((parama != null) && (com.tencent.mm.pluginsdk.g.bpc(parama.toString())))
            {
              ad.beh().Ro("key_data_center_session_id");
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22199);
                  Log.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousq != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousq instanceof ac)))
                  {
                    paramAnonymousString = ((ac)paramAnonymousq).boT();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, Util.nullAs(paramAnonymousString.Uwz, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed)), WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
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
          Gg(33);
          break;
        case 34: 
          Gg(34);
          break;
        case 35: 
          Gg(35);
          break;
        case 36: 
          Gg(36);
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
                paramIntent = com.tencent.mm.plugin.ext.b.dhj().azn(str1);
                if (paramIntent == null) {
                  com.tencent.mm.ui.base.h.a(this, Util.nullAsNil(getString(R.l.eKI)), getString(R.l.app_tip), getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
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
            f.Gh(5);
            parama = parama.getQueryParameter("invokeData");
            final long l = System.currentTimeMillis();
            com.tencent.mm.pluginsdk.g.a(this, paramIntent, getIntent().getIntExtra("translate_link_scene", 1), new g.a()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(22202);
                Log.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                WXBizEntryActivity.a(WXBizEntryActivity.this, paramAnonymousInt2, paramAnonymousq, (int)(System.currentTimeMillis() - l));
                if ((paramAnonymousq != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousq instanceof ac)))
                {
                  f.Gh(7);
                  paramAnonymousString = ((ac)paramAnonymousq).boT();
                  if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                  {
                    com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, Util.nullAs(paramAnonymousString.Uwz, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed)), WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(22201);
                        paramAnonymous2DialogInterface = WXBizEntryActivity.this;
                        String str1 = WXBizEntryActivity.8.this.sfM;
                        String str2 = paramAnonymousString.Uwz;
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
                f.Gh(6);
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
            paramIntent = ad.beh().I("key_data_center_session_id", false);
            if (paramIntent == null)
            {
              paramIntent = "";
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new a(paramIntent), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
            }
          }
          break;
        case 30: 
          paramIntent = getIntent();
          ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).a(z.qPe);
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
                  break label1470;
                }
                localObject1 = "null";
                Log.i("MicroMsg.WXBizEntryActivity", "dealRequest COMMAND_LAUNCH_WX_WXA_REDIRECTING_PAGE, deepLink[%s] translateLinkScene[%d], appPackage[%s | %s], req.ticket[%s], activity[%d]", new Object[] { localObject2, Integer.valueOf(i), str1, str2, localObject1, Integer.valueOf(hashCode()) });
                if ((localObject2 != null) && (i > 0) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (paramIntent != null)) {
                  break label1479;
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
          localObject1 = new euu();
          ((euu)localObject1).link = ((Uri)localObject2).toString();
          ((euu)localObject1).scene = 1;
          localObject2 = new ef();
          ((ef)localObject2).signature = str2;
          ((ef)localObject2).ufq = str1;
          ((euu)localObject1).Uwx.add(localObject2);
          localObject2 = new com.tencent.mm.an.d.a();
          ((com.tencent.mm.an.d.a)localObject2).lBU = ((com.tencent.mm.cd.a)localObject1);
          ((com.tencent.mm.an.d.a)localObject2).lBV = new euv();
          ((com.tencent.mm.an.d.a)localObject2).uri = "/cgi-bin/mmbiz-bin/translatelink";
          ((com.tencent.mm.an.d.a)localObject2).funcId = 1200;
          f.Gj(3);
          aa.a(((com.tencent.mm.an.d.a)localObject2).bgN(), new aa.a()
          {
            public final int a(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.an.d paramAnonymousd, com.tencent.mm.an.q paramAnonymousq)
            {
              AppMethodBeat.i(272947);
              paramAnonymousd = (euv)d.c.b(paramAnonymousd.lBS);
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                Log.e("MicroMsg.WXBizEntryActivity", "doLaunchWxaRedirectingPage, with ticket[%s] hostAppId[%s], cgi failed, errType[%d] errCode[%d] errMsg[%s]", new Object[] { paramIntent.invokeTicket, parama, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                f.Gj(5);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(280522);
                    String str;
                    if (paramAnonymousd != null)
                    {
                      str = paramAnonymousd.Uwz;
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
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, str, WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(278761);
                          f.a(WXBizEntryActivity.this, WXBizEntryActivity.11.this.sfR, WXBizEntryActivity.11.this.sfT, WXBizEntryActivity.11.1.this.val$errCode, WXBizEntryActivity.11.1.this.val$errMsg);
                          AppMethodBeat.o(278761);
                        }
                      });
                      AppMethodBeat.o(280522);
                      return;
                      str = null;
                      break;
                      str = WXBizEntryActivity.this.getString(R.l.openapi_jump_failed);
                    }
                  }
                });
                AppMethodBeat.o(272947);
                return 0;
              }
              if ((paramAnonymousd.UwC == null) || (paramAnonymousd.UwC.UH.length <= 0))
              {
                f.Gj(6);
                Log.e("MicroMsg.WXBizEntryActivity", "doLaunchWxaRedirectingPage, with ticket[%s] hostAppId[%s], get invalid wxa_runtime_buff from cgi", new Object[] { paramIntent.invokeTicket, parama });
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(289265);
                    Toast.makeText(MMApplicationContext.getContext(), R.l.wxa_redirecting_page_deep_link_return_invalid_runtime_buffer, 0).show();
                    AppMethodBeat.o(289265);
                  }
                });
                f.a(WXBizEntryActivity.this, paramIntent, str1, -1, "Invalid wxa_runtime_buff");
                AppMethodBeat.o(272947);
                return 0;
              }
              f.Gj(4);
              paramAnonymousString = paramAnonymousd.Uwy;
              paramAnonymousString = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).a(WXBizEntryActivity.this, paramIntent, ((ef)this.sfU.Uwx.getFirst()).ufq, paramAnonymousString, paramAnonymousd.UwC.Ap());
              if (((Integer)paramAnonymousString.first).intValue() != 0) {
                f.a(WXBizEntryActivity.this, paramIntent, str1, ((Integer)paramAnonymousString.first).intValue(), (String)paramAnonymousString.second);
              }
              for (;;)
              {
                AppMethodBeat.o(272947);
                return 0;
                a.a.b(paramIntent.invokeTicket, WXBizEntryActivity.this);
              }
            }
          }, true);
          break;
        case 24: 
          try
          {
            label1470:
            label1479:
            parama = getIntent().getData();
            if (parama != null) {
              com.tencent.mm.pluginsdk.g.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(22204);
                  Log.i("MicroMsg.WXBizEntryActivity", "offline pay, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousq != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousq instanceof ac)))
                  {
                    paramAnonymousString = ((ac)paramAnonymousq).boT();
                    if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                    {
                      com.tencent.mm.ui.base.h.a(WXBizEntryActivity.this, Util.nullAs(paramAnonymousString.Uwz, WXBizEntryActivity.this.getString(R.l.openapi_jump_failed)), WXBizEntryActivity.this.getString(R.l.app_tip), WXBizEntryActivity.this.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
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
        }
      }
      Log.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
    }
  }
  
  public int getLayoutId()
  {
    return R.i.ecc;
  }
  
  public void hideAllManagedDialogs()
  {
    AppMethodBeat.i(22214);
    super.hideAllManagedDialogs();
    ll(false);
    AppMethodBeat.o(22214);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22208);
    this.sfE = f.ac(getIntent());
    com.tencent.mm.kernel.h.aHE();
    if ((com.tencent.mm.kernel.b.aGL()) && (!com.tencent.mm.kernel.b.aGE())) {
      f.ab(getIntent());
    }
    setTheme(R.m.MMTheme_NoWindowAnim);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.WXBizEntryActivity", "onCreate");
    if (f.cxm())
    {
      boolean bool = getIntent().getBooleanExtra("__BIZ_ENTRY_FROM_RETRY", false);
      if (this.sfE)
      {
        if (bool) {}
        for (i = 32;; i = 33)
        {
          f.Gh(i);
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
      f.Gh(i);
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
    Log.i("MicroMsg.WXBizEntryActivity", "onNewIntent");
    this.sfF = false;
    if (this.sfC != null)
    {
      this.sfC.dead();
      this.sfC = null;
    }
    ll(true);
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
    Log.i("MicroMsg.WXBizEntryActivity", "onResume, mDoFinishOnNextResume[%b]", new Object[] { Boolean.valueOf(this.sfF) });
    if (this.sfF) {
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
    implements r.a, g.a
  {
    public final void a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq, boolean paramBoolean)
    {
      AppMethodBeat.i(22192);
      Log.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
      if ((paramq != null) && (((!paramBoolean) && (!Util.isNullOrNil(paramString))) || ((paramInt1 != 0) && (paramInt2 != 0) && ((paramq instanceof ac)))))
      {
        paramq = ((ac)paramq).boT();
        if ((paramq != null) && (!this.sfG.isFinishing()))
        {
          paramString = Util.nullAs(Util.nullAs(paramq.Uwz, paramString), this.sfG.getString(R.l.openapi_jump_failed));
          com.tencent.mm.ui.base.h.a(this.sfG, paramString, this.sfG.getString(R.l.app_tip), this.sfG.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(22190);
              WXBizEntryActivity.a(WXBizEntryActivity.a.this.sfG, paramString);
              WXBizEntryActivity.a.this.sfG.finish();
              AppMethodBeat.o(22190);
            }
          });
          AppMethodBeat.o(22192);
          return;
        }
        this.sfG.finish();
        AppMethodBeat.o(22192);
        return;
      }
      if ("nativeOpenAdCanvas".equals(this.sfG.getIntent().getStringExtra("key_business_type"))) {
        com.tencent.mm.plugin.sns.ad.h.a.fU(com.tencent.mm.plugin.sns.ad.h.a.ko(this.sfG.getIntent().getStringExtra("key_app_id"), paramIntent), 2);
      }
      if ((paramq instanceof ac))
      {
        paramString = ((ac)paramq).boS();
        Log.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback transUri[%s]", new Object[] { paramString });
        if (!Util.nullAsNil(paramString).startsWith("weixin://dl/jumpFakeWxa/")) {
          this.sfG.finish();
        }
        AppMethodBeat.o(22192);
        return;
      }
      Log.e("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, scene is not NetSceneTranslateLink, finish activity");
      this.sfG.finish();
      AppMethodBeat.o(22192);
    }
    
    public final void cak()
    {
      AppMethodBeat.i(22193);
      if (WXBizEntryActivity.d(this.sfG) != null)
      {
        WXBizEntryActivity.d(this.sfG).dead();
        WXBizEntryActivity.a(this.sfG, null);
      }
      WXBizEntryActivity.a(this.sfG, new IListener() {});
      WXBizEntryActivity.d(this.sfG).alive();
      WXBizEntryActivity.e(this.sfG);
      AppMethodBeat.o(22193);
    }
    
    public final void cal()
    {
      AppMethodBeat.i(22194);
      this.sfG.finish();
      AppMethodBeat.o(22194);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity
 * JD-Core Version:    0.7.0.1
 */