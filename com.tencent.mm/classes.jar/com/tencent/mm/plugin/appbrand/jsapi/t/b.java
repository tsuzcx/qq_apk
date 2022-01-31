package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.d.a;
import com.tencent.mm.audio.d.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements c
{
  private a ifi;
  private Set<c.b> ifj;
  
  public b()
  {
    AppMethodBeat.i(145907);
    this.ifj = new HashSet();
    AppMethodBeat.o(145907);
  }
  
  private void release()
  {
    AppMethodBeat.i(145909);
    if (this.ifi != null)
    {
      this.ifi.release();
      this.ifi = null;
    }
    AppMethodBeat.o(145909);
  }
  
  public final g CU(String arg1)
  {
    AppMethodBeat.i(145910);
    if (bo.isNullOrNil(???))
    {
      d.e("MicaoMsg.DefaultLuggageVoicePlayer", "filePath is null");
      ??? = new g("filePath is null", new Object[0]);
      AppMethodBeat.o(145910);
      return ???;
    }
    if (!e.cN(???))
    {
      d.e("MicaoMsg.DefaultLuggageVoicePlayer", "file is not exist");
      ??? = new g("file is not exist", new Object[0]);
      AppMethodBeat.o(145910);
      return ???;
    }
    release();
    this.ifi = new com.tencent.mm.audio.d.b();
    this.ifi.a(new a.a()
    {
      public final void EW()
      {
        AppMethodBeat.i(145906);
        b.a(b.this).a(null);
        b.b(b.this);
        AppMethodBeat.o(145906);
      }
    });
    boolean bool = this.ifi.eK(???);
    d.i("MicaoMsg.DefaultLuggageVoicePlayer", "play:%s isOk:%b", new Object[] { ???, Boolean.valueOf(bool) });
    if (!bool)
    {
      d.i("MicaoMsg.DefaultLuggageVoicePlayer", "play fail");
      ??? = new g("fail to start, may be already start", new Object[0]);
      AppMethodBeat.o(145910);
      return ???;
    }
    synchronized (this.ifj)
    {
      Iterator localIterator = this.ifj.iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    ??? = g.ifo;
    AppMethodBeat.o(145910);
    return ???;
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(145913);
    synchronized (this.ifj)
    {
      this.ifj.add(paramb);
      AppMethodBeat.o(145913);
      return;
    }
  }
  
  public final g aFY()
  {
    AppMethodBeat.i(145911);
    if (this.ifi == null)
    {
      ??? = new g("fail to pause, may be not start", new Object[0]);
      AppMethodBeat.o(145911);
      return ???;
    }
    boolean bool = this.ifi.pause();
    d.i("MicaoMsg.DefaultLuggageVoicePlayer", "pause:%s isOk:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      d.i("MicaoMsg.DefaultLuggageVoicePlayer", "pause fail");
      ??? = new g("fail to pause, may be not start", new Object[0]);
      AppMethodBeat.o(145911);
      return ???;
    }
    synchronized (this.ifj)
    {
      Iterator localIterator = this.ifj.iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    ??? = g.ifo;
    AppMethodBeat.o(145911);
    return ???;
  }
  
  public final g aFZ()
  {
    AppMethodBeat.i(145912);
    if (this.ifi == null)
    {
      ??? = new g("fail to stop, may be not start", new Object[0]);
      AppMethodBeat.o(145912);
      return ???;
    }
    this.ifi.Ez();
    d.i("MicaoMsg.DefaultLuggageVoicePlayer", "stop isOk:%b", new Object[] { Boolean.TRUE });
    this.ifi.a(null);
    release();
    synchronized (this.ifj)
    {
      Iterator localIterator = this.ifj.iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    ??? = g.ifo;
    AppMethodBeat.o(145912);
    return ???;
  }
  
  public final void b(c.b paramb)
  {
    AppMethodBeat.i(145914);
    synchronized (this.ifj)
    {
      this.ifj.remove(paramb);
      AppMethodBeat.o(145914);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(145908);
    release();
    AppMethodBeat.o(145908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.b
 * JD-Core Version:    0.7.0.1
 */