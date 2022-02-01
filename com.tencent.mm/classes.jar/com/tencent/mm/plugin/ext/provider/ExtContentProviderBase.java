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
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.pluginsdk.e.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtContentProviderBase
  extends ContentProvider
{
  protected static boolean nTB;
  private static HashMap<String, Long> rlx;
  protected MatrixCursor nTy;
  private long rls;
  private String rlt;
  public String rlu;
  private String[] rlv;
  private int rlw;
  
  static
  {
    AppMethodBeat.i(24419);
    nTB = false;
    rlx = new HashMap();
    AppMethodBeat.o(24419);
  }
  
  public ExtContentProviderBase()
  {
    AppMethodBeat.i(24405);
    this.nTy = new MatrixCursor(new String[0]);
    this.rls = bu.HQ();
    this.rlu = "";
    this.rlw = 0;
    AppMethodBeat.o(24405);
  }
  
  private int ctK()
  {
    AppMethodBeat.i(24409);
    int i = (int)bu.aO(this.rls);
    AppMethodBeat.o(24409);
    return i;
  }
  
  private void eL(Context paramContext)
  {
    AppMethodBeat.i(24418);
    if (paramContext == null)
    {
      ae.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
      AppMethodBeat.o(24418);
      return;
    }
    ae.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
    this.rlv = paramContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
    if (this.rlv == null) {
      ae.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
    }
    AppMethodBeat.o(24418);
  }
  
  private static String r(Uri paramUri)
  {
    AppMethodBeat.i(24415);
    if (paramUri == null)
    {
      AppMethodBeat.o(24415);
      return "";
    }
    paramUri = bu.nullAsNil(paramUri.getQueryParameter("appid"));
    AppMethodBeat.o(24415);
    return paramUri;
  }
  
  protected final void DS(int paramInt)
  {
    AppMethodBeat.i(24406);
    ae.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { ctL(), this.rlu, Integer.valueOf(this.rlw), Integer.valueOf(paramInt), Integer.valueOf(ctK()) });
    com.tencent.mm.plugin.report.service.g.yxI.f(10505, new Object[] { ctL(), this.rlu, Integer.valueOf(this.rlw), Integer.valueOf(paramInt), Integer.valueOf(ctK()) });
    AppMethodBeat.o(24406);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(24411);
    this.rlu = r(paramUri);
    eL(paramContext);
    this.rlw = paramInt;
    this.rls = bu.HQ();
    AppMethodBeat.o(24411);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(24412);
    this.rlu = r(paramUri);
    if (paramArrayOfString == null) {
      eL(paramContext);
    }
    for (;;)
    {
      this.rlw = paramInt;
      this.rls = bu.HQ();
      AppMethodBeat.o(24412);
      return;
      this.rlv = paramArrayOfString;
    }
  }
  
  protected final void a(Uri paramUri, Context paramContext, UriMatcher paramUriMatcher)
  {
    AppMethodBeat.i(24410);
    this.rlu = r(paramUri);
    eL(paramContext);
    if (paramUriMatcher != null)
    {
      this.rlw = paramUriMatcher.match(paramUri);
      if (this.rlw < 0) {
        this.rlw = 0;
      }
    }
    this.rls = bu.HQ();
    AppMethodBeat.o(24410);
  }
  
  protected final void ab(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(24408);
    ae.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { ctL(), this.rlu, Integer.valueOf(this.rlw), Integer.valueOf(paramInt2), Integer.valueOf(ctK()) });
    com.tencent.mm.plugin.report.service.g.yxI.f(10505, new Object[] { ctL(), this.rlu, Integer.valueOf(this.rlw), Integer.valueOf(paramInt2), Integer.valueOf(ctK()), Integer.valueOf(paramInt3) });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(300L, paramInt1, 1L, false);
    AppMethodBeat.o(24408);
  }
  
  protected final boolean bNl()
  {
    AppMethodBeat.i(24414);
    try
    {
      ae.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
      if (!nTB)
      {
        final b localb = new b();
        localb.c(4000L, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24404);
            try
            {
              boolean bool = bc.ajM();
              if (!bool)
              {
                AppMethodBeat.o(24404);
                return;
              }
              bc.ajj().a(new bq(new bq.a()
              {
                public final void a(e paramAnonymous2e)
                {
                  AppMethodBeat.i(24403);
                  ae.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                  ExtContentProviderBase.1.this.nTH.countDown();
                  AppMethodBeat.o(24403);
                }
              }), 0);
              AppMethodBeat.o(24404);
              return;
            }
            catch (Exception localException)
            {
              ae.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
              localb.countDown();
              AppMethodBeat.o(24404);
            }
          }
        });
      }
      if ((bc.ajM()) && (bc.aCh()) && (!bc.aiT())) {}
      for (nTB = true;; nTB = false)
      {
        ae.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + nTB);
        boolean bool = nTB;
        AppMethodBeat.o(24414);
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.ExtContentProviderBase", localException.getMessage());
      ae.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException, "", new Object[0]);
      AppMethodBeat.o(24414);
    }
  }
  
  public final String ctL()
  {
    AppMethodBeat.i(24413);
    if (!bu.isNullOrNil(this.rlt))
    {
      str = this.rlt;
      AppMethodBeat.o(24413);
      return str;
    }
    if ((this.rlv == null) || (this.rlv.length <= 0))
    {
      AppMethodBeat.o(24413);
      return "";
    }
    String str = this.rlv[0];
    AppMethodBeat.o(24413);
    return str;
  }
  
  protected final int ctM()
  {
    AppMethodBeat.i(24417);
    if (bu.isNullOrNil(this.rlu))
    {
      ae.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(24417);
      return 7;
    }
    if ((this.rlv == null) || (this.rlv.length <= 0))
    {
      ae.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(24417);
      return 6;
    }
    try
    {
      localg = h.m(this.rlu, true, false);
      if (localg == null)
      {
        ae.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        AppMethodBeat.o(24417);
        return 13;
      }
      if (localg.field_status == 3)
      {
        ae.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localg.field_packageName });
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
          label256:
          this.rlt = ((String)localObject2);
          i = 1;
          if (i != 1) {}
        }
        catch (Exception localException2)
        {
          com.tencent.mm.pluginsdk.model.app.g localg;
          Object localObject1;
          Object localObject2;
          i = 1;
          continue;
        }
        try
        {
          localObject2 = (Integer)e.c.FbP.get(Integer.valueOf(this.rlw));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            fz(5, 16);
            ae.i("MicroMsg.ExtContentProviderBase", "api flag = null");
            localObject1 = Integer.valueOf(64);
          }
          if (!h.b(localg, ((Integer)localObject1).intValue()))
          {
            i = 11;
            continue;
          }
          ae.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
        }
        catch (Exception localException3)
        {
          continue;
        }
        localException1 = localException1;
        i = 0;
        ae.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { localException1.getMessage() });
        ae.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException1, "", new Object[0]);
      }
    }
    try
    {
      localObject1 = Long.valueOf(bu.a((Long)rlx.get(this.rlu), 0L));
      ae.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - ((Long)localObject1).longValue() > 3600000L)
      {
        ae.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.rlu });
        a.a.dBn().avm(this.rlu);
        rlx.put(this.rlu, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(24417);
      return i;
    }
    catch (Exception localException4)
    {
      break label402;
      i = 0;
      break label318;
      i += 1;
      break label256;
    }
    localObject1 = this.rlv;
    j = localObject1.length;
    i = 0;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if ((!((String)localObject2).equals(localg.field_packageName)) || (!com.tencent.mm.pluginsdk.model.app.q.a(ak.getContext(), localg, (String)localObject2, false))) {
        break label455;
      }
      ae.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject2 });
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  protected final boolean eK(Context paramContext)
  {
    AppMethodBeat.i(24416);
    if (paramContext == null)
    {
      ae.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
      AppMethodBeat.o(24416);
      return false;
    }
    if (bu.isNullOrNil(this.rlu))
    {
      ae.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(24416);
      return false;
    }
    if ((this.rlv == null) || (this.rlv.length <= 0))
    {
      ae.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(24416);
      return false;
    }
    try
    {
      localg = h.m(this.rlu, true, false);
      if (localg == null)
      {
        ae.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        AppMethodBeat.o(24416);
        return false;
      }
      if (localg.field_status == 3)
      {
        ae.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localg.field_packageName });
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
          label274:
          this.rlt = ((String)localObject);
          bool = true;
          if (!bool) {}
        }
        catch (Exception paramContext)
        {
          com.tencent.mm.pluginsdk.model.app.g localg;
          Object localObject;
          bool = true;
          continue;
        }
        try
        {
          localObject = (Integer)e.c.FbP.get(Integer.valueOf(this.rlw));
          paramContext = (Context)localObject;
          if (localObject == null) {
            paramContext = Integer.valueOf(64);
          }
          if (!h.b(localg, paramContext.intValue()))
          {
            bool = false;
            continue;
          }
          ae.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
        }
        catch (Exception paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        bool = false;
        ae.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { paramContext.getMessage() });
        ae.printErrStackTrace("MicroMsg.ExtContentProviderBase", paramContext, "", new Object[0]);
      }
    }
    try
    {
      paramContext = Long.valueOf(bu.a((Long)rlx.get(this.rlu), 0L));
      ae.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { paramContext, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - paramContext.longValue() > 3600000L)
      {
        ae.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.rlu });
        a.a.dBn().avm(this.rlu);
        rlx.put(this.rlu, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(24416);
      return bool;
    }
    catch (Exception paramContext)
    {
      break label407;
      bool = false;
      break label337;
      i += 1;
      break label274;
    }
    paramContext = this.rlv;
    j = paramContext.length;
    i = 0;
    if (i < j)
    {
      localObject = paramContext[i];
      if ((!((String)localObject).equals(localg.field_packageName)) || (!com.tencent.mm.pluginsdk.model.app.q.a(ak.getContext(), localg, (String)localObject, false))) {
        break label462;
      }
      ae.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject });
    }
  }
  
  protected final void fz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24407);
    ae.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { ctL(), this.rlu, Integer.valueOf(this.rlw), Integer.valueOf(paramInt1), Integer.valueOf(ctK()) });
    com.tencent.mm.plugin.report.service.g.yxI.f(10505, new Object[] { ctL(), this.rlu, Integer.valueOf(this.rlw), Integer.valueOf(paramInt1), Integer.valueOf(ctK()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24407);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
 * JD-Core Version:    0.7.0.1
 */