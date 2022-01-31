package com.tencent.mm.plugin.emojicapture.ui;

import a.l;
import a.v;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView;
import com.tencent.mm.plugin.emojicapture.ui.b.b;
import com.tencent.mm.plugin.emojicapture.ui.b.f;
import com.tencent.mm.plugin.emojicapture.ui.b.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "getPreviewTextureId", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureGLTextureView
  extends CameraPreviewGLTextureView
{
  public static final EmojiCaptureGLTextureView.a lwX;
  
  static
  {
    AppMethodBeat.i(2861);
    lwX = new EmojiCaptureGLTextureView.a((byte)0);
    AppMethodBeat.o(2861);
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
  
  public final int getPreviewTextureId()
  {
    AppMethodBeat.i(2860);
    if ((getRenderer() instanceof b))
    {
      Object localObject = getRenderer();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCaptureGLSurfaceTextureRenderer");
        AppMethodBeat.o(2860);
        throw ((Throwable)localObject);
      }
      localObject = (b)localObject;
      if ((((com.tencent.mm.media.h.a)localObject).eXY instanceof com.tencent.mm.plugin.emojicapture.ui.b.a))
      {
        localObject = ((com.tencent.mm.media.h.a)localObject).eXY;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCaptureCropTopRenderProc");
          AppMethodBeat.o(2860);
          throw ((Throwable)localObject);
        }
        i = ((com.tencent.mm.plugin.emojicapture.ui.b.a)localObject).lAF.bpm();
        AppMethodBeat.o(2860);
        return i;
      }
      if ((((com.tencent.mm.media.h.a)localObject).eXY instanceof f))
      {
        localObject = ((com.tencent.mm.media.h.a)localObject).eXY;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCaptureRGBRenderProc");
          AppMethodBeat.o(2860);
          throw ((Throwable)localObject);
        }
        i = ((f)localObject).lAF.bpm();
        AppMethodBeat.o(2860);
        return i;
      }
      AppMethodBeat.o(2860);
      return 0;
    }
    int i = super.getPreviewTextureId();
    AppMethodBeat.o(2860);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureGLTextureView
 * JD-Core Version:    0.7.0.1
 */