package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.s;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveUI
  extends MMWizardActivity
  implements b.d
{
  public TextView hJs;
  public TextView hJt;
  public TextView hJu;
  public TextView hJv;
  public TextView hJw;
  public ImageView hJx;
  
  private void auq()
  {
    this.hJw.setText(R.l.backup_close);
    this.hJw.setOnClickListener(new BackupMoveUI.2(this));
  }
  
  private void aur()
  {
    int i = b.atS().atn().hFu;
    y.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      FW(1);
      return;
    case 15: 
      y.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
      b.atS().atW().cancel();
      b.atS().atU().cancel(true);
      b.atS().atT().stop();
      b.atS().atn().hFu = -100;
      FW(1);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, R.l.backup_move_qrcode_exit_move_tip, R.l.backup_move_qrcode_exit_move, R.l.backup_move_stop_move, R.l.backup_cancel, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        y.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
        com.tencent.mm.plugin.report.service.h.nFQ.a(485L, 25L, 1L, false);
        b.atS().atT().stop();
        b.atS().atU().cancel(false);
        b.atS().atn().hFu = -100;
        BackupMoveUI.c(BackupMoveUI.this);
      }
    }, null, R.e.backup_red);
  }
  
  public final void atm() {}
  
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
  
  public final void nt(int paramInt)
  {
    Object localObject = b.atS().atn();
    y.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).hFv), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).hFw) });
    TextView localTextView;
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      return;
    case -100: 
      FW(1);
      return;
    case 3: 
      finish();
      return;
    case 1: 
      this.hJx.setImageResource(R.k.backup_move);
      this.hJu.setText(R.l.backup_move_connecting);
      this.hJv.setText(R.l.backup_move_keep_screen_on);
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      auq();
      return;
    case 13: 
      this.hJx.setImageResource(R.k.backup_move);
      this.hJu.setText(getString(R.l.backup_move_calculating, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).hFv), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).hFw) }));
      this.hJv.setText(R.l.backup_move_keep_screen_on);
      this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      auq();
      return;
    case 12: 
      this.hJx.setImageResource(R.k.backup_move);
      this.hJu.setText(R.l.backup_move_preparing);
      this.hJv.setText(R.l.backup_move_keep_screen_on);
      this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      auq();
      return;
    case 14: 
      this.hJx.setImageResource(R.k.backup_move);
      localTextView = this.hJu;
      paramInt = R.l.backup_move_transfer;
      i = ((com.tencent.mm.plugin.backup.b.e)localObject).hFv;
      j = ((com.tencent.mm.plugin.backup.b.e)localObject).hFw;
      b.atS().atU();
      localTextView.setText(getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), d.auj() }));
      this.hJv.setText(R.l.backup_move_keep_screen_on);
      this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      auq();
      return;
    case 15: 
      this.hJx.setImageResource(R.k.backup_move_finish);
      this.hJu.setText(R.l.backup_move_finish);
      this.hJv.setText(getString(R.l.backup_move_finish_detail, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).hFv), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).hFw) }));
      this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hJs.setText(R.l.backup_finish);
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(0);
      this.hJt.setVisibility(4);
      this.hJs.setOnClickListener(new BackupMoveUI.1(this));
      auq();
      return;
    case 51: 
      localObject = b.atS().atU().bitmapData;
      this.hJx.setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
      this.hJu.setText(R.l.backup_move_qrcode_success_tip);
      this.hJu.setTextColor(this.mController.uMN.getResources().getColor(R.e.black));
      this.hJv.setVisibility(4);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      auq();
      return;
    case 4: 
      this.hJx.setImageResource(R.k.backup_move);
      localTextView = this.hJu;
      paramInt = R.l.backup_move_transfer;
      i = ((com.tencent.mm.plugin.backup.b.e)localObject).hFv;
      j = ((com.tencent.mm.plugin.backup.b.e)localObject).hFw;
      b.atS().atU();
      localTextView.setText(getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), d.auj() }));
      this.hJv.setText(R.l.backup_move_transfer_weak_network);
      this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      auq();
      return;
    case -4: 
      this.hJx.setImageResource(R.k.backup_move_qrcode_dark);
      b.atS().atU().hIB.start();
      this.hJu.setText(getString(R.l.backup_move_network_disconnect_transfer_state, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).hFv), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).hFw), "0M" }));
      this.hJv.setText(R.l.backup_move_error_network_disconnect);
      this.hJv.setTextColor(this.mController.uMN.getResources().getColor(R.e.red));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      this.hJw.setText(R.l.backup_minimize);
      this.hJw.setOnClickListener(new BackupMoveUI.4(this));
      b.atS().atU().hIw = c.hFg;
      return;
    case -11: 
      this.hJx.setImageResource(R.k.backup_move_qrcode_dark);
      this.hJu.setText(getString(R.l.backup_move_network_disconnect_transfer_state, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).hFv), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).hFw), "0M" }));
      this.hJv.setText(R.l.backup_move_error_move_gencode_err);
      this.hJv.setTextColor(this.mController.uMN.getResources().getColor(R.e.red));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      auq();
      return;
    case -21: 
      this.hJx.setImageResource(R.k.backup_move_error);
      this.hJu.setText(R.l.backup_move_error_programme_error);
      this.hJv.setVisibility(4);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      auq();
      return;
    }
    this.hJx.setImageResource(R.k.backup_move_error);
    this.hJu.setText(R.l.backup_move_error_empty_records);
    this.hJv.setVisibility(4);
    this.hJs.setVisibility(4);
    this.hJt.setVisibility(4);
    auq();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
      return;
    }
    y.i("MicroMsg.BackupMoveUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.eUR.tn();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      b.atS().atU().hHV = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      y.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[] { Boolean.valueOf(b.atS().atU().hHV) });
      return;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bk.csb() });
    }
  }
  
  public void onDestroy()
  {
    y.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
    if (b.atS().atU().hIB != null) {
      b.atS().atU().hIB.stop();
    }
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
  
  public void onResume()
  {
    super.onResume();
    b.atS().atU().hGU = this;
    nt(b.atS().atn().hFu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI
 * JD-Core Version:    0.7.0.1
 */