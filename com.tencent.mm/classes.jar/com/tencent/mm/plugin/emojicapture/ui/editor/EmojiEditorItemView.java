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
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EmojiEditorItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "applyTouchMatrix", "", "m", "Landroid/graphics/Matrix;", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getTouchMatrix", "handleRemove", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setEditing", "editing", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public final class EmojiEditorItemView
  extends EmojiStatusView
  implements c.b
{
  private final String TAG;
  final c.a pXz;
  
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
    this.pXz = ((c.a)new b((c.b)this));
    AppMethodBeat.o(777);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(769);
    p.h(paramRectF, "bounds");
    this.pXz.a(paramRectF, paramFloat);
    AppMethodBeat.o(769);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(195142);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(195142);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(195142);
        throw paramMatrix;
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
      Matrix localMatrix = new Matrix();
      localMatrix.set(this.pXz.getTouchTracker().gR);
      if (paramMatrix != null) {
        localMatrix.postConcat(paramMatrix);
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c((Bitmap)localObject, localMatrix);
      AppMethodBeat.o(195142);
      return paramMatrix;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(195142);
        throw paramMatrix;
      }
      f = ((d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.pXz.getTouchTracker().gR);
      if (paramMatrix != null) {
        ((Matrix)localObject).postConcat(paramMatrix);
      }
      paramMatrix = getEmojiInfo();
      if (paramMatrix == null) {
        p.gfZ();
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new e(paramMatrix, (Matrix)localObject);
      AppMethodBeat.o(195142);
      return paramMatrix;
      if ((getDrawable() instanceof h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          paramMatrix = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(195142);
          throw paramMatrix;
        }
        f = ((h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a ckw()
  {
    return null;
  }
  
  public final boolean ckx()
  {
    return false;
  }
  
  public final EditorItemContainer getItemContainer()
  {
    AppMethodBeat.i(771);
    Object localObject = getParent();
    p.g(localObject, "parent");
    if ((((ViewParent)localObject).getParent() instanceof EditorItemContainer))
    {
      localObject = getParent();
      p.g(localObject, "parent");
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
    Matrix localMatrix = this.pXz.getTouchTracker().gR;
    AppMethodBeat.o(775);
    return localMatrix;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(774);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    this.pXz.j(paramCanvas);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    paramCanvas.restore();
    this.pXz.k(paramCanvas);
    AppMethodBeat.o(774);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(773);
    p.h(paramMotionEvent, "event");
    boolean bool = this.pXz.P(paramMotionEvent);
    AppMethodBeat.o(773);
    return bool;
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(770);
    this.pXz.setEditing(paramBoolean);
    AppMethodBeat.o(770);
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(772);
    super.setImageDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      this.pXz.fo(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    }
    AppMethodBeat.o(772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView
 * JD-Core Version:    0.7.0.1
 */