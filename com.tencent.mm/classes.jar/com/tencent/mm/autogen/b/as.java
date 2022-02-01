package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class as
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("CardMsgInfo");
  public static final Column jON;
  public static final Column jOO;
  private static final int jOT;
  private static final int jOU;
  private static final int jPC;
  public static final Column jPu;
  public static final Column jUQ;
  public static final Column jUR;
  public static final Column jUS;
  public static final Column jUT;
  public static final Column jUU;
  public static final Column jUV;
  public static final Column jUW;
  public static final Column jUX;
  public static final Column jUY;
  public static final Column jUZ;
  private static final int jVC;
  private static final int jVD;
  private static final int jVE;
  private static final int jVF;
  private static final int jVG;
  private static final int jVH;
  private static final int jVI;
  private static final int jVJ;
  private static final int jVK;
  private static final int jVL;
  private static final int jVM;
  private static final int jVN;
  private static final int jVO;
  private static final int jVP;
  private static final int jVQ;
  private static final int jVR;
  private static final int jVS;
  private static final int jVT;
  private static final int jVU;
  public static final Column jVa;
  public static final Column jVb;
  public static final Column jVc;
  public static final Column jVd;
  public static final Column jVe;
  public static final Column jVf;
  public static final Column jVg;
  public static final Column jVh;
  public static final Column jVi;
  private static final StorageObserverOwner<as> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_accept_buttons;
  public boolean field_all_unavailable;
  public byte[] field_buttonData;
  public String field_card_id;
  public String field_card_tp_id;
  public int field_card_type;
  public String field_consumed_box_id;
  public String field_description;
  public String field_jump_buttons;
  public int field_jump_type;
  public String field_logo_color;
  public String field_logo_url;
  public String field_msg_id;
  public int field_msg_type;
  public boolean field_need_pull_card_entrance;
  public byte[] field_operData;
  public int field_read_state;
  public int field_report_scene;
  public int field_time;
  public String field_title;
  public String field_unavailable_qr_code_list;
  public String field_url;
  private boolean jOQ = true;
  private boolean jOR = true;
  private boolean jPy = true;
  private boolean jVA = true;
  private boolean jVB = true;
  private boolean jVj = true;
  private boolean jVk = true;
  private boolean jVl = true;
  private boolean jVm = true;
  private boolean jVn = true;
  private boolean jVo = true;
  private boolean jVp = true;
  private boolean jVq = true;
  private boolean jVr = true;
  private boolean jVs = true;
  private boolean jVt = true;
  private boolean jVu = true;
  private boolean jVv = true;
  private boolean jVw = true;
  private boolean jVx = true;
  private boolean jVy = true;
  private boolean jVz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jUQ = new Column("card_type", "int", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    jOO = new Column("description", "string", TABLE.getName(), "");
    jUR = new Column("logo_url", "string", TABLE.getName(), "");
    jUS = new Column("time", "int", TABLE.getName(), "");
    jUT = new Column("card_id", "string", TABLE.getName(), "");
    jUU = new Column("card_tp_id", "string", TABLE.getName(), "");
    jUV = new Column("msg_id", "string", TABLE.getName(), "");
    jUW = new Column("msg_type", "int", TABLE.getName(), "");
    jUX = new Column("jump_type", "int", TABLE.getName(), "");
    jPu = new Column("url", "string", TABLE.getName(), "");
    jUY = new Column("buttonData", "byte[]", TABLE.getName(), "");
    jUZ = new Column("operData", "byte[]", TABLE.getName(), "");
    jVa = new Column("report_scene", "int", TABLE.getName(), "");
    jVb = new Column("read_state", "int", TABLE.getName(), "");
    jVc = new Column("accept_buttons", "string", TABLE.getName(), "");
    jVd = new Column("consumed_box_id", "string", TABLE.getName(), "");
    jVe = new Column("jump_buttons", "string", TABLE.getName(), "");
    jVf = new Column("logo_color", "string", TABLE.getName(), "");
    jVg = new Column("unavailable_qr_code_list", "string", TABLE.getName(), "");
    jVh = new Column("all_unavailable", "boolean", TABLE.getName(), "");
    jVi = new Column("need_pull_card_entrance", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jVC = "card_type".hashCode();
    jOT = "title".hashCode();
    jOU = "description".hashCode();
    jVD = "logo_url".hashCode();
    jVE = "time".hashCode();
    jVF = "card_id".hashCode();
    jVG = "card_tp_id".hashCode();
    jVH = "msg_id".hashCode();
    jVI = "msg_type".hashCode();
    jVJ = "jump_type".hashCode();
    jPC = "url".hashCode();
    jVK = "buttonData".hashCode();
    jVL = "operData".hashCode();
    jVM = "report_scene".hashCode();
    jVN = "read_state".hashCode();
    jVO = "accept_buttons".hashCode();
    jVP = "consumed_box_id".hashCode();
    jVQ = "jump_buttons".hashCode();
    jVR = "logo_color".hashCode();
    jVS = "unavailable_qr_code_list".hashCode();
    jVT = "all_unavailable".hashCode();
    jVU = "need_pull_card_entrance".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
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
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("card_type"))
    {
      this.field_card_type = paramContentValues.getAsInteger("card_type").intValue();
      if (paramBoolean) {
        this.jVj = true;
      }
    }
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("description"))
    {
      this.field_description = paramContentValues.getAsString("description");
      if (paramBoolean) {
        this.jOR = true;
      }
    }
    if (paramContentValues.containsKey("logo_url"))
    {
      this.field_logo_url = paramContentValues.getAsString("logo_url");
      if (paramBoolean) {
        this.jVk = true;
      }
    }
    if (paramContentValues.containsKey("time"))
    {
      this.field_time = paramContentValues.getAsInteger("time").intValue();
      if (paramBoolean) {
        this.jVl = true;
      }
    }
    if (paramContentValues.containsKey("card_id"))
    {
      this.field_card_id = paramContentValues.getAsString("card_id");
      if (paramBoolean) {
        this.jVm = true;
      }
    }
    if (paramContentValues.containsKey("card_tp_id"))
    {
      this.field_card_tp_id = paramContentValues.getAsString("card_tp_id");
      if (paramBoolean) {
        this.jVn = true;
      }
    }
    if (paramContentValues.containsKey("msg_id"))
    {
      this.field_msg_id = paramContentValues.getAsString("msg_id");
      if (paramBoolean) {
        this.jVo = true;
      }
    }
    if (paramContentValues.containsKey("msg_type"))
    {
      this.field_msg_type = paramContentValues.getAsInteger("msg_type").intValue();
      if (paramBoolean) {
        this.jVp = true;
      }
    }
    if (paramContentValues.containsKey("jump_type"))
    {
      this.field_jump_type = paramContentValues.getAsInteger("jump_type").intValue();
      if (paramBoolean) {
        this.jVq = true;
      }
    }
    if (paramContentValues.containsKey("url"))
    {
      this.field_url = paramContentValues.getAsString("url");
      if (paramBoolean) {
        this.jPy = true;
      }
    }
    if (paramContentValues.containsKey("buttonData"))
    {
      this.field_buttonData = paramContentValues.getAsByteArray("buttonData");
      if (paramBoolean) {
        this.jVr = true;
      }
    }
    if (paramContentValues.containsKey("operData"))
    {
      this.field_operData = paramContentValues.getAsByteArray("operData");
      if (paramBoolean) {
        this.jVs = true;
      }
    }
    if (paramContentValues.containsKey("report_scene"))
    {
      this.field_report_scene = paramContentValues.getAsInteger("report_scene").intValue();
      if (paramBoolean) {
        this.jVt = true;
      }
    }
    if (paramContentValues.containsKey("read_state"))
    {
      this.field_read_state = paramContentValues.getAsInteger("read_state").intValue();
      if (paramBoolean) {
        this.jVu = true;
      }
    }
    if (paramContentValues.containsKey("accept_buttons"))
    {
      this.field_accept_buttons = paramContentValues.getAsString("accept_buttons");
      if (paramBoolean) {
        this.jVv = true;
      }
    }
    if (paramContentValues.containsKey("consumed_box_id"))
    {
      this.field_consumed_box_id = paramContentValues.getAsString("consumed_box_id");
      if (paramBoolean) {
        this.jVw = true;
      }
    }
    if (paramContentValues.containsKey("jump_buttons"))
    {
      this.field_jump_buttons = paramContentValues.getAsString("jump_buttons");
      if (paramBoolean) {
        this.jVx = true;
      }
    }
    if (paramContentValues.containsKey("logo_color"))
    {
      this.field_logo_color = paramContentValues.getAsString("logo_color");
      if (paramBoolean) {
        this.jVy = true;
      }
    }
    if (paramContentValues.containsKey("unavailable_qr_code_list"))
    {
      this.field_unavailable_qr_code_list = paramContentValues.getAsString("unavailable_qr_code_list");
      if (paramBoolean) {
        this.jVz = true;
      }
    }
    if (paramContentValues.containsKey("all_unavailable")) {
      if (paramContentValues.getAsInteger("all_unavailable").intValue() == 0) {
        break label681;
      }
    }
    label681:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_all_unavailable = bool1;
      if (paramBoolean) {
        this.jVA = true;
      }
      if (paramContentValues.containsKey("need_pull_card_entrance"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("need_pull_card_entrance").intValue() != 0) {
          bool1 = true;
        }
        this.field_need_pull_card_entrance = bool1;
        if (paramBoolean) {
          this.jVB = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (jVC != k) {
        break label60;
      }
      this.field_card_type = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jOT == k)
      {
        this.field_title = paramCursor.getString(i);
      }
      else if (jOU == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (jVD == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (jVE == k)
      {
        this.field_time = paramCursor.getInt(i);
      }
      else if (jVF == k)
      {
        this.field_card_id = paramCursor.getString(i);
      }
      else if (jVG == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (jVH == k)
      {
        this.field_msg_id = paramCursor.getString(i);
        this.jVo = true;
      }
      else if (jVI == k)
      {
        this.field_msg_type = paramCursor.getInt(i);
      }
      else if (jVJ == k)
      {
        this.field_jump_type = paramCursor.getInt(i);
      }
      else if (jPC == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (jVK == k)
      {
        this.field_buttonData = paramCursor.getBlob(i);
      }
      else if (jVL == k)
      {
        this.field_operData = paramCursor.getBlob(i);
      }
      else if (jVM == k)
      {
        this.field_report_scene = paramCursor.getInt(i);
      }
      else if (jVN == k)
      {
        this.field_read_state = paramCursor.getInt(i);
      }
      else if (jVO == k)
      {
        this.field_accept_buttons = paramCursor.getString(i);
      }
      else if (jVP == k)
      {
        this.field_consumed_box_id = paramCursor.getString(i);
      }
      else if (jVQ == k)
      {
        this.field_jump_buttons = paramCursor.getString(i);
      }
      else if (jVR == k)
      {
        this.field_logo_color = paramCursor.getString(i);
      }
      else if (jVS == k)
      {
        this.field_unavailable_qr_code_list = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (jVT == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_all_unavailable = bool;
            break;
          }
        }
        if (jVU == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_need_pull_card_entrance = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jVj) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.jOR) {
      localContentValues.put("description", this.field_description);
    }
    if (this.jVk) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.jVl) {
      localContentValues.put("time", Integer.valueOf(this.field_time));
    }
    if (this.jVm) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.jVn) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.jVo) {
      localContentValues.put("msg_id", this.field_msg_id);
    }
    if (this.jVp) {
      localContentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
    }
    if (this.jVq) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.jPy) {
      localContentValues.put("url", this.field_url);
    }
    if (this.jVr) {
      localContentValues.put("buttonData", this.field_buttonData);
    }
    if (this.jVs) {
      localContentValues.put("operData", this.field_operData);
    }
    if (this.jVt) {
      localContentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
    }
    if (this.jVu) {
      localContentValues.put("read_state", Integer.valueOf(this.field_read_state));
    }
    if (this.jVv) {
      localContentValues.put("accept_buttons", this.field_accept_buttons);
    }
    if (this.jVw) {
      localContentValues.put("consumed_box_id", this.field_consumed_box_id);
    }
    if (this.jVx) {
      localContentValues.put("jump_buttons", this.field_jump_buttons);
    }
    if (this.jVy) {
      localContentValues.put("logo_color", this.field_logo_color);
    }
    if (this.jVz) {
      localContentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
    }
    if (this.jVA) {
      localContentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
    }
    if (this.jVB) {
      localContentValues.put("need_pull_card_entrance", Boolean.valueOf(this.field_need_pull_card_entrance));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends as> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_msg_id;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.as
 * JD-Core Version:    0.7.0.1
 */