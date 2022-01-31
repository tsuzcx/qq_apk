package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.account.security.a.a;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ModSafeDeviceNameUI
  extends MMActivity
  implements f
{
  private String bJp;
  private long createTime;
  private ProgressDialog dnm = null;
  private EditText fka;
  private String fkb;
  private String fkc;
  private String fkd;
  
  protected final int getLayoutId()
  {
    return a.b.mod_safe_device_name;
  }
  
  protected final void initView()
  {
    this.fkb = getIntent().getStringExtra("safe_device_name");
    this.fkd = getIntent().getStringExtra("safe_device_uid");
    this.bJp = getIntent().getStringExtra("safe_device_type");
    setMMTitle(com.tencent.mm.cb.a.ac(this, a.d.safe_device_edit_title));
    setBackBtn(new ModSafeDeviceNameUI.1(this));
    addTextOptionMenu(0, getString(a.d.app_save), new ModSafeDeviceNameUI.2(this));
    ModSafeDeviceNameUI.3 local3 = new ModSafeDeviceNameUI.3(this);
    this.fka = ((EditText)findViewById(a.a.mod_safe_device_name));
    MMEditText.c localc = new MMEditText.c(this.fka, null, 32);
    localc.wjn = local3;
    this.fka.addTextChangedListener(localc);
    if (!bk.bl(this.fkb))
    {
      this.fka.setText(this.fkb);
      return;
    }
    enableOptionMenu(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onPause()
  {
    com.tencent.mm.kernel.g.Dk().b(361, this);
    super.onPause();
  }
  
  protected void onResume()
  {
    com.tencent.mm.kernel.g.Dk().a(361, this);
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((this.dnm != null) && (this.dnm.isShowing()))
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new d();
      paramString.field_devicetype = this.bJp;
      paramString.field_name = this.fkc;
      paramString.field_uid = this.fkd;
      paramString.field_createtime = this.createTime;
      com.tencent.mm.plugin.account.security.a.g.XB().c(paramString, new String[0]);
      h.bC(this, com.tencent.mm.cb.a.ac(this, a.d.safe_device_mod_name_ok));
      new ah().postDelayed(new Runnable()
      {
        public final void run()
        {
          ModSafeDeviceNameUI.this.finish();
        }
      }, 1000L);
    }
    while (!com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI
 * JD-Core Version:    0.7.0.1
 */