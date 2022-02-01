package com.tencent.mm.plugin.finder.extension.reddot;

import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier;", "", "()V", "TAG", "", "discoveryTab", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getDiscoveryTab", "()Landroidx/lifecycle/MutableLiveData;", "finderAuthorProfileFans", "getFinderAuthorProfileFans", "finderAuthorProfileNotify", "getFinderAuthorProfileNotify", "finderCreateFinderEntrance", "getFinderCreateFinderEntrance", "finderCreatorEntrance", "getFinderCreatorEntrance", "finderEntrance", "getFinderEntrance", "finderFirstFav", "getFinderFirstFav", "finderLiveEntrance", "getFinderLiveEntrance", "finderLiveForFindPageEntrance", "getFinderLiveForFindPageEntrance", "finderLiveInComeEntrance", "getFinderLiveInComeEntrance", "finderMessage", "getFinderMessage", "finderOriginalEntrance", "getFinderOriginalEntrance", "finderPosterEntrace", "getFinderPosterEntrace", "finderProfileEntrance", "getFinderProfileEntrance", "finderProfileSetting", "getFinderProfileSetting", "finderProfileTop", "getFinderProfileTop", "finderSettingLiveTask", "getFinderSettingLiveTask", "finderTlCamera", "getFinderTlCamera", "finderTlPersonalCenter", "getFinderTlPersonalCenter", "finderTlPostCamera", "getFinderTlPostCamera", "finderTlTabFollow", "getFinderTlTabFollow", "finderTlTabFriend", "getFinderTlTabFriend", "finderTlTabLbs", "getFinderTlTabLbs", "finderTlTabMachine", "getFinderTlTabMachine", "finderTlWxBubble", "getFinderTlWxBubble", "finderTlWxMessageBubble", "getFinderTlWxMessageBubble", "finderWxMessage", "getFinderWxMessage", "nearbyEntrance", "getNearbyEntrance", "nearbyTabFeed", "getNearbyTabFeed", "nearbyTabLive", "getNearbyTabLive", "nearbyTabPeople", "getNearbyTabPeople", "checkPathAndNotify", "", "path", "notify", "isShow", "", "tipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "observeForeverWithNotify", "T", "observer", "Landroidx/lifecycle/Observer;", "observeWithNotify", "owner", "Landroidx/lifecycle/LifecycleOwner;", "Result", "plugin-finder_release"})
public final class h
{
  private static final r<a> xtK;
  private static final r<a> xtL;
  private static final r<a> xtM;
  private static final r<a> xtN;
  private static final r<a> xtO;
  private static final r<a> xtP;
  private static final r<a> xtQ;
  private static final r<a> xtR;
  private static final r<a> xtS;
  private static final r<a> xtT;
  private static final r<a> xtU;
  private static final r<a> xtV;
  private static final r<a> xtW;
  private static final r<a> xtX;
  private static final r<a> xtY;
  private static final r<a> xtZ;
  private static final r<a> xua;
  private static final r<a> xub;
  private static final r<a> xuc;
  private static final r<a> xud;
  private static final r<a> xue;
  private static final r<a> xuf;
  private static final r<a> xug;
  private static final r<a> xuh;
  private static final r<a> xui;
  private static final r<a> xuj;
  private static final r<a> xuk;
  private static final r<a> xul;
  private static final r<a> xum;
  private static final r<a> xun;
  private static final r<a> xuo;
  public static final h xup;
  
  static
  {
    AppMethodBeat.i(178190);
    xup = new h();
    xtK = new r();
    xtL = new r();
    xtM = new r();
    xtN = new r();
    xtO = new r();
    xtP = new r();
    xtQ = new r();
    xtR = new r();
    xtS = new r();
    xtT = new r();
    xtU = new r();
    xtV = new r();
    xtW = new r();
    xtX = new r();
    xtY = new r();
    xtZ = new r();
    xua = new r();
    xub = new r();
    xuc = new r();
    xud = new r();
    xue = new r();
    xuf = new r();
    xug = new r();
    xuh = new r();
    xui = new r();
    xuj = new r();
    xuk = new r();
    xul = new r();
    xum = new r();
    xun = new r();
    xuo = new r();
    AppMethodBeat.o(178190);
  }
  
