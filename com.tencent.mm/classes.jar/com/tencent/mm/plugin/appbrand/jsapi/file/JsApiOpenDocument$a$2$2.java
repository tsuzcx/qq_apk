package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;
import com.tencent.xweb.util.f;

final class JsApiOpenDocument$a$2$2
  implements n.d
{
  JsApiOpenDocument$a$2$2(JsApiOpenDocument.a.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(143407);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143407);
      return;
      f.ayl(this.hMf.hMe);
      com.tencent.mm.cn.a.a(JsApiOpenDocument.a.d(this.hMf.hMd), this.hMf.val$filePath, this.hMf.cbL, this.hMf.hMe);
      AppMethodBeat.o(143407);
      return;
      f.aym(this.hMf.hMe);
      com.tencent.mm.pluginsdk.ui.tools.a.b(JsApiOpenDocument.a.e(this.hMf.hMd), this.hMf.val$filePath, this.hMf.hMe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.a.2.2
 * JD-Core Version:    0.7.0.1
 */