package com.tencent.mm.model;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class x
{
  public x.a fls;
  boolean flt;
  String flu;
  BlockingQueue<x.c> flv;
  public x.b flw;
  ak handler;
  
  public x(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(77803);
    this.fls = null;
    this.flt = false;
    this.flu = "";
    this.flv = new ArrayBlockingQueue(80);
    this.flw = null;
    com.tencent.mm.kernel.g.RM();
    this.handler = new x.1(this, com.tencent.mm.kernel.g.RO().oNc.getLooper());
    this.fls = null;
    this.flt = paramBoolean;
    this.flu = paramString;
    ab.d("MicroMsg.GetPicService", "getPicService, isFromWebView:%b isFromWebViewReffer:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppMethodBeat.o(77803);
  }
  
  public final String c(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(77804);
    Object localObject;
    if (paramString1 == null) {
      localObject = null;
    }
    for (;;)
    {
      ab.d("MicroMsg.GetPicService", "getPicfileByUrl type:" + paramInt1 + " url:" + paramString1);
      try
      {
        boolean bool = com.tencent.mm.a.e.cN((String)localObject);
        if (!bool) {
          break label245;
        }
        AppMethodBeat.o(77804);
        return localObject;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.GetPicService", "exception:%s", new Object[] { bo.l(localException) });
      }
      if (!com.tencent.mm.kernel.g.RG())
      {
        ab.i("MicroMsg.GetPicService", "genFileName, account not ready");
        localObject = new File(com.tencent.mm.kernel.g.RL().eHQ + "/imagecache");
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = ((File)localObject).getAbsolutePath() + "/reader_" + paramInt1 + "_" + com.tencent.mm.a.g.w(paramString1.getBytes()) + ".jpg";
      }
      else
      {
        localObject = c.YK() + "/reader_" + paramInt1 + "_" + com.tencent.mm.a.g.w(paramString1.getBytes()) + ".jpg";
      }
    }
    try
    {
      label245:
      this.flv.add(new x.c(this, paramString1, (String)localObject, paramInt2, paramString2));
      if ((this.fls == null) || (!d.ysm.an(this.fls)))
      {
        d.ysm.remove(this.fls);
        this.fls = new x.a(this);
        d.post(this.fls, "GetPicService_getPic");
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.e("MicroMsg.GetPicService", "exception:%s", new Object[] { bo.l(paramString1) });
      }
    }
    AppMethodBeat.o(77804);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.x
 * JD-Core Version:    0.7.0.1
 */