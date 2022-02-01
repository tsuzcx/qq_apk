package com.tencent.mm.media.camera;

import android.graphics.SurfaceTexture;
import kotlin.Metadata;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/ICameraKitEnv;", "Lcom/tencent/mm/media/camera/ISuspendCameraKitEnvExport;", "bufferUpdateFrame", "", "data", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentFrame", "Landroid/graphics/Bitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGLInputSurface", "Landroid/view/Surface;", "getGLInputTexture", "Landroid/graphics/SurfaceTexture;", "texturePreview", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenSize", "Lcom/tencent/mm/media/camera/model/GLSize;", "jumpNextFrame", "makeSureEnvSetup", "pause", "resume", "setRenderSetting", "setting", "Lcom/tencent/mm/media/camera/model/CameraKitRenderSetting;", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h
{
  public abstract Object a(boolean paramBoolean, d<? super SurfaceTexture> paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.h
 * JD-Core Version:    0.7.0.1
 */