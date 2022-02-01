package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class eo
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGb;
  private static final int eHf;
  private static final int eJC;
  private static final int eMi = "extInfo".hashCode();
  private static final int eUE = "state".hashCode();
  private static final int feO;
  private static final int foD;
  private static final int foG;
  private static final int foK;
  private static final int foL;
  private static final int foM;
  private static final int foX = "uniqueId".hashCode();
  private static final int foY;
  private static final int foZ;
  private static final int fpa;
  private static final int fpb;
  private static final int fpc;
  private static final int fpd;
  private static final int fpe = "dynamicPath".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFE = true;
  private boolean eHb = true;
  private boolean eJz = true;
  private boolean eLU = true;
  private boolean eTS = true;
  private boolean feC = true;
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
  public doc field_parents;
  public int field_path;
  public int field_priority;
  public int field_showType;
  public int field_state;
  public int field_tipId;
  public int field_tipType;
  public String field_title;
  public String field_uniqueId;
  private boolean foA = true;
  private boolean foP = true;
  private boolean foQ = true;
  private boolean foR = true;
  private boolean foS = true;
  private boolean foT = true;
  private boolean foU = true;
  private boolean foV = true;
  private boolean foW = true;
  private boolean jdField_for = true;
  private boolean fou = true;
  private boolean foy = true;
  private boolean foz = true;
  
  static
  {
    eHf = "path".hashCode();
    feO = "showType".hashCode();
    eJC = "title".hashCode();
    foY = "icon_url".hashCode();
    foZ = "parents".hashCode();
    foD = "tipId".hashCode();
    fpa = "priority".hashCode();
    foG = "tipType".hashCode();
    foK = "beginShowTime".hashCode();
    eGb = "exposureTime".hashCode();
    foM = "overdueTime".hashCode();
    foL = "disappearTime".hashCode();
    fpb = "exposureDisappearTime".hashCode();
    fpc = "minClientVersion".hashCode();
    fpd = "maxClientVersion".hashCode();
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
      if (foX != k) {
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
      if (eHf == k) {
        this.field_path = paramCursor.getInt(i);
      } else if (feO == k) {
        this.field_showType = paramCursor.getInt(i);
      } else if (eJC == k) {
        this.field_title = paramCursor.getString(i);
      } else if (foY == k) {
        this.field_icon_url = paramCursor.getString(i);
      } else if (foZ == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_parents = ((doc)new doc().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
        }
      } else if (foD == k) {
        this.field_tipId = paramCursor.getInt(i);
      } else if (fpa == k) {
        this.field_priority = paramCursor.getInt(i);
      } else if (foG == k) {
        this.field_tipType = paramCursor.getInt(i);
      } else if (foK == k) {
        this.field_beginShowTime = paramCursor.getLong(i);
      } else if (eGb == k) {
        this.field_exposureTime = paramCursor.getLong(i);
      } else if (foM == k) {
        this.field_overdueTime = paramCursor.getLong(i);
      } else if (foL == k) {
        this.field_disappearTime = paramCursor.getLong(i);
      } else if (fpb == k) {
        this.field_exposureDisappearTime = paramCursor.getLong(i);
      } else if (fpc == k) {
        this.field_minClientVersion = paramCursor.getInt(i);
      } else if (fpd == k) {
        this.field_maxClientVersion = paramCursor.getInt(i);
      } else if (eMi == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (eUE == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fpe == k) {
        this.field_dynamicPath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.foP) {
      localContentValues.put("uniqueId", this.field_uniqueId);
    }
    if (this.eHb) {
      localContentValues.put("path", Integer.valueOf(this.field_path));
    }
    if (this.feC) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.foQ) {
      localContentValues.put("icon_url", this.field_icon_url);
    }
    if ((this.foR) && (this.field_parents != null)) {}
    try
    {
      localContentValues.put("parents", this.field_parents.toByteArray());
      if (this.jdField_for) {
        localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
      }
      if (this.foS) {
        localContentValues.put("priority", Integer.valueOf(this.field_priority));
      }
      if (this.fou) {
        localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
      }
      if (this.foy) {
        localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
      }
      if (this.eFE) {
        localContentValues.put("exposureTime", Long.valueOf(this.field_exposureTime));
      }
      if (this.foA) {
        localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
      }
      if (this.foz) {
        localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
      }
      if (this.foT) {
        localContentValues.put("exposureDisappearTime", Long.valueOf(this.field_exposureDisappearTime));
      }
      if (this.foU) {
        localContentValues.put("minClientVersion", Integer.valueOf(this.field_minClientVersion));
      }
      if (this.foV) {
        localContentValues.put("maxClientVersion", Integer.valueOf(this.field_maxClientVersion));
      }
      if (this.eLU) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.eTS) {
        localContentValues.put("state", Integer.valueOf(this.field_state));
      }
      if (this.foW) {
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
        ae.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.eo
 * JD-Core Version:    0.7.0.1
 */