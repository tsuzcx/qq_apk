package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BackupMoveQRCodeUI
  extends MMWizardActivity
{
  private b.d oKF;
  private ImageView oNc;
  private TextView oNd;
  private TextView oNe;
  private boolean oNf;
  
  public BackupMoveQRCodeUI()
  {
    AppMethodBeat.i(21406);
    this.oNf = false;
    this.oKF = new b.d()
    {
      public final void Ba(int paramAnonymousInt)
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
          com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 12;
          Object localObject = new Intent(BackupMoveQRCodeUI.this, BackupMoveUI.class);
          MMWizardActivity.ay(BackupMoveQRCodeUI.this, (Intent)localObject);
          AppMethodBeat.o(21403);
          return;
          localObject = com.tencent.mm.plugin.backup.d.b.cfv().cfx().bitmapData;
          BackupMoveQRCodeUI.b(BackupMoveQRCodeUI.this).setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setText(2131756283);
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setTextColor(BackupMoveQRCodeUI.this.getContext().getResources().getColor(2131100904));
          BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this).setVisibility(4);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setText(2131756256);
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setTextColor(BackupMoveQRCodeUI.this.getContext().getResources().getColor(2131100994));
          BackupMoveQRCodeUI.b(BackupMoveQRCodeUI.this).setImageResource(2131689743);
          BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this).setVisibility(4);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          h.a(BackupMoveQRCodeUI.this, 2131756265, 0, 2131756223, 2131756224, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21396);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.cfv().cfx().jB(true);
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
          }, 2131100014);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          h.a(BackupMoveQRCodeUI.this, 2131756264, 0, 2131756222, 2131756224, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21398);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.cfv().cfx().jB(true);
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
          }, 2131100014);
          AppMethodBeat.o(21403);
          return;
          h.a(BackupMoveQRCodeUI.this, 2131756267, 0, 2131756404, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21400);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
              AppMethodBeat.o(21400);
            }
          }, null, 2131100014);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          h.a(BackupMoveQRCodeUI.this, 2131756263, 0, 2131756223, 2131756224, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21401);
              Log.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.cfv().cfx().jB(true);
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
          }, 2131100014);
        }
      }
      
      public final void ceL() {}
    };
    AppMethodBeat.o(21406);
  }
  
  private void cfS()
  {
    AppMethodBeat.i(21412);
    if (bg.azj())
    {
      h.a(this, 2131756282, 2131756281, 2131756305, 2131756224, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21405);
          Log.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
          com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
          com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(true);
          com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
          BackupMoveQRCodeUI.g(BackupMoveQRCodeUI.this);
          AppMethodBeat.o(21405);
        }
      }, null, 2131100015);
      AppMethodBeat.o(21412);
      return;
    }
    Log.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
    com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
    com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(true);
    com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
    ala(1);
    AppMethodBeat.o(21412);
  }
  
  public int getLayoutId()
  {
    return 2131493173;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21410);
    setMMTitle(2131756232);
    this.oNc = ((ImageView)findViewById(2131297202));
    this.oNd = ((TextView)findViewById(2131297204));
    this.oNe = ((TextView)findViewById(2131297203));
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
    if (!bg.aAc())
    {
      finish();
      AppMethodBeat.o(21407);
      return;
    }
    initView();
    com.tencent.mm.plugin.backup.g.b.clear();
    paramBundle = com.tencent.mm.plugin.backup.d.b.cfv().cfx();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.oLY);
    com.tencent.mm.plugin.backup.b.d.Bb(21);
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.oLX);
    com.tencent.mm.plugin.backup.d.b.cfv().ceN();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.oMn);
    com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.d.b.cfv().cfw());
    com.tencent.mm.plugin.backup.g.b.Bb(2);
    com.tencent.mm.plugin.backup.d.b.cfv().oIX = null;
    paramBundle.oMh = false;
    paramBundle.oMe = new com.tencent.mm.plugin.backup.c.c(com.tencent.mm.plugin.backup.d.b.cfv(), 2, paramBundle.oJO);
    com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMi = com.tencent.mm.plugin.backup.b.c.oIN;
    com.tencent.mm.plugin.backup.b.d.ceS();
    AppMethodBeat.o(21407);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21411);
    if (paramInt == 4)
    {
      cfS();
      AppMethodBeat.o(21411);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21411);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21409);
    super.onResume();
    this.oKF.Ba(com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc);
    AppMethodBeat.o(21409);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21408);
    super.onStart();
    com.tencent.mm.plugin.backup.d.b.cfv().cfx().oKF = this.oKF;
    com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo.start();
    AppMethodBeat.o(21408);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21413);
    Log.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
    com.tencent.mm.plugin.backup.d.b.cfv().cfx().a(this.oKF);
    if (com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo != null) {
      com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo.stop();
    }
    super.onStop();
    AppMethodBeat.o(21413);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI
 * JD-Core Version:    0.7.0.1
 */