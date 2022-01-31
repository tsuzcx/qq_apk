package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveRecoverUI
  extends MMWizardActivity
  implements b.d
{
  private static boolean faM = false;
  private static boolean hJz = false;
  public TextView hJs;
  public TextView hJt;
  public TextView hJu;
  public TextView hJv;
  public TextView hJw;
  public ImageView hJx;
  private RoundProgressBtn hJy;
  
  private void auq()
  {
    this.hJw.setText(R.l.backup_close);
    this.hJw.setOnClickListener(new BackupMoveRecoverUI.15(this));
  }
  
  private void aur()
  {
    int i = b.atS().atn().hFu;
    y.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
    switch (i)
    {
    default: 
    case -22: 
    case -21: 
    case -13: 
    case -5: 
    case -3: 
    case -2: 
    case -1: 
    case 1: 
    case 27: 
    case 24: 
      for (;;)
      {
        FW(1);
        return;
        b.atS().atV().a(false, false, -100);
        return;
        y.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[] { Integer.valueOf(i) });
        b.atS().atV().a(true, false, -100);
        b.atS().atT().stop();
        return;
        b.atS().atn().hFu = 25;
      }
    case 52: 
      com.tencent.mm.ui.base.h.a(this, R.l.backup_move_error_alert_stop_move_tip, R.l.backup_move_error_alert_stop_move, R.l.backup_move_recover_stop_move, R.l.backup_cancel, false, new BackupMoveRecoverUI.16(this, i), null, R.e.backup_red);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, R.l.backup_pc_error_alert_stop_recover_tip, R.l.backup_pc_error_alert_stop_recover, R.l.backup_pc_stop_recover, R.l.backup_cancel, false, new BackupMoveRecoverUI.17(this, i), null, R.e.backup_red);
  }
  
  private void aus()
  {
    this.hJw.setText(R.l.backup_minimize);
    this.hJw.setOnClickListener(new BackupMoveRecoverUI.18(this));
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
    this.hJy = ((RoundProgressBtn)findViewById(R.h.backup_pause_button));
  }
  
  public final void nt(final int paramInt)
  {
    Object localObject = b.atS().atn();
    y.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(hJz), Integer.valueOf(((e)localObject).hFv), Integer.valueOf(((e)localObject).hFw), Integer.valueOf(((e)localObject).hFx) });
    TextView localTextView;
    int i;
    int j;
    switch (paramInt)
    {
    default: 
    case -100: 
    case 3: 
    case 1: 
    case 22: 
    case 52: 
    case 23: 
    case 28: 
    case 29: 
    case 25: 
    case 24: 
      do
      {
        do
        {
          return;
          FW(1);
          return;
          finish();
          return;
          this.hJx.setImageResource(R.k.backup_move);
          this.hJu.setText(R.l.backup_move_connecting);
          this.hJv.setText(R.l.backup_move_keep_screen_on);
          this.hJv.setVisibility(0);
          this.hJs.setVisibility(4);
          this.hJt.setVisibility(4);
          this.hJy.setVisibility(8);
          auq();
          return;
          this.hJx.setImageResource(R.k.backup_move);
          this.hJu.setText(R.l.backup_move_recover_preparing);
          this.hJv.setText(R.l.backup_move_keep_screen_on);
          this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
          this.hJv.setVisibility(0);
          this.hJs.setVisibility(4);
          this.hJt.setVisibility(4);
          this.hJy.setVisibility(8);
          aus();
          return;
          this.hJx.setImageResource(R.k.backup_move);
          this.hJu.setText(R.l.backup_move_has_move_before);
          this.hJs.setText(R.l.backup_move_has_move_before_move_resume);
          this.hJt.setText(R.l.backup_move_has_move_before_move_all);
          this.hJv.setVisibility(4);
          this.hJs.setVisibility(0);
          this.hJt.setVisibility(0);
          this.hJy.setVisibility(8);
          this.hJs.setOnClickListener(new BackupMoveRecoverUI.1(this));
          this.hJt.setOnClickListener(new BackupMoveRecoverUI.12(this));
          auq();
          return;
          this.hJx.setImageResource(R.k.backup_move);
          localTextView = this.hJu;
          paramInt = R.l.backup_move_recover_transfer;
          i = ((e)localObject).hFv;
          j = ((e)localObject).hFw;
          b.atS().atV();
          localTextView.setText(getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), c.aub() }));
          this.hJv.setText(R.l.backup_move_keep_screen_on);
          this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
          this.hJv.setVisibility(0);
          this.hJs.setVisibility(8);
          this.hJt.setVisibility(4);
          this.hJy.setVisibility(0);
          this.hJy.setProgress(((e)localObject).atw());
          this.hJy.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              y.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
              b.atS().atV().aua();
            }
          });
          aus();
          return;
          this.hJx.setImageResource(R.k.backup_move);
          this.hJu.setText(R.l.backup_move_pause);
          this.hJv.setText(R.l.backup_move_pause_tips);
          this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
          this.hJv.setVisibility(0);
          this.hJs.setVisibility(0);
          this.hJy.setVisibility(8);
          this.hJs.setText(R.l.backup_move_pause_scan_qrcode);
          this.hJs.setOnClickListener(new BackupMoveRecoverUI.20(this));
          this.hJt.setVisibility(0);
          this.hJt.setText(R.l.backup_move_recover_stop_move);
          this.hJt.setOnClickListener(new BackupMoveRecoverUI.21(this));
          aus();
          return;
          this.hJx.setImageResource(R.k.backup_move);
          this.hJu.setText(R.l.backup_move_stop);
          this.hJv.setText(R.l.backup_move_stop_tips);
          this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
          this.hJv.setVisibility(0);
          this.hJs.setVisibility(0);
          this.hJy.setVisibility(8);
          this.hJs.setText(R.l.backup_move_start_merge_already_move_data);
          this.hJs.setOnClickListener(new BackupMoveRecoverUI.22(this));
          this.hJt.setVisibility(0);
          this.hJt.setText(R.l.backup_move_do_not_merge);
          this.hJt.setOnClickListener(new BackupMoveRecoverUI.23(this, paramInt));
          this.hJw.setText(R.l.backup_remind_later);
          this.hJw.setOnClickListener(new BackupMoveRecoverUI.24(this));
          return;
        } while (!hJz);
        b.atS().atn().hFu = 24;
        paramInt = 24;
        break;
        y.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[] { Boolean.valueOf(faM) });
        if (faM)
        {
          this.hJx.setImageResource(R.k.backup_move);
          this.hJu.setText(R.l.backup_move_recover_transfer_finish);
          this.hJv.setText(R.l.backup_move_recover_transfer_finish_tip);
          this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
          this.hJs.setText(R.l.backup_move_recover_start_merge);
          this.hJt.setText(R.l.backup_move_recover_stop_merge);
          this.hJw.setText(R.l.backup_remind_later);
          this.hJv.setVisibility(0);
          this.hJs.setVisibility(0);
          this.hJt.setVisibility(0);
          this.hJy.setVisibility(8);
          this.hJs.setOnClickListener(new BackupMoveRecoverUI.25(this));
          this.hJt.setOnClickListener(new BackupMoveRecoverUI.2(this, paramInt));
          this.hJw.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              b.atS().atn().hFu = 25;
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this);
            }
          });
          return;
        }
      } while (!hJz);
      b.atS().atV();
      if (!c.atX())
      {
        y.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
        b.atS().atn().hFu = -22;
        nt(-22);
        com.tencent.mm.plugin.report.service.h.nFQ.a(485L, 6L, 1L, false);
        return;
      }
      b.atS().atV().atF();
      return;
    case 26: 
      this.hJx.setImageResource(R.k.backup_move_recover);
      this.hJu.setText(getString(R.l.backup_move_recover_merging, new Object[] { Integer.valueOf(((e)localObject).hFx) }));
      this.hJv.setText(R.l.backup_move_recover_merging_tip);
      this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      this.hJy.setVisibility(8);
      auq();
      return;
    case 30: 
      this.hJx.setImageResource(R.k.backup_move_recover);
      this.hJu.setText(R.l.backup_recover_merge_building);
      this.hJv.setText(R.l.backup_move_recover_merging_tip);
      this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      this.hJy.setVisibility(8);
      auq();
      return;
    case 27: 
      this.hJx.setImageResource(R.k.backup_move_recover_finish);
      this.hJu.setText(R.l.backup_move_recover_merge_finish);
      this.hJv.setText(getString(R.l.backup_move_recover_merge_finish_detail, new Object[] { Integer.valueOf(((e)localObject).hFv), Integer.valueOf(((e)localObject).hFw) }));
      this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hJs.setText(R.l.backup_finish);
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(0);
      this.hJt.setVisibility(4);
      this.hJy.setVisibility(8);
      this.hJs.setOnClickListener(new BackupMoveRecoverUI.4(this));
      auq();
      return;
    case 4: 
      this.hJx.setImageResource(R.k.backup_move);
      localTextView = this.hJu;
      paramInt = R.l.backup_move_recover_transfer;
      i = ((e)localObject).hFv;
      j = ((e)localObject).hFw;
      b.atS().atV();
      localTextView.setText(getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), c.aub() }));
      this.hJv.setText(R.l.backup_move_transfer_weak_network);
      this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(8);
      this.hJt.setVisibility(0);
      this.hJy.setVisibility(0);
      this.hJy.setProgress(((e)localObject).atw());
      this.hJy.setOnClickListener(new BackupMoveRecoverUI.5(this));
      this.hJt.setText(R.l.backup_move_transfer_weak_network_go_set_wifi_ap);
      this.hJt.setOnClickListener(new BackupMoveRecoverUI.6(this));
      aus();
      return;
    case -4: 
      this.hJx.setImageResource(R.k.backup_move_error);
      this.hJu.setText(getString(R.l.backup_move_network_disconnect_transfer_state, new Object[] { Integer.valueOf(((e)localObject).hFv), Integer.valueOf(((e)localObject).hFw), "0M" }));
      this.hJv.setText(R.l.backup_move_error_network_disconnect);
      this.hJs.setText(R.l.backup_move_recover_scan_qrcode_again);
      this.hJt.setText(R.l.backup_move_recover_stop_move);
      this.hJs.setOnClickListener(new BackupMoveRecoverUI.7(this));
      this.hJt.setOnClickListener(new BackupMoveRecoverUI.8(this, paramInt));
      this.hJv.setTextColor(getResources().getColor(R.e.backup_red));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(0);
      this.hJt.setVisibility(0);
      this.hJy.setVisibility(8);
      aus();
      return;
    case -2: 
    case -1: 
      this.hJx.setImageResource(R.k.backup_move_error);
      this.hJu.setText(R.l.backup_move_error_not_same_wifi);
      localObject = g.cM(this);
      if ((localObject == null) || (((String)localObject).equals(""))) {
        this.hJv.setText(getString(R.l.backup_move_error_not_same_wifi_wifiname, new Object[] { "移动网络", b.atS().atV().hIb }));
      }
      for (;;)
      {
        this.hJv.setTextColor(getResources().getColor(R.e.backup_red));
        this.hJv.setVisibility(0);
        this.hJs.setVisibility(4);
        this.hJt.setVisibility(4);
        this.hJy.setVisibility(8);
        auq();
        return;
        this.hJv.setText(getString(R.l.backup_move_error_not_same_wifi_wifiname, new Object[] { localObject, b.atS().atV().hIb }));
      }
    case -3: 
      this.hJx.setImageResource(R.k.backup_move_error);
      this.hJu.setText(R.l.backup_move_error_complex_wifi);
      this.hJv.setText(R.l.backup_move_error_complex_wifi_wifiap_tip);
      this.hJs.setText(R.l.backup_move_recover_open_wifia_word);
      this.hJt.setText(R.l.backup_move_recover_stop_move);
      this.hJv.setTextColor(getResources().getColor(R.e.backup_red));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(0);
      this.hJt.setVisibility(0);
      this.hJy.setVisibility(8);
      this.hJs.setOnClickListener(new BackupMoveRecoverUI.9(this));
      this.hJt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, R.l.backup_move_error_alert_stop_move_tip, R.l.backup_move_error_alert_stop_move, R.l.backup_move_recover_stop_move, R.l.backup_cancel, false, new BackupMoveRecoverUI.10.1(this), null, R.e.backup_red);
        }
      });
      auq();
      return;
    case -5: 
      this.hJx.setImageResource(R.k.backup_move_error);
      this.hJu.setText(R.l.backup_move_error_connect_fail);
      this.hJs.setText(R.l.backup_move_recover_scan_qrcode_again);
      this.hJt.setText(R.l.backup_move_recover_stop_move);
      this.hJv.setVisibility(4);
      this.hJs.setVisibility(0);
      this.hJt.setVisibility(0);
      this.hJy.setVisibility(8);
      this.hJs.setOnClickListener(new BackupMoveRecoverUI.11(this));
      this.hJt.setOnClickListener(new BackupMoveRecoverUI.13(this, paramInt));
      auq();
      return;
    case -21: 
      this.hJx.setImageResource(R.k.backup_move_error);
      this.hJu.setText(R.l.backup_pc_error_programme_error);
      this.hJv.setVisibility(4);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      this.hJy.setVisibility(8);
      auq();
      return;
    case -12: 
      this.hJx.setImageResource(R.k.backup_move);
      this.hJu.setText(R.l.backup_move_connecting);
      this.hJv.setText(R.l.backup_move_keep_screen_on);
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      this.hJy.setVisibility(8);
      auq();
      com.tencent.mm.ui.base.h.a(this, R.l.backup_move_error_move_phone_old_version, 0, R.l.backup_sure, 0, false, new BackupMoveRecoverUI.14(this), null, R.e.backup_green);
      return;
    case -13: 
      this.hJx.setImageResource(R.k.backup_move_error);
      this.hJu.setText(R.l.backup_move_error_not_enough_space_for_recover);
      this.hJv.setText(getString(R.l.backup_move_error_not_enough_space_for_recover_tip, new Object[] { bk.cm(b.atS().atV().hIj) }));
      this.hJv.setVisibility(0);
      this.hJs.setVisibility(4);
      this.hJt.setVisibility(4);
      this.hJy.setVisibility(8);
      auq();
      return;
    }
    this.hJx.setImageResource(R.k.backup_move_error);
    this.hJu.setText(R.l.backup_pc_error_miss_recover_merge_data);
    b.atS().atT().stop();
    this.hJv.setVisibility(4);
    this.hJs.setVisibility(4);
    this.hJt.setVisibility(4);
    this.hJy.setVisibility(8);
    auq();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
      return;
    }
    y.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.eUR.tn();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      b.atS().atV().hHV = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      y.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[] { Boolean.valueOf(b.atS().atV().hHV) });
      return;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bk.csb() });
    }
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
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
  
  protected void onPause()
  {
    super.onPause();
    y.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
    hJz = false;
  }
  
  public void onResume()
  {
    super.onResume();
    y.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
    hJz = true;
    b.atS().atV().hGU = this;
    faM = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    nt(b.atS().atn().hFu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI
 * JD-Core Version:    0.7.0.1
 */