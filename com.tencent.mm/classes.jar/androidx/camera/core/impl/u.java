package androidx.camera.core.impl;

import androidx.camera.core.ak;
import androidx.camera.core.al;
import androidx.camera.core.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class u
{
  private final Object LI;
  private final Map<String, t> LJ;
  private final Set<t> LK;
  
  public u()
  {
    AppMethodBeat.i(198664);
    this.LI = new Object();
    this.LJ = new LinkedHashMap();
    this.LK = new HashSet();
    AppMethodBeat.o(198664);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(198674);
    synchronized (this.LI)
    {
      try
      {
        Iterator localIterator = paramr.gC().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          "Added camera: ".concat(String.valueOf(str));
          al.O("CameraRepository");
          this.LJ.put(str, paramr.y(str));
          continue;
          paramr = finally;
        }
      }
      catch (s paramr)
      {
        paramr = new ak(paramr);
        AppMethodBeat.o(198674);
        throw paramr;
      }
    }
    AppMethodBeat.o(198674);
  }
  
  public final LinkedHashSet<t> jW()
  {
    AppMethodBeat.i(198681);
    synchronized (this.LI)
    {
      LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.LJ.values());
      AppMethodBeat.o(198681);
      return localLinkedHashSet;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.u
 * JD-Core Version:    0.7.0.1
 */