package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.List;

public abstract interface q
{
  public abstract WxaPkg UT(String paramString);
  
  public abstract InputStream UU(String paramString);
  
  public abstract a UV(String paramString);
  
  public abstract boolean UW(String paramString);
  
  public abstract List<String> bvA();
  
  public abstract void bvy();
  
  public abstract List<ModulePkgInfo> bvz();
  
  public abstract void close();
  
  public static class a
  {
    public int appVersion;
    public String fileName;
    public String kKF;
    public String kKG;
    public WxaPkg kKH;
    public String kKI;
    public int kKJ;
    public int kKK;
    
    public final void a(a parama)
    {
      this.kKF = parama.kKF;
      this.appVersion = parama.appVersion;
      this.kKG = parama.kKG;
      this.kKH = parama.kKH;
      this.kKI = parama.kKI;
      this.fileName = parama.fileName;
      this.kKJ = parama.kKJ;
      this.kKK = parama.kKK;
    }
    
    public final WxaPkg.Info bvB()
    {
      AppMethodBeat.i(178519);
      WxaPkg.Info localInfo = new WxaPkg.Info(this.kKI, this.fileName, this.kKJ, this.kKK);
      AppMethodBeat.o(178519);
      return localInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q
 * JD-Core Version:    0.7.0.1
 */