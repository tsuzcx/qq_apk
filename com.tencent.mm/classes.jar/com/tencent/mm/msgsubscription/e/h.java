package com.tencent.mm.msgsubscription.e;

import com.tencent.f.i;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "bizUsername", "", "(Ljava/lang/String;)V", "appId", "buffer", "", "extInfo", "isForRequestDialog", "", "isOpened", "mCallback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "netScene", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "cancel", "", "getKey", "getType", "", "run", "Companion", "plugin-comm_release"})
public final class h
  extends a
{
  public static final h.a jBq;
  private String appId;
  private byte[] buffer;
  private String extInfo;
  private com.tencent.mm.msgsubscription.api.a jAX;
  private boolean jBo;
  private b jBp;
  private List<SubscribeMsgTmpItem> jyV;
  private boolean jyo;
  private SubscribeMsgRequestDialogUiData jzc;
  private com.tencent.mm.msgsubscription.d.a jzv;
  
  static
  {
    AppMethodBeat.i(223407);
    jBq = new h.a((byte)0);
    AppMethodBeat.o(223407);
  }
  
  public h(c paramc, com.tencent.mm.msgsubscription.d.a parama)
  {
    this(paramc.username);
    AppMethodBeat.i(223406);
    this.jzv = parama;
    this.appId = paramc.appId;
    this.jyV.addAll((Collection)paramc.jyV);
    this.jAX = paramc.jze;
    this.jyo = paramc.jzb;
    this.buffer = paramc.buffer;
    this.jzc = paramc.jzc;
    this.extInfo = paramc.extInfo;
    this.jBo = paramc.jzd;
    AppMethodBeat.o(223406);
  }
  
  private h(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(223405);
    this.jyV = ((List)new ArrayList());
    this.appId = "";
    this.buffer = new byte[] { 0 };
    this.extInfo = "";
    AppMethodBeat.o(223405);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(223403);
    super.cancel();
    Object localObject = this.jBp;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((b)localObject).hashCode());; localObject = null)
    {
      Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList cancel task: %s", new Object[] { localObject });
      localObject = com.tencent.mm.msgsubscription.a.a.jzi;
      com.tencent.mm.msgsubscription.a.a.a((com.tencent.mm.msgsubscription.util.a)this.jBp);
      AppMethodBeat.o(223403);
      return;
    }
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(223404);
    int i;
    if (((CharSequence)this.dVu).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label63;
      }
    }
    label63:
    for (String str = this.dVu;; str = this.appId)
    {
      str = str + ",1";
      AppMethodBeat.o(223404);
      return str;
      i = 0;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(223402);
    Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList %s, isOpened: %b", new Object[] { this.dVu, Boolean.valueOf(this.jyo) });
    Object localObject1 = new b(this);
    Object localObject2;
    if (this.jBo) {
      localObject2 = b.a.jzu;
    }
    String str;
    List localList;
    boolean bool;
    for (localObject1 = b.a.a.a(this.dVu, this.appId, this.jyV, this.extInfo, (b.c)localObject1, this.jyo, this.buffer, this.jzc);; localObject1 = b.a.a.a((String)localObject2, str, bool, (b.c)localObject1, localList, new byte[0]))
    {
      this.jBp = ((b)localObject1);
      localObject1 = this.jBp;
      if (localObject1 == null) {
        p.hyc();
      }
      d((b)localObject1);
      AppMethodBeat.o(223402);
      return;
      localObject2 = b.a.jzu;
      localObject2 = this.dVu;
      str = this.appId;
      localList = this.jyV;
      localObject1 = (b.c)localObject1;
      bool = this.jyo;
      p.h(localObject2, "username");
      p.h(str, "appId");
      p.h(localList, "templates");
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/task/UpdateSubscribeListTask$run$netSceneEndCallback$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(223401);
      p.h(paramString, "errMsg");
      int i = this.jBr.hashCode();
      Object localObject;
      final z.a locala;
      if (paramSubscribeMsgRequestResult != null)
      {
        localObject = paramSubscribeMsgRequestResult.jyk;
        if (localObject != null)
        {
          localObject = Integer.valueOf(((ArrayList)localObject).size());
          Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList end errType: %d, errCode: %d, errMsg: %s, hashCode: %s, tmpSize: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i), localObject });
          locala = new z.a();
          locala.SYB = false;
          if (((CharSequence)this.jBr.dVu).length() <= 0) {
            break label300;
          }
          i = 1;
          label125:
          if (i == 0) {
            break label306;
          }
          localObject = this.jBr.dVu;
          label139:
          if ((paramInt1 == 0) && (paramInt2 == 0) && (!h.b(this.jBr)))
          {
            if (((Collection)h.c(this.jBr)).isEmpty()) {
              break label318;
            }
            i = 1;
            label178:
            if ((i != 0) && (paramSubscribeMsgRequestResult != null))
            {
              ArrayList localArrayList = paramSubscribeMsgRequestResult.jyk;
              if (localArrayList != null) {
                if (((Collection)localArrayList).isEmpty()) {
                  break label324;
                }
              }
            }
          }
        }
      }
      label300:
      label306:
      label318:
      label324:
      for (i = 1;; i = 0)
      {
        if (i == 1)
        {
          Log.d("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList end and save to local");
          locala.SYB = true;
        }
        com.tencent.f.h.RTc.aV((Runnable)new a(this, locala, (String)localObject, paramSubscribeMsgRequestResult));
        com.tencent.f.h.RTc.aV((Runnable)new b(this, paramInt1, paramInt2, (String)localObject, paramSubscribeMsgRequestResult, paramString));
        AppMethodBeat.o(223401);
        return;
        localObject = null;
        break;
        i = 0;
        break label125;
        localObject = h.a(this.jBr);
        break label139;
        i = 0;
        break label178;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(h.b paramb, z.a parama, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void run()
      {
        Object localObject1 = null;
        AppMethodBeat.i(223399);
        Object localObject2;
        Object localObject3;
        if (locala.SYB)
        {
          localObject2 = h.d(this.jBs.jBr);
          if (localObject2 != null)
          {
            localObject3 = this.hLl;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult != null) {
              localObject1 = localSubscribeMsgRequestResult.jyk;
            }
            if (localObject1 == null) {
              p.hyc();
            }
            ((com.tencent.mm.msgsubscription.d.a)localObject2).b((String)localObject3, (List)localObject1, paramSubscribeMsgRequestResult.jyo, true, false);
            AppMethodBeat.o(223399);
            return;
          }
          AppMethodBeat.o(223399);
          return;
        }
        localObject1 = h.d(this.jBs.jBr);
        if (localObject1 != null)
        {
          localObject2 = this.hLl;
          localObject3 = paramSubscribeMsgRequestResult;
          if (localObject3 != null) {}
          for (boolean bool = ((SubscribeMsgRequestResult)localObject3).jyo;; bool = false)
          {
            ((com.tencent.mm.msgsubscription.d.a)localObject1).b((String)localObject2, null, bool, true, false);
            AppMethodBeat.o(223399);
            return;
          }
        }
        AppMethodBeat.o(223399);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(h.b paramb, int paramInt1, int paramInt2, String paramString1, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString2) {}
      
      public final void run()
      {
        AppMethodBeat.i(223400);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          locala = h.e(this.jBs.jBr);
          if (locala != null)
          {
            String str = this.hLl;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult == null) {
              p.hyc();
            }
            locala.a(str, localSubscribeMsgRequestResult);
            AppMethodBeat.o(223400);
            return;
          }
          AppMethodBeat.o(223400);
          return;
        }
        Log.e("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList failed");
        com.tencent.mm.msgsubscription.api.a locala = h.e(this.jBs.jBr);
        if (locala != null)
        {
          locala.i(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(223400);
          return;
        }
        AppMethodBeat.o(223400);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.h
 * JD-Core Version:    0.7.0.1
 */