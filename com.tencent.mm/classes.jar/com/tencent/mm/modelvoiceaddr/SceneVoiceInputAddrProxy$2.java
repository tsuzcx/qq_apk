package com.tencent.mm.modelvoiceaddr;

import java.util.Set;

final class SceneVoiceInputAddrProxy$2
  implements g.b
{
  SceneVoiceInputAddrProxy$2(SceneVoiceInputAddrProxy paramSceneVoiceInputAddrProxy) {}
  
  public final void TC()
  {
    this.eMi.CLIENT_CALL("onRecognizeFinishCli", new Object[0]);
  }
  
  public final void Ty()
  {
    this.eMi.CLIENT_CALL("onRecordFinCli", new Object[0]);
  }
  
  public final void a(String[] paramArrayOfString, Set<String> paramSet)
  {
    this.eMi.CLIENT_CALL("onResCli", new Object[] { paramArrayOfString, paramSet });
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.eMi.CLIENT_CALL("onErrorCli", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy.2
 * JD-Core Version:    0.7.0.1
 */