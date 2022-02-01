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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;

public final class a
{
  private Button hJg;
  private Button hJh;
  String ioa;
  private View jGG;
  private int kBk;
  private BottomSheetBehavior kBl;
  Context mContext;
  android.support.design.widget.a sri;
  private TextView srj;
  a srk;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(110416);
    this.mContext = paramContext;
    this.jGG = View.inflate(this.mContext, 2131494423, null);
    this.sri = new android.support.design.widget.a(this.mContext);
    this.sri.setContentView(this.jGG);
    this.sri.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        a.this.sri = null;
      }
    });
    this.srj = ((TextView)this.jGG.findViewById(2131303216));
    paramContext = (FrameLayout.LayoutParams)this.jGG.getLayoutParams();
    paramContext.height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 250);
    this.jGG.setLayoutParams(paramContext);
    this.kBk = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 350);
    this.kBl = BottomSheetBehavior.l((View)this.jGG.getParent());
    if (this.kBl != null)
    {
      this.kBl.J(this.kBk);
      this.kBl.lh = false;
    }
    this.hJh = ((Button)this.jGG.findViewById(2131302999));
    this.hJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110414);
        if (a.this.srk != null)
        {
          paramAnonymousView = a.this.srk;
          a locala = a.this;
          ad.i("MicroMsg.TiemDatePicker", "[getPhoneNum] :%s", new Object[] { locala.ioa });
          paramAnonymousView.adq(locala.ioa);
        }
        AppMethodBeat.o(110414);
      }
    });
    this.hJg = ((Button)this.jGG.findViewById(2131297690));
    this.hJg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110415);
        if (a.this.srk != null) {
          a.this.srk.onCancel();
        }
        AppMethodBeat.o(110415);
      }
    });
    AppMethodBeat.o(110416);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(110418);
    if (this.sri != null) {
      this.sri.dismiss();
    }
    AppMethodBeat.o(110418);
  }
  
  public final void show()
  {
    AppMethodBeat.i(110417);
    String str = (String)g.afB().afk().get(6, null);
    ad.d("MicroMsg.TiemDatePicker", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      h.a(this.mContext, false, this.mContext.getString(2131760087), this.mContext.getString(2131760087), this.mContext.getString(2131760089), this.mContext.getString(2131755691), new a.1(this), new a.2(this), 2131100464, 2131100464);
      AppMethodBeat.o(110417);
      return;
    }
    this.ioa = str;
    this.srj.setText(this.ioa);
    if (this.sri != null) {
      this.sri.show();
    }
    AppMethodBeat.o(110417);
  }
  
  public static abstract interface a
  {
    public abstract void adq(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.a
 * JD-Core Version:    0.7.0.1
 */