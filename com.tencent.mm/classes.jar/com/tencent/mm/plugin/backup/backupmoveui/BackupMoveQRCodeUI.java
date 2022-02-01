package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
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
import com.tencent.mm.ui.base.h;

public class BackupMoveQRCodeUI
  extends MMWizardActivity
{
  private b.d rMv;
  private ImageView rOY;
  private TextView rOZ;
  private TextView rPa;
  private boolean rPb;
  
  public BackupMoveQRCodeUI()
  {
    AppMethodBeat.i(21406);
    this.rPb = false;
    this.rMv = new b.d()
    {
      public final void EB(int paramAnonymousInt)
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
          com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = 12;
          Object localObject = new Intent(BackupMoveQRCodeUI.this, BackupMoveUI.class);
          MMWizardActivity.aH(BackupMoveQRCodeUI.this, (Intent)localObject);
          AppMethodBeat.o(21403);
          return;
          localObject = com.tencent.mm.plugin.backup.d.b.csI().csK().bitmapData;
          BackupMoveQRCodeUI.b(BackupMoveQRCodeUI.this).setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setText(R.l.eql);
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setTextColor(BackupMoveQRCodeUI.this.getContext().getResources().getColor(R.e.normal_text_color));
          BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this).setVisibility(4);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setText(R.l.epM);
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setTextColor(BackupMoveQRCodeUI.this.getContext().getResources().getColor(R.e.red));
          BackupMoveQRCodeUI.b(BackupMoveQRCodeUI.this).setImageResource(R.k.backup_move_qrcode_light);
          BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this).setVisibility(4);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          h.a(BackupMoveQRCodeUI.this, R.l.epV, 0, R.l.epk, R.l.epl, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21396);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.csI().csK().kM(true);
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
          }, R.e.dke);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          h.a(BackupMoveQRCodeUI.this, R.l.epU, 0, R.l.epj, R.l.epl, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21398);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.csI().csK().kM(true);
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
          }, R.e.dke);
          AppMethodBeat.o(21403);
          return;
          h.a(BackupMoveQRCodeUI.this, R.l.epX, 0, R.l.erY, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21400);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
              AppMethodBeat.o(21400);
            }
          }, null, R.e.dke);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          h.a(BackupMoveQRCodeUI.this, R.l.epT, 0, R.l.epk, R.l.epl, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21401);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.csI().csK().kM(true);
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
          }, R.e.dke);
        }
      }
      
      public final void crY() {}
    };
    AppMethodBeat.o(21406);
  }
  
  private void ctf()
  {
    AppMethodBeat.i(21412);
    if (bh.aGE())
    {
      h.a(this, R.l.eqk, R.l.eqj, R.l.eqF, R.l.epl, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21405);
          Log.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
          com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
          com.tencent.mm.plugin.backup.d.b.csI().csK().cancel(true);
          com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = -100;
          BackupMoveQRCodeUI.g(BackupMoveQRCodeUI.this);
          AppMethodBeat.o(21405);
        }
      }, null, R.e.dkf);
      AppMethodBeat.o(21412);
      return;
    }
    Log.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
    com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
    com.tencent.mm.plugin.backup.d.b.csI().csK().cancel(true);
    com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = -100;
    atX(1);
    AppMethodBeat.o(21412);
  }
  
  public int getLayoutId()
  {
    return R.i.ebP;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21410);
    setMMTitle(R.l.backup_move);
    this.rOY = ((ImageView)findViewById(R.h.dsH));
    this.rOZ = ((TextView)findViewById(R.h.dsJ));
    this.rPa = ((TextView)findViewById(R.h.dsI));
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
    if (!bh.aHB())
    {
      finish();
      AppMethodBeat.o(21407);
      return;
    }
    initView();
    com.tencent.mm.plugin.backup.g.b.clear();
    paramBundle = com.tencent.mm.plugin.backup.d.b.csI().csK();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.rNQ);
    com.tencent.mm.plugin.backup.b.d.EC(21);
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.rNP);
    com.tencent.mm.plugin.backup.d.b.csI().csa();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.rOi);
    com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.d.b.csI().csJ());
    com.tencent.mm.plugin.backup.g.b.EC(2);
    com.tencent.mm.plugin.backup.d.b.csI().rKN = null;
    paramBundle.rOc = false;
    paramBundle.rNZ = new com.tencent.mm.plugin.backup.c.c(com.tencent.mm.plugin.backup.d.b.csI(), 2, paramBundle.rLE);
    com.tencent.mm.plugin.backup.d.b.csI().csK().rOd = com.tencent.mm.plugin.backup.b.c.rKD;
    com.tencent.mm.plugin.backup.b.d.csf();
    AppMethodBeat.o(21407);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21411);
    if (paramInt == 4)
    {
      ctf();
      AppMethodBeat.o(21411);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21411);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(287289);
    Log.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onPause.");
    com.tencent.mm.plugin.backup.d.b.csI().csK().b(this.rMv);
    if (com.tencent.mm.plugin.backup.d.b.csI().csK().rOj != null) {
      com.tencent.mm.plugin.backup.d.b.csI().csK().rOj.stop();
    }
    super.onPause();
    AppMethodBeat.o(287289);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21409);
    super.onResume();
    com.tencent.mm.plugin.backup.d.b.csI().csK().rOj.start();
    com.tencent.mm.plugin.backup.d.b.csI().csK().a(this.rMv);
    this.rMv.EB(com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS);
    AppMethodBeat.o(21409);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI
 * JD-Core Version:    0.7.0.1
 */