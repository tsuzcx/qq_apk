package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;

final class JsApiChooseMedia$3
  implements View.OnCreateContextMenuListener
{
  JsApiChooseMedia$3(JsApiChooseMedia paramJsApiChooseMedia, Context paramContext) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(329254);
    paramContextMenu.add(0, 1, 0, this.rXK.getString(ba.i.app_field_mmsight));
    paramContextMenu.add(0, 2, 1, this.rXK.getString(ba.i.app_field_select_new_pic));
    AppMethodBeat.o(329254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.3
 * JD-Core Version:    0.7.0.1
 */