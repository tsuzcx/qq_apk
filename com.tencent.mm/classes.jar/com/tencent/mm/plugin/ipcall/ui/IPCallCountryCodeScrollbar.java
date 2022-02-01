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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.ui.base.v;

public class IPCallCountryCodeScrollbar
  extends View
{
  public static final String[] JMh = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  protected float JMi;
  protected int JMj;
  protected String[] JMk;
  private float JMl;
  private v JMm;
  private TextView JMn;
  private int JMo;
  private IPCallCountryCodeScrollbar.a JMp;
  private int dbk;
  private float mkn;
  private Paint paint;
  private float textSize;
  
  public IPCallCountryCodeScrollbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25725);
    this.JMl = 0.0F;
    this.JMk = new String[] { "↑" };
    this.JMi = 1.3F;
    this.JMj = 79;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.JMo = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 3.0F);
    paramAttributeSet = inflate(paramContext, getToastLayoutId(), null);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, this.JMj);
    this.JMm = new v(paramAttributeSet, i, i);
    this.JMn = ((TextView)paramAttributeSet.findViewById(R.h.show_head_toast_text));
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-11119018);
    this.paint.setTextAlign(Paint.Align.CENTER);
    AppMethodBeat.o(25725);
  }
  
  public final void aJl(String paramString)
  {
    AppMethodBeat.i(25724);
    String[] arrayOfString1 = JMh;
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
    k = this.JMk.length + 1;
    arrayOfString1 = new String[k];
    String[] arrayOfString2 = this.JMk;
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
    this.JMk = arrayOfString1;
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
    this.textSize = (m / (this.JMk.length * this.JMi));
    int n = getResources().getDimensionPixelSize(R.f.NormalTextSize);
    if (this.textSize > n) {
      this.textSize = n;
    }
    this.paint.setTextSize(this.textSize);
    if (this.JMl != this.textSize)
    {
      this.JMl = this.textSize;
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25723);
          if (IPCallCountryCodeScrollbar.this.JMk.length <= 0)
          {
            AppMethodBeat.o(25723);
            return;
          }
          int i = (int)IPCallCountryCodeScrollbar.a(IPCallCountryCodeScrollbar.this).measureText(IPCallCountryCodeScrollbar.this.JMk[(IPCallCountryCodeScrollbar.this.JMk.length - 1)]) + a.fromDPToPix(IPCallCountryCodeScrollbar.this.getContext(), 8);
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
      float f = (m - this.JMk.length * this.textSize * this.JMi) / 2.0F;
      i = j;
      while (i < this.JMk.length)
      {
        paramCanvas.drawText(this.JMk[i], k / 2.0F, this.textSize + f + i * this.textSize * this.JMi, this.paint);
        i += 1;
      }
      AppMethodBeat.o(25726);
      return;
    }
    while (i < this.JMk.length)
    {
      paramCanvas.drawText(this.JMk[i], k / 2.0F, this.textSize + i * this.textSize * this.JMi, this.paint);
      i += 1;
    }
    AppMethodBeat.o(25726);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(25727);
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.mkn = paramMotionEvent.getY();
      if (this.mkn < 0.0F) {
        this.mkn = 0.0F;
      }
      if (this.mkn > getMeasuredHeight()) {
        this.mkn = getMeasuredHeight();
      }
      setBackgroundDrawable(a.m(getContext(), R.g.scrollbar_bg));
      float f1 = this.mkn;
      float f2 = this.textSize * this.JMi;
      int j = (int)((f1 - (getMeasuredHeight() - this.JMk.length * f2) / 2.0F) / f2);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = i;
      if (i >= this.JMk.length) {
        j = this.JMk.length - 1;
      }
      this.dbk = j;
      if (this.dbk != -1) {
        break label262;
      }
      this.JMn.setText(R.l.scroll_bar_search);
      this.JMm.showAtLocation(this, 17, 0, 0);
      if (this.JMp != null)
      {
        if (this.dbk != -1) {
          break label281;
        }
        this.JMp.onScollBarTouch(a.bt(getContext(), R.l.scroll_bar_search));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        setBackgroundResource(0);
        this.JMm.dismiss();
      }
      AppMethodBeat.o(25727);
      return true;
      label262:
      this.JMn.setText(this.JMk[this.dbk]);
      break;
      label281:
      this.JMp.onScollBarTouch(this.JMk[this.dbk]);
    }
  }
  
  public void setOnScrollBarTouchListener(IPCallCountryCodeScrollbar.a parama)
  {
    this.JMp = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar
 * JD-Core Version:    0.7.0.1
 */