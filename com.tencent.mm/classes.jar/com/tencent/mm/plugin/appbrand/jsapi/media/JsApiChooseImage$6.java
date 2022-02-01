package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class JsApiChooseImage$6
  implements View.OnCreateContextMenuListener
{
  JsApiChooseImage$6(JsApiChooseImage paramJsApiChooseImage, Context paramContext) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(226863);
    paramContextMenu.add(0, 1, 0, this.val$context.getString(2131755822));
    paramContextMenu.add(0, 2, 1, this.val$context.getString(2131755831));
    AppMethodBeat.o(226863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.6
 * JD-Core Version:    0.7.0.1
 */