package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.ui.base.p;

public class IPCallCountryCodeScrollbar
  extends View
{
  public static final String[] yuU = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  private int bxP;
  private float haa;
  private Paint paint;
  private float textSize;
  protected float yuV;
  protected int yuW;
  protected String[] yuX;
  private float yuY;
  private p yuZ;
  private TextView yva;
  private int yvb;
  private a yvc;
  
  public IPCallCountryCodeScrollbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25725);
    this.yuY = 0.0F;
    this.yuX = new String[] { "↑" };
    this.yuV = 1.3F;
    this.yuW = 79;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.yvb = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 3.0F);
    paramAttributeSet = inflate(paramContext, getToastLayoutId(), null);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, this.yuW);
    this.yuZ = new p(paramAttributeSet, i, i);
    this.yva = ((TextView)paramAttributeSet.findViewById(2131307861));
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-11119018);
    this.paint.setTextAlign(Paint.Align.CENTER);
    AppMethodBeat.o(25725);
  }
  
  public final void aCk(String paramString)
  {
    AppMethodBeat.i(25724);
    String[] arrayOfString1 = yuU;
    int k = arrayOfString1.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (arrayOfString1[i].equals(paramString)) {
        j = 1;
      }
      i += 1;
    }
    if (j == 0) {
      paramString = "#";
    }
    k = this.yuX.length + 1;
    arrayOfString1 = new String[k];
    String[] arrayOfString2 = this.yuX;
    int m = arrayOfString2.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      String str = arrayOfString2[j];
      if (str.equals(paramString))
      {
        AppMethodBeat.o(25724);
        return;
      }
      arrayOfString1[i] = str;
      j += 1;
      i += 1;
    }
    arrayOfString1[(k - 1)] = paramString;
    this.yuX = arrayOfString1;
    AppMethodBeat.o(25724);
  }
  
  protected int getToastLayoutId()
  {
    return 2131496311;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(25726);
    super.onDraw(paramCanvas);
    final int m = getMeasuredHeight();
    final int k = getMeasuredWidth();
    this.textSize = (m / (this.yuX.length * this.yuV));
    int n = getResources().getDimensionPixelSize(2131165535);
    if (this.textSize > n) {
      this.textSize = n;
    }
    this.paint.setTextSize(this.textSize);
    if (this.yuY != this.textSize)
    {
      this.yuY = this.textSize;
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25723);
          if (IPCallCountryCodeScrollbar.this.yuX.length <= 0)
          {
            AppMethodBeat.o(25723);
            return;
          }
          int i = (int)IPCallCountryCodeScrollbar.a(IPCallCountryCodeScrollbar.this).measureText(IPCallCountryCodeScrollbar.this.yuX[(IPCallCountryCodeScrollbar.this.yuX.length - 1)]) + a.fromDPToPix(IPCallCountryCodeScrollbar.this.getContext(), 8);
          if (i > k)
          {
            ViewGroup.LayoutParams localLayoutParams = IPCallCountryCodeScrollbar.this.getLayoutParams();
            localLayoutParams.width = i;
            localLayoutParams.height = m;
            IPCallCountryCodeScrollbar.this.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(25723);
        }
      });
    }
    if (this.textSize == n)
    {
      float f = (m - this.yuX.length * this.textSize * this.yuV) / 2.0F;
      i = j;
      while (i < this.yuX.length)
      {
        paramCanvas.drawText(this.yuX[i], k / 2.0F, this.textSize + f + i * this.textSize * this.yuV, this.paint);
        i += 1;
      }
      AppMethodBeat.o(25726);
      return;
    }
    while (i < this.yuX.length)
    {
      paramCanvas.drawText(this.yuX[i], k / 2.0F, this.textSize + i * this.textSize * this.yuV, this.paint);
      i += 1;
    }
    AppMethodBeat.o(25726);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(25727);
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.haa = paramMotionEvent.getY();
      if (this.haa < 0.0F) {
        this.haa = 0.0F;
      }
      if (this.haa > getMeasuredHeight()) {
        this.haa = getMeasuredHeight();
      }
      setBackgroundDrawable(a.l(getContext(), 2131234746));
      float f1 = this.haa;
      float f2 = this.textSize * this.yuV;
      int j = (int)((f1 - (getMeasuredHeight() - this.yuX.length * f2) / 2.0F) / f2);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = i;
      if (i >= this.yuX.length) {
        j = this.yuX.length - 1;
      }
      this.bxP = j;
      if (this.bxP != -1) {
        break label259;
      }
      this.yva.setText(2131765029);
      this.yuZ.showAtLocation(this, 17, 0, 0);
      if (this.yvc != null)
      {
        if (this.bxP != -1) {
          break label278;
        }
        this.yvc.DP(a.aI(getContext(), 2131765029));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        setBackgroundResource(0);
        this.yuZ.dismiss();
      }
      AppMethodBeat.o(25727);
      return true;
      label259:
      this.yva.setText(this.yuX[this.bxP]);
      break;
      label278:
      this.yvc.DP(this.yuX[this.bxP]);
    }
  }
  
  public void setOnScrollBarTouchListener(a parama)
  {
    this.yvc = parama;
  }
  
  public static abstract interface a
  {
    public abstract void DP(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar
 * JD-Core Version:    0.7.0.1
 */