package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgUpdateStrategy;", "", "()V", "TAG", "", "checkSubscribeStatusNeedUpdate", "", "subscribeMsgTmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "plugin-comm_release"})
public final class b
{
  public static final b jzH;
  
  static
  {
    AppMethodBeat.i(223272);
    jzH = new b();
    AppMethodBeat.o(223272);
  }
  
  public static boolean b(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    Object localObject2 = null;
    AppMethodBeat.i(223271);
    Object localObject1;
    boolean bool;
    if ((paramSubscribeMsgTmpItem == null) || (paramSubscribeMsgTmpItem.jyC == 0L)) {
      if (paramSubscribeMsgTmpItem != null)
      {
        localObject1 = paramSubscribeMsgTmpItem.ixM;
        Log.i("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate first time and do update templateId: %s", new Object[] { localObject1 });
        bool = true;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (paramSubscribeMsgTmpItem != null) {
        localObject1 = Long.valueOf(paramSubscribeMsgTmpItem.jyC);
      }
      Log.v("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate updateTimestamp: %s, now: %s, needUpdate: %b", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(bool) });
      AppMethodBeat.o(223271);
      return bool;
      localObject1 = null;
      break;
      if (paramSubscribeMsgTmpItem.jyC < System.currentTimeMillis())
      {
        Log.i("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate updateTimestamp expired and do update, templateId: %s", new Object[] { paramSubscribeMsgTmpItem.ixM });
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