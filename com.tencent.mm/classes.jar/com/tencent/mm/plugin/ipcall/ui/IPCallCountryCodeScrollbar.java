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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.ui.base.r;

public class IPCallCountryCodeScrollbar
  extends View
{
  public static final String[] DUY = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  protected float DUZ;
  protected int DVa;
  protected String[] DVb;
  private float DVc;
  private r DVd;
  private TextView DVe;
  private int DVf;
  private a DVg;
  private int bhr;
  private float jLb;
  private Paint paint;
  private float textSize;
  
  public IPCallCountryCodeScrollbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25725);
    this.DVc = 0.0F;
    this.DVb = new String[] { "↑" };
    this.DUZ = 1.3F;
    this.DVa = 79;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.DVf = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 3.0F);
    paramAttributeSet = inflate(paramContext, getToastLayoutId(), null);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, this.DVa);
    this.DVd = new r(paramAttributeSet, i, i);
    this.DVe = ((TextView)paramAttributeSet.findViewById(R.h.show_head_toast_text));
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-11119018);
    this.paint.setTextAlign(Paint.Align.CENTER);
    AppMethodBeat.o(25725);
  }
  
  public final void aMr(String paramString)
  {
    AppMethodBeat.i(25724);
    String[] arrayOfString1 = DUY;
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
    k = this.DVb.length + 1;
    arrayOfString1 = new String[k];
    String[] arrayOfString2 = this.DVb;
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
    this.DVb = arrayOfString1;
    AppMethodBeat.o(25724);
  }
  
  protected int getToastLayoutId()
  {
    return R.i.show_head_toast;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(25726);
    super.onDraw(paramCanvas);
    final int m = getMeasuredHeight();
    final int k = getMeasuredWidth();
    this.textSize = (m / (this.DVb.length * this.DUZ));
    int n = getResources().getDimensionPixelSize(R.f.NormalTextSize);
    if (this.textSize > n) {
      this.textSize = n;
    }
    this.paint.setTextSize(this.textSize);
    if (this.DVc != this.textSize)
    {
      this.DVc = this.textSize;
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25723);
          if (IPCallCountryCodeScrollbar.this.DVb.length <= 0)
          {
            AppMethodBeat.o(25723);
            return;
          }
          int i = (int)IPCallCountryCodeScrollbar.a(IPCallCountryCodeScrollbar.this).measureText(IPCallCountryCodeScrollbar.this.DVb[(IPCallCountryCodeScrollbar.this.DVb.length - 1)]) + a.fromDPToPix(IPCallCountryCodeScrollbar.this.getContext(), 8);
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
      float f = (m - this.DVb.length * this.textSize * this.DUZ) / 2.0F;
      i = j;
      while (i < this.DVb.length)
      {
        paramCanvas.drawText(this.DVb[i], k / 2.0F, this.textSize + f + i * this.textSize * this.DUZ, this.paint);
        i += 1;
      }
      AppMethodBeat.o(25726);
      return;
    }
    while (i < this.DVb.length)
    {
      paramCanvas.drawText(this.DVb[i], k / 2.0F, this.textSize + i * this.textSize * this.DUZ, this.paint);
      i += 1;
    }
    AppMethodBeat.o(25726);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(25727);
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.jLb = paramMotionEvent.getY();
      if (this.jLb < 0.0F) {
        this.jLb = 0.0F;
      }
      if (this.jLb > getMeasuredHeight()) {
        this.jLb = getMeasuredHeight();
      }
      setBackgroundDrawable(a.m(getContext(), R.g.scrollbar_bg));
      float f1 = this.jLb;
      float f2 = this.textSize * this.DUZ;
      int j = (int)((f1 - (getMeasuredHeight() - this.DVb.length * f2) / 2.0F) / f2);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = i;
      if (i >= this.DVb.length) {
        j = this.DVb.length - 1;
      }
      this.bhr = j;
      if (this.bhr != -1) {
        break label262;
      }
      this.DVe.setText(R.l.scroll_bar_search);
      this.DVd.showAtLocation(this, 17, 0, 0);
      if (this.DVg != null)
      {
        if (this.bhr != -1) {
          break label281;
        }
        this.DVg.KH(a.ba(getContext(), R.l.scroll_bar_search));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        setBackgroundResource(0);
        this.DVd.dismiss();
      }
      AppMethodBeat.o(25727);
      return true;
      label262:
      this.DVe.setText(this.DVb[this.bhr]);
      break;
      label281:
      this.DVg.KH(this.DVb[this.bhr]);
    }
  }
  
  public void setOnScrollBarTouchListener(a parama)
  {
    this.DVg = parama;
  }
  
  public static abstract interface a
  {
    public abstract void KH(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar
 * JD-Core Version:    0.7.0.1
 */