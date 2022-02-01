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
  protected b jIJ;
  protected h jIK;
  protected f jIL;
  protected f jIM;
  protected f jIN;
  protected e jIO;
  protected com.tencent.mm.plugin.appbrand.h.c.b.c jIP;
  protected com.tencent.mm.plugin.appbrand.h.c.b.c jIQ;
  protected d jIR;
  protected boolean jIS;
  protected boolean jIT;
  protected boolean mIsMute;
  
  public c(b paramb)
  {
    AppMethodBeat.i(158923);
    this.jIK = h.bbW();
    this.jIO = new e();
    this.mIsMute = false;
    this.jIS = false;
    this.jIT = false;
    this.jIJ = paramb;
    init();
    AppMethodBeat.o(158923);
  }
  
  public static c a(b paramb)
  {
    AppMethodBeat.i(158922);
    paramb = new c(paramb);
    if ((paramb.jIL != null) && (paramb.jIM != null)) {}
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
    if (this.jIJ != null)
    {
      paramf = com.tencent.mm.plugin.appbrand.h.c.g.n(this.jIJ.host, this.jIJ.port, paramf.jJe);
      AppMethodBeat.o(158938);
      return paramf;
    }
    AppMethodBeat.o(158938);
    return "";
  }
  
  private void init()
  {
    AppMethodBeat.i(158924);
    if (this.jIJ == null)
    {
      AppMethodBeat.o(158924);
      return;
    }
    if (this.jIJ.jIH.size() == 0)
    {
      AppMethodBeat.o(158924);
      return;
    }
    Iterator localIterator = this.jIJ.jIH.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (!TextUtils.isEmpty(localf.hlM)) {
        if (localf.hlM.startsWith("urn:schemas-upnp-org:service:AVTransport")) {
          this.jIL = localf;
        } else if (localf.hlM.startsWith("urn:schemas-upnp-org:service:RenderingControl")) {
          this.jIM = localf;
        } else if (localf.hlM.startsWith("urn:schemas-upnp-org:service:ConnectionManager")) {
          this.jIN = localf;
        }
      }
    }
    AppMethodBeat.o(158924);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158929);
    if (this.jIM != null)
    {
      k localk = new k(a(this.jIM), this.jIM.hlM, paramInt);
      this.jIK.a(localk, parama);
    }
    AppMethodBeat.o(158929);
  }
  
  public final void a(d paramd)
  {
    this.jIR = paramd;
  }
  
  public final void a(e.a parama)
  {
    this.jIO.jIV = parama;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158926);
    if (this.jIL != null)
    {
      com.tencent.mm.plugin.appbrand.h.a.g localg = new com.tencent.mm.plugin.appbrand.h.a.g(a(this.jIL), this.jIL.hlM);
      this.jIK.a(localg, parama);
    }
    AppMethodBeat.o(158926);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158925);
    if (this.jIL != null)
    {
      paramString = new com.tencent.mm.plugin.appbrand.h.a.j(a(this.jIL), this.jIL.hlM, paramString);
      this.jIK.a(paramString, parama);
    }
    AppMethodBeat.o(158925);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.h.c.b.d paramd)
  {
    HashMap localHashMap = null;
    AppMethodBeat.i(158939);
    if (this.jIR == null)
    {
      AppMethodBeat.o(158939);
      return true;
    }
    if ((paramd.jKf != null) && (!paramd.jKf.containsKey("LastChange")))
    {
      AppMethodBeat.o(158939);
      return false;
    }
    if (paramd.jKf != null) {}
    for (String str = ((com.tencent.mm.plugin.appbrand.h.c.b.a)Objects.requireNonNull(paramd.jKf.get("LastChange"))).value;; str = null)
    {
      if (str != null) {
        localHashMap = com.tencent.mm.plugin.appbrand.h.c.j.bbZ().KS(str);
      }
      if (localHashMap == null)
      {
        AppMethodBeat.o(158939);
        return false;
      }
      int i;
      if ("avtEvent".equals(paramd.jKd))
      {
        paramd = (com.tencent.mm.plugin.appbrand.h.c.b.a)localHashMap.get("TransportState");
        if (paramd != null)
        {
          paramd = paramd.KU("val");
          if ("PLAYING".equalsIgnoreCase(paramd)) {
            this.jIR.d(this);
          }
        }
        else
        {
          paramd = (com.tencent.mm.plugin.appbrand.h.c.b.a)localHashMap.get("CurrentTrackDuration");
          if (paramd != null)
          {
            paramd = paramd.KU("val").split(":");
            if (paramd.length == 3)
            {
              i = Integer.parseInt(paramd[0]);
              int j = Integer.parseInt(paramd[1]);
              int k = Integer.parseInt(paramd[2]);
              this.jIR.b(this, k + (i * 3600 + j * 60));
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
            this.jIR.e(this);
            break;
          }
          if (!"STOPPED".equalsIgnoreCase(paramd)) {
            break;
          }
          this.jIR.f(this);
          break;
        } while (!"rdcEvent".equals(paramd.jKd));
        paramd = (com.tencent.mm.plugin.appbrand.h.c.b.a)localHashMap.get("Volume");
        if (paramd != null)
        {
          i = Integer.parseInt(paramd.KU("val"));
          this.jIR.a(this, i);
        }
        paramd = (com.tencent.mm.plugin.appbrand.h.c.b.a)localHashMap.get("Mute");
      } while (paramd == null);
      if (!"0".equals(paramd.KU("val"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.jIR.a(this, bool);
        break;
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158927);
    if (this.jIL != null)
    {
      com.tencent.mm.plugin.appbrand.h.a.f localf = new com.tencent.mm.plugin.appbrand.h.a.f(a(this.jIL), this.jIL.hlM);
      this.jIK.a(localf, parama);
    }
    AppMethodBeat.o(158927);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158931);
    if (this.jIL != null)
    {
      paramString = new i(a(this.jIL), this.jIL.hlM, paramString);
      this.jIK.a(paramString, parama);
    }
    AppMethodBeat.o(158931);
  }
  
  public final b bbJ()
  {
    return this.jIJ;
  }
  
  public final e.a bbK()
  {
    return this.jIO.jIV;
  }
  
  public final void bbL()
  {
    AppMethodBeat.i(158934);
    if (this.jIS)
    {
      AppMethodBeat.o(158934);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.c.c localc = c.b.bbS();
    com.tencent.mm.plugin.appbrand.h.c.a.c local1 = new com.tencent.mm.plugin.appbrand.h.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158914);
        c.this.jIS = true;
        c.this.jIP = paramAnonymousc;
        if (c.this.jIJ != null) {
          new StringBuilder().append(c.this.jIJ.jID).append(" subscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158914);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158915);
        if ((paramAnonymouse != null) && (c.this.jIJ != null)) {
          new StringBuilder().append(c.this.jIJ.jID).append(" subscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158915);
      }
    };
    Object localObject = this.jIL;
    if (localObject != null)
    {
      String str = localc.KQ("/upnp/cb/AVTransport");
      localObject = new m(com.tencent.mm.plugin.appbrand.h.c.g.n(this.jIJ.host, this.jIJ.port, ((f)localObject).jJf), str);
      h.bbW().a((com.tencent.mm.plugin.appbrand.h.a.e)localObject, new com.tencent.mm.plugin.appbrand.h.c.c.1(localc, this, local1));
      AppMethodBeat.o(158934);
      return;
    }
    local1.a(null);
    AppMethodBeat.o(158934);
  }
  
  public final void bbM()
  {
    AppMethodBeat.i(158935);
    if (this.jIT)
    {
      AppMethodBeat.o(158935);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.c.c localc = c.b.bbS();
    com.tencent.mm.plugin.appbrand.h.c.a.c local2 = new com.tencent.mm.plugin.appbrand.h.c.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.c paramAnonymousc)
      {
        AppMethodBeat.i(158916);
        c.this.jIT = true;
        c.this.jIQ = paramAnonymousc;
        if (c.this.jIJ != null) {
          new StringBuilder().append(c.this.jIJ.jID).append(" subscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158916);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158917);
        if ((paramAnonymouse != null) && (c.this.jIJ != null)) {
          new StringBuilder().append(c.this.jIJ.jID).append(" subscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158917);
      }
    };
    Object localObject = this.jIM;
    if (localObject != null)
    {
      String str = localc.KQ("/upnp/cb/RenderControl");
      localObject = new m(com.tencent.mm.plugin.appbrand.h.c.g.n(this.jIJ.host, this.jIJ.port, ((f)localObject).jJf), str);
      h.bbW().a((com.tencent.mm.plugin.appbrand.h.a.e)localObject, new com.tencent.mm.plugin.appbrand.h.c.c.2(localc, this, local2));
      AppMethodBeat.o(158935);
      return;
    }
    local2.a(null);
    AppMethodBeat.o(158935);
  }
  
  public final void bbN()
  {
    AppMethodBeat.i(158936);
    if (!this.jIS)
    {
      AppMethodBeat.o(158936);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.c.c localc = c.b.bbS();
    com.tencent.mm.plugin.appbrand.h.c.a.a local3 = new com.tencent.mm.plugin.appbrand.h.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158919);
        if ((paramAnonymouse != null) && (c.this.jIJ != null)) {
          new StringBuilder().append(c.this.jIJ.jID).append(" unSubscribeAVTransportEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158919);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158918);
        c.this.jIS = false;
        c.this.jIP = null;
        if (c.this.jIJ != null) {
          new StringBuilder().append(c.this.jIJ.jID).append(" unSubscribeAVTransportEvent success");
        }
        AppMethodBeat.o(158918);
      }
    };
    Object localObject = this.jIL;
    com.tencent.mm.plugin.appbrand.h.c.b.c localc1 = this.jIP;
    if ((localObject != null) && (localc1 != null) && (localc1.jKb != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.h.c.g.n(this.jIJ.host, this.jIJ.port, ((f)localObject).jJf), localc1.jKb);
      h.bbW().a((com.tencent.mm.plugin.appbrand.h.a.e)localObject, new com.tencent.mm.plugin.appbrand.h.c.c.3(localc, localc1, local3));
      AppMethodBeat.o(158936);
      return;
    }
    local3.a(null);
    AppMethodBeat.o(158936);
  }
  
  public final void bbO()
  {
    AppMethodBeat.i(158937);
    if (!this.jIT)
    {
      AppMethodBeat.o(158937);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.c.c localc = c.b.bbS();
    com.tencent.mm.plugin.appbrand.h.c.a.a local4 = new com.tencent.mm.plugin.appbrand.h.c.a.a()
    {
      public final void a(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158921);
        if ((paramAnonymouse != null) && (c.this.jIJ != null)) {
          new StringBuilder().append(c.this.jIJ.jID).append(" unSubscribeRenderingControlEvent fail response code : ").append(paramAnonymouse.responseCode);
        }
        AppMethodBeat.o(158921);
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.h.c.b.e paramAnonymouse)
      {
        AppMethodBeat.i(158920);
        c.this.jIT = false;
        c.this.jIQ = null;
        if (c.this.jIJ != null) {
          new StringBuilder().append(c.this.jIJ.jID).append(" unSubscribeRenderingControlEvent success");
        }
        AppMethodBeat.o(158920);
      }
    };
    Object localObject = this.jIM;
    com.tencent.mm.plugin.appbrand.h.c.b.c localc1 = this.jIQ;
    if ((localObject != null) && (localc1 != null) && (localc1.jKb != null))
    {
      localObject = new n(com.tencent.mm.plugin.appbrand.h.c.g.n(this.jIJ.host, this.jIJ.port, ((f)localObject).jJf), localc1.jKb);
      h.bbW().a((com.tencent.mm.plugin.appbrand.h.a.e)localObject, new com.tencent.mm.plugin.appbrand.h.c.c.4(localc, localc1, local4));
      AppMethodBeat.o(158937);
      return;
    }
    local4.a(null);
    AppMethodBeat.o(158937);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158928);
    if (this.jIL != null)
    {
      l locall = new l(a(this.jIL), this.jIL.hlM);
      this.jIK.a(locall, parama);
    }
    AppMethodBeat.o(158928);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158930);
    if (this.jIM != null)
    {
      com.tencent.mm.plugin.appbrand.h.a.c localc = new com.tencent.mm.plugin.appbrand.h.a.c(a(this.jIM), this.jIM.hlM);
      this.jIK.a(localc, parama);
    }
    AppMethodBeat.o(158930);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158932);
    if (this.jIL != null)
    {
      com.tencent.mm.plugin.appbrand.h.a.b localb = new com.tencent.mm.plugin.appbrand.h.a.b(a(this.jIL), this.jIL.hlM);
      this.jIK.a(localb, parama);
    }
    AppMethodBeat.o(158932);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158940);
    if ((this.jIJ == null) && (paramObject == null))
    {
      AppMethodBeat.o(158940);
      return true;
    }
    if (this.jIJ == null)
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
      boolean bool = this.jIJ.equals(paramObject.jIJ);
      AppMethodBeat.o(158940);
      return bool;
    }
    AppMethodBeat.o(158940);
    return false;
  }
  
  public final void f(com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(158933);
    if (this.jIL != null)
    {
      com.tencent.mm.plugin.appbrand.h.a.a locala = new com.tencent.mm.plugin.appbrand.h.a.a(a(this.jIL), this.jIL.hlM);
      this.jIK.a(locala, parama);
    }
    AppMethodBeat.o(158933);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158941);
    String str = "MRDevice{mDevice=" + this.jIJ + '}';
    AppMethodBeat.o(158941);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.b.c
 * JD-Core Version:    0.7.0.1
 */