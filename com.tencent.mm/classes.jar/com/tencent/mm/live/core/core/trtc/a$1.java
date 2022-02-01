package com.tencent.mm.live.core.core.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.rtmp.ITXLiveBaseListener;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "level", "", "module", "", "kotlin.jvm.PlatformType", "log", "OnLog"})
final class a$1
  implements ITXLiveBaseListener
{
  public static final 1 gLf;
  
  static
  {
    AppMethodBeat.i(196848);
    gLf = new 1();
    AppMethodBeat.o(196848);
  }
  
  public final void OnLog(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(196847);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196847);
      return;
      ae.v("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(196847);
      return;
      ae.d("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(196847);
      return;
      ae.i("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(196847);
      return;
      ae.w("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(196847);
      return;
      ae.e("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.1
 * JD-Core Version:    0.7.0.1
 */