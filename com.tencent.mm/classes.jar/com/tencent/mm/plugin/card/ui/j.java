package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
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
  public Bitmap gMJ;
  public o gMK;
  ImageView gML;
  View gMM;
  View.OnClickListener gMO;
  b klk;
  public Bitmap kqq;
  float kqy;
  boolean ktM;
  MMActivity kxD;
  Bitmap kxE;
  TextView kxF;
  TextView kxG;
  View kxH;
  ImageView kxI;
  MMVerticalTextView kxJ;
  MMVerticalTextView kxK;
  ArrayList<Bitmap> kxL;
  String kxM;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(88623);
    this.ktM = true;
    this.kxE = null;
    this.gMK = null;
    this.kqy = 0.0F;
    this.kxL = new ArrayList();
    this.kxM = "";
    this.gMO = new j.1(this);
    this.kxD = paramMMActivity;
    AppMethodBeat.o(88623);
  }
  
  private void aH(float paramFloat)
  {
    AppMethodBeat.i(88624);
    WindowManager.LayoutParams localLayoutParams = this.kxD.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.kxD.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(88624);
  }
  
  public final void beo()
  {
    AppMethodBeat.i(88625);
    if (this.kqy < 0.8F) {
      aH(0.8F);
    }
    AppMethodBeat.o(88625);
  }
  
  public final void bep()
  {
    AppMethodBeat.i(88626);
    aH(this.kqy);
    AppMethodBeat.o(88626);
  }
  
  public final void beq()
  {
    AppMethodBeat.i(88627);
    if ((this.gMK != null) && (this.gMK.isShowing())) {
      this.gML.setImageBitmap(this.gMJ);
    }
    AppMethodBeat.o(88627);
  }
  
  final void ber()
  {
    AppMethodBeat.i(88628);
    if (this.kxL.size() > 2)
    {
      int i = this.kxL.size() - 1;
      while (i > 1)
      {
        l.I((Bitmap)this.kxL.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(88628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j
 * JD-Core Version:    0.7.0.1
 */