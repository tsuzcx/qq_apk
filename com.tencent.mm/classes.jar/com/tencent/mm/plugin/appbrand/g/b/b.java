package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  public String hEr;
  public String host;
  public String mse;
  public int port;
  public int rid;
  public int rie;
  public String rif;
  public String rig;
  public String rih;
  public String rii;
  public ArrayList<f> rij;
  public ArrayList<Object> rik;
  public String uuid;
  
  public b()
  {
    AppMethodBeat.i(158911);
    this.rij = new ArrayList();
    this.rik = new ArrayList();
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
      if ((this.host.equals(paramObject.host)) && (this.port == paramObject.port) && (this.rii.equals(paramObject.rii)))
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
    Iterator localIterator = this.rij.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(localf.toString());
      ((StringBuilder)localObject).append("]\n");
    }
    localObject = "host=" + this.host + "\nport=" + this.port + "\nmajor=" + this.rid + "\nminor=" + this.rie + "\ndeviceType=" + this.hEr + "\nfriendlyName=" + this.rif + "\nmanufacturer=" + this.rig + "\nmodeName=" + this.rih + "\nserviceCount=" + this.rij.size() + "\nserviceList=\n" + ((StringBuilder)localObject).toString();
    AppMethodBeat.o(158912);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.b
 * JD-Core Version:    0.7.0.1
 */