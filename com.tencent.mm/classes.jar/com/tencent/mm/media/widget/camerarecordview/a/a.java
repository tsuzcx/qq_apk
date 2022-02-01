package com.tencent.mm.media.widget.camerarecordview.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "black", "", "", "blackModelList", "kotlin.jvm.PlatformType", "enable", "", "ramConfig", "", "totalMemory", "getTotalMemory", "()I", "enableDaemonRecord", "enableDaemonRecordByConfig", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a hwy;
  public final boolean enable;
  private final int hwu;
  public final int hwv;
  public final String hww;
  private final List<String> hwx;
  
  static
  {
    AppMethodBeat.i(161621);
    hwy = new a.a((byte)0);
    AppMethodBeat.o(161621);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(161620);
    this.hwu = (d.fT(paramContext) / 1024);
    this.enable = ((b)g.ab(b.class)).a(b.a.qFL, true);
    this.hwv = ((b)g.ab(b.class)).a(b.a.qFM, 5000);
    this.hww = ((b)g.ab(b.class)).a(b.a.qFN, "");
    paramContext = this.hww;
    p.g(paramContext, "blackModelList");
    this.hwx = n.c((CharSequence)paramContext, new char[] { ';' });
    AppMethodBeat.o(161620);
  }
  
  public final boolean axN()
  {
    AppMethodBeat.i(161619);
    Iterator localIterator = ((Iterable)this.hwx).iterator();
    while (localIterator.hasNext()) {
      if (p.i((String)localIterator.next(), Build.MODEL))
      {
        ae.i("MicroMsg.DaemonChecker", "disable by blackModelList Build.MODEL:" + Build.MODEL);
        AppMethodBeat.o(161619);
        return false;
      }
    }
    if (this.hwu < this.hwv)
    {
      ae.i("MicroMsg.DaemonChecker", "disable by lower ram:" + this.hwu + "  config:" + this.hwv);
      AppMethodBeat.o(161619);
      return false;
    }
    AppMethodBeat.o(161619);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.a
 * JD-Core Version:    0.7.0.1
 */