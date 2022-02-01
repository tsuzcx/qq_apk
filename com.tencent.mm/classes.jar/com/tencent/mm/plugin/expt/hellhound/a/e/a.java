package com.tencent.mm.plugin.expt.hellhound.a.e;

import android.app.Activity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor;", "", "()V", "Companion", "PermissionListener", "plugin-expt_release"})
public final class a
{
  private static int qYH;
  private static boolean qYI;
  private static boolean qYJ;
  private static final b qYK;
  public static final a.a qYL;
  
  static
  {
    AppMethodBeat.i(184283);
    qYL = new a.a((byte)0);
    qYH = -1;
    qYK = new b();
    AppMethodBeat.o(184283);
  }
  
  public static final void cnf()
  {
    AppMethodBeat.i(184284);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("requestPermissions", "([Ljava/lang/String;I)V"));
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a((List)localArrayList, (b)qYK);
    AppMethodBeat.o(184284);
  }
  
  public static final boolean cpA()
  {
    return qYJ;
  }
  
  public static final void cpB()
  {
    qYJ = false;
  }
  
  public static final int cpx()
  {
    return qYH;
  }
  
  public static final void cpy()
  {
    qYH = -1;
  }
  
  public static final boolean cpz()
  {
    return qYI;
  }
  
  public static final void lb(boolean paramBoolean)
  {
    qYI = paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor$PermissionListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "()V", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class b
    implements b
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject) {}
    
    public final void c(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210957);
      if ((paramObject != null) && (((paramObject instanceof Activity)) || ((paramObject instanceof android.support.v4.app.Fragment)) || ((paramObject instanceof android.app.Fragment))) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString1 = a.qYL;
        paramString1 = paramArrayOfObject[1];
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(210957);
          throw paramString1;
        }
        a.Dk(((Integer)paramString1).intValue());
        paramString1 = a.qYL;
        ad.i("HABBYGE-MALI.PermissionMonitor", "PermissionListener, args: %d", new Object[] { Integer.valueOf(a.cpv()) });
        paramString1 = a.qYL;
        a.cpw();
      }
      AppMethodBeat.o(210957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.e.a
 * JD-Core Version:    0.7.0.1
 */