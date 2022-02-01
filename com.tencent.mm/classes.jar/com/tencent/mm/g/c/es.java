package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class es
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eTA = "allArticleWording".hashCode();
  private static final int eTB = "historyArticlesUrl".hashCode();
  private static final int eTC = "userRole".hashCode();
  private static final int eTD = "banReason".hashCode();
  private static final int eTE = "showRecommendArticle".hashCode();
  private static final int eTF = "showService".hashCode();
  private static final int eTG = "messageListStr".hashCode();
  private static final int eTH = "serviceInfoListStr".hashCode();
  private static final int eTI = "bizAccountListStr".hashCode();
  private static final int eTJ = "cacheTime".hashCode();
  private static final int eTK = "decryptUserName".hashCode();
  private static final int eTL = "hiddenAvatar".hashCode();
  private static final int eTM = "hiddenButtonBeforeFocus".hashCode();
  private static final int eTN = "newBanReason".hashCode();
  private static final int eTy;
  private static final int eTz;
  private static final int eme = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eTi = true;
  private boolean eTj = true;
  private boolean eTk = true;
  private boolean eTl = true;
  private boolean eTm = true;
  private boolean eTn = true;
  private boolean eTo = true;
  private boolean eTp = true;
  private boolean eTq = true;
  private boolean eTr = true;
  private boolean eTs = true;
  private boolean eTt = true;
  private boolean eTu = true;
  private boolean eTv = true;
  private boolean eTw = true;
  private boolean eTx = true;
  private boolean emb = true;
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
  
  static
  {
    eTy = "originalArticleCount".hashCode();
    eTz = "friendSubscribeCount".hashCode();
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
      if (eme != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.emb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eTy == k) {
        this.field_originalArticleCount = paramCursor.getInt(i);
      } else if (eTz == k) {
        this.field_friendSubscribeCount = paramCursor.getInt(i);
      } else if (eTA == k) {
        this.field_allArticleWording = paramCursor.getString(i);
      } else if (eTB == k) {
        this.field_historyArticlesUrl = paramCursor.getString(i);
      } else if (eTC == k) {
        this.field_userRole = paramCursor.getInt(i);
      } else if (eTD == k) {
        this.field_banReason = paramCursor.getString(i);
      } else if (eTE == k) {
        this.field_showRecommendArticle = paramCursor.getInt(i);
      } else if (eTF == k) {
        this.field_showService = paramCursor.getInt(i);
      } else if (eTG == k) {
        this.field_messageListStr = paramCursor.getString(i);
      } else if (eTH == k) {
        this.field_serviceInfoListStr = paramCursor.getString(i);
      } else if (eTI == k) {
        this.field_bizAccountListStr = paramCursor.getString(i);
      } else if (eTJ == k) {
        this.field_cacheTime = paramCursor.getLong(i);
      } else if (eTK == k) {
        this.field_decryptUserName = paramCursor.getString(i);
      } else if (eTL == k) {
        this.field_hiddenAvatar = paramCursor.getInt(i);
      } else if (eTM == k) {
        this.field_hiddenButtonBeforeFocus = paramCursor.getInt(i);
      } else if (eTN == k) {
        this.field_newBanReason = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eTi) {
      localContentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
    }
    if (this.eTj) {
      localContentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
    }
    if (this.eTk) {
      localContentValues.put("allArticleWording", this.field_allArticleWording);
    }
    if (this.eTl) {
      localContentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
    }
    if (this.eTm) {
      localContentValues.put("userRole", Integer.valueOf(this.field_userRole));
    }
    if (this.eTn) {
      localContentValues.put("banReason", this.field_banReason);
    }
    if (this.eTo) {
      localContentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
    }
    if (this.eTp) {
      localContentValues.put("showService", Integer.valueOf(this.field_showService));
    }
    if (this.eTq) {
      localContentValues.put("messageListStr", this.field_messageListStr);
    }
    if (this.eTr) {
      localContentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
    }
    if (this.eTs) {
      localContentValues.put("bizAccountListStr", this.field_bizAccountListStr);
    }
    if (this.eTt) {
      localContentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
    }
    if (this.field_decryptUserName == null) {
      this.field_decryptUserName = "";
    }
    if (this.eTu) {
      localContentValues.put("decryptUserName", this.field_decryptUserName);
    }
    if (this.eTv) {
      localContentValues.put("hiddenAvatar", Integer.valueOf(this.field_hiddenAvatar));
    }
    if (this.eTw) {
      localContentValues.put("hiddenButtonBeforeFocus", Integer.valueOf(this.field_hiddenButtonBeforeFocus));
    }
    if (this.eTx) {
      localContentValues.put("newBanReason", this.field_newBanReason);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.es
 * JD-Core Version:    0.7.0.1
 */