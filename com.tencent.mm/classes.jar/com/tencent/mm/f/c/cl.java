package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cl
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("FinderLiveGiftInfo");
  public static final Column hHa;
  public static final Column hHb;
  private static final int hIC = "state".hashCode();
  private static final int hID;
  private static final int hSA;
  private static final int hSB;
  private static final int hSC;
  private static final int hSD;
  private static final int hSE;
  private static final int hSF;
  private static final int hSG;
  private static final int hSH;
  private static final int hSI;
  private static final int hSJ = "giftIndex".hashCode();
  public static final Column hSd;
  public static final Column hSe;
  public static final Column hSf;
  public static final Column hSg;
  public static final Column hSh;
  public static final Column hSi;
  public static final Column hSj;
  public static final Column hSk;
  public static final Column hSl;
  public static final Column hSm;
  public static final Column hSn;
  private static final int hSz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_animationPagMd5;
  public String field_animationPagUrl;
  public int field_businessType;
  public int field_giftIndex;
  public int field_giftType;
  public String field_name;
  public String field_previewPagMd5;
  public String field_previewPagUrl;
  public float field_price;
  public String field_rewardProductId;
  public int field_state;
  public String field_thumbnailFileUrl;
  public String field_thumbnailMd5;
  private boolean hHO = true;
  private boolean hHP = true;
  private boolean hSo = true;
  private boolean hSp = true;
  private boolean hSq = true;
  private boolean hSr = true;
  private boolean hSs = true;
  private boolean hSt = true;
  private boolean hSu = true;
  private boolean hSv = true;
  private boolean hSw = true;
  private boolean hSx = true;
  private boolean hSy = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderLiveGiftInfo", "");
    hSd = new Column("rewardproductid", "string", "FinderLiveGiftInfo", "");
    hSe = new Column("businesstype", "int", "FinderLiveGiftInfo", "");
    hSf = new Column("thumbnailfileurl", "string", "FinderLiveGiftInfo", "");
    hSg = new Column("previewpagurl", "string", "FinderLiveGiftInfo", "");
    hSh = new Column("animationpagurl", "string", "FinderLiveGiftInfo", "");
    hSi = new Column("thumbnailmd5", "string", "FinderLiveGiftInfo", "");
    hSj = new Column("previewpagmd5", "string", "FinderLiveGiftInfo", "");
    hSk = new Column("animationpagmd5", "string", "FinderLiveGiftInfo", "");
    hSl = new Column("gifttype", "int", "FinderLiveGiftInfo", "");
    hHb = new Column("name", "string", "FinderLiveGiftInfo", "");
    hSm = new Column("price", "float", "FinderLiveGiftInfo", "");
    hHa = new Column("state", "int", "FinderLiveGiftInfo", "");
    hSn = new Column("giftindex", "int", "FinderLiveGiftInfo", "");
    hSz = "rewardProductId".hashCode();
    hSA = "businessType".hashCode();
    hSB = "thumbnailFileUrl".hashCode();
    hSC = "previewPagUrl".hashCode();
    hSD = "animationPagUrl".hashCode();
    hSE = "thumbnailMd5".hashCode();
    hSF = "previewPagMd5".hashCode();
    hSG = "animationPagMd5".hashCode();
    hSH = "giftType".hashCode();
    hID = "name".hashCode();
    hSI = "price".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "rewardProductId";
    localMAutoDBInfo.colsMap.put("rewardProductId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" rewardProductId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "rewardProductId";
    localMAutoDBInfo.columns[1] = "businessType";
    localMAutoDBInfo.colsMap.put("businessType", "INTEGER default '' ");
    localStringBuilder.append(" businessType INTEGER default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "thumbnailFileUrl";
    localMAutoDBInfo.colsMap.put("thumbnailFileUrl", "TEXT default '' ");
    localStringBuilder.append(" thumbnailFileUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "previewPagUrl";
    localMAutoDBInfo.colsMap.put("previewPagUrl", "TEXT default '' ");
    localStringBuilder.append(" previewPagUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "animationPagUrl";
    localMAutoDBInfo.colsMap.put("animationPagUrl", "TEXT default '' ");
    localStringBuilder.append(" animationPagUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "thumbnailMd5";
    localMAutoDBInfo.colsMap.put("thumbnailMd5", "TEXT default '' ");
    localStringBuilder.append(" thumbnailMd5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "previewPagMd5";
    localMAutoDBInfo.colsMap.put("previewPagMd5", "TEXT default '' ");
    localStringBuilder.append(" previewPagMd5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "animationPagMd5";
    localMAutoDBInfo.colsMap.put("animationPagMd5", "TEXT default '' ");
    localStringBuilder.append(" animationPagMd5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "giftType";
    localMAutoDBInfo.colsMap.put("giftType", "INTEGER default '' ");
    localStringBuilder.append(" giftType INTEGER default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "name";
    localMAutoDBInfo.colsMap.put("name", "TEXT default '' ");
    localStringBuilder.append(" name TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "price";
    localMAutoDBInfo.colsMap.put("price", "FLOAT");
    localStringBuilder.append(" price FLOAT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "giftIndex";
    localMAutoDBInfo.colsMap.put("giftIndex", "INTEGER");
    localStringBuilder.append(" giftIndex INTEGER");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (hSz != k) {
        break label65;
      }
      this.field_rewardProductId = paramCursor.getString(i);
      this.hSo = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hSA == k) {
        this.field_businessType = paramCursor.getInt(i);
      } else if (hSB == k) {
        this.field_thumbnailFileUrl = paramCursor.getString(i);
      } else if (hSC == k) {
        this.field_previewPagUrl = paramCursor.getString(i);
      } else if (hSD == k) {
        this.field_animationPagUrl = paramCursor.getString(i);
      } else if (hSE == k) {
        this.field_thumbnailMd5 = paramCursor.getString(i);
      } else if (hSF == k) {
        this.field_previewPagMd5 = paramCursor.getString(i);
      } else if (hSG == k) {
        this.field_animationPagMd5 = paramCursor.getString(i);
      } else if (hSH == k) {
        this.field_giftType = paramCursor.getInt(i);
      } else if (hID == k) {
        this.field_name = paramCursor.getString(i);
      } else if (hSI == k) {
        this.field_price = paramCursor.getFloat(i);
      } else if (hIC == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (hSJ == k) {
        this.field_giftIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hSo) {
      localContentValues.put("rewardProductId", this.field_rewardProductId);
    }
    if (this.hSp) {
      localContentValues.put("businessType", Integer.valueOf(this.field_businessType));
    }
    if (this.field_thumbnailFileUrl == null) {
      this.field_thumbnailFileUrl = "";
    }
    if (this.hSq) {
      localContentValues.put("thumbnailFileUrl", this.field_thumbnailFileUrl);
    }
    if (this.field_previewPagUrl == null) {
      this.field_previewPagUrl = "";
    }
    if (this.hSr) {
      localContentValues.put("previewPagUrl", this.field_previewPagUrl);
    }
    if (this.field_animationPagUrl == null) {
      this.field_animationPagUrl = "";
    }
    if (this.hSs) {
      localContentValues.put("animationPagUrl", this.field_animationPagUrl);
    }
    if (this.field_thumbnailMd5 == null) {
      this.field_thumbnailMd5 = "";
    }
    if (this.hSt) {
      localContentValues.put("thumbnailMd5", this.field_thumbnailMd5);
    }
    if (this.field_previewPagMd5 == null) {
      this.field_previewPagMd5 = "";
    }
    if (this.hSu) {
      localContentValues.put("previewPagMd5", this.field_previewPagMd5);
    }
    if (this.field_animationPagMd5 == null) {
      this.field_animationPagMd5 = "";
    }
    if (this.hSv) {
      localContentValues.put("animationPagMd5", this.field_animationPagMd5);
    }
    if (this.hSw) {
      localContentValues.put("giftType", Integer.valueOf(this.field_giftType));
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.hHP) {
      localContentValues.put("name", this.field_name);
    }
    if (this.hSx) {
      localContentValues.put("price", Float.valueOf(this.field_price));
    }
    if (this.hHO) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.hSy) {
      localContentValues.put("giftIndex", Integer.valueOf(this.field_giftIndex));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "FinderLiveGiftInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.cl
 * JD-Core Version:    0.7.0.1
 */