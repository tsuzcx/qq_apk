package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.k;
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
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import com.tencent.mm.plugin.emojicapture.e.f;
import com.tencent.mm.plugin.emojicapture.model.a.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public final class EmojiEditorItemView
  extends MMAnimateView
  implements c.b
{
  private final String TAG = "MicroMsg.EmojiEditorItemView";
  private EmojiInfo hNs;
  private final com.tencent.mm.plugin.emojicapture.c.c.a jpr = (com.tencent.mm.plugin.emojicapture.c.c.a)new com.tencent.mm.plugin.emojicapture.e.b((c.b)this);
  
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
    setLayerType(1, null);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    a.d.b.g.k(paramRectF, "bounds");
    this.jpr.a(paramRectF, paramFloat);
  }
  
  public final a aKU()
  {
    if (this.hNs == null) {
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null) {
        throw new k("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
      }
      return (a)new com.tencent.mm.plugin.emojicapture.model.a.b(((BitmapDrawable)localObject).getBitmap(), this.jpr.aJW().aqv);
    }
    float f = 1.0F;
    if ((getDrawable() instanceof d))
    {
      localObject = getDrawable();
      if (localObject == null) {
        throw new k("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
      }
      f = ((d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.jpr.aJW().aqv);
      EmojiInfo localEmojiInfo = this.hNs;
      if (localEmojiInfo == null) {
        a.d.b.g.cUk();
      }
      return (a)new com.tencent.mm.plugin.emojicapture.model.a.c(localEmojiInfo, (Matrix)localObject);
      if ((getDrawable() instanceof h))
      {
        localObject = getDrawable();
        if (localObject == null) {
          throw new k("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
        }
        f = ((h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final EmojiInfo getEmojiInfo()
  {
    return this.hNs;
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
    a.d.b.g.k(paramCanvas, "canvas");
    paramCanvas.save();
    this.jpr.h(paramCanvas);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    paramCanvas.restore();
    this.jpr.i(paramCanvas);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a.d.b.g.k(paramMotionEvent, "event");
    return this.jpr.A(paramMotionEvent);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    this.jpr.setEditing(paramBoolean);
  }
  
  public final void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    a.d.b.g.k(paramEmojiInfo, "info");
    this.hNs = paramEmojiInfo;
    Object localObject = paramEmojiInfo.cwL();
    if ((paramEmojiInfo.cwH() == EmojiGroupInfo.uCR) || (paramEmojiInfo.cwH() == EmojiInfo.uCY) || (paramEmojiInfo.cwH() == EmojiInfo.uCX))
    {
      localObject = getContext();
      com.tencent.mm.plugin.emojicapture.model.c.a locala = com.tencent.mm.plugin.emojicapture.model.c.jko;
      setImageBitmap(paramEmojiInfo.t((Context)localObject, com.tencent.mm.plugin.emojicapture.model.c.aKd()));
      return;
    }
    if (paramEmojiInfo.cwC())
    {
      b(EmojiInfo.bv(getContext(), paramEmojiInfo.getName()), paramEmojiInfo.getName());
      return;
    }
    if ((paramEmojiInfo.cwI() & EmojiInfo.uDo) == EmojiInfo.uDo)
    {
      paramEmojiInfo = this.hNs;
      localObject = com.tencent.mm.kernel.g.t(PluginEmoji.class);
      a.d.b.g.j(localObject, "MMKernel.plugin(PluginEmoji::class.java)");
      localObject = ((PluginEmoji)localObject).getProvider().a(this.hNs);
      a.d.b.g.j(localObject, "MMKernel.plugin(PluginEm…ecodeEmojiData(emojiInfo)");
      this.hNs = paramEmojiInfo;
      try
      {
        if (!bk.bE((byte[])localObject)) {
          if (o.bz((byte[])localObject))
          {
            paramEmojiInfo = com.tencent.mm.kernel.g.t(PluginEmoji.class);
            a.d.b.g.j(paramEmojiInfo, "MMKernel.plugin(PluginEmoji::class.java)");
            paramEmojiInfo = ((PluginEmoji)paramEmojiInfo).getProvider();
            a.d.b.g.j(paramEmojiInfo, "MMKernel.plugin(PluginEmoji::class.java).provider");
            if (paramEmojiInfo.aHs())
            {
              paramEmojiInfo = (com.tencent.mm.plugin.gif.b)new h((byte[])localObject);
              if (!paramEmojiInfo.isRunning()) {
                paramEmojiInfo.reset();
              }
              setImageDrawable((Drawable)paramEmojiInfo);
              return;
            }
          }
        }
      }
      catch (MMGIFException paramEmojiInfo)
      {
        for (;;)
        {
          a(paramEmojiInfo);
          if (paramEmojiInfo.getErrorCode() != 103) {
            break label348;
          }
          y.d(this.TAG, "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
          paramEmojiInfo = com.tencent.mm.sdk.platformtools.c.bu((byte[])localObject);
          if (paramEmojiInfo == null) {
            break;
          }
          paramEmojiInfo.setDensity(getEmojiDensity());
          setImageBitmap(paramEmojiInfo);
          return;
          y.v(this.TAG, "set with gif");
          paramEmojiInfo = (com.tencent.mm.plugin.gif.b)new d((byte[])localObject);
        }
        y.w(this.TAG, "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { ((byte[])localObject).toString() });
        paramEmojiInfo = this.hNs;
        if (paramEmojiInfo != null) {
          paramEmojiInfo.cwA();
        }
        init();
        return;
        y.e(this.TAG, "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
        paramEmojiInfo = this.hNs;
        if (paramEmojiInfo != null) {
          paramEmojiInfo.cwA();
        }
        init();
        return;
      }
      catch (IOException paramEmojiInfo)
      {
        for (;;)
        {
          y.e(this.TAG, "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
        }
      }
      catch (NullPointerException paramEmojiInfo)
      {
        for (;;)
        {
          label348:
          y.e(this.TAG, "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
        }
      }
    }
    du((String)localObject, "");
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      this.jpr.cF(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView
 * JD-Core Version:    0.7.0.1
 */