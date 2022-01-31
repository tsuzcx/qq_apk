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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;

public class FrameAnimatorImageView
  extends ImageView
{
  private Runnable kks = null;
  private DrawFilter kkt = new PaintFlagsDrawFilter(0, 3);
  
  public FrameAnimatorImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FrameAnimatorImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(int paramInt, FrameAnimatorImageView.a parama)
  {
    Object localObject = ae.getContext().getResources().getDrawable(paramInt);
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
          this.kks = new FrameAnimatorImageView.1(this, parama);
          ai.l(this.kks, paramInt);
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(this.kkt);
    super.onDraw(paramCanvas);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    ai.S(this.kks);
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    ai.S(this.kks);
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    ai.S(this.kks);
    super.setImageResource(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView
 * JD-Core Version:    0.7.0.1
 */