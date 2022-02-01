package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ej;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends ej
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
  
  public static c a(edn paramedn, String paramString)
  {
    AppMethodBeat.i(163694);
    c localc = new c();
    if (paramedn != null)
    {
      localc.field_packet_id = paramString;
      localc.field_height = paramedn.height;
      localc.field_width = paramedn.width;
      localc.field_media_type = paramedn.Gat;
      localc.field_media_md5 = paramedn.NdO;
      localc.field_media_url = paramedn.Gav;
      localc.field_media_fuzzy_thumbnail_url = paramedn.NdP;
      localc.field_media_fuzzy_thumbnail_md5 = paramedn.NdQ;
    }
    AppMethodBeat.o(163694);
    return localc;
  }
  
  public static edn a(c paramc)
  {
    AppMethodBeat.i(163695);
    edn localedn = new edn();
    localedn.height = paramc.field_height;
    localedn.width = paramc.field_width;
    localedn.Gat = paramc.field_media_type;
    localedn.Gav = paramc.field_media_url;
    localedn.NdO = paramc.field_media_md5;
    localedn.NdP = paramc.field_media_fuzzy_thumbnail_url;
    localedn.NdQ = paramc.field_media_fuzzy_thumbnail_md5;
    AppMethodBeat.o(163695);
    return localedn;
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