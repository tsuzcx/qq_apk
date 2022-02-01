package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback;", "", "()V", "CLASS_NAME", "", "METHOD_DESC_doAttach", "METHOD_DESC_doPause", "METHOD_DESC_doResume", "METHOD_DESC_onEnterBegin", "METHOD_DESC_onExitBegin", "METHOD_DESC_onExitEnd", "METHOD_NAME_doAttach", "METHOD_NAME_doPause", "METHOD_NAME_doResume", "METHOD_NAME_onEnterBegin", "METHOD_NAME_onExitBegin", "METHOD_NAME_onExitEnd", "mChatFragmentListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1;", "mDoAttach", "", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/IChatFragmentListener;", "mOnEnter", "mOnExit", "callbackOnEnter", "", "callbackOnExit", "callbackOnPause", "callbackOnResume", "monitor", "registerListener", "listener", "unregisterListener", "plugin-expt_release"})
public final class a
{
  private static List<i> mListeners;
  private static boolean wfL;
  private static boolean wfM;
  private static boolean wfN;
  private static final a wfO;
  public static final a wfP;
  
  static
  {
    AppMethodBeat.i(257288);
    wfP = new a();
    mListeners = (List)new ArrayList();
    wfO = new a();
    AppMethodBeat.o(257288);
  }
  
  public static void Xr()
  {
    AppMethodBeat.i(257281);
    wfL = false;
    wfM = false;
    wfN = false;
    Map localMap = (Map)new LinkedHashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("doAttach", "(Landroid/content/Context;)V"));
    localArrayList.add(new Pair("onEnterBegin", "()V"));
    localArrayList.add(new Pair("onExitBegin", "()V"));
    localArrayList.add(new Pair("doResume", "()V"));
    localArrayList.add(new Pair("doPause", "()V"));
    localArrayList.add(new Pair("onExitEnd", "()V"));
    localMap.put("com/tencent/mm/ui/chatting/ChattingUIFragment", localArrayList);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a(localMap, (d)wfO);
    AppMethodBeat.o(257281);
  }
  
  private final void dcS()
  {
    try
    {
      AppMethodBeat.i(257283);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onEnter();
      }
      AppMethodBeat.o(257283);
    }
    finally {}
  }
  
  private final void dcT()
  {
    try
    {
      AppMethodBeat.i(257284);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onExit();
      }
      AppMethodBeat.o(257284);
    }
    finally {}
  }
  
  private final void dcU()
  {
    try
    {
      AppMethodBeat.i(257286);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onResume();
      }
      AppMethodBeat.o(257286);
    }
    finally {}
  }
  
  private final void dcV()
  {
    try
    {
      AppMethodBeat.i(257287);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onPause();
      }
      AppMethodBeat.o(257287);
    }
    finally {}
  }
  
  public final void a(i parami)
  {
    try
    {
      AppMethodBeat.i(257282);
      p.k(parami, "listener");
      if (!mListeners.contains(parami)) {
        mListeners.add(parami);
      }
      AppMethodBeat.o(257282);
      return;
    }
    finally {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class a
    implements d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(255930);
      if ((p.h(paramString1, "com/tencent/mm/ui/chatting/ChattingUIFragment") ^ true))
      {
        AppMethodBeat.o(255930);
        return;
      }
      if (paramString2 == null)
      {
        AppMethodBeat.o(255930);
        return;
      }
      switch (paramString2.hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        for (;;)
                        {
                          AppMethodBeat.o(255930);
                          return;
                          if ((paramString2.equals("onExitEnd")) && (p.h(paramString3, "()V")))
                          {
                            paramString1 = a.wfP;
                            a.nk(false);
                          }
                        }
                      } while ((!paramString2.equals("doResume")) || (!p.h(paramString3, "()V")));
                      paramString1 = a.wfP;
                    } while (a.dcW());
                    paramString1 = a.wfP;
                    if (a.dcX()) {
                      break;
                    }
                    a.b(a.wfP);
                    AppMethodBeat.o(255930);
                    return;
                  } while ((!paramString2.equals("onExitBegin")) || (!p.h(paramString3, "()V")));
                  paramString1 = a.wfP;
                } while (a.dcW());
                a.c(a.wfP);
                paramString1 = a.wfP;
                a.nm(true);
                AppMethodBeat.o(255930);
                return;
              } while ((!paramString2.equals("doPause")) || (!p.h(paramString3, "()V")));
              paramString1 = a.wfP;
            } while (a.dcW());
            paramString1 = a.wfP;
            if (a.dcY()) {
              break label373;
            }
            a.d(a.wfP);
            AppMethodBeat.o(255930);
            return;
          } while ((!paramString2.equals("onEnterBegin")) || (!p.h(paramString3, "()V")));
          paramString1 = a.wfP;
        } while (a.dcW());
        a.a(a.wfP);
        paramString1 = a.wfP;
        a.nl(true);
        AppMethodBeat.o(255930);
        return;
      } while ((!paramString2.equals("doAttach")) || (!p.h(paramString3, "(Landroid/content/Context;)V")));
      paramString1 = a.wfP;
      a.nk(true);
      AppMethodBeat.o(255930);
      return;
      paramString1 = a.wfP;
      a.nl(false);
      AppMethodBeat.o(255930);
      return;
      label373:
      paramString1 = a.wfP;
      a.nm(false);
      AppMethodBeat.o(255930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a
 * JD-Core Version:    0.7.0.1
 */