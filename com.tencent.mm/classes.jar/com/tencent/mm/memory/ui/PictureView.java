package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;

public class PictureView
  extends ImageView
{
  private boolean DEBUG;
  private i hAE;
  private boolean hAF;
  private Runnable hAG;
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(156531);
    this.DEBUG = false;
    this.hAE = null;
    this.hAF = false;
    this.hAG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156530);
        PictureView.a(PictureView.this);
        AppMethodBeat.o(156530);
      }
    };
    AppMethodBeat.o(156531);
  }
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(156532);
    this.DEBUG = false;
    this.hAE = null;
    this.hAF = false;
    this.hAG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156530);
        PictureView.a(PictureView.this);
        AppMethodBeat.o(156530);
      }
    };
    AppMethodBeat.o(156532);
  }
  
  private void azm()
  {
    AppMethodBeat.i(156538);
    removeCallbacks(this.hAG);
    if (this.DEBUG) {
      ae.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + bu.fpN().toString());
    }
    if (this.hAF)
    {
      AppMethodBeat.o(156538);
      return;
    }
    this.hAF = true;
    AppMethodBeat.o(156538);
  }
  
  private static String bT(Object paramObject)
  {
    AppMethodBeat.i(156533);
    if (paramObject == null)
    {
      AppMethodBeat.o(156533);
      return "NULL";
    }
    if ((paramObject instanceof a))
    {
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).azl() + " " + ((a)paramObject).azl().hashCode();
      AppMethodBeat.o(156533);
      return paramObject;
    }
    paramObject = String.valueOf(paramObject);
    AppMethodBeat.o(156533);
    return paramObject;
  }
  
  private static void bU(Object paramObject)
  {
    AppMethodBeat.i(156536);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).ayQ();
    }
    AppMethodBeat.o(156536);
  }
  
  private static void bV(Object paramObject)
  {
    AppMethodBeat.i(156537);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).ayR();
    }
    AppMethodBeat.o(156537);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(156539);
    if (this.DEBUG) {
      ae.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + bu.fpN().toString());
    }
    if (!this.hAF)
    {
      AppMethodBeat.o(156539);
      return;
    }
    this.hAF = false;
    removeCallbacks(this.hAG);
    postDelayed(this.hAG, 500L);
    AppMethodBeat.o(156539);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(156540);
    super.onAttachedToWindow();
    azm();
    AppMethodBeat.o(156540);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(156541);
    super.onDetachedFromWindow();
    onDetach();
    AppMethodBeat.o(156541);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(156543);
    super.onFinishTemporaryDetach();
    azm();
    AppMethodBeat.o(156543);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(156542);
    super.onStartTemporaryDetach();
    onDetach();
    AppMethodBeat.o(156542);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(156535);
    removeCallbacks(this.hAG);
    if ((paramDrawable == null) || (paramDrawable.equals(this.hAE)))
    {
      AppMethodBeat.o(156535);
      return;
    }
    if (this.DEBUG) {
      ae.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + bT(this.hAE) + " new:" + bT(paramDrawable) + " " + bu.fpN().toString());
    }
    bV(this.hAE);
    if ((paramDrawable instanceof i)) {}
    for (this.hAE = ((i)paramDrawable);; this.hAE = null)
    {
      bU(paramDrawable);
      super.setImageDrawable(paramDrawable);
      AppMethodBeat.o(156535);
      return;
    }
  }
  
  public void setReleasableBitmap(n paramn)
  {
    AppMethodBeat.i(156534);
    if ((paramn == null) || (paramn.equals(this.hAE)))
    {
      AppMethodBeat.o(156534);
      return;
    }
    setImageBitmap(paramn.ayV());
    this.hAE = paramn;
    bU(this.hAE);
    AppMethodBeat.o(156534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.ui.PictureView
 * JD-Core Version:    0.7.0.1
 */