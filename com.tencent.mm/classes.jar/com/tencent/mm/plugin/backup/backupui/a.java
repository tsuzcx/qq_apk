package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ar;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private static String TAG = "MicroMsg.BackupChatBanner";
  private View oQL;
  private View oQM;
  private int oQN;
  private int oQO;
  private b.a oQP;
  private TextView titleTv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21770);
    this.oQL = null;
    this.titleTv = null;
    this.oQN = 100;
    this.oQO = 100;
    this.oQP = new a(this);
    Log.i(TAG, "new BackupChatBanner.");
    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
    com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
    Log.i(TAG, "initialize");
    this.titleTv = ((TextView)this.view.findViewById(2131297229));
    this.oQL = this.view.findViewById(2131297227);
    this.oQM = this.view.findViewById(2131297327);
    if (this.view != null)
    {
      this.oQL = this.view.findViewById(2131297227);
      this.oQL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21767);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupui/BackupChatBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          int i = d.ceP();
          Log.i(a.TAG, "backupbanner onclick, backupMode[%d]", new Object[] { Integer.valueOf(i) });
          switch (i)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupui/BackupChatBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21767);
            return;
            i = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc;
            Log.i(a.TAG, "backupbanner onclick, backupPcState[%d]", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            default: 
              Log.i(a.TAG, "click backup banner, BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc) });
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
              Log.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc) });
              a.a(a.this, false);
              break;
            case 24: 
            case 25: 
              Log.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc) });
              a.a(a.this, true);
              continue;
              i = com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc;
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
    bYa();
    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOx = this.oQP;
    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().oOx = this.oQP;
    com.tencent.mm.plugin.backup.d.b.cfv().cfy().oLA = this.oQP;
    AppMethodBeat.o(21770);
  }
  
  private boolean Br(int paramInt)
  {
    AppMethodBeat.i(21774);
    if ((paramInt != -100) || (paramInt != this.oQN))
    {
      Log.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", new Object[] { Integer.valueOf(d.ceP()), Integer.valueOf(paramInt) });
      this.oQN = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM();
    TextView localTextView;
    Context localContext;
    int i;
    switch (paramInt)
    {
    default: 
      this.oQL.setVisibility(8);
      AppMethodBeat.o(21774);
      return false;
    case 12: 
    case 22: 
      this.oQL.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk)) {
        ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690786, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
      }
      for (;;)
      {
        ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756354));
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk)) {
          ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690786, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
        }
      }
    case 14: 
      this.oQL.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690786, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
      localTextView = (TextView)this.view.findViewById(2131297229);
      localContext = MMApplicationContext.getContext();
      paramInt = locale.oJd;
      i = locale.oJe;
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
      localTextView.setText(localContext.getString(2131756383, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.cgg() }));
      AppMethodBeat.o(21774);
      return true;
    case 15: 
      this.oQL.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690786, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
      ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756314));
      AppMethodBeat.o(21774);
      return true;
    case 23: 
      this.oQL.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690786, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
      localTextView = (TextView)this.view.findViewById(2131297229);
      localContext = MMApplicationContext.getContext();
      paramInt = locale.oJd;
      i = locale.oJe;
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
      localTextView.setText(localContext.getString(2131756366, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.cgg() }));
      AppMethodBeat.o(21774);
      return true;
    case 25: 
      this.oQL.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690786, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
      ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756368));
      AppMethodBeat.o(21774);
      return true;
    case 24: 
      jF(true);
      AppMethodBeat.o(21774);
      return true;
    case 4: 
    case 5: 
      this.oQL.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk))
      {
        ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690786, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
        localTextView = (TextView)this.view.findViewById(2131297229);
        localContext = MMApplicationContext.getContext();
        paramInt = locale.oJd;
        i = locale.oJe;
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
        localTextView.setText(localContext.getString(2131756383, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.cgg() }));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk))
        {
          ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690786, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
          localTextView = (TextView)this.view.findViewById(2131297229);
          localContext = MMApplicationContext.getContext();
          paramInt = locale.oJd;
          i = locale.oJe;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
          localTextView.setText(localContext.getString(2131756366, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.cgg() }));
        }
      }
    case -4: 
    case 28: 
      this.oQL.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk))
      {
        ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690786, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
        ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756330));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk))
        {
          ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690786, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
          ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756331));
        }
      }
    }
    this.oQL.setVisibility(8);
    if (Util.isTopActivity((Context)this.Kgr.get())) {
      jF(true);
    }
    AppMethodBeat.o(21774);
    return true;
  }
  
  private boolean Bs(int paramInt)
  {
    AppMethodBeat.i(21775);
    if ((paramInt != -100) || (paramInt != this.oQO))
    {
      Log.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", new Object[] { Integer.valueOf(d.ceP()), Integer.valueOf(paramInt) });
      this.oQO = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.d.b.cfv().ceM();
    switch (paramInt)
    {
    default: 
      this.oQL.setVisibility(8);
      AppMethodBeat.o(21775);
      return false;
    case 22: 
      this.oQL.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690832, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
      ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756289));
      AppMethodBeat.o(21775);
      return true;
    case 4: 
    case 5: 
    case 23: 
      this.oQL.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690832, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
      TextView localTextView = (TextView)this.view.findViewById(2131297229);
      Context localContext = MMApplicationContext.getContext();
      paramInt = locale.oJd;
      int i = locale.oJe;
      com.tencent.mm.plugin.backup.d.b.cfv().cfy();
      localTextView.setText(localContext.getString(2131756294, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.d.c.cfE() }));
      AppMethodBeat.o(21775);
      return true;
    case 25: 
      this.oQL.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690832, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
      ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756296));
      AppMethodBeat.o(21775);
      return true;
    case 24: 
    case 52: 
      if (Util.isTopActivity((Context)this.Kgr.get())) {
        jG(true);
      }
      AppMethodBeat.o(21775);
      return true;
    case -4: 
    case 28: 
      this.oQL.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297228)).setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690832, ((Context)this.Kgr.get()).getResources().getColor(2131099683)));
      ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756246));
      AppMethodBeat.o(21775);
      return true;
    }
    this.oQL.setVisibility(8);
    if (Util.isTopActivity((Context)this.Kgr.get())) {
      jG(true);
    }
    AppMethodBeat.o(21775);
    return true;
  }
  
  private void jF(boolean paramBoolean)
  {
    AppMethodBeat.i(21771);
    Log.i(TAG, "jumpToBackupPcUI");
    if (Util.isTopActivity((Context)this.Kgr.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.Kgr.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.ay((Context)this.Kgr.get(), localIntent);
    }
    AppMethodBeat.o(21771);
  }
  
  private void jG(boolean paramBoolean)
  {
    AppMethodBeat.i(21772);
    Log.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (Util.isTopActivity((Context)this.Kgr.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.Kgr.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.ay((Context)this.Kgr.get(), localIntent);
    }
    AppMethodBeat.o(21772);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(21773);
    if ((this.isFirst) && (this.ifo))
    {
      this.oQM.setBackgroundResource(2131235299);
      this.oQL.setBackground(null);
      this.titleTv.setBackground(null);
    }
    for (;;)
    {
      switch (d.ceP())
      {
      default: 
        this.oQL.setVisibility(8);
        AppMethodBeat.o(21773);
        return false;
        if (this.isFirst)
        {
          this.oQM.setBackgroundResource(2131233332);
          this.oQL.setBackgroundResource(2131233330);
          this.titleTv.setBackgroundResource(2131233327);
        }
        else if (this.ifo)
        {
          this.oQM.setBackgroundResource(2131233332);
          this.oQL.setBackgroundResource(2131233327);
          this.titleTv.setBackground(null);
        }
        else
        {
          this.oQM.setBackgroundResource(2131233332);
          this.oQL.setBackground(null);
          this.titleTv.setBackgroundResource(2131233327);
        }
        break;
      }
    }
    boolean bool = Br(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc);
    AppMethodBeat.o(21773);
    return bool;
    bool = Bs(com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc);
    AppMethodBeat.o(21773);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131493188;
  }
  
  public final int getOrder()
  {
    return 3;
  }
  
  static final class a
    implements b.a
  {
    private final WeakReference<a> oQR;
    
    a(a parama)
    {
      AppMethodBeat.i(21768);
      this.oQR = new WeakReference(parama);
      AppMethodBeat.o(21768);
    }
    
    public final void AZ(int paramInt)
    {
      AppMethodBeat.i(21769);
      a locala = (a)this.oQR.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a
 * JD-Core Version:    0.7.0.1
 */