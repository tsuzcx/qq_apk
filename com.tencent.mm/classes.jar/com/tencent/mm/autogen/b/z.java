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

public abstract class z
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AppInfo");
  private static final int jIF;
  public static final Column jIz;
  public static final Column jKD;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jLE;
  private static final int jLM;
  private static final int jLl;
  private static final int jNS;
  private static final int jNT;
  private static final int jNU;
  private static final int jNV;
  private static final int jNW;
  private static final int jNX;
  private static final int jNY;
  private static final int jNZ;
  public static final Column jNa;
  public static final Column jNb;
  public static final Column jNc;
  public static final Column jNd;
  public static final Column jNe;
  public static final Column jNf;
  public static final Column jNg;
  public static final Column jNh;
  public static final Column jNi;
  public static final Column jNj;
  public static final Column jNk;
  public static final Column jNl;
  public static final Column jNm;
  public static final Column jNn;
  public static final Column jNo;
  public static final Column jNp;
  public static final Column jNq;
  public static final Column jNr;
  public static final Column jNs;
  public static final Column jNt;
  public static final Column jNu;
  public static final Column jNv;
  private static final int jOa;
  private static final int jOb;
  private static final int jOc;
  private static final int jOd;
  private static final int jOe;
  private static final int jOf;
  private static final int jOg;
  private static final int jOh;
  private static final int jOi;
  private static final int jOj;
  private static final int jOk;
  private static final int jOl;
  private static final int jOm;
  private static final int jOn;
  private static final StorageObserverOwner<z> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appDiscription;
  public String field_appDiscription_en;
  public String field_appDiscription_tw;
  public String field_appIconUrl;
  public String field_appId;
  public int field_appInfoFlag;
  public String field_appName;
  public String field_appName_en;
  public String field_appName_hk;
  public String field_appName_tw;
  public String field_appStoreUrl;
  public long field_appSupportContentType;
  public String field_appType;
  public int field_appVersion;
  public String field_appWatermarkUrl;
  public int field_authFlag;
  public byte[] field_lvbuff;
  public long field_modifyTime;
  public String field_openId;
  public String field_packageName;
  public int field_serviceAppInfoFlag;
  public int field_serviceAppType;
  public int field_serviceShowFlag;
  public String field_signature;
  public int field_status;
  public long field_svrAppSupportContentType;
  private boolean jIC = true;
  private boolean jKG = true;
  private boolean jKU = true;
  private boolean jLI = true;
  private boolean jNA = true;
  private boolean jNB = true;
  private boolean jNC = true;
  private boolean jND = true;
  private boolean jNE = true;
  private boolean jNF = true;
  private boolean jNG = true;
  private boolean jNH = true;
  private boolean jNI = true;
  private boolean jNJ = true;
  private boolean jNK = true;
  private boolean jNL = true;
  public boolean jNM = true;
  private boolean jNN = true;
  private boolean jNO = true;
  private boolean jNP = true;
  private boolean jNQ = true;
  private boolean jNR = true;
  private boolean jNw = true;
  private boolean jNx = true;
  private boolean jNy = true;
  private boolean jNz = true;
  public String jOA;
  public String jOB;
  public String jOC;
  public String jOD;
  private String jOE;
  public int jOF;
  private String jOG;
  private int jOH;
  public String jOI;
  public String jOJ;
  public String jOK;
  public int jOL;
  private String jOo;
  private String jOp;
  public String jOq;
  public int jOr;
  public int jOs;
  public String jOt;
  public String jOu;
  public String jOv;
  public String jOw;
  public String jOx;
  public String jOy;
  public int jOz;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jNa = new Column("appName", "string", TABLE.getName(), "");
    jNb = new Column("appDiscription", "string", TABLE.getName(), "");
    jNc = new Column("appIconUrl", "string", TABLE.getName(), "");
    jNd = new Column("appStoreUrl", "string", TABLE.getName(), "");
    jLE = new Column("appVersion", "int", TABLE.getName(), "");
    jNe = new Column("appWatermarkUrl", "string", TABLE.getName(), "");
    jNf = new Column("packageName", "string", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    jKD = new Column("signature", "string", TABLE.getName(), "");
    jNg = new Column("modifyTime", "long", TABLE.getName(), "");
    jNh = new Column("appName_en", "string", TABLE.getName(), "");
    jNi = new Column("appName_tw", "string", TABLE.getName(), "");
    jNj = new Column("appName_hk", "string", TABLE.getName(), "");
    jNk = new Column("appDiscription_en", "string", TABLE.getName(), "");
    jNl = new Column("appDiscription_tw", "string", TABLE.getName(), "");
    jNm = new Column("appType", "string", TABLE.getName(), "");
    jNn = new Column("openId", "string", TABLE.getName(), "");
    jNo = new Column("authFlag", "int", TABLE.getName(), "");
    jNp = new Column("appInfoFlag", "int", TABLE.getName(), "");
    jNq = new Column("lvbuff", "byte[]", TABLE.getName(), "");
    jNr = new Column("serviceAppType", "int", TABLE.getName(), "");
    jNs = new Column("serviceAppInfoFlag", "int", TABLE.getName(), "");
    jNt = new Column("serviceShowFlag", "int", TABLE.getName(), "");
    jNu = new Column("appSupportContentType", "long", TABLE.getName(), "");
    jNv = new Column("svrAppSupportContentType", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)" };
    jKX = "appId".hashCode();
    jNS = "appName".hashCode();
    jNT = "appDiscription".hashCode();
    jNU = "appIconUrl".hashCode();
    jNV = "appStoreUrl".hashCode();
    jLM = "appVersion".hashCode();
    jNW = "appWatermarkUrl".hashCode();
    jNX = "packageName".hashCode();
    jIF = "status".hashCode();
    jLl = "signature".hashCode();
    jNY = "modifyTime".hashCode();
    jNZ = "appName_en".hashCode();
    jOa = "appName_tw".hashCode();
    jOb = "appName_hk".hashCode();
    jOc = "appDiscription_en".hashCode();
    jOd = "appDiscription_tw".hashCode();
    jOe = "appType".hashCode();
    jOf = "openId".hashCode();
    jOg = "authFlag".hashCode();
    jOh = "appInfoFlag".hashCode();
    jOi = "lvbuff".hashCode();
    jOj = "serviceAppType".hashCode();
    jOk = "serviceAppInfoFlag".hashCode();
    jOl = "serviceShowFlag".hashCode();
    jOm = "appSupportContentType".hashCode();
    jOn = "svrAppSupportContentType".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[26];
    localMAutoDBInfo.columns = new String[27];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appId";
    localMAutoDBInfo.columns[1] = "appName";
    localMAutoDBInfo.colsMap.put("appName", "TEXT");
    localStringBuilder.append(" appName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appDiscription";
    localMAutoDBInfo.colsMap.put("appDiscription", "TEXT");
    localStringBuilder.append(" appDiscription TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "appIconUrl";
    localMAutoDBInfo.colsMap.put("appIconUrl", "TEXT");
    localStringBuilder.append(" appIconUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "appStoreUrl";
    localMAutoDBInfo.colsMap.put("appStoreUrl", "TEXT");
    localStringBuilder.append(" appStoreUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "appVersion";
    localMAutoDBInfo.colsMap.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "appWatermarkUrl";
    localMAutoDBInfo.colsMap.put("appWatermarkUrl", "TEXT");
    localStringBuilder.append(" appWatermarkUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "packageName";
    localMAutoDBInfo.colsMap.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "modifyTime";
    localMAutoDBInfo.colsMap.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "appName_en";
    localMAutoDBInfo.colsMap.put("appName_en", "TEXT");
    localStringBuilder.append(" appName_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "appName_tw";
    localMAutoDBInfo.colsMap.put("appName_tw", "TEXT");
    localStringBuilder.append(" appName_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "appName_hk";
    localMAutoDBInfo.colsMap.put("appName_hk", "TEXT");
    localStringBuilder.append(" appName_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "appDiscription_en";
    localMAutoDBInfo.colsMap.put("appDiscription_en", "TEXT");
    localStringBuilder.append(" appDiscription_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "appDiscription_tw";
    localMAutoDBInfo.colsMap.put("appDiscription_tw", "TEXT");
    localStringBuilder.append(" appDiscription_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "appType";
    localMAutoDBInfo.colsMap.put("appType", "TEXT");
    localStringBuilder.append(" appType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "openId";
    localMAutoDBInfo.colsMap.put("openId", "TEXT");
    localStringBuilder.append(" openId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "authFlag";
    localMAutoDBInfo.colsMap.put("authFlag", "INTEGER");
    localStringBuilder.append(" authFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "appInfoFlag";
    localMAutoDBInfo.colsMap.put("appInfoFlag", "INTEGER default '-1' ");
    localStringBuilder.append(" appInfoFlag INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "lvbuff";
    localMAutoDBInfo.colsMap.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "serviceAppType";
    localMAutoDBInfo.colsMap.put("serviceAppType", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "serviceAppInfoFlag";
    localMAutoDBInfo.colsMap.put("serviceAppInfoFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppInfoFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "serviceShowFlag";
    localMAutoDBInfo.colsMap.put("serviceShowFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceShowFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "appSupportContentType";
    localMAutoDBInfo.colsMap.put("appSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" appSupportContentType LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "svrAppSupportContentType";
    localMAutoDBInfo.colsMap.put("svrAppSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" svrAppSupportContentType LONG default '0' ");
    localMAutoDBInfo.columns[26] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public final void AC(String paramString)
  {
    this.jOo = paramString;
    this.jNM = true;
  }
  
  public final void AD(String paramString)
  {
    this.jOp = paramString;
    this.jNM = true;
  }
  
  public final void AE(String paramString)
  {
    this.jOq = paramString;
    this.jNM = true;
  }
  
  public final void AF(String paramString)
  {
    this.jOt = paramString;
    this.jNM = true;
  }
  
  public final void AG(String paramString)
  {
    this.jOu = paramString;
    this.jNM = true;
  }
  
  public final void AH(String paramString)
  {
    this.jOv = paramString;
    this.jNM = true;
  }
  
  public final void AI(String paramString)
  {
    this.jOw = paramString;
    this.jNM = true;
  }
  
  public final void AJ(String paramString)
  {
    this.jOx = paramString;
    this.jNM = true;
  }
  
  public final void AK(String paramString)
  {
    this.jOy = paramString;
    this.jNM = true;
  }
  
  public final void AL(String paramString)
  {
    this.jOA = paramString;
    this.jNM = true;
  }
  
  public final void AM(String paramString)
  {
    this.jOB = paramString;
    this.jNM = true;
  }
  
  public final void AN(String paramString)
  {
    this.jOC = paramString;
    this.jNM = true;
  }
  
  public final void AO(String paramString)
  {
    this.jOD = paramString;
    this.jNM = true;
  }
  
  public final void AP(String paramString)
  {
    this.jOE = paramString;
    this.jNM = true;
  }
  
  public final void AQ(String paramString)
  {
    this.jOG = paramString;
    this.jNM = true;
  }
  
  public final void AR(String paramString)
  {
    this.jOI = paramString;
    this.jNM = true;
  }
  
  public final void AS(String paramString)
  {
    this.jOJ = paramString;
    this.jNM = true;
  }
  
  public final void AT(String paramString)
  {
    this.jOK = paramString;
    this.jNM = true;
  }
  
  public final String aJn()
  {
    return this.jOq;
  }
  
  public final String aJo()
  {
    return this.jOv;
  }
  
  public final String aJp()
  {
    return this.jOw;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("appName"))
    {
      this.field_appName = paramContentValues.getAsString("appName");
      if (paramBoolean) {
        this.jNw = true;
      }
    }
    if (paramContentValues.containsKey("appDiscription"))
    {
      this.field_appDiscription = paramContentValues.getAsString("appDiscription");
      if (paramBoolean) {
        this.jNx = true;
      }
    }
    if (paramContentValues.containsKey("appIconUrl"))
    {
      this.field_appIconUrl = paramContentValues.getAsString("appIconUrl");
      if (paramBoolean) {
        this.jNy = true;
      }
    }
    if (paramContentValues.containsKey("appStoreUrl"))
    {
      this.field_appStoreUrl = paramContentValues.getAsString("appStoreUrl");
      if (paramBoolean) {
        this.jNz = true;
      }
    }
    if (paramContentValues.containsKey("appVersion"))
    {
      this.field_appVersion = paramContentValues.getAsInteger("appVersion").intValue();
      if (paramBoolean) {
        this.jLI = true;
      }
    }
    if (paramContentValues.containsKey("appWatermarkUrl"))
    {
      this.field_appWatermarkUrl = paramContentValues.getAsString("appWatermarkUrl");
      if (paramBoolean) {
        this.jNA = true;
      }
    }
    if (paramContentValues.containsKey("packageName"))
    {
      this.field_packageName = paramContentValues.getAsString("packageName");
      if (paramBoolean) {
        this.jNB = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("signature"))
    {
      this.field_signature = paramContentValues.getAsString("signature");
      if (paramBoolean) {
        this.jKU = true;
      }
    }
    if (paramContentValues.containsKey("modifyTime"))
    {
      this.field_modifyTime = paramContentValues.getAsLong("modifyTime").longValue();
      if (paramBoolean) {
        this.jNC = true;
      }
    }
    if (paramContentValues.containsKey("appName_en"))
    {
      this.field_appName_en = paramContentValues.getAsString("appName_en");
      if (paramBoolean) {
        this.jND = true;
      }
    }
    if (paramContentValues.containsKey("appName_tw"))
    {
      this.field_appName_tw = paramContentValues.getAsString("appName_tw");
      if (paramBoolean) {
        this.jNE = true;
      }
    }
    if (paramContentValues.containsKey("appName_hk"))
    {
      this.field_appName_hk = paramContentValues.getAsString("appName_hk");
      if (paramBoolean) {
        this.jNF = true;
      }
    }
    if (paramContentValues.containsKey("appDiscription_en"))
    {
      this.field_appDiscription_en = paramContentValues.getAsString("appDiscription_en");
      if (paramBoolean) {
        this.jNG = true;
      }
    }
    if (paramContentValues.containsKey("appDiscription_tw"))
    {
      this.field_appDiscription_tw = paramContentValues.getAsString("appDiscription_tw");
      if (paramBoolean) {
        this.jNH = true;
      }
    }
    if (paramContentValues.containsKey("appType"))
    {
      this.field_appType = paramContentValues.getAsString("appType");
      if (paramBoolean) {
        this.jNI = true;
      }
    }
    if (paramContentValues.containsKey("openId"))
    {
      this.field_openId = paramContentValues.getAsString("openId");
      if (paramBoolean) {
        this.jNJ = true;
      }
    }
    if (paramContentValues.containsKey("authFlag"))
    {
      this.field_authFlag = paramContentValues.getAsInteger("authFlag").intValue();
      if (paramBoolean) {
        this.jNK = true;
      }
    }
    if (paramContentValues.containsKey("appInfoFlag"))
    {
      this.field_appInfoFlag = paramContentValues.getAsInteger("appInfoFlag").intValue();
      if (paramBoolean) {
        this.jNL = true;
      }
    }
    if (paramContentValues.containsKey("lvbuff"))
    {
      this.field_lvbuff = paramContentValues.getAsByteArray("lvbuff");
      if (paramBoolean) {
        this.jNM = true;
      }
    }
    if (paramContentValues.containsKey("serviceAppType"))
    {
      this.field_serviceAppType = paramContentValues.getAsInteger("serviceAppType").intValue();
      if (paramBoolean) {
        this.jNN = true;
      }
    }
    if (paramContentValues.containsKey("serviceAppInfoFlag"))
    {
      this.field_serviceAppInfoFlag = paramContentValues.getAsInteger("serviceAppInfoFlag").intValue();
      if (paramBoolean) {
        this.jNO = true;
      }
    }
    if (paramContentValues.containsKey("serviceShowFlag"))
    {
      this.field_serviceShowFlag = paramContentValues.getAsInteger("serviceShowFlag").intValue();
      if (paramBoolean) {
        this.jNP = true;
      }
    }
    if (paramContentValues.containsKey("appSupportContentType"))
    {
      this.field_appSupportContentType = paramContentValues.getAsLong("appSupportContentType").longValue();
      if (paramBoolean) {
        this.jNQ = true;
      }
    }
    if (paramContentValues.containsKey("svrAppSupportContentType"))
    {
      this.field_svrAppSupportContentType = paramContentValues.getAsLong("svrAppSupportContentType").longValue();
      if (paramBoolean) {
        this.jNR = true;
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
          if (jKX == k)
          {
            this.field_appId = paramCursor.getString(i);
            this.jKG = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (jNS == k) {
              this.field_appName = paramCursor.getString(i);
            } else if (jNT == k) {
              this.field_appDiscription = paramCursor.getString(i);
            } else if (jNU == k) {
              this.field_appIconUrl = paramCursor.getString(i);
            } else if (jNV == k) {
              this.field_appStoreUrl = paramCursor.getString(i);
            } else if (jLM == k) {
              this.field_appVersion = paramCursor.getInt(i);
            } else if (jNW == k) {
              this.field_appWatermarkUrl = paramCursor.getString(i);
            } else if (jNX == k) {
              this.field_packageName = paramCursor.getString(i);
            } else if (jIF == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (jLl == k) {
              this.field_signature = paramCursor.getString(i);
            } else if (jNY == k) {
              this.field_modifyTime = paramCursor.getLong(i);
            } else if (jNZ == k) {
              this.field_appName_en = paramCursor.getString(i);
            } else if (jOa == k) {
              this.field_appName_tw = paramCursor.getString(i);
            } else if (jOb == k) {
              this.field_appName_hk = paramCursor.getString(i);
            } else if (jOc == k) {
              this.field_appDiscription_en = paramCursor.getString(i);
            } else if (jOd == k) {
              this.field_appDiscription_tw = paramCursor.getString(i);
            } else if (jOe == k) {
              this.field_appType = paramCursor.getString(i);
            } else if (jOf == k) {
              this.field_openId = paramCursor.getString(i);
            } else if (jOg == k) {
              this.field_authFlag = paramCursor.getInt(i);
            } else if (jOh == k) {
              this.field_appInfoFlag = paramCursor.getInt(i);
            } else if (jOi == k) {
              this.field_lvbuff = paramCursor.getBlob(i);
            } else if (jOj == k) {
              this.field_serviceAppType = paramCursor.getInt(i);
            } else if (jOk == k) {
              this.field_serviceAppInfoFlag = paramCursor.getInt(i);
            } else if (jOl == k) {
              this.field_serviceShowFlag = paramCursor.getInt(i);
            } else if (jOm == k) {
              this.field_appSupportContentType = paramCursor.getLong(i);
            } else if (jOn == k) {
              this.field_svrAppSupportContentType = paramCursor.getLong(i);
            } else if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
        try
        {
          if ((this.field_lvbuff != null) && (this.field_lvbuff.length != 0))
          {
            paramCursor = new LVBuffer();
            i = paramCursor.initParse(this.field_lvbuff);
            if (i != 0)
            {
              Log.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          Log.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
          return;
        }
      }
      this.jOo = paramCursor.getString();
      this.jOp = paramCursor.getString();
      this.jOq = paramCursor.getString();
      this.jOr = paramCursor.getInt();
      this.jOs = paramCursor.getInt();
      this.jOt = paramCursor.getString();
      this.jOu = paramCursor.getString();
      this.jOv = paramCursor.getString();
      this.jOw = paramCursor.getString();
      if (!paramCursor.checkGetFinish()) {
        this.jOx = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOy = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOz = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOA = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOB = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOC = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOD = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOE = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOF = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOG = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOH = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOI = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOJ = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jOK = paramCursor.getString();
      }
    } while (paramCursor.checkGetFinish());
    this.jOL = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.jNM)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putString(this.jOo);
        ((LVBuffer)localObject).putString(this.jOp);
        ((LVBuffer)localObject).putString(this.jOq);
        ((LVBuffer)localObject).putInt(this.jOr);
        ((LVBuffer)localObject).putInt(this.jOs);
        ((LVBuffer)localObject).putString(this.jOt);
        ((LVBuffer)localObject).putString(this.jOu);
        ((LVBuffer)localObject).putString(this.jOv);
        ((LVBuffer)localObject).putString(this.jOw);
        ((LVBuffer)localObject).putString(this.jOx);
        ((LVBuffer)localObject).putString(this.jOy);
        ((LVBuffer)localObject).putInt(this.jOz);
        ((LVBuffer)localObject).putString(this.jOA);
        ((LVBuffer)localObject).putString(this.jOB);
        ((LVBuffer)localObject).putString(this.jOC);
        ((LVBuffer)localObject).putString(this.jOD);
        ((LVBuffer)localObject).putString(this.jOE);
        ((LVBuffer)localObject).putInt(this.jOF);
        ((LVBuffer)localObject).putString(this.jOG);
        ((LVBuffer)localObject).putInt(this.jOH);
        ((LVBuffer)localObject).putString(this.jOI);
        ((LVBuffer)localObject).putString(this.jOJ);
        ((LVBuffer)localObject).putString(this.jOK);
        ((LVBuffer)localObject).putInt(this.jOL);
        this.field_lvbuff = ((LVBuffer)localObject).buildFinish();
      }
      Object localObject = new ContentValues();
      if (this.field_appId == null) {
        this.field_appId = "";
      }
      if (this.jKG) {
        ((ContentValues)localObject).put("appId", this.field_appId);
      }
      if (this.jNw) {
        ((ContentValues)localObject).put("appName", this.field_appName);
      }
      if (this.jNx) {
        ((ContentValues)localObject).put("appDiscription", this.field_appDiscription);
      }
      if (this.jNy) {
        ((ContentValues)localObject).put("appIconUrl", this.field_appIconUrl);
      }
      if (this.jNz) {
        ((ContentValues)localObject).put("appStoreUrl", this.field_appStoreUrl);
      }
      if (this.jLI) {
        ((ContentValues)localObject).put("appVersion", Integer.valueOf(this.field_appVersion));
      }
      if (this.jNA) {
        ((ContentValues)localObject).put("appWatermarkUrl", this.field_appWatermarkUrl);
      }
      if (this.jNB) {
        ((ContentValues)localObject).put("packageName", this.field_packageName);
      }
      if (this.jIC) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.jKU) {
        ((ContentValues)localObject).put("signature", this.field_signature);
      }
      if (this.jNC) {
        ((ContentValues)localObject).put("modifyTime", Long.valueOf(this.field_modifyTime));
      }
      if (this.jND) {
        ((ContentValues)localObject).put("appName_en", this.field_appName_en);
      }
      if (this.jNE) {
        ((ContentValues)localObject).put("appName_tw", this.field_appName_tw);
      }
      if (this.jNF) {
        ((ContentValues)localObject).put("appName_hk", this.field_appName_hk);
      }
      if (this.jNG) {
        ((ContentValues)localObject).put("appDiscription_en", this.field_appDiscription_en);
      }
      if (this.jNH) {
        ((ContentValues)localObject).put("appDiscription_tw", this.field_appDiscription_tw);
      }
      if (this.jNI) {
        ((ContentValues)localObject).put("appType", this.field_appType);
      }
      if (this.jNJ) {
        ((ContentValues)localObject).put("openId", this.field_openId);
      }
      if (this.jNK) {
        ((ContentValues)localObject).put("authFlag", Integer.valueOf(this.field_authFlag));
      }
      if (this.jNL) {
        ((ContentValues)localObject).put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
      }
      if (this.jNM) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.jNN) {
        ((ContentValues)localObject).put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
      }
      if (this.jNO) {
        ((ContentValues)localObject).put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
      }
      if (this.jNP) {
        ((ContentValues)localObject).put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
      }
      if (this.jNQ) {
        ((ContentValues)localObject).put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
      }
      if (this.jNR) {
        ((ContentValues)localObject).put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
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
        Log.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends z> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_appId;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public final void pl(int paramInt)
  {
    this.jOz = paramInt;
    this.jNM = true;
  }
  
  public final void pm(int paramInt)
  {
    this.jOF = paramInt;
    this.jNM = true;
  }
  
  public final void pn(int paramInt)
  {
    this.jOL = paramInt;
    this.jNM = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.z
 * JD-Core Version:    0.7.0.1
 */