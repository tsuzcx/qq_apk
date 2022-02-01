package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr;", "", "()V", "value", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "curSpeed", "getCurSpeed", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "setCurSpeed", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;)V", "lastSpeed", "getLastSpeed", "setLastSpeed", "resetCurSpeed", "", "MPVideoSpeed", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a vZP;
  private static a vZQ;
  
  static
  {
    AppMethodBeat.i(179028);
    vZP = new a();
    AppMethodBeat.o(179028);
  }
  
  public static a dig()
  {
    if (vZQ == null) {
      return a.vZW;
    }
    return vZQ;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "", "mode", "", "desc", "", "(Ljava/lang/String;IFLjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getMode", "()F", "SLOW05", "SLOW075", "NORMAL", "FAST15", "FAST20", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    public static final a vZR;
    public static List<? extends a> vZT;
    private final String desc;
    final float vZS;
    
    static
    {
      AppMethodBeat.i(179024);
      vZU = new a("SLOW05", 0, 0.5F, "0.5X");
      vZV = new a("SLOW075", 1, 0.75F, "0.75X");
      vZW = new a("NORMAL", 2, 1.0F, "1.0X");
      vZX = new a("FAST15", 3, 1.5F, "1.5X");
      vZY = new a("FAST20", 4, 2.0F, "2.0X");
      vZZ = new a[] { vZU, vZV, vZW, vZX, vZY };
      vZR = new a((byte)0);
      vZT = p.listOf(new a[] { vZU, vZV, vZW, vZX, vZY });
      AppMethodBeat.o(179024);
    }
    
    private a(float paramFloat, String paramString)
    {
      this.vZS = paramFloat;
      this.desc = paramString;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed$Companion;", "", "()V", "speedList", "", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */