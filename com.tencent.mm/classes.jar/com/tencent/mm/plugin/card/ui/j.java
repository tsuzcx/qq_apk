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
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;

public final class j
{
  public Bitmap kuJ;
  public p kuK;
  ImageView kuL;
  View kuM;
  View.OnClickListener kuO;
  com.tencent.mm.plugin.card.base.b pQV;
  float pWC;
  public Bitmap pWu;
  boolean pZM;
  MMActivity qdG;
  Bitmap qdH;
  TextView qdI;
  TextView qdJ;
  View qdK;
  ImageView qdL;
  MMVerticalTextView qdM;
  MMVerticalTextView qdN;
  ArrayList<Bitmap> qdO;
  String qdP;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113550);
    this.pZM = true;
    this.qdH = null;
    this.kuK = null;
    this.pWC = 0.0F;
    this.qdO = new ArrayList();
    this.qdP = "";
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113548);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/card/ui/CardPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((paramAnonymousView.getId() == 2131306037) || (paramAnonymousView.getId() == 2131306033))
        {
          if ((j.this.kuK != null) && (j.this.kuK.isShowing())) {
            j.this.kuK.dismiss();
          }
          if (!j.this.pQV.csz()) {
            j.this.cwj();
          }
        }
        a.a(this, "com/tencent/mm/plugin/card/ui/CardPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113548);
      }
    };
    this.qdG = paramMMActivity;
    AppMethodBeat.o(113550);
  }
  
  private void bd(float paramFloat)
  {
    AppMethodBeat.i(113551);
    WindowManager.LayoutParams localLayoutParams = this.qdG.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.qdG.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113551);
  }
  
  public final void cwi()
  {
    AppMethodBeat.i(113552);
    if (this.pWC < 0.8F) {
      bd(0.8F);
    }
    AppMethodBeat.o(113552);
  }
  
  public final void cwj()
  {
    AppMethodBeat.i(113553);
    bd(this.pWC);
    AppMethodBeat.o(113553);
  }
  
  public final void cwk()
  {
    AppMethodBeat.i(113554);
    if ((this.kuK != null) && (this.kuK.isShowing())) {
      this.kuL.setImageBitmap(this.kuJ);
    }
    AppMethodBeat.o(113554);
  }
  
  final void recycleBmpList()
  {
    AppMethodBeat.i(113555);
    if (this.qdO.size() > 2)
    {
      int i = this.qdO.size() - 1;
      while (i > 1)
      {
        l.Z((Bitmap)this.qdO.remove(i));
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