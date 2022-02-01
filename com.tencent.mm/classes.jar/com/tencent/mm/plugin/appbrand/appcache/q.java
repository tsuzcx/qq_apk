package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.List;

public abstract interface q
{
  public abstract WxaPkg acD(String paramString);
  
  public abstract InputStream acE(String paramString);
  
  public abstract a acF(String paramString);
  
  public abstract boolean acG(String paramString);
  
  public abstract void bGF();
  
  public abstract List<ModulePkgInfo> bGG();
  
  public abstract List<String> bGH();
  
  public abstract void close();
  
  public static class a
  {
    public int appVersion;
    public String fileName;
    public String nEu;
    public String nEv;
    public WxaPkg nEw;
    public String nEx;
    public int nEy;
    public int nEz;
    
    public final void a(a parama)
    {
      this.nEu = parama.nEu;
      this.appVersion = parama.appVersion;
      this.nEv = parama.nEv;
      this.nEw = parama.nEw;
      this.nEx = parama.nEx;
      this.fileName = parama.fileName;
      this.nEy = parama.nEy;
      this.nEz = parama.nEz;
    }
    
    public final WxaPkg.Info bGI()
    {
      AppMethodBeat.i(178519);
      WxaPkg.Info localInfo = new WxaPkg.Info(this.nEx, this.fileName, this.nEy, this.nEz);
      AppMethodBeat.o(178519);
      return localInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q
 * JD-Core Version:    0.7.0.1
 */