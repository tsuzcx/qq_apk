package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ExtControlProviderVoiceControl$1
  implements Runnable
{
  ExtControlProviderVoiceControl$1(ExtControlProviderVoiceControl paramExtControlProviderVoiceControl, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public final void run()
  {
    AppMethodBeat.i(20440);
    int i = bo.getInt(this.mfC, 4);
    if (i == 1) {
      ExtControlProviderVoiceControl.a(this.mfG, this.val$filePath);
    }
    for (;;)
    {
      if (!ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.a(this.mfG), i, bo.getInt(this.mfD, 4), bo.getInt(this.mfE, 16000), bo.getInt(this.mfF, 16), this.val$filePath))
      {
        ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
        ExtControlProviderVoiceControl.b(this.mfG);
        this.mfG.mfy.countDown();
      }
      AppMethodBeat.o(20440);
      return;
      ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.1
 * JD-Core Version:    0.7.0.1
 */