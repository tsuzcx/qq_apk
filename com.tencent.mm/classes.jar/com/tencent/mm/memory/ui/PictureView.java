package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

public class PictureView
  extends ImageView
{
  private boolean DEBUG;
  private i hxQ;
  private boolean hxR;
  private Runnable hxS;
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(156531);
    this.DEBUG = false;
    this.hxQ = null;
    this.hxR = false;
    this.hxS = new Runnable()
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
    this.hxQ = null;
    this.hxR = false;
    this.hxS = new Runnable()
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
  
  private void ayX()
  {
    AppMethodBeat.i(156538);
    removeCallbacks(this.hxS);
    if (this.DEBUG) {
      ad.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + bt.flS().toString());
    }
    if (this.hxR)
    {
      AppMethodBeat.o(156538);
      return;
    }
    this.hxR = true;
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
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).ayW() + " " + ((a)paramObject).ayW().hashCode();
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
      ((i)paramObject).ayB();
    }
    AppMethodBeat.o(156536);
  }
  
  private static void bV(Object paramObject)
  {
    AppMethodBeat.i(156537);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).ayC();
    }
    AppMethodBeat.o(156537);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(156539);
    if (this.DEBUG) {
      ad.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + bt.flS().toString());
    }
    if (!this.hxR)
    {
      AppMethodBeat.o(156539);
      return;
    }
    this.hxR = false;
    removeCallbacks(this.hxS);
    postDelayed(this.hxS, 500L);
    AppMethodBeat.o(156539);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(156540);
    super.onAttachedToWindow();
    ayX();
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
    ayX();
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
    removeCallbacks(this.hxS);
    if ((paramDrawable == null) || (paramDrawable.equals(this.hxQ)))
    {
      AppMethodBeat.o(156535);
      return;
    }
    if (this.DEBUG) {
      ad.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + bT(this.hxQ) + " new:" + bT(paramDrawable) + " " + bt.flS().toString());
    }
    bV(this.hxQ);
    if ((paramDrawable instanceof i)) {}
    for (this.hxQ = ((i)paramDrawable);; this.hxQ = null)
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
    if ((paramn == null) || (paramn.equals(this.hxQ)))
    {
      AppMethodBeat.o(156534);
      return;
    }
    setImageBitmap(paramn.ayG());
    this.hxQ = paramn;
    bU(this.hxQ);
    AppMethodBeat.o(156534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.ui.PictureView
 * JD-Core Version:    0.7.0.1
 */