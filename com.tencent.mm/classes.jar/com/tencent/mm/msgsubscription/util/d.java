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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper;", "", "()V", "getSubscribeMsgInfoByNetScene", "", "userName", "", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "receiver", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "syncSetting2Server", "data", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "bind", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d pmU;
  
  static
  {
    AppMethodBeat.i(149823);
    pmU = new d();
    AppMethodBeat.o(149823);
  }
  
  private static b.c a(b.c paramc, com.tencent.mm.vending.e.b<? super com.tencent.mm.vending.e.a> paramb)
  {
    AppMethodBeat.i(236308);
    s.u(paramc, "<this>");
    if (paramb == null)
    {
      AppMethodBeat.o(236308);
      return paramc;
    }
    a locala = new a();
    locala.pmV = paramc;
    paramb.keep((com.tencent.mm.vending.e.a)locala);
    paramc = (b.c)locala;
    AppMethodBeat.o(236308);
    return paramc;
  }
  
  public static void a(final String paramString, SubscribeMsgSettingData paramSubscribeMsgSettingData, com.tencent.mm.vending.e.b<? super com.tencent.mm.vending.e.a> paramb, kotlin.g.a.b<? super SubscribeMsgRequestResult, ah> paramb1)
  {
    AppMethodBeat.i(236326);
    s.u(paramString, "userName");
    s.u(paramSubscribeMsgSettingData, "data");
    s.u(paramb1, "receiver");
    Object localObject = b.a.piO;
    List localList = (List)new ArrayList();
    Iterator localIterator1 = ((Iterable)paramSubscribeMsgSettingData.bMQ).iterator();
    label137:
    label215:
    label219:
    while (localIterator1.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)localIterator1.next();
      Iterator localIterator2 = ((Iterable)paramSubscribeMsgSettingData.pjB.phC).iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          localObject = localIterator2.next();
          if (TextUtils.equals((CharSequence)((SubscribeMsgTmpItem)localObject).nSg, (CharSequence)localSubscribeMsgTmpItem.nSg))
          {
            localObject = (SubscribeMsgTmpItem)localObject;
            if (localObject == null) {
              break;
            }
            if ((((SubscribeMsgTmpItem)localObject).phT == localSubscribeMsgTmpItem.phT) && (((SubscribeMsgTmpItem)localObject).phu == localSubscribeMsgTmpItem.phu) && (((SubscribeMsgTmpItem)localObject).pib == localSubscribeMsgTmpItem.pib)) {
              break label215;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label219;
        }
        localList.add(localSubscribeMsgTmpItem);
        break;
        localObject = null;
        break label137;
      }
    }
    paramb = a((b.c)new c(paramb1, paramString), paramb);
    boolean bool = paramSubscribeMsgSettingData.oyB;
    s.u(paramString, "username");
    s.u(localList, "templates");
    b.a.a.a(paramString, "", bool, paramb, localList, new byte[0]).a((a.a)com.tencent.mm.msgsubscription.a.a.piE);
    AppMethodBeat.o(236326);
  }
  
  public static void a(String paramString, SubscribeMsgSettingData paramSubscribeMsgSettingData, kotlin.g.a.b<? super SubscribeMsgRequestResult, ah> paramb)
  {
    AppMethodBeat.i(149822);
    s.u(paramString, "userName");
    s.u(paramSubscribeMsgSettingData, "data");
    s.u(paramb, "receiver");
    a(paramString, paramSubscribeMsgSettingData, null, paramb);
    AppMethodBeat.o(149822);
  }
  
  public static void a(String paramString, com.tencent.mm.vending.e.b<? super com.tencent.mm.vending.e.a> paramb, final kotlin.g.a.b<? super SubscribeMsgSettingData, ah> paramb1)
  {
    AppMethodBeat.i(236315);
    s.u(paramString, "userName");
    s.u(paramb1, "receiver");
    b.a.a locala = b.a.piO;
    b.a.a.a(paramString, a((b.c)new b(paramString, paramb1), paramb)).a((a.a)com.tencent.mm.msgsubscription.a.a.piE);
    AppMethodBeat.o(236315);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$bind$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "cb", "getCb", "()Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "setCb", "(Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;)V", "dead", "", "onNetSceneEndCallback", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b.c, com.tencent.mm.vending.e.a
  {
    b.c pmV;
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(236301);
      s.u(paramString, "errMsg");
      try
      {
        b.c localc = this.pmV;
        if (localc != null) {
          localc.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        }
        return;
      }
      finally
      {
        dead();
        AppMethodBeat.o(236301);
      }
    }
    
    public final void dead()
    {
      this.pmV = null;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$getSubscribeMsgInfoByNetScene$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.c
  {
    b(String paramString, kotlin.g.a.b<? super SubscribeMsgSettingData, ah> paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149819);
      s.u(paramString, "errMsg");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramSubscribeMsgRequestResult != null)
        {
          paramString = com.tencent.mm.msgsubscription.api.b.piw;
          paramString = com.tencent.mm.msgsubscription.api.b.QW("name_wxa");
          if (paramString != null) {
            paramString.a(this.pmW, (List)paramSubscribeMsgRequestResult.phC, paramSubscribeMsgRequestResult.phG, true, false);
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$syncSetting2Server$netSceneSubscribeMsg$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements b.c
  {
    c(kotlin.g.a.b<? super SubscribeMsgRequestResult, ah> paramb, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149820);
      s.u(paramString, "errMsg");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.pmX.invoke(null);
        AppMethodBeat.o(149820);
        return;
      }
      paramString = com.tencent.mm.msgsubscription.api.b.piw;
      paramString = com.tencent.mm.msgsubscription.api.b.QW("name_wxa");
      if ((paramString != null) && (paramSubscribeMsgRequestResult != null)) {
        paramString.a(paramString, (List)paramSubscribeMsgRequestResult.phC, paramSubscribeMsgRequestResult.phG, true, false);
      }
      this.pmX.invoke(paramSubscribeMsgRequestResult);
      AppMethodBeat.o(149820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.d
 * JD-Core Version:    0.7.0.1
 */