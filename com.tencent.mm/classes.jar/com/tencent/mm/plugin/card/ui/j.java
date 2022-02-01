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
  View.OnClickListener jwB;
  public Bitmap jww;
  public o jwx;
  ImageView jwy;
  View jwz;
  b oDm;
  public Bitmap oIG;
  float oIO;
  boolean oLY;
  MMActivity oPS;
  Bitmap oPT;
  TextView oPU;
  TextView oPV;
  View oPW;
  ImageView oPX;
  MMVerticalTextView oPY;
  MMVerticalTextView oPZ;
  ArrayList<Bitmap> oQa;
  String oQb;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113550);
    this.oLY = true;
    this.oPT = null;
    this.jwx = null;
    this.oIO = 0.0F;
    this.oQa = new ArrayList();
    this.oQb = "";
    this.jwB = new j.1(this);
    this.oPS = paramMMActivity;
    AppMethodBeat.o(113550);
  }
  
  private void aW(float paramFloat)
  {
    AppMethodBeat.i(113551);
    WindowManager.LayoutParams localLayoutParams = this.oPS.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.oPS.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113551);
  }
  
  public final void bYs()
  {
    AppMethodBeat.i(113552);
    if (this.oIO < 0.8F) {
      aW(0.8F);
    }
    AppMethodBeat.o(113552);
  }
  
  public final void bYt()
  {
    AppMethodBeat.i(113553);
    aW(this.oIO);
    AppMethodBeat.o(113553);
  }
  
  public final void bYu()
  {
    AppMethodBeat.i(113554);
    if ((this.jwx != null) && (this.jwx.isShowing())) {
      this.jwy.setImageBitmap(this.jww);
    }
    AppMethodBeat.o(113554);
  }
  
  final void recycleBmpList()
  {
    AppMethodBeat.i(113555);
    if (this.oQa.size() > 2)
    {
      int i = this.oQa.size() - 1;
      while (i > 1)
      {
        l.U((Bitmap)this.oQa.remove(i));
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