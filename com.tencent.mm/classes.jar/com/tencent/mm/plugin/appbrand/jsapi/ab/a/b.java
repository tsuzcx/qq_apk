package com.tencent.mm.plugin.appbrand.jsapi.ab.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;

@TargetApi(5)
public class b
  extends a
{
  private com.tencent.mm.audio.d.a.a lyA;
  private c.b lyB;
  private int lyC;
  private Runnable lyD;
  
  public b()
  {
    AppMethodBeat.i(137896);
    this.lyD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137895);
        b.this.bpG();
        AppMethodBeat.o(137895);
      }
    };
    AppMethodBeat.o(137896);
  }
  
  public c bpG()
  {
    AppMethodBeat.i(137898);
    if (this.lyA == null)
    {
      ae.e("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      localObject = new c("may be not start", new Object[0]);
      AppMethodBeat.o(137898);
      return localObject;
    }
    this.lyA.PF();
    Object localObject = this.lyB.filePath;
    int i = this.lyC;
    int j = (int)o.aZR(this.lyB.filePath);
    P((String)localObject, i, j);
    ae.i("MicroMsg.DefaultLuggageRecorder", "stopRecord() filePath:%s duration:%d fileSize:%d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(j) });
    release();
    localObject = c.lyy;
    AppMethodBeat.o(137898);
    return localObject;
  }
  
  protected void release()
  {
    try
    {
      AppMethodBeat.i(137897);
      this.lyB = null;
      if (this.lyA != null)
      {
        this.lyA.djV.release();
        this.lyA = null;
      }
      AppMethodBeat.o(137897);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a.b
 * JD-Core Version:    0.7.0.1
 */