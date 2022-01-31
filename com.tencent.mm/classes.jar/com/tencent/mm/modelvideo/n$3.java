package com.tencent.mm.modelvideo;

import com.tencent.mm.h.a.jp;
import com.tencent.mm.h.a.jp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class n$3
  extends c<jp>
{
  n$3(n paramn)
  {
    this.udX = jp.class.getName().hashCode();
  }
  
  private boolean a(jp paramjp)
  {
    y.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
    if (paramjp == null) {
      return false;
    }
    String str1 = paramjp.bRN.path;
    Object localObject2 = str1;
    Object localObject1 = str1;
    try
    {
      if (str1.endsWith(".tmp"))
      {
        localObject1 = str1;
        localObject2 = str1.substring(0, str1.lastIndexOf(".tmp"));
        localObject1 = localObject2;
        y.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[] { localObject2, paramjp.bRN.path });
      }
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label93:
      String str2;
      int i;
      String str3;
      String str4;
      long l1;
      long l2;
      String[] arrayOfString;
      int j;
      int k;
      break label93;
    }
    localObject2 = this.eGT;
    str1 = paramjp.bRN.bRO;
    str2 = paramjp.bRN.bRP;
    i = paramjp.bRN.bRQ;
    str3 = paramjp.bRN.fileId;
    str4 = paramjp.bRN.bRS;
    l1 = paramjp.bRN.startTime;
    l2 = paramjp.bRN.endTime;
    arrayOfString = paramjp.bRN.bRR;
    j = paramjp.bRN.bRT;
    k = paramjp.bRN.bRU;
    paramjp = paramjp.bRN.bRV;
    g.DS().O(new n.2((n)localObject2, (String)localObject1, arrayOfString, str1, str2, i, str3, str4, l1, l2, j, k, paramjp));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n.3
 * JD-Core Version:    0.7.0.1
 */