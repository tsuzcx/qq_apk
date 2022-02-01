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
import com.tencent.mm.aw.b.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class a
{
  private Button gXc;
  private Button gZv;
  String jki;
  private View kFh;
  private int lEa;
  private BottomSheetBehavior lEb;
  Context mContext;
  android.support.design.widget.a uNn;
  private TextView uNo;
  a uNp;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(110416);
    this.mContext = paramContext;
    this.kFh = View.inflate(this.mContext, 2131494423, null);
    this.uNn = new android.support.design.widget.a(this.mContext);
    this.uNn.setContentView(this.kFh);
    this.uNn.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        a.this.uNn = null;
      }
    });
    this.uNo = ((TextView)this.kFh.findViewById(2131303216));
    paramContext = (FrameLayout.LayoutParams)this.kFh.getLayoutParams();
    paramContext.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 250);
    this.kFh.setLayoutParams(paramContext);
    this.lEa = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 350);
    this.lEb = BottomSheetBehavior.l((View)this.kFh.getParent());
    if (this.lEb != null)
    {
      this.lEb.J(this.lEa);
      this.lEb.nZ = false;
    }
    this.gXc = ((Button)this.kFh.findViewById(2131302999));
    this.gXc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110414);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (a.this.uNp != null)
        {
          paramAnonymousView = a.this.uNp;
          localObject = a.this;
          ae.i("MicroMsg.TiemDatePicker", "[getPhoneNum] :%s", new Object[] { ((a)localObject).jki });
          paramAnonymousView.anW(((a)localObject).jki);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110414);
      }
    });
    this.gZv = ((Button)this.kFh.findViewById(2131297690));
    this.gZv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110415);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (a.this.uNp != null) {
          a.this.uNp.onCancel();
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
    if (this.uNn != null) {
      this.uNn.dismiss();
    }
    AppMethodBeat.o(110418);
  }
  
  public final void show()
  {
    AppMethodBeat.i(110417);
    String str = (String)g.ajR().ajA().get(6, null);
    ae.d("MicroMsg.TiemDatePicker", "mobile :".concat(String.valueOf(str)));
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
          if (!bu.isNullOrNil(paramAnonymousDialogInterface))
          {
            paramAnonymousDialogInterface = com.tencent.mm.aw.b.bq(paramAnonymousDialogInterface, a.this.mContext.getString(2131757950));
            if (paramAnonymousDialogInterface != null)
            {
              localIntent.putExtra("country_name", paramAnonymousDialogInterface.ihe);
              localIntent.putExtra("couttry_code", paramAnonymousDialogInterface.ihd);
            }
          }
          Context localContext = a.this.mContext;
          ae.i("MicroMsg.TiemDatePicker", "startWizardActivity()");
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
    this.jki = str;
    this.uNo.setText(this.jki);
    if (this.uNn != null) {
      this.uNn.show();
    }
    AppMethodBeat.o(110417);
  }
  
  public static abstract interface a
  {
    public abstract void anW(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.a
 * JD-Core Version:    0.7.0.1
 */