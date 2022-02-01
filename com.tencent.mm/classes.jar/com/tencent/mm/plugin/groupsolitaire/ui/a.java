package com.tencent.mm.plugin.groupsolitaire.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class a
{
  private Button gUt;
  private Button gWI;
  String jhp;
  private View kBS;
  private int lzC;
  private BottomSheetBehavior lzD;
  Context mContext;
  android.support.design.widget.a uBI;
  private TextView uBJ;
  a uBK;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(110416);
    this.mContext = paramContext;
    this.kBS = View.inflate(this.mContext, 2131494423, null);
    this.uBI = new android.support.design.widget.a(this.mContext);
    this.uBI.setContentView(this.kBS);
    this.uBI.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        a.this.uBI = null;
      }
    });
    this.uBJ = ((TextView)this.kBS.findViewById(2131303216));
    paramContext = (FrameLayout.LayoutParams)this.kBS.getLayoutParams();
    paramContext.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 250);
    this.kBS.setLayoutParams(paramContext);
    this.lzC = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 350);
    this.lzD = BottomSheetBehavior.l((View)this.kBS.getParent());
    if (this.lzD != null)
    {
      this.lzD.J(this.lzC);
      this.lzD.nZ = false;
    }
    this.gUt = ((Button)this.kBS.findViewById(2131302999));
    this.gUt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110414);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (a.this.uBK != null)
        {
          paramAnonymousView = a.this.uBK;
          localObject = a.this;
          ad.i("MicroMsg.TiemDatePicker", "[getPhoneNum] :%s", new Object[] { ((a)localObject).jhp });
          paramAnonymousView.amV(((a)localObject).jhp);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110414);
      }
    });
    this.gWI = ((Button)this.kBS.findViewById(2131297690));
    this.gWI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110415);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (a.this.uBK != null) {
          a.this.uBK.onCancel();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110415);
      }
    });
    AppMethodBeat.o(110416);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(110418);
    if (this.uBI != null) {
      this.uBI.dismiss();
    }
    AppMethodBeat.o(110418);
  }
  
  public final void show()
  {
    AppMethodBeat.i(110417);
    String str = (String)g.ajC().ajl().get(6, null);
    ad.d("MicroMsg.TiemDatePicker", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      h.a(this.mContext, false, this.mContext.getString(2131760087), this.mContext.getString(2131760087), this.mContext.getString(2131760089), this.mContext.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110412);
          Intent localIntent = new Intent(a.this.mContext, BindMContactUI.class);
          localIntent.putExtra("bind_scene", 0);
          paramAnonymousDialogInterface = ((TelephonyManager)a.this.mContext.getSystemService("phone")).getSimCountryIso();
          if (!bt.isNullOrNil(paramAnonymousDialogInterface))
          {
            paramAnonymousDialogInterface = com.tencent.mm.ax.b.bq(paramAnonymousDialogInterface, a.this.mContext.getString(2131757950));
            if (paramAnonymousDialogInterface != null)
            {
              localIntent.putExtra("country_name", paramAnonymousDialogInterface.iem);
              localIntent.putExtra("couttry_code", paramAnonymousDialogInterface.iel);
            }
          }
          Context localContext = a.this.mContext;
          ad.i("MicroMsg.TiemDatePicker", "startWizardActivity()");
          Assert.assertTrue("startWizardActivity: Param context should be a Activity :" + localContext.toString(), localContext instanceof Activity);
          paramAnonymousDialogInterface = ((Activity)localContext).getIntent();
          String str;
          if (paramAnonymousDialogInterface != null)
          {
            str = paramAnonymousDialogInterface.getStringExtra("WizardRootClass");
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.getStringExtra("WizardTransactionId");
          }
          for (;;)
          {
            localIntent.putExtra("WizardRootClass", str);
            if (paramAnonymousDialogInterface != null) {
              localIntent.putExtra("WizardTransactionId", paramAnonymousDialogInterface);
            }
            ((Activity)localContext).startActivityForResult(localIntent, 4098);
            AppMethodBeat.o(110412);
            return;
            paramAnonymousDialogInterface = null;
            str = null;
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110413);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(110413);
        }
      }, 2131100464, 2131100464);
      AppMethodBeat.o(110417);
      return;
    }
    this.jhp = str;
    this.uBJ.setText(this.jhp);
    if (this.uBI != null) {
      this.uBI.show();
    }
    AppMethodBeat.o(110417);
  }
  
  public static abstract interface a
  {
    public abstract void amV(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.a
 * JD-Core Version:    0.7.0.1
 */