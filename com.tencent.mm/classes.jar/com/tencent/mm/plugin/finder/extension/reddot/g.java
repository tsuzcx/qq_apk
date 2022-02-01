package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier;", "", "()V", "TAG", "", "discoveryTab", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getDiscoveryTab", "()Landroid/arch/lifecycle/MutableLiveData;", "finderAuthorProfileFans", "getFinderAuthorProfileFans", "finderAuthorProfileNotify", "getFinderAuthorProfileNotify", "finderEntrance", "getFinderEntrance", "finderFirstFav", "getFinderFirstFav", "finderMessage", "getFinderMessage", "finderOriginalEntrance", "getFinderOriginalEntrance", "finderProfileEntrance", "getFinderProfileEntrance", "finderProfileSetting", "getFinderProfileSetting", "finderTlCamera", "getFinderTlCamera", "finderTlPersonalCenter", "getFinderTlPersonalCenter", "finderTlPostCamera", "getFinderTlPostCamera", "finderTlTabFollow", "getFinderTlTabFollow", "finderTlTabFriend", "getFinderTlTabFriend", "finderTlTabLbs", "getFinderTlTabLbs", "finderTlTabMachine", "getFinderTlTabMachine", "finderTlWxBubble", "getFinderTlWxBubble", "finderTlWxMessageBubble", "getFinderTlWxMessageBubble", "finderWxMessage", "getFinderWxMessage", "notify", "", "isShow", "", "path", "tipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "observeForeverWithNotify", "T", "observer", "Landroid/arch/lifecycle/Observer;", "observeWithNotify", "owner", "Landroid/arch/lifecycle/LifecycleOwner;", "Result", "plugin-finder_release"})
public final class g
{
  private static final MutableLiveData<a> sbd;
  private static final MutableLiveData<a> sbe;
  private static final MutableLiveData<a> sbf;
  private static final MutableLiveData<a> sbg;
  private static final MutableLiveData<a> sbh;
  private static final MutableLiveData<a> sbi;
  private static final MutableLiveData<a> sbj;
  private static final MutableLiveData<a> sbk;
  private static final MutableLiveData<a> sbl;
  private static final MutableLiveData<a> sbm;
  private static final MutableLiveData<a> sbn;
  private static final MutableLiveData<a> sbo;
  private static final MutableLiveData<a> sbp;
  private static final MutableLiveData<a> sbq;
  private static final MutableLiveData<a> sbr;
  private static final MutableLiveData<a> sbs;
  private static final MutableLiveData<a> sbt;
  private static final MutableLiveData<a> sbu;
  private static final MutableLiveData<a> sbv;
  public static final g sbw;
  
  static
  {
    AppMethodBeat.i(178190);
    sbw = new g();
    sbd = new MutableLiveData();
    sbe = new MutableLiveData();
    sbf = new MutableLiveData();
    sbg = new MutableLiveData();
    sbh = new MutableLiveData();
    sbi = new MutableLiveData();
    sbj = new MutableLiveData();
    sbk = new MutableLiveData();
    sbl = new MutableLiveData();
    sbm = new MutableLiveData();
    sbn = new MutableLiveData();
    sbo = new MutableLiveData();
    sbp = new MutableLiveData();
    sbq = new MutableLiveData();
    sbr = new MutableLiveData();
    sbs = new MutableLiveData();
    sbt = new MutableLiveData();
    sbu = new MutableLiveData();
    sbv = new MutableLiveData();
    AppMethodBeat.o(178190);
  }
  
  public static <T> void a(MutableLiveData<T> paramMutableLiveData, final LifecycleOwner paramLifecycleOwner, final Observer<T> paramObserver)
  {
    AppMethodBeat.i(178188);
    p.h(paramMutableLiveData, "$this$observeWithNotify");
    p.h(paramLifecycleOwner, "owner");
    p.h(paramObserver, "observer");
    paramMutableLiveData.observe(paramLifecycleOwner, paramObserver);
    h.MqF.aM((Runnable)new c(paramMutableLiveData, paramObserver, paramLifecycleOwner));
    AppMethodBeat.o(178188);
  }
  
  public static <T> void a(MutableLiveData<T> paramMutableLiveData, final Observer<T> paramObserver)
  {
    AppMethodBeat.i(202099);
    p.h(paramMutableLiveData, "$this$observeForeverWithNotify");
    p.h(paramObserver, "observer");
    paramMutableLiveData.observeForever(paramObserver);
    h.MqF.aM((Runnable)new b(paramMutableLiveData, paramObserver));
    AppMethodBeat.o(202099);
  }
  
