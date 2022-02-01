package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cj
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fEA;
  private static final int fEB;
  private static final int fEC = "giftIndex".hashCode();
  private static final int fEs = "rewardProductId".hashCode();
  private static final int fEt = "businessType".hashCode();
  private static final int fEu = "thumbnailFileUrl".hashCode();
  private static final int fEv = "previewPagUrl".hashCode();
  private static final int fEw = "animationPagUrl".hashCode();
  private static final int fEx = "thumbnailMd5".hashCode();
  private static final int fEy = "previewPagMd5".hashCode();
  private static final int fEz = "animationPagMd5".hashCode();
  private static final int fyj;
  private static final int fyk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fEh = true;
  private boolean fEi = true;
  private boolean fEj = true;
  private boolean fEk = true;
  private boolean fEl = true;
  private boolean fEm = true;
  private boolean fEn = true;
  private boolean fEo = true;
  private boolean fEp = true;
  private boolean fEq = true;
  private boolean fEr = true;
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
  private boolean fxx = true;
  private boolean fxy = true;
  
  static
  {
    fEA = "giftType".hashCode();
    fyk = "name".hashCode();
    fEB = "price".hashCode();
    fyj = "state".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fEs != k) {
        break label65;
      }
      this.field_rewardProductId = paramCursor.getString(i);
      this.fEh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fEt == k) {
        this.field_businessType = paramCursor.getInt(i);
      } else if (fEu == k) {
        this.field_thumbnailFileUrl = paramCursor.getString(i);
      } else if (fEv == k) {
        this.field_previewPagUrl = paramCursor.getString(i);
      } else if (fEw == k) {
        this.field_animationPagUrl = paramCursor.getString(i);
      } else if (fEx == k) {
        this.field_thumbnailMd5 = paramCursor.getString(i);
      } else if (fEy == k) {
        this.field_previewPagMd5 = paramCursor.getString(i);
      } else if (fEz == k) {
        this.field_animationPagMd5 = paramCursor.getString(i);
      } else if (fEA == k) {
        this.field_giftType = paramCursor.getInt(i);
      } else if (fyk == k) {
        this.field_name = paramCursor.getString(i);
      } else if (fEB == k) {
        this.field_price = paramCursor.getFloat(i);
      } else if (fyj == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fEC == k) {
        this.field_giftIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fEh) {
      localContentValues.put("rewardProductId", this.field_rewardProductId);
    }
    if (this.fEi) {
      localContentValues.put("businessType", Integer.valueOf(this.field_businessType));
    }
    if (this.field_thumbnailFileUrl == null) {
      this.field_thumbnailFileUrl = "";
    }
    if (this.fEj) {
      localContentValues.put("thumbnailFileUrl", this.field_thumbnailFileUrl);
    }
    if (this.field_previewPagUrl == null) {
      this.field_previewPagUrl = "";
    }
    if (this.fEk) {
      localContentValues.put("previewPagUrl", this.field_previewPagUrl);
    }
    if (this.field_animationPagUrl == null) {
      this.field_animationPagUrl = "";
    }
    if (this.fEl) {
      localContentValues.put("animationPagUrl", this.field_animationPagUrl);
    }
    if (this.field_thumbnailMd5 == null) {
      this.field_thumbnailMd5 = "";
    }
    if (this.fEm) {
      localContentValues.put("thumbnailMd5", this.field_thumbnailMd5);
    }
    if (this.field_previewPagMd5 == null) {
      this.field_previewPagMd5 = "";
    }
    if (this.fEn) {
      localContentValues.put("previewPagMd5", this.field_previewPagMd5);
    }
    if (this.field_animationPagMd5 == null) {
      this.field_animationPagMd5 = "";
    }
    if (this.fEo) {
      localContentValues.put("animationPagMd5", this.field_animationPagMd5);
    }
    if (this.fEp) {
      localContentValues.put("giftType", Integer.valueOf(this.field_giftType));
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.fxy) {
      localContentValues.put("name", this.field_name);
    }
    if (this.fEq) {
      localContentValues.put("price", Float.valueOf(this.field_price));
    }
    if (this.fxx) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.fEr) {
      localContentValues.put("giftIndex", Integer.valueOf(this.field_giftIndex));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.cj
 * JD-Core Version:    0.7.0.1
 */