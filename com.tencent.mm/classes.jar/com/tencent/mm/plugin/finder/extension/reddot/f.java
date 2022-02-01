package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier;", "", "()V", "TAG", "", "discoveryTab", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getDiscoveryTab", "()Landroid/arch/lifecycle/MutableLiveData;", "finderAuthorProfileFans", "getFinderAuthorProfileFans", "finderAuthorProfileNotify", "getFinderAuthorProfileNotify", "finderEntrance", "getFinderEntrance", "finderFirstFav", "getFinderFirstFav", "finderOriginalEntrance", "getFinderOriginalEntrance", "finderProfileEntrance", "getFinderProfileEntrance", "finderProfileSetting", "getFinderProfileSetting", "finderTlCamera", "getFinderTlCamera", "finderTlPersonalCenter", "getFinderTlPersonalCenter", "finderTlTabFollow", "getFinderTlTabFollow", "finderTlTabFriend", "getFinderTlTabFriend", "finderTlTabLbs", "getFinderTlTabLbs", "finderTlTabMachine", "getFinderTlTabMachine", "finderTlWxBubble", "getFinderTlWxBubble", "notify", "", "isShow", "", "path", "tipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "observeForeverWithNotify", "T", "observer", "Landroid/arch/lifecycle/Observer;", "observeWithNotify", "owner", "Landroid/arch/lifecycle/LifecycleOwner;", "Result", "plugin-finder_release"})
public final class f
{
  private static final MutableLiveData<a> reW;
  private static final MutableLiveData<a> reX;
  private static final MutableLiveData<a> reY;
  private static final MutableLiveData<a> reZ;
  private static final MutableLiveData<a> rfa;
  private static final MutableLiveData<a> rfb;
  private static final MutableLiveData<a> rfc;
  private static final MutableLiveData<a> rfd;
  private static final MutableLiveData<a> rfe;
  private static final MutableLiveData<a> rff;
  private static final MutableLiveData<a> rfg;
  private static final MutableLiveData<a> rfh;
  private static final MutableLiveData<a> rfi;
  private static final MutableLiveData<a> rfj;
  private static final MutableLiveData<a> rfk;
  public static final f rfl;
  
  static
  {
    AppMethodBeat.i(178190);
    rfl = new f();
    reW = new MutableLiveData();
    reX = new MutableLiveData();
    reY = new MutableLiveData();
    reZ = new MutableLiveData();
    rfa = new MutableLiveData();
    rfb = new MutableLiveData();
    rfc = new MutableLiveData();
    rfd = new MutableLiveData();
    rfe = new MutableLiveData();
    rff = new MutableLiveData();
    rfg = new MutableLiveData();
    rfh = new MutableLiveData();
    rfi = new MutableLiveData();
    rfj = new MutableLiveData();
    rfk = new MutableLiveData();
    AppMethodBeat.o(178190);
  }
  
  public static <T> void a(MutableLiveData<T> paramMutableLiveData, LifecycleOwner paramLifecycleOwner, final Observer<T> paramObserver)
  {
    AppMethodBeat.i(178188);
    k.h(paramMutableLiveData, "$this$observeWithNotify");
    k.h(paramLifecycleOwner, "owner");
    k.h(paramObserver, "observer");
    paramMutableLiveData.observe(paramLifecycleOwner, paramObserver);
    com.tencent.e.h.JZN.aQ((Runnable)new c(paramMutableLiveData, paramObserver));
    AppMethodBeat.o(178188);
  }
  
  public static <T> void a(MutableLiveData<T> paramMutableLiveData, final Observer<T> paramObserver)
  {
    AppMethodBeat.i(201482);
    k.h(paramMutableLiveData, "$this$observeForeverWithNotify");
    k.h(paramObserver, "observer");
    paramMutableLiveData.observeForever(paramObserver);
    com.tencent.e.h.JZN.aQ((Runnable)new b(paramMutableLiveData, paramObserver));
    AppMethodBeat.o(201482);
  }
  
