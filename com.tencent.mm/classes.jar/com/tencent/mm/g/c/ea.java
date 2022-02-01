package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dcd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class ea
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHK;
  private static final int eRA;
  private static final int eRB;
  private static final int eRC;
  private static final int eRD;
  private static final int eRE;
  private static final int eRF = "dynamicPath".hashCode();
  private static final int eRe;
  private static final int eRh;
  private static final int eRl;
  private static final int eRm;
  private static final int eRn;
  private static final int eRy = "uniqueId".hashCode();
  private static final int eRz;
  private static final int elh;
  private static final int eml = "path".hashCode();
  private static final int eoG;
  private static final int erm;
  private static final int ezb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHz = true;
  private boolean eQS = true;
  private boolean eQV = true;
  private boolean eQZ = true;
  private boolean eRa = true;
  private boolean eRb = true;
  private boolean eRq = true;
  private boolean eRr = true;
  private boolean eRs = true;
  private boolean eRt = true;
  private boolean eRu = true;
  private boolean eRv = true;
  private boolean eRw = true;
  private boolean eRx = true;
  private boolean ekK = true;
  private boolean emh = true;
  private boolean eoD = true;
  private boolean eqY = true;
  private boolean eyp = true;
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
  public dcd field_parents;
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
    eHK = "showType".hashCode();
    eoG = "title".hashCode();
    eRz = "icon_url".hashCode();
    eRA = "parents".hashCode();
    eRe = "tipId".hashCode();
    eRB = "priority".hashCode();
    eRh = "tipType".hashCode();
    eRl = "beginShowTime".hashCode();
    elh = "exposureTime".hashCode();
    eRn = "overdueTime".hashCode();
    eRm = "disappearTime".hashCode();
    eRC = "exposureDisappearTime".hashCode();
    eRD = "minClientVersion".hashCode();
    eRE = "maxClientVersion".hashCode();
    erm = "extInfo".hashCode();
    ezb = "state".hashCode();
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
      if (eRy != k) {
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
      if (eml == k) {
        this.field_path = paramCursor.getInt(i);
      } else if (eHK == k) {
        this.field_showType = paramCursor.getInt(i);
      } else if (eoG == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eRz == k) {
        this.field_icon_url = paramCursor.getString(i);
      } else if (eRA == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_parents = ((dcd)new dcd().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
        }
      } else if (eRe == k) {
        this.field_tipId = paramCursor.getInt(i);
      } else if (eRB == k) {
        this.field_priority = paramCursor.getInt(i);
      } else if (eRh == k) {
        this.field_tipType = paramCursor.getInt(i);
      } else if (eRl == k) {
        this.field_beginShowTime = paramCursor.getLong(i);
      } else if (elh == k) {
        this.field_exposureTime = paramCursor.getLong(i);
      } else if (eRn == k) {
        this.field_overdueTime = paramCursor.getLong(i);
      } else if (eRm == k) {
        this.field_disappearTime = paramCursor.getLong(i);
      } else if (eRC == k) {
        this.field_exposureDisappearTime = paramCursor.getLong(i);
      } else if (eRD == k) {
        this.field_minClientVersion = paramCursor.getInt(i);
      } else if (eRE == k) {
        this.field_maxClientVersion = paramCursor.getInt(i);
      } else if (erm == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (ezb == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eRF == k) {
        this.field_dynamicPath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eRq) {
      localContentValues.put("uniqueId", this.field_uniqueId);
    }
    if (this.emh) {
      localContentValues.put("path", Integer.valueOf(this.field_path));
    }
    if (this.eHz) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eRr) {
      localContentValues.put("icon_url", this.field_icon_url);
    }
    if ((this.eRs) && (this.field_parents != null)) {}
    try
    {
      localContentValues.put("parents", this.field_parents.toByteArray());
      if (this.eQS) {
        localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
      }
      if (this.eRt) {
        localContentValues.put("priority", Integer.valueOf(this.field_priority));
      }
      if (this.eQV) {
        localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
      }
      if (this.eQZ) {
        localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
      }
      if (this.ekK) {
        localContentValues.put("exposureTime", Long.valueOf(this.field_exposureTime));
      }
      if (this.eRb) {
        localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
      }
      if (this.eRa) {
        localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
      }
      if (this.eRu) {
        localContentValues.put("exposureDisappearTime", Long.valueOf(this.field_exposureDisappearTime));
      }
      if (this.eRv) {
        localContentValues.put("minClientVersion", Integer.valueOf(this.field_minClientVersion));
      }
      if (this.eRw) {
        localContentValues.put("maxClientVersion", Integer.valueOf(this.field_maxClientVersion));
      }
      if (this.eqY) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.eyp) {
        localContentValues.put("state", Integer.valueOf(this.field_state));
      }
      if (this.eRx) {
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
 * Qualified Name:     com.tencent.mm.g.c.ea
 * JD-Core Version:    0.7.0.1
 */