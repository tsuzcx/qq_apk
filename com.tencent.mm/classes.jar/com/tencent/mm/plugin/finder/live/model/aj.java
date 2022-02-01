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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveSysMsgCallback;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "aceptLinkMicCallbacks", "Ljava/util/HashMap;", "Lkotlin/Function0;", "", "Lkotlin/collections/HashMap;", "anchorCallInterruptionCallbacks", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "interrupted", "anchorConnectionChangeCallbacks", "available", "applyLinkMicCallbacks", "closeLinkMicCallbacks", "closeLiveCallbacks", "kickedCallbacks", "notifyAccepLinkMic", "notifyAnchorCallInterruption", "callInterruption", "notifyAnchorConnectionChange", "notifyApplyLinkMic", "notifyClodeLive", "notifyCloseLinkMic", "notifyKicked", "registerAcceptLinkMicCallback", "key", "callback", "registerAnchorCallInterruptionCallback", "registerAnchorConnectionChangeCallback", "registerApplyLinkMicCallback", "registerCloseLinkMicCallback", "registerCloseLiveCallback", "registerKickedCallback", "releaseCallback", "plugin-finder_release"})
public final class aj
{
  private static final String TAG = "Finder.FinderLiveSysMsgCallback";
  private static final HashMap<String, a<x>> yhY;
  private static final HashMap<String, a<x>> yhZ;
  private static final HashMap<String, a<x>> yia;
  private static final HashMap<String, a<x>> yib;
  private static final HashMap<String, a<x>> yic;
  private static final HashMap<String, b<Boolean, x>> yid;
  private static final HashMap<String, b<Boolean, x>> yie;
  public static final aj yif;
  
  static
  {
    AppMethodBeat.i(290420);
    yif = new aj();
    TAG = "Finder.FinderLiveSysMsgCallback";
    yhY = new HashMap();
    yhZ = new HashMap();
    yia = new HashMap();
    yib = new HashMap();
    yic = new HashMap();
    yid = new HashMap();
    yie = new HashMap();
    AppMethodBeat.o(290420);
  }
  
  public static void dzP()
  {
    AppMethodBeat.i(290415);
    Log.i(TAG, "notify close live");
    Iterator localIterator = ((Map)yib).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(290415);
  }
  
  public static void dzQ()
  {
    AppMethodBeat.i(290416);
    Log.i(TAG, "notify kicked");
    Iterator localIterator = ((Map)yic).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(290416);
  }
  
  public static void dzR()
  {
    AppMethodBeat.i(290419);
    Log.i(TAG, "release callback");
    yhY.clear();
    yhZ.clear();
    yia.clear();
    yib.clear();
    yic.clear();
    yid.clear();
    yie.clear();
    AppMethodBeat.o(290419);
  }
  
  public static void j(String paramString, a<x> parama)
  {
    AppMethodBeat.i(290411);
    p.k(paramString, "key");
    Log.i(TAG, "register close live callback");
    if (yib.get(paramString) == null) {
      ((Map)yib).put(paramString, parama);
    }
    AppMethodBeat.o(290411);
  }
  
  public static void k(String paramString, a<x> parama)
  {
    AppMethodBeat.i(290412);
    p.k(paramString, "key");
    Log.i(TAG, "register kicked callback");
    if (yic.get(paramString) == null) {
      ((Map)yic).put(paramString, parama);
    }
    AppMethodBeat.o(290412);
  }
  
  public static void k(String paramString, b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(290413);
    p.k(paramString, "key");
    Log.i(TAG, "register anchor connection change callback");
    if (yid.get(paramString) == null) {
      ((Map)yid).put(paramString, paramb);
    }
    AppMethodBeat.o(290413);
  }
  
  public static void l(String paramString, b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(290414);
    p.k(paramString, "key");
    Log.i(TAG, "register anchor connection change callback");
    if (yie.get(paramString) == null) {
      ((Map)yie).put(paramString, paramb);
    }
    AppMethodBeat.o(290414);
  }
  
  public static void oQ(boolean paramBoolean)
  {
    AppMethodBeat.i(290417);
    Log.i(TAG, "notify anchor connection change");
    Iterator localIterator = ((Map)yid).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).invoke(Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(290417);
  }
  
  public static void oR(boolean paramBoolean)
  {
    AppMethodBeat.i(290418);
    Log.i(TAG, "notify anchor call interruption change: ".concat(String.valueOf(paramBoolean)));
    Iterator localIterator = ((Map)yie).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).invoke(Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(290418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.aj
 * JD-Core Version:    0.7.0.1
 */