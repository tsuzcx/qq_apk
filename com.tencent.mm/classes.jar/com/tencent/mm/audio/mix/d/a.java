package com.tencent.mm.audio.mix.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class a
  implements f
{
  public volatile HashMap<String, c> hrU;
  Object hri;
  public volatile LinkedList<String> hsK;
  volatile ArrayList<String> hsL;
  public f.a hsM;
  
  public a()
  {
    AppMethodBeat.i(236201);
    this.hrU = new HashMap();
    this.hsK = new LinkedList();
    this.hsL = new ArrayList();
    this.hri = new Object();
    AppMethodBeat.o(236201);
  }
  
  public final boolean a(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(236202);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Audio.AudioDownloadMgr", "startDownload");
    if (paramb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "param is null");
      AppMethodBeat.o(236202);
      return false;
    }
    if (TextUtils.isEmpty(paramb.hsg))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "srcUrl is null");
      AppMethodBeat.o(236202);
      return false;
    }
    if (this.hsL.contains(paramb.hsg))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "srcUrl:%s is download finish", new Object[] { paramb.hsg });
      AppMethodBeat.o(236202);
      return false;
    }
    if (this.hrU.containsKey(paramb.hsg))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "task is exit!");
      AppMethodBeat.o(236202);
      return true;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Audio.AudioDownloadMgr", "download src:%s, audioId:%s", new Object[] { paramb.hsg, paramb.hqQ });
    c localc = new c(new b(new e()
    {
      public final void c(com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(236209);
        String str = "";
        Object localObject = a.this.hri;
        if (paramAnonymousb != null) {}
        try
        {
          a.this.hrU.remove(paramAnonymousb.hsg);
          str = paramAnonymousb.hsg;
          a.this.hsL.add(paramAnonymousb.hsg);
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Audio.AudioDownloadMgr", "download finish, src:%s", new Object[] { str });
          if (a.this.hsM != null) {
            a.this.hsM.e(paramAnonymousb);
          }
          AppMethodBeat.o(236209);
          return;
        }
        finally
        {
          AppMethodBeat.o(236209);
        }
      }
      
      public final void d(com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(236211);
        String str = "";
        Object localObject = a.this.hri;
        if (paramAnonymousb != null) {}
        try
        {
          a.this.hrU.remove(paramAnonymousb.hsg);
          str = paramAnonymousb.hsg;
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "download fail, src:%s", new Object[] { str });
          AppMethodBeat.o(236211);
          return;
        }
        finally
        {
          AppMethodBeat.o(236211);
        }
      }
    }), paramb.hqQ);
    localc.b(b(paramb));
    d.a(localc);
    synchronized (this.hri)
    {
      this.hrU.put(paramb.hsg, localc);
      this.hsK.add(paramb.hsg);
      AppMethodBeat.o(236202);
      return true;
    }
  }
  
  protected com.tencent.mm.audio.mix.g.c b(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(236206);
    paramb = new com.tencent.mm.audio.mix.g.b();
    AppMethodBeat.o(236206);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.a
 * JD-Core Version:    0.7.0.1
 */