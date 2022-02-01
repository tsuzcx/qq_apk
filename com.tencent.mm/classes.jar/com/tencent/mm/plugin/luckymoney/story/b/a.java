package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ei
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(163692);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[11];
    localMAutoDBInfo.columns = new String[12];
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
    localMAutoDBInfo.columns[11] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(163692);
  }
  
  public static dlt a(a parama)
  {
    AppMethodBeat.i(163691);
    dlt localdlt = new dlt();
    localdlt.title = parama.field_title;
    localdlt.description = parama.field_description;
    localdlt.MPn = parama.field_corp_name;
    localdlt.MPp = parama.field_action_app_nickname;
    localdlt.yUL = parama.field_action_app_username;
    localdlt.pTI = parama.field_action_type;
    localdlt.yUK = parama.field_action_url;
    localdlt.iwv = parama.field_logo_url;
    localdlt.iww = parama.field_logo_md5;
    localdlt.iwu = parama.field_packet_id;
    AppMethodBeat.o(163691);
    return localdlt;
  }
  
  public static void a(a parama, dlt paramdlt, String paramString)
  {
    if (paramdlt != null)
    {
      parama.field_title = paramdlt.title;
      parama.field_corp_name = paramdlt.MPn;
      parama.field_action_app_nickname = paramdlt.MPp;
      parama.field_action_app_username = paramdlt.yUL;
      parama.field_action_type = paramdlt.pTI;
      parama.field_action_url = paramdlt.yUK;
      parama.field_description = paramdlt.description;
      parama.field_logo_url = paramdlt.iwv;
      parama.field_logo_md5 = paramdlt.iww;
      parama.field_packet_id = paramString;
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.a
 * JD-Core Version:    0.7.0.1
 */