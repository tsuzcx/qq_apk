package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "", "mode", "", "desc", "", "(Ljava/lang/String;IFLjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getMode", "()F", "SLOW05", "SLOW075", "NORMAL", "FAST15", "FAST20", "Companion", "plugin-brandservice_release"})
public enum c$a
{
  public static List<? extends a> nRe;
  public static final a nRf;
  public final String desc;
  public final float nRd;
  
  static
  {
    AppMethodBeat.i(179024);
    a locala1 = new a("SLOW05", 0, 0.5F, "0.5X");
    nQX = locala1;
    a locala2 = new a("SLOW075", 1, 0.75F, "0.75X");
    nQY = locala2;
    a locala3 = new a("NORMAL", 2, 1.0F, "1.0X");
    nQZ = locala3;
    a locala4 = new a("FAST15", 3, 1.5F, "1.5X");
    nRa = locala4;
    a locala5 = new a("FAST20", 4, 2.0F, "2.0X");
    nRb = locala5;
    nRc = new a[] { locala1, locala2, locala3, locala4, locala5 };
    nRf = new a((byte)0);
    nRe = j.listOf(new a[] { nQX, nQY, nQZ, nRa, nRb });
    AppMethodBeat.o(179024);
  }
  
  private c$a(float paramFloat, String paramString)
  {
    this.nRd = paramFloat;
    this.desc = paramString;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed$Companion;", "", "()V", "speedList", "", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "plugin-brandservice_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.c.a
 * JD-Core Version:    0.7.0.1
 */