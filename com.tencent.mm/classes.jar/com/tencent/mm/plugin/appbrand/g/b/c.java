package com.tencent.mm.plugin.appbrand.g.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a.i;
import com.tencent.mm.plugin.appbrand.g.a.k;
import com.tencent.mm.plugin.appbrand.g.a.l;
import com.tencent.mm.plugin.appbrand.g.a.m;
import com.tencent.mm.plugin.appbrand.g.a.n;
import com.tencent.mm.plugin.appbrand.g.c.c.b;
import com.tencent.mm.plugin.appbrand.g.c.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public final class c
  implements com.tencent.mm.plugin.appbrand.g.c.a.b
{
  protected b kgm;
  protected h kgn;
  protected f kgo;
  protected f kgp;
  protected f kgq;
  protected e kgr;
  protected com.tencent.mm.plugin.appbrand.g.c.b.c kgs;
  protected com.tencent.mm.plugin.appbrand.g.c.b.c kgt;
  protected d kgu;
  protected boolean kgv;
  protected boolean kgw;
  protected boolean mIsMute;
  
  public c(b paramb)
  {
    AppMethodBeat.i(158923);
    this.kgn = h.bgi();
    this.kgr = new e();
    this.mIsMute = false;
    this.kgv = false;
    this.kgw = false;
    this.kgm = paramb;
    init();
    AppMethodBeat.o(158923);
  }
  
  public static c a(b paramb)
  {
    AppMethodBeat.i(158922);
    paramb = new c(paramb);
    if ((paramb.kgo != null) && (paramb.kgp != null)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(158922);
      return paramb;
    }
    AppMethodBeat.o(158922);
    return null;
  }
  
  private String a(f paramf)
  {
    AppMethodBeat.i(158938);
    if (this.kgm != null)
    {
      paramf = com.tencent.mm.plugin.appbrand.g.c.g.q(this.kgm.host, this.kgm.port, paramf.kgH);
      AppMethodBeat.o(158938);
      return paramf;
    }
    AppMethodBeat.o(158938);
    return "";
  }
  
  private void init()
  {
    AppMethodBeat.i(158924);
    if (this.kgm == null)
    {
      AppMethodBeat.o(158924);
      return;
    }
    if (this.kgm.kgk.size() == 0)
    {
      AppMethodBeat.o(158924);
      return;
    }
    Iterator localIterator = this.kgm.kgk.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (!TextUtils.isEmpty(localf.hGR)) {
        if (localf.hGR.startsWith("urn:schemas-upnp-org:service:AVTransport")) {
          this.kgo = localf;
        } else if (localf.hGR.startsWith("urn:schemas-upnp-org:service:RenderingControl")) {
          this.kgp = localf;
        } else if (localf.hGR.startsWith("urn:schemas-upnp-org:service:ConnectionManager")) {
          this.kgq = localf;
        }
      }
    }
    AppMethodBeat.o(158924);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158929);
    if (this.kgp != null)
    {
      k localk = new k(a(this.kgp), this.kgp.hGR, paramInt);
      this.kgn.a(localk, parama);
    }
    AppMethodBeat.o(158929);
  }
  
  public final void a(d paramd)
  {
    this.kgu = paramd;
  }
  
  public final void a(e.a parama)
  {
    this.kgr.kgy = parama;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158926);
    if (this.kgo != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.g localg = new com.tencent.mm.plugin.appbrand.g.a.g(a(this.kgo), this.kgo.hGR);
      this.kgn.a(localg, parama);
    }
    AppMethodBeat.o(158926);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158925);
    if (this.kgo != null)
    {
      paramString = new com.tencent.mm.plugin.appbrand.g.a.j(a(this.kgo), this.kgo.hGR, paramString);
      this.kgn.a(paramString, parama);
    }
    AppMethodBeat.o(158925);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.g.c.b.d paramd)
  {
    HashMap localHashMap = null;
    AppMethodBeat.i(158939);
    if (this.kgu == null)
    {
      AppMethodBeat.o(158939);
      return true;
    }
    if ((paramd.khH != null) && (!paramd.khH.containsKey("LastChange")))
    {
      AppMethodBeat.o(158939);
      return false;
    }
    if (paramd.khH != null) {}
    for (String str = ((com.tencent.mm.plugin.appbrand.g.c.b.a)Objects.requireNonNull(paramd.khH.get("LastChange"))).value;; str = null)
    {
      if (str != null) {
        localHashMap = com.tencent.mm.plugin.appbrand.g.c.j.bgl().OU(str);
      }
      if (localHashMap == null)
      {
        AppMethodBeat.o(158939);
        return false;
      }
      int i;
      if ("avtEvent".equals(paramd.khF))
      {
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("TransportState");
        if (paramd != null)
        {
          paramd = paramd.OW("val");
          if ("PLAYING".equalsIgnoreCase(paramd)) {
            this.kgu.d(this);
          }
        }
        else
        {
          paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("CurrentTrackDuration");
          if (paramd != null)
          {
            paramd = paramd.OW("val").split(":");
            if (paramd.length == 3)
            {
              i = Integer.parseInt(paramd[0]);
              int j = Integer.parseInt(paramd[1]);
              int k = Integer.parseInt(paramd[2]);
              this.kgu.b(this, k + (i * 3600 + j * 60));
            }
          }
        }
      }
      do
      {
        do
        {
          AppMethodBeat.o(158939);
          return true;
          if ("PAUSED_PLAYBACK".equalsIgnoreCase(paramd))
          {
            this.kgu.e(this);
            break;
          }
          if (!"STOPPED".equalsIgnoreCase(paramd)) {
            break;
          }
          this.kgu.f(this);
          break;
        } while (!"rdcEvent".equals(paramd.khF));
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("Volume");
        if (paramd != null)
        {
          i = Integer.parseInt(paramd.OW("val"));
          this.kgu.a(this, i);
        }
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("Mute");
      } while (paramd == null);
      if (!"0".equals(paramd.OW("val"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.kgu.a(this, bool);
        break;
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158927);
    if (this.kgo != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.f localf = new com.tencent.mm.plugin.appbrand.g.a.f(a(this.kgo), this.kgo.hGR);
      this.kgn.a(localf, parama);
    }
    AppMethodBeat.o(158927);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158931);
    if (this.kgo != null)
    {
      paramString = new i(a(this.kgo), this.kgo.hGR, paramString);
      this.kgn.a(paramString, parama);
    }
    AppMethodBeat.o(158931);
  }
  
  public final b bfV()
  {
    return this.kgm;
  }
  
  public final e.a bfW()
  {
    return this.kgr.kgy;
  }
  
  public final void bfX()
  {
    AppMethodBeat.i(158934);
    if (this.kgv)
    {
      AppMethodBeat.o(158934);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bge();
    com.tencent.mm.plugin.appbrand.g.c.a.c local1 = new com.tencent.mm.plugin.appbrand.g.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158914);
        c.this.kgv = true;
        c.this.kgs = paramAnonymousc;
        if (c.this.kgm != null) {
          new StringBuilder().append(c.this.kgm.kgg).append(" subscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158914);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158915);
        if ((paramAnonymouse != null) && (c.this.kgm != null)) {
          new StringBuilder().append(c.this.kgm.kgg).append(" subscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158915);
      }
    };
    Object localObject = this.kgo;
    if (localObject != null)
    {
      String str = localc.OR("/upnp/cb/AVTransport");
      localObject = new m(com.tencent.mm.plugin.appbrand.g.c.g.q(this.kgm.host, this.kgm.port, ((f)localObject).kgI), str);
      h.bgi().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.1(localc, this, local1));
      AppMethodBeat.o(158934);
      return;
    }
    local1.a(null);
    AppMethodBeat.o(158934);
  }
  
  public final void bfY()
  {
    AppMethodBeat.i(158935);
    if (this.kgw)
    {
      AppMethodBeat.o(158935);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bge();
    com.tencent.mm.plugin.appbrand.g.c.a.c local2 = new com.tencent.mm.plugin.appbrand.g.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158916);
        c.this.kgw = true;
        c.this.kgt = paramAnonymousc;
        if (c.this.kgm != null) {
          new StringBuilder().append(c.this.kgm.kgg).append(" subscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158916);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158917);
        if ((paramAnonymouse != null) && (c.this.kgm != null)) {
          new StringBuilder().append(c.this.kgm.kgg).append(" subscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158917);
      }
    };
    Object localObject = this.kgp;
    if (localObject != null)
    {
      String str = localc.OR("/upnp/cb/RenderControl");
      localObject = new m(com.tencent.mm.plugin.appbrand.g.c.g.q(this.kgm.host, this.kgm.port, ((f)localObject).kgI), str);
      h.bgi().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.2(localc, this, local2));
      AppMethodBeat.o(158935);
      return;
    }
    local2.a(null);
    AppMethodBeat.o(158935);
  }
  
  public final void bfZ()
  {
    AppMethodBeat.i(158936);
    if (!this.kgv)
    {
      AppMethodBeat.o(158936);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bge();
    com.tencent.mm.plugin.appbrand.g.c.a.a local3 = new com.tencent.mm.plugin.appbrand.g.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158919);
        if ((paramAnonymouse != null) && (c.this.kgm != null)) {
          new StringBuilder().append(c.this.kgm.kgg).append(" unSubscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158919);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158918);
        c.this.kgv = false;
        c.this.kgs = null;
        if (c.this.kgm != null) {
          new StringBuilder().append(c.this.kgm.kgg).append(" unSubscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158918);
      }
    };
    Object localObject = this.kgo;
    com.tencent.mm.plugin.appbrand.g.c.b.c localc1 = this.kgs;
    if ((localObject != null) && (localc1 != null) && (localc1.khD != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.g.c.g.q(this.kgm.host, this.kgm.port, ((f)localObject).kgI), localc1.khD);
      h.bgi().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.3(localc, localc1, local3));
      AppMethodBeat.o(158936);
      return;
    }
    local3.a(null);
    AppMethodBeat.o(158936);
  }
  
  public final void bga()
  {
    AppMethodBeat.i(158937);
    if (!this.kgw)
    {
      AppMethodBeat.o(158937);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bge();
    com.tencent.mm.plugin.appbrand.g.c.a.a local4 = new com.tencent.mm.plugin.appbrand.g.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158921);
        if ((paramAnonymouse != null) && (c.this.kgm != null)) {
          new StringBuilder().append(c.this.kgm.kgg).append(" unSubscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158921);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158920);
        c.this.kgw = false;
        c.this.kgt = null;
        if (c.this.kgm != null) {
          new StringBuilder().append(c.this.kgm.kgg).append(" unSubscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158920);
      }
    };
    Object localObject = this.kgp;
    com.tencent.mm.plugin.appbrand.g.c.b.c localc1 = this.kgt;
    if ((localObject != null) && (localc1 != null) && (localc1.khD != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.g.c.g.q(this.kgm.host, this.kgm.port, ((f)localObject).kgI), localc1.khD);
      h.bgi().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.4(localc, localc1, local4));
      AppMethodBeat.o(158937);
      return;
    }
    local4.a(null);
    AppMethodBeat.o(158937);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158928);
    if (this.kgo != null)
    {
      l locall = new l(a(this.kgo), this.kgo.hGR);
      this.kgn.a(locall, parama);
    }
    AppMethodBeat.o(158928);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158930);
    if (this.kgp != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.c localc = new com.tencent.mm.plugin.appbrand.g.a.c(a(this.kgp), this.kgp.hGR);
      this.kgn.a(localc, parama);
    }
    AppMethodBeat.o(158930);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158932);
    if (this.kgo != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.b localb = new com.tencent.mm.plugin.appbrand.g.a.b(a(this.kgo), this.kgo.hGR);
      this.kgn.a(localb, parama);
    }
    AppMethodBeat.o(158932);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158940);
    if ((this.kgm == null) && (paramObject == null))
    {
      AppMethodBeat.o(158940);
      return true;
    }
    if (this.kgm == null)
    {
      AppMethodBeat.o(158940);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(158940);
      return true;
    }
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      boolean bool = this.kgm.equals(paramObject.kgm);
      AppMethodBeat.o(158940);
      return bool;
    }
    AppMethodBeat.o(158940);
    return false;
  }
  
  public final void f(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158933);
    if (this.kgo != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.a locala = new com.tencent.mm.plugin.appbrand.g.a.a(a(this.kgo), this.kgo.hGR);
      this.kgn.a(locala, parama);
    }
    AppMethodBeat.o(158933);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158941);
    String str = "MRDevice{mDevice=" + this.kgm + '}';
    AppMethodBeat.o(158941);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.c
 * JD-Core Version:    0.7.0.1
 */