package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.QImageView;

public class QPictureView
  extends QImageView
{
  private boolean DEBUG;
  private i feX;
  private boolean feY;
  private Runnable feZ;
  
  public QPictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115499);
    this.DEBUG = false;
    this.feX = null;
    this.feY = false;
    this.feZ = new QPictureView.1(this);
    AppMethodBeat.o(115499);
  }
  
  public QPictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(115500);
    this.DEBUG = false;
    this.feX = null;
    this.feY = false;
    this.feZ = new QPictureView.1(this);
    AppMethodBeat.o(115500);
  }
  
  private void Yj()
  {
    AppMethodBeat.i(115506);
    if (this.DEBUG) {
      ab.i("MicroMsg.QPictureView", "onAttach" + hashCode() + " " + bo.dtY().toString());
    }
    removeCallbacks(this.feZ);
    if (this.feY)
    {
      AppMethodBeat.o(115506);
      return;
    }
    this.feY = true;
    AppMethodBeat.o(115506);
  }
  
  private static String aO(Object paramObject)
  {
    AppMethodBeat.i(115501);
    if (paramObject == null)
    {
      AppMethodBeat.o(115501);
      return "NULL";
    }
    if ((paramObject instanceof a))
    {
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).Yi() + " " + ((a)paramObject).Yi().hashCode();
      AppMethodBeat.o(115501);
      return paramObject;
    }
    paramObject = String.valueOf(paramObject);
    AppMethodBeat.o(115501);
    return paramObject;
  }
  
  private static void aP(Object paramObject)
  {
    AppMethodBeat.i(115504);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).XO();
    }
    AppMethodBeat.o(115504);
  }
  
  private static void aQ(Object paramObject)
  {
    AppMethodBeat.i(115505);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).XP();
    }
    AppMethodBeat.o(115505);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(115507);
    if (this.DEBUG) {
      ab.i("MicroMsg.QPictureView", "onDetach " + hashCode() + " " + bo.dtY().toString());
    }
    if (!this.feY)
    {
      AppMethodBeat.o(115507);
      return;
    }
    this.feY = false;
    removeCallbacks(this.feZ);
    postDelayed(this.feZ, 500L);
    AppMethodBeat.o(115507);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(115508);
    super.onAttachedToWindow();
    Yj();
    AppMethodBeat.o(115508);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(115509);
    super.onDetachedFromWindow();
    onDetach();
    AppMethodBeat.o(115509);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(115511);
    super.onFinishTemporaryDetach();
    Yj();
    AppMethodBeat.o(115511);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(115510);
    super.onStartTemporaryDetach();
    onDetach();
    AppMethodBeat.o(115510);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(115503);
    removeCallbacks(this.feZ);
    if ((paramDrawable == null) || (paramDrawable.equals(this.feX)))
    {
      AppMethodBeat.o(115503);
      return;
    }
    if (this.DEBUG) {
      ab.i("MicroMsg.QPictureView", "setImageDrawable " + hashCode() + " old: " + aO(this.feX) + " new:" + aO(paramDrawable) + " " + bo.dtY().toString());
    }
    aQ(this.feX);
    if ((paramDrawable instanceof i)) {}
    for (this.feX = ((i)paramDrawable);; this.feX = null)
    {
      aP(paramDrawable);
      super.setImageDrawable(paramDrawable);
      AppMethodBeat.o(115503);
      return;
    }
  }
  
  public void setReleasableBitmap(n paramn)
  {
    AppMethodBeat.i(115502);
    if ((paramn == null) || (paramn.equals(this.feX)))
    {
      AppMethodBeat.o(115502);
      return;
    }
    setImageBitmap(paramn.XT());
    this.feX = paramn;
    aP(this.feX);
    AppMethodBeat.o(115502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.ui.QPictureView
 * JD-Core Version:    0.7.0.1
 */