package a.j.b.a.c.i.d;

import a.j.b.a.c.a.h;
import a.j.b.a.c.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum c
{
  private static final Set<b> Cxb;
  private static final Map<String, c> Cxc;
  private static final Map<h, c> Cxd;
  private static final Map<String, c> Cxe;
  public final h Cxf;
  public final b Cxg;
  public final String desc;
  public final String name;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(122167);
    CwT = new c("BOOLEAN", 0, h.BTE, "boolean", "Z", "java.lang.Boolean");
    CwU = new c("CHAR", 1, h.BTF, "char", "C", "java.lang.Character");
    CwV = new c("BYTE", 2, h.BTG, "byte", "B", "java.lang.Byte");
    CwW = new c("SHORT", 3, h.BTH, "short", "S", "java.lang.Short");
    CwX = new c("INT", 4, h.BTI, "int", "I", "java.lang.Integer");
    CwY = new c("FLOAT", 5, h.BTJ, "float", "F", "java.lang.Float");
    CwZ = new c("LONG", 6, h.BTK, "long", "J", "java.lang.Long");
    Cxa = new c("DOUBLE", 7, h.BTL, "double", "D", "java.lang.Double");
    Cxh = new c[] { CwT, CwU, CwV, CwW, CwX, CwY, CwZ, Cxa };
    Cxb = new HashSet();
    Cxc = new HashMap();
    Cxd = new EnumMap(h.class);
    Cxe = new HashMap();
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    while (i < j)
    {
      c localc = arrayOfc[i];
      Cxb.add(localc.Cxg);
      Cxc.put(localc.name, localc);
      Cxd.put(localc.Cxf, localc);
      Cxe.put(localc.desc, localc);
      i += 1;
    }
    AppMethodBeat.o(122167);
  }
  
  private c(h paramh, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(122166);
    this.Cxf = paramh;
    this.name = paramString1;
    this.desc = paramString2;
    this.Cxg = new b(paramString3);
    AppMethodBeat.o(122166);
  }
  
  public static c azg(String paramString)
  {
    AppMethodBeat.i(122164);
    c localc = (c)Cxc.get(paramString);
    if (localc == null)
    {
      paramString = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(122164);
      throw paramString;
    }
    AppMethodBeat.o(122164);
    return localc;
  }
  
  public static c d(h paramh)
  {
    AppMethodBeat.i(122165);
    paramh = (c)Cxd.get(paramh);
    AppMethodBeat.o(122165);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.i.d.c
 * JD-Core Version:    0.7.0.1
 */