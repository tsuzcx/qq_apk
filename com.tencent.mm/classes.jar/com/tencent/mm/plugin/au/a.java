package com.tencent.mm.plugin.au;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.au.b.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vibrate/VibrateServiceHelper;", "", "()V", "mHapticVibrate", "Lcom/appaac/haptic/AACHapticPlayer;", "mVibrator", "Landroid/os/Vibrator;", "initVibrateInfo", "", "vibrateInfo", "Lcom/tencent/mm/plugin/ringtoneapi/api/VibrateDescInfo;", "callback", "Lcom/tencent/mm/plugin/vibrate/api/SyncCallback;", "startShake", "stopShake", "plugin-vibrate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private com.appaac.haptic.a TWQ;
  private Vibrator cqQ;
  
  private static final int a(com.tencent.mm.plugin.au.a.a parama)
  {
    AppMethodBeat.i(260700);
    int i = parama.getCurrentPosition();
    AppMethodBeat.o(260700);
    return i;
  }
  
  public final void a(com.tencent.mm.plugin.aj.a.a parama, com.tencent.mm.plugin.au.a.a parama1)
  {
    String str = null;
    AppMethodBeat.i(260714);
    s.u(parama, "vibrateInfo");
    com.appaac.haptic.a locala;
    if ((d.rb(26)) && (parama.fileUrl != null) && (parama.fileName != null) && (b.hQh()))
    {
      locala = com.appaac.haptic.a.aE(MMApplicationContext.getContext());
      if (locala == null)
      {
        parama = str;
        this.TWQ = parama;
      }
    }
    else
    {
      AppMethodBeat.o(260714);
      return;
    }
    if (parama1 == null)
    {
      parama1 = parama.fileUrl;
      s.s(parama1, "vibrateInfo.fileUrl");
      parama = parama.fileName;
      s.s(parama, "vibrateInfo.fileName");
      locala.a(new File(b.nq(parama1, parama)), null);
    }
    for (;;)
    {
      parama = ah.aiuX;
      parama = locala;
      break;
      str = parama.fileUrl;
      s.s(str, "vibrateInfo.fileUrl");
      parama = parama.fileName;
      s.s(parama, "vibrateInfo.fileName");
      locala.a(new File(b.nq(str, parama)), new a..ExternalSyntheticLambda0(parama1));
    }
  }
  
  public final void hQe()
  {
    AppMethodBeat.i(260720);
    Object localObject;
    if ((d.rb(26)) && (this.TWQ != null))
    {
      localObject = this.TWQ;
      if (localObject != null)
      {
        ((com.appaac.haptic.a)localObject).prepare();
        ((com.appaac.haptic.a)localObject).Nn();
        ((com.appaac.haptic.a)localObject).start();
        AppMethodBeat.o(260720);
      }
    }
    else
    {
      localObject = MMApplicationContext.getContext().getSystemService("vibrator");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
        AppMethodBeat.o(260720);
        throw ((Throwable)localObject);
      }
      this.cqQ = ((Vibrator)localObject);
      if (d.rb(26))
      {
        localObject = new AudioAttributes.Builder().setUsage(6).build();
        Vibrator localVibrator = this.cqQ;
        if (localVibrator != null)
        {
          localVibrator.vibrate(VibrationEffect.createWaveform(new long[] { 1000L, 1000L, 1000L, 1000L }, 0), (AudioAttributes)localObject);
          AppMethodBeat.o(260720);
        }
      }
      else
      {
        localObject = this.cqQ;
        if (localObject != null) {
          ((Vibrator)localObject).vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
        }
      }
    }
    AppMethodBeat.o(260720);
  }
  
  public final void stopShake()
  {
    AppMethodBeat.i(260725);
    Object localObject = this.TWQ;
    if (localObject != null)
    {
      ((com.appaac.haptic.a)localObject).pause();
      ((com.appaac.haptic.a)localObject).stop();
      ((com.appaac.haptic.a)localObject).release();
    }
    localObject = this.cqQ;
    if (localObject != null) {
      ((Vibrator)localObject).cancel();
    }
    AppMethodBeat.o(260725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.au.a
 * JD-Core Version:    0.7.0.1
 */