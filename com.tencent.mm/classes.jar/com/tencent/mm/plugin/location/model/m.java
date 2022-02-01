package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.b.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements i
{
  public static final String URL;
  LinkedList<com.tencent.mm.pluginsdk.location.d> EjV;
  com.tencent.mm.pluginsdk.location.d EjW;
  private List<c> callbacks;
  int h;
  private QueueWorkerThread lLz;
  int w;
  
  static
  {
    AppMethodBeat.i(244576);
    URL = "http://" + WeChatHosts.domainString(a.i.host_st_map_qq_com) + "/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin";
    AppMethodBeat.o(244576);
  }
  
  public m()
  {
    AppMethodBeat.i(55717);
    this.lLz = new QueueWorkerThread(1, "location_worker");
    this.EjV = new LinkedList();
    this.EjW = null;
    this.callbacks = new ArrayList();
    this.w = 300;
    this.h = 300;
    start();
    AppMethodBeat.o(55717);
  }
  
  public static String b(com.tencent.mm.pluginsdk.location.d paramd)
  {
    AppMethodBeat.i(55721);
    paramd = g.getMessageDigest(paramd.toString().getBytes());
    String str = com.tencent.mm.plugin.image.d.bbX() + paramd.charAt(0) + paramd.charAt(1) + "/" + paramd.charAt(3) + paramd.charAt(4) + "/";
    if (!u.agG(str)) {
      new com.tencent.mm.vfs.q(str).ifL();
    }
    paramd = str + "static_map_" + paramd;
    AppMethodBeat.o(55721);
    return paramd;
  }
  
  private void start()
  {
    AppMethodBeat.i(55718);
    com.tencent.mm.kernel.h.aGY().a(648, this);
    AppMethodBeat.o(55718);
  }
  
  private void tI(boolean paramBoolean)
  {
    AppMethodBeat.i(55722);
    Log.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator;
    c localc;
    if (paramBoolean)
    {
      if (this.EjW != null)
      {
        localIterator = this.callbacks.iterator();
        while (localIterator.hasNext())
        {
          localc = (c)localIterator.next();
          if (localc != null) {
            localc.a(b(this.EjW), this.EjW);
          }
        }
      }
    }
    else if (this.EjW != null)
    {
      localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        if (localc != null) {
          localc.a(this.EjW);
        }
      }
    }
    this.EjW = null;
    blo();
    AppMethodBeat.o(55722);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(55715);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      if (paramc.equals((c)localIterator.next()))
      {
        AppMethodBeat.o(55715);
        return;
      }
    }
    this.callbacks.add(paramc);
    Log.i("MicroMsg.StaticMapServer", "addMapCallBack " + this.callbacks.size());
    if (this.callbacks.size() == 1) {
      start();
    }
    AppMethodBeat.o(55715);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(55716);
    this.callbacks.remove(paramc);
    Log.i("MicroMsg.StaticMapServer", "removeCallback " + this.callbacks.size());
    if (this.callbacks.size() == 0)
    {
      Log.i("MicroMsg.StaticMapServer", "clean task");
      this.EjV.clear();
      this.EjW = null;
      stop();
    }
    AppMethodBeat.o(55716);
  }
  
  final void blo()
  {
    AppMethodBeat.i(55720);
    if ((this.EjW == null) && (this.EjV.size() > 0))
    {
      this.EjW = ((com.tencent.mm.pluginsdk.location.d)this.EjV.removeFirst());
      try
      {
        i = Integer.valueOf(Util.nullAs(com.tencent.mm.n.h.axc().getValue("StaticMapGetClient"), "")).intValue();
        Log.i("MicroMsg.StaticMapServer", "run local %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          h localh = new h(this.EjW.lLr, this.EjW.lLs, this.EjW.fKJ + 1, this.w, this.h, b(this.EjW), LocaleUtil.getApplicationLanguage());
          com.tencent.mm.kernel.h.aGY().a(localh, 0);
          AppMethodBeat.o(55720);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = 0;
        }
        int j = this.w;
        for (int i = this.h; j * i > 270000; i = (int)(i / 1.2D)) {
          j = (int)(j / 1.2D);
        }
        if (Util.isOverseasUser(MMApplicationContext.getContext()))
        {
          str = String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.EjW.lLr), Float.valueOf(this.EjW.lLs), Integer.valueOf(this.EjW.fKJ), LocaleUtil.getApplicationLanguage() });
          this.lLz.add(new a(true, str, b(this.EjW)));
          AppMethodBeat.o(55720);
          return;
        }
        String str = String.format(URL, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.EjW.lLs), Float.valueOf(this.EjW.lLr), Integer.valueOf(this.EjW.fKJ) });
        this.lLz.add(new a(false, str, b(this.EjW)));
      }
    }
    AppMethodBeat.o(55720);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(55723);
    if (paramq.getType() == 648)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (this.EjW != null))
      {
        tI(true);
        AppMethodBeat.o(55723);
        return;
      }
      tI(false);
    }
    AppMethodBeat.o(55723);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55719);
    Log.i("MicroMsg.StaticMapServer", "stop static map server");
    com.tencent.mm.kernel.h.aGY().b(648, this);
    AppMethodBeat.o(55719);
  }
  
  public final class a
    implements QueueWorkerThread.ThreadObject
  {
    boolean EjX;
    private int EjY;
    private int EjZ;
    private byte[] data;
    private String mFilePath;
    String url;
    
    public a(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(55712);
      this.url = "";
      this.EjX = true;
      this.EjX = paramBoolean;
      this.EjY = m.a(m.this);
      this.EjZ = m.b(m.this);
      this.url = paramString1;
      while (this.EjY * this.EjZ > 270000)
      {
        this.EjY = ((int)(this.EjY / 1.2D));
        this.EjZ = ((int)(this.EjZ / 1.2D));
      }
      this.mFilePath = paramString2;
      Log.i("MicroMsg.StaticMapServer", "get url %s %s", new Object[] { paramString1, Util.nullAs(this.mFilePath, "") });
      AppMethodBeat.o(55712);
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(55713);
      this.data = Util.httpGet(this.url);
      if (this.data != null) {
        u.f(this.mFilePath, this.data, this.data.length);
      }
      AppMethodBeat.o(55713);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(55714);
      StringBuilder localStringBuilder = new StringBuilder("http onPostExecute ");
      if (this.data == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.StaticMapServer", bool + " isGoole: " + this.EjX);
        if (this.data != null) {
          break label234;
        }
        if (!this.EjX) {
          break label219;
        }
        if (m.c(m.this) != null) {
          break;
        }
        m.a(m.this, false);
        AppMethodBeat.o(55714);
        return false;
      }
      this.url = String.format(m.URL, new Object[] { Integer.valueOf(this.EjY), Integer.valueOf(this.EjZ), Float.valueOf(m.c(m.this).lLs), Float.valueOf(m.c(m.this).lLr), Integer.valueOf(m.c(m.this).fKJ) });
      m.d(m.this).add(new a(m.this, false, this.url, m.b(m.c(m.this))));
      AppMethodBeat.o(55714);
      return false;
      label219:
      m.a(m.this, false);
      AppMethodBeat.o(55714);
      return false;
      label234:
      m.a(m.this, true);
      AppMethodBeat.o(55714);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.m
 * JD-Core Version:    0.7.0.1
 */