package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

public class PictureView
  extends ImageView
{
  private boolean DEBUG;
  private i feX;
  private boolean feY;
  private Runnable feZ;
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115484);
    this.DEBUG = false;
    this.feX = null;
    this.feY = false;
    this.feZ = new PictureView.1(this);
    AppMethodBeat.o(115484);
  }
  
  public PictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(115485);
    this.DEBUG = false;
    this.feX = null;
    this.feY = false;
    this.feZ = new PictureView.1(this);
    AppMethodBeat.o(115485);
  }
  
  private void Yj()
  {
    AppMethodBeat.i(115491);
    removeCallbacks(this.feZ);
    if (this.DEBUG) {
      ab.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + bo.dtY().toString());
    }
    if (this.feY)
    {
      AppMethodBeat.o(115491);
      return;
    }
    this.feY = true;
    AppMethodBeat.o(115491);
  }
  
  private static String aO(Object paramObject)
  {
    AppMethodBeat.i(115486);
    if (paramObject == null)
    {
      AppMethodBeat.o(115486);
      return "NULL";
    }
    if ((paramObject instanceof a))
    {
      paramObject = paramObject + " hashcode " + paramObject.hashCode() + " " + ((a)paramObject).Yi() + " " + ((a)paramObject).Yi().hashCode();
      AppMethodBeat.o(115486);
      return paramObject;
    }
    paramObject = String.valueOf(paramObject);
    AppMethodBeat.o(115486);
    return paramObject;
  }
  
  private static void aP(Object paramObject)
  {
    AppMethodBeat.i(115489);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).XO();
    }
    AppMethodBeat.o(115489);
  }
  
  private static void aQ(Object paramObject)
  {
    AppMethodBeat.i(115490);
    if ((paramObject != null) && ((paramObject instanceof i))) {
      ((i)paramObject).XP();
    }
    AppMethodBeat.o(115490);
  }
  
  private void onDetach()
  {
    AppMethodBeat.i(115492);
    if (this.DEBUG) {
      ab.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + bo.dtY().toString());
    }
    if (!this.feY)
    {
      AppMethodBeat.o(115492);
      return;
    }
    this.feY = false;
    removeCallbacks(this.feZ);
    postDelayed(this.feZ, 500L);
    AppMethodBeat.o(115492);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(115493);
    super.onAttachedToWindow();
    Yj();
    AppMethodBeat.o(115493);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(115494);
    super.onDetachedFromWindow();
    onDetach();
    AppMethodBeat.o(115494);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(115496);
    super.onFinishTemporaryDetach();
    Yj();
    AppMethodBeat.o(115496);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(115495);
    super.onStartTemporaryDetach();
    onDetach();
    AppMethodBeat.o(115495);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(115488);
    removeCallbacks(this.feZ);
    if ((paramDrawable == null) || (paramDrawable.equals(this.feX)))
    {
      AppMethodBeat.o(115488);
      return;
    }
    if (this.DEBUG) {
      ab.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + aO(this.feX) + " new:" + aO(paramDrawable) + " " + bo.dtY().toString());
    }
    aQ(this.feX);
    if ((paramDrawable instanceof i)) {}
    for (this.feX = ((i)paramDrawable);; this.feX = null)
    {
      aP(paramDrawable);
      super.setImageDrawable(paramDrawable);
      AppMethodBeat.o(115488);
      return;
    }
  }
  
  public void setReleasableBitmap(n paramn)
  {
    AppMethodBeat.i(115487);
    if ((paramn == null) || (paramn.equals(this.feX)))
    {
      AppMethodBeat.o(115487);
      return;
    }
    setImageBitmap(paramn.XT());
    this.feX = paramn;
    aP(this.feX);
    AppMethodBeat.o(115487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.ui.PictureView
 * JD-Core Version:    0.7.0.1
 */