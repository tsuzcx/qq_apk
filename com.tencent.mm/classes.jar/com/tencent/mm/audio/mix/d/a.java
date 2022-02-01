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
  public Object ddu;
  public d dee;
  public HashMap<String, b> def;
  public HashMap<String, com.tencent.mm.ai.b> deg;
  public List<String> deh;
  public LinkedList<String> dei;
  
  public a(d paramd)
  {
    AppMethodBeat.i(136786);
    this.def = new HashMap();
    this.deg = new HashMap();
    this.deh = new ArrayList();
    this.dei = new LinkedList();
    this.ddu = new Object();
    this.dee = paramd;
    e.Os().clearCache();
    AppMethodBeat.o(136786);
  }
  
  public final void OA()
  {
    AppMethodBeat.i(136789);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopAll");
    Iterator localIterator = this.dei.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (b)this.def.get(localObject);
      if ((localObject != null) && (!((b)localObject).del) && (!((b)localObject).OB()))
      {
        localObject = ((b)localObject).dem;
        if (localObject != null) {
          ((k)localObject).stop();
        }
      }
    }
    AppMethodBeat.o(136789);
  }
  
  public final boolean b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(136792);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
    if (this.dee == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
      AppMethodBeat.o(136792);
      return false;
    }
    Object localObject2 = (com.tencent.mm.ai.b)this.deg.get(paramString);
    if (localObject2 == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(136792);
      return false;
    }
    Object localObject1 = (b)this.def.get(paramString);
    k localk;
    if (localObject1 != null)
    {
      if ((((b)localObject1).del) && (!this.dee.dge.OH()) && (!this.dee.dge.gg(paramString)))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        AppMethodBeat.o(136792);
        return true;
      }
      if (((b)localObject1).del)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
        ((b)localObject1).del = false;
        paramString = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.ai.b)localObject2);
        ((b)localObject1).b(f.a(this.dee, paramString, paramBoolean2));
        h.a((i)localObject1);
        AppMethodBeat.o(136792);
        return true;
      }
      localk = ((b)localObject1).dem;
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
      localObject1 = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.ai.b)localObject2);
      localObject1 = f.a(this.dee, (com.tencent.mm.audio.mix.g.b)localObject1, paramBoolean2);
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
          com.tencent.mm.ai.b localb = paramAnonymousk.OS();
          paramAnonymousk.OL();
          paramAnonymousk.OI();
          paramAnonymousk.release();
          paramAnonymousk = a.this.ddu;
          if (localb != null) {}
          try
          {
            if (a.this.deh.contains(localb.filePath)) {
              a.this.deh.remove(localb.filePath);
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
      this.def.put(paramString, localObject2);
      AppMethodBeat.o(136792);
      return true;
      if ((localk != null) && (localk.OG()) && (!localk.OH()))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
        localk.resume();
        AppMethodBeat.o(136792);
        return true;
      }
      if ((localk != null) && (localk.OH()))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
        ((b)localObject1).del = false;
        paramString = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.ai.b)localObject2);
        ((b)localObject1).b(f.a(this.dee, paramString, paramBoolean2));
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
    this.def.clear();
    this.dei.clear();
    this.deg.clear();
    AppMethodBeat.o(136787);
  }
  
  public final boolean fU(String paramString)
  {
    AppMethodBeat.i(136788);
    synchronized (this.ddu)
    {
      boolean bool = this.deh.contains(paramString);
      AppMethodBeat.o(136788);
      return bool;
    }
  }
  
  public final void fV(String paramString)
  {
    AppMethodBeat.i(136790);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", new Object[] { paramString });
    b(paramString, false, false);
    AppMethodBeat.o(136790);
  }
  
  public final void fW(String paramString)
  {
    AppMethodBeat.i(136791);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", new Object[] { paramString });
    b localb = (b)this.def.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136791);
      return;
    }
    if (localb.del)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136791);
      return;
    }
    k localk = localb.dem;
    if (localk != null)
    {
      localk.stop();
      localb.dem = null;
      this.def.remove(paramString);
    }
    AppMethodBeat.o(136791);
  }
  
  public final boolean fX(String paramString)
  {
    AppMethodBeat.i(136795);
    paramString = (b)this.def.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136795);
      return true;
    }
    if (paramString.del)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136795);
      return true;
    }
    if (paramString.OB())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136795);
      return true;
    }
    AppMethodBeat.o(136795);
    return false;
  }
  
  public final boolean fY(String paramString)
  {
    AppMethodBeat.i(136796);
    b localb = (b)this.def.get(paramString);
    if ((localb != null) && (localb.del) && (!this.dee.dge.OH()) && (!this.dee.dge.gg(paramString)))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
      AppMethodBeat.o(136796);
      return true;
    }
    AppMethodBeat.o(136796);
    return false;
  }
  
  public final long fZ(String paramString)
  {
    AppMethodBeat.i(177343);
    paramString = (b)this.def.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(177343);
      return -1L;
    }
    paramString = paramString.dem;
    if (paramString != null)
    {
      long l = paramString.getCurrentPosition();
      AppMethodBeat.o(177343);
      return l;
    }
    AppMethodBeat.o(177343);
    return -1L;
  }
  
  public final boolean x(String paramString, int paramInt)
  {
    AppMethodBeat.i(136793);
    if (!y(paramString, paramInt))
    {
      AppMethodBeat.o(136793);
      return false;
    }
    y(paramString, paramInt);
    paramString = (b)this.def.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136793);
      return false;
    }
    if (paramString.del)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136793);
      return false;
    }
    if (paramString.OB())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136793);
      return false;
    }
    paramString = paramString.dem;
    if (paramString != null) {
      paramString.seek(paramInt);
    }
    AppMethodBeat.o(136793);
    return true;
  }
  
  public final boolean y(String paramString, int paramInt)
  {
    AppMethodBeat.i(136794);
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.deg.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(136794);
      return false;
    }
    localb.dez = paramInt;
    AppMethodBeat.o(136794);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.a
 * JD-Core Version:    0.7.0.1
 */