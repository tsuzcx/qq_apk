package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import junit.framework.Assert;

public final class h
{
  public static final class b
    implements com.tencent.mm.ah.f
  {
    public int hYg = -10001;
    public String hYl;
    private h.a hYq = null;
    public String hYr = "";
    public final f hYs = new f();
    public String iconUrl = "";
    
    public final boolean a(h.a parama)
    {
      y.d("MicroMsg.PickBottle", "bottle pick:" + c.awG() + " throw:" + c.awF());
      if (this.hYq == null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("renew this class", bool);
        Assert.assertTrue("must call back onFin", true);
        if (c.awG() > 0) {
          break;
        }
        parama.cs(1, 16);
        return false;
      }
      au.Dk().a(155, this);
      au.Dk().a(156, this);
      this.hYq = parama;
      return au.Dk().a(this.hYs, 0);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
    {
      y.d("MicroMsg.PickBottle", "type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
      if (paramm.getType() == 155)
      {
        paramm = (f)paramm;
        if (!paramm.hYo)
        {
          if (this.hYq != null) {
            this.hYq.cs(paramInt1, paramInt2);
          }
          this.hYq = null;
          au.Dk().b(155, this);
          au.Dk().b(156, this);
        }
      }
      label176:
      while (paramm.getType() != 156)
      {
        return;
        au.Dk().b(155, this);
        a.eUS.tk();
        if (paramm.awK().twD == null)
        {
          paramString = "";
          this.hYl = paramString;
          this.hYg = paramm.awK().kSW;
          if (paramm.awK().tdT != null) {
            break label275;
          }
          paramString = "";
          paramString = bn.s(paramString, "branduser");
          if (paramString == null) {
            break label301;
          }
          this.hYr = ((String)paramString.get(".branduser.$username"));
          this.iconUrl = ((String)paramString.get(".branduser.$iconurl"));
          if (this.hYr == null) {
            break label301;
          }
          this.hYg = 19990;
          if (this.hYq != null)
          {
            if ((paramInt1 == 0) && (paramInt2 == 0)) {
              break label287;
            }
            this.hYq.cs(paramInt1, paramInt2);
          }
        }
        for (;;)
        {
          this.hYq = null;
          return;
          paramString = paramm.awK().twD;
          break;
          paramString = paramm.awK().tdT;
          break label176;
          this.hYq.cs(paramInt1, paramInt2);
        }
        paramString = new e(this.hYl, this.hYg);
        au.Dk().a(paramString, 0);
        return;
      }
      label275:
      label287:
      label301:
      au.Dk().b(156, this);
      if (this.hYq != null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label380;
        }
        this.hYq.cs(paramInt1, paramInt2);
      }
      for (;;)
      {
        this.hYq = null;
        return;
        label380:
        this.hYq.cs(paramInt1, paramInt2);
      }
    }
  }
  
  public static final class c
    implements com.tencent.mm.ah.f
  {
    private h.a hYq = null;
    private int hYt = 0;
    
    public c(String paramString, h.a parama)
    {
      boolean bool;
      if (!bk.bl(paramString))
      {
        bool = true;
        Assert.assertTrue("emtpy input text", bool);
        if (parama == null) {
          break label86;
        }
        bool = true;
        label35:
        Assert.assertTrue("must call back onFin", bool);
        if (c.awF() <= 0) {
          break label91;
        }
        au.Dk().a(154, this);
        this.hYq = parama;
        paramString = new g(paramString);
        au.Dk().a(paramString, 0);
      }
      label86:
      label91:
      while (parama == null)
      {
        return;
        bool = false;
        break;
        bool = false;
        break label35;
      }
      parama.cs(1, 16);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
    {
      if (paramm.getType() != 154) {
        return;
      }
      if (this.hYq != null)
      {
        this.hYt = ((g)paramm).awL();
        this.hYq.cs(paramInt1, paramInt2);
      }
      this.hYq = null;
      au.Dk().b(154, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.h
 * JD-Core Version:    0.7.0.1
 */