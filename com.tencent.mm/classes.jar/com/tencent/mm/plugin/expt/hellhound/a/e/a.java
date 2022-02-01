package com.tencent.mm.plugin.expt.hellhound.a.e;

import android.app.Activity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor;", "", "()V", "Companion", "PermissionListener", "plugin-expt_release"})
public final class a
{
  private static int woe;
  private static boolean wof;
  private static boolean wog;
  private static final b woh;
  public static final a.a woi;
  
  static
  {
    AppMethodBeat.i(184283);
    woi = new a.a((byte)0);
    woe = -1;
    woh = new b();
    AppMethodBeat.o(184283);
  }
  
  public static final void Xr()
  {
    AppMethodBeat.i(184284);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("requestPermissions", "([Ljava/lang/String;I)V"));
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((List)localArrayList, (b)woh);
    AppMethodBeat.o(184284);
  }
  
  public static final int deB()
  {
    return woe;
  }
  
  public static final void deC()
  {
    woe = -1;
  }
  
  public static final boolean deD()
  {
    return wof;
  }
  
  public static final boolean deE()
  {
    return wog;
  }
  
  public static final void deF()
  {
    wog = false;
  }
  
  public static final void nw(boolean paramBoolean)
  {
    wof = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor$PermissionListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "()V", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class b
    implements b
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(256509);
      if ((paramObject != null) && (((paramObject instanceof Activity)) || ((paramObject instanceof androidx.fragment.app.Fragment)) || ((paramObject instanceof android.app.Fragment))) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString1 = a.woi;
        paramString1 = paramArrayOfObject[1];
        if (paramString1 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(256509);
          throw paramString1;
        }
        a.KU(((Integer)paramString1).intValue());
        paramString1 = a.woi;
        Log.i("HABBYGE-MALI.PermissionMonitor", "PermissionListener, args: %d", new Object[] { Integer.valueOf(a.dez()) });
        paramString1 = a.woi;
        a.deA();
      }
      AppMethodBeat.o(256509);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.e.a
 * JD-Core Version:    0.7.0.1
 */