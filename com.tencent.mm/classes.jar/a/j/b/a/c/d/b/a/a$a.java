package a.j.b.a.c.d.b.a;

import a.a.ad;
import a.i.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;

public enum a$a
{
  private static final Map<Integer, a> Cke;
  public static final a.a.a Ckf;
  private final int id;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(120337);
    Object localObject1 = new a("UNKNOWN", 0, 0);
    CjX = (a)localObject1;
    Object localObject2 = new a("CLASS", 1, 1);
    CjY = (a)localObject2;
    a locala1 = new a("FILE_FACADE", 2, 2);
    CjZ = locala1;
    a locala2 = new a("SYNTHETIC_CLASS", 3, 3);
    Cka = locala2;
    a locala3 = new a("MULTIFILE_CLASS", 4, 4);
    Ckb = locala3;
    a locala4 = new a("MULTIFILE_CLASS_PART", 5, 5);
    Ckc = locala4;
    Ckd = new a[] { localObject1, localObject2, locala1, locala2, locala3, locala4 };
    Ckf = new a.a.a((byte)0);
    localObject1 = values();
    localObject2 = (Map)new LinkedHashMap(e.iE(ad.TQ(localObject1.length), 16));
    int j = localObject1.length;
    while (i < j)
    {
      locala1 = localObject1[i];
      ((Map)localObject2).put(Integer.valueOf(locala1.id), locala1);
      i += 1;
    }
    Cke = (Map)localObject2;
    AppMethodBeat.o(120337);
  }
  
  private a$a(int paramInt)
  {
    this.id = paramInt;
  }
  
  public static final a TW(int paramInt)
  {
    AppMethodBeat.i(120340);
    a locala2 = (a)Cke.get(Integer.valueOf(paramInt));
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = CjX;
    }
    AppMethodBeat.o(120340);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.d.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */