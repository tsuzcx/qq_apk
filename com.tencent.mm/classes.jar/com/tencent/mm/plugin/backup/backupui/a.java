package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bb;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  private static String TAG = "MicroMsg.BackupChatBanner";
  private TextView titleTv;
  private View vdX;
  private View vdY;
  private int vdZ;
  private int vea;
  private b.a veb;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21770);
    this.vdX = null;
    this.titleTv = null;
    this.vdZ = 100;
    this.vea = 100;
    this.veb = new a(this);
    Log.i(TAG, "new BackupChatBanner.");
    com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = -100;
    com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = -100;
    this.titleTv = ((TextView)this.view.findViewById(R.h.ftq));
    this.vdX = this.view.findViewById(R.h.fto);
    this.vdY = this.view.findViewById(R.h.banner_root);
    bh.bCz();
    boolean bool1 = ((Boolean)com.tencent.mm.model.c.ban().get(at.a.acOZ, Boolean.FALSE)).booleanValue();
    bh.bCz();
    boolean bool2 = ((Boolean)com.tencent.mm.model.c.ban().get(at.a.acPc, Boolean.FALSE)).booleanValue();
    Log.i(TAG, "initialize, isPcMerging:%s, isMoveMerging:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ();
      if (com.tencent.mm.plugin.backup.backuppcmodel.d.cVx())
      {
        com.tencent.mm.plugin.backup.b.d.Fd(1);
        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 24;
      }
    }
    for (;;)
    {
      if (this.view != null)
      {
        this.vdX = this.view.findViewById(R.h.fto);
        this.vdX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(300672);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupui/BackupChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            int i = com.tencent.mm.plugin.backup.b.d.cUM();
            Log.i(a.TAG, "backupbanner onclick, backupMode[%d]", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupui/BackupChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(300672);
              return;
              i = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg;
              Log.i(a.TAG, "backupbanner onclick, backupPcState[%d]", new Object[] { Integer.valueOf(i) });
              switch (i)
              {
              default: 
                Log.i(a.TAG, "click backup banner, BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg) });
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
                Log.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg) });
                a.a(a.this, false);
                break;
              case 24: 
              case 25: 
                Log.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg) });
                a.a(a.this, true);
                continue;
                i = com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg;
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
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().vbK = this.veb;
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().vbK = this.veb;
      com.tencent.mm.plugin.backup.d.b.cVs().cVv().uYX = this.veb;
      paramContext = MultiProcessMMKV.getMMKV("MMKV_BACKUP");
      bool1 = paramContext.getBoolean("MMKV_BACKUP_NEED_REPORT", false);
      int i = paramContext.getInt("MMKV_BACKUP_TRY_TIME", 0);
      if ((bool1) && (i > 0)) {
        h.ahAA.bm(new a.1(this, paramContext, i));
      }
      AppMethodBeat.o(21770);
      return;
      if (bool2)
      {
        com.tencent.mm.plugin.backup.d.b.cVs().cVv();
        if (com.tencent.mm.plugin.backup.d.c.cVx())
        {
          com.tencent.mm.plugin.backup.b.d.Fd(22);
          com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = 24;
        }
      }
    }
  }
  
  private boolean Ft(int paramInt)
  {
    AppMethodBeat.i(21774);
    if ((paramInt != -100) || (paramInt != this.vdZ)) {
      Log.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.b.d.cUM()), Integer.valueOf(paramInt) });
    }
    e locale = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ();
    TextView localTextView;
    Context localContext;
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      if (paramInt == this.vdZ)
      {
        AppMethodBeat.o(21774);
        return true;
      }
      break;
    case 14: 
      this.vdX.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_display_mobile, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
      localTextView = (TextView)this.view.findViewById(R.h.ftq);
      localContext = MMApplicationContext.getContext();
      paramInt = R.l.guO;
      i = locale.uWh;
      j = locale.uWi;
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX();
      localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cWc() }));
      AppMethodBeat.o(21774);
      return true;
    case 23: 
      this.vdX.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_display_mobile, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
      localTextView = (TextView)this.view.findViewById(R.h.ftq);
      localContext = MMApplicationContext.getContext();
      paramInt = R.l.guA;
      i = locale.uWh;
      j = locale.uWi;
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX();
      localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cWc() }));
      AppMethodBeat.o(21774);
      return true;
    case 4: 
    case 5: 
      this.vdX.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw))
      {
        ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_display_mobile, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
        localTextView = (TextView)this.view.findViewById(R.h.ftq);
        localContext = MMApplicationContext.getContext();
        paramInt = R.l.guO;
        i = locale.uWh;
        j = locale.uWi;
        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX();
        localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cWc() }));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw))
        {
          ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_display_mobile, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
          localTextView = (TextView)this.view.findViewById(R.h.ftq);
          localContext = MMApplicationContext.getContext();
          paramInt = R.l.guA;
          i = locale.uWh;
          j = locale.uWi;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX();
          localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cWc() }));
        }
      }
    }
    this.vdZ = paramInt;
    switch (paramInt)
    {
    default: 
      this.vdX.setVisibility(8);
      AppMethodBeat.o(21774);
      return false;
    case 12: 
    case 22: 
      this.vdX.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw)) {
        ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_display_mobile, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
      }
      for (;;)
      {
        ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.guq));
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw)) {
          ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_display_mobile, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
        }
      }
    case 15: 
      this.vdX.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_display_mobile, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
      ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gtL));
      AppMethodBeat.o(21774);
      return true;
    case 25: 
      this.vdX.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_display_mobile, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
      ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.guC));
      AppMethodBeat.o(21774);
      return true;
    case 24: 
      md(true);
      AppMethodBeat.o(21774);
      return true;
    case -4: 
    case 28: 
      this.vdX.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw))
      {
        ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_display_mobile, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
        ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gtY));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw))
        {
          ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_display_mobile, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
          ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gtZ));
        }
      }
    }
    this.vdX.setVisibility(8);
    if (Util.isTopActivity((Context)this.Ydi.get())) {
      md(true);
    }
    AppMethodBeat.o(21774);
    return true;
  }
  
  private boolean Fu(int paramInt)
  {
    AppMethodBeat.i(21775);
    if ((paramInt != -100) || (paramInt != this.vea)) {
      Log.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.b.d.cUM()), Integer.valueOf(paramInt) });
    }
    e locale = com.tencent.mm.plugin.backup.d.b.cVs().cUJ();
    switch (paramInt)
    {
    default: 
      if (paramInt == this.vea)
      {
        AppMethodBeat.o(21775);
        return true;
      }
      break;
    case 4: 
    case 5: 
    case 23: 
      this.vdX.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_migration_recieve, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
      TextView localTextView = (TextView)this.view.findViewById(R.h.ftq);
      Context localContext = MMApplicationContext.getContext();
      paramInt = R.l.gtx;
      int i = locale.uWh;
      int j = locale.uWi;
      com.tencent.mm.plugin.backup.d.b.cVs().cVv();
      localTextView.setText(localContext.getString(paramInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.d.c.cVB() }));
      AppMethodBeat.o(21775);
      return true;
    }
    this.vea = paramInt;
    switch (paramInt)
    {
    default: 
      this.vdX.setVisibility(8);
      AppMethodBeat.o(21775);
      return false;
    case 22: 
      this.vdX.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_migration_recieve, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
      ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gts));
      AppMethodBeat.o(21775);
      return true;
    case 25: 
      this.vdX.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_migration_recieve, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
      ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gtz));
      AppMethodBeat.o(21775);
      return true;
    case 24: 
    case 52: 
      if (Util.isTopActivity((Context)this.Ydi.get())) {
        me(true);
      }
      AppMethodBeat.o(21775);
      return true;
    case -4: 
    case 28: 
      this.vdX.setVisibility(0);
      ((ImageView)this.view.findViewById(R.h.ftp)).setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_outlined_migration_recieve, ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50)));
      ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gsE));
      AppMethodBeat.o(21775);
      return true;
    }
    this.vdX.setVisibility(8);
    if (Util.isTopActivity((Context)this.Ydi.get())) {
      me(true);
    }
    AppMethodBeat.o(21775);
    return true;
  }
  
  private void md(boolean paramBoolean)
  {
    AppMethodBeat.i(21771);
    Log.i(TAG, "jumpToBackupPcUI");
    if (Util.isTopActivity((Context)this.Ydi.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.Ydi.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.aQ((Context)this.Ydi.get(), localIntent);
    }
    AppMethodBeat.o(21771);
  }
  
  private void me(boolean paramBoolean)
  {
    AppMethodBeat.i(21772);
    Log.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (Util.isTopActivity((Context)this.Ydi.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.Ydi.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.aQ((Context)this.Ydi.get(), localIntent);
    }
    AppMethodBeat.o(21772);
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(21773);
    if ((this.isFirst) && (this.nzL))
    {
      this.vdY.setBackgroundResource(R.g.tips_bar_white_selector);
      this.vdX.setBackground(null);
      this.titleTv.setBackground(null);
    }
    for (;;)
    {
      switch (com.tencent.mm.plugin.backup.b.d.cUM())
      {
      default: 
        this.vdX.setVisibility(8);
        AppMethodBeat.o(21773);
        return false;
        if (this.isFirst)
        {
          this.vdY.setBackgroundResource(R.g.list_item_top_selector);
          this.vdX.setBackgroundResource(R.g.list_item_top_normal);
          this.titleTv.setBackgroundResource(R.g.list_item_normal);
        }
        else if (this.nzL)
        {
          this.vdY.setBackgroundResource(R.g.list_item_top_selector);
          this.vdX.setBackgroundResource(R.g.list_item_normal);
          this.titleTv.setBackground(null);
        }
        else
        {
          this.vdY.setBackgroundResource(R.g.list_item_top_selector);
          this.vdX.setBackground(null);
          this.titleTv.setBackgroundResource(R.g.list_item_normal);
        }
        break;
      }
    }
    boolean bool = Ft(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg);
    AppMethodBeat.o(21773);
    return bool;
    bool = Fu(com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg);
    AppMethodBeat.o(21773);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.fto;
  }
  
  public final int getOrder()
  {
    return 3;
  }
  
  static final class a
    implements b.a
  {
    private final WeakReference<a> vef;
    
    a(a parama)
    {
      AppMethodBeat.i(21768);
      this.vef = new WeakReference(parama);
      AppMethodBeat.o(21768);
    }
    
    public final void Fb(int paramInt)
    {
      AppMethodBeat.i(21769);
      a locala = (a)this.vef.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a
 * JD-Core Version:    0.7.0.1
 */