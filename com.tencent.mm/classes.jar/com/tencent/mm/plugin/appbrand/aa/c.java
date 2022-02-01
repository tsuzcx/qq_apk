package com.tencent.mm.plugin.appbrand.aa;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static LinkedList<e> fyl;
  private static HashSet<a> lLJ;
  private static boolean lLK;
  private static boolean lLL;
  
  static
  {
    AppMethodBeat.i(121091);
    fyl = new LinkedList();
    lLJ = new HashSet();
    lLK = false;
    lLL = false;
    AppMethodBeat.o(121091);
  }
  
  protected static String a(bl parambl, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(121089);
    if (parambl.field_isSend == 1)
    {
      parambl = u.aqG();
      AppMethodBeat.o(121089);
      return parambl;
    }
    String str = null;
    if (paramBoolean) {
      str = bi.uf(parambl.field_content);
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
        if (lLK)
        {
          lLJ.add(parama);
          AppMethodBeat.o(121087);
          return;
        }
        if (lLL)
        {
          parama.A(fyl);
          AppMethodBeat.o(121087);
          continue;
        }
        lLK = true;
      }
      finally {}
      lLJ.add(parama);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121085);
          c.Ic().clear();
          if (com.tencent.mm.model.w.pF(this.fHA)) {}
          label507:
          Object localObject2;
          for (com.tencent.mm.storage.w localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.fHA);; localObject2 = null)
          {
            int i = 100;
            int j = 0;
            while (i >= 100)
            {
              Cursor localCursor = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().dH(this.fHA, j);
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
                  bl localbl = new bl();
                  localbl.setMsgId(localCursor.getLong(0));
                  localbl.kX(localCursor.getLong(1));
                  localbl.kY(localCursor.getLong(2));
                  localbl.setContent(localCursor.getString(3));
                  localbl.jV(localCursor.getInt(4));
                  localbl.nZ(localCursor.getString(5));
                  str = localbl.field_content;
                  if (str == null) {
                    continue;
                  }
                  k.b localb = k.b.rx(str);
                  if ((localb == null) || (!c.uj(localb.type))) {
                    continue;
                  }
                  Object localObject4 = c.a(localbl, com.tencent.mm.model.w.pF(this.fHA), this.fHA);
                  localObject3 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY((String)localObject4);
                  str = "";
                  if (localw != null) {
                    str = localw.sh((String)localObject4);
                  }
                  localObject3 = new e(localbl.field_createTime, localb.type, localb.title, localbl.field_msgId, ((au)localObject3).field_username, ((af)localObject3).ZW(), ((au)localObject3).field_conRemark, str, bt.by(localb.gJF, localb.appId), localb, localbl.field_msgSvrId);
                  ((e)localObject3).desc = localb.title;
                  localObject4 = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(((e)localObject3).duP.gJE);
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
                  if (localb.gJG != 1)
                  {
                    str = o.ayF().b(localbl.field_imgPath, false, true);
                    if (!bt.isNullOrNil(str)) {
                      ((e)localObject3).lLO = "file://".concat(String.valueOf(str));
                    }
                  }
                  c.Ic().add(localObject3);
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
                String str = ((e)localObject3).duP.dxA;
                continue;
                label520:
                str = ((e)localObject3).duP.gJS;
              }
              if (localCursor != null) {
                localCursor.close();
              }
              j += i;
            }
            ad.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", new Object[] { Integer.valueOf(c.Ic().size()) });
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
      lLL = true;
      lLK = false;
      Iterator localIterator = lLJ.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.A(fyl);
        }
      }
      lLJ.clear();
    }
    finally {}
    AppMethodBeat.o(121088);
  }
  
  public static void reset()
  {
    try
    {
      AppMethodBeat.i(121086);
      lLK = false;
      lLL = false;
      fyl.clear();
      lLJ.clear();
      AppMethodBeat.o(121086);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean uj(int paramInt)
  {
    return (33 == paramInt) || (36 == paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void A(LinkedList<e> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.c
 * JD-Core Version:    0.7.0.1
 */