package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ee
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("HardDeviceInfo");
  private static final int jPC;
  public static final Column jPb;
  public static final Column jPu;
  public static final Column jTD;
  private static final int jUf;
  private static final int kCM;
  private static final int kCN;
  private static final int kCO;
  private static final int kCP;
  private static final int kCQ;
  private static final int kCR;
  private static final int kCS;
  private static final int kCT;
  private static final int kCU;
  private static final int kCV;
  private static final int kCW;
  private static final int kCX;
  public static final Column kCp;
  public static final Column kCq;
  public static final Column kCr;
  public static final Column kCs;
  public static final Column kCt;
  public static final Column kCu;
  public static final Column kCv;
  public static final Column kCw;
  public static final Column kCx;
  public static final Column kCy;
  public static final Column kCz;
  private static final StorageObserverOwner<ee> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public byte[] field_authBuf;
  public String field_authKey;
  public String field_brandName;
  public int field_closeStrategy;
  public String field_connProto;
  public int field_connStrategy;
  public String field_deviceID;
  public String field_deviceType;
  public byte[] field_lvbuffer;
  public long field_mac;
  public String field_md5Str;
  public byte[] field_sessionBuf;
  public byte[] field_sessionKey;
  public String field_url;
  public String iconUrl;
  private boolean jPy = true;
  public boolean jTR = true;
  public String jumpUrl;
  private boolean kCA = true;
  private boolean kCB = true;
  private boolean kCC = true;
  private boolean kCD = true;
  private boolean kCE = true;
  private boolean kCF = true;
  private boolean kCG = true;
  private boolean kCH = true;
  private boolean kCI = true;
  private boolean kCJ = true;
  private boolean kCK = true;
  private boolean kCL = true;
  public int kCY;
  public int kCZ;
  public long kDa;
  private long kDb;
  public String kDc;
  public String kDd;
  public String kDe;
  public String kDf;
  private int kDg;
  public int kDh;
  public long kDi;
  public String kDj;
  public String kDk;
  private String kDl;
  public String kDm;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jPb = new Column("deviceID", "string", TABLE.getName(), "");
    kCp = new Column("brandName", "string", TABLE.getName(), "");
    kCq = new Column("mac", "long", TABLE.getName(), "");
    kCr = new Column("deviceType", "string", TABLE.getName(), "");
    kCs = new Column("connProto", "string", TABLE.getName(), "");
    kCt = new Column("connStrategy", "int", TABLE.getName(), "");
    kCu = new Column("closeStrategy", "int", TABLE.getName(), "");
    kCv = new Column("md5Str", "string", TABLE.getName(), "");
    kCw = new Column("authKey", "string", TABLE.getName(), "");
    jPu = new Column("url", "string", TABLE.getName(), "");
    kCx = new Column("sessionKey", "byte[]", TABLE.getName(), "");
    kCy = new Column("sessionBuf", "byte[]", TABLE.getName(), "");
    kCz = new Column("authBuf", "byte[]", TABLE.getName(), "");
    jTD = new Column("lvbuffer", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kCM = "deviceID".hashCode();
    kCN = "brandName".hashCode();
    kCO = "mac".hashCode();
    kCP = "deviceType".hashCode();
    kCQ = "connProto".hashCode();
    kCR = "connStrategy".hashCode();
    kCS = "closeStrategy".hashCode();
    kCT = "md5Str".hashCode();
    kCU = "authKey".hashCode();
    jPC = "url".hashCode();
    kCV = "sessionKey".hashCode();
    kCW = "sessionBuf".hashCode();
    kCX = "authBuf".hashCode();
    jUf = "lvbuffer".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[14];
    localMAutoDBInfo.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "deviceID";
    localMAutoDBInfo.colsMap.put("deviceID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" deviceID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "deviceID";
    localMAutoDBInfo.columns[1] = "brandName";
    localMAutoDBInfo.colsMap.put("brandName", "TEXT");
    localStringBuilder.append(" brandName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "mac";
    localMAutoDBInfo.colsMap.put("mac", "LONG");
    localStringBuilder.append(" mac LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "deviceType";
    localMAutoDBInfo.colsMap.put("deviceType", "TEXT");
    localStringBuilder.append(" deviceType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "connProto";
    localMAutoDBInfo.colsMap.put("connProto", "TEXT");
    localStringBuilder.append(" connProto TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "connStrategy";
    localMAutoDBInfo.colsMap.put("connStrategy", "INTEGER");
    localStringBuilder.append(" connStrategy INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "closeStrategy";
    localMAutoDBInfo.colsMap.put("closeStrategy", "INTEGER");
    localStringBuilder.append(" closeStrategy INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "md5Str";
    localMAutoDBInfo.colsMap.put("md5Str", "TEXT");
    localStringBuilder.append(" md5Str TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "authKey";
    localMAutoDBInfo.colsMap.put("authKey", "TEXT");
    localStringBuilder.append(" authKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "sessionKey";
    localMAutoDBInfo.colsMap.put("sessionKey", "BLOB");
    localStringBuilder.append(" sessionKey BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "sessionBuf";
    localMAutoDBInfo.colsMap.put("sessionBuf", "BLOB");
    localStringBuilder.append(" sessionBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "authBuf";
    localMAutoDBInfo.colsMap.put("authBuf", "BLOB");
    localStringBuilder.append(" authBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "lvbuffer";
    localMAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localMAutoDBInfo.columns[14] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public final void AV(String paramString)
  {
    this.kDc = paramString;
    this.jTR = true;
  }
  
  public final void BJ(String paramString)
  {
    this.jumpUrl = paramString;
    this.jTR = true;
  }
  
  public final void BK(String paramString)
  {
    this.kDd = paramString;
    this.jTR = true;
  }
  
  public final void BL(String paramString)
  {
    this.kDe = paramString;
    this.jTR = true;
  }
  
  public final void BM(String paramString)
  {
    this.kDf = paramString;
    this.jTR = true;
  }
  
  public final void BN(String paramString)
  {
    this.kDj = paramString;
    this.jTR = true;
  }
  
  public final void BO(String paramString)
  {
    this.kDk = paramString;
    this.jTR = true;
  }
  
  public final void BP(String paramString)
  {
    this.kDl = paramString;
    this.jTR = true;
  }
  
  public final void BQ(String paramString)
  {
    this.kDm = paramString;
    this.jTR = true;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("deviceID"))
    {
      this.field_deviceID = paramContentValues.getAsString("deviceID");
      if (paramBoolean) {
        this.kCA = true;
      }
    }
    if (paramContentValues.containsKey("brandName"))
    {
      this.field_brandName = paramContentValues.getAsString("brandName");
      if (paramBoolean) {
        this.kCB = true;
      }
    }
    if (paramContentValues.containsKey("mac"))
    {
      this.field_mac = paramContentValues.getAsLong("mac").longValue();
      if (paramBoolean) {
        this.kCC = true;
      }
    }
    if (paramContentValues.containsKey("deviceType"))
    {
      this.field_deviceType = paramContentValues.getAsString("deviceType");
      if (paramBoolean) {
        this.kCD = true;
      }
    }
    if (paramContentValues.containsKey("connProto"))
    {
      this.field_connProto = paramContentValues.getAsString("connProto");
      if (paramBoolean) {
        this.kCE = true;
      }
    }
    if (paramContentValues.containsKey("connStrategy"))
    {
      this.field_connStrategy = paramContentValues.getAsInteger("connStrategy").intValue();
      if (paramBoolean) {
        this.kCF = true;
      }
    }
    if (paramContentValues.containsKey("closeStrategy"))
    {
      this.field_closeStrategy = paramContentValues.getAsInteger("closeStrategy").intValue();
      if (paramBoolean) {
        this.kCG = true;
      }
    }
    if (paramContentValues.containsKey("md5Str"))
    {
      this.field_md5Str = paramContentValues.getAsString("md5Str");
      if (paramBoolean) {
        this.kCH = true;
      }
    }
    if (paramContentValues.containsKey("authKey"))
    {
      this.field_authKey = paramContentValues.getAsString("authKey");
      if (paramBoolean) {
        this.kCI = true;
      }
    }
    if (paramContentValues.containsKey("url"))
    {
      this.field_url = paramContentValues.getAsString("url");
      if (paramBoolean) {
        this.jPy = true;
      }
    }
    if (paramContentValues.containsKey("sessionKey"))
    {
      this.field_sessionKey = paramContentValues.getAsByteArray("sessionKey");
      if (paramBoolean) {
        this.kCJ = true;
      }
    }
    if (paramContentValues.containsKey("sessionBuf"))
    {
      this.field_sessionBuf = paramContentValues.getAsByteArray("sessionBuf");
      if (paramBoolean) {
        this.kCK = true;
      }
    }
    if (paramContentValues.containsKey("authBuf"))
    {
      this.field_authBuf = paramContentValues.getAsByteArray("authBuf");
      if (paramBoolean) {
        this.kCL = true;
      }
    }
    if (paramContentValues.containsKey("lvbuffer"))
    {
      this.field_lvbuffer = paramContentValues.getAsByteArray("lvbuffer");
      if (paramBoolean) {
        this.jTR = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    do
    {
      for (;;)
      {
        return;
        int i = 0;
        int j = arrayOfString.length;
        if (i < j)
        {
          int k = arrayOfString[i].hashCode();
          if (kCM == k)
          {
            this.field_deviceID = paramCursor.getString(i);
            this.kCA = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (kCN == k) {
              this.field_brandName = paramCursor.getString(i);
            } else if (kCO == k) {
              this.field_mac = paramCursor.getLong(i);
            } else if (kCP == k) {
              this.field_deviceType = paramCursor.getString(i);
            } else if (kCQ == k) {
              this.field_connProto = paramCursor.getString(i);
            } else if (kCR == k) {
              this.field_connStrategy = paramCursor.getInt(i);
            } else if (kCS == k) {
              this.field_closeStrategy = paramCursor.getInt(i);
            } else if (kCT == k) {
              this.field_md5Str = paramCursor.getString(i);
            } else if (kCU == k) {
              this.field_authKey = paramCursor.getString(i);
            } else if (jPC == k) {
              this.field_url = paramCursor.getString(i);
            } else if (kCV == k) {
              this.field_sessionKey = paramCursor.getBlob(i);
            } else if (kCW == k) {
              this.field_sessionBuf = paramCursor.getBlob(i);
            } else if (kCX == k) {
              this.field_authBuf = paramCursor.getBlob(i);
            } else if (jUf == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
        try
        {
          if ((this.field_lvbuffer != null) && (this.field_lvbuffer.length != 0))
          {
            paramCursor = new LVBuffer();
            i = paramCursor.initParse(this.field_lvbuffer);
            if (i != 0)
            {
              Log.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          Log.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.checkGetFinish()) {
        this.kCY = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kCZ = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDa = paramCursor.getLong();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDb = paramCursor.getLong();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDc = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.iconUrl = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jumpUrl = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDd = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDe = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDf = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDg = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDh = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDi = paramCursor.getLong();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDj = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDk = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kDl = paramCursor.getString();
      }
    } while (paramCursor.checkGetFinish());
    this.kDm = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.jTR)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putInt(this.kCY);
        ((LVBuffer)localObject).putInt(this.kCZ);
        ((LVBuffer)localObject).putLong(this.kDa);
        ((LVBuffer)localObject).putLong(this.kDb);
        ((LVBuffer)localObject).putString(this.kDc);
        ((LVBuffer)localObject).putString(this.iconUrl);
        ((LVBuffer)localObject).putString(this.jumpUrl);
        ((LVBuffer)localObject).putString(this.kDd);
        ((LVBuffer)localObject).putString(this.kDe);
        ((LVBuffer)localObject).putString(this.kDf);
        ((LVBuffer)localObject).putInt(this.kDg);
        ((LVBuffer)localObject).putInt(this.kDh);
        ((LVBuffer)localObject).putLong(this.kDi);
        ((LVBuffer)localObject).putString(this.kDj);
        ((LVBuffer)localObject).putString(this.kDk);
        ((LVBuffer)localObject).putString(this.kDl);
        ((LVBuffer)localObject).putString(this.kDm);
        this.field_lvbuffer = ((LVBuffer)localObject).buildFinish();
      }
      Object localObject = new ContentValues();
      if (this.kCA) {
        ((ContentValues)localObject).put("deviceID", this.field_deviceID);
      }
      if (this.kCB) {
        ((ContentValues)localObject).put("brandName", this.field_brandName);
      }
      if (this.kCC) {
        ((ContentValues)localObject).put("mac", Long.valueOf(this.field_mac));
      }
      if (this.kCD) {
        ((ContentValues)localObject).put("deviceType", this.field_deviceType);
      }
      if (this.kCE) {
        ((ContentValues)localObject).put("connProto", this.field_connProto);
      }
      if (this.kCF) {
        ((ContentValues)localObject).put("connStrategy", Integer.valueOf(this.field_connStrategy));
      }
      if (this.kCG) {
        ((ContentValues)localObject).put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
      }
      if (this.kCH) {
        ((ContentValues)localObject).put("md5Str", this.field_md5Str);
      }
      if (this.kCI) {
        ((ContentValues)localObject).put("authKey", this.field_authKey);
      }
      if (this.jPy) {
        ((ContentValues)localObject).put("url", this.field_url);
      }
      if (this.kCJ) {
        ((ContentValues)localObject).put("sessionKey", this.field_sessionKey);
      }
      if (this.kCK) {
        ((ContentValues)localObject).put("sessionBuf", this.field_sessionBuf);
      }
      if (this.kCL) {
        ((ContentValues)localObject).put("authBuf", this.field_authBuf);
      }
      if (this.jTR) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.systemRowid > 0L) {
        ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
      }
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void gV(long paramLong)
  {
    this.kDi = paramLong;
    this.jTR = true;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends ee> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_deviceID;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public final void pT(int paramInt)
  {
    this.kDg = paramInt;
    this.jTR = true;
  }
  
  public final void pU(int paramInt)
  {
    this.kDh = paramInt;
    this.jTR = true;
  }
  
  public final void setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
    this.jTR = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.ee
 * JD-Core Version:    0.7.0.1
 */