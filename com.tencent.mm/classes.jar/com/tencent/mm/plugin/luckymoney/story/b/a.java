package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ec
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(163692);
    c.a locala = new c.a();
    locala.IBL = new Field[11];
    locala.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "title";
    locala.IBN.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "logo_url";
    locala.IBN.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "logo_md5";
    locala.IBN.put("logo_md5", "TEXT");
    localStringBuilder.append(" logo_md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "description";
    locala.IBN.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "corp_name";
    locala.IBN.put("corp_name", "TEXT");
    localStringBuilder.append(" corp_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "action_type";
    locala.IBN.put("action_type", "INTEGER");
    localStringBuilder.append(" action_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "action_url";
    locala.IBN.put("action_url", "TEXT");
    localStringBuilder.append(" action_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "action_app_username";
    locala.IBN.put("action_app_username", "TEXT");
    localStringBuilder.append(" action_app_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "action_app_nickname";
    locala.IBN.put("action_app_nickname", "TEXT");
    localStringBuilder.append(" action_app_nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "packet_id";
    locala.IBN.put("packet_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" packet_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "packet_id";
    locala.columns[10] = "update_time";
    locala.IBN.put("update_time", "LONG");
    localStringBuilder.append(" update_time LONG");
    locala.columns[11] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(163692);
  }
  
  public static ctd a(a parama)
  {
    AppMethodBeat.i(163691);
    ctd localctd = new ctd();
    localctd.title = parama.field_title;
    localctd.description = parama.field_description;
    localctd.HEf = parama.field_corp_name;
    localctd.HEj = parama.field_action_app_nickname;
    localctd.HEi = parama.field_action_app_username;
    localctd.oGc = parama.field_action_type;
    localctd.HEh = parama.field_action_url;
    localctd.hCp = parama.field_logo_url;
    localctd.hCq = parama.field_logo_md5;
    localctd.hCo = parama.field_packet_id;
    AppMethodBeat.o(163691);
    return localctd;
  }
  
  public static void a(a parama, ctd paramctd, String paramString)
  {
    if (paramctd != null)
    {
      parama.field_title = paramctd.title;
      parama.field_corp_name = paramctd.HEf;
      parama.field_action_app_nickname = paramctd.HEj;
      parama.field_action_app_username = paramctd.HEi;
      parama.field_action_type = paramctd.oGc;
      parama.field_action_url = paramctd.HEh;
      parama.field_description = paramctd.description;
      parama.field_logo_url = paramctd.hCp;
      parama.field_logo_md5 = paramctd.hCq;
      parama.field_packet_id = paramString;
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.a
 * JD-Core Version:    0.7.0.1
 */