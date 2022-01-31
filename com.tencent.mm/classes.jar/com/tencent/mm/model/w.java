package com.tencent.mm.model;

import android.os.HandlerThread;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class w
{
  public w.a dVj = null;
  boolean dVk = false;
  String dVl = "";
  BlockingQueue<w.c> dVm = new ArrayBlockingQueue(80);
  public w.b dVn = null;
  ah handler;
  
  public w(boolean paramBoolean, String paramString)
  {
    com.tencent.mm.kernel.g.DQ();
    this.handler = new w.1(this, com.tencent.mm.kernel.g.DS().mnU.getLooper());
    this.dVj = null;
    this.dVk = paramBoolean;
    this.dVl = paramString;
    y.d("MicroMsg.GetPicService", "getPicService, isFromWebView:%b isFromWebViewReffer:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
  }
  
  public final String c(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject;
    if (paramString1 == null) {
      localObject = null;
    }
    for (;;)
    {
      y.d("MicroMsg.GetPicService", "getPicfileByUrl type:" + paramInt1 + " url:" + paramString1);
      try
      {
        boolean bool = com.tencent.mm.a.e.bK((String)localObject);
        if (!bool) {
          break label235;
        }
        return localObject;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.GetPicService", "exception:%s", new Object[] { bk.j(localException) });
      }
      if (!com.tencent.mm.kernel.g.DK())
      {
        y.i("MicroMsg.GetPicService", "genFileName, account not ready");
        localObject = new File(com.tencent.mm.kernel.g.DP().dKs + "/imagecache");
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = ((File)localObject).getAbsolutePath() + "/reader_" + paramInt1 + "_" + com.tencent.mm.a.g.o(paramString1.getBytes()) + ".jpg";
      }
      else
      {
        localObject = c.FG() + "/reader_" + paramInt1 + "_" + com.tencent.mm.a.g.o(paramString1.getBytes()) + ".jpg";
      }
    }
    try
    {
      label235:
      this.dVm.add(new w.c(this, paramString1, (String)localObject, paramInt2, paramString2));
      if ((this.dVj == null) || (!com.tencent.mm.sdk.f.e.ad(this.dVj)))
      {
        com.tencent.mm.sdk.f.e.remove(this.dVj);
        this.dVj = new w.a(this);
        com.tencent.mm.sdk.f.e.post(this.dVj, "GetPicService_getPic");
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.e("MicroMsg.GetPicService", "exception:%s", new Object[] { bk.j(paramString1) });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.w
 * JD-Core Version:    0.7.0.1
 */