package com.tencent.mm.plugin.groupsolitaire.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.h;

public final class a
{
  private Button gAJ;
  private Button gCY;
  String iOg;
  private View khe;
  private int lcC;
  private BottomSheetBehavior lcD;
  Context mContext;
  android.support.design.widget.a tyZ;
  private TextView tza;
  a tzb;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(110416);
    this.mContext = paramContext;
    this.khe = View.inflate(this.mContext, 2131494423, null);
    this.tyZ = new android.support.design.widget.a(this.mContext);
    this.tyZ.setContentView(this.khe);
    this.tyZ.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        a.this.tyZ = null;
      }
    });
    this.tza = ((TextView)this.khe.findViewById(2131303216));
    paramContext = (FrameLayout.LayoutParams)this.khe.getLayoutParams();
    paramContext.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 250);
    this.khe.setLayoutParams(paramContext);
    this.lcC = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 350);
    this.lcD = BottomSheetBehavior.l((View)this.khe.getParent());
    if (this.lcD != null)
    {
      this.lcD.J(this.lcC);
      this.lcD.mg = false;
    }
    this.gAJ = ((Button)this.khe.findViewById(2131302999));
    this.gAJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110414);
        if (a.this.tzb != null)
        {
          paramAnonymousView = a.this.tzb;
          a locala = a.this;
          ac.i("MicroMsg.TiemDatePicker", "[getPhoneNum] :%s", new Object[] { locala.iOg });
          paramAnonymousView.aii(locala.iOg);
        }
        AppMethodBeat.o(110414);
      }
    });
    this.gCY = ((Button)this.khe.findViewById(2131297690));
    this.gCY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110415);
        if (a.this.tzb != null) {
          a.this.tzb.onCancel();
        }
        AppMethodBeat.o(110415);
      }
    });
    AppMethodBeat.o(110416);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(110418);
    if (this.tyZ != null) {
      this.tyZ.dismiss();
    }
    AppMethodBeat.o(110418);
  }
  
  public final void show()
  {
    AppMethodBeat.i(110417);
    String str = (String)g.agR().agA().get(6, null);
    ac.d("MicroMsg.TiemDatePicker", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      h.a(this.mContext, false, this.mContext.getString(2131760087), this.mContext.getString(2131760087), this.mContext.getString(2131760089), this.mContext.getString(2131755691), new a.1(this), new a.2(this), 2131100464, 2131100464);
      AppMethodBeat.o(110417);
      return;
    }
    this.iOg = str;
    this.tza.setText(this.iOg);
    if (this.tyZ != null) {
      this.tyZ.show();
    }
    AppMethodBeat.o(110417);
  }
  
  public static abstract interface a
  {
    public abstract void aii(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.a
 * JD-Core Version:    0.7.0.1
 */