package com.tencent.mm.plugin.ext.voicecontrol;

import com.qq.wx.voice.embed.recognizer.a;
import com.qq.wx.voice.embed.recognizer.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ExtControlProviderVoiceControl$5
  implements c
{
  ExtControlProviderVoiceControl$5(ExtControlProviderVoiceControl paramExtControlProviderVoiceControl) {}
  
  public final void a(a parama)
  {
    AppMethodBeat.i(20444);
    if (parama == null)
    {
      ab.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
      AppMethodBeat.o(20444);
      return;
    }
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.c(this.mfG)), parama.text, parama.name });
    if (!bo.isNullOrNil(parama.name))
    {
      ExtControlProviderVoiceControl.d(this.mfG);
      ExtControlProviderVoiceControl.b(this.mfG, parama.name);
    }
    AppMethodBeat.o(20444);
  }
  
  public final void fn(int paramInt)
  {
    AppMethodBeat.i(20445);
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(20445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.5
 * JD-Core Version:    0.7.0.1
 */