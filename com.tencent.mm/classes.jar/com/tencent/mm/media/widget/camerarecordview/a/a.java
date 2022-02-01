package com.tencent.mm.media.widget.camerarecordview.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "black", "", "", "blackModelList", "kotlin.jvm.PlatformType", "enable", "", "ramConfig", "", "totalMemory", "getTotalMemory", "()I", "enableDaemonRecord", "enableDaemonRecordByConfig", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a iqa;
  public final boolean enable;
  private final int ipW;
  public final int ipX;
  public final String ipY;
  private final List<String> ipZ;
  
  static
  {
    AppMethodBeat.i(161621);
    iqa = new a((byte)0);
    AppMethodBeat.o(161621);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(161620);
    this.ipW = (d.gy(paramContext) / 1024);
    this.enable = ((b)g.af(b.class)).a(b.a.rYX, true);
    this.ipX = ((b)g.af(b.class)).a(b.a.rYY, 5000);
    this.ipY = ((b)g.af(b.class)).a(b.a.rYZ, "");
    paramContext = this.ipY;
    p.g(paramContext, "blackModelList");
    this.ipZ = n.b((CharSequence)paramContext, new char[] { ';' });
    AppMethodBeat.o(161620);
  }
  
  public final boolean aQl()
  {
    AppMethodBeat.i(161619);
    Iterator localIterator = ((Iterable)this.ipZ).iterator();
    while (localIterator.hasNext()) {
      if (p.j((String)localIterator.next(), Build.MODEL))
      {
        Log.i("MicroMsg.DaemonChecker", "disable by blackModelList Build.MODEL:" + Build.MODEL);
        AppMethodBeat.o(161619);
        return false;
      }
    }
    if (this.ipW < this.ipX)
    {
      Log.i("MicroMsg.DaemonChecker", "disable by lower ram:" + this.ipW + "  config:" + this.ipX);
      AppMethodBeat.o(161619);
      return false;
    }
    AppMethodBeat.o(161619);
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.a
 * JD-Core Version:    0.7.0.1
 */