package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class SceneVoiceInputAddrProxy$2
  implements g.b
{
  SceneVoiceInputAddrProxy$2(SceneVoiceInputAddrProxy paramSceneVoiceInputAddrProxy) {}
  
  public final void aOo()
  {
    AppMethodBeat.i(148567);
    this.iBv.CLIENT_CALL("onRecordFinCli", new Object[0]);
    AppMethodBeat.o(148567);
  }
  
  public final void aOs()
  {
    AppMethodBeat.i(148568);
    this.iBv.CLIENT_CALL("onRecognizeFinishCli", new Object[0]);
    AppMethodBeat.o(148568);
  }
  
  public final void b(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(148565);
    this.iBv.CLIENT_CALL("onResCli", new Object[] { paramArrayOfString, paramList });
    AppMethodBeat.o(148565);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(148566);
    this.iBv.CLIENT_CALL("onErrorCli", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
    AppMethodBeat.o(148566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy.2
 * JD-Core Version:    0.7.0.1
 */