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
  b BAA;
  c BAB;
  FaceFlashUI BzL;
  
  a(FaceFlashUI paramFaceFlashUI)
  {
    this.BzL = paramFaceFlashUI;
  }
  
  public final void TL()
  {
    AppMethodBeat.i(191286);
    if ((egx()) && (this.BAB != null)) {
      this.BAB.TL();
    }
    AppMethodBeat.o(191286);
  }
  
  public final boolean egx()
  {
    if (this.BAB == null) {
      return false;
    }
    return this.BAB.wFf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.a
 * JD-Core Version:    0.7.0.1
 */