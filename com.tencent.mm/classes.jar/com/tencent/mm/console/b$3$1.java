package com.tencent.mm.console;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(16076);
    try
    {
      String str1 = com.tencent.mm.compatible.util.e.eQx;
      aw.aaz();
      String str2 = c.YR();
      aw.aaz();
      Object localObject = c.Yv();
      String str3 = str2.substring(str1.length());
      ab.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", new Object[] { Integer.valueOf(this.etX.etV), str1, str2, localObject, str3 });
      int i = 0;
      while (i < this.etX.etV)
      {
        localObject = ((bd.a)this.etX.etW.get(i)).yqc;
        if ((!bo.isNullOrNil((String)localObject)) && (!str1.contains((CharSequence)localObject)))
        {
          localObject = new b((String)localObject + str3);
          if ((((b)localObject).exists()) && (((b)localObject).isDirectory()))
          {
            boolean bool = com.tencent.mm.vfs.e.iF(j.p(((b)localObject).dQJ()), str2);
            ab.i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", new Object[] { str2, j.p(((b)localObject).dQJ()), Boolean.valueOf(bool) });
            if (bool)
            {
              new ak(Looper.getMainLooper()).post(new b.3.1.1(this));
              AppMethodBeat.o(16076);
              return;
            }
          }
        }
        i += 1;
      }
      new ak(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(16075);
          h.bO(b.3.1.this.etX.val$context, b.3.1.this.etX.val$context.getString(2131298868));
          AppMethodBeat.o(16075);
        }
      });
      AppMethodBeat.o(16076);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(16076);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.console.b.3.1
 * JD-Core Version:    0.7.0.1
 */