  public static <T> void a(r<T> paramr, final androidx.lifecycle.l paraml, final s<T> params)
  {
    AppMethodBeat.i(273992);
    p.k(paramr, "$this$observeWithNotify");
    p.k(paraml, "owner");
    p.k(params, "observer");
    d.uiThread((a)new c(paramr, paraml, params));
    AppMethodBeat.o(273992);
  }
  
  public static <T> void a(r<T> paramr, final s<T> params)
  {
    AppMethodBeat.i(273993);
    p.k(paramr, "$this$observeForeverWithNotify");
    p.k(params, "observer");
    d.uiThread((a)new b(paramr, params));
    AppMethodBeat.o(273993);
  }
  
  public static void a(boolean paramBoolean, String paramString, bkn parambkn, l paraml)
  {
    Object localObject2 = null;
    AppMethodBeat.i(178189);
    p.k(paramString, "path");
    StringBuilder localStringBuilder = new StringBuilder("[notify] isShow=").append(paramBoolean).append(" path=").append(paramString).append(" show_type=");
    if (parambkn != null)
    {
      localObject1 = Integer.valueOf(parambkn.CKC);
      localStringBuilder = localStringBuilder.append(localObject1).append(" count=");
      if (parambkn == null) {
        break label288;
      }
      localObject1 = Integer.valueOf(parambkn.count);
      label89:
      localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("title=");
      if (parambkn == null) {
        break label294;
      }
      localObject1 = parambkn.title;
      label119:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" clear_type=");
      if (parambkn == null) {
        break label300;
      }
      localObject1 = Integer.valueOf(parambkn.SVs);
      label147:
      localStringBuilder = localStringBuilder.append(localObject1).append(" parent=");
      if (parambkn == null) {
        break label306;
      }
    }
    label288:
    label294:
    label300:
    label306:
    for (Object localObject1 = parambkn.HpB;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" icon=");
      localObject1 = localObject2;
      if (parambkn != null) {
        localObject1 = parambkn.ufC;
      }
      Log.i("Finder.RedDotNotifier", (String)localObject1);
      if (!paramBoolean) {
        break label312;
      }
      localObject1 = com.tencent.mm.kernel.h.ae(ae.class);
      p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if ((!((ae)localObject1).dYT()) || ((paraml != null) && (paraml.field_ctrInfo.type == 8))) {
        break label312;
      }
      Log.i("Finder.RedDotManager", "[notify] 青少年模式且只看关注的模式下只notify关注的红点展示");
      AppMethodBeat.o(178189);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label89;
      localObject1 = null;
      break label119;
      localObject1 = null;
      break label147;
    }
    label312:
    parambkn = new a(paramBoolean, parambkn, paraml);
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(178189);
          return;
          if (paramString.equals("OriginalEntrance"))
          {
            xtT.L(parambkn);
            AppMethodBeat.o(178189);
            return;
            if (paramString.equals("finder_wx_private_msg_entrance"))
            {
              xub.L(parambkn);
              AppMethodBeat.o(178189);
              return;
              if (paramString.equals("FinderProfileBanner"))
              {
                xug.L(parambkn);
                AppMethodBeat.o(178189);
                return;
                if (paramString.equals("NearbyPeopleTab"))
                {
                  xuj.L(parambkn);
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("TLRecommendTab"))
                  {
                    xtW.L(parambkn);
                    AppMethodBeat.o(178189);
                    return;
                    if (paramString.equals("TLWxPrivateMsgBubble"))
                    {
                      xuc.L(parambkn);
                      AppMethodBeat.o(178189);
                      return;
                      if (paramString.equals("NearbyEntrance"))
                      {
                        xul.L(parambkn);
                        AppMethodBeat.o(178189);
                        return;
                        if (paramString.equals("FinderEntrance"))
                        {
                          xtL.L(parambkn);
                          AppMethodBeat.o(178189);
                          return;
                          if (paramString.equals("NearbyLiveTab"))
                          {
                            xui.L(parambkn);
                            AppMethodBeat.o(178189);
                            return;
                            if (paramString.equals("TLPostCamera"))
                            {
                              xtN.L(parambkn);
                              AppMethodBeat.o(178189);
                              return;
                              if (paramString.equals("finder_tl_hot_tab"))
                              {
                                xtY.L(parambkn);
                                AppMethodBeat.o(178189);
                                return;
                                if (paramString.equals("FinderLiveEntrance"))
                                {
                                  xuk.L(parambkn);
                                  AppMethodBeat.o(178189);
                                  return;
                                  if (paramString.equals("FinderLiveIncomeEntrance"))
                                  {
                                    xum.L(parambkn);
                                    AppMethodBeat.o(178189);
                                    return;
                                    if (paramString.equals("finder_private_msg_entrance"))
                                    {
                                      xua.L(parambkn);
                                      AppMethodBeat.o(178189);
                                      return;
                                      if (paramString.equals("ProfileEntrance"))
                                      {
                                        xtP.L(parambkn);
                                        AppMethodBeat.o(178189);
                                        return;
                                        if (paramString.equals("TLCamera"))
                                        {
                                          xtM.L(parambkn);
                                          AppMethodBeat.o(178189);
                                          return;
                                          if (paramString.equals("Discovery"))
                                          {
                                            xtK.L(parambkn);
                                            AppMethodBeat.o(178189);
                                            return;
                                            if (paramString.equals("AuthorProfileFans"))
                                            {
                                              xtQ.L(parambkn);
                                              AppMethodBeat.o(178189);
                                              return;
                                              if (paramString.equals("FinderSetting"))
                                              {
                                                xtU.L(parambkn);
                                                AppMethodBeat.o(178189);
                                                return;
                                                if (paramString.equals("Personal_Center_FavList_Entrance"))
                                                {
                                                  xtX.L(parambkn);
                                                  AppMethodBeat.o(178189);
                                                  return;
                                                  if (paramString.equals("CreateFinderEntrance"))
                                                  {
                                                    xuf.L(parambkn);
                                                    AppMethodBeat.o(178189);
                                                    return;
                                                    if (paramString.equals("TLPersonalCenter"))
                                                    {
                                                      xtS.L(parambkn);
                                                      AppMethodBeat.o(178189);
                                                      return;
                                                      if (paramString.equals("NearbyFeedTab"))
                                                      {
                                                        xuh.L(parambkn);
                                                        AppMethodBeat.o(178189);
                                                        return;
                                                        if (paramString.equals("CreatorCenter"))
                                                        {
                                                          xue.L(parambkn);
                                                          AppMethodBeat.o(178189);
                                                          return;
                                                          if (paramString.equals("FinderSelfLiveEntrance"))
                                                          {
                                                            xud.L(parambkn);
                                                            AppMethodBeat.o(178189);
                                                            return;
                                                            if (paramString.equals("TLFollow"))
                                                            {
                                                              xtV.L(parambkn);
                                                              AppMethodBeat.o(178189);
                                                              return;
                                                              if (paramString.equals("AuthorProfileNotify"))
                                                              {
                                                                xtR.L(parambkn);
                                                                AppMethodBeat.o(178189);
                                                                return;
                                                                if (paramString.equals("FinderPosterEntrance"))
                                                                {
                                                                  xuo.L(parambkn);
                                                                  AppMethodBeat.o(178189);
                                                                  return;
                                                                  if (paramString.equals("FinderSettingLiveTask")) {
                                                                    xun.L(parambkn);
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramString.equals("finder_tl_nearby_tab"));
      xtZ.L(parambkn);
      AppMethodBeat.o(178189);
      return;
    } while (!paramString.equals("TLWxBubble"));
    xtO.L(parambkn);
    AppMethodBeat.o(178189);
  }
  
  public static void aBk(String paramString)
  {
    AppMethodBeat.i(273994);
    p.k(paramString, "path");
    Object localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().aBf(paramString);
    if (localObject != null)
    {
      bkn localbkn = ((l)localObject).aBy(paramString);
      if (localbkn != null)
      {
        a(true, paramString, localbkn, (l)localObject);
        AppMethodBeat.o(273994);
        return;
      }
      a(false, paramString, null, (l)localObject);
      AppMethodBeat.o(273994);
      return;
    }
    a(false, paramString, null, null);
    AppMethodBeat.o(273994);
  }
  
  public static r<a> dqN()
  {
    return xtK;
  }
  
  public static r<a> dqO()
  {
    return xtL;
  }
  
  public static r<a> dqP()
  {
    return xtM;
  }
  
  public static r<a> dqQ()
  {
    return xtP;
  }
  
  public static r<a> dqR()
  {
    return xtS;
  }
  
  public static r<a> dqS()
  {
    return xtT;
  }
  
  public static r<a> dqT()
  {
    return xtU;
  }
  
  public static r<a> dqU()
  {
    return xtV;
  }
  
  public static r<a> dqV()
  {
    return xtW;
  }
  
  public static r<a> dqW()
  {
    return xtX;
  }
  
  public static r<a> dqX()
  {
    return xtY;
  }
  
  public static r<a> dqY()
  {
    return xtZ;
  }
  
  public static r<a> dqZ()
  {
    return xua;
  }
  
  public static r<a> dra()
  {
    return xub;
  }
  
  public static r<a> drb()
  {
    return xuc;
  }
  
  public static r<a> drc()
  {
    return xud;
  }
  
  public static r<a> drd()
  {
    return xue;
  }
  
  public static r<a> dre()
  {
    return xuf;
  }
  
  public static r<a> drf()
  {
    return xug;
  }
  
  public static r<a> drg()
  {
    return xuh;
  }
  
  public static r<a> drh()
  {
    return xui;
  }
  
  public static r<a> dri()
  {
    return xuj;
  }
  
  public static r<a> drj()
  {
    return xuk;
  }
  
  public static r<a> drk()
  {
    return xul;
  }
  
  public static r<a> drl()
  {
    return xum;
  }
  
  public static r<a> drm()
  {
    return xun;
  }
  
  public static r<a> drn()
  {
    return xuo;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "", "isShow", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "(ZLcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;)V", "getCtrInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public final boolean fxt;
    public bkn xuq;
    public final l xur;
    
    public a(boolean paramBoolean, bkn parambkn, l paraml)
    {
      this.fxt = paramBoolean;
      this.xuq = parambkn;
      this.xur = paraml;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(178187);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.fxt != paramObject.fxt) || (!p.h(this.xuq, paramObject.xuq)) || (!p.h(this.xur, paramObject.xur))) {}
        }
      }
      else
      {
        AppMethodBeat.o(178187);
        return true;
      }
      AppMethodBeat.o(178187);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      Object localObject2 = null;
      AppMethodBeat.i(178185);
      StringBuilder localStringBuilder = new StringBuilder("tipId=");
      Object localObject1 = this.xur;
      if (localObject1 != null)
      {
        localObject1 = ((l)localObject1).field_tipsId;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" type=");
        localObject1 = this.xur;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = ((l)localObject1).field_ctrInfo;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = Integer.valueOf(((bhw)localObject1).type);
        label68:
        localStringBuilder = localStringBuilder.append(localObject1).append(" isShow=").append(this.fxt).append(" path=");
        localObject1 = this.xuq;
        if (localObject1 == null) {
          break label189;
        }
        localObject1 = ((bkn)localObject1).path;
        label105:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" showType=");
        localObject1 = this.xuq;
        if (localObject1 == null) {
          break label194;
        }
      }
      label184:
      label189:
      label194:
      for (localObject1 = Integer.valueOf(((bkn)localObject1).CKC);; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append(" title=");
        bkn localbkn = this.xuq;
        localObject1 = localObject2;
        if (localbkn != null) {
          localObject1 = localbkn.title;
        }
        localObject1 = (String)localObject1;
        AppMethodBeat.o(178185);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = null;
        break label68;
        localObject1 = null;
        break label105;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(r paramr, s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(r paramr, androidx.lifecycle.l paraml, s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.h
 * JD-Core Version:    0.7.0.1
 */