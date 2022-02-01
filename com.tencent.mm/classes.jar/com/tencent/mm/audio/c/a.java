package com.tencent.mm.audio.c;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.deviceinfo.b;

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
      if ((com.tencent.mm.plugin.audio.c.a.bHy().bHt()) || (com.tencent.mm.plugin.audio.c.a.bHz())) {
        j = 3;
      }
      i = j;
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYn)
      {
        com.tencent.mm.compatible.deviceinfo.ae.geN.dump();
        if ((!paramBoolean) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYQ < 0)) {
          break label239;
        }
        i = com.tencent.mm.compatible.deviceinfo.ae.geN.fYQ;
      }
      j = AudioTrack.getMinBufferSize(paramInt1, paramInt2, 2);
      com.tencent.mm.sdk.platformtools.ae.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      locale = new e(i, paramInt1, paramInt2, paramInt3 * j);
      if (locale.getState() != 0) {
        break label277;
      }
      locale.release();
      com.tencent.mm.sdk.platformtools.ae.i("AudioDeviceFactory", "reconstruct AudioTrack");
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
      com.tencent.mm.sdk.platformtools.ae.i("AudioDeviceFactory", "AudioTrack state: " + locale.getState());
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
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYR < 0) {
        break label73;
      }
      i = com.tencent.mm.compatible.deviceinfo.ae.geN.fYR;
      break label73;
      i = 0;
      break label183;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.c.a
 * JD-Core Version:    0.7.0.1
 */