package com.tencent.mm.plugin.expt.d;

import android.telephony.PhoneStateListener;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aau;
import com.tencent.mm.hellhoundlib.a;
import com.tencent.mm.hellhoundlib.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/biz/TelePmMonitor;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a zxU;
  private static final HashMap<String, List<Pair<String, String>>> zxV;
  private static final b zxW;
  
  static
  {
    AppMethodBeat.i(299534);
    zxU = new d.a((byte)0);
    zxV = new HashMap();
    zxW = new b();
    AppMethodBeat.o(299534);
  }
  
  public static final void ayW()
  {
    AppMethodBeat.i(299528);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("listen", "(Landroid/telephony/PhoneStateListener;I)V"));
    ((Map)zxV).put("android/telephony/TelephonyManager", localArrayList);
    a.aYh();
    a.a((Map)zxV, (b)zxW);
    AppMethodBeat.o(299528);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/biz/TelePmMonitor$Companion$mTelePmListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b
  {
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(299570);
      paramString1 = new aau();
      paramString1.ier.action = 1;
      paramString1.publish();
      AppMethodBeat.o(299570);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(299565);
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString3 = new aau();
        paramString4 = paramString3.ier;
        paramString1 = paramArrayOfObject[0];
        if (!(paramString1 instanceof PhoneStateListener)) {
          break label116;
        }
        paramString1 = (PhoneStateListener)paramString1;
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = null;
        }
        paramString4.ies = paramString2;
        paramString2 = paramString3.ier;
        paramString1 = paramArrayOfObject[1];
        if (!(paramString1 instanceof Integer)) {
          break label121;
        }
        paramString1 = (Integer)paramString1;
        label84:
        if (paramString1 != null) {
          break label126;
        }
      }
      label116:
      label121:
      label126:
      for (int i = -1;; i = paramString1.intValue())
      {
        paramString2.iet = i;
        paramString3.ier.action = 0;
        paramString3.publish();
        AppMethodBeat.o(299565);
        return;
        paramString1 = null;
        break;
        paramString1 = null;
        break label84;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.d
 * JD-Core Version:    0.7.0.1
 */