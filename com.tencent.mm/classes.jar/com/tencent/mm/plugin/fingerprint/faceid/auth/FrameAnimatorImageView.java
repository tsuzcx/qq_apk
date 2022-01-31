package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public class FrameAnimatorImageView
  extends ImageView
{
  private Runnable mFf;
  private DrawFilter mFg;
  
  public FrameAnimatorImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41355);
    this.mFf = null;
    this.mFg = new PaintFlagsDrawFilter(0, 3);
    AppMethodBeat.o(41355);
  }
  
  public FrameAnimatorImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41356);
    this.mFf = null;
    this.mFg = new PaintFlagsDrawFilter(0, 3);
    AppMethodBeat.o(41356);
  }
  
  public final void a(int paramInt, FrameAnimatorImageView.a parama)
  {
    AppMethodBeat.i(41357);
    Object localObject = ah.getContext().getResources().getDrawable(paramInt);
    setImageDrawable((Drawable)localObject);
    if ((localObject instanceof AnimationDrawable))
    {
      localObject = (AnimationDrawable)localObject;
      ((AnimationDrawable)localObject).start();
      if (((AnimationDrawable)localObject).isOneShot())
      {
        int i = 0;
        int j;
        for (paramInt = 0; i < ((AnimationDrawable)localObject).getNumberOfFrames(); paramInt = j + paramInt)
        {
          j = ((AnimationDrawable)localObject).getDuration(i);
          i += 1;
        }
        if (parama != null)
        {
          this.mFf = new FrameAnimatorImageView.1(this, parama);
          al.p(this.mFf, paramInt);
        }
      }
    }
    AppMethodBeat.o(41357);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(41361);
    paramCanvas.setDrawFilter(this.mFg);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(41361);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(41360);
    al.ae(this.mFf);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(41360);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(41358);
    al.ae(this.mFf);
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(41358);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(41359);
    al.ae(this.mFf);
    super.setImageResource(paramInt);
    AppMethodBeat.o(41359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView
 * JD-Core Version:    0.7.0.1
 */