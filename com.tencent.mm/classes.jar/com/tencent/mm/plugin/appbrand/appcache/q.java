package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.List;

public abstract interface q
{
  public abstract WxaPkg Lj(String paramString);
  
  public abstract InputStream Lk(String paramString);
  
  public abstract a Ll(String paramString);
  
  public abstract boolean Lm(String paramString);
  
  public abstract List<WxaPkg.Info> aZK();
  
  public abstract void aZL();
  
  public abstract List<ModulePkgInfo> aZM();
  
  public abstract List<String> aZN();
  
  public abstract void close();
  
  public static class a
  {
    public int aDD;
    public String fileName;
    public String jFK;
    public String jFL;
    public WxaPkg jFM;
    public String jFN;
    public int jFO;
    public int jFP;
    
    public final WxaPkg.Info aZO()
    {
      AppMethodBeat.i(178519);
      WxaPkg.Info localInfo = new WxaPkg.Info(this.jFN, this.fileName, this.jFO, this.jFP);
      AppMethodBeat.o(178519);
      return localInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q
 * JD-Core Version:    0.7.0.1
 */