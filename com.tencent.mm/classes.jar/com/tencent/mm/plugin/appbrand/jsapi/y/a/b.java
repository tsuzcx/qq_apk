package com.tencent.mm.plugin.appbrand.jsapi.y.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.y.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

@TargetApi(5)
public class b
  extends a
{
  private com.tencent.mm.audio.d.a.a kvO;
  private c.b kvP;
  private int kvQ;
  private Runnable kvR;
  
  public b()
  {
    AppMethodBeat.i(137896);
    this.kvR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137895);
        b.this.ber();
        AppMethodBeat.o(137895);
      }
    };
    AppMethodBeat.o(137896);
  }
  
  public c ber()
  {
    AppMethodBeat.i(137898);
    if (this.kvO == null)
    {
      ad.e("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      localObject = new c("may be not start", new Object[0]);
      AppMethodBeat.o(137898);
      return localObject;
    }
    this.kvO.Ob();
    Object localObject = this.kvP.filePath;
    int i = this.kvQ;
    int j = (int)i.aMN(this.kvP.filePath);
    O((String)localObject, i, j);
    ad.i("MicroMsg.DefaultLuggageRecorder", "stopRecord() filePath:%s duration:%d fileSize:%d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(j) });
    release();
    localObject = c.kvM;
    AppMethodBeat.o(137898);
    return localObject;
  }
  
  protected void release()
  {
    try
    {
      AppMethodBeat.i(137897);
      this.kvP = null;
      if (this.kvO != null)
      {
        this.kvO.daf.release();
        this.kvO = null;
      }
      AppMethodBeat.o(137897);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a.b
 * JD-Core Version:    0.7.0.1
 */