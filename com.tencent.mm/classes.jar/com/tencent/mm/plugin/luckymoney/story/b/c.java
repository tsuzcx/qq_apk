package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ed;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends ed
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(163696);
    c.a locala = new c.a();
    locala.IBL = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "media_type";
    locala.IBN.put("media_type", "INTEGER");
    localStringBuilder.append(" media_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "media_url";
    locala.IBN.put("media_url", "TEXT");
    localStringBuilder.append(" media_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "media_md5";
    locala.IBN.put("media_md5", "TEXT");
    localStringBuilder.append(" media_md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "height";
    locala.IBN.put("height", "INTEGER");
    localStringBuilder.append(" height INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "width";
    locala.IBN.put("width", "INTEGER");
    localStringBuilder.append(" width INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "packet_id";
    locala.IBN.put("packet_id", "TEXT");
    localStringBuilder.append(" packet_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "media_fuzzy_thumbnail_url";
    locala.IBN.put("media_fuzzy_thumbnail_url", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "media_fuzzy_thumbnail_md5";
    locala.IBN.put("media_fuzzy_thumbnail_md5", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_md5 TEXT");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(163696);
  }
  
  public static c a(dka paramdka, String paramString)
  {
    AppMethodBeat.i(163694);
    c localc = new c();
    if (paramdka != null)
    {
      localc.field_packet_id = paramString;
      localc.field_height = paramdka.height;
      localc.field_width = paramdka.width;
      localc.field_media_type = paramdka.HRK;
      localc.field_media_md5 = paramdka.HRM;
      localc.field_media_url = paramdka.HRL;
      localc.field_media_fuzzy_thumbnail_url = paramdka.HRN;
      localc.field_media_fuzzy_thumbnail_md5 = paramdka.HRO;
    }
    AppMethodBeat.o(163694);
    return localc;
  }
  
  public static dka a(c paramc)
  {
    AppMethodBeat.i(163695);
    dka localdka = new dka();
    localdka.height = paramc.field_height;
    localdka.width = paramc.field_width;
    localdka.HRK = paramc.field_media_type;
    localdka.HRL = paramc.field_media_url;
    localdka.HRM = paramc.field_media_md5;
    localdka.HRN = paramc.field_media_fuzzy_thumbnail_url;
    localdka.HRO = paramc.field_media_fuzzy_thumbnail_md5;
    AppMethodBeat.o(163695);
    return localdka;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.c
 * JD-Core Version:    0.7.0.1
 */