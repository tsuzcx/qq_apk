package com.tencent.mm.plugin.emoji.ui;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.ui.tools.b.b;
import com.tencent.mm.ui.tools.b.b.a;

final class EmojiCustomUI$2
  implements b.a
{
  EmojiCustomUI$2(EmojiCustomUI paramEmojiCustomUI, int paramInt, String paramString) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(53300);
    if (EmojiCustomUI.j(this.llF) == null)
    {
      if (this.llG != 0) {
        break label119;
      }
      EmojiCustomUI.a(this.llF, i.getEmojiStorageMgr().yNn.d(this.iiy, "", EmojiGroupInfo.yPg, EmojiInfo.yPn, paramb.Ayz, ""));
    }
    for (;;)
    {
      i.blp().a(this.llF.getContext(), EmojiCustomUI.j(this.llF), 1, r.Zn());
      if (EmojiCustomUI.f(this.llF) != null)
      {
        EmojiCustomUI.f(this.llF).bmC();
        EmojiCustomUI.f(this.llF).notifyDataSetChanged();
      }
      AppMethodBeat.o(53300);
      return;
      label119:
      EmojiCustomUI.a(this.llF, i.getEmojiStorageMgr().yNn.d(this.iiy, "", EmojiGroupInfo.yPg, EmojiInfo.yPo, paramb.Ayz, ""));
    }
  }
  
  public final void bmr()
  {
    AppMethodBeat.i(53301);
    com.tencent.mm.ui.base.h.a(this.llF.getContext(), this.llF.getContext().getString(2131299129), "", this.llF.getContext().getString(2131300718), false, null);
    AppMethodBeat.o(53301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.2
 * JD-Core Version:    0.7.0.1
 */