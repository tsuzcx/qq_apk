package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.b;
import com.tencent.mm.plugin.appbrand.ae.b.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.c.a;

public final class bi
  extends g
  implements b
{
  public static final String[] INDEX_CREATE;
  static final IAutoDBItem.MAutoDBInfo nVV;
  public static final String[] qDJ;
  public String field_versionDesc;
  
  static
  {
    AppMethodBeat.i(320149);
    INDEX_CREATE = new String[] { String.format(Locale.ENGLISH, "CREATE INDEX IF NOT EXISTS %sPkgPathIndex ON %s(%s)", new Object[] { "AppBrandWxaPkgManifestRecordWithDesc", "AppBrandWxaPkgManifestRecordWithDesc", "pkgPath" }) };
    qDJ = new String[] { "appId", "debugType", "versionDesc" };
    Object localObject = g.aJm();
    nVV = (IAutoDBItem.MAutoDBInfo)localObject;
    ((IAutoDBItem.MAutoDBInfo)localObject).columns = ((String[])a.d(((IAutoDBItem.MAutoDBInfo)localObject).columns, "versionDesc"));
    nVV.colsMap.put("versionDesc", "TEXT");
    localObject = new StringBuilder();
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = nVV;
    localMAutoDBInfo.sql += ", versionDesc TEXT ";
    localObject = new StringBuilder();
    localMAutoDBInfo = nVV;
    localMAutoDBInfo.sql += b.a.s(qDJ);
    AppMethodBeat.o(320149);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(320161);
    super.convertFrom(paramCursor);
    int i = paramCursor.getColumnIndex("versionDesc");
    if (i >= 0) {
      this.field_versionDesc = paramCursor.getString(i);
    }
    AppMethodBeat.o(320161);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(320167);
    ContentValues localContentValues = super.convertTo();
    localContentValues.put("versionDesc", this.field_versionDesc);
    AppMethodBeat.o(320167);
    return localContentValues;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
  
  public final String[] getKeys()
  {
    return qDJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bi
 * JD-Core Version:    0.7.0.1
 */