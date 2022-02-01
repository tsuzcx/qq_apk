package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/task/GetSubscribeMsgUIStatusTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "templateIds", "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "templateIdList", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class d
  extends a
{
  public static final a iiT;
  private e.b iiH;
  private com.tencent.mm.msgsubscription.storage.d iiI;
  private List<String> iiS;
  
  static
  {
    AppMethodBeat.i(149682);
    iiT = new a((byte)0);
    AppMethodBeat.o(149682);
  }
  
  private d(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(149680);
    this.iiS = ((List)new ArrayList());
    AppMethodBeat.o(149680);
  }
  
  public d(String paramString, List<String> paramList, com.tencent.mm.msgsubscription.storage.d paramd, e.b paramb)
  {
    this(paramString);
    AppMethodBeat.i(149681);
    this.iiI = paramd;
    this.iiH = paramb;
    this.iiS.addAll((Collection)paramList);
    AppMethodBeat.o(149681);
  }
  
  public final void run()
  {
    AppMethodBeat.i(149679);
    Object localObject1 = b.a.ihC;
    localObject1 = this.dqK;
    Object localObject2 = this.iiS;
    Object localObject3 = (b.c)new b(this);
    k.h(localObject1, "username");
    k.h(localObject2, "templateIds");
    b localb = new b((String)localObject1, 5);
    b.a(localb, (b.c)localObject3);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      List localList = b.a(localb);
      dfh localdfh = new dfh();
      localdfh.EaV = ((String)localObject1);
      localdfh.Fhh = ((String)localObject3);
      localList.add(localdfh);
    }
    b(localb);
    AppMethodBeat.o(149679);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/task/GetSubscribeMsgUIStatusTask$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/task/GetSubscribeMsgUIStatusTask$run$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149678);
      k.h(paramString, "errMsg");
      ac.i("MicroMsg.GetSubscribeMsgUIStatusTask", "alvinluo getSubscribeStatus end errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      ap.f((Runnable)new a(this, paramInt1, paramInt2, paramSubscribeMsgRequestResult, paramString));
      AppMethodBeat.o(149678);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.b paramb, int paramInt1, int paramInt2, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString) {}
      
      public final void run()
      {
        AppMethodBeat.i(149677);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localb = d.a(this.iiV.iiU);
          if (localb != null)
          {
            String str = this.iiV.iiU.dqK;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult == null) {
              k.fOy();
            }
            localb.a(str, localSubscribeMsgRequestResult);
            AppMethodBeat.o(149677);
            return;
          }
          AppMethodBeat.o(149677);
          return;
        }
        e.b localb = d.a(this.iiV.iiU);
        if (localb != null)
        {
          localb.i(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(149677);
          return;
        }
        AppMethodBeat.o(149677);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.d
 * JD-Core Version:    0.7.0.1
 */