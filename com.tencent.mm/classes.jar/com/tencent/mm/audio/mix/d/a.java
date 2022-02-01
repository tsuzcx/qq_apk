package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.e;
import com.tencent.mm.audio.mix.e.c;
import com.tencent.mm.audio.mix.f.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public Object cTF;
  public d cUp;
  public HashMap<String, b> cUq;
  public HashMap<String, com.tencent.mm.aj.b> cUr;
  public List<String> cUs;
  public LinkedList<String> cUt;
  
  public a(d paramd)
  {
    AppMethodBeat.i(136786);
    this.cUq = new HashMap();
    this.cUr = new HashMap();
    this.cUs = new ArrayList();
    this.cUt = new LinkedList();
    this.cTF = new Object();
    this.cUp = paramd;
    e.MN().clearCache();
    AppMethodBeat.o(136786);
  }
  
  public final void MV()
  {
    AppMethodBeat.i(136789);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopAll");
    Iterator localIterator = this.cUt.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (b)this.cUq.get(localObject);
      if ((localObject != null) && (!((b)localObject).cUw) && (!((b)localObject).MW()))
      {
        localObject = ((b)localObject).cUx;
        if (localObject != null) {
          ((k)localObject).stop();
        }
      }
    }
    AppMethodBeat.o(136789);
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(136792);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
    if (this.cUp == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
      AppMethodBeat.o(136792);
      return false;
    }
    Object localObject2 = (com.tencent.mm.aj.b)this.cUr.get(paramString);
    if (localObject2 == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(136792);
      return false;
    }
    Object localObject1 = (b)this.cUq.get(paramString);
    k localk;
    if (localObject1 != null)
    {
      if ((((b)localObject1).cUw) && (!this.cUp.cWq.Nc()) && (!this.cUp.cWq.fp(paramString)))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        AppMethodBeat.o(136792);
        return true;
      }
      if (((b)localObject1).cUw)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
        ((b)localObject1).cUw = false;
        paramString = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.aj.b)localObject2);
        ((b)localObject1).b(f.a(this.cUp, paramString, paramBoolean2));
        h.a((i)localObject1);
        AppMethodBeat.o(136792);
        return true;
      }
      localk = ((b)localObject1).cUx;
      if ((localk == null) || (!paramBoolean1)) {
        break label305;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force decode to stop and create new task to run");
      localk.stop();
    }
    label305:
    do
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is not exist, create new task to run");
      localObject1 = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.aj.b)localObject2);
      localObject1 = f.a(this.cUp, (com.tencent.mm.audio.mix.g.b)localObject1, paramBoolean2);
      localObject2 = new b(new j()
      {
        public final void a(b paramAnonymousb)
        {
          AppMethodBeat.i(136785);
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "decode process end");
          h.b(paramAnonymousb);
          AppMethodBeat.o(136785);
        }
        
        public final void a(k paramAnonymousk)
        {
          AppMethodBeat.i(136784);
          if (paramAnonymousk == null)
          {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "process decoder is null");
            AppMethodBeat.o(136784);
            return;
          }
          com.tencent.mm.aj.b localb = paramAnonymousk.Nn();
          paramAnonymousk.Ng();
          paramAnonymousk.Nd();
          paramAnonymousk.release();
          paramAnonymousk = a.this.cTF;
          if (localb != null) {}
          try
          {
            if (a.this.cUs.contains(localb.filePath)) {
              a.this.cUs.remove(localb.filePath);
            }
            return;
          }
          finally
          {
            AppMethodBeat.o(136784);
          }
        }
      }, paramString);
      ((b)localObject2).b((k)localObject1);
      h.a((i)localObject2);
      this.cUq.put(paramString, localObject2);
      AppMethodBeat.o(136792);
      return true;
      if ((localk != null) && (localk.Nb()) && (!localk.Nc()))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
        localk.resume();
        AppMethodBeat.o(136792);
        return true;
      }
      if ((localk != null) && (localk.Nc()))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
        ((b)localObject1).cUw = false;
        paramString = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.aj.b)localObject2);
        ((b)localObject1).b(f.a(this.cUp, paramString, paramBoolean2));
        h.a((i)localObject1);
        AppMethodBeat.o(136792);
        return true;
      }
    } while (localk == null);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is run and playing audio");
    AppMethodBeat.o(136792);
    return true;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136787);
    this.cUq.clear();
    this.cUt.clear();
    this.cUr.clear();
    AppMethodBeat.o(136787);
  }
  
  public final boolean fd(String paramString)
  {
    AppMethodBeat.i(136788);
    synchronized (this.cTF)
    {
      boolean bool = this.cUs.contains(paramString);
      AppMethodBeat.o(136788);
      return bool;
    }
  }
  
  public final void fe(String paramString)
  {
    AppMethodBeat.i(136790);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", new Object[] { paramString });
    a(paramString, false, false);
    AppMethodBeat.o(136790);
  }
  
  public final void ff(String paramString)
  {
    AppMethodBeat.i(136791);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", new Object[] { paramString });
    b localb = (b)this.cUq.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136791);
      return;
    }
    if (localb.cUw)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136791);
      return;
    }
    k localk = localb.cUx;
    if (localk != null)
    {
      localk.stop();
      localb.cUx = null;
      this.cUq.remove(paramString);
    }
    AppMethodBeat.o(136791);
  }
  
  public final boolean fg(String paramString)
  {
    AppMethodBeat.i(136795);
    paramString = (b)this.cUq.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136795);
      return true;
    }
    if (paramString.cUw)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136795);
      return true;
    }
    if (paramString.MW())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136795);
      return true;
    }
    AppMethodBeat.o(136795);
    return false;
  }
  
  public final boolean fh(String paramString)
  {
    AppMethodBeat.i(136796);
    b localb = (b)this.cUq.get(paramString);
    if ((localb != null) && (localb.cUw) && (!this.cUp.cWq.Nc()) && (!this.cUp.cWq.fp(paramString)))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
      AppMethodBeat.o(136796);
      return true;
    }
    AppMethodBeat.o(136796);
    return false;
  }
  
  public final long fi(String paramString)
  {
    AppMethodBeat.i(177343);
    paramString = (b)this.cUq.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(177343);
      return -1L;
    }
    paramString = paramString.cUx;
    if (paramString != null)
    {
      long l = paramString.getCurrentPosition();
      AppMethodBeat.o(177343);
      return l;
    }
    AppMethodBeat.o(177343);
    return -1L;
  }
  
  public final boolean u(String paramString, int paramInt)
  {
    AppMethodBeat.i(136793);
    if (!v(paramString, paramInt))
    {
      AppMethodBeat.o(136793);
      return false;
    }
    v(paramString, paramInt);
    paramString = (b)this.cUq.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136793);
      return false;
    }
    if (paramString.cUw)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136793);
      return false;
    }
    if (paramString.MW())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136793);
      return false;
    }
    paramString = paramString.cUx;
    if (paramString != null) {
      paramString.seek(paramInt);
    }
    AppMethodBeat.o(136793);
    return true;
  }
  
  public final boolean v(String paramString, int paramInt)
  {
    AppMethodBeat.i(136794);
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.cUr.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(136794);
      return false;
    }
    localb.cUL = paramInt;
    AppMethodBeat.o(136794);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.a
 * JD-Core Version:    0.7.0.1
 */