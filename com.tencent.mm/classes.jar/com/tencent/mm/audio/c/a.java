package com.tencent.mm.audio.c;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static AudioTrack a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 3;
    AppMethodBeat.i(130010);
    int j;
    int i;
    label73:
    e locale;
    if (paramBoolean)
    {
      j = 3;
      if ((com.tencent.mm.plugin.audio.c.a.bGC().bGx()) || (com.tencent.mm.plugin.audio.c.a.bGD())) {
        j = 3;
      }
      i = j;
      if (ae.gcF.fWh)
      {
        ae.gcF.dump();
        if ((!paramBoolean) || (ae.gcF.fWK < 0)) {
          break label239;
        }
        i = ae.gcF.fWK;
      }
      j = AudioTrack.getMinBufferSize(paramInt1, paramInt2, 2);
      ad.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      locale = new e(i, paramInt1, paramInt2, paramInt3 * j);
      if (locale.getState() != 0) {
        break label277;
      }
      locale.release();
      ad.i("AudioDeviceFactory", "reconstruct AudioTrack");
      if (i != 0) {
        break label271;
      }
      i = k;
      label183:
      locale = new e(i, paramInt1, paramInt2, paramInt3 * j);
    }
    label271:
    label277:
    for (;;)
    {
      ad.i("AudioDeviceFactory", "AudioTrack state: " + locale.getState());
      AppMethodBeat.o(130010);
      return locale;
      j = 0;
      break;
      label239:
      i = j;
      if (paramBoolean) {
        break label73;
      }
      i = j;
      if (ae.gcF.fWL < 0) {
        break label73;
      }
      i = ae.gcF.fWL;
      break label73;
      i = 0;
      break label183;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.c.a
 * JD-Core Version:    0.7.0.1
 */