package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public class IJSRuntime$Config
{
  public String cYF = null;
  public byte[] cYG = null;
  public String cYH = "0";
  public boolean cYI;
  public boolean cYJ;
  public boolean cYK = false;
  public boolean cYL = false;
  public String cYM = null;
  public WeakReference<d> cYN = null;
  
  public IJSRuntime$Config() {}
  
  public IJSRuntime$Config(String paramString, byte[] paramArrayOfByte)
  {
    this.cYF = paramString;
    this.cYG = paramArrayOfByte;
  }
  
  public String toString()
  {
    AppMethodBeat.i(143995);
    StringBuilder localStringBuilder = new StringBuilder("Config{codeCache='").append(this.cYF).append('\'').append(", snapShot=");
    Object localObject;
    if (bu.cF(this.cYG))
    {
      localObject = "null";
      localObject = localStringBuilder.append((String)localObject).append(", nativeBuffer='").append(this.cYH).append('\'').append(", supportDirectEvaluation=").append(this.cYI).append(", enableNativeTrans=").append(this.cYJ).append(", hasGlobalTimer=").append(this.cYK).append(", ignoreRemainingTaskWhenLoopEnd=").append(this.cYL).append(", globalAlias=").append(this.cYM).append(", hasComponent=");
      if ((this.cYN == null) || (this.cYN.get() == null)) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + '}';
      AppMethodBeat.o(143995);
      return localObject;
      localObject = "not null";
      break;
    }
  }
  
  public boolean useNativeBufferJNI()
  {
    AppMethodBeat.i(143994);
    boolean bool = "1".equalsIgnoreCase(this.cYH);
    AppMethodBeat.o(143994);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.IJSRuntime.Config
 * JD-Core Version:    0.7.0.1
 */