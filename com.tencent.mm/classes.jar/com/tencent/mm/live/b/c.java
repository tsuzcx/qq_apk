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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveCallbacks;", "", "()V", "liveBanCommentCallbacks", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sysTip", "", "Lkotlin/collections/HashMap;", "liveKickedCallbacks", "Lkotlin/Function0;", "liveMessageCallbacks", "liveOnlineCntChangeCallbacks", "livelinkMicCallbacks", "Lkotlin/Function2;", "", "linked", "callingUser", "callbackBanComment", "callbackKicked", "callbackLinkMic", "callbackLiveMessage", "callbackOnlineCntChanged", "registerLiveBanCommentCallback", "key", "callback", "registerLiveKickedCallback", "registerLiveLinkMicCallback", "registerLiveMessageCallback", "registerOnlineCntChangedCallback", "releaseCallbacks", "plugin-logic_release"})
public final class c
{
  private static final HashMap<String, a<z>> gMJ;
  private static final HashMap<String, a<z>> gMK;
  private static final HashMap<String, b<String, z>> gML;
  private static final HashMap<String, m<Boolean, String, z>> gMM;
  private static final HashMap<String, a<z>> gMN;
  public static final c gMO;
  
  static
  {
    AppMethodBeat.i(212035);
    gMO = new c();
    gMJ = new HashMap();
    gMK = new HashMap();
    gML = new HashMap();
    gMM = new HashMap();
    gMN = new HashMap();
    AppMethodBeat.o(212035);
  }
  
  public static void a(String paramString, b<? super String, z> paramb)
  {
    AppMethodBeat.i(212030);
    p.h(paramString, "key");
    p.h(paramb, "callback");
    ((Map)gML).put(paramString, paramb);
    AppMethodBeat.o(212030);
  }
  
  public static void a(String paramString, m<? super Boolean, ? super String, z> paramm)
  {
    AppMethodBeat.i(212031);
    p.h(paramString, "key");
    p.h(paramm, "callback");
    ((Map)gMM).put(paramString, paramm);
    AppMethodBeat.o(212031);
  }
  
  public static void amO()
  {
    AppMethodBeat.i(212024);
    Iterator localIterator = ((Map)gMK).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(212024);
  }
  
  public static void amP()
  {
    AppMethodBeat.i(212027);
    Iterator localIterator = ((Map)gMJ).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(212027);
  }
  
  public static void amQ()
  {
    AppMethodBeat.i(212028);
    Iterator localIterator = ((Map)gMN).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(212028);
  }
  
  public static void amR()
  {
    AppMethodBeat.i(212034);
    gMK.clear();
    gML.clear();
    gMM.clear();
    gMJ.clear();
    gMN.clear();
    AppMethodBeat.o(212034);
  }
  
  public static void d(String paramString, a<z> parama)
  {
    AppMethodBeat.i(212029);
    p.h(paramString, "key");
    p.h(parama, "callback");
    ((Map)gMK).put(paramString, parama);
    AppMethodBeat.o(212029);
  }
  
  public static void e(String paramString, a<z> parama)
  {
    AppMethodBeat.i(212032);
    p.h(paramString, "key");
    p.h(parama, "callback");
    ((Map)gMJ).put(paramString, parama);
    AppMethodBeat.o(212032);
  }
  
  public static void f(String paramString, a<z> parama)
  {
    AppMethodBeat.i(212033);
    p.h(paramString, "key");
    p.h(parama, "callback");
    ((Map)gMN).put(paramString, parama);
    AppMethodBeat.o(212033);
  }
  
  public static void g(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(212026);
    p.h(paramString, "callingUser");
    Iterator localIterator = ((Map)gMM).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((m)((Map.Entry)localIterator.next()).getValue()).p(Boolean.valueOf(paramBoolean), paramString);
    }
    AppMethodBeat.o(212026);
  }
  
  public static void xD(String paramString)
  {
    AppMethodBeat.i(212025);
    p.h(paramString, "sysTip");
    Iterator localIterator = ((Map)gML).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).invoke(paramString);
    }
    AppMethodBeat.o(212025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.c
 * JD-Core Version:    0.7.0.1
 */