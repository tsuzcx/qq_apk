package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dp;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends dp
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(163692);
    c.a locala = new c.a();
    locala.EYt = new Field[11];
    locala.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "title";
    locala.EYv.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "logo_url";
    locala.EYv.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "logo_md5";
    locala.EYv.put("logo_md5", "TEXT");
    localStringBuilder.append(" logo_md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "description";
    locala.EYv.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "corp_name";
    locala.EYv.put("corp_name", "TEXT");
    localStringBuilder.append(" corp_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "action_type";
    locala.EYv.put("action_type", "INTEGER");
    localStringBuilder.append(" action_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "action_url";
    locala.EYv.put("action_url", "TEXT");
    localStringBuilder.append(" action_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "action_app_username";
    locala.EYv.put("action_app_username", "TEXT");
    localStringBuilder.append(" action_app_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "action_app_nickname";
    locala.EYv.put("action_app_nickname", "TEXT");
    localStringBuilder.append(" action_app_nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "packet_id";
    locala.EYv.put("packet_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" packet_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "packet_id";
    locala.columns[10] = "update_time";
    locala.EYv.put("update_time", "LONG");
    localStringBuilder.append(" update_time LONG");
    locala.columns[11] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(163692);
  }
  
  public static cic a(a parama)
  {
    AppMethodBeat.i(163691);
    cic localcic = new cic();
    localcic.title = parama.field_title;
    localcic.description = parama.field_description;
    localcic.Edu = parama.field_corp_name;
    localcic.Edy = parama.field_action_app_nickname;
    localcic.Edx = parama.field_action_app_username;
    localcic.ntg = parama.field_action_type;
    localcic.Edw = parama.field_action_url;
    localcic.gGR = parama.field_logo_url;
    localcic.gGS = parama.field_logo_md5;
    localcic.gGQ = parama.field_packet_id;
    AppMethodBeat.o(163691);
    return localcic;
  }
  
  public static void a(a parama, cic paramcic, String paramString)
  {
    if (paramcic != null)
    {
      parama.field_title = paramcic.title;
      parama.field_corp_name = paramcic.Edu;
      parama.field_action_app_nickname = paramcic.Edy;
      parama.field_action_app_username = paramcic.Edx;
      parama.field_action_type = paramcic.ntg;
      parama.field_action_url = paramcic.Edw;
      parama.field_description = paramcic.description;
      parama.field_logo_url = paramcic.gGR;
      parama.field_logo_md5 = paramcic.gGS;
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