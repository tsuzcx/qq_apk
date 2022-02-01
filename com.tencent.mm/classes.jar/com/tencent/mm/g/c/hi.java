package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hi
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fJg;
  private static final int fWn;
  private static final int fWo = "invalidtime".hashCode();
  private static final int fqv = "msgSvrId".hashCode();
  private static final int gfA;
  private static final int gfB;
  private static final int gfC;
  private static final int gfD;
  private static final int gfx = "mNativeUrl".hashCode();
  private static final int gfy = "hbType".hashCode();
  private static final int gfz = "receiveAmount".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fIU = true;
  private boolean fWk = true;
  private boolean fWl = true;
  public String field_exclusiveUsername;
  public int field_hbStatus;
  public int field_hbType;
  public int field_invalidtime;
  public String field_mNativeUrl;
  public long field_msgSvrId;
  public long field_receiveAmount;
  public int field_receiveStatus;
  public long field_receiveTime;
  public String field_sendId;
  public String field_sender;
  private boolean fqh = true;
  private boolean gfq = true;
  private boolean gfr = true;
  private boolean gfs = true;
  private boolean gft = true;
  private boolean gfu = true;
  private boolean gfv = true;
  private boolean gfw = true;
  
  static
  {
    fJg = "receiveTime".hashCode();
    fWn = "receiveStatus".hashCode();
    gfA = "hbStatus".hashCode();
    gfB = "sender".hashCode();
    gfC = "exclusiveUsername".hashCode();
    gfD = "sendId".hashCode();
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
      if (gfx != k) {
        break label65;
      }
      this.field_mNativeUrl = paramCursor.getString(i);
      this.gfq = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gfy == k) {
        this.field_hbType = paramCursor.getInt(i);
      } else if (gfz == k) {
        this.field_receiveAmount = paramCursor.getLong(i);
      } else if (fJg == k) {
        this.field_receiveTime = paramCursor.getLong(i);
      } else if (fWn == k) {
        this.field_receiveStatus = paramCursor.getInt(i);
      } else if (gfA == k) {
        this.field_hbStatus = paramCursor.getInt(i);
      } else if (gfB == k) {
        this.field_sender = paramCursor.getString(i);
      } else if (gfC == k) {
        this.field_exclusiveUsername = paramCursor.getString(i);
      } else if (gfD == k) {
        this.field_sendId = paramCursor.getString(i);
      } else if (fWo == k) {
        this.field_invalidtime = paramCursor.getInt(i);
      } else if (fqv == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.gfq) {
      localContentValues.put("mNativeUrl", this.field_mNativeUrl);
    }
    if (this.gfr) {
      localContentValues.put("hbType", Integer.valueOf(this.field_hbType));
    }
    if (this.gfs) {
      localContentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
    }
    if (this.fIU) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.fWk) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.gft) {
      localContentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
    }
    if (this.gfu) {
      localContentValues.put("sender", this.field_sender);
    }
    if (this.gfv) {
      localContentValues.put("exclusiveUsername", this.field_exclusiveUsername);
    }
    if (this.gfw) {
      localContentValues.put("sendId", this.field_sendId);
    }
    if (this.fWl) {
      localContentValues.put("invalidtime", Integer.valueOf(this.field_invalidtime));
    }
    if (this.fqh) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hi
 * JD-Core Version:    0.7.0.1
 */