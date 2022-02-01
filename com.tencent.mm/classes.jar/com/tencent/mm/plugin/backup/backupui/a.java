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
import com.tencent.mm.ui.am;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private static String TAG = "MicroMsg.BackupChatBanner";
  private View mxV;
  private View mxW;
  private int mxX;
  private int mxY;
  private b.a mxZ;
  private TextView titleTv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21770);
    this.mxV = null;
    this.titleTv = null;
    this.mxX = 100;
    this.mxY = 100;
    this.mxZ = new a(this);
    ad.i(TAG, "new BackupChatBanner.");
    com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bvT().mqj = -100;
    com.tencent.mm.plugin.backup.d.b.bwC().bvT().mqj = -100;
    ad.i(TAG, "initialize");
    this.titleTv = ((TextView)this.view.findViewById(2131297084));
    this.mxV = this.view.findViewById(2131297082);
    this.mxW = this.view.findViewById(2131297183);
    if (this.view != null)
    {
      this.mxV = this.view.findViewById(2131297082);
      this.mxV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21767);
          int i = d.bvW();
          ad.i(a.TAG, "backupbanner onclick, backupMode[%d]", new Object[] { Integer.valueOf(i) });
          switch (i)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(21767);
            return;
            i = com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bvT().mqj;
            ad.i(a.TAG, "backupbanner onclick, backupPcState[%d]", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            default: 
              ad.i(a.TAG, "click backup banner, BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bvT().mqj) });
              AppMethodBeat.o(21767);
              return;
            case -4: 
            case 4: 
            case 5: 
            case 12: 
            case 14: 
            case 15: 
            case 22: 
            case 23: 
            case 28: 
              ad.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bvT().mqj) });
              a.a(a.this, false);
              AppMethodBeat.o(21767);
              return;
            }
            ad.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bvT().mqj) });
            a.a(a.this, true);
            AppMethodBeat.o(21767);
            return;
            i = com.tencent.mm.plugin.backup.d.b.bwC().bvT().mqj;
            ad.i(a.TAG, "backupbanner onclick, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            default: 
              ad.i(a.TAG, "click backup banner,backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
            }
          }
          ad.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
          a.b(a.this, false);
          AppMethodBeat.o(21767);
          return;
          ad.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
          a.b(a.this, true);
          AppMethodBeat.o(21767);
        }
      });
    }
    boZ();
    com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxg().mvH = this.mxZ;
    com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxh().mvH = this.mxZ;
    com.tencent.mm.plugin.backup.d.b.bwC().bwF().msI = this.mxZ;
    AppMethodBeat.o(21770);
  }
  
  private void hX(boolean paramBoolean)
  {
    AppMethodBeat.i(21771);
    ad.i(TAG, "jumpToBackupPcUI");
    if (bt.iM((Context)this.BZM.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.BZM.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.V((Context)this.BZM.get(), localIntent);
    }
    AppMethodBeat.o(21771);
  }
  
  private void hY(boolean paramBoolean)
  {
    AppMethodBeat.i(21772);
    ad.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (bt.iM((Context)this.BZM.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.BZM.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.V((Context)this.BZM.get(), localIntent);
    }
    AppMethodBeat.o(21772);
  }
  
  private boolean wk(int paramInt)
  {
    AppMethodBeat.i(21774);
    if ((paramInt != -100) || (paramInt != this.mxX))
    {
      ad.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", new Object[] { Integer.valueOf(d.bvW()), Integer.valueOf(paramInt) });
      this.mxX = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bvT();
    TextView localTextView;
    Context localContext;
    int i;
    switch (paramInt)
    {
    default: 
      this.mxV.setVisibility(8);
      AppMethodBeat.o(21774);
      return false;
    case 12: 
    case 22: 
      this.mxV.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu)) {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690557, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
      }
      for (;;)
      {
        ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756220));
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu)) {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690557, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
        }
      }
    case 14: 
      this.mxV.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690557, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
      localTextView = (TextView)this.view.findViewById(2131297084);
      localContext = aj.getContext();
      paramInt = locale.mqk;
      i = locale.mql;
      com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf();
      localTextView.setText(localContext.getString(2131756249, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bxk() }));
      AppMethodBeat.o(21774);
      return true;
    case 15: 
      this.mxV.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690557, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756180));
      AppMethodBeat.o(21774);
      return true;
    case 23: 
      this.mxV.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690557, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
      localTextView = (TextView)this.view.findViewById(2131297084);
      localContext = aj.getContext();
      paramInt = locale.mqk;
      i = locale.mql;
      com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf();
      localTextView.setText(localContext.getString(2131756232, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bxk() }));
      AppMethodBeat.o(21774);
      return true;
    case 25: 
      this.mxV.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690557, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756234));
      AppMethodBeat.o(21774);
      return true;
    case 24: 
      hX(true);
      AppMethodBeat.o(21774);
      return true;
    case 4: 
    case 5: 
      this.mxV.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu))
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690557, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
        localTextView = (TextView)this.view.findViewById(2131297084);
        localContext = aj.getContext();
        paramInt = locale.mqk;
        i = locale.mql;
        com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf();
        localTextView.setText(localContext.getString(2131756249, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bxk() }));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu))
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690557, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
          localTextView = (TextView)this.view.findViewById(2131297084);
          localContext = aj.getContext();
          paramInt = locale.mqk;
          i = locale.mql;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf();
          localTextView.setText(localContext.getString(2131756232, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bxk() }));
        }
      }
    case -4: 
    case 28: 
      this.mxV.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu))
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690557, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
        ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756196));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bxf().mvu))
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690557, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
          ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756197));
        }
      }
    }
    this.mxV.setVisibility(8);
    if (bt.iM((Context)this.BZM.get())) {
      hX(true);
    }
    AppMethodBeat.o(21774);
    return true;
  }
  
  private boolean wl(int paramInt)
  {
    AppMethodBeat.i(21775);
    if ((paramInt != -100) || (paramInt != this.mxY))
    {
      ad.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", new Object[] { Integer.valueOf(d.bvW()), Integer.valueOf(paramInt) });
      this.mxY = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.d.b.bwC().bvT();
    switch (paramInt)
    {
    default: 
      this.mxV.setVisibility(8);
      AppMethodBeat.o(21775);
      return false;
    case 22: 
      this.mxV.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690594, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756155));
      AppMethodBeat.o(21775);
      return true;
    case 4: 
    case 5: 
    case 23: 
      this.mxV.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690594, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
      TextView localTextView = (TextView)this.view.findViewById(2131297084);
      Context localContext = aj.getContext();
      paramInt = locale.mqk;
      int i = locale.mql;
      com.tencent.mm.plugin.backup.d.b.bwC().bwF();
      localTextView.setText(localContext.getString(2131756160, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.d.c.bwL() }));
      AppMethodBeat.o(21775);
      return true;
    case 25: 
      this.mxV.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690594, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756162));
      AppMethodBeat.o(21775);
      return true;
    case 24: 
    case 52: 
      if (bt.iM((Context)this.BZM.get())) {
        hY(true);
      }
      AppMethodBeat.o(21775);
      return true;
    case -4: 
    case 28: 
      this.mxV.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.i((Context)this.BZM.get(), 2131690594, ((Context)this.BZM.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756112));
      AppMethodBeat.o(21775);
      return true;
    }
    this.mxV.setVisibility(8);
    if (bt.iM((Context)this.BZM.get())) {
      hY(true);
    }
    AppMethodBeat.o(21775);
    return true;
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(21773);
    if ((this.isFirst) && (this.gqE))
    {
      this.mxW.setBackgroundResource(2131234377);
      this.mxV.setBackground(null);
      this.titleTv.setBackground(null);
    }
    for (;;)
    {
      switch (d.bvW())
      {
      default: 
        this.mxV.setVisibility(8);
        AppMethodBeat.o(21773);
        return false;
        if (this.isFirst)
        {
          this.mxW.setBackgroundResource(2131232872);
          this.mxV.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
        }
        else if (this.gqE)
        {
          this.mxW.setBackgroundResource(2131232872);
          this.mxV.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
        }
        else
        {
          this.mxW.setBackgroundResource(2131232872);
          this.mxV.setBackground(null);
          this.titleTv.setBackgroundResource(2131232867);
        }
        break;
      }
    }
    boolean bool = wk(com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bvT().mqj);
    AppMethodBeat.o(21773);
    return bool;
    bool = wl(com.tencent.mm.plugin.backup.d.b.bwC().bvT().mqj);
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
    private final WeakReference<a> myb;
    
    a(a parama)
    {
      AppMethodBeat.i(21768);
      this.myb = new WeakReference(parama);
      AppMethodBeat.o(21768);
    }
    
    public final void vR(int paramInt)
    {
      AppMethodBeat.i(21769);
      a locala = (a)this.myb.get();
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