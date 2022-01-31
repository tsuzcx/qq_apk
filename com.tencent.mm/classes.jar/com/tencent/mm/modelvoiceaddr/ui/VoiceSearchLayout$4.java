package com.tencent.mm.modelvoiceaddr.ui;

import com.tencent.mm.modelvoiceaddr.f.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class VoiceSearchLayout$4
  implements f.b
{
  VoiceSearchLayout$4(VoiceSearchLayout paramVoiceSearchLayout) {}
  
  public final void Tx()
  {
    this.eNc.reset();
    VoiceSearchLayout.n(this.eNc).a(false, null, -1L);
  }
  
  public final void Ty()
  {
    VoiceSearchLayout.k(this.eNc);
    VoiceSearchLayout.l(this.eNc);
    if (VoiceSearchLayout.m(this.eNc) != null) {
      VoiceSearchLayout.m(this.eNc).stopTimer();
    }
  }
  
  public final void a(String[] paramArrayOfString, long paramLong)
  {
    try
    {
      y.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes ");
      if (paramArrayOfString != null)
      {
        y.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes size:" + paramArrayOfString.length + " " + paramArrayOfString.toString());
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = paramArrayOfString[i];
          y.d("MicroMsg.VoiceSearchLayout", "search username  :" + str);
          i += 1;
        }
      }
      this.eNc.reset();
      VoiceSearchLayout.n(this.eNc).a(true, paramArrayOfString, paramLong);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      y.printErrStackTrace("MicroMsg.VoiceSearchLayout", paramArrayOfString, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.4
 * JD-Core Version:    0.7.0.1
 */