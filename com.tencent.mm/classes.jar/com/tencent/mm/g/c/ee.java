package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dhq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public abstract class ee
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBv = "state".hashCode();
  private static final int eKC;
  private static final int eUI = "uniqueId".hashCode();
  private static final int eUJ;
  private static final int eUK;
  private static final int eUL;
  private static final int eUM;
  private static final int eUN;
  private static final int eUO;
  private static final int eUP = "dynamicPath".hashCode();
  private static final int eUo;
  private static final int eUr;
  private static final int eUv;
  private static final int eUw;
  private static final int eUx;
  private static final int enm;
  private static final int eor = "path".hashCode();
  private static final int eqK;
  private static final int etq;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAJ = true;
  private boolean eKr = true;
  private boolean eUA = true;
  private boolean eUB = true;
  private boolean eUC = true;
  private boolean eUD = true;
  private boolean eUE = true;
  private boolean eUF = true;
  private boolean eUG = true;
  private boolean eUH = true;
  private boolean eUc = true;
  private boolean eUf = true;
  private boolean eUj = true;
  private boolean eUk = true;
  private boolean eUl = true;
  private boolean emO = true;
  private boolean eon = true;
  private boolean eqH = true;
  private boolean etc = true;
  public long field_beginShowTime;
  public long field_disappearTime;
  public String field_dynamicPath;
  public long field_exposureDisappearTime;
  public long field_exposureTime;
  public String field_extInfo;
  public String field_icon_url;
  public int field_maxClientVersion;
  public int field_minClientVersion;
  public long field_overdueTime;
  public dhq field_parents;
  public int field_path;
  public int field_priority;
  public int field_showType;
  public int field_state;
  public int field_tipId;
  public int field_tipType;
  public String field_title;
  public String field_uniqueId;
  
  static
  {
    eKC = "showType".hashCode();
    eqK = "title".hashCode();
    eUJ = "icon_url".hashCode();
    eUK = "parents".hashCode();
    eUo = "tipId".hashCode();
    eUL = "priority".hashCode();
    eUr = "tipType".hashCode();
    eUv = "beginShowTime".hashCode();
    enm = "exposureTime".hashCode();
    eUx = "overdueTime".hashCode();
    eUw = "disappearTime".hashCode();
    eUM = "exposureDisappearTime".hashCode();
    eUN = "minClientVersion".hashCode();
    eUO = "maxClientVersion".hashCode();
    etq = "extInfo".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (eUI != k) {
        break label60;
      }
      this.field_uniqueId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eor == k) {
        this.field_path = paramCursor.getInt(i);
      } else if (eKC == k) {
        this.field_showType = paramCursor.getInt(i);
      } else if (eqK == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eUJ == k) {
        this.field_icon_url = paramCursor.getString(i);
      } else if (eUK == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_parents = ((dhq)new dhq().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ac.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
        }
      } else if (eUo == k) {
        this.field_tipId = paramCursor.getInt(i);
      } else if (eUL == k) {
        this.field_priority = paramCursor.getInt(i);
      } else if (eUr == k) {
        this.field_tipType = paramCursor.getInt(i);
      } else if (eUv == k) {
        this.field_beginShowTime = paramCursor.getLong(i);
      } else if (enm == k) {
        this.field_exposureTime = paramCursor.getLong(i);
      } else if (eUx == k) {
        this.field_overdueTime = paramCursor.getLong(i);
      } else if (eUw == k) {
        this.field_disappearTime = paramCursor.getLong(i);
      } else if (eUM == k) {
        this.field_exposureDisappearTime = paramCursor.getLong(i);
      } else if (eUN == k) {
        this.field_minClientVersion = paramCursor.getInt(i);
      } else if (eUO == k) {
        this.field_maxClientVersion = paramCursor.getInt(i);
      } else if (etq == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (eBv == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eUP == k) {
        this.field_dynamicPath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eUA) {
      localContentValues.put("uniqueId", this.field_uniqueId);
    }
    if (this.eon) {
      localContentValues.put("path", Integer.valueOf(this.field_path));
    }
    if (this.eKr) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.eqH) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eUB) {
      localContentValues.put("icon_url", this.field_icon_url);
    }
    if ((this.eUC) && (this.field_parents != null)) {}
    try
    {
      localContentValues.put("parents", this.field_parents.toByteArray());
      if (this.eUc) {
        localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
      }
      if (this.eUD) {
        localContentValues.put("priority", Integer.valueOf(this.field_priority));
      }
      if (this.eUf) {
        localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
      }
      if (this.eUj) {
        localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
      }
      if (this.emO) {
        localContentValues.put("exposureTime", Long.valueOf(this.field_exposureTime));
      }
      if (this.eUl) {
        localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
      }
      if (this.eUk) {
        localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
      }
      if (this.eUE) {
        localContentValues.put("exposureDisappearTime", Long.valueOf(this.field_exposureDisappearTime));
      }
      if (this.eUF) {
        localContentValues.put("minClientVersion", Integer.valueOf(this.field_minClientVersion));
      }
      if (this.eUG) {
        localContentValues.put("maxClientVersion", Integer.valueOf(this.field_maxClientVersion));
      }
      if (this.etc) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.eAJ) {
        localContentValues.put("state", Integer.valueOf(this.field_state));
      }
      if (this.eUH) {
        localContentValues.put("dynamicPath", this.field_dynamicPath);
      }
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ee
 * JD-Core Version:    0.7.0.1
 */