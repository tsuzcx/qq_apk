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

public abstract class gp
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ProfileInfo");
  public static final Column USERNAME;
  public static final Column kSE;
  public static final Column kSF;
  public static final Column kSG;
  public static final Column kSH;
  public static final Column kSI;
  public static final Column kSJ;
  public static final Column kSK;
  public static final Column kSL;
  public static final Column kSM;
  public static final Column kSN;
  public static final Column kSO;
  public static final Column kSP;
  public static final Column kSQ;
  public static final Column kSR;
  public static final Column kSS;
  private static final int kTi;
  private static final int kTj;
  private static final int kTk;
  private static final int kTl;
  private static final int kTm;
  private static final int kTn;
  private static final int kTo;
  private static final int kTp;
  private static final int kTq;
  private static final int kTr;
  private static final int kTs;
  private static final int kTt;
  private static final int kTu;
  private static final int kTv;
  private static final int kTw;
  private static final int kwX;
  public static final Column kwr;
  private static final StorageObserverOwner<gp> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_allArticleWording;
  public String field_banReason;
  public String field_bizAccountListStr;
  public long field_cacheTime;
  public String field_decryptUserName;
  public int field_friendSubscribeCount;
  public int field_hiddenAvatar;
  public int field_hiddenButtonBeforeFocus;
  public String field_historyArticlesUrl;
  public String field_messageListStr;
  public String field_newBanReason;
  public int field_originalArticleCount;
  public String field_serviceInfoListStr;
  public int field_showRecommendArticle;
  public int field_showService;
  public int field_userRole;
  public String field_username;
  private boolean kST = true;
  private boolean kSU = true;
  private boolean kSV = true;
  private boolean kSW = true;
  private boolean kSX = true;
  private boolean kSY = true;
  private boolean kSZ = true;
  private boolean kTa = true;
  private boolean kTb = true;
  private boolean kTc = true;
  private boolean kTd = true;
  private boolean kTe = true;
  private boolean kTf = true;
  private boolean kTg = true;
  private boolean kTh = true;
  private boolean kwH = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    kSE = new Column("originalArticleCount", "int", TABLE.getName(), "");
    kSF = new Column("friendSubscribeCount", "int", TABLE.getName(), "");
    kSG = new Column("allArticleWording", "string", TABLE.getName(), "");
    kSH = new Column("historyArticlesUrl", "string", TABLE.getName(), "");
    kwr = new Column("userRole", "int", TABLE.getName(), "");
    kSI = new Column("banReason", "string", TABLE.getName(), "");
    kSJ = new Column("showRecommendArticle", "int", TABLE.getName(), "");
    kSK = new Column("showService", "int", TABLE.getName(), "");
    kSL = new Column("messageListStr", "string", TABLE.getName(), "");
    kSM = new Column("serviceInfoListStr", "string", TABLE.getName(), "");
    kSN = new Column("bizAccountListStr", "string", TABLE.getName(), "");
    kSO = new Column("cacheTime", "long", TABLE.getName(), "");
    kSP = new Column("decryptUserName", "string", TABLE.getName(), "");
    kSQ = new Column("hiddenAvatar", "int", TABLE.getName(), "");
    kSR = new Column("hiddenButtonBeforeFocus", "int", TABLE.getName(), "");
    kSS = new Column("newBanReason", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    username_HASHCODE = "username".hashCode();
    kTi = "originalArticleCount".hashCode();
    kTj = "friendSubscribeCount".hashCode();
    kTk = "allArticleWording".hashCode();
    kTl = "historyArticlesUrl".hashCode();
    kwX = "userRole".hashCode();
    kTm = "banReason".hashCode();
    kTn = "showRecommendArticle".hashCode();
    kTo = "showService".hashCode();
    kTp = "messageListStr".hashCode();
    kTq = "serviceInfoListStr".hashCode();
    kTr = "bizAccountListStr".hashCode();
    kTs = "cacheTime".hashCode();
    kTt = "decryptUserName".hashCode();
    kTu = "hiddenAvatar".hashCode();
    kTv = "hiddenButtonBeforeFocus".hashCode();
    kTw = "newBanReason".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[17];
    localMAutoDBInfo.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "originalArticleCount";
    localMAutoDBInfo.colsMap.put("originalArticleCount", "INTEGER default '1' ");
    localStringBuilder.append(" originalArticleCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "friendSubscribeCount";
    localMAutoDBInfo.colsMap.put("friendSubscribeCount", "INTEGER default '1' ");
    localStringBuilder.append(" friendSubscribeCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "allArticleWording";
    localMAutoDBInfo.colsMap.put("allArticleWording", "TEXT");
    localStringBuilder.append(" allArticleWording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "historyArticlesUrl";
    localMAutoDBInfo.colsMap.put("historyArticlesUrl", "TEXT");
    localStringBuilder.append(" historyArticlesUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "userRole";
    localMAutoDBInfo.colsMap.put("userRole", "INTEGER default '1' ");
    localStringBuilder.append(" userRole INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "banReason";
    localMAutoDBInfo.colsMap.put("banReason", "TEXT");
    localStringBuilder.append(" banReason TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "showRecommendArticle";
    localMAutoDBInfo.colsMap.put("showRecommendArticle", "INTEGER default '0' ");
    localStringBuilder.append(" showRecommendArticle INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "showService";
    localMAutoDBInfo.colsMap.put("showService", "INTEGER default '0' ");
    localStringBuilder.append(" showService INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "messageListStr";
    localMAutoDBInfo.colsMap.put("messageListStr", "TEXT");
    localStringBuilder.append(" messageListStr TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "serviceInfoListStr";
    localMAutoDBInfo.colsMap.put("serviceInfoListStr", "TEXT");
    localStringBuilder.append(" serviceInfoListStr TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "bizAccountListStr";
    localMAutoDBInfo.colsMap.put("bizAccountListStr", "TEXT");
    localStringBuilder.append(" bizAccountListStr TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "cacheTime";
    localMAutoDBInfo.colsMap.put("cacheTime", "LONG default '0' ");
    localStringBuilder.append(" cacheTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "decryptUserName";
    localMAutoDBInfo.colsMap.put("decryptUserName", "TEXT default '' ");
    localStringBuilder.append(" decryptUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "hiddenAvatar";
    localMAutoDBInfo.colsMap.put("hiddenAvatar", "INTEGER default '0' ");
    localStringBuilder.append(" hiddenAvatar INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "hiddenButtonBeforeFocus";
    localMAutoDBInfo.colsMap.put("hiddenButtonBeforeFocus", "INTEGER default '0' ");
    localStringBuilder.append(" hiddenButtonBeforeFocus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "newBanReason";
    localMAutoDBInfo.colsMap.put("newBanReason", "TEXT");
    localStringBuilder.append(" newBanReason TEXT");
    localMAutoDBInfo.columns[17] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("originalArticleCount"))
    {
      this.field_originalArticleCount = paramContentValues.getAsInteger("originalArticleCount").intValue();
      if (paramBoolean) {
        this.kST = true;
      }
    }
    if (paramContentValues.containsKey("friendSubscribeCount"))
    {
      this.field_friendSubscribeCount = paramContentValues.getAsInteger("friendSubscribeCount").intValue();
      if (paramBoolean) {
        this.kSU = true;
      }
    }
    if (paramContentValues.containsKey("allArticleWording"))
    {
      this.field_allArticleWording = paramContentValues.getAsString("allArticleWording");
      if (paramBoolean) {
        this.kSV = true;
      }
    }
    if (paramContentValues.containsKey("historyArticlesUrl"))
    {
      this.field_historyArticlesUrl = paramContentValues.getAsString("historyArticlesUrl");
      if (paramBoolean) {
        this.kSW = true;
      }
    }
    if (paramContentValues.containsKey("userRole"))
    {
      this.field_userRole = paramContentValues.getAsInteger("userRole").intValue();
      if (paramBoolean) {
        this.kwH = true;
      }
    }
    if (paramContentValues.containsKey("banReason"))
    {
      this.field_banReason = paramContentValues.getAsString("banReason");
      if (paramBoolean) {
        this.kSX = true;
      }
    }
    if (paramContentValues.containsKey("showRecommendArticle"))
    {
      this.field_showRecommendArticle = paramContentValues.getAsInteger("showRecommendArticle").intValue();
      if (paramBoolean) {
        this.kSY = true;
      }
    }
    if (paramContentValues.containsKey("showService"))
    {
      this.field_showService = paramContentValues.getAsInteger("showService").intValue();
      if (paramBoolean) {
        this.kSZ = true;
      }
    }
    if (paramContentValues.containsKey("messageListStr"))
    {
      this.field_messageListStr = paramContentValues.getAsString("messageListStr");
      if (paramBoolean) {
        this.kTa = true;
      }
    }
    if (paramContentValues.containsKey("serviceInfoListStr"))
    {
      this.field_serviceInfoListStr = paramContentValues.getAsString("serviceInfoListStr");
      if (paramBoolean) {
        this.kTb = true;
      }
    }
    if (paramContentValues.containsKey("bizAccountListStr"))
    {
      this.field_bizAccountListStr = paramContentValues.getAsString("bizAccountListStr");
      if (paramBoolean) {
        this.kTc = true;
      }
    }
    if (paramContentValues.containsKey("cacheTime"))
    {
      this.field_cacheTime = paramContentValues.getAsLong("cacheTime").longValue();
      if (paramBoolean) {
        this.kTd = true;
      }
    }
    if (paramContentValues.containsKey("decryptUserName"))
    {
      this.field_decryptUserName = paramContentValues.getAsString("decryptUserName");
      if (paramBoolean) {
        this.kTe = true;
      }
    }
    if (paramContentValues.containsKey("hiddenAvatar"))
    {
      this.field_hiddenAvatar = paramContentValues.getAsInteger("hiddenAvatar").intValue();
      if (paramBoolean) {
        this.kTf = true;
      }
    }
    if (paramContentValues.containsKey("hiddenButtonBeforeFocus"))
    {
      this.field_hiddenButtonBeforeFocus = paramContentValues.getAsInteger("hiddenButtonBeforeFocus").intValue();
      if (paramBoolean) {
        this.kTg = true;
      }
    }
    if (paramContentValues.containsKey("newBanReason"))
    {
      this.field_newBanReason = paramContentValues.getAsString("newBanReason");
      if (paramBoolean) {
        this.kTh = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
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
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kTi == k) {
        this.field_originalArticleCount = paramCursor.getInt(i);
      } else if (kTj == k) {
        this.field_friendSubscribeCount = paramCursor.getInt(i);
      } else if (kTk == k) {
        this.field_allArticleWording = paramCursor.getString(i);
      } else if (kTl == k) {
        this.field_historyArticlesUrl = paramCursor.getString(i);
      } else if (kwX == k) {
        this.field_userRole = paramCursor.getInt(i);
      } else if (kTm == k) {
        this.field_banReason = paramCursor.getString(i);
      } else if (kTn == k) {
        this.field_showRecommendArticle = paramCursor.getInt(i);
      } else if (kTo == k) {
        this.field_showService = paramCursor.getInt(i);
      } else if (kTp == k) {
        this.field_messageListStr = paramCursor.getString(i);
      } else if (kTq == k) {
        this.field_serviceInfoListStr = paramCursor.getString(i);
      } else if (kTr == k) {
        this.field_bizAccountListStr = paramCursor.getString(i);
      } else if (kTs == k) {
        this.field_cacheTime = paramCursor.getLong(i);
      } else if (kTt == k) {
        this.field_decryptUserName = paramCursor.getString(i);
      } else if (kTu == k) {
        this.field_hiddenAvatar = paramCursor.getInt(i);
      } else if (kTv == k) {
        this.field_hiddenButtonBeforeFocus = paramCursor.getInt(i);
      } else if (kTw == k) {
        this.field_newBanReason = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.kST) {
      localContentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
    }
    if (this.kSU) {
      localContentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
    }
    if (this.kSV) {
      localContentValues.put("allArticleWording", this.field_allArticleWording);
    }
    if (this.kSW) {
      localContentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
    }
    if (this.kwH) {
      localContentValues.put("userRole", Integer.valueOf(this.field_userRole));
    }
    if (this.kSX) {
      localContentValues.put("banReason", this.field_banReason);
    }
    if (this.kSY) {
      localContentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
    }
    if (this.kSZ) {
      localContentValues.put("showService", Integer.valueOf(this.field_showService));
    }
    if (this.kTa) {
      localContentValues.put("messageListStr", this.field_messageListStr);
    }
    if (this.kTb) {
      localContentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
    }
    if (this.kTc) {
      localContentValues.put("bizAccountListStr", this.field_bizAccountListStr);
    }
    if (this.kTd) {
      localContentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
    }
    if (this.field_decryptUserName == null) {
      this.field_decryptUserName = "";
    }
    if (this.kTe) {
      localContentValues.put("decryptUserName", this.field_decryptUserName);
    }
    if (this.kTf) {
      localContentValues.put("hiddenAvatar", Integer.valueOf(this.field_hiddenAvatar));
    }
    if (this.kTg) {
      localContentValues.put("hiddenButtonBeforeFocus", Integer.valueOf(this.field_hiddenButtonBeforeFocus));
    }
    if (this.kTh) {
      localContentValues.put("newBanReason", this.field_newBanReason);
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
  
  public StorageObserverOwner<? extends gp> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_username;
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
 * Qualified Name:     com.tencent.mm.autogen.b.gp
 * JD-Core Version:    0.7.0.1
 */