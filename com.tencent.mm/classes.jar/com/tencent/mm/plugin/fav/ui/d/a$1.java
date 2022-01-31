package com.tencent.mm.plugin.fav.ui.d;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import java.util.Map;

final class a$1
  implements CompoundButton.OnCheckedChangeListener
{
  a$1(a parama) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getTag() == null) {}
    for (;;)
    {
      return;
      paramCompoundButton = (com.tencent.mm.plugin.fav.a.g)paramCompoundButton.getTag();
      if (paramBoolean)
      {
        com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramCompoundButton.field_localId);
        this.kip.kio.keH.put(Long.valueOf(paramCompoundButton.field_localId), localg);
      }
      while (this.kip.kio.kiq != null)
      {
        this.kip.kio.kiq.eI(paramCompoundButton.field_localId);
        return;
        this.kip.kio.keH.remove(Long.valueOf(paramCompoundButton.field_localId));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a.1
 * JD-Core Version:    0.7.0.1
 */