package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveCallbacks;", "", "()V", "liveBanCommentCallbacks", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sysTip", "", "Lkotlin/collections/HashMap;", "liveKickedCallbacks", "Lkotlin/Function0;", "liveMessageCallbacks", "liveOnlineCntChangeCallbacks", "livelinkMicCallbacks", "Lkotlin/Function2;", "", "linked", "callingUser", "callbackBanComment", "callbackKicked", "callbackLinkMic", "callbackLiveMessage", "callbackOnlineCntChanged", "registerLiveBanCommentCallback", "key", "callback", "registerLiveKickedCallback", "registerLiveLinkMicCallback", "registerLiveMessageCallback", "registerOnlineCntChangedCallback", "releaseCallbacks", "plugin-logic_release"})
public final class c
{
  private static final HashMap<String, a<z>> gPs;
  private static final HashMap<String, a<z>> gPt;
  private static final HashMap<String, b<String, z>> gPu;
  private static final HashMap<String, m<Boolean, String, z>> gPv;
  private static final HashMap<String, a<z>> gPw;
  public static final c gPx;
  
  static
  {
    AppMethodBeat.i(215654);
    gPx = new c();
    gPs = new HashMap();
    gPt = new HashMap();
    gPu = new HashMap();
    gPv = new HashMap();
    gPw = new HashMap();
    AppMethodBeat.o(215654);
  }
  
  public static void a(String paramString, b<? super String, z> paramb)
  {
    AppMethodBeat.i(215649);
    p.h(paramString, "key");
    p.h(paramb, "callback");
    ((Map)gPu).put(paramString, paramb);
    AppMethodBeat.o(215649);
  }
  
  public static void a(String paramString, m<? super Boolean, ? super String, z> paramm)
  {
    AppMethodBeat.i(215650);
    p.h(paramString, "key");
    p.h(paramm, "callback");
    ((Map)gPv).put(paramString, paramm);
    AppMethodBeat.o(215650);
  }
  
  public static void and()
  {
    AppMethodBeat.i(215643);
    Iterator localIterator = ((Map)gPt).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(215643);
  }
  
  public static void ane()
  {
    AppMethodBeat.i(215646);
    Iterator localIterator = ((Map)gPs).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(215646);
  }
  
  public static void anf()
  {
    AppMethodBeat.i(215647);
    Iterator localIterator = ((Map)gPw).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(215647);
  }
  
  public static void ang()
  {
    AppMethodBeat.i(215653);
    gPt.clear();
    gPu.clear();
    gPv.clear();
    gPs.clear();
    gPw.clear();
    AppMethodBeat.o(215653);
  }
  
  public static void d(String paramString, a<z> parama)
  {
    AppMethodBeat.i(215648);
    p.h(paramString, "key");
    p.h(parama, "callback");
    ((Map)gPt).put(paramString, parama);
    AppMethodBeat.o(215648);
  }
  
  public static void e(String paramString, a<z> parama)
  {
    AppMethodBeat.i(215651);
    p.h(paramString, "key");
    p.h(parama, "callback");
    ((Map)gPs).put(paramString, parama);
    AppMethodBeat.o(215651);
  }
  
  public static void f(String paramString, a<z> parama)
  {
    AppMethodBeat.i(215652);
    p.h(paramString, "key");
    p.h(parama, "callback");
    ((Map)gPw).put(paramString, parama);
    AppMethodBeat.o(215652);
  }
  
  public static void g(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(215645);
    p.h(paramString, "callingUser");
    Iterator localIterator = ((Map)gPv).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((m)((Map.Entry)localIterator.next()).getValue()).p(Boolean.valueOf(paramBoolean), paramString);
    }
    AppMethodBeat.o(215645);
  }
  
  public static void ym(String paramString)
  {
    AppMethodBeat.i(215644);
    p.h(paramString, "sysTip");
    Iterator localIterator = ((Map)gPu).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).invoke(paramString);
    }
    AppMethodBeat.o(215644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.c
 * JD-Core Version:    0.7.0.1
 */