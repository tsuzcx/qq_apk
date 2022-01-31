package com.tencent.mm.ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d$a
{
  int cKk;
  String className;
  String savePath;
  int ySY;
  int ySZ;
  
  public d$a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76906);
    this.className = paramString;
    this.cKk = paramInt1;
    this.ySY = paramInt2;
    this.ySZ = paramInt3;
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (bo.isNullOrNil(paramString))
    {
      localStringBuilder1.append(d.ySS).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
      ab.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", new Object[] { localStringBuilder1.toString(), Integer.valueOf(paramInt2) });
      this.savePath = localStringBuilder1.toString();
      AppMethodBeat.o(76906);
      return;
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append(d.ySS).append(paramString).append("_");
    paramString = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localStringBuilder2.append(paramString).append(".trace");
      break;
      paramString = "onResume";
      continue;
      paramString = "onCreate";
      continue;
      paramString = "onPause";
      continue;
      paramString = "onScrool";
      continue;
      paramString = "all";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ci.d.a
 * JD-Core Version:    0.7.0.1
 */