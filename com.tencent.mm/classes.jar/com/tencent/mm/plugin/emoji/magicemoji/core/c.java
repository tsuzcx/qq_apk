package com.tencent.mm.plugin.emoji.magicemoji.core;

import android.view.Surface;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.MagicBrushView.b;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiRendererView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "()V", "surface", "Landroid/view/Surface;", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "destroySurface", "", "getSurface", "onDestroy", "setSurface", "width", "", "height", "setSurfaceListener", "l", "switchRenderMode", "forceRecreate", "", "renderModeFlag", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "updateSurfaceSize", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements MagicBrushView.b
{
  public static final c.a xIF;
  private final View eKH;
  MagicBrushView.c eKJ;
  Surface surface;
  
  static
  {
    AppMethodBeat.i(270054);
    xIF = new c.a((byte)0);
    AppMethodBeat.o(270054);
  }
  
  public final void a(boolean paramBoolean, int paramInt, b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(270078);
    s.u(paramb, "callback");
    s.u(paramMBRuntime, "runtime");
    paramb.invoke(Boolean.FALSE);
    AppMethodBeat.o(270078);
  }
  
  public final View getThisView()
  {
    return this.eKH;
  }
  
  public final MagicBrushView.h getViewType()
  {
    return MagicBrushView.h.eKY;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(270063);
    Log.i("MicroMsg.MagicEmojiRendererView", "stevecai: onDestroy() called");
    this.surface = null;
    this.eKJ = null;
    AppMethodBeat.o(270063);
  }
  
  public final void setSurfaceListener(MagicBrushView.c paramc)
  {
    AppMethodBeat.i(270068);
    Log.i("MicroMsg.MagicEmojiRendererView", s.X("stevecai: setSurfaceListener() called with: l = ", paramc));
    this.eKJ = paramc;
    AppMethodBeat.o(270068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.core.c
 * JD-Core Version:    0.7.0.1
 */