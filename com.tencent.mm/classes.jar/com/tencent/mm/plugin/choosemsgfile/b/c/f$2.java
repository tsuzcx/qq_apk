package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.choosemsgfile.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class f$2
  implements g.a
{
  f$2(f paramf) {}
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(54363);
    if (parama == null)
    {
      ab.e("MicroMsg.ChooseMsgFileUIController", "[onCheck] item is null, err");
      AppMethodBeat.o(54363);
      return;
    }
    ab.i("MicroMsg.ChooseMsgFileUIController", "[onCheck] isChecked:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      parama.bgo();
      f.a(this.kFK).ik(parama.kEz.field_msgId);
      b.a(parama, new f.2.1(this, parama, paramv), this.kFK.bgy());
    }
    for (;;)
    {
      parama.T(paramv);
      AppMethodBeat.o(54363);
      return;
      parama.bgs();
      f.a(this.kFK).il(parama.kEz.field_msgId);
      f.a(this.kFK).ii(parama.kEz.field_msgId);
      if (f.a(this.kFK).bgB()) {
        al.d(new f.2.2(this));
      }
      this.kFK.kFr.bgE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.f.2
 * JD-Core Version:    0.7.0.1
 */