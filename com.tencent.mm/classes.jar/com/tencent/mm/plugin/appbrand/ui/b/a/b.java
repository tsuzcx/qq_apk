package com.tencent.mm.plugin.appbrand.ui.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.n;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "guard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "deleteAll", "", "appId", "", "versionType", "version", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "fillInitConfig", "", "initConfigWC", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getScreenshotFilePath", "appVersion", "isDarkMode", "", "updateInfo", "info", "screenshotFilePath", "updateNotify", "item", "isNotify", "keys", "", "(Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;Z[Ljava/lang/String;)Z", "Companion", "VERSION_QUERY", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MAutoStorage<a>
{
  public static final String[] nVW;
  private static final String[] qDJ;
  public static final b.a upH;
  private final ISQLiteDatabase db;
  private final ReentrantReadWriteLock upI;
  
  static
  {
    AppMethodBeat.i(322613);
    upH = new b.a((byte)0);
    nVW = new String[] { MAutoStorage.getCreateSQLs(a.nVV, "AppBrandFakeNativeSplashScreenshot") };
    qDJ = new String[] { "appId", "versionType", "appVersion", "isDarkMode" };
    AppMethodBeat.o(322613);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.nVV, "AppBrandFakeNativeSplashScreenshot", n.INDEX_CREATE);
    AppMethodBeat.i(322598);
    this.db = paramISQLiteDatabase;
    this.upI = new ReentrantReadWriteLock();
    AppMethodBeat.o(322598);
  }
  
  public static final boolean cNh()
  {
    AppMethodBeat.i(322607);
    boolean bool = b.a.cNh();
    AppMethodBeat.o(322607);
    return bool;
  }
  
  public final int a(String paramString, int paramInt, b.b paramb)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(322629);
    s.u(paramb, "version");
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(322629);
      return 0;
    }
    localObject1 = new LinkedList();
    ((LinkedList)localObject1).add("appId='" + paramString + '\'');
    if (paramInt >= 0)
    {
      ((LinkedList)localObject1).add(s.X("versionType=", Integer.valueOf(paramInt)));
      if (!(paramb instanceof b.b.a))
      {
        if (!(paramb instanceof b.b.c)) {
          break label237;
        }
        ((LinkedList)localObject1).add(s.X("appVersion<", Integer.valueOf(((b.b.c)paramb).version)));
      }
    }
    ((LinkedList)localObject1).add("1=1");
    String str = i.b(((LinkedList)localObject1).toArray(), " AND ");
    s.s(str, "LinkedList<String>().app…ray(), \" AND \")\n        }");
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject2 = this.upI;
    localObject1 = ((ReentrantReadWriteLock)localObject2).readLock();
    if (((ReentrantReadWriteLock)localObject2).getWriteHoldCount() == 0) {}
    int j;
    for (i = ((ReentrantReadWriteLock)localObject2).getReadHoldCount();; i = 0)
    {
      j = 0;
      while (j < i)
      {
        ((ReentrantReadWriteLock.ReadLock)localObject1).unlock();
        j += 1;
      }
      label237:
      if (!(paramb instanceof b.b.b)) {
        break;
      }
      AppMethodBeat.o(322629);
      throw null;
    }
    localObject2 = ((ReentrantReadWriteLock)localObject2).writeLock();
    ((ReentrantReadWriteLock.WriteLock)localObject2).lock();
    int n;
    try
    {
      Object localObject3 = (Closeable)this.db.rawQuery(s.X("select screenshotFilePath from AppBrandFakeNativeSplashScreenshot where ", str), null, 2);
      try
      {
        Cursor localCursor = (Cursor)localObject3;
        LinkedList localLinkedList2 = new LinkedList();
        if ((localCursor != null) && (!localCursor.isClosed()) && (localCursor.moveToFirst()))
        {
          boolean bool;
          do
          {
            localLinkedList2.add(localCursor.getString(0));
            bool = localCursor.moveToNext();
          } while (bool);
        }
        kotlin.f.b.a((Closeable)localObject3, null);
        localLinkedList1.addAll((Collection)localLinkedList2);
        n = this.db.delete("AppBrandFakeNativeSplashScreenshot", str, null);
        localObject3 = ah.aiuX;
        j = k;
        while (j < i)
        {
          ((ReentrantReadWriteLock.ReadLock)localObject1).lock();
          j += 1;
          continue;
          paramString = finally;
        }
      }
      finally
      {
        try
        {
          AppMethodBeat.o(322629);
          throw paramString;
        }
        finally
        {
          kotlin.f.b.a((Closeable)localObject3, paramString);
          AppMethodBeat.o(322629);
        }
      }
      if (!s.p(b.b.a.upJ, paramb)) {
        break label547;
      }
    }
    finally
    {
      paramInt = m;
      while (paramInt < i)
      {
        ((ReentrantReadWriteLock.ReadLock)localObject1).lock();
        paramInt += 1;
        continue;
        ((ReentrantReadWriteLock.WriteLock)localObject2).unlock();
        localObject1 = ((Iterable)localLinkedList1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          y.deleteFile((String)((Iterator)localObject1).next());
        }
      }
      ((ReentrantReadWriteLock.WriteLock)localObject2).unlock();
      AppMethodBeat.o(322629);
    }
    if (paramInt < 0) {
      y.ew(b.a.agr(paramString), true);
    }
    label547:
    AppMethodBeat.o(322629);
    return n;
  }
  
  public final String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(322623);
    ReentrantReadWriteLock.ReadLock localReadLock = this.upI.readLock();
    localReadLock.lock();
    label157:
    for (;;)
    {
      try
      {
        Object localObject = (CharSequence)paramString;
        if (localObject != null)
        {
          if (((CharSequence)localObject).length() == 0)
          {
            break label157;
            if (i == 0)
            {
              localObject = new a();
              ((a)localObject).field_appId = paramString;
              ((a)localObject).field_versionType = paramInt1;
              ((a)localObject).field_appVersion = paramInt2;
              ((a)localObject).field_isDarkMode = paramBoolean;
              paramString = (IAutoDBItem)localObject;
              String[] arrayOfString = qDJ;
              if (super.get(paramString, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length)))
              {
                paramString = ((a)localObject).field_screenshotFilePath;
                return paramString;
              }
            }
          }
          else
          {
            i = 0;
            continue;
          }
          paramString = null;
          continue;
        }
        int i = 1;
      }
      finally
      {
        localReadLock.unlock();
        AppMethodBeat.o(322623);
      }
    }
  }
  
  public final boolean a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    m = 0;
    int k = 0;
    AppMethodBeat.i(322618);
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(322618);
      return false;
    }
    Object localObject2 = this.upI;
    localObject1 = ((ReentrantReadWriteLock)localObject2).readLock();
    if (((ReentrantReadWriteLock)localObject2).getWriteHoldCount() == 0) {}
    for (i = ((ReentrantReadWriteLock)localObject2).getReadHoldCount();; i = 0)
    {
      int j = 0;
      while (j < i)
      {
        ((ReentrantReadWriteLock.ReadLock)localObject1).unlock();
        j += 1;
      }
    }
    localObject2 = ((ReentrantReadWriteLock)localObject2).writeLock();
    ((ReentrantReadWriteLock.WriteLock)localObject2).lock();
    for (;;)
    {
      try
      {
        localObject3 = new a();
        ((a)localObject3).field_appId = paramString1;
        ((a)localObject3).field_versionType = paramInt1;
        ((a)localObject3).field_appVersion = paramInt2;
        ((a)localObject3).field_isDarkMode = paramBoolean;
        paramString1 = (IAutoDBItem)localObject3;
        String[] arrayOfString = qDJ;
        if (super.get(paramString1, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length))) {
          continue;
        }
        paramInt1 = 1;
        paramString1 = ((a)localObject3).field_screenshotFilePath;
        ((a)localObject3).field_screenshotFilePath = paramString2;
        if (paramInt1 == 0) {
          continue;
        }
        paramBoolean = super.insert((IAutoDBItem)localObject3);
        paramString2 = (CharSequence)paramString1;
        if (paramString2 == null) {
          continue;
        }
        if (paramString2.length() != 0) {
          continue;
        }
      }
      finally
      {
        Object localObject3;
        paramInt1 = m;
        continue;
        paramInt1 = 1;
        continue;
      }
      paramInt2 = k;
      if (paramInt1 == 0)
      {
        y.deleteFile(paramString1);
        paramInt2 = k;
      }
      if (paramInt2 >= i) {
        continue;
      }
      ((ReentrantReadWriteLock.ReadLock)localObject1).lock();
      paramInt2 += 1;
      continue;
      paramInt1 = 0;
      continue;
      paramString2 = (IAutoDBItem)localObject3;
      localObject3 = qDJ;
      paramBoolean = super.update(paramString2, (String[])Arrays.copyOf((Object[])localObject3, localObject3.length));
      continue;
      paramInt1 = 0;
    }
    ((ReentrantReadWriteLock.WriteLock)localObject2).unlock();
    AppMethodBeat.o(322618);
    return paramBoolean;
    while (paramInt1 < i)
    {
      ((ReentrantReadWriteLock.ReadLock)localObject1).lock();
      paramInt1 += 1;
    }
    ((ReentrantReadWriteLock.WriteLock)localObject2).unlock();
    AppMethodBeat.o(322618);
    throw paramString1;
  }
  
  public final int agq(String paramString)
  {
    AppMethodBeat.i(322631);
    int i = a(this, paramString, 0, null, 6);
    AppMethodBeat.o(322631);
    return i;
  }
  
  public final int dp(String paramString, int paramInt)
  {
    AppMethodBeat.i(322630);
    paramInt = a(this, paramString, paramInt, null, 4);
    AppMethodBeat.o(322630);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b.a.b
 * JD-Core Version:    0.7.0.1
 */