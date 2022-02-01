package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.h.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

class a$b
  implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
{
  private static final String[] kjB = { "scope.userLocation" };
  
  private static void a(d<Bundle> paramd, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(121301);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("ret", paramBoolean);
    localBundle.putString("reason", paramString);
    paramd.be(localBundle);
    AppMethodBeat.o(121301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.b
 * JD-Core Version:    0.7.0.1
 */