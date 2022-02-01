package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.au;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private static String TAG = "MicroMsg.BackupChatBanner";
  private View rSI;
  private View rSJ;
  private int rSK;
  private int rSL;
  private b.a rSM;
  private TextView titleTv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21770);
    this.rSI = null;
    this.titleTv = null;
    this.rSK = 100;
    this.rSL = 100;
    this.rSM = new a(this);
    Log.i(TAG, "new BackupChatBanner.");
    com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = -100;
    com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = -100;
    this.titleTv = ((TextView)this.view.findViewById(R.h.dsZ));
    this.rSI = this.view.findViewById(R.h.dsX);
    this.rSJ = this.view.findViewById(R.h.banner_root);
    bh.beI();
    boolean bool1 = ((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VnE, Boolean.FALSE)).booleanValue();
    bh.beI();
    boolean bool2 = ((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VnH, Boolean.FALSE)).booleanValue();
    Log.i(TAG, "initialize, isPcMerging:%s, isMoveMerging:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp();
      if (com.tencent.mm.plugin.backup.backuppcmodel.d.csN())
      {
        com.tencent.mm.plugin.backup.b.d.EC(1);
        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 24;
      }
    }
    for (;;)
    {
      if (this.view != null)
      {
        this.rSI = this.view.findViewById(R.h.dsX);
        this.rSI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(269409);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupui/BackupChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            int i = com.tencent.mm.plugin.backup.b.d.csc();
            Log.i(a.TAG, "backupbanner onclick, backupMode[%d]", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupui/BackupChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(269409);
              return;
              i = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS;
              Log.i(a.TAG, "backupbanner onclick, backupPcState[%d]", new Object[] { Integer.valueOf(i) });
              switch (i)
              {
              default: 
                Log.i(a.TAG, "click backup banner, BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS) });
                break;
              case -4: 
              case 4: 
              case 5: 
              case 12: 
              case 14: 
              case 15: 
              case 22: 
              case 23: 
              case 28: 
                Log.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS) });
                a.a(a.this, false);
                break;
              case 24: 
              case 25: 
                Log.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS) });
                a.a(a.this, true);
                continue;
                i = com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS;
                Log.i(a.TAG, "backupbanner onclick, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
                switch (i)
                {
                default: 
                  Log.i(a.TAG, "click backup banner,backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
                  break;
                case -4: 
                case 4: 
                case 5: 
                case 12: 
                case 22: 
                case 23: 
                case 28: 
                case 52: 
                  Log.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
                  a.b(a.this, false);
                  break;
                case 24: 
                case 25: 
                  Log.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
                  a.b(a.this, true);
                }
                break;
              }
            }
          }
        });
      }
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().rQv = this.rSM;
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().rQv = this.rSM;
      com.tencent.mm.plugin.backup.d.b.csI().csL().rNJ = this.rSM;
      paramContext = MultiProcessMMKV.getMMKV("MMKV_BACKUP");
      bool1 = paramContext.getBoolean("MMKV_BACKUP_NEED_REPORT", false);
      int i = paramContext.getInt("MMKV_BACKUP_TRY_TIME", 0);
      if ((bool1) && (i > 0)) {
        h.ZvG.be(new a.1(this, paramContext, i));
      }
      AppMethodBeat.o(21770);
      return;
      if (bool2)
      {
        com.tencent.mm.plugin.backup.d.b.csI().csL();
        if (com.tencent.mm.plugin.backup.d.c.csN())
        {
          com.tencent.mm.plugin.backup.b.d.EC(22);
          com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = 24;
        }
      }
    }
  }
  
  private boolean ES(int paramInt)
  {
    AppMethodBeat.i(21774);
    if ((paramInt != -100) || (paramInt != this.rSK)) {
      Log.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.b.d.csc()), Integer.valueOf(paramInt) });
    }
    e locale = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ();
    TextView localTextView;
    Context localContext;
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      if (paramInt == this.rSK)
      {
        AppMethodBeat.o(21774);
        return true;
      }
      break;
    case 14: 
      this.rSI.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_display_mobile, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
      localTextView = (TextView)this.view.findViewById(R.h.dsZ);
      localContext = MMApplicationContext.getContext();
      paramInt = R.l.erN;
      i = locale.rKT;
      j = locale.rKU;
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn();
      localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cts() }));
      AppMethodBeat.o(21774);
      return true;
    case 23: 
      this.rSI.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_display_mobile, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
      localTextView = (TextView)this.view.findViewById(R.h.dsZ);
      localContext = MMApplicationContext.getContext();
      paramInt = R.l.erz;
      i = locale.rKT;
      j = locale.rKU;
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn();
      localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cts() }));
      AppMethodBeat.o(21774);
      return true;
    case 4: 
    case 5: 
      this.rSI.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh))
      {
        ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_display_mobile, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
        localTextView = (TextView)this.view.findViewById(R.h.dsZ);
        localContext = MMApplicationContext.getContext();
        paramInt = R.l.erN;
        i = locale.rKT;
        j = locale.rKU;
        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn();
        localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cts() }));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh))
        {
          ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_display_mobile, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
          localTextView = (TextView)this.view.findViewById(R.h.dsZ);
          localContext = MMApplicationContext.getContext();
          paramInt = R.l.erz;
          i = locale.rKT;
          j = locale.rKU;
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn();
          localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cts() }));
        }
      }
    }
    this.rSK = paramInt;
    switch (paramInt)
    {
    default: 
      this.rSI.setVisibility(8);
      AppMethodBeat.o(21774);
      return false;
    case 12: 
    case 22: 
      this.rSI.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh)) {
        ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_display_mobile, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
      }
      for (;;)
      {
        ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.erp));
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh)) {
          ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_display_mobile, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
        }
      }
    case 15: 
      this.rSI.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_display_mobile, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
      ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.eqK));
      AppMethodBeat.o(21774);
      return true;
    case 25: 
      this.rSI.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_display_mobile, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
      ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.erB));
      AppMethodBeat.o(21774);
      return true;
    case 24: 
      kQ(true);
      AppMethodBeat.o(21774);
      return true;
    case -4: 
    case 28: 
      this.rSI.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh))
      {
        ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_display_mobile, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
        ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.eqX));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh))
        {
          ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_display_mobile, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
          ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.eqY));
        }
      }
    }
    this.rSI.setVisibility(8);
    if (Util.isTopActivity((Context)this.Rhc.get())) {
      kQ(true);
    }
    AppMethodBeat.o(21774);
    return true;
  }
  
  private boolean ET(int paramInt)
  {
    AppMethodBeat.i(21775);
    if ((paramInt != -100) || (paramInt != this.rSL)) {
      Log.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.b.d.csc()), Integer.valueOf(paramInt) });
    }
    e locale = com.tencent.mm.plugin.backup.d.b.csI().crZ();
    switch (paramInt)
    {
    default: 
      if (paramInt == this.rSL)
      {
        AppMethodBeat.o(21775);
        return true;
      }
      break;
    case 4: 
    case 5: 
    case 23: 
      this.rSI.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_migration_recieve, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
      TextView localTextView = (TextView)this.view.findViewById(R.h.dsZ);
      Context localContext = MMApplicationContext.getContext();
      paramInt = R.l.eqw;
      int i = locale.rKT;
      int j = locale.rKU;
      com.tencent.mm.plugin.backup.d.b.csI().csL();
      localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.d.c.csR() }));
      AppMethodBeat.o(21775);
      return true;
    }
    this.rSL = paramInt;
    switch (paramInt)
    {
    default: 
      this.rSI.setVisibility(8);
      AppMethodBeat.o(21775);
      return false;
    case 22: 
      this.rSI.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_migration_recieve, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
      ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.eqr));
      AppMethodBeat.o(21775);
      return true;
    case 25: 
      this.rSI.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_migration_recieve, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
      ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.eqy));
      AppMethodBeat.o(21775);
      return true;
    case 24: 
    case 52: 
      if (Util.isTopActivity((Context)this.Rhc.get())) {
        kR(true);
      }
      AppMethodBeat.o(21775);
      return true;
    case -4: 
    case 28: 
      this.rSI.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.dsY)).setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_outlined_migration_recieve, ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50)));
      ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.epD));
      AppMethodBeat.o(21775);
      return true;
    }
    this.rSI.setVisibility(8);
    if (Util.isTopActivity((Context)this.Rhc.get())) {
      kR(true);
    }
    AppMethodBeat.o(21775);
    return true;
  }
  
  private void kQ(boolean paramBoolean)
  {
    AppMethodBeat.i(21771);
    Log.i(TAG, "jumpToBackupPcUI");
    if (Util.isTopActivity((Context)this.Rhc.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.Rhc.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.aH((Context)this.Rhc.get(), localIntent);
    }
    AppMethodBeat.o(21771);
  }
  
  private void kR(boolean paramBoolean)
  {
    AppMethodBeat.i(21772);
    Log.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (Util.isTopActivity((Context)this.Rhc.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.Rhc.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.aH((Context)this.Rhc.get(), localIntent);
    }
    AppMethodBeat.o(21772);
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(21773);
    if ((this.isFirst) && (this.kUc))
    {
      this.rSJ.setBackgroundResource(R.g.tips_bar_white_selector);
      this.rSI.setBackground(null);
      this.titleTv.setBackground(null);
    }
    for (;;)
    {
      switch (com.tencent.mm.plugin.backup.b.d.csc())
      {
      default: 
        this.rSI.setVisibility(8);
        AppMethodBeat.o(21773);
        return false;
        if (this.isFirst)
        {
          this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
          this.rSI.setBackgroundResource(R.g.list_item_top_normal);
          this.titleTv.setBackgroundResource(R.g.list_item_normal);
        }
        else if (this.kUc)
        {
          this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
          this.rSI.setBackgroundResource(R.g.list_item_normal);
          this.titleTv.setBackground(null);
        }
        else
        {
          this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
          this.rSI.setBackground(null);
          this.titleTv.setBackgroundResource(R.g.list_item_normal);
        }
        break;
      }
    }
    boolean bool = ES(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS);
    AppMethodBeat.o(21773);
    return bool;
    bool = ET(com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS);
    AppMethodBeat.o(21773);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.dsX;
  }
  
  public final int getOrder()
  {
    return 3;
  }
  
  static final class a
    implements b.a
  {
    private final WeakReference<a> rSQ;
    
    a(a parama)
    {
      AppMethodBeat.i(21768);
      this.rSQ = new WeakReference(parama);
      AppMethodBeat.o(21768);
    }
    
    public final void EA(int paramInt)
    {
      AppMethodBeat.i(21769);
      a locala = (a)this.rSQ.get();
      if (locala != null)
      {
        a.a(locala, paramInt);
        AppMethodBeat.o(21769);
        return;
      }
      Log.e(a.TAG, "BackupChatBanner WeakReference is null!");
      AppMethodBeat.o(21769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a
 * JD-Core Version:    0.7.0.1
 */