package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.protocal.protobuf.csj;
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
    locala.IhA = new Field[11];
    locala.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "title";
    locala.IhC.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "logo_url";
    locala.IhC.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "logo_md5";
    locala.IhC.put("logo_md5", "TEXT");
    localStringBuilder.append(" logo_md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "description";
    locala.IhC.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "corp_name";
    locala.IhC.put("corp_name", "TEXT");
    localStringBuilder.append(" corp_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "action_type";
    locala.IhC.put("action_type", "INTEGER");
    localStringBuilder.append(" action_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "action_url";
    locala.IhC.put("action_url", "TEXT");
    localStringBuilder.append(" action_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "action_app_username";
    locala.IhC.put("action_app_username", "TEXT");
    localStringBuilder.append(" action_app_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "action_app_nickname";
    locala.IhC.put("action_app_nickname", "TEXT");
    localStringBuilder.append(" action_app_nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "packet_id";
    locala.IhC.put("packet_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" packet_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "packet_id";
    locala.columns[10] = "update_time";
    locala.IhC.put("update_time", "LONG");
    localStringBuilder.append(" update_time LONG");
    locala.columns[11] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(163692);
  }
  
  public static csj a(a parama)
  {
    AppMethodBeat.i(163691);
    csj localcsj = new csj();
    localcsj.title = parama.field_title;
    localcsj.description = parama.field_description;
    localcsj.HkF = parama.field_corp_name;
    localcsj.HkJ = parama.field_action_app_nickname;
    localcsj.HkI = parama.field_action_app_username;
    localcsj.ozA = parama.field_action_type;
    localcsj.HkH = parama.field_action_url;
    localcsj.hzB = parama.field_logo_url;
    localcsj.hzC = parama.field_logo_md5;
    localcsj.hzA = parama.field_packet_id;
    AppMethodBeat.o(163691);
    return localcsj;
  }
  
  public static void a(a parama, csj paramcsj, String paramString)
  {
    if (paramcsj != null)
    {
      parama.field_title = paramcsj.title;
      parama.field_corp_name = paramcsj.HkF;
      parama.field_action_app_nickname = paramcsj.HkJ;
      parama.field_action_app_username = paramcsj.HkI;
      parama.field_action_type = paramcsj.ozA;
      parama.field_action_url = paramcsj.HkH;
      parama.field_description = paramcsj.description;
      parama.field_logo_url = paramcsj.hzB;
      parama.field_logo_md5 = paramcsj.hzC;
      parama.field_packet_id = paramString;
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.a
 * JD-Core Version:    0.7.0.1
 */