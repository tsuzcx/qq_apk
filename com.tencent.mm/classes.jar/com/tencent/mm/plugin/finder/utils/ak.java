package com.tencent.mm.plugin.finder.utils;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil2;", "", "()V", "CARE_MEDIA_TYPE", "", "", "getCARE_MEDIA_TYPE", "()Ljava/util/List;", "CARE_MEDIA_TYPE$delegate", "Lkotlin/Lazy;", "FINDER_EDIT_ALLOW_FILLING_FULL_SCREEN_VALUE", "getFINDER_EDIT_ALLOW_FILLING_FULL_SCREEN_VALUE", "()I", "setFINDER_EDIT_ALLOW_FILLING_FULL_SCREEN_VALUE", "(I)V", "FINDER_FOLLOW_FULLSCREEN_ENJOY_VALUE", "getFINDER_FOLLOW_FULLSCREEN_ENJOY_VALUE", "setFINDER_FOLLOW_FULLSCREEN_ENJOY_VALUE", "FINDER_FRIEND_FULLSCREEN_ENJOY_VALUE", "getFINDER_FRIEND_FULLSCREEN_ENJOY_VALUE", "setFINDER_FRIEND_FULLSCREEN_ENJOY_VALUE", "FINDER_GLOBAL_FULLSCREEN_ENJOY_VALUE", "getFINDER_GLOBAL_FULLSCREEN_ENJOY_VALUE", "setFINDER_GLOBAL_FULLSCREEN_ENJOY_VALUE", "FINDER_HOT_FULLSCREEN_ENJOY_VALUE", "getFINDER_HOT_FULLSCREEN_ENJOY_VALUE", "setFINDER_HOT_FULLSCREEN_ENJOY_VALUE", "FINDER_OTHER_FULLSCREEN_ENJOY_VALUE", "getFINDER_OTHER_FULLSCREEN_ENJOY_VALUE", "setFINDER_OTHER_FULLSCREEN_ENJOY_VALUE", "FINDER_POST_DISABLE_HALF_SCREEN_VALUE", "getFINDER_POST_DISABLE_HALF_SCREEN_VALUE", "setFINDER_POST_DISABLE_HALF_SCREEN_VALUE", "FINDER_SHARE_FULLSCREEN_ENJOY_VALUE", "getFINDER_SHARE_FULLSCREEN_ENJOY_VALUE", "setFINDER_SHARE_FULLSCREEN_ENJOY_VALUE", "OTHER_CARE_REPORT_RV_TYPE", "", "getOTHER_CARE_REPORT_RV_TYPE", "()Ljava/util/Set;", "TAG", "", "isNeedResetFullScreenConfig", "", "()Z", "setNeedResetFullScreenConfig", "(Z)V", "checkResetFullScreenConfig", "", "convertCompatibilityMediaType", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isAllEnableFullScreenEnjoy", "isAnyEnableFullScreenEnjoy", "isFinderComment", "displayFlag", "isNormalVideo", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isOtherEnableFullScreenEnjoy", "isPoster", "isRegInChina", "isTest", "isWxSelf", "username", "testStack", "transOldFinderMsgSessionAndConv", "tryCatchReleaseException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "extraMsg", "plugin-finder-base_release"})
public final class ak
{
  private static final Set<Integer> AFP;
  private static boolean AFT = false;
  private static int AFU = 0;
  private static int AFV = 0;
  private static int AFW = 0;
  private static int AFX = 0;
  private static int AFY = 0;
  private static int AFZ = 0;
  private static final kotlin.f AGK;
  public static final ak AGL;
  private static int AGa = 0;
  private static int AGb = 0;
  private static final String TAG = "Finder.FinderUtil2";
  
  static
  {
    AppMethodBeat.i(258411);
    AGL = new ak();
    TAG = "Finder.FinderUtil2";
    AGK = g.ar((kotlin.g.a.a)ak.a.AGM);
    AFP = kotlin.a.ak.setOf(Integer.valueOf(2013));
    AFT = true;
    d locald = d.AjH;
    AFU = ((Number)d.dWC().aSr()).intValue();
    locald = d.AjH;
    AFV = ((Number)d.dWD().aSr()).intValue();
    locald = d.AjH;
    AFW = ((Number)d.dWE().aSr()).intValue();
    locald = d.AjH;
    AFX = ((Number)d.dWF().aSr()).intValue();
    locald = d.AjH;
    AFY = ((Number)d.dWH().aSr()).intValue();
    locald = d.AjH;
    AFZ = ((Number)d.dWG().aSr()).intValue();
    locald = d.AjH;
    AGa = ((Number)d.dWI().aSr()).intValue();
    locald = d.AjH;
    AGb = ((Number)d.dWJ().aSr()).intValue();
    AppMethodBeat.o(258411);
  }
  
