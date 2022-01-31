package com.tencent.mm.plugin.emojicapture.ui;

import a.d.a.b;
import com.tencent.mm.plugin.s.c;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.y;

public final class EmojiVideoPlayTextureView$c
  implements c
{
  public final void F(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i(EmojiVideoPlayTextureView.b(this.joW), "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    EmojiVideoPlayTextureView.a(this.joW, paramInt1);
    EmojiVideoPlayTextureView.b(this.joW, paramInt2);
    f.a locala = EmojiVideoPlayTextureView.m(this.joW);
    if (locala != null) {
      locala.cw(EmojiVideoPlayTextureView.q(this.joW), EmojiVideoPlayTextureView.r(this.joW));
    }
  }
  
  public final void aKN()
  {
    Object localObject = EmojiVideoPlayTextureView.n(this.joW);
    if (localObject != null) {
      ((b)localObject).W(Boolean.valueOf(EmojiVideoPlayTextureView.o(this.joW)));
    }
    if (!EmojiVideoPlayTextureView.o(this.joW))
    {
      y.d(EmojiVideoPlayTextureView.b(this.joW), "player seek done, but don't play now.");
      EmojiVideoPlayTextureView.p(this.joW);
      return;
    }
    String str = EmojiVideoPlayTextureView.b(this.joW);
    localObject = EmojiVideoPlayTextureView.f(this.joW);
    if (localObject != null) {}
    for (localObject = ((i)localObject).ayN();; localObject = null)
    {
      y.d(str, "%s player seek done", new Object[] { localObject });
      localObject = EmojiVideoPlayTextureView.f(this.joW);
      if (localObject == null) {
        break;
      }
      ((i)localObject).start();
      return;
    }
  }
  
  public final void kA()
  {
    EmojiVideoPlayTextureView.h(this.joW);
    f.a locala = EmojiVideoPlayTextureView.m(this.joW);
    if (locala != null) {
      locala.kA();
    }
    this.joW.requestLayout();
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    f.a locala = EmojiVideoPlayTextureView.m(this.joW);
    if (locala != null) {
      locala.onError(paramInt1, paramInt2);
    }
  }
  
  public final void ug()
  {
    f.a locala = EmojiVideoPlayTextureView.m(this.joW);
    if (locala != null) {
      locala.ug();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView.c
 * JD-Core Version:    0.7.0.1
 */