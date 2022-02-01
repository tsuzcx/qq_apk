package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;

public class BackupMoveQRCodeUI
  extends MMWizardActivity
{
  private b.d uXI;
  private ImageView van;
  private TextView vao;
  private TextView vap;
  private boolean vaq;
  
  public BackupMoveQRCodeUI()
  {
    AppMethodBeat.i(21406);
    this.vaq = false;
    this.uXI = new b.d()
    {
      public final void Fc(int paramAnonymousInt)
      {
        AppMethodBeat.i(21403);
        Log.i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this))
        {
          AppMethodBeat.o(21403);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21403);
          return;
          Log.i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
          com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = 12;
          Object localObject = new Intent(BackupMoveQRCodeUI.this, BackupMoveUI.class);
          MMWizardActivity.aQ(BackupMoveQRCodeUI.this, (Intent)localObject);
          AppMethodBeat.o(21403);
          return;
          localObject = com.tencent.mm.plugin.backup.d.b.cVs().cVu().bitmapData;
          BackupMoveQRCodeUI.b(BackupMoveQRCodeUI.this).setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setText(R.l.gtm);
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setTextColor(BackupMoveQRCodeUI.this.getContext().getResources().getColor(R.e.normal_text_color));
          BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this).setVisibility(4);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setText(R.l.gsN);
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setTextColor(BackupMoveQRCodeUI.this.getContext().getResources().getColor(R.e.red));
          BackupMoveQRCodeUI.b(BackupMoveQRCodeUI.this).setImageResource(R.k.backup_move_qrcode_light);
          BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this).setVisibility(4);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          k.a(BackupMoveQRCodeUI.this, R.l.gsW, 0, R.l.gsl, R.l.gsm, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21396);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.cVs().cVu().lZ(true);
              AppMethodBeat.o(21396);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21397);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click cancel.");
              BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
              AppMethodBeat.o(21397);
            }
          }, R.e.fkf);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          k.a(BackupMoveQRCodeUI.this, R.l.gsV, 0, R.l.gsk, R.l.gsm, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21398);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.cVs().cVu().lZ(true);
              AppMethodBeat.o(21398);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21399);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click cancel.");
              BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
              AppMethodBeat.o(21399);
            }
          }, R.e.fkf);
          AppMethodBeat.o(21403);
          return;
          k.a(BackupMoveQRCodeUI.this, R.l.gsY, 0, R.l.guZ, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21400);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
              AppMethodBeat.o(21400);
            }
          }, null, R.e.fkf);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          k.a(BackupMoveQRCodeUI.this, R.l.gsU, 0, R.l.gsl, R.l.gsm, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21401);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.cVs().cVu().lZ(true);
              AppMethodBeat.o(21401);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21402);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click cancel.");
              BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
              AppMethodBeat.o(21402);
            }
          }, R.e.fkf);
        }
      }
      
      public final void cUI() {}
    };
    AppMethodBeat.o(21406);
  }
  
  private void cVO()
  {
    AppMethodBeat.i(21412);
    if (bh.aZG())
    {
      k.a(this, R.l.gtl, R.l.gtk, R.l.gtG, R.l.gsm, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21405);
          Log.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
          com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
          com.tencent.mm.plugin.backup.d.b.cVs().cVu().cancel(true);
          com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = -100;
          BackupMoveQRCodeUI.g(BackupMoveQRCodeUI.this);
          AppMethodBeat.o(21405);
        }
      }, null, R.e.fkg);
      AppMethodBeat.o(21412);
      return;
    }
    Log.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
    com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
    com.tencent.mm.plugin.backup.d.b.cVs().cVu().cancel(true);
    com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = -100;
    aAp(1);
    AppMethodBeat.o(21412);
  }
  
  public int getLayoutId()
  {
    return R.i.gex;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21410);
    setMMTitle(R.l.backup_move);
    this.van = ((ImageView)findViewById(R.h.fsY));
    this.vao = ((TextView)findViewById(R.h.fta));
    this.vap = ((TextView)findViewById(R.h.fsZ));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21404);
        BackupMoveQRCodeUI.f(BackupMoveQRCodeUI.this);
        AppMethodBeat.o(21404);
        return true;
      }
    });
    AppMethodBeat.o(21410);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21407);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(21407);
      return;
    }
    if (!bh.baz())
    {
      finish();
      AppMethodBeat.o(21407);
      return;
    }
    initView();
    com.tencent.mm.plugin.backup.g.b.clear();
    paramBundle = com.tencent.mm.plugin.backup.d.b.cVs().cVu();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.uZe);
    com.tencent.mm.plugin.backup.b.d.Fd(21);
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.uZd);
    com.tencent.mm.plugin.backup.d.b.cVs().cUK();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.uZw);
    com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.d.b.cVs().cVt());
    com.tencent.mm.plugin.backup.g.b.Fd(2);
    com.tencent.mm.plugin.backup.d.b.cVs().uWb = null;
    paramBundle.uZq = false;
    paramBundle.uZn = new com.tencent.mm.plugin.backup.c.c(com.tencent.mm.plugin.backup.d.b.cVs(), 2, paramBundle.uWR);
    com.tencent.mm.plugin.backup.d.b.cVs().cVu().uZr = com.tencent.mm.plugin.backup.b.c.uVR;
    com.tencent.mm.plugin.backup.b.d.cUP();
    AppMethodBeat.o(21407);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21411);
    if (paramInt == 4)
    {
      cVO();
      AppMethodBeat.o(21411);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21411);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(300784);
    Log.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onPause.");
    com.tencent.mm.plugin.backup.d.b.cVs().cVu().b(this.uXI);
    if (com.tencent.mm.plugin.backup.d.b.cVs().cVu().uZx != null) {
      com.tencent.mm.plugin.backup.d.b.cVs().cVu().uZx.stop();
    }
    super.onPause();
    AppMethodBeat.o(300784);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21409);
    super.onResume();
    com.tencent.mm.plugin.backup.d.b.cVs().cVu().uZx.start();
    com.tencent.mm.plugin.backup.d.b.cVs().cVu().a(this.uXI);
    this.uXI.Fc(com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg);
    AppMethodBeat.o(21409);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI
 * JD-Core Version:    0.7.0.1
 */