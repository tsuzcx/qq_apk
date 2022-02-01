package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.v;
import java.util.ArrayList;

public final class j
{
  MMActivity pVV;
  public Bitmap qjG;
  public v qjH;
  ImageView qjI;
  View qjJ;
  View.OnClickListener qjL;
  boolean wAg;
  Bitmap wDZ;
  TextView wEa;
  TextView wEb;
  View wEc;
  ImageView wEd;
  MMVerticalTextView wEe;
  MMVerticalTextView wEf;
  ArrayList<Bitmap> wEg;
  String wEh;
  com.tencent.mm.plugin.card.base.b wru;
  public Bitmap wwO;
  float wwW;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113550);
    this.wAg = true;
    this.wDZ = null;
    this.qjH = null;
    this.wwW = 0.0F;
    this.wEg = new ArrayList();
    this.wEh = "";
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113548);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/card/ui/CardPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((paramAnonymousView.getId() == a.d.popupwd_qrcode_iv) || (paramAnonymousView.getId() == a.d.popupwd_barcode_iv))
        {
          if ((j.this.qjH != null) && (j.this.qjH.isShowing())) {
            j.this.qjH.dismiss();
          }
          if (!j.this.wru.djs()) {
            j.this.dnb();
          }
        }
        a.a(this, "com/tencent/mm/plugin/card/ui/CardPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113548);
      }
    };
    this.pVV = paramMMActivity;
    AppMethodBeat.o(113550);
  }
  
  private void cf(float paramFloat)
  {
    AppMethodBeat.i(113551);
    WindowManager.LayoutParams localLayoutParams = this.pVV.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.pVV.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113551);
  }
  
  public final void dna()
  {
    AppMethodBeat.i(113552);
    if (this.wwW < 0.8F) {
      cf(0.8F);
    }
    AppMethodBeat.o(113552);
  }
  
  public final void dnb()
  {
    AppMethodBeat.i(113553);
    cf(this.wwW);
    AppMethodBeat.o(113553);
  }
  
  public final void dnc()
  {
    AppMethodBeat.i(113554);
    if ((this.qjH != null) && (this.qjH.isShowing())) {
      this.qjI.setImageBitmap(this.qjG);
    }
    AppMethodBeat.o(113554);
  }
  
  final void recycleBmpList()
  {
    AppMethodBeat.i(113555);
    if (this.wEg.size() > 2)
    {
      int i = this.wEg.size() - 1;
      while (i > 1)
      {
        l.ah((Bitmap)this.wEg.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(113555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j
 * JD-Core Version:    0.7.0.1
 */