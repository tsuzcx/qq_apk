package com.tencent.mm.plugin.expt.hellhound.a.e;

import android.app.Activity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor;", "", "()V", "Companion", "PermissionListener", "plugin-expt_release"})
public final class a
{
  private static int qpI;
  private static boolean qpJ;
  private static boolean qpK;
  private static final b qpL;
  public static final a.a qpM;
  
  static
  {
    AppMethodBeat.i(184283);
    qpM = new a.a((byte)0);
    qpI = -1;
    qpL = new b();
    AppMethodBeat.o(184283);
  }
  
  public static final void cjA()
  {
    AppMethodBeat.i(184284);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("requestPermissions", "([Ljava/lang/String;I)V"));
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a((List)localArrayList, (b)qpL);
    AppMethodBeat.o(184284);
  }
  
  public static final int cki()
  {
    return qpI;
  }
  
  public static final void ckj()
  {
    qpI = -1;
  }
  
  public static final boolean ckk()
  {
    return qpJ;
  }
  
  public static final boolean ckl()
  {
    return qpK;
  }
  
  public static final void ckm()
  {
    qpK = false;
  }
  
  public static final void kJ(boolean paramBoolean)
  {
    qpJ = paramBoolean;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor$PermissionListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "()V", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class b
    implements b
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184282);
      if ((paramObject != null) && (((paramObject instanceof Activity)) || ((paramObject instanceof android.support.v4.app.Fragment)) || ((paramObject instanceof android.app.Fragment))) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString1 = a.qpM;
        paramString1 = paramArrayOfObject[1];
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(184282);
          throw paramString1;
        }
        a.Cx(((Integer)paramString1).intValue());
        paramString1 = a.qpM;
        ac.i("PermissionMonitor", "HABBYGE-MALI, PermissionListener, args: %d", new Object[] { Integer.valueOf(a.ckg()) });
        paramString1 = a.qpM;
        a.ckh();
      }
      AppMethodBeat.o(184282);
    }
    
    public final void l(String paramString1, String paramString2, String paramString3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.e.a
 * JD-Core Version:    0.7.0.1
 */