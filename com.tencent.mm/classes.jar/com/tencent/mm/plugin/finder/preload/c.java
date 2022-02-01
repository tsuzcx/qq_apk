package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.cgi.bd;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.ui.component.n;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/FinderSharePreloadCore;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "preloadMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "checkPlaceHolderExpire", "", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "containsShareFeedMark", "objectId", "commentScene", "", "pullScene", "expireTime", "generateKey", "getShareFeed", "isFinderToTimeline", "isFinderToTimelinePreload", "postShareFeed", "", "preloadShareFeed", "nonceId", "reportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isMegaVideo", "username", "callback", "Lcom/tencent/mm/plugin/finder/preload/FinderSharePreloadCore$PreloadCallback;", "preloadShareFeedInternal", "megaObjectId", "megaNonceId", "scene", "preloadShareFeedWithMegaVideo", "putShareFeedMark", "removeShareFeed", "removeShareFeedMark", "removeShareFeedMarkMegaVideo", "Companion", "PreloadCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends n<PluginFinder>
{
  public static final a EUt;
  private final HashMap<String, Long> EUu;
  
  static
  {
    AppMethodBeat.i(346382);
    EUt = new a((byte)0);
    AppMethodBeat.o(346382);
  }
  
  public c()
  {
    AppMethodBeat.i(346307);
    this.EUu = new HashMap();
    AppMethodBeat.o(346307);
  }
  
  private static final ah a(c paramc, long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean, int paramInt2, b paramb, b.a parama)
  {
    AppMethodBeat.i(346376);
    s.u(paramc, "this$0");
    Object localObject;
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      localObject = aw.Gjk;
      if (!aw.iv(parama.errType, parama.errCode)) {}
    }
    else
    {
      localObject = ((ayl)parama.ott).feedObject;
      if (localObject != null)
      {
        FinderContact localFinderContact = new FinderContact();
        parama = ((FinderObject)localObject).contact;
        if (parama == null)
        {
          parama = null;
          localFinderContact.username = parama;
          parama = ((FinderObject)localObject).contact;
          if (parama != null) {
            break label249;
          }
          parama = null;
          label112:
          localFinderContact.nickname = parama;
          parama = ((FinderObject)localObject).contact;
          if (parama != null) {
            break label259;
          }
          parama = null;
          label134:
          localFinderContact.headUrl = parama;
          parama = ((FinderObject)localObject).contact;
          if (parama != null) {
            break label269;
          }
          parama = null;
          label156:
          localFinderContact.authInfo = parama;
          parama = ((FinderObject)localObject).contact;
          if (parama != null) {
            break label279;
          }
        }
        label259:
        label269:
        label279:
        for (parama = null;; parama = parama.extInfo)
        {
          localFinderContact.extInfo = parama;
          parama = com.tencent.mm.plugin.finder.api.d.AwY;
          d.a.e(localFinderContact);
          parama = FinderItem.Companion;
          parama = FinderItem.a.e((FinderObject)localObject, 1);
          a(paramLong1, parama);
          paramc.a(paramLong1, paramInt1, paramLong2, paramBoolean, paramInt2);
          if (paramb != null) {
            break label289;
          }
          AppMethodBeat.o(346376);
          return null;
          parama = parama.username;
          break;
          label249:
          parama = parama.nickname;
          break label112;
          parama = parama.headUrl;
          break label134;
          parama = parama.authInfo;
          break label156;
        }
        label289:
        paramb.c(parama);
        paramc = ah.aiuX;
        AppMethodBeat.o(346376);
        return paramc;
      }
      paramc.a(paramLong1, paramInt1, paramLong2, paramBoolean, paramInt2);
      pp(paramLong1);
      if (paramb == null)
      {
        AppMethodBeat.o(346376);
        return null;
      }
      paramb.c(null);
      paramc = ah.aiuX;
      AppMethodBeat.o(346376);
      return paramc;
    }
    paramc.a(paramLong1, paramInt1, paramLong2, paramBoolean, paramInt2);
    pp(paramLong1);
    if (paramb == null)
    {
      AppMethodBeat.o(346376);
      return null;
    }
    paramb.c(null);
    paramc = ah.aiuX;
    AppMethodBeat.o(346376);
    return paramc;
  }
  
  private static final ah a(c paramc, long paramLong, String paramString, int paramInt1, boolean paramBoolean, bui parambui, b paramb, int paramInt2, b.a parama)
  {
    AppMethodBeat.i(346368);
    s.u(paramc, "this$0");
    s.u(paramString, "$nonceId");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      paramString = ((dnj)parama.ott).ZXx;
      long l;
      if (paramString == null)
      {
        l = 0L;
        if (l == 0L) {
          break label209;
        }
        paramString = ((dnj)parama.ott).ZXx;
        if (paramString != null) {
          break label150;
        }
        l = 0L;
        label78:
        paramString = ((dnj)parama.ott).ZXx;
        if (paramString != null) {
          break label174;
        }
        paramString = "";
      }
      for (;;)
      {
        paramc.a(l, paramString, paramLong, paramInt1, paramBoolean, parambui, paramb, paramInt2);
        paramc = ah.aiuX;
        AppMethodBeat.o(346368);
        return paramc;
        paramString = paramString.aaUv;
        if (paramString == null)
        {
          l = 0L;
          break;
        }
        l = paramString.hKN;
        break;
        label150:
        paramString = paramString.aaUv;
        if (paramString == null)
        {
          l = 0L;
          break label78;
        }
        l = paramString.hKN;
        break label78;
        label174:
        paramString = paramString.aaUv;
        if (paramString == null)
        {
          paramString = "";
        }
        else
        {
          parama = paramString.objectNonceId;
          paramString = parama;
          if (parama == null) {
            paramString = "";
          }
        }
      }
    }
    label209:
    paramString = q(paramLong, paramInt1, paramInt2);
    if (paramc.EUu.containsKey(paramString)) {
      paramc.EUu.remove(paramString);
    }
    if (paramb == null)
    {
      AppMethodBeat.o(346368);
      return null;
    }
    paramb.c(null);
    paramc = ah.aiuX;
    AppMethodBeat.o(346368);
    return paramc;
  }
  
  public static void a(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(346338);
    if (paramFinderItem != null)
    {
      e.a locala = e.FMN;
      e.a.b(paramLong, paramFinderItem);
    }
    AppMethodBeat.o(346338);
  }
  
  private final void a(long paramLong1, String paramString, long paramLong2, int paramInt1, boolean paramBoolean, bui parambui, b paramb, int paramInt2)
  {
    AppMethodBeat.i(346329);
    new az(paramLong1, paramString, paramInt1, 2, "", true, null, null, 0L, null, false, false, "", parambui, paramInt2, null, 36800).bFJ().b(new c..ExternalSyntheticLambda0(this, paramLong1, paramInt1, paramLong2, paramBoolean, paramInt2, paramb));
    AppMethodBeat.o(346329);
  }
  
  private final void a(long paramLong, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, bui parambui, b paramb, int paramInt2)
  {
    AppMethodBeat.i(346324);
    new bd(paramLong, paramString2, paramString1, paramInt1, parambui).bFJ().b(new c..ExternalSyntheticLambda1(this, paramLong, paramString1, paramInt1, paramBoolean, parambui, paramb, paramInt2));
    AppMethodBeat.o(346324);
  }
  
  public static boolean eHG()
  {
    AppMethodBeat.i(346354);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eYu().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(346354);
      return true;
    }
    AppMethodBeat.o(346354);
    return false;
  }
  
  public static FinderItem po(long paramLong)
  {
    AppMethodBeat.i(346333);
    Object localObject = e.FMN;
    localObject = e.a.jn(paramLong);
    AppMethodBeat.o(346333);
    return localObject;
  }
  
  public static void pp(long paramLong)
  {
    AppMethodBeat.i(346344);
    e.a locala = e.FMN;
    e.a.ky(paramLong);
    AppMethodBeat.o(346344);
  }
  
  private static String q(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(346361);
    String str = String.valueOf(paramLong) + String.valueOf(paramInt1) + String.valueOf(paramInt2);
    s.s(str, "StringBuilder().append(o…ne.toString()).toString()");
    AppMethodBeat.o(346361);
    return str;
  }
  
  public final void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(346420);
    if (paramBoolean) {}
    for (String str = q(paramLong2, paramInt1, paramInt2);; str = q(paramLong1, paramInt1, paramInt2))
    {
      if (this.EUu.containsKey(str)) {
        this.EUu.remove(str);
      }
      AppMethodBeat.o(346420);
      return;
    }
  }
  
  public final void a(long paramLong, String paramString1, int paramInt1, bui parambui, boolean paramBoolean, String paramString2, b paramb, int paramInt2)
  {
    AppMethodBeat.i(346403);
    s.u(paramString1, "nonceId");
    if (paramBoolean)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        a(paramLong, paramString1, paramString2, paramInt1, paramBoolean, parambui, paramb, paramInt2);
        AppMethodBeat.o(346403);
        return;
      }
    }
    a(paramLong, paramString1, 0L, paramInt1, paramBoolean, parambui, paramb, paramInt2);
    AppMethodBeat.o(346403);
  }
  
  public final boolean o(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(346410);
    String str = q(paramLong, paramInt1, paramInt2);
    boolean bool = this.EUu.containsKey(str);
    if (bool)
    {
      Long localLong = (Long)this.EUu.get(str);
      if (localLong != null)
      {
        paramLong = System.currentTimeMillis();
        long l = localLong.longValue();
        if ((localLong.longValue() <= 0L) || (paramLong - l >= 300000L))
        {
          this.EUu.remove(str);
          AppMethodBeat.o(346410);
          return false;
        }
      }
    }
    AppMethodBeat.o(346410);
    return bool;
  }
  
  public final void p(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(346414);
    ((Map)this.EUu).put(q(paramLong, paramInt1, paramInt2), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(346414);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/FinderSharePreloadCore$Companion;", "", "()V", "TIME_OUT_TIME", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/FinderSharePreloadCore$PreloadCallback;", "", "loadFinish", "", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "errorCode", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void c(FinderItem paramFinderItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c
 * JD-Core Version:    0.7.0.1
 */