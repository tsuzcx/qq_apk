package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ev
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int exposureTime_HASHCODE;
  private static final int fJh;
  private static final int fTD = "uniqueId".hashCode();
  private static final int fTE;
  private static final int fTF;
  private static final int fTG;
  private static final int fTH;
  private static final int fTI;
  private static final int fTJ;
  private static final int fTK = "dynamicPath".hashCode();
  private static final int fTj;
  private static final int fTm;
  private static final int fTq;
  private static final int fTr;
  private static final int fTs;
  private static final int fkH = "path".hashCode();
  private static final int fne;
  private static final int fpP;
  private static final int fyj;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetexposureTime = true;
  private boolean fIV = true;
  private boolean fSX = true;
  private boolean fTA = true;
  private boolean fTB = true;
  private boolean fTC = true;
  private boolean fTa = true;
  private boolean fTe = true;
  private boolean fTf = true;
  private boolean fTg = true;
  private boolean fTv = true;
  private boolean fTw = true;
  private boolean fTx = true;
  private boolean fTy = true;
  private boolean fTz = true;
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
  public ehy field_parents;
  public int field_path;
  public int field_priority;
  public int field_showType;
  public int field_state;
  public int field_tipId;
  public int field_tipType;
  public String field_title;
  public String field_uniqueId;
  private boolean fkD = true;
  private boolean fnb = true;
  private boolean fpB = true;
  private boolean fxx = true;
  
  static
  {
    fJh = "showType".hashCode();
    fne = "title".hashCode();
    fTE = "icon_url".hashCode();
    fTF = "parents".hashCode();
    fTj = "tipId".hashCode();
    fTG = "priority".hashCode();
    fTm = "tipType".hashCode();
    fTq = "beginShowTime".hashCode();
    exposureTime_HASHCODE = "exposureTime".hashCode();
    fTs = "overdueTime".hashCode();
    fTr = "disappearTime".hashCode();
    fTH = "exposureDisappearTime".hashCode();
    fTI = "minClientVersion".hashCode();
    fTJ = "maxClientVersion".hashCode();
    fpP = "extInfo".hashCode();
    fyj = "state".hashCode();
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
      if (fTD != k) {
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
      if (fkH == k) {
        this.field_path = paramCursor.getInt(i);
      } else if (fJh == k) {
        this.field_showType = paramCursor.getInt(i);
      } else if (fne == k) {
        this.field_title = paramCursor.getString(i);
      } else if (fTE == k) {
        this.field_icon_url = paramCursor.getString(i);
      } else if (fTF == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_parents = ((ehy)new ehy().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
        }
      } else if (fTj == k) {
        this.field_tipId = paramCursor.getInt(i);
      } else if (fTG == k) {
        this.field_priority = paramCursor.getInt(i);
      } else if (fTm == k) {
        this.field_tipType = paramCursor.getInt(i);
      } else if (fTq == k) {
        this.field_beginShowTime = paramCursor.getLong(i);
      } else if (exposureTime_HASHCODE == k) {
        this.field_exposureTime = paramCursor.getLong(i);
      } else if (fTs == k) {
        this.field_overdueTime = paramCursor.getLong(i);
      } else if (fTr == k) {
        this.field_disappearTime = paramCursor.getLong(i);
      } else if (fTH == k) {
        this.field_exposureDisappearTime = paramCursor.getLong(i);
      } else if (fTI == k) {
        this.field_minClientVersion = paramCursor.getInt(i);
      } else if (fTJ == k) {
        this.field_maxClientVersion = paramCursor.getInt(i);
      } else if (fpP == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (fyj == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fTK == k) {
        this.field_dynamicPath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fTv) {
      localContentValues.put("uniqueId", this.field_uniqueId);
    }
    if (this.fkD) {
      localContentValues.put("path", Integer.valueOf(this.field_path));
    }
    if (this.fIV) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fTw) {
      localContentValues.put("icon_url", this.field_icon_url);
    }
    if ((this.fTx) && (this.field_parents != null)) {}
    try
    {
      localContentValues.put("parents", this.field_parents.toByteArray());
      if (this.fSX) {
        localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
      }
      if (this.fTy) {
        localContentValues.put("priority", Integer.valueOf(this.field_priority));
      }
      if (this.fTa) {
        localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
      }
      if (this.fTe) {
        localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
      }
      if (this.__hadSetexposureTime) {
        localContentValues.put("exposureTime", Long.valueOf(this.field_exposureTime));
      }
      if (this.fTg) {
        localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
      }
      if (this.fTf) {
        localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
      }
      if (this.fTz) {
        localContentValues.put("exposureDisappearTime", Long.valueOf(this.field_exposureDisappearTime));
      }
      if (this.fTA) {
        localContentValues.put("minClientVersion", Integer.valueOf(this.field_minClientVersion));
      }
      if (this.fTB) {
        localContentValues.put("maxClientVersion", Integer.valueOf(this.field_maxClientVersion));
      }
      if (this.fpB) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.fxx) {
        localContentValues.put("state", Integer.valueOf(this.field_state));
      }
      if (this.fTC) {
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
        Log.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ev
 * JD-Core Version:    0.7.0.1
 */