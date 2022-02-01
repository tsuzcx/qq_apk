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
  protected b kcV;
  protected h kcW;
  protected f kcX;
  protected f kcY;
  protected f kcZ;
  protected e kda;
  protected com.tencent.mm.plugin.appbrand.g.c.b.c kdb;
  protected com.tencent.mm.plugin.appbrand.g.c.b.c kdc;
  protected d kdd;
  protected boolean kde;
  protected boolean kdf;
  protected boolean mIsMute;
  
  public c(b paramb)
  {
    AppMethodBeat.i(158923);
    this.kcW = h.bfA();
    this.kda = new e();
    this.mIsMute = false;
    this.kde = false;
    this.kdf = false;
    this.kcV = paramb;
    init();
    AppMethodBeat.o(158923);
  }
  
  public static c a(b paramb)
  {
    AppMethodBeat.i(158922);
    paramb = new c(paramb);
    if ((paramb.kcX != null) && (paramb.kcY != null)) {}
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
    if (this.kcV != null)
    {
      paramf = com.tencent.mm.plugin.appbrand.g.c.g.o(this.kcV.host, this.kcV.port, paramf.kdq);
      AppMethodBeat.o(158938);
      return paramf;
    }
    AppMethodBeat.o(158938);
    return "";
  }
  
  private void init()
  {
    AppMethodBeat.i(158924);
    if (this.kcV == null)
    {
      AppMethodBeat.o(158924);
      return;
    }
    if (this.kcV.kcT.size() == 0)
    {
      AppMethodBeat.o(158924);
      return;
    }
    Iterator localIterator = this.kcV.kcT.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (!TextUtils.isEmpty(localf.hDZ)) {
        if (localf.hDZ.startsWith("urn:schemas-upnp-org:service:AVTransport")) {
          this.kcX = localf;
        } else if (localf.hDZ.startsWith("urn:schemas-upnp-org:service:RenderingControl")) {
          this.kcY = localf;
        } else if (localf.hDZ.startsWith("urn:schemas-upnp-org:service:ConnectionManager")) {
          this.kcZ = localf;
        }
      }
    }
    AppMethodBeat.o(158924);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158929);
    if (this.kcY != null)
    {
      k localk = new k(a(this.kcY), this.kcY.hDZ, paramInt);
      this.kcW.a(localk, parama);
    }
    AppMethodBeat.o(158929);
  }
  
  public final void a(d paramd)
  {
    this.kdd = paramd;
  }
  
  public final void a(e.a parama)
  {
    this.kda.kdh = parama;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158926);
    if (this.kcX != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.g localg = new com.tencent.mm.plugin.appbrand.g.a.g(a(this.kcX), this.kcX.hDZ);
      this.kcW.a(localg, parama);
    }
    AppMethodBeat.o(158926);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158925);
    if (this.kcX != null)
    {
      paramString = new com.tencent.mm.plugin.appbrand.g.a.j(a(this.kcX), this.kcX.hDZ, paramString);
      this.kcW.a(paramString, parama);
    }
    AppMethodBeat.o(158925);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.g.c.b.d paramd)
  {
    HashMap localHashMap = null;
    AppMethodBeat.i(158939);
    if (this.kdd == null)
    {
      AppMethodBeat.o(158939);
      return true;
    }
    if ((paramd.keq != null) && (!paramd.keq.containsKey("LastChange")))
    {
      AppMethodBeat.o(158939);
      return false;
    }
    if (paramd.keq != null) {}
    for (String str = ((com.tencent.mm.plugin.appbrand.g.c.b.a)Objects.requireNonNull(paramd.keq.get("LastChange"))).value;; str = null)
    {
      if (str != null) {
        localHashMap = com.tencent.mm.plugin.appbrand.g.c.j.bfD().Om(str);
      }
      if (localHashMap == null)
      {
        AppMethodBeat.o(158939);
        return false;
      }
      int i;
      if ("avtEvent".equals(paramd.keo))
      {
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("TransportState");
        if (paramd != null)
        {
          paramd = paramd.Oo("val");
          if ("PLAYING".equalsIgnoreCase(paramd)) {
            this.kdd.d(this);
          }
        }
        else
        {
          paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("CurrentTrackDuration");
          if (paramd != null)
          {
            paramd = paramd.Oo("val").split(":");
            if (paramd.length == 3)
            {
              i = Integer.parseInt(paramd[0]);
              int j = Integer.parseInt(paramd[1]);
              int k = Integer.parseInt(paramd[2]);
              this.kdd.b(this, k + (i * 3600 + j * 60));
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
            this.kdd.e(this);
            break;
          }
          if (!"STOPPED".equalsIgnoreCase(paramd)) {
            break;
          }
          this.kdd.f(this);
          break;
        } while (!"rdcEvent".equals(paramd.keo));
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("Volume");
        if (paramd != null)
        {
          i = Integer.parseInt(paramd.Oo("val"));
          this.kdd.a(this, i);
        }
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("Mute");
      } while (paramd == null);
      if (!"0".equals(paramd.Oo("val"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.kdd.a(this, bool);
        break;
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158927);
    if (this.kcX != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.f localf = new com.tencent.mm.plugin.appbrand.g.a.f(a(this.kcX), this.kcX.hDZ);
      this.kcW.a(localf, parama);
    }
    AppMethodBeat.o(158927);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158931);
    if (this.kcX != null)
    {
      paramString = new i(a(this.kcX), this.kcX.hDZ, paramString);
      this.kcW.a(paramString, parama);
    }
    AppMethodBeat.o(158931);
  }
  
  public final b bfn()
  {
    return this.kcV;
  }
  
  public final e.a bfo()
  {
    return this.kda.kdh;
  }
  
  public final void bfp()
  {
    AppMethodBeat.i(158934);
    if (this.kde)
    {
      AppMethodBeat.o(158934);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bfw();
    com.tencent.mm.plugin.appbrand.g.c.a.c local1 = new com.tencent.mm.plugin.appbrand.g.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158914);
        c.this.kde = true;
        c.this.kdb = paramAnonymousc;
        if (c.this.kcV != null) {
          new StringBuilder().append(c.this.kcV.kcP).append(" subscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158914);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158915);
        if ((paramAnonymouse != null) && (c.this.kcV != null)) {
          new StringBuilder().append(c.this.kcV.kcP).append(" subscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158915);
      }
    };
    Object localObject = this.kcX;
    if (localObject != null)
    {
      String str = localc.Ok("/upnp/cb/AVTransport");
      localObject = new m(com.tencent.mm.plugin.appbrand.g.c.g.o(this.kcV.host, this.kcV.port, ((f)localObject).kdr), str);
      h.bfA().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.1(localc, this, local1));
      AppMethodBeat.o(158934);
      return;
    }
    local1.a(null);
    AppMethodBeat.o(158934);
  }
  
  public final void bfq()
  {
    AppMethodBeat.i(158935);
    if (this.kdf)
    {
      AppMethodBeat.o(158935);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bfw();
    com.tencent.mm.plugin.appbrand.g.c.a.c local2 = new com.tencent.mm.plugin.appbrand.g.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158916);
        c.this.kdf = true;
        c.this.kdc = paramAnonymousc;
        if (c.this.kcV != null) {
          new StringBuilder().append(c.this.kcV.kcP).append(" subscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158916);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158917);
        if ((paramAnonymouse != null) && (c.this.kcV != null)) {
          new StringBuilder().append(c.this.kcV.kcP).append(" subscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158917);
      }
    };
    Object localObject = this.kcY;
    if (localObject != null)
    {
      String str = localc.Ok("/upnp/cb/RenderControl");
      localObject = new m(com.tencent.mm.plugin.appbrand.g.c.g.o(this.kcV.host, this.kcV.port, ((f)localObject).kdr), str);
      h.bfA().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.2(localc, this, local2));
      AppMethodBeat.o(158935);
      return;
    }
    local2.a(null);
    AppMethodBeat.o(158935);
  }
  
  public final void bfr()
  {
    AppMethodBeat.i(158936);
    if (!this.kde)
    {
      AppMethodBeat.o(158936);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bfw();
    com.tencent.mm.plugin.appbrand.g.c.a.a local3 = new com.tencent.mm.plugin.appbrand.g.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158919);
        if ((paramAnonymouse != null) && (c.this.kcV != null)) {
          new StringBuilder().append(c.this.kcV.kcP).append(" unSubscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158919);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158918);
        c.this.kde = false;
        c.this.kdb = null;
        if (c.this.kcV != null) {
          new StringBuilder().append(c.this.kcV.kcP).append(" unSubscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158918);
      }
    };
    Object localObject = this.kcX;
    com.tencent.mm.plugin.appbrand.g.c.b.c localc1 = this.kdb;
    if ((localObject != null) && (localc1 != null) && (localc1.kem != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.g.c.g.o(this.kcV.host, this.kcV.port, ((f)localObject).kdr), localc1.kem);
      h.bfA().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.3(localc, localc1, local3));
      AppMethodBeat.o(158936);
      return;
    }
    local3.a(null);
    AppMethodBeat.o(158936);
  }
  
  public final void bfs()
  {
    AppMethodBeat.i(158937);
    if (!this.kdf)
    {
      AppMethodBeat.o(158937);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bfw();
    com.tencent.mm.plugin.appbrand.g.c.a.a local4 = new com.tencent.mm.plugin.appbrand.g.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158921);
        if ((paramAnonymouse != null) && (c.this.kcV != null)) {
          new StringBuilder().append(c.this.kcV.kcP).append(" unSubscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158921);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158920);
        c.this.kdf = false;
        c.this.kdc = null;
        if (c.this.kcV != null) {
          new StringBuilder().append(c.this.kcV.kcP).append(" unSubscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158920);
      }
    };
    Object localObject = this.kcY;
    com.tencent.mm.plugin.appbrand.g.c.b.c localc1 = this.kdc;
    if ((localObject != null) && (localc1 != null) && (localc1.kem != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.g.c.g.o(this.kcV.host, this.kcV.port, ((f)localObject).kdr), localc1.kem);
      h.bfA().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.4(localc, localc1, local4));
      AppMethodBeat.o(158937);
      return;
    }
    local4.a(null);
    AppMethodBeat.o(158937);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158928);
    if (this.kcX != null)
    {
      l locall = new l(a(this.kcX), this.kcX.hDZ);
      this.kcW.a(locall, parama);
    }
    AppMethodBeat.o(158928);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158930);
    if (this.kcY != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.c localc = new com.tencent.mm.plugin.appbrand.g.a.c(a(this.kcY), this.kcY.hDZ);
      this.kcW.a(localc, parama);
    }
    AppMethodBeat.o(158930);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158932);
    if (this.kcX != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.b localb = new com.tencent.mm.plugin.appbrand.g.a.b(a(this.kcX), this.kcX.hDZ);
      this.kcW.a(localb, parama);
    }
    AppMethodBeat.o(158932);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158940);
    if ((this.kcV == null) && (paramObject == null))
    {
      AppMethodBeat.o(158940);
      return true;
    }
    if (this.kcV == null)
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
      boolean bool = this.kcV.equals(paramObject.kcV);
      AppMethodBeat.o(158940);
      return bool;
    }
    AppMethodBeat.o(158940);
    return false;
  }
  
  public final void f(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158933);
    if (this.kcX != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.a locala = new com.tencent.mm.plugin.appbrand.g.a.a(a(this.kcX), this.kcX.hDZ);
      this.kcW.a(locala, parama);
    }
    AppMethodBeat.o(158933);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158941);
    String str = "MRDevice{mDevice=" + this.kcV + '}';
    AppMethodBeat.o(158941);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.c
 * JD-Core Version:    0.7.0.1
 */