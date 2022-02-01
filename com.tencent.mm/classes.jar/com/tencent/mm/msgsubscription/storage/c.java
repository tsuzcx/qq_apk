package com.tencent.mm.msgsubscription.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgStrategy;", "", "()V", "TAG", "", "checkSubscribeStatusNeedUpdate", "", "subscribeMsgTmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "plugin-comm_release"})
public final class c
{
  public static final c iin;
  
  static
  {
    AppMethodBeat.i(149635);
    iin = new c();
    AppMethodBeat.o(149635);
  }
  
  public static boolean b(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    Object localObject2 = null;
    AppMethodBeat.i(149634);
    Object localObject1;
    boolean bool;
    if ((paramSubscribeMsgTmpItem == null) || (paramSubscribeMsgTmpItem.igZ == 0L)) {
      if (paramSubscribeMsgTmpItem != null)
      {
        localObject1 = paramSubscribeMsgTmpItem.hiK;
        ac.i("MicroMsg.BrandSubscribeMsgStrategy", "alvinluo checkSubscribeStatusNeedUpdate first time and do update templateId: %s", new Object[] { localObject1 });
        bool = true;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (paramSubscribeMsgTmpItem != null) {
        localObject1 = Long.valueOf(paramSubscribeMsgTmpItem.igZ);
      }
      ac.v("MicroMsg.BrandSubscribeMsgStrategy", "alvinluo checkSubscribeStatusNeedUpdate updateTimestamp: %s, now: %s", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(149634);
      return bool;
      localObject1 = null;
      break;
      if (paramSubscribeMsgTmpItem.igZ < System.currentTimeMillis())
      {
        ac.i("MicroMsg.BrandSubscribeMsgStrategy", "alvinluo checkSubscribeStatusNeedUpdate updateTimestamp expired and do update, templateId: %s", new Object[] { paramSubscribeMsgTmpItem.hiK });
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.c
 * JD-Core Version:    0.7.0.1
 */