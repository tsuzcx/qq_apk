package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends MAutoStorage<b>
{
  public static final String[] lqL;
  public final ISQLiteDatabase nFQ;
  
  static
  {
    AppMethodBeat.i(44488);
    lqL = new String[] { MAutoStorage.getCreateSQLs(b.lqK, "AppBrandAppLaunchUsernameDuplicateRecord2") };
    AppMethodBeat.o(44488);
  }
  
  public k(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.lqK, "AppBrandAppLaunchUsernameDuplicateRecord2", b.INDEX_CREATE);
    this.nFQ = paramISQLiteDatabase;
  }
  
  public final boolean P(String paramString, long paramLong)
  {
    AppMethodBeat.i(44487);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44487);
      return false;
    }
    b localb = new b();
    localb.field_usernameHash = paramString.hashCode();
    localb.field_username = paramString;
    boolean bool = get(localb, new String[0]);
    localb.field_updateTime = paramLong;
    if (bool)
    {
      bool = update(localb, new String[0]);
      AppMethodBeat.o(44487);
      return bool;
    }
    bool = insert(localb);
    AppMethodBeat.o(44487);
    return bool;
  }
  
  public final boolean aef(String paramString)
  {
    AppMethodBeat.i(279979);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(279979);
      return false;
    }
    b localb2 = new b();
    localb2.field_usernameHash = paramString.hashCode();
    b localb1;
    if ((get(localb2, new String[] { "usernameHash" })) && (localb2.field_username != null))
    {
      localb1 = localb2;
      if (localb2.field_username.equals(paramString)) {}
    }
    else
    {
      localb1 = null;
    }
    if ((localb1 != null) && (localb1.field_updateTime > 0L))
    {
      AppMethodBeat.o(279979);
      return true;
    }
    AppMethodBeat.o(279979);
    return false;
  }
  
  public final boolean aeg(String paramString)
  {
    AppMethodBeat.i(279980);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(279980);
      return false;
    }
    b localb = new b();
    localb.field_username = paramString;
    localb.field_usernameHash = paramString.hashCode();
    boolean bool = super.delete(localb, new String[] { "usernameHash" });
    AppMethodBeat.o(279980);
    return bool;
  }
  
  public final List<String> bJi()
  {
    AppMethodBeat.i(279977);
    Cursor localCursor = rawQuery(String.format("select attributes.appId from %s as duplicate inner join %s as attributes where duplicate.username = attributes.username", new Object[] { "AppBrandAppLaunchUsernameDuplicateRecord2", "WxaAttributesTable" }), new String[0]);
    ArrayList localArrayList = new ArrayList();
    if ((localCursor == null) || (localCursor.getColumnCount() <= 0))
    {
      AppMethodBeat.o(279977);
      return localArrayList;
    }
    for (;;)
    {
      try
      {
        if (!localCursor.moveToNext()) {
          break;
        }
        String str = localCursor.getString(0);
        if (Util.isNullOrNil(str)) {
          Log.i("MicroMsg.AppBrandLaunchUsernameDuplicateStorage", "appId is null, continue");
        } else {
          localList.add(str);
        }
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(279977);
      }
    }
    localCursor.close();
    AppMethodBeat.o(279977);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.k
 * JD-Core Version:    0.7.0.1
 */