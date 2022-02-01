package com.tencent.mm.media.widget.camerarecordview.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "black", "", "", "blackModelList", "kotlin.jvm.PlatformType", "enable", "", "ramConfig", "", "totalMemory", "getTotalMemory", "()I", "enableDaemonRecord", "enableDaemonRecordByConfig", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a lfg;
  public final boolean enable;
  private final int lfc;
  public final int lfd;
  public final String lfe;
  private final List<String> lff;
  
  static
  {
    AppMethodBeat.i(161621);
    lfg = new a((byte)0);
    AppMethodBeat.o(161621);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(161620);
    this.lfc = (d.hw(paramContext) / 1024);
    this.enable = ((b)h.ae(b.class)).a(b.a.vFU, true);
    this.lfd = ((b)h.ae(b.class)).a(b.a.vFV, 5000);
    this.lfe = ((b)h.ae(b.class)).a(b.a.vFW, "");
    paramContext = this.lfe;
    p.j(paramContext, "blackModelList");
    this.lff = n.b((CharSequence)paramContext, new char[] { ';' });
    AppMethodBeat.o(161620);
  }
  
  public final boolean aZc()
  {
    AppMethodBeat.i(161619);
    Iterator localIterator = ((Iterable)this.lff).iterator();
    while (localIterator.hasNext()) {
      if (p.h((String)localIterator.next(), Build.MODEL))
      {
        Log.i("MicroMsg.DaemonChecker", "disable by blackModelList Build.MODEL:" + Build.MODEL);
        AppMethodBeat.o(161619);
        return false;
      }
    }
    if (this.lfc < this.lfd)
    {
      Log.i("MicroMsg.DaemonChecker", "disable by lower ram:" + this.lfc + "  config:" + this.lfd);
      AppMethodBeat.o(161619);
      return false;
    }
    AppMethodBeat.o(161619);
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.a
 * JD-Core Version:    0.7.0.1
 */