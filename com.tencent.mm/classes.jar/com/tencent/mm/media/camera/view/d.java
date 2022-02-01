package com.tencent.mm.media.camera.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.lifecycle.q;
import com.tencent.mm.media.camera.d.f;
import com.tencent.mm.media.camera.l;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;
import kotlinx.coroutines.b.af;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/view/ICameraUsage;", "Lcom/tencent/mm/media/camera/ICameraRenderExport;", "bindLifeCycleOwner", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "getCameraState", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/Pair;", "Lcom/tencent/mm/media/camera/view/CameraStatusEnum;", "Landroid/os/Bundle;", "onZoomIn", "onZoomOut", "setCameraKitSetting", "setting", "Lcom/tencent/mm/media/camera/model/CameraKitSetting;", "switchCamera", "switchToCamera", "back", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takePicture", "", "Landroid/graphics/Bitmap;", "width", "height", "rotate", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
  extends l
{
  public abstract Object a(int paramInt, kotlin.d.d<? super r<Integer, Bitmap>> paramd);
  
  public abstract void bof();
  
  public abstract void bog();
  
  public abstract Object c(boolean paramBoolean, kotlin.d.d<? super ah> paramd);
  
  public abstract af<r<a, Bundle>> getCameraState();
  
  public abstract void n(q paramq);
  
  public abstract void setCameraKitSetting(f paramf);
  
  public abstract void switchCamera();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.view.d
 * JD-Core Version:    0.7.0.1
 */