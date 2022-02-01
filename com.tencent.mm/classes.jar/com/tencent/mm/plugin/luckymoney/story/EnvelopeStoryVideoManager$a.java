package com.tencent.mm.plugin.luckymoney.story;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class EnvelopeStoryVideoManager$a
  implements h.a
{
  EnvelopeStoryVideoManager.c zaL;
  
  public EnvelopeStoryVideoManager$a(EnvelopeStoryVideoManager paramEnvelopeStoryVideoManager, EnvelopeStoryVideoManager.c paramc)
  {
    this.zaL = paramc;
  }
  
  public final void Ds(String paramString) {}
  
  public final void a(String paramString, int paramInt, d paramd)
  {
    AppMethodBeat.i(163648);
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "download finish: %s", new Object[] { paramString });
      EnvelopeStoryVideoManager.VQ().putInt(paramString, 1).commit();
    }
    this.zaL.zaV.ax(paramString, paramInt);
    AppMethodBeat.o(163648);
  }
  
  public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
  {
    AppMethodBeat.i(213348);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163644);
        EnvelopeStoryVideoManager.a.this.zaL.zaV.AI(paramLong1);
        AppMethodBeat.o(163644);
      }
    });
    AppMethodBeat.o(213348);
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(163647);
    this.zaL.zaV.i(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(163647);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(163646);
    this.zaL.zaV.onDataAvailable(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(163646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.a
 * JD-Core Version:    0.7.0.1
 */