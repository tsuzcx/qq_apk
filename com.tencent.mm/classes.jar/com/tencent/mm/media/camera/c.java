package com.tencent.mm.media.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/CameraUtil;", "", "()V", "isDebugVer", "", "logAndThrowException", "", "tag", "", "msg", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c ntw;
  
  static
  {
    AppMethodBeat.i(237076);
    ntw = new c();
    AppMethodBeat.o(237076);
  }
  
  public static boolean bnM()
  {
    AppMethodBeat.i(237070);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(237070);
      return true;
    }
    AppMethodBeat.o(237070);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.camera.c
 * JD-Core Version:    0.7.0.1
 */