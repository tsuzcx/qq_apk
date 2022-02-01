package com.tencent.mm.plugin.finder.extension.reddot;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier;", "", "()V", "TAG", "", "discoveryTab", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getDiscoveryTab", "()Landroidx/lifecycle/MutableLiveData;", "finderAuthorProfileFans", "getFinderAuthorProfileFans", "finderAuthorProfileNotify", "getFinderAuthorProfileNotify", "finderCreateFinderEntrance", "getFinderCreateFinderEntrance", "finderCreatorEntrance", "getFinderCreatorEntrance", "finderEntrance", "getFinderEntrance", "finderFirstFav", "getFinderFirstFav", "finderLiveEntrance", "getFinderLiveEntrance", "finderLiveForFindPageEntrance", "getFinderLiveForFindPageEntrance", "finderLiveInComeEntrance", "getFinderLiveInComeEntrance", "finderMessage", "getFinderMessage", "finderOriginalEntrance", "getFinderOriginalEntrance", "finderPosterEntrace", "getFinderPosterEntrace", "finderProfileEntrance", "getFinderProfileEntrance", "finderProfileSetting", "getFinderProfileSetting", "finderProfileTop", "getFinderProfileTop", "finderSettingLiveTask", "getFinderSettingLiveTask", "finderTlCamera", "getFinderTlCamera", "finderTlPersonalCenter", "getFinderTlPersonalCenter", "finderTlPostCamera", "getFinderTlPostCamera", "finderTlTabFollow", "getFinderTlTabFollow", "finderTlTabFriend", "getFinderTlTabFriend", "finderTlTabLbs", "getFinderTlTabLbs", "finderTlTabMachine", "getFinderTlTabMachine", "finderTlWxBubble", "getFinderTlWxBubble", "finderTlWxMessageBubble", "getFinderTlWxMessageBubble", "finderWxMessage", "getFinderWxMessage", "nearbyEntrance", "getNearbyEntrance", "nearbyTabFeed", "getNearbyTabFeed", "nearbyTabLive", "getNearbyTabLive", "nearbyTabPeople", "getNearbyTabPeople", "checkPathAndNotify", "", "path", "notify", "isShow", "", "tipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "Result", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l ARA;
  private static final x<a> ARB;
  private static final x<a> ARC;
  private static final x<a> ARD;
  private static final x<a> ARE;
  private static final x<a> ARF;
  private static final x<a> ARG;
  private static final x<a> ARH;
  private static final x<a> ARI;
  private static final x<a> ARJ;
  private static final x<a> ARK;
  private static final x<a> ARL;
  private static final x<a> ARM;
  private static final x<a> ARN;
  private static final x<a> ARO;
  private static final x<a> ARP;
  private static final x<a> ARQ;
  private static final x<a> ARR;
  private static final x<a> ARS;
  private static final x<a> ART;
  private static final x<a> ARU;
  private static final x<a> ARV;
  private static final x<a> ARW;
  private static final x<a> ARX;
  private static final x<a> ARY;
  private static final x<a> ARZ;
  private static final x<a> ASa;
  private static final x<a> ASb;
  private static final x<a> ASc;
  private static final x<a> ASd;
  private static final x<a> ASe;
  private static final x<a> ASf;
  
  static
  {
    AppMethodBeat.i(178190);
    ARA = new l();
    ARB = new x();
    ARC = new x();
    ARD = new x();
    ARE = new x();
    ARF = new x();
    ARG = new x();
    ARH = new x();
    ARI = new x();
    ARJ = new x();
    ARK = new x();
    ARL = new x();
    ARM = new x();
    ARN = new x();
    ARO = new x();
    ARP = new x();
    ARQ = new x();
    ARR = new x();
    ARS = new x();
    ART = new x();
    ARU = new x();
    ARV = new x();
    ARW = new x();
    ARX = new x();
    ARY = new x();
    ARZ = new x();
    ASa = new x();
    ASb = new x();
    ASc = new x();
    ASd = new x();
    ASe = new x();
    ASf = new x();
    AppMethodBeat.o(178190);
  }
  
  public static void a(boolean paramBoolean, String paramString, bxq parambxq, p paramp)
  {
    Object localObject2 = null;
    AppMethodBeat.i(178189);
    s.u(paramString, "path");
    StringBuilder localStringBuilder = new StringBuilder("[notify] tipsId=");
    if (paramp == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" isShow=").append(paramBoolean).append(" path=").append(paramString).append(" show_type=");
      if (parambxq != null) {
        break label255;
      }
      localObject1 = null;
      label71:
      localStringBuilder = localStringBuilder.append(localObject1).append(" count=");
      if (parambxq != null) {
        break label267;
      }
      localObject1 = null;
      label92:
      localStringBuilder = localStringBuilder.append(localObject1).append(" title=");
      if (parambxq != null) {
        break label279;
      }
      localObject1 = null;
      label113:
      localStringBuilder = localStringBuilder.append(localObject1).append(" clear_type=");
      if (parambxq != null) {
        break label288;
      }
      localObject1 = null;
      label134:
      localStringBuilder = localStringBuilder.append(localObject1).append(" parent=");
      if (parambxq != null) {
        break label300;
      }
      localObject1 = null;
      label155:
      localStringBuilder = localStringBuilder.append(localObject1).append(" icon=");
      if (parambxq != null) {
        break label309;
      }
    }
    label267:
    label279:
    label288:
    label300:
    label309:
    for (Object localObject1 = null;; localObject1 = parambxq.icon_url)
    {
      Log.i("Finder.RedDotNotifier", localObject1);
      if (((cn)h.az(cn.class)).getRedDotManager() != null) {
        break label318;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotManager");
      AppMethodBeat.o(178189);
      throw paramString;
      localObject1 = paramp.field_ctrInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((btw)localObject1).ZYN;
      break;
      label255:
      localObject1 = Integer.valueOf(parambxq.show_type);
      break label71;
      localObject1 = Integer.valueOf(parambxq.count);
      break label92;
      localObject1 = parambxq.title;
      break label113;
      localObject1 = Integer.valueOf(parambxq.aagq);
      break label134;
      localObject1 = parambxq.Nnp;
      break label155;
    }
    label318:
    if ((paramBoolean) && (((bw)h.ax(bw.class)).eZE()))
    {
      if (paramp == null) {}
      for (localObject1 = localObject2; !i.p((Integer)localObject1); localObject1 = Integer.valueOf(paramp.field_ctrInfo.type))
      {
        Log.i("Finder.RedDotManager", "[notify] 青少年模式且只看关注的模式下只notify关注的红点展示");
        AppMethodBeat.o(178189);
        return;
      }
    }
    parambxq = new a(paramBoolean, parambxq, paramp);
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(178189);
      return;
      if (!paramString.equals("OriginalEntrance"))
      {
        AppMethodBeat.o(178189);
        return;
        if (!paramString.equals("finder_wx_private_msg_entrance"))
        {
          AppMethodBeat.o(178189);
          return;
          if (paramString.equals("FinderProfileBanner")) {
            break label1461;
          }
          AppMethodBeat.o(178189);
          return;
          if (paramString.equals("NearbyPeopleTab")) {
            break label1500;
          }
          AppMethodBeat.o(178189);
          return;
          if (paramString.equals("TLRecommendTab")) {
            break label1383;
          }
          AppMethodBeat.o(178189);
          return;
          if (!paramString.equals("TLWxPrivateMsgBubble"))
          {
            AppMethodBeat.o(178189);
            return;
            if (paramString.equals("NearbyEntrance")) {
              break label1513;
            }
            AppMethodBeat.o(178189);
            return;
            if (!paramString.equals("FinderEntrance"))
            {
              AppMethodBeat.o(178189);
              return;
              if (paramString.equals("NearbyLiveTab")) {
                break label1487;
              }
              AppMethodBeat.o(178189);
              return;
              if (paramString.equals("TLPostCamera")) {
                break label1214;
              }
              AppMethodBeat.o(178189);
              return;
              if (paramString.equals("finder_tl_hot_tab")) {
                break label1396;
              }
              AppMethodBeat.o(178189);
              return;
              if (paramString.equals("FinderLiveEntrance")) {
                break label1526;
              }
              AppMethodBeat.o(178189);
              return;
              if (paramString.equals("FinderLiveIncomeEntrance")) {
                break label1539;
              }
              AppMethodBeat.o(178189);
              return;
              if (paramString.equals("finder_private_msg_entrance")) {
                break label1227;
              }
              AppMethodBeat.o(178189);
              return;
              if (paramString.equals("ProfileEntrance")) {
                break label1279;
              }
              AppMethodBeat.o(178189);
              return;
              if (!paramString.equals("TLCamera"))
              {
                AppMethodBeat.o(178189);
                return;
                if (!paramString.equals("Discovery"))
                {
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("AuthorProfileFans")) {
                    break label1305;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("FinderSetting")) {
                    break label1344;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("Personal_Center_FavList_Entrance")) {
                    break label1422;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("CreateFinderEntrance")) {
                    break label1448;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("TLPersonalCenter")) {
                    break label1266;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("NearbyFeedTab")) {
                    break label1474;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("CreatorCenter")) {
                    break label1435;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("FinderSelfLiveEntrance")) {
                    break label1331;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("TLFollow")) {
                    break label1370;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("AuthorProfileNotify")) {
                    break label1292;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("FinderPosterEntrance")) {
                    break label1357;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("FinderSettingLiveTask")) {
                    break label1552;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (paramString.equals("finder_tl_nearby_tab")) {
                    break label1409;
                  }
                  AppMethodBeat.o(178189);
                  return;
                  if (!paramString.equals("TLWxBubble")) {
                    AppMethodBeat.o(178189);
                  }
                }
                else
                {
                  ARB.t(parambxq);
                  AppMethodBeat.o(178189);
                  return;
                }
                ARF.t(parambxq);
                AppMethodBeat.o(178189);
              }
            }
            else
            {
              ARC.t(parambxq);
              AppMethodBeat.o(178189);
              return;
            }
            ARD.t(parambxq);
            AppMethodBeat.o(178189);
            return;
            label1214:
            ARE.t(parambxq);
            AppMethodBeat.o(178189);
            return;
            label1227:
            ARR.t(parambxq);
            AppMethodBeat.o(178189);
          }
        }
        else
        {
          ARS.t(parambxq);
          AppMethodBeat.o(178189);
          return;
        }
        ART.t(parambxq);
        AppMethodBeat.o(178189);
        return;
        label1266:
        ARJ.t(parambxq);
        AppMethodBeat.o(178189);
        return;
        label1279:
        ARG.t(parambxq);
        AppMethodBeat.o(178189);
        return;
        label1292:
        ARI.t(parambxq);
        AppMethodBeat.o(178189);
        return;
        label1305:
        ARH.t(parambxq);
        AppMethodBeat.o(178189);
      }
      else
      {
        ARK.t(parambxq);
        AppMethodBeat.o(178189);
        return;
      }
      label1331:
      ARU.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1344:
      ARL.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1357:
      ASf.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1370:
      ARM.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1383:
      ARN.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1396:
      ARP.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1409:
      ARQ.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1422:
      ARO.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1435:
      ARV.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1448:
      ARW.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1461:
      ARX.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1474:
      ARY.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1487:
      ARZ.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1500:
      ASa.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1513:
      ASc.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1526:
      ASb.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1539:
      ASd.t(parambxq);
      AppMethodBeat.o(178189);
      return;
      label1552:
      ASe.t(parambxq);
    }
  }
  
  public static void avu(String paramString)
  {
    AppMethodBeat.i(366919);
    s.u(paramString, "path");
    p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su(paramString);
    if (localp != null)
    {
      bxq localbxq = localp.avK(paramString);
      if (localbxq != null)
      {
        a(true, paramString, localbxq, localp);
        AppMethodBeat.o(366919);
        return;
      }
      a(false, paramString, null, localp);
      AppMethodBeat.o(366919);
      return;
    }
    a(false, paramString, null, null);
    AppMethodBeat.o(366919);
  }
  
  public static x<a> dZB()
  {
    return ARB;
  }
  
  public static x<a> dZC()
  {
    return ARC;
  }
  
  public static x<a> dZD()
  {
    return ARD;
  }
  
  public static x<a> dZE()
  {
    return ARG;
  }
  
  public static x<a> dZF()
  {
    return ARJ;
  }
  
  public static x<a> dZG()
  {
    return ARK;
  }
  
  public static x<a> dZH()
  {
    return ARL;
  }
  
  public static x<a> dZI()
  {
    return ARM;
  }
  
  public static x<a> dZJ()
  {
    return ARN;
  }
  
  public static x<a> dZK()
  {
    return ARO;
  }
  
  public static x<a> dZL()
  {
    return ARP;
  }
  
  public static x<a> dZM()
  {
    return ARQ;
  }
  
  public static x<a> dZN()
  {
    return ARR;
  }
  
  public static x<a> dZO()
  {
    return ARS;
  }
  
  public static x<a> dZP()
  {
    return ART;
  }
  
  public static x<a> dZQ()
  {
    return ARU;
  }
  
  public static x<a> dZR()
  {
    return ARV;
  }
  
  public static x<a> dZS()
  {
    return ARW;
  }
  
  public static x<a> dZT()
  {
    return ARX;
  }
  
  public static x<a> dZU()
  {
    return ARY;
  }
  
  public static x<a> dZV()
  {
    return ARZ;
  }
  
  public static x<a> dZW()
  {
    return ASa;
  }
  
  public static x<a> dZX()
  {
    return ASb;
  }
  
  public static x<a> dZY()
  {
    return ASc;
  }
  
  public static x<a> dZZ()
  {
    return ASd;
  }
  
  public static x<a> eaa()
  {
    return ASe;
  }
  
  public static x<a> eab()
  {
    return ASf;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "", "isShow", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "(ZLcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;)V", "getCtrInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public bxq ASg;
    public final p ASh;
    public final boolean hBY;
    
    public a(boolean paramBoolean, bxq parambxq, p paramp)
    {
      this.hBY = paramBoolean;
      this.ASg = parambxq;
      this.ASh = paramp;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(178187);
      if (this == paramObject)
      {
        AppMethodBeat.o(178187);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(178187);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.hBY != paramObject.hBY)
      {
        AppMethodBeat.o(178187);
        return false;
      }
      if (!s.p(this.ASg, paramObject.ASg))
      {
        AppMethodBeat.o(178187);
        return false;
      }
      if (!s.p(this.ASh, paramObject.ASh))
      {
        AppMethodBeat.o(178187);
        return false;
      }
      AppMethodBeat.o(178187);
      return true;
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
      Object localObject1 = this.ASh;
      if (localObject1 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(" type=");
        localObject1 = this.ASh;
        if (localObject1 != null) {
          break label152;
        }
        localObject1 = null;
        label50:
        localStringBuilder = localStringBuilder.append(localObject1).append(" isShow=").append(this.hBY).append(" path=");
        localObject1 = this.ASg;
        if (localObject1 != null) {
          break label177;
        }
        localObject1 = null;
        label84:
        localStringBuilder = localStringBuilder.append(localObject1).append(" showType=");
        localObject1 = this.ASg;
        if (localObject1 != null) {
          break label185;
        }
        localObject1 = null;
        label106:
        localStringBuilder = localStringBuilder.append(localObject1).append(" title=");
        localObject1 = this.ASg;
        if (localObject1 != null) {
          break label196;
        }
      }
      label152:
      label177:
      label185:
      label196:
      for (localObject1 = localObject2;; localObject1 = ((bxq)localObject1).title)
      {
        localObject1 = localObject1;
        AppMethodBeat.o(178185);
        return localObject1;
        localObject1 = ((p)localObject1).field_tipsId;
        break;
        localObject1 = ((p)localObject1).field_ctrInfo;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label50;
        }
        localObject1 = Integer.valueOf(((btw)localObject1).type);
        break label50;
        localObject1 = ((bxq)localObject1).path;
        break label84;
        localObject1 = Integer.valueOf(((bxq)localObject1).show_type);
        break label106;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.l
 * JD-Core Version:    0.7.0.1
 */