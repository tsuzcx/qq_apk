package com.tencent.mm.console;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;

final class b$4$1
  implements Runnable
{
  b$4$1(b.4 param4) {}
  
  public final void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = this.dAx.bhH.substring(10);
        String str1 = com.tencent.mm.compatible.util.e.bkF;
        au.Hx();
        Object localObject2 = c.FU();
        String str2 = (String)localObject2 + (String)localObject1;
        String str3 = str2.substring(str1.length());
        y.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", new Object[] { localObject1, str1, localObject2, str2, str3 });
        i = 0;
        if (i < this.dAx.dAt)
        {
          localObject1 = ((az.a)this.dAx.dAu.get(i)).uhW;
          if ((!bk.bl((String)localObject1)) && (!str1.contains((CharSequence)localObject1)))
          {
            localObject1 = new b((String)localObject1 + str3);
            if ((((b)localObject1).exists()) && (((b)localObject1).isDirectory()))
            {
              localObject2 = new b(str2);
              if (!((b)localObject2).exists()) {
                ((b)localObject2).mkdirs();
              }
              boolean bool = com.tencent.mm.vfs.e.gC(j.n(((b)localObject1).cLr()), j.n(((b)localObject2).cLr()));
              y.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", new Object[] { j.n(((b)localObject2).cLr()), j.n(((b)localObject1).cLr()), Boolean.valueOf(bool) });
              if (bool) {
                new ah(Looper.getMainLooper()).post(new b.4.1.1(this));
              }
            }
          }
        }
        else
        {
          new ah(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              h.bC(b.4.1.this.dAx.val$context, b.4.1.this.dAx.val$context.getString(R.l.copy_acc_fail));
            }
          });
          return;
        }
      }
      catch (Exception localException)
      {
        y.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", new Object[] { localException.getMessage() });
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.b.4.1
 * JD-Core Version:    0.7.0.1
 */