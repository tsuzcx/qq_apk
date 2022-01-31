package com.tencent.mm.plugin.backup.backuppcui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class BackupPcUI$3
  implements b.c
{
  BackupPcUI$3(BackupPcUI paramBackupPcUI) {}
  
  private void auq()
  {
    BackupPcUI.h(this.hLm).setText(R.l.backup_close);
    BackupPcUI.h(this.hLm).setOnClickListener(new BackupPcUI.3.7(this));
  }
  
  private void aus()
  {
    BackupPcUI.h(this.hLm).setText(R.l.backup_minimize);
    BackupPcUI.h(this.hLm).setOnClickListener(new BackupPcUI.3.8(this));
  }
  
  private void nE(int paramInt)
  {
    if ((2 == paramInt) || (4 == paramInt))
    {
      BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_recover_error);
      return;
    }
    BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_error);
  }
  
  public final void atl()
  {
    int i = b.auw().aux().hKx;
    y.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      return;
    case 1: 
      b.auw().atn().hFu = 11;
      nt(11);
      return;
    case 2: 
      b.auw().atn().hFu = 21;
      nt(21);
      return;
    case 3: 
      b.auw().atn().hFu = 12;
      nt(12);
      return;
    }
    b.auw().atn().hFu = 22;
    nt(22);
  }
  
  public final void atm() {}
  
  public final void nt(int paramInt)
  {
    int i = b.auw().aux().hKx;
    y.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    Object localObject = b.auw().atn();
    TextView localTextView;
    BackupPcUI localBackupPcUI;
    int j;
    switch (paramInt)
    {
    default: 
    case -100: 
    case 1: 
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    case 21: 
    case 22: 
    case 23: 
    case 25: 
    case 24: 
      do
      {
        do
        {
          return;
          BackupPcUI.a(this.hLm);
          return;
          BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_icon);
          BackupPcUI.c(this.hLm).setText(R.l.backup_pc_connecting);
          BackupPcUI.d(this.hLm).setVisibility(4);
          BackupPcUI.e(this.hLm).setVisibility(4);
          BackupPcUI.f(this.hLm).setVisibility(4);
          auq();
          return;
          BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_icon);
          BackupPcUI.c(this.hLm).setText(R.l.backup_pc_start_tip);
          BackupPcUI.d(this.hLm).setText(R.l.backup_pc_start_no_new_message);
          BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_status_content));
          BackupPcUI.e(this.hLm).setText(R.l.backup_pc_start_backup_allrecords);
          BackupPcUI.f(this.hLm).setText(R.l.backup_pc_start_choose_records);
          BackupPcUI.d(this.hLm).setVisibility(0);
          BackupPcUI.e(this.hLm).setVisibility(0);
          BackupPcUI.f(this.hLm).setVisibility(0);
          auq();
          BackupPcUI.e(this.hLm).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              au.Hx();
              boolean bool = ((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uus, Boolean.valueOf(false))).booleanValue();
              y.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                com.tencent.mm.ui.base.h.a(BackupPcUI.3.this.hLm, R.l.backup_pc_has_move_tip, 0, R.l.backup_sure, 0, false, new BackupPcUI.3.1.1(this), null, R.e.backup_green);
                return;
              }
              b.auw().aux().nB(2);
              b.auw().atn().hFu = 12;
              BackupPcUI.3.this.nt(12);
              b.auw().auA().cancel();
              b.auw().auA().auv();
              b.auw().auA().ee(true);
              com.tencent.mm.plugin.report.service.h.nFQ.a(400L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.h.nFQ.f(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(b.auw().aux().hKD) });
            }
          });
          BackupPcUI.f(this.hLm).setOnClickListener(new BackupPcUI.3.9(this));
          return;
          BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_icon);
          BackupPcUI.c(this.hLm).setText(R.l.backup_pc_prepare);
          BackupPcUI.d(this.hLm).setText(R.l.backup_pc_prepare_keep_screen_on);
          BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_status_content));
          BackupPcUI.d(this.hLm).setVisibility(0);
          BackupPcUI.e(this.hLm).setVisibility(4);
          BackupPcUI.f(this.hLm).setVisibility(4);
          aus();
          return;
          BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_icon);
          localTextView = BackupPcUI.c(this.hLm);
          localBackupPcUI = this.hLm;
          paramInt = R.l.backup_pc_transfer;
          i = ((e)localObject).hFv;
          j = ((e)localObject).hFw;
          b.auw().aux();
          localTextView.setText(localBackupPcUI.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.auC() }));
          BackupPcUI.d(this.hLm).setText(R.l.backup_pc_prepare_keep_screen_on);
          BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_status_content));
          BackupPcUI.d(this.hLm).setVisibility(0);
          BackupPcUI.e(this.hLm).setVisibility(4);
          BackupPcUI.f(this.hLm).setVisibility(4);
          aus();
          return;
          BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_finished);
          BackupPcUI.c(this.hLm).setText(R.l.backup_pc_backup_finish);
          BackupPcUI.d(this.hLm).setText(this.hLm.getString(R.l.backup_pc_backup_finish_detail, new Object[] { Integer.valueOf(((e)localObject).hFv), Integer.valueOf(((e)localObject).hFw) }));
          BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_status_content));
          BackupPcUI.e(this.hLm).setText(R.l.backup_finish);
          BackupPcUI.d(this.hLm).setVisibility(0);
          BackupPcUI.e(this.hLm).setVisibility(0);
          BackupPcUI.f(this.hLm).setVisibility(4);
          BackupPcUI.e(this.hLm).setOnClickListener(new BackupPcUI.3.10(this));
          auq();
          return;
          BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_recover_icon);
          BackupPcUI.c(this.hLm).setText(R.l.backup_pc_recover_start_tip);
          BackupPcUI.e(this.hLm).setText(R.l.backup_pc_recover_start_recover);
          BackupPcUI.d(this.hLm).setVisibility(4);
          BackupPcUI.e(this.hLm).setVisibility(0);
          BackupPcUI.f(this.hLm).setVisibility(4);
          BackupPcUI.e(this.hLm).setOnClickListener(new BackupPcUI.3.11(this));
          auq();
          return;
          BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_recover_icon);
          BackupPcUI.c(this.hLm).setText(R.l.backup_pc_prepare);
          BackupPcUI.d(this.hLm).setText(R.l.backup_pc_prepare_keep_screen_on);
          BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_status_content));
          BackupPcUI.d(this.hLm).setVisibility(0);
          BackupPcUI.e(this.hLm).setVisibility(4);
          BackupPcUI.f(this.hLm).setVisibility(4);
          aus();
          return;
          BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_recover_icon);
          localTextView = BackupPcUI.c(this.hLm);
          localBackupPcUI = this.hLm;
          paramInt = R.l.backup_pc_recover_transfer;
          i = ((e)localObject).hFv;
          j = ((e)localObject).hFw;
          b.auw().aux();
          localTextView.setText(localBackupPcUI.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.auC() }));
          BackupPcUI.d(this.hLm).setText(R.l.backup_pc_prepare_keep_screen_on);
          BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_status_content));
          BackupPcUI.d(this.hLm).setVisibility(0);
          BackupPcUI.e(this.hLm).setVisibility(4);
          BackupPcUI.f(this.hLm).setVisibility(4);
          aus();
          return;
        } while (!bk.bU(this.hLm));
        b.auw().atn().hFu = 24;
        paramInt = 24;
        break;
        if (BackupPcUI.access$700())
        {
          BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_recover_icon);
          BackupPcUI.c(this.hLm).setText(R.l.backup_pc_recover_transfer_finish);
          BackupPcUI.d(this.hLm).setText(R.l.backup_pc_recover_transfer_finish_tip);
          BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_status_content));
          BackupPcUI.e(this.hLm).setText(R.l.backup_pc_recover_start_merge);
          BackupPcUI.f(this.hLm).setText(R.l.backup_pc_recover_stop_recover);
          BackupPcUI.h(this.hLm).setText(R.l.backup_remind_later);
          BackupPcUI.d(this.hLm).setVisibility(0);
          BackupPcUI.e(this.hLm).setVisibility(0);
          BackupPcUI.f(this.hLm).setVisibility(0);
          BackupPcUI.e(this.hLm).setOnClickListener(new BackupPcUI.3.12(this));
          BackupPcUI.f(this.hLm).setOnClickListener(new BackupPcUI.3.13(this));
          BackupPcUI.h(this.hLm).setOnClickListener(new BackupPcUI.3.14(this));
          return;
        }
      } while (!bk.bU(this.hLm));
      b.auw().auz();
      if (!d.atX())
      {
        b.auw().atn().hFu = -22;
        nt(-22);
        com.tencent.mm.plugin.report.service.h.nFQ.a(400L, 64L, 1L, false);
        return;
      }
      b.auw().auz().atF();
      return;
    case 26: 
      BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_recover_icon);
      BackupPcUI.c(this.hLm).setText(this.hLm.getString(R.l.backup_pc_recover_merging, new Object[] { Integer.valueOf(((e)localObject).hFx) }));
      BackupPcUI.d(this.hLm).setText(R.l.backup_pc_recover_merge_tip);
      BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_status_content));
      BackupPcUI.h(this.hLm).setText(R.l.backup_pc_recover_stop_recover);
      BackupPcUI.d(this.hLm).setVisibility(0);
      BackupPcUI.e(this.hLm).setVisibility(4);
      BackupPcUI.f(this.hLm).setVisibility(4);
      auq();
      return;
    case 30: 
      BackupPcUI.b(this.hLm).setImageResource(R.k.backup_move_recover);
      BackupPcUI.c(this.hLm).setText(R.l.backup_recover_merge_building);
      BackupPcUI.d(this.hLm).setText(R.l.backup_move_recover_merging_tip);
      BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_status_content));
      BackupPcUI.d(this.hLm).setVisibility(0);
      BackupPcUI.e(this.hLm).setVisibility(4);
      BackupPcUI.f(this.hLm).setVisibility(4);
      auq();
      return;
    case 27: 
      BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_recover_finished);
      BackupPcUI.c(this.hLm).setText(R.l.backup_pc_recover_merge_finish);
      BackupPcUI.d(this.hLm).setText(this.hLm.getString(R.l.backup_pc_recover_merge_finish_detail, new Object[] { Integer.valueOf(((e)localObject).hFv), Integer.valueOf(((e)localObject).hFw) }));
      BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_status_content));
      BackupPcUI.e(this.hLm).setText(R.l.backup_finish);
      BackupPcUI.d(this.hLm).setVisibility(0);
      BackupPcUI.e(this.hLm).setVisibility(0);
      BackupPcUI.f(this.hLm).setVisibility(4);
      BackupPcUI.e(this.hLm).setOnClickListener(new BackupPcUI.3.15(this));
      auq();
      return;
    case 4: 
      switch (i)
      {
      }
      for (;;)
      {
        BackupPcUI.d(this.hLm).setText(R.l.backup_pc_transfer_weak_network);
        BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_red));
        BackupPcUI.d(this.hLm).setVisibility(0);
        BackupPcUI.e(this.hLm).setVisibility(4);
        BackupPcUI.f(this.hLm).setVisibility(4);
        aus();
        return;
        BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_icon);
        localTextView = BackupPcUI.c(this.hLm);
        localBackupPcUI = this.hLm;
        paramInt = R.l.backup_pc_transfer;
        i = ((e)localObject).hFv;
        j = ((e)localObject).hFw;
        b.auw().aux();
        localTextView.setText(localBackupPcUI.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.auC() }));
        continue;
        BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_recover_icon);
        localTextView = BackupPcUI.c(this.hLm);
        localBackupPcUI = this.hLm;
        paramInt = R.l.backup_pc_recover_transfer;
        i = ((e)localObject).hFv;
        j = ((e)localObject).hFw;
        b.auw().aux();
        localTextView.setText(localBackupPcUI.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.auC() }));
      }
    case 5: 
      switch (i)
      {
      }
      for (;;)
      {
        BackupPcUI.d(this.hLm).setText(R.l.backup_pc_transfer_reconnecting);
        BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_red));
        BackupPcUI.d(this.hLm).setVisibility(0);
        BackupPcUI.e(this.hLm).setVisibility(4);
        BackupPcUI.f(this.hLm).setVisibility(0);
        aus();
        return;
        BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_icon);
        localTextView = BackupPcUI.c(this.hLm);
        localBackupPcUI = this.hLm;
        paramInt = R.l.backup_pc_transfer;
        i = ((e)localObject).hFv;
        j = ((e)localObject).hFw;
        b.auw().aux();
        localTextView.setText(localBackupPcUI.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.auC() }));
        BackupPcUI.f(this.hLm).setText(R.l.backup_pc_stop_backup);
        BackupPcUI.f(this.hLm).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            com.tencent.mm.ui.base.h.a(BackupPcUI.3.this.hLm, R.l.backup_pc_error_alert_stop_backup_tip, R.l.backup_pc_error_alert_stop_backup, R.l.backup_pc_stop_backup, R.l.backup_cancel, false, new BackupPcUI.3.16.1(this), null, R.e.backup_red);
          }
        });
        continue;
        BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_recover_icon);
        localTextView = BackupPcUI.c(this.hLm);
        localBackupPcUI = this.hLm;
        paramInt = R.l.backup_pc_recover_transfer;
        i = ((e)localObject).hFv;
        j = ((e)localObject).hFw;
        b.auw().aux();
        localTextView.setText(localBackupPcUI.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.auC() }));
        BackupPcUI.f(this.hLm).setText(R.l.backup_pc_stop_transfer);
        BackupPcUI.f(this.hLm).setOnClickListener(new BackupPcUI.3.2(this));
      }
    case -4: 
      if ((1 == i) || (3 == i))
      {
        BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_error);
        BackupPcUI.c(this.hLm).setText(this.hLm.getString(R.l.backup_pc_transfer, new Object[] { Integer.valueOf(((e)localObject).hFv), Integer.valueOf(((e)localObject).hFw), "0M" }));
        BackupPcUI.d(this.hLm).setText(R.l.backup_pc_error_network_disconnect);
        BackupPcUI.f(this.hLm).setText(R.l.backup_pc_stop_backup);
        BackupPcUI.f(this.hLm).setOnClickListener(new BackupPcUI.3.3(this));
      }
      for (;;)
      {
        BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_red));
        BackupPcUI.d(this.hLm).setVisibility(0);
        BackupPcUI.e(this.hLm).setVisibility(4);
        BackupPcUI.f(this.hLm).setVisibility(0);
        aus();
        return;
        if ((2 == i) || (4 == i))
        {
          BackupPcUI.b(this.hLm).setImageResource(R.k.backup_pc_recover_error);
          BackupPcUI.c(this.hLm).setText(this.hLm.getString(R.l.backup_pc_recover_transfer, new Object[] { Integer.valueOf(((e)localObject).hFv), Integer.valueOf(((e)localObject).hFw), "0M" }));
          BackupPcUI.d(this.hLm).setText(R.l.backup_pc_error_recover_network_disconnect);
          BackupPcUI.f(this.hLm).setText(R.l.backup_pc_stop_transfer);
          BackupPcUI.f(this.hLm).setOnClickListener(new BackupPcUI.3.4(this));
        }
      }
    case -2: 
    case -1: 
      nE(i);
      BackupPcUI.c(this.hLm).setText(R.l.backup_pc_error_not_same_wifi);
      localObject = g.cM(this.hLm);
      if ((localObject == null) || (((String)localObject).equals(""))) {
        BackupPcUI.d(this.hLm).setText(this.hLm.getString(R.l.backup_pc_error_not_same_wifi_wifiname, new Object[] { b.auw().aux().hKy, "移动网络" }));
      }
      for (;;)
      {
        BackupPcUI.d(this.hLm).setTextColor(this.hLm.getResources().getColor(R.e.backup_red));
        BackupPcUI.f(this.hLm).setText(R.l.backup_pc_error_see_connect_details);
        BackupPcUI.d(this.hLm).setVisibility(0);
        BackupPcUI.e(this.hLm).setVisibility(4);
        BackupPcUI.f(this.hLm).setVisibility(0);
        BackupPcUI.f(this.hLm).setOnClickListener(new BackupPcUI.3.5(this));
        auq();
        return;
        BackupPcUI.d(this.hLm).setText(this.hLm.getString(R.l.backup_pc_error_not_same_wifi_wifiname, new Object[] { b.auw().aux().hKy, localObject }));
      }
    case -3: 
      nE(i);
      BackupPcUI.c(this.hLm).setText(R.l.backup_pc_error_complex_wifi);
      BackupPcUI.f(this.hLm).setText(R.l.backup_pc_error_see_connect_details);
      BackupPcUI.d(this.hLm).setVisibility(4);
      BackupPcUI.e(this.hLm).setVisibility(4);
      BackupPcUI.f(this.hLm).setVisibility(0);
      BackupPcUI.f(this.hLm).setOnClickListener(new BackupPcUI.3.6(this));
      auq();
      return;
    case -5: 
      nE(i);
      BackupPcUI.c(this.hLm).setText(R.l.backup_pc_error_connect_fail);
      BackupPcUI.d(this.hLm).setVisibility(4);
      BackupPcUI.e(this.hLm).setVisibility(4);
      BackupPcUI.f(this.hLm).setVisibility(4);
      auq();
      return;
    case -21: 
      nE(i);
      BackupPcUI.c(this.hLm).setText(R.l.backup_pc_error_programme_error);
      BackupPcUI.d(this.hLm).setVisibility(4);
      BackupPcUI.e(this.hLm).setVisibility(4);
      BackupPcUI.f(this.hLm).setVisibility(4);
      auq();
      return;
    case -13: 
      nE(i);
      BackupPcUI.c(this.hLm).setText(R.l.backup_pc_error_not_enough_space_for_recover);
      b.auw().atT().stop();
      BackupPcUI.d(this.hLm).setVisibility(4);
      BackupPcUI.e(this.hLm).setVisibility(4);
      BackupPcUI.f(this.hLm).setVisibility(4);
      auq();
      return;
    case -22: 
      nE(i);
      BackupPcUI.c(this.hLm).setText(R.l.backup_pc_error_miss_recover_merge_data);
      b.auw().atT().stop();
      BackupPcUI.d(this.hLm).setVisibility(4);
      BackupPcUI.e(this.hLm).setVisibility(4);
      BackupPcUI.f(this.hLm).setVisibility(4);
      auq();
      return;
    }
    nE(i);
    BackupPcUI.c(this.hLm).setText(R.l.backup_pc_error_empty_records);
    BackupPcUI.d(this.hLm).setVisibility(4);
    BackupPcUI.e(this.hLm).setVisibility(4);
    BackupPcUI.f(this.hLm).setVisibility(4);
    auq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3
 * JD-Core Version:    0.7.0.1
 */