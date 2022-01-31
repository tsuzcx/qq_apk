package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.e.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class WXBizEntryActivity
  extends AutoLoginActivity
{
  private int jLH;
  
  private static void a(Bundle paramBundle, BaseResp paramBaseResp, f paramf)
  {
    AppMethodBeat.i(18150);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramf.field_packageName;
    paramBaseResp.bundle = paramBundle;
    com.tencent.mm.pluginsdk.model.app.p.aC(paramBundle);
    com.tencent.mm.pluginsdk.model.app.p.aD(paramBundle);
    MMessageActV2.send(ah.getContext(), paramBaseResp);
    AppMethodBeat.o(18150);
  }
  
  private static void dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18151);
    paramString1 = g.ca(paramString1, true);
    if (paramString1 == null)
    {
      AppMethodBeat.o(18151);
      return;
    }
    Object localObject = new WXAppExtendObject();
    ((WXAppExtendObject)localObject).extInfo = paramString2;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).sdkVer = 620954624;
    ((WXMediaMessage)localObject).messageExt = paramString2;
    g.a(ah.getContext(), paramString1.field_appId, (WXMediaMessage)localObject, 2, null, null);
    AppMethodBeat.o(18151);
  }
  
  public final boolean O(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, final Intent paramIntent)
  {
    String str1 = null;
    String str2 = null;
    LinkedList localLinkedList = null;
    paramIntent = null;
    AppMethodBeat.i(18149);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    if (getIntent() != null) {
      this.jLH = getIntent().getIntExtra("key_command_id", 0);
    }
    switch (8.jLR[parama.ordinal()])
    {
    default: 
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(18149);
      return;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WXBizEntryActivity", "req type = %d", new Object[] { Integer.valueOf(this.jLH) });
      switch (this.jLH)
      {
      case 10: 
      case 18: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      default: 
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(18149);
        return;
        d.c(this, "card", ".ui.CardAddEntranceUI", getIntent());
        finish();
        AppMethodBeat.o(18149);
        return;
        d.c(this, "card", ".ui.CardListSelectedUI", getIntent());
        finish();
        AppMethodBeat.o(18149);
        return;
        parama = getIntent();
        parama.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
        startActivity(parama);
        finish();
        AppMethodBeat.o(18149);
        return;
        parama = getIntent();
        parama.putExtra("device_type", 1);
        d.c(this, "exdevice", ".ui.ExdeviceRankInfoUI", parama);
        finish();
        AppMethodBeat.o(18149);
        return;
        parama = getIntent();
        parama.putExtra("key_static_from_scene", 100001);
        d.c(this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parama);
        finish();
        AppMethodBeat.o(18149);
        return;
        new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new WXBizEntryActivity.1(this)).aVE();
        AppMethodBeat.o(18149);
        return;
        int i;
        try
        {
          paramIntent = getIntent().getData();
          parama = new WXBizEntryActivity.2(this);
          str1 = getIntent().getStringExtra("key_package_name");
          str2 = getIntent().getStringExtra("key_package_signature");
          i = getIntent().getIntExtra("translate_link_scene", 1);
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", new Object[] { str1, str2 });
          if ((bo.isNullOrNil(str1)) || (bo.isNullOrNil(str2)))
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
            AppMethodBeat.o(18149);
            return;
          }
        }
        catch (Exception parama)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", new Object[] { parama.getMessage() });
          AppMethodBeat.o(18149);
          return;
        }
        localLinkedList = new LinkedList();
        df localdf = new df();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", new Object[] { str1 });
        localdf.kWn = str1;
        localdf.signature = str2;
        localLinkedList.add(localdf);
        paramIntent = new com.tencent.mm.modelsimple.ab(paramIntent.toString(), i, localLinkedList);
        parama = new e.1(this, parama);
        aw.Rc().a(1200, parama);
        aw.Rc().a(paramIntent, 0);
        AppMethodBeat.o(18149);
        return;
        try
        {
          parama = getIntent().getData();
          if ((parama == null) || (!e.akW(parama.toString()))) {
            continue;
          }
          v.aae().oP("key_data_center_session_id");
          e.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new WXBizEntryActivity.3(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
          AppMethodBeat.o(18149);
          return;
        }
        catch (Exception parama)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
            parama = paramIntent;
          }
        }
        try
        {
          parama = getIntent().getData();
          if ((parama == null) || (!e.akX(parama.toString()))) {
            continue;
          }
          v.aae().oP("key_data_center_session_id");
          e.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new WXBizEntryActivity.4(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
          AppMethodBeat.o(18149);
          return;
        }
        catch (Exception parama)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
            parama = str1;
          }
        }
        try
        {
          parama = getIntent().getData();
          if (parama == null) {
            continue;
          }
          paramIntent = parama.getQueryParameter("invokeData");
          e.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new e.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(18142);
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
              if ((paramAnonymousm != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousm instanceof com.tencent.mm.modelsimple.ab)))
              {
                paramAnonymousString = ((com.tencent.mm.modelsimple.ab)paramAnonymousm).ajY();
                if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing()))
                {
                  h.a(WXBizEntryActivity.this, bo.nullAsNil(paramAnonymousString.xVH), WXBizEntryActivity.this.getString(2131297087), WXBizEntryActivity.this.getString(2131297018), false, new WXBizEntryActivity.5.1(this, paramAnonymousString));
                  AppMethodBeat.o(18142);
                  return;
                }
                WXBizEntryActivity.this.finish();
                AppMethodBeat.o(18142);
                return;
              }
              WXBizEntryActivity.this.finish();
              AppMethodBeat.o(18142);
            }
          }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
          AppMethodBeat.o(18149);
          return;
        }
        catch (Exception parama)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", new Object[] { parama.getMessage() });
            parama = str2;
          }
        }
        try
        {
          parama = getIntent().getData();
          if (parama == null) {
            continue;
          }
          e.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new WXBizEntryActivity.6(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
          AppMethodBeat.o(18149);
          return;
        }
        catch (Exception parama)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch fake native miniprogram failed : %s", new Object[] { parama.getMessage() });
            parama = localLinkedList;
          }
        }
        try
        {
          parama = getIntent().getData();
          if (parama != null)
          {
            e.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new WXBizEntryActivity.7(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
            AppMethodBeat.o(18149);
            return;
          }
        }
        catch (Exception parama)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizEntryActivity", "get data from intent for offline pay failed : %s", new Object[] { parama.getMessage() });
            parama = null;
          }
        }
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
    }
  }
  
  public int getLayoutId()
  {
    return 2130968865;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18148);
    super.onCreate(paramBundle);
    setTitleVisibility(0);
    AppMethodBeat.o(18148);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity
 * JD-Core Version:    0.7.0.1
 */