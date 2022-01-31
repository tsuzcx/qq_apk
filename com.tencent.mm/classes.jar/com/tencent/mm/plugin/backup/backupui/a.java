package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private static String TAG = "MicroMsg.BackupChatBanner";
  private View hNa = null;
  private int hNb = 100;
  private int hNc = 100;
  private b.a hNd = new a.a(this);
  
  public a(Context paramContext)
  {
    super(paramContext);
    y.i(TAG, "BackupChatBanner.");
    com.tencent.mm.plugin.backup.backuppcmodel.b.auw().atn().hFu = -100;
    com.tencent.mm.plugin.backup.d.b.atS().atn().hFu = -100;
    y.i(TAG, "initialize");
    if (this.view != null)
    {
      this.hNa = this.view.findViewById(R.h.bakchat_banner_view);
      this.hNa.setOnClickListener(new a.1(this));
    }
    apu();
    com.tencent.mm.plugin.backup.backuppcmodel.b.auw().auy().hKK = this.hNd;
    com.tencent.mm.plugin.backup.backuppcmodel.b.auw().auz().hKK = this.hNd;
    com.tencent.mm.plugin.backup.d.b.atS().atV().hHM = this.hNd;
  }
  
  private void eh(boolean paramBoolean)
  {
    y.i(TAG, "jumpToBackupPcUI");
    if (bk.bU((Context)this.sdy.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.sdy.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.C((Context)this.sdy.get(), localIntent);
    }
  }
  
  private void ei(boolean paramBoolean)
  {
    y.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (bk.bU((Context)this.sdy.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.sdy.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.C((Context)this.sdy.get(), localIntent);
    }
  }
  
  private boolean nK(int paramInt)
  {
    if ((paramInt != -100) || (paramInt != this.hNb))
    {
      y.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", new Object[] { Integer.valueOf(d.atq()), Integer.valueOf(paramInt) });
      this.hNb = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.backuppcmodel.b.auw().atn();
    TextView localTextView;
    Context localContext;
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      this.hNa.setVisibility(8);
      return false;
    case 12: 
    case 22: 
      this.hNa.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx)) {
        ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_banner);
      }
      for (;;)
      {
        ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.backup_pc_prepare));
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx)) {
          ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_recover_banner);
        }
      }
    case 14: 
      this.hNa.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_banner);
      localTextView = (TextView)this.view.findViewById(R.h.bakchat_info);
      localContext = ae.getContext();
      paramInt = R.l.backup_pc_transfer;
      i = locale.hFv;
      j = locale.hFw;
      com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux();
      localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.auC() }));
      return true;
    case 15: 
      this.hNa.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_banner);
      ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.backup_pc_backup_finish));
      return true;
    case 23: 
      this.hNa.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_recover_banner);
      localTextView = (TextView)this.view.findViewById(R.h.bakchat_info);
      localContext = ae.getContext();
      paramInt = R.l.backup_pc_recover_transfer;
      i = locale.hFv;
      j = locale.hFw;
      com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux();
      localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.auC() }));
      return true;
    case 25: 
      this.hNa.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_recover_banner);
      ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.backup_pc_recover_transfer_finish_start_merge));
      return true;
    case 24: 
      eh(true);
      return true;
    case 4: 
    case 5: 
      this.hNa.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx))
      {
        ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_banner);
        localTextView = (TextView)this.view.findViewById(R.h.bakchat_info);
        localContext = ae.getContext();
        paramInt = R.l.backup_pc_transfer;
        i = locale.hFv;
        j = locale.hFw;
        com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux();
        localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.auC() }));
      }
      for (;;)
      {
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx))
        {
          ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_recover_banner);
          localTextView = (TextView)this.view.findViewById(R.h.bakchat_info);
          localContext = ae.getContext();
          paramInt = R.l.backup_pc_recover_transfer;
          i = locale.hFv;
          j = locale.hFw;
          com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux();
          localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.auC() }));
        }
      }
    case -4: 
    case 28: 
      this.hNa.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx))
      {
        ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_banner);
        ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.backup_pc_error_banner_disconnect));
      }
      for (;;)
      {
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.auw().aux().hKx))
        {
          ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_recover_banner);
          ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.backup_pc_error_banner_recover_disconnect));
        }
      }
    }
    this.hNa.setVisibility(8);
    if (bk.bU((Context)this.sdy.get())) {
      eh(true);
    }
    return true;
  }
  
  private boolean nL(int paramInt)
  {
    if ((paramInt != -100) || (paramInt != this.hNc))
    {
      y.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", new Object[] { Integer.valueOf(d.atq()), Integer.valueOf(paramInt) });
      this.hNc = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.d.b.atS().atn();
    switch (paramInt)
    {
    default: 
      this.hNa.setVisibility(8);
      return false;
    case 22: 
      this.hNa.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_move_banner);
      ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.backup_move_recover_preparing));
      return true;
    case 4: 
    case 5: 
    case 23: 
      this.hNa.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_move_banner);
      TextView localTextView = (TextView)this.view.findViewById(R.h.bakchat_info);
      Context localContext = ae.getContext();
      paramInt = R.l.backup_move_recover_transfer;
      int i = locale.hFv;
      int j = locale.hFw;
      com.tencent.mm.plugin.backup.d.b.atS().atV();
      localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.d.c.aub() }));
      return true;
    case 25: 
      this.hNa.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_move_banner);
      ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.backup_move_recover_transfer_finish_start_merge));
      return true;
    case 24: 
    case 52: 
      if (bk.bU((Context)this.sdy.get())) {
        ei(true);
      }
      return true;
    case -4: 
    case 28: 
      this.hNa.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_move_banner);
      ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.backup_move_error_banner_recover_disconnect));
      return true;
    }
    this.hNa.setVisibility(8);
    if (bk.bU((Context)this.sdy.get())) {
      ei(true);
    }
    return true;
  }
  
  public final boolean apu()
  {
    switch ()
    {
    default: 
      this.hNa.setVisibility(8);
      return false;
    case 1: 
      return nK(com.tencent.mm.plugin.backup.backuppcmodel.b.auw().atn().hFu);
    }
    return nL(com.tencent.mm.plugin.backup.d.b.atS().atn().hFu);
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.bakchat_banner_view;
  }
  
  public final int getOrder()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a
 * JD-Core Version:    0.7.0.1
 */