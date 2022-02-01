package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "", "mode", "", "desc", "", "(Ljava/lang/String;IFLjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getMode", "()F", "SLOW05", "SLOW075", "NORMAL", "FAST15", "FAST20", "Companion", "plugin-brandservice_release"})
public enum a$a
{
  public static List<? extends a> sUU;
  public static final a sUV;
  final String desc;
  final float sUT;
  
  static
  {
    AppMethodBeat.i(179024);
    a locala1 = new a("SLOW05", 0, 0.5F, "0.5X");
    sUN = locala1;
    a locala2 = new a("SLOW075", 1, 0.75F, "0.75X");
    sUO = locala2;
    a locala3 = new a("NORMAL", 2, 1.0F, "1.0X");
    sUP = locala3;
    a locala4 = new a("FAST15", 3, 1.5F, "1.5X");
    sUQ = locala4;
    a locala5 = new a("FAST20", 4, 2.0F, "2.0X");
    sUR = locala5;
    sUS = new a[] { locala1, locala2, locala3, locala4, locala5 };
    sUV = new a((byte)0);
    sUU = j.listOf(new a[] { sUN, sUO, sUP, sUQ, sUR });
    AppMethodBeat.o(179024);
  }
  
  private a$a(float paramFloat, String paramString)
  {
    this.sUT = paramFloat;
    this.desc = paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed$Companion;", "", "()V", "speedList", "", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "plugin-brandservice_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.a.a
 * JD-Core Version:    0.7.0.1
 */