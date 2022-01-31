package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.f.b.h;
import com.tencent.mm.model.au;
import junit.framework.Assert;

public final class h$d
  extends h
  implements f
{
  public h.a hYq = null;
  private int hYt = 0;
  
  public h$d(Context paramContext, h.a parama)
  {
    super(paramContext, false);
    if (parama != null) {
      bool = true;
    }
    Assert.assertTrue("must call back onFin", bool);
    au.Dk().a(154, this);
    this.hYq = parama;
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
  
  public final boolean un()
  {
    Object localObject = super.getFileName();
    boolean bool = super.un();
    super.reset();
    if (!bool)
    {
      au.Dk().b(154, this);
      this.hYq = null;
    }
    do
    {
      return false;
      if (c.awF() > 0)
      {
        localObject = new g((String)localObject, this.bDF);
        au.Dk().a((m)localObject, 0);
        return true;
      }
      au.Dk().b(154, this);
    } while (this.hYq == null);
    this.hYq.cs(1, 16);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.h.d
 * JD-Core Version:    0.7.0.1
 */