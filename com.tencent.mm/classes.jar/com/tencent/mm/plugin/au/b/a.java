package com.tencent.mm.plugin.au.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import java.io.File;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vibrate/manager/VibratePlayer;", "", "()V", "mHapticVibrate", "Lcom/appaac/haptic/AACHapticPlayer;", "startShake", "", "vibrateInfo", "Lcom/tencent/mm/plugin/ringtoneapi/api/VibrateDescInfo;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/vibrate/api/SyncCallback;", "stopShake", "", "plugin-vibrate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private com.appaac.haptic.a TWQ;
  
  private static final int b(com.tencent.mm.plugin.au.a.a parama)
  {
    AppMethodBeat.i(260683);
    s.u(parama, "$callback");
    int i = parama.getCurrentPosition();
    AppMethodBeat.o(260683);
    return i;
  }
  
  public final boolean a(com.tencent.mm.plugin.aj.a.a parama, Context paramContext, com.tencent.mm.plugin.au.a.a parama1)
  {
    AppMethodBeat.i(260702);
    s.u(parama, "vibrateInfo");
    s.u(paramContext, "context");
    s.u(parama1, "callback");
    if ((d.rb(26)) && (b.hQf()))
    {
      if (parama.fileUrl != null)
      {
        paramContext = com.appaac.haptic.a.aE(paramContext);
        if (paramContext != null) {
          break label67;
        }
      }
      for (parama = null;; parama = paramContext)
      {
        this.TWQ = parama;
        AppMethodBeat.o(260702);
        return true;
        label67:
        String str = parama.fileUrl;
        s.s(str, "vibrateInfo.fileUrl");
        parama = parama.fileName;
        s.s(parama, "vibrateInfo.fileName");
        paramContext.a(new File(b.nq(str, parama)), new a..ExternalSyntheticLambda0(parama1));
        paramContext.prepare();
        paramContext.Nn();
        paramContext.start();
        parama = ah.aiuX;
      }
    }
    AppMethodBeat.o(260702);
    return false;
  }
  
  public final void stopShake()
  {
    AppMethodBeat.i(260709);
    com.appaac.haptic.a locala = this.TWQ;
    if (locala != null)
    {
      locala.pause();
      locala.stop();
      locala.release();
    }
    AppMethodBeat.o(260709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.au.b.a
 * JD-Core Version:    0.7.0.1
 */