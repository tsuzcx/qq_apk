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
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/view/RoundEmojiView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "getRect", "()Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-emojisdk_release"})
public final class RoundEmojiView
  extends BaseEmojiView
{
  private final RectF ciQ;
  private final Path lP;
  
  public RoundEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105816);
    this.lP = new Path();
    this.ciQ = new RectF();
    AppMethodBeat.o(105816);
  }
  
  public final Path getPath()
  {
    return this.lP;
  }
  
  public final RectF getRect()
  {
    return this.ciQ;
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
    int i = getMeasuredWidth();
    Object localObject = getDrawable();
    p.g(localObject, "drawable");
    Drawable localDrawable;
    float f1;
    float f2;
    float f3;
    if (i >= ((Drawable)localObject).getBounds().right)
    {
      i = getMeasuredHeight();
      localObject = getDrawable();
      p.g(localObject, "drawable");
      if (i >= ((Drawable)localObject).getBounds().bottom)
      {
        localObject = this.ciQ;
        i = getMeasuredWidth();
        localDrawable = getDrawable();
        p.g(localDrawable, "drawable");
        f1 = (i - localDrawable.getBounds().right) / 2.0F;
        i = getMeasuredHeight();
        localDrawable = getDrawable();
        p.g(localDrawable, "drawable");
        f2 = (i - localDrawable.getBounds().bottom) / 2.0F;
        i = getMeasuredWidth();
        localDrawable = getDrawable();
        p.g(localDrawable, "drawable");
        f3 = (i - localDrawable.getBounds().right) / 2.0F;
        localDrawable = getDrawable();
        p.g(localDrawable, "drawable");
        float f4 = localDrawable.getBounds().right;
        i = getMeasuredHeight();
        localDrawable = getDrawable();
        p.g(localDrawable, "drawable");
        float f5 = (i - localDrawable.getBounds().bottom) / 2.0F;
        localDrawable = getDrawable();
        p.g(localDrawable, "drawable");
        ((RectF)localObject).set(f1, f2, f3 + f4, f5 + localDrawable.getBounds().bottom);
      }
    }
    for (;;)
    {
      this.lP.addRoundRect(this.ciQ, getMeasuredWidth() / 10.0F, getMeasuredHeight() / 10.0F, Path.Direction.CW);
      if (paramCanvas != null) {
        paramCanvas.save();
      }
      if (paramCanvas != null) {
        paramCanvas.clipPath(this.lP);
      }
      super.onDraw(paramCanvas);
      if (paramCanvas == null) {
        break;
      }
      paramCanvas.restore();
      AppMethodBeat.o(105815);
      return;
      i = getMeasuredWidth();
      localObject = getDrawable();
      p.g(localObject, "drawable");
      if (i >= ((Drawable)localObject).getBounds().right)
      {
        localObject = this.ciQ;
        i = getMeasuredWidth();
        localDrawable = getDrawable();
        p.g(localDrawable, "drawable");
        f1 = (i - localDrawable.getBounds().right) / 2.0F;
        i = getMeasuredWidth();
        localDrawable = getDrawable();
        p.g(localDrawable, "drawable");
        f2 = (i - localDrawable.getBounds().right) / 2.0F;
        localDrawable = getDrawable();
        p.g(localDrawable, "drawable");
        ((RectF)localObject).set(f1, 0.0F, f2 + localDrawable.getBounds().right, getMeasuredHeight());
      }
      else
      {
        i = getMeasuredHeight();
        localObject = getDrawable();
        p.g(localObject, "drawable");
        if (i >= ((Drawable)localObject).getBounds().bottom)
        {
          localObject = this.ciQ;
          i = getMeasuredHeight();
          localDrawable = getDrawable();
          p.g(localDrawable, "drawable");
          f1 = (i - localDrawable.getBounds().bottom) / 2.0F;
          f2 = getMeasuredWidth();
          i = getMeasuredHeight();
          localDrawable = getDrawable();
          p.g(localDrawable, "drawable");
          f3 = (i - localDrawable.getBounds().bottom) / 2.0F;
          localDrawable = getDrawable();
          p.g(localDrawable, "drawable");
          ((RectF)localObject).set(0.0F, f1, f2, f3 + localDrawable.getBounds().bottom);
        }
        else
        {
          this.ciQ.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
        }
      }
    }
    AppMethodBeat.o(105815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.view.RoundEmojiView
 * JD-Core Version:    0.7.0.1
 */