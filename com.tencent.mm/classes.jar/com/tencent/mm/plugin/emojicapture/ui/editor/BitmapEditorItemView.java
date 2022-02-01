package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.a;
import com.tencent.mm.media.editor.a.d;
import com.tencent.mm.media.editor.c.c;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/BitmapEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "handleRemove", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "resume", "setEditing", "editing", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public final class BitmapEditorItemView
  extends View
  implements c.b
{
  private Bitmap bitmap;
  private final c.a oPD;
  
  public BitmapEditorItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BitmapEditorItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(684);
    this.oPD = ((c.a)new com.tencent.mm.plugin.emojicapture.e.b((c.b)this));
    AppMethodBeat.o(684);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(678);
    k.h(paramRectF, "bounds");
    this.oPD.a(paramRectF, paramFloat);
    AppMethodBeat.o(678);
  }
  
  public final a ajz()
  {
    return null;
  }
  
  public final boolean bYI()
  {
    return false;
  }
  
  public final com.tencent.mm.media.editor.a.b c(Matrix paramMatrix)
  {
    AppMethodBeat.i(163482);
    if (this.bitmap == null)
    {
      AppMethodBeat.o(163482);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.set(this.oPD.getTouchTracker().dY);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.media.editor.a.b)new d(this.bitmap, localMatrix);
    AppMethodBeat.o(163482);
    return paramMatrix;
  }
  
  public final Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public final EditorItemContainer getItemContainer()
  {
    AppMethodBeat.i(680);
    if ((getParent() instanceof EditorItemContainer))
    {
      Object localObject = getParent();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
        AppMethodBeat.o(680);
        throw ((Throwable)localObject);
      }
      localObject = (EditorItemContainer)localObject;
      AppMethodBeat.o(680);
      return localObject;
    }
    AppMethodBeat.o(680);
    return null;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(682);
    k.h(paramCanvas, "canvas");
    paramCanvas.save();
    this.oPD.j(paramCanvas);
    if (this.bitmap != null) {
      paramCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, null);
    }
    paramCanvas.restore();
    AppMethodBeat.o(682);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(681);
    k.h(paramMotionEvent, "event");
    boolean bool = this.oPD.T(paramMotionEvent);
    AppMethodBeat.o(681);
    return bool;
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(677);
    this.bitmap = paramBitmap;
    if (paramBitmap != null) {
      this.oPD.fh(paramBitmap.getWidth(), paramBitmap.getHeight());
    }
    AppMethodBeat.o(677);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(679);
    this.oPD.setEditing(paramBoolean);
    invalidate();
    AppMethodBeat.o(679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.BitmapEditorItemView
 * JD-Core Version:    0.7.0.1
 */