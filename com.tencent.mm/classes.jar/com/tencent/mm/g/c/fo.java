package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fo
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fVD = "originalArticleCount".hashCode();
  private static final int fVE = "friendSubscribeCount".hashCode();
  private static final int fVF = "allArticleWording".hashCode();
  private static final int fVG = "historyArticlesUrl".hashCode();
  private static final int fVH = "userRole".hashCode();
  private static final int fVI = "banReason".hashCode();
  private static final int fVJ = "showRecommendArticle".hashCode();
  private static final int fVK = "showService".hashCode();
  private static final int fVL = "messageListStr".hashCode();
  private static final int fVM = "serviceInfoListStr".hashCode();
  private static final int fVN = "bizAccountListStr".hashCode();
  private static final int fVO = "cacheTime".hashCode();
  private static final int fVP = "decryptUserName".hashCode();
  private static final int fVQ = "hiddenAvatar".hashCode();
  private static final int fVR = "hiddenButtonBeforeFocus".hashCode();
  private static final int fVS = "newBanReason".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  private boolean fVA = true;
  private boolean fVB = true;
  private boolean fVC = true;
  private boolean fVn = true;
  private boolean fVo = true;
  private boolean fVp = true;
  private boolean fVq = true;
  private boolean fVr = true;
  private boolean fVs = true;
  private boolean fVt = true;
  private boolean fVu = true;
  private boolean fVv = true;
  private boolean fVw = true;
  private boolean fVx = true;
  private boolean fVy = true;
  private boolean fVz = true;
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
      if (fVD == k) {
        this.field_originalArticleCount = paramCursor.getInt(i);
      } else if (fVE == k) {
        this.field_friendSubscribeCount = paramCursor.getInt(i);
      } else if (fVF == k) {
        this.field_allArticleWording = paramCursor.getString(i);
      } else if (fVG == k) {
        this.field_historyArticlesUrl = paramCursor.getString(i);
      } else if (fVH == k) {
        this.field_userRole = paramCursor.getInt(i);
      } else if (fVI == k) {
        this.field_banReason = paramCursor.getString(i);
      } else if (fVJ == k) {
        this.field_showRecommendArticle = paramCursor.getInt(i);
      } else if (fVK == k) {
        this.field_showService = paramCursor.getInt(i);
      } else if (fVL == k) {
        this.field_messageListStr = paramCursor.getString(i);
      } else if (fVM == k) {
        this.field_serviceInfoListStr = paramCursor.getString(i);
      } else if (fVN == k) {
        this.field_bizAccountListStr = paramCursor.getString(i);
      } else if (fVO == k) {
        this.field_cacheTime = paramCursor.getLong(i);
      } else if (fVP == k) {
        this.field_decryptUserName = paramCursor.getString(i);
      } else if (fVQ == k) {
        this.field_hiddenAvatar = paramCursor.getInt(i);
      } else if (fVR == k) {
        this.field_hiddenButtonBeforeFocus = paramCursor.getInt(i);
      } else if (fVS == k) {
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
    if (this.fVn) {
      localContentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
    }
    if (this.fVo) {
      localContentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
    }
    if (this.fVp) {
      localContentValues.put("allArticleWording", this.field_allArticleWording);
    }
    if (this.fVq) {
      localContentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
    }
    if (this.fVr) {
      localContentValues.put("userRole", Integer.valueOf(this.field_userRole));
    }
    if (this.fVs) {
      localContentValues.put("banReason", this.field_banReason);
    }
    if (this.fVt) {
      localContentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
    }
    if (this.fVu) {
      localContentValues.put("showService", Integer.valueOf(this.field_showService));
    }
    if (this.fVv) {
      localContentValues.put("messageListStr", this.field_messageListStr);
    }
    if (this.fVw) {
      localContentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
    }
    if (this.fVx) {
      localContentValues.put("bizAccountListStr", this.field_bizAccountListStr);
    }
    if (this.fVy) {
      localContentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
    }
    if (this.field_decryptUserName == null) {
      this.field_decryptUserName = "";
    }
    if (this.fVz) {
      localContentValues.put("decryptUserName", this.field_decryptUserName);
    }
    if (this.fVA) {
      localContentValues.put("hiddenAvatar", Integer.valueOf(this.field_hiddenAvatar));
    }
    if (this.fVB) {
      localContentValues.put("hiddenButtonBeforeFocus", Integer.valueOf(this.field_hiddenButtonBeforeFocus));
    }
    if (this.fVC) {
      localContentValues.put("newBanReason", this.field_newBanReason);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.fo
 * JD-Core Version:    0.7.0.1
 */