package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier;", "", "()V", "TAG", "", "discoveryTab", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getDiscoveryTab", "()Landroid/arch/lifecycle/MutableLiveData;", "finderAuthorProfileFans", "getFinderAuthorProfileFans", "finderAuthorProfileNotify", "getFinderAuthorProfileNotify", "finderEntrance", "getFinderEntrance", "finderFirstFav", "getFinderFirstFav", "finderMessage", "getFinderMessage", "finderOriginalEntrance", "getFinderOriginalEntrance", "finderProfileEntrance", "getFinderProfileEntrance", "finderProfileSetting", "getFinderProfileSetting", "finderTlCamera", "getFinderTlCamera", "finderTlPersonalCenter", "getFinderTlPersonalCenter", "finderTlTabFollow", "getFinderTlTabFollow", "finderTlTabFriend", "getFinderTlTabFriend", "finderTlTabLbs", "getFinderTlTabLbs", "finderTlTabMachine", "getFinderTlTabMachine", "finderTlWxBubble", "getFinderTlWxBubble", "finderTlWxMessageBubble", "getFinderTlWxMessageBubble", "finderWxMessage", "getFinderWxMessage", "notify", "", "isShow", "", "path", "tipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "observeForeverWithNotify", "T", "observer", "Landroid/arch/lifecycle/Observer;", "observeWithNotify", "owner", "Landroid/arch/lifecycle/LifecycleOwner;", "Result", "plugin-finder_release"})
public final class g
{
  private static final MutableLiveData<a> rSC;
  private static final MutableLiveData<a> rSD;
  private static final MutableLiveData<a> rSE;
  private static final MutableLiveData<a> rSF;
  private static final MutableLiveData<a> rSG;
  private static final MutableLiveData<a> rSH;
  private static final MutableLiveData<a> rSI;
  private static final MutableLiveData<a> rSJ;
  private static final MutableLiveData<a> rSK;
  private static final MutableLiveData<a> rSL;
  private static final MutableLiveData<a> rSM;
  private static final MutableLiveData<a> rSN;
  private static final MutableLiveData<a> rSO;
  private static final MutableLiveData<a> rSP;
  private static final MutableLiveData<a> rSQ;
  private static final MutableLiveData<a> rSR;
  private static final MutableLiveData<a> rSS;
  private static final MutableLiveData<a> rST;
  public static final g rSU;
  
  static
  {
    AppMethodBeat.i(178190);
    rSU = new g();
    rSC = new MutableLiveData();
    rSD = new MutableLiveData();
    rSE = new MutableLiveData();
    rSF = new MutableLiveData();
    rSG = new MutableLiveData();
    rSH = new MutableLiveData();
    rSI = new MutableLiveData();
    rSJ = new MutableLiveData();
    rSK = new MutableLiveData();
    rSL = new MutableLiveData();
    rSM = new MutableLiveData();
    rSN = new MutableLiveData();
    rSO = new MutableLiveData();
    rSP = new MutableLiveData();
    rSQ = new MutableLiveData();
    rSR = new MutableLiveData();
    rSS = new MutableLiveData();
    rST = new MutableLiveData();
    AppMethodBeat.o(178190);
  }
  
  public static <T> void a(MutableLiveData<T> paramMutableLiveData, final LifecycleOwner paramLifecycleOwner, final Observer<T> paramObserver)
  {
    AppMethodBeat.i(178188);
    p.h(paramMutableLiveData, "$this$observeWithNotify");
    p.h(paramLifecycleOwner, "owner");
    p.h(paramObserver, "observer");
    paramMutableLiveData.observe(paramLifecycleOwner, paramObserver);
    h.LTJ.aP((Runnable)new c(paramMutableLiveData, paramObserver, paramLifecycleOwner));
    AppMethodBeat.o(178188);
  }
  
  public static <T> void a(MutableLiveData<T> paramMutableLiveData, final Observer<T> paramObserver)
  {
    AppMethodBeat.i(201650);
    p.h(paramMutableLiveData, "$this$observeForeverWithNotify");
    p.h(paramObserver, "observer");
    paramMutableLiveData.observeForever(paramObserver);
    h.LTJ.aP((Runnable)new b(paramMutableLiveData, paramObserver));
    AppMethodBeat.o(201650);
  }
  
