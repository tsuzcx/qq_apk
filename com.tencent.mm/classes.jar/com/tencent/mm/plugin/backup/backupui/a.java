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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private static String TAG = "MicroMsg.BackupChatBanner";
  private View nAt;
  private View nAu;
  private int nAv;
  private int nAw;
  private b.a nAx;
  private TextView titleTv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21770);
    this.nAt = null;
    this.titleTv = null;
    this.nAv = 100;
    this.nAw = 100;
    this.nAx = new a(this);
    ad.i(TAG, "new BackupChatBanner.");
    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = -100;
    com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = -100;
    ad.i(TAG, "initialize");
    this.titleTv = ((TextView)this.view.findViewById(2131297084));
    this.nAt = this.view.findViewById(2131297082);
    this.nAu = this.view.findViewById(2131297183);
    if (this.view != null)
    {
      this.nAt = this.view.findViewById(2131297082);
      this.nAt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21767);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupui/BackupChatBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          int i = d.bHa();
          ad.i(a.TAG, "backupbanner onclick, backupMode[%d]", new Object[] { Integer.valueOf(i) });
          switch (i)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupui/BackupChatBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21767);
            return;
            i = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ;
            ad.i(a.TAG, "backupbanner onclick, backupPcState[%d]", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            default: 
              ad.i(a.TAG, "click backup banner, BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ) });
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
              ad.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ) });
              a.a(a.this, false);
              break;
            case 24: 
            case 25: 
              ad.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ) });
              a.a(a.this, true);
              continue;
              i = com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ;
              ad.i(a.TAG, "backupbanner onclick, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
              switch (i)
              {
              default: 
                ad.i(a.TAG, "click backup banner,backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
                break;
              case -4: 
              case 4: 
              case 5: 
              case 12: 
              case 22: 
              case 23: 
              case 28: 
              case 52: 
                ad.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
                a.b(a.this, false);
                break;
              case 24: 
              case 25: 
                ad.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
                a.b(a.this, true);
              }
              break;
            }
          }
        }
      });
    }
    bAa();
    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().nyf = this.nAx;
    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().nyf = this.nAx;
    com.tencent.mm.plugin.backup.d.b.bHG().bHJ().nvh = this.nAx;
    AppMethodBeat.o(21770);
  }
  
  private void iG(boolean paramBoolean)
  {
    AppMethodBeat.i(21771);
    ad.i(TAG, "jumpToBackupPcUI");
    if (bt.jh((Context)this.EXg.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.EXg.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.al((Context)this.EXg.get(), localIntent);
    }
    AppMethodBeat.o(21771);
  }
  
  private void iH(boolean paramBoolean)
  {
    AppMethodBeat.i(21772);
    ad.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (bt.jh((Context)this.EXg.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.EXg.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.al((Context)this.EXg.get(), localIntent);
    }
    AppMethodBeat.o(21772);
  }
  
  private boolean xH(int paramInt)
  {
    AppMethodBeat.i(21774);
    if ((paramInt != -100) || (paramInt != this.nAv))
    {
      ad.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", new Object[] { Integer.valueOf(d.bHa()), Integer.valueOf(paramInt) });
      this.nAv = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX();
    TextView localTextView;
    Context localContext;
    int i;
    switch (paramInt)
    {
    default: 
      this.nAt.setVisibility(8);
      AppMethodBeat.o(21774);
      return false;
    case 12: 
    case 22: 
      this.nAt.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS)) {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690557, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
      }
      for (;;)
      {
        ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756220));
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS)) {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690557, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
        }
      }
    case 14: 
      this.nAt.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690557, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
      localTextView = (TextView)this.view.findViewById(2131297084);
      localContext = aj.getContext();
      paramInt = locale.nsK;
      i = locale.nsL;
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk();
      localTextView.setText(localContext.getString(2131756249, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bIp() }));
      AppMethodBeat.o(21774);
      return true;
    case 15: 
      this.nAt.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690557, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756180));
      AppMethodBeat.o(21774);
      return true;
    case 23: 
      this.nAt.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690557, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
      localTextView = (TextView)this.view.findViewById(2131297084);
      localContext = aj.getContext();
      paramInt = locale.nsK;
      i = locale.nsL;
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk();
      localTextView.setText(localContext.getString(2131756232, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bIp() }));
      AppMethodBeat.o(21774);
      return true;
    case 25: 
      this.nAt.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690557, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756234));
      AppMethodBeat.o(21774);
      return true;
    case 24: 
      iG(true);
      AppMethodBeat.o(21774);
      return true;
    case 4: 
    case 5: 
      this.nAt.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS))
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690557, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
        localTextView = (TextView)this.view.findViewById(2131297084);
        localContext = aj.getContext();
        paramInt = locale.nsK;
        i = locale.nsL;
        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk();
        localTextView.setText(localContext.getString(2131756249, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bIp() }));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS))
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690557, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
          localTextView = (TextView)this.view.findViewById(2131297084);
          localContext = aj.getContext();
          paramInt = locale.nsK;
          i = locale.nsL;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk();
          localTextView.setText(localContext.getString(2131756232, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bIp() }));
        }
      }
    case -4: 
    case 28: 
      this.nAt.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS))
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690557, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
        ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756196));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS))
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690557, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
          ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756197));
        }
      }
    }
    this.nAt.setVisibility(8);
    if (bt.jh((Context)this.EXg.get())) {
      iG(true);
    }
    AppMethodBeat.o(21774);
    return true;
  }
  
  private boolean xI(int paramInt)
  {
    AppMethodBeat.i(21775);
    if ((paramInt != -100) || (paramInt != this.nAw))
    {
      ad.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", new Object[] { Integer.valueOf(d.bHa()), Integer.valueOf(paramInt) });
      this.nAw = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.d.b.bHG().bGX();
    switch (paramInt)
    {
    default: 
      this.nAt.setVisibility(8);
      AppMethodBeat.o(21775);
      return false;
    case 22: 
      this.nAt.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690594, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756155));
      AppMethodBeat.o(21775);
      return true;
    case 4: 
    case 5: 
    case 23: 
      this.nAt.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690594, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
      TextView localTextView = (TextView)this.view.findViewById(2131297084);
      Context localContext = aj.getContext();
      paramInt = locale.nsK;
      int i = locale.nsL;
      com.tencent.mm.plugin.backup.d.b.bHG().bHJ();
      localTextView.setText(localContext.getString(2131756160, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.d.c.bHP() }));
      AppMethodBeat.o(21775);
      return true;
    case 25: 
      this.nAt.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690594, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756162));
      AppMethodBeat.o(21775);
      return true;
    case 24: 
    case 52: 
      if (bt.jh((Context)this.EXg.get())) {
        iH(true);
      }
      AppMethodBeat.o(21775);
      return true;
    case -4: 
    case 28: 
      this.nAt.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(ao.k((Context)this.EXg.get(), 2131690594, ((Context)this.EXg.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756112));
      AppMethodBeat.o(21775);
      return true;
    }
    this.nAt.setVisibility(8);
    if (bt.jh((Context)this.EXg.get())) {
      iH(true);
    }
    AppMethodBeat.o(21775);
    return true;
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(21773);
    if ((this.isFirst) && (this.hjE))
    {
      this.nAu.setBackgroundResource(2131234377);
      this.nAt.setBackground(null);
      this.titleTv.setBackground(null);
    }
    for (;;)
    {
      switch (d.bHa())
      {
      default: 
        this.nAt.setVisibility(8);
        AppMethodBeat.o(21773);
        return false;
        if (this.isFirst)
        {
          this.nAu.setBackgroundResource(2131232872);
          this.nAt.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
        }
        else if (this.hjE)
        {
          this.nAu.setBackgroundResource(2131232872);
          this.nAt.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
        }
        else
        {
          this.nAu.setBackgroundResource(2131232872);
          this.nAt.setBackground(null);
          this.titleTv.setBackgroundResource(2131232867);
        }
        break;
      }
    }
    boolean bool = xH(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ);
    AppMethodBeat.o(21773);
    return bool;
    bool = xI(com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ);
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
    private final WeakReference<a> nAz;
    
    a(a parama)
    {
      AppMethodBeat.i(21768);
      this.nAz = new WeakReference(parama);
      AppMethodBeat.o(21768);
    }
    
    public final void xo(int paramInt)
    {
      AppMethodBeat.i(21769);
      a locala = (a)this.nAz.get();
      if (locala != null)
      {
        a.a(locala, paramInt);
        AppMethodBeat.o(21769);
        return;
      }
      ad.e(a.TAG, "BackupChatBanner WeakReference is null!");
      AppMethodBeat.o(21769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a
 * JD-Core Version:    0.7.0.1
 */