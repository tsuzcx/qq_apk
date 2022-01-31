package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.protocal.c.ea;
import com.tencent.mm.sdk.platformtools.y;

final class ExtControlProviderVoiceControl$2
  implements Runnable
{
  ExtControlProviderVoiceControl$2(ExtControlProviderVoiceControl paramExtControlProviderVoiceControl, a parama, ea paramea) {}
  
  public final void run()
  {
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
    a locala = this.jLD;
    int i = this.jLE.sxG;
    y.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[] { Integer.valueOf(i) });
    locala.jLK = i;
    this.jLC.a(this.jLD.jLF, this.jLD.appId, this.jLD.jLG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.2
 * JD-Core Version:    0.7.0.1
 */