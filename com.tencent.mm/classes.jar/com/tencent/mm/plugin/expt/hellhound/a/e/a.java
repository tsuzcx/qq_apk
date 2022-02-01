package com.tencent.mm.plugin.expt.hellhound.a.e;

import android.app.Activity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor;", "", "()V", "Companion", "PermissionListener", "plugin-expt_release"})
public final class a
{
  private static int rgN;
  private static boolean rgO;
  private static boolean rgP;
  private static final b rgQ;
  public static final a.a rgR;
  
  static
  {
    AppMethodBeat.i(184283);
    rgR = new a.a((byte)0);
    rgN = -1;
    rgQ = new b();
    AppMethodBeat.o(184283);
  }
  
  public static final void cov()
  {
    AppMethodBeat.i(184284);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("requestPermissions", "([Ljava/lang/String;I)V"));
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((List)localArrayList, (b)rgQ);
    AppMethodBeat.o(184284);
  }
  
  public static final int cqZ()
  {
    return rgN;
  }
  
  public static final void cra()
  {
    rgN = -1;
  }
  
  public static final boolean crb()
  {
    return rgO;
  }
  
  public static final boolean crc()
  {
    return rgP;
  }
  
  public static final void crd()
  {
    rgP = false;
  }
  
  public static final void lb(boolean paramBoolean)
  {
    rgO = paramBoolean;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor$PermissionListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "()V", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class b
    implements b
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject) {}
    
    public final void c(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(196628);
      if ((paramObject != null) && (((paramObject instanceof Activity)) || ((paramObject instanceof android.support.v4.app.Fragment)) || ((paramObject instanceof android.app.Fragment))) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString1 = a.rgR;
        paramString1 = paramArrayOfObject[1];
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(196628);
          throw paramString1;
        }
        a.Dx(((Integer)paramString1).intValue());
        paramString1 = a.rgR;
        ae.i("HABBYGE-MALI.PermissionMonitor", "PermissionListener, args: %d", new Object[] { Integer.valueOf(a.cqX()) });
        paramString1 = a.rgR;
        a.cqY();
      }
      AppMethodBeat.o(196628);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.e.a
 * JD-Core Version:    0.7.0.1
 */