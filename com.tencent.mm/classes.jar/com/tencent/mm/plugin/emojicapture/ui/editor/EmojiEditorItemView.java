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
import com.tencent.mm.media.editor.a.a;
import com.tencent.mm.media.editor.a.f;
import com.tencent.mm.media.editor.c.c;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import com.tencent.mm.plugin.gif.h;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EmojiEditorItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "applyTouchMatrix", "", "m", "Landroid/graphics/Matrix;", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "matrix", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getTouchMatrix", "handleRemove", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setEditing", "editing", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public final class EmojiEditorItemView
  extends EmojiStatusView
  implements c.b
{
  private final String TAG;
  final c.a psP;
  
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
    this.psP = ((c.a)new com.tencent.mm.plugin.emojicapture.e.b((c.b)this));
    AppMethodBeat.o(777);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(769);
    k.h(paramRectF, "bounds");
    this.psP.a(paramRectF, paramFloat);
    AppMethodBeat.o(769);
  }
  
  public final a aqy()
  {
    return null;
  }
  
  public final com.tencent.mm.media.editor.a.b c(Matrix paramMatrix)
  {
    AppMethodBeat.i(163483);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(163483);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(163483);
        throw paramMatrix;
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
      Matrix localMatrix = new Matrix();
      localMatrix.set(this.psP.getTouchTracker().eY);
      if (paramMatrix != null) {
        localMatrix.postConcat(paramMatrix);
      }
      paramMatrix = (com.tencent.mm.media.editor.a.b)new com.tencent.mm.media.editor.a.d((Bitmap)localObject, localMatrix);
      AppMethodBeat.o(163483);
      return paramMatrix;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(163483);
        throw paramMatrix;
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.psP.getTouchTracker().eY);
      if (paramMatrix != null) {
        ((Matrix)localObject).postConcat(paramMatrix);
      }
      paramMatrix = getEmojiInfo();
      if (paramMatrix == null) {
        k.fOy();
      }
      paramMatrix = (com.tencent.mm.media.editor.a.b)new f(paramMatrix, (Matrix)localObject);
      AppMethodBeat.o(163483);
      return paramMatrix;
      if ((getDrawable() instanceof h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          paramMatrix = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(163483);
          throw paramMatrix;
        }
        f = ((h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final boolean cfT()
  {
    return false;
  }
  
  public final EditorItemContainer getItemContainer()
  {
    AppMethodBeat.i(771);
    Object localObject = getParent();
    k.g(localObject, "parent");
    if ((((ViewParent)localObject).getParent() instanceof EditorItemContainer))
    {
      localObject = getParent();
      k.g(localObject, "parent");
      localObject = ((ViewParent)localObject).getParent();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
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
    Matrix localMatrix = this.psP.getTouchTracker().eY;
    AppMethodBeat.o(775);
    return localMatrix;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(774);
    k.h(paramCanvas, "canvas");
    paramCanvas.save();
    this.psP.j(paramCanvas);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    paramCanvas.restore();
    this.psP.k(paramCanvas);
    AppMethodBeat.o(774);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(773);
    k.h(paramMotionEvent, "event");
    boolean bool = this.psP.R(paramMotionEvent);
    AppMethodBeat.o(773);
    return bool;
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(770);
    this.psP.setEditing(paramBoolean);
    AppMethodBeat.o(770);
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(772);
    super.setImageDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      this.psP.fk(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    }
    AppMethodBeat.o(772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView
 * JD-Core Version:    0.7.0.1
 */