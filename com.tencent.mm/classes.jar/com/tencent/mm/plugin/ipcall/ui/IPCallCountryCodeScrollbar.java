package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.o;

public class IPCallCountryCodeScrollbar
  extends View
{
  public static final String[] nSu = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  private int aRn;
  private float fad;
  private TextView nSA;
  private int nSB;
  private IPCallCountryCodeScrollbar.a nSC;
  protected float nSv;
  protected int nSw;
  protected String[] nSx;
  private float nSy;
  private o nSz;
  private Paint paint;
  private float textSize;
  
  public IPCallCountryCodeScrollbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22108);
    this.nSy = 0.0F;
    this.nSx = new String[] { "↑" };
    this.nSv = 1.3F;
    this.nSw = 79;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.nSB = BackwardSupportUtil.b.b(paramContext, 3.0F);
    paramAttributeSet = inflate(paramContext, getToastLayoutId(), null);
    int i = BackwardSupportUtil.b.b(paramContext, this.nSw);
    this.nSz = new o(paramAttributeSet, i, i);
    this.nSA = ((TextView)paramAttributeSet.findViewById(2131827784));
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-11119018);
    this.paint.setTextAlign(Paint.Align.CENTER);
    AppMethodBeat.o(22108);
  }
  
  public final void Rp(String paramString)
  {
    AppMethodBeat.i(22107);
    String[] arrayOfString1 = nSu;
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
    k = this.nSx.length + 1;
    arrayOfString1 = new String[k];
    String[] arrayOfString2 = this.nSx;
    int m = arrayOfString2.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      String str = arrayOfString2[j];
      if (str.equals(paramString))
      {
        AppMethodBeat.o(22107);
        return;
      }
      arrayOfString1[i] = str;
      j += 1;
      i += 1;
    }
    arrayOfString1[(k - 1)] = paramString;
    this.nSx = arrayOfString1;
    AppMethodBeat.o(22107);
  }
  
  protected int getToastLayoutId()
  {
    return 2130970734;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(22109);
    super.onDraw(paramCanvas);
    int m = getMeasuredHeight();
    int k = getMeasuredWidth();
    this.textSize = (m / (this.nSx.length * this.nSv));
    int n = getResources().getDimensionPixelSize(2131427809);
    if (this.textSize > n) {
      this.textSize = n;
    }
    this.paint.setTextSize(this.textSize);
    if (this.nSy != this.textSize)
    {
      this.nSy = this.textSize;
      post(new IPCallCountryCodeScrollbar.1(this, k, m));
    }
    if (this.textSize == n)
    {
      float f = (m - this.nSx.length * this.textSize * this.nSv) / 2.0F;
      i = j;
      while (i < this.nSx.length)
      {
        paramCanvas.drawText(this.nSx[i], k / 2.0F, this.textSize + f + i * this.textSize * this.nSv, this.paint);
        i += 1;
      }
      AppMethodBeat.o(22109);
      return;
    }
    while (i < this.nSx.length)
    {
      paramCanvas.drawText(this.nSx[i], k / 2.0F, this.textSize + i * this.textSize * this.nSv, this.paint);
      i += 1;
    }
    AppMethodBeat.o(22109);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(22110);
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.fad = paramMotionEvent.getY();
      if (this.fad < 0.0F) {
        this.fad = 0.0F;
      }
      if (this.fad > getMeasuredHeight()) {
        this.fad = getMeasuredHeight();
      }
      setBackgroundDrawable(a.k(getContext(), 2130840212));
      float f1 = this.fad;
      float f2 = this.textSize * this.nSv;
      int j = (int)((f1 - (getMeasuredHeight() - this.nSx.length * f2) / 2.0F) / f2);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = i;
      if (i >= this.nSx.length) {
        j = this.nSx.length - 1;
      }
      this.aRn = j;
      if (this.aRn != -1) {
        break label259;
      }
      this.nSA.setText(2131302955);
      this.nSz.showAtLocation(this, 17, 0, 0);
      if (this.nSC != null)
      {
        if (this.aRn != -1) {
          break label278;
        }
        this.nSC.lf(a.aq(getContext(), 2131302955));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        setBackgroundResource(0);
        this.nSz.dismiss();
      }
      AppMethodBeat.o(22110);
      return true;
      label259:
      this.nSA.setText(this.nSx[this.aRn]);
      break;
      label278:
      this.nSC.lf(this.nSx[this.aRn]);
    }
  }
  
  public void setOnScrollBarTouchListener(IPCallCountryCodeScrollbar.a parama)
  {
    this.nSC = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar
 * JD-Core Version:    0.7.0.1
 */