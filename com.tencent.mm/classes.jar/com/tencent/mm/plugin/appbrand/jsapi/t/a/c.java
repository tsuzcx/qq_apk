package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import android.annotation.TargetApi;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.d.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vfs.e;
import java.util.concurrent.ExecutorService;

@TargetApi(5)
public class c
  extends a
{
  private com.tencent.mm.audio.d.a.a ifr;
  private e.d ifs;
  private long ift;
  private int ifu;
  private Runnable ifv;
  
  public c()
  {
    AppMethodBeat.i(145929);
    this.ifv = new c.1(this);
    AppMethodBeat.o(145929);
  }
  
  private void aGe()
  {
    AppMethodBeat.i(145936);
    this.ift = System.currentTimeMillis();
    d.i("MicroMsg.DefaultLuggageRecorder", "resumeRecordTime mRecordingTime:%d mLastStartTime:%d", new Object[] { Integer.valueOf(this.ifu), Long.valueOf(this.ift) });
    m.aNS().o(this.ifv, this.ifs.duration - this.ifu);
    AppMethodBeat.o(145936);
  }
  
  public g a(e.d paramd)
  {
    AppMethodBeat.i(145934);
    if (paramd == null) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramd = new g("invalid params", new Object[0]);
      AppMethodBeat.o(145934);
      return paramd;
    }
    release();
    this.ifs = paramd;
    if (this.ifs.duration <= 0) {
      this.ifs.duration = 60000;
    }
    this.ifr = new com.tencent.mm.audio.d.a.a(this.ifs.ifL.ifE, this.ifs.sampleRate, this.ifs.ifH, this.ifs.ifJ, this.ifs.ifK, this.ifs.filePath, this.ifs.ifI);
    this.ift = System.currentTimeMillis();
    this.ifu = 0;
    com.tencent.mm.audio.d.a.a locala = this.ifr;
    boolean bool;
    if (locala.eM("startRecord fail, recorder is null, return")) {
      bool = false;
    }
    for (;;)
    {
      d.i("MicroMsg.DefaultLuggageRecorder", "startRecord() params:%s isOK:%b", new Object[] { paramd, Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      this.ifr.clp = new c.2(this);
      aGe();
      aGa();
      paramd = g.ifo;
      AppMethodBeat.o(145934);
      return paramd;
      if (!locala.Fa())
      {
        ab.e("MicroMsg.RecorderPcm", "initEncoder fail");
        bool = false;
      }
      else
      {
        locala.clg.clu = locala.clj;
        bool = locala.clg.EC();
        ab.i("MicroMsg.RecorderPcm", "startRecord:%b", new Object[] { Boolean.valueOf(bool) });
      }
    }
    release();
    paramd = new g("start fail", new Object[0]);
    AppMethodBeat.o(145934);
    return paramd;
  }
  
  public g aGd()
  {
    AppMethodBeat.i(145935);
    d.i("MicroMsg.DefaultLuggageRecorder", "pauseRecord");
    if (this.ifr == null)
    {
      d.e("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      localObject = new g("may be not start", new Object[0]);
      AppMethodBeat.o(145935);
      return localObject;
    }
    Object localObject = this.ifr;
    if (!((com.tencent.mm.audio.d.a.a)localObject).eM("pauseRecord fail, recorder is null, return"))
    {
      localObject = ((com.tencent.mm.audio.d.a.a)localObject).clg;
      if (!((b)localObject).checkValid()) {
        ((b)localObject).mIsRecording = false;
      }
    }
    this.ifu = ((int)(this.ifu + (System.currentTimeMillis() - this.ift)));
    d.i("MicroMsg.DefaultLuggageRecorder", "pauseRecordTime mRecordingTime:%d mLastStartTime:%d", new Object[] { Integer.valueOf(this.ifu), Long.valueOf(this.ift) });
    m.aNS().caB().removeCallbacks(this.ifv);
    aGc();
    localObject = g.ifo;
    AppMethodBeat.o(145935);
    return localObject;
  }
  
  public g aGf()
  {
    AppMethodBeat.i(145937);
    d.i("MicroMsg.DefaultLuggageRecorder", "resumeRecord");
    if (this.ifr == null)
    {
      d.e("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      localObject = new g("may be not start", new Object[0]);
      AppMethodBeat.o(145937);
      return localObject;
    }
    Object localObject = this.ifr;
    if (!((com.tencent.mm.audio.d.a.a)localObject).eM("resumeRecord fail, recorder is null, return"))
    {
      localObject = ((com.tencent.mm.audio.d.a.a)localObject).clg;
      if (!((b)localObject).checkValid())
      {
        ((b)localObject).mIsRecording = true;
        ((b)localObject).mExecutorService.submit(((b)localObject).clt);
      }
    }
    aGe();
    aGb();
    localObject = g.ifo;
    AppMethodBeat.o(145937);
    return localObject;
  }
  
  public g aGg()
  {
    AppMethodBeat.i(145938);
    if (this.ifr == null)
    {
      d.e("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      localObject = new g("may be not start", new Object[0]);
      AppMethodBeat.o(145938);
      return localObject;
    }
    this.ifr.Et();
    Object localObject = this.ifs.filePath;
    int i = this.ifu;
    int j = (int)e.avI(this.ifs.filePath);
    R((String)localObject, i, j);
    d.i("MicroMsg.DefaultLuggageRecorder", "stopRecord() filePath:%s duration:%d fileSize:%d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(j) });
    release();
    localObject = g.ifo;
    AppMethodBeat.o(145938);
    return localObject;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(145930);
    d.i("MicroMsg.DefaultLuggageRecorder", "onBackground");
    AppMethodBeat.o(145930);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(145932);
    d.i("MicroMsg.DefaultLuggageRecorder", "onDestroy");
    release();
    AppMethodBeat.o(145932);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(145931);
    d.i("MicroMsg.DefaultLuggageRecorder", "onForeground");
    AppMethodBeat.o(145931);
  }
  
  protected void release()
  {
    try
    {
      AppMethodBeat.i(145933);
      this.ifs = null;
      if (this.ifr != null)
      {
        this.ifr.release();
        this.ifr = null;
      }
      AppMethodBeat.o(145933);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.c
 * JD-Core Version:    0.7.0.1
 */