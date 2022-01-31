package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.a;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class EmojiMineUI$2
  implements MenuItem.OnMenuItemClickListener
{
  EmojiMineUI$2(EmojiMineUI paramEmojiMineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(53374);
    Object localObject = i.getEmojiStorageMgr().yNo.dzh();
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
      h.h(this.lmf.getContext(), 2131299102, 2131297087);
      AppMethodBeat.o(53374);
      return true;
    }
    if (!com.tencent.mm.sdk.platformtools.at.isConnected(ah.getContext()))
    {
      EmojiMineUI.a(this.lmf);
      AppMethodBeat.o(53374);
      return true;
    }
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.lmf, EmojiSortUI.class);
    this.lmf.startActivity(paramMenuItem);
    AppMethodBeat.o(53374);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiMineUI.2
 * JD-Core Version:    0.7.0.1
 */