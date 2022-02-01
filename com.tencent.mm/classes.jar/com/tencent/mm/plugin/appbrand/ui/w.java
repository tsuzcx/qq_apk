package com.tencent.mm.plugin.appbrand.ui;

import android.os.Looper;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.service.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIFinishIPCNotify;", "", "()V", "doNotify", "", "processName", "", "appbrandUIClazz", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final w ufh;
  
  static
  {
    AppMethodBeat.i(322155);
    ufh = new w();
    AppMethodBeat.o(322155);
  }
  
  public static final void doNotify(String paramString)
  {
    AppMethodBeat.i(322144);
    fp(MainProcessIPCService.PROCESS_NAME, paramString);
    AppMethodBeat.o(322144);
  }
  
  public static final void fp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(322141);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(322141);
      return;
    }
    localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(322141);
      return;
    }
    com.tencent.mm.ipcinvoker.a.a(paramString1, (Parcelable)new IPCString(paramString2), (d)w..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(322141);
  }
  
  private static final void i(IPCString paramIPCString, f paramf)
  {
    AppMethodBeat.i(322150);
    if (paramIPCString != null)
    {
      paramIPCString = paramIPCString.value;
      if (paramIPCString != null)
      {
        e locale = new e();
        locale.tTx.tTw = paramIPCString;
        locale.asyncPublish(Looper.getMainLooper());
      }
    }
    if (paramf != null) {
      com.tencent.mm.ipcinvoker.wx_extension.b.a.b(paramf);
    }
    AppMethodBeat.o(322150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.w
 * JD-Core Version:    0.7.0.1
 */