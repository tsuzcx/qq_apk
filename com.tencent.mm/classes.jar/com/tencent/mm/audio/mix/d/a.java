package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.g.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public Object dup;
  public d dva;
  public HashMap<String, b> dvb;
  public HashMap<String, com.tencent.mm.ai.b> dvc;
  public List<String> dvd;
  public LinkedList<String> dve;
  
  public a(d paramd)
  {
    AppMethodBeat.i(136786);
    this.dvb = new HashMap();
    this.dvc = new HashMap();
    this.dvd = new ArrayList();
    this.dve = new LinkedList();
    this.dup = new Object();
    this.dva = paramd;
    com.tencent.mm.audio.mix.b.f.YL().clearCache();
    AppMethodBeat.o(136786);
  }
  
  public final boolean c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(136792);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
    if (this.dva == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
      AppMethodBeat.o(136792);
      return false;
    }
    Object localObject2 = (com.tencent.mm.ai.b)this.dvc.get(paramString);
    if (localObject2 == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(136792);
      return false;
    }
    Object localObject1 = (b)this.dvb.get(paramString);
    l locall;
    if (localObject1 != null)
    {
      if ((((b)localObject1).dvh) && (!this.dva.dxo.YZ()) && (!this.dva.dxo.gW(paramString)))
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        AppMethodBeat.o(136792);
        return true;
      }
      if (((b)localObject1).dvh)
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
        ((b)localObject1).dvh = false;
        paramString = new com.tencent.mm.audio.mix.h.a((com.tencent.mm.ai.b)localObject2);
        ((b)localObject1).b(f.a(this.dva, paramString, paramBoolean2));
        i.a((j)localObject1);
        AppMethodBeat.o(136792);
        return true;
      }
      locall = ((b)localObject1).dvi;
      if ((locall == null) || (!paramBoolean1)) {
        break label305;
      }
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "force decode to stop and create new task to run");
      locall.stop();
    }
    label305:
    do
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is not exist, create new task to run");
      localObject1 = new com.tencent.mm.audio.mix.h.a((com.tencent.mm.ai.b)localObject2);
      localObject1 = f.a(this.dva, (com.tencent.mm.audio.mix.h.c)localObject1, paramBoolean2);
      localObject2 = new b(new k()
      {
        public final void a(b paramAnonymousb)
        {
          AppMethodBeat.i(136785);
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "decode process end");
          i.b(paramAnonymousb);
          AppMethodBeat.o(136785);
        }
        
        public final void a(l paramAnonymousl)
        {
          AppMethodBeat.i(136784);
          if (paramAnonymousl == null)
          {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "process decoder is null");
            AppMethodBeat.o(136784);
            return;
          }
          com.tencent.mm.ai.b localb = paramAnonymousl.Zk();
          paramAnonymousl.Zd();
          paramAnonymousl.Za();
          paramAnonymousl.release();
          paramAnonymousl = a.this.dup;
          if (localb != null) {}
          try
          {
            if (a.this.dvd.contains(localb.filePath)) {
              a.this.dvd.remove(localb.filePath);
            }
            return;
          }
          finally
          {
            AppMethodBeat.o(136784);
          }
        }
      }, paramString);
      ((b)localObject2).b((l)localObject1);
      i.a((j)localObject2);
      this.dvb.put(paramString, localObject2);
      AppMethodBeat.o(136792);
      return true;
      if ((locall != null) && (locall.YY()) && (!locall.YZ()))
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
        locall.resume();
        AppMethodBeat.o(136792);
        return true;
      }
      if ((locall != null) && (locall.YZ()))
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
        ((b)localObject1).dvh = false;
        paramString = new com.tencent.mm.audio.mix.h.a((com.tencent.mm.ai.b)localObject2);
        ((b)localObject1).b(f.a(this.dva, paramString, paramBoolean2));
        i.a((j)localObject1);
        AppMethodBeat.o(136792);
        return true;
      }
    } while (locall == null);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is run and playing audio");
    AppMethodBeat.o(136792);
    return true;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136787);
    this.dvb.clear();
    this.dve.clear();
    this.dvc.clear();
    AppMethodBeat.o(136787);
  }
  
  public final boolean gK(String paramString)
  {
    AppMethodBeat.i(136788);
    synchronized (this.dup)
    {
      boolean bool = this.dvd.contains(paramString);
      AppMethodBeat.o(136788);
      return bool;
    }
  }
  
  public final void gL(String paramString)
  {
    AppMethodBeat.i(136790);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", new Object[] { paramString });
    c(paramString, false, false);
    AppMethodBeat.o(136790);
  }
  
  public final void gM(String paramString)
  {
    AppMethodBeat.i(136791);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", new Object[] { paramString });
    b localb = (b)this.dvb.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136791);
      return;
    }
    if (localb.dvh)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136791);
      return;
    }
    l locall = localb.dvi;
    if (locall != null)
    {
      locall.stop();
      localb.dvi = null;
      this.dvb.remove(paramString);
    }
    AppMethodBeat.o(136791);
  }
  
  public final boolean gN(String paramString)
  {
    AppMethodBeat.i(136795);
    paramString = (b)this.dvb.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(136795);
      return true;
    }
    if (paramString.dvh)
    {
      AppMethodBeat.o(136795);
      return true;
    }
    if (paramString.YT())
    {
      AppMethodBeat.o(136795);
      return true;
    }
    AppMethodBeat.o(136795);
    return false;
  }
  
  public final boolean gO(String paramString)
  {
    AppMethodBeat.i(136796);
    b localb = (b)this.dvb.get(paramString);
    if ((localb != null) && (localb.dvh) && (!this.dva.dxo.YZ()) && (!this.dva.dxo.gW(paramString)))
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
      AppMethodBeat.o(136796);
      return true;
    }
    AppMethodBeat.o(136796);
    return false;
  }
  
  public final long gP(String paramString)
  {
    AppMethodBeat.i(177343);
    paramString = (b)this.dvb.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(177343);
      return -1L;
    }
    paramString = paramString.dvi;
    if (paramString != null)
    {
      long l = paramString.getCurrentPosition();
      AppMethodBeat.o(177343);
      return l;
    }
    AppMethodBeat.o(177343);
    return -1L;
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(136789);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopAll");
    Iterator localIterator = this.dve.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (b)this.dvb.get(localObject);
      if ((localObject != null) && (!((b)localObject).dvh) && (!((b)localObject).YT()))
      {
        localObject = ((b)localObject).dvi;
        if (localObject != null) {
          ((l)localObject).stop();
        }
      }
    }
    AppMethodBeat.o(136789);
  }
  
  public final boolean y(String paramString, int paramInt)
  {
    AppMethodBeat.i(136793);
    if (!z(paramString, paramInt))
    {
      AppMethodBeat.o(136793);
      return false;
    }
    z(paramString, paramInt);
    paramString = (b)this.dvb.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136793);
      return false;
    }
    if (paramString.dvh)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136793);
      return false;
    }
    if (paramString.YT())
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136793);
      return false;
    }
    paramString = paramString.dvi;
    if (paramString != null) {
      paramString.seek(paramInt);
    }
    AppMethodBeat.o(136793);
    return true;
  }
  
  public final boolean z(String paramString, int paramInt)
  {
    AppMethodBeat.i(136794);
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.dvc.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(136794);
      return false;
    }
    localb.dvv = paramInt;
    AppMethodBeat.o(136794);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.a
 * JD-Core Version:    0.7.0.1
 */