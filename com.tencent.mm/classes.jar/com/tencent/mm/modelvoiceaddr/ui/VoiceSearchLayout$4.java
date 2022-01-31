package com.tencent.mm.modelvoiceaddr.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class VoiceSearchLayout$4
  implements f.b
{
  VoiceSearchLayout$4(VoiceSearchLayout paramVoiceSearchLayout) {}
  
  public final void a(String[] paramArrayOfString, long paramLong)
  {
    AppMethodBeat.i(116767);
    try
    {
      ab.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes ");
      if (paramArrayOfString != null)
      {
        ab.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes size:" + paramArrayOfString.length + " " + paramArrayOfString.toString());
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          ab.d("MicroMsg.VoiceSearchLayout", "search username  :".concat(String.valueOf(paramArrayOfString[i])));
          i += 1;
        }
      }
      this.gcH.reset();
      VoiceSearchLayout.n(this.gcH).a(true, paramArrayOfString, paramLong);
      AppMethodBeat.o(116767);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      ab.printErrStackTrace("MicroMsg.VoiceSearchLayout", paramArrayOfString, "", new Object[0]);
      AppMethodBeat.o(116767);
    }
  }
  
  public final void amJ()
  {
    AppMethodBeat.i(116768);
    this.gcH.reset();
    VoiceSearchLayout.n(this.gcH).a(false, null, -1L);
    AppMethodBeat.o(116768);
  }
  
  public final void amK()
  {
    AppMethodBeat.i(116766);
    VoiceSearchLayout.k(this.gcH);
    VoiceSearchLayout.l(this.gcH);
    if (VoiceSearchLayout.m(this.gcH) != null) {
      VoiceSearchLayout.m(this.gcH).stopTimer();
    }
    AppMethodBeat.o(116766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.4
 * JD-Core Version:    0.7.0.1
 */