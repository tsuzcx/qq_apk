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
import com.tencent.mm.au.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.groupsolitaire.b.e;
import com.tencent.mm.plugin.groupsolitaire.b.f;
import com.tencent.mm.plugin.groupsolitaire.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;
import junit.framework.Assert;

public final class a
{
  com.google.android.material.bottomsheet.a Jjv;
  private TextView Jjw;
  a Jjx;
  Context mContext;
  private Button nhC;
  private Button njI;
  String pWt;
  private View rootView;
  private int sRu;
  private BottomSheetBehavior sRv;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(110416);
    this.mContext = paramContext;
    this.rootView = View.inflate(this.mContext, b.f.Jil, null);
    this.Jjv = new com.google.android.material.bottomsheet.a(this.mContext);
    this.Jjv.setContentView(this.rootView);
    this.Jjv.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        a.this.Jjv = null;
      }
    });
    this.Jjw = ((TextView)this.rootView.findViewById(b.e.Jii));
    paramContext = (FrameLayout.LayoutParams)this.rootView.getLayoutParams();
    paramContext.height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 250);
    this.rootView.setLayoutParams(paramContext);
    this.sRu = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 350);
    this.sRv = BottomSheetBehavior.cC((View)this.rootView.getParent());
    if (this.sRv != null)
    {
      this.sRv.setPeekHeight(this.sRu);
      this.sRv.dqC = false;
    }
    this.nhC = ((Button)this.rootView.findViewById(b.e.ok_btn));
    this.nhC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110414);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (a.this.Jjx != null)
        {
          paramAnonymousView = a.this.Jjx;
          localObject = a.this;
          Log.i("MicroMsg.TiemDatePicker", "[getPhoneNum] :%s", new Object[] { ((a)localObject).pWt });
          paramAnonymousView.aHU(((a)localObject).pWt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110414);
      }
    });
    this.njI = ((Button)this.rootView.findViewById(b.e.cancel_btn));
    this.njI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110415);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (a.this.Jjx != null) {
          a.this.Jjx.onCancel();
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
    if (this.Jjv != null) {
      this.Jjv.dismiss();
    }
    AppMethodBeat.o(110418);
  }
  
  public final void show()
  {
    AppMethodBeat.i(110417);
    Object localObject = (String)h.baE().ban().d(6, null);
    Log.d("MicroMsg.TiemDatePicker", "mobile :".concat(String.valueOf(localObject)));
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      localObject = this.mContext;
      String str1 = this.mContext.getString(b.g.Jir);
      String str2 = this.mContext.getString(b.g.Jir);
      String str3 = this.mContext.getString(b.g.Jis);
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
            paramAnonymousDialogInterface = com.tencent.mm.au.b.bH(paramAnonymousDialogInterface, a.this.mContext.getString(b.g.country_code));
            if (paramAnonymousDialogInterface != null)
            {
              localIntent.putExtra("country_name", paramAnonymousDialogInterface.oLl);
              localIntent.putExtra("couttry_code", paramAnonymousDialogInterface.oLk);
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
            com.tencent.mm.hellhoundlib.a.a.a((Activity)localContext, c.a(4098, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker", "startBindActivity", "(Landroid/content/Context;Landroid/content/Intent;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
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
      k.a((Context)localObject, false, str1, str2, str3, str4, local1, local2, i, i);
      AppMethodBeat.o(110417);
      return;
    }
    this.pWt = ((String)localObject);
    this.Jjw.setText(this.pWt);
    if (this.Jjv != null) {
      this.Jjv.show();
    }
    AppMethodBeat.o(110417);
  }
  
  public static abstract interface a
  {
    public abstract void aHU(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.a
 * JD-Core Version:    0.7.0.1
 */