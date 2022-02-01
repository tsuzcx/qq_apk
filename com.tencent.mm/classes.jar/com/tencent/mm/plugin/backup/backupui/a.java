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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private static String TAG = "MicroMsg.BackupChatBanner";
  private View nFO;
  private View nFP;
  private int nFQ;
  private int nFR;
  private b.a nFS;
  private TextView titleTv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21770);
    this.nFO = null;
    this.titleTv = null;
    this.nFQ = 100;
    this.nFR = 100;
    this.nFS = new a(this);
    ae.i(TAG, "new BackupChatBanner.");
    com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bHV().nye = -100;
    com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = -100;
    ae.i(TAG, "initialize");
    this.titleTv = ((TextView)this.view.findViewById(2131297084));
    this.nFO = this.view.findViewById(2131297082);
    this.nFP = this.view.findViewById(2131297183);
    if (this.view != null)
    {
      this.nFO = this.view.findViewById(2131297082);
      this.nFO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21767);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupui/BackupChatBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          int i = d.bHY();
          ae.i(a.TAG, "backupbanner onclick, backupMode[%d]", new Object[] { Integer.valueOf(i) });
          switch (i)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupui/BackupChatBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21767);
            return;
            i = com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bHV().nye;
            ae.i(a.TAG, "backupbanner onclick, backupPcState[%d]", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            default: 
              ae.i(a.TAG, "click backup banner, BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bHV().nye) });
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
              ae.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bHV().nye) });
              a.a(a.this, false);
              break;
            case 24: 
            case 25: 
              ae.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bHV().nye) });
              a.a(a.this, true);
              continue;
              i = com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye;
              ae.i(a.TAG, "backupbanner onclick, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
              switch (i)
              {
              default: 
                ae.i(a.TAG, "click backup banner,backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
                break;
              case -4: 
              case 4: 
              case 5: 
              case 12: 
              case 22: 
              case 23: 
              case 28: 
              case 52: 
                ae.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
                a.b(a.this, false);
                break;
              case 24: 
              case 25: 
                ae.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
                a.b(a.this, true);
              }
              break;
            }
          }
        }
      });
    }
    bAV();
    com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj().nDA = this.nFS;
    com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJk().nDA = this.nFS;
    com.tencent.mm.plugin.backup.d.b.bIE().bIH().nAC = this.nFS;
    AppMethodBeat.o(21770);
  }
  
  private void iE(boolean paramBoolean)
  {
    AppMethodBeat.i(21771);
    ae.i(TAG, "jumpToBackupPcUI");
    if (bu.jn((Context)this.FpA.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.FpA.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.al((Context)this.FpA.get(), localIntent);
    }
    AppMethodBeat.o(21771);
  }
  
  private void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(21772);
    ae.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (bu.jn((Context)this.FpA.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.FpA.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.al((Context)this.FpA.get(), localIntent);
    }
    AppMethodBeat.o(21772);
  }
  
  private boolean xL(int paramInt)
  {
    AppMethodBeat.i(21774);
    if ((paramInt != -100) || (paramInt != this.nFQ))
    {
      ae.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", new Object[] { Integer.valueOf(d.bHY()), Integer.valueOf(paramInt) });
      this.nFQ = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bHV();
    TextView localTextView;
    Context localContext;
    int i;
    switch (paramInt)
    {
    default: 
      this.nFO.setVisibility(8);
      AppMethodBeat.o(21774);
      return false;
    case 12: 
    case 22: 
      this.nFO.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn)) {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690557, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
      }
      for (;;)
      {
        ((TextView)this.view.findViewById(2131297084)).setText(ak.getContext().getString(2131756220));
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn)) {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690557, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
        }
      }
    case 14: 
      this.nFO.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690557, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
      localTextView = (TextView)this.view.findViewById(2131297084);
      localContext = ak.getContext();
      paramInt = locale.nyf;
      i = locale.nyg;
      com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi();
      localTextView.setText(localContext.getString(2131756249, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bJn() }));
      AppMethodBeat.o(21774);
      return true;
    case 15: 
      this.nFO.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690557, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(ak.getContext().getString(2131756180));
      AppMethodBeat.o(21774);
      return true;
    case 23: 
      this.nFO.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690557, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
      localTextView = (TextView)this.view.findViewById(2131297084);
      localContext = ak.getContext();
      paramInt = locale.nyf;
      i = locale.nyg;
      com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi();
      localTextView.setText(localContext.getString(2131756232, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bJn() }));
      AppMethodBeat.o(21774);
      return true;
    case 25: 
      this.nFO.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690557, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(ak.getContext().getString(2131756234));
      AppMethodBeat.o(21774);
      return true;
    case 24: 
      iE(true);
      AppMethodBeat.o(21774);
      return true;
    case 4: 
    case 5: 
      this.nFO.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn))
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690557, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
        localTextView = (TextView)this.view.findViewById(2131297084);
        localContext = ak.getContext();
        paramInt = locale.nyf;
        i = locale.nyg;
        com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi();
        localTextView.setText(localContext.getString(2131756249, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bJn() }));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn))
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690557, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
          localTextView = (TextView)this.view.findViewById(2131297084);
          localContext = ak.getContext();
          paramInt = locale.nyf;
          i = locale.nyg;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi();
          localTextView.setText(localContext.getString(2131756232, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bJn() }));
        }
      }
    case -4: 
    case 28: 
      this.nFO.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn))
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690557, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
        ((TextView)this.view.findViewById(2131297084)).setText(ak.getContext().getString(2131756196));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDn))
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690557, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
          ((TextView)this.view.findViewById(2131297084)).setText(ak.getContext().getString(2131756197));
        }
      }
    }
    this.nFO.setVisibility(8);
    if (bu.jn((Context)this.FpA.get())) {
      iE(true);
    }
    AppMethodBeat.o(21774);
    return true;
  }
  
  private boolean xM(int paramInt)
  {
    AppMethodBeat.i(21775);
    if ((paramInt != -100) || (paramInt != this.nFR))
    {
      ae.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", new Object[] { Integer.valueOf(d.bHY()), Integer.valueOf(paramInt) });
      this.nFR = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.d.b.bIE().bHV();
    switch (paramInt)
    {
    default: 
      this.nFO.setVisibility(8);
      AppMethodBeat.o(21775);
      return false;
    case 22: 
      this.nFO.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690594, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(ak.getContext().getString(2131756155));
      AppMethodBeat.o(21775);
      return true;
    case 4: 
    case 5: 
    case 23: 
      this.nFO.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690594, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
      TextView localTextView = (TextView)this.view.findViewById(2131297084);
      Context localContext = ak.getContext();
      paramInt = locale.nyf;
      int i = locale.nyg;
      com.tencent.mm.plugin.backup.d.b.bIE().bIH();
      localTextView.setText(localContext.getString(2131756160, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.d.c.bIN() }));
      AppMethodBeat.o(21775);
      return true;
    case 25: 
      this.nFO.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690594, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(ak.getContext().getString(2131756162));
      AppMethodBeat.o(21775);
      return true;
    case 24: 
    case 52: 
      if (bu.jn((Context)this.FpA.get())) {
        iF(true);
      }
      AppMethodBeat.o(21775);
      return true;
    case -4: 
    case 28: 
      this.nFO.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.FpA.get(), 2131690594, ((Context)this.FpA.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(ak.getContext().getString(2131756112));
      AppMethodBeat.o(21775);
      return true;
    }
    this.nFO.setVisibility(8);
    if (bu.jn((Context)this.FpA.get())) {
      iF(true);
    }
    AppMethodBeat.o(21775);
    return true;
  }
  
  public final boolean bAV()
  {
    AppMethodBeat.i(21773);
    if ((this.isFirst) && (this.hms))
    {
      this.nFP.setBackgroundResource(2131234377);
      this.nFO.setBackground(null);
      this.titleTv.setBackground(null);
    }
    for (;;)
    {
      switch (d.bHY())
      {
      default: 
        this.nFO.setVisibility(8);
        AppMethodBeat.o(21773);
        return false;
        if (this.isFirst)
        {
          this.nFP.setBackgroundResource(2131232872);
          this.nFO.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
        }
        else if (this.hms)
        {
          this.nFP.setBackgroundResource(2131232872);
          this.nFO.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
        }
        else
        {
          this.nFP.setBackgroundResource(2131232872);
          this.nFO.setBackground(null);
          this.titleTv.setBackgroundResource(2131232867);
        }
        break;
      }
    }
    boolean bool = xL(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bHV().nye);
    AppMethodBeat.o(21773);
    return bool;
    bool = xM(com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye);
    AppMethodBeat.o(21773);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131493145;
  }
  
  public final int getOrder()
  {
    return 3;
  }
  
  static final class a
    implements b.a
  {
    private final WeakReference<a> nFU;
    
    a(a parama)
    {
      AppMethodBeat.i(21768);
      this.nFU = new WeakReference(parama);
      AppMethodBeat.o(21768);
    }
    
    public final void xt(int paramInt)
    {
      AppMethodBeat.i(21769);
      a locala = (a)this.nFU.get();
      if (locala != null)
      {
        a.a(locala, paramInt);
        AppMethodBeat.o(21769);
        return;
      }
      ae.e(a.TAG, "BackupChatBanner WeakReference is null!");
      AppMethodBeat.o(21769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a
 * JD-Core Version:    0.7.0.1
 */