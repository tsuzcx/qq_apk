package com.tencent.mm.app;

import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.d.a.4;
import com.tencent.mm.model.d.b;
import com.tencent.mm.model.d.b.1;
import com.tencent.mm.model.d.c;
import com.tencent.mm.model.d.c.1;
import com.tencent.mm.model.d.c.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.k;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class m
{
  public static m bwV;
  public boolean bwW;
  public ah bwX = new ah(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      Object localObject;
      if (paramAnonymousMessage.what == -1999) {
        if (!m.this.bwW)
        {
          paramAnonymousMessage = LauncherUI.cyX();
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.uKS))
          {
            paramAnonymousMessage.uKP.uKi.acW("tab_main");
            localObject = paramAnonymousMessage.uKP;
            if (((HomeUI)localObject).uJU) {
              ((HomeUI)localObject).uJW = true;
            }
            localObject = n.omC;
            if (localObject != null) {
              ((f)localObject).bCm();
            }
            paramAnonymousMessage = paramAnonymousMessage.uKP.uKi.uOR.values().iterator();
            while (paramAnonymousMessage.hasNext())
            {
              localObject = (Fragment)paramAnonymousMessage.next();
              if (!(localObject instanceof k)) {
                ((o)localObject).cxM();
              }
            }
          }
          System.gc();
        }
      }
      while ((paramAnonymousMessage.what != -2999) || (m.this.bwW)) {
        return;
      }
      paramAnonymousMessage = LauncherUI.cyX();
      if (paramAnonymousMessage != null)
      {
        paramAnonymousMessage = paramAnonymousMessage.uKP.uKi;
        if (paramAnonymousMessage.uOR.containsKey(Integer.valueOf(0))) {
          ((o)paramAnonymousMessage.uOR.get(Integer.valueOf(0))).cxM();
        }
      }
      if (g.DN().Dc())
      {
        au.Hq();
        paramAnonymousMessage = bu.iR("plugin.emoji");
        if (paramAnonymousMessage != null) {
          paramAnonymousMessage.gf(0);
        }
        paramAnonymousMessage = b.Jg();
        localObject = com.tencent.mm.model.d.a.Ja();
        c localc = c.Ji();
        au.DS().O(new b.1(paramAnonymousMessage));
        au.DS().O(new a.4((com.tencent.mm.model.d.a)localObject));
        localc.a(paramAnonymousMessage);
        localc.a((c.a)localObject);
        au.DS().O(new c.1(localc));
      }
      System.gc();
    }
  };
  
  public static m sZ()
  {
    if (bwV == null) {
      bwV = new m();
    }
    return bwV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.m
 * JD-Core Version:    0.7.0.1
 */