  public static void a(boolean paramBoolean, String paramString, aon paramaon, h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(178189);
    k.h(paramString, "path");
    StringBuilder localStringBuilder = new StringBuilder("[notify] isShow=").append(paramBoolean).append(" path=").append(paramString).append(" show_type=");
    Object localObject1;
    if (paramaon != null)
    {
      localObject1 = Integer.valueOf(paramaon.tfk);
      localStringBuilder = localStringBuilder.append(localObject1).append(" count=");
      if (paramaon == null) {
        break label364;
      }
      localObject1 = Integer.valueOf(paramaon.count);
      label83:
      localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("title=");
      if (paramaon == null) {
        break label370;
      }
      localObject1 = paramaon.title;
      label112:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" clear_type=");
      if (paramaon == null) {
        break label376;
      }
      localObject1 = Integer.valueOf(paramaon.EHC);
      label139:
      localStringBuilder = localStringBuilder.append(localObject1).append(" parent=");
      if (paramaon == null) {
        break label382;
      }
      localObject1 = paramaon.vXx;
      label163:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" icon=");
      localObject1 = localObject2;
      if (paramaon != null) {
        localObject1 = paramaon.oGN;
      }
      ac.i("Finder.RedDotNotifier", (String)localObject1);
      paramaon = new a(paramBoolean, paramaon, paramh);
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
                                  rfa.postValue(paramaon);
                                  AppMethodBeat.o(178189);
                                  return;
                                  if (paramString.equals("FinderFirstFav")) {
                                    rfi.postValue(paramaon);
                                  }
                                }
                              }
                            } while (!paramString.equals("OriginalEntrance"));
                            rfe.postValue(paramaon);
                            AppMethodBeat.o(178189);
                            return;
                          } while (!paramString.equals("TLCamera"));
                          reY.postValue(paramaon);
                          AppMethodBeat.o(178189);
                          return;
                        } while (!paramString.equals("Discovery"));
                        reW.postValue(paramaon);
                        AppMethodBeat.o(178189);
                        return;
                      } while (!paramString.equals("AuthorProfileFans"));
                      rfb.postValue(paramaon);
                      AppMethodBeat.o(178189);
                      return;
                    } while (!paramString.equals("FinderSetting"));
                    rff.postValue(paramaon);
                    AppMethodBeat.o(178189);
                    return;
                  } while (!paramString.equals("TLPersonalCenter"));
                  rfd.postValue(paramaon);
                  AppMethodBeat.o(178189);
                  return;
                } while (!paramString.equals("TLRecommendTab"));
                rfh.postValue(paramaon);
                AppMethodBeat.o(178189);
                return;
              } while (!paramString.equals("TLFollow"));
              rfg.postValue(paramaon);
              AppMethodBeat.o(178189);
              return;
            } while (!paramString.equals("TLLbsTab"));
            rfk.postValue(paramaon);
            AppMethodBeat.o(178189);
            return;
          } while (!paramString.equals("FinderEntrance"));
          reX.postValue(paramaon);
          AppMethodBeat.o(178189);
          return;
        } while (!paramString.equals("AuthorProfileNotify"));
        rfc.postValue(paramaon);
        AppMethodBeat.o(178189);
        return;
      } while (!paramString.equals("TLMachineTab"));
      rfj.postValue(paramaon);
      AppMethodBeat.o(178189);
      return;
    } while (!paramString.equals("TLWxBubble"));
    reZ.postValue(paramaon);
    AppMethodBeat.o(178189);
  }
  
  public static MutableLiveData<a> ctL()
  {
    return reW;
  }
  
  public static MutableLiveData<a> ctM()
  {
    return reX;
  }
  
  public static MutableLiveData<a> ctN()
  {
    return reY;
  }
  
  public static MutableLiveData<a> ctO()
  {
    return rfd;
  }
  
  public static MutableLiveData<a> ctP()
  {
    return rff;
  }
  
  public static MutableLiveData<a> ctQ()
  {
    return rfg;
  }
  
  public static MutableLiveData<a> ctR()
  {
    return rfh;
  }
  
  public static MutableLiveData<a> ctS()
  {
    return rfi;
  }
  
  public static MutableLiveData<a> ctT()
  {
    return rfj;
  }
  
  public static MutableLiveData<a> ctU()
  {
    return rfk;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "", "isShow", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "(ZLcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;)V", "getCtrInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public final boolean daU;
    public aon rfm;
    public final h rfn;
    
    public a(boolean paramBoolean, aon paramaon, h paramh)
    {
      this.daU = paramBoolean;
      this.rfm = paramaon;
      this.rfn = paramh;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(178187);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.daU != paramObject.daU) || (!k.g(this.rfm, paramObject.rfm)) || (!k.g(this.rfn, paramObject.rfn))) {}
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
      Object localObject1 = this.rfn;
      if (localObject1 != null)
      {
        localObject1 = ((h)localObject1).field_tipsId;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" type=");
        localObject1 = this.rfn;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = ((h)localObject1).field_ctrInfo;
        if (localObject1 == null) {
          break label184;
        }
        localObject1 = Integer.valueOf(((ani)localObject1).type);
        label68:
        localStringBuilder = localStringBuilder.append(localObject1).append(" isShow=").append(this.daU).append(" path=");
        localObject1 = this.rfm;
        if (localObject1 == null) {
          break label189;
        }
        localObject1 = ((aon)localObject1).path;
        label105:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" showType=");
        localObject1 = this.rfm;
        if (localObject1 == null) {
          break label194;
        }
      }
      label184:
      label189:
      label194:
      for (localObject1 = Integer.valueOf(((aon)localObject1).tfk);; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append(" title=");
        aon localaon = this.rfm;
        localObject1 = localObject2;
        if (localaon != null) {
          localObject1 = localaon.title;
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "run"})
  static final class b
    implements Runnable
  {
    b(MutableLiveData paramMutableLiveData, Observer paramObserver) {}
    
    public final void run()
    {
      AppMethodBeat.i(201480);
      Object localObject = this.rfo.getValue();
      if (localObject != null)
      {
        paramObserver.onChanged(localObject);
        AppMethodBeat.o(201480);
        return;
      }
      AppMethodBeat.o(201480);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "run"})
  static final class c
    implements Runnable
  {
    c(MutableLiveData paramMutableLiveData, Observer paramObserver) {}
    
    public final void run()
    {
      AppMethodBeat.i(201481);
      Object localObject = this.rfq.getValue();
      if (localObject != null)
      {
        ac.i("Finder.RedDotNotifier", "value=" + this.rfq.getValue() + " observer=" + paramObserver.getClass().getSimpleName());
        paramObserver.onChanged(localObject);
        AppMethodBeat.o(201481);
        return;
      }
      AppMethodBeat.o(201481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.f
 * JD-Core Version:    0.7.0.1
 */