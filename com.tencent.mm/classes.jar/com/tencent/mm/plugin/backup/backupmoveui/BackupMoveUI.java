package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveUI
  extends MMWizardActivity
{
  public TextView kCQ;
  private b.d rMv;
  public TextView rPe;
  public TextView rPf;
  public TextView rPg;
  public TextView rPh;
  public ImageView rPi;
  
  public BackupMoveUI()
  {
    AppMethodBeat.i(21470);
    this.rMv = new b.d()
    {
      public final void EB(int paramAnonymousInt)
      {
        AppMethodBeat.i(21466);
        Object localObject = com.tencent.mm.plugin.backup.d.b.csI().crZ();
        Log.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKT), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKU) });
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.a(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.finish();
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.rPi.setImageResource(R.g.backup_move);
          BackupMoveUI.this.rPg.setText(R.l.epx);
          BackupMoveUI.this.rPh.setText(R.l.eqc);
          BackupMoveUI.this.rPh.setVisibility(0);
          BackupMoveUI.this.rPe.setVisibility(4);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.rPi.setImageResource(R.g.backup_move);
          BackupMoveUI.this.rPg.setText(BackupMoveUI.this.getString(R.l.epr, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKT), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKU) }));
          BackupMoveUI.this.rPh.setText(R.l.eqc);
          BackupMoveUI.this.rPh.setTextColor(BackupMoveUI.this.getResources().getColor(R.e.dkg));
          BackupMoveUI.this.rPh.setVisibility(0);
          BackupMoveUI.this.rPe.setVisibility(4);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.rPi.setImageResource(R.g.backup_move);
          BackupMoveUI.this.rPg.setText(R.l.eqi);
          BackupMoveUI.this.rPh.setText(R.l.eqc);
          BackupMoveUI.this.rPh.setTextColor(BackupMoveUI.this.getResources().getColor(R.e.dkg));
          BackupMoveUI.this.rPh.setVisibility(0);
          BackupMoveUI.this.rPe.setVisibility(4);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.rPi.setImageResource(R.g.backup_move);
          TextView localTextView = BackupMoveUI.this.rPg;
          BackupMoveUI localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = R.l.eqH;
          int i = ((com.tencent.mm.plugin.backup.b.e)localObject).rKT;
          int j = ((com.tencent.mm.plugin.backup.b.e)localObject).rKU;
          com.tencent.mm.plugin.backup.d.b.csI().csK();
          localTextView.setText(localBackupMoveUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), d.cta() }));
          BackupMoveUI.this.rPh.setText(R.l.eqc);
          BackupMoveUI.this.rPh.setTextColor(BackupMoveUI.this.getResources().getColor(R.e.dkg));
          BackupMoveUI.this.rPh.setVisibility(0);
          BackupMoveUI.this.rPe.setVisibility(4);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.rPi.setImageResource(R.g.backup_move_finish);
          BackupMoveUI.this.rPg.setText(R.l.backup_move_finish);
          BackupMoveUI.this.rPh.setText(BackupMoveUI.this.getString(R.l.epY, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKT), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKU) }));
          BackupMoveUI.this.rPh.setTextColor(BackupMoveUI.this.getResources().getColor(R.e.dkg));
          BackupMoveUI.this.rPe.setText(R.l.epp);
          BackupMoveUI.this.rPh.setVisibility(0);
          BackupMoveUI.this.rPe.setVisibility(0);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.this.rPe.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21465);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
              com.tencent.mm.plugin.backup.d.b.csI().csK().cancel(true);
              com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = -100;
              BackupMoveUI.c(BackupMoveUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21465);
            }
          });
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          localObject = com.tencent.mm.plugin.backup.d.b.csI().csK().bitmapData;
          BackupMoveUI.this.rPi.setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveUI.this.rPg.setText(R.l.eql);
          BackupMoveUI.this.rPg.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(R.e.normal_text_color));
          BackupMoveUI.this.rPh.setVisibility(4);
          BackupMoveUI.this.rPe.setVisibility(4);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.rPi.setImageResource(R.g.backup_move);
          localTextView = BackupMoveUI.this.rPg;
          localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = R.l.eqH;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).rKT;
          j = ((com.tencent.mm.plugin.backup.b.e)localObject).rKU;
          com.tencent.mm.plugin.backup.d.b.csI().csK();
          localTextView.setText(localBackupMoveUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), d.cta() }));
          BackupMoveUI.this.rPh.setText(R.l.eqI);
          BackupMoveUI.this.rPh.setTextColor(BackupMoveUI.this.getResources().getColor(R.e.dkg));
          BackupMoveUI.this.rPh.setVisibility(0);
          BackupMoveUI.this.rPe.setVisibility(4);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.rPi.setImageResource(R.k.backup_move_qrcode_dark);
          com.tencent.mm.plugin.backup.d.b.csI().csK().rOj.start();
          BackupMoveUI.this.rPg.setText(BackupMoveUI.this.getString(R.l.eqd, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKT), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKU), "0M" }));
          BackupMoveUI.this.rPh.setText(R.l.epO);
          BackupMoveUI.this.rPh.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(R.e.red));
          BackupMoveUI.this.rPh.setVisibility(0);
          BackupMoveUI.this.rPe.setVisibility(4);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.d(BackupMoveUI.this);
          com.tencent.mm.plugin.backup.d.b.csI().csK().rOd = c.rKE;
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.rPi.setImageResource(R.k.backup_move_qrcode_dark);
          BackupMoveUI.this.rPg.setText(BackupMoveUI.this.getString(R.l.eqd, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKT), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKU), "0M" }));
          BackupMoveUI.this.rPh.setText(R.l.epM);
          BackupMoveUI.this.rPh.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(R.e.red));
          BackupMoveUI.this.rPh.setVisibility(0);
          BackupMoveUI.this.rPe.setVisibility(4);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.rPi.setImageResource(R.k.backup_move_error);
          BackupMoveUI.this.rPg.setText(R.l.epW);
          BackupMoveUI.this.rPh.setVisibility(4);
          BackupMoveUI.this.rPe.setVisibility(4);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.rPi.setImageResource(R.k.backup_move_error);
          BackupMoveUI.this.rPg.setText(R.l.epI);
          BackupMoveUI.this.rPh.setVisibility(4);
          BackupMoveUI.this.rPe.setVisibility(4);
          BackupMoveUI.this.rPf.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
        }
      }
      
      public final void crY() {}
    };
    AppMethodBeat.o(21470);
  }
  
  private void ctg()
  {
    AppMethodBeat.i(21477);
    int i = com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS;
    Log.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      atX(1);
      AppMethodBeat.o(21477);
      return;
    case 15: 
      Log.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
      cth();
      AppMethodBeat.o(21477);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, R.l.eqk, R.l.eqj, R.l.eqF, R.l.epl, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21468);
        Log.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 25L, 1L, false);
        com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
        com.tencent.mm.plugin.backup.d.b.csI().csK().cancel(false);
        com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = -100;
        BackupMoveUI.f(BackupMoveUI.this);
        AppMethodBeat.o(21468);
      }
    }, null, R.e.dkf);
    AppMethodBeat.o(21477);
  }
  
  private void cth()
  {
    AppMethodBeat.i(21478);
    com.tencent.mm.plugin.backup.d.b.csI().csM().cancel();
    com.tencent.mm.plugin.backup.d.b.csI().csK().cancel(true);
    com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
    com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = -100;
    atX(1);
    AppMethodBeat.o(21478);
  }
  
  public int getLayoutId()
  {
    return R.i.ebQ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21472);
    this.kCQ = ((TextView)findViewById(R.h.dsE));
    this.rPi = ((ImageView)findViewById(R.h.dsF));
    this.rPg = ((TextView)findViewById(R.h.dsM));
    this.rPh = ((TextView)findViewById(R.h.dkg));
    this.rPe = ((TextView)findViewById(R.h.dsk));
    this.rPf = ((TextView)findViewById(R.h.dsj));
    AppMethodBeat.o(21472);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21471);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(21471);
      return;
    }
    Log.i("MicroMsg.BackupMoveUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.mIG.abF();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      com.tencent.mm.plugin.backup.d.b.csI().csK().rNw = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      Log.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.csI().csK().rNw) });
      AppMethodBeat.o(21471);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { Util.getStack() });
      AppMethodBeat.o(21471);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21476);
    if (paramInt == 4)
    {
      ctg();
      AppMethodBeat.o(21476);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21476);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(21474);
    super.onPause();
    com.tencent.mm.plugin.backup.d.b.csI().csK().b(this.rMv);
    if (com.tencent.mm.plugin.backup.d.b.csI().csK().rOj != null) {
      com.tencent.mm.plugin.backup.d.b.csI().csK().rOj.stop();
    }
    AppMethodBeat.o(21474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21473);
    super.onResume();
    com.tencent.mm.plugin.backup.d.b.csI().csK().a(this.rMv);
    this.rMv.EB(com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS);
    AppMethodBeat.o(21473);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI
 * JD-Core Version:    0.7.0.1
 */