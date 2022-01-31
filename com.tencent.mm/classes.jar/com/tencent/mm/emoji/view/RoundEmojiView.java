package com.tencent.mm.emoji.view;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/view/RoundEmojiView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "getRect", "()Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-emojisdk_release"})
public final class RoundEmojiView
  extends BaseEmojiView
{
  private final Path eyD;
  private final RectF rect;
  
  public RoundEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63326);
    this.eyD = new Path();
    this.rect = new RectF();
    AppMethodBeat.o(63326);
  }
  
  public final Path getPath()
  {
    return this.eyD;
  }
  
  public final RectF getRect()
  {
    return this.rect;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(63325);
    int i = getMeasuredWidth();
    Object localObject = getDrawable();
    j.p(localObject, "drawable");
    Drawable localDrawable;
    float f1;
    float f2;
    float f3;
    if (i >= ((Drawable)localObject).getBounds().right)
    {
      i = getMeasuredHeight();
      localObject = getDrawable();
      j.p(localObject, "drawable");
      if (i >= ((Drawable)localObject).getBounds().bottom)
      {
        localObject = this.rect;
        i = getMeasuredWidth();
        localDrawable = getDrawable();
        j.p(localDrawable, "drawable");
        f1 = (i - localDrawable.getBounds().right) / 2.0F;
        i = getMeasuredHeight();
        localDrawable = getDrawable();
        j.p(localDrawable, "drawable");
        f2 = (i - localDrawable.getBounds().bottom) / 2.0F;
        i = getMeasuredWidth();
        localDrawable = getDrawable();
        j.p(localDrawable, "drawable");
        f3 = (i - localDrawable.getBounds().right) / 2.0F;
        localDrawable = getDrawable();
        j.p(localDrawable, "drawable");
        float f4 = localDrawable.getBounds().right;
        i = getMeasuredHeight();
        localDrawable = getDrawable();
        j.p(localDrawable, "drawable");
        float f5 = (i - localDrawable.getBounds().bottom) / 2.0F;
        localDrawable = getDrawable();
        j.p(localDrawable, "drawable");
        ((RectF)localObject).set(f1, f2, f3 + f4, f5 + localDrawable.getBounds().bottom);
      }
    }
    for (;;)
    {
      this.eyD.addRoundRect(this.rect, getMeasuredWidth() / 10.0F, getMeasuredHeight() / 10.0F, Path.Direction.CW);
      if (paramCanvas != null) {
        paramCanvas.save();
      }
      if (paramCanvas != null) {
        paramCanvas.clipPath(this.eyD);
      }
      super.onDraw(paramCanvas);
      if (paramCanvas == null) {
        break;
      }
      paramCanvas.restore();
      AppMethodBeat.o(63325);
      return;
      i = getMeasuredWidth();
      localObject = getDrawable();
      j.p(localObject, "drawable");
      if (i >= ((Drawable)localObject).getBounds().right)
      {
        localObject = this.rect;
        i = getMeasuredWidth();
        localDrawable = getDrawable();
        j.p(localDrawable, "drawable");
        f1 = (i - localDrawable.getBounds().right) / 2.0F;
        i = getMeasuredWidth();
        localDrawable = getDrawable();
        j.p(localDrawable, "drawable");
        f2 = (i - localDrawable.getBounds().right) / 2.0F;
        localDrawable = getDrawable();
        j.p(localDrawable, "drawable");
        ((RectF)localObject).set(f1, 0.0F, f2 + localDrawable.getBounds().right, getMeasuredHeight());
      }
      else
      {
        i = getMeasuredHeight();
        localObject = getDrawable();
        j.p(localObject, "drawable");
        if (i >= ((Drawable)localObject).getBounds().bottom)
        {
          localObject = this.rect;
          i = getMeasuredHeight();
          localDrawable = getDrawable();
          j.p(localDrawable, "drawable");
          f1 = (i - localDrawable.getBounds().bottom) / 2.0F;
          f2 = getMeasuredWidth();
          i = getMeasuredHeight();
          localDrawable = getDrawable();
          j.p(localDrawable, "drawable");
          f3 = (i - localDrawable.getBounds().bottom) / 2.0F;
          localDrawable = getDrawable();
          j.p(localDrawable, "drawable");
          ((RectF)localObject).set(0.0F, f1, f2, f3 + localDrawable.getBounds().bottom);
        }
        else
        {
          this.rect.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
        }
      }
    }
    AppMethodBeat.o(63325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.view.RoundEmojiView
 * JD-Core Version:    0.7.0.1
 */