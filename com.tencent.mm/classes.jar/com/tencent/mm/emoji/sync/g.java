package com.tencent.mm.emoji.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader;", "Lcom/tencent/mm/emoji/sync/IEmojiSyncLoader;", "data", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IDataProvider;", "config", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IConfigProvider;", "(Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IDataProvider;Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IConfigProvider;)V", "TAG", "", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncLoader$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$downloadCallback$1;", "downloadList", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue;", "isLoadEnd", "", "isLoading", "startNonWifi", "syncCount", "", "targetSyncCount", "totalCount", "waitNotifyCount", "waitingIndex", "checkStart", "checkSyncEmoji", "", "start", "destroy", "getSyncCount", "getTargetSyncCount", "getWaitingIndex", "hasMore", "init", "loadMore", "matchDisplayIndex", "index", "registerCallback", "callback", "startInternal", "stop", "unregisterCallback", "CaptureEmojiDataProvider", "Companion", "ConfigProvider", "CustomEmojiDataProvider", "IConfigProvider", "IDataProvider", "LoadCallback", "plugin-emojisdk_release"})
public final class g
  implements j
{
  private static j jOo;
  private static j jOp;
  private static final i jOq;
  private static final i jOr;
  public static final b jOs;
  private String TAG;
  private boolean isLoading;
  private int jOd;
  private int jOe;
  private int jOf;
  private boolean jOg;
  private final List<String> jOh;
  private final LinkedList<i> jOi;
  private final i jOj;
  private int jOk;
  private final k jOl;
  private final h jOm;
  private final g jOn;
  private int jlf;
  
  static
  {
    AppMethodBeat.i(224300);
    jOs = new b((byte)0);
    jOq = (i)new d();
    jOr = (i)new c();
    AppMethodBeat.o(224300);
  }
  
  private g(h paramh, g paramg)
  {
    AppMethodBeat.i(224296);
    this.jOm = paramh;
    this.jOn = paramg;
    this.TAG = "MicroMsg.EmojiSyncLoader";
    this.jOe = -1;
    this.jOh = Collections.synchronizedList((List)new LinkedList());
    this.jOi = new LinkedList();
    this.jOj = new i();
    this.jOl = new k(this);
    AppMethodBeat.o(224296);
  }
  
  private final boolean aDm()
  {
    if (this.jOg) {
      this.isLoading = false;
    }
    while (this.isLoading) {
      return false;
    }
    return true;
  }
  
  public static final j aDr()
  {
    AppMethodBeat.i(224328);
    j localj = b.aDr();
    AppMethodBeat.o(224328);
    return localj;
  }
  
  public static final j aDs()
  {
    AppMethodBeat.i(224332);
    j localj = b.aDs();
    AppMethodBeat.o(224332);
    return localj;
  }
  
  private final void startInternal()
  {
    AppMethodBeat.i(224291);
    Object localObject1 = this.jOm.aDt();
    this.jlf = ((List)localObject1).size();
    this.jOf = Math.min(this.jOf, ((List)localObject1).size());
    if (this.jOd > this.jOf) {
      this.jOd = this.jOf;
    }
    if (this.jOf > this.jOd) {
      this.isLoading = true;
    }
    if ((!this.isLoading) && (this.jOf == this.jlf)) {
      this.jOg = true;
    }
    this.jOe = this.jOd;
    Log.i(this.TAG, "startInternal: " + this.jOd + ", " + this.jOf + ", " + this.jlf + ", " + this.jOe + ", " + this.isLoading + ", " + this.jOg);
    i locali = this.jOj;
    Object localObject2 = (Iterable)((List)localObject1).subList(this.jOd, this.jOf);
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    int i = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject3 = (EmojiInfo)localObject3;
      this.jOh.add(((EmojiInfo)localObject3).getMd5());
      ((Collection)localObject1).add(new i.a((EmojiInfo)localObject3, i + this.jOd));
      i += 1;
    }
    locali.ab((List)localObject1);
    AppMethodBeat.o(224291);
  }
  
  public final void a(final i parami)
  {
    AppMethodBeat.i(224263);
    p.k(parami, "callback");
    d.uiThread((a)new l(this, parami));
    AppMethodBeat.o(224263);
  }
  
  public final void aDi()
  {
    AppMethodBeat.i(224275);
    Log.i(this.TAG, "loadMore: " + this.isLoading + ", " + this.jOg);
    if (aDm())
    {
      this.jOf = this.jOn.rO(this.jOf);
      startInternal();
    }
    AppMethodBeat.o(224275);
  }
  
  public final int aDj()
  {
    if (this.jOg) {
      return 2147483647;
    }
    return this.jOe;
  }
  
  public final int aDk()
  {
    if (this.jOg) {
      return 2147483647;
    }
    return this.jOf;
  }
  
  public final boolean aDl()
  {
    return !this.jOg;
  }
  
  public final void b(final i parami)
  {
    AppMethodBeat.i(224266);
    p.k(parami, "callback");
    d.uiThread((a)new m(this, parami));
    AppMethodBeat.o(224266);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(224261);
    Object localObject = this.jOj;
    ((i)localObject).jOK.clear();
    localObject = ((Map)((i)localObject).jOL).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    this.jOj.jOM = null;
    AppMethodBeat.o(224261);
  }
  
  public final void eD(final boolean paramBoolean)
  {
    AppMethodBeat.i(224281);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(224281);
      return;
    }
    d.b("EmojiSyncLoader_checkSyncEmoji", (a)new j(this, paramBoolean));
    AppMethodBeat.o(224281);
  }
  
  public final void init()
  {
    AppMethodBeat.i(224256);
    this.jOj.jOM = ((i.b)this.jOl);
    this.jOf = this.jOn.aDu();
    eD(false);
    AppMethodBeat.o(224256);
  }
  
  public final void start()
  {
    AppMethodBeat.i(224269);
    Log.i(this.TAG, "start: ");
    if (aDm()) {
      startInternal();
    }
    AppMethodBeat.o(224269);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$CaptureEmojiDataProvider;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IDataProvider;", "()V", "getEmojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"})
  static final class a
    implements g.h
  {
    public final List<EmojiInfo> aDt()
    {
      AppMethodBeat.i(233280);
      Object localObject = k.aBH().es(false);
      p.j(localObject, "EmojiStorageCache.getIns…().getCaptureEmoji(false)");
      localObject = (List)localObject;
      AppMethodBeat.o(233280);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$Companion;", "", "()V", "captureLoader", "Lcom/tencent/mm/emoji/sync/IEmojiSyncLoader;", "captureRemoteCallback", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "customLoader", "customRemoteCallback", "getCaptureLoader", "getCustomLoader", "getRemoteData", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData;", "type", "", "updateRemoteData", "", "data", "plugin-emojisdk_release"})
  public static final class b
  {
    public static j aDr()
    {
      AppMethodBeat.i(231724);
      Object localObject = g.aDo();
      if (localObject != null)
      {
        AppMethodBeat.o(231724);
        return localObject;
      }
      if (MMApplicationContext.isMainProcess())
      {
        localObject = new g((g.h)new g.f(), (g.g)new g.e(), (byte)0);
        String str = g.k((g)localObject);
        g.a((g)localObject, str + "_custom");
        g.b((j)localObject);
        ((g)localObject).a(g.aDp());
        localObject = (j)localObject;
        AppMethodBeat.o(231724);
        return localObject;
      }
      localObject = new EmojiSyncLoaderIPC(0);
      g.b((j)localObject);
      localObject = (j)localObject;
      AppMethodBeat.o(231724);
      return localObject;
    }
    
    public static j aDs()
    {
      AppMethodBeat.i(231725);
      Object localObject = g.aDn();
      if (localObject != null)
      {
        AppMethodBeat.o(231725);
        return localObject;
      }
      if (MMApplicationContext.isMainProcess())
      {
        localObject = new g((g.h)new g.a(), (g.g)new g.e(), (byte)0);
        String str = g.k((g)localObject);
        g.a((g)localObject, str + "_capture");
        g.a((j)localObject);
        ((g)localObject).a(g.aDq());
        localObject = (j)localObject;
        AppMethodBeat.o(231725);
        return localObject;
      }
      localObject = new EmojiSyncLoaderIPC(1);
      g.a((j)localObject);
      localObject = (j)localObject;
      AppMethodBeat.o(231725);
      return localObject;
    }
    
    public static EmojiSyncLoaderIPC.EmojiSyncData rN(int paramInt)
    {
      j localj = null;
      Object localObject = null;
      AppMethodBeat.i(231722);
      EmojiSyncLoaderIPC.EmojiSyncData localEmojiSyncData = new EmojiSyncLoaderIPC.EmojiSyncData();
      localEmojiSyncData.jJL = paramInt;
      if (paramInt == 1)
      {
        localj = g.aDn();
        if ((localj instanceof g)) {
          break label110;
        }
      }
      for (;;)
      {
        localObject = (g)localObject;
        if (localObject != null)
        {
          localEmojiSyncData.jOd = g.f((g)localObject);
          localEmojiSyncData.jOf = g.h((g)localObject);
          localEmojiSyncData.jOe = g.i((g)localObject);
          localEmojiSyncData.jOg = g.j((g)localObject);
        }
        AppMethodBeat.o(231722);
        return localEmojiSyncData;
        localObject = g.aDo();
        if (!(localObject instanceof g)) {
          localObject = localj;
        }
        for (;;)
        {
          localObject = (g)localObject;
          break;
        }
        label110:
        localObject = localj;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/sync/EmojiSyncLoader$Companion$captureRemoteCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "onLoadMore", "", "increase", "", "plugin-emojisdk_release"})
  public static final class c
    implements g.i
  {
    public final void aCN()
    {
      AppMethodBeat.i(225590);
      Object localObject = g.jOs;
      localObject = g.b.rN(1);
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.KEY_TYPE, EmojiUpdateReceiver.jPa);
      localIntent.putExtra("data", (Parcelable)localObject);
      MMApplicationContext.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(225590);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/sync/EmojiSyncLoader$Companion$customRemoteCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "onLoadMore", "", "increase", "", "plugin-emojisdk_release"})
  public static final class d
    implements g.i
  {
    public final void aCN()
    {
      AppMethodBeat.i(237884);
      Object localObject = g.jOs;
      localObject = g.b.rN(0);
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.KEY_TYPE, EmojiUpdateReceiver.jPa);
      localIntent.putExtra("data", (Parcelable)localObject);
      MMApplicationContext.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(237884);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$ConfigProvider;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IConfigProvider;", "()V", "getSyncMinCount", "", "getSyncNotifyCount", "nextSyncCount", "current", "plugin-emojisdk_release"})
  static final class e
    implements g.g
  {
    public final int aDu()
    {
      AppMethodBeat.i(236738);
      int i = ((b)h.ae(b.class)).a(b.a.vDl, 300);
      AppMethodBeat.o(236738);
      return i;
    }
    
    public final int rO(int paramInt)
    {
      AppMethodBeat.i(236743);
      int i = ((b)h.ae(b.class)).a(b.a.vDm, 120);
      AppMethodBeat.o(236743);
      return i + paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$CustomEmojiDataProvider;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IDataProvider;", "()V", "getEmojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"})
  static final class f
    implements g.h
  {
    public final List<EmojiInfo> aDt()
    {
      AppMethodBeat.i(223971);
      Object localObject = k.aBH();
      p.j(localObject, "EmojiStorageCache.getInstance()");
      localObject = ((k)localObject).aBK();
      if (localObject != null)
      {
        localObject = (List)localObject;
        AppMethodBeat.o(223971);
        return localObject;
      }
      localObject = (List)new ArrayList();
      AppMethodBeat.o(223971);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IConfigProvider;", "", "getSyncMinCount", "", "getSyncNotifyCount", "nextSyncCount", "current", "plugin-emojisdk_release"})
  static abstract interface g
  {
    public abstract int aDu();
    
    public abstract int rO(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IDataProvider;", "", "getEmojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"})
  static abstract interface h
  {
    public abstract List<EmojiInfo> aDt();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "", "onLoadMore", "", "increase", "", "plugin-emojisdk_release"})
  public static abstract interface i
  {
    public abstract void aCN();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements a<x>
  {
    j(g paramg, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/sync/EmojiSyncLoader$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$SyncQueueCallback;", "onState", "", "state", "", "emojiData", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$EmojiSyncData;", "plugin-emojisdk_release"})
  public static final class k
    implements i.b
  {
    public final void a(int paramInt, i.a parama)
    {
      AppMethodBeat.i(230957);
      p.k(parama, "emojiData");
      Object localObject = parama.jHh;
      Log.i(g.k(this.jOt), "onLoaderFin: " + ((EmojiInfo)localObject).getMd5() + ' ' + paramInt + ", " + parama.index);
      g.l(this.jOt).remove(((EmojiInfo)localObject).getMd5());
      if (g.l(this.jOt).size() <= 0) {
        g.e(this.jOt);
      }
      localObject = this.jOt;
      g.e((g)localObject, g.m((g)localObject) + 1);
      paramInt = parama.index;
      if ((g.rM(paramInt)) || (!g.d(this.jOt)))
      {
        if (g.i(this.jOt) < paramInt + 1) {
          g.d(this.jOt, paramInt + 1);
        }
        g.f(this.jOt);
        parama = this.jOt;
        g.b(parama, g.f(parama) + g.m(this.jOt));
        if ((g.f(this.jOt) == g.h(this.jOt)) && (g.h(this.jOt) == g.c(this.jOt))) {
          g.a(this.jOt, true);
        }
        if (!g.d(this.jOt)) {
          g.d(this.jOt, g.h(this.jOt));
        }
        parama = ((Iterable)g.a(this.jOt)).iterator();
        while (parama.hasNext())
        {
          localObject = (g.i)parama.next();
          g.f(this.jOt);
          ((g.i)localObject).aCN();
        }
        g.e(this.jOt, 0);
      }
      AppMethodBeat.o(230957);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements a<x>
  {
    l(g paramg, g.i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements a<x>
  {
    m(g paramg, g.i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.g
 * JD-Core Version:    0.7.0.1
 */