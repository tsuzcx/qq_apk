package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "bizUsername", "", "(Ljava/lang/String;)V", "appId", "buffer", "", "extInfo", "isForRequestDialog", "", "isOpened", "mCallback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "netScene", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "cancel", "", "getKey", "getType", "", "run", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a
{
  public static final h.a pkx;
  private String appId;
  private byte[] buffer;
  private String extInfo;
  private boolean phG;
  private com.tencent.mm.msgsubscription.d.a piQ;
  private List<SubscribeMsgTmpItem> pis;
  private SubscribeMsgRequestDialogUiData piz;
  private com.tencent.mm.msgsubscription.api.a pkl;
  private boolean pky;
  private b pkz;
  
  static
  {
    AppMethodBeat.i(236496);
    pkx = new h.a((byte)0);
    AppMethodBeat.o(236496);
  }
  
  public h(c paramc, com.tencent.mm.msgsubscription.d.a parama)
  {
    this(paramc.username);
    AppMethodBeat.i(236429);
    this.piQ = parama;
    this.appId = paramc.appId;
    this.pis.addAll((Collection)paramc.pis);
    this.pkl = paramc.piB;
    this.phG = paramc.piy;
    this.buffer = paramc.buffer;
    this.piz = paramc.piz;
    this.extInfo = paramc.extInfo;
    this.pky = paramc.piA;
    AppMethodBeat.o(236429);
  }
  
  private h(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(236411);
    this.pis = ((List)new ArrayList());
    this.appId = "";
    this.buffer = new byte[] { 0 };
    this.extInfo = "";
    AppMethodBeat.o(236411);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(236511);
    super.cancel();
    Object localObject = this.pkz;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((b)localObject).hashCode()))
    {
      Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList cancel task: %s", new Object[] { localObject });
      localObject = com.tencent.mm.msgsubscription.a.a.piE;
      com.tencent.mm.msgsubscription.a.a.a((com.tencent.mm.msgsubscription.util.a)this.pkz);
      AppMethodBeat.o(236511);
      return;
    }
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(236518);
    int i;
    if (((CharSequence)this.hUQ).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label67;
      }
    }
    label67:
    for (String str = this.hUQ;; str = this.appId)
    {
      str = str + ',' + 1;
      AppMethodBeat.o(236518);
      return str;
      i = 0;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(236505);
    Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList %s, isOpened: %b", new Object[] { this.hUQ, Boolean.valueOf(this.phG) });
    Object localObject1 = new b(this);
    Object localObject2;
    if (this.pky) {
      localObject2 = b.a.piO;
    }
    String str;
    List localList;
    boolean bool;
    for (localObject1 = b.a.a.a(this.hUQ, this.appId, this.pis, this.extInfo, (b.c)localObject1, this.phG, this.buffer, this.piz);; localObject1 = b.a.a.a((String)localObject2, str, bool, (b.c)localObject1, localList, new byte[0]))
    {
      this.pkz = ((b)localObject1);
      localObject1 = this.pkz;
      s.checkNotNull(localObject1);
      d((b)localObject1);
      AppMethodBeat.o(236505);
      return;
      localObject2 = b.a.piO;
      localObject2 = this.hUQ;
      str = this.appId;
      localList = this.pis;
      localObject1 = (b.c)localObject1;
      bool = this.phG;
      s.u(localObject2, "username");
      s.u(str, "appId");
      s.u(localList, "templates");
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/task/UpdateSubscribeListTask$run$netSceneEndCallback$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.c
  {
    b(h paramh) {}
    
    private static final void a(int paramInt1, int paramInt2, h paramh, String paramString1, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString2)
    {
      AppMethodBeat.i(236448);
      s.u(paramh, "this$0");
      s.u(paramString1, "$username");
      s.u(paramString2, "$errMsg");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramh = h.e(paramh);
        if (paramh != null)
        {
          s.checkNotNull(paramSubscribeMsgRequestResult);
          paramh.a(paramString1, paramSubscribeMsgRequestResult);
          AppMethodBeat.o(236448);
        }
      }
      else
      {
        Log.e("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList failed");
        paramh = h.e(paramh);
        if (paramh != null) {
          paramh.j(paramInt1, paramInt2, paramString2);
        }
      }
      AppMethodBeat.o(236448);
    }
    
    private static final void a(ah.a parama, h paramh, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      List localList = null;
      AppMethodBeat.i(236441);
      s.u(parama, "$needUpdateList");
      s.u(paramh, "this$0");
      s.u(paramString, "$username");
      boolean bool;
      if (parama.aiwY)
      {
        paramh = h.d(paramh);
        if (paramh != null)
        {
          if (paramSubscribeMsgRequestResult != null) {
            break label87;
          }
          parama = null;
          s.checkNotNull(parama);
          localList = (List)parama;
          bool = paramSubscribeMsgRequestResult.phG;
          parama = paramh;
          paramh = localList;
        }
      }
      for (;;)
      {
        parama.b(paramString, paramh, bool, true, false);
        label87:
        do
        {
          AppMethodBeat.o(236441);
          return;
          parama = paramSubscribeMsgRequestResult.phC;
          break;
          parama = h.d(paramh);
        } while (parama == null);
        if (paramSubscribeMsgRequestResult == null)
        {
          bool = false;
          paramh = localList;
        }
        else
        {
          bool = paramSubscribeMsgRequestResult.phG;
          paramh = localList;
        }
      }
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      Object localObject1 = null;
      AppMethodBeat.i(236477);
      s.u(paramString, "errMsg");
      int i = this.pkA.hashCode();
      Object localObject2;
      label153:
      label191:
      if (paramSubscribeMsgRequestResult == null)
      {
        Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList end errType: %d, errCode: %d, errMsg: %s, hashCode: %s, tmpSize: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i), localObject1 });
        localObject2 = new ah.a();
        if (((CharSequence)this.pkA.hUQ).length() <= 0) {
          break label302;
        }
        i = 1;
        label100:
        if (i == 0) {
          break label308;
        }
        localObject1 = this.pkA.hUQ;
        label114:
        if ((paramInt1 == 0) && (paramInt2 == 0) && (!h.b(this.pkA)))
        {
          if (((Collection)h.c(this.pkA)).isEmpty()) {
            break label320;
          }
          i = 1;
          if (i != 0)
          {
            if (paramSubscribeMsgRequestResult == null) {
              break label332;
            }
            ArrayList localArrayList = paramSubscribeMsgRequestResult.phC;
            if (localArrayList == null) {
              break label332;
            }
            if (((Collection)localArrayList).isEmpty()) {
              break label326;
            }
            i = 1;
            if (i != 1) {
              break label332;
            }
          }
        }
      }
      label302:
      label308:
      label320:
      label326:
      label332:
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          Log.d("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList end and save to local");
          ((ah.a)localObject2).aiwY = true;
        }
        com.tencent.threadpool.h.ahAA.bk(new h.b..ExternalSyntheticLambda1((ah.a)localObject2, this.pkA, (String)localObject1, paramSubscribeMsgRequestResult));
        com.tencent.threadpool.h.ahAA.bk(new h.b..ExternalSyntheticLambda0(paramInt1, paramInt2, this.pkA, (String)localObject1, paramSubscribeMsgRequestResult, paramString));
        AppMethodBeat.o(236477);
        return;
        localObject2 = paramSubscribeMsgRequestResult.phC;
        if (localObject2 == null) {
          break;
        }
        localObject1 = Integer.valueOf(((ArrayList)localObject2).size());
        break;
        i = 0;
        break label100;
        localObject1 = h.a(this.pkA);
        break label114;
        i = 0;
        break label153;
        i = 0;
        break label191;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.h
 * JD-Core Version:    0.7.0.1
 */