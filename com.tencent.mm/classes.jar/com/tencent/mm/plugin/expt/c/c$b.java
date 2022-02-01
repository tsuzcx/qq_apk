package com.tencent.mm.plugin.expt.c;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xt;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/biz/TelePmMonitor$Companion$mTelePmListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
public final class c$b
  implements b
{
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(220735);
    paramString1 = new xt();
    paramString1.eeb.action = 1;
    EventCenter.instance.publish((IEvent)paramString1);
    AppMethodBeat.o(220735);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(220734);
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      paramString3 = new xt();
      paramString4 = paramString3.eeb;
      paramString2 = paramArrayOfObject[0];
      paramString1 = paramString2;
      if (!(paramString2 instanceof PhoneStateListener)) {
        paramString1 = null;
      }
      paramString2 = (PhoneStateListener)paramString1;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = null;
      }
      paramString4.eec = paramString1;
      paramString4 = paramString3.eeb;
      paramString2 = paramArrayOfObject[1];
      paramString1 = paramString2;
      if (!(paramString2 instanceof Integer)) {
        paramString1 = null;
      }
      paramString1 = (Integer)paramString1;
      if (paramString1 == null) {
        break label135;
      }
    }
    label135:
    for (int i = paramString1.intValue();; i = -1)
    {
      paramString4.eed = i;
      paramString3.eeb.action = 0;
      EventCenter.instance.publish((IEvent)paramString3);
      AppMethodBeat.o(220734);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.c.b
 * JD-Core Version:    0.7.0.1
 */