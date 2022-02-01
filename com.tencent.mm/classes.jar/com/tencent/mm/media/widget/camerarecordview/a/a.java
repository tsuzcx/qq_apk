package com.tencent.mm.media.widget.camerarecordview.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "black", "", "", "blackModelList", "kotlin.jvm.PlatformType", "enable", "", "ramConfig", "", "totalMemory", "getTotalMemory", "()I", "enableDaemonRecord", "enableDaemonRecordByConfig", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a hbC;
  public final boolean enable;
  public final String hbA;
  private final List<String> hbB;
  private final int hby;
  public final int hbz;
  
  static
  {
    AppMethodBeat.i(161621);
    hbC = new a.a((byte)0);
    AppMethodBeat.o(161621);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(161620);
    this.hby = (d.fI(paramContext) / 1024);
    this.enable = ((b)g.ab(b.class)).a(b.a.pTZ, true);
    this.hbz = ((b)g.ab(b.class)).a(b.a.pUa, 5000);
    this.hbA = ((b)g.ab(b.class)).a(b.a.pUb, "");
    paramContext = this.hbA;
    k.g(paramContext, "blackModelList");
    this.hbB = n.c((CharSequence)paramContext, new char[] { ';' });
    AppMethodBeat.o(161620);
  }
  
  public final boolean auL()
  {
    AppMethodBeat.i(161619);
    Iterator localIterator = ((Iterable)this.hbB).iterator();
    while (localIterator.hasNext()) {
      if (k.g((String)localIterator.next(), Build.MODEL))
      {
        ac.i("MicroMsg.DaemonChecker", "disable by blackModelList Build.MODEL:" + Build.MODEL);
        AppMethodBeat.o(161619);
        return false;
      }
    }
    if (this.hby < this.hbz)
    {
      ac.i("MicroMsg.DaemonChecker", "disable by lower ram:" + this.hby + "  config:" + this.hbz);
      AppMethodBeat.o(161619);
      return false;
    }
    AppMethodBeat.o(161619);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.a
 * JD-Core Version:    0.7.0.1
 */