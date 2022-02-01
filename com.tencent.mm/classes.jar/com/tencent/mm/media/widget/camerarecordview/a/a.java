package com.tencent.mm.media.widget.camerarecordview.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "black", "", "", "blackModelList", "kotlin.jvm.PlatformType", "enable", "", "ramConfig", "", "totalMemory", "getTotalMemory", "()I", "enableDaemonRecord", "enableDaemonRecordByConfig", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a htK;
  public final boolean enable;
  private final int htG;
  public final int htH;
  public final String htI;
  private final List<String> htJ;
  
  static
  {
    AppMethodBeat.i(161621);
    htK = new a.a((byte)0);
    AppMethodBeat.o(161621);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(161620);
    this.htG = (d.fN(paramContext) / 1024);
    this.enable = ((b)g.ab(b.class)).a(b.a.qyF, true);
    this.htH = ((b)g.ab(b.class)).a(b.a.qyG, 5000);
    this.htI = ((b)g.ab(b.class)).a(b.a.qyH, "");
    paramContext = this.htI;
    p.g(paramContext, "blackModelList");
    this.htJ = n.c((CharSequence)paramContext, new char[] { ';' });
    AppMethodBeat.o(161620);
  }
  
  public final boolean axy()
  {
    AppMethodBeat.i(161619);
    Iterator localIterator = ((Iterable)this.htJ).iterator();
    while (localIterator.hasNext()) {
      if (p.i((String)localIterator.next(), Build.MODEL))
      {
        ad.i("MicroMsg.DaemonChecker", "disable by blackModelList Build.MODEL:" + Build.MODEL);
        AppMethodBeat.o(161619);
        return false;
      }
    }
    if (this.htG < this.htH)
    {
      ad.i("MicroMsg.DaemonChecker", "disable by lower ram:" + this.htG + "  config:" + this.htH);
      AppMethodBeat.o(161619);
      return false;
    }
    AppMethodBeat.o(161619);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.a
 * JD-Core Version:    0.7.0.1
 */