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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback;", "", "()V", "CLASS_NAME", "", "METHOD_DESC_doAttach", "METHOD_DESC_doPause", "METHOD_DESC_doResume", "METHOD_DESC_onEnterBegin", "METHOD_DESC_onExitBegin", "METHOD_DESC_onExitEnd", "METHOD_NAME_doAttach", "METHOD_NAME_doPause", "METHOD_NAME_doResume", "METHOD_NAME_onEnterBegin", "METHOD_NAME_onExitBegin", "METHOD_NAME_onExitEnd", "mChatFragmentListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1;", "mDoAttach", "", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/IChatFragmentListener;", "mOnEnter", "mOnExit", "callbackOnEnter", "", "callbackOnExit", "callbackOnPause", "callbackOnResume", "monitor", "registerListener", "listener", "unregisterListener", "plugin-expt_release"})
public final class a
{
  private static List<i> mListeners;
  private static boolean qRC;
  private static boolean qRD;
  private static boolean qRE;
  private static final a qRF;
  public static final a qRG;
  
  static
  {
    AppMethodBeat.i(210630);
    qRG = new a();
    mListeners = (List)new ArrayList();
    qRF = new a();
    AppMethodBeat.o(210630);
  }
  
  public static void cnf()
  {
    AppMethodBeat.i(210624);
    qRC = false;
    qRD = false;
    qRE = false;
    Map localMap = (Map)new LinkedHashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("doAttach", "(Landroid/content/Context;)V"));
    localArrayList.add(new Pair("onEnterBegin", "()V"));
    localArrayList.add(new Pair("onExitBegin", "()V"));
    localArrayList.add(new Pair("doResume", "()V"));
    localArrayList.add(new Pair("doPause", "()V"));
    localArrayList.add(new Pair("onExitEnd", "()V"));
    localMap.put("com/tencent/mm/ui/chatting/ChattingUIFragment", localArrayList);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(localMap, (c)qRF);
    AppMethodBeat.o(210624);
  }
  
  private final void cof()
  {
    try
    {
      AppMethodBeat.i(210626);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onEnter();
      }
      AppMethodBeat.o(210626);
    }
    finally {}
  }
  
  private final void cog()
  {
    try
    {
      AppMethodBeat.i(210627);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onExit();
      }
      AppMethodBeat.o(210627);
    }
    finally {}
  }
  
  private final void coh()
  {
    try
    {
      AppMethodBeat.i(210628);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onResume();
      }
      AppMethodBeat.o(210628);
    }
    finally {}
  }
  
  private final void coi()
  {
    try
    {
      AppMethodBeat.i(210629);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onPause();
      }
      AppMethodBeat.o(210629);
    }
    finally {}
  }
  
  public final void a(i parami)
  {
    try
    {
      AppMethodBeat.i(210625);
      p.h(parami, "listener");
      if (!mListeners.contains(parami)) {
        mListeners.add(parami);
      }
      AppMethodBeat.o(210625);
      return;
    }
    finally {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class a
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210623);
      if ((p.i(paramString1, "com/tencent/mm/ui/chatting/ChattingUIFragment") ^ true))
      {
        AppMethodBeat.o(210623);
        return;
      }
      if (paramString2 == null)
      {
        AppMethodBeat.o(210623);
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
                          AppMethodBeat.o(210623);
                          return;
                          if ((paramString2.equals("onExitEnd")) && (p.i(paramString3, "()V")))
                          {
                            paramString1 = a.qRG;
                            a.kU(false);
                          }
                        }
                      } while ((!paramString2.equals("doResume")) || (!p.i(paramString3, "()V")));
                      paramString1 = a.qRG;
                    } while (a.coj());
                    paramString1 = a.qRG;
                    if (a.cok()) {
                      break;
                    }
                    a.b(a.qRG);
                    AppMethodBeat.o(210623);
                    return;
                  } while ((!paramString2.equals("onExitBegin")) || (!p.i(paramString3, "()V")));
                  paramString1 = a.qRG;
                } while (a.coj());
                a.c(a.qRG);
                paramString1 = a.qRG;
                a.kW(true);
                AppMethodBeat.o(210623);
                return;
              } while ((!paramString2.equals("doPause")) || (!p.i(paramString3, "()V")));
              paramString1 = a.qRG;
            } while (a.coj());
            paramString1 = a.qRG;
            if (a.col()) {
              break label373;
            }
            a.d(a.qRG);
            AppMethodBeat.o(210623);
            return;
          } while ((!paramString2.equals("onEnterBegin")) || (!p.i(paramString3, "()V")));
          paramString1 = a.qRG;
        } while (a.coj());
        a.a(a.qRG);
        paramString1 = a.qRG;
        a.kV(true);
        AppMethodBeat.o(210623);
        return;
      } while ((!paramString2.equals("doAttach")) || (!p.i(paramString3, "(Landroid/content/Context;)V")));
      paramString1 = a.qRG;
      a.kU(true);
      AppMethodBeat.o(210623);
      return;
      paramString1 = a.qRG;
      a.kV(false);
      AppMethodBeat.o(210623);
      return;
      label373:
      paramString1 = a.qRG;
      a.kW(false);
      AppMethodBeat.o(210623);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a
 * JD-Core Version:    0.7.0.1
 */