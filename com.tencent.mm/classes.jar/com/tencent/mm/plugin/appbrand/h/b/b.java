package com.tencent.mm.plugin.appbrand.h.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  public String dfF;
  public String host;
  public String jio;
  public String jip;
  public String jiq;
  public String jir;
  public String jis;
  public ArrayList<f> jit;
  public ArrayList<Object> jiu;
  public int major;
  public int minor;
  public int port;
  public String uuid;
  
  public b()
  {
    AppMethodBeat.i(158911);
    this.jit = new ArrayList();
    this.jiu = new ArrayList();
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
      if ((this.host.equals(paramObject.host)) && (this.port == paramObject.port) && (this.jis.equals(paramObject.jis)))
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
    Iterator localIterator = this.jit.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(localf.toString());
      ((StringBuilder)localObject).append("]\n");
    }
    localObject = "host=" + this.host + "\nport=" + this.port + "\nmajor=" + this.major + "\nminor=" + this.minor + "\ndeviceType=" + this.dfF + "\nfriendlyName=" + this.jip + "\nmanufacturer=" + this.jiq + "\nmodeName=" + this.jir + "\nserviceCount=" + this.jit.size() + "\nserviceList=\n" + ((StringBuilder)localObject).toString();
    AppMethodBeat.o(158912);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.b.b
 * JD-Core Version:    0.7.0.1
 */