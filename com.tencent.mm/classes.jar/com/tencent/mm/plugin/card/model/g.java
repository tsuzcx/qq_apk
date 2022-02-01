package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ap;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g
  extends ap
{
  protected static c.a info;
  public String oFN = "";
  public String oFO = "";
  public String oFP;
  public String oFQ;
  public String oFR;
  public boolean oFS = false;
  public sr oFT;
  public tj oFU;
  public List<a> oFV = null;
  public List<b> oFW = null;
  public int oFX = 0;
  public int oFY = 0;
  public boolean oFZ;
  public List<c> oGa = null;
  
  static
  {
    AppMethodBeat.i(112776);
    c.a locala = new c.a();
    locala.IBL = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_type";
    locala.IBN.put("card_type", "INTEGER");
    localStringBuilder.append(" card_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "title";
    locala.IBN.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "description";
    locala.IBN.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "logo_url";
    locala.IBN.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "time";
    locala.IBN.put("time", "INTEGER");
    localStringBuilder.append(" time INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "card_id";
    locala.IBN.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "card_tp_id";
    locala.IBN.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "msg_id";
    locala.IBN.put("msg_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msg_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "msg_id";
    locala.columns[8] = "msg_type";
    locala.IBN.put("msg_type", "INTEGER");
    localStringBuilder.append(" msg_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "jump_type";
    locala.IBN.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "url";
    locala.IBN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "buttonData";
    locala.IBN.put("buttonData", "BLOB");
    localStringBuilder.append(" buttonData BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "operData";
    locala.IBN.put("operData", "BLOB");
    localStringBuilder.append(" operData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "report_scene";
    locala.IBN.put("report_scene", "INTEGER");
    localStringBuilder.append(" report_scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "read_state";
    locala.IBN.put("read_state", "INTEGER default '0' ");
    localStringBuilder.append(" read_state INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "accept_buttons";
    locala.IBN.put("accept_buttons", "TEXT");
    localStringBuilder.append(" accept_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "consumed_box_id";
    locala.IBN.put("consumed_box_id", "TEXT");
    localStringBuilder.append(" consumed_box_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "jump_buttons";
    locala.IBN.put("jump_buttons", "TEXT");
    localStringBuilder.append(" jump_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "logo_color";
    locala.IBN.put("logo_color", "TEXT");
    localStringBuilder.append(" logo_color TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "unavailable_qr_code_list";
    locala.IBN.put("unavailable_qr_code_list", "TEXT");
    localStringBuilder.append(" unavailable_qr_code_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "all_unavailable";
    locala.IBN.put("all_unavailable", "INTEGER default 'false' ");
    localStringBuilder.append(" all_unavailable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "need_pull_card_entrance";
    locala.IBN.put("need_pull_card_entrance", "INTEGER default 'false' ");
    localStringBuilder.append(" need_pull_card_entrance INTEGER default 'false' ");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(112776);
  }
  
  public final sr bVT()
  {
    AppMethodBeat.i(112771);
    sr localsr1;
    if (this.oFT != null)
    {
      localsr1 = this.oFT;
      AppMethodBeat.o(112771);
      return localsr1;
    }
    try
    {
      this.oFT = ((sr)new sr().parseFrom(this.field_buttonData));
      localsr1 = this.oFT;
      AppMethodBeat.o(112771);
      return localsr1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      sr localsr2 = new sr();
      AppMethodBeat.o(112771);
      return localsr2;
    }
  }
  
  public final tj bVU()
  {
    AppMethodBeat.i(112772);
    tj localtj1;
    if (this.oFU != null)
    {
      localtj1 = this.oFU;
      AppMethodBeat.o(112772);
      return localtj1;
    }
    try
    {
      this.oFU = ((tj)new tj().parseFrom(this.field_operData));
      localtj1 = this.oFU;
      AppMethodBeat.o(112772);
      return localtj1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      tj localtj2 = new tj();
      AppMethodBeat.o(112772);
      return localtj2;
    }
  }
  
  public final void bVV()
  {
    AppMethodBeat.i(112773);
    if (this.oFV == null)
    {
      this.oFV = new ArrayList();
      if (bu.isNullOrNil(this.field_accept_buttons))
      {
        AppMethodBeat.o(112773);
        return;
      }
      Map localMap = bx.M(this.field_accept_buttons, "accept_buttons_list");
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
          if ((bu.isNullOrNil((String)localObject2)) && (bu.isNullOrNil(str))) {
            break label452;
          }
          int j = bu.getInt((String)localMap.get((String)localObject1 + ".end_time"), 0);
          if ((j == 0) || (j > bu.aRi()))
          {
            localObject2 = new a();
            ((a)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
            ((a)localObject2).nhq = ((String)localMap.get((String)localObject1 + ".sub_title"));
            ((a)localObject2).oGb = ((String)localMap.get((String)localObject1 + ".card_ext"));
            ((a)localObject2).cardId = ((String)localMap.get((String)localObject1 + ".card_id"));
            ((a)localObject2).oGc = bu.getInt((String)localMap.get((String)localObject1 + ".action_type"), 0);
            ((a)localObject2).hwE = j;
            this.oFV.add(localObject2);
          }
          i += 1;
          break;
        }
      }
    }
    label452:
    AppMethodBeat.o(112773);
  }
  
  public final void bVW()
  {
    AppMethodBeat.i(112774);
    if (this.oFW == null)
    {
      this.oFW = new ArrayList();
      if (bu.isNullOrNil(this.field_jump_buttons))
      {
        AppMethodBeat.o(112774);
        return;
      }
      Map localMap = bx.M(this.field_jump_buttons, "jump_buttons_list");
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
          if (bu.isNullOrNil((String)localMap.get((String)localObject1 + ".title"))) {
            break label308;
          }
          localObject2 = new b();
          ((b)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
          ((b)localObject2).description = ((String)localMap.get((String)localObject1 + ".description"));
          ((b)localObject2).oGe = ((String)localMap.get((String)localObject1 + ".button_wording"));
          ((b)localObject2).oGf = ((String)localMap.get((String)localObject1 + ".jump_url"));
          this.oFW.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label308:
    AppMethodBeat.o(112774);
  }
  
  public final void bVX()
  {
    AppMethodBeat.i(112775);
    if (this.oGa == null)
    {
      this.oGa = new ArrayList();
      if (bu.isNullOrNil(this.field_unavailable_qr_code_list))
      {
        AppMethodBeat.o(112775);
        return;
      }
      Map localMap = bx.M(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
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
          if (bu.isNullOrNil((String)localMap.get((String)localObject1 + ".code_id"))) {
            break label205;
          }
          localObject2 = new c();
          ((c)localObject2).oGg = ((String)localMap.get((String)localObject1 + ".code_id"));
          this.oGa.add(localObject2);
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
    public int hwE;
    public String nhq;
    public String oGb;
    public int oGc;
    public String title;
    
    public a() {}
  }
  
  public final class b
  {
    public String description;
    public String oGe;
    public String oGf;
    public String title;
    
    public b() {}
  }
  
  public final class c
  {
    public String oGg;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.g
 * JD-Core Version:    0.7.0.1
 */