package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.core.b.a.a;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.core.e.j;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/LiveUtil;", "", "()V", "TAG", "", "addSysMsg", "", "content", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getAliasInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "getDebugFinderLiveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "giftFuncEnableByContactFlag", "", "contactFlag", "", "giftFuncEnableBySwitchFlag", "switchFlag", "isAnchorLive", "isAnchorLiveWithoutSndDevice", "isBuyProductMicUser", "userAttrFlag", "isFollowMicUser", "isRewardMicUser", "micSettingBuyProduct", "flag", "micSettingFollow", "micSettingReward", "printVisitorRoleInfo", "prefix", "visitorRoleList", "curVisitorRoleType", "", "visitorRoleModifyTime", "plugin-finder-base_release"})
public final class r
{
  public static final r yQS;
  
  static
  {
    AppMethodBeat.i(258625);
    yQS = new r();
    AppMethodBeat.o(258625);
  }
  
  public static boolean LA(long paramLong)
  {
    AppMethodBeat.i(258616);
    int i = (int)paramLong;
    e.h localh = e.h.kkq;
    boolean bool = com.tencent.mm.ae.d.dr(i, e.h.aKw());
    AppMethodBeat.o(258616);
    return bool;
  }
  
  public static boolean LB(long paramLong)
  {
    AppMethodBeat.i(258618);
    int i = (int)paramLong;
    e.j localj = e.j.kky;
    boolean bool = com.tencent.mm.ae.d.dr(i, e.j.aKB());
    AppMethodBeat.o(258618);
    return bool;
  }
  
  public static boolean LC(long paramLong)
  {
    AppMethodBeat.i(258620);
    int i = (int)paramLong;
    e.j localj = e.j.kky;
    boolean bool = com.tencent.mm.ae.d.dr(i, e.j.aKA());
    AppMethodBeat.o(258620);
    return bool;
  }
  
  public static boolean LD(long paramLong)
  {
    AppMethodBeat.i(258621);
    int i = (int)paramLong;
    e.j localj = e.j.kky;
    boolean bool = com.tencent.mm.ae.d.dr(i, e.j.aKC());
    AppMethodBeat.o(258621);
    return bool;
  }
  
