package com.tencent.mm.plugin.emoji.magicemoji.core;

import android.view.Surface;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.b;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiPage;", "", "meContext", "Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiServiceContextBase;", "(Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiServiceContextBase;)V", "magicBrushView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getMeContext", "()Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiServiceContextBase;", "rendererView", "Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiRendererView;", "destroy", "", "destroySurface", "resizeSurface", "width", "", "height", "setSurface", "surface", "Landroid/view/Surface;", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a xIB;
  private final MagicEmojiServiceContextBase xIC;
  final c xID;
  private final MagicBrushView xIE;
  
  static
  {
    AppMethodBeat.i(270058);
    xIB = new b.a((byte)0);
    AppMethodBeat.o(270058);
  }
  
  public b(MagicEmojiServiceContextBase paramMagicEmojiServiceContextBase)
  {
    AppMethodBeat.i(270052);
    this.xIC = paramMagicEmojiServiceContextBase;
    this.xID = new c();
    paramMagicEmojiServiceContextBase = MMApplicationContext.getContext();
    s.s(paramMagicEmojiServiceContextBase, "getContext()");
    paramMagicEmojiServiceContextBase = new MagicBrushView(paramMagicEmojiServiceContextBase, (MagicBrushView.b)this.xID);
    paramMagicEmojiServiceContextBase.setEnableTouchEvent(false);
    paramMagicEmojiServiceContextBase.setMagicBrush(this.xIC.dyN().dyM());
    ah localah = ah.aiuX;
    this.xIE = paramMagicEmojiServiceContextBase;
    AppMethodBeat.o(270052);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(270091);
    Log.i("MicroMsg.MagicEmojiPage", "stevecai: destroy magicBrushView");
    this.xIE.destroy();
    AppMethodBeat.o(270091);
  }
  
  public final void dyK()
  {
    AppMethodBeat.i(270083);
    Log.i("MicroMsg.MagicEmojiPage", "stevecai: destroySurface");
    Object localObject = this.xID;
    Surface localSurface = ((c)localObject).surface;
    if (localSurface == null)
    {
      Log.w("MicroMsg.MagicEmojiRendererView", "stevecai: destroyService: try to destroy an empty surface");
      AppMethodBeat.o(270083);
      return;
    }
    ((c)localObject).surface = null;
    localObject = ((c)localObject).eKJ;
    if (localObject != null) {
      ((MagicBrushView.c)localObject).c(localSurface, false);
    }
    AppMethodBeat.o(270083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.core.b
 * JD-Core Version:    0.7.0.1
 */