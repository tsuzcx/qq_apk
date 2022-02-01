package com.tencent.mm.plugin.expt.c;

import android.telephony.PhoneStateListener;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.za;
import com.tencent.mm.hellhoundlib.a;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/biz/TelePmMonitor;", "", "()V", "Companion", "plugin-expt_release"})
public final class d
{
  private static final HashMap<String, List<Pair<String, String>>> wcU;
  private static final b wcV;
  public static final d.a wcW;
  
  static
  {
    AppMethodBeat.i(252021);
    wcW = new d.a((byte)0);
    wcU = new HashMap();
    wcV = new b();
    AppMethodBeat.o(252021);
  }
  
  public static final void Xr()
  {
    AppMethodBeat.i(252022);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("listen", "(Landroid/telephony/PhoneStateListener;I)V"));
    ((Map)wcU).put("android/telephony/TelephonyManager", localArrayList);
    a.aFg();
    a.a((Map)wcU, (b)wcV);
    AppMethodBeat.o(252022);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/biz/TelePmMonitor$Companion$mTelePmListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements b
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject)
    {
      AppMethodBeat.i(253359);
      paramString1 = new za();
      paramString1.fYq.action = 1;
      EventCenter.instance.publish((IEvent)paramString1);
      AppMethodBeat.o(253359);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(253357);
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString3 = new za();
        paramString4 = paramString3.fYq;
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
        paramString4.fYr = paramString1;
        paramString4 = paramString3.fYq;
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
        paramString4.fYs = i;
        paramString3.fYq.action = 0;
        EventCenter.instance.publish((IEvent)paramString3);
        AppMethodBeat.o(253357);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.d
 * JD-Core Version:    0.7.0.1
 */