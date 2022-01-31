package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class SceneVoiceInputAddrProxy$2
  implements g.b
{
  SceneVoiceInputAddrProxy$2(SceneVoiceInputAddrProxy paramSceneVoiceInputAddrProxy) {}
  
  public final void amK()
  {
    AppMethodBeat.i(116725);
    this.gbO.CLIENT_CALL("onRecordFinCli", new Object[0]);
    AppMethodBeat.o(116725);
  }
  
  public final void amO()
  {
    AppMethodBeat.i(116726);
    this.gbO.CLIENT_CALL("onRecognizeFinishCli", new Object[0]);
    AppMethodBeat.o(116726);
  }
  
  public final void b(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(138329);
    this.gbO.CLIENT_CALL("onResCli", new Object[] { paramArrayOfString, paramList });
    AppMethodBeat.o(138329);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(116724);
    this.gbO.CLIENT_CALL("onErrorCli", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
    AppMethodBeat.o(116724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy.2
 * JD-Core Version:    0.7.0.1
 */