package com.tencent.mm.audio.mix.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class a
  implements f
{
  Object fmX;
  public volatile HashMap<String, c> fnJ;
  public volatile LinkedList<String> foA;
  volatile ArrayList<String> foB;
  public f.a foC;
  
  public a()
  {
    AppMethodBeat.i(257033);
    this.fnJ = new HashMap();
    this.foA = new LinkedList();
    this.foB = new ArrayList();
    this.fmX = new Object();
    AppMethodBeat.o(257033);
  }
  
  public final boolean a(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(257034);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Audio.AudioDownloadMgr", "startDownload");
    if (paramb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "param is null");
      AppMethodBeat.o(257034);
      return false;
    }
    if (TextUtils.isEmpty(paramb.fnV))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "srcUrl is null");
      AppMethodBeat.o(257034);
      return false;
    }
    if (this.foB.contains(paramb.fnV))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "srcUrl:%s is download finish", new Object[] { paramb.fnV });
      AppMethodBeat.o(257034);
      return false;
    }
    if (this.fnJ.containsKey(paramb.fnV))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "task is exit!");
      AppMethodBeat.o(257034);
      return true;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Audio.AudioDownloadMgr", "download src:%s, audioId:%s", new Object[] { paramb.fnV, paramb.fmF });
    c localc = new c(new b(new e()
    {
      public final void c(com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(257206);
        String str = "";
        Object localObject = a.this.fmX;
        if (paramAnonymousb != null) {}
        try
        {
          a.this.fnJ.remove(paramAnonymousb.fnV);
          str = paramAnonymousb.fnV;
          a.this.foB.add(paramAnonymousb.fnV);
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Audio.AudioDownloadMgr", "download finish, src:%s", new Object[] { str });
          if (a.this.foC != null) {
            a.this.foC.e(paramAnonymousb);
          }
          AppMethodBeat.o(257206);
          return;
        }
        finally
        {
          AppMethodBeat.o(257206);
        }
      }
      
      public final void d(com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(257207);
        String str = "";
        Object localObject = a.this.fmX;
        if (paramAnonymousb != null) {}
        try
        {
          a.this.fnJ.remove(paramAnonymousb.fnV);
          str = paramAnonymousb.fnV;
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "download fail, src:%s", new Object[] { str });
          AppMethodBeat.o(257207);
          return;
        }
        finally
        {
          AppMethodBeat.o(257207);
        }
      }
    }), paramb.fmF);
    localc.b(b(paramb));
    d.a(localc);
    synchronized (this.fmX)
    {
      this.fnJ.put(paramb.fnV, localc);
      this.foA.add(paramb.fnV);
      AppMethodBeat.o(257034);
      return true;
    }
  }
  
  protected com.tencent.mm.audio.mix.g.c b(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(257035);
    paramb = new com.tencent.mm.audio.mix.g.b();
    AppMethodBeat.o(257035);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.a
 * JD-Core Version:    0.7.0.1
 */