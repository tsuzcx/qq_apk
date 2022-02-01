package com.tencent.mm.media.camera.instance;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/instance/CameraKitFocusHelper;", "", "()V", "<set-?>", "Landroid/graphics/RectF;", "previewRectF", "getPreviewRectF", "()Landroid/graphics/RectF;", "rotate", "", "getRotate", "()I", "setRotate", "(I)V", "viewHeight", "getViewHeight", "setViewHeight", "viewWidth", "getViewWidth", "setViewWidth", "updateTransformer", "", "mirrorX", "", "textureWidth", "textureHeight", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
{
  public static final b.a nuC;
  private int hYK;
  private int mbM;
  private int mbN;
  public RectF nuD;
  
  static
  {
    AppMethodBeat.i(237327);
    nuC = new b.a((byte)0);
    AppMethodBeat.o(237327);
  }
  
  public b()
  {
    AppMethodBeat.i(237321);
    this.nuD = new RectF();
    AppMethodBeat.o(237321);
  }
  
  public void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(237342);
    Log.i("MicroMsg.Camera.CameraKitFocusHelper", "updateFocusParam mirrorX:" + paramBoolean + " rotate:" + paramInt1 + " textureWidth:" + paramInt2 + " textureHeight:" + paramInt3 + " viewWidth:" + paramInt4 + " viewHeight:" + paramInt5);
    if ((paramInt5 <= 0) || (paramInt4 <= 0))
    {
      Log.e("MicroMsg.Camera.CameraKitFocusHelper", "ignore updateTransformer,for width:" + paramInt4 + " height:" + paramInt5);
      AppMethodBeat.o(237342);
      return;
    }
    this.hYK = paramInt1;
    this.mbM = paramInt4;
    this.mbN = paramInt5;
    float f2 = paramInt5 * 1.0F / paramInt4;
    float f1;
    switch (paramInt1)
    {
    default: 
      f1 = paramInt3 * 1.0F / paramInt2;
      if (f2 > f1) {
        f1 = (f2 - f1) * paramInt4 / 2.0F;
      }
      break;
    }
    for (RectF localRectF = new RectF(0.0F - f1, 0.0F, f1 + paramInt4, paramInt5);; localRectF = new RectF(0.0F, 0.0F - f1, paramInt4, f1 + paramInt5))
    {
      this.nuD = localRectF;
      Log.i("MicroMsg.Camera.CameraKitFocusHelper", s.X("calculate real preview rect:", this.nuD));
      AppMethodBeat.o(237342);
      return;
      f1 = paramInt2 * 1.0F / paramInt3;
      break;
      f1 = (f1 - f2) * paramInt5 / 2.0F;
    }
  }
  
  protected final int getViewHeight()
  {
    return this.mbN;
  }
  
  protected final int getViewWidth()
  {
    return this.mbM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.b
 * JD-Core Version:    0.7.0.1
 */