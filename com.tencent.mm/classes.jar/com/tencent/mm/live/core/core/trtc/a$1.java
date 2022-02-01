package com.tencent.mm.live.core.core.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.rtmp.ITXLiveBaseListener;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "level", "", "module", "", "kotlin.jvm.PlatformType", "log", "OnLog"})
final class a$1
  implements ITXLiveBaseListener
{
  public static final 1 goO;
  
  static
  {
    AppMethodBeat.i(209179);
    goO = new 1();
    AppMethodBeat.o(209179);
  }
  
  public final void OnLog(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(209178);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(209178);
      return;
      ac.v("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(209178);
      return;
      ac.d("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(209178);
      return;
      ac.i("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(209178);
      return;
      ac.w("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      AppMethodBeat.o(209178);
      return;
      ac.e("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.1
 * JD-Core Version:    0.7.0.1
 */