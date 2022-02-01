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
  public Bitmap jtB;
  public o jtC;
  ImageView jtD;
  View jtE;
  View.OnClickListener jtG;
  public Bitmap oCe;
  float oCm;
  boolean oFw;
  MMActivity oJq;
  Bitmap oJr;
  TextView oJs;
  TextView oJt;
  View oJu;
  ImageView oJv;
  MMVerticalTextView oJw;
  MMVerticalTextView oJx;
  ArrayList<Bitmap> oJy;
  String oJz;
  b owK;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113550);
    this.oFw = true;
    this.oJr = null;
    this.jtC = null;
    this.oCm = 0.0F;
    this.oJy = new ArrayList();
    this.oJz = "";
    this.jtG = new j.1(this);
    this.oJq = paramMMActivity;
    AppMethodBeat.o(113550);
  }
  
  private void aW(float paramFloat)
  {
    AppMethodBeat.i(113551);
    WindowManager.LayoutParams localLayoutParams = this.oJq.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.oJq.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113551);
  }
  
  public final void bXd()
  {
    AppMethodBeat.i(113552);
    if (this.oCm < 0.8F) {
      aW(0.8F);
    }
    AppMethodBeat.o(113552);
  }
  
  public final void bXe()
  {
    AppMethodBeat.i(113553);
    aW(this.oCm);
    AppMethodBeat.o(113553);
  }
  
  public final void bXf()
  {
    AppMethodBeat.i(113554);
    if ((this.jtC != null) && (this.jtC.isShowing())) {
      this.jtD.setImageBitmap(this.jtB);
    }
    AppMethodBeat.o(113554);
  }
  
  final void recycleBmpList()
  {
    AppMethodBeat.i(113555);
    if (this.oJy.size() > 2)
    {
      int i = this.oJy.size() - 1;
      while (i > 1)
      {
        l.T((Bitmap)this.oJy.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(113555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j
 * JD-Core Version:    0.7.0.1
 */