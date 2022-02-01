package com.tencent.mm.plugin.appbrand.ab;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoDBFieldAnnotation;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a
  extends MAutoStorage<a>
{
  public static final String[] lqL;
  
  static
  {
    AppMethodBeat.i(48359);
    lqL = new String[] { MAutoStorage.getCreateSQLs(a.nFK, "AppBrandCommonKVBinaryData") };
    AppMethodBeat.o(48359);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.nFK, "AppBrandCommonKVBinaryData", null);
  }
  
  public final void clear(String paramString)
  {
    AppMethodBeat.i(48355);
    a locala = new a();
    locala.field_key = paramString;
    locala.field_value = new byte[0];
    super.replace(locala);
    AppMethodBeat.o(48355);
  }
  
  public final byte[] get(String paramString)
  {
    AppMethodBeat.i(48357);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(48357);
      return null;
    }
    a locala = new a();
    locala.field_key = paramString;
    if (super.get(locala, new String[0]))
    {
      paramString = locala.field_value;
      AppMethodBeat.o(48357);
      return paramString;
    }
    AppMethodBeat.o(48357);
    return null;
  }
  
  public final void l(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(48356);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(48356);
      return;
    }
    a locala = new a();
    locala.field_key = paramString;
    locala.field_value = paramArrayOfByte;
    super.replace(locala);
    AppMethodBeat.o(48356);
  }
  
  static final class a
    extends IAutoDBItem
  {
    static final IAutoDBItem.MAutoDBInfo nFK;
    @MAutoDBFieldAnnotation(defValue="$$invalid", primaryKey=1)
    public String field_key;
    public byte[] field_value;
    
    static
    {
      AppMethodBeat.i(48354);
      nFK = initAutoDBInfo(a.class);
      AppMethodBeat.o(48354);
    }
    
    public final void convertFrom(Cursor paramCursor)
    {
      AppMethodBeat.i(48352);
      this.field_key = paramCursor.getString(0);
      this.field_value = paramCursor.getBlob(1);
      AppMethodBeat.o(48352);
    }
    
    public final ContentValues convertTo()
    {
      AppMethodBeat.i(48353);
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("key", this.field_key);
      localContentValues.put("value", this.field_value);
      AppMethodBeat.o(48353);
      return localContentValues;
    }
    
    public final IAutoDBItem.MAutoDBInfo getDBInfo()
    {
      return nFK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.a
 * JD-Core Version:    0.7.0.1
 */