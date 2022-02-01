package com.tencent.mm.live.core.core.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.ITXLiveBaseListener;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "level", "", "module", "", "kotlin.jvm.PlatformType", "log", "OnLog"})
final class a$1
  implements ITXLiveBaseListener
{
  public static final 1 gIw;
  
  static
  {
    AppMethodBeat.i(216836);
    gIw = new 1();
    AppMethodBeat.o(216836);
  }
  
  public final void OnLog(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(216835);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216835);
      return;
      ad.v("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(216835);
      return;
      ad.d("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(216835);
      return;
      ad.i("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(216835);
      return;
      ad.w("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(216835);
      return;
      ad.e("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.1
 * JD-Core Version:    0.7.0.1
 */