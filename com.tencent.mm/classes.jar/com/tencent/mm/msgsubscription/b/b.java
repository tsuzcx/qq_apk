package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgUpdateStrategy;", "", "()V", "TAG", "", "checkSubscribeStatusNeedUpdate", "", "subscribeMsgTmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b pja;
  
  static
  {
    AppMethodBeat.i(236344);
    pja = new b();
    AppMethodBeat.o(236344);
  }
  
  public static boolean b(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    Object localObject = null;
    AppMethodBeat.i(236340);
    String str;
    boolean bool;
    if ((paramSubscribeMsgTmpItem == null) || (paramSubscribeMsgTmpItem.phU == 0L)) {
      if (paramSubscribeMsgTmpItem == null)
      {
        str = null;
        Log.i("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate first time and do update templateId: %s", new Object[] { str });
        bool = true;
        label43:
        if (paramSubscribeMsgTmpItem != null) {
          break label134;
        }
      }
    }
    label134:
    for (paramSubscribeMsgTmpItem = localObject;; paramSubscribeMsgTmpItem = Long.valueOf(paramSubscribeMsgTmpItem.phU))
    {
      Log.v("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate updateTimestamp: %s, now: %s, needUpdate: %b", new Object[] { paramSubscribeMsgTmpItem, Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(bool) });
      AppMethodBeat.o(236340);
      return bool;
      str = paramSubscribeMsgTmpItem.nSg;
      break;
      if (paramSubscribeMsgTmpItem.phU < System.currentTimeMillis())
      {
        Log.i("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate updateTimestamp expired and do update, templateId: %s", new Object[] { paramSubscribeMsgTmpItem.nSg });
        bool = true;
        break label43;
      }
      bool = false;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.b
 * JD-Core Version:    0.7.0.1
 */