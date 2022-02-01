package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;

final class b$4
  implements DialogInterface.OnClickListener
{
  b$4(String paramString, int paramInt, ArrayList paramArrayList, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20113);
    com.tencent.e.h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20112);
        try
        {
          Object localObject1 = b.4.this.val$msg.substring(10);
          String str1 = b.arO();
          ba.aBQ();
          Object localObject2 = c.getAccPath();
          String str2 = (String)localObject2 + (String)localObject1;
          String str3 = str2.substring(str1.length());
          ad.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", new Object[] { localObject1, str1, localObject2, str2, str3 });
          int i = 0;
          while (i < b.4.this.geC)
          {
            localObject1 = ((bi.a)b.4.this.val$list.get(i)).IfT;
            if ((!bt.isNullOrNil((String)localObject1)) && (!str1.contains((CharSequence)localObject1)))
            {
              localObject1 = new e((String)localObject1 + str3);
              if ((((e)localObject1).exists()) && (((e)localObject1).isDirectory()))
              {
                localObject2 = new e(str2);
                if (!((e)localObject2).exists()) {
                  ((e)localObject2).mkdirs();
                }
                boolean bool = com.tencent.mm.vfs.i.mB(q.B(((e)localObject1).fOK()), q.B(((e)localObject2).fOK()));
                ad.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", new Object[] { q.B(((e)localObject2).fOK()), q.B(((e)localObject1).fOK()), Boolean.valueOf(bool) });
                if (bool)
                {
                  new ap(Looper.getMainLooper()).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(20110);
                      com.tencent.mm.ui.base.h.cl(b.4.this.val$context, b.4.this.val$context.getString(2131757948));
                      AppMethodBeat.o(20110);
                    }
                  });
                  AppMethodBeat.o(20112);
                  return;
                }
              }
            }
            i += 1;
          }
          new ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(20111);
              com.tencent.mm.ui.base.h.cl(b.4.this.val$context, b.4.this.val$context.getString(2131757947));
              AppMethodBeat.o(20111);
            }
          });
          AppMethodBeat.o(20112);
          return;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(20112);
        }
      }
    });
    AppMethodBeat.o(20113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.b.4
 * JD-Core Version:    0.7.0.1
 */