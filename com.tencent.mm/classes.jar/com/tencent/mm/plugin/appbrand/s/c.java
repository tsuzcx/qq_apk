package com.tencent.mm.plugin.appbrand.s;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static LinkedList<e> elu;
  private static HashSet<c.a> iXj;
  private static boolean iXk;
  private static boolean iXl;
  
  static
  {
    AppMethodBeat.i(93777);
    elu = new LinkedList();
    iXj = new HashSet();
    iXk = false;
    iXl = false;
    AppMethodBeat.o(93777);
  }
  
  protected static String a(bi parambi, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(93775);
    if (parambi.field_isSend == 1)
    {
      parambi = r.Zn();
      AppMethodBeat.o(93775);
      return parambi;
    }
    String str = null;
    if (paramBoolean) {
      str = bf.pu(parambi.field_content);
    }
    if (bo.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(93775);
      return paramString;
      paramString = str;
    }
  }
  
  public static void a(String paramString, c.a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(93773);
        if (iXk)
        {
          iXj.add(parama);
          AppMethodBeat.o(93773);
          return;
        }
        if (iXl)
        {
          parama.z(elu);
          AppMethodBeat.o(93773);
          continue;
        }
        iXk = true;
      }
      finally {}
      iXj.add(parama);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RO().ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(93771);
          c.aNO().clear();
          if (t.lA(this.euc)) {}
          label507:
          Object localObject2;
          for (u localu = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.euc);; localObject2 = null)
          {
            int i = 100;
            int j = 0;
            while (i >= 100)
            {
              Cursor localCursor = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().cF(this.euc, j);
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
                  bi localbi = new bi();
                  localbi.setMsgId(localCursor.getLong(0));
                  localbi.fP(localCursor.getLong(1));
                  localbi.fQ(localCursor.getLong(2));
                  localbi.setContent(localCursor.getString(3));
                  localbi.hL(localCursor.getInt(4));
                  localbi.kk(localCursor.getString(5));
                  str = localbi.field_content;
                  if (str == null) {
                    continue;
                  }
                  j.b localb = j.b.mY(str);
                  if ((localb == null) || (!c.pL(localb.type))) {
                    continue;
                  }
                  Object localObject4 = c.a(localbi, t.lA(this.euc), this.euc);
                  localObject3 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw((String)localObject4);
                  str = "";
                  if (localu != null) {
                    str = localu.nE((String)localObject4);
                  }
                  localObject3 = new e(localbi.field_createTime, localb.type, localb.title, localbi.field_msgId, ((aq)localObject3).field_username, ((ad)localObject3).Oe(), ((aq)localObject3).field_conRemark, str, bo.bf(localb.fiY, localb.appId), localb, localbi.field_msgSvrId);
                  ((e)localObject3).desc = localb.title;
                  localObject4 = ((i)com.tencent.mm.kernel.g.E(i.class)).Ae(((e)localObject3).cEn.fiX);
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
                  if (localb.fiZ != 1)
                  {
                    str = o.ahC().c(localbi.field_imgPath, false, true);
                    if (!bo.isNullOrNil(str)) {
                      ((e)localObject3).iXo = "file://".concat(String.valueOf(str));
                    }
                  }
                  c.aNO().add(localObject3);
                  continue;
                  i = 0;
                }
                finally
                {
                  if (localCursor != null) {
                    localCursor.close();
                  }
                  AppMethodBeat.o(93771);
                }
                continue;
                String str = ((e)localObject3).cEn.cGO;
                continue;
                label520:
                str = ((e)localObject3).cEn.fjj;
              }
              if (localCursor != null) {
                localCursor.close();
              }
              j += i;
            }
            ab.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", new Object[] { Integer.valueOf(c.aNO().size()) });
            al.d(new c.1.1(this));
            AppMethodBeat.o(93771);
            return;
          }
        }
      });
      AppMethodBeat.o(93773);
    }
  }
  
  private static void done()
  {
    try
    {
      AppMethodBeat.i(93774);
      ab.i("MicroMsg.AppBrandHistoryListLogic", "done");
      iXl = true;
      iXk = false;
      Iterator localIterator = iXj.iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if (locala != null) {
          locala.z(elu);
        }
      }
      iXj.clear();
    }
    finally {}
    AppMethodBeat.o(93774);
  }
  
  public static boolean pL(int paramInt)
  {
    return (33 == paramInt) || (36 == paramInt);
  }
  
  public static void reset()
  {
    try
    {
      AppMethodBeat.i(93772);
      iXk = false;
      iXl = false;
      elu.clear();
      iXj.clear();
      AppMethodBeat.o(93772);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.c
 * JD-Core Version:    0.7.0.1
 */