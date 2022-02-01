package androidx.camera.camera2.a;

import androidx.camera.core.impl.ar;
import androidx.camera.core.impl.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class c
  extends ar<b>
{
  private c(b... paramVarArgs)
  {
    AppMethodBeat.i(197248);
    addAll(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(197248);
  }
  
  public static c fX()
  {
    AppMethodBeat.i(197253);
    c localc = new c(new b[0]);
    AppMethodBeat.o(197253);
    return localc;
  }
  
  public final a fW()
  {
    AppMethodBeat.i(197257);
    a locala = new a(kt());
    AppMethodBeat.o(197257);
    return locala;
  }
  
  public final ar<b> fY()
  {
    AppMethodBeat.i(197262);
    c localc = fX();
    localc.addAll(kt());
    AppMethodBeat.o(197262);
    return localc;
  }
  
  public static final class a
  {
    private final List<b> cQ;
    
    a(List<b> paramList)
    {
      AppMethodBeat.i(197264);
      this.cQ = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        b localb = (b)paramList.next();
        this.cQ.add(localb);
      }
      AppMethodBeat.o(197264);
    }
    
    public final List<z> fZ()
    {
      AppMethodBeat.i(197272);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(197272);
      return localArrayList;
    }
    
    public final List<z> ga()
    {
      AppMethodBeat.i(197277);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(197277);
      return localArrayList;
    }
    
    public final List<z> gb()
    {
      AppMethodBeat.i(197282);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(197282);
      return localArrayList;
    }
    
    public final List<z> gc()
    {
      AppMethodBeat.i(197288);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(197288);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.a.c
 * JD-Core Version:    0.7.0.1
 */