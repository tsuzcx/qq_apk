package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.d.b.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.emojicapture.a.b;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;

public final class CaptureDecoration
  extends FrameLayout
{
  private final Path jkG = new Path();
  private final RectF jpo = new RectF();
  private final float jpp;
  public MMEmojiView jpq;
  
  public CaptureDecoration(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CaptureDecoration(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jpp = paramContext.getResources().getDimension(a.b.preview_radius);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    g.k(paramCanvas, "canvas");
    this.jpo.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
    this.jkG.addRoundRect(this.jpo, this.jpp, this.jpp, Path.Direction.CW);
    paramCanvas.clipPath(this.jkG);
    super.dispatchDraw(paramCanvas);
  }
  
  public final void resume()
  {
    MMEmojiView localMMEmojiView = this.jpq;
    if (localMMEmojiView != null) {
      localMMEmojiView.resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration
 * JD-Core Version:    0.7.0.1
 */