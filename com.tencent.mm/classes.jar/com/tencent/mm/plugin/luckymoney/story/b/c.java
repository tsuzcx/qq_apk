package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.eo;
import com.tencent.mm.protocal.protobuf.eno;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends eo
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(163696);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "media_type";
    localMAutoDBInfo.colsMap.put("media_type", "INTEGER");
    localStringBuilder.append(" media_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "media_url";
    localMAutoDBInfo.colsMap.put("media_url", "TEXT");
    localStringBuilder.append(" media_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "media_md5";
    localMAutoDBInfo.colsMap.put("media_md5", "TEXT");
    localStringBuilder.append(" media_md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "height";
    localMAutoDBInfo.colsMap.put("height", "INTEGER");
    localStringBuilder.append(" height INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "width";
    localMAutoDBInfo.colsMap.put("width", "INTEGER");
    localStringBuilder.append(" width INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "packet_id";
    localMAutoDBInfo.colsMap.put("packet_id", "TEXT");
    localStringBuilder.append(" packet_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "media_fuzzy_thumbnail_url";
    localMAutoDBInfo.colsMap.put("media_fuzzy_thumbnail_url", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "media_fuzzy_thumbnail_md5";
    localMAutoDBInfo.colsMap.put("media_fuzzy_thumbnail_md5", "TEXT");
    localStringBuilder.append(" media_fuzzy_thumbnail_md5 TEXT");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(163696);
  }
  
  public static c a(eno parameno, String paramString)
  {
    AppMethodBeat.i(163694);
    c localc = new c();
    if (parameno != null)
    {
      localc.field_packet_id = paramString;
      localc.field_height = parameno.height;
      localc.field_width = parameno.width;
      localc.field_media_type = parameno.Uql;
      localc.field_media_md5 = parameno.Uqn;
      localc.field_media_url = parameno.Uqm;
      localc.field_media_fuzzy_thumbnail_url = parameno.Uqo;
      localc.field_media_fuzzy_thumbnail_md5 = parameno.Uqp;
    }
    AppMethodBeat.o(163694);
    return localc;
  }
  
  public static eno a(c paramc)
  {
    AppMethodBeat.i(163695);
    eno localeno = new eno();
    localeno.height = paramc.field_height;
    localeno.width = paramc.field_width;
    localeno.Uql = paramc.field_media_type;
    localeno.Uqm = paramc.field_media_url;
    localeno.Uqn = paramc.field_media_md5;
    localeno.Uqo = paramc.field_media_fuzzy_thumbnail_url;
    localeno.Uqp = paramc.field_media_fuzzy_thumbnail_md5;
    AppMethodBeat.o(163695);
    return localeno;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.c
 * JD-Core Version:    0.7.0.1
 */