package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ez
  extends c
{
  private static final int cHG;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ddN = "disable".hashCode();
  private static final int ddO;
  private static final int ddP;
  private static final int ddQ;
  private static final int ddR;
  private boolean cHF = true;
  private boolean ddI = true;
  private boolean ddJ = true;
  private boolean ddK = true;
  private boolean ddL = true;
  private boolean ddM = true;
  public long field_configCrc32;
  public String field_configId;
  public String field_configResources;
  public String field_configUrl;
  public boolean field_disable;
  public boolean field_isFromXml;
  
  static
  {
    cHG = "configId".hashCode();
    ddO = "configUrl".hashCode();
    ddP = "configResources".hashCode();
    ddQ = "configCrc32".hashCode();
    ddR = "isFromXml".hashCode();
  }
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    boolean bool;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (ddN != k) {
        break label74;
      }
      if (paramCursor.getInt(i) == 0) {
        break label68;
      }
      bool = true;
      label55:
      this.field_disable = bool;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label68:
      bool = false;
      break label55;
      label74:
      if (cHG == k)
      {
        this.field_configId = paramCursor.getString(i);
        this.cHF = true;
      }
      else if (ddO == k)
      {
        this.field_configUrl = paramCursor.getString(i);
      }
      else if (ddP == k)
      {
        this.field_configResources = paramCursor.getString(i);
      }
      else if (ddQ == k)
      {
        this.field_configCrc32 = paramCursor.getLong(i);
      }
      else
      {
        if (ddR == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isFromXml = bool;
            break;
          }
        }
        if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ddI) {
      localContentValues.put("disable", Boolean.valueOf(this.field_disable));
    }
    if (this.cHF) {
      localContentValues.put("configId", this.field_configId);
    }
    if (this.ddJ) {
      localContentValues.put("configUrl", this.field_configUrl);
    }
    if (this.ddK) {
      localContentValues.put("configResources", this.field_configResources);
    }
    if (this.ddL) {
      localContentValues.put("configCrc32", Long.valueOf(this.field_configCrc32));
    }
    if (this.ddM) {
      localContentValues.put("isFromXml", Boolean.valueOf(this.field_isFromXml));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.ez
 * JD-Core Version:    0.7.0.1
 */