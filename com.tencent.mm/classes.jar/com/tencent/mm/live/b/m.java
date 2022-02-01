package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveCallbacks;", "", "()V", "liveBanCommentCallbacks", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sysTip", "", "Lkotlin/collections/HashMap;", "liveKickedCallbacks", "Lkotlin/Function0;", "liveMessageCallbacks", "liveOnlineCntChangeCallbacks", "livelinkMicCallbacks", "Lkotlin/Function2;", "", "linked", "callingUser", "callbackBanComment", "callbackKicked", "callbackLinkMic", "callbackLiveMessage", "callbackOnlineCntChanged", "registerLiveBanCommentCallback", "key", "callback", "registerLiveKickedCallback", "registerLiveLinkMicCallback", "registerLiveMessageCallback", "registerOnlineCntChangedCallback", "releaseCallbacks", "plugin-logic_release"})
public final class m
{
  private static final HashMap<String, a<x>> hGb;
  private static final HashMap<String, a<x>> hGc;
  private static final HashMap<String, b<String, x>> hGd;
  private static final HashMap<String, kotlin.g.a.m<Boolean, String, x>> hGe;
  private static final HashMap<String, a<x>> hGf;
  public static final m hGg;
  
  static
  {
    AppMethodBeat.i(207591);
    hGg = new m();
    hGb = new HashMap();
    hGc = new HashMap();
    hGd = new HashMap();
    hGe = new HashMap();
    hGf = new HashMap();
    AppMethodBeat.o(207591);
  }
  
  public static void GL(String paramString)
  {
    AppMethodBeat.i(207581);
    p.h(paramString, "sysTip");
    Iterator localIterator = ((Map)hGd).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).invoke(paramString);
    }
    AppMethodBeat.o(207581);
  }
  
  public static void a(String paramString, b<? super String, x> paramb)
  {
    AppMethodBeat.i(207586);
    p.h(paramString, "key");
    p.h(paramb, "callback");
    ((Map)hGd).put(paramString, paramb);
    AppMethodBeat.o(207586);
  }
  
  public static void a(String paramString, kotlin.g.a.m<? super Boolean, ? super String, x> paramm)
  {
    AppMethodBeat.i(207587);
    p.h(paramString, "key");
    p.h(paramm, "callback");
    ((Map)hGe).put(paramString, paramm);
    AppMethodBeat.o(207587);
  }
  
  public static void aFe()
  {
    AppMethodBeat.i(207580);
    Iterator localIterator = ((Map)hGc).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(207580);
  }
  
  public static void aFf()
  {
    AppMethodBeat.i(207583);
    Iterator localIterator = ((Map)hGb).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(207583);
  }
  
  public static void aFg()
  {
    AppMethodBeat.i(207584);
    Iterator localIterator = ((Map)hGf).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(207584);
  }
  
  public static void aFh()
  {
    AppMethodBeat.i(207590);
    hGc.clear();
    hGd.clear();
    hGe.clear();
    hGb.clear();
    hGf.clear();
    AppMethodBeat.o(207590);
  }
  
  public static void d(String paramString, a<x> parama)
  {
    AppMethodBeat.i(207585);
    p.h(paramString, "key");
    p.h(parama, "callback");
    ((Map)hGc).put(paramString, parama);
    AppMethodBeat.o(207585);
  }
  
  public static void e(String paramString, a<x> parama)
  {
    AppMethodBeat.i(207588);
    p.h(paramString, "key");
    p.h(parama, "callback");
    ((Map)hGb).put(paramString, parama);
    AppMethodBeat.o(207588);
  }
  
  public static void f(String paramString, a<x> parama)
  {
    AppMethodBeat.i(207589);
    p.h(paramString, "key");
    p.h(parama, "callback");
    ((Map)hGf).put(paramString, parama);
    AppMethodBeat.o(207589);
  }
  
  public static void h(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(207582);
    p.h(paramString, "callingUser");
    Iterator localIterator = ((Map)hGe).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((kotlin.g.a.m)((Map.Entry)localIterator.next()).getValue()).invoke(Boolean.valueOf(paramBoolean), paramString);
    }
    AppMethodBeat.o(207582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.m
 * JD-Core Version:    0.7.0.1
 */