  public static int F(FinderObject paramFinderObject)
  {
    Object localObject2 = null;
    int k = 0;
    AppMethodBeat.i(258405);
    p.k(paramFinderObject, "obj");
    if (paramFinderObject.objectDesc != null)
    {
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 == null) {
        break label132;
      }
    }
    label132:
    for (Object localObject1 = Integer.valueOf(((FinderObjectDesc)localObject1).mediaType);; localObject1 = null)
    {
      if (localObject1 == null) {
        Log.printInfoStack(TAG, "obj ".concat(String.valueOf(paramFinderObject)), new Object[0]);
      }
      Iterable localIterable = (Iterable)eeC();
      FinderObjectDesc localFinderObjectDesc = paramFinderObject.objectDesc;
      localObject1 = localObject2;
      if (localFinderObjectDesc != null) {
        localObject1 = Integer.valueOf(localFinderObjectDesc.mediaType);
      }
      if (!j.a(localIterable, localObject1)) {
        break label145;
      }
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject == null) {
        break;
      }
      i = paramFinderObject.mediaType;
      AppMethodBeat.o(258405);
      return i;
    }
    AppMethodBeat.o(258405);
    return 0;
    label145:
    localObject1 = paramFinderObject.objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if ((localObject1 != null) && (((LinkedList)localObject1).size() == 0))
      {
        paramFinderObject = paramFinderObject.objectDesc;
        if (paramFinderObject != null)
        {
          i = paramFinderObject.mediaType;
          AppMethodBeat.o(258405);
          return i;
        }
        AppMethodBeat.o(258405);
        return 0;
      }
    }
    localObject1 = paramFinderObject.objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 != null)
      {
        localObject1 = (FinderMedia)((LinkedList)localObject1).get(0);
        if (localObject1 == null) {}
      }
    }
    for (int i = ((FinderMedia)localObject1).mediaType; !eeC().contains(Integer.valueOf(i)); i = 0)
    {
      AppMethodBeat.o(258405);
      return i;
    }
    if (i == 4)
    {
      localObject1 = paramFinderObject.objectDesc;
      int j = k;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        j = k;
        if (localObject1 != null) {
          j = ((LinkedList)localObject1).size();
        }
      }
      if (j > 1)
      {
        AppMethodBeat.o(258405);
        return 8;
      }
    }
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject != null)
      {
        paramFinderObject = ((Iterable)paramFinderObject).iterator();
        while (paramFinderObject.hasNext()) {
          if (((FinderMedia)paramFinderObject.next()).mediaType != i)
          {
            AppMethodBeat.o(258405);
            return 8;
          }
        }
      }
    }
    AppMethodBeat.o(258405);
    return i;
  }
  
  public static boolean QU(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean Ro(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static void a(Exception paramException, String paramString)
  {
    AppMethodBeat.i(258402);
    p.k(paramException, "e");
    p.k(paramString, "extraMsg");
    if (eej())
    {
      paramException = (Throwable)paramException;
      AppMethodBeat.o(258402);
      throw paramException;
    }
    Log.printInfoStack(TAG, paramString + ' ' + paramException.getMessage(), new Object[0]);
    AppMethodBeat.o(258402);
  }
  
  public static boolean aFJ(String paramString)
  {
    AppMethodBeat.i(258406);
    boolean bool = Util.isEqual(paramString, z.bcZ());
    AppMethodBeat.o(258406);
    return bool;
  }
  
  public static Set<Integer> edV()
  {
    return AFP;
  }
  
  public static List<Integer> eeC()
  {
    AppMethodBeat.i(258401);
    List localList = (List)AGK.getValue();
    AppMethodBeat.o(258401);
    return localList;
  }
  
  public static boolean eeD()
  {
    AppMethodBeat.i(258410);
    Object localObject1 = h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    Object localObject2 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(274436);
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = Util.nullAs((String)localObject1, "CN");
    boolean bool = n.L("CN", (String)localObject1, true);
    Log.i(TAG, "isRegInChina, regCountryIsoCode:" + (String)localObject1 + " isChinaReg:" + bool);
    AppMethodBeat.o(258410);
    return bool;
  }
  
  public static boolean eej()
  {
    AppMethodBeat.i(258403);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(258403);
      return true;
    }
    AppMethodBeat.o(258403);
    return false;
  }
  
  private static void eep()
  {
    AppMethodBeat.i(258407);
    if (AFT)
    {
      d locald = d.AjH;
      AFU = ((Number)d.dWC().aSr()).intValue();
      locald = d.AjH;
      AFV = ((Number)d.dWD().aSr()).intValue();
      locald = d.AjH;
      AFW = ((Number)d.dWE().aSr()).intValue();
      locald = d.AjH;
      AFX = ((Number)d.dWF().aSr()).intValue();
      locald = d.AjH;
      AFY = ((Number)d.dWH().aSr()).intValue();
      locald = d.AjH;
      AFZ = ((Number)d.dWG().aSr()).intValue();
      locald = d.AjH;
      AGa = ((Number)d.dWI().aSr()).intValue();
      locald = d.AjH;
      AGb = ((Number)d.dWJ().aSr()).intValue();
      AFT = false;
      Log.i(TAG, "[checkResetFullScreenConfig] reset config GLOBAL=" + AFU + " HOT=" + AFV + ' ' + "FOLLOW=" + AFW + " FRIEND=" + AFX + ' ' + "SHARE=" + AFY + " OTHER=" + AFZ);
      Log.i(TAG, "[checkResetFullScreenConfig] reset config DISABLE_HALF_SCREEN=" + AGa + ' ' + "ALLOW_FILLING_FULL_SCREEN_VALUE=" + AGb);
    }
    AppMethodBeat.o(258407);
  }
  
  public static void eez()
  {
    boolean bool2 = true;
    AppMethodBeat.i(258404);
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    boolean bool1 = ((com.tencent.mm.kernel.f)localObject).aHp().getBoolean(ar.a.Vzb, false);
    localObject = d.AjH;
    boolean bool3 = ((Boolean)d.dXJ().aSr()).booleanValue();
    Log.i(TAG, "[checkOldSessionInfo] hasTrans:" + bool1 + " , ignoreHasTrans:" + bool3);
    final aa.a locala;
    com.tencent.mm.plugin.findersdk.b localb;
    if ((!bool1) || (bool3))
    {
      Log.i(TAG, "[checkOldSessionInfo] begin");
      long l = SystemClock.uptimeMillis();
      localObject = new aa.a();
      ((aa.a)localObject).aaBx = ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).bvP();
      locala = new aa.a();
      locala.aaBx = ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).bvQ();
      l = SystemClock.uptimeMillis() - l;
      Log.i(TAG, "[checkOldSessionInfo] end,duration = ".concat(String.valueOf(l)));
      localb = com.tencent.mm.plugin.findersdk.b.BuZ;
      if (l <= 10000L) {
        break label318;
      }
      bool1 = true;
      f.a.a(localb, "transOldFinderMsgSessionInfo", bool1, (kotlin.g.a.a)new b(l));
      localb = com.tencent.mm.plugin.findersdk.b.BuZ;
      if ((!((aa.a)localObject).aaBx) || (!locala.aaBx)) {
        break label323;
      }
    }
    label318:
    label323:
    for (bool1 = bool2;; bool1 = false)
    {
      f.a.a(localb, "transOldFinderMsgSessionInfo-result", bool1, false, (kotlin.g.a.a)new c((aa.a)localObject, locala), 12);
      if ((((aa.a)localObject).aaBx) && (locala.aaBx))
      {
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vzb, Boolean.TRUE);
      }
      AppMethodBeat.o(258404);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static boolean g(csg paramcsg)
  {
    if (paramcsg != null) {
      paramcsg = paramcsg.TpG;
    }
    return (paramcsg == null) || (paramcsg.Sox != true);
  }
  
  public static boolean isAllEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(258409);
    eep();
    if ((AFU == 1) || ((AFV == 1) && (AFW == 1) && (AFX == 1) && (AFY == 1) && (AFZ == 1)))
    {
      AppMethodBeat.o(258409);
      return true;
    }
    AppMethodBeat.o(258409);
    return false;
  }
  
  public static boolean isAnyEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(258408);
    eep();
    if ((AFU == 1) || (AFV == 1) || (AFW == 1) || (AFX == 1) || (AFY == 1) || (AFZ == 1))
    {
      AppMethodBeat.o(258408);
      return true;
    }
    AppMethodBeat.o(258408);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<String>
  {
    b(long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<String>
  {
    c(aa.a parama1, aa.a parama2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ak
 * JD-Core Version:    0.7.0.1
 */