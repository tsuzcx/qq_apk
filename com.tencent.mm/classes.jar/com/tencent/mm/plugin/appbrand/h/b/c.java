package com.tencent.mm.plugin.appbrand.h.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.a.i;
import com.tencent.mm.plugin.appbrand.h.a.k;
import com.tencent.mm.plugin.appbrand.h.a.l;
import com.tencent.mm.plugin.appbrand.h.a.m;
import com.tencent.mm.plugin.appbrand.h.a.n;
import com.tencent.mm.plugin.appbrand.h.c.c.b;
import com.tencent.mm.plugin.appbrand.h.c.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public final class c
  implements com.tencent.mm.plugin.appbrand.h.c.a.b
{
  protected e jiA;
  protected com.tencent.mm.plugin.appbrand.h.c.b.c jiB;
  protected com.tencent.mm.plugin.appbrand.h.c.b.c jiC;
  protected d jiD;
  protected boolean jiE;
  protected boolean jiF;
  protected b jiv;
  protected h jiw;
  protected f jix;
  protected f jiy;
  protected f jiz;
  protected boolean mIsMute;
  
  public c(b paramb)
  {
    AppMethodBeat.i(158923);
    this.jiw = h.aUY();
    this.jiA = new e();
    this.mIsMute = false;
    this.jiE = false;
    this.jiF = false;
    this.jiv = paramb;
    init();
    AppMethodBeat.o(158923);
  }
  
  public static c a(b paramb)
  {
    AppMethodBeat.i(158922);
    paramb = new c(paramb);
    if ((paramb.jix != null) && (paramb.jiy != null)) {}
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
    if (this.jiv != null)
    {
      paramf = com.tencent.mm.plugin.appbrand.h.c.g.n(this.jiv.host, this.jiv.port, paramf.jiR);
      AppMethodBeat.o(158938);
      return paramf;
    }
    AppMethodBeat.o(158938);
    return "";
  }
  
  private void init()
  {
    AppMethodBeat.i(158924);
    if (this.jiv == null)
    {
      AppMethodBeat.o(158924);
      return;
    }
    if (this.jiv.jit.size() == 0)
    {
      AppMethodBeat.o(158924);
      return;
    }
    Iterator localIterator = this.jiv.jit.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (!TextUtils.isEmpty(localf.gLm)) {
        if (localf.gLm.startsWith("urn:schemas-upnp-org:service:AVTransport")) {
          this.jix = localf;
        } else if (localf.gLm.startsWith("urn:schemas-upnp-org:service:RenderingControl")) {
          this.jiy = localf;
        } else if (localf.gLm.startsWith("urn:schemas-upnp-org:service:ConnectionManager")) {
          this.jiz = localf;
        }
      }
    }
    AppMethodBeat.o(158924);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158929);
    if (this.jiy != null)
    {
      k localk = new k(a(this.jiy), this.jiy.gLm, paramInt);
      this.jiw.a(localk, parama);
    }
    AppMethodBeat.o(158929);
  }
  
  public final void a(d paramd)
  {
    this.jiD = paramd;
  }
  
  public final void a(e.a parama)
  {
    this.jiA.jiH = parama;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158926);
    if (this.jix != null)
    {
      com.tencent.mm.plugin.appbrand.h.a.g localg = new com.tencent.mm.plugin.appbrand.h.a.g(a(this.jix), this.jix.gLm);
      this.jiw.a(localg, parama);
    }
    AppMethodBeat.o(158926);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158925);
    if (this.jix != null)
    {
      paramString = new com.tencent.mm.plugin.appbrand.h.a.j(a(this.jix), this.jix.gLm, paramString);
      this.jiw.a(paramString, parama);
    }
    AppMethodBeat.o(158925);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.h.c.b.d paramd)
  {
    HashMap localHashMap = null;
    AppMethodBeat.i(158939);
    if (this.jiD == null)
    {
      AppMethodBeat.o(158939);
      return true;
    }
    if ((paramd.jjS != null) && (!paramd.jjS.containsKey("LastChange")))
    {
      AppMethodBeat.o(158939);
      return false;
    }
    if (paramd.jjS != null) {}
    for (String str = ((com.tencent.mm.plugin.appbrand.h.c.b.a)Objects.requireNonNull(paramd.jjS.get("LastChange"))).value;; str = null)
    {
      if (str != null) {
        localHashMap = com.tencent.mm.plugin.appbrand.h.c.j.aVb().GO(str);
      }
      if (localHashMap == null)
      {
        AppMethodBeat.o(158939);
        return false;
      }
      int i;
      if ("avtEvent".equals(paramd.jjQ))
      {
        paramd = (com.tencent.mm.plugin.appbrand.h.c.b.a)localHashMap.get("TransportState");
        if (paramd != null)
        {
          paramd = paramd.GQ("val");
          if ("PLAYING".equalsIgnoreCase(paramd)) {
            this.jiD.d(this);
          }
        }
        else
        {
          paramd = (com.tencent.mm.plugin.appbrand.h.c.b.a)localHashMap.get("CurrentTrackDuration");
          if (paramd != null)
          {
            paramd = paramd.GQ("val").split(":");
            if (paramd.length == 3)
            {
              i = Integer.parseInt(paramd[0]);
              int j = Integer.parseInt(paramd[1]);
              int k = Integer.parseInt(paramd[2]);
              this.jiD.b(this, k + (i * 3600 + j * 60));
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
            this.jiD.e(this);
            break;
          }
          if (!"STOPPED".equalsIgnoreCase(paramd)) {
            break;
          }
          this.jiD.f(this);
          break;
        } while (!"rdcEvent".equals(paramd.jjQ));
        paramd = (com.tencent.mm.plugin.appbrand.h.c.b.a)localHashMap.get("Volume");
        if (paramd != null)
        {
          i = Integer.parseInt(paramd.GQ("val"));
          this.jiD.a(this, i);
        }
        paramd = (com.tencent.mm.plugin.appbrand.h.c.b.a)localHashMap.get("Mute");
      } while (paramd == null);
      if (!"0".equals(paramd.GQ("val"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.jiD.a(this, bool);
        break;
      }
    }
  }
  
  public final b aUL()
  {
    return this.jiv;
  }
  
  public final e.a aUM()
  {
    return this.jiA.jiH;
  }
  
  public final void aUN()
  {
    AppMethodBeat.i(158934);
    if (this.jiE)
    {
      AppMethodBeat.o(158934);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.c.c localc = c.b.aUU();
    com.tencent.mm.plugin.appbrand.h.c.a.c local1 = new com.tencent.mm.plugin.appbrand.h.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158914);
        c.this.jiE = true;
        c.this.jiB = paramAnonymousc;
        if (c.this.jiv != null) {
          new StringBuilder().append(c.this.jiv.jip).append(" subscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158914);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158915);
        if ((paramAnonymouse != null) && (c.this.jiv != null)) {
          new StringBuilder().append(c.this.jiv.jip).append(" subscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158915);
      }
    };
    Object localObject = this.jix;
    if (localObject != null)
    {
      String str = localc.GM("/upnp/cb/AVTransport");
      localObject = new m(com.tencent.mm.plugin.appbrand.h.c.g.n(this.jiv.host, this.jiv.port, ((f)localObject).jiS), str);
      h.aUY().a((com.tencent.mm.plugin.appbrand.h.a.e)localObject, new com.tencent.mm.plugin.appbrand.h.c.c.1(localc, this, local1));
      AppMethodBeat.o(158934);
      return;
    }
    local1.a(null);
    AppMethodBeat.o(158934);
  }
  
  public final void aUO()
  {
    AppMethodBeat.i(158935);
    if (this.jiF)
    {
      AppMethodBeat.o(158935);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.c.c localc = c.b.aUU();
    com.tencent.mm.plugin.appbrand.h.c.a.c local2 = new com.tencent.mm.plugin.appbrand.h.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158916);
        c.this.jiF = true;
        c.this.jiC = paramAnonymousc;
        if (c.this.jiv != null) {
          new StringBuilder().append(c.this.jiv.jip).append(" subscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158916);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158917);
        if ((paramAnonymouse != null) && (c.this.jiv != null)) {
          new StringBuilder().append(c.this.jiv.jip).append(" subscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158917);
      }
    };
    Object localObject = this.jiy;
    if (localObject != null)
    {
      String str = localc.GM("/upnp/cb/RenderControl");
      localObject = new m(com.tencent.mm.plugin.appbrand.h.c.g.n(this.jiv.host, this.jiv.port, ((f)localObject).jiS), str);
      h.aUY().a((com.tencent.mm.plugin.appbrand.h.a.e)localObject, new com.tencent.mm.plugin.appbrand.h.c.c.2(localc, this, local2));
      AppMethodBeat.o(158935);
      return;
    }
    local2.a(null);
    AppMethodBeat.o(158935);
  }
  
  public final void aUP()
  {
    AppMethodBeat.i(158936);
    if (!this.jiE)
    {
      AppMethodBeat.o(158936);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.c.c localc = c.b.aUU();
    com.tencent.mm.plugin.appbrand.h.c.a.a local3 = new com.tencent.mm.plugin.appbrand.h.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158919);
        if ((paramAnonymouse != null) && (c.this.jiv != null)) {
          new StringBuilder().append(c.this.jiv.jip).append(" unSubscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158919);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158918);
        c.this.jiE = false;
        c.this.jiB = null;
        if (c.this.jiv != null) {
          new StringBuilder().append(c.this.jiv.jip).append(" unSubscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158918);
      }
    };
    Object localObject = this.jix;
    com.tencent.mm.plugin.appbrand.h.c.b.c localc1 = this.jiB;
    if ((localObject != null) && (localc1 != null) && (localc1.jjO != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.h.c.g.n(this.jiv.host, this.jiv.port, ((f)localObject).jiS), localc1.jjO);
      h.aUY().a((com.tencent.mm.plugin.appbrand.h.a.e)localObject, new com.tencent.mm.plugin.appbrand.h.c.c.3(localc, localc1, local3));
      AppMethodBeat.o(158936);
      return;
    }
    local3.a(null);
    AppMethodBeat.o(158936);
  }
  
  public final void aUQ()
  {
    AppMethodBeat.i(158937);
    if (!this.jiF)
    {
      AppMethodBeat.o(158937);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.c.c localc = c.b.aUU();
    com.tencent.mm.plugin.appbrand.h.c.a.a local4 = new com.tencent.mm.plugin.appbrand.h.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158921);
        if ((paramAnonymouse != null) && (c.this.jiv != null)) {
          new StringBuilder().append(c.this.jiv.jip).append(" unSubscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158921);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158920);
        c.this.jiF = false;
        c.this.jiC = null;
        if (c.this.jiv != null) {
          new StringBuilder().append(c.this.jiv.jip).append(" unSubscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158920);
      }
    };
    Object localObject = this.jiy;
    com.tencent.mm.plugin.appbrand.h.c.b.c localc1 = this.jiC;
    if ((localObject != null) && (localc1 != null) && (localc1.jjO != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.h.c.g.n(this.jiv.host, this.jiv.port, ((f)localObject).jiS), localc1.jjO);
      h.aUY().a((com.tencent.mm.plugin.appbrand.h.a.e)localObject, new com.tencent.mm.plugin.appbrand.h.c.c.4(localc, localc1, local4));
      AppMethodBeat.o(158937);
      return;
    }
    local4.a(null);
    AppMethodBeat.o(158937);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158927);
    if (this.jix != null)
    {
      com.tencent.mm.plugin.appbrand.h.a.f localf = new com.tencent.mm.plugin.appbrand.h.a.f(a(this.jix), this.jix.gLm);
      this.jiw.a(localf, parama);
    }
    AppMethodBeat.o(158927);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158931);
    if (this.jix != null)
    {
      paramString = new i(a(this.jix), this.jix.gLm, paramString);
      this.jiw.a(paramString, parama);
    }
    AppMethodBeat.o(158931);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158928);
    if (this.jix != null)
    {
      l locall = new l(a(this.jix), this.jix.gLm);
      this.jiw.a(locall, parama);
    }
    AppMethodBeat.o(158928);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158930);
    if (this.jiy != null)
    {
      com.tencent.mm.plugin.appbrand.h.a.c localc = new com.tencent.mm.plugin.appbrand.h.a.c(a(this.jiy), this.jiy.gLm);
      this.jiw.a(localc, parama);
    }
    AppMethodBeat.o(158930);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158932);
    if (this.jix != null)
    {
      com.tencent.mm.plugin.appbrand.h.a.b localb = new com.tencent.mm.plugin.appbrand.h.a.b(a(this.jix), this.jix.gLm);
      this.jiw.a(localb, parama);
    }
    AppMethodBeat.o(158932);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158940);
    if ((this.jiv == null) && (paramObject == null))
    {
      AppMethodBeat.o(158940);
      return true;
    }
    if (this.jiv == null)
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
      boolean bool = this.jiv.equals(paramObject.jiv);
      AppMethodBeat.o(158940);
      return bool;
    }
    AppMethodBeat.o(158940);
    return false;
  }
  
  public final void f(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158933);
    if (this.jix != null)
    {
      com.tencent.mm.plugin.appbrand.h.a.a locala = new com.tencent.mm.plugin.appbrand.h.a.a(a(this.jix), this.jix.gLm);
      this.jiw.a(locala, parama);
    }
    AppMethodBeat.o(158933);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158941);
    String str = "MRDevice{mDevice=" + this.jiv + '}';
    AppMethodBeat.o(158941);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.b.c
 * JD-Core Version:    0.7.0.1
 */