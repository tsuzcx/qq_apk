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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper;", "", "()V", "getSubscribeMsgInfoByNetScene", "", "userName", "", "receiver", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "syncSetting2Server", "data", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
public final class c
{
  public static final c jDh;
  
  static
  {
    AppMethodBeat.i(149823);
    jDh = new c();
    AppMethodBeat.o(149823);
  }
  
  public static void a(final String paramString, SubscribeMsgSettingData paramSubscribeMsgSettingData, kotlin.g.a.b<? super SubscribeMsgRequestResult, x> paramb)
  {
    AppMethodBeat.i(149822);
    p.h(paramString, "userName");
    p.h(paramSubscribeMsgSettingData, "data");
    p.h(paramb, "receiver");
    Object localObject = b.a.jzu;
    List localList = (List)new ArrayList();
    Iterator localIterator1 = ((Iterable)paramSubscribeMsgSettingData.iHf).iterator();
    label137:
    label187:
    label190:
    while (localIterator1.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)localIterator1.next();
      Iterator localIterator2 = ((Iterable)paramSubscribeMsgSettingData.jAj.jyk).iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          localObject = localIterator2.next();
          if (TextUtils.equals((CharSequence)((SubscribeMsgTmpItem)localObject).ixM, (CharSequence)localSubscribeMsgTmpItem.ixM))
          {
            localObject = (SubscribeMsgTmpItem)localObject;
            if (localObject == null) {
              break;
            }
            if (((SubscribeMsgTmpItem)localObject).jyB == localSubscribeMsgTmpItem.jyB) {
              break label187;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label190;
        }
        localList.add(localSubscribeMsgTmpItem);
        break;
        localObject = null;
        break label137;
      }
    }
    paramb = (b.c)new b(paramb, paramString);
    boolean bool = paramSubscribeMsgSettingData.iQD;
    p.h(paramString, "username");
    p.h(localList, "templates");
    b.a.a.a(paramString, "", bool, paramb, localList, new byte[0]).a((a.a)com.tencent.mm.msgsubscription.a.a.jzi);
    AppMethodBeat.o(149822);
  }
  
  public static void c(String paramString, final kotlin.g.a.b<? super SubscribeMsgSettingData, x> paramb)
  {
    AppMethodBeat.i(149821);
    p.h(paramString, "userName");
    p.h(paramb, "receiver");
    b.a.a locala = b.a.jzu;
    b.a.a.a(paramString, (b.c)new a(paramString, paramb)).a((a.a)com.tencent.mm.msgsubscription.a.a.jzi);
    AppMethodBeat.o(149821);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$getSubscribeMsgInfoByNetScene$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class a
    implements b.c
  {
    a(String paramString, kotlin.g.a.b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149819);
      p.h(paramString, "errMsg");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramSubscribeMsgRequestResult != null)
        {
          paramString = com.tencent.mm.msgsubscription.api.b.jza;
          paramString = com.tencent.mm.msgsubscription.api.b.Ru("name_wxa");
          if (paramString != null) {
            paramString.a(this.jDi, (List)paramSubscribeMsgRequestResult.jyk, paramSubscribeMsgRequestResult.jyo, true, false);
          }
          paramb.invoke(new SubscribeMsgSettingData(paramSubscribeMsgRequestResult, (byte)0));
          AppMethodBeat.o(149819);
          return;
        }
        paramb.invoke(null);
        AppMethodBeat.o(149819);
        return;
      }
      paramb.invoke(null);
      AppMethodBeat.o(149819);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$syncSetting2Server$netSceneSubscribeMsg$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    b(kotlin.g.a.b paramb, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149820);
      p.h(paramString, "errMsg");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.jDj.invoke(null);
        AppMethodBeat.o(149820);
        return;
      }
      paramString = com.tencent.mm.msgsubscription.api.b.jza;
      paramString = com.tencent.mm.msgsubscription.api.b.Ru("name_wxa");
      if ((paramString != null) && (paramSubscribeMsgRequestResult != null)) {
        paramString.a(paramString, (List)paramSubscribeMsgRequestResult.jyk, paramSubscribeMsgRequestResult.jyo, true, false);
      }
      this.jDj.invoke(paramSubscribeMsgRequestResult);
      AppMethodBeat.o(149820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.c
 * JD-Core Version:    0.7.0.1
 */