package com.tencent.mm.emoji.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/view/RoundEmojiView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "getRect", "()Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RoundEmojiView
  extends BaseEmojiView
{
  private final RectF ekW;
  private final Path path;
  
  public RoundEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105816);
    this.path = new Path();
    this.ekW = new RectF();
    AppMethodBeat.o(105816);
  }
  
  public final Path getPath()
  {
    return this.path;
  }
  
  public final RectF getRect()
  {
    return this.ekW;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(105815);
    if (getDrawable() == null)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(105815);
      return;
    }
    if ((getMeasuredWidth() >= getDrawable().getBounds().right) && (getMeasuredHeight() >= getDrawable().getBounds().bottom)) {
      this.ekW.set((getMeasuredWidth() - getDrawable().getBounds().right) / 2.0F, (getMeasuredHeight() - getDrawable().getBounds().bottom) / 2.0F, (getMeasuredWidth() - getDrawable().getBounds().right) / 2.0F + getDrawable().getBounds().right, (getMeasuredHeight() - getDrawable().getBounds().bottom) / 2.0F + getDrawable().getBounds().bottom);
    }
    for (;;)
    {
      this.path.addRoundRect(this.ekW, getMeasuredWidth() / 10.0F, getMeasuredHeight() / 10.0F, Path.Direction.CW);
      if (paramCanvas != null) {
        paramCanvas.save();
      }
      if (paramCanvas != null) {
        paramCanvas.clipPath(this.path);
      }
      super.onDraw(paramCanvas);
      if (paramCanvas != null) {
        paramCanvas.restore();
      }
      AppMethodBeat.o(105815);
      return;
      if (getMeasuredWidth() >= getDrawable().getBounds().right) {
        this.ekW.set((getMeasuredWidth() - getDrawable().getBounds().right) / 2.0F, 0.0F, (getMeasuredWidth() - getDrawable().getBounds().right) / 2.0F + getDrawable().getBounds().right, getMeasuredHeight());
      } else if (getMeasuredHeight() >= getDrawable().getBounds().bottom) {
        this.ekW.set(0.0F, (getMeasuredHeight() - getDrawable().getBounds().bottom) / 2.0F, getMeasuredWidth(), (getMeasuredHeight() - getDrawable().getBounds().bottom) / 2.0F + getDrawable().getBounds().bottom);
      } else {
        this.ekW.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.view.RoundEmojiView
 * JD-Core Version:    0.7.0.1
 */