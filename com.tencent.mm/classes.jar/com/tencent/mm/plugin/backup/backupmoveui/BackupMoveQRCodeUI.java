package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BackupMoveQRCodeUI
  extends MMWizardActivity
{
  private b.d jAq;
  private ImageView jCO;
  private TextView jCP;
  private TextView jCQ;
  private boolean jCR;
  
  public BackupMoveQRCodeUI()
  {
    AppMethodBeat.i(17348);
    this.jCR = false;
    this.jAq = new BackupMoveQRCodeUI.1(this);
    AppMethodBeat.o(17348);
  }
  
  private void aTP()
  {
    AppMethodBeat.i(17354);
    if (aw.QP())
    {
      h.a(this, 2131297275, 2131297274, 2131297298, 2131297220, false, new BackupMoveQRCodeUI.3(this), null, 2131689740);
      AppMethodBeat.o(17354);
      return;
    }
    ab.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
    com.tencent.mm.plugin.backup.d.b.aTr().aTs().stop();
    com.tencent.mm.plugin.backup.d.b.aTr().aTt().cancel(true);
    com.tencent.mm.plugin.backup.d.b.aTr().aSL().jyN = -100;
    Oi(1);
    AppMethodBeat.o(17354);
  }
  
  public int getLayoutId()
  {
    return 2130968801;
  }
  
  public void initView()
  {
    AppMethodBeat.i(17352);
    setMMTitle(2131297228);
    this.jCO = ((ImageView)findViewById(2131821619));
    this.jCP = ((TextView)findViewById(2131821620));
    this.jCQ = ((TextView)findViewById(2131821621));
    setBackBtn(new BackupMoveQRCodeUI.2(this));
    AppMethodBeat.o(17352);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17349);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(17349);
      return;
    }
    if (!aw.RG())
    {
      finish();
      AppMethodBeat.o(17349);
      return;
    }
    initView();
    com.tencent.mm.plugin.backup.g.b.clear();
    paramBundle = com.tencent.mm.plugin.backup.d.b.aTr().aTt();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.jBK);
    com.tencent.mm.plugin.backup.b.d.rg(21);
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.jBJ);
    com.tencent.mm.plugin.backup.d.b.aTr().aSM();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.jBZ);
    com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.d.b.aTr().aTs());
    com.tencent.mm.plugin.backup.g.b.rg(2);
    com.tencent.mm.plugin.backup.d.b.aTr().jyI = null;
    paramBundle.jBT = false;
    paramBundle.jBQ = new com.tencent.mm.plugin.backup.c.c(com.tencent.mm.plugin.backup.d.b.aTr(), 2, paramBundle.jzz);
    com.tencent.mm.plugin.backup.d.b.aTr().aTt().jBU = com.tencent.mm.plugin.backup.b.c.jyy;
    com.tencent.mm.plugin.backup.b.d.aSR();
    AppMethodBeat.o(17349);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(17353);
    if (paramInt == 4)
    {
      aTP();
      AppMethodBeat.o(17353);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(17353);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(17351);
    super.onResume();
    this.jAq.rf(com.tencent.mm.plugin.backup.d.b.aTr().aSL().jyN);
    AppMethodBeat.o(17351);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(17350);
    super.onStart();
    com.tencent.mm.plugin.backup.d.b.aTr().aTt().jAq = this.jAq;
    com.tencent.mm.plugin.backup.d.b.aTr().aTt().jCa.start();
    AppMethodBeat.o(17350);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(17355);
    ab.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
    if (com.tencent.mm.plugin.backup.d.b.aTr().aTt().jCa != null) {
      com.tencent.mm.plugin.backup.d.b.aTr().aTt().jCa.stop();
    }
    super.onStop();
    AppMethodBeat.o(17355);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI
 * JD-Core Version:    0.7.0.1
 */