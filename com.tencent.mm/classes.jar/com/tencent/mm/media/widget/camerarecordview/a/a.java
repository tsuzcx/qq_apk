package com.tencent.mm.media.widget.camerarecordview.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "black", "", "", "blackModelList", "kotlin.jvm.PlatformType", "enable", "", "ramConfig", "", "totalMemory", "getTotalMemory", "()I", "enableDaemonRecord", "enableDaemonRecordByConfig", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a gBg;
  public final boolean enable;
  private final int gBc;
  public final int gBd;
  public final String gBe;
  private final List<String> gBf;
  
  static
  {
    AppMethodBeat.i(161621);
    gBg = new a((byte)0);
    AppMethodBeat.o(161621);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(161620);
    this.gBc = (d.fw(paramContext) / 1024);
    this.enable = ((b)g.ab(b.class)).a(b.a.pqo, true);
    this.gBd = ((b)g.ab(b.class)).a(b.a.pqp, 5000);
    this.gBe = ((b)g.ab(b.class)).a(b.a.pqq, "");
    paramContext = this.gBe;
    k.g(paramContext, "blackModelList");
    this.gBf = n.b((CharSequence)paramContext, new char[] { ';' });
    AppMethodBeat.o(161620);
  }
  
  public final boolean anV()
  {
    AppMethodBeat.i(161619);
    Iterator localIterator = ((Iterable)this.gBf).iterator();
    while (localIterator.hasNext()) {
      if (k.g((String)localIterator.next(), Build.MODEL))
      {
        ad.i("MicroMsg.DaemonChecker", "disable by blackModelList Build.MODEL:" + Build.MODEL);
        AppMethodBeat.o(161619);
        return false;
      }
    }
    if (this.gBc < this.gBd)
    {
      ad.i("MicroMsg.DaemonChecker", "disable by lower ram:" + this.gBc + "  config:" + this.gBd);
      AppMethodBeat.o(161619);
      return false;
    }
    AppMethodBeat.o(161619);
    return true;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.a
 * JD-Core Version:    0.7.0.1
 */