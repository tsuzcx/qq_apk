package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g
  extends aq
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public tw pTA;
  public uo pTB;
  public List<a> pTC = null;
  public List<b> pTD = null;
  public int pTE = 0;
  public int pTF = 0;
  public boolean pTG;
  public List<c> pTH = null;
  public String pTu = "";
  public String pTv = "";
  public String pTw;
  public String pTx;
  public String pTy;
  public boolean pTz = false;
  
  static
  {
    AppMethodBeat.i(112776);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[22];
    localMAutoDBInfo.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "card_type";
    localMAutoDBInfo.colsMap.put("card_type", "INTEGER");
    localStringBuilder.append(" card_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "description";
    localMAutoDBInfo.colsMap.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "logo_url";
    localMAutoDBInfo.colsMap.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "time";
    localMAutoDBInfo.colsMap.put("time", "INTEGER");
    localStringBuilder.append(" time INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "card_id";
    localMAutoDBInfo.colsMap.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "card_tp_id";
    localMAutoDBInfo.colsMap.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "msg_id";
    localMAutoDBInfo.colsMap.put("msg_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msg_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msg_id";
    localMAutoDBInfo.columns[8] = "msg_type";
    localMAutoDBInfo.colsMap.put("msg_type", "INTEGER");
    localStringBuilder.append(" msg_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "jump_type";
    localMAutoDBInfo.colsMap.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "buttonData";
    localMAutoDBInfo.colsMap.put("buttonData", "BLOB");
    localStringBuilder.append(" buttonData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "operData";
    localMAutoDBInfo.colsMap.put("operData", "BLOB");
    localStringBuilder.append(" operData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "report_scene";
    localMAutoDBInfo.colsMap.put("report_scene", "INTEGER");
    localStringBuilder.append(" report_scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "read_state";
    localMAutoDBInfo.colsMap.put("read_state", "INTEGER default '0' ");
    localStringBuilder.append(" read_state INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "accept_buttons";
    localMAutoDBInfo.colsMap.put("accept_buttons", "TEXT");
    localStringBuilder.append(" accept_buttons TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "consumed_box_id";
    localMAutoDBInfo.colsMap.put("consumed_box_id", "TEXT");
    localStringBuilder.append(" consumed_box_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "jump_buttons";
    localMAutoDBInfo.colsMap.put("jump_buttons", "TEXT");
    localStringBuilder.append(" jump_buttons TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "logo_color";
    localMAutoDBInfo.colsMap.put("logo_color", "TEXT");
    localStringBuilder.append(" logo_color TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "unavailable_qr_code_list";
    localMAutoDBInfo.colsMap.put("unavailable_qr_code_list", "TEXT");
    localStringBuilder.append(" unavailable_qr_code_list TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "all_unavailable";
    localMAutoDBInfo.colsMap.put("all_unavailable", "INTEGER default 'false' ");
    localStringBuilder.append(" all_unavailable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "need_pull_card_entrance";
    localMAutoDBInfo.colsMap.put("need_pull_card_entrance", "INTEGER default 'false' ");
    localStringBuilder.append(" need_pull_card_entrance INTEGER default 'false' ");
    localMAutoDBInfo.columns[22] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(112776);
  }
  
  public final tw ctH()
  {
    AppMethodBeat.i(112771);
    tw localtw1;
    if (this.pTA != null)
    {
      localtw1 = this.pTA;
      AppMethodBeat.o(112771);
      return localtw1;
    }
    try
    {
      this.pTA = ((tw)new tw().parseFrom(this.field_buttonData));
      localtw1 = this.pTA;
      AppMethodBeat.o(112771);
      return localtw1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      tw localtw2 = new tw();
      AppMethodBeat.o(112771);
      return localtw2;
    }
  }
  
  public final uo ctI()
  {
    AppMethodBeat.i(112772);
    uo localuo1;
    if (this.pTB != null)
    {
      localuo1 = this.pTB;
      AppMethodBeat.o(112772);
      return localuo1;
    }
    try
    {
      this.pTB = ((uo)new uo().parseFrom(this.field_operData));
      localuo1 = this.pTB;
      AppMethodBeat.o(112772);
      return localuo1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      uo localuo2 = new uo();
      AppMethodBeat.o(112772);
      return localuo2;
    }
  }
  
  public final void ctJ()
  {
    AppMethodBeat.i(112773);
    if (this.pTC == null)
    {
      this.pTC = new ArrayList();
      if (Util.isNullOrNil(this.field_accept_buttons))
      {
        AppMethodBeat.o(112773);
        return;
      }
      Map localMap = XmlParser.parseXml(this.field_accept_buttons, "accept_buttons_list", null);
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
          if ((Util.isNullOrNil((String)localObject2)) && (Util.isNullOrNil(str))) {
            break label453;
          }
          int j = Util.getInt((String)localMap.get((String)localObject1 + ".end_time"), 0);
          if ((j == 0) || (j > Util.nowSecond()))
          {
            localObject2 = new a();
            ((a)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
            ((a)localObject2).oqZ = ((String)localMap.get((String)localObject1 + ".sub_title"));
            ((a)localObject2).cardExt = ((String)localMap.get((String)localObject1 + ".card_ext"));
            ((a)localObject2).cardId = ((String)localMap.get((String)localObject1 + ".card_id"));
            ((a)localObject2).pTI = Util.getInt((String)localMap.get((String)localObject1 + ".action_type"), 0);
            ((a)localObject2).iqg = j;
            this.pTC.add(localObject2);
          }
          i += 1;
          break;
        }
      }
    }
    label453:
    AppMethodBeat.o(112773);
  }
  
  public final void ctK()
  {
    AppMethodBeat.i(112774);
    if (this.pTD == null)
    {
      this.pTD = new ArrayList();
      if (Util.isNullOrNil(this.field_jump_buttons))
      {
        AppMethodBeat.o(112774);
        return;
      }
      Map localMap = XmlParser.parseXml(this.field_jump_buttons, "jump_buttons_list", null);
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
          if (Util.isNullOrNil((String)localMap.get((String)localObject1 + ".title"))) {
            break label309;
          }
          localObject2 = new b();
          ((b)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
          ((b)localObject2).description = ((String)localMap.get((String)localObject1 + ".description"));
          ((b)localObject2).pTK = ((String)localMap.get((String)localObject1 + ".button_wording"));
          ((b)localObject2).pTL = ((String)localMap.get((String)localObject1 + ".jump_url"));
          this.pTD.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label309:
    AppMethodBeat.o(112774);
  }
  
  public final void ctL()
  {
    AppMethodBeat.i(112775);
    if (this.pTH == null)
    {
      this.pTH = new ArrayList();
      if (Util.isNullOrNil(this.field_unavailable_qr_code_list))
      {
        AppMethodBeat.o(112775);
        return;
      }
      Map localMap = XmlParser.parseXml(this.field_unavailable_qr_code_list, "unavailable_qr_code_list", null);
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
          if (Util.isNullOrNil((String)localMap.get((String)localObject1 + ".code_id"))) {
            break label206;
          }
          localObject2 = new c();
          ((c)localObject2).pTM = ((String)localMap.get((String)localObject1 + ".code_id"));
          this.pTH.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label206:
    AppMethodBeat.o(112775);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final class a
  {
    public String cardExt;
    public String cardId;
    public int iqg;
    public String oqZ;
    public int pTI;
    public String title;
    
    public a() {}
  }
  
  public final class b
  {
    public String description;
    public String pTK;
    public String pTL;
    public String title;
    
    public b() {}
  }
  
  public final class c
  {
    public String pTM;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.g
 * JD-Core Version:    0.7.0.1
 */