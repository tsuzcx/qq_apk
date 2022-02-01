package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.esa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class fa
  extends IAutoDBItem
{
  public static final Column C_EXPOSURETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("NewTipsInfo2");
  private static final int exposureTime_HASHCODE;
  public static final Column hHa;
  private static final int hIC = "state".hashCode();
  private static final int hZJ;
  public static final Column hZl;
  public static final Column hoC;
  private static final int hoK;
  public static final Column hsa;
  private static final int hsg;
  public static final Column hvK;
  private static final int hwm;
  private static final int ioK;
  private static final int ioN;
  private static final int ioR;
  private static final int ioS;
  private static final int ioT;
  public static final Column ioW;
  public static final Column ioX;
  public static final Column ioY;
  public static final Column ioZ;
  public static final Column iom;
  public static final Column iop;
  public static final Column iot;
  public static final Column iou;
  public static final Column iov;
  public static final Column ipa;
  public static final Column ipb;
  public static final Column ipc;
  public static final Column ipd;
  private static final int ipm;
  private static final int ipn;
  private static final int ipo;
  private static final int ipp;
  private static final int ipq;
  private static final int ipr;
  private static final int ips;
  private static final int ipt = "dynamicPath".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetexposureTime = true;
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
  public esa field_parents;
  public int field_path;
  public int field_priority;
  public int field_showType;
  public int field_state;
  public int field_tipId;
  public int field_tipType;
  public String field_title;
  public String field_uniqueId;
  private boolean hHO = true;
  private boolean hZx = true;
  private boolean hoG = true;
  private boolean hsd = true;
  private boolean hvY = true;
  private boolean ioB = true;
  private boolean ioF = true;
  private boolean ioG = true;
  private boolean ioH = true;
  private boolean ioy = true;
  private boolean ipe = true;
  private boolean ipf = true;
  private boolean ipg = true;
  private boolean iph = true;
  private boolean ipi = true;
  private boolean ipj = true;
  private boolean ipk = true;
  private boolean ipl = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "NewTipsInfo2", "");
    ioW = new Column("uniqueid", "string", "NewTipsInfo2", "");
    hoC = new Column("path", "int", "NewTipsInfo2", "");
    hZl = new Column("showtype", "int", "NewTipsInfo2", "");
    hsa = new Column("title", "string", "NewTipsInfo2", "");
    ioX = new Column("icon_url", "string", "NewTipsInfo2", "");
    ioY = new Column("parents", "proto", "NewTipsInfo2", "com.tencent.mm.protocal.protobuf.TipsShowInfoParentList");
    iom = new Column("tipid", "int", "NewTipsInfo2", "");
    ioZ = new Column("priority", "int", "NewTipsInfo2", "");
    iop = new Column("tiptype", "int", "NewTipsInfo2", "");
    iot = new Column("beginshowtime", "long", "NewTipsInfo2", "");
    C_EXPOSURETIME = new Column("exposuretime", "long", "NewTipsInfo2", "");
    iov = new Column("overduetime", "long", "NewTipsInfo2", "");
    iou = new Column("disappeartime", "long", "NewTipsInfo2", "");
    ipa = new Column("exposuredisappeartime", "long", "NewTipsInfo2", "");
    ipb = new Column("minclientversion", "int", "NewTipsInfo2", "");
    ipc = new Column("maxclientversion", "int", "NewTipsInfo2", "");
    hvK = new Column("extinfo", "string", "NewTipsInfo2", "");
    hHa = new Column("state", "int", "NewTipsInfo2", "");
    ipd = new Column("dynamicpath", "string", "NewTipsInfo2", "");
    ipm = "uniqueId".hashCode();
    hoK = "path".hashCode();
    hZJ = "showType".hashCode();
    hsg = "title".hashCode();
    ipn = "icon_url".hashCode();
    ipo = "parents".hashCode();
    ioK = "tipId".hashCode();
    ipp = "priority".hashCode();
    ioN = "tipType".hashCode();
    ioR = "beginShowTime".hashCode();
    exposureTime_HASHCODE = "exposureTime".hashCode();
    ioT = "overdueTime".hashCode();
    ioS = "disappearTime".hashCode();
    ipq = "exposureDisappearTime".hashCode();
    ipr = "minClientVersion".hashCode();
    ips = "maxClientVersion".hashCode();
    hwm = "extInfo".hashCode();
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
      if (ipm != k) {
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
      if (hoK == k) {
        this.field_path = paramCursor.getInt(i);
      } else if (hZJ == k) {
        this.field_showType = paramCursor.getInt(i);
      } else if (hsg == k) {
        this.field_title = paramCursor.getString(i);
      } else if (ipn == k) {
        this.field_icon_url = paramCursor.getString(i);
      } else if (ipo == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_parents = ((esa)new esa().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
        }
      } else if (ioK == k) {
        this.field_tipId = paramCursor.getInt(i);
      } else if (ipp == k) {
        this.field_priority = paramCursor.getInt(i);
      } else if (ioN == k) {
        this.field_tipType = paramCursor.getInt(i);
      } else if (ioR == k) {
        this.field_beginShowTime = paramCursor.getLong(i);
      } else if (exposureTime_HASHCODE == k) {
        this.field_exposureTime = paramCursor.getLong(i);
      } else if (ioT == k) {
        this.field_overdueTime = paramCursor.getLong(i);
      } else if (ioS == k) {
        this.field_disappearTime = paramCursor.getLong(i);
      } else if (ipq == k) {
        this.field_exposureDisappearTime = paramCursor.getLong(i);
      } else if (ipr == k) {
        this.field_minClientVersion = paramCursor.getInt(i);
      } else if (ips == k) {
        this.field_maxClientVersion = paramCursor.getInt(i);
      } else if (hwm == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (hIC == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (ipt == k) {
        this.field_dynamicPath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ipe) {
      localContentValues.put("uniqueId", this.field_uniqueId);
    }
    if (this.hoG) {
      localContentValues.put("path", Integer.valueOf(this.field_path));
    }
    if (this.hZx) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.ipf) {
      localContentValues.put("icon_url", this.field_icon_url);
    }
    if ((this.ipg) && (this.field_parents != null)) {}
    try
    {
      localContentValues.put("parents", this.field_parents.toByteArray());
      if (this.ioy) {
        localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
      }
      if (this.iph) {
        localContentValues.put("priority", Integer.valueOf(this.field_priority));
      }
      if (this.ioB) {
        localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
      }
      if (this.ioF) {
        localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
      }
      if (this.__hadSetexposureTime) {
        localContentValues.put("exposureTime", Long.valueOf(this.field_exposureTime));
      }
      if (this.ioH) {
        localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
      }
      if (this.ioG) {
        localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
      }
      if (this.ipi) {
        localContentValues.put("exposureDisappearTime", Long.valueOf(this.field_exposureDisappearTime));
      }
      if (this.ipj) {
        localContentValues.put("minClientVersion", Integer.valueOf(this.field_minClientVersion));
      }
      if (this.ipk) {
        localContentValues.put("maxClientVersion", Integer.valueOf(this.field_maxClientVersion));
      }
      if (this.hvY) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.hHO) {
        localContentValues.put("state", Integer.valueOf(this.field_state));
      }
      if (this.ipl) {
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "NewTipsInfo2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.c.fa
 * JD-Core Version:    0.7.0.1
 */