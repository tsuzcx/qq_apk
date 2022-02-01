package com.tencent.mm.audio.mix.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.f.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public d hrT;
  public HashMap<String, b> hrU;
  public HashMap<String, com.tencent.mm.al.b> hrV;
  public List<String> hrW;
  public LinkedList<String> hrX;
  public Object hri;
  
  public a(d paramd)
  {
    AppMethodBeat.i(136786);
    this.hrU = new HashMap();
    this.hrV = new HashMap();
    this.hrW = new ArrayList();
    this.hrX = new LinkedList();
    this.hri = new Object();
    this.hrT = paramd;
    com.tencent.mm.audio.mix.b.f.aFr().clearCache();
    AppMethodBeat.o(136786);
  }
  
  public final boolean Z(String paramString, int paramInt)
  {
    AppMethodBeat.i(136793);
    if (!aa(paramString, paramInt))
    {
      AppMethodBeat.o(136793);
      return false;
    }
    aa(paramString, paramInt);
    paramString = (b)this.hrU.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136793);
      return false;
    }
    if (paramString.hsa)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136793);
      return false;
    }
    if (paramString.aFA())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136793);
      return false;
    }
    paramString = paramString.hsb;
    if (paramString != null) {
      paramString.seek(paramInt);
    }
    AppMethodBeat.o(136793);
    return true;
  }
  
  public final boolean aa(String paramString, int paramInt)
  {
    AppMethodBeat.i(136794);
    com.tencent.mm.al.b localb = (com.tencent.mm.al.b)this.hrV.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(136794);
      return false;
    }
    localb.startTime = paramInt;
    AppMethodBeat.o(136794);
    return true;
  }
  
  public final boolean c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(136792);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
    if (this.hrT == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
      AppMethodBeat.o(136792);
      return false;
    }
    Object localObject2 = (com.tencent.mm.al.b)this.hrV.get(paramString);
    if (localObject2 == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(136792);
      return false;
    }
    Object localObject1 = (b)this.hrU.get(paramString);
    l locall;
    if (localObject1 != null)
    {
      if ((((b)localObject1).hsa) && (!this.hrT.huj.aFG()) && (!this.hrT.huj.jk(paramString)))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        AppMethodBeat.o(136792);
        return true;
      }
      if (((b)localObject1).hsa)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
        ((b)localObject1).hsa = false;
        paramString = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.al.b)localObject2);
        ((b)localObject1).b(f.a(this.hrT, paramString, paramBoolean2));
        i.a((j)localObject1);
        AppMethodBeat.o(136792);
        return true;
      }
      locall = ((b)localObject1).hsb;
      if ((locall == null) || (!paramBoolean1)) {
        break label325;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force decode to stop and create new task to run");
      locall.stop();
    }
    label325:
    do
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is not exist, create new task to run");
      localObject1 = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.al.b)localObject2);
      localObject1 = f.a(this.hrT, (com.tencent.mm.audio.mix.g.c)localObject1, paramBoolean2);
      localObject2 = new b(new k()
      {
        public final void a(b paramAnonymousb)
        {
          AppMethodBeat.i(136785);
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "decode process end");
          i.b(paramAnonymousb);
          AppMethodBeat.o(136785);
        }
        
        public final void a(l paramAnonymousl)
        {
          AppMethodBeat.i(136784);
          if (paramAnonymousl == null)
          {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "process decoder is null");
            AppMethodBeat.o(136784);
            return;
          }
          com.tencent.mm.al.b localb = paramAnonymousl.aFR();
          paramAnonymousl.aFL();
          paramAnonymousl.aFI();
          paramAnonymousl.release();
          paramAnonymousl = a.this.hri;
          if (localb != null) {}
          try
          {
            if (a.this.hrW.contains(localb.filePath)) {
              a.this.hrW.remove(localb.filePath);
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
      this.hrU.put(paramString, localObject2);
      if (!this.hrX.contains(paramString)) {
        this.hrX.add(paramString);
      }
      AppMethodBeat.o(136792);
      return true;
      if ((locall != null) && (locall.aFF()) && (!locall.aFG()))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
        locall.resume();
        AppMethodBeat.o(136792);
        return true;
      }
      if ((locall != null) && (locall.aFG()))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
        ((b)localObject1).hsa = false;
        paramString = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.al.b)localObject2);
        ((b)localObject1).b(f.a(this.hrT, paramString, paramBoolean2));
        i.a((j)localObject1);
        AppMethodBeat.o(136792);
        return true;
      }
    } while (locall == null);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is run and playing audio");
    AppMethodBeat.o(136792);
    return true;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136787);
    this.hrU.clear();
    this.hrX.clear();
    this.hrV.clear();
    AppMethodBeat.o(136787);
  }
  
  public final boolean iX(String paramString)
  {
    AppMethodBeat.i(136788);
    synchronized (this.hri)
    {
      boolean bool = this.hrW.contains(paramString);
      AppMethodBeat.o(136788);
      return bool;
    }
  }
  
  public final void iY(String paramString)
  {
    AppMethodBeat.i(136790);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", new Object[] { paramString });
    c(paramString, false, false);
    AppMethodBeat.o(136790);
  }
  
  public final void iZ(String paramString)
  {
    AppMethodBeat.i(136791);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", new Object[] { paramString });
    b localb = (b)this.hrU.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136791);
      return;
    }
    if (localb.hsa)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136791);
      return;
    }
    l locall = localb.hsb;
    if (locall != null)
    {
      locall.stop();
      localb.hsb = null;
      this.hrU.remove(paramString);
    }
    AppMethodBeat.o(136791);
  }
  
  public final boolean ja(String paramString)
  {
    AppMethodBeat.i(136795);
    paramString = (b)this.hrU.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(136795);
      return true;
    }
    if (paramString.hsa)
    {
      AppMethodBeat.o(136795);
      return true;
    }
    if (paramString.aFA())
    {
      AppMethodBeat.o(136795);
      return true;
    }
    AppMethodBeat.o(136795);
    return false;
  }
  
  public final boolean jb(String paramString)
  {
    AppMethodBeat.i(136796);
    b localb = (b)this.hrU.get(paramString);
    if ((localb != null) && (localb.hsa) && (!this.hrT.huj.aFG()) && (!this.hrT.huj.jk(paramString)))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
      AppMethodBeat.o(136796);
      return true;
    }
    AppMethodBeat.o(136796);
    return false;
  }
  
  public final long jc(String paramString)
  {
    AppMethodBeat.i(177343);
    paramString = (b)this.hrU.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(177343);
      return -1L;
    }
    paramString = paramString.hsb;
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
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopAll");
    Iterator localIterator = this.hrX.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (b)this.hrU.get(localObject);
      if ((localObject != null) && (!((b)localObject).hsa) && (!((b)localObject).aFA()))
      {
        localObject = ((b)localObject).hsb;
        if (localObject != null) {
          ((l)localObject).stop();
        }
      }
    }
    AppMethodBeat.o(136789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.a
 * JD-Core Version:    0.7.0.1
 */