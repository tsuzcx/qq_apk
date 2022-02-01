package com.tencent.mm.plugin.hld.keyboard.selfdraw;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.a.b;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.a.d;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.a.e;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.a.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "canvas", "Landroid/graphics/Canvas;", "getCanvas", "()Landroid/graphics/Canvas;", "setCanvas", "(Landroid/graphics/Canvas;)V", "drawerMap", "", "", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/drawmethod/DrawMethod;", "getKeyboard", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "bindDrawMethod", "", "drawMethod", "drawButton", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "initCanvas", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  final KeyboardView JsC;
  final Map<String, b> JsD;
  Canvas cxr;
  
  public a(KeyboardView paramKeyboardView)
  {
    AppMethodBeat.i(313004);
    this.JsC = paramKeyboardView;
    this.JsD = ((Map)new LinkedHashMap());
    a((b)new g(this.JsC));
    a((b)new d(this.JsC));
    a((b)new e(this.JsC));
    AppMethodBeat.o(313004);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(313013);
    s.u(paramb, "drawMethod");
    this.JsD.put(paramb.getType(), paramb);
    AppMethodBeat.o(313013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.a
 * JD-Core Version:    0.7.0.1
 */