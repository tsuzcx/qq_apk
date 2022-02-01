package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.QImageView;

public class QPictureView
  extends QImageView
{
  private boolean DEBUG;
  private i iuL;
  private boolean iuM;
  private Runnable iuN;
  
  public QPictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(156547);
    this.DEBUG = false;
    this.iuL = null;
    this.iuM = false;
    this.iuN = new Runnable()
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
    this.iuL = null;
    this.iuM = false;
    this.iuN = new Runnable()
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
  
  private void aSs()
  {
    AppMethodBeat.i(156554);
    if (this.DEBUG) {
      Log.i("MicroMsg.QPictureView", "onAttach" + hashCode() + " " + Util.getStack().toString());
    }
    removeCallbacks(this.iuN);
    if (this.iuM)
    {
      AppMethodBeat.o(156554);
      return;
    }
    this.iuM = true;
    AppMethodBeat.o(156554);
  }
  
  private static String cd(Object paramObject)
  {
    AppMethodBeat.i(156549);
    if (paramObject == null)
    {
      AppMethodBeat.o(156549);
      return "NULL";
    }
    if ((paramObject instanceof a))
    {
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).aSr() + " " + ((a)paramObject).aSr().hashCode();
      AppMethodBeat.o(156549);
      return paramObject;
    }
    paramObject = String.valueOf(paramObject);
    AppMethodBeat.o(156549);
    return paramObject;
  }
  
  private static void ce(Object paramObject)
  {
    AppMethodBeat.i(156552);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).aRW();
    }
    AppMethodBeat.o(156552);
  }
  
  private static void cf(Object paramObject)
  {
    AppMethodBeat.i(156553);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).aRX();
    }
    AppMethodBeat.o(156553);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(156555);
    if (this.DEBUG) {
      Log.i("MicroMsg.QPictureView", "onDetach " + hashCode() + " " + Util.getStack().toString());
    }
    if (!this.iuM)
    {
      AppMethodBeat.o(156555);
      return;
    }
    this.iuM = false;
    removeCallbacks(this.iuN);
    postDelayed(this.iuN, 500L);
    AppMethodBeat.o(156555);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(156556);
    super.onAttachedToWindow();
    aSs();
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
    aSs();
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
    removeCallbacks(this.iuN);
    if ((paramDrawable == null) || (paramDrawable.equals(this.iuL)))
    {
      AppMethodBeat.o(156551);
      return;
    }
    if (this.DEBUG) {
      Log.i("MicroMsg.QPictureView", "setImageDrawable " + hashCode() + " old: " + cd(this.iuL) + " new:" + cd(paramDrawable) + " " + Util.getStack().toString());
    }
    cf(this.iuL);
    if ((paramDrawable instanceof i)) {}
    for (this.iuL = ((i)paramDrawable);; this.iuL = null)
    {
      ce(paramDrawable);
      super.setImageDrawable(paramDrawable);
      AppMethodBeat.o(156551);
      return;
    }
  }
  
  public void setReleasableBitmap(n paramn)
  {
    AppMethodBeat.i(156550);
    if ((paramn == null) || (paramn.equals(this.iuL)))
    {
      AppMethodBeat.o(156550);
      return;
    }
    setImageBitmap(paramn.aSb());
    this.iuL = paramn;
    ce(this.iuL);
    AppMethodBeat.o(156550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.ui.QPictureView
 * JD-Core Version:    0.7.0.1
 */