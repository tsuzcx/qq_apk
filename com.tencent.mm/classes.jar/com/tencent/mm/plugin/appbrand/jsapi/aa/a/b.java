package com.tencent.mm.plugin.appbrand.jsapi.aa.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

@TargetApi(5)
public class b
  extends a
{
  private com.tencent.mm.audio.d.a.a lub;
  private c.b luc;
  private int lud;
  private Runnable lue;
  
  public b()
  {
    AppMethodBeat.i(137896);
    this.lue = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137895);
        b.this.boW();
        AppMethodBeat.o(137895);
      }
    };
    AppMethodBeat.o(137896);
  }
  
  public c boW()
  {
    AppMethodBeat.i(137898);
    if (this.lub == null)
    {
      ad.e("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      localObject = new c("may be not start", new Object[0]);
      AppMethodBeat.o(137898);
      return localObject;
    }
    this.lub.PG();
    Object localObject = this.luc.filePath;
    int i = this.lud;
    int j = (int)i.aYo(this.luc.filePath);
    P((String)localObject, i, j);
    ad.i("MicroMsg.DefaultLuggageRecorder", "stopRecord() filePath:%s duration:%d fileSize:%d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(j) });
    release();
    localObject = c.ltZ;
    AppMethodBeat.o(137898);
    return localObject;
  }
  
  protected void release()
  {
    try
    {
      AppMethodBeat.i(137897);
      this.luc = null;
      if (this.lub != null)
      {
        this.lub.diT.release();
        this.lub = null;
      }
      AppMethodBeat.o(137897);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.a.b
 * JD-Core Version:    0.7.0.1
 */