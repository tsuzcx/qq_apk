package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier;", "", "()V", "TAG", "", "discoveryTab", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getDiscoveryTab", "()Landroid/arch/lifecycle/MutableLiveData;", "finderAuthorProfileFans", "getFinderAuthorProfileFans", "finderAuthorProfileNotify", "getFinderAuthorProfileNotify", "finderCreatorEntrance", "getFinderCreatorEntrance", "finderEntrance", "getFinderEntrance", "finderFirstFav", "getFinderFirstFav", "finderLiveEntrance", "getFinderLiveEntrance", "finderMessage", "getFinderMessage", "finderMyTabRedPack", "getFinderMyTabRedPack", "finderOriginalEntrance", "getFinderOriginalEntrance", "finderProfileEntrance", "getFinderProfileEntrance", "finderProfileSetting", "getFinderProfileSetting", "finderSelfRedPack", "getFinderSelfRedPack", "finderTlCamera", "getFinderTlCamera", "finderTlPersonalCenter", "getFinderTlPersonalCenter", "finderTlPostCamera", "getFinderTlPostCamera", "finderTlTabFollow", "getFinderTlTabFollow", "finderTlTabFriend", "getFinderTlTabFriend", "finderTlTabLbs", "getFinderTlTabLbs", "finderTlTabMachine", "getFinderTlTabMachine", "finderTlWxBubble", "getFinderTlWxBubble", "finderTlWxMessageBubble", "getFinderTlWxMessageBubble", "finderWxMessage", "getFinderWxMessage", "nearbyEntrance", "getNearbyEntrance", "nearbyTabFeed", "getNearbyTabFeed", "nearbyTabLive", "getNearbyTabLive", "nearbyTabPeople", "getNearbyTabPeople", "notify", "", "isShow", "", "path", "tipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "observeForeverWithNotify", "T", "observer", "Landroid/arch/lifecycle/Observer;", "observeWithNotify", "owner", "Landroid/arch/lifecycle/LifecycleOwner;", "Result", "plugin-finder_release"})
public final class h
{
  private static final MutableLiveData<a> tKA;
  private static final MutableLiveData<a> tKB;
  private static final MutableLiveData<a> tKC;
  private static final MutableLiveData<a> tKD;
  private static final MutableLiveData<a> tKE;
  private static final MutableLiveData<a> tKF;
  private static final MutableLiveData<a> tKG;
  private static final MutableLiveData<a> tKH;
  private static final MutableLiveData<a> tKI;
  private static final MutableLiveData<a> tKJ;
  private static final MutableLiveData<a> tKK;
  private static final MutableLiveData<a> tKL;
  private static final MutableLiveData<a> tKM;
  private static final MutableLiveData<a> tKN;
  private static final MutableLiveData<a> tKO;
  private static final MutableLiveData<a> tKP;
  private static final MutableLiveData<a> tKQ;
  public static final h tKR;
  private static final MutableLiveData<a> tKq;
  private static final MutableLiveData<a> tKr;
  private static final MutableLiveData<a> tKs;
  private static final MutableLiveData<a> tKt;
  private static final MutableLiveData<a> tKu;
  private static final MutableLiveData<a> tKv;
  private static final MutableLiveData<a> tKw;
  private static final MutableLiveData<a> tKx;
  private static final MutableLiveData<a> tKy;
  private static final MutableLiveData<a> tKz;
  
  static
  {
    AppMethodBeat.i(178190);
    tKR = new h();
    tKq = new MutableLiveData();
    tKr = new MutableLiveData();
    tKs = new MutableLiveData();
    tKt = new MutableLiveData();
    tKu = new MutableLiveData();
    tKv = new MutableLiveData();
    tKw = new MutableLiveData();
    tKx = new MutableLiveData();
    tKy = new MutableLiveData();
    tKz = new MutableLiveData();
    tKA = new MutableLiveData();
    tKB = new MutableLiveData();
    tKC = new MutableLiveData();
    tKD = new MutableLiveData();
    tKE = new MutableLiveData();
    tKF = new MutableLiveData();
    tKG = new MutableLiveData();
    tKH = new MutableLiveData();
    tKI = new MutableLiveData();
    tKJ = new MutableLiveData();
    tKK = new MutableLiveData();
    tKL = new MutableLiveData();
    tKM = new MutableLiveData();
    tKN = new MutableLiveData();
    tKO = new MutableLiveData();
    tKP = new MutableLiveData();
    tKQ = new MutableLiveData();
    AppMethodBeat.o(178190);
  }
  
  public static <T> void a(MutableLiveData<T> paramMutableLiveData, final LifecycleOwner paramLifecycleOwner, final Observer<T> paramObserver)
  {
    AppMethodBeat.i(178188);
    p.h(paramMutableLiveData, "$this$observeWithNotify");
    p.h(paramLifecycleOwner, "owner");
    p.h(paramObserver, "observer");
    d.h((a)new c(paramMutableLiveData, paramLifecycleOwner, paramObserver));
    AppMethodBeat.o(178188);
  }
  
