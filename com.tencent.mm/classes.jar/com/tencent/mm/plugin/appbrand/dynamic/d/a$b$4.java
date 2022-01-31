package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.h.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class a$b$4
  implements Runnable
{
  a$b$4(a.b paramb, String paramString1, a.a parama, LinkedList paramLinkedList, String paramString2, String paramString3) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(10820);
    Object localObject = a.aAa().Bn(this.hoG);
    if (localObject == null)
    {
      ab.e("MicroMsg.IPCInvoke_DoAuthorize", "dynamicPageView not found! widgetid[%s]", new Object[] { this.hoG });
      AppMethodBeat.o(10820);
      return;
    }
    localObject = new n(((IPCDynamicPageView)localObject).getContext());
    a.b.4.1 local1 = new a.b.4.1(this);
    if ((this.hoL != null) && (this.hoL.size() > 0)) {
      if (((n)localObject).a(this.hoL, this.gWJ, this.hoM, local1)) {
        break label153;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("retCode", -2);
        this.hoK.o((Bundle)localObject);
      }
      AppMethodBeat.o(10820);
      return;
      ab.e("MicroMsg.IPCInvoke_DoAuthorize", "scopeInfoList is empty!");
      continue;
      label153:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.b.4
 * JD-Core Version:    0.7.0.1
 */