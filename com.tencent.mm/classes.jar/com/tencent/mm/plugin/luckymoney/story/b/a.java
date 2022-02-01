package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ds;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ds
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(163692);
    c.a locala = new c.a();
    locala.GvF = new Field[11];
    locala.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "title";
    locala.GvH.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "logo_url";
    locala.GvH.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "logo_md5";
    locala.GvH.put("logo_md5", "TEXT");
    localStringBuilder.append(" logo_md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "description";
    locala.GvH.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "corp_name";
    locala.GvH.put("corp_name", "TEXT");
    localStringBuilder.append(" corp_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "action_type";
    locala.GvH.put("action_type", "INTEGER");
    localStringBuilder.append(" action_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "action_url";
    locala.GvH.put("action_url", "TEXT");
    localStringBuilder.append(" action_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "action_app_username";
    locala.GvH.put("action_app_username", "TEXT");
    localStringBuilder.append(" action_app_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "action_app_nickname";
    locala.GvH.put("action_app_nickname", "TEXT");
    localStringBuilder.append(" action_app_nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "packet_id";
    locala.GvH.put("packet_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" packet_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "packet_id";
    locala.columns[10] = "update_time";
    locala.GvH.put("update_time", "LONG");
    localStringBuilder.append(" update_time LONG");
    locala.columns[11] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(163692);
  }
  
  public static cng a(a parama)
  {
    AppMethodBeat.i(163691);
    cng localcng = new cng();
    localcng.title = parama.field_title;
    localcng.description = parama.field_description;
    localcng.FAr = parama.field_corp_name;
    localcng.FAv = parama.field_action_app_nickname;
    localcng.FAu = parama.field_action_app_username;
    localcng.nWg = parama.field_action_type;
    localcng.FAt = parama.field_action_url;
    localcng.hhs = parama.field_logo_url;
    localcng.hht = parama.field_logo_md5;
    localcng.hhr = parama.field_packet_id;
    AppMethodBeat.o(163691);
    return localcng;
  }
  
  public static void a(a parama, cng paramcng, String paramString)
  {
    if (paramcng != null)
    {
      parama.field_title = paramcng.title;
      parama.field_corp_name = paramcng.FAr;
      parama.field_action_app_nickname = paramcng.FAv;
      parama.field_action_app_username = paramcng.FAu;
      parama.field_action_type = paramcng.nWg;
      parama.field_action_url = paramcng.FAt;
      parama.field_description = paramcng.description;
      parama.field_logo_url = paramcng.hhs;
      parama.field_logo_md5 = paramcng.hht;
      parama.field_packet_id = paramString;
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.a
 * JD-Core Version:    0.7.0.1
 */