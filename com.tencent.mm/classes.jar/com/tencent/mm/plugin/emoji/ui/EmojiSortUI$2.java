package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class EmojiSortUI$2
  implements MenuItem.OnMenuItemClickListener
{
  EmojiSortUI$2(EmojiSortUI paramEmojiSortUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(53409);
    if (!at.isConnected(ah.getContext())) {
      EmojiSortUI.a(this.lmp);
    }
    for (;;)
    {
      AppMethodBeat.o(53409);
      return true;
      paramMenuItem = this.lmp;
      paramMenuItem.getString(2131297087);
      paramMenuItem.gsr = h.b(paramMenuItem, paramMenuItem.getString(2131297112), true, new EmojiSortUI.3(paramMenuItem));
      paramMenuItem = new ArrayList();
      if ((EmojiSortUI.b(this.lmp) != null) && (EmojiSortUI.b(this.lmp).lee != null))
      {
        Iterator localIterator = EmojiSortUI.b(this.lmp).lee.iterator();
        while (localIterator.hasNext()) {
          paramMenuItem.add(((EmojiGroupInfo)localIterator.next()).field_productID);
        }
      }
      EmojiSortUI.a(this.lmp, new s(paramMenuItem, 2));
      g.RK().eHt.a(EmojiSortUI.c(this.lmp), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI.2
 * JD-Core Version:    0.7.0.1
 */