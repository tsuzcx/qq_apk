package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY = "username".hashCode();
  private static final int fqY = "originalArticleCount".hashCode();
  private static final int fqZ = "friendSubscribeCount".hashCode();
  private static final int fra = "allArticleWording".hashCode();
  private static final int frb = "historyArticlesUrl".hashCode();
  private static final int frc = "userRole".hashCode();
  private static final int frd = "banReason".hashCode();
  private static final int fre = "showRecommendArticle".hashCode();
  private static final int frf = "showService".hashCode();
  private static final int frg = "messageListStr".hashCode();
  private static final int frh = "serviceInfoListStr".hashCode();
  private static final int fri = "bizAccountListStr".hashCode();
  private static final int frj = "cacheTime".hashCode();
  private static final int frk = "decryptUserName".hashCode();
  private static final int frl = "hiddenAvatar".hashCode();
  private static final int frm = "hiddenButtonBeforeFocus".hashCode();
  private static final int frn = "newBanReason".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
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
  private boolean fqI = true;
  private boolean fqJ = true;
  private boolean fqK = true;
  private boolean fqL = true;
  private boolean fqM = true;
  private boolean fqN = true;
  private boolean fqO = true;
  private boolean fqP = true;
  private boolean fqQ = true;
  private boolean fqR = true;
  private boolean fqS = true;
  private boolean fqT = true;
  private boolean fqU = true;
  private boolean fqV = true;
  private boolean fqW = true;
  private boolean fqX = true;
  
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
      if (eGY != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eGV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fqY == k) {
        this.field_originalArticleCount = paramCursor.getInt(i);
      } else if (fqZ == k) {
        this.field_friendSubscribeCount = paramCursor.getInt(i);
      } else if (fra == k) {
        this.field_allArticleWording = paramCursor.getString(i);
      } else if (frb == k) {
        this.field_historyArticlesUrl = paramCursor.getString(i);
      } else if (frc == k) {
        this.field_userRole = paramCursor.getInt(i);
      } else if (frd == k) {
        this.field_banReason = paramCursor.getString(i);
      } else if (fre == k) {
        this.field_showRecommendArticle = paramCursor.getInt(i);
      } else if (frf == k) {
        this.field_showService = paramCursor.getInt(i);
      } else if (frg == k) {
        this.field_messageListStr = paramCursor.getString(i);
      } else if (frh == k) {
        this.field_serviceInfoListStr = paramCursor.getString(i);
      } else if (fri == k) {
        this.field_bizAccountListStr = paramCursor.getString(i);
      } else if (frj == k) {
        this.field_cacheTime = paramCursor.getLong(i);
      } else if (frk == k) {
        this.field_decryptUserName = paramCursor.getString(i);
      } else if (frl == k) {
        this.field_hiddenAvatar = paramCursor.getInt(i);
      } else if (frm == k) {
        this.field_hiddenButtonBeforeFocus = paramCursor.getInt(i);
      } else if (frn == k) {
        this.field_newBanReason = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fqI) {
      localContentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
    }
    if (this.fqJ) {
      localContentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
    }
    if (this.fqK) {
      localContentValues.put("allArticleWording", this.field_allArticleWording);
    }
    if (this.fqL) {
      localContentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
    }
    if (this.fqM) {
      localContentValues.put("userRole", Integer.valueOf(this.field_userRole));
    }
    if (this.fqN) {
      localContentValues.put("banReason", this.field_banReason);
    }
    if (this.fqO) {
      localContentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
    }
    if (this.fqP) {
      localContentValues.put("showService", Integer.valueOf(this.field_showService));
    }
    if (this.fqQ) {
      localContentValues.put("messageListStr", this.field_messageListStr);
    }
    if (this.fqR) {
      localContentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
    }
    if (this.fqS) {
      localContentValues.put("bizAccountListStr", this.field_bizAccountListStr);
    }
    if (this.fqT) {
      localContentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
    }
    if (this.field_decryptUserName == null) {
      this.field_decryptUserName = "";
    }
    if (this.fqU) {
      localContentValues.put("decryptUserName", this.field_decryptUserName);
    }
    if (this.fqV) {
      localContentValues.put("hiddenAvatar", Integer.valueOf(this.field_hiddenAvatar));
    }
    if (this.fqW) {
      localContentValues.put("hiddenButtonBeforeFocus", Integer.valueOf(this.field_hiddenButtonBeforeFocus));
    }
    if (this.fqX) {
      localContentValues.put("newBanReason", this.field_newBanReason);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fg
 * JD-Core Version:    0.7.0.1
 */