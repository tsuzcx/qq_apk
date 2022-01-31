package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ExtControlProviderVoiceControl$1
  implements Runnable
{
  ExtControlProviderVoiceControl$1(ExtControlProviderVoiceControl paramExtControlProviderVoiceControl, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public final void run()
  {
    int i = bk.getInt(this.jLy, 4);
    if (i == 1) {
      ExtControlProviderVoiceControl.a(this.jLC, this.val$filePath);
    }
    for (;;)
    {
      if (!ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.a(this.jLC), i, bk.getInt(this.jLz, 4), bk.getInt(this.jLA, 16000), bk.getInt(this.jLB, 16), this.val$filePath))
      {
        y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
        ExtControlProviderVoiceControl.b(this.jLC);
        this.jLC.jLu.countDown();
      }
      return;
      y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl.1
 * JD-Core Version:    0.7.0.1
 */