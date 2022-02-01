package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveCallbacks;", "", "()V", "liveBanCommentCallbacks", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "sysTip", "", "Lkotlin/collections/ArrayList;", "liveKickedCallbacks", "Lkotlin/Function0;", "liveMessageCallbacks", "livelinkMicCallbacks", "Lkotlin/Function2;", "", "linked", "callingUser", "callbackBanComment", "callbackKicked", "callbackLinkMic", "callbackLiveMessage", "registerLiveBanCommentCallback", "callback", "registerLiveKickedCallback", "registerLiveLinkMicCallback", "registerLiveMessageCallback", "releaseCallbacks", "plugin-logic_release"})
public final class c
{
  private static final ArrayList<a<y>> qYc;
  private static final ArrayList<a<y>> qYd;
  private static final ArrayList<b<String, y>> qYe;
  private static final ArrayList<m<Boolean, String, y>> qYf;
  public static final c qYi;
  
  static
  {
    AppMethodBeat.i(202575);
    qYi = new c();
    qYc = new ArrayList();
    qYd = new ArrayList();
    qYe = new ArrayList();
    qYf = new ArrayList();
    AppMethodBeat.o(202575);
  }
  
  public static void E(b<? super String, y> paramb)
  {
    AppMethodBeat.i(202571);
    k.h(paramb, "callback");
    if (!qYe.contains(paramb)) {
      qYe.add(paramb);
    }
    AppMethodBeat.o(202571);
  }
  
  public static void L(a<y> parama)
  {
    AppMethodBeat.i(202570);
    k.h(parama, "callback");
    if (!qYd.contains(parama)) {
      qYd.add(parama);
    }
    AppMethodBeat.o(202570);
  }
  
  public static void M(a<y> parama)
  {
    AppMethodBeat.i(202573);
    k.h(parama, "callback");
    if (!qYc.contains(parama)) {
      qYc.add(parama);
    }
    AppMethodBeat.o(202573);
  }
  
  public static void aUj(String paramString)
  {
    AppMethodBeat.i(202567);
    k.h(paramString, "sysTip");
    Iterator localIterator = ((Iterable)qYe).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).aA(paramString);
    }
    AppMethodBeat.o(202567);
  }
  
  public static void dRj()
  {
    AppMethodBeat.i(202566);
    Iterator localIterator = ((Iterable)qYd).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).invoke();
    }
    AppMethodBeat.o(202566);
  }
  
  public static void dRk()
  {
    AppMethodBeat.i(202569);
    Iterator localIterator = ((Iterable)qYc).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).invoke();
    }
    AppMethodBeat.o(202569);
  }
  
  public static void dRl()
  {
    AppMethodBeat.i(202574);
    qYd.clear();
    qYe.clear();
    qYf.clear();
    qYc.clear();
    AppMethodBeat.o(202574);
  }
  
  public static void g(m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(202572);
    k.h(paramm, "callback");
    if (!qYf.contains(paramm)) {
      qYf.add(paramm);
    }
    AppMethodBeat.o(202572);
  }
  
  public static void g(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(202568);
    k.h(paramString, "callingUser");
    Iterator localIterator = ((Iterable)qYf).iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).n(Boolean.valueOf(paramBoolean), paramString);
    }
    AppMethodBeat.o(202568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.c
 * JD-Core Version:    0.7.0.1
 */