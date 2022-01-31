package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class IPCallAcitivityUI
  extends MMActivity
{
  private FrameLayout nQT;
  private TextView nQU;
  private TextView nQV;
  private Button nQW;
  private CdnImageView nQX;
  private boolean nQY = false;
  private com.tencent.mm.plugin.ipcall.a.g.a nQZ;
  
  public void finish()
  {
    AppMethodBeat.i(21993);
    super.finish();
    overridePendingTransition(2131034130, 2131034222);
    if (this.nQY)
    {
      com.tencent.mm.plugin.ipcall.a.e.c.xK(1);
      AppMethodBeat.o(21993);
      return;
    }
    com.tencent.mm.plugin.ipcall.a.e.c.xK(0);
    AppMethodBeat.o(21993);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969932;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21992);
    this.nQT = ((FrameLayout)findViewById(2131825245));
    this.nQU = ((TextView)findViewById(2131825247));
    this.nQV = ((TextView)findViewById(2131825249));
    this.nQW = ((Button)findViewById(2131825251));
    this.nQX = ((CdnImageView)findViewById(2131825250));
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yAG, "");
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
      finish();
    }
    for (;;)
    {
      this.nQT.setOnClickListener(new IPCallAcitivityUI.1(this));
      this.nQW.setOnClickListener(new IPCallAcitivityUI.2(this));
      setBackBtn(new IPCallAcitivityUI.3(this));
      AppMethodBeat.o(21992);
      return;
      this.nQZ = com.tencent.mm.plugin.ipcall.a.g.a.QY(str);
      if (this.nQZ == null)
      {
        ab.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
        finish();
      }
      else
      {
        this.nQU.setText(this.nQZ.Title);
        this.nQV.setText(this.nQZ.Desc);
        this.nQW.setText(this.nQZ.nQa);
        this.nQX.setUrl(this.nQZ.ImgUrl);
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(21994);
    super.onBackPressed();
    AppMethodBeat.o(21994);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21989);
    super.onCreate(paramBundle);
    getWindow().addFlags(131072);
    getWindow().setFlags(1024, 1024);
    hideTitleView();
    initView();
    AppMethodBeat.o(21989);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21990);
    super.onDestroy();
    AppMethodBeat.o(21990);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI
 * JD-Core Version:    0.7.0.1
 */