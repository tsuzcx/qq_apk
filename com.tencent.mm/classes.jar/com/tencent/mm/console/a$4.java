package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SdcardUtil.StatMountParse;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;

final class a$4
  implements DialogInterface.OnClickListener
{
  a$4(String paramString, int paramInt, ArrayList paramArrayList, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20113);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20112);
        try
        {
          Object localObject1 = a.4.this.val$msg.substring(10);
          String str1 = b.bmt();
          bh.bCz();
          Object localObject2 = c.getAccPath();
          String str2 = (String)localObject2 + (String)localObject1;
          String str3 = str2.substring(str1.length());
          Log.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", new Object[] { localObject1, str1, localObject2, str2, str3 });
          int i = 0;
          while (i < a.4.this.lZX)
          {
            localObject1 = ((SdcardUtil.StatMountParse)a.4.this.val$list.get(i)).mountDir;
            if ((!Util.isNullOrNil((String)localObject1)) && (!str1.contains((CharSequence)localObject1)))
            {
              localObject1 = new u((String)localObject1 + str3);
              if ((((u)localObject1).jKS()) && (((u)localObject1).isDirectory()))
              {
                localObject2 = new u(str2);
                if (!((u)localObject2).jKS()) {
                  ((u)localObject2).jKY();
                }
                boolean bool = y.qo(ah.v(((u)localObject1).jKT()), ah.v(((u)localObject2).jKT()));
                Log.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", new Object[] { ah.v(((u)localObject2).jKT()), ah.v(((u)localObject1).jKT()), Boolean.valueOf(bool) });
                if (bool)
                {
                  new MMHandler(Looper.getMainLooper()).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(20110);
                      k.cZ(a.4.this.val$context, a.4.this.val$context.getString(R.l.gDx));
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
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(20111);
              k.cZ(a.4.this.val$context, a.4.this.val$context.getString(R.l.gDw));
              AppMethodBeat.o(20111);
            }
          });
          AppMethodBeat.o(20112);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(20112);
        }
      }
    });
    AppMethodBeat.o(20113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.console.a.4
 * JD-Core Version:    0.7.0.1
 */