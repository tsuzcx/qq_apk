package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgUpdateStrategy;", "", "()V", "TAG", "", "checkSubscribeStatusNeedUpdate", "", "subscribeMsgTmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "plugin-comm_release"})
public final class b
{
  public static final b mpn;
  
  static
  {
    AppMethodBeat.i(224855);
    mpn = new b();
    AppMethodBeat.o(224855);
  }
  
  public static boolean b(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    Object localObject2 = null;
    AppMethodBeat.i(224854);
    Object localObject1;
    boolean bool;
    if ((paramSubscribeMsgTmpItem == null) || (paramSubscribeMsgTmpItem.mog == 0L)) {
      if (paramSubscribeMsgTmpItem != null)
      {
        localObject1 = paramSubscribeMsgTmpItem.lnb;
        Log.i("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate first time and do update templateId: %s", new Object[] { localObject1 });
        bool = true;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (paramSubscribeMsgTmpItem != null) {
        localObject1 = Long.valueOf(paramSubscribeMsgTmpItem.mog);
      }
      Log.v("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate updateTimestamp: %s, now: %s, needUpdate: %b", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(bool) });
      AppMethodBeat.o(224854);
      return bool;
      localObject1 = null;
      break;
      if (paramSubscribeMsgTmpItem.mog < System.currentTimeMillis())
      {
        Log.i("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate updateTimestamp expired and do update, templateId: %s", new Object[] { paramSubscribeMsgTmpItem.lnb });
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.b
 * JD-Core Version:    0.7.0.1
 */