package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.d.b.g;
import a.k;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import com.tencent.mm.plugin.emojicapture.e.f;
import com.tencent.mm.plugin.emojicapture.model.a.a;

public final class BitmapEditorItemView
  extends View
  implements c.b
{
  private Bitmap bitmap;
  private final c.a jpr = (c.a)new com.tencent.mm.plugin.emojicapture.e.b((c.b)this);
  
  public BitmapEditorItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BitmapEditorItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    g.k(paramRectF, "bounds");
    this.jpr.a(paramRectF, paramFloat);
  }
  
  public final a aKU()
  {
    if (this.bitmap == null) {
      return null;
    }
    return (a)new com.tencent.mm.plugin.emojicapture.model.a.b(this.bitmap, this.jpr.aJW().aqv);
  }
  
  public final Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public final EditorItemContainer getItemContainer()
  {
    if ((getParent() instanceof EditorItemContainer))
    {
      ViewParent localViewParent = getParent();
      if (localViewParent == null) {
        throw new k("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
      }
      return (EditorItemContainer)localViewParent;
    }
    return null;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    g.k(paramCanvas, "canvas");
    paramCanvas.save();
    this.jpr.h(paramCanvas);
    if (this.bitmap != null) {
      paramCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, null);
    }
    paramCanvas.restore();
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    g.k(paramMotionEvent, "event");
    return this.jpr.A(paramMotionEvent);
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    if (paramBitmap != null) {
      this.jpr.cF(paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    this.jpr.setEditing(paramBoolean);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.BitmapEditorItemView
 * JD-Core Version:    0.7.0.1
 */