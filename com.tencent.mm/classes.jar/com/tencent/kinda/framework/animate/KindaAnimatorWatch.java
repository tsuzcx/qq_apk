package com.tencent.kinda.framework.animate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;

public class KindaAnimatorWatch
{
  private static final String TAG = "MicroMsg.KindaAnimatorWatch";
  private static Map<Integer, Runnable> pendingActions;
  private static int pendingObj;
  
  static
  {
    AppMethodBeat.i(144291);
    pendingActions = new HashMap();
    pendingObj = 0;
    AppMethodBeat.o(144291);
  }
  
  public static void didObjCreated(int paramInt)
  {
    AppMethodBeat.i(144289);
    pendingObj = paramInt;
    al.p(new KindaAnimatorWatch.2(paramInt), 5000L);
    AppMethodBeat.o(144289);
  }
  
  public static void didViewCreated(int paramInt)
  {
    AppMethodBeat.i(144290);
    pendingObj = 0;
    if (pendingActions.containsKey(Integer.valueOf(paramInt)))
    {
      Runnable localRunnable = (Runnable)pendingActions.get(Integer.valueOf(paramInt));
      pendingActions.remove(Integer.valueOf(paramInt));
      al.d(new KindaAnimatorWatch.3(localRunnable));
    }
    AppMethodBeat.o(144290);
  }
  
  public static void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(144288);
    if (pendingObj != 0)
    {
      pendingActions.put(Integer.valueOf(pendingObj), paramRunnable);
      pendingObj = 0;
      AppMethodBeat.o(144288);
      return;
    }
    al.d(new KindaAnimatorWatch.1(paramRunnable));
    AppMethodBeat.o(144288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimatorWatch
 * JD-Core Version:    0.7.0.1
 */