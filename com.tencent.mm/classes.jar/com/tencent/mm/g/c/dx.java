package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dKF = "originalArticleCount".hashCode();
  private static final int dKG = "friendSubscribeCount".hashCode();
  private static final int dKH = "allArticleWording".hashCode();
  private static final int dKI = "historyArticlesUrl".hashCode();
  private static final int dKJ = "userRole".hashCode();
  private static final int dKK = "banReason".hashCode();
  private static final int dKL = "showRecommendArticle".hashCode();
  private static final int dKM = "showService".hashCode();
  private static final int dKN = "messageListStr".hashCode();
  private static final int dKO = "serviceInfoListStr".hashCode();
  private static final int dKP = "bizAccountListStr".hashCode();
  private static final int dKQ = "cacheTime".hashCode();
  private static final int dKR = "decryptUserName".hashCode();
  private static final int dKS = "hiddenAvatar".hashCode();
  private static final int dKT = "hiddenButtonBeforeFocus".hashCode();
  private static final int dKU = "newBanReason".hashCode();
  private static final int dhU = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dKA = true;
  private boolean dKB = true;
  private boolean dKC = true;
  private boolean dKD = true;
  private boolean dKE = true;
  private boolean dKp = true;
  private boolean dKq = true;
  private boolean dKr = true;
  private boolean dKs = true;
  private boolean dKt = true;
  private boolean dKu = true;
  private boolean dKv = true;
  private boolean dKw = true;
  private boolean dKx = true;
  private boolean dKy = true;
  private boolean dKz = true;
  private boolean dhS = true;
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
      if (dhU != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.dhS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dKF == k) {
        this.field_originalArticleCount = paramCursor.getInt(i);
      } else if (dKG == k) {
        this.field_friendSubscribeCount = paramCursor.getInt(i);
      } else if (dKH == k) {
        this.field_allArticleWording = paramCursor.getString(i);
      } else if (dKI == k) {
        this.field_historyArticlesUrl = paramCursor.getString(i);
      } else if (dKJ == k) {
        this.field_userRole = paramCursor.getInt(i);
      } else if (dKK == k) {
        this.field_banReason = paramCursor.getString(i);
      } else if (dKL == k) {
        this.field_showRecommendArticle = paramCursor.getInt(i);
      } else if (dKM == k) {
        this.field_showService = paramCursor.getInt(i);
      } else if (dKN == k) {
        this.field_messageListStr = paramCursor.getString(i);
      } else if (dKO == k) {
        this.field_serviceInfoListStr = paramCursor.getString(i);
      } else if (dKP == k) {
        this.field_bizAccountListStr = paramCursor.getString(i);
      } else if (dKQ == k) {
        this.field_cacheTime = paramCursor.getLong(i);
      } else if (dKR == k) {
        this.field_decryptUserName = paramCursor.getString(i);
      } else if (dKS == k) {
        this.field_hiddenAvatar = paramCursor.getInt(i);
      } else if (dKT == k) {
        this.field_hiddenButtonBeforeFocus = paramCursor.getInt(i);
      } else if (dKU == k) {
        this.field_newBanReason = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dKp) {
      localContentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
    }
    if (this.dKq) {
      localContentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
    }
    if (this.dKr) {
      localContentValues.put("allArticleWording", this.field_allArticleWording);
    }
    if (this.dKs) {
      localContentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
    }
    if (this.dKt) {
      localContentValues.put("userRole", Integer.valueOf(this.field_userRole));
    }
    if (this.dKu) {
      localContentValues.put("banReason", this.field_banReason);
    }
    if (this.dKv) {
      localContentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
    }
    if (this.dKw) {
      localContentValues.put("showService", Integer.valueOf(this.field_showService));
    }
    if (this.dKx) {
      localContentValues.put("messageListStr", this.field_messageListStr);
    }
    if (this.dKy) {
      localContentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
    }
    if (this.dKz) {
      localContentValues.put("bizAccountListStr", this.field_bizAccountListStr);
    }
    if (this.dKA) {
      localContentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
    }
    if (this.field_decryptUserName == null) {
      this.field_decryptUserName = "";
    }
    if (this.dKB) {
      localContentValues.put("decryptUserName", this.field_decryptUserName);
    }
    if (this.dKC) {
      localContentValues.put("hiddenAvatar", Integer.valueOf(this.field_hiddenAvatar));
    }
    if (this.dKD) {
      localContentValues.put("hiddenButtonBeforeFocus", Integer.valueOf(this.field_hiddenButtonBeforeFocus));
    }
    if (this.dKE) {
      localContentValues.put("newBanReason", this.field_newBanReason);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dx
 * JD-Core Version:    0.7.0.1
 */