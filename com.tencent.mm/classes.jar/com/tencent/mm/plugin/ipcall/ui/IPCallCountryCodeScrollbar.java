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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.o;

public class IPCallCountryCodeScrollbar
  extends View
{
  public static final String[] lvd = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  private int aJH;
  private float dOB;
  private Paint gaZ;
  protected float lve = 1.3F;
  protected int lvf = 79;
  protected String[] lvg = { "↑" };
  private float lvh = 0.0F;
  private float lvi;
  private o lvj;
  private TextView lvk;
  private int lvl;
  private IPCallCountryCodeScrollbar.a lvm;
  
  public IPCallCountryCodeScrollbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.lvl = BackwardSupportUtil.b.b(paramContext, 3.0F);
    paramAttributeSet = inflate(paramContext, getToastLayoutId(), null);
    int i = BackwardSupportUtil.b.b(paramContext, this.lvf);
    this.lvj = new o(paramAttributeSet, i, i);
    this.lvk = ((TextView)paramAttributeSet.findViewById(R.h.show_head_toast_text));
    this.gaZ = new Paint();
    this.gaZ.setAntiAlias(true);
    this.gaZ.setColor(-11119018);
    this.gaZ.setTextAlign(Paint.Align.CENTER);
  }
  
  public final void FN(String paramString)
  {
    String[] arrayOfString1 = lvd;
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
    k = this.lvg.length + 1;
    arrayOfString1 = new String[k];
    String[] arrayOfString2 = this.lvg;
    int m = arrayOfString2.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      String str = arrayOfString2[j];
      if (str.equals(paramString)) {
        return;
      }
      arrayOfString1[i] = str;
      j += 1;
      i += 1;
    }
    arrayOfString1[(k - 1)] = paramString;
    this.lvg = arrayOfString1;
  }
  
  protected int getToastLayoutId()
  {
    return R.i.show_head_toast;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    int j = 0;
    super.onDraw(paramCanvas);
    int m = getMeasuredHeight();
    int k = getMeasuredWidth();
    this.dOB = (m / (this.lvg.length * this.lve));
    int n = getResources().getDimensionPixelSize(R.f.NormalTextSize);
    if (this.dOB > n) {
      this.dOB = n;
    }
    this.gaZ.setTextSize(this.dOB);
    if (this.lvh != this.dOB)
    {
      this.lvh = this.dOB;
      post(new IPCallCountryCodeScrollbar.1(this, k, m));
    }
    if (this.dOB == n)
    {
      float f = (m - this.lvg.length * this.dOB * this.lve) / 2.0F;
      i = j;
      while (i < this.lvg.length)
      {
        paramCanvas.drawText(this.lvg[i], k / 2.0F, this.dOB + f + i * this.dOB * this.lve, this.gaZ);
        i += 1;
      }
    }
    while (i < this.lvg.length)
    {
      paramCanvas.drawText(this.lvg[i], k / 2.0F, this.dOB + i * this.dOB * this.lve, this.gaZ);
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.lvi = paramMotionEvent.getY();
      if (this.lvi < 0.0F) {
        this.lvi = 0.0F;
      }
      if (this.lvi > getMeasuredHeight()) {
        this.lvi = getMeasuredHeight();
      }
      setBackgroundDrawable(a.g(getContext(), R.g.scrollbar_bg));
      float f1 = this.lvi;
      float f2 = this.dOB * this.lve;
      int j = (int)((f1 - (getMeasuredHeight() - this.lvg.length * f2) / 2.0F) / f2);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = i;
      if (i >= this.lvg.length) {
        j = this.lvg.length - 1;
      }
      this.aJH = j;
      if (this.aJH != -1) {
        break label250;
      }
      this.lvk.setText(R.l.scroll_bar_search);
      this.lvj.showAtLocation(this, 17, 0, 0);
      if (this.lvm != null)
      {
        if (this.aJH != -1) {
          break label269;
        }
        this.lvm.eU(a.ac(getContext(), R.l.scroll_bar_search));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        setBackgroundResource(0);
        this.lvj.dismiss();
      }
      return true;
      label250:
      this.lvk.setText(this.lvg[this.aJH]);
      break;
      label269:
      this.lvm.eU(this.lvg[this.aJH]);
    }
  }
  
  public void setOnScrollBarTouchListener(IPCallCountryCodeScrollbar.a parama)
  {
    this.lvm = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar
 * JD-Core Version:    0.7.0.1
 */