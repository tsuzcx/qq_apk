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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.am;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private static String TAG = "MicroMsg.BackupChatBanner";
  private View mZW;
  private View mZX;
  private int mZY;
  private int mZZ;
  private b.a naa;
  private TextView titleTv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21770);
    this.mZW = null;
    this.titleTv = null;
    this.mZY = 100;
    this.mZZ = 100;
    this.naa = new a(this);
    ac.i(TAG, "new BackupChatBanner.");
    com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bCP().mSk = -100;
    com.tencent.mm.plugin.backup.d.b.bDy().bCP().mSk = -100;
    ac.i(TAG, "initialize");
    this.titleTv = ((TextView)this.view.findViewById(2131297084));
    this.mZW = this.view.findViewById(2131297082);
    this.mZX = this.view.findViewById(2131297183);
    if (this.view != null)
    {
      this.mZW = this.view.findViewById(2131297082);
      this.mZW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21767);
          int i = d.bCS();
          ac.i(a.TAG, "backupbanner onclick, backupMode[%d]", new Object[] { Integer.valueOf(i) });
          switch (i)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(21767);
            return;
            i = com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bCP().mSk;
            ac.i(a.TAG, "backupbanner onclick, backupPcState[%d]", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            default: 
              ac.i(a.TAG, "click backup banner, BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bCP().mSk) });
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
              ac.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bCP().mSk) });
              a.a(a.this, false);
              AppMethodBeat.o(21767);
              return;
            }
            ac.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bCP().mSk) });
            a.a(a.this, true);
            AppMethodBeat.o(21767);
            return;
            i = com.tencent.mm.plugin.backup.d.b.bDy().bCP().mSk;
            ac.i(a.TAG, "backupbanner onclick, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            default: 
              ac.i(a.TAG, "click backup banner,backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
            }
          }
          ac.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
          a.b(a.this, false);
          AppMethodBeat.o(21767);
          return;
          ac.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
          a.b(a.this, true);
          AppMethodBeat.o(21767);
        }
      });
    }
    bvU();
    com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEc().mXI = this.naa;
    com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEd().mXI = this.naa;
    com.tencent.mm.plugin.backup.d.b.bDy().bDB().mUK = this.naa;
    AppMethodBeat.o(21770);
  }
  
  private void ix(boolean paramBoolean)
  {
    AppMethodBeat.i(21771);
    ac.i(TAG, "jumpToBackupPcUI");
    if (bs.iX((Context)this.Dsc.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.Dsc.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.aj((Context)this.Dsc.get(), localIntent);
    }
    AppMethodBeat.o(21771);
  }
  
  private void iy(boolean paramBoolean)
  {
    AppMethodBeat.i(21772);
    ac.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (bs.iX((Context)this.Dsc.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.Dsc.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.aj((Context)this.Dsc.get(), localIntent);
    }
    AppMethodBeat.o(21772);
  }
  
  private boolean xb(int paramInt)
  {
    AppMethodBeat.i(21774);
    if ((paramInt != -100) || (paramInt != this.mZY))
    {
      ac.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", new Object[] { Integer.valueOf(d.bCS()), Integer.valueOf(paramInt) });
      this.mZY = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bCP();
    TextView localTextView;
    Context localContext;
    int i;
    switch (paramInt)
    {
    default: 
      this.mZW.setVisibility(8);
      AppMethodBeat.o(21774);
      return false;
    case 12: 
    case 22: 
      this.mZW.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv)) {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690557, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
      }
      for (;;)
      {
        ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756220));
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv)) {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690557, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
        }
      }
    case 14: 
      this.mZW.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690557, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
      localTextView = (TextView)this.view.findViewById(2131297084);
      localContext = ai.getContext();
      paramInt = locale.mSl;
      i = locale.mSm;
      com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb();
      localTextView.setText(localContext.getString(2131756249, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bEg() }));
      AppMethodBeat.o(21774);
      return true;
    case 15: 
      this.mZW.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690557, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756180));
      AppMethodBeat.o(21774);
      return true;
    case 23: 
      this.mZW.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690557, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
      localTextView = (TextView)this.view.findViewById(2131297084);
      localContext = ai.getContext();
      paramInt = locale.mSl;
      i = locale.mSm;
      com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb();
      localTextView.setText(localContext.getString(2131756232, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bEg() }));
      AppMethodBeat.o(21774);
      return true;
    case 25: 
      this.mZW.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690557, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756234));
      AppMethodBeat.o(21774);
      return true;
    case 24: 
      ix(true);
      AppMethodBeat.o(21774);
      return true;
    case 4: 
    case 5: 
      this.mZW.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv))
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690557, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
        localTextView = (TextView)this.view.findViewById(2131297084);
        localContext = ai.getContext();
        paramInt = locale.mSl;
        i = locale.mSm;
        com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb();
        localTextView.setText(localContext.getString(2131756249, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bEg() }));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv))
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690557, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
          localTextView = (TextView)this.view.findViewById(2131297084);
          localContext = ai.getContext();
          paramInt = locale.mSl;
          i = locale.mSm;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb();
          localTextView.setText(localContext.getString(2131756232, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bEg() }));
        }
      }
    case -4: 
    case 28: 
      this.mZW.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv))
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690557, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
        ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756196));
      }
      for (;;)
      {
        AppMethodBeat.o(21774);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bEb().mXv))
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690557, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
          ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756197));
        }
      }
    }
    this.mZW.setVisibility(8);
    if (bs.iX((Context)this.Dsc.get())) {
      ix(true);
    }
    AppMethodBeat.o(21774);
    return true;
  }
  
  private boolean xc(int paramInt)
  {
    AppMethodBeat.i(21775);
    if ((paramInt != -100) || (paramInt != this.mZZ))
    {
      ac.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", new Object[] { Integer.valueOf(d.bCS()), Integer.valueOf(paramInt) });
      this.mZZ = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.d.b.bDy().bCP();
    switch (paramInt)
    {
    default: 
      this.mZW.setVisibility(8);
      AppMethodBeat.o(21775);
      return false;
    case 22: 
      this.mZW.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690594, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756155));
      AppMethodBeat.o(21775);
      return true;
    case 4: 
    case 5: 
    case 23: 
      this.mZW.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690594, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
      TextView localTextView = (TextView)this.view.findViewById(2131297084);
      Context localContext = ai.getContext();
      paramInt = locale.mSl;
      int i = locale.mSm;
      com.tencent.mm.plugin.backup.d.b.bDy().bDB();
      localTextView.setText(localContext.getString(2131756160, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.d.c.bDH() }));
      AppMethodBeat.o(21775);
      return true;
    case 25: 
      this.mZW.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690594, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756162));
      AppMethodBeat.o(21775);
      return true;
    case 24: 
    case 52: 
      if (bs.iX((Context)this.Dsc.get())) {
        iy(true);
      }
      AppMethodBeat.o(21775);
      return true;
    case -4: 
    case 28: 
      this.mZW.setVisibility(0);
      ((ImageView)this.view.findViewById(2131297083)).setImageDrawable(am.k((Context)this.Dsc.get(), 2131690594, ((Context)this.Dsc.get()).getResources().getColor(2131099676)));
      ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756112));
      AppMethodBeat.o(21775);
      return true;
    }
    this.mZW.setVisibility(8);
    if (bs.iX((Context)this.Dsc.get())) {
      iy(true);
    }
    AppMethodBeat.o(21775);
    return true;
  }
  
  public final boolean bvU()
  {
    AppMethodBeat.i(21773);
    if ((this.isFirst) && (this.gRm))
    {
      this.mZX.setBackgroundResource(2131234377);
      this.mZW.setBackground(null);
      this.titleTv.setBackground(null);
    }
    for (;;)
    {
      switch (d.bCS())
      {
      default: 
        this.mZW.setVisibility(8);
        AppMethodBeat.o(21773);
        return false;
        if (this.isFirst)
        {
          this.mZX.setBackgroundResource(2131232872);
          this.mZW.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
        }
        else if (this.gRm)
        {
          this.mZX.setBackgroundResource(2131232872);
          this.mZW.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
        }
        else
        {
          this.mZX.setBackgroundResource(2131232872);
          this.mZW.setBackground(null);
          this.titleTv.setBackgroundResource(2131232867);
        }
        break;
      }
    }
    boolean bool = xb(com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bCP().mSk);
    AppMethodBeat.o(21773);
    return bool;
    bool = xc(com.tencent.mm.plugin.backup.d.b.bDy().bCP().mSk);
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
    private final WeakReference<a> nac;
    
    a(a parama)
    {
      AppMethodBeat.i(21768);
      this.nac = new WeakReference(parama);
      AppMethodBeat.o(21768);
    }
    
    public final void wI(int paramInt)
    {
      AppMethodBeat.i(21769);
      a locala = (a)this.nac.get();
      if (locala != null)
      {
        a.a(locala, paramInt);
        AppMethodBeat.o(21769);
        return;
      }
      ac.e(a.TAG, "BackupChatBanner WeakReference is null!");
      AppMethodBeat.o(21769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a
 * JD-Core Version:    0.7.0.1
 */