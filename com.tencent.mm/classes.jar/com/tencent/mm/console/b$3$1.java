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

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3) {}
  
  public final void run()
  {
    for (;;)
    {
      int i;
      try
      {
        String str1 = com.tencent.mm.compatible.util.e.bkF;
        au.Hx();
        String str2 = c.FN();
        au.Hx();
        Object localObject = c.Fr();
        String str3 = str2.substring(str1.length());
        y.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", new Object[] { Integer.valueOf(this.dAv.dAt), str1, str2, localObject, str3 });
        i = 0;
        if (i < this.dAv.dAt)
        {
          localObject = ((az.a)this.dAv.dAu.get(i)).uhW;
          if ((!bk.bl((String)localObject)) && (!str1.contains((CharSequence)localObject)))
          {
            localObject = new b((String)localObject + str3);
            if ((((b)localObject).exists()) && (((b)localObject).isDirectory()))
            {
              boolean bool = com.tencent.mm.vfs.e.gC(j.n(((b)localObject).cLr()), str2);
              y.i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", new Object[] { str2, j.n(((b)localObject).cLr()), Boolean.valueOf(bool) });
              if (bool) {
                new ah(Looper.getMainLooper()).post(new b.3.1.1(this));
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
              h.bC(b.3.1.this.dAv.val$context, b.3.1.this.dAv.val$context.getString(R.l.copy_acc_fail));
            }
          });
          return;
        }
      }
      catch (Exception localException)
      {
        y.w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", new Object[] { localException.getMessage() });
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.console.b.3.1
 * JD-Core Version:    0.7.0.1
 */