package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class eo
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEs;
  private static final int eFw;
  private static final int eHT;
  private static final int eKz = "extInfo".hashCode();
  private static final int eST = "state".hashCode();
  private static final int fcW;
  private static final int fmD;
  private static final int fmG;
  private static final int fmK;
  private static final int fmL;
  private static final int fmM;
  private static final int fmX = "uniqueId".hashCode();
  private static final int fmY;
  private static final int fmZ;
  private static final int fna;
  private static final int fnb;
  private static final int fnc;
  private static final int fnd;
  private static final int fne = "dynamicPath".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDV = true;
  private boolean eFs = true;
  private boolean eHQ = true;
  private boolean eKl = true;
  private boolean eSh = true;
  private boolean fcL = true;
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
  public dnf field_parents;
  public int field_path;
  public int field_priority;
  public int field_showType;
  public int field_state;
  public int field_tipId;
  public int field_tipType;
  public String field_title;
  public String field_uniqueId;
  private boolean fmA = true;
  private boolean fmP = true;
  private boolean fmQ = true;
  private boolean fmR = true;
  private boolean fmS = true;
  private boolean fmT = true;
  private boolean fmU = true;
  private boolean fmV = true;
  private boolean fmW = true;
  private boolean fmr = true;
  private boolean fmu = true;
  private boolean fmy = true;
  private boolean fmz = true;
  
  static
  {
    eFw = "path".hashCode();
    fcW = "showType".hashCode();
    eHT = "title".hashCode();
    fmY = "icon_url".hashCode();
    fmZ = "parents".hashCode();
    fmD = "tipId".hashCode();
    fna = "priority".hashCode();
    fmG = "tipType".hashCode();
    fmK = "beginShowTime".hashCode();
    eEs = "exposureTime".hashCode();
    fmM = "overdueTime".hashCode();
    fmL = "disappearTime".hashCode();
    fnb = "exposureDisappearTime".hashCode();
    fnc = "minClientVersion".hashCode();
    fnd = "maxClientVersion".hashCode();
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
      if (fmX != k) {
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
      if (eFw == k) {
        this.field_path = paramCursor.getInt(i);
      } else if (fcW == k) {
        this.field_showType = paramCursor.getInt(i);
      } else if (eHT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (fmY == k) {
        this.field_icon_url = paramCursor.getString(i);
      } else if (fmZ == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_parents = ((dnf)new dnf().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
        }
      } else if (fmD == k) {
        this.field_tipId = paramCursor.getInt(i);
      } else if (fna == k) {
        this.field_priority = paramCursor.getInt(i);
      } else if (fmG == k) {
        this.field_tipType = paramCursor.getInt(i);
      } else if (fmK == k) {
        this.field_beginShowTime = paramCursor.getLong(i);
      } else if (eEs == k) {
        this.field_exposureTime = paramCursor.getLong(i);
      } else if (fmM == k) {
        this.field_overdueTime = paramCursor.getLong(i);
      } else if (fmL == k) {
        this.field_disappearTime = paramCursor.getLong(i);
      } else if (fnb == k) {
        this.field_exposureDisappearTime = paramCursor.getLong(i);
      } else if (fnc == k) {
        this.field_minClientVersion = paramCursor.getInt(i);
      } else if (fnd == k) {
        this.field_maxClientVersion = paramCursor.getInt(i);
      } else if (eKz == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (eST == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fne == k) {
        this.field_dynamicPath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fmP) {
      localContentValues.put("uniqueId", this.field_uniqueId);
    }
    if (this.eFs) {
      localContentValues.put("path", Integer.valueOf(this.field_path));
    }
    if (this.fcL) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fmQ) {
      localContentValues.put("icon_url", this.field_icon_url);
    }
    if ((this.fmR) && (this.field_parents != null)) {}
    try
    {
      localContentValues.put("parents", this.field_parents.toByteArray());
      if (this.fmr) {
        localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
      }
      if (this.fmS) {
        localContentValues.put("priority", Integer.valueOf(this.field_priority));
      }
      if (this.fmu) {
        localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
      }
      if (this.fmy) {
        localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
      }
      if (this.eDV) {
        localContentValues.put("exposureTime", Long.valueOf(this.field_exposureTime));
      }
      if (this.fmA) {
        localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
      }
      if (this.fmz) {
        localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
      }
      if (this.fmT) {
        localContentValues.put("exposureDisappearTime", Long.valueOf(this.field_exposureDisappearTime));
      }
      if (this.fmU) {
        localContentValues.put("minClientVersion", Integer.valueOf(this.field_minClientVersion));
      }
      if (this.fmV) {
        localContentValues.put("maxClientVersion", Integer.valueOf(this.field_maxClientVersion));
      }
      if (this.eKl) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.eSh) {
        localContentValues.put("state", Integer.valueOf(this.field_state));
      }
      if (this.fmW) {
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
        ad.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.eo
 * JD-Core Version:    0.7.0.1
 */