package com.tencent.mm.plugin.findersdk.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/tmp/FinderNearByRef;", "", "()V", "nearByRefCallback", "Lcom/tencent/mm/plugin/findersdk/tmp/FinderNearByRef$INearByRef;", "getNearByRefCallback", "()Lcom/tencent/mm/plugin/findersdk/tmp/FinderNearByRef$INearByRef;", "setNearByRefCallback", "(Lcom/tencent/mm/plugin/findersdk/tmp/FinderNearByRef$INearByRef;)V", "isFinderLiveFindPageUI", "", "activity", "Landroid/app/Activity;", "isNearByUI", "isOtherSquareScene", "INearByRef", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b HeH;
  public static a HeI;
  
  static
  {
    AppMethodBeat.i(273726);
    HeH = new b();
    AppMethodBeat.o(273726);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(273703);
    s.u(parama, "<set-?>");
    HeI = parama;
    AppMethodBeat.o(273703);
  }
  
  public static boolean aD(Activity paramActivity)
  {
    AppMethodBeat.i(273710);
    s.u(paramActivity, "activity");
    boolean bool = fta().aD(paramActivity);
    AppMethodBeat.o(273710);
    return bool;
  }
  
  public static boolean aE(Activity paramActivity)
  {
    AppMethodBeat.i(273718);
    s.u(paramActivity, "activity");
    boolean bool = fta().aE(paramActivity);
    AppMethodBeat.o(273718);
    return bool;
  }
  
  public static boolean aF(Activity paramActivity)
  {
    AppMethodBeat.i(273723);
    s.u(paramActivity, "activity");
    boolean bool = fta().aF(paramActivity);
    AppMethodBeat.o(273723);
    return bool;
  }
  
  private static a fta()
  {
    AppMethodBeat.i(273699);
    a locala = HeI;
    if (locala != null)
    {
      AppMethodBeat.o(273699);
      return locala;
    }
    s.bIx("nearByRefCallback");
    AppMethodBeat.o(273699);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/tmp/FinderNearByRef$INearByRef;", "", "isFinderLiveFindPageUI", "", "activity", "Landroid/app/Activity;", "isNearByUI", "isOtherSquareScene", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract boolean aD(Activity paramActivity);
    
    public abstract boolean aE(Activity paramActivity);
    
    public abstract boolean aF(Activity paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.e.b
 * JD-Core Version:    0.7.0.1
 */