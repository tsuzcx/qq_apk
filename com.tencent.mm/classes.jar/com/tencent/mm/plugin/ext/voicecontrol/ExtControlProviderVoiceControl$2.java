package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.sdk.platformtools.ab;

final class ExtControlProviderVoiceControl$2
  implements Runnable
{
  ExtControlProviderVoiceControl$2(ExtControlProviderVoiceControl paramExtControlProviderVoiceControl, a parama, fb paramfb) {}
  
  public final void run()
  {
    AppMethodBeat.i(20441);
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
    a locala = this.mfH;
    int i = this.mfI.wrk;
    ab.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[] { Integer.valueOf(i) });
    locala.mfO = i;
    this.mfG.a(this.mfH.mfJ, this.mfH.appId, this.mfH.mfK);
    AppMethodBeat.o(20441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.2
 * JD-Core Version:    0.7.0.1
 */