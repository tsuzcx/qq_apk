package com.tencent.mm.msgsubscription.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.storage.f;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper;", "", "()V", "getSubscribeMsgInfoByNetScene", "", "userName", "", "receiver", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "syncSetting2Server", "data", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
public final class c
{
  public static final c ikO;
  
  static
  {
    AppMethodBeat.i(149823);
    ikO = new c();
    AppMethodBeat.o(149823);
  }
  
  public static void a(final String paramString, SubscribeMsgSettingData paramSubscribeMsgSettingData, d.g.a.b<? super SubscribeMsgRequestResult, y> paramb)
  {
    AppMethodBeat.i(149822);
    k.h(paramString, "userName");
    k.h(paramSubscribeMsgSettingData, "data");
    k.h(paramb, "receiver");
    Object localObject = b.a.ihC;
    List localList = (List)new ArrayList();
    Iterator localIterator1 = ((Iterable)paramSubscribeMsgSettingData.hqR).iterator();
    label137:
    label187:
    label190:
    while (localIterator1.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)localIterator1.next();
      Iterator localIterator2 = ((Iterable)paramSubscribeMsgSettingData.ihF.igI).iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          localObject = localIterator2.next();
          if (TextUtils.equals((CharSequence)((SubscribeMsgTmpItem)localObject).hiK, (CharSequence)localSubscribeMsgTmpItem.hiK))
          {
            localObject = (SubscribeMsgTmpItem)localObject;
            if (localObject == null) {
              break;
            }
            if (((SubscribeMsgTmpItem)localObject).igY == localSubscribeMsgTmpItem.igY) {
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
    b.a.a.a(paramString, localList, (b.c)new b(paramb, paramString), paramSubscribeMsgSettingData.hAd).a((a.a)com.tencent.mm.msgsubscription.a.a.ihr);
    AppMethodBeat.o(149822);
  }
  
  public static void c(String paramString, final d.g.a.b<? super SubscribeMsgSettingData, y> paramb)
  {
    AppMethodBeat.i(149821);
    k.h(paramString, "userName");
    k.h(paramb, "receiver");
    b.a.a locala = b.a.ihC;
    b.a.a.a(paramString, (b.c)new a(paramString, paramb)).a((a.a)com.tencent.mm.msgsubscription.a.a.ihr);
    AppMethodBeat.o(149821);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$getSubscribeMsgInfoByNetScene$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class a
    implements b.c
  {
    a(String paramString, d.g.a.b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149819);
      k.h(paramString, "errMsg");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramSubscribeMsgRequestResult != null)
        {
          paramString = f.iix;
          paramString = f.ES("name_wxa");
          if (paramString != null) {
            paramString.a(this.ikP, (List)paramSubscribeMsgRequestResult.igI, paramSubscribeMsgRequestResult.igL, true, false);
          }
          paramb.ay(new SubscribeMsgSettingData(paramSubscribeMsgRequestResult, (byte)0));
          AppMethodBeat.o(149819);
          return;
        }
        paramb.ay(null);
        AppMethodBeat.o(149819);
        return;
      }
      paramb.ay(null);
      AppMethodBeat.o(149819);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$syncSetting2Server$netSceneSubscribeMsg$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    b(d.g.a.b paramb, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149820);
      k.h(paramString, "errMsg");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.ikQ.ay(null);
        AppMethodBeat.o(149820);
        return;
      }
      paramString = f.iix;
      paramString = f.ES("name_wxa");
      if ((paramString != null) && (paramSubscribeMsgRequestResult != null)) {
        paramString.a(paramString, (List)paramSubscribeMsgRequestResult.igI, paramSubscribeMsgRequestResult.igL, true, false);
      }
      this.ikQ.ay(paramSubscribeMsgRequestResult);
      AppMethodBeat.o(149820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.c
 * JD-Core Version:    0.7.0.1
 */