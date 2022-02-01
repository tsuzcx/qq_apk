package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.opengl.GLES30;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;

public final class n
  implements m
{
  private boolean isInit;
  private ArrayList<Runnable> jSc;
  private String krc;
  private com.tencent.mm.plugin.xlabeffect.e rIL;
  private float rIM;
  private float rIN;
  private float rIO;
  private float rIP;
  private long rIQ;
  private long rIR;
  private long rIS;
  private long rIT;
  private long rIU;
  private long rIV;
  private long rIW;
  private long rIX;
  private int[] rIY;
  
  public n()
  {
    AppMethodBeat.i(283701);
    this.rIL = null;
    this.isInit = false;
    this.rIM = 0.0F;
    this.rIN = 0.0F;
    this.rIO = 0.0F;
    this.rIP = 0.0F;
    this.krc = "";
    this.rIQ = 0L;
    this.rIR = 0L;
    this.rIS = 0L;
    this.rIT = 0L;
    this.rIU = 0L;
    this.rIV = 0L;
    this.rIW = 0L;
    this.rIX = 0L;
    this.rIY = new int[1];
    this.jSc = new ArrayList();
    AppMethodBeat.o(283701);
  }
  
  private void aa(Runnable paramRunnable)
  {
    AppMethodBeat.i(283703);
    try
    {
      this.jSc.add(paramRunnable);
      return;
    }
    finally
    {
      AppMethodBeat.o(283703);
    }
  }
  
  public final void TG()
  {
    AppMethodBeat.i(283709);
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276616);
        if (!n.a(n.this))
        {
          AppMethodBeat.o(276616);
          return;
        }
        n.b(n.this).TL(n.c(n.this));
        n.b(n.this).bG(12, false);
        n.b(n.this).TL(n.d(n.this));
        n.b(n.this).bG(13, false);
        n.b(n.this).TL(n.e(n.this));
        n.b(n.this).bG(11, false);
        n.b(n.this).DH(false);
        n.a(n.this, 0L);
        n.b(n.this, 0L);
        n.c(n.this, 0L);
        AppMethodBeat.o(276616);
      }
    });
    AppMethodBeat.o(283709);
  }
  
  public final void TH()
  {
    AppMethodBeat.i(283711);
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245634);
        if (!n.a(n.this))
        {
          AppMethodBeat.o(245634);
          return;
        }
        n.b(n.this).bG(14, false);
        n.b(n.this).bG(15, false);
        n.b(n.this).bG(16, false);
        n.b(n.this).bG(17, false);
        n.b(n.this).bG(18, false);
        n.b(n.this).TL(n.f(n.this));
        n.b(n.this).TL(n.g(n.this));
        n.b(n.this).TL(n.h(n.this));
        n.b(n.this).TL(n.i(n.this));
        n.b(n.this).TL(n.j(n.this));
        n.d(n.this, 0L);
        n.e(n.this, 0L);
        n.f(n.this, 0L);
        n.g(n.this, 0L);
        n.h(n.this, 0L);
        AppMethodBeat.o(245634);
      }
    });
    AppMethodBeat.o(283711);
  }
  
  public final void a(final m.a parama, float paramFloat)
  {
    AppMethodBeat.i(283704);
    final float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      aa(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250065);
          if (!n.a(n.this))
          {
            AppMethodBeat.o(250065);
            return;
          }
          switch (n.7.rJg[parama.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(250065);
            return;
            n.b(n.this).lP(3, this.rJa);
            n.a(n.this, f);
            AppMethodBeat.o(250065);
            return;
            n.b(n.this).lP(0, this.rJa);
            n.b(n.this, f);
            AppMethodBeat.o(250065);
            return;
            n.b(n.this).lP(2, this.rJa * 2);
            n.c(n.this, f * 2.0F);
            AppMethodBeat.o(250065);
            return;
            n.b(n.this).lP(1, this.rJa);
            n.d(n.this, f);
          }
        }
      });
      AppMethodBeat.o(283704);
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  public final void a(final m.b paramb, final String paramString)
  {
    AppMethodBeat.i(283710);
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(280150);
        if (!n.a(n.this))
        {
          AppMethodBeat.o(280150);
          return;
        }
        switch (n.7.cJm[paramb.ordinal()])
        {
        default: 
          AppMethodBeat.o(280150);
          return;
        case 1: 
          if (n.f(n.this) != 0L)
          {
            n.b(n.this).TL(n.f(n.this));
            n.d(n.this, 0L);
          }
          n.b(n.this).bG(14, true);
          n.d(n.this, n.b(n.this).db(0, paramString));
          AppMethodBeat.o(280150);
          return;
        case 2: 
          if (n.g(n.this) != 0L)
          {
            n.b(n.this).TL(n.g(n.this));
            n.e(n.this, 0L);
          }
          n.b(n.this).bG(15, true);
          n.e(n.this, n.b(n.this).db(1, paramString));
          AppMethodBeat.o(280150);
          return;
        case 3: 
          if (n.h(n.this) != 0L)
          {
            n.b(n.this).TL(n.h(n.this));
            n.f(n.this, 0L);
          }
          n.b(n.this).bG(16, true);
          n.f(n.this, n.b(n.this).db(2, paramString));
          AppMethodBeat.o(280150);
          return;
        case 4: 
          if (n.i(n.this) != 0L)
          {
            n.b(n.this).TL(n.i(n.this));
            n.g(n.this, 0L);
          }
          n.b(n.this).bG(17, true);
          n.g(n.this, n.b(n.this).db(3, paramString));
          AppMethodBeat.o(280150);
          return;
        }
        if (n.j(n.this) != 0L)
        {
          n.b(n.this).TL(n.j(n.this));
          n.h(n.this, 0L);
        }
        n.b(n.this).bG(18, true);
        n.h(n.this, n.b(n.this).db(4, paramString));
        AppMethodBeat.o(280150);
      }
    });
    AppMethodBeat.o(283710);
  }
  
  public final void a(final m.c paramc, final String paramString)
  {
    AppMethodBeat.i(283707);
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277857);
        if (!n.a(n.this))
        {
          AppMethodBeat.o(277857);
          return;
        }
        com.tencent.mm.sticker.e locale = new com.tencent.mm.sticker.e();
        try
        {
          locale.buG(paramString);
          locale.ay(h.ME(u.bBS(paramString + "/config.json")));
          switch (n.7.rJh[paramc.ordinal()])
          {
          default: 
            AppMethodBeat.o(277857);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          AppMethodBeat.o(277857);
          return;
        }
        catch (IOException localIOException)
        {
          AppMethodBeat.o(277857);
          return;
        }
        if (n.c(n.this) != 0L)
        {
          n.b(n.this).TL(n.c(n.this));
          n.a(n.this, 0L);
        }
        n.b(n.this).bG(12, true);
        n.a(n.this, n.b(n.this).a(localIOException));
        n.b(n.this).DH(true);
        AppMethodBeat.o(277857);
        return;
        if (n.d(n.this) != 0L)
        {
          n.b(n.this).TL(n.d(n.this));
          n.b(n.this, 0L);
        }
        n.b(n.this).bG(13, true);
        n.b(n.this, n.b(n.this).a(localIOException));
        AppMethodBeat.o(277857);
        return;
        if (n.e(n.this) != 0L)
        {
          n.b(n.this).TL(n.e(n.this));
          n.c(n.this, 0L);
        }
        n.b(n.this).bG(11, true);
        n.c(n.this, n.b(n.this).a(localIOException));
        AppMethodBeat.o(277857);
      }
    });
    AppMethodBeat.o(283707);
  }
  
  public final void b(final String paramString, float paramFloat)
  {
    AppMethodBeat.i(283706);
    final float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    while (!paramString.isEmpty())
    {
      try
      {
        boolean bool = new File(paramString).exists();
        if (bool) {
          break;
        }
        AppMethodBeat.o(283706);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(283706);
        return;
      }
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(266904);
        if (!n.a(n.this))
        {
          AppMethodBeat.o(266904);
          return;
        }
        n.b(n.this).m(paramString, f);
        n.a(n.this, paramString);
        AppMethodBeat.o(266904);
      }
    });
    AppMethodBeat.o(283706);
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(283708);
    b("", 0.0F);
    AppMethodBeat.o(283708);
  }
  
  public final boolean isEnabled()
  {
    return true;
  }
  
  public final void onDetectFacePoints(float[] paramArrayOfFloat) {}
  
  public final int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(283712);
    try
    {
      if (!this.isInit)
      {
        this.rIL = new com.tencent.mm.plugin.xlabeffect.e();
        GLES30.glGenTextures(1, this.rIY, 0);
        GLES30.glBindTexture(3553, this.rIY[0]);
        GLES30.glTexParameteri(3553, 10241, 9729);
        GLES30.glTexParameteri(3553, 10240, 9728);
        GLES30.glTexParameteri(3553, 10242, 33071);
        GLES30.glTexParameteri(3553, 10243, 33071);
        GLES30.glBindTexture(3553, 0);
        this.rIL.QPZ.hjw = 2;
        this.isInit = true;
      }
      while (!this.jSc.isEmpty()) {
        ((Runnable)this.jSc.remove(0)).run();
      }
      if (this.rIM != 0.0F) {
        break label381;
      }
    }
    finally
    {
      AppMethodBeat.o(283712);
    }
    if ((this.rIN == 0.0F) && (this.rIO == 0.0F) && (this.rIP == 0.0F) && (this.krc.isEmpty()) && (this.rIQ == 0L) && (this.rIR == 0L) && (this.rIS == 0L) && (this.rIT == 0L) && (this.rIU == 0L) && (this.rIV == 0L) && (this.rIW == 0L)) {
      if (this.rIX != 0L) {
        break label381;
      }
    }
    for (;;)
    {
      int i;
      if (i != 0)
      {
        GLES30.glBindTexture(3553, this.rIY[0]);
        GLES30.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
        this.rIL.setSize(paramInt2, paramInt3);
        this.rIL.lO(paramInt1, 0);
        com.tencent.mm.plugin.xlabeffect.e.a(this.rIL, paramInt1, this.rIY[0], false, 60);
        paramInt1 = this.rIY[0];
        AppMethodBeat.o(283712);
        return paramInt1;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(283712);
        return paramInt1;
        label381:
        i = 1;
      }
    }
  }
  
  public final void onTextureDestoryed()
  {
    AppMethodBeat.i(283713);
    try
    {
      if (this.isInit)
      {
        this.rIL.destroy();
        GLES30.glDeleteTextures(1, this.rIY, 0);
        this.isInit = false;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(283713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.n
 * JD-Core Version:    0.7.0.1
 */