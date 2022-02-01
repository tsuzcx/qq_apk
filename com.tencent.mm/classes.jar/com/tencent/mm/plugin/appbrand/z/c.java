package com.tencent.mm.plugin.appbrand.z;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static LinkedList<e> fVg;
  private static HashSet<a> mOi;
  private static boolean mOj;
  private static boolean mOk;
  
  static
  {
    AppMethodBeat.i(121091);
    fVg = new LinkedList();
    mOi = new HashSet();
    mOj = false;
    mOk = false;
    AppMethodBeat.o(121091);
  }
  
  protected static String a(bu parambu, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(121089);
    if (parambu.field_isSend == 1)
    {
      parambu = u.aAm();
      AppMethodBeat.o(121089);
      return parambu;
    }
    String str = null;
    if (paramBoolean) {
      str = bj.Bk(parambu.field_content);
    }
    if (bt.isNullOrNil(str)) {}
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
        if (mOj)
        {
          mOi.add(parama);
          AppMethodBeat.o(121087);
          return;
        }
        if (mOk)
        {
          parama.A(fVg);
          AppMethodBeat.o(121087);
          continue;
        }
        mOj = true;
      }
      finally {}
      mOi.add(parama);
      g.ajD();
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121085);
          c.Ji().clear();
          if (w.vF(this.geH)) {}
          label507:
          Object localObject2;
          for (ab localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.geH);; localObject2 = null)
          {
            int i = 100;
            int j = 0;
            while (i >= 100)
            {
              Cursor localCursor = ((l)g.ab(l.class)).dlK().ef(this.geH, j);
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
                  bu localbu = new bu();
                  localbu.setMsgId(localCursor.getLong(0));
                  localbu.qz(localCursor.getLong(1));
                  localbu.qA(localCursor.getLong(2));
                  localbu.setContent(localCursor.getString(3));
                  localbu.kr(localCursor.getInt(4));
                  localbu.tO(localCursor.getString(5));
                  str = localbu.field_content;
                  if (str == null) {
                    continue;
                  }
                  k.b localb = k.b.yr(str);
                  if ((localb == null) || (!c.vG(localb.type))) {
                    continue;
                  }
                  Object localObject4 = c.a(localbu, w.vF(this.geH), this.geH);
                  localObject3 = ((l)g.ab(l.class)).azp().Bf((String)localObject4);
                  str = "";
                  if (localab != null) {
                    str = localab.zf((String)localObject4);
                  }
                  localObject3 = new e(localbu.field_createTime, localb.type, localb.title, localbu.field_msgId, ((aw)localObject3).field_username, ((am)localObject3).adu(), ((aw)localObject3).field_conRemark, str, bt.bI(localb.hCo, localb.appId), localb, localbu.field_msgSvrId);
                  ((e)localObject3).desc = localb.title;
                  localObject4 = ((n)g.ab(n.class)).Nt(((e)localObject3).dEu.hCn);
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
                  if (localb.hCp != 1)
                  {
                    str = q.aIF().c(localbu.field_imgPath, false, true);
                    if (!bt.isNullOrNil(str)) {
                      ((e)localObject3).mOn = "file://".concat(String.valueOf(str));
                    }
                  }
                  c.Ji().add(localObject3);
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
                String str = ((e)localObject3).dEu.dHp;
                continue;
                label520:
                str = ((e)localObject3).dEu.hCB;
              }
              if (localCursor != null) {
                localCursor.close();
              }
              j += i;
            }
            ad.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", new Object[] { Integer.valueOf(c.Ji().size()) });
            aq.f(new Runnable()
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
      ad.i("MicroMsg.AppBrandHistoryListLogic", "done");
      mOk = true;
      mOj = false;
      Iterator localIterator = mOi.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.A(fVg);
        }
      }
      mOi.clear();
    }
    finally {}
    AppMethodBeat.o(121088);
  }
  
  public static void reset()
  {
    try
    {
      AppMethodBeat.i(121086);
      mOj = false;
      mOk = false;
      fVg.clear();
      mOi.clear();
      AppMethodBeat.o(121086);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean vG(int paramInt)
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