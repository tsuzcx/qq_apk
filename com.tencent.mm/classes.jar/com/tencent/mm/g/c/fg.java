package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFp = "username".hashCode();
  private static final int foX = "originalArticleCount".hashCode();
  private static final int foY = "friendSubscribeCount".hashCode();
  private static final int foZ = "allArticleWording".hashCode();
  private static final int fpa = "historyArticlesUrl".hashCode();
  private static final int fpb = "userRole".hashCode();
  private static final int fpc = "banReason".hashCode();
  private static final int fpd = "showRecommendArticle".hashCode();
  private static final int fpe = "showService".hashCode();
  private static final int fpf = "messageListStr".hashCode();
  private static final int fpg = "serviceInfoListStr".hashCode();
  private static final int fph = "bizAccountListStr".hashCode();
  private static final int fpi = "cacheTime".hashCode();
  private static final int fpj = "decryptUserName".hashCode();
  private static final int fpk = "hiddenAvatar".hashCode();
  private static final int fpl = "hiddenButtonBeforeFocus".hashCode();
  private static final int fpm = "newBanReason".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFm = true;
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
  private boolean foH = true;
  private boolean foI = true;
  private boolean foJ = true;
  private boolean foK = true;
  private boolean foL = true;
  private boolean foM = true;
  private boolean foN = true;
  private boolean foO = true;
  private boolean foP = true;
  private boolean foQ = true;
  private boolean foR = true;
  private boolean foS = true;
  private boolean foT = true;
  private boolean foU = true;
  private boolean foV = true;
  private boolean foW = true;
  
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
      if (eFp != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eFm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (foX == k) {
        this.field_originalArticleCount = paramCursor.getInt(i);
      } else if (foY == k) {
        this.field_friendSubscribeCount = paramCursor.getInt(i);
      } else if (foZ == k) {
        this.field_allArticleWording = paramCursor.getString(i);
      } else if (fpa == k) {
        this.field_historyArticlesUrl = paramCursor.getString(i);
      } else if (fpb == k) {
        this.field_userRole = paramCursor.getInt(i);
      } else if (fpc == k) {
        this.field_banReason = paramCursor.getString(i);
      } else if (fpd == k) {
        this.field_showRecommendArticle = paramCursor.getInt(i);
      } else if (fpe == k) {
        this.field_showService = paramCursor.getInt(i);
      } else if (fpf == k) {
        this.field_messageListStr = paramCursor.getString(i);
      } else if (fpg == k) {
        this.field_serviceInfoListStr = paramCursor.getString(i);
      } else if (fph == k) {
        this.field_bizAccountListStr = paramCursor.getString(i);
      } else if (fpi == k) {
        this.field_cacheTime = paramCursor.getLong(i);
      } else if (fpj == k) {
        this.field_decryptUserName = paramCursor.getString(i);
      } else if (fpk == k) {
        this.field_hiddenAvatar = paramCursor.getInt(i);
      } else if (fpl == k) {
        this.field_hiddenButtonBeforeFocus = paramCursor.getInt(i);
      } else if (fpm == k) {
        this.field_newBanReason = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.foH) {
      localContentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
    }
    if (this.foI) {
      localContentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
    }
    if (this.foJ) {
      localContentValues.put("allArticleWording", this.field_allArticleWording);
    }
    if (this.foK) {
      localContentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
    }
    if (this.foL) {
      localContentValues.put("userRole", Integer.valueOf(this.field_userRole));
    }
    if (this.foM) {
      localContentValues.put("banReason", this.field_banReason);
    }
    if (this.foN) {
      localContentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
    }
    if (this.foO) {
      localContentValues.put("showService", Integer.valueOf(this.field_showService));
    }
    if (this.foP) {
      localContentValues.put("messageListStr", this.field_messageListStr);
    }
    if (this.foQ) {
      localContentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
    }
    if (this.foR) {
      localContentValues.put("bizAccountListStr", this.field_bizAccountListStr);
    }
    if (this.foS) {
      localContentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
    }
    if (this.field_decryptUserName == null) {
      this.field_decryptUserName = "";
    }
    if (this.foT) {
      localContentValues.put("decryptUserName", this.field_decryptUserName);
    }
    if (this.foU) {
      localContentValues.put("hiddenAvatar", Integer.valueOf(this.field_hiddenAvatar));
    }
    if (this.foV) {
      localContentValues.put("hiddenButtonBeforeFocus", Integer.valueOf(this.field_hiddenButtonBeforeFocus));
    }
    if (this.foW) {
      localContentValues.put("newBanReason", this.field_newBanReason);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fg
 * JD-Core Version:    0.7.0.1
 */