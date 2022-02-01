package androidx.camera.core.impl;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class au
  extends bi
{
  private au(Map<String, Object> paramMap)
  {
    super(paramMap);
  }
  
  public static au b(bi parambi)
  {
    AppMethodBeat.i(198863);
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = parambi.kB().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayMap.put(str, parambi.getTag(str));
    }
    parambi = new au(localArrayMap);
    AppMethodBeat.o(198863);
    return parambi;
  }
  
  public static au kv()
  {
    AppMethodBeat.i(198856);
    au localau = new au(new ArrayMap());
    AppMethodBeat.o(198856);
    return localau;
  }
  
  public final void c(bi parambi)
  {
    AppMethodBeat.i(198874);
    if ((this.NB != null) && (parambi.NB != null)) {
      this.NB.putAll(parambi.NB);
    }
    AppMethodBeat.o(198874);
  }
  
  public final void h(String paramString, Object paramObject)
  {
    AppMethodBeat.i(198867);
    this.NB.put(paramString, paramObject);
    AppMethodBeat.o(198867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.au
 * JD-Core Version:    0.7.0.1
 */