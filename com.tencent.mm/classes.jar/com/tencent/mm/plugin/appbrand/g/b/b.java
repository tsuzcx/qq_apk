package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  public String fzF;
  public String host;
  public String oeA;
  public String oeB;
  public String oeC;
  public String oeD;
  public ArrayList<f> oeE;
  public ArrayList<Object> oeF;
  public String oex;
  public int oey;
  public int oez;
  public int port;
  public String uuid;
  
  public b()
  {
    AppMethodBeat.i(158911);
    this.oeE = new ArrayList();
    this.oeF = new ArrayList();
    AppMethodBeat.o(158911);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158913);
    if (paramObject == this)
    {
      AppMethodBeat.o(158913);
      return true;
    }
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if ((this.host.equals(paramObject.host)) && (this.port == paramObject.port) && (this.oeD.equals(paramObject.oeD)))
      {
        AppMethodBeat.o(158913);
        return true;
      }
      AppMethodBeat.o(158913);
      return false;
    }
    AppMethodBeat.o(158913);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158912);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.oeE.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(localf.toString());
      ((StringBuilder)localObject).append("]\n");
    }
    localObject = "host=" + this.host + "\nport=" + this.port + "\nmajor=" + this.oey + "\nminor=" + this.oez + "\ndeviceType=" + this.fzF + "\nfriendlyName=" + this.oeA + "\nmanufacturer=" + this.oeB + "\nmodeName=" + this.oeC + "\nserviceCount=" + this.oeE.size() + "\nserviceList=\n" + ((StringBuilder)localObject).toString();
    AppMethodBeat.o(158912);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.b
 * JD-Core Version:    0.7.0.1
 */