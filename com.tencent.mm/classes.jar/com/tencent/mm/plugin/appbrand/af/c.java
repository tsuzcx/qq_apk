package com.tencent.mm.plugin.appbrand.af;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static LinkedList<e> lPK;
  private static boolean onP;
  private static HashSet<a> upY;
  private static boolean upZ;
  
  static
  {
    AppMethodBeat.i(121091);
    lPK = new LinkedList();
    upY = new HashSet();
    onP = false;
    upZ = false;
    AppMethodBeat.o(121091);
  }
  
  public static boolean Dz(int paramInt)
  {
    return (33 == paramInt) || (36 == paramInt);
  }
  
  protected static String a(cc paramcc, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(121089);
    if (paramcc.field_isSend == 1)
    {
      paramcc = z.bAM();
      AppMethodBeat.o(121089);
      return paramcc;
    }
    String str = null;
    if (paramBoolean) {
      str = br.JJ(paramcc.field_content);
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
        if (onP)
        {
          upY.add(parama);
          AppMethodBeat.o(121087);
          return;
        }
        if (upZ)
        {
          parama.E(lPK);
          AppMethodBeat.o(121087);
          continue;
        }
        onP = true;
      }
      finally {}
      upY.add(parama);
      h.baF();
      h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121085);
          c.azT().clear();
          if (au.bwE(c.this)) {}
          label507:
          Object localObject2;
          for (aj localaj = ((b)h.ax(b.class)).bzK().Ju(c.this);; localObject2 = null)
          {
            int i = 100;
            int j = 0;
            while (i >= 100)
            {
              Cursor localCursor = ((n)h.ax(n.class)).gaZ().fU(c.this, j);
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
                  cc localcc = new cc();
                  localcc.setMsgId(localCursor.getLong(0));
                  localcc.gX(localCursor.getLong(1));
                  localcc.setCreateTime(localCursor.getLong(2));
                  localcc.setContent(localCursor.getString(3));
                  localcc.pI(localCursor.getInt(4));
                  localcc.BT(localCursor.getString(5));
                  str = localcc.field_content;
                  if (str == null) {
                    continue;
                  }
                  k.b localb = k.b.Hf(str);
                  if ((localb == null) || (!c.Dz(localb.type))) {
                    continue;
                  }
                  Object localObject4 = c.a(localcc, au.bwE(c.this), c.this);
                  localObject3 = ((n)h.ax(n.class)).bzA().JE((String)localObject4);
                  str = "";
                  if (localaj != null) {
                    str = localaj.getDisplayName((String)localObject4);
                  }
                  localObject3 = new e(localcc.getCreateTime(), localb.type, localb.title, localcc.field_msgId, ((az)localObject3).field_username, ((au)localObject3).aSU(), ((az)localObject3).field_conRemark, str, Util.nullAs(localb.nTE, localb.appId), localb, localcc.field_msgSvrId);
                  ((e)localObject3).desc = localb.title;
                  localObject4 = ((s)h.ax(s.class)).Xy(((e)localObject3).hWV.nTD);
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
                  if (localb.nTF != 1)
                  {
                    str = r.bKa().d(localcc.field_imgPath, false, true);
                    if (!Util.isNullOrNil(str)) {
                      ((e)localObject3).uqc = "file://".concat(String.valueOf(str));
                    }
                  }
                  c.azT().add(localObject3);
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
                String str = ((e)localObject3).hWV.iab;
                continue;
                label520:
                str = ((e)localObject3).hWV.nTY;
              }
              if (localCursor != null) {
                localCursor.close();
              }
              j += i;
            }
            Log.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", new Object[] { Integer.valueOf(c.azT().size()) });
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
      upZ = true;
      onP = false;
      Iterator localIterator = upY.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.E(lPK);
        }
      }
      upY.clear();
    }
    finally {}
    AppMethodBeat.o(121088);
  }
  
  public static void reset()
  {
    try
    {
      AppMethodBeat.i(121086);
      onP = false;
      upZ = false;
      lPK.clear();
      upY.clear();
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
    public abstract void E(LinkedList<e> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.c
 * JD-Core Version:    0.7.0.1
 */