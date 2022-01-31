package a.j.b.a.c.a;

import a.j.b.a.c.f.b;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum h
{
  public static final Set<h> BTM;
  public final f BTN;
  public final f BTO;
  public b BTP;
  private b BTQ;
  
  static
  {
    AppMethodBeat.i(119106);
    BTE = new h("BOOLEAN", 0, "Boolean");
    BTF = new h("CHAR", 1, "Char");
    BTG = new h("BYTE", 2, "Byte");
    BTH = new h("SHORT", 3, "Short");
    BTI = new h("INT", 4, "Int");
    BTJ = new h("FLOAT", 5, "Float");
    BTK = new h("LONG", 6, "Long");
    BTL = new h("DOUBLE", 7, "Double");
    BTR = new h[] { BTE, BTF, BTG, BTH, BTI, BTJ, BTK, BTL };
    BTM = Collections.unmodifiableSet(EnumSet.of(BTF, new h[] { BTG, BTH, BTI, BTJ, BTK, BTL }));
    AppMethodBeat.o(119106);
  }
  
  private h(String paramString)
  {
    AppMethodBeat.i(119105);
    this.BTP = null;
    this.BTQ = null;
    this.BTN = f.ayT(paramString);
    this.BTO = f.ayT(paramString + "Array");
    AppMethodBeat.o(119105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.a.h
 * JD-Core Version:    0.7.0.1
 */