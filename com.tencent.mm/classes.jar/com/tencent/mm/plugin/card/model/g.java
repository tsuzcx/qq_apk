package com.tencent.mm.plugin.card.model;

import com.tencent.mm.h.c.ai;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g
  extends ai
{
  protected static c.a buS;
  public String imH = "";
  public String imI = "";
  public String imJ;
  public String imK;
  public String imL;
  public boolean imM = false;
  public lt imN;
  public ly imO;
  public List<a> imP = null;
  public List<g.b> imQ = null;
  public int imR = 0;
  public int imS = 0;
  public boolean imT;
  public List<c> imU = null;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_type";
    locala.ujN.put("card_type", "INTEGER");
    localStringBuilder.append(" card_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "title";
    locala.ujN.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "description";
    locala.ujN.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "logo_url";
    locala.ujN.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "time";
    locala.ujN.put("time", "INTEGER");
    localStringBuilder.append(" time INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "card_id";
    locala.ujN.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "card_tp_id";
    locala.ujN.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "msg_id";
    locala.ujN.put("msg_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msg_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "msg_id";
    locala.columns[8] = "msg_type";
    locala.ujN.put("msg_type", "INTEGER");
    localStringBuilder.append(" msg_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "jump_type";
    locala.ujN.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "url";
    locala.ujN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "buttonData";
    locala.ujN.put("buttonData", "BLOB");
    localStringBuilder.append(" buttonData BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "operData";
    locala.ujN.put("operData", "BLOB");
    localStringBuilder.append(" operData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "report_scene";
    locala.ujN.put("report_scene", "INTEGER");
    localStringBuilder.append(" report_scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "read_state";
    locala.ujN.put("read_state", "INTEGER default '0' ");
    localStringBuilder.append(" read_state INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "accept_buttons";
    locala.ujN.put("accept_buttons", "TEXT");
    localStringBuilder.append(" accept_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "consumed_box_id";
    locala.ujN.put("consumed_box_id", "TEXT");
    localStringBuilder.append(" consumed_box_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "jump_buttons";
    locala.ujN.put("jump_buttons", "TEXT");
    localStringBuilder.append(" jump_buttons TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "logo_color";
    locala.ujN.put("logo_color", "TEXT");
    localStringBuilder.append(" logo_color TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "unavailable_qr_code_list";
    locala.ujN.put("unavailable_qr_code_list", "TEXT");
    localStringBuilder.append(" unavailable_qr_code_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "all_unavailable";
    locala.ujN.put("all_unavailable", "INTEGER default 'false' ");
    localStringBuilder.append(" all_unavailable INTEGER default 'false' ");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final lt aAi()
  {
    if (this.imN != null) {
      return this.imN;
    }
    try
    {
      this.imN = ((lt)new lt().aH(this.field_buttonData));
      return this.imN;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[] { localException.getMessage() });
      y.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
    }
    return new lt();
  }
  
  public final ly aAj()
  {
    if (this.imO != null) {
      return this.imO;
    }
    try
    {
      this.imO = ((ly)new ly().aH(this.field_operData));
      return this.imO;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[] { localException.getMessage() });
      y.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
    }
    return new ly();
  }
  
  public final void aAk()
  {
    if (this.imP == null)
    {
      this.imP = new ArrayList();
      if (!bk.bl(this.field_accept_buttons)) {
        break label29;
      }
    }
    label29:
    Map localMap;
    do
    {
      return;
      localMap = bn.s(this.field_accept_buttons, "accept_buttons_list");
    } while (localMap == null);
    int i = 0;
    label48:
    Object localObject2;
    if (i < 100)
    {
      localObject2 = new StringBuilder(".accept_buttons_list.accept_buttons");
      if (i <= 0) {
        break label427;
      }
    }
    label427:
    for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
    {
      localObject1 = localObject1;
      localObject2 = (String)localMap.get((String)localObject1 + ".card_id");
      String str = (String)localMap.get((String)localObject1 + ".title");
      if ((bk.bl((String)localObject2)) && (bk.bl(str))) {
        break;
      }
      int j = bk.getInt((String)localMap.get((String)localObject1 + ".end_time"), 0);
      if ((j == 0) || (j > bk.UX()))
      {
        localObject2 = new a();
        ((a)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
        ((a)localObject2).imV = ((String)localMap.get((String)localObject1 + ".sub_title"));
        ((a)localObject2).imW = ((String)localMap.get((String)localObject1 + ".card_ext"));
        ((a)localObject2).cardId = ((String)localMap.get((String)localObject1 + ".card_id"));
        ((a)localObject2).imX = bk.getInt((String)localMap.get((String)localObject1 + ".action_type"), 0);
        ((a)localObject2).endTime = j;
        this.imP.add(localObject2);
      }
      i += 1;
      break label48;
      break;
    }
  }
  
  public final void aAl()
  {
    if (this.imQ == null)
    {
      this.imQ = new ArrayList();
      if (!bk.bl(this.field_jump_buttons)) {
        break label29;
      }
    }
    label29:
    Map localMap;
    do
    {
      return;
      localMap = bn.s(this.field_jump_buttons, "jump_buttons_list");
    } while (localMap == null);
    int i = 0;
    label46:
    Object localObject2;
    if (i < 100)
    {
      localObject2 = new StringBuilder(".jump_buttons_list.jump_buttons");
      if (i <= 0) {
        break label283;
      }
    }
    label283:
    for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
    {
      localObject1 = localObject1;
      if (bk.bl((String)localMap.get((String)localObject1 + ".title"))) {
        break;
      }
      localObject2 = new g.b(this);
      ((g.b)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
      ((g.b)localObject2).description = ((String)localMap.get((String)localObject1 + ".description"));
      ((g.b)localObject2).imZ = ((String)localMap.get((String)localObject1 + ".button_wording"));
      ((g.b)localObject2).ina = ((String)localMap.get((String)localObject1 + ".jump_url"));
      this.imQ.add(localObject2);
      i += 1;
      break label46;
      break;
    }
  }
  
  public final void aAm()
  {
    if (this.imU == null)
    {
      this.imU = new ArrayList();
      if (!bk.bl(this.field_unavailable_qr_code_list)) {
        break label29;
      }
    }
    label29:
    Map localMap;
    do
    {
      return;
      localMap = bn.s(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
    } while (localMap == null);
    int i = 0;
    label45:
    Object localObject2;
    if (i < 100)
    {
      localObject2 = new StringBuilder(".unavailable_qr_code_list.unavailable_qr_codes");
      if (i <= 0) {
        break label180;
      }
    }
    label180:
    for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
    {
      localObject1 = localObject1;
      if (bk.bl((String)localMap.get((String)localObject1 + ".code_id"))) {
        break;
      }
      localObject2 = new c();
      ((c)localObject2).inb = ((String)localMap.get((String)localObject1 + ".code_id"));
      this.imU.add(localObject2);
      i += 1;
      break label45;
      break;
    }
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final class a
  {
    public String cardId;
    public int endTime;
    public String imV;
    public String imW;
    public int imX;
    public String title;
    
    public a() {}
  }
  
  public final class c
  {
    public String inb;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.g
 * JD-Core Version:    0.7.0.1
 */