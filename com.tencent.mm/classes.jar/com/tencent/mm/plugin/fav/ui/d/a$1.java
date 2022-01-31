package com.tencent.mm.plugin.fav.ui.d;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import java.util.Map;

final class a$1
  implements CompoundButton.OnCheckedChangeListener
{
  a$1(a parama) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(74612);
    if (paramCompoundButton.getTag() == null)
    {
      AppMethodBeat.o(74612);
      return;
    }
    paramCompoundButton = (com.tencent.mm.plugin.fav.a.g)paramCompoundButton.getTag();
    if (paramBoolean)
    {
      com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramCompoundButton.field_localId);
      this.mCT.mCS.mzq.put(Long.valueOf(paramCompoundButton.field_localId), localg);
    }
    for (;;)
    {
      if (this.mCT.mCS.mCU != null) {
        this.mCT.mCS.mCU.kf(paramCompoundButton.field_localId);
      }
      AppMethodBeat.o(74612);
      return;
      this.mCT.mCS.mzq.remove(Long.valueOf(paramCompoundButton.field_localId));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a.1
 * JD-Core Version:    0.7.0.1
 */