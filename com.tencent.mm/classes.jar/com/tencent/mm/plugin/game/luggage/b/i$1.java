package com.tencent.mm.plugin.game.luggage.b;

import android.content.Intent;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;

final class i$1
  implements MMActivity.a
{
  i$1(i parami, a.a parama, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == (this.kNk.hashCode() & 0xFFFF))
    {
      if (paramInt2 != -1) {
        break label86;
      }
      if (paramIntent == null) {
        break label73;
      }
      paramIntent = bk.aM(paramIntent.getStringExtra("gameRegionName"), "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("gameRegionName", paramIntent);
      this.kNj.c("", localHashMap);
    }
    for (;;)
    {
      this.gGJ.gJb = null;
      return;
      label73:
      this.kNj.a("fail", null);
      continue;
      label86:
      if (paramInt2 == 1) {
        this.kNj.a("fail", null);
      } else {
        this.kNj.a("cancel", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.i.1
 * JD-Core Version:    0.7.0.1
 */