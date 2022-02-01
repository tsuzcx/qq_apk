package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveSysMsgCallback;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "aceptLinkMicCallbacks", "Ljava/util/HashMap;", "Lkotlin/Function0;", "", "Lkotlin/collections/HashMap;", "anchorConnectionChangeCallbacks", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "available", "applyLinkMicCallbacks", "closeLinkMicCallbacks", "closeLiveCallbacks", "kickedCallbacks", "notifyAccepLinkMic", "notifyAnchorConnectionChange", "notifyApplyLinkMic", "notifyClodeLive", "notifyCloseLinkMic", "notifyKicked", "registerAcceptLinkMicCallback", "key", "callback", "registerAnchorConnectionChangeCallback", "registerApplyLinkMicCallback", "registerCloseLinkMicCallback", "registerCloseLiveCallback", "registerKickedCallback", "releaseCallback", "plugin-finder_release"})
public final class q
{
  private static final String TAG = "Finder.FinderLiveSysMsgCallback";
  private static final HashMap<String, a<x>> ujX;
  private static final HashMap<String, a<x>> ujY;
  private static final HashMap<String, a<x>> ujZ;
  private static final HashMap<String, a<x>> uka;
  private static final HashMap<String, a<x>> ukb;
  private static final HashMap<String, b<Boolean, x>> ukc;
  public static final q ukd;
  
  static
  {
    AppMethodBeat.i(246271);
    ukd = new q();
    TAG = "Finder.FinderLiveSysMsgCallback";
    ujX = new HashMap();
    ujY = new HashMap();
    ujZ = new HashMap();
    uka = new HashMap();
    ukb = new HashMap();
    ukc = new HashMap();
    AppMethodBeat.o(246271);
  }
  
  public static void dgA()
  {
    AppMethodBeat.i(246267);
    Log.i(TAG, "notify close live");
    Iterator localIterator = ((Map)uka).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(246267);
  }
  
  public static void dgB()
  {
    AppMethodBeat.i(246268);
    Log.i(TAG, "notify kicked");
    Iterator localIterator = ((Map)ukb).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(246268);
  }
  
  public static void dgC()
  {
    AppMethodBeat.i(246270);
    Log.i(TAG, "release callback");
    ujX.clear();
    ujY.clear();
    ujZ.clear();
    uka.clear();
    ukb.clear();
    ukc.clear();
    AppMethodBeat.o(246270);
  }
  
  public static void dgx()
  {
    AppMethodBeat.i(246264);
    Log.i(TAG, "notify apply link mic");
    Iterator localIterator = ((Map)ujX).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(246264);
  }
  
  public static void dgy()
  {
    AppMethodBeat.i(246265);
    Log.i(TAG, "notify accept link mic");
    Iterator localIterator = ((Map)ujY).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(246265);
  }
  
  public static void dgz()
  {
    AppMethodBeat.i(246266);
    Log.i(TAG, "notify close link mic");
    Iterator localIterator = ((Map)ujZ).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(246266);
  }
  
  public static void j(String paramString, a<x> parama)
  {
    AppMethodBeat.i(246261);
    p.h(paramString, "key");
    Log.i(TAG, "register close live callback");
    if (uka.get(paramString) == null) {
      ((Map)uka).put(paramString, parama);
    }
    AppMethodBeat.o(246261);
  }
  
  public static void k(String paramString, a<x> parama)
  {
    AppMethodBeat.i(246262);
    p.h(paramString, "key");
    Log.i(TAG, "register kicked callback");
    if (ukb.get(paramString) == null) {
      ((Map)ukb).put(paramString, parama);
    }
    AppMethodBeat.o(246262);
  }
  
  public static void k(String paramString, b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(246263);
    p.h(paramString, "key");
    Log.i(TAG, "register anchor connection change callback");
    if (ukc.get(paramString) == null) {
      ((Map)ukc).put(paramString, paramb);
    }
    AppMethodBeat.o(246263);
  }
  
  public static void no(boolean paramBoolean)
  {
    AppMethodBeat.i(246269);
    Log.i(TAG, "notify anchor connection change");
    Iterator localIterator = ((Map)ukc).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).invoke(Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(246269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.q
 * JD-Core Version:    0.7.0.1
 */