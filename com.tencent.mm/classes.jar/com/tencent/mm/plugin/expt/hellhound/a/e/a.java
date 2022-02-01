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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor;", "", "()V", "Companion", "PermissionListener", "plugin-expt_release"})
public final class a
{
  private static int sIj;
  private static boolean sIk;
  private static boolean sIl;
  private static final b sIm;
  public static final a.a sIn;
  
  static
  {
    AppMethodBeat.i(184283);
    sIn = new a.a((byte)0);
    sIj = -1;
    sIm = new b();
    AppMethodBeat.o(184283);
  }
  
  public static final void cMH()
  {
    AppMethodBeat.i(184284);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("requestPermissions", "([Ljava/lang/String;I)V"));
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((List)localArrayList, (b)sIm);
    AppMethodBeat.o(184284);
  }
  
  public static final int cPH()
  {
    return sIj;
  }
  
  public static final void cPI()
  {
    sIj = -1;
  }
  
  public static final boolean cPJ()
  {
    return sIk;
  }
  
  public static final boolean cPK()
  {
    return sIl;
  }
  
  public static final void cPL()
  {
    sIl = false;
  }
  
  public static final void mj(boolean paramBoolean)
  {
    sIk = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor$PermissionListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "()V", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class b
    implements b
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject) {}
    
    public final void c(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(221120);
      if ((paramObject != null) && (((paramObject instanceof Activity)) || ((paramObject instanceof android.support.v4.app.Fragment)) || ((paramObject instanceof android.app.Fragment))) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString1 = a.sIn;
        paramString1 = paramArrayOfObject[1];
        if (paramString1 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(221120);
          throw paramString1;
        }
        a.Hk(((Integer)paramString1).intValue());
        paramString1 = a.sIn;
        Log.i("HABBYGE-MALI.PermissionMonitor", "PermissionListener, args: %d", new Object[] { Integer.valueOf(a.cPF()) });
        paramString1 = a.sIn;
        a.cPG();
      }
      AppMethodBeat.o(221120);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.e.a
 * JD-Core Version:    0.7.0.1
 */