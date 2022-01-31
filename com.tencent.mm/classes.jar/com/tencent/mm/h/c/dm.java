package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dm
  extends c
{
  private static final int cUA = "userRole".hashCode();
  private static final int cUB = "banReason".hashCode();
  private static final int cUC = "showRecommendArticle".hashCode();
  private static final int cUD = "showService".hashCode();
  private static final int cUE = "messageListStr".hashCode();
  private static final int cUF = "serviceInfoListStr".hashCode();
  private static final int cUG = "bizAccountListStr".hashCode();
  private static final int cUH = "cacheTime".hashCode();
  private static final int cUI = "decryptUserName".hashCode();
  private static final int cUw;
  private static final int cUx;
  private static final int cUy;
  private static final int cUz;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctF = "username".hashCode();
  private boolean cUj = true;
  private boolean cUk = true;
  private boolean cUl = true;
  private boolean cUm = true;
  private boolean cUn = true;
  private boolean cUo = true;
  private boolean cUp = true;
  private boolean cUq = true;
  private boolean cUr = true;
  private boolean cUs = true;
  private boolean cUt = true;
  private boolean cUu = true;
  private boolean cUv = true;
  private boolean ctD = true;
  public String field_allArticleWording;
  public String field_banReason;
  public String field_bizAccountListStr;
  public long field_cacheTime;
  public String field_decryptUserName;
  public int field_friendSubscribeCount;
  public String field_historyArticlesUrl;
  public String field_messageListStr;
  public int field_originalArticleCount;
  public String field_serviceInfoListStr;
  public int field_showRecommendArticle;
  public int field_showService;
  public int field_userRole;
  public String field_username;
  
  static
  {
    cUw = "originalArticleCount".hashCode();
    cUx = "friendSubscribeCount".hashCode();
    cUy = "allArticleWording".hashCode();
    cUz = "historyArticlesUrl".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (ctF != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.ctD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cUw == k) {
        this.field_originalArticleCount = paramCursor.getInt(i);
      } else if (cUx == k) {
        this.field_friendSubscribeCount = paramCursor.getInt(i);
      } else if (cUy == k) {
        this.field_allArticleWording = paramCursor.getString(i);
      } else if (cUz == k) {
        this.field_historyArticlesUrl = paramCursor.getString(i);
      } else if (cUA == k) {
        this.field_userRole = paramCursor.getInt(i);
      } else if (cUB == k) {
        this.field_banReason = paramCursor.getString(i);
      } else if (cUC == k) {
        this.field_showRecommendArticle = paramCursor.getInt(i);
      } else if (cUD == k) {
        this.field_showService = paramCursor.getInt(i);
      } else if (cUE == k) {
        this.field_messageListStr = paramCursor.getString(i);
      } else if (cUF == k) {
        this.field_serviceInfoListStr = paramCursor.getString(i);
      } else if (cUG == k) {
        this.field_bizAccountListStr = paramCursor.getString(i);
      } else if (cUH == k) {
        this.field_cacheTime = paramCursor.getLong(i);
      } else if (cUI == k) {
        this.field_decryptUserName = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cUj) {
      localContentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
    }
    if (this.cUk) {
      localContentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
    }
    if (this.cUl) {
      localContentValues.put("allArticleWording", this.field_allArticleWording);
    }
    if (this.cUm) {
      localContentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
    }
    if (this.cUn) {
      localContentValues.put("userRole", Integer.valueOf(this.field_userRole));
    }
    if (this.cUo) {
      localContentValues.put("banReason", this.field_banReason);
    }
    if (this.cUp) {
      localContentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
    }
    if (this.cUq) {
      localContentValues.put("showService", Integer.valueOf(this.field_showService));
    }
    if (this.cUr) {
      localContentValues.put("messageListStr", this.field_messageListStr);
    }
    if (this.cUs) {
      localContentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
    }
    if (this.cUt) {
      localContentValues.put("bizAccountListStr", this.field_bizAccountListStr);
    }
    if (this.cUu) {
      localContentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
    }
    if (this.field_decryptUserName == null) {
      this.field_decryptUserName = "";
    }
    if (this.cUv) {
      localContentValues.put("decryptUserName", this.field_decryptUserName);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.dm
 * JD-Core Version:    0.7.0.1
 */