  public static void a(boolean paramBoolean, String paramString, ast paramast, i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(178189);
    p.h(paramString, "path");
    StringBuilder localStringBuilder = new StringBuilder("[notify] isShow=").append(paramBoolean).append(" path=").append(paramString).append(" show_type=");
    Object localObject1;
    if (paramast != null)
    {
      localObject1 = Integer.valueOf(paramast.uoi);
      localStringBuilder = localStringBuilder.append(localObject1).append(" count=");
      if (paramast == null) {
        break label400;
      }
      localObject1 = Integer.valueOf(paramast.count);
      label83:
      localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("title=");
      if (paramast == null) {
        break label406;
      }
      localObject1 = paramast.title;
      label112:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" clear_type=");
      if (paramast == null) {
        break label412;
      }
      localObject1 = Integer.valueOf(paramast.GJM);
      label140:
      localStringBuilder = localStringBuilder.append(localObject1).append(" parent=");
      if (paramast == null) {
        break label418;
      }
      localObject1 = paramast.xvd;
      label165:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" icon=");
      localObject1 = localObject2;
      if (paramast != null) {
        localObject1 = paramast.pqW;
      }
      ae.i("Finder.RedDotNotifier", (String)localObject1);
      paramast = new a(paramBoolean, paramast, parami);
      switch (paramString.hashCode())
      {
      }
    }
    label400:
    label406:
    label412:
    label418:
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
                                      localObject1 = null;
                                      break;
                                      localObject1 = null;
                                      break label83;
                                      localObject1 = null;
                                      break label112;
                                      localObject1 = null;
                                      break label140;
                                      localObject1 = null;
                                      break label165;
                                      if (paramString.equals("finder_private_msg_entrance"))
                                      {
                                        sbt.postValue(paramast);
                                        AppMethodBeat.o(178189);
                                        return;
                                        if (paramString.equals("ProfileEntrance"))
                                        {
                                          sbi.postValue(paramast);
                                          AppMethodBeat.o(178189);
                                          return;
                                          if (paramString.equals("FinderFirstFav")) {
                                            sbq.postValue(paramast);
                                          }
                                        }
                                      }
                                    }
                                  } while (!paramString.equals("OriginalEntrance"));
                                  sbm.postValue(paramast);
                                  AppMethodBeat.o(178189);
                                  return;
                                } while (!paramString.equals("TLCamera"));
                                sbf.postValue(paramast);
                                AppMethodBeat.o(178189);
                                return;
                              } while (!paramString.equals("Discovery"));
                              sbd.postValue(paramast);
                              AppMethodBeat.o(178189);
                              return;
                            } while (!paramString.equals("AuthorProfileFans"));
                            sbj.postValue(paramast);
                            AppMethodBeat.o(178189);
                            return;
                          } while (!paramString.equals("FinderSetting"));
                          sbn.postValue(paramast);
                          AppMethodBeat.o(178189);
                          return;
                        } while (!paramString.equals("finder_wx_private_msg_entrance"));
                        sbu.postValue(paramast);
                        AppMethodBeat.o(178189);
                        return;
                      } while (!paramString.equals("TLPersonalCenter"));
                      sbl.postValue(paramast);
                      AppMethodBeat.o(178189);
                      return;
                    } while (!paramString.equals("TLRecommendTab"));
                    sbp.postValue(paramast);
                    AppMethodBeat.o(178189);
                    return;
                  } while (!paramString.equals("TLWxPrivateMsgBubble"));
                  sbv.postValue(paramast);
                  AppMethodBeat.o(178189);
                  return;
                } while (!paramString.equals("TLFollow"));
                sbo.postValue(paramast);
                AppMethodBeat.o(178189);
                return;
              } while (!paramString.equals("TLLbsTab"));
              sbs.postValue(paramast);
              AppMethodBeat.o(178189);
              return;
            } while (!paramString.equals("FinderEntrance"));
            sbe.postValue(paramast);
            AppMethodBeat.o(178189);
            return;
          } while (!paramString.equals("TLPostCamera"));
          sbg.postValue(paramast);
          AppMethodBeat.o(178189);
          return;
        } while (!paramString.equals("AuthorProfileNotify"));
        sbk.postValue(paramast);
        AppMethodBeat.o(178189);
        return;
      } while (!paramString.equals("TLMachineTab"));
      sbr.postValue(paramast);
      AppMethodBeat.o(178189);
      return;
    } while (!paramString.equals("TLWxBubble"));
    sbh.postValue(paramast);
    AppMethodBeat.o(178189);
  }
  
  public static MutableLiveData<a> cBA()
  {
    return sbi;
  }
  
  public static MutableLiveData<a> cBB()
  {
    return sbl;
  }
  
  public static MutableLiveData<a> cBC()
  {
    return sbm;
  }
  
  public static MutableLiveData<a> cBD()
  {
    return sbn;
  }
  
  public static MutableLiveData<a> cBE()
  {
    return sbo;
  }
  
  public static MutableLiveData<a> cBF()
  {
    return sbp;
  }
  
  public static MutableLiveData<a> cBG()
  {
    return sbq;
  }
  
  public static MutableLiveData<a> cBH()
  {
    return sbr;
  }
  
  public static MutableLiveData<a> cBI()
  {
    return sbs;
  }
  
  public static MutableLiveData<a> cBJ()
  {
    return sbt;
  }
  
  public static MutableLiveData<a> cBK()
  {
    return sbu;
  }
  
  public static MutableLiveData<a> cBL()
  {
    return sbv;
  }
  
  public static MutableLiveData<a> cBx()
  {
    return sbd;
  }
  
  public static MutableLiveData<a> cBy()
  {
    return sbe;
  }
  
  public static MutableLiveData<a> cBz()
  {
    return sbf;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "", "isShow", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "(ZLcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;)V", "getCtrInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public final boolean dnq;
    public ast sbx;
    public final i sby;
    
    public a(boolean paramBoolean, ast paramast, i parami)
    {
      this.dnq = paramBoolean;
      this.sbx = paramast;
      this.sby = parami;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(178187);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.dnq != paramObject.dnq) || (!p.i(this.sbx, paramObject.sbx)) || (!p.i(this.sby, paramObject.sby))) {}
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
      Object localObject1 = this.sby;
      if (localObject1 != null)
      {
        localObject1 = ((i)localObject1).field_tipsId;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" type=");
        localObject1 = this.sby;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = ((i)localObject1).field_ctrInfo;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = Integer.valueOf(((arj)localObject1).type);
        label68:
        localStringBuilder = localStringBuilder.append(localObject1).append(" isShow=").append(this.dnq).append(" path=");
        localObject1 = this.sbx;
        if (localObject1 == null) {
          break label189;
        }
        localObject1 = ((ast)localObject1).path;
        label105:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" showType=");
        localObject1 = this.sbx;
        if (localObject1 == null) {
          break label194;
        }
      }
      label184:
      label189:
      label194:
      for (localObject1 = Integer.valueOf(((ast)localObject1).uoi);; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append(" title=");
        ast localast = this.sbx;
        localObject1 = localObject2;
        if (localast != null) {
          localObject1 = localast.title;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "run"})
  static final class b
    implements Runnable
  {
    b(MutableLiveData paramMutableLiveData, Observer paramObserver) {}
    
    public final void run()
    {
      AppMethodBeat.i(202097);
      Object localObject = this.sbz.getValue();
      if (localObject != null)
      {
        paramObserver.onChanged(localObject);
        AppMethodBeat.o(202097);
        return;
      }
      AppMethodBeat.o(202097);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "run"})
  static final class c
    implements Runnable
  {
    c(MutableLiveData paramMutableLiveData, Observer paramObserver, LifecycleOwner paramLifecycleOwner) {}
    
    public final void run()
    {
      AppMethodBeat.i(202098);
      Object localObject1 = this.sbB.getValue();
      if (localObject1 != null)
      {
        Object localObject2 = new StringBuilder("value=").append(this.sbB.getValue()).append(" observer=").append(paramObserver.getClass().getSimpleName()).append(" currentState=");
        Lifecycle localLifecycle = paramLifecycleOwner.getLifecycle();
        p.g(localLifecycle, "owner.lifecycle");
        ae.i("Finder.RedDotNotifier", localLifecycle.getCurrentState());
        localObject2 = paramLifecycleOwner.getLifecycle();
        p.g(localObject2, "owner.lifecycle");
        if (((Lifecycle)localObject2).getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
          paramObserver.onChanged(localObject1);
        }
        AppMethodBeat.o(202098);
        return;
      }
      AppMethodBeat.o(202098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.g
 * JD-Core Version:    0.7.0.1
 */