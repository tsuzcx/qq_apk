package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ao;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g
  extends ao
{
  protected static c.a info;
  public String nVR = "";
  public String nVS = "";
  public String nVT;
  public String nVU;
  public String nVV;
  public boolean nVW = false;
  public qw nVX;
  public rn nVY;
  public List<a> nVZ = null;
  public List<b> nWa = null;
  public int nWb = 0;
  public int nWc = 0;
  public boolean nWd;
  public List<c> nWe = null;
  
  static
  {
    AppMethodBeat.i(112776);
    c.a locala = new c.a();
    locala.GvF = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_type";
    locala.GvH.put("card_type", "INTEGER");
    localStringBuilder.append(" card_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "title";
    locala.GvH.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "description";
    locala.GvH.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "logo_url";
    locala.GvH.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "time";
    locala.GvH.put("time", "INTEGER");
    localStringBuilder.append(" time INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "card_id";
    locala.GvH.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "card_tp_id";
    locala.GvH.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "msg_id";
    locala.GvH.put("msg_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msg_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "msg_id";
    locala.columns[8] = "msg_type";
    locala.GvH.put("msg_type", "INTEGER");
    localStringBuilder.append(" msg_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "jump_type";
    locala.GvH.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "url";
    locala.GvH.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "buttonData";
    locala.GvH.put("buttonData", "BLOB");
    localStringBuilder.append(" buttonData BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "operData";
    locala.GvH.put("operData", "BLOB");
    localStringBuilder.append(" operData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "report_scene";
    locala.GvH.put("report_scene", "INTEGER");
    localStringBuilder.append(" report_scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "read_state";
    locala.GvH.put("read_state", "INTEGER default '0' ");
    localStringBuilder.append(" read_state INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "accept_buttons";
    locala.GvH.put("accept_buttons", "TEXT");
    localStringBuilder.append(" accept_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "consumed_box_id";
    locala.GvH.put("consumed_box_id", "TEXT");
    localStringBuilder.append(" consumed_box_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "jump_buttons";
    locala.GvH.put("jump_buttons", "TEXT");
    localStringBuilder.append(" jump_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "logo_color";
    locala.GvH.put("logo_color", "TEXT");
    localStringBuilder.append(" logo_color TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "unavailable_qr_code_list";
    locala.GvH.put("unavailable_qr_code_list", "TEXT");
    localStringBuilder.append(" unavailable_qr_code_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "all_unavailable";
    locala.GvH.put("all_unavailable", "INTEGER default 'false' ");
    localStringBuilder.append(" all_unavailable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "need_pull_card_entrance";
    locala.GvH.put("need_pull_card_entrance", "INTEGER default 'false' ");
    localStringBuilder.append(" need_pull_card_entrance INTEGER default 'false' ");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(112776);
  }
  
  public final qw bPZ()
  {
    AppMethodBeat.i(112771);
    qw localqw1;
    if (this.nVX != null)
    {
      localqw1 = this.nVX;
      AppMethodBeat.o(112771);
      return localqw1;
    }
    try
    {
      this.nVX = ((qw)new qw().parseFrom(this.field_buttonData));
      localqw1 = this.nVX;
      AppMethodBeat.o(112771);
      return localqw1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      qw localqw2 = new qw();
      AppMethodBeat.o(112771);
      return localqw2;
    }
  }
  
  public final rn bQa()
  {
    AppMethodBeat.i(112772);
    rn localrn1;
    if (this.nVY != null)
    {
      localrn1 = this.nVY;
      AppMethodBeat.o(112772);
      return localrn1;
    }
    try
    {
      this.nVY = ((rn)new rn().parseFrom(this.field_operData));
      localrn1 = this.nVY;
      AppMethodBeat.o(112772);
      return localrn1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      rn localrn2 = new rn();
      AppMethodBeat.o(112772);
      return localrn2;
    }
  }
  
  public final void bQb()
  {
    AppMethodBeat.i(112773);
    if (this.nVZ == null)
    {
      this.nVZ = new ArrayList();
      if (bs.isNullOrNil(this.field_accept_buttons))
      {
        AppMethodBeat.o(112773);
        return;
      }
      Map localMap = bv.L(this.field_accept_buttons, "accept_buttons_list");
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
          if ((bs.isNullOrNil((String)localObject2)) && (bs.isNullOrNil(str))) {
            break label452;
          }
          int j = bs.getInt((String)localMap.get((String)localObject1 + ".end_time"), 0);
          if ((j == 0) || (j > bs.aNx()))
          {
            localObject2 = new a();
            ((a)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
            ((a)localObject2).mBH = ((String)localMap.get((String)localObject1 + ".sub_title"));
            ((a)localObject2).nWf = ((String)localMap.get((String)localObject1 + ".card_ext"));
            ((a)localObject2).cardId = ((String)localMap.get((String)localObject1 + ".card_id"));
            ((a)localObject2).nWg = bs.getInt((String)localMap.get((String)localObject1 + ".action_type"), 0);
            ((a)localObject2).hbI = j;
            this.nVZ.add(localObject2);
          }
          i += 1;
          break;
        }
      }
    }
    label452:
    AppMethodBeat.o(112773);
  }
  
  public final void bQc()
  {
    AppMethodBeat.i(112774);
    if (this.nWa == null)
    {
      this.nWa = new ArrayList();
      if (bs.isNullOrNil(this.field_jump_buttons))
      {
        AppMethodBeat.o(112774);
        return;
      }
      Map localMap = bv.L(this.field_jump_buttons, "jump_buttons_list");
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
          if (bs.isNullOrNil((String)localMap.get((String)localObject1 + ".title"))) {
            break label308;
          }
          localObject2 = new b();
          ((b)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
          ((b)localObject2).description = ((String)localMap.get((String)localObject1 + ".description"));
          ((b)localObject2).nWi = ((String)localMap.get((String)localObject1 + ".button_wording"));
          ((b)localObject2).nWj = ((String)localMap.get((String)localObject1 + ".jump_url"));
          this.nWa.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label308:
    AppMethodBeat.o(112774);
  }
  
  public final void bQd()
  {
    AppMethodBeat.i(112775);
    if (this.nWe == null)
    {
      this.nWe = new ArrayList();
      if (bs.isNullOrNil(this.field_unavailable_qr_code_list))
      {
        AppMethodBeat.o(112775);
        return;
      }
      Map localMap = bv.L(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
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
          if (bs.isNullOrNil((String)localMap.get((String)localObject1 + ".code_id"))) {
            break label205;
          }
          localObject2 = new c();
          ((c)localObject2).nWk = ((String)localMap.get((String)localObject1 + ".code_id"));
          this.nWe.add(localObject2);
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
    public int hbI;
    public String mBH;
    public String nWf;
    public int nWg;
    public String title;
    
    public a() {}
  }
  
  public final class b
  {
    public String description;
    public String nWi;
    public String nWj;
    public String title;
    
    public b() {}
  }
  
  public final class c
  {
    public String nWk;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.g
 * JD-Core Version:    0.7.0.1
 */