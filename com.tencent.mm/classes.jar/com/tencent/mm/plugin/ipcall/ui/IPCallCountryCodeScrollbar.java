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
  public static final String[] uQI = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  private int bxN;
  private float gmL;
  private Paint paint;
  private float textSize;
  protected float uQJ;
  protected int uQK;
  protected String[] uQL;
  private float uQM;
  private o uQN;
  private TextView uQO;
  private int uQP;
  private a uQQ;
  
  public IPCallCountryCodeScrollbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25725);
    this.uQM = 0.0F;
    this.uQL = new String[] { "↑" };
    this.uQJ = 1.3F;
    this.uQK = 79;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.uQP = BackwardSupportUtil.b.g(paramContext, 3.0F);
    paramAttributeSet = inflate(paramContext, getToastLayoutId(), null);
    int i = BackwardSupportUtil.b.g(paramContext, this.uQK);
    this.uQN = new o(paramAttributeSet, i, i);
    this.uQO = ((TextView)paramAttributeSet.findViewById(2131304779));
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-11119018);
    this.paint.setTextAlign(Paint.Align.CENTER);
    AppMethodBeat.o(25725);
  }
  
  public final void anO(String paramString)
  {
    AppMethodBeat.i(25724);
    String[] arrayOfString1 = uQI;
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
    k = this.uQL.length + 1;
    arrayOfString1 = new String[k];
    String[] arrayOfString2 = this.uQL;
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
    this.uQL = arrayOfString1;
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
    this.textSize = (m / (this.uQL.length * this.uQJ));
    int n = getResources().getDimensionPixelSize(2131165517);
    if (this.textSize > n) {
      this.textSize = n;
    }
    this.paint.setTextSize(this.textSize);
    if (this.uQM != this.textSize)
    {
      this.uQM = this.textSize;
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25723);
          if (IPCallCountryCodeScrollbar.this.uQL.length <= 0)
          {
            AppMethodBeat.o(25723);
            return;
          }
          int i = (int)IPCallCountryCodeScrollbar.a(IPCallCountryCodeScrollbar.this).measureText(IPCallCountryCodeScrollbar.this.uQL[(IPCallCountryCodeScrollbar.this.uQL.length - 1)]) + a.fromDPToPix(IPCallCountryCodeScrollbar.this.getContext(), 8);
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
      float f = (m - this.uQL.length * this.textSize * this.uQJ) / 2.0F;
      i = j;
      while (i < this.uQL.length)
      {
        paramCanvas.drawText(this.uQL[i], k / 2.0F, this.textSize + f + i * this.textSize * this.uQJ, this.paint);
        i += 1;
      }
      AppMethodBeat.o(25726);
      return;
    }
    while (i < this.uQL.length)
    {
      paramCanvas.drawText(this.uQL[i], k / 2.0F, this.textSize + i * this.textSize * this.uQJ, this.paint);
      i += 1;
    }
    AppMethodBeat.o(25726);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(25727);
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.gmL = paramMotionEvent.getY();
      if (this.gmL < 0.0F) {
        this.gmL = 0.0F;
      }
      if (this.gmL > getMeasuredHeight()) {
        this.gmL = getMeasuredHeight();
      }
      setBackgroundDrawable(a.l(getContext(), 2131233914));
      float f1 = this.gmL;
      float f2 = this.textSize * this.uQJ;
      int j = (int)((f1 - (getMeasuredHeight() - this.uQL.length * f2) / 2.0F) / f2);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = i;
      if (i >= this.uQL.length) {
        j = this.uQL.length - 1;
      }
      this.bxN = j;
      if (this.bxN != -1) {
        break label259;
      }
      this.uQO.setText(2131762893);
      this.uQN.showAtLocation(this, 17, 0, 0);
      if (this.uQQ != null)
      {
        if (this.bxN != -1) {
          break label278;
        }
        this.uQQ.vc(a.az(getContext(), 2131762893));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        setBackgroundResource(0);
        this.uQN.dismiss();
      }
      AppMethodBeat.o(25727);
      return true;
      label259:
      this.uQO.setText(this.uQL[this.bxN]);
      break;
      label278:
      this.uQQ.vc(this.uQL[this.bxN]);
    }
  }
  
  public void setOnScrollBarTouchListener(a parama)
  {
    this.uQQ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void vc(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar
 * JD-Core Version:    0.7.0.1
 */