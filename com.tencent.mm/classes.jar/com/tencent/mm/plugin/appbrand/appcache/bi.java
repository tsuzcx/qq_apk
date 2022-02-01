package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.plugin.appbrand.ab.b.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.b.a;

public final class bi
  extends g
  implements b
{
  public static final String[] INDEX_CREATE;
  static final IAutoDBItem.MAutoDBInfo lqK;
  public static final String[] nDP;
  public String field_versionDesc;
  
  static
  {
    AppMethodBeat.i(187429);
    INDEX_CREATE = new String[] { String.format(Locale.ENGLISH, "CREATE INDEX IF NOT EXISTS %sPkgPathIndex ON %s(%s)", new Object[] { "AppBrandWxaPkgManifestRecordWithDesc", "AppBrandWxaPkgManifestRecordWithDesc", "pkgPath" }) };
    nDP = new String[] { "appId", "debugType", "versionDesc" };
    Object localObject = g.aoY();
    lqK = (IAutoDBItem.MAutoDBInfo)localObject;
    ((IAutoDBItem.MAutoDBInfo)localObject).columns = ((String[])a.b(((IAutoDBItem.MAutoDBInfo)localObject).columns, "versionDesc"));
    lqK.colsMap.put("versionDesc", "TEXT");
    localObject = new StringBuilder();
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = lqK;
    localMAutoDBInfo.sql += ", versionDesc TEXT ";
    localObject = new StringBuilder();
    localMAutoDBInfo = lqK;
    localMAutoDBInfo.sql += b.a.s(nDP);
    AppMethodBeat.o(187429);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(187425);
    super.convertFrom(paramCursor);
    int i = paramCursor.getColumnIndex("versionDesc");
    if (i >= 0) {
      this.field_versionDesc = paramCursor.getString(i);
    }
    AppMethodBeat.o(187425);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(187427);
    ContentValues localContentValues = super.convertTo();
    localContentValues.put("versionDesc", this.field_versionDesc);
    AppMethodBeat.o(187427);
    return localContentValues;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return lqK;
  }
  
  public final String[] getKeys()
  {
    return nDP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bi
 * JD-Core Version:    0.7.0.1
 */