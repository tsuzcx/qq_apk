package com.tencent.mm.plugin.emoji.magicemoji.view;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/view/MEHolderView$Companion;", "", "()V", "EMPTY_RECT", "Landroid/graphics/RectF;", "MODE_SURFACE_VIEW", "", "MODE_TEXTURE_VIEW", "TAG", "", "mode", "switchMode", "", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MEHolderView$a
{
  public static void bVL()
  {
    AppMethodBeat.i(270309);
    String str = "";
    if (MEHolderView.dzp() == 0)
    {
      MEHolderView.Kn(1);
      str = "surface";
    }
    for (;;)
    {
      if (BuildInfo.DEBUG) {
        Toast.makeText(MMApplicationContext.getContext(), (CharSequence)s.X("Switch render mode to ", str), 1).show();
      }
      AppMethodBeat.o(270309);
      return;
      if (MEHolderView.dzp() == 1)
      {
        MEHolderView.Kn(0);
        str = "texture";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.view.MEHolderView.a
 * JD-Core Version:    0.7.0.1
 */