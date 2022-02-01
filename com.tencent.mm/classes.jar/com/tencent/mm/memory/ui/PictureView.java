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
  private i gFh;
  private boolean gFi;
  private Runnable gFj;
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(156531);
    this.DEBUG = false;
    this.gFh = null;
    this.gFi = false;
    this.gFj = new Runnable()
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
    this.gFh = null;
    this.gFi = false;
    this.gFj = new Runnable()
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
  
  private void apt()
  {
    AppMethodBeat.i(156538);
    removeCallbacks(this.gFj);
    if (this.DEBUG) {
      ad.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + bt.eGN().toString());
    }
    if (this.gFi)
    {
      AppMethodBeat.o(156538);
      return;
    }
    this.gFi = true;
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
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).aps() + " " + ((a)paramObject).aps().hashCode();
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
      ((i)paramObject).aoX();
    }
    AppMethodBeat.o(156536);
  }
  
  private static void bV(Object paramObject)
  {
    AppMethodBeat.i(156537);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).aoY();
    }
    AppMethodBeat.o(156537);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(156539);
    if (this.DEBUG) {
      ad.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + bt.eGN().toString());
    }
    if (!this.gFi)
    {
      AppMethodBeat.o(156539);
      return;
    }
    this.gFi = false;
    removeCallbacks(this.gFj);
    postDelayed(this.gFj, 500L);
    AppMethodBeat.o(156539);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(156540);
    super.onAttachedToWindow();
    apt();
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
    apt();
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
    removeCallbacks(this.gFj);
    if ((paramDrawable == null) || (paramDrawable.equals(this.gFh)))
    {
      AppMethodBeat.o(156535);
      return;
    }
    if (this.DEBUG) {
      ad.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + bT(this.gFh) + " new:" + bT(paramDrawable) + " " + bt.eGN().toString());
    }
    bV(this.gFh);
    if ((paramDrawable instanceof i)) {}
    for (this.gFh = ((i)paramDrawable);; this.gFh = null)
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
    if ((paramn == null) || (paramn.equals(this.gFh)))
    {
      AppMethodBeat.o(156534);
      return;
    }
    setImageBitmap(paramn.apc());
    this.gFh = paramn;
    bU(this.gFh);
    AppMethodBeat.o(156534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.memory.ui.PictureView
 * JD-Core Version:    0.7.0.1
 */