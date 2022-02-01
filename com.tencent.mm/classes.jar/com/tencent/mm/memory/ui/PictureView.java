package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.h;
import com.tencent.mm.memory.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public class PictureView
  extends ImageView
{
  private boolean DEBUG;
  private h nOF;
  private boolean nOG;
  private Runnable nOH;
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(156531);
    this.DEBUG = false;
    this.nOF = null;
    this.nOG = false;
    this.nOH = new PictureView.1(this);
    AppMethodBeat.o(156531);
  }
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(156532);
    this.DEBUG = false;
    this.nOF = null;
    this.nOG = false;
    this.nOH = new PictureView.1(this);
    AppMethodBeat.o(156532);
  }
  
  private void bwk()
  {
    AppMethodBeat.i(156538);
    removeCallbacks(this.nOH);
    if (this.DEBUG) {
      Log.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + Util.getStack().toString());
    }
    if (this.nOG)
    {
      AppMethodBeat.o(156538);
      return;
    }
    this.nOG = true;
    AppMethodBeat.o(156538);
  }
  
  private static String dv(Object paramObject)
  {
    AppMethodBeat.i(156533);
    if (paramObject == null)
    {
      AppMethodBeat.o(156533);
      return "NULL";
    }
    if ((paramObject instanceof a))
    {
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).bwj() + " " + ((a)paramObject).bwj().hashCode();
      AppMethodBeat.o(156533);
      return paramObject;
    }
    paramObject = String.valueOf(paramObject);
    AppMethodBeat.o(156533);
    return paramObject;
  }
  
  private static void dw(Object paramObject)
  {
    AppMethodBeat.i(156536);
    if ((paramObject != null) && ((paramObject instanceof h))) {
      ((h)paramObject).bvM();
    }
    AppMethodBeat.o(156536);
  }
  
  private static void dx(Object paramObject)
  {
    AppMethodBeat.i(156537);
    if ((paramObject != null) && ((paramObject instanceof h))) {
      ((h)paramObject).bvN();
    }
    AppMethodBeat.o(156537);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(156539);
    if (this.DEBUG) {
      Log.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + Util.getStack().toString());
    }
    if (!this.nOG)
    {
      AppMethodBeat.o(156539);
      return;
    }
    this.nOG = false;
    removeCallbacks(this.nOH);
    postDelayed(this.nOH, 500L);
    AppMethodBeat.o(156539);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(156540);
    super.onAttachedToWindow();
    bwk();
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
    bwk();
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
    removeCallbacks(this.nOH);
    if ((paramDrawable == null) || (paramDrawable.equals(this.nOF)))
    {
      AppMethodBeat.o(156535);
      return;
    }
    if (this.DEBUG) {
      Log.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + dv(this.nOF) + " new:" + dv(paramDrawable) + " " + Util.getStack().toString());
    }
    dx(this.nOF);
    if ((paramDrawable instanceof h)) {}
    for (this.nOF = ((h)paramDrawable);; this.nOF = null)
    {
      dw(paramDrawable);
      super.setImageDrawable(paramDrawable);
      AppMethodBeat.o(156535);
      return;
    }
  }
  
  public void setReleasableBitmap(m paramm)
  {
    AppMethodBeat.i(156534);
    if ((paramm == null) || (paramm.equals(this.nOF)))
    {
      AppMethodBeat.o(156534);
      return;
    }
    setImageBitmap(paramm.bvR());
    this.nOF = paramm;
    dw(this.nOF);
    AppMethodBeat.o(156534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.ui.PictureView
 * JD-Core Version:    0.7.0.1
 */