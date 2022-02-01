package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public class IJSRuntime$Config
{
  public String dpj = null;
  public byte[] dpk = null;
  public String dpl = "0";
  public boolean dpm;
  public boolean dpn;
  public boolean dpo = false;
  public boolean dpp = false;
  public String dpq = null;
  public String dpr = "";
  public WeakReference<g> dps = null;
  
  public IJSRuntime$Config() {}
  
  public IJSRuntime$Config(String paramString, byte[] paramArrayOfByte)
  {
    this.dpj = paramString;
    this.dpk = paramArrayOfByte;
  }
  
  public String toString()
  {
    AppMethodBeat.i(143995);
    StringBuilder localStringBuilder = new StringBuilder("Config{codeCache='").append(this.dpj).append('\'').append(", snapShot=");
    Object localObject;
    if (Util.isNullOrNil(this.dpk))
    {
      localObject = "null";
      localObject = localStringBuilder.append((String)localObject).append(", nativeBuffer='").append(this.dpl).append('\'').append(", supportDirectEvaluation=").append(this.dpm).append(", enableNativeTrans=").append(this.dpn).append(", hasGlobalTimer=").append(this.dpo).append(", ignoreRemainingTaskWhenLoopEnd=").append(this.dpp).append(", globalAlias=").append(this.dpq).append(", hasComponent=");
      if ((this.dps == null) || (this.dps.get() == null)) {
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
    boolean bool = "1".equalsIgnoreCase(this.dpl);
    AppMethodBeat.o(143994);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.IJSRuntime.Config
 * JD-Core Version:    0.7.0.1
 */