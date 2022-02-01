package com.tencent.mm.plugin.appbrand.jsapi.x.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;

@TargetApi(5)
public class b
  extends a
{
  private com.tencent.mm.audio.d.a.a kXc;
  private c.b kXd;
  private int kXe;
  private Runnable kXf;
  
  public b()
  {
    AppMethodBeat.i(137896);
    this.kXf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137895);
        b.this.bll();
        AppMethodBeat.o(137895);
      }
    };
    AppMethodBeat.o(137896);
  }
  
  public c bll()
  {
    AppMethodBeat.i(137898);
    if (this.kXc == null)
    {
      ac.e("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      localObject = new c("may be not start", new Object[0]);
      AppMethodBeat.o(137898);
      return localObject;
    }
    this.kXc.NX();
    Object localObject = this.kXd.filePath;
    int i = this.kXe;
    int j = (int)i.aSp(this.kXd.filePath);
    N((String)localObject, i, j);
    ac.i("MicroMsg.DefaultLuggageRecorder", "stopRecord() filePath:%s duration:%d fileSize:%d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(j) });
    release();
    localObject = c.kXa;
    AppMethodBeat.o(137898);
    return localObject;
  }
  
  protected void release()
  {
    try
    {
      AppMethodBeat.i(137897);
      this.kXd = null;
      if (this.kXc != null)
      {
        this.kXc.cXB.release();
        this.kXc = null;
      }
      AppMethodBeat.o(137897);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.a.b
 * JD-Core Version:    0.7.0.1
 */