package com.tencent.mm.plugin.groupsolitaire.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.b.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.groupsolitaire.b.e;
import com.tencent.mm.plugin.groupsolitaire.b.f;
import com.tencent.mm.plugin.groupsolitaire.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import junit.framework.Assert;

public final class a
{
  com.google.android.material.bottomsheet.a DpN;
  private TextView DpO;
  a DpP;
  private Button kEt;
  private Button kGN;
  Context mContext;
  String mZK;
  private View oFW;
  private int pMB;
  private BottomSheetBehavior pMC;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(110416);
    this.mContext = paramContext;
    this.oFW = View.inflate(this.mContext, b.f.DoC, null);
    this.DpN = new com.google.android.material.bottomsheet.a(this.mContext);
    this.DpN.setContentView(this.oFW);
    this.DpN.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        a.this.DpN = null;
      }
    });
    this.DpO = ((TextView)this.oFW.findViewById(b.e.Doz));
    paramContext = (FrameLayout.LayoutParams)this.oFW.getLayoutParams();
    paramContext.height = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 250);
    this.oFW.setLayoutParams(paramContext);
    this.pMB = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 350);
    this.pMC = BottomSheetBehavior.cg((View)this.oFW.getParent());
    if (this.pMC != null)
    {
      this.pMC.D(this.pMB);
      this.pMC.bxz = false;
    }
    this.kEt = ((Button)this.oFW.findViewById(b.e.ok_btn));
    this.kEt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110414);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (a.this.DpP != null)
        {
          paramAnonymousView = a.this.DpP;
          localObject = a.this;
          Log.i("MicroMsg.TiemDatePicker", "[getPhoneNum] :%s", new Object[] { ((a)localObject).mZK });
          paramAnonymousView.aLd(((a)localObject).mZK);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110414);
      }
    });
    this.kGN = ((Button)this.oFW.findViewById(b.e.cancel_btn));
    this.kGN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110415);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (a.this.DpP != null) {
          a.this.DpP.onCancel();
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
    if (this.DpN != null) {
      this.DpN.dismiss();
    }
    AppMethodBeat.o(110418);
  }
  
  public final void show()
  {
    AppMethodBeat.i(110417);
    Object localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null);
    Log.d("MicroMsg.TiemDatePicker", "mobile :".concat(String.valueOf(localObject)));
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      localObject = this.mContext;
      String str1 = this.mContext.getString(b.g.DoI);
      String str2 = this.mContext.getString(b.g.DoI);
      String str3 = this.mContext.getString(b.g.DoJ);
      String str4 = this.mContext.getString(b.g.app_cancel);
      DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110412);
          Intent localIntent = new Intent(a.this.mContext, BindMContactUI.class);
          localIntent.putExtra("bind_scene", 0);
          paramAnonymousDialogInterface = ((TelephonyManager)a.this.mContext.getSystemService("phone")).getSimCountryIso();
          if (!Util.isNullOrNil(paramAnonymousDialogInterface))
          {
            paramAnonymousDialogInterface = com.tencent.mm.az.b.bw(paramAnonymousDialogInterface, a.this.mContext.getString(b.g.country_code));
            if (paramAnonymousDialogInterface != null)
            {
              localIntent.putExtra("country_name", paramAnonymousDialogInterface.lSz);
              localIntent.putExtra("couttry_code", paramAnonymousDialogInterface.lSy);
            }
          }
          Context localContext = a.this.mContext;
          Log.i("MicroMsg.TiemDatePicker", "startWizardActivity()");
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
      };
      DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110413);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(110413);
        }
      };
      int i = b.b.green_text_color;
      com.tencent.mm.ui.base.h.a((Context)localObject, false, str1, str2, str3, str4, local1, local2, i, i);
      AppMethodBeat.o(110417);
      return;
    }
    this.mZK = ((String)localObject);
    this.DpO.setText(this.mZK);
    if (this.DpN != null) {
      this.DpN.show();
    }
    AppMethodBeat.o(110417);
  }
  
  public static abstract interface a
  {
    public abstract void aLd(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.a
 * JD-Core Version:    0.7.0.1
 */