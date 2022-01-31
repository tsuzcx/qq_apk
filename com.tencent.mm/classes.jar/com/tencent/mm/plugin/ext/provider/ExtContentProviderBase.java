package com.tencent.mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtContentProviderBase
  extends ContentProvider
{
  protected static boolean jLZ;
  private static HashMap<String, Long> mel;
  protected MatrixCursor jLW;
  private long meg;
  private String meh;
  public String mei;
  private String[] mej;
  private int mek;
  
  static
  {
    AppMethodBeat.i(20340);
    jLZ = false;
    mel = new HashMap();
    AppMethodBeat.o(20340);
  }
  
  public ExtContentProviderBase()
  {
    AppMethodBeat.i(20326);
    this.jLW = new MatrixCursor(new String[0]);
    this.meg = bo.yB();
    this.mei = "";
    this.mek = 0;
    AppMethodBeat.o(20326);
  }
  
  private int btC()
  {
    AppMethodBeat.i(20330);
    int i = (int)bo.av(this.meg);
    AppMethodBeat.o(20330);
    return i;
  }
  
  private void dP(Context paramContext)
  {
    AppMethodBeat.i(20339);
    if (paramContext == null)
    {
      ab.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
      AppMethodBeat.o(20339);
      return;
    }
    ab.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
    this.mej = paramContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
    if (this.mej == null) {
      ab.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
    }
    AppMethodBeat.o(20339);
  }
  
  private static String i(Uri paramUri)
  {
    AppMethodBeat.i(20336);
    if (paramUri == null)
    {
      AppMethodBeat.o(20336);
      return "";
    }
    paramUri = bo.nullAsNil(paramUri.getQueryParameter("appid"));
    AppMethodBeat.o(20336);
    return paramUri;
  }
  
  protected final void S(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(20329);
    ab.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { btD(), this.mei, Integer.valueOf(this.mek), Integer.valueOf(paramInt2), Integer.valueOf(btC()) });
    h.qsU.e(10505, new Object[] { btD(), this.mei, Integer.valueOf(this.mek), Integer.valueOf(paramInt2), Integer.valueOf(btC()), Integer.valueOf(paramInt3) });
    h.qsU.idkeyStat(300L, paramInt1, 1L, false);
    AppMethodBeat.o(20329);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(20332);
    this.mei = i(paramUri);
    dP(paramContext);
    this.mek = paramInt;
    this.meg = bo.yB();
    AppMethodBeat.o(20332);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(20333);
    this.mei = i(paramUri);
    if (paramArrayOfString == null) {
      dP(paramContext);
    }
    for (;;)
    {
      this.mek = paramInt;
      this.meg = bo.yB();
      AppMethodBeat.o(20333);
      return;
      this.mej = paramArrayOfString;
    }
  }
  
  protected final void a(Uri paramUri, Context paramContext, UriMatcher paramUriMatcher)
  {
    AppMethodBeat.i(20331);
    this.mei = i(paramUri);
    dP(paramContext);
    if (paramUriMatcher != null)
    {
      this.mek = paramUriMatcher.match(paramUri);
      if (this.mek < 0) {
        this.mek = 0;
      }
    }
    this.meg = bo.yB();
    AppMethodBeat.o(20331);
  }
  
  protected final boolean aVH()
  {
    AppMethodBeat.i(20335);
    try
    {
      ab.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
      if (!jLZ)
      {
        b localb = new b();
        localb.b(4000L, new ExtContentProviderBase.1(this, localb));
      }
      if ((aw.RG()) && (aw.aaB()) && (!aw.QP())) {}
      for (jLZ = true;; jLZ = false)
      {
        ab.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + jLZ);
        boolean bool = jLZ;
        AppMethodBeat.o(20335);
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.ExtContentProviderBase", localException.getMessage());
      ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException, "", new Object[0]);
      AppMethodBeat.o(20335);
    }
  }
  
  protected final String btD()
  {
    AppMethodBeat.i(20334);
    if (!bo.isNullOrNil(this.meh))
    {
      str = this.meh;
      AppMethodBeat.o(20334);
      return str;
    }
    if ((this.mej == null) || (this.mej.length <= 0))
    {
      AppMethodBeat.o(20334);
      return "";
    }
    String str = this.mej[0];
    AppMethodBeat.o(20334);
    return str;
  }
  
  protected final int btE()
  {
    AppMethodBeat.i(20338);
    if (bo.isNullOrNil(this.mei))
    {
      ab.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(20338);
      return 7;
    }
    if ((this.mej == null) || (this.mej.length <= 0))
    {
      ab.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(20338);
      return 6;
    }
    try
    {
      localf = g.ca(this.mei, true);
      if (localf == null)
      {
        ab.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        AppMethodBeat.o(20338);
        return 13;
      }
      if (localf.field_status == 3)
      {
        ab.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localf.field_packageName });
        i = 10;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          int j;
          label254:
          this.meh = ((String)localObject2);
          i = 1;
          if (i != 1) {}
        }
        catch (Exception localException2)
        {
          f localf;
          Object localObject1;
          Object localObject2;
          i = 1;
          continue;
        }
        try
        {
          localObject2 = (Integer)c.b.vJq.get(Integer.valueOf(this.mek));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            ej(5, 16);
            ab.i("MicroMsg.ExtContentProviderBase", "api flag = null");
            localObject1 = Integer.valueOf(64);
          }
          if (!g.b(localf, ((Integer)localObject1).intValue()))
          {
            i = 11;
            continue;
          }
          ab.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
        }
        catch (Exception localException3)
        {
          continue;
        }
        localException1 = localException1;
        i = 0;
        ab.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { localException1.getMessage() });
        ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException1, "", new Object[0]);
      }
    }
    try
    {
      localObject1 = Long.valueOf(bo.a((Long)mel.get(this.mei), 0L));
      ab.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - ((Long)localObject1).longValue() > 3600000L)
      {
        ab.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.mei });
        a.a.caj().WF(this.mei);
        mel.put(this.mei, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(20338);
      return i;
    }
    catch (Exception localException4)
    {
      break label400;
      i = 0;
      break label316;
      i += 1;
      break label254;
    }
    localObject1 = this.mej;
    j = localObject1.length;
    i = 0;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if ((!((String)localObject2).equals(localf.field_packageName)) || (!p.a(ah.getContext(), localf, (String)localObject2, false))) {
        break label453;
      }
      ab.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject2 });
    }
  }
  
  protected final boolean dO(Context paramContext)
  {
    AppMethodBeat.i(20337);
    if (paramContext == null)
    {
      ab.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
      AppMethodBeat.o(20337);
      return false;
    }
    if (bo.isNullOrNil(this.mei))
    {
      ab.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(20337);
      return false;
    }
    if ((this.mej == null) || (this.mej.length <= 0))
    {
      ab.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(20337);
      return false;
    }
    try
    {
      localf = g.ca(this.mei, true);
      if (localf == null)
      {
        ab.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        AppMethodBeat.o(20337);
        return false;
      }
      if (localf.field_status == 3)
      {
        ab.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localf.field_packageName });
        bool = false;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        try
        {
          int j;
          label272:
          this.meh = ((String)localObject);
          bool = true;
          if (!bool) {}
        }
        catch (Exception paramContext)
        {
          f localf;
          Object localObject;
          bool = true;
          continue;
        }
        try
        {
          localObject = (Integer)c.b.vJq.get(Integer.valueOf(this.mek));
          paramContext = (Context)localObject;
          if (localObject == null) {
            paramContext = Integer.valueOf(64);
          }
          if (!g.b(localf, paramContext.intValue()))
          {
            bool = false;
            continue;
          }
          ab.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
        }
        catch (Exception paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        bool = false;
        ab.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { paramContext.getMessage() });
        ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", paramContext, "", new Object[0]);
      }
    }
    try
    {
      paramContext = Long.valueOf(bo.a((Long)mel.get(this.mei), 0L));
      ab.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { paramContext, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - paramContext.longValue() > 3600000L)
      {
        ab.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.mei });
        a.a.caj().WF(this.mei);
        mel.put(this.mei, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(20337);
      return bool;
    }
    catch (Exception paramContext)
    {
      break label405;
      bool = false;
      break label335;
      i += 1;
      break label272;
    }
    paramContext = this.mej;
    j = paramContext.length;
    i = 0;
    if (i < j)
    {
      localObject = paramContext[i];
      if ((!((String)localObject).equals(localf.field_packageName)) || (!p.a(ah.getContext(), localf, (String)localObject, false))) {
        break label460;
      }
      ab.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject });
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  protected final void ej(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20328);
    ab.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { btD(), this.mei, Integer.valueOf(this.mek), Integer.valueOf(paramInt1), Integer.valueOf(btC()) });
    h.qsU.e(10505, new Object[] { btD(), this.mei, Integer.valueOf(this.mek), Integer.valueOf(paramInt1), Integer.valueOf(btC()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(20328);
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  protected final void vA(int paramInt)
  {
    AppMethodBeat.i(20327);
    ab.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { btD(), this.mei, Integer.valueOf(this.mek), Integer.valueOf(paramInt), Integer.valueOf(btC()) });
    h.qsU.e(10505, new Object[] { btD(), this.mei, Integer.valueOf(this.mek), Integer.valueOf(paramInt), Integer.valueOf(btC()) });
    AppMethodBeat.o(20327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
 * JD-Core Version:    0.7.0.1
 */