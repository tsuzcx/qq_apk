package com.tencent.mm.msgsubscription.e;

import com.tencent.e.i;
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
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "bizUsername", "", "(Ljava/lang/String;)V", "appId", "buffer", "", "extInfo", "isForRequestDialog", "", "isOpened", "mCallback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "netScene", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "cancel", "", "getKey", "getType", "", "run", "Companion", "plugin-comm_release"})
public final class h
  extends a
{
  public static final h.a mqZ;
  private String appId;
  private byte[] buffer;
  private String extInfo;
  private boolean mnS;
  private List<SubscribeMsgTmpItem> moB;
  private SubscribeMsgRequestDialogUiData moI;
  private com.tencent.mm.msgsubscription.d.a mpb;
  private com.tencent.mm.msgsubscription.api.a mqF;
  private boolean mqX;
  private b mqY;
  
  static
  {
    AppMethodBeat.i(203953);
    mqZ = new h.a((byte)0);
    AppMethodBeat.o(203953);
  }
  
  public h(c paramc, com.tencent.mm.msgsubscription.d.a parama)
  {
    this(paramc.username);
    AppMethodBeat.i(203952);
    this.mpb = parama;
    this.appId = paramc.appId;
    this.moB.addAll((Collection)paramc.moB);
    this.mqF = paramc.moK;
    this.mnS = paramc.moH;
    this.buffer = paramc.buffer;
    this.moI = paramc.moI;
    this.extInfo = paramc.extInfo;
    this.mqX = paramc.moJ;
    AppMethodBeat.o(203952);
  }
  
  private h(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(203949);
    this.moB = ((List)new ArrayList());
    this.appId = "";
    this.buffer = new byte[] { 0 };
    this.extInfo = "";
    AppMethodBeat.o(203949);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(203946);
    super.cancel();
    Object localObject = this.mqY;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((b)localObject).hashCode());; localObject = null)
    {
      Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList cancel task: %s", new Object[] { localObject });
      localObject = com.tencent.mm.msgsubscription.a.a.moO;
      com.tencent.mm.msgsubscription.a.a.a((com.tencent.mm.msgsubscription.util.a)this.mqY);
      AppMethodBeat.o(203946);
      return;
    }
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(203948);
    int i;
    if (((CharSequence)this.fOX).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label63;
      }
    }
    label63:
    for (String str = this.fOX;; str = this.appId)
    {
      str = str + ",1";
      AppMethodBeat.o(203948);
      return str;
      i = 0;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(203945);
    Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList %s, isOpened: %b", new Object[] { this.fOX, Boolean.valueOf(this.mnS) });
    Object localObject1 = new b(this);
    Object localObject2;
    if (this.mqX) {
      localObject2 = b.a.mpa;
    }
    String str;
    List localList;
    boolean bool;
    for (localObject1 = b.a.a.a(this.fOX, this.appId, this.moB, this.extInfo, (b.c)localObject1, this.mnS, this.buffer, this.moI);; localObject1 = b.a.a.a((String)localObject2, str, bool, (b.c)localObject1, localList, new byte[0]))
    {
      this.mqY = ((b)localObject1);
      localObject1 = this.mqY;
      if (localObject1 == null) {
        p.iCn();
      }
      d((b)localObject1);
      AppMethodBeat.o(203945);
      return;
      localObject2 = b.a.mpa;
      localObject2 = this.fOX;
      str = this.appId;
      localList = this.moB;
      localObject1 = (b.c)localObject1;
      bool = this.mnS;
      p.k(localObject2, "username");
      p.k(str, "appId");
      p.k(localList, "templates");
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/task/UpdateSubscribeListTask$run$netSceneEndCallback$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(234276);
      p.k(paramString, "errMsg");
      int i = this.mra.hashCode();
      Object localObject;
      final aa.a locala;
      if (paramSubscribeMsgRequestResult != null)
      {
        localObject = paramSubscribeMsgRequestResult.mnO;
        if (localObject != null)
        {
          localObject = Integer.valueOf(((ArrayList)localObject).size());
          Log.i("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList end errType: %d, errCode: %d, errMsg: %s, hashCode: %s, tmpSize: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i), localObject });
          locala = new aa.a();
          locala.aaBx = false;
          if (((CharSequence)this.mra.fOX).length() <= 0) {
            break label300;
          }
          i = 1;
          label125:
          if (i == 0) {
            break label306;
          }
          localObject = this.mra.fOX;
          label139:
          if ((paramInt1 == 0) && (paramInt2 == 0) && (!h.b(this.mra)))
          {
            if (((Collection)h.c(this.mra)).isEmpty()) {
              break label318;
            }
            i = 1;
            label178:
            if ((i != 0) && (paramSubscribeMsgRequestResult != null))
            {
              ArrayList localArrayList = paramSubscribeMsgRequestResult.mnO;
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
          locala.aaBx = true;
        }
        com.tencent.e.h.ZvG.bc((Runnable)new a(this, locala, (String)localObject, paramSubscribeMsgRequestResult));
        com.tencent.e.h.ZvG.bc((Runnable)new b(this, paramInt1, paramInt2, (String)localObject, paramSubscribeMsgRequestResult, paramString));
        AppMethodBeat.o(234276);
        return;
        localObject = null;
        break;
        i = 0;
        break label125;
        localObject = h.a(this.mra);
        break label139;
        i = 0;
        break label178;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(h.b paramb, aa.a parama, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void run()
      {
        Object localObject1 = null;
        AppMethodBeat.i(193932);
        Object localObject2;
        Object localObject3;
        if (locala.aaBx)
        {
          localObject2 = h.d(this.mrb.mra);
          if (localObject2 != null)
          {
            localObject3 = this.kyF;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult != null) {
              localObject1 = localSubscribeMsgRequestResult.mnO;
            }
            if (localObject1 == null) {
              p.iCn();
            }
            ((com.tencent.mm.msgsubscription.d.a)localObject2).b((String)localObject3, (List)localObject1, paramSubscribeMsgRequestResult.mnS, true, false);
            AppMethodBeat.o(193932);
            return;
          }
          AppMethodBeat.o(193932);
          return;
        }
        localObject1 = h.d(this.mrb.mra);
        if (localObject1 != null)
        {
          localObject2 = this.kyF;
          localObject3 = paramSubscribeMsgRequestResult;
          if (localObject3 != null) {}
          for (boolean bool = ((SubscribeMsgRequestResult)localObject3).mnS;; bool = false)
          {
            ((com.tencent.mm.msgsubscription.d.a)localObject1).b((String)localObject2, null, bool, true, false);
            AppMethodBeat.o(193932);
            return;
          }
        }
        AppMethodBeat.o(193932);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(h.b paramb, int paramInt1, int paramInt2, String paramString1, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString2) {}
      
      public final void run()
      {
        AppMethodBeat.i(224890);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          locala = h.e(this.mrb.mra);
          if (locala != null)
          {
            String str = this.kyF;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult == null) {
              p.iCn();
            }
            locala.a(str, localSubscribeMsgRequestResult);
            AppMethodBeat.o(224890);
            return;
          }
          AppMethodBeat.o(224890);
          return;
        }
        Log.e("MicroMsg.UpdateSubscribeMsgListTask", "alvinluo updateSubscribeMsgList failed");
        com.tencent.mm.msgsubscription.api.a locala = h.e(this.mrb.mra);
        if (locala != null)
        {
          locala.i(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(224890);
          return;
        }
        AppMethodBeat.o(224890);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.h
 * JD-Core Version:    0.7.0.1
 */