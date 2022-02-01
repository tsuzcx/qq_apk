package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.en;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends en
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(163692);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[12];
    localMAutoDBInfo.columns = new String[13];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "logo_url";
    localMAutoDBInfo.colsMap.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "logo_md5";
    localMAutoDBInfo.colsMap.put("logo_md5", "TEXT");
    localStringBuilder.append(" logo_md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "description";
    localMAutoDBInfo.colsMap.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "corp_name";
    localMAutoDBInfo.colsMap.put("corp_name", "TEXT");
    localStringBuilder.append(" corp_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "action_type";
    localMAutoDBInfo.colsMap.put("action_type", "INTEGER");
    localStringBuilder.append(" action_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "action_url";
    localMAutoDBInfo.colsMap.put("action_url", "TEXT");
    localStringBuilder.append(" action_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "action_app_username";
    localMAutoDBInfo.colsMap.put("action_app_username", "TEXT");
    localStringBuilder.append(" action_app_username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "action_app_nickname";
    localMAutoDBInfo.colsMap.put("action_app_nickname", "TEXT");
    localStringBuilder.append(" action_app_nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "packet_id";
    localMAutoDBInfo.colsMap.put("packet_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" packet_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "packet_id";
    localMAutoDBInfo.columns[10] = "update_time";
    localMAutoDBInfo.colsMap.put("update_time", "LONG");
    localStringBuilder.append(" update_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "subtype_id";
    localMAutoDBInfo.colsMap.put("subtype_id", "INTEGER");
    localStringBuilder.append(" subtype_id INTEGER");
    localMAutoDBInfo.columns[12] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(163692);
  }
  
  public static dvl a(a parama)
  {
    AppMethodBeat.i(163691);
    dvl localdvl = new dvl();
    localdvl.title = parama.field_title;
    localdvl.description = parama.field_description;
    localdvl.Ubp = parama.field_corp_name;
    localdvl.Ubr = parama.field_action_app_nickname;
    localdvl.EyI = parama.field_action_app_username;
    localdvl.tpK = parama.field_action_type;
    localdvl.EyH = parama.field_action_url;
    localdvl.llI = parama.field_logo_url;
    localdvl.llJ = parama.field_logo_md5;
    localdvl.llH = parama.field_packet_id;
    localdvl.Tkq = parama.field_subtype_id;
    AppMethodBeat.o(163691);
    return localdvl;
  }
  
  public static void a(a parama, dvl paramdvl, String paramString, int paramInt)
  {
    if (paramdvl != null)
    {
      parama.field_title = paramdvl.title;
      parama.field_corp_name = paramdvl.Ubp;
      parama.field_action_app_nickname = paramdvl.Ubr;
      parama.field_action_app_username = paramdvl.EyI;
      parama.field_action_type = paramdvl.tpK;
      parama.field_action_url = paramdvl.EyH;
      parama.field_description = paramdvl.description;
      parama.field_logo_url = paramdvl.llI;
      parama.field_logo_md5 = paramdvl.llJ;
      parama.field_packet_id = paramString;
      parama.field_subtype_id = paramInt;
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.a
 * JD-Core Version:    0.7.0.1
 */