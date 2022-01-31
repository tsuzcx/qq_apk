package com.tencent.mm.plugin.appbrand.appusage;

import a.a.e;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.mm.cf.h;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.protocal.c.bvi;
import com.tencent.mm.protocal.c.cmc;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class s
  extends j
{
  public static final String[] dUb = { i.a(s.a.dUa, "AppBrandStarApp") };
  private static final s.b<cmc> fJn = new s.1();
  private static final s.b<LocalUsageInfo> fJo = new s.2();
  final h fEC;
  private final s.c fJm;
  
  public s(h paramh)
  {
    this.fEC = paramh;
    this.fJm = new s.c(paramh);
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> a(af.a parama)
  {
    return b(-1, parama);
  }
  
  final <T> void a(Class<T> paramClass, List<T> paramList, Long paramLong)
  {
    s.b localb;
    long l;
    if (paramClass == cmc.class)
    {
      localb = fJn;
      l = this.fEC.eV(Thread.currentThread().getId());
      this.fEC.delete("AppBrandStarApp", "", null);
      if (bk.dk(paramList)) {
        break label250;
      }
      if (paramList == null) {
        break label245;
      }
      paramClass = (Iterable)paramList;
      a.d.b.g.k(paramClass, "$receiver");
      if ((!(paramClass instanceof Collection)) || (((Collection)paramClass).size() > 1)) {
        break label227;
      }
      paramClass = e.c(paramClass);
    }
    for (;;)
    {
      paramList = new s.a();
      paramClass = paramClass.iterator();
      int i = 0;
      while (paramClass.hasNext())
      {
        Object localObject = paramClass.next();
        if (!bk.bl(localb.aL(localObject)))
        {
          paramList.field_username = localb.aL(localObject);
          paramList.field_versionType = localb.aK(localObject);
          paramList.field_updateTime = localb.aJ(localObject);
          i += 1;
          paramList.field_orderSequence = (i * (t.ads() * 2));
          this.fEC.insert("AppBrandStarApp", null, paramList.vf());
        }
      }
      if (paramClass != LocalUsageInfo.class) {
        return;
      }
      localb = fJo;
      break;
      label227:
      paramClass = e.d(paramClass);
      a.d.b.g.k(paramClass, "$receiver");
      Collections.reverse(paramClass);
      continue;
      label245:
      paramClass = null;
    }
    label250:
    this.fEC.hI(l);
    b("batch", 3, paramLong);
  }
  
  public final int adp()
  {
    int i = 0;
    Cursor localCursor = this.fEC.a("select count(*) from AppBrandStarApp", null, 0);
    if ((localCursor == null) || (localCursor.isClosed())) {
      return 0;
    }
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    return i;
  }
  
  public final boolean at(String paramString, int paramInt)
  {
    Object localObject = null;
    if (bk.bl(paramString)) {}
    for (paramString = localObject; paramString == null; paramString = this.fEC.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "username", "versionType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null, null)) {
      return false;
    }
    boolean bool = paramString.moveToFirst();
    paramString.close();
    return bool;
  }
  
  public final int au(String paramString, int paramInt)
  {
    long l2 = 0L;
    int i = 1;
    int j = 0;
    if (bk.bl(paramString))
    {
      paramInt = -1;
      return paramInt;
    }
    long l3 = bk.UX();
    Object localObject = String.format(Locale.US, "select %s from %s order by %s desc limit 1 offset 0", new Object[] { "orderSequence", "AppBrandStarApp", "orderSequence" });
    localObject = this.fEC.a((String)localObject, null, 2);
    long l1 = l2;
    if (localObject != null)
    {
      if (((Cursor)localObject).isClosed()) {
        l1 = l2;
      }
    }
    else
    {
      l2 = t.ads() * 2;
      if (at(paramString, paramInt)) {
        break label229;
      }
      if (adp() < t.ads()) {
        break label159;
      }
      return -2;
    }
    if (!((Cursor)localObject).moveToFirst()) {}
    for (l1 = l2;; l1 = ((Cursor)localObject).getLong(0))
    {
      ((Cursor)localObject).close();
      break;
    }
    label159:
    localObject = new s.a();
    ((s.a)localObject).field_username = paramString;
    ((s.a)localObject).field_versionType = paramInt;
    ((s.a)localObject).field_updateTime = l3;
    ((s.a)localObject).field_orderSequence = (l1 + l2);
    this.fJm.a((com.tencent.mm.sdk.e.c)localObject, false);
    if (at(paramString, paramInt)) {
      b("single", 2, localObject);
    }
    for (i = 1;; i = 0)
    {
      label229:
      if (i != 0)
      {
        localObject = new bvi();
        ((bvi)localObject).username = paramString;
        ((bvi)localObject).sEr = paramInt;
        ((c)com.tencent.mm.kernel.g.r(c.class)).a(z.a((bvi)localObject), z.b.fJJ);
      }
      paramInt = j;
      if (i != 0) {
        break;
      }
      return -1;
    }
  }
  
  public final boolean av(String paramString, int paramInt)
  {
    return j(paramString, paramInt, true);
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> b(int paramInt, af.a parama)
  {
    Object localObject2 = null;
    Object localObject1 = parama;
    if (parama == null) {
      localObject1 = af.a.fJT;
    }
    if (localObject1 == af.a.fJV)
    {
      parama = "select AppBrandStarApp.username, AppBrandStarApp.versionType, AppBrandLocalUsageRecord.updateTime from AppBrandStarApp left outer join AppBrandLocalUsageRecord on AppBrandStarApp.username = AppBrandLocalUsageRecord.username and AppBrandStarApp.versionType = AppBrandLocalUsageRecord.versionType order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(paramInt, 1) + " offset 0";
      localObject1 = this.fEC.a(parama, null, 0);
      if (localObject1 != null) {}
    }
    Object localObject3;
    do
    {
      return null;
      if (!((Cursor)localObject1).moveToFirst())
      {
        ((Cursor)localObject1).close();
        return null;
      }
      parama = new LinkedList();
      do
      {
        localObject2 = ((Cursor)localObject1).getString(0);
        if (!bk.bl((String)localObject2))
        {
          paramInt = ((Cursor)localObject1).getInt(1);
          long l = ((Cursor)localObject1).getLong(2);
          parama.add(r.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { localObject2, Integer.valueOf(paramInt) }), (String)localObject2, paramInt, l));
        }
      } while (((Cursor)localObject1).moveToNext());
      ((Cursor)localObject1).close();
      localObject1 = new ArrayList(parama.size());
      ((ArrayList)localObject1).addAll(parama);
      return localObject1;
      if (paramInt > 0) {
        break;
      }
      paramInt = t.ads();
      parama = this.fEC;
      localObject3 = String.format(Locale.US, "%s desc limit %d offset 0", new Object[] { "orderSequence", Integer.valueOf(paramInt) });
      localObject3 = parama.query("AppBrandStarApp", new String[] { "username", "versionType" }, null, null, null, null, (String)localObject3);
    } while (localObject3 == null);
    if (af.a.fJU == localObject1)
    {
      parama = (af.a)localObject2;
      if (((Cursor)localObject3).moveToLast())
      {
        label305:
        localObject2 = new LinkedList();
        parama = new s.a();
        label322:
        do
        {
          parama.d((Cursor)localObject3);
          ((List)localObject2).add(r.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { parama.field_username, Integer.valueOf(parama.field_versionType) }), parama.field_username, parama.field_versionType, -1L));
          if (af.a.fJU != localObject1) {
            break;
          }
        } while (((Cursor)localObject3).moveToPrevious());
      }
    }
    for (;;)
    {
      parama = new ArrayList(((List)localObject2).size());
      parama.addAll((Collection)localObject2);
      do
      {
        ((Cursor)localObject3).close();
        return parama;
        paramInt = Math.min(t.ads(), paramInt);
        break;
        parama = (af.a)localObject2;
      } while (!((Cursor)localObject3).moveToFirst());
      break label305;
      if (((Cursor)localObject3).moveToNext()) {
        break label322;
      }
    }
  }
  
  public final void c(j.a parama)
  {
    a(parama, com.tencent.mm.plugin.appbrand.v.c.DS().mnU.getLooper());
  }
  
  public final boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (bk.bl(paramString)) {
      return false;
    }
    Object localObject = new s.a();
    ((s.a)localObject).field_username = paramString;
    ((s.a)localObject).field_versionType = paramInt;
    boolean bool1 = bool2;
    if (this.fJm.b((com.tencent.mm.sdk.e.c)localObject, new String[] { "versionType", "username" }))
    {
      this.fJm.a((com.tencent.mm.sdk.e.c)localObject, false, s.a.fCT);
      if (at(paramString, paramInt)) {
        break label153;
      }
      b("single", 5, localObject);
    }
    label153:
    for (bool1 = bool2;; bool1 = false)
    {
      if ((bool1) && (paramBoolean))
      {
        localObject = new bvi();
        ((bvi)localObject).username = paramString;
        ((bvi)localObject).sEr = paramInt;
        ((c)com.tencent.mm.kernel.g.r(c.class)).a(z.b((bvi)localObject), z.b.fJJ);
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.s
 * JD-Core Version:    0.7.0.1
 */