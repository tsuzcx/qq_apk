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
  protected boolean mIsMute;
  protected b ril;
  protected h rim;
  protected f rin;
  protected f rio;
  protected f rip;
  protected e riq;
  protected com.tencent.mm.plugin.appbrand.g.c.b.c rir;
  protected com.tencent.mm.plugin.appbrand.g.c.b.c ris;
  protected d rit;
  protected boolean riu;
  protected boolean riv;
  
  public c(b paramb)
  {
    AppMethodBeat.i(158923);
    this.rim = h.cnm();
    this.riq = new e();
    this.mIsMute = false;
    this.riu = false;
    this.riv = false;
    this.ril = paramb;
    init();
    AppMethodBeat.o(158923);
  }
  
  public static c a(b paramb)
  {
    AppMethodBeat.i(158922);
    paramb = new c(paramb);
    if ((paramb.rin != null) && (paramb.rio != null)) {}
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
    if (this.ril != null)
    {
      paramf = com.tencent.mm.plugin.appbrand.g.c.g.y(this.ril.host, this.ril.port, paramf.riG);
      AppMethodBeat.o(158938);
      return paramf;
    }
    AppMethodBeat.o(158938);
    return "";
  }
  
  private void init()
  {
    AppMethodBeat.i(158924);
    if (this.ril == null)
    {
      AppMethodBeat.o(158924);
      return;
    }
    if (this.ril.rij.size() == 0)
    {
      AppMethodBeat.o(158924);
      return;
    }
    Iterator localIterator = this.ril.rij.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (!TextUtils.isEmpty(localf.nVK)) {
        if (localf.nVK.startsWith("urn:schemas-upnp-org:service:AVTransport")) {
          this.rin = localf;
        } else if (localf.nVK.startsWith("urn:schemas-upnp-org:service:RenderingControl")) {
          this.rio = localf;
        } else if (localf.nVK.startsWith("urn:schemas-upnp-org:service:ConnectionManager")) {
          this.rip = localf;
        }
      }
    }
    AppMethodBeat.o(158924);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158929);
    if (this.rio != null)
    {
      k localk = new k(a(this.rio), this.rio.nVK, paramInt);
      this.rim.a(localk, parama);
    }
    AppMethodBeat.o(158929);
  }
  
  public final void a(d paramd)
  {
    this.rit = paramd;
  }
  
  public final void a(e.a parama)
  {
    this.riq.rix = parama;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158926);
    if (this.rin != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.g localg = new com.tencent.mm.plugin.appbrand.g.a.g(a(this.rin), this.rin.nVK);
      this.rim.a(localg, parama);
    }
    AppMethodBeat.o(158926);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158925);
    if (this.rin != null)
    {
      paramString = new com.tencent.mm.plugin.appbrand.g.a.j(a(this.rin), this.rin.nVK, paramString);
      this.rim.a(paramString, parama);
    }
    AppMethodBeat.o(158925);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.g.c.b.d paramd)
  {
    HashMap localHashMap = null;
    AppMethodBeat.i(158939);
    if (this.rit == null)
    {
      AppMethodBeat.o(158939);
      return true;
    }
    if ((paramd.rjG != null) && (!paramd.rjG.containsKey("LastChange")))
    {
      AppMethodBeat.o(158939);
      return false;
    }
    if (paramd.rjG != null) {}
    for (String str = ((com.tencent.mm.plugin.appbrand.g.c.b.a)Objects.requireNonNull((com.tencent.mm.plugin.appbrand.g.c.b.a)paramd.rjG.get("LastChange"))).value;; str = null)
    {
      if (str != null) {
        localHashMap = com.tencent.mm.plugin.appbrand.g.c.j.cnp().YP(str);
      }
      if (localHashMap == null)
      {
        AppMethodBeat.o(158939);
        return false;
      }
      int i;
      if ("avtEvent".equals(paramd.rjE))
      {
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("TransportState");
        if (paramd != null)
        {
          paramd = paramd.YR("val");
          if ("PLAYING".equalsIgnoreCase(paramd)) {
            this.rit.d(this);
          }
        }
        else
        {
          paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("CurrentTrackDuration");
          if (paramd != null)
          {
            paramd = paramd.YR("val").split(":");
            if (paramd.length == 3)
            {
              i = Integer.parseInt(paramd[0]);
              int j = Integer.parseInt(paramd[1]);
              int k = Integer.parseInt(paramd[2]);
              this.rit.b(this, k + (i * 3600 + j * 60));
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
            this.rit.e(this);
            break;
          }
          if (!"STOPPED".equalsIgnoreCase(paramd)) {
            break;
          }
          this.rit.f(this);
          break;
        } while (!"rdcEvent".equals(paramd.rjE));
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("Volume");
        if (paramd != null)
        {
          i = Integer.parseInt(paramd.YR("val"));
          this.rit.a(this, i);
        }
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("Mute");
      } while (paramd == null);
      if (!"0".equals(paramd.YR("val"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.rit.a(this, bool);
        break;
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158927);
    if (this.rin != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.f localf = new com.tencent.mm.plugin.appbrand.g.a.f(a(this.rin), this.rin.nVK);
      this.rim.a(localf, parama);
    }
    AppMethodBeat.o(158927);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158931);
    if (this.rin != null)
    {
      paramString = new i(a(this.rin), this.rin.nVK, paramString);
      this.rim.a(paramString, parama);
    }
    AppMethodBeat.o(158931);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158928);
    if (this.rin != null)
    {
      l locall = new l(a(this.rin), this.rin.nVK);
      this.rim.a(locall, parama);
    }
    AppMethodBeat.o(158928);
  }
  
  public final b cmY()
  {
    return this.ril;
  }
  
  public final e.a cmZ()
  {
    return this.riq.rix;
  }
  
  public final void cna()
  {
    AppMethodBeat.i(158934);
    if (this.riu)
    {
      AppMethodBeat.o(158934);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.cnh();
    com.tencent.mm.plugin.appbrand.g.c.a.c local1 = new com.tencent.mm.plugin.appbrand.g.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158914);
        c.this.riu = true;
        c.this.rir = paramAnonymousc;
        if (c.this.ril != null) {
          new StringBuilder().append(c.this.ril.rif).append(" subscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158914);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158915);
        if ((paramAnonymouse != null) && (c.this.ril != null)) {
          new StringBuilder().append(c.this.ril.rif).append(" subscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158915);
      }
    };
    Object localObject = this.rin;
    if (localObject != null)
    {
      String str = localc.YM("/upnp/cb/AVTransport");
      localObject = new m(com.tencent.mm.plugin.appbrand.g.c.g.y(this.ril.host, this.ril.port, ((f)localObject).riH), str);
      h.cnm().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.1(localc, this, local1));
      AppMethodBeat.o(158934);
      return;
    }
    local1.a(null);
    AppMethodBeat.o(158934);
  }
  
  public final void cnb()
  {
    AppMethodBeat.i(158935);
    if (this.riv)
    {
      AppMethodBeat.o(158935);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.cnh();
    com.tencent.mm.plugin.appbrand.g.c.a.c local2 = new com.tencent.mm.plugin.appbrand.g.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158916);
        c.this.riv = true;
        c.this.ris = paramAnonymousc;
        if (c.this.ril != null) {
          new StringBuilder().append(c.this.ril.rif).append(" subscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158916);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158917);
        if ((paramAnonymouse != null) && (c.this.ril != null)) {
          new StringBuilder().append(c.this.ril.rif).append(" subscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158917);
      }
    };
    Object localObject = this.rio;
    if (localObject != null)
    {
      String str = localc.YM("/upnp/cb/RenderControl");
      localObject = new m(com.tencent.mm.plugin.appbrand.g.c.g.y(this.ril.host, this.ril.port, ((f)localObject).riH), str);
      h.cnm().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.2(localc, this, local2));
      AppMethodBeat.o(158935);
      return;
    }
    local2.a(null);
    AppMethodBeat.o(158935);
  }
  
  public final void cnc()
  {
    AppMethodBeat.i(158936);
    if (!this.riu)
    {
      AppMethodBeat.o(158936);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.cnh();
    com.tencent.mm.plugin.appbrand.g.c.a.a local3 = new com.tencent.mm.plugin.appbrand.g.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158919);
        if ((paramAnonymouse != null) && (c.this.ril != null)) {
          new StringBuilder().append(c.this.ril.rif).append(" unSubscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158919);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158918);
        c.this.riu = false;
        c.this.rir = null;
        if (c.this.ril != null) {
          new StringBuilder().append(c.this.ril.rif).append(" unSubscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158918);
      }
    };
    Object localObject = this.rin;
    com.tencent.mm.plugin.appbrand.g.c.b.c localc1 = this.rir;
    if ((localObject != null) && (localc1 != null) && (localc1.rjC != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.g.c.g.y(this.ril.host, this.ril.port, ((f)localObject).riH), localc1.rjC);
      h.cnm().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.3(localc, localc1, local3));
      AppMethodBeat.o(158936);
      return;
    }
    local3.a(null);
    AppMethodBeat.o(158936);
  }
  
  public final void cnd()
  {
    AppMethodBeat.i(158937);
    if (!this.riv)
    {
      AppMethodBeat.o(158937);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.cnh();
    com.tencent.mm.plugin.appbrand.g.c.a.a local4 = new com.tencent.mm.plugin.appbrand.g.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158921);
        if ((paramAnonymouse != null) && (c.this.ril != null)) {
          new StringBuilder().append(c.this.ril.rif).append(" unSubscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158921);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158920);
        c.this.riv = false;
        c.this.ris = null;
        if (c.this.ril != null) {
          new StringBuilder().append(c.this.ril.rif).append(" unSubscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158920);
      }
    };
    Object localObject = this.rio;
    com.tencent.mm.plugin.appbrand.g.c.b.c localc1 = this.ris;
    if ((localObject != null) && (localc1 != null) && (localc1.rjC != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.g.c.g.y(this.ril.host, this.ril.port, ((f)localObject).riH), localc1.rjC);
      h.cnm().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.4(localc, localc1, local4));
      AppMethodBeat.o(158937);
      return;
    }
    local4.a(null);
    AppMethodBeat.o(158937);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158930);
    if (this.rio != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.c localc = new com.tencent.mm.plugin.appbrand.g.a.c(a(this.rio), this.rio.nVK);
      this.rim.a(localc, parama);
    }
    AppMethodBeat.o(158930);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158932);
    if (this.rin != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.b localb = new com.tencent.mm.plugin.appbrand.g.a.b(a(this.rin), this.rin.nVK);
      this.rim.a(localb, parama);
    }
    AppMethodBeat.o(158932);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158940);
    if ((this.ril == null) && (paramObject == null))
    {
      AppMethodBeat.o(158940);
      return true;
    }
    if (this.ril == null)
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
      boolean bool = this.ril.equals(paramObject.ril);
      AppMethodBeat.o(158940);
      return bool;
    }
    AppMethodBeat.o(158940);
    return false;
  }
  
  public final void f(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158933);
    if (this.rin != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.a locala = new com.tencent.mm.plugin.appbrand.g.a.a(a(this.rin), this.rin.nVK);
      this.rim.a(locala, parama);
    }
    AppMethodBeat.o(158933);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158941);
    String str = "MRDevice{mDevice=" + this.ril + '}';
    AppMethodBeat.o(158941);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.c
 * JD-Core Version:    0.7.0.1
 */