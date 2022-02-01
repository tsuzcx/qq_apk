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
  protected b ljV;
  protected h ljW;
  protected f ljX;
  protected f ljY;
  protected f ljZ;
  protected e lka;
  protected com.tencent.mm.plugin.appbrand.g.c.b.c lkb;
  protected com.tencent.mm.plugin.appbrand.g.c.b.c lkc;
  protected d lkd;
  protected boolean lke;
  protected boolean lkf;
  protected boolean mIsMute;
  
  public c(b paramb)
  {
    AppMethodBeat.i(158923);
    this.ljW = h.bBB();
    this.lka = new e();
    this.mIsMute = false;
    this.lke = false;
    this.lkf = false;
    this.ljV = paramb;
    init();
    AppMethodBeat.o(158923);
  }
  
  public static c a(b paramb)
  {
    AppMethodBeat.i(158922);
    paramb = new c(paramb);
    if ((paramb.ljX != null) && (paramb.ljY != null)) {}
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
    if (this.ljV != null)
    {
      paramf = com.tencent.mm.plugin.appbrand.g.c.g.u(this.ljV.host, this.ljV.port, paramf.lkq);
      AppMethodBeat.o(158938);
      return paramf;
    }
    AppMethodBeat.o(158938);
    return "";
  }
  
  private void init()
  {
    AppMethodBeat.i(158924);
    if (this.ljV == null)
    {
      AppMethodBeat.o(158924);
      return;
    }
    if (this.ljV.ljT.size() == 0)
    {
      AppMethodBeat.o(158924);
      return;
    }
    Iterator localIterator = this.ljV.ljT.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (!TextUtils.isEmpty(localf.iBb)) {
        if (localf.iBb.startsWith("urn:schemas-upnp-org:service:AVTransport")) {
          this.ljX = localf;
        } else if (localf.iBb.startsWith("urn:schemas-upnp-org:service:RenderingControl")) {
          this.ljY = localf;
        } else if (localf.iBb.startsWith("urn:schemas-upnp-org:service:ConnectionManager")) {
          this.ljZ = localf;
        }
      }
    }
    AppMethodBeat.o(158924);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158929);
    if (this.ljY != null)
    {
      k localk = new k(a(this.ljY), this.ljY.iBb, paramInt);
      this.ljW.a(localk, parama);
    }
    AppMethodBeat.o(158929);
  }
  
  public final void a(d paramd)
  {
    this.lkd = paramd;
  }
  
  public final void a(e.a parama)
  {
    this.lka.lkh = parama;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158926);
    if (this.ljX != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.g localg = new com.tencent.mm.plugin.appbrand.g.a.g(a(this.ljX), this.ljX.iBb);
      this.ljW.a(localg, parama);
    }
    AppMethodBeat.o(158926);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158925);
    if (this.ljX != null)
    {
      paramString = new com.tencent.mm.plugin.appbrand.g.a.j(a(this.ljX), this.ljX.iBb, paramString);
      this.ljW.a(paramString, parama);
    }
    AppMethodBeat.o(158925);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.g.c.b.d paramd)
  {
    HashMap localHashMap = null;
    AppMethodBeat.i(158939);
    if (this.lkd == null)
    {
      AppMethodBeat.o(158939);
      return true;
    }
    if ((paramd.llq != null) && (!paramd.llq.containsKey("LastChange")))
    {
      AppMethodBeat.o(158939);
      return false;
    }
    if (paramd.llq != null) {}
    for (String str = ((com.tencent.mm.plugin.appbrand.g.c.b.a)Objects.requireNonNull(paramd.llq.get("LastChange"))).value;; str = null)
    {
      if (str != null) {
        localHashMap = com.tencent.mm.plugin.appbrand.g.c.j.bBE().Yf(str);
      }
      if (localHashMap == null)
      {
        AppMethodBeat.o(158939);
        return false;
      }
      int i;
      if ("avtEvent".equals(paramd.llo))
      {
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("TransportState");
        if (paramd != null)
        {
          paramd = paramd.Yh("val");
          if ("PLAYING".equalsIgnoreCase(paramd)) {
            this.lkd.d(this);
          }
        }
        else
        {
          paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("CurrentTrackDuration");
          if (paramd != null)
          {
            paramd = paramd.Yh("val").split(":");
            if (paramd.length == 3)
            {
              i = Integer.parseInt(paramd[0]);
              int j = Integer.parseInt(paramd[1]);
              int k = Integer.parseInt(paramd[2]);
              this.lkd.b(this, k + (i * 3600 + j * 60));
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
            this.lkd.e(this);
            break;
          }
          if (!"STOPPED".equalsIgnoreCase(paramd)) {
            break;
          }
          this.lkd.f(this);
          break;
        } while (!"rdcEvent".equals(paramd.llo));
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("Volume");
        if (paramd != null)
        {
          i = Integer.parseInt(paramd.Yh("val"));
          this.lkd.a(this, i);
        }
        paramd = (com.tencent.mm.plugin.appbrand.g.c.b.a)localHashMap.get("Mute");
      } while (paramd == null);
      if (!"0".equals(paramd.Yh("val"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.lkd.a(this, bool);
        break;
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158927);
    if (this.ljX != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.f localf = new com.tencent.mm.plugin.appbrand.g.a.f(a(this.ljX), this.ljX.iBb);
      this.ljW.a(localf, parama);
    }
    AppMethodBeat.o(158927);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158931);
    if (this.ljX != null)
    {
      paramString = new i(a(this.ljX), this.ljX.iBb, paramString);
      this.ljW.a(paramString, parama);
    }
    AppMethodBeat.o(158931);
  }
  
  public final b bBo()
  {
    return this.ljV;
  }
  
  public final e.a bBp()
  {
    return this.lka.lkh;
  }
  
  public final void bBq()
  {
    AppMethodBeat.i(158934);
    if (this.lke)
    {
      AppMethodBeat.o(158934);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bBx();
    com.tencent.mm.plugin.appbrand.g.c.a.c local1 = new com.tencent.mm.plugin.appbrand.g.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158914);
        c.this.lke = true;
        c.this.lkb = paramAnonymousc;
        if (c.this.ljV != null) {
          new StringBuilder().append(c.this.ljV.ljP).append(" subscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158914);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158915);
        if ((paramAnonymouse != null) && (c.this.ljV != null)) {
          new StringBuilder().append(c.this.ljV.ljP).append(" subscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158915);
      }
    };
    Object localObject = this.ljX;
    if (localObject != null)
    {
      String str = localc.Yc("/upnp/cb/AVTransport");
      localObject = new m(com.tencent.mm.plugin.appbrand.g.c.g.u(this.ljV.host, this.ljV.port, ((f)localObject).lkr), str);
      h.bBB().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.1(localc, this, local1));
      AppMethodBeat.o(158934);
      return;
    }
    local1.a(null);
    AppMethodBeat.o(158934);
  }
  
  public final void bBr()
  {
    AppMethodBeat.i(158935);
    if (this.lkf)
    {
      AppMethodBeat.o(158935);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bBx();
    com.tencent.mm.plugin.appbrand.g.c.a.c local2 = new com.tencent.mm.plugin.appbrand.g.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158916);
        c.this.lkf = true;
        c.this.lkc = paramAnonymousc;
        if (c.this.ljV != null) {
          new StringBuilder().append(c.this.ljV.ljP).append(" subscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158916);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158917);
        if ((paramAnonymouse != null) && (c.this.ljV != null)) {
          new StringBuilder().append(c.this.ljV.ljP).append(" subscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158917);
      }
    };
    Object localObject = this.ljY;
    if (localObject != null)
    {
      String str = localc.Yc("/upnp/cb/RenderControl");
      localObject = new m(com.tencent.mm.plugin.appbrand.g.c.g.u(this.ljV.host, this.ljV.port, ((f)localObject).lkr), str);
      h.bBB().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.2(localc, this, local2));
      AppMethodBeat.o(158935);
      return;
    }
    local2.a(null);
    AppMethodBeat.o(158935);
  }
  
  public final void bBs()
  {
    AppMethodBeat.i(158936);
    if (!this.lke)
    {
      AppMethodBeat.o(158936);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bBx();
    com.tencent.mm.plugin.appbrand.g.c.a.a local3 = new com.tencent.mm.plugin.appbrand.g.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158919);
        if ((paramAnonymouse != null) && (c.this.ljV != null)) {
          new StringBuilder().append(c.this.ljV.ljP).append(" unSubscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158919);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158918);
        c.this.lke = false;
        c.this.lkb = null;
        if (c.this.ljV != null) {
          new StringBuilder().append(c.this.ljV.ljP).append(" unSubscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158918);
      }
    };
    Object localObject = this.ljX;
    com.tencent.mm.plugin.appbrand.g.c.b.c localc1 = this.lkb;
    if ((localObject != null) && (localc1 != null) && (localc1.llm != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.g.c.g.u(this.ljV.host, this.ljV.port, ((f)localObject).lkr), localc1.llm);
      h.bBB().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.3(localc, localc1, local3));
      AppMethodBeat.o(158936);
      return;
    }
    local3.a(null);
    AppMethodBeat.o(158936);
  }
  
  public final void bBt()
  {
    AppMethodBeat.i(158937);
    if (!this.lkf)
    {
      AppMethodBeat.o(158937);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.c.c localc = c.b.bBx();
    com.tencent.mm.plugin.appbrand.g.c.a.a local4 = new com.tencent.mm.plugin.appbrand.g.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158921);
        if ((paramAnonymouse != null) && (c.this.ljV != null)) {
          new StringBuilder().append(c.this.ljV.ljP).append(" unSubscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158921);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158920);
        c.this.lkf = false;
        c.this.lkc = null;
        if (c.this.ljV != null) {
          new StringBuilder().append(c.this.ljV.ljP).append(" unSubscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158920);
      }
    };
    Object localObject = this.ljY;
    com.tencent.mm.plugin.appbrand.g.c.b.c localc1 = this.lkc;
    if ((localObject != null) && (localc1 != null) && (localc1.llm != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.g.c.g.u(this.ljV.host, this.ljV.port, ((f)localObject).lkr), localc1.llm);
      h.bBB().a((com.tencent.mm.plugin.appbrand.g.a.e)localObject, new com.tencent.mm.plugin.appbrand.g.c.c.4(localc, localc1, local4));
      AppMethodBeat.o(158937);
      return;
    }
    local4.a(null);
    AppMethodBeat.o(158937);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158928);
    if (this.ljX != null)
    {
      l locall = new l(a(this.ljX), this.ljX.iBb);
      this.ljW.a(locall, parama);
    }
    AppMethodBeat.o(158928);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158930);
    if (this.ljY != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.c localc = new com.tencent.mm.plugin.appbrand.g.a.c(a(this.ljY), this.ljY.iBb);
      this.ljW.a(localc, parama);
    }
    AppMethodBeat.o(158930);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158932);
    if (this.ljX != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.b localb = new com.tencent.mm.plugin.appbrand.g.a.b(a(this.ljX), this.ljX.iBb);
      this.ljW.a(localb, parama);
    }
    AppMethodBeat.o(158932);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158940);
    if ((this.ljV == null) && (paramObject == null))
    {
      AppMethodBeat.o(158940);
      return true;
    }
    if (this.ljV == null)
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
      boolean bool = this.ljV.equals(paramObject.ljV);
      AppMethodBeat.o(158940);
      return bool;
    }
    AppMethodBeat.o(158940);
    return false;
  }
  
  public final void f(com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(158933);
    if (this.ljX != null)
    {
      com.tencent.mm.plugin.appbrand.g.a.a locala = new com.tencent.mm.plugin.appbrand.g.a.a(a(this.ljX), this.ljX.iBb);
      this.ljW.a(locala, parama);
    }
    AppMethodBeat.o(158933);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158941);
    String str = "MRDevice{mDevice=" + this.ljV + '}';
    AppMethodBeat.o(158941);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.c
 * JD-Core Version:    0.7.0.1
 */