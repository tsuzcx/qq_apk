package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aj;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g
  extends aj
{
  protected static c.a info;
  public String knD = "";
  public String knE = "";
  public String knF;
  public String knG;
  public String knH;
  public boolean knI = false;
  public oh knJ;
  public ov knK;
  public List<a> knL = null;
  public List<g.b> knM = null;
  public int knN = 0;
  public int knO = 0;
  public boolean knP;
  public List<g.c> knQ = null;
  
  static
  {
    AppMethodBeat.i(87834);
    c.a locala = new c.a();
    locala.yrK = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_type";
    locala.yrM.put("card_type", "INTEGER");
    localStringBuilder.append(" card_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "title";
    locala.yrM.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "description";
    locala.yrM.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "logo_url";
    locala.yrM.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "time";
    locala.yrM.put("time", "INTEGER");
    localStringBuilder.append(" time INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "card_id";
    locala.yrM.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "card_tp_id";
    locala.yrM.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "msg_id";
    locala.yrM.put("msg_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msg_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "msg_id";
    locala.columns[8] = "msg_type";
    locala.yrM.put("msg_type", "INTEGER");
    localStringBuilder.append(" msg_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "jump_type";
    locala.yrM.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "url";
    locala.yrM.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "buttonData";
    locala.yrM.put("buttonData", "BLOB");
    localStringBuilder.append(" buttonData BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "operData";
    locala.yrM.put("operData", "BLOB");
    localStringBuilder.append(" operData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "report_scene";
    locala.yrM.put("report_scene", "INTEGER");
    localStringBuilder.append(" report_scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "read_state";
    locala.yrM.put("read_state", "INTEGER default '0' ");
    localStringBuilder.append(" read_state INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "accept_buttons";
    locala.yrM.put("accept_buttons", "TEXT");
    localStringBuilder.append(" accept_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "consumed_box_id";
    locala.yrM.put("consumed_box_id", "TEXT");
    localStringBuilder.append(" consumed_box_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "jump_buttons";
    locala.yrM.put("jump_buttons", "TEXT");
    localStringBuilder.append(" jump_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "logo_color";
    locala.yrM.put("logo_color", "TEXT");
    localStringBuilder.append(" logo_color TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "unavailable_qr_code_list";
    locala.yrM.put("unavailable_qr_code_list", "TEXT");
    localStringBuilder.append(" unavailable_qr_code_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "all_unavailable";
    locala.yrM.put("all_unavailable", "INTEGER default 'false' ");
    localStringBuilder.append(" all_unavailable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "need_pull_card_entrance";
    locala.yrM.put("need_pull_card_entrance", "INTEGER default 'false' ");
    localStringBuilder.append(" need_pull_card_entrance INTEGER default 'false' ");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(87834);
  }
  
  public final oh bbU()
  {
    AppMethodBeat.i(87829);
    oh localoh1;
    if (this.knJ != null)
    {
      localoh1 = this.knJ;
      AppMethodBeat.o(87829);
      return localoh1;
    }
    try
    {
      this.knJ = ((oh)new oh().parseFrom(this.field_buttonData));
      localoh1 = this.knJ;
      AppMethodBeat.o(87829);
      return localoh1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      oh localoh2 = new oh();
      AppMethodBeat.o(87829);
      return localoh2;
    }
  }
  
  public final ov bbV()
  {
    AppMethodBeat.i(87830);
    ov localov1;
    if (this.knK != null)
    {
      localov1 = this.knK;
      AppMethodBeat.o(87830);
      return localov1;
    }
    try
    {
      this.knK = ((ov)new ov().parseFrom(this.field_operData));
      localov1 = this.knK;
      AppMethodBeat.o(87830);
      return localov1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      ov localov2 = new ov();
      AppMethodBeat.o(87830);
      return localov2;
    }
  }
  
  public final void bbW()
  {
    AppMethodBeat.i(87831);
    if (this.knL == null)
    {
      this.knL = new ArrayList();
      if (bo.isNullOrNil(this.field_accept_buttons))
      {
        AppMethodBeat.o(87831);
        return;
      }
      Map localMap = br.F(this.field_accept_buttons, "accept_buttons_list");
      if (localMap == null)
      {
        AppMethodBeat.o(87831);
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
          if ((bo.isNullOrNil((String)localObject2)) && (bo.isNullOrNil(str))) {
            break label452;
          }
          int j = bo.getInt((String)localMap.get((String)localObject1 + ".end_time"), 0);
          if ((j == 0) || (j > bo.aox()))
          {
            localObject2 = new a();
            ((a)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
            ((a)localObject2).jjP = ((String)localMap.get((String)localObject1 + ".sub_title"));
            ((a)localObject2).knR = ((String)localMap.get((String)localObject1 + ".card_ext"));
            ((a)localObject2).cardId = ((String)localMap.get((String)localObject1 + ".card_id"));
            ((a)localObject2).knS = bo.getInt((String)localMap.get((String)localObject1 + ".action_type"), 0);
            ((a)localObject2).endTime = j;
            this.knL.add(localObject2);
          }
          i += 1;
          break;
        }
      }
    }
    label452:
    AppMethodBeat.o(87831);
  }
  
  public final void bbX()
  {
    AppMethodBeat.i(87832);
    if (this.knM == null)
    {
      this.knM = new ArrayList();
      if (bo.isNullOrNil(this.field_jump_buttons))
      {
        AppMethodBeat.o(87832);
        return;
      }
      Map localMap = br.F(this.field_jump_buttons, "jump_buttons_list");
      if (localMap == null)
      {
        AppMethodBeat.o(87832);
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
          if (bo.isNullOrNil((String)localMap.get((String)localObject1 + ".title"))) {
            break label308;
          }
          localObject2 = new g.b(this);
          ((g.b)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
          ((g.b)localObject2).description = ((String)localMap.get((String)localObject1 + ".description"));
          ((g.b)localObject2).knU = ((String)localMap.get((String)localObject1 + ".button_wording"));
          ((g.b)localObject2).knV = ((String)localMap.get((String)localObject1 + ".jump_url"));
          this.knM.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label308:
    AppMethodBeat.o(87832);
  }
  
  public final void bbY()
  {
    AppMethodBeat.i(87833);
    if (this.knQ == null)
    {
      this.knQ = new ArrayList();
      if (bo.isNullOrNil(this.field_unavailable_qr_code_list))
      {
        AppMethodBeat.o(87833);
        return;
      }
      Map localMap = br.F(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
      if (localMap == null)
      {
        AppMethodBeat.o(87833);
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
          if (bo.isNullOrNil((String)localMap.get((String)localObject1 + ".code_id"))) {
            break label205;
          }
          localObject2 = new g.c(this);
          ((g.c)localObject2).knW = ((String)localMap.get((String)localObject1 + ".code_id"));
          this.knQ.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label205:
    AppMethodBeat.o(87833);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final class a
  {
    public String cardId;
    public int endTime;
    public String jjP;
    public String knR;
    public int knS;
    public String title;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.g
 * JD-Core Version:    0.7.0.1
 */