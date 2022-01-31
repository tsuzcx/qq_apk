package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class PictureView
  extends ImageView
{
  private boolean DEBUG = false;
  private Runnable dPA = new PictureView.1(this);
  private i dPy = null;
  private boolean dPz = false;
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Fj()
  {
    removeCallbacks(this.dPA);
    if (this.DEBUG) {
      y.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + bk.csb().toString());
    }
    if (this.dPz) {
      return;
    }
    this.dPz = true;
  }
  
  private static String au(Object paramObject)
  {
    if (paramObject == null) {
      return "NULL";
    }
    if ((paramObject instanceof a)) {
      return paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).Fi() + " " + ((a)paramObject).Fi().hashCode();
    }
    return String.valueOf(paramObject);
  }
  
  private static void av(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).EZ();
    }
  }
  
  private static void aw(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).Fa();
    }
  }
  
  private void onDetach()
  {
    if (this.DEBUG) {
      y.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + bk.csb().toString());
    }
    if (!this.dPz) {
      return;
    }
    this.dPz = false;
    removeCallbacks(this.dPA);
    postDelayed(this.dPA, 500L);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Fj();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    onDetach();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    Fj();
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    onDetach();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    removeCallbacks(this.dPA);
    if ((paramDrawable == null) || (paramDrawable.equals(this.dPy))) {
      return;
    }
    if (this.DEBUG) {
      y.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + au(this.dPy) + " new:" + au(paramDrawable) + " " + bk.csb().toString());
    }
    aw(this.dPy);
    if ((paramDrawable instanceof i)) {}
    for (this.dPy = ((i)paramDrawable);; this.dPy = null)
    {
      av(paramDrawable);
      super.setImageDrawable(paramDrawable);
      return;
    }
  }
  
  public void setReleasableBitmap(n paramn)
  {
    if ((paramn == null) || (paramn.equals(this.dPy))) {
      return;
    }
    setImageBitmap(paramn.Fe());
    this.dPy = paramn;
    av(this.dPy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.ui.PictureView
 * JD-Core Version:    0.7.0.1
 */