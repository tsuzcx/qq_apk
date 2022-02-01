package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.QImageView;

public class QPictureView
  extends QImageView
{
  private boolean DEBUG;
  private i hAE;
  private boolean hAF;
  private Runnable hAG;
  
  public QPictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(156547);
    this.DEBUG = false;
    this.hAE = null;
    this.hAF = false;
    this.hAG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156546);
        QPictureView.a(QPictureView.this);
        AppMethodBeat.o(156546);
      }
    };
    AppMethodBeat.o(156547);
  }
  
  public QPictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(156548);
    this.DEBUG = false;
    this.hAE = null;
    this.hAF = false;
    this.hAG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156546);
        QPictureView.a(QPictureView.this);
        AppMethodBeat.o(156546);
      }
    };
    AppMethodBeat.o(156548);
  }
  
  private void azm()
  {
    AppMethodBeat.i(156554);
    if (this.DEBUG) {
      ae.i("MicroMsg.QPictureView", "onAttach" + hashCode() + " " + bu.fpN().toString());
    }
    removeCallbacks(this.hAG);
    if (this.hAF)
    {
      AppMethodBeat.o(156554);
      return;
    }
    this.hAF = true;
    AppMethodBeat.o(156554);
  }
  
  private static String bT(Object paramObject)
  {
    AppMethodBeat.i(156549);
    if (paramObject == null)
    {
      AppMethodBeat.o(156549);
      return "NULL";
    }
    if ((paramObject instanceof a))
    {
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).azl() + " " + ((a)paramObject).azl().hashCode();
      AppMethodBeat.o(156549);
      return paramObject;
    }
    paramObject = String.valueOf(paramObject);
    AppMethodBeat.o(156549);
    return paramObject;
  }
  
  private static void bU(Object paramObject)
  {
    AppMethodBeat.i(156552);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).ayQ();
    }
    AppMethodBeat.o(156552);
  }
  
  private static void bV(Object paramObject)
  {
    AppMethodBeat.i(156553);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).ayR();
    }
    AppMethodBeat.o(156553);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(156555);
    if (this.DEBUG) {
      ae.i("MicroMsg.QPictureView", "onDetach " + hashCode() + " " + bu.fpN().toString());
    }
    if (!this.hAF)
    {
      AppMethodBeat.o(156555);
      return;
    }
    this.hAF = false;
    removeCallbacks(this.hAG);
    postDelayed(this.hAG, 500L);
    AppMethodBeat.o(156555);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(156556);
    super.onAttachedToWindow();
    azm();
    AppMethodBeat.o(156556);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(156557);
    super.onDetachedFromWindow();
    onDetach();
    AppMethodBeat.o(156557);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(156559);
    super.onFinishTemporaryDetach();
    azm();
    AppMethodBeat.o(156559);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(156558);
    super.onStartTemporaryDetach();
    onDetach();
    AppMethodBeat.o(156558);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(156551);
    removeCallbacks(this.hAG);
    if ((paramDrawable == null) || (paramDrawable.equals(this.hAE)))
    {
      AppMethodBeat.o(156551);
      return;
    }
    if (this.DEBUG) {
      ae.i("MicroMsg.QPictureView", "setImageDrawable " + hashCode() + " old: " + bT(this.hAE) + " new:" + bT(paramDrawable) + " " + bu.fpN().toString());
    }
    bV(this.hAE);
    if ((paramDrawable instanceof i)) {}
    for (this.hAE = ((i)paramDrawable);; this.hAE = null)
    {
      bU(paramDrawable);
      super.setImageDrawable(paramDrawable);
      AppMethodBeat.o(156551);
      return;
    }
  }
  
  public void setReleasableBitmap(n paramn)
  {
    AppMethodBeat.i(156550);
    if ((paramn == null) || (paramn.equals(this.hAE)))
    {
      AppMethodBeat.o(156550);
      return;
    }
    setImageBitmap(paramn.ayV());
    this.hAE = paramn;
    bU(this.hAE);
    AppMethodBeat.o(156550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.ui.QPictureView
 * JD-Core Version:    0.7.0.1
 */