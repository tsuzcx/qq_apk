package com.tencent.kinda.framework.animate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KindaAnimatorWatch
{
  private static final String TAG = "MicroMsg.KindaAnimatorWatch";
  private static List<Runnable> pendingActions;
  private static int pendingObj;
  
  static
  {
    AppMethodBeat.i(18326);
    pendingActions = new ArrayList();
    pendingObj = 0;
    AppMethodBeat.o(18326);
  }
  
  public static void didObjCreated(int paramInt)
  {
    AppMethodBeat.i(18324);
    new StringBuilder("didObjCreated: creating pendingObj=").append(paramInt).append(".");
    pendingObj = paramInt;
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18321);
        if (this.val$hash_code == KindaAnimatorWatch.pendingObj)
        {
          AppMethodBeat.o(18321);
          return;
        }
        Iterator localIterator = KindaAnimatorWatch.pendingActions.iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
        KindaAnimatorWatch.pendingActions.clear();
        KindaAnimatorWatch.access$002(0);
        AppMethodBeat.o(18321);
      }
    }, 5000L);
    AppMethodBeat.o(18324);
  }
  
  public static void didViewCreated(int paramInt)
  {
    AppMethodBeat.i(18325);
    if (paramInt != pendingObj)
    {
      new StringBuilder("didViewCreated: pendingObj:").append(paramInt).append(" has created view, but there is a new pendingObj=").append(pendingObj).append(", just wait.");
      AppMethodBeat.o(18325);
      return;
    }
    new StringBuilder("didViewCreated: pendingObj=").append(pendingObj).append(", has created view. should run actions.");
    pendingObj = 0;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18322);
        new StringBuilder("post: pendingObj=").append(this.val$tempObj).append(", run actions.");
        Iterator localIterator = KindaAnimatorWatch.pendingActions.iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
        KindaAnimatorWatch.pendingActions.clear();
        AppMethodBeat.o(18322);
      }
    });
    AppMethodBeat.o(18325);
  }
  
  public static void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(18323);
    if (pendingObj != 0)
    {
      new StringBuilder("post: pendingObj=").append(pendingObj).append(", append queue, wait for view create.");
      pendingActions.add(paramRunnable);
      AppMethodBeat.o(18323);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18320);
        KindaAnimatorWatch.this.run();
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