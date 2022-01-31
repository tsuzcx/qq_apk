package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class JsApiChooseMedia$a$1
  implements View.OnCreateContextMenuListener
{
  JsApiChooseMedia$a$1(JsApiChooseMedia.a parama) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(131168);
    paramContextMenu.add(0, 1, 0, JsApiChooseMedia.a.a(this.hRe).getString(2131296938));
    paramContextMenu.add(0, 2, 1, JsApiChooseMedia.a.b(this.hRe).getString(2131296945));
    AppMethodBeat.o(131168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.1
 * JD-Core Version:    0.7.0.1
 */