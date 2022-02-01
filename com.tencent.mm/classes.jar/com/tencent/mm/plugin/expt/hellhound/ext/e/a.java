package com.tencent.mm.plugin.expt.hellhound.ext.e;

import android.app.Activity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor;", "", "()V", "Companion", "PermissionListener", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a zKh;
  private static int zKi;
  private static boolean zKj;
  private static boolean zKk;
  private static final b zKl;
  
  static
  {
    AppMethodBeat.i(184283);
    zKh = new a.a((byte)0);
    zKi = -1;
    zKl = new b();
    AppMethodBeat.o(184283);
  }
  
  public static final void ayW()
  {
    AppMethodBeat.i(184284);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("requestPermissions", "([Ljava/lang/String;I)V"));
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((List)localArrayList, (b)zKl);
    AppMethodBeat.o(184284);
  }
  
  public static final int dLo()
  {
    return zKi;
  }
  
  public static final void dLp()
  {
    zKi = -1;
  }
  
  public static final boolean dLq()
  {
    return zKj;
  }
  
  public static final boolean dLr()
  {
    return zKk;
  }
  
  public static final void dLs()
  {
    zKk = false;
  }
  
  public static final void oW(boolean paramBoolean)
  {
    zKj = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor$PermissionListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "()V", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements b
  {
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300109);
      if ((paramObject != null) && (((paramObject instanceof Activity)) || ((paramObject instanceof androidx.fragment.app.Fragment)) || ((paramObject instanceof android.app.Fragment))) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString1 = a.zKh;
        a.LT(((Integer)paramArrayOfObject[1]).intValue());
        paramString1 = a.zKh;
        Log.i("HABBYGE-MALI.PermissionMonitor", "PermissionListener, args: %d", new Object[] { Integer.valueOf(a.dLt()) });
        paramString1 = a.zKh;
        a.dLu();
      }
      AppMethodBeat.o(300109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.e.a
 * JD-Core Version:    0.7.0.1
 */