  public static <T> void a(MutableLiveData<T> paramMutableLiveData, final Observer<T> paramObserver)
  {
    AppMethodBeat.i(243610);
    p.h(paramMutableLiveData, "$this$observeForeverWithNotify");
    p.h(paramObserver, "observer");
    d.h((a)new b(paramMutableLiveData, paramObserver));
    AppMethodBeat.o(243610);
  }
  
  public static void a(boolean paramBoolean, String paramString, bdo parambdo, k paramk)
  {
    Object localObject2 = null;
    AppMethodBeat.i(178189);
    p.h(paramString, "path");
    StringBuilder localStringBuilder = new StringBuilder("[notify] isShow=").append(paramBoolean).append(" path=").append(paramString).append(" show_type=");
    if (parambdo != null)
    {
      localObject1 = Integer.valueOf(parambdo.xGz);
      localStringBuilder = localStringBuilder.append(localObject1).append(" count=");
      if (parambdo == null) {
        break label282;
      }
      localObject1 = Integer.valueOf(parambdo.count);
      label84:
      localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("title=");
      if (parambdo == null) {
        break label288;
      }
      localObject1 = parambdo.title;
      label114:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" clear_type=");
      if (parambdo == null) {
        break label294;
      }
      localObject1 = Integer.valueOf(parambdo.LNm);
      label142:
      localStringBuilder = localStringBuilder.append(localObject1).append(" parent=");
      if (parambdo == null) {
        break label300;
      }
    }
    label282:
    label288:
    label294:
    label300:
    for (Object localObject1 = parambdo.Bvg;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" icon=");
      localObject1 = localObject2;
      if (parambdo != null) {
        localObject1 = parambdo.qGB;
      }
      Log.i("Finder.RedDotNotifier", (String)localObject1);
      if (!paramBoolean) {
        break label306;
      }
      localObject1 = g.af(ad.class);
      p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if ((!((ad)localObject1).dxX()) || ((paramk != null) && (paramk.field_ctrInfo.type == 8))) {
        break label306;
      }
      Log.i("Finder.RedDotManager", "[notify] 青少年模式且只看关注的模式下只notify关注的红点展示");
      AppMethodBeat.o(178189);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label84;
      localObject1 = null;
      break label114;
      localObject1 = null;
      break label142;
    }
    label306:
    parambdo = new a(paramBoolean, parambdo, paramk);
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
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
                                                tKz.postValue(parambdo);
                                                AppMethodBeat.o(178189);
                                                return;
                                                if (paramString.equals("finder_wx_private_msg_entrance"))
                                                {
                                                  tKH.postValue(parambdo);
                                                  AppMethodBeat.o(178189);
                                                  return;
                                                  if (paramString.equals("FinderSelfRedPack"))
                                                  {
                                                    tKL.postValue(parambdo);
                                                    AppMethodBeat.o(178189);
                                                    return;
                                                    if (paramString.equals("NearbyPeopleTab"))
                                                    {
                                                      tKP.postValue(parambdo);
                                                      AppMethodBeat.o(178189);
                                                      return;
                                                      if (paramString.equals("TLRecommendTab"))
                                                      {
                                                        tKC.postValue(parambdo);
                                                        AppMethodBeat.o(178189);
                                                        return;
                                                        if (paramString.equals("TLWxPrivateMsgBubble"))
                                                        {
                                                          tKI.postValue(parambdo);
                                                          AppMethodBeat.o(178189);
                                                          return;
                                                          if (paramString.equals("NearbyEntrance")) {
                                                            tKQ.postValue(parambdo);
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          } while (!paramString.equals("FinderEntrance"));
                                          tKr.postValue(parambdo);
                                          AppMethodBeat.o(178189);
                                          return;
                                        } while (!paramString.equals("NearbyLiveTab"));
                                        tKO.postValue(parambdo);
                                        AppMethodBeat.o(178189);
                                        return;
                                      } while (!paramString.equals("TLPostCamera"));
                                      tKt.postValue(parambdo);
                                      AppMethodBeat.o(178189);
                                      return;
                                    } while (!paramString.equals("finder_tl_hot_tab"));
                                    tKE.postValue(parambdo);
                                    AppMethodBeat.o(178189);
                                    return;
                                  } while (!paramString.equals("finder_private_msg_entrance"));
                                  tKG.postValue(parambdo);
                                  AppMethodBeat.o(178189);
                                  return;
                                } while (!paramString.equals("ProfileEntrance"));
                                tKv.postValue(parambdo);
                                AppMethodBeat.o(178189);
                                return;
                              } while (!paramString.equals("TLCamera"));
                              tKs.postValue(parambdo);
                              AppMethodBeat.o(178189);
                              return;
                            } while (!paramString.equals("Discovery"));
                            tKq.postValue(parambdo);
                            AppMethodBeat.o(178189);
                            return;
                          } while (!paramString.equals("AuthorProfileFans"));
                          tKw.postValue(parambdo);
                          AppMethodBeat.o(178189);
                          return;
                        } while (!paramString.equals("FinderSetting"));
                        tKA.postValue(parambdo);
                        AppMethodBeat.o(178189);
                        return;
                      } while (!paramString.equals("Personal_Center_FavList_Entrance"));
                      tKD.postValue(parambdo);
                      AppMethodBeat.o(178189);
                      return;
                    } while (!paramString.equals("FinderMyTabRedPack"));
                    tKM.postValue(parambdo);
                    AppMethodBeat.o(178189);
                    return;
                  } while (!paramString.equals("TLPersonalCenter"));
                  tKy.postValue(parambdo);
                  AppMethodBeat.o(178189);
                  return;
                } while (!paramString.equals("NearbyFeedTab"));
                tKN.postValue(parambdo);
                AppMethodBeat.o(178189);
                return;
              } while (!paramString.equals("CreatorCenter"));
              tKK.postValue(parambdo);
              AppMethodBeat.o(178189);
              return;
            } while (!paramString.equals("FinderSelfLiveEntrance"));
            tKJ.postValue(parambdo);
            AppMethodBeat.o(178189);
            return;
          } while (!paramString.equals("TLFollow"));
          tKB.postValue(parambdo);
          AppMethodBeat.o(178189);
          return;
        } while (!paramString.equals("AuthorProfileNotify"));
        tKx.postValue(parambdo);
        AppMethodBeat.o(178189);
        return;
      } while (!paramString.equals("finder_tl_nearby_tab"));
      tKF.postValue(parambdo);
      AppMethodBeat.o(178189);
      return;
    } while (!paramString.equals("TLWxBubble"));
    tKu.postValue(parambdo);
    AppMethodBeat.o(178189);
  }
  
  public static MutableLiveData<a> daJ()
  {
    return tKq;
  }
  
  public static MutableLiveData<a> daK()
  {
    return tKr;
  }
  
  public static MutableLiveData<a> daL()
  {
    return tKs;
  }
  
  public static MutableLiveData<a> daM()
  {
    return tKv;
  }
  
  public static MutableLiveData<a> daN()
  {
    return tKy;
  }
  
  public static MutableLiveData<a> daO()
  {
    return tKz;
  }
  
  public static MutableLiveData<a> daP()
  {
    return tKA;
  }
  
  public static MutableLiveData<a> daQ()
  {
    return tKB;
  }
  
  public static MutableLiveData<a> daR()
  {
    return tKC;
  }
  
  public static MutableLiveData<a> daS()
  {
    return tKD;
  }
  
  public static MutableLiveData<a> daT()
  {
    return tKE;
  }
  
  public static MutableLiveData<a> daU()
  {
    return tKF;
  }
  
  public static MutableLiveData<a> daV()
  {
    return tKG;
  }
  
  public static MutableLiveData<a> daW()
  {
    return tKH;
  }
  
  public static MutableLiveData<a> daX()
  {
    return tKI;
  }
  
  public static MutableLiveData<a> daY()
  {
    return tKJ;
  }
  
  public static MutableLiveData<a> daZ()
  {
    return tKK;
  }
  
  public static MutableLiveData<a> dba()
  {
    return tKL;
  }
  
  public static MutableLiveData<a> dbb()
  {
    return tKM;
  }
  
  public static MutableLiveData<a> dbc()
  {
    return tKN;
  }
  
  public static MutableLiveData<a> dbd()
  {
    return tKO;
  }
  
  public static MutableLiveData<a> dbe()
  {
    return tKP;
  }
  
  public static MutableLiveData<a> dbf()
  {
    return tKQ;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "", "isShow", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "(ZLcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;)V", "getCtrInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public final boolean dEF;
    public bdo tKS;
    public final k tKT;
    
    public a(boolean paramBoolean, bdo parambdo, k paramk)
    {
      this.dEF = paramBoolean;
      this.tKS = parambdo;
      this.tKT = paramk;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(178187);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.dEF != paramObject.dEF) || (!p.j(this.tKS, paramObject.tKS)) || (!p.j(this.tKT, paramObject.tKT))) {}
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
      Object localObject1 = this.tKT;
      if (localObject1 != null)
      {
        localObject1 = ((k)localObject1).field_tipsId;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" type=");
        localObject1 = this.tKT;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = ((k)localObject1).field_ctrInfo;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = Integer.valueOf(((bbi)localObject1).type);
        label68:
        localStringBuilder = localStringBuilder.append(localObject1).append(" isShow=").append(this.dEF).append(" path=");
        localObject1 = this.tKS;
        if (localObject1 == null) {
          break label189;
        }
        localObject1 = ((bdo)localObject1).path;
        label105:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" showType=");
        localObject1 = this.tKS;
        if (localObject1 == null) {
          break label194;
        }
      }
      label184:
      label189:
      label194:
      for (localObject1 = Integer.valueOf(((bdo)localObject1).xGz);; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append(" title=");
        bdo localbdo = this.tKS;
        localObject1 = localObject2;
        if (localbdo != null) {
          localObject1 = localbdo.title;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(MutableLiveData paramMutableLiveData, Observer paramObserver)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(MutableLiveData paramMutableLiveData, LifecycleOwner paramLifecycleOwner, Observer paramObserver)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.h
 * JD-Core Version:    0.7.0.1
 */