package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  public String dpB;
  public String host;
  public String kgf;
  public String kgg;
  public String kgh;
  public String kgi;
  public String kgj;
  public ArrayList<f> kgk;
  public ArrayList<Object> kgl;
  public int major;
  public int minor;
  public int port;
  public String uuid;
  
  public b()
  {
    AppMethodBeat.i(158911);
    this.kgk = new ArrayList();
    this.kgl = new ArrayList();
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
      if ((this.host.equals(paramObject.host)) && (this.port == paramObject.port) && (this.kgj.equals(paramObject.kgj)))
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
    Iterator localIterator = this.kgk.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(localf.toString());
      ((StringBuilder)localObject).append("]\n");
    }
    localObject = "host=" + this.host + "\nport=" + this.port + "\nmajor=" + this.major + "\nminor=" + this.minor + "\ndeviceType=" + this.dpB + "\nfriendlyName=" + this.kgg + "\nmanufacturer=" + this.kgh + "\nmodeName=" + this.kgi + "\nserviceCount=" + this.kgk.size() + "\nserviceList=\n" + ((StringBuilder)localObject).toString();
    AppMethodBeat.o(158912);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.b
 * JD-Core Version:    0.7.0.1
 */