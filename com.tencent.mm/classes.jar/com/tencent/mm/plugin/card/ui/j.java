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
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.r;
import java.util.ArrayList;

public final class j
{
  View nmA;
  View.OnClickListener nmC;
  public Bitmap nmx;
  public r nmy;
  ImageView nmz;
  com.tencent.mm.plugin.card.base.b tmU;
  public Bitmap tsr;
  float tsz;
  boolean tvI;
  MMActivity tzD;
  Bitmap tzE;
  TextView tzF;
  TextView tzG;
  View tzH;
  ImageView tzI;
  MMVerticalTextView tzJ;
  MMVerticalTextView tzK;
  ArrayList<Bitmap> tzL;
  String tzM;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113550);
    this.tvI = true;
    this.tzE = null;
    this.nmy = null;
    this.tsz = 0.0F;
    this.tzL = new ArrayList();
    this.tzM = "";
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113548);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/card/ui/CardPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((paramAnonymousView.getId() == a.d.popupwd_qrcode_iv) || (paramAnonymousView.getId() == a.d.popupwd_barcode_iv))
        {
          if ((j.this.nmy != null) && (j.this.nmy.isShowing())) {
            j.this.nmy.dismiss();
          }
          if (!j.this.tmU.cGa()) {
            j.this.cJL();
          }
        }
        a.a(this, "com/tencent/mm/plugin/card/ui/CardPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113548);
      }
    };
    this.tzD = paramMMActivity;
    AppMethodBeat.o(113550);
  }
  
  private void bc(float paramFloat)
  {
    AppMethodBeat.i(113551);
    WindowManager.LayoutParams localLayoutParams = this.tzD.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.tzD.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113551);
  }
  
  public final void cJK()
  {
    AppMethodBeat.i(113552);
    if (this.tsz < 0.8F) {
      bc(0.8F);
    }
    AppMethodBeat.o(113552);
  }
  
  public final void cJL()
  {
    AppMethodBeat.i(113553);
    bc(this.tsz);
    AppMethodBeat.o(113553);
  }
  
  public final void cJM()
  {
    AppMethodBeat.i(113554);
    if ((this.nmy != null) && (this.nmy.isShowing())) {
      this.nmz.setImageBitmap(this.nmx);
    }
    AppMethodBeat.o(113554);
  }
  
  final void recycleBmpList()
  {
    AppMethodBeat.i(113555);
    if (this.tzL.size() > 2)
    {
      int i = this.tzL.size() - 1;
      while (i > 1)
      {
        l.X((Bitmap)this.tzL.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(113555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j
 * JD-Core Version:    0.7.0.1
 */