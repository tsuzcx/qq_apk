package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.cw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public class WXBizEntryActivity
  extends AutoLoginActivity
{
  private int hSc;
  
  private static void cn(String paramString1, String paramString2)
  {
    paramString1 = g.by(paramString1, true);
    if (paramString1 == null) {
      return;
    }
    Object localObject = new WXAppExtendObject();
    ((WXAppExtendObject)localObject).extInfo = paramString2;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).sdkVer = 620824064;
    ((WXMediaMessage)localObject).messageExt = paramString2;
    g.a(ae.getContext(), paramString1.field_appId, (WXMediaMessage)localObject, 2, null, null);
  }
  
  protected final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    String str1 = null;
    String str2 = null;
    paramIntent = null;
    y.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = " + parama);
    if (getIntent() != null) {
      this.hSc = getIntent().getIntExtra("key_command_id", 0);
    }
    switch (WXBizEntryActivity.7.hSj[parama.ordinal()])
    {
    default: 
      y.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = " + parama);
    }
    for (;;)
    {
      finish();
      for (;;)
      {
        return;
        y.i("MicroMsg.WXBizEntryActivity", "req type = %d", new Object[] { Integer.valueOf(this.hSc) });
        switch (this.hSc)
        {
        case 10: 
        case 18: 
        case 20: 
        case 21: 
        case 22: 
        case 23: 
        default: 
          finish();
          return;
        case 9: 
          com.tencent.mm.br.d.c(this, "card", ".ui.CardAddEntranceUI", getIntent());
          finish();
          return;
        case 16: 
          com.tencent.mm.br.d.c(this, "card", ".ui.CardListSelectedUI", getIntent());
          finish();
          return;
        case 7: 
        case 8: 
          parama = getIntent();
          parama.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
          startActivity(parama);
          finish();
          return;
        case 11: 
          parama = getIntent();
          parama.putExtra("device_type", 1);
          com.tencent.mm.br.d.c(this, "exdevice", ".ui.ExdeviceRankInfoUI", parama);
          finish();
          return;
        case 13: 
          parama = getIntent();
          parama.putExtra("key_static_from_scene", 100001);
          com.tencent.mm.br.d.c(this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parama);
          finish();
          return;
        case 14: 
        case 15: 
          new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new WXBizEntryActivity.1(this)).awa();
          return;
        case 17: 
          int i;
          try
          {
            paramIntent = getIntent().getData();
            parama = new WXBizEntryActivity.2(this);
            str1 = getIntent().getStringExtra("key_package_name");
            str2 = getIntent().getStringExtra("key_package_signature");
            i = getIntent().getIntExtra("translate_link_scene", 1);
            y.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", new Object[] { str1, str2 });
            if ((bk.bl(str1)) || (bk.bl(str2)))
            {
              y.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
              return;
            }
          }
          catch (Exception parama)
          {
            y.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", new Object[] { parama.getMessage() });
            return;
          }
          LinkedList localLinkedList = new LinkedList();
          cw localcw = new cw();
          y.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", new Object[] { str1 });
          localcw.iQe = str1;
          localcw.signature = str2;
          localLinkedList.add(localcw);
          paramIntent = new aa(paramIntent.toString(), i, localLinkedList);
          parama = new e.1(this, parama);
          au.Dk().a(1200, parama);
          au.Dk().a(paramIntent, 0);
          return;
        case 12: 
          try
          {
            parama = getIntent().getData();
            if ((parama != null) && (com.tencent.mm.pluginsdk.d.VA(parama.toString())))
            {
              u.Hc().ii("key_data_center_session_id");
              com.tencent.mm.pluginsdk.d.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new WXBizEntryActivity.3(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
              return;
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              y.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
              parama = paramIntent;
            }
          }
        case 25: 
          try
          {
            parama = getIntent().getData();
            if ((parama != null) && (com.tencent.mm.pluginsdk.d.VB(parama.toString())))
            {
              u.Hc().ii("key_data_center_session_id");
              com.tencent.mm.pluginsdk.d.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new WXBizEntryActivity.4(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
              return;
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              y.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
              parama = str1;
            }
          }
        case 19: 
          try
          {
            parama = getIntent().getData();
            if (parama != null)
            {
              com.tencent.mm.pluginsdk.d.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new WXBizEntryActivity.5(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
              return;
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              y.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", new Object[] { parama.getMessage() });
              parama = str2;
            }
          }
        case 24: 
          try
          {
            parama = getIntent().getData();
            if (parama != null)
            {
              com.tencent.mm.pluginsdk.d.a(this, parama.toString(), getIntent().getIntExtra("translate_link_scene", 1), new WXBizEntryActivity.6(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
              return;
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              y.e("MicroMsg.WXBizEntryActivity", "get data from intent for offline pay failed : %s", new Object[] { parama.getMessage() });
              parama = null;
            }
          }
        }
      }
      y.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = " + parama);
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.biz_share_check;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitleVisibility(0);
  }
  
  protected final boolean w(Intent paramIntent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity
 * JD-Core Version:    0.7.0.1
 */