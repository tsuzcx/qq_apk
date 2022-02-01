package com.tencent.mm.plugin.appbrand.z;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static LinkedList<e> fBS;
  private static HashSet<a> mnG;
  private static boolean mnH;
  private static boolean mnI;
  
  static
  {
    AppMethodBeat.i(121091);
    fBS = new LinkedList();
    mnG = new HashSet();
    mnH = false;
    mnI = false;
    AppMethodBeat.o(121091);
  }
  
  protected static String a(bo parambo, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(121089);
    if (parambo.field_isSend == 1)
    {
      parambo = u.axw();
      AppMethodBeat.o(121089);
      return parambo;
    }
    String str = null;
    if (paramBoolean) {
      str = bi.yl(parambo.field_content);
    }
    if (bs.isNullOrNil(str)) {}
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
        if (mnH)
        {
          mnG.add(parama);
          AppMethodBeat.o(121087);
          return;
        }
        if (mnI)
        {
          parama.A(fBS);
          AppMethodBeat.o(121087);
          continue;
        }
        mnH = true;
      }
      finally {}
      mnG.add(parama);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121085);
          c.HN().clear();
          if (w.sQ(this.fLg)) {}
          label507:
          Object localObject2;
          for (x localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.fLg);; localObject2 = null)
          {
            int i = 100;
            int j = 0;
            while (i >= 100)
            {
              Cursor localCursor = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().dO(this.fLg, j);
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
                  bo localbo = new bo();
                  localbo.setMsgId(localCursor.getLong(0));
                  localbo.oz(localCursor.getLong(1));
                  localbo.oA(localCursor.getLong(2));
                  localbo.setContent(localCursor.getString(3));
                  localbo.jT(localCursor.getInt(4));
                  localbo.rf(localCursor.getString(5));
                  str = localbo.field_content;
                  if (str == null) {
                    continue;
                  }
                  k.b localb = k.b.vA(str);
                  if ((localb == null) || (!c.vb(localb.type))) {
                    continue;
                  }
                  Object localObject4 = c.a(localbo, w.sQ(this.fLg), this.fLg);
                  localObject3 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt((String)localObject4);
                  str = "";
                  if (localx != null) {
                    str = localx.wk((String)localObject4);
                  }
                  localObject3 = new e(localbo.field_createTime, localb.type, localb.title, localbo.field_msgId, ((av)localObject3).field_username, ((ai)localObject3).aaR(), ((av)localObject3).field_conRemark, str, bs.bG(localb.hkf, localb.appId), localb, localbo.field_msgSvrId);
                  ((e)localObject3).desc = localb.title;
                  localObject4 = ((m)com.tencent.mm.kernel.g.ab(m.class)).Ka(((e)localObject3).dsB.hke);
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
                  if (localb.hkg != 1)
                  {
                    str = o.aFx().b(localbo.field_imgPath, false, true);
                    if (!bs.isNullOrNil(str)) {
                      ((e)localObject3).mnL = "file://".concat(String.valueOf(str));
                    }
                  }
                  c.HN().add(localObject3);
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
                String str = ((e)localObject3).dsB.dvm;
                continue;
                label520:
                str = ((e)localObject3).dsB.hks;
              }
              if (localCursor != null) {
                localCursor.close();
              }
              j += i;
            }
            ac.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", new Object[] { Integer.valueOf(c.HN().size()) });
            ap.f(new Runnable()
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
      ac.i("MicroMsg.AppBrandHistoryListLogic", "done");
      mnI = true;
      mnH = false;
      Iterator localIterator = mnG.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.A(fBS);
        }
      }
      mnG.clear();
    }
    finally {}
    AppMethodBeat.o(121088);
  }
  
  public static void reset()
  {
    try
    {
      AppMethodBeat.i(121086);
      mnH = false;
      mnI = false;
      fBS.clear();
      mnG.clear();
      AppMethodBeat.o(121086);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean vb(int paramInt)
  {
    return (33 == paramInt) || (36 == paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void A(LinkedList<e> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.c
 * JD-Core Version:    0.7.0.1
 */