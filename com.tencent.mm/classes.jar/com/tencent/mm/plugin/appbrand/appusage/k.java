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
  public static final String[] iBh;
  public final ISQLiteDatabase kLX;
  
  static
  {
    AppMethodBeat.i(44488);
    iBh = new String[] { MAutoStorage.getCreateSQLs(b.iBg, "AppBrandAppLaunchUsernameDuplicateRecord2") };
    AppMethodBeat.o(44488);
  }
  
  public k(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.iBg, "AppBrandAppLaunchUsernameDuplicateRecord2", b.INDEX_CREATE);
    this.kLX = paramISQLiteDatabase;
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
  
  public final b Ws(String paramString)
  {
    AppMethodBeat.i(226387);
    b localb = new b();
    localb.field_usernameHash = paramString.hashCode();
    if ((!get(localb, new String[] { "usernameHash" })) || (localb.field_username == null) || (!localb.field_username.equals(paramString)))
    {
      AppMethodBeat.o(226387);
      return null;
    }
    AppMethodBeat.o(226387);
    return localb;
  }
  
  public final boolean Wt(String paramString)
  {
    AppMethodBeat.i(226389);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(226389);
      return false;
    }
    paramString = Ws(paramString);
    if ((paramString != null) && (paramString.field_updateTime > 0L))
    {
      AppMethodBeat.o(226389);
      return true;
    }
    AppMethodBeat.o(226389);
    return false;
  }
  
  public final boolean Wu(String paramString)
  {
    AppMethodBeat.i(226390);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(226390);
      return false;
    }
    b localb = new b();
    localb.field_username = paramString;
    localb.field_usernameHash = paramString.hashCode();
    boolean bool = super.delete(localb, new String[] { "usernameHash" });
    AppMethodBeat.o(226390);
    return bool;
  }
  
  public final List<String> bxT()
  {
    AppMethodBeat.i(226388);
    Cursor localCursor = rawQuery(String.format("select attributes.appId from %s as duplicate inner join %s as attributes where duplicate.username = attributes.username", new Object[] { "AppBrandAppLaunchUsernameDuplicateRecord2", "WxaAttributesTable" }), new String[0]);
    ArrayList localArrayList = new ArrayList();
    if ((localCursor == null) || (localCursor.getColumnCount() <= 0))
    {
      AppMethodBeat.o(226388);
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
        AppMethodBeat.o(226388);
      }
    }
    localCursor.close();
    AppMethodBeat.o(226388);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.k
 * JD-Core Version:    0.7.0.1
 */