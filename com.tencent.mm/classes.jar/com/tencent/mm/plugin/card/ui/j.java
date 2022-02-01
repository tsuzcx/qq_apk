package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class j
{
  public Bitmap jas;
  public o jat;
  ImageView jau;
  View jav;
  View.OnClickListener jax;
  b nTp;
  public Bitmap nYK;
  float nYS;
  boolean ocd;
  MMActivity ofX;
  Bitmap ofY;
  TextView ofZ;
  TextView oga;
  View ogb;
  ImageView ogc;
  MMVerticalTextView ogd;
  MMVerticalTextView oge;
  ArrayList<Bitmap> ogf;
  String ogg;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113550);
    this.ocd = true;
    this.ofY = null;
    this.jat = null;
    this.nYS = 0.0F;
    this.ogf = new ArrayList();
    this.ogg = "";
    this.jax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113548);
        if ((paramAnonymousView.getId() == 2131303350) || (paramAnonymousView.getId() == 2131303346))
        {
          if ((j.this.jat != null) && (j.this.jat.isShowing())) {
            j.this.jat.dismiss();
          }
          if (!j.this.nTp.bOR()) {
            j.this.bSz();
          }
        }
        AppMethodBeat.o(113548);
      }
    };
    this.ofX = paramMMActivity;
    AppMethodBeat.o(113550);
  }
  
  private void aT(float paramFloat)
  {
    AppMethodBeat.i(113551);
    WindowManager.LayoutParams localLayoutParams = this.ofX.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.ofX.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113551);
  }
  
  public final void bSA()
  {
    AppMethodBeat.i(113554);
    if ((this.jat != null) && (this.jat.isShowing())) {
      this.jau.setImageBitmap(this.jas);
    }
    AppMethodBeat.o(113554);
  }
  
  public final void bSy()
  {
    AppMethodBeat.i(113552);
    if (this.nYS < 0.8F) {
      aT(0.8F);
    }
    AppMethodBeat.o(113552);
  }
  
  public final void bSz()
  {
    AppMethodBeat.i(113553);
    aT(this.nYS);
    AppMethodBeat.o(113553);
  }
  
  final void recycleBmpList()
  {
    AppMethodBeat.i(113555);
    if (this.ogf.size() > 2)
    {
      int i = this.ogf.size() - 1;
      while (i > 1)
      {
        l.T((Bitmap)this.ogf.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(113555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j
 * JD-Core Version:    0.7.0.1
 */