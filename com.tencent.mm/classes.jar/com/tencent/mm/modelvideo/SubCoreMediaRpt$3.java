package com.tencent.mm.modelvideo;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oi;
import com.tencent.mm.autogen.a.oi.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

class SubCoreMediaRpt$3
  extends IListener<oi>
{
  SubCoreMediaRpt$3(u paramu, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(241258);
    this.__eventId = oi.class.getName().hashCode();
    AppMethodBeat.o(241258);
  }
  
  private boolean a(oi paramoi)
  {
    AppMethodBeat.i(126916);
    Log.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
    if (paramoi == null)
    {
      AppMethodBeat.o(126916);
      return false;
    }
    String str1 = paramoi.hQP.path;
    Object localObject2 = str1;
    Object localObject1 = str1;
    try
    {
      if (str1.endsWith(".tmp"))
      {
        localObject1 = str1;
        localObject2 = str1.substring(0, str1.lastIndexOf(".tmp"));
        localObject1 = localObject2;
        Log.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[] { localObject2, paramoi.hQP.path });
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
    localObject2 = this.pan;
    str1 = paramoi.hQP.hQQ;
    str2 = paramoi.hQP.hQR;
    i = paramoi.hQP.hQS;
    str3 = paramoi.hQP.fileId;
    str4 = paramoi.hQP.hQU;
    l1 = paramoi.hQP.startTime;
    l2 = paramoi.hQP.endTime;
    arrayOfString = paramoi.hQP.hQT;
    j = paramoi.hQP.hQV;
    k = paramoi.hQP.hQW;
    paramoi = paramoi.hQP.hQX;
    h.baH().postToWorker(new u.2((u)localObject2, (String)localObject1, arrayOfString, str1, str2, i, str3, str4, l1, l2, j, k, paramoi));
    AppMethodBeat.o(126916);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.SubCoreMediaRpt.3
 * JD-Core Version:    0.7.0.1
 */