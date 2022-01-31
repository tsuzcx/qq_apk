package com.tencent.mm.console;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;

final class b$4$1
  implements Runnable
{
  b$4$1(b.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(16080);
    try
    {
      Object localObject1 = this.etZ.byh.substring(10);
      String str1 = com.tencent.mm.compatible.util.e.eQx;
      aw.aaz();
      Object localObject2 = c.getAccPath();
      String str2 = (String)localObject2 + (String)localObject1;
      String str3 = str2.substring(str1.length());
      ab.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", new Object[] { localObject1, str1, localObject2, str2, str3 });
      int i = 0;
      while (i < this.etZ.etV)
      {
        localObject1 = ((bd.a)this.etZ.etW.get(i)).yqc;
        if ((!bo.isNullOrNil((String)localObject1)) && (!str1.contains((CharSequence)localObject1)))
        {
          localObject1 = new b((String)localObject1 + str3);
          if ((((b)localObject1).exists()) && (((b)localObject1).isDirectory()))
          {
            localObject2 = new b(str2);
            if (!((b)localObject2).exists()) {
              ((b)localObject2).mkdirs();
            }
            boolean bool = com.tencent.mm.vfs.e.iF(j.p(((b)localObject1).dQJ()), j.p(((b)localObject2).dQJ()));
            ab.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", new Object[] { j.p(((b)localObject2).dQJ()), j.p(((b)localObject1).dQJ()), Boolean.valueOf(bool) });
            if (bool)
            {
              new ak(Looper.getMainLooper()).post(new b.4.1.1(this));
              AppMethodBeat.o(16080);
              return;
            }
          }
        }
        i += 1;
      }
      new ak(Looper.getMainLooper()).post(new b.4.1.2(this));
      AppMethodBeat.o(16080);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(16080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.b.4.1
 * JD-Core Version:    0.7.0.1
 */