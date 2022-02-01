package androidx.camera.core.impl;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class bi
{
  private static final bi NC;
  protected final Map<String, Object> NB;
  
  static
  {
    AppMethodBeat.i(198836);
    NC = new bi(new ArrayMap());
    AppMethodBeat.o(198836);
  }
  
  protected bi(Map<String, Object> paramMap)
  {
    this.NB = paramMap;
  }
  
  public static bi d(bi parambi)
  {
    AppMethodBeat.i(198831);
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = parambi.kB().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayMap.put(str, parambi.getTag(str));
    }
    parambi = new bi(localArrayMap);
    AppMethodBeat.o(198831);
    return parambi;
  }
  
  public static bi kA()
  {
    return NC;
  }
  
  public final Object getTag(String paramString)
  {
    AppMethodBeat.i(198845);
    paramString = this.NB.get(paramString);
    AppMethodBeat.o(198845);
    return paramString;
  }
  
  public final Set<String> kB()
  {
    AppMethodBeat.i(198850);
    Set localSet = this.NB.keySet();
    AppMethodBeat.o(198850);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.bi
 * JD-Core Version:    0.7.0.1
 */