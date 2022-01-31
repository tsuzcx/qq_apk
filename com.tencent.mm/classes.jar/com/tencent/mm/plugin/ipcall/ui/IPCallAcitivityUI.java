package com.tencent.mm.plugin.ipcall.ui;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(3)
public class IPCallAcitivityUI
  extends MMActivity
{
  private FrameLayout ltA;
  private TextView ltB;
  private TextView ltC;
  private Button ltD;
  private CdnImageView ltE;
  private boolean ltF = false;
  private com.tencent.mm.plugin.ipcall.a.g.a ltG;
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.a.anim_not_change, R.a.pop_out);
    if (this.ltF)
    {
      com.tencent.mm.plugin.ipcall.a.e.c.sJ(1);
      return;
    }
    com.tencent.mm.plugin.ipcall.a.e.c.sJ(0);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ipcall_activity_ui;
  }
  
  protected final void initView()
  {
    this.ltA = ((FrameLayout)findViewById(R.h.ipcall_activity_close_btn));
    this.ltB = ((TextView)findViewById(R.h.ipcall_activity_title_tv));
    this.ltC = ((TextView)findViewById(R.h.ipcall_activity_desc_tv));
    this.ltD = ((Button)findViewById(R.h.ipcall_activity_enter_btn));
    this.ltE = ((CdnImageView)findViewById(R.h.ipcall_activity_iv));
    au.Hx();
    String str = (String)com.tencent.mm.model.c.Dz().get(ac.a.uqG, "");
    if (bk.bl(str))
    {
      y.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
      finish();
    }
    for (;;)
    {
      this.ltA.setOnClickListener(new IPCallAcitivityUI.1(this));
      this.ltD.setOnClickListener(new IPCallAcitivityUI.2(this));
      setBackBtn(new IPCallAcitivityUI.3(this));
      return;
      this.ltG = com.tencent.mm.plugin.ipcall.a.g.a.Fy(str);
      if (this.ltG == null)
      {
        y.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
        finish();
      }
      else
      {
        this.ltB.setText(this.ltG.bGw);
        this.ltC.setText(this.ltG.kRN);
        this.ltD.setText(this.ltG.lsG);
        this.ltE.setUrl(this.ltG.lsF);
      }
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(131072);
    getWindow().setFlags(1024, 1024);
    this.mController.hideTitleView();
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI
 * JD-Core Version:    0.7.0.1
 */