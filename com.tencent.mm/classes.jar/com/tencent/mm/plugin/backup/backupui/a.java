package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.aj;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private static String TAG = "MicroMsg.BackupChatBanner";
  private View jGC;
  private View jGD;
  private int jGE;
  private int jGF;
  private b.a jGG;
  private TextView titleTv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(17713);
    this.jGC = null;
    this.titleTv = null;
    this.jGE = 100;
    this.jGF = 100;
    this.jGG = new a.a(this);
    ab.i(TAG, "BackupChatBanner.");
    com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aSL().jyN = -100;
    com.tencent.mm.plugin.backup.d.b.aTr().aSL().jyN = -100;
    ab.i(TAG, "initialize");
    this.titleTv = ((TextView)this.view.findViewById(2131821670));
    this.jGC = this.view.findViewById(2131821668);
    this.jGD = this.view.findViewById(2131821667);
    if (this.view != null)
    {
      this.jGC = this.view.findViewById(2131821668);
      this.jGC.setOnClickListener(new a.1(this));
    }
    aMK();
    com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTZ().jEn = this.jGG;
    com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aUa().jEn = this.jGG;
    com.tencent.mm.plugin.backup.d.b.aTr().aTu().jBk = this.jGG;
    AppMethodBeat.o(17713);
  }
  
  private void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(17714);
    ab.i(TAG, "jumpToBackupPcUI");
    if (bo.cB((Context)this.vUD.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.vUD.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.J((Context)this.vUD.get(), localIntent);
    }
    AppMethodBeat.o(17714);
  }
  
  private void fE(boolean paramBoolean)
  {
    AppMethodBeat.i(17715);
    ab.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (bo.cB((Context)this.vUD.get()))
    {
      Intent localIntent = new Intent().setClassName((Context)this.vUD.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      localIntent.putExtra("isRecoverTransferFinishFromBanner", paramBoolean);
      MMWizardActivity.J((Context)this.vUD.get(), localIntent);
    }
    AppMethodBeat.o(17715);
  }
  
  private boolean ry(int paramInt)
  {
    AppMethodBeat.i(17717);
    if ((paramInt != -100) || (paramInt != this.jGE))
    {
      ab.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", new Object[] { Integer.valueOf(d.aSO()), Integer.valueOf(paramInt) });
      this.jGE = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aSL();
    TextView localTextView;
    Context localContext;
    int i;
    switch (paramInt)
    {
    default: 
      this.jGC.setVisibility(8);
      AppMethodBeat.o(17717);
      return false;
    case 12: 
    case 22: 
      this.jGC.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa)) {
        ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231505, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
      }
      for (;;)
      {
        ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297345));
        AppMethodBeat.o(17717);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa)) {
          ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231505, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
        }
      }
    case 14: 
      this.jGC.setVisibility(0);
      ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231505, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
      localTextView = (TextView)this.view.findViewById(2131821670);
      localContext = ah.getContext();
      paramInt = locale.jyO;
      i = locale.jyP;
      com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY();
      localTextView.setText(localContext.getString(2131297373, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.aUd() }));
      AppMethodBeat.o(17717);
      return true;
    case 15: 
      this.jGC.setVisibility(0);
      ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231505, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
      ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297306));
      AppMethodBeat.o(17717);
      return true;
    case 23: 
      this.jGC.setVisibility(0);
      ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231505, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
      localTextView = (TextView)this.view.findViewById(2131821670);
      localContext = ah.getContext();
      paramInt = locale.jyO;
      i = locale.jyP;
      com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY();
      localTextView.setText(localContext.getString(2131297357, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.aUd() }));
      AppMethodBeat.o(17717);
      return true;
    case 25: 
      this.jGC.setVisibility(0);
      ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231505, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
      ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297359));
      AppMethodBeat.o(17717);
      return true;
    case 24: 
      fD(true);
      AppMethodBeat.o(17717);
      return true;
    case 4: 
    case 5: 
      this.jGC.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa))
      {
        ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231505, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
        localTextView = (TextView)this.view.findViewById(2131821670);
        localContext = ah.getContext();
        paramInt = locale.jyO;
        i = locale.jyP;
        com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY();
        localTextView.setText(localContext.getString(2131297373, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.aUd() }));
      }
      for (;;)
      {
        AppMethodBeat.o(17717);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa))
        {
          ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231505, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
          localTextView = (TextView)this.view.findViewById(2131821670);
          localContext = ah.getContext();
          paramInt = locale.jyO;
          i = locale.jyP;
          com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY();
          localTextView.setText(localContext.getString(2131297357, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.aUd() }));
        }
      }
    case -4: 
    case 28: 
      this.jGC.setVisibility(0);
      if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa))
      {
        ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231505, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
        ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297322));
      }
      for (;;)
      {
        AppMethodBeat.o(17717);
        return true;
        if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aTY().jEa))
        {
          ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231505, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
          ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297323));
        }
      }
    }
    this.jGC.setVisibility(8);
    if (bo.cB((Context)this.vUD.get())) {
      fD(true);
    }
    AppMethodBeat.o(17717);
    return true;
  }
  
  private boolean rz(int paramInt)
  {
    AppMethodBeat.i(17718);
    if ((paramInt != -100) || (paramInt != this.jGF))
    {
      ab.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", new Object[] { Integer.valueOf(d.aSO()), Integer.valueOf(paramInt) });
      this.jGF = paramInt;
    }
    e locale = com.tencent.mm.plugin.backup.d.b.aTr().aSL();
    switch (paramInt)
    {
    default: 
      this.jGC.setVisibility(8);
      AppMethodBeat.o(17718);
      return false;
    case 22: 
      this.jGC.setVisibility(0);
      ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231515, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
      ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297282));
      AppMethodBeat.o(17718);
      return true;
    case 4: 
    case 5: 
    case 23: 
      this.jGC.setVisibility(0);
      ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231515, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
      TextView localTextView = (TextView)this.view.findViewById(2131821670);
      Context localContext = ah.getContext();
      paramInt = locale.jyO;
      int i = locale.jyP;
      com.tencent.mm.plugin.backup.d.b.aTr().aTu();
      localTextView.setText(localContext.getString(2131297287, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.d.c.aTA() }));
      AppMethodBeat.o(17718);
      return true;
    case 25: 
      this.jGC.setVisibility(0);
      ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231515, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
      ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297289));
      AppMethodBeat.o(17718);
      return true;
    case 24: 
    case 52: 
      if (bo.cB((Context)this.vUD.get())) {
        fE(true);
      }
      AppMethodBeat.o(17718);
      return true;
    case -4: 
    case 28: 
      this.jGC.setVisibility(0);
      ((ImageView)this.view.findViewById(2131821669)).setImageDrawable(aj.g((Context)this.vUD.get(), 2131231515, ((Context)this.vUD.get()).getResources().getColor(2131690589)));
      ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297242));
      AppMethodBeat.o(17718);
      return true;
    }
    this.jGC.setVisibility(8);
    if (bo.cB((Context)this.vUD.get())) {
      fE(true);
    }
    AppMethodBeat.o(17718);
    return true;
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(17716);
    if ((this.nwf) && (this.eUx))
    {
      this.jGD.setBackgroundResource(2130840583);
      this.jGC.setBackground(null);
      this.titleTv.setBackground(null);
    }
    for (;;)
    {
      switch (d.aSO())
      {
      default: 
        this.jGC.setVisibility(8);
        AppMethodBeat.o(17716);
        return false;
        if (this.nwf)
        {
          this.jGD.setBackgroundResource(2130839279);
          this.jGC.setBackgroundResource(2130839278);
          this.titleTv.setBackgroundResource(2130839276);
        }
        else if (this.eUx)
        {
          this.jGD.setBackgroundResource(2130839279);
          this.jGC.setBackgroundResource(2130839276);
          this.titleTv.setBackground(null);
        }
        else
        {
          this.jGD.setBackgroundResource(2130839279);
          this.jGC.setBackground(null);
          this.titleTv.setBackgroundResource(2130839276);
        }
        break;
      }
    }
    boolean bool = ry(com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aSL().jyN);
    AppMethodBeat.o(17716);
    return bool;
    bool = rz(com.tencent.mm.plugin.backup.d.b.aTr().aSL().jyN);
    AppMethodBeat.o(17716);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2130968816;
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