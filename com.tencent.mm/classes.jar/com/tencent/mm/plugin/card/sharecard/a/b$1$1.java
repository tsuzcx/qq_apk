package com.tencent.mm.plugin.card.sharecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.mgr.d;
import com.tencent.mm.plugin.card.model.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

final class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(112920);
    Map localMap = (Map)am.dkO().getValue("key_share_user_info_map");
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put(this.wwp.wwm, this.wwo);
    am.dkO().z("key_share_user_info_map", localObject);
    AppMethodBeat.o(112920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.b.1.1
 * JD-Core Version:    0.7.0.1
 */