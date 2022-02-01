package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier;", "", "()V", "TAG", "", "discoveryTab", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getDiscoveryTab", "()Landroid/arch/lifecycle/MutableLiveData;", "finderAuthorProfileFans", "getFinderAuthorProfileFans", "finderAuthorProfileNotify", "getFinderAuthorProfileNotify", "finderEntrance", "getFinderEntrance", "finderFirstFav", "getFinderFirstFav", "finderOriginalEntrance", "getFinderOriginalEntrance", "finderProfileEntrance", "getFinderProfileEntrance", "finderProfileSetting", "getFinderProfileSetting", "finderTlCamera", "getFinderTlCamera", "finderTlPersonalCenter", "getFinderTlPersonalCenter", "finderTlTabFollow", "getFinderTlTabFollow", "finderTlTabFriend", "getFinderTlTabFriend", "finderTlTabLbs", "getFinderTlTabLbs", "finderTlTabMachine", "getFinderTlTabMachine", "finderTlWxBubble", "getFinderTlWxBubble", "notify", "", "isShow", "", "path", "tipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "observeForeverWithNotify", "T", "observer", "Landroid/arch/lifecycle/Observer;", "observeWithNotify", "owner", "Landroid/arch/lifecycle/LifecycleOwner;", "Result", "plugin-finder_release"})
public final class d
{
  private static final MutableLiveData<a> KMB;
  private static final MutableLiveData<a> KMC;
  private static final MutableLiveData<a> KMD;
  private static final MutableLiveData<a> KME;
  private static final MutableLiveData<a> KMF;
  private static final MutableLiveData<a> KMG;
  private static final MutableLiveData<a> KMH;
  private static final MutableLiveData<a> qtA;
  private static final MutableLiveData<a> qtB;
  private static final MutableLiveData<a> qtC;
  private static final MutableLiveData<a> qtD;
  private static final MutableLiveData<a> qtE;
  private static final MutableLiveData<a> qtF;
  public static final d qtG;
  private static final MutableLiveData<a> qty;
  private static final MutableLiveData<a> qtz;
  
  static
  {
    AppMethodBeat.i(178190);
    qtG = new d();
    qty = new MutableLiveData();
    qtz = new MutableLiveData();
    qtA = new MutableLiveData();
    qtB = new MutableLiveData();
    qtC = new MutableLiveData();
    qtD = new MutableLiveData();
    qtE = new MutableLiveData();
    qtF = new MutableLiveData();
    KMB = new MutableLiveData();
    KMC = new MutableLiveData();
    KMD = new MutableLiveData();
    KME = new MutableLiveData();
    KMF = new MutableLiveData();
    KMG = new MutableLiveData();
    KMH = new MutableLiveData();
    AppMethodBeat.o(178190);
  }
  
  public static <T> void a(MutableLiveData<T> paramMutableLiveData, LifecycleOwner paramLifecycleOwner, final Observer<T> paramObserver)
  {
    AppMethodBeat.i(178188);
    k.h(paramMutableLiveData, "$this$observeWithNotify");
    k.h(paramLifecycleOwner, "owner");
    k.h(paramObserver, "observer");
    paramMutableLiveData.observe(paramLifecycleOwner, paramObserver);
    h.Iye.aN((Runnable)new b(paramMutableLiveData, paramObserver));
    AppMethodBeat.o(178188);
  }
  
