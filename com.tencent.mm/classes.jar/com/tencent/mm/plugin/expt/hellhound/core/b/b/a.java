package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback;", "", "()V", "CLASS_NAME", "", "METHOD_DESC_doAttach", "METHOD_DESC_doPause", "METHOD_DESC_doResume", "METHOD_DESC_onEnterBegin", "METHOD_DESC_onExitBegin", "METHOD_DESC_onExitEnd", "METHOD_NAME_doAttach", "METHOD_NAME_doPause", "METHOD_NAME_doResume", "METHOD_NAME_onEnterBegin", "METHOD_NAME_onExitBegin", "METHOD_NAME_onExitEnd", "mChatFragmentListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1;", "mDoAttach", "", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/IChatFragmentListener;", "mOnEnter", "mOnExit", "callbackOnEnter", "", "callbackOnExit", "callbackOnPause", "callbackOnResume", "monitor", "registerListener", "listener", "unregisterListener", "plugin-expt_release"})
public final class a
{
  private static List<i> mListeners;
  private static boolean qZA;
  private static boolean qZB;
  private static boolean qZC;
  private static final a qZD;
  public static final a qZE;
  
  static
  {
    AppMethodBeat.i(196297);
    qZE = new a();
    mListeners = (List)new ArrayList();
    qZD = new a();
    AppMethodBeat.o(196297);
  }
  
  public static void cov()
  {
    AppMethodBeat.i(196291);
    qZA = false;
    qZB = false;
    qZC = false;
    Map localMap = (Map)new LinkedHashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("doAttach", "(Landroid/content/Context;)V"));
    localArrayList.add(new Pair("onEnterBegin", "()V"));
    localArrayList.add(new Pair("onExitBegin", "()V"));
    localArrayList.add(new Pair("doResume", "()V"));
    localArrayList.add(new Pair("doPause", "()V"));
    localArrayList.add(new Pair("onExitEnd", "()V"));
    localMap.put("com/tencent/mm/ui/chatting/ChattingUIFragment", localArrayList);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a(localMap, (c)qZD);
    AppMethodBeat.o(196291);
  }
  
  private final void cpH()
  {
    try
    {
      AppMethodBeat.i(196293);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onEnter();
      }
      AppMethodBeat.o(196293);
    }
    finally {}
  }
  
  private final void cpI()
  {
    try
    {
      AppMethodBeat.i(196294);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onExit();
      }
      AppMethodBeat.o(196294);
    }
    finally {}
  }
  
  private final void cpJ()
  {
    try
    {
      AppMethodBeat.i(196295);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onResume();
      }
      AppMethodBeat.o(196295);
    }
    finally {}
  }
  
  private final void cpK()
  {
    try
    {
      AppMethodBeat.i(196296);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onPause();
      }
      AppMethodBeat.o(196296);
    }
    finally {}
  }
  
  public final void a(i parami)
  {
    try
    {
      AppMethodBeat.i(196292);
      p.h(parami, "listener");
      if (!mListeners.contains(parami)) {
        mListeners.add(parami);
      }
      AppMethodBeat.o(196292);
      return;
    }
    finally {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class a
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(196290);
      if ((p.i(paramString1, "com/tencent/mm/ui/chatting/ChattingUIFragment") ^ true))
      {
        AppMethodBeat.o(196290);
        return;
      }
      if (paramString2 == null)
      {
        AppMethodBeat.o(196290);
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
                          AppMethodBeat.o(196290);
                          return;
                          if ((paramString2.equals("onExitEnd")) && (p.i(paramString3, "()V")))
                          {
                            paramString1 = a.qZE;
                            a.kU(false);
                          }
                        }
                      } while ((!paramString2.equals("doResume")) || (!p.i(paramString3, "()V")));
                      paramString1 = a.qZE;
                    } while (a.cpL());
                    paramString1 = a.qZE;
                    if (a.cpM()) {
                      break;
                    }
                    a.b(a.qZE);
                    AppMethodBeat.o(196290);
                    return;
                  } while ((!paramString2.equals("onExitBegin")) || (!p.i(paramString3, "()V")));
                  paramString1 = a.qZE;
                } while (a.cpL());
                a.c(a.qZE);
                paramString1 = a.qZE;
                a.kW(true);
                AppMethodBeat.o(196290);
                return;
              } while ((!paramString2.equals("doPause")) || (!p.i(paramString3, "()V")));
              paramString1 = a.qZE;
            } while (a.cpL());
            paramString1 = a.qZE;
            if (a.cpN()) {
              break label373;
            }
            a.d(a.qZE);
            AppMethodBeat.o(196290);
            return;
          } while ((!paramString2.equals("onEnterBegin")) || (!p.i(paramString3, "()V")));
          paramString1 = a.qZE;
        } while (a.cpL());
        a.a(a.qZE);
        paramString1 = a.qZE;
        a.kV(true);
        AppMethodBeat.o(196290);
        return;
      } while ((!paramString2.equals("doAttach")) || (!p.i(paramString3, "(Landroid/content/Context;)V")));
      paramString1 = a.qZE;
      a.kU(true);
      AppMethodBeat.o(196290);
      return;
      paramString1 = a.qZE;
      a.kV(false);
      AppMethodBeat.o(196290);
      return;
      label373:
      paramString1 = a.qZE;
      a.kW(false);
      AppMethodBeat.o(196290);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a
 * JD-Core Version:    0.7.0.1
 */