package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.storage.d;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeMsgListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "isOpened", "", "isForRequestDialog", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "buffer", "", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "(Ljava/lang/String;Ljava/util/List;ZZLcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;[BLcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "netScene", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "cancel", "", "getKey", "getType", "", "run", "Companion", "plugin-comm_release"})
public final class h
  extends a
{
  public static final h.a hID;
  private byte[] buffer;
  private boolean hGj;
  private SubscribeMsgRequestDialogUiData hHD;
  private List<SubscribeMsgTmpItem> hHO;
  private boolean hIB;
  private b hIC;
  private e.b hIf;
  private d hIg;
  
  static
  {
    AppMethodBeat.i(149701);
    hID = new h.a((byte)0);
    AppMethodBeat.o(149701);
  }
  
  private h(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(149698);
    this.hHO = ((List)new ArrayList());
    this.buffer = new byte[] { 0 };
    AppMethodBeat.o(149698);
  }
  
  public h(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, d paramd, e.b paramb, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
  {
    this(paramString);
    AppMethodBeat.i(149699);
    this.hIg = paramd;
    this.hIf = paramb;
    this.hHO.addAll((Collection)paramList);
    this.hGj = paramBoolean1;
    this.hIB = paramBoolean2;
    this.buffer = paramArrayOfByte;
    this.hHD = paramSubscribeMsgRequestDialogUiData;
    AppMethodBeat.o(149699);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(149696);
    super.cancel();
    Object localObject = this.hIC;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((b)localObject).hashCode());; localObject = null)
    {
      ad.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList cancel task: %s", new Object[] { localObject });
      localObject = com.tencent.mm.msgsubscription.a.a.hGP;
      com.tencent.mm.msgsubscription.a.a.a((com.tencent.mm.msgsubscription.util.a)this.hIC);
      AppMethodBeat.o(149696);
      return;
    }
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(149697);
    String str = this.dta + ",1";
    AppMethodBeat.o(149697);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(149695);
    ad.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList %s, isOpened: %b", new Object[] { this.dta, Boolean.valueOf(this.hGj) });
    Object localObject = new b(this);
    b.a.a locala;
    if (this.hIB) {
      locala = b.a.hHa;
    }
    for (localObject = b.a.a.a(this.dta, this.hHO, (b.c)localObject, this.hGj, this.buffer, this.hHD);; localObject = b.a.a.a(this.dta, this.hHO, (b.c)localObject, this.hGj))
    {
      this.hIC = ((b)localObject);
      localObject = this.hIC;
      if (localObject == null) {
        k.fvU();
      }
      if (localObject != null) {
        break;
      }
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.msgsubscription.cgi.NetSceneSubscribeMsg");
      AppMethodBeat.o(149695);
      throw ((Throwable)localObject);
      locala = b.a.hHa;
    }
    b((b)localObject);
    AppMethodBeat.o(149695);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/task/UpdateSubscribeMsgListTask$run$netSceneEndCallback$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149694);
      k.h(paramString, "errMsg");
      int i = this.hIE.hashCode();
      Object localObject1;
      if (paramSubscribeMsgRequestResult != null)
      {
        localObject1 = paramSubscribeMsgRequestResult.hGg;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
          ad.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList end errType: %d, errCode: %d, errMsg: %s, hashCode: %s, tmpSize: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i), localObject1 });
          if ((paramInt1 == 0) && (paramInt2 == 0) && (!h.a(this.hIE)))
          {
            if (((Collection)h.b(this.hIE)).isEmpty()) {
              break label280;
            }
            i = 1;
            label128:
            if (i == 0) {
              break label360;
            }
            if (paramSubscribeMsgRequestResult == null) {
              break label292;
            }
            localObject1 = paramSubscribeMsgRequestResult.hGg;
            if (localObject1 == null) {
              break label292;
            }
            if (((Collection)localObject1).isEmpty()) {
              break label286;
            }
            i = 1;
            label166:
            if (i != 1) {
              break label360;
            }
            ad.d("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList end and save to local");
            i = 1;
          }
        }
      }
      for (;;)
      {
        label182:
        if (i != 0)
        {
          localObject2 = h.c(this.hIE);
          if (localObject2 != null)
          {
            String str = this.hIE.dta;
            if (paramSubscribeMsgRequestResult == null) {
              break label298;
            }
            localObject1 = paramSubscribeMsgRequestResult.hGg;
            label222:
            if (localObject1 == null) {
              k.fvU();
            }
            ((d)localObject2).b(str, (List)localObject1, paramSubscribeMsgRequestResult.hGj);
          }
        }
        label280:
        label286:
        label292:
        label298:
        do
        {
          aq.f((Runnable)new a(this, paramInt1, paramInt2, paramSubscribeMsgRequestResult, paramString));
          AppMethodBeat.o(149694);
          return;
          localObject1 = null;
          break;
          i = 0;
          break label128;
          i = 0;
          break label166;
          i = 0;
          break label182;
          localObject1 = null;
          break label222;
          localObject1 = h.c(this.hIE);
        } while (localObject1 == null);
        Object localObject2 = this.hIE.dta;
        if (paramSubscribeMsgRequestResult != null) {}
        for (boolean bool = paramSubscribeMsgRequestResult.hGj;; bool = false)
        {
          ((d)localObject1).b((String)localObject2, null, bool);
          break;
        }
        label360:
        i = 0;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(h.b paramb, int paramInt1, int paramInt2, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString) {}
      
      public final void run()
      {
        AppMethodBeat.i(149693);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localb = h.d(this.hIF.hIE);
          if (localb != null)
          {
            String str = this.hIF.hIE.dta;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult == null) {
              k.fvU();
            }
            localb.a(str, localSubscribeMsgRequestResult);
            AppMethodBeat.o(149693);
            return;
          }
          AppMethodBeat.o(149693);
          return;
        }
        ad.e("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList failed");
        e.b localb = h.d(this.hIF.hIE);
        if (localb != null)
        {
          localb.i(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(149693);
          return;
        }
        AppMethodBeat.o(149693);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.h
 * JD-Core Version:    0.7.0.1
 */