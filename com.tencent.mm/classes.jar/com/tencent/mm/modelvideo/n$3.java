package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.jy.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class n$3
  extends c<jy>
{
  n$3(n paramn)
  {
    AppMethodBeat.i(50754);
    this.__eventId = jy.class.getName().hashCode();
    AppMethodBeat.o(50754);
  }
  
  private boolean a(jy paramjy)
  {
    AppMethodBeat.i(50755);
    ab.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
    if (paramjy == null)
    {
      AppMethodBeat.o(50755);
      return false;
    }
    String str1 = paramjy.czo.path;
    Object localObject2 = str1;
    Object localObject1 = str1;
    try
    {
      if (str1.endsWith(".tmp"))
      {
        localObject1 = str1;
        localObject2 = str1.substring(0, str1.lastIndexOf(".tmp"));
        localObject1 = localObject2;
        ab.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[] { localObject2, paramjy.czo.path });
      }
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label103:
      String str2;
      int i;
      String str3;
      String str4;
      long l1;
      long l2;
      String[] arrayOfString;
      int j;
      int k;
      break label103;
    }
    localObject2 = this.fWJ;
    str1 = paramjy.czo.czp;
    str2 = paramjy.czo.czq;
    i = paramjy.czo.czr;
    str3 = paramjy.czo.fileId;
    str4 = paramjy.czo.czt;
    l1 = paramjy.czo.startTime;
    l2 = paramjy.czo.endTime;
    arrayOfString = paramjy.czo.czs;
    j = paramjy.czo.czu;
    k = paramjy.czo.czv;
    paramjy = paramjy.czo.czw;
    g.RO().ac(new n.2((n)localObject2, (String)localObject1, arrayOfString, str1, str2, i, str3, str4, l1, l2, j, k, paramjy));
    AppMethodBeat.o(50755);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n.3
 * JD-Core Version:    0.7.0.1
 */