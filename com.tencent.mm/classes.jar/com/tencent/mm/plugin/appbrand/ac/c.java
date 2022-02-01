package com.tencent.mm.plugin.appbrand.ac;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static LinkedList<e> gCs;
  private static boolean iGo;
  private static HashSet<a> ogq;
  private static boolean ogr;
  
  static
  {
    AppMethodBeat.i(121091);
    gCs = new LinkedList();
    ogq = new HashSet();
    iGo = false;
    ogr = false;
    AppMethodBeat.o(121091);
  }
  
  protected static String a(ca paramca, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(121089);
    if (paramca.field_isSend == 1)
    {
      paramca = z.aTY();
      AppMethodBeat.o(121089);
      return paramca;
    }
    String str = null;
    if (paramBoolean) {
      str = bp.Ks(paramca.field_content);
    }
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(121089);
      return paramString;
      paramString = str;
    }
  }
  
  public static void a(String paramString, a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(121087);
        if (iGo)
        {
          ogq.add(parama);
          AppMethodBeat.o(121087);
          return;
        }
        if (ogr)
        {
          parama.A(gCs);
          AppMethodBeat.o(121087);
          continue;
        }
        iGo = true;
      }
      finally {}
      ogq.add(parama);
      g.aAi();
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121085);
          c.TE().clear();
          if (ab.Eq(this.gMw)) {}
          label507:
          Object localObject2;
          for (ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.gMw);; localObject2 = null)
          {
            int i = 100;
            int j = 0;
            while (i >= 100)
            {
              Cursor localCursor = ((l)g.af(l.class)).eiy().eA(this.gMw, j);
              if (localCursor != null) {}
              for (;;)
              {
                Object localObject3;
                try
                {
                  i = localCursor.getCount();
                  if ((localCursor == null) || (!localCursor.moveToNext())) {
                    break;
                  }
                  ca localca = new ca();
                  localca.setMsgId(localCursor.getLong(0));
                  localca.yF(localCursor.getLong(1));
                  localca.setCreateTime(localCursor.getLong(2));
                  localca.setContent(localCursor.getString(3));
                  localca.nv(localCursor.getInt(4));
                  localca.Cz(localCursor.getString(5));
                  str = localca.field_content;
                  if (str == null) {
                    continue;
                  }
                  k.b localb = k.b.HD(str);
                  if ((localb == null) || (!c.zA(localb.type))) {
                    continue;
                  }
                  Object localObject4 = c.a(localca, ab.Eq(this.gMw), this.gMw);
                  localObject3 = ((l)g.af(l.class)).aSN().Kn((String)localObject4);
                  str = "";
                  if (localah != null) {
                    str = localah.getDisplayName((String)localObject4);
                  }
                  localObject3 = new e(localca.field_createTime, localb.type, localb.title, localca.field_msgId, ((ax)localObject3).field_username, ((as)localObject3).arI(), ((ax)localObject3).field_conRemark, str, Util.nullAs(localb.izj, localb.appId), localb, localca.field_msgSvrId);
                  ((e)localObject3).desc = localb.title;
                  localObject4 = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(((e)localObject3).dXm.izi);
                  if (localObject4 == null) {
                    break label507;
                  }
                  str = ((WxaAttributes)localObject4).field_nickname;
                  ((e)localObject3).title = str;
                  if (localObject4 == null) {
                    break label520;
                  }
                  str = ((WxaAttributes)localObject4).field_brandIconURL;
                  ((e)localObject3).imagePath = str;
                  if (localb.izk != 1)
                  {
                    str = com.tencent.mm.av.q.bcR().d(localca.field_imgPath, false, true);
                    if (!Util.isNullOrNil(str)) {
                      ((e)localObject3).ogu = "file://".concat(String.valueOf(str));
                    }
                  }
                  c.TE().add(localObject3);
                  continue;
                  i = 0;
                }
                finally
                {
                  if (localCursor != null) {
                    localCursor.close();
                  }
                  AppMethodBeat.o(121085);
                }
                continue;
                String str = ((e)localObject3).dXm.eah;
                continue;
                label520:
                str = ((e)localObject3).dXm.izB;
              }
              if (localCursor != null) {
                localCursor.close();
              }
              j += i;
            }
            Log.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", new Object[] { Integer.valueOf(c.TE().size()) });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(121084);
                c.access$100();
                AppMethodBeat.o(121084);
              }
            });
            AppMethodBeat.o(121085);
            return;
          }
        }
      });
      AppMethodBeat.o(121087);
    }
  }
  
  private static void done()
  {
    try
    {
      AppMethodBeat.i(121088);
      Log.i("MicroMsg.AppBrandHistoryListLogic", "done");
      ogr = true;
      iGo = false;
      Iterator localIterator = ogq.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.A(gCs);
        }
      }
      ogq.clear();
    }
    finally {}
    AppMethodBeat.o(121088);
  }
  
  public static void reset()
  {
    try
    {
      AppMethodBeat.i(121086);
      iGo = false;
      ogr = false;
      gCs.clear();
      ogq.clear();
      AppMethodBeat.o(121086);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean zA(int paramInt)
  {
    return (33 == paramInt) || (36 == paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void A(LinkedList<e> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.c
 * JD-Core Version:    0.7.0.1
 */