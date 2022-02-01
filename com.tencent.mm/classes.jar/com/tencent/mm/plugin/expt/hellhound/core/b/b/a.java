package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback;", "", "()V", "CLASS_NAME", "", "METHOD_DESC_doAttach", "METHOD_DESC_doPause", "METHOD_DESC_doResume", "METHOD_DESC_onEnterBegin", "METHOD_DESC_onExitBegin", "METHOD_DESC_onExitEnd", "METHOD_NAME_doAttach", "METHOD_NAME_doPause", "METHOD_NAME_doResume", "METHOD_NAME_onEnterBegin", "METHOD_NAME_onExitBegin", "METHOD_NAME_onExitEnd", "mChatFragmentListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1;", "mDoAttach", "", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/IChatFragmentListener;", "mOnEnter", "mOnExit", "callbackOnEnter", "", "callbackOnExit", "callbackOnPause", "callbackOnResume", "monitor", "registerListener", "listener", "unregisterListener", "plugin-expt_release"})
public final class a
{
  private static List<i> mListeners;
  private static boolean szR;
  private static boolean szS;
  private static boolean szT;
  private static final a szU;
  public static final a szV;
  
  static
  {
    AppMethodBeat.i(220745);
    szV = new a();
    mListeners = (List)new ArrayList();
    szU = new a();
    AppMethodBeat.o(220745);
  }
  
  public static void cMH()
  {
    AppMethodBeat.i(220739);
    szR = false;
    szS = false;
    szT = false;
    Map localMap = (Map)new LinkedHashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("doAttach", "(Landroid/content/Context;)V"));
    localArrayList.add(new Pair("onEnterBegin", "()V"));
    localArrayList.add(new Pair("onExitBegin", "()V"));
    localArrayList.add(new Pair("doResume", "()V"));
    localArrayList.add(new Pair("doPause", "()V"));
    localArrayList.add(new Pair("onExitEnd", "()V"));
    localMap.put("com/tencent/mm/ui/chatting/ChattingUIFragment", localArrayList);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a(localMap, (c)szU);
    AppMethodBeat.o(220739);
  }
  
  private final void cOa()
  {
    try
    {
      AppMethodBeat.i(220741);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onEnter();
      }
      AppMethodBeat.o(220741);
    }
    finally {}
  }
  
  private final void cOb()
  {
    try
    {
      AppMethodBeat.i(220742);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onExit();
      }
      AppMethodBeat.o(220742);
    }
    finally {}
  }
  
  private final void cOc()
  {
    try
    {
      AppMethodBeat.i(220743);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onResume();
      }
      AppMethodBeat.o(220743);
    }
    finally {}
  }
  
  private final void cOd()
  {
    try
    {
      AppMethodBeat.i(220744);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onPause();
      }
      AppMethodBeat.o(220744);
    }
    finally {}
  }
  
  public final void a(i parami)
  {
    try
    {
      AppMethodBeat.i(220740);
      p.h(parami, "listener");
      if (!mListeners.contains(parami)) {
        mListeners.add(parami);
      }
      AppMethodBeat.o(220740);
      return;
    }
    finally {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class a
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220738);
      if ((p.j(paramString1, "com/tencent/mm/ui/chatting/ChattingUIFragment") ^ true))
      {
        AppMethodBeat.o(220738);
        return;
      }
      if (paramString2 == null)
      {
        AppMethodBeat.o(220738);
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
                          AppMethodBeat.o(220738);
                          return;
                          if ((paramString2.equals("onExitEnd")) && (p.j(paramString3, "()V")))
                          {
                            paramString1 = a.szV;
                            a.lY(false);
                          }
                        }
                      } while ((!paramString2.equals("doResume")) || (!p.j(paramString3, "()V")));
                      paramString1 = a.szV;
                    } while (a.cOe());
                    paramString1 = a.szV;
                    if (a.cOf()) {
                      break;
                    }
                    a.b(a.szV);
                    AppMethodBeat.o(220738);
                    return;
                  } while ((!paramString2.equals("onExitBegin")) || (!p.j(paramString3, "()V")));
                  paramString1 = a.szV;
                } while (a.cOe());
                a.c(a.szV);
                paramString1 = a.szV;
                a.ma(true);
                AppMethodBeat.o(220738);
                return;
              } while ((!paramString2.equals("doPause")) || (!p.j(paramString3, "()V")));
              paramString1 = a.szV;
            } while (a.cOe());
            paramString1 = a.szV;
            if (a.cOg()) {
              break label373;
            }
            a.d(a.szV);
            AppMethodBeat.o(220738);
            return;
          } while ((!paramString2.equals("onEnterBegin")) || (!p.j(paramString3, "()V")));
          paramString1 = a.szV;
        } while (a.cOe());
        a.a(a.szV);
        paramString1 = a.szV;
        a.lZ(true);
        AppMethodBeat.o(220738);
        return;
      } while ((!paramString2.equals("doAttach")) || (!p.j(paramString3, "(Landroid/content/Context;)V")));
      paramString1 = a.szV;
      a.lY(true);
      AppMethodBeat.o(220738);
      return;
      paramString1 = a.szV;
      a.lZ(false);
      AppMethodBeat.o(220738);
      return;
      label373:
      paramString1 = a.szV;
      a.ma(false);
      AppMethodBeat.o(220738);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a
 * JD-Core Version:    0.7.0.1
 */