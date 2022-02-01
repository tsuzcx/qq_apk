package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveCallbacks;", "", "()V", "liveBanCommentCallbacks", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sysTip", "", "Lkotlin/collections/HashMap;", "liveKickedCallbacks", "Lkotlin/Function0;", "liveMessageCallbacks", "", "kotlin.jvm.PlatformType", "", "liveOnlineCntChangeCallbacks", "liveSlowMessageCallbacks", "livelinkMicCallbacks", "Lkotlin/Function2;", "", "linked", "callingUser", "callbackBanComment", "callbackKicked", "callbackLinkMic", "callbackLiveMessage", "callbackOnlineCntChanged", "callbackSlowLiveMessage", "registerLiveBanCommentCallback", "key", "callback", "registerLiveKickedCallback", "registerLiveLinkMicCallback", "registerLiveMessageCallback", "registerOnlineCntChangedCallback", "registerSlowLiveMessageCallback", "releaseCallbacks", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j mXT;
  private static final HashMap<String, a<ah>> mXU;
  private static final Map<String, a<ah>> mXV;
  private static final HashMap<String, b<String, ah>> mXW;
  private static final HashMap<String, m<Boolean, String, ah>> mXX;
  private static final HashMap<String, a<ah>> mXY;
  private static final HashMap<String, a<ah>> mXZ;
  
  static
  {
    AppMethodBeat.i(246657);
    mXT = new j();
    mXU = new HashMap();
    mXV = Collections.synchronizedMap((Map)new HashMap());
    mXW = new HashMap();
    mXX = new HashMap();
    mXY = new HashMap();
    mXZ = new HashMap();
    AppMethodBeat.o(246657);
  }
  
  public static void Gj(String paramString)
  {
    AppMethodBeat.i(246577);
    s.u(paramString, "sysTip");
    Iterator localIterator = ((Map)mXW).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).invoke(paramString);
    }
    AppMethodBeat.o(246577);
  }
  
  public static void a(String paramString, b<? super String, ah> paramb)
  {
    AppMethodBeat.i(246626);
    s.u(paramString, "key");
    s.u(paramb, "callback");
    ((Map)mXW).put(paramString, paramb);
    AppMethodBeat.o(246626);
  }
  
  public static void b(String paramString, m<? super Boolean, ? super String, ah> paramm)
  {
    AppMethodBeat.i(246630);
    s.u(paramString, "key");
    s.u(paramm, "callback");
    ((Map)mXX).put(paramString, paramm);
    AppMethodBeat.o(246630);
  }
  
  public static void bhf()
  {
    AppMethodBeat.i(246571);
    Map localMap = mXV;
    s.s(localMap, "liveMessageCallbacks");
    try
    {
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
      }
      ah localah = ah.aiuX;
    }
    finally
    {
      AppMethodBeat.o(246571);
    }
    AppMethodBeat.o(246571);
  }
  
  public static void bhg()
  {
    AppMethodBeat.i(246596);
    Iterator localIterator = ((Map)mXU).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(246596);
  }
  
  public static void bhh()
  {
    AppMethodBeat.i(246603);
    Iterator localIterator = ((Map)mXY).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(246603);
  }
  
  public static void bhi()
  {
    AppMethodBeat.i(246612);
    Iterator localIterator = ((Map)mXZ).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(246612);
  }
  
  public static void bhj()
  {
    AppMethodBeat.i(246647);
    mXV.clear();
    mXZ.clear();
    mXW.clear();
    mXX.clear();
    mXU.clear();
    mXY.clear();
    AppMethodBeat.o(246647);
  }
  
  public static void g(String paramString, a<ah> parama)
  {
    AppMethodBeat.i(246618);
    s.u(paramString, "key");
    s.u(parama, "callback");
    Map localMap = mXV;
    s.s(localMap, "liveMessageCallbacks");
    localMap.put(paramString, parama);
    AppMethodBeat.o(246618);
  }
  
  public static void h(String paramString, a<ah> parama)
  {
    AppMethodBeat.i(246622);
    s.u(paramString, "key");
    s.u(parama, "callback");
    ((Map)mXZ).put(paramString, parama);
    AppMethodBeat.o(246622);
  }
  
  public static void i(String paramString, a<ah> parama)
  {
    AppMethodBeat.i(246635);
    s.u(paramString, "key");
    s.u(parama, "callback");
    ((Map)mXU).put(paramString, parama);
    AppMethodBeat.o(246635);
  }
  
  public static void j(String paramString, a<ah> parama)
  {
    AppMethodBeat.i(246642);
    s.u(paramString, "key");
    s.u(parama, "callback");
    ((Map)mXY).put(paramString, parama);
    AppMethodBeat.o(246642);
  }
  
  public static void j(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(246586);
    s.u(paramString, "callingUser");
    Iterator localIterator = ((Map)mXX).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((m)((Map.Entry)localIterator.next()).getValue()).invoke(Boolean.valueOf(paramBoolean), paramString);
    }
    AppMethodBeat.o(246586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.model.j
 * JD-Core Version:    0.7.0.1
 */