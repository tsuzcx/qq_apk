package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fb;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends fb
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(163692);
    info = fb.aJm();
    AppMethodBeat.o(163692);
  }
  
  public static eoh a(a parama)
  {
    AppMethodBeat.i(163691);
    eoh localeoh = new eoh();
    localeoh.title = parama.field_title;
    localeoh.description = parama.field_description;
    localeoh.absv = parama.field_corp_name;
    localeoh.absx = parama.field_action_app_nickname;
    localeoh.Krv = parama.field_action_app_username;
    localeoh.absA = parama.field_action_emotion_designer_uin;
    localeoh.wuj = parama.field_action_type;
    localeoh.Kru = parama.field_action_url;
    localeoh.nQG = parama.field_logo_url;
    localeoh.nQH = parama.field_logo_md5;
    localeoh.absD = parama.field_action_jump_text;
    localeoh.absE = parama.field_same_receive_link;
    localeoh.nQE = parama.field_packet_id;
    localeoh.aaxT = parama.field_subtype_id;
    AppMethodBeat.o(163691);
    return localeoh;
  }
  
  public static void a(a parama, eoh parameoh, String paramString, int paramInt)
  {
    if (parameoh != null)
    {
      parama.field_title = parameoh.title;
      parama.field_corp_name = parameoh.absv;
      parama.field_action_app_nickname = parameoh.absx;
      parama.field_action_app_username = parameoh.Krv;
      parama.field_action_emotion_designer_uin = parameoh.absA;
      parama.field_action_type = parameoh.wuj;
      parama.field_action_url = parameoh.Kru;
      parama.field_description = parameoh.description;
      parama.field_logo_url = parameoh.nQG;
      parama.field_logo_md5 = parameoh.nQH;
      parama.field_action_jump_text = parameoh.absD;
      parama.field_same_receive_link = parameoh.absE;
      parama.field_packet_id = paramString;
      parama.field_subtype_id = paramInt;
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.a
 * JD-Core Version:    0.7.0.1
 */