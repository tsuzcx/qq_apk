package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.h.c.cb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends cb
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.ujN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "championUrl";
    locala.ujN.put("championUrl", "TEXT");
    localStringBuilder.append(" championUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "championMotto";
    locala.ujN.put("championMotto", "TEXT");
    localStringBuilder.append(" championMotto TEXT");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.a.a
 * JD-Core Version:    0.7.0.1
 */