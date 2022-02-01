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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class a
{
  private Button hPX;
  private Button hSq;
  String kik;
  private View lJI;
  Context mContext;
  private int mLJ;
  private BottomSheetBehavior mLK;
  android.support.design.widget.a yfL;
  private TextView yfM;
  a yfN;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(110416);
    this.mContext = paramContext;
    this.lJI = View.inflate(this.mContext, 2131494996, null);
    this.yfL = new android.support.design.widget.a(this.mContext);
    this.yfL.setContentView(this.lJI);
    this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        a.this.yfL = null;
      }
    });
    this.yfM = ((TextView)this.lJI.findViewById(2131305884));
    paramContext = (FrameLayout.LayoutParams)this.lJI.getLayoutParams();
    paramContext.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 250);
    this.lJI.setLayoutParams(paramContext);
    this.mLJ = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 350);
    this.mLK = BottomSheetBehavior.l((View)this.lJI.getParent());
    if (this.mLK != null)
    {
      this.mLK.J(this.mLJ);
      this.mLK.ob = false;
    }
    this.hPX = ((Button)this.lJI.findViewById(2131305592));
    this.hPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110414);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (a.this.yfN != null)
        {
          paramAnonymousView = a.this.yfN;
          localObject = a.this;
          Log.i("MicroMsg.TiemDatePicker", "[getPhoneNum] :%s", new Object[] { ((a)localObject).kik });
          paramAnonymousView.aBp(((a)localObject).kik);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110414);
      }
    });
    this.hSq = ((Button)this.lJI.findViewById(2131297963));
    this.hSq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110415);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (a.this.yfN != null) {
          a.this.yfN.onCancel();
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
    if (this.yfL != null) {
      this.yfL.dismiss();
    }
    AppMethodBeat.o(110418);
  }
  
  public final void show()
  {
    AppMethodBeat.i(110417);
    String str = (String)g.aAh().azQ().get(6, null);
    Log.d("MicroMsg.TiemDatePicker", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      h.a(this.mContext, false, this.mContext.getString(2131761467), this.mContext.getString(2131761467), this.mContext.getString(2131761469), this.mContext.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110412);
          Intent localIntent = new Intent(a.this.mContext, BindMContactUI.class);
          localIntent.putExtra("bind_scene", 0);
          paramAnonymousDialogInterface = ((TelephonyManager)a.this.mContext.getSystemService("phone")).getSimCountryIso();
          if (!Util.isNullOrNil(paramAnonymousDialogInterface))
          {
            paramAnonymousDialogInterface = com.tencent.mm.aw.b.bs(paramAnonymousDialogInterface, a.this.mContext.getString(2131758198));
            if (paramAnonymousDialogInterface != null)
            {
              localIntent.putExtra("country_name", paramAnonymousDialogInterface.jbZ);
              localIntent.putExtra("couttry_code", paramAnonymousDialogInterface.jbY);
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
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110413);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(110413);
        }
      }, 2131100566, 2131100566);
      AppMethodBeat.o(110417);
      return;
    }
    this.kik = str;
    this.yfM.setText(this.kik);
    if (this.yfL != null) {
      this.yfL.show();
    }
    AppMethodBeat.o(110417);
  }
  
  public static abstract interface a
  {
    public abstract void aBp(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.a
 * JD-Core Version:    0.7.0.1
 */