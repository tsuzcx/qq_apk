package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public class PictureView
  extends ImageView
{
  private boolean DEBUG;
  private i ljU;
  private boolean ljV;
  private Runnable ljW;
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(156531);
    this.DEBUG = false;
    this.ljU = null;
    this.ljV = false;
    this.ljW = new Runnable()
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
    this.ljU = null;
    this.ljV = false;
    this.ljW = new Runnable()
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
  
  private void bbp()
  {
    AppMethodBeat.i(156538);
    removeCallbacks(this.ljW);
    if (this.DEBUG) {
      Log.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + Util.getStack().toString());
    }
    if (this.ljV)
    {
      AppMethodBeat.o(156538);
      return;
    }
    this.ljV = true;
    AppMethodBeat.o(156538);
  }
  
  private static String cd(Object paramObject)
  {
    AppMethodBeat.i(156533);
    if (paramObject == null)
    {
      AppMethodBeat.o(156533);
      return "NULL";
    }
    if ((paramObject instanceof a))
    {
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).bbo() + " " + ((a)paramObject).bbo().hashCode();
      AppMethodBeat.o(156533);
      return paramObject;
    }
    paramObject = String.valueOf(paramObject);
    AppMethodBeat.o(156533);
    return paramObject;
  }
  
  private static void ce(Object paramObject)
  {
    AppMethodBeat.i(156536);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).baR();
    }
    AppMethodBeat.o(156536);
  }
  
  private static void cf(Object paramObject)
  {
    AppMethodBeat.i(156537);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).baS();
    }
    AppMethodBeat.o(156537);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(156539);
    if (this.DEBUG) {
      Log.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + Util.getStack().toString());
    }
    if (!this.ljV)
    {
      AppMethodBeat.o(156539);
      return;
    }
    this.ljV = false;
    removeCallbacks(this.ljW);
    postDelayed(this.ljW, 500L);
    AppMethodBeat.o(156539);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(156540);
    super.onAttachedToWindow();
    bbp();
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
    bbp();
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
    removeCallbacks(this.ljW);
    if ((paramDrawable == null) || (paramDrawable.equals(this.ljU)))
    {
      AppMethodBeat.o(156535);
      return;
    }
    if (this.DEBUG) {
      Log.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + cd(this.ljU) + " new:" + cd(paramDrawable) + " " + Util.getStack().toString());
    }
    cf(this.ljU);
    if ((paramDrawable instanceof i)) {}
    for (this.ljU = ((i)paramDrawable);; this.ljU = null)
    {
      ce(paramDrawable);
      super.setImageDrawable(paramDrawable);
      AppMethodBeat.o(156535);
      return;
    }
  }
  
  public void setReleasableBitmap(n paramn)
  {
    AppMethodBeat.i(156534);
    if ((paramn == null) || (paramn.equals(this.ljU)))
    {
      AppMethodBeat.o(156534);
      return;
    }
    setImageBitmap(paramn.baW());
    this.ljU = paramn;
    ce(this.ljU);
    AppMethodBeat.o(156534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.ui.PictureView
 * JD-Core Version:    0.7.0.1
 */