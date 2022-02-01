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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;

public class FrameAnimatorImageView
  extends ImageView
{
  private Runnable raX;
  private DrawFilter raY;
  
  public FrameAnimatorImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64218);
    this.raX = null;
    this.raY = new PaintFlagsDrawFilter(0, 3);
    AppMethodBeat.o(64218);
  }
  
  public FrameAnimatorImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64219);
    this.raX = null;
    this.raY = new PaintFlagsDrawFilter(0, 3);
    AppMethodBeat.o(64219);
  }
  
  public final void a(int paramInt, final a parama)
  {
    AppMethodBeat.i(64220);
    Object localObject = aj.getContext().getResources().getDrawable(paramInt);
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
          this.raX = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64217);
              parama.onStop();
              AppMethodBeat.o(64217);
            }
          };
          aq.n(this.raX, paramInt);
        }
      }
    }
    AppMethodBeat.o(64220);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(64224);
    paramCanvas.setDrawFilter(this.raY);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(64224);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(64223);
    aq.az(this.raX);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(64223);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(64221);
    aq.az(this.raX);
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(64221);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(64222);
    aq.az(this.raX);
    super.setImageResource(paramInt);
    AppMethodBeat.o(64222);
  }
  
  public static abstract interface a
  {
    public abstract void onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView
 * JD-Core Version:    0.7.0.1
 */