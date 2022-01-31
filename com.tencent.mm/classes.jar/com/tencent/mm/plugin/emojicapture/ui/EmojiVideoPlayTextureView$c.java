package com.tencent.mm.plugin.emojicapture.ui;

import a.f.a.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView$playerCallback$1", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "onCompletion", "", "onError", "what", "", "error", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "width", "height", "degrees", "plugin-emojicapture_release"})
public final class EmojiVideoPlayTextureView$c
  implements c
{
  public final void Es()
  {
    AppMethodBeat.i(2908);
    e.a locala = EmojiVideoPlayTextureView.m(this.lxL);
    if (locala != null)
    {
      locala.Es();
      AppMethodBeat.o(2908);
      return;
    }
    AppMethodBeat.o(2908);
  }
  
  public final void R(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(2911);
    ab.i(EmojiVideoPlayTextureView.b(this.lxL), "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    EmojiVideoPlayTextureView.a(this.lxL, paramInt1);
    EmojiVideoPlayTextureView.b(this.lxL, paramInt2);
    e.a locala = EmojiVideoPlayTextureView.m(this.lxL);
    if (locala != null)
    {
      locala.dQ(EmojiVideoPlayTextureView.q(this.lxL), EmojiVideoPlayTextureView.r(this.lxL));
      AppMethodBeat.o(2911);
      return;
    }
    AppMethodBeat.o(2911);
  }
  
  public final void boW()
  {
    AppMethodBeat.i(2910);
    Object localObject = EmojiVideoPlayTextureView.n(this.lxL);
    if (localObject != null) {
      ((b)localObject).S(Boolean.valueOf(EmojiVideoPlayTextureView.o(this.lxL)));
    }
    if (!EmojiVideoPlayTextureView.o(this.lxL))
    {
      ab.d(EmojiVideoPlayTextureView.b(this.lxL), "player seek done, but don't play now.");
      EmojiVideoPlayTextureView.p(this.lxL);
      AppMethodBeat.o(2910);
      return;
    }
    String str = EmojiVideoPlayTextureView.b(this.lxL);
    localObject = EmojiVideoPlayTextureView.f(this.lxL);
    if (localObject != null) {}
    for (localObject = ((i)localObject).bau();; localObject = null)
    {
      ab.d(str, "%s player seek done", new Object[] { localObject });
      localObject = EmojiVideoPlayTextureView.f(this.lxL);
      if (localObject == null) {
        break;
      }
      ((i)localObject).start();
      AppMethodBeat.o(2910);
      return;
    }
    AppMethodBeat.o(2910);
  }
  
  public final void mG()
  {
    AppMethodBeat.i(2907);
    ab.i(EmojiVideoPlayTextureView.b(this.lxL), "onPrepared: ");
    EmojiVideoPlayTextureView.h(this.lxL);
    e.a locala = EmojiVideoPlayTextureView.m(this.lxL);
    if (locala != null) {
      locala.mG();
    }
    this.lxL.requestLayout();
    AppMethodBeat.o(2907);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2909);
    e.a locala = EmojiVideoPlayTextureView.m(this.lxL);
    if (locala != null)
    {
      locala.onError(paramInt1, paramInt2);
      AppMethodBeat.o(2909);
      return;
    }
    AppMethodBeat.o(2909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView.c
 * JD-Core Version:    0.7.0.1
 */