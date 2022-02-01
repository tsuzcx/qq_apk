package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ao;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g
  extends ao
{
  protected static c.a info;
  public String nsR = "";
  public String nsS = "";
  public String nsT;
  public String nsU;
  public String nsV;
  public boolean nsW = false;
  public qm nsX;
  public rd nsY;
  public List<a> nsZ = null;
  public List<b> nta = null;
  public int ntb = 0;
  public int ntc = 0;
  public boolean ntd;
  public List<c> nte = null;
  
  static
  {
    AppMethodBeat.i(112776);
    c.a locala = new c.a();
    locala.EYt = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_type";
    locala.EYv.put("card_type", "INTEGER");
    localStringBuilder.append(" card_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "title";
    locala.EYv.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "description";
    locala.EYv.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "logo_url";
    locala.EYv.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "time";
    locala.EYv.put("time", "INTEGER");
    localStringBuilder.append(" time INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "card_id";
    locala.EYv.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "card_tp_id";
    locala.EYv.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "msg_id";
    locala.EYv.put("msg_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msg_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "msg_id";
    locala.columns[8] = "msg_type";
    locala.EYv.put("msg_type", "INTEGER");
    localStringBuilder.append(" msg_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "jump_type";
    locala.EYv.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "url";
    locala.EYv.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "buttonData";
    locala.EYv.put("buttonData", "BLOB");
    localStringBuilder.append(" buttonData BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "operData";
    locala.EYv.put("operData", "BLOB");
    localStringBuilder.append(" operData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "report_scene";
    locala.EYv.put("report_scene", "INTEGER");
    localStringBuilder.append(" report_scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "read_state";
    locala.EYv.put("read_state", "INTEGER default '0' ");
    localStringBuilder.append(" read_state INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "accept_buttons";
    locala.EYv.put("accept_buttons", "TEXT");
    localStringBuilder.append(" accept_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "consumed_box_id";
    locala.EYv.put("consumed_box_id", "TEXT");
    localStringBuilder.append(" consumed_box_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "jump_buttons";
    locala.EYv.put("jump_buttons", "TEXT");
    localStringBuilder.append(" jump_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "logo_color";
    locala.EYv.put("logo_color", "TEXT");
    localStringBuilder.append(" logo_color TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "unavailable_qr_code_list";
    locala.EYv.put("unavailable_qr_code_list", "TEXT");
    localStringBuilder.append(" unavailable_qr_code_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "all_unavailable";
    locala.EYv.put("all_unavailable", "INTEGER default 'false' ");
    localStringBuilder.append(" all_unavailable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "need_pull_card_entrance";
    locala.EYv.put("need_pull_card_entrance", "INTEGER default 'false' ");
    localStringBuilder.append(" need_pull_card_entrance INTEGER default 'false' ");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(112776);
  }
  
  public final qm bIM()
  {
    AppMethodBeat.i(112771);
    qm localqm1;
    if (this.nsX != null)
    {
      localqm1 = this.nsX;
      AppMethodBeat.o(112771);
      return localqm1;
    }
    try
    {
      this.nsX = ((qm)new qm().parseFrom(this.field_buttonData));
      localqm1 = this.nsX;
      AppMethodBeat.o(112771);
      return localqm1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      qm localqm2 = new qm();
      AppMethodBeat.o(112771);
      return localqm2;
    }
  }
  
  public final rd bIN()
  {
    AppMethodBeat.i(112772);
    rd localrd1;
    if (this.nsY != null)
    {
      localrd1 = this.nsY;
      AppMethodBeat.o(112772);
      return localrd1;
    }
    try
    {
      this.nsY = ((rd)new rd().parseFrom(this.field_operData));
      localrd1 = this.nsY;
      AppMethodBeat.o(112772);
      return localrd1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      rd localrd2 = new rd();
      AppMethodBeat.o(112772);
      return localrd2;
    }
  }
  
  public final void bIO()
  {
    AppMethodBeat.i(112773);
    if (this.nsZ == null)
    {
      this.nsZ = new ArrayList();
      if (bt.isNullOrNil(this.field_accept_buttons))
      {
        AppMethodBeat.o(112773);
        return;
      }
      Map localMap = bw.K(this.field_accept_buttons, "accept_buttons_list");
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
          if ((j == 0) || (j > bt.aGK()))
          {
            localObject2 = new a();
            ((a)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
            ((a)localObject2).lZG = ((String)localMap.get((String)localObject1 + ".sub_title"));
            ((a)localObject2).ntf = ((String)localMap.get((String)localObject1 + ".card_ext"));
            ((a)localObject2).cardId = ((String)localMap.get((String)localObject1 + ".card_id"));
            ((a)localObject2).ntg = bt.getInt((String)localMap.get((String)localObject1 + ".action_type"), 0);
            ((a)localObject2).gBm = j;
            this.nsZ.add(localObject2);
          }
          i += 1;
          break;
        }
      }
    }
    label452:
    AppMethodBeat.o(112773);
  }
  
  public final void bIP()
  {
    AppMethodBeat.i(112774);
    if (this.nta == null)
    {
      this.nta = new ArrayList();
      if (bt.isNullOrNil(this.field_jump_buttons))
      {
        AppMethodBeat.o(112774);
        return;
      }
      Map localMap = bw.K(this.field_jump_buttons, "jump_buttons_list");
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
          ((b)localObject2).nti = ((String)localMap.get((String)localObject1 + ".button_wording"));
          ((b)localObject2).ntj = ((String)localMap.get((String)localObject1 + ".jump_url"));
          this.nta.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label308:
    AppMethodBeat.o(112774);
  }
  
  public final void bIQ()
  {
    AppMethodBeat.i(112775);
    if (this.nte == null)
    {
      this.nte = new ArrayList();
      if (bt.isNullOrNil(this.field_unavailable_qr_code_list))
      {
        AppMethodBeat.o(112775);
        return;
      }
      Map localMap = bw.K(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
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
          ((c)localObject2).ntk = ((String)localMap.get((String)localObject1 + ".code_id"));
          this.nte.add(localObject2);
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
    public int gBm;
    public String lZG;
    public String ntf;
    public int ntg;
    public String title;
    
    public a() {}
  }
  
  public final class b
  {
    public String description;
    public String nti;
    public String ntj;
    public String title;
    
    public b() {}
  }
  
  public final class c
  {
    public String ntk;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.g
 * JD-Core Version:    0.7.0.1
 */