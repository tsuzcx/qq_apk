package com.tencent.mm.media.camera.instance;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.lifecycle.q;
import com.tencent.mm.media.camera.e;
import com.tencent.mm.media.camera.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/instance/ICameraInstance;", "", "cameraKitInfo", "Lcom/tencent/mm/media/camera/model/CameraKitInfo;", "createCamera", "", "backCamera", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "focusOn", "x", "", "y", "getCameraOrientation", "", "getPreviewResolution", "Lcom/tencent/mm/media/camera/model/GLSize;", "hasBackCamera", "hasFrontCamera", "isBackCamera", "isPreviewing", "needMirror", "onZoomIn", "onZoomOut", "setCameraKitSetting", "setting", "Lcom/tencent/mm/media/camera/model/CameraKitCommonSetting;", "setup", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/LifecycleOwner;", "glEnvBuilder", "Lcom/tencent/mm/media/camera/GLEnvBuilder;", "cameraCoroutines", "Lcom/tencent/mm/media/camera/ICameraCoroutines;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/media/camera/GLEnvBuilder;Lcom/tencent/mm/media/camera/ICameraCoroutines;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startPreview", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopPreview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchCamera", "takePictureAsync", "Landroid/graphics/Bitmap;", "width", "height", "rotate", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFocusParam", "updateScreenSize", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public abstract Object a(Context paramContext, q paramq, e parame, f paramf, boolean paramBoolean, d<? super ah> paramd);
  
  public abstract Object a(Boolean paramBoolean, d<? super ah> paramd);
  
  public abstract void ak(float paramFloat1, float paramFloat2);
  
  public abstract Object b(int paramInt1, int paramInt2, int paramInt3, d<? super Bitmap> paramd);
  
  public abstract com.tencent.mm.media.camera.d.c bob();
  
  public abstract void bof();
  
  public abstract void bog();
  
  public abstract int boh();
  
  public abstract Object c(int paramInt1, int paramInt2, d<? super ah> paramd);
  
  public abstract boolean needMirror();
  
  public abstract Object u(d<? super Boolean> paramd);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.c
 * JD-Core Version:    0.7.0.1
 */