package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveSysMsgCallback;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "aceptLinkMicCallbacks", "Ljava/util/HashMap;", "Lkotlin/Function0;", "", "Lkotlin/collections/HashMap;", "anchorCallInterruptionCallbacks", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "interrupted", "anchorConnectionChangeCallbacks", "available", "applyLinkMicCallbacks", "closeLinkMicCallbacks", "closeLiveCallbacks", "kickedCallbacks", "notifyAccepLinkMic", "notifyAnchorCallInterruption", "callInterruption", "notifyAnchorConnectionChange", "notifyApplyLinkMic", "notifyClodeLive", "notifyCloseLinkMic", "notifyKicked", "registerAcceptLinkMicCallback", "key", "callback", "registerAnchorCallInterruptionCallback", "registerAnchorConnectionChangeCallback", "registerApplyLinkMicCallback", "registerCloseLinkMicCallback", "registerCloseLiveCallback", "registerKickedCallback", "releaseCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
{
  public static final al CHU;
  private static final HashMap<String, a<ah>> CHV;
  private static final HashMap<String, a<ah>> CHW;
  private static final HashMap<String, a<ah>> CHX;
  private static final HashMap<String, a<ah>> CHY;
  private static final HashMap<String, a<ah>> CHZ;
  private static final HashMap<String, b<Boolean, ah>> CIa;
  private static final HashMap<String, b<Boolean, ah>> CIb;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(359261);
    CHU = new al();
    TAG = "Finder.FinderLiveSysMsgCallback";
    CHV = new HashMap();
    CHW = new HashMap();
    CHX = new HashMap();
    CHY = new HashMap();
    CHZ = new HashMap();
    CIa = new HashMap();
    CIb = new HashMap();
    AppMethodBeat.o(359261);
  }
  
  public static void emc()
  {
    AppMethodBeat.i(359223);
    Log.i(TAG, "notify close live");
    Iterator localIterator = ((Map)CHY).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(359223);
  }
  
  public static void emd()
  {
    AppMethodBeat.i(359234);
    Log.i(TAG, "notify kicked");
    Iterator localIterator = ((Map)CHZ).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).invoke();
    }
    AppMethodBeat.o(359234);
  }
  
  public static void eme()
  {
    AppMethodBeat.i(359254);
    Log.i(TAG, "release callback");
    CHV.clear();
    CHW.clear();
    CHX.clear();
    CHY.clear();
    CHZ.clear();
    CIa.clear();
    CIb.clear();
    AppMethodBeat.o(359254);
  }
  
  public static void o(String paramString, b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(359210);
    s.u(paramString, "key");
    Log.i(TAG, "register anchor connection change callback");
    if (CIa.get(paramString) == null) {
      ((Map)CIa).put(paramString, paramb);
    }
    AppMethodBeat.o(359210);
  }
  
  public static void p(String paramString, b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(359216);
    s.u(paramString, "key");
    Log.i(TAG, "register anchor connection change callback");
    if (CIb.get(paramString) == null) {
      ((Map)CIb).put(paramString, paramb);
    }
    AppMethodBeat.o(359216);
  }
  
  public static void q(String paramString, a<ah> parama)
  {
    AppMethodBeat.i(359196);
    s.u(paramString, "key");
    Log.i(TAG, "register close live callback");
    if (CHY.get(paramString) == null) {
      ((Map)CHY).put(paramString, parama);
    }
    AppMethodBeat.o(359196);
  }
  
  public static void qH(boolean paramBoolean)
  {
    AppMethodBeat.i(359238);
    Log.i(TAG, "notify anchor connection change");
    Iterator localIterator = ((Map)CIa).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).invoke(Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(359238);
  }
  
  public static void qI(boolean paramBoolean)
  {
    AppMethodBeat.i(359248);
    Log.i(TAG, s.X("notify anchor call interruption change: ", Boolean.valueOf(paramBoolean)));
    Iterator localIterator = ((Map)CIb).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).invoke(Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(359248);
  }
  
  public static void r(String paramString, a<ah> parama)
  {
    AppMethodBeat.i(359201);
    s.u(paramString, "key");
    Log.i(TAG, "register kicked callback");
    if (CHZ.get(paramString) == null) {
      ((Map)CHZ).put(paramString, parama);
    }
    AppMethodBeat.o(359201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.al
 * JD-Core Version:    0.7.0.1
 */