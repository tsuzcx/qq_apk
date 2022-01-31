package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class CleanChattingUI$6
  implements Runnable
{
  CleanChattingUI$6(CleanChattingUI paramCleanChattingUI) {}
  
  public final void run()
  {
    if (!CleanChattingUI.c(this.iDb))
    {
      y.i("MicroMsg.CleanChattingUI", "load contact cursor now");
      CleanChattingUI.d(this.iDb);
      ai.d(new CleanChattingUI.6.1(this));
      Cursor localCursor = com.tencent.mm.plugin.h.b.ayE().ayF().ayP();
      if (localCursor != null) {
        while (localCursor.moveToNext())
        {
          c localc = new c();
          localc.username = localCursor.getString(0);
          localc.size = localCursor.getLong(1);
          CleanChattingUI.f(this.iDb).add(localc);
        }
      }
      ai.d(new CleanChattingUI.6.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.6
 * JD-Core Version:    0.7.0.1
 */