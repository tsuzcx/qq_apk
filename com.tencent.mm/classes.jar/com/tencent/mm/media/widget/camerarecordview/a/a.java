package com.tencent.mm.media.widget.camerarecordview.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "black", "", "", "blackModelList", "kotlin.jvm.PlatformType", "enable", "", "ramConfig", "", "totalMemory", "getTotalMemory", "()I", "enableDaemonRecord", "enableDaemonRecordByConfig", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a nJM;
  public final boolean enable;
  private final int nJN;
  public final int nJO;
  public final String nJP;
  private final List<String> nJQ;
  
  static
  {
    AppMethodBeat.i(161621);
    nJM = new a.a((byte)0);
    AppMethodBeat.o(161621);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(161620);
    this.nJN = (d.iR(paramContext) / 1024);
    this.enable = ((c)h.ax(c.class)).a(c.a.yVu, true);
    this.nJO = ((c)h.ax(c.class)).a(c.a.yVv, 5000);
    this.nJP = ((c)h.ax(c.class)).a(c.a.yVw, "");
    paramContext = this.nJP;
    s.s(paramContext, "blackModelList");
    this.nJQ = n.a((CharSequence)paramContext, new char[] { ';' }, 0, 6);
    AppMethodBeat.o(161620);
  }
  
  public final boolean bub()
  {
    AppMethodBeat.i(161619);
    Iterator localIterator = ((Iterable)this.nJQ).iterator();
    while (localIterator.hasNext()) {
      if (s.p((String)localIterator.next(), q.aPo()))
      {
        Log.i("MicroMsg.DaemonChecker", s.X("disable by blackModelList Build.MODEL:", q.aPo()));
        AppMethodBeat.o(161619);
        return false;
      }
    }
    if (this.nJN < this.nJO)
    {
      Log.i("MicroMsg.DaemonChecker", "disable by lower ram:" + this.nJN + "  config:" + this.nJO);
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