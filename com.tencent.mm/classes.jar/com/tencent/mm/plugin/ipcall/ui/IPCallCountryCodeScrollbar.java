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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.o;

public class IPCallCountryCodeScrollbar
  extends View
{
  public static final String[] tNV = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  private int bns;
  private float fTh;
  private Paint paint;
  protected float tNW;
  protected int tNX;
  protected String[] tNY;
  private float tNZ;
  private o tOa;
  private TextView tOb;
  private int tOc;
  private a tOd;
  private float textSize;
  
  public IPCallCountryCodeScrollbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25725);
    this.tNZ = 0.0F;
    this.tNY = new String[] { "↑" };
    this.tNW = 1.3F;
    this.tNX = 79;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.tOc = BackwardSupportUtil.b.g(paramContext, 3.0F);
    paramAttributeSet = inflate(paramContext, getToastLayoutId(), null);
    int i = BackwardSupportUtil.b.g(paramContext, this.tNX);
    this.tOa = new o(paramAttributeSet, i, i);
    this.tOb = ((TextView)paramAttributeSet.findViewById(2131304779));
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-11119018);
    this.paint.setTextAlign(Paint.Align.CENTER);
    AppMethodBeat.o(25725);
  }
  
  public final void ajb(String paramString)
  {
    AppMethodBeat.i(25724);
    String[] arrayOfString1 = tNV;
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
    k = this.tNY.length + 1;
    arrayOfString1 = new String[k];
    String[] arrayOfString2 = this.tNY;
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
    this.tNY = arrayOfString1;
    AppMethodBeat.o(25724);
  }
  
  protected int getToastLayoutId()
  {
    return 2131495439;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(25726);
    super.onDraw(paramCanvas);
    final int m = getMeasuredHeight();
    final int k = getMeasuredWidth();
    this.textSize = (m / (this.tNY.length * this.tNW));
    int n = getResources().getDimensionPixelSize(2131165517);
    if (this.textSize > n) {
      this.textSize = n;
    }
    this.paint.setTextSize(this.textSize);
    if (this.tNZ != this.textSize)
    {
      this.tNZ = this.textSize;
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25723);
          if (IPCallCountryCodeScrollbar.this.tNY.length <= 0)
          {
            AppMethodBeat.o(25723);
            return;
          }
          int i = (int)IPCallCountryCodeScrollbar.a(IPCallCountryCodeScrollbar.this).measureText(IPCallCountryCodeScrollbar.this.tNY[(IPCallCountryCodeScrollbar.this.tNY.length - 1)]) + a.fromDPToPix(IPCallCountryCodeScrollbar.this.getContext(), 8);
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
      float f = (m - this.tNY.length * this.textSize * this.tNW) / 2.0F;
      i = j;
      while (i < this.tNY.length)
      {
        paramCanvas.drawText(this.tNY[i], k / 2.0F, this.textSize + f + i * this.textSize * this.tNW, this.paint);
        i += 1;
      }
      AppMethodBeat.o(25726);
      return;
    }
    while (i < this.tNY.length)
    {
      paramCanvas.drawText(this.tNY[i], k / 2.0F, this.textSize + i * this.textSize * this.tNW, this.paint);
      i += 1;
    }
    AppMethodBeat.o(25726);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(25727);
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.fTh = paramMotionEvent.getY();
      if (this.fTh < 0.0F) {
        this.fTh = 0.0F;
      }
      if (this.fTh > getMeasuredHeight()) {
        this.fTh = getMeasuredHeight();
      }
      setBackgroundDrawable(a.l(getContext(), 2131233914));
      float f1 = this.fTh;
      float f2 = this.textSize * this.tNW;
      int j = (int)((f1 - (getMeasuredHeight() - this.tNY.length * f2) / 2.0F) / f2);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = i;
      if (i >= this.tNY.length) {
        j = this.tNY.length - 1;
      }
      this.bns = j;
      if (this.bns != -1) {
        break label259;
      }
      this.tOb.setText(2131762893);
      this.tOa.showAtLocation(this, 17, 0, 0);
      if (this.tOd != null)
      {
        if (this.bns != -1) {
          break label278;
        }
        this.tOd.sn(a.aw(getContext(), 2131762893));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        setBackgroundResource(0);
        this.tOa.dismiss();
      }
      AppMethodBeat.o(25727);
      return true;
      label259:
      this.tOb.setText(this.tNY[this.bns]);
      break;
      label278:
      this.tOd.sn(this.tNY[this.bns]);
    }
  }
  
  public void setOnScrollBarTouchListener(a parama)
  {
    this.tOd = parama;
  }
  
  public static abstract interface a
  {
    public abstract void sn(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar
 * JD-Core Version:    0.7.0.1
 */