  public static void a(boolean paramBoolean, String paramString, aln paramaln, f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(178189);
    k.h(paramString, "path");
    StringBuilder localStringBuilder = new StringBuilder("[notify] isShow=").append(paramBoolean).append(" path=").append(paramString).append(" show_type=");
    Object localObject1;
    if (paramaln != null)
    {
      localObject1 = Integer.valueOf(paramaln.rXs);
      localStringBuilder = localStringBuilder.append(localObject1).append(" count=");
      if (paramaln == null) {
        break label364;
      }
      localObject1 = Integer.valueOf(paramaln.count);
      label83:
      localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("title=");
      if (paramaln == null) {
        break label370;
      }
      localObject1 = paramaln.title;
      label112:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" clear_type=");
      if (paramaln == null) {
        break label376;
      }
      localObject1 = Integer.valueOf(paramaln.DmL);
      label139:
      localStringBuilder = localStringBuilder.append(localObject1).append(" parent=");
      if (paramaln == null) {
        break label382;
      }
      localObject1 = paramaln.uOH;
      label163:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" icon=");
      localObject1 = localObject2;
      if (paramaln != null) {
        localObject1 = paramaln.odo;
      }
      ad.i("Finder.RedDotNotifier", (String)localObject1);
      paramaln = new a(paramBoolean, paramaln, paramf);
      switch (paramString.hashCode())
      {
      }
    }
    label364:
    label370:
    label376:
    label382:
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
                                localObject1 = null;
                                break;
                                localObject1 = null;
                                break label83;
                                localObject1 = null;
                                break label112;
                                localObject1 = null;
                                break label139;
                                localObject1 = null;
                                break label163;
                                if (paramString.equals("ProfileEntrance"))
                                {
                                  qtC.postValue(paramaln);
                                  AppMethodBeat.o(178189);
                                  return;
                                  if (paramString.equals("FinderFirstFav")) {
                                    KMF.postValue(paramaln);
                                  }
                                }
                              }
                            } while (!paramString.equals("OriginalEntrance"));
                            KMB.postValue(paramaln);
                            AppMethodBeat.o(178189);
                            return;
                          } while (!paramString.equals("TLCamera"));
                          qtA.postValue(paramaln);
                          AppMethodBeat.o(178189);
                          return;
                        } while (!paramString.equals("Discovery"));
                        qty.postValue(paramaln);
                        AppMethodBeat.o(178189);
                        return;
                      } while (!paramString.equals("AuthorProfileFans"));
                      qtD.postValue(paramaln);
                      AppMethodBeat.o(178189);
                      return;
                    } while (!paramString.equals("FinderSetting"));
                    KMC.postValue(paramaln);
                    AppMethodBeat.o(178189);
                    return;
                  } while (!paramString.equals("TLPersonalCenter"));
                  qtF.postValue(paramaln);
                  AppMethodBeat.o(178189);
                  return;
                } while (!paramString.equals("TLRecommendTab"));
                KME.postValue(paramaln);
                AppMethodBeat.o(178189);
                return;
              } while (!paramString.equals("TLFollow"));
              KMD.postValue(paramaln);
              AppMethodBeat.o(178189);
              return;
            } while (!paramString.equals("TLLbsTab"));
            KMH.postValue(paramaln);
            AppMethodBeat.o(178189);
            return;
          } while (!paramString.equals("FinderEntrance"));
          qtz.postValue(paramaln);
          AppMethodBeat.o(178189);
          return;
        } while (!paramString.equals("AuthorProfileNotify"));
        qtE.postValue(paramaln);
        AppMethodBeat.o(178189);
        return;
      } while (!paramString.equals("TLMachineTab"));
      KMG.postValue(paramaln);
      AppMethodBeat.o(178189);
      return;
    } while (!paramString.equals("TLWxBubble"));
    qtB.postValue(paramaln);
    AppMethodBeat.o(178189);
  }
  
  public static MutableLiveData<a> clp()
  {
    return qty;
  }
  
  public static MutableLiveData<a> clq()
  {
    return qtz;
  }
  
  public static MutableLiveData<a> clr()
  {
    return qtA;
  }
  
  public static MutableLiveData<a> cls()
  {
    return qtF;
  }
  
  public static MutableLiveData<a> fSL()
  {
    return KMC;
  }
  
  public static MutableLiveData<a> fSM()
  {
    return KMD;
  }
  
  public static MutableLiveData<a> fSN()
  {
    return KME;
  }
  
  public static MutableLiveData<a> fSO()
  {
    return KMF;
  }
  
  public static MutableLiveData<a> fSP()
  {
    return KMG;
  }
  
  public static MutableLiveData<a> fSQ()
  {
    return KMH;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "", "isShow", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "(ZLcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;)V", "getCtrInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public final boolean ddw;
    public aln qtH;
    public final f qtI;
    
    public a(boolean paramBoolean, aln paramaln, f paramf)
    {
      this.ddw = paramBoolean;
      this.qtH = paramaln;
      this.qtI = paramf;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(178187);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.ddw != paramObject.ddw) || (!k.g(this.qtH, paramObject.qtH)) || (!k.g(this.qtI, paramObject.qtI))) {}
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
      Object localObject1 = this.qtI;
      if (localObject1 != null)
      {
        localObject1 = ((f)localObject1).field_tipsId;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" type=");
        localObject1 = this.qtI;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = ((f)localObject1).field_ctrInfo;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = Integer.valueOf(((akv)localObject1).type);
        label68:
        localStringBuilder = localStringBuilder.append(localObject1).append(" isShow=").append(this.ddw).append(" path=");
        localObject1 = this.qtH;
        if (localObject1 == null) {
          break label189;
        }
        localObject1 = ((aln)localObject1).path;
        label105:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" showType=");
        localObject1 = this.qtH;
        if (localObject1 == null) {
          break label194;
        }
      }
      label184:
      label189:
      label194:
      for (localObject1 = Integer.valueOf(((aln)localObject1).rXs);; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append(" title=");
        aln localaln = this.qtH;
        localObject1 = localObject2;
        if (localaln != null) {
          localObject1 = localaln.title;
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "run"})
  static final class b
    implements Runnable
  {
    b(MutableLiveData paramMutableLiveData, Observer paramObserver) {}
    
    public final void run()
    {
      AppMethodBeat.i(197589);
      Object localObject = this.KMI.getValue();
      if (localObject != null)
      {
        ad.i("Finder.RedDotNotifier", "value=" + this.KMI.getValue() + " observer=" + paramObserver.getClass().getSimpleName());
        paramObserver.onChanged(localObject);
        AppMethodBeat.o(197589);
        return;
      }
      AppMethodBeat.o(197589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.d
 * JD-Core Version:    0.7.0.1
 */