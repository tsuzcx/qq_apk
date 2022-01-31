package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fl
  extends c
{
  private static final int cTw;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csD;
  private static final int dfU = "shareKeyHash".hashCode();
  private static final int dfV = "btnState".hashCode();
  private static final int dfW;
  private static final int dfX;
  private boolean cTt = true;
  private boolean csf = true;
  private boolean dfQ = true;
  private boolean dfR = true;
  private boolean dfS = true;
  private boolean dfT = true;
  public int field_btnState;
  public String field_content;
  public String field_contentColor;
  public int field_msgState;
  public int field_shareKeyHash;
  public int field_updatePeroid;
  
  static
  {
    cTw = "msgState".hashCode();
    csD = "content".hashCode();
    dfW = "contentColor".hashCode();
    dfX = "updatePeroid".hashCode();
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
      if (dfU != k) {
        break label65;
      }
      this.field_shareKeyHash = paramCursor.getInt(i);
      this.dfQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dfV == k) {
        this.field_btnState = paramCursor.getInt(i);
      } else if (cTw == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (csD == k) {
        this.field_content = paramCursor.getString(i);
      } else if (dfW == k) {
        this.field_contentColor = paramCursor.getString(i);
      } else if (dfX == k) {
        this.field_updatePeroid = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dfQ) {
      localContentValues.put("shareKeyHash", Integer.valueOf(this.field_shareKeyHash));
    }
    if (this.dfR) {
      localContentValues.put("btnState", Integer.valueOf(this.field_btnState));
    }
    if (this.cTt) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.dfS) {
      localContentValues.put("contentColor", this.field_contentColor);
    }
    if (this.dfT) {
      localContentValues.put("updatePeroid", Integer.valueOf(this.field_updatePeroid));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.fl
 * JD-Core Version:    0.7.0.1
 */