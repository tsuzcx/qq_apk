package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveCallbacks;", "", "()V", "liveBanCommentCallbacks", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sysTip", "", "Lkotlin/collections/HashMap;", "liveKickedCallbacks", "Lkotlin/Function0;", "liveMessageCallbacks", "liveOnlineCntChangeCallbacks", "livelinkMicCallbacks", "Lkotlin/Function2;", "", "linked", "callingUser", "callbackBanComment", "callbackKicked", "callbackLinkMic", "callbackLiveMessage", "callbackOnlineCntChanged", "registerLiveBanCommentCallback", "key", "callback", "registerLiveKickedCallback", "registerLiveLinkMicCallback", "registerLiveMessageCallback", "registerOnlineCntChangedCallback", "releaseCallbacks", "plugin-logic_release"})
public final class c
{
  private static final HashMap<String, a<y>> gsY;
  private static final HashMap<String, a<y>> gsZ;
  private static final HashMap<String, b<String, y>> gta;
  private static final HashMap<String, m<Boolean, String, y>> gtb;
  private static final HashMap<String, a<y>> gtc;
  public static final c gtd;
  
  static
  {
    AppMethodBeat.i(189749);
    gtd = new c();
    gsY = new HashMap();
    gsZ = new HashMap();
    gta = new HashMap();
    gtb = new HashMap();
    gtc = new HashMap();
    AppMethodBeat.o(189749);
  }
  
  public static void a(String paramString, b<? super String, y> paramb)
  {
    AppMethodBeat.i(189744);
    k.h(paramString, "key");
    k.h(paramb, "callback");
    ((Map)gta).put(paramString, paramb);
    AppMethodBeat.o(189744);
  }
  
  public static void a(String paramString, m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(189745);
    k.h(paramString, "key");
    k.h(paramm, "callback");
    ((Map)gtb).put(paramString, paramm);
    AppMethodBeat.o(189745);
  }
  
  public static void akc()
  {
    AppMethodBeat.i(189738);
    Iterator localIterator = ((Map)gsZ).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(189738);
  }
  
  public static void akd()
  {
    AppMethodBeat.i(189741);
    Iterator localIterator = ((Map)gsY).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(189741);
  }
  
  public static void ake()
  {
    AppMethodBeat.i(189742);
    Iterator localIterator = ((Map)gtc).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(189742);
  }
  
  public static void akf()
  {
    AppMethodBeat.i(189748);
    gsZ.clear();
    gta.clear();
    gtb.clear();
    gsY.clear();
    gtc.clear();
    AppMethodBeat.o(189748);
  }
  
  public static void d(String paramString, a<y> parama)
  {
    AppMethodBeat.i(189743);
    k.h(paramString, "key");
    k.h(parama, "callback");
    ((Map)gsZ).put(paramString, parama);
    AppMethodBeat.o(189743);
  }
  
  public static void e(String paramString, a<y> parama)
  {
    AppMethodBeat.i(189746);
    k.h(paramString, "key");
    k.h(parama, "callback");
    ((Map)gsY).put(paramString, parama);
    AppMethodBeat.o(189746);
  }
  
  public static void f(String paramString, a<y> parama)
  {
    AppMethodBeat.i(189747);
    k.h(paramString, "key");
    k.h(parama, "callback");
    ((Map)gtc).put(paramString, parama);
    AppMethodBeat.o(189747);
  }
  
  public static void f(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(189740);
    k.h(paramString, "callingUser");
    Iterator localIterator = ((Map)gtb).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((m)((Map.Entry)localIterator.next()).getValue()).n(Boolean.valueOf(paramBoolean), paramString);
    }
    AppMethodBeat.o(189740);
  }
  
  public static void uN(String paramString)
  {
    AppMethodBeat.i(189739);
    k.h(paramString, "sysTip");
    Iterator localIterator = ((Map)gta).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).ay(paramString);
    }
    AppMethodBeat.o(189739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.c
 * JD-Core Version:    0.7.0.1
 */