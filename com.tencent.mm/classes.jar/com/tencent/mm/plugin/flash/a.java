package com.tencent.mm.plugin.flash;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.youtu.sdkkitframework.common.YtCameraSetting;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;

public final class a
{
  b HhY;
  c HhZ;
  FaceFlashUI Hhn;
  
  a(FaceFlashUI paramFaceFlashUI)
  {
    this.Hhn = paramFaceFlashUI;
  }
  
  public final void auq()
  {
    AppMethodBeat.i(264441);
    if ((boa()) && (this.HhZ != null)) {
      this.HhZ.auq();
    }
    AppMethodBeat.o(264441);
  }
  
  public final boolean boa()
  {
    if (this.HhZ == null) {
      return false;
    }
    return this.HhZ.nvB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.a
 * JD-Core Version:    0.7.0.1
 */