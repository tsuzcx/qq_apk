package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class h$a
  implements Runnable
{
  ak handler;
  
  public h$a(h paramh)
  {
    AppMethodBeat.i(116500);
    this.handler = new h.a.1(this, paramh);
    AppMethodBeat.o(116500);
  }
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(116501);
    al.ae(h.d(this.ckE));
    ab.i("MicroMsg.SceneVoice.Recorder", "RecordStartRunnable begin run %s", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    synchronized (this.ckE)
    {
      ab.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of runnable[%s]!", new Object[] { Long.valueOf(Thread.currentThread().getId()), this.ckE });
      if (h.e(this.ckE) == null)
      {
        ab.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
        AppMethodBeat.o(116501);
        return;
      }
      String str = h.a(this.ckE);
      if (!h.f(this.ckE)) {}
      for (;;)
      {
        str = s.V(str, bool);
        ab.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[] { str, Boolean.valueOf(h.f(this.ckE)) });
        if (h.e(this.ckE).eH(str)) {
          break;
        }
        s.vP(h.a(this.ckE));
        h.g(this.ckE);
        h.h(this.ckE);
        ab.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.a(this.ckE) + "]");
        h.a(this.ckE, bo.yB());
        ab.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.a(this.ckE) + "] time:" + bo.av(h.j(this.ckE)));
        this.handler.sendEmptyMessageDelayed(0, 1L);
        AppMethodBeat.o(116501);
        return;
        bool = false;
      }
      h.i(this.ckE).requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.b.h.a
 * JD-Core Version:    0.7.0.1
 */