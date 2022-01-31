package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.ai.z;
import com.tencent.mm.cf.h;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.t;
import java.util.List;

final class f$1
  implements r.c
{
  f$1(f paramf) {}
  
  public final void a(r.a parama)
  {
    if (parama != null)
    {
      if ((parama.unb != r.b.und) || (parama.igD == null)) {
        break label46;
      }
      f.a(this.igw).add(0, parama.igD);
    }
    for (;;)
    {
      this.igw.notifyDataSetChanged();
      return;
      label46:
      if (parama.unb == r.b.une)
      {
        Object localObject = this.igw;
        parama = ((f)localObject).axL();
        if (parama != null)
        {
          ((f)localObject).hfb.clear();
          localObject = ((f)localObject).hfb;
          t localt = z.MF();
          long l = parama.field_createTime;
          ((List)localObject).addAll(t.m(localt.dXo.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[] { String.valueOf(l) }, null, null, "createTime DESC")));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f.1
 * JD-Core Version:    0.7.0.1
 */