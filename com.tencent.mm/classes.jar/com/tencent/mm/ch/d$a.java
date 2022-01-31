package com.tencent.mm.ch;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d$a
{
  int cbH;
  String className;
  String savePath;
  int uGg;
  int uGh;
  
  public d$a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.className = paramString;
    this.cbH = paramInt1;
    this.uGg = paramInt2;
    this.uGh = paramInt3;
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (bk.bl(paramString))
    {
      localStringBuilder1.append(d.uGa).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
      y.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", new Object[] { localStringBuilder1.toString(), Integer.valueOf(paramInt2) });
      this.savePath = localStringBuilder1.toString();
      return;
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append(d.uGa).append(paramString).append("_");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ch.d.a
 * JD-Core Version:    0.7.0.1
 */