package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dt;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends dt
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(163696);
    c.a locala = new c.a();
    locala.GvF = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "media_type";
    locala.GvH.put("media_type", "INTEGER");
    localStringBuilder.append(" media_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "media_url";
    locala.GvH.put("media_url", "TEXT");
    localStringBuilder.append(" media_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "media_md5";
    locala.GvH.put("media_md5", "TEXT");
    localStringBuilder.append(" media_md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "height";
    locala.GvH.put("height", "INTEGER");
    localStringBuilder.append(" height INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "width";
    locala.GvH.put("width", "INTEGER");
    localStringBuilder.append(" width INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "packet_id";
    locala.GvH.put("packet_id", "TEXT");
    localStringBuilder.append(" packet_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "media_fuzzy_thumbnail_url";
    locala.GvH.put("media_fuzzy_thumbnail_url", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "media_fuzzy_thumbnail_md5";
    locala.GvH.put("media_fuzzy_thumbnail_md5", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_md5 TEXT");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(163696);
  }
  
  public static c a(dds paramdds, String paramString)
  {
    AppMethodBeat.i(163694);
    c localc = new c();
    if (paramdds != null)
    {
      localc.field_packet_id = paramString;
      localc.field_height = paramdds.height;
      localc.field_width = paramdds.width;
      localc.field_media_type = paramdds.FNo;
      localc.field_media_md5 = paramdds.FNq;
      localc.field_media_url = paramdds.FNp;
      localc.field_media_fuzzy_thumbnail_url = paramdds.FNr;
      localc.field_media_fuzzy_thumbnail_md5 = paramdds.FNs;
    }
    AppMethodBeat.o(163694);
    return localc;
  }
  
  public static dds a(c paramc)
  {
    AppMethodBeat.i(163695);
    dds localdds = new dds();
    localdds.height = paramc.field_height;
    localdds.width = paramc.field_width;
    localdds.FNo = paramc.field_media_type;
    localdds.FNp = paramc.field_media_url;
    localdds.FNq = paramc.field_media_md5;
    localdds.FNr = paramc.field_media_fuzzy_thumbnail_url;
    localdds.FNs = paramc.field_media_fuzzy_thumbnail_md5;
    AppMethodBeat.o(163695);
    return localdds;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.c
 * JD-Core Version:    0.7.0.1
 */