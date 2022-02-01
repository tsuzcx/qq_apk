package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "", "mode", "", "desc", "", "(Ljava/lang/String;IFLjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getMode", "()F", "SLOW05", "SLOW075", "NORMAL", "FAST15", "FAST20", "Companion", "plugin-brandservice_release"})
public enum c$a
{
  public static List<? extends a> noe;
  public static final a nof;
  public final String desc;
  public final float nod;
  
  static
  {
    AppMethodBeat.i(179024);
    a locala1 = new a("SLOW05", 0, 0.5F, "0.5X");
    nnX = locala1;
    a locala2 = new a("SLOW075", 1, 0.75F, "0.75X");
    nnY = locala2;
    a locala3 = new a("NORMAL", 2, 1.0F, "1.0X");
    nnZ = locala3;
    a locala4 = new a("FAST15", 3, 1.5F, "1.5X");
    noa = locala4;
    a locala5 = new a("FAST20", 4, 2.0F, "2.0X");
    nob = locala5;
    noc = new a[] { locala1, locala2, locala3, locala4, locala5 };
    nof = new a((byte)0);
    noe = j.listOf(new a[] { nnX, nnY, nnZ, noa, nob });
    AppMethodBeat.o(179024);
  }
  
  private c$a(float paramFloat, String paramString)
  {
    this.nod = paramFloat;
    this.desc = paramString;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed$Companion;", "", "()V", "speedList", "", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "plugin-brandservice_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.c.a
 * JD-Core Version:    0.7.0.1
 */