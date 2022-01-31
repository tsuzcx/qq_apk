package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class BackupMoveQRCodeUI
  extends MMWizardActivity
  implements b.d
{
  private ImageView hJn;
  private TextView hJo;
  private TextView hJp;
  private boolean hJq = false;
  
  private void aup()
  {
    if (au.CW())
    {
      h.a(this, R.l.backup_move_qrcode_exit_move_tip, R.l.backup_move_qrcode_exit_move, R.l.backup_move_stop_move, R.l.backup_cancel, false, new BackupMoveQRCodeUI.2(this), null, R.e.backup_red);
      return;
    }
    y.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
    com.tencent.mm.plugin.backup.d.b.atS().atT().stop();
    com.tencent.mm.plugin.backup.d.b.atS().atU().cancel(true);
    com.tencent.mm.plugin.backup.d.b.atS().atn().hFu = -100;
    FW(1);
  }
  
  public final void atm() {}
  
  protected final int getLayoutId()
  {
    return R.i.backup_move_qrcode;
  }
  
  public final void initView()
  {
    setMMTitle(R.l.backup_move);
    this.hJn = ((ImageView)findViewById(R.h.backup_move_qrcode_image));
    this.hJo = ((TextView)findViewById(R.h.backup_move_qrcode_status_title));
    this.hJp = ((TextView)findViewById(R.h.backup_move_qrcode_status_content));
    setBackBtn(new BackupMoveQRCodeUI.1(this));
  }
  
  public final void nt(int paramInt)
  {
    y.i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.hJq) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case -33: 
      this.hJq = true;
      h.a(this, R.l.backup_move_error_not_support_quick_backup, 0, R.l.backup_all_types, R.l.backup_cancel, false, new BackupMoveQRCodeUI.8(this), new BackupMoveQRCodeUI.9(this), R.e.backup_green);
      return;
    case 2: 
      y.i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
      com.tencent.mm.plugin.backup.d.b.atS().atn().hFu = 12;
      MMWizardActivity.C(this, new Intent(this, BackupMoveUI.class));
      return;
    case 51: 
      byte[] arrayOfByte = com.tencent.mm.plugin.backup.d.b.atS().atU().bitmapData;
      this.hJn.setImageBitmap(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
      this.hJo.setText(R.l.backup_move_qrcode_success_tip);
      this.hJo.setTextColor(this.mController.uMN.getResources().getColor(R.e.black));
      this.hJp.setVisibility(4);
      return;
    case -11: 
    case -4: 
      this.hJo.setText(R.l.backup_move_error_move_gencode_err);
      this.hJo.setTextColor(this.mController.uMN.getResources().getColor(R.e.red));
      this.hJn.setImageResource(R.k.backup_move_qrcode_light);
      this.hJp.setVisibility(4);
      return;
    case -31: 
      this.hJq = true;
      h.a(this, R.l.backup_move_error_not_support_select_time_and_quick_backup, 0, R.l.backup_all_types, R.l.backup_cancel, false, new BackupMoveQRCodeUI.3(this), new BackupMoveQRCodeUI.4(this), R.e.backup_green);
      return;
    case -32: 
      this.hJq = true;
      h.a(this, R.l.backup_move_error_not_support_select_time, 0, R.l.backup_all_records, R.l.backup_cancel, false, new BackupMoveQRCodeUI.5(this), new BackupMoveQRCodeUI.6(this), R.e.backup_green);
      return;
    }
    h.a(this, R.l.backup_move_error_recover_phone_old_version, 0, R.l.backup_sure, 0, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        y.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
      }
    }, null, R.e.backup_green);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
      return;
    }
    if (!au.DK())
    {
      finish();
      return;
    }
    initView();
    com.tencent.mm.plugin.backup.g.b.clear();
    paramBundle = com.tencent.mm.plugin.backup.d.b.atS().atU();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.hIm);
    com.tencent.mm.plugin.backup.b.d.nu(21);
    com.tencent.mm.plugin.backup.g.b.a(paramBundle.hIl);
    com.tencent.mm.plugin.backup.d.b.atS().ato();
    com.tencent.mm.plugin.backup.g.b.a(paramBundle);
    com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.d.b.atS().atT());
    com.tencent.mm.plugin.backup.g.b.nu(2);
    com.tencent.mm.plugin.backup.d.b.atS().hFp = null;
    paramBundle.hIv = false;
    com.tencent.mm.plugin.backup.d.b.atS().atU().hIw = c.hFf;
    com.tencent.mm.plugin.backup.b.d.att();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      aup();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    nt(com.tencent.mm.plugin.backup.d.b.atS().atn().hFu);
  }
  
  public void onStart()
  {
    super.onStart();
    com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.d.b.atS().atU());
    com.tencent.mm.plugin.backup.d.b.atS().atU().hGU = this;
    com.tencent.mm.plugin.backup.d.b.atS().atU().hIB.start();
  }
  
  public void onStop()
  {
    y.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
    if (com.tencent.mm.plugin.backup.d.b.atS().atU().hIB != null) {
      com.tencent.mm.plugin.backup.d.b.atS().atU().hIB.stop();
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI
 * JD-Core Version:    0.7.0.1
 */