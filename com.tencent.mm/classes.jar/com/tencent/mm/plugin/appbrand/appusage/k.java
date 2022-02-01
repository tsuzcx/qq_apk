package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends j<b>
{
  public static final String[] hGX;
  public final e jKa;
  
  static
  {
    AppMethodBeat.i(44488);
    hGX = new String[] { j.getCreateSQLs(b.hGW, "AppBrandAppLaunchUsernameDuplicateRecord2") };
    AppMethodBeat.o(44488);
  }
  
  public k(e parame)
  {
    super(parame, b.hGW, "AppBrandAppLaunchUsernameDuplicateRecord2", b.INDEX_CREATE);
    this.jKa = parame;
  }
  
  public final b Nk(String paramString)
  {
    AppMethodBeat.i(222147);
    b localb = new b();
    localb.field_usernameHash = paramString.hashCode();
    if ((!get(localb, new String[] { "usernameHash" })) || (localb.field_username == null) || (!localb.field_username.equals(paramString)))
    {
      AppMethodBeat.o(222147);
      return null;
    }
    AppMethodBeat.o(222147);
    return localb;
  }
  
  public final boolean Nl(String paramString)
  {
    AppMethodBeat.i(222149);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(222149);
      return false;
    }
    paramString = Nk(paramString);
    if ((paramString != null) && (paramString.field_updateTime > 0L))
    {
      AppMethodBeat.o(222149);
      return true;
    }
    AppMethodBeat.o(222149);
    return false;
  }
  
  public final boolean Nm(String paramString)
  {
    AppMethodBeat.i(222150);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(222150);
      return false;
    }
    b localb = new b();
    localb.field_username = paramString;
    localb.field_usernameHash = paramString.hashCode();
    boolean bool = super.delete(localb, new String[] { "usernameHash" });
    AppMethodBeat.o(222150);
    return bool;
  }
  
  public final boolean P(String paramString, long paramLong)
  {
    AppMethodBeat.i(44487);
    if (bu.isNullOrNil(paramString))
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
  
  public final List<String> bcE()
  {
    AppMethodBeat.i(222148);
    Cursor localCursor = rawQuery(String.format("select attributes.appId from %s as duplicate inner join %s as attributes where duplicate.username = attributes.username", new Object[] { "AppBrandAppLaunchUsernameDuplicateRecord2", "WxaAttributesTable" }), new String[0]);
    ArrayList localArrayList = new ArrayList();
    if ((localCursor == null) || (localCursor.getColumnCount() <= 0))
    {
      AppMethodBeat.o(222148);
      return localArrayList;
    }
    try
    {
      if (localCursor.moveToNext()) {}
      return localList;
    }
    finally
    {
      localCursor.close();
      AppMethodBeat.o(222148);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.k
 * JD-Core Version:    0.7.0.1
 */