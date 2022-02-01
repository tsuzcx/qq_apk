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
  public Bitmap iAr;
  public o iAs;
  ImageView iAt;
  View iAu;
  View.OnClickListener iAw;
  MMActivity nCW;
  Bitmap nCX;
  TextView nCY;
  TextView nCZ;
  View nDa;
  ImageView nDb;
  MMVerticalTextView nDc;
  MMVerticalTextView nDd;
  ArrayList<Bitmap> nDe;
  String nDf;
  b nqp;
  public Bitmap nvK;
  float nvS;
  boolean nzc;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113550);
    this.nzc = true;
    this.nCX = null;
    this.iAs = null;
    this.nvS = 0.0F;
    this.nDe = new ArrayList();
    this.nDf = "";
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113548);
        if ((paramAnonymousView.getId() == 2131303350) || (paramAnonymousView.getId() == 2131303346))
        {
          if ((j.this.iAs != null) && (j.this.iAs.isShowing())) {
            j.this.iAs.dismiss();
          }
          if (!j.this.nqp.bHE()) {
            j.this.bLm();
          }
        }
        AppMethodBeat.o(113548);
      }
    };
    this.nCW = paramMMActivity;
    AppMethodBeat.o(113550);
  }
  
  private void aP(float paramFloat)
  {
    AppMethodBeat.i(113551);
    WindowManager.LayoutParams localLayoutParams = this.nCW.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.nCW.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113551);
  }
  
  public final void bLl()
  {
    AppMethodBeat.i(113552);
    if (this.nvS < 0.8F) {
      aP(0.8F);
    }
    AppMethodBeat.o(113552);
  }
  
  public final void bLm()
  {
    AppMethodBeat.i(113553);
    aP(this.nvS);
    AppMethodBeat.o(113553);
  }
  
  public final void bLn()
  {
    AppMethodBeat.i(113554);
    if ((this.iAs != null) && (this.iAs.isShowing())) {
      this.iAt.setImageBitmap(this.iAr);
    }
    AppMethodBeat.o(113554);
  }
  
  final void recycleBmpList()
  {
    AppMethodBeat.i(113555);
    if (this.nDe.size() > 2)
    {
      int i = this.nDe.size() - 1;
      while (i > 1)
      {
        l.T((Bitmap)this.nDe.remove(i));
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