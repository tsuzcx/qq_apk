package com.tencent.mm.ba;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.ah.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class c
{
  private static c oRM;
  private QueueWorkerThread oRN = null;
  
  public static String OO(String paramString)
  {
    AppMethodBeat.i(90695);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90695);
      return null;
    }
    paramString = FilePathGenerator.genPath(a.gLu(), "remark_", g.getMessageDigest((paramString + "ZnVjaw==").getBytes()), ".png", 1);
    AppMethodBeat.o(90695);
    return paramString;
  }
  
  public static boolean OP(String paramString)
  {
    AppMethodBeat.i(90696);
    String str = OO(paramString);
    Log.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = new u(str).jKS();
    AppMethodBeat.o(90696);
    return bool;
  }
  
  public static boolean OQ(String paramString)
  {
    AppMethodBeat.i(90697);
    String str = OO(paramString);
    Log.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = y.deleteFile(str);
    AppMethodBeat.o(90697);
    return bool;
  }
  
  public static Bitmap OR(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(90698);
    paramString = BitmapUtil.getBitmapNative(OO(paramString), 0, 0);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (!paramString.isRecycled()) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(90698);
      return paramString;
    }
    AppMethodBeat.o(90698);
    return null;
  }
  
  public static c bLL()
  {
    AppMethodBeat.i(90694);
    if (oRM == null) {
      oRM = new c();
    }
    c localc = oRM;
    AppMethodBeat.o(90694);
    return localc;
  }
  
  public final void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(90699);
    if ((!Util.isNullOrNil(paramString2)) && (!OP(paramString1)))
    {
      if ((this.oRN == null) || (this.oRN.isDead())) {
        this.oRN = new QueueWorkerThread(1, "download-remark-img", 1);
      }
      this.oRN.add(new c.b(this, paramString1, paramString2, parama));
    }
    AppMethodBeat.o(90699);
  }
  
  public static abstract interface a
  {
    public abstract void hk(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ba.c
 * JD-Core Version:    0.7.0.1
 */