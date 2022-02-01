package com.tencent.kinda.framework.animate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.HashMap;
import java.util.Map;

public class KindaAnimatorWatch
{
  private static final String TAG = "MicroMsg.KindaAnimatorWatch";
  private static Map<Integer, Runnable> pendingActions;
  private static int pendingObj;
  
  static
  {
    AppMethodBeat.i(18326);
    pendingActions = new HashMap();
    pendingObj = 0;
    AppMethodBeat.o(18326);
  }
  
  public static void didObjCreated(int paramInt)
  {
    AppMethodBeat.i(18324);
    pendingObj = paramInt;
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(18321);
        if (KindaAnimatorWatch.pendingActions.containsKey(Integer.valueOf(this.val$hash_code))) {
          KindaAnimatorWatch.pendingActions.remove(Integer.valueOf(this.val$hash_code));
        }
        AppMethodBeat.o(18321);
      }
    }, 5000L);
    AppMethodBeat.o(18324);
  }
  
  public static void didViewCreated(int paramInt)
  {
    AppMethodBeat.i(18325);
    pendingObj = 0;
    if (pendingActions.containsKey(Integer.valueOf(paramInt)))
    {
      Runnable localRunnable = (Runnable)pendingActions.get(Integer.valueOf(paramInt));
      pendingActions.remove(Integer.valueOf(paramInt));
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(18322);
          this.val$action.run();
          AppMethodBeat.o(18322);
        }
      });
    }
    AppMethodBeat.o(18325);
  }
  
  public static void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(18323);
    if (pendingObj != 0)
    {
      pendingActions.put(Integer.valueOf(pendingObj), paramRunnable);
      pendingObj = 0;
      AppMethodBeat.o(18323);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(18320);
        this.val$action.run();
        AppMethodBeat.o(18320);
      }
    });
    AppMethodBeat.o(18323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimatorWatch
 * JD-Core Version:    0.7.0.1
 */