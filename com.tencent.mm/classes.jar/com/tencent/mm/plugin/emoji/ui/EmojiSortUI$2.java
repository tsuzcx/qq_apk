package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
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
    if (!aq.isConnected(ae.getContext()))
    {
      EmojiSortUI.a(this.jdC);
      return true;
    }
    paramMenuItem = this.jdC;
    paramMenuItem.getString(f.h.app_tip);
    paramMenuItem.faz = h.b(paramMenuItem, paramMenuItem.getString(f.h.app_waiting), true, new EmojiSortUI.3(paramMenuItem));
    paramMenuItem = new ArrayList();
    if ((EmojiSortUI.b(this.jdC) != null) && (EmojiSortUI.b(this.jdC).iVa != null))
    {
      Iterator localIterator = EmojiSortUI.b(this.jdC).iVa.iterator();
      while (localIterator.hasNext()) {
        paramMenuItem.add(((EmojiGroupInfo)localIterator.next()).field_productID);
      }
    }
    EmojiSortUI.a(this.jdC, new t(paramMenuItem, 2));
    g.DO().dJT.a(EmojiSortUI.c(this.jdC), 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI.2
 * JD-Core Version:    0.7.0.1
 */