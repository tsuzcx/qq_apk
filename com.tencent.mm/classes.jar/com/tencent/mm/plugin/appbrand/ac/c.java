package com.tencent.mm.plugin.appbrand.ac;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
  private static LinkedList<e> jmy;
  private static boolean lwq;
  private static HashSet<a> ric;
  private static boolean rid;
  
  static
  {
    AppMethodBeat.i(121091);
    jmy = new LinkedList();
    ric = new HashSet();
    lwq = false;
    rid = false;
    AppMethodBeat.o(121091);
  }
  
  public static boolean Df(int paramInt)
  {
    return (33 == paramInt) || (36 == paramInt);
  }
  
  protected static String a(ca paramca, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(121089);
    if (paramca.field_isSend == 1)
    {
      paramca = z.bcZ();
      AppMethodBeat.o(121089);
      return paramca;
    }
    String str = null;
    if (paramBoolean) {
      str = bq.RL(paramca.field_content);
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
        if (lwq)
        {
          ric.add(parama);
          AppMethodBeat.o(121087);
          return;
        }
        if (rid)
        {
          parama.B(jmy);
          AppMethodBeat.o(121087);
          continue;
        }
        lwq = true;
      }
      finally {}
      ric.add(parama);
      h.aHH();
      h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121085);
          c.Yi().clear();
          if (ab.Lj(this.jwL)) {}
          label507:
          Object localObject2;
          for (ah localah = ((b)h.ae(b.class)).bbV().Rw(this.jwL);; localObject2 = null)
          {
            int i = 100;
            int j = 0;
            while (i >= 100)
            {
              Cursor localCursor = ((n)h.ae(n.class)).eSe().fb(this.jwL, j);
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
                  localca.EG(localCursor.getLong(1));
                  localca.setCreateTime(localCursor.getLong(2));
                  localca.setContent(localCursor.getString(3));
                  localca.pJ(localCursor.getInt(4));
                  localca.Jn(localCursor.getString(5));
                  str = localca.field_content;
                  if (str == null) {
                    continue;
                  }
                  k.b localb = k.b.OQ(str);
                  if ((localb == null) || (!c.Df(localb.type))) {
                    continue;
                  }
                  Object localObject4 = c.a(localca, ab.Lj(this.jwL), this.jwL);
                  localObject3 = ((n)h.ae(n.class)).bbL().RG((String)localObject4);
                  str = "";
                  if (localah != null) {
                    str = localah.PJ((String)localObject4);
                  }
                  localObject3 = new e(localca.field_createTime, localb.type, localb.title, localca.field_msgId, ((ax)localObject3).field_username, ((as)localObject3).ayr(), ((ax)localObject3).field_conRemark, str, Util.nullAs(localb.loB, localb.appId), localb, localca.field_msgSvrId);
                  ((e)localObject3).desc = localb.title;
                  localObject4 = ((com.tencent.mm.plugin.appbrand.service.q)h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(((e)localObject3).fQY.loA);
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
                  if (localb.loC != 1)
                  {
                    str = com.tencent.mm.ay.q.bmh().d(localca.field_imgPath, false, true);
                    if (!Util.isNullOrNil(str)) {
                      ((e)localObject3).rig = "file://".concat(String.valueOf(str));
                    }
                  }
                  c.Yi().add(localObject3);
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
                String str = ((e)localObject3).fQY.fUe;
                continue;
                label520:
                str = ((e)localObject3).fQY.loV;
              }
              if (localCursor != null) {
                localCursor.close();
              }
              j += i;
            }
            Log.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", new Object[] { Integer.valueOf(c.Yi().size()) });
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
      rid = true;
      lwq = false;
      Iterator localIterator = ric.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.B(jmy);
        }
      }
      ric.clear();
    }
    finally {}
    AppMethodBeat.o(121088);
  }
  
  public static void reset()
  {
    try
    {
      AppMethodBeat.i(121086);
      lwq = false;
      rid = false;
      jmy.clear();
      ric.clear();
      AppMethodBeat.o(121086);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static abstract interface a
  {
    public abstract void B(LinkedList<e> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.c
 * JD-Core Version:    0.7.0.1
 */