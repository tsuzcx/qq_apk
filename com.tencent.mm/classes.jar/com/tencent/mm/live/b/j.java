package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveCallbacks;", "", "()V", "liveBanCommentCallbacks", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sysTip", "", "Lkotlin/collections/HashMap;", "liveKickedCallbacks", "Lkotlin/Function0;", "liveMessageCallbacks", "liveOnlineCntChangeCallbacks", "livelinkMicCallbacks", "Lkotlin/Function2;", "", "linked", "callingUser", "callbackBanComment", "callbackKicked", "callbackLinkMic", "callbackLiveMessage", "callbackOnlineCntChanged", "registerLiveBanCommentCallback", "key", "callback", "registerLiveKickedCallback", "registerLiveLinkMicCallback", "registerLiveMessageCallback", "registerOnlineCntChangedCallback", "releaseCallbacks", "plugin-logic_release"})
public final class j
{
  private static final HashMap<String, a<x>> ktZ;
  private static final HashMap<String, a<x>> kua;
  private static final HashMap<String, b<String, x>> kub;
  private static final HashMap<String, m<Boolean, String, x>> kuc;
  private static final HashMap<String, a<x>> kud;
  public static final j kue;
  
  static
  {
    AppMethodBeat.i(198695);
    kue = new j();
    ktZ = new HashMap();
    kua = new HashMap();
    kub = new HashMap();
    kuc = new HashMap();
    kud = new HashMap();
    AppMethodBeat.o(198695);
  }
  
  public static void NW(String paramString)
  {
    AppMethodBeat.i(198668);
    p.k(paramString, "sysTip");
    Iterator localIterator = ((Map)kub).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).invoke(paramString);
    }
    AppMethodBeat.o(198668);
  }
  
  public static void a(String paramString, b<? super String, x> paramb)
  {
    AppMethodBeat.i(198682);
    p.k(paramString, "key");
    p.k(paramb, "callback");
    ((Map)kub).put(paramString, paramb);
    AppMethodBeat.o(198682);
  }
  
  public static void a(String paramString, m<? super Boolean, ? super String, x> paramm)
  {
    AppMethodBeat.i(198684);
    p.k(paramString, "key");
    p.k(paramm, "callback");
    ((Map)kuc).put(paramString, paramm);
    AppMethodBeat.o(198684);
  }
  
  public static void aNv()
  {
    AppMethodBeat.i(198665);
    Iterator localIterator = ((Map)kua).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(198665);
  }
  
  public static void aNw()
  {
    AppMethodBeat.i(198673);
    Iterator localIterator = ((Map)ktZ).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(198673);
  }
  
  public static void aNx()
  {
    AppMethodBeat.i(198676);
    Iterator localIterator = ((Map)kud).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(198676);
  }
  
  public static void aNy()
  {
    AppMethodBeat.i(198691);
    kua.clear();
    kub.clear();
    kuc.clear();
    ktZ.clear();
    kud.clear();
    AppMethodBeat.o(198691);
  }
  
  public static void d(String paramString, a<x> parama)
  {
    AppMethodBeat.i(198680);
    p.k(paramString, "key");
    p.k(parama, "callback");
    ((Map)kua).put(paramString, parama);
    AppMethodBeat.o(198680);
  }
  
  public static void e(String paramString, a<x> parama)
  {
    AppMethodBeat.i(198686);
    p.k(paramString, "key");
    p.k(parama, "callback");
    ((Map)ktZ).put(paramString, parama);
    AppMethodBeat.o(198686);
  }
  
  public static void f(String paramString, a<x> parama)
  {
    AppMethodBeat.i(198690);
    p.k(paramString, "key");
    p.k(parama, "callback");
    ((Map)kud).put(paramString, parama);
    AppMethodBeat.o(198690);
  }
  
  public static void k(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(198672);
    p.k(paramString, "callingUser");
    Iterator localIterator = ((Map)kuc).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((m)((Map.Entry)localIterator.next()).getValue()).invoke(Boolean.valueOf(paramBoolean), paramString);
    }
    AppMethodBeat.o(198672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.j
 * JD-Core Version:    0.7.0.1
 */