  public static void a(boolean paramBoolean, String paramString, ase paramase, i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(178189);
    p.h(paramString, "path");
    StringBuilder localStringBuilder = new StringBuilder("[notify] isShow=").append(paramBoolean).append(" path=").append(paramString).append(" show_type=");
    Object localObject1;
    if (paramase != null)
    {
      localObject1 = Integer.valueOf(paramase.uda);
      localStringBuilder = localStringBuilder.append(localObject1).append(" count=");
      if (paramase == null) {
        break label392;
      }
      localObject1 = Integer.valueOf(paramase.count);
      label83:
      localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("title=");
      if (paramase == null) {
        break label398;
      }
      localObject1 = paramase.title;
      label112:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" clear_type=");
      if (paramase == null) {
        break label404;
      }
      localObject1 = Integer.valueOf(paramase.Gqr);
      label139:
      localStringBuilder = localStringBuilder.append(localObject1).append(" parent=");
      if (paramase == null) {
        break label410;
      }
      localObject1 = paramase.xfl;
      label164:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" icon=");
      localObject1 = localObject2;
      if (paramase != null) {
        localObject1 = paramase.pkr;
      }
      ad.i("Finder.RedDotNotifier", (String)localObject1);
      paramase = new a(paramBoolean, paramase, parami);
      switch (paramString.hashCode())
      {
      }
    }
    label392:
    label398:
    label404:
    label410:
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
                                    localObject1 = null;
                                    break;
                                    localObject1 = null;
                                    break label83;
                                    localObject1 = null;
                                    break label112;
                                    localObject1 = null;
                                    break label139;
                                    localObject1 = null;
                                    break label164;
                                    if (paramString.equals("finder_private_msg_entrance"))
                                    {
                                      rSR.postValue(paramase);
                                      AppMethodBeat.o(178189);
                                      return;
                                      if (paramString.equals("ProfileEntrance"))
                                      {
                                        rSG.postValue(paramase);
                                        AppMethodBeat.o(178189);
                                        return;
                                        if (paramString.equals("FinderFirstFav")) {
                                          rSO.postValue(paramase);
                                        }
                                      }
                                    }
                                  }
                                } while (!paramString.equals("OriginalEntrance"));
                                rSK.postValue(paramase);
                                AppMethodBeat.o(178189);
                                return;
                              } while (!paramString.equals("TLCamera"));
                              rSE.postValue(paramase);
                              AppMethodBeat.o(178189);
                              return;
                            } while (!paramString.equals("Discovery"));
                            rSC.postValue(paramase);
                            AppMethodBeat.o(178189);
                            return;
                          } while (!paramString.equals("AuthorProfileFans"));
                          rSH.postValue(paramase);
                          AppMethodBeat.o(178189);
                          return;
                        } while (!paramString.equals("FinderSetting"));
                        rSL.postValue(paramase);
                        AppMethodBeat.o(178189);
                        return;
                      } while (!paramString.equals("finder_wx_private_msg_entrance"));
                      rSS.postValue(paramase);
                      AppMethodBeat.o(178189);
                      return;
                    } while (!paramString.equals("TLPersonalCenter"));
                    rSJ.postValue(paramase);
                    AppMethodBeat.o(178189);
                    return;
                  } while (!paramString.equals("TLRecommendTab"));
                  rSN.postValue(paramase);
                  AppMethodBeat.o(178189);
                  return;
                } while (!paramString.equals("TLWxPrivateMsgBubble"));
                rST.postValue(paramase);
                AppMethodBeat.o(178189);
                return;
              } while (!paramString.equals("TLFollow"));
              rSM.postValue(paramase);
              AppMethodBeat.o(178189);
              return;
            } while (!paramString.equals("TLLbsTab"));
            rSQ.postValue(paramase);
            AppMethodBeat.o(178189);
            return;
          } while (!paramString.equals("FinderEntrance"));
          rSD.postValue(paramase);
          AppMethodBeat.o(178189);
          return;
        } while (!paramString.equals("AuthorProfileNotify"));
        rSI.postValue(paramase);
        AppMethodBeat.o(178189);
        return;
      } while (!paramString.equals("TLMachineTab"));
      rSP.postValue(paramase);
      AppMethodBeat.o(178189);
      return;
    } while (!paramString.equals("TLWxBubble"));
    rSF.postValue(paramase);
    AppMethodBeat.o(178189);
  }
  
  public static MutableLiveData<a> cAa()
  {
    return rSO;
  }
  
  public static MutableLiveData<a> cAb()
  {
    return rSP;
  }
  
  public static MutableLiveData<a> cAc()
  {
    return rSQ;
  }
  
  public static MutableLiveData<a> cAd()
  {
    return rSR;
  }
  
  public static MutableLiveData<a> cAe()
  {
    return rSS;
  }
  
  public static MutableLiveData<a> cAf()
  {
    return rST;
  }
  
  public static MutableLiveData<a> czT()
  {
    return rSC;
  }
  
  public static MutableLiveData<a> czU()
  {
    return rSD;
  }
  
  public static MutableLiveData<a> czV()
  {
    return rSE;
  }
  
  public static MutableLiveData<a> czW()
  {
    return rSJ;
  }
  
  public static MutableLiveData<a> czX()
  {
    return rSL;
  }
  
  public static MutableLiveData<a> czY()
  {
    return rSM;
  }
  
  public static MutableLiveData<a> czZ()
  {
    return rSN;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "", "isShow", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "(ZLcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;)V", "getCtrInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public final boolean dmo;
    public ase rSV;
    public final i rSW;
    
    public a(boolean paramBoolean, ase paramase, i parami)
    {
      this.dmo = paramBoolean;
      this.rSV = paramase;
      this.rSW = parami;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(178187);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.dmo != paramObject.dmo) || (!p.i(this.rSV, paramObject.rSV)) || (!p.i(this.rSW, paramObject.rSW))) {}
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
      Object localObject1 = this.rSW;
      if (localObject1 != null)
      {
        localObject1 = ((i)localObject1).field_tipsId;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" type=");
        localObject1 = this.rSW;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = ((i)localObject1).field_ctrInfo;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = Integer.valueOf(((aqu)localObject1).type);
        label68:
        localStringBuilder = localStringBuilder.append(localObject1).append(" isShow=").append(this.dmo).append(" path=");
        localObject1 = this.rSV;
        if (localObject1 == null) {
          break label189;
        }
        localObject1 = ((ase)localObject1).path;
        label105:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" showType=");
        localObject1 = this.rSV;
        if (localObject1 == null) {
          break label194;
        }
      }
      label184:
      label189:
      label194:
      for (localObject1 = Integer.valueOf(((ase)localObject1).uda);; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append(" title=");
        ase localase = this.rSV;
        localObject1 = localObject2;
        if (localase != null) {
          localObject1 = localase.title;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "run"})
  static final class b
    implements Runnable
  {
    b(MutableLiveData paramMutableLiveData, Observer paramObserver) {}
    
    public final void run()
    {
      AppMethodBeat.i(201648);
      Object localObject = this.rSX.getValue();
      if (localObject != null)
      {
        paramObserver.onChanged(localObject);
        AppMethodBeat.o(201648);
        return;
      }
      AppMethodBeat.o(201648);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "run"})
  static final class c
    implements Runnable
  {
    c(MutableLiveData paramMutableLiveData, Observer paramObserver, LifecycleOwner paramLifecycleOwner) {}
    
    public final void run()
    {
      AppMethodBeat.i(201649);
      Object localObject1 = this.rSZ.getValue();
      if (localObject1 != null)
      {
        Object localObject2 = new StringBuilder("value=").append(this.rSZ.getValue()).append(" observer=").append(paramObserver.getClass().getSimpleName()).append(" currentState=");
        Lifecycle localLifecycle = paramLifecycleOwner.getLifecycle();
        p.g(localLifecycle, "owner.lifecycle");
        ad.i("Finder.RedDotNotifier", localLifecycle.getCurrentState());
        localObject2 = paramLifecycleOwner.getLifecycle();
        p.g(localObject2, "owner.lifecycle");
        if (((Lifecycle)localObject2).getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
          paramObserver.onChanged(localObject1);
        }
        AppMethodBeat.o(201649);
        return;
      }
      AppMethodBeat.o(201649);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.g
 * JD-Core Version:    0.7.0.1
 */