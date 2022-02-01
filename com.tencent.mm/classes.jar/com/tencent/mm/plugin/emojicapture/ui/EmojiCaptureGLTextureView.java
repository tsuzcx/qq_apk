package com.tencent.mm.plugin.emojicapture.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView;
import com.tencent.mm.plugin.emojicapture.ui.b.e;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureGLTextureView
  extends CameraPreviewGLTextureView
{
  public static final EmojiCaptureGLTextureView.a rrN;
  
  static
  {
    AppMethodBeat.i(435);
    rrN = new EmojiCaptureGLTextureView.a((byte)0);
    AppMethodBeat.o(435);
  }
  
  public EmojiCaptureGLTextureView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmojiCaptureGLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmojiCaptureGLTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final d getPreviewTexture()
  {
    AppMethodBeat.i(256434);
    if ((getRenderer() instanceof e))
    {
      localObject = getRenderer();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCapturePreviewRenderer");
        AppMethodBeat.o(256434);
        throw ((Throwable)localObject);
      }
      localObject = ((e)localObject).cJX();
      AppMethodBeat.o(256434);
      return localObject;
    }
    Object localObject = super.getPreviewTexture();
    AppMethodBeat.o(256434);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureGLTextureView
 * JD-Core Version:    0.7.0.1
 */