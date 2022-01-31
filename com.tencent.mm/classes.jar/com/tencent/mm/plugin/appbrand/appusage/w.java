package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.mm.cf.h;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.d.b;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class w
  extends j
{
  public static final String[] dUb = { com.tencent.mm.sdk.e.i.a(w.a.dUa, "AppBrandLauncherLayoutItem") };
  public final h fEC;
  final w.b fJv;
  public final w.c fJw = new w.c(this, (byte)0);
  
  public w(h paramh)
  {
    this.fEC = paramh;
    this.fJv = new w.b(paramh);
  }
  
  private void adu()
  {
    int j = 0;
    Object localObject1 = this.fEC.a(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "scene" }), new String[] { "2" }, 0);
    Object localObject2;
    if (localObject1 == null)
    {
      i = 0;
      if (i > 200)
      {
        localObject2 = a(new String[] { "recordId", "brandId", "versionType" }, 2147483647, 200);
        if (localObject2 != null) {
          break label122;
        }
      }
    }
    else
    {
      label92:
      if (!((Cursor)localObject1).moveToFirst()) {
        break label469;
      }
    }
    label469:
    for (int i = ((Cursor)localObject1).getInt(0);; i = 0)
    {
      ((Cursor)localObject1).close();
      break;
      label122:
      localObject1 = new LinkedList();
      ArrayList localArrayList1 = new ArrayList(i - 200);
      ArrayList localArrayList2 = new ArrayList(i - 200);
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          ((List)localObject1).add(String.valueOf(((Cursor)localObject2).getInt(0)));
          localArrayList1.add(((Cursor)localObject2).getString(1));
          localArrayList2.add(Integer.valueOf(((Cursor)localObject2).getInt(2)));
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
      if (bk.dk((List)localObject1)) {
        break label92;
      }
      long l = this.fEC.eV(Thread.currentThread().getId());
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        this.fEC.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { localObject3 });
      }
      this.fEC.hI(l);
      localObject2 = new ArrayList(localArrayList1.size());
      Object localObject3 = new ArrayList(localArrayList1.size());
      i = j;
      while (i < localArrayList1.size())
      {
        String str = com.tencent.mm.plugin.appbrand.config.r.sv((String)localArrayList1.get(i));
        if (!bk.bl(str))
        {
          ((List)localObject2).add(str);
          ((List)localObject3).add(localArrayList2.get(i));
        }
        i += 1;
      }
      if (e.abb() != null) {
        e.abb().d((List)localObject2, (List)localObject3);
      }
      b("batch", 5, localObject1);
      return;
    }
  }
  
  public static ArrayList<AppBrandRecentTaskInfo> f(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return new ArrayList();
    }
    Object localObject;
    if (paramCursor.moveToFirst())
    {
      LinkedList localLinkedList = new LinkedList();
      localObject = new w.a();
      do
      {
        ((w.a)localObject).d(paramCursor);
        if (!bk.bl(((w.a)localObject).field_brandId)) {
          localLinkedList.add(com.tencent.mm.plugin.appbrand.config.r.a(String.valueOf(((w.a)localObject).field_recordId), ((w.a)localObject).field_brandId, ((w.a)localObject).field_versionType, ((w.a)localObject).field_updateTime));
        }
      } while (paramCursor.moveToNext());
      localObject = new ArrayList(localLinkedList.size());
      ((ArrayList)localObject).addAll(localLinkedList);
    }
    for (;;)
    {
      paramCursor.close();
      return localObject;
      localObject = new ArrayList();
    }
  }
  
  private static int x(String paramString, int paramInt1, int paramInt2)
  {
    return String.format(Locale.US, "%s|%d|%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }).hashCode();
  }
  
  final Cursor a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    return this.fEC.query("AppBrandLauncherLayoutItem", paramArrayOfString, String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", new Object[] { "scene", "updateTime", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), new String[] { "2" }, null, null, null);
  }
  
  final boolean a(w.a parama)
  {
    if (bk.bl(parama.field_brandId)) {}
    long l;
    do
    {
      return false;
      l = this.fEC.insert("AppBrandLauncherLayoutItem", "", parama.vf());
    } while ((l <= 0L) && (l != parama.field_recordId));
    return true;
  }
  
  public final boolean a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString2)
  {
    paramBoolean = a(paramString1, paramInt1, true, paramBoolean, paramInt2, paramInt3, paramString2);
    if (paramBoolean) {
      i.rF(paramString2);
    }
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, String paramString2)
  {
    if ((bk.bl(paramString1)) || (999 == paramInt1)) {
      return false;
    }
    Object localObject = String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[] { "updateTime", "AppBrandLauncherLayoutItem", "scene" });
    localObject = this.fEC.a((String)localObject, new String[] { "2" }, 0);
    long l;
    int i;
    label165:
    boolean bool2;
    boolean bool1;
    if (localObject == null)
    {
      l = 0L;
      l = Math.max(l + 1L, bk.UX());
      int j = x(paramString1, paramInt1, 2);
      localObject = new ContentValues(1);
      ((ContentValues)localObject).put("updateTime", Long.valueOf(l));
      if (this.fEC.update("AppBrandLauncherLayoutItem", (ContentValues)localObject, String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(j) }) <= 0) {
        break label426;
      }
      i = 1;
      if (i != 0) {
        b("single", 3, String.valueOf(j));
      }
      if (i != 0) {
        break label432;
      }
      localObject = new w.a();
      ((w.a)localObject).field_updateTime = l;
      ((w.a)localObject).field_scene = 2;
      ((w.a)localObject).field_brandId = paramString1;
      ((w.a)localObject).field_versionType = paramInt1;
      bool2 = a((w.a)localObject);
      if (bool2) {
        b("single", 2, String.valueOf(j));
      }
      bool1 = bool2;
      label252:
      if ((bool2) && (paramBoolean1) && (d.a.kq(paramInt1)))
      {
        localObject = ((b)e.G(b.class)).v(paramString1, 3, paramInt2);
        if (!((Boolean)((Pair)localObject).first).booleanValue()) {
          break label441;
        }
        y.i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", new Object[] { paramString1, Integer.valueOf(paramInt2) });
        paramString2 = a.fFB;
        a.s(((Integer)((Pair)localObject).second).intValue(), 165L);
      }
    }
    for (;;)
    {
      if (bool2) {
        com.tencent.mm.plugin.appbrand.appcache.r.af(paramString1, paramInt1);
      }
      if (bool1) {
        adu();
      }
      if (bool2) {
        ((n)e.G(n.class)).a(paramString1, paramInt1, n.a.fID);
      }
      return bool2;
      l = 0L;
      if (((Cursor)localObject).moveToFirst()) {
        l = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      break;
      label426:
      i = 0;
      break label165;
      label432:
      bool2 = true;
      bool1 = false;
      break label252;
      label441:
      new aa(paramInt2, paramBoolean2, paramInt1, 1, paramString1, paramInt3, paramString2).Km();
    }
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> adt()
  {
    return kB(200);
  }
  
  public final boolean aw(String paramString, int paramInt)
  {
    boolean bool = true;
    if (bk.bl(paramString)) {}
    do
    {
      return false;
      paramString = this.fEC.a(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[] { "AppBrandLauncherLayoutItem", "brandId", "versionType", "scene" }), new String[] { paramString, String.valueOf(paramInt), "2" }, 0);
    } while (paramString == null);
    if (paramString.moveToFirst()) {
      if (paramString.getInt(0) <= 0) {}
    }
    for (;;)
    {
      paramString.close();
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final boolean ax(String paramString, int paramInt)
  {
    if (bk.bl(paramString))
    {
      bool = false;
      if (bool)
      {
        new aa(1001, false, paramInt, 2, paramString, 1, null).Km();
        b("single", 5, String.valueOf(x(paramString, paramInt, 2)));
      }
      return bool;
    }
    if (this.fEC.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(x(paramString, paramInt, 2)) }) >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        ((n)e.G(n.class)).b(paramString, paramInt, n.a.fID);
      }
      break;
    }
  }
  
  public final void c(j.a parama)
  {
    a(parama, c.DS().mnU.getLooper());
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> kB(int paramInt)
  {
    return f(a(null, paramInt, 0));
  }
  
  public final AppBrandRecentTaskInfo rI(String paramString)
  {
    Object localObject = null;
    if (bk.bl(paramString)) {}
    Cursor localCursor;
    do
    {
      return null;
      localCursor = this.fEC.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "scene", "recordId" }), new String[] { "2", paramString }, null, null, null);
    } while (localCursor == null);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      w.a locala = new w.a();
      locala.d(localCursor);
      paramString = localObject;
      if (!bk.bl(locala.field_brandId)) {
        paramString = com.tencent.mm.plugin.appbrand.config.r.a(String.valueOf(locala.field_recordId), locala.field_brandId, locala.field_versionType, locala.field_updateTime);
      }
    }
    localCursor.close();
    return paramString;
  }
  
  public final List<String> rJ(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    if (!bk.bl(paramString))
    {
      h localh = this.fEC;
      String str = String.format(Locale.US, "%s=? and %s=?", new Object[] { "scene", "brandId" });
      paramString = localh.query("AppBrandLauncherLayoutItem", new String[] { "recordId" }, str, new String[] { "2", paramString }, null, null, null);
      if (paramString == null) {
        return null;
      }
      if (paramString.moveToFirst()) {
        do
        {
          localLinkedList.add(String.valueOf(paramString.getInt(paramString.getColumnIndex("recordId"))));
        } while (paramString.moveToNext());
      }
      paramString.close();
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w
 * JD-Core Version:    0.7.0.1
 */