  public static boolean Lw(long paramLong)
  {
    AppMethodBeat.i(258593);
    boolean bool1 = com.tencent.mm.ae.d.dr((int)paramLong, 2);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.b)locala).ZM();
    boolean bool3 = ((com.tencent.mm.plugin.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.b.class)).bvO();
    Log.i("LiveUtil", "giftFuncEnableBySwitchFlag isTeenMode:" + bool2 + " pagEnable:" + bool3 + " enableGiftBySwitchFlag:" + bool1 + " switchFlag:" + paramLong);
    if ((bool1) && (bool3) && (!bool2))
    {
      AppMethodBeat.o(258593);
      return true;
    }
    AppMethodBeat.o(258593);
    return false;
  }
  
  public static boolean Lx(long paramLong)
  {
    AppMethodBeat.i(258596);
    boolean bool1 = com.tencent.mm.ae.d.dr((int)paramLong, 1);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.b)localObject).ZM();
    localObject = com.tencent.mm.plugin.finder.utils.ak.AGL;
    boolean bool3 = com.tencent.mm.plugin.finder.utils.ak.eeD();
    boolean bool4 = ((com.tencent.mm.plugin.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.b.class)).bvO();
    Log.i("LiveUtil", "giftFuncEnableByContactFlag isTeenMode:" + bool2 + " pagEnable:" + bool4 + " enableGiftByContactFlag:" + bool1 + " regChina:" + bool3 + " switchFlag:" + paramLong);
    if ((bool1) && (!bool2) && (bool3) && (bool4))
    {
      AppMethodBeat.o(258596);
      return true;
    }
    AppMethodBeat.o(258596);
    return false;
  }
  
  public static boolean Ly(long paramLong)
  {
    AppMethodBeat.i(258612);
    int i = (int)paramLong;
    e.h localh = e.h.kkq;
    boolean bool = com.tencent.mm.ae.d.dr(i, e.h.aKv());
    AppMethodBeat.o(258612);
    return bool;
  }
  
  public static boolean Lz(long paramLong)
  {
    AppMethodBeat.i(258614);
    int i = (int)paramLong;
    e.h localh = e.h.kkq;
    boolean bool = com.tencent.mm.ae.d.dr(i, e.h.aKu());
    AppMethodBeat.o(258614);
    return bool;
  }
  
  public static String a(String paramString, LinkedList<axc> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(258604);
    p.k(paramString, "prefix");
    p.k(paramLinkedList, "visitorRoleList");
    StringBuilder localStringBuilder1 = new StringBuilder("[printVisitorRoleInfo]" + paramString + ":curVisitorRoleType:" + paramInt + ";visitorRoleModifyTime:0;");
    synchronized ((Iterable)paramLinkedList)
    {
      Iterator localIterator = ???.iterator();
      paramInt = 0;
      while (localIterator.hasNext())
      {
        paramString = localIterator.next();
        if (paramInt < 0) {
          kotlin.a.j.iBO();
        }
        paramLinkedList = (axc)paramString;
        StringBuilder localStringBuilder2 = new StringBuilder("[").append(paramInt).append(':');
        paramString = paramLinkedList;
        if (paramLinkedList == null) {
          paramString = "";
        }
        localStringBuilder1.append(g.bN(paramString) + ']');
        paramInt += 1;
      }
      paramString = x.aazN;
      paramString = localStringBuilder1.toString();
      p.j(paramString, "msg.toString()");
      AppMethodBeat.o(258604);
      return paramString;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(258607);
    p.k(paramString, "content");
    p.k(parama, "liveData");
    bbd localbbd = new bbd();
    localbbd.type = 10001;
    localbbd.content = paramString;
    paramString = new com.tencent.mm.plugin.finder.live.model.ak(localbbd);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.add(paramString);
    paramString = com.tencent.mm.live.b.j.kue;
    com.tencent.mm.live.b.j.aNv();
    AppMethodBeat.o(258607);
  }
  
  public static boolean dEA()
  {
    AppMethodBeat.i(258610);
    b.b localb = com.tencent.mm.live.core.core.a.b.klq;
    boolean bool = b.b.aLi();
    AppMethodBeat.o(258610);
    return bool;
  }
  
  public static boolean dEy()
  {
    AppMethodBeat.i(258598);
    Object localObject = com.tencent.mm.live.core.core.a.b.klq;
    if (!b.b.aLi())
    {
      localObject = com.tencent.mm.live.core.core.b.a.knj;
      if (!a.a.aLi()) {}
    }
    else
    {
      AppMethodBeat.o(258598);
      return true;
    }
    AppMethodBeat.o(258598);
    return false;
  }
  
  public static LinkedList<axc> dEz()
  {
    AppMethodBeat.i(258601);
    Object localObject1 = new LinkedList();
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject2 = (String)((f)localObject2).aHp().j(ar.a.VyT);
        axd localaxd = new axd();
        if (localObject2 != null)
        {
          localObject5 = kotlin.n.d.ISO_8859_1;
          if (localObject2 == null)
          {
            localObject2 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(258601);
            throw ((Throwable)localObject2);
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject5;
        localObject2 = localObject1;
        localObject1 = localObject2;
        try
        {
          localObject5 = com.tencent.mm.plugin.finder.utils.ak.AGL;
          localObject1 = localObject2;
          com.tencent.mm.plugin.finder.utils.ak.a(localException1, "getAliasInfoList:" + localException1.getMessage());
          AppMethodBeat.o(258601);
          return localObject2;
        }
        finally
        {
          continue;
        }
        localObject2 = ((String)localObject2).getBytes((Charset)localObject5);
        p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
        localException1.parseFrom((byte[])localObject2);
        localObject2 = localException1.SID;
        p.j(localObject2, "safeAliasInfo.alias_info");
        localObject1 = localObject2;
      }
      finally
      {
        try
        {
          Object localObject2;
          Log.i("LiveUtil", "getAliasInfoList result:" + g.bN(localException1));
          AppMethodBeat.o(258601);
          return localObject2;
        }
        catch (Exception localException2) {}
        localObject3 = finally;
        AppMethodBeat.o(258601);
        return localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.r
 * JD-Core Version:    0.7.0.1
 */