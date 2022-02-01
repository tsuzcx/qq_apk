package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.plugin.expt.b.e.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback;", "", "()V", "CLASS_NAME", "", "METHOD_DESC_doAttach", "METHOD_DESC_doPause", "METHOD_DESC_doResume", "METHOD_DESC_onEnterBegin", "METHOD_DESC_onExitBegin", "METHOD_DESC_onExitEnd", "METHOD_NAME_doAttach", "METHOD_NAME_doPause", "METHOD_NAME_doResume", "METHOD_NAME_onEnterBegin", "METHOD_NAME_onExitBegin", "METHOD_NAME_onExitEnd", "mChatFragmentListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1;", "mDoAttach", "", "mHellEventListeners", "", "Lcom/tencent/mm/plugin/expt/api/IHellhoundService$IHellEventListener;", "mListeners", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/IChatFragmentListener;", "mOnEnter", "mOnExit", "callbackOnEnter", "", "caller", "callbackOnExit", "callbackOnPause", "callbackOnResume", "monitor", "registerHellEventListener", "listener", "registerListener", "unregisterHellEventListener", "unregisterListener", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static List<i> mListeners;
  private static List<e.d> zBA;
  public static final a zBM;
  private static boolean zBN;
  private static boolean zBO;
  private static boolean zBP;
  private static final a zBQ;
  
  static
  {
    AppMethodBeat.i(300014);
    zBM = new a();
    mListeners = (List)new ArrayList();
    zBA = (List)new ArrayList();
    zBQ = new a();
    AppMethodBeat.o(300014);
  }
  
  public static void a(e.d paramd)
  {
    AppMethodBeat.i(299980);
    s.u(paramd, "listener");
    if (!zBA.contains(paramd)) {
      zBA.add(paramd);
    }
    AppMethodBeat.o(299980);
  }
  
  public static void ayW()
  {
    AppMethodBeat.i(299960);
    zBN = false;
    zBO = false;
    zBP = false;
    Map localMap = (Map)new LinkedHashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("doAttach", "(Landroid/content/Context;)V"));
    localArrayList.add(new Pair("onEnterBegin", "()V"));
    localArrayList.add(new Pair("onExitBegin", "()V"));
    localArrayList.add(new Pair("doResume", "()V"));
    localArrayList.add(new Pair("doPause", "()V"));
    localArrayList.add(new Pair("onExitEnd", "()V"));
    localMap.put("com/tencent/mm/ui/chatting/ChattingUIFragment", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a(localMap, (d)zBQ);
    AppMethodBeat.o(299960);
  }
  
  private final void dJu()
  {
    try
    {
      AppMethodBeat.i(299965);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).dJD();
      }
      AppMethodBeat.o(299965);
    }
    finally {}
  }
  
  private final void dJv()
  {
    try
    {
      AppMethodBeat.i(299969);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).dJE();
      }
      AppMethodBeat.o(299969);
    }
    finally {}
  }
  
  private final void dJw()
  {
    try
    {
      AppMethodBeat.i(299973);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).dJF();
      }
      AppMethodBeat.o(299973);
    }
    finally {}
  }
  
  private final void dJx()
  {
    try
    {
      AppMethodBeat.i(299977);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).dJG();
      }
      AppMethodBeat.o(299977);
    }
    finally {}
  }
  
  public final void a(i parami)
  {
    try
    {
      AppMethodBeat.i(300016);
      s.u(parami, "listener");
      if (!mListeners.contains(parami)) {
        mListeners.add(parami);
      }
      AppMethodBeat.o(300016);
      return;
    }
    finally {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(299990);
      if (!s.p(paramString1, "com/tencent/mm/ui/chatting/ChattingUIFragment"))
      {
        AppMethodBeat.o(299990);
        return;
      }
      if (paramString2 != null) {
        switch (paramString2.hashCode())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(299990);
        return;
        if (!paramString2.equals("onExitEnd"))
        {
          AppMethodBeat.o(299990);
          return;
          if (!paramString2.equals("doResume"))
          {
            AppMethodBeat.o(299990);
            return;
            if (!paramString2.equals("onExitBegin"))
            {
              AppMethodBeat.o(299990);
              return;
              if (paramString2.equals("doPause")) {
                break label318;
              }
              AppMethodBeat.o(299990);
              return;
              if (!paramString2.equals("onEnterBegin"))
              {
                AppMethodBeat.o(299990);
                return;
                if ((!paramString2.equals("doAttach")) || (!s.p(paramString3, "(Landroid/content/Context;)V"))) {
                  continue;
                }
                paramString1 = a.zBM;
                a.oK(true);
                AppMethodBeat.o(299990);
                return;
              }
              if ((!s.p(paramString3, "()V")) || (a.dJy())) {
                continue;
              }
              a.a(a.zBM);
              paramString1 = a.zBM;
              a.oL(true);
              AppMethodBeat.o(299990);
            }
          }
          else
          {
            if ((!s.p(paramString3, "()V")) || (a.dJy())) {
              continue;
            }
            if (!a.dJz())
            {
              a.b(a.zBM);
              AppMethodBeat.o(299990);
              return;
            }
            paramString1 = a.zBM;
            a.oL(false);
            AppMethodBeat.o(299990);
            return;
          }
          if ((s.p(paramString3, "()V")) && (!a.dJy()))
          {
            a.c(a.zBM);
            paramString1 = a.zBM;
            a.oM(true);
            AppMethodBeat.o(299990);
            return;
            label318:
            if ((s.p(paramString3, "()V")) && (!a.dJy()))
            {
              if (!a.dJA())
              {
                a.d(a.zBM);
                AppMethodBeat.o(299990);
                return;
              }
              paramString1 = a.zBM;
              a.oM(false);
              AppMethodBeat.o(299990);
            }
          }
        }
        else if (s.p(paramString3, "()V"))
        {
          paramString1 = a.zBM;
          a.oK(false);
          paramString1 = ((Iterable)a.dJB()).iterator();
          while (paramString1.hasNext()) {
            ((e.d)paramString1.next()).eW(paramObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a
 * JD-Core Version:    0.7.0.1
 */