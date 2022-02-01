package com.tencent.mm.plugin.hld.keyboard.selfdraw;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.a.b;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.a.d;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.a.e;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.a.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "canvas", "Landroid/graphics/Canvas;", "getCanvas", "()Landroid/graphics/Canvas;", "setCanvas", "(Landroid/graphics/Canvas;)V", "drawerMap", "", "", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "getKeyboard", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "bindDrawMethod", "", "drawMethod", "drawButton", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "initCanvas", "plugin-hld_release"})
public final class a
{
  final Map<String, b> DzA;
  final KeyboardView DzB;
  Canvas aBC;
  
  public a(KeyboardView paramKeyboardView)
  {
    AppMethodBeat.i(211959);
    this.DzB = paramKeyboardView;
    this.DzA = ((Map)new LinkedHashMap());
    a((b)new g(this.DzB));
    a((b)new d(this.DzB));
    a((b)new e(this.DzB));
    AppMethodBeat.o(211959);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(211956);
    p.k(paramb, "drawMethod");
    this.DzA.put(paramb.getType(), paramb);
    AppMethodBeat.o(211956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.a
 * JD-Core Version:    0.7.0.1
 */