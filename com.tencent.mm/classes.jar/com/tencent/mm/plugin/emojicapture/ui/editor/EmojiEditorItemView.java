package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import com.tencent.mm.plugin.emojicapture.e.b;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EmojiEditorItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "applyTouchMatrix", "", "m", "Landroid/graphics/Matrix;", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getTouchMatrix", "handleRemove", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setEditing", "editing", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiEditorItemView
  extends EmojiStatusView
  implements c.b
{
  private final String TAG;
  final c.a ymD;
  
  public EmojiEditorItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmojiEditorItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmojiEditorItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(777);
    this.TAG = "MicroMsg.EmojiEditorItemView";
    this.ymD = ((c.a)new b((c.b)this));
    AppMethodBeat.o(777);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(769);
    s.u(paramRectF, "bounds");
    this.ymD.a(paramRectF, paramFloat);
    AppMethodBeat.o(769);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a dEP()
  {
    return null;
  }
  
  public final boolean dEQ()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a e(Matrix paramMatrix)
  {
    AppMethodBeat.i(269501);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(269501);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(269501);
        throw paramMatrix;
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
      Matrix localMatrix = new Matrix();
      localMatrix.set(this.ymD.getTouchTracker().matrix);
      if (paramMatrix != null) {
        localMatrix.postConcat(paramMatrix);
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c((Bitmap)localObject, localMatrix);
      AppMethodBeat.o(269501);
      return paramMatrix;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(269501);
        throw paramMatrix;
      }
      f = ((d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.ymD.getTouchTracker().matrix);
      if (paramMatrix != null) {
        ((Matrix)localObject).postConcat(paramMatrix);
      }
      paramMatrix = getEmojiInfo();
      s.checkNotNull(paramMatrix);
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new e(paramMatrix, (Matrix)localObject);
      AppMethodBeat.o(269501);
      return paramMatrix;
      if ((getDrawable() instanceof h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          paramMatrix = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(269501);
          throw paramMatrix;
        }
        f = ((h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final EditorItemContainer getItemContainer()
  {
    AppMethodBeat.i(771);
    if ((getParent().getParent() instanceof EditorItemContainer))
    {
      Object localObject = getParent().getParent();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
        AppMethodBeat.o(771);
        throw ((Throwable)localObject);
      }
      localObject = (EditorItemContainer)localObject;
      AppMethodBeat.o(771);
      return localObject;
    }
    AppMethodBeat.o(771);
    return null;
  }
  
  public final Matrix getTouchMatrix()
  {
    AppMethodBeat.i(775);
    Matrix localMatrix = this.ymD.getTouchTracker().matrix;
    AppMethodBeat.o(775);
    return localMatrix;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(774);
    s.u(paramCanvas, "canvas");
    paramCanvas.save();
    this.ymD.n(paramCanvas);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    paramCanvas.restore();
    this.ymD.o(paramCanvas);
    AppMethodBeat.o(774);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(773);
    s.u(paramMotionEvent, "event");
    boolean bool = this.ymD.Z(paramMotionEvent);
    AppMethodBeat.o(773);
    return bool;
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(770);
    this.ymD.setEditing(paramBoolean);
    AppMethodBeat.o(770);
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(772);
    super.setImageDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      this.ymD.gV(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    }
    AppMethodBeat.o(772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView
 * JD-Core Version:    0.7.0.1
 */