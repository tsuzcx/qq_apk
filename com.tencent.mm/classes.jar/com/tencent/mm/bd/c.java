package com.tencent.mm.bd;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class c
{
  private static c jie;
  private QueueWorkerThread jif = null;
  
  public static String Pr(String paramString)
  {
    AppMethodBeat.i(90695);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90695);
      return null;
    }
    paramString = FilePathGenerator.genPath(a.eMT(), "remark_", g.getMessageDigest((paramString + "ZnVjaw==").getBytes()), ".png", 1);
    AppMethodBeat.o(90695);
    return paramString;
  }
  
  public static boolean Ps(String paramString)
  {
    AppMethodBeat.i(90696);
    String str = Pr(paramString);
    Log.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = new o(str).exists();
    AppMethodBeat.o(90696);
    return bool;
  }
  
  public static boolean Pt(String paramString)
  {
    AppMethodBeat.i(90697);
    String str = Pr(paramString);
    Log.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = s.deleteFile(str);
    AppMethodBeat.o(90697);
    return bool;
  }
  
  public static Bitmap Pu(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(90698);
    paramString = BitmapUtil.getBitmapNative(Pr(paramString), 0, 0);
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
  
  public static c bez()
  {
    AppMethodBeat.i(90694);
    if (jie == null) {
      jie = new c();
    }
    c localc = jie;
    AppMethodBeat.o(90694);
    return localc;
  }
  
  public final void a(String paramString1, String paramString2, c.a parama)
  {
    AppMethodBeat.i(90699);
    if ((!Util.isNullOrNil(paramString2)) && (!Ps(paramString1)))
    {
      if ((this.jif == null) || (this.jif.isDead())) {
        this.jif = new QueueWorkerThread(1, "download-remark-img", 1);
      }
      this.jif.add(new c.b(this, paramString1, paramString2, parama));
    }
    AppMethodBeat.o(90699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bd.c
 * JD-Core Version:    0.7.0.1
 */