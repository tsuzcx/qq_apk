package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import java.util.Collection;
import java.util.List;

final class e$2
  implements Runnable
{
  e$2(e parame, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(14148);
    Object localObject1;
    Object localObject2;
    if ((this.gxr == this.jWn.getCount() - 1) && (!this.jWn.jVY))
    {
      ab.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(this.gxr), Integer.valueOf(this.jWn.getCount()) });
      localObject1 = this.jWn;
      localObject2 = ((e)localObject1).aWH();
      if (localObject2 == null) {
        break label245;
      }
      t localt = z.afp();
      long l = ((q)localObject2).field_createTime;
      localObject2 = t.n(localt.fnw.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[] { String.valueOf(l) }, null, null, "createTime DESC limit 20"));
      ((e)localObject1).iQp.addAll((Collection)localObject2);
      ((e)localObject1).notifyDataSetChanged();
      if (((List)localObject2).size() <= 0) {
        break label245;
      }
    }
    label245:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jWn.jVY = true;
        localObject1 = e.b(this.jWn);
        if (((BizTimeLineNewMsgUI)localObject1).jWo != null)
        {
          ((BizTimeLineNewMsgUI)localObject1).jWs.setVisibility(8);
          ((BizTimeLineNewMsgUI)localObject1).jWt.setVisibility(0);
          localObject2 = (TextView)((BizTimeLineNewMsgUI)localObject1).jWt.findViewById(2131821860);
          if (localObject2 != null) {
            ((TextView)localObject2).setText(((BizTimeLineNewMsgUI)localObject1).getString(2131297716));
          }
        }
      }
      AppMethodBeat.o(14148);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.e.2
 * JD-Core Version:    0.7.0.1
 */