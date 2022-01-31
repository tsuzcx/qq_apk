package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class BackupPcUI
  extends MMWizardActivity
{
  private static boolean faM = false;
  private TextView hJs;
  private TextView hJt;
  private TextView hJu;
  private TextView hJv;
  private TextView hJw;
  private ImageView hJx;
  public b.c hLl = new BackupPcUI.3(this);
  
  private void auI()
  {
    y.i("MicroMsg.BackupPcUI", "exitBackupPc.");
    if ((1 == b.auw().aux().hKx) || (3 == b.auw().aux().hKx))
    {
      b.auw().auA().cancel();
      b.auw().auA().auv();
      b.auw().auy().cancel(true);
      b.auw().atT().stop();
      b.auw().atn().hFu = -100;
      FW(1);
    }
    while ((2 != b.auw().aux().hKx) && (4 != b.auw().aux().hKx)) {
      return;
    }
    b.auw().auz().a(true, true, -100);
    b.auw().atT().stop();
  }
  
  private void aur()
  {
    int i = b.auw().atn().hFu;
    int j = b.auw().aux().hKx;
    y.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
        FW(1);
        return;
        y.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
        auI();
        return;
        if ((1 == j) || (3 == j))
        {
          b.auw().auy().cancel(false);
          b.auw().atn().hFu = -100;
        }
        else
        {
          if ((2 == j) || (4 == j))
          {
            b.auw().auz().a(false, false, -100);
            return;
          }
          b.auw().atn().hFu = -100;
          continue;
          y.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
          auI();
          return;
          b.auw().atn().hFu = 25;
        }
      }
    }
    com.tencent.mm.ui.base.h.a(this, R.l.backup_pc_error_alert_stop_recover_tip, R.l.backup_pc_error_alert_stop_recover, R.l.backup_pc_stop_recover, R.l.backup_cancel, false, new BackupPcUI.2(this), null, R.e.backup_red);
  }
  
  protected final int getLayoutId()
  {
    return R.i.backup_pc;
  }
  
  public final void initView()
  {
    this.hJw = ((TextView)findViewById(R.h.backup_close_btn));
    this.hJx = ((ImageView)findViewById(R.h.backup_image));
    this.hJu = ((TextView)findViewById(R.h.backup_status_title));
    this.hJv = ((TextView)findViewById(R.h.backup_status_content));
    this.hJs = ((TextView)findViewById(R.h.backup_btn));
    this.hJt = ((TextView)findViewById(R.h.backup_bottom_btn));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {}
    int i;
    do
    {
      do
      {
        return;
        y.i("MicroMsg.BackupPcUI", "onCreate.");
        getSupportActionBar().hide();
        com.tencent.mm.plugin.backup.a.eUR.tn();
        initView();
      } while (!b.auw().aux().hKE);
      b.auw().aux().hKE = false;
      i = g.atz();
    } while (i >= 50);
    com.tencent.mm.plugin.report.service.h.nFQ.a(400L, 4L, 1L, false);
    com.tencent.mm.plugin.report.service.h.nFQ.f(13736, new Object[] { Integer.valueOf(4), b.auw().aux().hKy, g.cM(this), Integer.valueOf(0), Integer.valueOf(b.auw().aux().hKD) });
    com.tencent.mm.ui.base.h.a(this, R.l.backup_pc_error_low_battery_tip, R.l.backup_pc_error_low_battery, R.l.backup_sure, 0, false, new BackupPcUI.1(this, i), null, R.e.backup_green);
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", new Object[] { bk.csb() });
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      aur();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    y.i("MicroMsg.BackupPcUI", "onPause.");
    Object localObject1 = b.auw().auy();
    b.c localc = this.hLl;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).hKJ)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).hKJ.remove(localc);
      localObject1 = b.auw().auz();
      localc = this.hLl;
    }
    synchronized (((d)localObject1).hKJ)
    {
      ((d)localObject1).hKJ.remove(localc);
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    y.i("MicroMsg.BackupPcUI", "onResume.");
    Object localObject1 = b.auw().auy();
    b.c localc = this.hLl;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).hKJ)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).hKJ.add(localc);
      localObject1 = b.auw().auz();
      localc = this.hLl;
    }
    synchronized (((d)localObject1).hKJ)
    {
      ((d)localObject1).hKJ.add(localc);
      int i = b.auw().atn().hFu;
      this.hLl.nt(i);
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    y.i("MicroMsg.BackupPcUI", "onStart.");
    faM = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI
 * JD-Core Version:    0.7.0.1
 */