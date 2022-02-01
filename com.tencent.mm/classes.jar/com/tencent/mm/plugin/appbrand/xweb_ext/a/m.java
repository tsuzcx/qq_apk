package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.opengl.GLES30;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.plugin.xlabeffect.k.d;
import com.tencent.mm.sticker.e;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;

public final class m
  implements o
{
  private boolean isInit;
  private String mUY;
  private ArrayList<Runnable> msu;
  private k uUb;
  private float uUc;
  private float uUd;
  private float uUe;
  private float uUf;
  private long uUg;
  private long uUh;
  private long uUi;
  private long uUj;
  private long uUk;
  private long uUl;
  private long uUm;
  private long uUn;
  private int[] uUo;
  
  public m()
  {
    AppMethodBeat.i(317114);
    this.uUb = null;
    this.isInit = false;
    this.uUc = 0.0F;
    this.uUd = 0.0F;
    this.uUe = 0.0F;
    this.uUf = 0.0F;
    this.mUY = "";
    this.uUg = 0L;
    this.uUh = 0L;
    this.uUi = 0L;
    this.uUj = 0L;
    this.uUk = 0L;
    this.uUl = 0L;
    this.uUm = 0L;
    this.uUn = 0L;
    this.uUo = new int[1];
    this.msu = new ArrayList();
    AppMethodBeat.o(317114);
  }
  
  private void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(317120);
    try
    {
      this.msu.add(paramRunnable);
      return;
    }
    finally
    {
      AppMethodBeat.o(317120);
    }
  }
  
  public final void a(final o.a parama, float paramFloat)
  {
    AppMethodBeat.i(317188);
    final float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      ag(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(317139);
          if (!m.a(m.this))
          {
            AppMethodBeat.o(317139);
            return;
          }
          switch (m.7.uUw[parama.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(317139);
            return;
            m.b(m.this).a(3, this.uUq, k.d.XLM);
            m.a(m.this, f);
            AppMethodBeat.o(317139);
            return;
            m.b(m.this).a(0, this.uUq, k.d.XLM);
            m.b(m.this, f);
            AppMethodBeat.o(317139);
            return;
            m.b(m.this).a(2, this.uUq * 2, k.d.XLM);
            m.c(m.this, f * 2.0F);
            AppMethodBeat.o(317139);
            return;
            m.b(m.this).a(1, this.uUq, k.d.XLM);
            m.d(m.this, f);
          }
        }
      });
      AppMethodBeat.o(317188);
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  public final void a(final o.b paramb, final String paramString)
  {
    AppMethodBeat.i(317208);
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317146);
        if (!m.a(m.this))
        {
          AppMethodBeat.o(317146);
          return;
        }
        switch (m.7.eCV[paramb.ordinal()])
        {
        default: 
          AppMethodBeat.o(317146);
          return;
        case 1: 
          if (m.f(m.this) != 0L)
          {
            m.b(m.this).xV(m.f(m.this));
            m.d(m.this, 0L);
          }
          m.b(m.this).co(14, true);
          m.d(m.this, m.b(m.this).dT(0, paramString));
          AppMethodBeat.o(317146);
          return;
        case 2: 
          if (m.g(m.this) != 0L)
          {
            m.b(m.this).xV(m.g(m.this));
            m.e(m.this, 0L);
          }
          m.b(m.this).co(15, true);
          m.e(m.this, m.b(m.this).dT(1, paramString));
          AppMethodBeat.o(317146);
          return;
        case 3: 
          if (m.h(m.this) != 0L)
          {
            m.b(m.this).xV(m.h(m.this));
            m.f(m.this, 0L);
          }
          m.b(m.this).co(16, true);
          m.f(m.this, m.b(m.this).dT(2, paramString));
          AppMethodBeat.o(317146);
          return;
        case 4: 
          if (m.i(m.this) != 0L)
          {
            m.b(m.this).xV(m.i(m.this));
            m.g(m.this, 0L);
          }
          m.b(m.this).co(17, true);
          m.g(m.this, m.b(m.this).dT(3, paramString));
          AppMethodBeat.o(317146);
          return;
        }
        if (m.j(m.this) != 0L)
        {
          m.b(m.this).xV(m.j(m.this));
          m.h(m.this, 0L);
        }
        m.b(m.this).co(18, true);
        m.h(m.this, m.b(m.this).dT(4, paramString));
        AppMethodBeat.o(317146);
      }
    });
    AppMethodBeat.o(317208);
  }
  
  public final void a(final o.c paramc, final String paramString)
  {
    AppMethodBeat.i(317196);
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317135);
        if (!m.a(m.this))
        {
          AppMethodBeat.o(317135);
          return;
        }
        e locale = new e();
        try
        {
          locale.buM(paramString);
          locale.G(h.Fn(y.bEn(paramString + "/config.json")));
          switch (m.7.uUx[paramc.ordinal()])
          {
          default: 
            AppMethodBeat.o(317135);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          AppMethodBeat.o(317135);
          return;
        }
        catch (IOException localIOException)
        {
          AppMethodBeat.o(317135);
          return;
        }
        if (m.c(m.this) != 0L)
        {
          m.b(m.this).xV(m.c(m.this));
          m.a(m.this, 0L);
        }
        m.b(m.this).co(12, true);
        m.a(m.this, m.b(m.this).a(localIOException));
        m.b(m.this).Jo(true);
        AppMethodBeat.o(317135);
        return;
        if (m.d(m.this) != 0L)
        {
          m.b(m.this).xV(m.d(m.this));
          m.b(m.this, 0L);
        }
        m.b(m.this).co(13, true);
        m.b(m.this, m.b(m.this).a(localIOException));
        AppMethodBeat.o(317135);
        return;
        if (m.e(m.this) != 0L)
        {
          m.b(m.this).xV(m.e(m.this));
          m.c(m.this, 0L);
        }
        m.b(m.this).co(11, true);
        m.c(m.this, m.b(m.this).a(localIOException));
        AppMethodBeat.o(317135);
      }
    });
    AppMethodBeat.o(317196);
  }
  
  public final void aul()
  {
    AppMethodBeat.i(317205);
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317133);
        if (!m.a(m.this))
        {
          AppMethodBeat.o(317133);
          return;
        }
        m.b(m.this).xV(m.c(m.this));
        m.b(m.this).co(12, false);
        m.b(m.this).xV(m.d(m.this));
        m.b(m.this).co(13, false);
        m.b(m.this).xV(m.e(m.this));
        m.b(m.this).co(11, false);
        m.b(m.this).Jo(false);
        m.a(m.this, 0L);
        m.b(m.this, 0L);
        m.c(m.this, 0L);
        AppMethodBeat.o(317133);
      }
    });
    AppMethodBeat.o(317205);
  }
  
  public final void aum()
  {
    AppMethodBeat.i(317211);
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317141);
        if (!m.a(m.this))
        {
          AppMethodBeat.o(317141);
          return;
        }
        m.b(m.this).co(14, false);
        m.b(m.this).co(15, false);
        m.b(m.this).co(16, false);
        m.b(m.this).co(17, false);
        m.b(m.this).co(18, false);
        m.b(m.this).xV(m.f(m.this));
        m.b(m.this).xV(m.g(m.this));
        m.b(m.this).xV(m.h(m.this));
        m.b(m.this).xV(m.i(m.this));
        m.b(m.this).xV(m.j(m.this));
        m.d(m.this, 0L);
        m.e(m.this, 0L);
        m.f(m.this, 0L);
        m.g(m.this, 0L);
        m.h(m.this, 0L);
        AppMethodBeat.o(317141);
      }
    });
    AppMethodBeat.o(317211);
  }
  
  public final void c(final String paramString, float paramFloat)
  {
    AppMethodBeat.i(317191);
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
        AppMethodBeat.o(317191);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(317191);
        return;
      }
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317140);
        if (!m.a(m.this))
        {
          AppMethodBeat.o(317140);
          return;
        }
        m.b(m.this).n(paramString, f);
        m.a(m.this, paramString);
        AppMethodBeat.o(317140);
      }
    });
    AppMethodBeat.o(317191);
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(317202);
    c("", 0.0F);
    AppMethodBeat.o(317202);
  }
  
  public final boolean isEnabled()
  {
    return true;
  }
  
  public final void onDetectFacePoints(float[] paramArrayOfFloat) {}
  
  public final int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(317213);
    try
    {
      if (!this.isInit)
      {
        this.uUb = new k();
        GLES30.glGenTextures(1, this.uUo, 0);
        GLES30.glBindTexture(3553, this.uUo[0]);
        GLES30.glTexParameteri(3553, 10241, 9729);
        GLES30.glTexParameteri(3553, 10240, 9728);
        GLES30.glTexParameteri(3553, 10242, 33071);
        GLES30.glTexParameteri(3553, 10243, 33071);
        GLES30.glBindTexture(3553, 0);
        this.uUb.XLr.jFp = 2;
        this.isInit = true;
      }
      while (!this.msu.isEmpty()) {
        ((Runnable)this.msu.remove(0)).run();
      }
      if (this.uUc != 0.0F) {
        break label381;
      }
    }
    finally
    {
      AppMethodBeat.o(317213);
    }
    if ((this.uUd == 0.0F) && (this.uUe == 0.0F) && (this.uUf == 0.0F) && (this.mUY.isEmpty()) && (this.uUg == 0L) && (this.uUh == 0L) && (this.uUi == 0L) && (this.uUj == 0L) && (this.uUk == 0L) && (this.uUl == 0L) && (this.uUm == 0L)) {
      if (this.uUn != 0L) {
        break label381;
      }
    }
    for (;;)
    {
      int i;
      if (i != 0)
      {
        GLES30.glBindTexture(3553, this.uUo[0]);
        GLES30.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
        this.uUb.setSize(paramInt2, paramInt3);
        this.uUb.nB(paramInt1, 0);
        k.a(this.uUb, paramInt1, this.uUo[0], false, 60);
        paramInt1 = this.uUo[0];
        AppMethodBeat.o(317213);
        return paramInt1;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(317213);
        return paramInt1;
        label381:
        i = 1;
      }
    }
  }
  
  public final void onTextureDestoryed()
  {
    AppMethodBeat.i(317220);
    try
    {
      if (this.isInit)
      {
        this.uUb.destroy();
        GLES30.glDeleteTextures(1, this.uUo, 0);
        this.isInit = false;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(317220);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.m
 * JD-Core Version:    0.7.0.1
 */