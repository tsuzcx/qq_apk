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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor;", "", "()V", "Companion", "PermissionListener", "plugin-expt_release"})
public final class a
{
  private static int pHb;
  private static boolean pHc;
  private static boolean pHd;
  private static final b pHe;
  public static final a.a pHf;
  
  static
  {
    AppMethodBeat.i(184283);
    pHf = new a.a((byte)0);
    pHb = -1;
    pHe = new b();
    AppMethodBeat.o(184283);
  }
  
  public static final void ccA()
  {
    pHb = -1;
  }
  
  public static final boolean ccB()
  {
    return pHc;
  }
  
  public static final boolean ccC()
  {
    return pHd;
  }
  
  public static final void ccD()
  {
    pHd = false;
  }
  
  public static final void ccE()
  {
    AppMethodBeat.i(184284);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("requestPermissions", "([Ljava/lang/String;I)V"));
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a((List)localArrayList, (b)pHe);
    AppMethodBeat.o(184284);
  }
  
  public static final int ccz()
  {
    return pHb;
  }
  
  public static final void kf(boolean paramBoolean)
  {
    pHc = paramBoolean;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor$PermissionListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "()V", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class b
    implements b
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184282);
      if ((paramObject != null) && (((paramObject instanceof Activity)) || ((paramObject instanceof android.support.v4.app.Fragment)) || ((paramObject instanceof android.app.Fragment))) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString1 = a.pHf;
        paramString1 = paramArrayOfObject[1];
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(184282);
          throw paramString1;
        }
        a.BD(((Integer)paramString1).intValue());
        paramString1 = a.pHf;
        ad.i("PermissionMonitor", "HABBYGE-MALI, PermissionListener, args: %d", new Object[] { Integer.valueOf(a.ccx()) });
        paramString1 = a.pHf;
        a.ccy();
      }
      AppMethodBeat.o(184282);
    }
    
    public final void l(String paramString1, String paramString2, String paramString3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.e.a
 * JD-Core Version:    0.7.0.1
 */