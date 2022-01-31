package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class s
  extends k
{
  public static final String[] fkl;
  private static final s.b<czt> hcg;
  private static final s.b<LocalUsageInfo> hch;
  final h hce;
  private final s.c hcf;
  
  static
  {
    AppMethodBeat.i(129656);
    fkl = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(s.a.fkk, "AppBrandStarApp") };
    hcg = new s.1();
    hch = new s.2();
    AppMethodBeat.o(129656);
  }
  
  public s(h paramh)
  {
    AppMethodBeat.i(129645);
    this.hce = paramh;
    this.hcf = new s.c(paramh);
    AppMethodBeat.o(129645);
  }
  
  private ArrayList<AppBrandRecentTaskInfo> nv(int paramInt)
  {
    AppMethodBeat.i(129650);
    Object localObject1 = "select AppBrandStarApp.username, AppBrandStarApp.versionType, AppBrandLocalUsageRecord.updateTime from AppBrandStarApp left outer join AppBrandLocalUsageRecord on AppBrandStarApp.username = AppBrandLocalUsageRecord.username and AppBrandStarApp.versionType = AppBrandLocalUsageRecord.versionType order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(paramInt, 1) + " offset 0";
    Object localObject2 = this.hce.a((String)localObject1, null, 0);
    if (localObject2 == null)
    {
      AppMethodBeat.o(129650);
      return null;
    }
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(129650);
      return null;
    }
    localObject1 = new LinkedList();
    do
    {
      String str = ((Cursor)localObject2).getString(0);
      if (!bo.isNullOrNil(str))
      {
        paramInt = ((Cursor)localObject2).getInt(1);
        long l = ((Cursor)localObject2).getLong(2);
        ((LinkedList)localObject1).add(q.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { str, Integer.valueOf(paramInt) }), str, paramInt, l));
      }
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject2 = new ArrayList(((LinkedList)localObject1).size());
    ((ArrayList)localObject2).addAll((Collection)localObject1);
    AppMethodBeat.o(129650);
    return localObject2;
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> a(af.a parama)
  {
    AppMethodBeat.i(129648);
    parama = b(-1, parama);
    AppMethodBeat.o(129648);
    return parama;
  }
  
  final <T> void a(Class<T> paramClass, List<T> paramList, Long paramLong)
  {
    AppMethodBeat.i(129652);
    long l;
    if (paramClass == czt.class)
    {
      paramClass = hcg;
      l = this.hce.kr(Thread.currentThread().getId());
      this.hce.delete("AppBrandStarApp", "", null);
      if (bo.es(paramList)) {
        break label216;
      }
      if (paramList == null) {
        break label211;
      }
    }
    label211:
    for (paramList = a.a.j.l((Iterable)paramList);; paramList = null)
    {
      s.a locala = new s.a();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (!bo.isNullOrNil(paramClass.bf(localObject)))
        {
          locala.field_username = paramClass.bf(localObject);
          locala.field_versionType = paramClass.be(localObject);
          locala.field_updateTime = paramClass.bd(localObject);
          i += 1;
          locala.field_orderSequence = (i * (t.axA() * 2));
          this.hce.a("AppBrandStarApp", null, locala.convertTo());
        }
      }
      if (paramClass == LocalUsageInfo.class)
      {
        paramClass = hch;
        break;
      }
      AppMethodBeat.o(129652);
      return;
    }
    label216:
    this.hce.nY(l);
    doNotify("batch", 3, paramLong);
    AppMethodBeat.o(129652);
  }
  
  public final boolean aG(String paramString, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(129651);
    if (bo.isNullOrNil(paramString)) {}
    for (paramString = localObject; paramString == null; paramString = this.hce.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "username", "versionType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null, null))
    {
      AppMethodBeat.o(129651);
      return false;
    }
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(129651);
    return bool;
  }
  
  public final int aH(String paramString, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(129653);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129653);
      return -1;
    }
    long l1;
    if (j.a.nk(paramInt))
    {
      localObject = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString, new String[] { "appInfo" });
      if ((localObject == null) || (TextUtils.isEmpty(((WxaAttributes)localObject).field_appInfo))) {
        i = 0;
      }
      while (i != 0)
      {
        AppMethodBeat.o(129653);
        return -3;
        l1 = ((WxaAttributes)localObject).ayC().hcP;
        l2 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        ab.i("MicroMsg.AppBrandStarAppStorage", "checkIsAddStarBlocked username[%s] until[%d] now[%d]", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
        if (l2 < l1) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    long l2 = bo.aox();
    Object localObject = String.format(Locale.US, "select %s from %s order by %s desc limit 1 offset 0", new Object[] { "orderSequence", "AppBrandStarApp", "orderSequence" });
    localObject = this.hce.a((String)localObject, null, 2);
    long l3;
    if ((localObject == null) || (((Cursor)localObject).isClosed()))
    {
      l1 = 0L;
      l3 = t.axA() * 2;
      i = j;
      if (aG(paramString, paramInt)) {
        break label366;
      }
      if (axx() >= t.axA())
      {
        AppMethodBeat.o(129653);
        return -2;
      }
    }
    else
    {
      if (!((Cursor)localObject).moveToFirst()) {}
      for (l1 = 0L;; l1 = ((Cursor)localObject).getLong(0))
      {
        ((Cursor)localObject).close();
        break;
      }
    }
    localObject = new s.a();
    ((s.a)localObject).field_username = paramString;
    ((s.a)localObject).field_versionType = paramInt;
    ((s.a)localObject).field_updateTime = l2;
    ((s.a)localObject).field_orderSequence = (l1 + l3);
    this.hcf.insertNotify((com.tencent.mm.sdk.e.c)localObject, false);
    if (aG(paramString, paramInt)) {
      doNotify("single", 2, localObject);
    }
    for (int i = 1;; i = 0)
    {
      label366:
      if (i != 0)
      {
        localObject = new cgb();
        ((cgb)localObject).username = paramString;
        ((cgb)localObject).wAx = paramInt;
        ((c)com.tencent.mm.kernel.g.E(c.class)).a(z.a((cgb)localObject), z.b.hcC);
      }
      if (i != 0)
      {
        AppMethodBeat.o(129653);
        return 0;
      }
      AppMethodBeat.o(129653);
      return -1;
    }
  }
  
  public final boolean aI(String paramString, int paramInt)
  {
    AppMethodBeat.i(129654);
    boolean bool = j(paramString, paramInt, true);
    AppMethodBeat.o(129654);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(129646);
    add(parama, e.aNS().oNc.getLooper());
    AppMethodBeat.o(129646);
  }
  
  public final int axx()
  {
    int i = 0;
    AppMethodBeat.i(129647);
    Cursor localCursor = this.hce.a("select count(*) from AppBrandStarApp", null, 0);
    if ((localCursor == null) || (localCursor.isClosed()))
    {
      AppMethodBeat.o(129647);
      return 0;
    }
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(129647);
    return i;
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> b(int paramInt, af.a parama)
  {
    LinkedList localLinkedList = null;
    AppMethodBeat.i(129649);
    af.a locala = parama;
    if (parama == null) {
      locala = af.a.hcJ;
    }
    if (locala == af.a.hcL)
    {
      parama = nv(paramInt);
      AppMethodBeat.o(129649);
      return parama;
    }
    if (paramInt <= 0) {}
    Object localObject;
    for (paramInt = t.axA();; paramInt = Math.min(t.axA(), paramInt))
    {
      parama = this.hce;
      localObject = String.format(Locale.US, "%s desc limit %d offset 0", new Object[] { "orderSequence", Integer.valueOf(paramInt) });
      localObject = parama.query("AppBrandStarApp", new String[] { "username", "versionType" }, null, null, null, null, (String)localObject);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(129649);
      return null;
    }
    if (af.a.hcK == locala)
    {
      parama = localLinkedList;
      if (((Cursor)localObject).moveToLast())
      {
        localLinkedList = new LinkedList();
        parama = new s.a();
        label172:
        do
        {
          parama.convertFrom((Cursor)localObject);
          localLinkedList.add(q.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { parama.field_username, Integer.valueOf(parama.field_versionType) }), parama.field_username, parama.field_versionType, -1L));
          if (af.a.hcK != locala) {
            break;
          }
        } while (((Cursor)localObject).moveToPrevious());
      }
    }
    for (;;)
    {
      parama = new ArrayList(localLinkedList.size());
      parama.addAll(localLinkedList);
      do
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(129649);
        return parama;
        parama = localLinkedList;
      } while (!((Cursor)localObject).moveToFirst());
      break;
      if (((Cursor)localObject).moveToNext()) {
        break label172;
      }
    }
  }
  
  public final boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(129655);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129655);
      return false;
    }
    Object localObject = new s.a();
    ((s.a)localObject).field_username = paramString;
    ((s.a)localObject).field_versionType = paramInt;
    boolean bool1 = bool2;
    if (this.hcf.get((com.tencent.mm.sdk.e.c)localObject, new String[] { "versionType", "username" }))
    {
      this.hcf.delete((com.tencent.mm.sdk.e.c)localObject, false, s.a.gUa);
      if (aG(paramString, paramInt)) {
        break label173;
      }
      doNotify("single", 5, localObject);
    }
    label173:
    for (bool1 = bool2;; bool1 = false)
    {
      if ((bool1) && (paramBoolean))
      {
        localObject = new cgb();
        ((cgb)localObject).username = paramString;
        ((cgb)localObject).wAx = paramInt;
        ((c)com.tencent.mm.kernel.g.E(c.class)).a(z.b((cgb)localObject), z.b.hcC);
      }
      AppMethodBeat.o(129655);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.s
 * JD-Core Version:    0.7.0.1
 */