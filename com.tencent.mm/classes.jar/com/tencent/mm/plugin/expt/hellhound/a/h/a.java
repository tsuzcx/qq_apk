package com.tencent.mm.plugin.expt.hellhound.a.h;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/submenu/SubMenuMonitor;", "", "()V", "Companion", "SubMenuListener", "plugin-expt_release"})
public final class a
{
  private static boolean qqL;
  private static final b qqM;
  private static boolean qqN;
  public static final a.a qqO;
  
  static
  {
    AppMethodBeat.i(169403);
    qqO = new a.a((byte)0);
    qqM = new b();
    AppMethodBeat.o(169403);
  }
  
  public static final void cjz()
  {
    AppMethodBeat.i(169404);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("processOnItemClick", "(II)V"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/ui/PlusSubMenuHelper", localArrayList);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a((Map)localHashMap, (c)qqM);
    AppMethodBeat.o(169404);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/submenu/SubMenuMonitor$SubMenuListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
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
      paramString1 = a.qqO;
      if (10 == i)
      {
        bool1 = true;
        a.kO(bool1);
        paramString1 = a.qqO;
        if (2147483647 != i) {
          break label187;
        }
      }
      label187:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        a.kP(bool1);
        paramString1 = new StringBuilder("HABBYGE-MALI, SubMenuMonitor, runOnEnter: ").append(i).append(", ");
        paramString2 = a.qqO;
        paramString1 = paramString1.append(a.clx()).append(", ");
        paramString2 = a.qqO;
        ac.i("SubMenuMonitor", a.cly());
        AppMethodBeat.o(184286);
        return;
        bool1 = false;
        break;
      }
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.h.a
 * JD-Core Version:    0.7.0.1
 */