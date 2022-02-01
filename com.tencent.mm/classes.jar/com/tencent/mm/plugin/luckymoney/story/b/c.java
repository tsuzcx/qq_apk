package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ed;
import com.tencent.mm.protocal.protobuf.djf;
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
    locala.IhA = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "media_type";
    locala.IhC.put("media_type", "INTEGER");
    localStringBuilder.append(" media_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "media_url";
    locala.IhC.put("media_url", "TEXT");
    localStringBuilder.append(" media_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "media_md5";
    locala.IhC.put("media_md5", "TEXT");
    localStringBuilder.append(" media_md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "height";
    locala.IhC.put("height", "INTEGER");
    localStringBuilder.append(" height INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "width";
    locala.IhC.put("width", "INTEGER");
    localStringBuilder.append(" width INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "packet_id";
    locala.IhC.put("packet_id", "TEXT");
    localStringBuilder.append(" packet_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "media_fuzzy_thumbnail_url";
    locala.IhC.put("media_fuzzy_thumbnail_url", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "media_fuzzy_thumbnail_md5";
    locala.IhC.put("media_fuzzy_thumbnail_md5", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_md5 TEXT");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(163696);
  }
  
  public static c a(djf paramdjf, String paramString)
  {
    AppMethodBeat.i(163694);
    c localc = new c();
    if (paramdjf != null)
    {
      localc.field_packet_id = paramString;
      localc.field_height = paramdjf.height;
      localc.field_width = paramdjf.width;
      localc.field_media_type = paramdjf.HxZ;
      localc.field_media_md5 = paramdjf.Hyb;
      localc.field_media_url = paramdjf.Hya;
      localc.field_media_fuzzy_thumbnail_url = paramdjf.Hyc;
      localc.field_media_fuzzy_thumbnail_md5 = paramdjf.Hyd;
    }
    AppMethodBeat.o(163694);
    return localc;
  }
  
  public static djf a(c paramc)
  {
    AppMethodBeat.i(163695);
    djf localdjf = new djf();
    localdjf.height = paramc.field_height;
    localdjf.width = paramc.field_width;
    localdjf.HxZ = paramc.field_media_type;
    localdjf.Hya = paramc.field_media_url;
    localdjf.Hyb = paramc.field_media_md5;
    localdjf.Hyc = paramc.field_media_fuzzy_thumbnail_url;
    localdjf.Hyd = paramc.field_media_fuzzy_thumbnail_md5;
    AppMethodBeat.o(163695);
    return localdjf;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.c
 * JD-Core Version:    0.7.0.1
 */