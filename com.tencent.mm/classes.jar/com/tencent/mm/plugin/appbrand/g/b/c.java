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
  protected b oeG;
  protected h oeH;
  protected f oeI;
  protected f oeJ;
  protected f oeK;
  protected e oeL;
  protected com.tencent.mm.plugin.appbrand.g.c.b.c oeM;
  protected com.tencent.mm.plugin.appbrand.g.c.b.c oeN;
  protected d oeO;
  protected boolean oeP;
  protected boolean oeQ;
  
  public c(b paramb)
  {
    AppMethodBeat.i(158923);
    this.oeH = h.bMX();
    this.oeL = new e();
    this.mIsMute = false;
    this.oeP = false;
    this.oeQ = false;
    this.oeG = paramb;
    init();
    AppMethodBeat.o(158923);
  }
  
  public static c a(b paramb)
  {
    AppMethodBeat.i(158922);
    paramb = new c(paramb);
    if ((paramb.oeI != null) && (paramb.oeJ != null)) {}
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
    if (this.oeG != null)
    {
      paramf = com.tencent.mm.plugin.appbrand.g.c.g.v(this.oeG.host, this.oeG.port, paramf.ofb);
      AppMethodBeat.o(158938);
      return paramf;
    }
    AppMethodBeat.o(158938);
    return "";
  }
  
  private void init()
  {
    AppMethodBeat.i(158924);
    if (this.oeG == null)
    {
      AppMethodBeat.o(158924);
      return;
    }
    if (this.oeG.oeE.size() == 0)
    {
      AppMethodBeat.o(158924);
      return;
    }
    Iterator localIterator = this.oeG.oeE.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (!TextUtils.isEmpty(localf.lqE)) {
        if (localf.lqE.startsWith("urn:schemas-upnp-org:service:AVTransport")) {
          this.oeI = localf;
        } else if (localf.lqE.startsWith("urn:schemas-upnp-org:service:RenderingControl")) {
          this.oeJ = localf;
        } else if (localf.lqE.startsWith("urn:schemas-upnp-org:service:ConnectionManager")) {
          this.oeK = localf;
        }
      }
    }
    AppMethodBeat.o(158924);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158929);
    if (this.oeJ != null)
    {
      k localk = new k(a(this.oeJ), this.oeJ.lqE, paramInt);
      this.oeH.a(localk, parama);
    }
    AppMethodBeat.o(158929);
  }
  
  public final void a(d paramd)
  {
    this.oeO = paramd;
  }
  
  public final void a(e.a parama)
  {
    this.oeL.oeS = parama;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158926);
    if (this.oeI != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.g localg = new com.tencent.mm.plugin.appbrand.g.a.g(a(this.oeI), this.oeI.lqE);
      this.oeH.a(localg, parama);
    }
    AppMethodBeat.o(158926);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158925);
    if (this.oeI != null)
    {
      paramString = new com.tencent.mm.plugin.appbrand.g.a.j(a(this.oeI), this.oeI.lqE, paramString);
      this.oeH.a(paramString, parama);
    }
    AppMethodBeat.o(158925);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.g.c.b.d paramd)
  {
    HashMap localHashMap = null;
    AppMethodBeat.i(158939);
    if (this.oeO == null)
    {
      AppMethodBeat.o(158939);
      return true;
    }
    if ((paramd.ogc != null) && (!paramd.ogc.containsKey("LastChange")))
    {
      AppMethodBeat.o(158939);
      return false;
    }
    if (paramd.ogc != null) {}
    for (String str = ((com.tencent.mm.plugin.appbrand.g.c.b.a)Objects.requireNonNull(paramd.ogc.get("LastChange"))).value;; str = null)
    {
      if (str != null) {
        localHashMap = com.tencent.mm.plugin.appbrand.g.c.j.bNa().afT(str);
      }
      if (localHashMap == null)
      {
        AppMethodBeat.o(158939);
        return false;
      }
      int i;
      if ("avtEvent".equals(paramd.oga))
      {
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("TransportState");
        if (paramd != null)
        {
          paramd = paramd.afV("val");
          if ("PLAYING".equalsIgnoreCase(paramd)) {
            this.oeO.d(this);
          }
        }
        else
        {
          paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("CurrentTrackDuration");
          if (paramd != null)
          {
            paramd = paramd.afV("val").split(":");
            if (paramd.length == 3)
            {
              i = Integer.parseInt(paramd[0]);
              int j = Integer.parseInt(paramd[1]);
              int k = Integer.parseInt(paramd[2]);
              this.oeO.b(this, k + (i * 3600 + j * 60));
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
            this.oeO.e(this);
            break;
          }
          if (!"STOPPED".equalsIgnoreCase(paramd)) {
            break;
          }
          this.oeO.f(this);
          break;
        } while (!"rdcEvent".equals(paramd.oga));
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("Volume");
        if (paramd != null)
        {
          i = Integer.parseInt(paramd.afV("val"));
          this.oeO.a(this, i);
        }
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("Mute");
      } while (paramd == null);
      if (!"0".equals(paramd.afV("val"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.oeO.a(this, bool);
        break;
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158927);
    if (this.oeI != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.f localf = new com.tencent.mm.plugin.appbrand.g.a.f(a(this.oeI), this.oeI.lqE);
      this.oeH.a(localf, parama);
    }
    AppMethodBeat.o(158927);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158931);
    if (this.oeI != null)
    {
      paramString = new i(a(this.oeI), this.oeI.lqE, paramString);
      this.oeH.a(paramString, parama);
    }
    AppMethodBeat.o(158931);
  }
  
  public final b bMJ()
  {
    return this.oeG;
  }
  
  public final e.a bMK()
  {
    return this.oeL.oeS;
  }
  
  public final void bML()
  {
    AppMethodBeat.i(158934);
    if (this.oeP)
    {
      AppMethodBeat.o(158934);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bMT();
    com.tencent.mm.plugin.appbrand.g.c.a.c local1 = new com.tencent.mm.plugin.appbrand.g.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158914);
        c.this.oeP = true;
        c.this.oeM = paramAnonymousc;
        if (c.this.oeG != null) {
          new StringBuilder().append(c.this.oeG.oeA).append(" subscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158914);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158915);
        if ((paramAnonymouse != null) && (c.this.oeG != null)) {
          new StringBuilder().append(c.this.oeG.oeA).append(" subscribeAVTransportEvent fail response code : ").append(paramAnonymouse.bpg);
        }
        AppMethodBeat.o(158915);
      }
    };
    Object localObject = this.oeI;
    if (localObject != null)
    {
      String str = localc.afQ("/upnp/cb/AVTransport");
      localObject = new m(com.tencent.mm.plugin.appbrand.g.c.g.v(this.oeG.host, this.oeG.port, ((f)localObject).ofc), str);
      h.bMX().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.1(localc, this, local1));
      AppMethodBeat.o(158934);
      return;
    }
    local1.a(null);
    AppMethodBeat.o(158934);
  }
  
  public final void bMM()
  {
    AppMethodBeat.i(158935);
    if (this.oeQ)
    {
      AppMethodBeat.o(158935);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bMT();
    com.tencent.mm.plugin.appbrand.g.c.a.c local2 = new com.tencent.mm.plugin.appbrand.g.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158916);
        c.this.oeQ = true;
        c.this.oeN = paramAnonymousc;
        if (c.this.oeG != null) {
          new StringBuilder().append(c.this.oeG.oeA).append(" subscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158916);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158917);
        if ((paramAnonymouse != null) && (c.this.oeG != null)) {
          new StringBuilder().append(c.this.oeG.oeA).append(" subscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.bpg);
        }
        AppMethodBeat.o(158917);
      }
    };
    Object localObject = this.oeJ;
    if (localObject != null)
    {
      String str = localc.afQ("/upnp/cb/RenderControl");
      localObject = new m(com.tencent.mm.plugin.appbrand.g.c.g.v(this.oeG.host, this.oeG.port, ((f)localObject).ofc), str);
      h.bMX().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.2(localc, this, local2));
      AppMethodBeat.o(158935);
      return;
    }
    local2.a(null);
    AppMethodBeat.o(158935);
  }
  
  public final void bMN()
  {
    AppMethodBeat.i(158936);
    if (!this.oeP)
    {
      AppMethodBeat.o(158936);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bMT();
    com.tencent.mm.plugin.appbrand.g.c.a.a local3 = new com.tencent.mm.plugin.appbrand.g.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158919);
        if ((paramAnonymouse != null) && (c.this.oeG != null)) {
          new StringBuilder().append(c.this.oeG.oeA).append(" unSubscribeAVTransportEvent fail response code : ").append(paramAnonymouse.bpg);
        }
        AppMethodBeat.o(158919);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158918);
        c.this.oeP = false;
        c.this.oeM = null;
        if (c.this.oeG != null) {
          new StringBuilder().append(c.this.oeG.oeA).append(" unSubscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158918);
      }
    };
    Object localObject = this.oeI;
    com.tencent.mm.plugin.appbrand.g.c.b.c localc1 = this.oeM;
    if ((localObject != null) && (localc1 != null) && (localc1.ofY != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.g.c.g.v(this.oeG.host, this.oeG.port, ((f)localObject).ofc), localc1.ofY);
      h.bMX().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.3(localc, localc1, local3));
      AppMethodBeat.o(158936);
      return;
    }
    local3.a(null);
    AppMethodBeat.o(158936);
  }
  
  public final void bMO()
  {
    AppMethodBeat.i(158937);
    if (!this.oeQ)
    {
      AppMethodBeat.o(158937);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bMT();
    com.tencent.mm.plugin.appbrand.g.c.a.a local4 = new com.tencent.mm.plugin.appbrand.g.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158921);
        if ((paramAnonymouse != null) && (c.this.oeG != null)) {
          new StringBuilder().append(c.this.oeG.oeA).append(" unSubscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.bpg);
        }
        AppMethodBeat.o(158921);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158920);
        c.this.oeQ = false;
        c.this.oeN = null;
        if (c.this.oeG != null) {
          new StringBuilder().append(c.this.oeG.oeA).append(" unSubscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158920);
      }
    };
    Object localObject = this.oeJ;
    com.tencent.mm.plugin.appbrand.g.c.b.c localc1 = this.oeN;
    if ((localObject != null) && (localc1 != null) && (localc1.ofY != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.g.c.g.v(this.oeG.host, this.oeG.port, ((f)localObject).ofc), localc1.ofY);
      h.bMX().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.4(localc, localc1, local4));
      AppMethodBeat.o(158937);
      return;
    }
    local4.a(null);
    AppMethodBeat.o(158937);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158928);
    if (this.oeI != null)
    {
      l locall = new l(a(this.oeI), this.oeI.lqE);
      this.oeH.a(locall, parama);
    }
    AppMethodBeat.o(158928);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158930);
    if (this.oeJ != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.c localc = new com.tencent.mm.plugin.appbrand.g.a.c(a(this.oeJ), this.oeJ.lqE);
      this.oeH.a(localc, parama);
    }
    AppMethodBeat.o(158930);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158932);
    if (this.oeI != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.b localb = new com.tencent.mm.plugin.appbrand.g.a.b(a(this.oeI), this.oeI.lqE);
      this.oeH.a(localb, parama);
    }
    AppMethodBeat.o(158932);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158940);
    if ((this.oeG == null) && (paramObject == null))
    {
      AppMethodBeat.o(158940);
      return true;
    }
    if (this.oeG == null)
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
      boolean bool = this.oeG.equals(paramObject.oeG);
      AppMethodBeat.o(158940);
      return bool;
    }
    AppMethodBeat.o(158940);
    return false;
  }
  
  public final void f(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158933);
    if (this.oeI != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.a locala = new com.tencent.mm.plugin.appbrand.g.a.a(a(this.oeI), this.oeI.lqE);
      this.oeH.a(locala, parama);
    }
    AppMethodBeat.o(158933);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158941);
    String str = "MRDevice{mDevice=" + this.oeG + '}';
    AppMethodBeat.o(158941);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.c
 * JD-Core Version:    0.7.0.1
 */