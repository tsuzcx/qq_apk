package com.tencent.mm.msgsubscription.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper;", "", "()V", "getSubscribeMsgInfoByNetScene", "", "userName", "", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "receiver", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "syncSetting2Server", "data", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "bind", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "plugin-comm_release"})
public final class d
{
  public static final d mtA;
  
  static
  {
    AppMethodBeat.i(149823);
    mtA = new d();
    AppMethodBeat.o(149823);
  }
  
  private static b.c a(b.c paramc, com.tencent.mm.vending.e.b<? super com.tencent.mm.vending.e.a> paramb)
  {
    AppMethodBeat.i(241070);
    p.k(paramc, "$this$bind");
    if (paramb == null)
    {
      AppMethodBeat.o(241070);
      return paramc;
    }
    a locala = new a();
    locala.mtB = paramc;
    paramb.keep((com.tencent.mm.vending.e.a)locala);
    paramc = (b.c)locala;
    AppMethodBeat.o(241070);
    return paramc;
  }
  
  public static void a(final String paramString, SubscribeMsgSettingData paramSubscribeMsgSettingData, com.tencent.mm.vending.e.b<? super com.tencent.mm.vending.e.a> paramb, kotlin.g.a.b<? super SubscribeMsgRequestResult, x> paramb1)
  {
    AppMethodBeat.i(241082);
    p.k(paramString, "userName");
    p.k(paramSubscribeMsgSettingData, "data");
    p.k(paramb1, "receiver");
    Object localObject = b.a.mpa;
    List localList = (List)new ArrayList();
    Iterator localIterator1 = ((Iterable)paramSubscribeMsgSettingData.lxh).iterator();
    label137:
    label202:
    label206:
    while (localIterator1.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)localIterator1.next();
      Iterator localIterator2 = ((Iterable)paramSubscribeMsgSettingData.mpP.mnO).iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          localObject = localIterator2.next();
          if (TextUtils.equals((CharSequence)((SubscribeMsgTmpItem)localObject).lnb, (CharSequence)localSubscribeMsgTmpItem.lnb))
          {
            localObject = (SubscribeMsgTmpItem)localObject;
            if (localObject == null) {
              break;
            }
            if ((((SubscribeMsgTmpItem)localObject).mof == localSubscribeMsgTmpItem.mof) && (((SubscribeMsgTmpItem)localObject).mnH == localSubscribeMsgTmpItem.mnH)) {
              break label202;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label206;
        }
        localList.add(localSubscribeMsgTmpItem);
        break;
        localObject = null;
        break label137;
      }
    }
    paramb = a((b.c)new c(paramb1, paramString), paramb);
    boolean bool = paramSubscribeMsgSettingData.lGT;
    p.k(paramString, "username");
    p.k(localList, "templates");
    b.a.a.a(paramString, "", bool, paramb, localList, new byte[0]).a((a.a)com.tencent.mm.msgsubscription.a.a.moO);
    AppMethodBeat.o(241082);
  }
  
  public static void a(String paramString, SubscribeMsgSettingData paramSubscribeMsgSettingData, kotlin.g.a.b<? super SubscribeMsgRequestResult, x> paramb)
  {
    AppMethodBeat.i(149822);
    a(paramString, paramSubscribeMsgSettingData, null, paramb);
    AppMethodBeat.o(149822);
  }
  
  public static void a(String paramString, com.tencent.mm.vending.e.b<? super com.tencent.mm.vending.e.a> paramb, final kotlin.g.a.b<? super SubscribeMsgSettingData, x> paramb1)
  {
    AppMethodBeat.i(241074);
    p.k(paramString, "userName");
    p.k(paramb1, "receiver");
    b.a.a locala = b.a.mpa;
    b.a.a.a(paramString, a((b.c)new b(paramString, paramb1), paramb)).a((a.a)com.tencent.mm.msgsubscription.a.a.moO);
    AppMethodBeat.o(241074);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$bind$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "cb", "getCb", "()Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "setCb", "(Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;)V", "dead", "", "onNetSceneEndCallback", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class a
    implements b.c, com.tencent.mm.vending.e.a
  {
    b.c mtB;
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(219300);
      p.k(paramString, "errMsg");
      try
      {
        b.c localc = this.mtB;
        if (localc != null) {
          localc.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        }
        return;
      }
      finally
      {
        dead();
        AppMethodBeat.o(219300);
      }
    }
    
    public final void dead()
    {
      this.mtB = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$getSubscribeMsgInfoByNetScene$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    b(String paramString, kotlin.g.a.b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149819);
      p.k(paramString, "errMsg");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramSubscribeMsgRequestResult != null)
        {
          paramString = com.tencent.mm.msgsubscription.api.b.moG;
          paramString = com.tencent.mm.msgsubscription.api.b.YR("name_wxa");
          if (paramString != null) {
            paramString.a(this.mtC, (List)paramSubscribeMsgRequestResult.mnO, paramSubscribeMsgRequestResult.mnS, true, false);
          }
          paramb1.invoke(new SubscribeMsgSettingData(paramSubscribeMsgRequestResult, (byte)0));
          AppMethodBeat.o(149819);
          return;
        }
        paramb1.invoke(null);
        AppMethodBeat.o(149819);
        return;
      }
      paramb1.invoke(null);
      AppMethodBeat.o(149819);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$syncSetting2Server$netSceneSubscribeMsg$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class c
    implements b.c
  {
    c(kotlin.g.a.b paramb, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149820);
      p.k(paramString, "errMsg");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.mtD.invoke(null);
        AppMethodBeat.o(149820);
        return;
      }
      paramString = com.tencent.mm.msgsubscription.api.b.moG;
      paramString = com.tencent.mm.msgsubscription.api.b.YR("name_wxa");
      if ((paramString != null) && (paramSubscribeMsgRequestResult != null)) {
        paramString.a(paramString, (List)paramSubscribeMsgRequestResult.mnO, paramSubscribeMsgRequestResult.mnS, true, false);
      }
      this.mtD.invoke(paramSubscribeMsgRequestResult);
      AppMethodBeat.o(149820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.d
 * JD-Core Version:    0.7.0.1
 */