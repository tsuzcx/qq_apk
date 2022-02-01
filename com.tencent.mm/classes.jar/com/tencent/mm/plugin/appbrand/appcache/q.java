package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.List;

public abstract interface q
{
  public abstract WxaPkg LK(String paramString);
  
  public abstract InputStream LL(String paramString);
  
  public abstract a LM(String paramString);
  
  public abstract boolean LN(String paramString);
  
  public abstract List<WxaPkg.Info> bah();
  
  public abstract void bai();
  
  public abstract List<ModulePkgInfo> baj();
  
  public abstract List<String> bak();
  
  public abstract void close();
  
  public static class a
  {
    public int aDD;
    public String fileName;
    public String jIJ;
    public String jIK;
    public WxaPkg jIL;
    public String jIM;
    public int jIN;
    public int jIO;
    
    public final WxaPkg.Info bal()
    {
      AppMethodBeat.i(178519);
      WxaPkg.Info localInfo = new WxaPkg.Info(this.jIM, this.fileName, this.jIN, this.jIO);
      AppMethodBeat.o(178519);
      return localInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q
 * JD-Core Version:    0.7.0.1
 */