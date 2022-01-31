package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

final class JsApiChooseMedia$a$2
  implements n.d
{
  JsApiChooseMedia$a$2(JsApiChooseMedia.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      JsApiChooseMedia.a.c(this.gvN);
      return;
    }
    JsApiChooseMedia.a.d(this.gvN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.2
 * JD-Core Version:    0.7.0.1
 */