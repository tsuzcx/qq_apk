package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;

public class PictureView
  extends ImageView
{
  private boolean DEBUG;
  private i hfI;
  private boolean hfJ;
  private Runnable hfK;
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(156531);
    this.DEBUG = false;
    this.hfI = null;
    this.hfJ = false;
    this.hfK = new PictureView.1(this);
    AppMethodBeat.o(156531);
  }
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(156532);
    this.DEBUG = false;
    this.hfI = null;
    this.hfJ = false;
    this.hfK = new PictureView.1(this);
    AppMethodBeat.o(156532);
  }
  
  private void awk()
  {
    AppMethodBeat.i(156538);
    removeCallbacks(this.hfK);
    if (this.DEBUG) {
      ac.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + bs.eWi().toString());
    }
    if (this.hfJ)
    {
      AppMethodBeat.o(156538);
      return;
    }
    this.hfJ = true;
    AppMethodBeat.o(156538);
  }
  
  private static String bR(Object paramObject)
  {
    AppMethodBeat.i(156533);
    if (paramObject == null)
    {
      AppMethodBeat.o(156533);
      return "NULL";
    }
    if ((paramObject instanceof a))
    {
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).awj() + " " + ((a)paramObject).awj().hashCode();
      AppMethodBeat.o(156533);
      return paramObject;
    }
    paramObject = String.valueOf(paramObject);
    AppMethodBeat.o(156533);
    return paramObject;
  }
  
  private static void bS(Object paramObject)
  {
    AppMethodBeat.i(156536);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).avO();
    }
    AppMethodBeat.o(156536);
  }
  
  private static void bT(Object paramObject)
  {
    AppMethodBeat.i(156537);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).avP();
    }
    AppMethodBeat.o(156537);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(156539);
    if (this.DEBUG) {
      ac.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + bs.eWi().toString());
    }
    if (!this.hfJ)
    {
      AppMethodBeat.o(156539);
      return;
    }
    this.hfJ = false;
    removeCallbacks(this.hfK);
    postDelayed(this.hfK, 500L);
    AppMethodBeat.o(156539);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(156540);
    super.onAttachedToWindow();
    awk();
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
    awk();
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
    removeCallbacks(this.hfK);
    if ((paramDrawable == null) || (paramDrawable.equals(this.hfI)))
    {
      AppMethodBeat.o(156535);
      return;
    }
    if (this.DEBUG) {
      ac.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + bR(this.hfI) + " new:" + bR(paramDrawable) + " " + bs.eWi().toString());
    }
    bT(this.hfI);
    if ((paramDrawable instanceof i)) {}
    for (this.hfI = ((i)paramDrawable);; this.hfI = null)
    {
      bS(paramDrawable);
      super.setImageDrawable(paramDrawable);
      AppMethodBeat.o(156535);
      return;
    }
  }
  
  public void setReleasableBitmap(n paramn)
  {
    AppMethodBeat.i(156534);
    if ((paramn == null) || (paramn.equals(this.hfI)))
    {
      AppMethodBeat.o(156534);
      return;
    }
    setImageBitmap(paramn.avT());
    this.hfI = paramn;
    bS(this.hfI);
    AppMethodBeat.o(156534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.ui.PictureView
 * JD-Core Version:    0.7.0.1
 */