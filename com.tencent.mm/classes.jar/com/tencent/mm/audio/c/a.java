package com.tencent.mm.audio.c;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public static AudioTrack a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 3;
    AppMethodBeat.i(55761);
    int j;
    int i;
    label55:
    e locale;
    if (paramBoolean)
    {
      j = 3;
      i = j;
      if (ac.erv.emD)
      {
        ac.erv.dump();
        if ((!paramBoolean) || (ac.erv.enh < 0)) {
          break label221;
        }
        i = ac.erv.enh;
      }
      j = AudioTrack.getMinBufferSize(paramInt1, paramInt2, 2);
      ab.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      locale = new e(i, paramInt1, paramInt2, paramInt3 * j);
      if (locale.getState() != 0) {
        break label259;
      }
      locale.release();
      ab.i("AudioDeviceFactory", "reconstruct AudioTrack");
      if (i != 0) {
        break label253;
      }
      i = k;
      label165:
      locale = new e(i, paramInt1, paramInt2, paramInt3 * j);
    }
    label259:
    for (;;)
    {
      ab.i("AudioDeviceFactory", "AudioTrack state: " + locale.getState());
      AppMethodBeat.o(55761);
      return locale;
      j = 0;
      break;
      label221:
      i = j;
      if (paramBoolean) {
        break label55;
      }
      i = j;
      if (ac.erv.eni < 0) {
        break label55;
      }
      i = ac.erv.eni;
      break label55;
      label253:
      i = 0;
      break label165;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.c.a
 * JD-Core Version:    0.7.0.1
 */