package com.tencent.mm.plugin.expt.hellhound.a.h;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.d;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.e;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/submenu/SubMenuMonitor;", "", "()V", "Companion", "SubMenuListener", "plugin-expt_release"})
public final class a
{
  private static boolean rhV;
  private static final b rhW;
  private static boolean rhX;
  public static final a.a rhY;
  
  static
  {
    AppMethodBeat.i(169403);
    rhY = new a.a((byte)0);
    rhW = new b();
    AppMethodBeat.o(169403);
  }
  
  public static final void cqn()
  {
    AppMethodBeat.i(169404);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("processOnItemClick", "(II)V"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/ui/PlusSubMenuHelper", localArrayList);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)localHashMap, (c)rhW);
    AppMethodBeat.o(169404);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/submenu/SubMenuMonitor$SubMenuListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "viewCallback", "id", "", "plugin-expt_release"})
  static final class b
    implements c
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
      paramString1 = paramArrayOfObject[0];
      if (paramString1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(184286);
        throw paramString1;
      }
      i = ((Integer)paramString1).intValue();
      paramString1 = a.rhY;
      if (10 == i)
      {
        bool1 = true;
        a.lg(bool1);
        paramString1 = a.rhY;
        if (2147483647 != i) {
          break label256;
        }
      }
      label256:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        a.lh(bool1);
        paramString1 = new dwx();
        paramString1.id = String.valueOf(i);
        paramString1.timestamp = System.currentTimeMillis();
        paramString1.Icn = paramString1.id;
        paramString1.typeName = "MMPopupWindow$PopupViewContainer";
        paramString1.Ico = "MMPopupWindow$PopupViewContainer";
        paramString1.duP = d.rao.value;
        paramString1.type = 0;
        ae.i("HABBYGE-MALI.SubMenuMonitor", "SubMenuMonitor, viewCallback:\nid=" + paramString1.id + '\n' + "timestamp=" + paramString1.timestamp + '\n' + "eventId=" + paramString1.duP);
        paramString2 = e.raD;
        e.a(paramString1);
        AppMethodBeat.o(184286);
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.h.a
 * JD-Core Version:    0.7.0.1
 */