package com.tencent.mm.plugin.appbrand.y;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  extends j<a>
{
  public static final String[] hlS;
  
  static
  {
    AppMethodBeat.i(48359);
    hlS = new String[] { j.getCreateSQLs(a.jmW, "AppBrandCommonKVBinaryData") };
    AppMethodBeat.o(48359);
  }
  
  public a(e parame)
  {
    super(parame, a.jmW, "AppBrandCommonKVBinaryData", null);
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
    if (bs.isNullOrNil(paramString))
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
  
  public final void k(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(48356);
    if (bs.isNullOrNil(paramString))
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
    extends c
  {
    static final c.a jmW;
    @i(eWA="$$invalid", eWB=1)
    public String field_key;
    public byte[] field_value;
    
    static
    {
      AppMethodBeat.i(48354);
      jmW = initAutoDBInfo(a.class);
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
    
    public final c.a getDBInfo()
    {
      return jmW;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y.a
 * JD-Core Version:    0.7.0.1
 */