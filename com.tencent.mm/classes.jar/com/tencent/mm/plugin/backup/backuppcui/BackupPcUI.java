package com.tencent.mm.plugin.backup.backuppcui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class BackupPcUI
  extends MMWizardActivity
{
  private static boolean gsE = false;
  private TextView jCU;
  private TextView jCV;
  private TextView jCW;
  private TextView jCX;
  private TextView jCY;
  private ImageView jCZ;
  public b.c jEO;
  
  public BackupPcUI()
  {
    AppMethodBeat.i(17617);
    this.jEO = new BackupPcUI.3(this);
    AppMethodBeat.o(17617);
  }
  
  private void aTQ()
  {
    AppMethodBeat.i(17625);
    int i = b.aTX().aSL().jyN;
    int j = b.aTX().aTY().jEa;
    ab.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    switch (i)
    {
    default: 
    case 15: 
    case -22: 
    case -21: 
    case -13: 
    case -5: 
    case -3: 
    case -2: 
    case -1: 
    case 1: 
    case 11: 
    case 21: 
    case 27: 
    case 24: 
      for (;;)
      {
        Oi(1);
        AppMethodBeat.o(17625);
        return;
        ab.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
        aUi();
        AppMethodBeat.o(17625);
        return;
        if ((1 == j) || (3 == j))
        {
          b.aTX().aTZ().cancel(false);
          b.aTX().aSL().jyN = -100;
        }
        else
        {
          if ((2 == j) || (4 == j))
          {
            b.aTX().aUa().c(false, false, -100);
            AppMethodBeat.o(17625);
            return;
          }
          b.aTX().aSL().jyN = -100;
          continue;
          ab.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
          aUi();
          AppMethodBeat.o(17625);
          return;
          b.aTX().aSL().jyN = 25;
        }
      }
    }
    com.tencent.mm.ui.base.h.a(this, 2131297321, 2131297320, 2131297371, 2131297220, false, new BackupPcUI.2(this), null, 2131689740);
    AppMethodBeat.o(17625);
  }
  
  private void aUi()
  {
    AppMethodBeat.i(17626);
    ab.i("MicroMsg.BackupPcUI", "exitBackupPc.");
    if ((1 == b.aTX().aTY().jEa) || (3 == b.aTX().aTY().jEa))
    {
      b.aTX().aUb().cancel();
      b.aTX().aUb().aTW();
      b.aTX().aTZ().cancel(true);
      b.aTX().aTs().stop();
      b.aTX().aSL().jyN = -100;
      Oi(1);
      AppMethodBeat.o(17626);
      return;
    }
    if ((2 == b.aTX().aTY().jEa) || (4 == b.aTX().aTY().jEa))
    {
      b.aTX().aUa().c(true, true, -100);
      b.aTX().aTs().stop();
    }
    AppMethodBeat.o(17626);
  }
  
  public int getLayoutId()
  {
    return 2130968802;
  }
  
  public void initView()
  {
    AppMethodBeat.i(17622);
    this.jCY = ((TextView)findViewById(2131821623));
    this.jCZ = ((ImageView)findViewById(2131821624));
    this.jCW = ((TextView)findViewById(2131821625));
    this.jCX = ((TextView)findViewById(2131821626));
    this.jCU = ((TextView)findViewById(2131821628));
    this.jCV = ((TextView)findViewById(2131821627));
    AppMethodBeat.o(17622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17618);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(17618);
      return;
    }
    ab.i("MicroMsg.BackupPcUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.gmO.BR();
    initView();
    if (b.aTX().aTY().jEh)
    {
      b.aTX().aTY().jEh = false;
      int i = g.aSX();
      if (i < 50)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(400L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.e(13736, new Object[] { Integer.valueOf(4), b.aTX().aTY().jEb, g.dx(this), Integer.valueOf(0), Integer.valueOf(b.aTX().aTY().jEg) });
        com.tencent.mm.ui.base.h.a(this, 2131297328, 2131297327, 2131297394, 0, false, new BackupPcUI.1(this, i), null, 2131689739);
      }
    }
    AppMethodBeat.o(17618);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(17623);
    ab.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", new Object[] { bo.dtY() });
    super.onDestroy();
    AppMethodBeat.o(17623);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(17624);
    if (paramInt == 4)
    {
      aTQ();
      AppMethodBeat.o(17624);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(17624);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(17620);
    super.onPause();
    ab.i("MicroMsg.BackupPcUI", "onPause.");
    Object localObject1 = b.aTX().aTZ();
    b.c localc = this.jEO;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).jEm)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).jEm.remove(localc);
      localObject1 = b.aTX().aUa();
      localc = this.jEO;
    }
    synchronized (((d)localObject1).jEm)
    {
      ((d)localObject1).jEm.remove(localc);
      AppMethodBeat.o(17620);
      return;
      localObject2 = finally;
      AppMethodBeat.o(17620);
      throw localObject2;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(17621);
    super.onResume();
    ab.i("MicroMsg.BackupPcUI", "onResume.");
    Object localObject1 = b.aTX().aTZ();
    b.c localc = this.jEO;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).jEm)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).jEm.add(localc);
      localObject1 = b.aTX().aUa();
      localc = this.jEO;
    }
    synchronized (((d)localObject1).jEm)
    {
      ((d)localObject1).jEm.add(localc);
      int i = b.aTX().aSL().jyN;
      this.jEO.rf(i);
      AppMethodBeat.o(17621);
      return;
      localObject2 = finally;
      AppMethodBeat.o(17621);
      throw localObject2;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(17619);
    super.onStart();
    ab.i("MicroMsg.BackupPcUI", "onStart.");
    gsE = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    AppMethodBeat.o(17619);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI
 * JD-Core Version:    0.7.0.1
 */