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
  public Object fmX;
  public d fnI;
  public HashMap<String, b> fnJ;
  public HashMap<String, com.tencent.mm.al.b> fnK;
  public List<String> fnL;
  public LinkedList<String> fnM;
  
  public a(d paramd)
  {
    AppMethodBeat.i(136786);
    this.fnJ = new HashMap();
    this.fnK = new HashMap();
    this.fnL = new ArrayList();
    this.fnM = new LinkedList();
    this.fmX = new Object();
    this.fnI = paramd;
    com.tencent.mm.audio.mix.b.f.ads().clearCache();
    AppMethodBeat.o(136786);
  }
  
  public final boolean Q(String paramString, int paramInt)
  {
    AppMethodBeat.i(136793);
    if (!R(paramString, paramInt))
    {
      AppMethodBeat.o(136793);
      return false;
    }
    R(paramString, paramInt);
    paramString = (b)this.fnJ.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136793);
      return false;
    }
    if (paramString.fnP)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136793);
      return false;
    }
    if (paramString.adC())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136793);
      return false;
    }
    paramString = paramString.fnQ;
    if (paramString != null) {
      paramString.seek(paramInt);
    }
    AppMethodBeat.o(136793);
    return true;
  }
  
  public final boolean R(String paramString, int paramInt)
  {
    AppMethodBeat.i(136794);
    com.tencent.mm.al.b localb = (com.tencent.mm.al.b)this.fnK.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(136794);
      return false;
    }
    localb.fod = paramInt;
    AppMethodBeat.o(136794);
    return true;
  }
  
  public final boolean c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(136792);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
    if (this.fnI == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
      AppMethodBeat.o(136792);
      return false;
    }
    Object localObject2 = (com.tencent.mm.al.b)this.fnK.get(paramString);
    if (localObject2 == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(136792);
      return false;
    }
    Object localObject1 = (b)this.fnJ.get(paramString);
    l locall;
    if (localObject1 != null)
    {
      if ((((b)localObject1).fnP) && (!this.fnI.fqa.adI()) && (!this.fnI.fqa.hJ(paramString)))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        AppMethodBeat.o(136792);
        return true;
      }
      if (((b)localObject1).fnP)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
        ((b)localObject1).fnP = false;
        paramString = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.al.b)localObject2);
        ((b)localObject1).b(f.a(this.fnI, paramString, paramBoolean2));
        i.a((j)localObject1);
        AppMethodBeat.o(136792);
        return true;
      }
      locall = ((b)localObject1).fnQ;
      if ((locall == null) || (!paramBoolean1)) {
        break label305;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force decode to stop and create new task to run");
      locall.stop();
    }
    label305:
    do
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is not exist, create new task to run");
      localObject1 = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.al.b)localObject2);
      localObject1 = f.a(this.fnI, (com.tencent.mm.audio.mix.g.c)localObject1, paramBoolean2);
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
          com.tencent.mm.al.b localb = paramAnonymousl.adT();
          paramAnonymousl.adM();
          paramAnonymousl.adJ();
          paramAnonymousl.release();
          paramAnonymousl = a.this.fmX;
          if (localb != null) {}
          try
          {
            if (a.this.fnL.contains(localb.filePath)) {
              a.this.fnL.remove(localb.filePath);
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
      this.fnJ.put(paramString, localObject2);
      AppMethodBeat.o(136792);
      return true;
      if ((locall != null) && (locall.adH()) && (!locall.adI()))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
        locall.resume();
        AppMethodBeat.o(136792);
        return true;
      }
      if ((locall != null) && (locall.adI()))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
        ((b)localObject1).fnP = false;
        paramString = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.al.b)localObject2);
        ((b)localObject1).b(f.a(this.fnI, paramString, paramBoolean2));
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
    this.fnJ.clear();
    this.fnM.clear();
    this.fnK.clear();
    AppMethodBeat.o(136787);
  }
  
  public final boolean hA(String paramString)
  {
    AppMethodBeat.i(136796);
    b localb = (b)this.fnJ.get(paramString);
    if ((localb != null) && (localb.fnP) && (!this.fnI.fqa.adI()) && (!this.fnI.fqa.hJ(paramString)))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
      AppMethodBeat.o(136796);
      return true;
    }
    AppMethodBeat.o(136796);
    return false;
  }
  
  public final long hB(String paramString)
  {
    AppMethodBeat.i(177343);
    paramString = (b)this.fnJ.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(177343);
      return -1L;
    }
    paramString = paramString.fnQ;
    if (paramString != null)
    {
      long l = paramString.getCurrentPosition();
      AppMethodBeat.o(177343);
      return l;
    }
    AppMethodBeat.o(177343);
    return -1L;
  }
  
  public final boolean hw(String paramString)
  {
    AppMethodBeat.i(136788);
    synchronized (this.fmX)
    {
      boolean bool = this.fnL.contains(paramString);
      AppMethodBeat.o(136788);
      return bool;
    }
  }
  
  public final void hx(String paramString)
  {
    AppMethodBeat.i(136790);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", new Object[] { paramString });
    c(paramString, false, false);
    AppMethodBeat.o(136790);
  }
  
  public final void hy(String paramString)
  {
    AppMethodBeat.i(136791);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", new Object[] { paramString });
    b localb = (b)this.fnJ.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136791);
      return;
    }
    if (localb.fnP)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136791);
      return;
    }
    l locall = localb.fnQ;
    if (locall != null)
    {
      locall.stop();
      localb.fnQ = null;
      this.fnJ.remove(paramString);
    }
    AppMethodBeat.o(136791);
  }
  
  public final boolean hz(String paramString)
  {
    AppMethodBeat.i(136795);
    paramString = (b)this.fnJ.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(136795);
      return true;
    }
    if (paramString.fnP)
    {
      AppMethodBeat.o(136795);
      return true;
    }
    if (paramString.adC())
    {
      AppMethodBeat.o(136795);
      return true;
    }
    AppMethodBeat.o(136795);
    return false;
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(136789);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopAll");
    Iterator localIterator = this.fnM.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (b)this.fnJ.get(localObject);
      if ((localObject != null) && (!((b)localObject).fnP) && (!((b)localObject).adC()))
      {
        localObject = ((b)localObject).fnQ;
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