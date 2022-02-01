package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ap;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g
  extends ap
{
  protected static c.a info;
  public String ozl = "";
  public String ozm = "";
  public String ozn;
  public String ozo;
  public String ozp;
  public boolean ozq = false;
  public sp ozr;
  public th ozs;
  public List<a> ozt = null;
  public List<b> ozu = null;
  public int ozv = 0;
  public int ozw = 0;
  public boolean ozx;
  public List<c> ozy = null;
  
  static
  {
    AppMethodBeat.i(112776);
    c.a locala = new c.a();
    locala.IhA = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_type";
    locala.IhC.put("card_type", "INTEGER");
    localStringBuilder.append(" card_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "title";
    locala.IhC.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "description";
    locala.IhC.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "logo_url";
    locala.IhC.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "time";
    locala.IhC.put("time", "INTEGER");
    localStringBuilder.append(" time INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "card_id";
    locala.IhC.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "card_tp_id";
    locala.IhC.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "msg_id";
    locala.IhC.put("msg_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msg_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "msg_id";
    locala.columns[8] = "msg_type";
    locala.IhC.put("msg_type", "INTEGER");
    localStringBuilder.append(" msg_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "jump_type";
    locala.IhC.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "url";
    locala.IhC.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "buttonData";
    locala.IhC.put("buttonData", "BLOB");
    localStringBuilder.append(" buttonData BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "operData";
    locala.IhC.put("operData", "BLOB");
    localStringBuilder.append(" operData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "report_scene";
    locala.IhC.put("report_scene", "INTEGER");
    localStringBuilder.append(" report_scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "read_state";
    locala.IhC.put("read_state", "INTEGER default '0' ");
    localStringBuilder.append(" read_state INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "accept_buttons";
    locala.IhC.put("accept_buttons", "TEXT");
    localStringBuilder.append(" accept_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "consumed_box_id";
    locala.IhC.put("consumed_box_id", "TEXT");
    localStringBuilder.append(" consumed_box_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "jump_buttons";
    locala.IhC.put("jump_buttons", "TEXT");
    localStringBuilder.append(" jump_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "logo_color";
    locala.IhC.put("logo_color", "TEXT");
    localStringBuilder.append(" logo_color TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "unavailable_qr_code_list";
    locala.IhC.put("unavailable_qr_code_list", "TEXT");
    localStringBuilder.append(" unavailable_qr_code_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "all_unavailable";
    locala.IhC.put("all_unavailable", "INTEGER default 'false' ");
    localStringBuilder.append(" all_unavailable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "need_pull_card_entrance";
    locala.IhC.put("need_pull_card_entrance", "INTEGER default 'false' ");
    localStringBuilder.append(" need_pull_card_entrance INTEGER default 'false' ");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(112776);
  }
  
  public final sp bUE()
  {
    AppMethodBeat.i(112771);
    sp localsp1;
    if (this.ozr != null)
    {
      localsp1 = this.ozr;
      AppMethodBeat.o(112771);
      return localsp1;
    }
    try
    {
      this.ozr = ((sp)new sp().parseFrom(this.field_buttonData));
      localsp1 = this.ozr;
      AppMethodBeat.o(112771);
      return localsp1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      sp localsp2 = new sp();
      AppMethodBeat.o(112771);
      return localsp2;
    }
  }
  
  public final th bUF()
  {
    AppMethodBeat.i(112772);
    th localth1;
    if (this.ozs != null)
    {
      localth1 = this.ozs;
      AppMethodBeat.o(112772);
      return localth1;
    }
    try
    {
      this.ozs = ((th)new th().parseFrom(this.field_operData));
      localth1 = this.ozs;
      AppMethodBeat.o(112772);
      return localth1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      th localth2 = new th();
      AppMethodBeat.o(112772);
      return localth2;
    }
  }
  
  public final void bUG()
  {
    AppMethodBeat.i(112773);
    if (this.ozt == null)
    {
      this.ozt = new ArrayList();
      if (bt.isNullOrNil(this.field_accept_buttons))
      {
        AppMethodBeat.o(112773);
        return;
      }
      Map localMap = bw.M(this.field_accept_buttons, "accept_buttons_list");
      if (localMap == null)
      {
        AppMethodBeat.o(112773);
        return;
      }
      int i = 0;
      if (i < 100)
      {
        Object localObject2 = new StringBuilder(".accept_buttons_list.accept_buttons");
        if (i > 0) {}
        for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
        {
          localObject1 = localObject1;
          localObject2 = (String)localMap.get((String)localObject1 + ".card_id");
          String str = (String)localMap.get((String)localObject1 + ".title");
          if ((bt.isNullOrNil((String)localObject2)) && (bt.isNullOrNil(str))) {
            break label452;
          }
          int j = bt.getInt((String)localMap.get((String)localObject1 + ".end_time"), 0);
          if ((j == 0) || (j > bt.aQJ()))
          {
            localObject2 = new a();
            ((a)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
            ((a)localObject2).nch = ((String)localMap.get((String)localObject1 + ".sub_title"));
            ((a)localObject2).ozz = ((String)localMap.get((String)localObject1 + ".card_ext"));
            ((a)localObject2).cardId = ((String)localMap.get((String)localObject1 + ".card_id"));
            ((a)localObject2).ozA = bt.getInt((String)localMap.get((String)localObject1 + ".action_type"), 0);
            ((a)localObject2).htQ = j;
            this.ozt.add(localObject2);
          }
          i += 1;
          break;
        }
      }
    }
    label452:
    AppMethodBeat.o(112773);
  }
  
  public final void bUH()
  {
    AppMethodBeat.i(112774);
    if (this.ozu == null)
    {
      this.ozu = new ArrayList();
      if (bt.isNullOrNil(this.field_jump_buttons))
      {
        AppMethodBeat.o(112774);
        return;
      }
      Map localMap = bw.M(this.field_jump_buttons, "jump_buttons_list");
      if (localMap == null)
      {
        AppMethodBeat.o(112774);
        return;
      }
      int i = 0;
      if (i < 100)
      {
        Object localObject2 = new StringBuilder(".jump_buttons_list.jump_buttons");
        if (i > 0) {}
        for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
        {
          localObject1 = localObject1;
          if (bt.isNullOrNil((String)localMap.get((String)localObject1 + ".title"))) {
            break label308;
          }
          localObject2 = new b();
          ((b)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
          ((b)localObject2).description = ((String)localMap.get((String)localObject1 + ".description"));
          ((b)localObject2).ozC = ((String)localMap.get((String)localObject1 + ".button_wording"));
          ((b)localObject2).ozD = ((String)localMap.get((String)localObject1 + ".jump_url"));
          this.ozu.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label308:
    AppMethodBeat.o(112774);
  }
  
  public final void bUI()
  {
    AppMethodBeat.i(112775);
    if (this.ozy == null)
    {
      this.ozy = new ArrayList();
      if (bt.isNullOrNil(this.field_unavailable_qr_code_list))
      {
        AppMethodBeat.o(112775);
        return;
      }
      Map localMap = bw.M(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
      if (localMap == null)
      {
        AppMethodBeat.o(112775);
        return;
      }
      int i = 0;
      if (i < 100)
      {
        Object localObject2 = new StringBuilder(".unavailable_qr_code_list.unavailable_qr_codes");
        if (i > 0) {}
        for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
        {
          localObject1 = localObject1;
          if (bt.isNullOrNil((String)localMap.get((String)localObject1 + ".code_id"))) {
            break label205;
          }
          localObject2 = new c();
          ((c)localObject2).ozE = ((String)localMap.get((String)localObject1 + ".code_id"));
          this.ozy.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label205:
    AppMethodBeat.o(112775);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final class a
  {
    public String cardId;
    public int htQ;
    public String nch;
    public int ozA;
    public String ozz;
    public String title;
    
    public a() {}
  }
  
  public final class b
  {
    public String description;
    public String ozC;
    public String ozD;
    public String title;
    
    public b() {}
  }
  
  public final class c
  {
    public String ozE;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.g
 * JD-Core Version:    0.7.0.1
 */