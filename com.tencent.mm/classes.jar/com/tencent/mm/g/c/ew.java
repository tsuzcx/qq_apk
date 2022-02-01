package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ew
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eWI = "originalArticleCount".hashCode();
  private static final int eWJ = "friendSubscribeCount".hashCode();
  private static final int eWK = "allArticleWording".hashCode();
  private static final int eWL = "historyArticlesUrl".hashCode();
  private static final int eWM = "userRole".hashCode();
  private static final int eWN = "banReason".hashCode();
  private static final int eWO = "showRecommendArticle".hashCode();
  private static final int eWP = "showService".hashCode();
  private static final int eWQ = "messageListStr".hashCode();
  private static final int eWR = "serviceInfoListStr".hashCode();
  private static final int eWS = "bizAccountListStr".hashCode();
  private static final int eWT = "cacheTime".hashCode();
  private static final int eWU = "decryptUserName".hashCode();
  private static final int eWV = "hiddenAvatar".hashCode();
  private static final int eWW = "hiddenButtonBeforeFocus".hashCode();
  private static final int eWX = "newBanReason".hashCode();
  private static final int eok = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eWA = true;
  private boolean eWB = true;
  private boolean eWC = true;
  private boolean eWD = true;
  private boolean eWE = true;
  private boolean eWF = true;
  private boolean eWG = true;
  private boolean eWH = true;
  private boolean eWs = true;
  private boolean eWt = true;
  private boolean eWu = true;
  private boolean eWv = true;
  private boolean eWw = true;
  private boolean eWx = true;
  private boolean eWy = true;
  private boolean eWz = true;
  private boolean eoh = true;
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
      if (eok != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eoh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eWI == k) {
        this.field_originalArticleCount = paramCursor.getInt(i);
      } else if (eWJ == k) {
        this.field_friendSubscribeCount = paramCursor.getInt(i);
      } else if (eWK == k) {
        this.field_allArticleWording = paramCursor.getString(i);
      } else if (eWL == k) {
        this.field_historyArticlesUrl = paramCursor.getString(i);
      } else if (eWM == k) {
        this.field_userRole = paramCursor.getInt(i);
      } else if (eWN == k) {
        this.field_banReason = paramCursor.getString(i);
      } else if (eWO == k) {
        this.field_showRecommendArticle = paramCursor.getInt(i);
      } else if (eWP == k) {
        this.field_showService = paramCursor.getInt(i);
      } else if (eWQ == k) {
        this.field_messageListStr = paramCursor.getString(i);
      } else if (eWR == k) {
        this.field_serviceInfoListStr = paramCursor.getString(i);
      } else if (eWS == k) {
        this.field_bizAccountListStr = paramCursor.getString(i);
      } else if (eWT == k) {
        this.field_cacheTime = paramCursor.getLong(i);
      } else if (eWU == k) {
        this.field_decryptUserName = paramCursor.getString(i);
      } else if (eWV == k) {
        this.field_hiddenAvatar = paramCursor.getInt(i);
      } else if (eWW == k) {
        this.field_hiddenButtonBeforeFocus = paramCursor.getInt(i);
      } else if (eWX == k) {
        this.field_newBanReason = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eWs) {
      localContentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
    }
    if (this.eWt) {
      localContentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
    }
    if (this.eWu) {
      localContentValues.put("allArticleWording", this.field_allArticleWording);
    }
    if (this.eWv) {
      localContentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
    }
    if (this.eWw) {
      localContentValues.put("userRole", Integer.valueOf(this.field_userRole));
    }
    if (this.eWx) {
      localContentValues.put("banReason", this.field_banReason);
    }
    if (this.eWy) {
      localContentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
    }
    if (this.eWz) {
      localContentValues.put("showService", Integer.valueOf(this.field_showService));
    }
    if (this.eWA) {
      localContentValues.put("messageListStr", this.field_messageListStr);
    }
    if (this.eWB) {
      localContentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
    }
    if (this.eWC) {
      localContentValues.put("bizAccountListStr", this.field_bizAccountListStr);
    }
    if (this.eWD) {
      localContentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
    }
    if (this.field_decryptUserName == null) {
      this.field_decryptUserName = "";
    }
    if (this.eWE) {
      localContentValues.put("decryptUserName", this.field_decryptUserName);
    }
    if (this.eWF) {
      localContentValues.put("hiddenAvatar", Integer.valueOf(this.field_hiddenAvatar));
    }
    if (this.eWG) {
      localContentValues.put("hiddenButtonBeforeFocus", Integer.valueOf(this.field_hiddenButtonBeforeFocus));
    }
    if (this.eWH) {
      localContentValues.put("newBanReason", this.field_newBanReason);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ew
 * JD-Core Version:    0.7.0.1
 */