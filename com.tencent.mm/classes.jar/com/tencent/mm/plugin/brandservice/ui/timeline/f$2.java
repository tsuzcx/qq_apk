package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ai.z;
import com.tencent.mm.cf.h;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import java.util.Collection;
import java.util.List;

final class f$2
  implements Runnable
{
  f$2(f paramf, int paramInt) {}
  
  public final void run()
  {
    Object localObject1;
    if ((this.ffJ == this.igw.getCount() - 1) && (!this.igw.ifk))
    {
      y.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(this.ffJ), Integer.valueOf(this.igw.getCount()) });
      localObject1 = this.igw;
      Object localObject2 = ((f)localObject1).axL();
      if (localObject2 == null) {
        break label208;
      }
      t localt = z.MF();
      long l = ((q)localObject2).field_createTime;
      localObject2 = t.m(localt.dXo.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[] { String.valueOf(l) }, null, null, "createTime DESC limit 20"));
      ((f)localObject1).hfb.addAll((Collection)localObject2);
      ((f)localObject1).notifyDataSetChanged();
      if (((List)localObject2).size() <= 0) {
        break label208;
      }
    }
    label208:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.igw.ifk = true;
        localObject1 = f.b(this.igw);
        if (((BizTimeLineNewMsgUI)localObject1).igy != null)
        {
          ((BizTimeLineNewMsgUI)localObject1).igz.setVisibility(8);
          ((BizTimeLineNewMsgUI)localObject1).igA.setText(((BizTimeLineNewMsgUI)localObject1).getString(b.h.biz_time_line_new_msg_loading_no_more_tips));
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f.2
 * JD-Core Version:    0.7.0.1
 */