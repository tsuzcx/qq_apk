package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.List;

public abstract interface q
{
  public abstract WxaPkg HR(String paramString);
  
  public abstract InputStream HS(String paramString);
  
  public abstract a HT(String paramString);
  
  public abstract boolean HU(String paramString);
  
  public abstract List<WxaPkg.Info> aWp();
  
  public abstract void aWq();
  
  public abstract List<ModulePkgInfo> aWr();
  
  public abstract List<String> aWs();
  
  public abstract void close();
  
  public static class a
  {
    public int aBM;
    public String fileName;
    public String jlU;
    public String jlV;
    public WxaPkg jlW;
    public String jlX;
    public int jlY;
    public int jlZ;
    
    public final WxaPkg.Info aWt()
    {
      AppMethodBeat.i(178519);
      WxaPkg.Info localInfo = new WxaPkg.Info(this.jlX, this.fileName, this.jlY, this.jlZ);
      AppMethodBeat.o(178519);
      return localInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q
 * JD-Core Version:    0.7.0.1
 */