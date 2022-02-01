package com.tencent.mm.audio.mix.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class a
  implements f
{
  Object dup;
  public volatile LinkedList<String> dvR;
  volatile ArrayList<String> dvS;
  public f.a dvT;
  public volatile HashMap<String, c> dvb;
  
  public a()
  {
    AppMethodBeat.i(198113);
    this.dvb = new HashMap();
    this.dvR = new LinkedList();
    this.dvS = new ArrayList();
    this.dup = new Object();
    AppMethodBeat.o(198113);
  }
  
  public final boolean a(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(198114);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Audio.AudioDownloadMgr", "startDownload");
    if (paramb == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "param is null");
      AppMethodBeat.o(198114);
      return false;
    }
    if (TextUtils.isEmpty(paramb.dvn))
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "srcUrl is null");
      AppMethodBeat.o(198114);
      return false;
    }
    if (this.dvS.contains(paramb.dvn))
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "srcUrl:%s is download finish", new Object[] { paramb.dvn });
      AppMethodBeat.o(198114);
      return false;
    }
    if (this.dvb.containsKey(paramb.dvn))
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "task is exit!");
      AppMethodBeat.o(198114);
      return true;
    }
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Audio.AudioDownloadMgr", "download src:%s, audioId:%s", new Object[] { paramb.dvn, paramb.dtX });
    c localc = new c(new b(new e()
    {
      public final void c(com.tencent.mm.ai.b paramAnonymousb)
      {
        AppMethodBeat.i(198111);
        String str = "";
        Object localObject = a.this.dup;
        if (paramAnonymousb != null) {}
        try
        {
          a.this.dvb.remove(paramAnonymousb.dvn);
          str = paramAnonymousb.dvn;
          a.this.dvS.add(paramAnonymousb.dvn);
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Audio.AudioDownloadMgr", "download finish, src:%s", new Object[] { str });
          if (a.this.dvT != null) {
            a.this.dvT.e(paramAnonymousb);
          }
          AppMethodBeat.o(198111);
          return;
        }
        finally
        {
          AppMethodBeat.o(198111);
        }
      }
      
      public final void d(com.tencent.mm.ai.b paramAnonymousb)
      {
        AppMethodBeat.i(198112);
        String str = "";
        Object localObject = a.this.dup;
        if (paramAnonymousb != null) {}
        try
        {
          a.this.dvb.remove(paramAnonymousb.dvn);
          str = paramAnonymousb.dvn;
          com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "download fail, src:%s", new Object[] { str });
          AppMethodBeat.o(198112);
          return;
        }
        finally
        {
          AppMethodBeat.o(198112);
        }
      }
    }), paramb.dtX);
    localc.b(b(paramb));
    d.a(localc);
    synchronized (this.dup)
    {
      this.dvb.put(paramb.dvn, localc);
      this.dvR.add(paramb.dvn);
      AppMethodBeat.o(198114);
      return true;
    }
  }
  
  protected com.tencent.mm.audio.mix.h.c b(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(198115);
    paramb = new com.tencent.mm.audio.mix.h.b();
    AppMethodBeat.o(198115);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.a
 * JD-Core Version:    0.7.0.1
 */