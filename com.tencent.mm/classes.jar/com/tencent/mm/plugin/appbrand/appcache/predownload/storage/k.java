package com.tencent.mm.plugin.appbrand.appcache.predownload.storage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentContentResolver;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentProvider;", "()V", "TAG", "", "URI_INVALID_CONTACT", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getURI_INVALID_CONTACT", "()Landroid/net/Uri;", "URI_INVALID_CONTACT$delegate", "Lkotlin/Lazy;", "resolver", "Landroid/content/ContentResolver;", "getResolver", "()Landroid/content/ContentResolver;", "getInvalidCodeReportIdForAppId", "", "appId", "getInvalidCodeTimestampForAppId", "", "getInvalidContactReportIdForUsername", "username", "getInvalidContactTimestampForUsername", "removeInvalidCodeTimestampForAppId", "", "removeInvalidContactTimestampForUsername", "updateInvalidCodeTimestampForAppId", "reportId", "updateInvalidContactTimestampForUsername", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k qKk;
  private static final j qKl;
  
  static
  {
    AppMethodBeat.i(320436);
    qKk = new k();
    qKl = kotlin.k.cm((a)a.qKm);
    AppMethodBeat.o(320436);
  }
  
  public static long VN(String paramString)
  {
    AppMethodBeat.i(320433);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320433);
      return -1L;
    }
    for (;;)
    {
      try
      {
        localObject1 = MMApplicationContext.getContext().getContentResolver();
        if (localObject1 != null)
        {
          localObject1 = ((ContentResolver)localObject1).query((Uri)qKl.getValue(), null, "username=?", new String[] { paramString }, null);
          if (localObject1 != null) {
            localObject1 = (Closeable)localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        Log.e("MicroMsg.WxaSyncCmdPersistentContentResolver", "getInvalidContactTimestampForUsername(" + paramString + ") get exception:" + localException);
        continue;
      }
      try
      {
        localObject2 = (Cursor)localObject1;
        if ((!((Cursor)localObject2).isClosed()) && (((Cursor)localObject2).moveToFirst()))
        {
          h localh = new h();
          localh.convertFrom((Cursor)localObject2);
          long l = localh.field_timestamp;
          b.a((Closeable)localObject1, null);
          AppMethodBeat.o(320433);
          return l;
        }
        localObject2 = ah.aiuX;
        b.a((Closeable)localObject1, null);
        AppMethodBeat.o(320433);
        return -1L;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(320433);
          throw localThrowable;
        }
        finally
        {
          b.a((Closeable)localObject1, localThrowable);
          AppMethodBeat.o(320433);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/net/Uri;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Uri>
  {
    public static final a qKm;
    
    static
    {
      AppMethodBeat.i(320440);
      qKm = new a();
      AppMethodBeat.o(320440);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.storage.k
 * JD-Core Version:    0.7.0.1
 */