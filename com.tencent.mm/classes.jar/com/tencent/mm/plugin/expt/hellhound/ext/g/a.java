package com.tencent.mm.plugin.expt.hellhound.ext.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.e;
import com.tencent.mm.protocal.protobuf.fxz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/submenu/SubMenuMonitor;", "", "()V", "Companion", "SubMenuListener", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a zLC;
  private static boolean zLD;
  private static final b zLE;
  private static boolean zLF;
  
  static
  {
    AppMethodBeat.i(169403);
    zLC = new a.a((byte)0);
    zLE = new b();
    AppMethodBeat.o(169403);
  }
  
  public static final void startMonitor()
  {
    AppMethodBeat.i(169404);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("processOnItemClick", "(II)V"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/ui/PlusSubMenuHelper", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)localHashMap, (com.tencent.mm.hellhoundlib.a.d)zLE);
    AppMethodBeat.o(169404);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/submenu/SubMenuMonitor$SubMenuListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "viewCallback", "id", "", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      boolean bool2 = true;
      AppMethodBeat.i(184286);
      if (paramArrayOfObject == null)
      {
        AppMethodBeat.o(184286);
        return;
      }
      if (paramArrayOfObject.length == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(184286);
        return;
      }
      i = ((Integer)paramArrayOfObject[0]).intValue();
      paramString1 = a.zLC;
      if (10 == i)
      {
        bool1 = true;
        a.pb(bool1);
        paramString1 = a.zLC;
        if (2147483647 != i) {
          break label223;
        }
      }
      label223:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        a.pc(bool1);
        paramString1 = new fxz();
        paramString1.id = String.valueOf(i);
        paramString1.timestamp = System.currentTimeMillis();
        paramString1.abVR = paramString1.id;
        paramString1.typeName = "MMPopupWindow$PopupViewContainer";
        paramString1.abVS = "MMPopupWindow$PopupViewContainer";
        paramString1.eventId = com.tencent.mm.plugin.expt.hellhound.core.b.c.d.zCB.value;
        paramString1.type = 0;
        Log.i("HABBYGE-MALI.SubMenuMonitor", "SubMenuMonitor, viewCallback:\nid=" + paramString1.id + "\ntimestamp=" + paramString1.timestamp + "\neventId=" + paramString1.eventId);
        paramString2 = e.zCM;
        e.a(paramString1);
        AppMethodBeat.o(184286);
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.g.a
 * JD-Core Version:    0.7.0.1
 */