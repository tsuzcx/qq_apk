package com.tencent.mm.plugin.appbrand.jsapi.ad.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

@TargetApi(5)
public class b
  extends a
{
  private com.tencent.mm.audio.d.a.a mFB;
  private c.b mFC;
  private int mFE;
  private Runnable mFF;
  
  public b()
  {
    AppMethodBeat.i(137896);
    this.mFF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137895);
        b.this.bLl();
        AppMethodBeat.o(137895);
      }
    };
    AppMethodBeat.o(137896);
  }
  
  public c bLl()
  {
    AppMethodBeat.i(137898);
    if (this.mFB == null)
    {
      Log.e("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      localObject = new c("may be not start", new Object[0]);
      AppMethodBeat.o(137898);
      return localObject;
    }
    this.mFB.ZZ();
    Object localObject = this.mFC.filePath;
    int i = this.mFE;
    int j = (int)s.boW(this.mFC.filePath);
    S((String)localObject, i, j);
    Log.i("MicroMsg.DefaultLuggageRecorder", "stopRecord() filePath:%s duration:%d fileSize:%d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(j) });
    release();
    localObject = c.mFz;
    AppMethodBeat.o(137898);
    return localObject;
  }
  
  protected void release()
  {
    try
    {
      AppMethodBeat.i(137897);
      this.mFC = null;
      if (this.mFB != null)
      {
        this.mFB.dBf.release();
        this.mFB = null;
      }
      AppMethodBeat.o(137897);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a.b
 * JD-Core Version:    0.7.0.1
 */