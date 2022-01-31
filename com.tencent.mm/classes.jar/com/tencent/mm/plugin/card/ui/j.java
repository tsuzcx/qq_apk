package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class j
{
  public Bitmap fve;
  public o fvf = null;
  public ImageView fvg;
  View fvh;
  View.OnClickListener fvj = new j.1(this);
  b ikk;
  public Bitmap ipj;
  float ipr = 0.0F;
  boolean isF = true;
  Bitmap iwA = null;
  TextView iwB;
  TextView iwC;
  View iwD;
  ImageView iwE;
  MMVerticalTextView iwF;
  MMVerticalTextView iwG;
  ArrayList<Bitmap> iwH = new ArrayList();
  String iwI = "";
  MMActivity iwz;
  
  public j(MMActivity paramMMActivity)
  {
    this.iwz = paramMMActivity;
  }
  
  private void ap(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.iwz.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.iwz.getWindow().setAttributes(localLayoutParams);
  }
  
  public final void aCe()
  {
    if (this.ipr < 0.8F) {
      ap(0.8F);
    }
  }
  
  public final void aCf()
  {
    ap(this.ipr);
  }
  
  final void aCg()
  {
    if (this.iwH.size() > 2)
    {
      int i = this.iwH.size() - 1;
      while (i > 1)
      {
        l.w((Bitmap)this.iwH.remove(i));
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j
 * JD-Core Version:    0.7.0.1
 */