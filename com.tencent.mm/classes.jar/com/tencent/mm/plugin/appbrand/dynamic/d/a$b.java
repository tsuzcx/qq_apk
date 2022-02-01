package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.h.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

class a$b
  implements b<Bundle, Bundle>
{
  private static final String[] lnk = { "scope.userLocation" };
  
  private static void a(com.tencent.mm.ipcinvoker.d<Bundle> paramd, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(121301);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("ret", paramBoolean);
    localBundle.putString("reason", paramString);
    paramd.bn(localBundle);
    AppMethodBeat.o(121301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.b
 * JD-Core Version:    0.7.0.1
 */