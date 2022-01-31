package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.choosemsgfile.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class e$1
  implements g.a
{
  e$1(e parame) {}
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(54345);
    if (parama == null)
    {
      ab.e("MicroMsg.ChooseMsgFileListUIController", "[onCheck] item is null, err");
      AppMethodBeat.o(54345);
      return;
    }
    ab.i("MicroMsg.ChooseMsgFileListUIController", "[onCheck] isChecked :%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      parama.bgo();
      e.a(this.kFx).ik(parama.kEz.field_msgId);
      b.a(parama, new e.1.1(this, parama, paramv), this.kFx.bgy());
    }
    for (;;)
    {
      parama.T(paramv);
      AppMethodBeat.o(54345);
      return;
      parama.bgs();
      e.a(this.kFx).il(parama.kEz.field_msgId);
      e.a(this.kFx).ii(parama.kEz.field_msgId);
      if (e.a(this.kFx).bgB()) {
        al.d(new e.1.2(this));
      }
      this.kFx.kFr.bgE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.e.1
 * JD-Core Version:    0.7.0.1
 */