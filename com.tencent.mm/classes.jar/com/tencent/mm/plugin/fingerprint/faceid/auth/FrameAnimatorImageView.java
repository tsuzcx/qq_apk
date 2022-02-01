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
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;

public class FrameAnimatorImageView
  extends ImageView
{
  private Runnable sjr;
  private DrawFilter sjs;
  
  public FrameAnimatorImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64218);
    this.sjr = null;
    this.sjs = new PaintFlagsDrawFilter(0, 3);
    AppMethodBeat.o(64218);
  }
  
  public FrameAnimatorImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64219);
    this.sjr = null;
    this.sjs = new PaintFlagsDrawFilter(0, 3);
    AppMethodBeat.o(64219);
  }
  
  public final void a(int paramInt, final a parama)
  {
    AppMethodBeat.i(64220);
    Object localObject = ai.getContext().getResources().getDrawable(paramInt);
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
          this.sjr = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64217);
              parama.onStop();
              AppMethodBeat.o(64217);
            }
          };
          ap.n(this.sjr, paramInt);
        }
      }
    }
    AppMethodBeat.o(64220);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(64224);
    paramCanvas.setDrawFilter(this.sjs);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(64224);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(64223);
    ap.aB(this.sjr);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(64223);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(64221);
    ap.aB(this.sjr);
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(64221);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(64222);
    ap.aB(this.sjr);
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