package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.h;
import com.tencent.mm.memory.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.QImageView;

public class QPictureView
  extends QImageView
{
  private boolean DEBUG;
  private h nOF;
  private boolean nOG;
  private Runnable nOH;
  
  public QPictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(156547);
    this.DEBUG = false;
    this.nOF = null;
    this.nOG = false;
    this.nOH = new QPictureView.1(this);
    AppMethodBeat.o(156547);
  }
  
  public QPictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(156548);
    this.DEBUG = false;
    this.nOF = null;
    this.nOG = false;
    this.nOH = new QPictureView.1(this);
    AppMethodBeat.o(156548);
  }
  
  private void bwk()
  {
    AppMethodBeat.i(156554);
    if (this.DEBUG) {
      Log.i("MicroMsg.QPictureView", "onAttach" + hashCode() + " " + Util.getStack().toString());
    }
    removeCallbacks(this.nOH);
    if (this.nOG)
    {
      AppMethodBeat.o(156554);
      return;
    }
    this.nOG = true;
    AppMethodBeat.o(156554);
  }
  
  private static String dv(Object paramObject)
  {
    AppMethodBeat.i(156549);
    if (paramObject == null)
    {
      AppMethodBeat.o(156549);
      return "NULL";
    }
    if ((paramObject instanceof a))
    {
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).bwj() + " " + ((a)paramObject).bwj().hashCode();
      AppMethodBeat.o(156549);
      return paramObject;
    }
    paramObject = String.valueOf(paramObject);
    AppMethodBeat.o(156549);
    return paramObject;
  }
  
  private static void dw(Object paramObject)
  {
    AppMethodBeat.i(156552);
    if ((paramObject != null) && ((paramObject instanceof h))) {
      ((h)paramObject).bvM();
    }
    AppMethodBeat.o(156552);
  }
  
  private static void dx(Object paramObject)
  {
    AppMethodBeat.i(156553);
    if ((paramObject != null) && ((paramObject instanceof h))) {
      ((h)paramObject).bvN();
    }
    AppMethodBeat.o(156553);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(156555);
    if (this.DEBUG) {
      Log.i("MicroMsg.QPictureView", "onDetach " + hashCode() + " " + Util.getStack().toString());
    }
    if (!this.nOG)
    {
      AppMethodBeat.o(156555);
      return;
    }
    this.nOG = false;
    removeCallbacks(this.nOH);
    postDelayed(this.nOH, 500L);
    AppMethodBeat.o(156555);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(156556);
    super.onAttachedToWindow();
    bwk();
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
    bwk();
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
    removeCallbacks(this.nOH);
    if ((paramDrawable == null) || (paramDrawable.equals(this.nOF)))
    {
      AppMethodBeat.o(156551);
      return;
    }
    if (this.DEBUG) {
      Log.i("MicroMsg.QPictureView", "setImageDrawable " + hashCode() + " old: " + dv(this.nOF) + " new:" + dv(paramDrawable) + " " + Util.getStack().toString());
    }
    dx(this.nOF);
    if ((paramDrawable instanceof h)) {}
    for (this.nOF = ((h)paramDrawable);; this.nOF = null)
    {
      dw(paramDrawable);
      super.setImageDrawable(paramDrawable);
      AppMethodBeat.o(156551);
      return;
    }
  }
  
  public void setReleasableBitmap(m paramm)
  {
    AppMethodBeat.i(156550);
    if ((paramm == null) || (paramm.equals(this.nOF)))
    {
      AppMethodBeat.o(156550);
      return;
    }
    setImageBitmap(paramm.bvR());
    this.nOF = paramm;
    dw(this.nOF);
    AppMethodBeat.o(156550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.ui.QPictureView
 * JD-Core Version:    0.7.0.1
 */