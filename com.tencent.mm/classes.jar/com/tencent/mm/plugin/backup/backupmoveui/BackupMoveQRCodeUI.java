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
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BackupMoveQRCodeUI
  extends MMWizardActivity
{
  private b.d mTO;
  private ImageView mWl;
  private TextView mWm;
  private TextView mWn;
  private boolean mWo;
  
  public BackupMoveQRCodeUI()
  {
    AppMethodBeat.i(21406);
    this.mWo = false;
    this.mTO = new b.d()
    {
      public final void bCO() {}
      
      public final void wJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(21403);
        ac.i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
          ac.i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
          com.tencent.mm.plugin.backup.d.b.bDy().bCP().mSk = 12;
          Object localObject = new Intent(BackupMoveQRCodeUI.this, BackupMoveUI.class);
          MMWizardActivity.aj(BackupMoveQRCodeUI.this, (Intent)localObject);
          AppMethodBeat.o(21403);
          return;
          localObject = com.tencent.mm.plugin.backup.d.b.bDy().bDA().bitmapData;
          BackupMoveQRCodeUI.b(BackupMoveQRCodeUI.this).setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setText(2131756149);
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setTextColor(BackupMoveQRCodeUI.this.getContext().getResources().getColor(2131100711));
          BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this).setVisibility(4);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setText(2131756122);
          BackupMoveQRCodeUI.c(BackupMoveQRCodeUI.this).setTextColor(BackupMoveQRCodeUI.this.getContext().getResources().getColor(2131100798));
          BackupMoveQRCodeUI.b(BackupMoveQRCodeUI.this).setImageResource(2131689734);
          BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this).setVisibility(4);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          h.a(BackupMoveQRCodeUI.this, 2131756131, 0, 2131756089, 2131756090, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21396);
              ac.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.bDy().bDA().it(true);
              AppMethodBeat.o(21396);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21397);
              ac.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click cancel.");
              BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
              AppMethodBeat.o(21397);
            }
          }, 2131099990);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          h.a(BackupMoveQRCodeUI.this, 2131756130, 0, 2131756088, 2131756090, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21398);
              ac.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.bDy().bDA().it(true);
              AppMethodBeat.o(21398);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21399);
              ac.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click cancel.");
              BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
              AppMethodBeat.o(21399);
            }
          }, 2131099990);
          AppMethodBeat.o(21403);
          return;
          h.a(BackupMoveQRCodeUI.this, 2131756133, 0, 2131756270, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21400);
              ac.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
              AppMethodBeat.o(21400);
            }
          }, null, 2131099990);
          AppMethodBeat.o(21403);
          return;
          BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, true);
          h.a(BackupMoveQRCodeUI.this, 2131756129, 0, 2131756089, 2131756090, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21401);
              ac.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click move all.");
              BackupMoveQRCodeUI.a(BackupMoveQRCodeUI.this, false);
              com.tencent.mm.plugin.backup.d.b.bDy().bDA().it(true);
              AppMethodBeat.o(21401);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21402);
              ac.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click cancel.");
              BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
              AppMethodBeat.o(21402);
            }
          }, 2131099990);
        }
      }
    };
    AppMethodBeat.o(21406);
  }
  
  private void bDS()
  {
    AppMethodBeat.i(21412);
    if (az.afS())
    {
      h.a(this, 2131756148, 2131756147, 2131756171, 2131756090, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21405);
          ac.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
          com.tencent.mm.plugin.backup.d.b.bDy().bDz().stop();
          com.tencent.mm.plugin.backup.d.b.bDy().bDA().cancel(true);
          com.tencent.mm.plugin.backup.d.b.bDy().bCP().mSk = -100;
          BackupMoveQRCodeUI.g(BackupMoveQRCodeUI.this);
          AppMethodBeat.o(21405);
        }
      }, null, 2131099991);
      AppMethodBeat.o(21412);
      return;
    }
    ac.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
    com.tencent.mm.plugin.backup.d.b.bDy().bDz().stop();
    com.tencent.mm.plugin.backup.d.b.bDy().bDA().cancel(true);
    com.tencent.mm.plugin.backup.d.b.bDy().bCP().mSk = -100;
    ZA(1);
    AppMethodBeat.o(21412);
  }
  
  public int getLayoutId()
  {
    return 2131493130;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21410);
    setMMTitle(2131756098);
    this.mWl = ((ImageView)findViewById(2131297056));
    this.mWm = ((TextView)findViewById(2131297058));
    this.mWn = ((TextView)findViewById(2131297057));
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
    if (!az.agM())
    {
      finish();
      AppMethodBeat.o(21407);
      return;
    }
    initView();
    com.tencent.mm.plugin.backup.g.b.clear();
    paramBundle = com.tencent.mm.plugin.backup.d.b.bDy().bDA();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.mVh);
    com.tencent.mm.plugin.backup.b.d.wK(21);
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.mVg);
    com.tencent.mm.plugin.backup.d.b.bDy().bCQ();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.mVw);
    com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.d.b.bDy().bDz());
    com.tencent.mm.plugin.backup.g.b.wK(2);
    com.tencent.mm.plugin.backup.d.b.bDy().mSf = null;
    paramBundle.mVq = false;
    paramBundle.mVn = new com.tencent.mm.plugin.backup.c.c(com.tencent.mm.plugin.backup.d.b.bDy(), 2, paramBundle.mSX);
    com.tencent.mm.plugin.backup.d.b.bDy().bDA().mVr = com.tencent.mm.plugin.backup.b.c.mRV;
    com.tencent.mm.plugin.backup.b.d.bCV();
    AppMethodBeat.o(21407);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21411);
    if (paramInt == 4)
    {
      bDS();
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
    this.mTO.wJ(com.tencent.mm.plugin.backup.d.b.bDy().bCP().mSk);
    AppMethodBeat.o(21409);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21408);
    super.onStart();
    com.tencent.mm.plugin.backup.d.b.bDy().bDA().mTO = this.mTO;
    com.tencent.mm.plugin.backup.d.b.bDy().bDA().mVx.start();
    AppMethodBeat.o(21408);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21413);
    ac.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
    com.tencent.mm.plugin.backup.d.b.bDy().bDA().a(this.mTO);
    if (com.tencent.mm.plugin.backup.d.b.bDy().bDA().mVx != null) {
      com.tencent.mm.plugin.backup.d.b.bDy().bDA().mVx.stop();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI
 * JD-Core Version:    0.7.0.1
 */