package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ModSafeDeviceNameUI
  extends MMActivity
  implements f
{
  private String cqJ;
  private long createTime;
  private ProgressDialog eeN = null;
  private EditText gBr;
  private String gBs;
  private String gBt;
  private String gBu;
  
  public int getLayoutId()
  {
    return 2130970297;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69870);
    this.gBs = getIntent().getStringExtra("safe_device_name");
    this.gBu = getIntent().getStringExtra("safe_device_uid");
    this.cqJ = getIntent().getStringExtra("safe_device_type");
    setMMTitle(com.tencent.mm.cb.a.aq(this, 2131302847));
    setBackBtn(new ModSafeDeviceNameUI.1(this));
    addTextOptionMenu(0, getString(2131297063), new ModSafeDeviceNameUI.2(this));
    ModSafeDeviceNameUI.3 local3 = new ModSafeDeviceNameUI.3(this);
    this.gBr = ((EditText)findViewById(2131826327));
    MMEditText.c localc = new MMEditText.c(this.gBr, null, 32);
    localc.ACU = local3;
    this.gBr.addTextChangedListener(localc);
    if (!bo.isNullOrNil(this.gBs))
    {
      this.gBr.setText(this.gBs);
      AppMethodBeat.o(69870);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(69870);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69867);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(69867);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69869);
    com.tencent.mm.kernel.g.Rc().b(361, this);
    super.onPause();
    AppMethodBeat.o(69869);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69868);
    com.tencent.mm.kernel.g.Rc().a(361, this);
    super.onResume();
    AppMethodBeat.o(69868);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(69871);
    if ((this.eeN != null) && (this.eeN.isShowing()))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new d();
      paramString.field_devicetype = this.cqJ;
      paramString.field_name = this.gBt;
      paramString.field_uid = this.gBu;
      paramString.field_createtime = this.createTime;
      com.tencent.mm.plugin.account.security.a.g.ard().update(paramString, new String[0]);
      h.bO(this, com.tencent.mm.cb.a.aq(this, 2131302851));
      new ak().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(69866);
          ModSafeDeviceNameUI.this.finish();
          AppMethodBeat.o(69866);
        }
      }, 1000L);
      AppMethodBeat.o(69871);
      return;
    }
    if (com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(69871);
      return;
    }
    AppMethodBeat.o(69871);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI
 * JD-Core Version:    0.7.0.1
 */