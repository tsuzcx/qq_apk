package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.opengl.GLES30;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sticker.e;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;

public final class n
  implements l
{
  private String hDj;
  private ArrayList<Runnable> hgk;
  private boolean isInit;
  private b oGV;
  private float oGW;
  private float oGX;
  private float oGY;
  private float oGZ;
  private long oHa;
  private long oHb;
  private long oHc;
  private long oHd;
  private long oHe;
  private long oHf;
  private long oHg;
  private long oHh;
  private int[] oHi;
  
  public n()
  {
    AppMethodBeat.i(227855);
    this.oGV = null;
    this.isInit = false;
    this.oGW = 0.0F;
    this.oGX = 0.0F;
    this.oGY = 0.0F;
    this.oGZ = 0.0F;
    this.hDj = "";
    this.oHa = 0L;
    this.oHb = 0L;
    this.oHc = 0L;
    this.oHd = 0L;
    this.oHe = 0L;
    this.oHf = 0L;
    this.oHg = 0L;
    this.oHh = 0L;
    this.oHi = new int[1];
    this.hgk = new ArrayList();
    AppMethodBeat.o(227855);
  }
  
  private void queueEvent(Runnable paramRunnable)
  {
    AppMethodBeat.i(227856);
    try
    {
      this.hgk.add(paramRunnable);
      return;
    }
    finally
    {
      AppMethodBeat.o(227856);
    }
  }
  
  public final void Qf()
  {
    AppMethodBeat.i(227861);
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227851);
        if (!n.a(n.this))
        {
          AppMethodBeat.o(227851);
          return;
        }
        n.b(n.this).Ml(n.c(n.this));
        n.b(n.this).bu(12, false);
        n.b(n.this).Ml(n.d(n.this));
        n.b(n.this).bu(13, false);
        n.b(n.this).Ml(n.e(n.this));
        n.b(n.this).bu(11, false);
        n.b(n.this).zG(false);
        n.a(n.this, 0L);
        n.b(n.this, 0L);
        n.c(n.this, 0L);
        AppMethodBeat.o(227851);
      }
    });
    AppMethodBeat.o(227861);
  }
  
  public final void Qg()
  {
    AppMethodBeat.i(227863);
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227853);
        if (!n.a(n.this))
        {
          AppMethodBeat.o(227853);
          return;
        }
        n.b(n.this).bu(14, false);
        n.b(n.this).bu(15, false);
        n.b(n.this).bu(16, false);
        n.b(n.this).bu(17, false);
        n.b(n.this).bu(18, false);
        n.b(n.this).Ml(n.f(n.this));
        n.b(n.this).Ml(n.g(n.this));
        n.b(n.this).Ml(n.h(n.this));
        n.b(n.this).Ml(n.i(n.this));
        n.b(n.this).Ml(n.j(n.this));
        n.d(n.this, 0L);
        n.e(n.this, 0L);
        n.f(n.this, 0L);
        n.g(n.this, 0L);
        n.h(n.this, 0L);
        AppMethodBeat.o(227853);
      }
    });
    AppMethodBeat.o(227863);
  }
  
  public final void a(final l.a parama, float paramFloat)
  {
    AppMethodBeat.i(227857);
    final float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      queueEvent(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227848);
          if (!n.a(n.this))
          {
            AppMethodBeat.o(227848);
            return;
          }
          switch (n.7.oHq[parama.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(227848);
            return;
            n.b(n.this).kx(3, this.oHk);
            n.a(n.this, f);
            AppMethodBeat.o(227848);
            return;
            n.b(n.this).kx(0, this.oHk);
            n.b(n.this, f);
            AppMethodBeat.o(227848);
            return;
            n.b(n.this).kx(2, this.oHk * 2);
            n.c(n.this, f * 2.0F);
            AppMethodBeat.o(227848);
            return;
            n.b(n.this).kx(1, this.oHk);
            n.d(n.this, f);
          }
        }
      });
      AppMethodBeat.o(227857);
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  public final void a(final l.b paramb, final String paramString)
  {
    AppMethodBeat.i(227862);
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227852);
        if (!n.a(n.this))
        {
          AppMethodBeat.o(227852);
          return;
        }
        switch (n.7.cIK[paramb.ordinal()])
        {
        default: 
          AppMethodBeat.o(227852);
          return;
        case 1: 
          if (n.f(n.this) != 0L)
          {
            n.b(n.this).Ml(n.f(n.this));
            n.d(n.this, 0L);
          }
          n.b(n.this).bu(14, true);
          n.d(n.this, n.b(n.this).db(0, paramString));
          AppMethodBeat.o(227852);
          return;
        case 2: 
          if (n.g(n.this) != 0L)
          {
            n.b(n.this).Ml(n.g(n.this));
            n.e(n.this, 0L);
          }
          n.b(n.this).bu(15, true);
          n.e(n.this, n.b(n.this).db(1, paramString));
          AppMethodBeat.o(227852);
          return;
        case 3: 
          if (n.h(n.this) != 0L)
          {
            n.b(n.this).Ml(n.h(n.this));
            n.f(n.this, 0L);
          }
          n.b(n.this).bu(16, true);
          n.f(n.this, n.b(n.this).db(2, paramString));
          AppMethodBeat.o(227852);
          return;
        case 4: 
          if (n.i(n.this) != 0L)
          {
            n.b(n.this).Ml(n.i(n.this));
            n.g(n.this, 0L);
          }
          n.b(n.this).bu(17, true);
          n.g(n.this, n.b(n.this).db(3, paramString));
          AppMethodBeat.o(227852);
          return;
        }
        if (n.j(n.this) != 0L)
        {
          n.b(n.this).Ml(n.j(n.this));
          n.h(n.this, 0L);
        }
        n.b(n.this).bu(18, true);
        n.h(n.this, n.b(n.this).db(4, paramString));
        AppMethodBeat.o(227852);
      }
    });
    AppMethodBeat.o(227862);
  }
  
  public final void a(final l.c paramc, final String paramString)
  {
    AppMethodBeat.i(227859);
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227850);
        if (!n.a(n.this))
        {
          AppMethodBeat.o(227850);
          return;
        }
        e locale = new e();
        try
        {
          locale.bip(paramString);
          locale.au(h.FE(s.boY(paramString + "/config.json")));
          switch (n.7.oHr[paramc.ordinal()])
          {
          default: 
            AppMethodBeat.o(227850);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          AppMethodBeat.o(227850);
          return;
        }
        catch (IOException localIOException)
        {
          AppMethodBeat.o(227850);
          return;
        }
        if (n.c(n.this) != 0L)
        {
          n.b(n.this).Ml(n.c(n.this));
          n.a(n.this, 0L);
        }
        n.b(n.this).bu(12, true);
        n.a(n.this, n.b(n.this).a(localIOException));
        n.b(n.this).zG(true);
        AppMethodBeat.o(227850);
        return;
        if (n.d(n.this) != 0L)
        {
          n.b(n.this).Ml(n.d(n.this));
          n.b(n.this, 0L);
        }
        n.b(n.this).bu(13, true);
        n.b(n.this, n.b(n.this).a(localIOException));
        AppMethodBeat.o(227850);
        return;
        if (n.e(n.this) != 0L)
        {
          n.b(n.this).Ml(n.e(n.this));
          n.c(n.this, 0L);
        }
        n.b(n.this).bu(11, true);
        n.c(n.this, n.b(n.this).a(localIOException));
        AppMethodBeat.o(227850);
      }
    });
    AppMethodBeat.o(227859);
  }
  
  public final void b(final String paramString, float paramFloat)
  {
    AppMethodBeat.i(227858);
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
        AppMethodBeat.o(227858);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(227858);
        return;
      }
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227849);
        if (!n.a(n.this))
        {
          AppMethodBeat.o(227849);
          return;
        }
        n.b(n.this).m(paramString, f);
        n.a(n.this, paramString);
        AppMethodBeat.o(227849);
      }
    });
    AppMethodBeat.o(227858);
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(227860);
    b("", 0.0F);
    AppMethodBeat.o(227860);
  }
  
  public final boolean isEnabled()
  {
    return true;
  }
  
  public final void onDetectFacePoints(float[] paramArrayOfFloat) {}
  
  public final int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(227864);
    try
    {
      if (!this.isInit)
      {
        this.oGV = new b((byte)0);
        GLES30.glGenTextures(1, this.oHi, 0);
        GLES30.glBindTexture(3553, this.oHi[0]);
        GLES30.glTexParameteri(3553, 10241, 9729);
        GLES30.glTexParameteri(3553, 10240, 9728);
        GLES30.glTexParameteri(3553, 10242, 33071);
        GLES30.glTexParameteri(3553, 10243, 33071);
        GLES30.glBindTexture(3553, 0);
        this.isInit = true;
      }
      while (!this.hgk.isEmpty()) {
        ((Runnable)this.hgk.remove(0)).run();
      }
      if (this.oGW != 0.0F) {
        break label371;
      }
    }
    finally
    {
      AppMethodBeat.o(227864);
    }
    if ((this.oGX == 0.0F) && (this.oGY == 0.0F) && (this.oGZ == 0.0F) && (this.hDj.isEmpty()) && (this.oHa == 0L) && (this.oHb == 0L) && (this.oHc == 0L) && (this.oHd == 0L) && (this.oHe == 0L) && (this.oHf == 0L) && (this.oHg == 0L)) {
      if (this.oHh != 0L) {
        break label371;
      }
    }
    for (;;)
    {
      int i;
      if (i != 0)
      {
        GLES30.glBindTexture(3553, this.oHi[0]);
        GLES30.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
        this.oGV.setSize(paramInt2, paramInt3);
        this.oGV.kw(paramInt1, 0);
        b.a(this.oGV, paramInt1, this.oHi[0], false, 60);
        paramInt1 = this.oHi[0];
        AppMethodBeat.o(227864);
        return paramInt1;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(227864);
        return paramInt1;
        label371:
        i = 1;
      }
    }
  }
  
  public final void onTextureDestoryed()
  {
    AppMethodBeat.i(227865);
    try
    {
      if (this.isInit)
      {
        this.oGV.destroy();
        GLES30.glDeleteTextures(1, this.oHi, 0);
        this.isInit = false;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(227865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.n
 * JD-Core Version:    0.7.0.1
 */