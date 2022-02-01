package com.tencent.mm.plugin.appbrand.y;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static LinkedList<e> fXm;
  private static HashSet<a> mTm;
  private static boolean mTn;
  private static boolean mTo;
  
  static
  {
    AppMethodBeat.i(121091);
    fXm = new LinkedList();
    mTm = new HashSet();
    mTn = false;
    mTo = false;
    AppMethodBeat.o(121091);
  }
  
  protected static String a(bv parambv, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(121089);
    if (parambv.field_isSend == 1)
    {
      parambv = v.aAC();
      AppMethodBeat.o(121089);
      return parambv;
    }
    String str = null;
    if (paramBoolean) {
      str = bl.BM(parambv.field_content);
    }
    if (bu.isNullOrNil(str)) {}
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
        if (mTn)
        {
          mTm.add(parama);
          AppMethodBeat.o(121087);
          return;
        }
        if (mTo)
        {
          parama.A(fXm);
          AppMethodBeat.o(121087);
          continue;
        }
        mTn = true;
      }
      finally {}
      mTm.add(parama);
      g.ajS();
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121085);
          c.Jq().clear();
          if (x.wb(this.ggQ)) {}
          label507:
          Object localObject2;
          for (ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.ggQ);; localObject2 = null)
          {
            int i = 100;
            int j = 0;
            while (i >= 100)
            {
              Cursor localCursor = ((l)g.ab(l.class)).doJ().em(this.ggQ, j);
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
                  bv localbv = new bv();
                  localbv.setMsgId(localCursor.getLong(0));
                  localbv.qM(localCursor.getLong(1));
                  localbv.qN(localCursor.getLong(2));
                  localbv.setContent(localCursor.getString(3));
                  localbv.kt(localCursor.getInt(4));
                  localbv.uj(localCursor.getString(5));
                  str = localbv.field_content;
                  if (str == null) {
                    continue;
                  }
                  k.b localb = k.b.zb(str);
                  if ((localb == null) || (!c.vL(localb.type))) {
                    continue;
                  }
                  Object localObject4 = c.a(localbv, x.wb(this.ggQ), this.ggQ);
                  localObject3 = ((l)g.ab(l.class)).azF().BH((String)localObject4);
                  str = "";
                  if (localac != null) {
                    str = localac.zP((String)localObject4);
                  }
                  localObject3 = new e(localbv.field_createTime, localb.type, localb.title, localbv.field_msgId, ((aw)localObject3).field_username, ((an)localObject3).adF(), ((aw)localObject3).field_conRemark, str, bu.bI(localb.hFd, localb.appId), localb, localbv.field_msgSvrId);
                  ((e)localObject3).desc = localb.title;
                  localObject4 = ((o)g.ab(o.class)).Ob(((e)localObject3).dFz.hFc);
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
                  if (localb.hFe != 1)
                  {
                    str = q.aIX().c(localbv.field_imgPath, false, true);
                    if (!bu.isNullOrNil(str)) {
                      ((e)localObject3).mTr = "file://".concat(String.valueOf(str));
                    }
                  }
                  c.Jq().add(localObject3);
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
                String str = ((e)localObject3).dFz.dIu;
                continue;
                label520:
                str = ((e)localObject3).dFz.hFt;
              }
              if (localCursor != null) {
                localCursor.close();
              }
              j += i;
            }
            ae.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", new Object[] { Integer.valueOf(c.Jq().size()) });
            ar.f(new Runnable()
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
      ae.i("MicroMsg.AppBrandHistoryListLogic", "done");
      mTo = true;
      mTn = false;
      Iterator localIterator = mTm.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.A(fXm);
        }
      }
      mTm.clear();
    }
    finally {}
    AppMethodBeat.o(121088);
  }
  
  public static void reset()
  {
    try
    {
      AppMethodBeat.i(121086);
      mTn = false;
      mTo = false;
      fXm.clear();
      mTm.clear();
      AppMethodBeat.o(121086);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean vL(int paramInt)
  {
    return (33 == paramInt) || (36 == paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void A(LinkedList<e> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y.c
 * JD-Core Version:    0.7.0.1
 */