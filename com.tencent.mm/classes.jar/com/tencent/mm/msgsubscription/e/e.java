package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.protocal.protobuf.efc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/task/GetSubscribeStatusTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "templateIds", "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "templateIdList", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class e
  extends a
{
  public static final e.a jBg;
  private com.tencent.mm.msgsubscription.api.a jAX;
  private List<String> jBf;
  private com.tencent.mm.msgsubscription.d.a jzv;
  
  static
  {
    AppMethodBeat.i(223392);
    jBg = new e.a((byte)0);
    AppMethodBeat.o(223392);
  }
  
  private e(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(223390);
    this.jBf = ((List)new ArrayList());
    AppMethodBeat.o(223390);
  }
  
  public e(String paramString, List<String> paramList, com.tencent.mm.msgsubscription.d.a parama, com.tencent.mm.msgsubscription.api.a parama1)
  {
    this(paramString);
    AppMethodBeat.i(223391);
    this.jzv = parama;
    this.jAX = parama1;
    this.jBf.addAll((Collection)paramList);
    AppMethodBeat.o(223391);
  }
  
  public final void run()
  {
    AppMethodBeat.i(223389);
    Object localObject1 = b.a.jzu;
    localObject1 = this.dVu;
    Object localObject2 = this.jBf;
    Object localObject3 = (b.c)new b(this);
    p.h(localObject1, "username");
    p.h(localObject2, "templateIds");
    b localb = new b((String)localObject1, 5);
    b.a(localb, (b.c)localObject3);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      List localList = b.a(localb);
      efc localefc = new efc();
      localefc.KSV = ((String)localObject1);
      localefc.Mqy = ((String)localObject3);
      localList.add(localefc);
    }
    d(localb);
    AppMethodBeat.o(223389);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/task/GetSubscribeStatusTask$run$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(223388);
      p.h(paramString, "errMsg");
      Log.i("MicroMsg.GetSubscribeMsgUIStatusTask", "alvinluo getSubscribeStatus end errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      MMHandlerThread.postToMainThread((Runnable)new a(this, paramInt1, paramInt2, paramSubscribeMsgRequestResult, paramString));
      AppMethodBeat.o(223388);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(e.b paramb, int paramInt1, int paramInt2, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString) {}
      
      public final void run()
      {
        AppMethodBeat.i(223387);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          locala = e.a(this.jBi.jBh);
          if (locala != null)
          {
            String str = this.jBi.jBh.dVu;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult == null) {
              p.hyc();
            }
            locala.a(str, localSubscribeMsgRequestResult);
            AppMethodBeat.o(223387);
            return;
          }
          AppMethodBeat.o(223387);
          return;
        }
        com.tencent.mm.msgsubscription.api.a locala = e.a(this.jBi.jBh);
        if (locala != null)
        {
          locala.i(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(223387);
          return;
        }
        AppMethodBeat.o(223387);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.e
 * JD-Core Version:    0.7.0.1
 */