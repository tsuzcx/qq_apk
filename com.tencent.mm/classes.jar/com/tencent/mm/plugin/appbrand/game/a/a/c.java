package com.tencent.mm.plugin.appbrand.game.a.a;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class c
  extends i<b>
{
  public static final String[] dUb = { i.a(b.buS, "WxagGameInfo") };
  private final boolean gaO;
  
  public c(e parame)
  {
    super(parame, b.buS, "WxagGameInfo", null);
    if (parame != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.gaO = bool;
      if (!this.gaO) {
        y.e("MicroMsg.MiniGameInfoStorage", "storage can not work!!!");
      }
      return;
    }
  }
  
  public final boolean Z(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.gaO)
    {
      if (!bk.bl(paramString)) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      do
      {
        return bool1;
        b localb = new b();
        localb.field_RecordId = paramString;
        bool2 = super.a(localb, new String[0]);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (!paramBoolean);
    b("single", 5, paramString);
    return bool2;
  }
  
  public final boolean a(a parama, boolean paramBoolean)
  {
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.gaO)
    {
      if (parama == null) {
        bool1 = bool3;
      }
    }
    else {
      return bool1;
    }
    Object localObject1 = parama.euK;
    int i = parama.fEL;
    if (!this.gaO)
    {
      localObject1 = null;
      label46:
      if ((localObject1 != null) && (((b)localObject1).field_isSync)) {
        break label383;
      }
    }
    label383:
    for (boolean bool2 = true;; bool2 = false)
    {
      y.i("MicroMsg.MiniGameInfoStorage", "needUpdate:%b", new Object[] { Boolean.valueOf(bool2) });
      bool1 = bool3;
      if (!bool2) {
        break;
      }
      if ((!this.gaO) || (localObject1 == null)) {}
      for (;;)
      {
        localObject1 = new b();
        if (bk.bl(parama.dzp))
        {
          localObject2 = parama.hPY;
          i = parama.fEL;
          parama.dzp = String.valueOf(String.format(Locale.US, "%s|%d", new Object[] { localObject2, Integer.valueOf(i) }).hashCode());
        }
        ((b)localObject1).field_RecordId = parama.dzp;
        ((b)localObject1).field_AppId = parama.euK;
        ((b)localObject1).field_AppName = parama.kVn;
        ((b)localObject1).field_UserName = parama.hPY;
        ((b)localObject1).field_IconUrl = parama.kSy;
        ((b)localObject1).field_BriefIntro = parama.kTg;
        ((b)localObject1).field_isSync = false;
        ((b)localObject1).field_createTime = System.currentTimeMillis();
        bool2 = b((com.tencent.mm.sdk.e.c)localObject1);
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        bool1 = bool2;
        if (!paramBoolean) {
          break;
        }
        b("single", 2, ((b)localObject1).field_RecordId);
        return bool2;
        Object localObject2 = rawQuery(String.format("select * from %s where %s=? and %s=?", new Object[] { "WxagGameInfo", "AppId", "debugType" }), new String[] { localObject1, String.valueOf(i) });
        if (((Cursor)localObject2).moveToFirst())
        {
          localObject1 = new b();
          ((b)localObject1).d((Cursor)localObject2);
          ((Cursor)localObject2).close();
          break label46;
        }
        ((Cursor)localObject2).close();
        localObject1 = null;
        break label46;
        super.a((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
      }
    }
  }
  
  public final List<b> agw()
  {
    if (!this.gaO) {
      return null;
    }
    Object localObject = String.format("select * from %s", new Object[] { "WxagGameInfo" });
    Cursor localCursor = rawQuery((String)localObject, new String[0]);
    y.i("MicroMsg.MiniGameInfoStorage", "getMiniGameList queryStr:%s", new Object[] { localObject });
    if (localCursor == null)
    {
      y.i("MicroMsg.MiniGameInfoStorage", "cursor is null");
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = new ArrayList();
      do
      {
        b localb = new b();
        localb.d(localCursor);
        ((List)localObject).add(localb);
      } while (localCursor.moveToNext());
      localCursor.close();
      y.i("MicroMsg.MiniGameInfoStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      return localObject;
    }
    localCursor.close();
    y.i("MicroMsg.MiniGameInfoStorage", "no record");
    return null;
  }
  
  public final boolean av(List<String> paramList)
  {
    if ((!this.gaO) || (bk.dk(paramList))) {
      return false;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      Z((String)localIterator.next(), false);
    }
    b("batch", 5, paramList);
    return true;
  }
  
  public final boolean b(List<a> paramList, boolean paramBoolean)
  {
    if ((!this.gaO) || (bk.dk(paramList))) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      a(locala, false);
      localArrayList.add(locala.dzp);
    }
    if (paramBoolean) {
      b("batch", 2, localArrayList);
    }
    y.i("MicroMsg.MiniGameInfoStorage", "insert miniGame size:%d,   isSync:%b", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(false) });
    return true;
  }
  
  public final void c(j.a parama)
  {
    a(parama, com.tencent.mm.plugin.appbrand.v.c.DS().mnU.getLooper());
  }
  
  public final b tr(String paramString)
  {
    if ((!this.gaO) || (bk.bl(paramString))) {
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=?", new Object[] { "WxagGameInfo", "RecordId" }), new String[] { paramString });
    if (localCursor.moveToFirst())
    {
      paramString = new b();
      paramString.d(localCursor);
      localCursor.close();
      return paramString;
    }
    y.i("MicroMsg.MiniGameInfoStorage", "getMiniGame recordId:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.a.c
 * JD-Core Version:    0.7.0.1
 */