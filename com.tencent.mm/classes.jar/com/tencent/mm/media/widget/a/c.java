package com.tencent.mm.media.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera/CameraTextureRenderConfig;", "", "()V", "TAG", "", "isEnableCropCameraTexture", "", "()Z", "renderScene", "", "getRenderScene", "()I", "setRenderScene", "(I)V", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c nGn;
  private static int nGo;
  
  static
  {
    AppMethodBeat.i(237619);
    nGn = new c();
    AppMethodBeat.o(237619);
  }
  
  public static boolean bsQ()
  {
    AppMethodBeat.i(237613);
    if (!p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }).contains(Integer.valueOf(nGo)))
    {
      AppMethodBeat.o(237613);
      return false;
    }
    Object localObject = i.agtt;
    localObject = i.a(b.a.agrJ, Integer.valueOf(0));
    StringBuilder localStringBuilder = new StringBuilder("isEnableCropCameraTexture, repairerConfig:").append(localObject).append(", cpuCrop:");
    b localb = b.nGj;
    Log.i("MicroMsg.CameraTextureRenderConfig", b.bsO());
    if (!s.p(localObject, Integer.valueOf(0)))
    {
      if (s.p(localObject, Integer.valueOf(1)))
      {
        localObject = b.nGj;
        if (!b.bsO())
        {
          AppMethodBeat.o(237613);
          return true;
        }
      }
      AppMethodBeat.o(237613);
      return false;
    }
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwO, 0);
    Log.i("MicroMsg.CameraTextureRenderConfig", s.X("isEnableCropCameraTexture, exptConfig:", Integer.valueOf(i)));
    if (i == 1)
    {
      localObject = b.nGj;
      if (!b.bsO())
      {
        AppMethodBeat.o(237613);
        return true;
      }
    }
    AppMethodBeat.o(237613);
    return false;
  }
  
  public static void uo(int paramInt)
  {
    nGo = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.c
 * JD-Core Version:    0.7.0.1
 */