package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fv
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ProfileInfo");
  private static final int hXL = "userRole".hashCode();
  public static final Column hXf;
  public static final Column irU;
  public static final Column irV;
  public static final Column irW;
  public static final Column irX;
  public static final Column irY;
  public static final Column irZ;
  private static final int isA;
  private static final int isB;
  private static final int isC = "banReason".hashCode();
  private static final int isD = "showRecommendArticle".hashCode();
  private static final int isE = "showService".hashCode();
  private static final int isF = "messageListStr".hashCode();
  private static final int isG = "serviceInfoListStr".hashCode();
  private static final int isH = "bizAccountListStr".hashCode();
  private static final int isI = "cacheTime".hashCode();
  private static final int isJ = "decryptUserName".hashCode();
  private static final int isK = "hiddenAvatar".hashCode();
  private static final int isL = "hiddenButtonBeforeFocus".hashCode();
  private static final int isM = "newBanReason".hashCode();
  public static final Column isa;
  public static final Column isb;
  public static final Column isc;
  public static final Column isd;
  public static final Column ise;
  public static final Column isf;
  public static final Column isg;
  public static final Column ish;
  public static final Column isi;
  private static final int isy;
  private static final int isz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hXv = true;
  private boolean isj = true;
  private boolean isk = true;
  private boolean isl = true;
  private boolean ism = true;
  private boolean isn = true;
  private boolean iso = true;
  private boolean isp = true;
  private boolean isq = true;
  private boolean isr = true;
  private boolean iss = true;
  private boolean ist = true;
  private boolean isu = true;
  private boolean isv = true;
  private boolean isw = true;
  private boolean isx = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ProfileInfo", "");
    C_USERNAME = new Column("username", "string", "ProfileInfo", "");
    irU = new Column("originalarticlecount", "int", "ProfileInfo", "");
    irV = new Column("friendsubscribecount", "int", "ProfileInfo", "");
    irW = new Column("allarticlewording", "string", "ProfileInfo", "");
    irX = new Column("historyarticlesurl", "string", "ProfileInfo", "");
    hXf = new Column("userrole", "int", "ProfileInfo", "");
    irY = new Column("banreason", "string", "ProfileInfo", "");
    irZ = new Column("showrecommendarticle", "int", "ProfileInfo", "");
    isa = new Column("showservice", "int", "ProfileInfo", "");
    isb = new Column("messageliststr", "string", "ProfileInfo", "");
    isc = new Column("serviceinfoliststr", "string", "ProfileInfo", "");
    isd = new Column("bizaccountliststr", "string", "ProfileInfo", "");
    ise = new Column("cachetime", "long", "ProfileInfo", "");
    isf = new Column("decryptusername", "string", "ProfileInfo", "");
    isg = new Column("hiddenavatar", "int", "ProfileInfo", "");
    ish = new Column("hiddenbuttonbeforefocus", "int", "ProfileInfo", "");
    isi = new Column("newbanreason", "string", "ProfileInfo", "");
    username_HASHCODE = "username".hashCode();
    isy = "originalArticleCount".hashCode();
    isz = "friendSubscribeCount".hashCode();
    isA = "allArticleWording".hashCode();
    isB = "historyArticlesUrl".hashCode();
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
      if (isy == k) {
        this.field_originalArticleCount = paramCursor.getInt(i);
      } else if (isz == k) {
        this.field_friendSubscribeCount = paramCursor.getInt(i);
      } else if (isA == k) {
        this.field_allArticleWording = paramCursor.getString(i);
      } else if (isB == k) {
        this.field_historyArticlesUrl = paramCursor.getString(i);
      } else if (hXL == k) {
        this.field_userRole = paramCursor.getInt(i);
      } else if (isC == k) {
        this.field_banReason = paramCursor.getString(i);
      } else if (isD == k) {
        this.field_showRecommendArticle = paramCursor.getInt(i);
      } else if (isE == k) {
        this.field_showService = paramCursor.getInt(i);
      } else if (isF == k) {
        this.field_messageListStr = paramCursor.getString(i);
      } else if (isG == k) {
        this.field_serviceInfoListStr = paramCursor.getString(i);
      } else if (isH == k) {
        this.field_bizAccountListStr = paramCursor.getString(i);
      } else if (isI == k) {
        this.field_cacheTime = paramCursor.getLong(i);
      } else if (isJ == k) {
        this.field_decryptUserName = paramCursor.getString(i);
      } else if (isK == k) {
        this.field_hiddenAvatar = paramCursor.getInt(i);
      } else if (isL == k) {
        this.field_hiddenButtonBeforeFocus = paramCursor.getInt(i);
      } else if (isM == k) {
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
    if (this.isj) {
      localContentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
    }
    if (this.isk) {
      localContentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
    }
    if (this.isl) {
      localContentValues.put("allArticleWording", this.field_allArticleWording);
    }
    if (this.ism) {
      localContentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
    }
    if (this.hXv) {
      localContentValues.put("userRole", Integer.valueOf(this.field_userRole));
    }
    if (this.isn) {
      localContentValues.put("banReason", this.field_banReason);
    }
    if (this.iso) {
      localContentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
    }
    if (this.isp) {
      localContentValues.put("showService", Integer.valueOf(this.field_showService));
    }
    if (this.isq) {
      localContentValues.put("messageListStr", this.field_messageListStr);
    }
    if (this.isr) {
      localContentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
    }
    if (this.iss) {
      localContentValues.put("bizAccountListStr", this.field_bizAccountListStr);
    }
    if (this.ist) {
      localContentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
    }
    if (this.field_decryptUserName == null) {
      this.field_decryptUserName = "";
    }
    if (this.isu) {
      localContentValues.put("decryptUserName", this.field_decryptUserName);
    }
    if (this.isv) {
      localContentValues.put("hiddenAvatar", Integer.valueOf(this.field_hiddenAvatar));
    }
    if (this.isw) {
      localContentValues.put("hiddenButtonBeforeFocus", Integer.valueOf(this.field_hiddenButtonBeforeFocus));
    }
    if (this.isx) {
      localContentValues.put("newBanReason", this.field_newBanReason);
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
    return "ProfileInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.fv
 * JD-Core Version:    0.7.0.1
 */