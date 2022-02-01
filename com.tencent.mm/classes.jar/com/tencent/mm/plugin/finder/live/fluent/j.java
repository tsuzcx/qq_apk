package com.tencent.mm.plugin.finder.live.fluent;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/FluentSwitchTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "videoHeight", "", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "videoWidth", "getVideoWidth", "setVideoWidth", "setVideoSize", "", "width", "height", "updateTextureViewSizeCenterCrop", "Companion", "FluentSwitchSurfaceTextureListener", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends TextureView
{
  public static final a CCK;
  public int videoHeight;
  public int videoWidth;
  
  static
  {
    AppMethodBeat.i(352104);
    CCK = new a((byte)0);
    AppMethodBeat.o(352104);
  }
  
  public j(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(352095);
    setOpaque(false);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)new b("FluentSwitchTextureView"));
    AppMethodBeat.o(352095);
  }
  
  public final int getVideoHeight()
  {
    return this.videoHeight;
  }
  
  public final int getVideoWidth()
  {
    return this.videoWidth;
  }
  
  public final void hD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(352142);
    float f1 = paramInt1 / this.videoWidth;
    float f2 = paramInt2 / this.videoHeight;
    Matrix localMatrix = new Matrix();
    f1 = k.bt(f1, f2);
    localMatrix.preTranslate((paramInt1 - this.videoWidth) / 2.0F, (paramInt2 - this.videoHeight) / 2.0F);
    localMatrix.preScale(this.videoWidth / paramInt1, this.videoHeight / paramInt2);
    localMatrix.postScale(f1, f1, paramInt1 / 2.0F, paramInt2 / 2.0F);
    setTransform(localMatrix);
    postInvalidate();
    AppMethodBeat.o(352142);
  }
  
  public final void setVideoHeight(int paramInt)
  {
    this.videoHeight = paramInt;
  }
  
  public final void setVideoWidth(int paramInt)
  {
    this.videoWidth = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/FluentSwitchTextureView$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/FluentSwitchTextureView$FluentSwitchSurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "source", "", "isNeedDestory", "", "(Ljava/lang/String;Z)V", "()Z", "getSource", "()Ljava/lang/String;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    private final boolean CCL;
    private final String source;
    
    public b(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(352113);
      this.source = paramString;
      this.CCL = paramBoolean;
      AppMethodBeat.o(352113);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(352129);
      s.u(paramSurfaceTexture, "surface");
      Log.i("FluentSwitchTextureView", this.source + " onSurfaceTextureDestroyed surface:" + paramSurfaceTexture);
      AppMethodBeat.o(352129);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(352147);
      s.u(paramSurfaceTexture, "surface");
      Log.i("FluentSwitchTextureView", this.source + " onSurfaceTextureDestroyed surface:" + paramSurfaceTexture);
      boolean bool = this.CCL;
      AppMethodBeat.o(352147);
      return bool;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(352139);
      s.u(paramSurfaceTexture, "surface");
      Log.i("FluentSwitchTextureView", this.source + " onSurfaceTextureDestroyed surface:" + paramSurfaceTexture);
      AppMethodBeat.o(352139);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(352153);
      s.u(paramSurfaceTexture, "surface");
      Log.i("FluentSwitchTextureView", this.source + " onSurfaceTextureDestroyed surface:" + paramSurfaceTexture);
      AppMethodBeat.o(352153);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.j
 * JD-Core Version:    0.7.0.1
 */