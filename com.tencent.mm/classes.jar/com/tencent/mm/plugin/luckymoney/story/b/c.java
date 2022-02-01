package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dq;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends dq
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(163696);
    c.a locala = new c.a();
    locala.EYt = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "media_type";
    locala.EYv.put("media_type", "INTEGER");
    localStringBuilder.append(" media_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "media_url";
    locala.EYv.put("media_url", "TEXT");
    localStringBuilder.append(" media_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "media_md5";
    locala.EYv.put("media_md5", "TEXT");
    localStringBuilder.append(" media_md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "height";
    locala.EYv.put("height", "INTEGER");
    localStringBuilder.append(" height INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "width";
    locala.EYv.put("width", "INTEGER");
    localStringBuilder.append(" width INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "packet_id";
    locala.EYv.put("packet_id", "TEXT");
    localStringBuilder.append(" packet_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "media_fuzzy_thumbnail_url";
    locala.EYv.put("media_fuzzy_thumbnail_url", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "media_fuzzy_thumbnail_md5";
    locala.EYv.put("media_fuzzy_thumbnail_md5", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_md5 TEXT");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(163696);
  }
  
  public static c a(cyg paramcyg, String paramString)
  {
    AppMethodBeat.i(163694);
    c localc = new c();
    if (paramcyg != null)
    {
      localc.field_packet_id = paramString;
      localc.field_height = paramcyg.height;
      localc.field_width = paramcyg.width;
      localc.field_media_type = paramcyg.Eqm;
      localc.field_media_md5 = paramcyg.Eqo;
      localc.field_media_url = paramcyg.Eqn;
      localc.field_media_fuzzy_thumbnail_url = paramcyg.Eqp;
      localc.field_media_fuzzy_thumbnail_md5 = paramcyg.Eqq;
    }
    AppMethodBeat.o(163694);
    return localc;
  }
  
  public static cyg a(c paramc)
  {
    AppMethodBeat.i(163695);
    cyg localcyg = new cyg();
    localcyg.height = paramc.field_height;
    localcyg.width = paramc.field_width;
    localcyg.Eqm = paramc.field_media_type;
    localcyg.Eqn = paramc.field_media_url;
    localcyg.Eqo = paramc.field_media_md5;
    localcyg.Eqp = paramc.field_media_fuzzy_thumbnail_url;
    localcyg.Eqq = paramc.field_media_fuzzy_thumbnail_md5;
    AppMethodBeat.o(163695);
    return localcyg;
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