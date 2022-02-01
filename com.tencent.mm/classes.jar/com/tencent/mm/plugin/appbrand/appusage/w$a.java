package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.q;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class w$a
  extends q
{
  static final IAutoDBItem.MAutoDBInfo nVV;
  static final String[] qDJ;
  
  static
  {
    AppMethodBeat.i(44607);
    qDJ = new String[] { "brandId", "versionType", "scene" };
    nVV = q.aJm();
    AppMethodBeat.o(44607);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(44606);
    this.systemRowid = 0L;
    ContentValues localContentValues = super.convertTo();
    int i = w.P(this.field_brandId, this.field_versionType, this.field_scene);
    this.field_recordId = i;
    localContentValues.put("recordId", Integer.valueOf(i));
    AppMethodBeat.o(44606);
    return localContentValues;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w.a
 * JD-Core Version:    0.7.0.1
 */