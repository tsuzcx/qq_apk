package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI
  extends MMWizardActivity
  implements e.a
{
  private Button gtF;
  private ak handler;
  private Button jIG;
  private TextView jIH;
  private TextView jII;
  private int vA;
  
  public BakToPcUI()
  {
    AppMethodBeat.i(17972);
    this.vA = -1;
    this.handler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(17972);
  }
  
  private void aVp()
  {
    AppMethodBeat.i(17977);
    if (this.vA == 0)
    {
      this.gtF.setEnabled(true);
      this.jIG.setEnabled(true);
      AppMethodBeat.o(17977);
      return;
    }
    this.gtF.setEnabled(false);
    this.jIG.setEnabled(false);
    AppMethodBeat.o(17977);
  }
  
  public final void aVh()
  {
    AppMethodBeat.i(17976);
    this.vA = 0;
    this.gtF.setVisibility(0);
    this.jIG.setVisibility(0);
    new ak(Looper.getMainLooper()).post(new BakToPcUI.4(this));
    AppMethodBeat.o(17976);
  }
  
  public int getLayoutId()
  {
    return 2130968811;
  }
  
  public void initView()
  {
    AppMethodBeat.i(17974);
    setMMTitle(2131297432);
    setBackBtn(new BakToPcUI.1(this));
    this.gtF = ((Button)findViewById(2131821658));
    this.gtF.setOnClickListener(new BakToPcUI.2(this));
    this.jIG = ((Button)findViewById(2131821659));
    this.jIG.setOnClickListener(new BakToPcUI.3(this));
    this.jIH = ((TextView)findViewById(2131821656));
    this.jIH.setText(a.aUU().aUV().jHI);
    this.jII = ((TextView)findViewById(2131821657));
    this.jII.setText(a.aUU().aUV().jHJ);
    AppMethodBeat.o(17974);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17973);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(17973);
      return;
    }
    initView();
    this.vA = a.aUU().aUV().jHH;
    ab.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.vA) });
    a.aUU().aUV().jHB = this;
    aVp();
    AppMethodBeat.o(17973);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(17975);
    super.onDestroy();
    ab.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.vA) });
    a.aUU().aUV().jHB = null;
    AppMethodBeat.o(17975);
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(17978);
    this.handler.post(new BakToPcUI.5(this, paramInt));
    AppMethodBeat.o(17978);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(17979);
    if (paramInt == 4)
    {
      a.aUU().aUW().fme = 3;
      a.aUU().aUW().abd();
      a.aUU().aUV().rB(1);
      Oi(1);
      AppMethodBeat.o(17979);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(17979);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI
 * JD-Core Version:    0.7.0.1
 */