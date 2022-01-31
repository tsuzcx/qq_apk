package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class EmojiMineUI$2
  implements MenuItem.OnMenuItemClickListener
{
  EmojiMineUI$2(EmojiMineUI paramEmojiMineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    Object localObject = i.getEmojiStorageMgr().uBc.cww();
    paramMenuItem = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject).next();
      if (localEmojiGroupInfo.field_type != EmojiGroupInfo.TYPE_CUSTOM) {
        paramMenuItem.add(localEmojiGroupInfo);
      }
    }
    if (paramMenuItem.size() <= 1)
    {
      h.h(this.jdu.mController.uMN, f.h.emoji_cant_sort_tip, f.h.app_tip);
      return true;
    }
    if (!aq.isConnected(ae.getContext()))
    {
      EmojiMineUI.a(this.jdu);
      return true;
    }
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.jdu, EmojiSortUI.class);
    this.jdu.startActivity(paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiMineUI.2
 * JD-Core Version:    0.7.0.1
 */