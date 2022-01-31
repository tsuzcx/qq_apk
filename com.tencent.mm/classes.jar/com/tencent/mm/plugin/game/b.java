package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.h.a.kp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.game.model.b.a;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements com.tencent.mm.plugin.game.a.a
{
  public final void S(String paramString, int paramInt1, int paramInt2)
  {
    c.dCx.f(paramString, paramInt1, paramInt2);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    c.dCx.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, 0L, paramString5);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    c.dCx.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    c.dCx.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong)
  {
    c.dCx.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramLong);
  }
  
  public final boolean aXZ()
  {
    try
    {
      boolean bool = com.tencent.mm.plugin.game.commlib.a.aYk();
      return bool;
    }
    catch (Exception localException) {}
    return true;
  }
  
  public final String aYa()
  {
    return f.dw(ae.getContext());
  }
  
  public final void dm(Context paramContext)
  {
    f.dm(paramContext);
  }
  
  public final void gt(boolean paramBoolean)
  {
    if ((!((com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.jIa, false)) || (!((com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.jIc, false))) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (com.b.a.a.b.X(ae.getContext()) < 2014)
        {
          y.i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
          return;
        }
        long l = f.aZf();
        if (System.currentTimeMillis() - l <= 21600000L) {
          break;
        }
        y.i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
      } while (!paramBoolean);
      ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
      localObject = r.aZn();
      if (System.currentTimeMillis() - ((o)localObject).field_receiveTime * 1000L > 21600000L)
      {
        y.i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
        return;
      }
      if (e.cqq())
      {
        y.i("MicroMsg.GameDelegateImpl", "isGPVersion");
        return;
      }
      localObject = com.tencent.mm.plugin.game.model.b.sd(901);
    } while ((((b.a)localObject).bcw != 2) || (bk.bl(((b.a)localObject).url)));
    y.i("MicroMsg.GameDelegateImpl", "preload");
    kp localkp = new kp();
    localkp.bTG.type = 3;
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", ((b.a)localObject).url);
    localkp.bTG.intent = localIntent;
    com.tencent.mm.sdk.b.a.udP.m(localkp);
  }
  
  public final void h(Context paramContext, String paramString1, String paramString2)
  {
    c.dCx.h(paramContext, paramString1, paramString2);
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    c.dCx.k(paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b
 * JD-Core Version:    0.7.0.1
 */