package com.tencent.mm.api;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.j;
import com.tencent.mm.g.c.ak;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends ak
{
  public static int cFi;
  public static int cFj;
  public static int cFk;
  private static int cFn;
  private static b cFo;
  public static com.tencent.mm.sdk.e.c.a info;
  private List<a> cFl;
  public b cFm;
  
  static
  {
    AppMethodBeat.i(116408);
    cFi = 1;
    cFj = 0;
    cFk = 1;
    com.tencent.mm.sdk.e.c.a locala = new com.tencent.mm.sdk.e.c.a();
    locala.GvF = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.GvH.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "username";
    locala.columns[1] = "appId";
    locala.GvH.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandList";
    locala.GvH.put("brandList", "TEXT default '' ");
    localStringBuilder.append(" brandList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "brandListVersion";
    locala.GvH.put("brandListVersion", "TEXT");
    localStringBuilder.append(" brandListVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "brandListContent";
    locala.GvH.put("brandListContent", "TEXT");
    localStringBuilder.append(" brandListContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandFlag";
    locala.GvH.put("brandFlag", "INTEGER");
    localStringBuilder.append(" brandFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "extInfo";
    locala.GvH.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "brandInfo";
    locala.GvH.put("brandInfo", "TEXT");
    localStringBuilder.append(" brandInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "brandIconURL";
    locala.GvH.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "updateTime";
    locala.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "hadAlert";
    locala.GvH.put("hadAlert", "INTEGER");
    localStringBuilder.append(" hadAlert INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "acceptType";
    locala.GvH.put("acceptType", "INTEGER default '0' ");
    localStringBuilder.append(" acceptType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "type";
    locala.GvH.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "status";
    locala.GvH.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "enterpriseFather";
    locala.GvH.put("enterpriseFather", "TEXT");
    localStringBuilder.append(" enterpriseFather TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "kfWorkerId";
    locala.GvH.put("kfWorkerId", "TEXT");
    localStringBuilder.append(" kfWorkerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "specialType";
    locala.GvH.put("specialType", "INTEGER");
    localStringBuilder.append(" specialType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "attrSyncVersion";
    locala.GvH.put("attrSyncVersion", "TEXT");
    localStringBuilder.append(" attrSyncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "incrementUpdateTime";
    locala.GvH.put("incrementUpdateTime", "LONG");
    localStringBuilder.append(" incrementUpdateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[19] = "bitFlag";
    locala.GvH.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    cFn = 0;
    cFo = null;
    AppMethodBeat.o(116408);
  }
  
  private boolean hc(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  private void hd(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
  
  public final boolean IF()
  {
    return (this.field_brandFlag & 0x1) == 0;
  }
  
  public final boolean IG()
  {
    return (this.field_brandFlag & 0x4) != 0;
  }
  
  public final boolean IH()
  {
    AppMethodBeat.i(116390);
    if (System.currentTimeMillis() - this.field_updateTime > 86400000L)
    {
      AppMethodBeat.o(116390);
      return true;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    if (this.field_updateTime < localCalendar.getTimeInMillis())
    {
      AppMethodBeat.o(116390);
      return true;
    }
    AppMethodBeat.o(116390);
    return false;
  }
  
  public final void II()
  {
    AppMethodBeat.i(116391);
    bV(false);
    b localb = this.cFm;
    if (localb.cFq != null) {
      localb.cFF = localb.cFq.optInt("ConnectorMsgType");
    }
    this.field_acceptType = localb.cFF;
    this.field_type = bV(false).getServiceType();
    if (IP())
    {
      hd(1);
      AppMethodBeat.o(116391);
      return;
    }
    this.field_bitFlag &= 0xFFFFFFFE;
    AppMethodBeat.o(116391);
  }
  
  public final boolean IJ()
  {
    AppMethodBeat.i(116392);
    bV(false);
    ac.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[] { this.field_username, Boolean.valueOf(this.cFm.IJ()) });
    boolean bool = this.cFm.IJ();
    AppMethodBeat.o(116392);
    return bool;
  }
  
  public final boolean IK()
  {
    AppMethodBeat.i(116393);
    bV(false);
    if (this.field_type == 1)
    {
      AppMethodBeat.o(116393);
      return true;
    }
    AppMethodBeat.o(116393);
    return false;
  }
  
  public final boolean IL()
  {
    AppMethodBeat.i(116394);
    bV(false);
    if (this.field_type == 0)
    {
      AppMethodBeat.o(116394);
      return true;
    }
    AppMethodBeat.o(116394);
    return false;
  }
  
  public final boolean IM()
  {
    AppMethodBeat.i(116395);
    bV(false);
    if ((this.field_type == 2) || (this.field_type == 3))
    {
      AppMethodBeat.o(116395);
      return true;
    }
    AppMethodBeat.o(116395);
    return false;
  }
  
  public final boolean IN()
  {
    AppMethodBeat.i(116396);
    bV(false);
    if (this.field_type == 2)
    {
      AppMethodBeat.o(116396);
      return true;
    }
    AppMethodBeat.o(116396);
    return false;
  }
  
  public final boolean IO()
  {
    AppMethodBeat.i(116397);
    bV(false);
    if (this.field_type == 3)
    {
      AppMethodBeat.o(116397);
      return true;
    }
    AppMethodBeat.o(116397);
    return false;
  }
  
  public final boolean IP()
  {
    AppMethodBeat.i(116398);
    bV(false);
    boolean bool;
    if ((this.cFm != null) && (this.cFm.Jq() != null)) {
      if (this.cFm.cFC.cGe == 1)
      {
        bool = true;
        if ((bool) && (!hc(1)))
        {
          hd(1);
          ((o)g.ab(o.class)).a(this);
        }
        if (bool) {
          ac.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", new Object[] { this.field_username });
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(116398);
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public final boolean IQ()
  {
    AppMethodBeat.i(116399);
    bV(false);
    boolean bool;
    if ((this.cFm != null) && (this.cFm.Jq() != null)) {
      if (this.cFm.cFC.cGe == 2)
      {
        bool = true;
        if ((bool) && (!hc(2)))
        {
          hd(2);
          ((o)g.ab(o.class)).a(this);
        }
        if (bool) {
          ac.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", new Object[] { this.field_username });
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(116399);
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public final String IR()
  {
    AppMethodBeat.i(116400);
    bV(false);
    if (this.cFm != null)
    {
      Object localObject = this.cFm.Jq();
      if ((localObject != null) && (((c.b.c.a)localObject).cGf != null) && (!((c.b.c.a)localObject).cGf.isEmpty()))
      {
        localObject = ((c.b.c.a)localObject).cGf;
        AppMethodBeat.o(116400);
        return localObject;
      }
    }
    AppMethodBeat.o(116400);
    return null;
  }
  
  public final long IS()
  {
    AppMethodBeat.i(116401);
    bV(false);
    if (this.cFm != null)
    {
      c.b.c.a locala = this.cFm.Jq();
      if ((locala != null) && (locala.appid != 0L))
      {
        long l = locala.appid;
        AppMethodBeat.o(116401);
        return l;
      }
    }
    AppMethodBeat.o(116401);
    return 0L;
  }
  
  public final boolean IT()
  {
    AppMethodBeat.i(116402);
    bV(false);
    if (this.cFm == null)
    {
      ac.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (this.cFm.Jk() == null)
    {
      ac.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (!this.cFm.Jk().cGu)
    {
      AppMethodBeat.o(116402);
      return true;
    }
    AppMethodBeat.o(116402);
    return false;
  }
  
  public final String IU()
  {
    AppMethodBeat.i(116403);
    bV(false);
    if (this.cFm != null)
    {
      Object localObject = this.cFm.Jq();
      if (localObject != null)
      {
        localObject = ((c.b.c.a)localObject).cGg;
        AppMethodBeat.o(116403);
        return localObject;
      }
    }
    AppMethodBeat.o(116403);
    return null;
  }
  
  public final String IV()
  {
    AppMethodBeat.i(116404);
    try
    {
      String str1 = bV(false).Jq().cGc;
      if (bs.isNullOrNil(str1)) {
        ac.e("MicroMsg.BizInfo", "check father: %s, %s", new Object[] { this.field_username, str1 });
      }
      AppMethodBeat.o(116404);
      return str1;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        String str2 = "";
      }
    }
  }
  
  /* Error */
  public final List<a> IW()
  {
    // Byte code:
    //   0: ldc_w 416
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 418	com/tencent/mm/api/c:cFl	Ljava/util/List;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: getfield 418	com/tencent/mm/api/c:cFl	Ljava/util/List;
    //   17: astore_2
    //   18: ldc_w 416
    //   21: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_2
    //   25: areturn
    //   26: aload_0
    //   27: new 420	java/util/LinkedList
    //   30: dup
    //   31: invokespecial 421	java/util/LinkedList:<init>	()V
    //   34: putfield 418	com/tencent/mm/api/c:cFl	Ljava/util/List;
    //   37: aload_0
    //   38: getfield 424	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   41: ifnull +13 -> 54
    //   44: aload_0
    //   45: getfield 424	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   48: invokevirtual 427	java/lang/String:length	()I
    //   51: ifne +16 -> 67
    //   54: aload_0
    //   55: getfield 418	com/tencent/mm/api/c:cFl	Ljava/util/List;
    //   58: astore_2
    //   59: ldc_w 416
    //   62: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_2
    //   66: areturn
    //   67: new 267	org/json/JSONObject
    //   70: dup
    //   71: aload_0
    //   72: getfield 424	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   75: invokespecial 430	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   78: ldc_w 432
    //   81: invokevirtual 436	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   84: astore_2
    //   85: iconst_0
    //   86: istore_1
    //   87: iload_1
    //   88: aload_2
    //   89: invokevirtual 439	org/json/JSONArray:length	()I
    //   92: if_icmpge +105 -> 197
    //   95: new 6	com/tencent/mm/api/c$a
    //   98: dup
    //   99: invokespecial 440	com/tencent/mm/api/c$a:<init>	()V
    //   102: astore_3
    //   103: aload_2
    //   104: iload_1
    //   105: invokevirtual 444	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   108: astore 4
    //   110: aload_3
    //   111: aload 4
    //   113: ldc_w 446
    //   116: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putfield 452	com/tencent/mm/api/c$a:title	Ljava/lang/String;
    //   122: aload_3
    //   123: aload 4
    //   125: ldc_w 454
    //   128: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 456	com/tencent/mm/api/c$a:url	Ljava/lang/String;
    //   134: aload_3
    //   135: aload 4
    //   137: ldc_w 458
    //   140: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 461	com/tencent/mm/api/c$a:cFp	Ljava/lang/String;
    //   146: aload_3
    //   147: aload 4
    //   149: ldc_w 463
    //   152: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 465	com/tencent/mm/api/c$a:description	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 418	com/tencent/mm/api/c:cFl	Ljava/util/List;
    //   162: aload_3
    //   163: invokeinterface 471 2 0
    //   168: pop
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: goto -86 -> 87
    //   176: astore_2
    //   177: ldc_w 293
    //   180: ldc_w 473
    //   183: iconst_1
    //   184: anewarray 297	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: invokestatic 477	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 409	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_0
    //   198: getfield 418	com/tencent/mm/api/c:cFl	Ljava/util/List;
    //   201: astore_2
    //   202: ldc_w 416
    //   205: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_2
    //   209: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	c
    //   86	87	1	i	int
    //   17	87	2	localObject	Object
    //   176	14	2	localException	Exception
    //   201	8	2	localList	List
    //   102	61	3	locala	a
    //   108	40	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   67	85	176	java/lang/Exception
    //   87	169	176	java/lang/Exception
  }
  
  public final b bV(boolean paramBoolean)
  {
    AppMethodBeat.i(116389);
    if ((this.cFm == null) || (paramBoolean))
    {
      if ((bs.isNullOrNil(this.field_extInfo)) || (cFn != this.field_extInfo.hashCode())) {
        break label60;
      }
      this.cFm = cFo;
    }
    for (;;)
    {
      b localb = this.cFm;
      AppMethodBeat.o(116389);
      return localb;
      label60:
      localb = b.dC(this.field_extInfo);
      this.cFm = localb;
      cFo = localb;
      cFn = bs.nullAsNil(this.field_extInfo).hashCode();
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(116405);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(116405);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(116406);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(116406);
    return localContentValues;
  }
  
  public final com.tencent.mm.sdk.e.c.a getDBInfo()
  {
    return info;
  }
  
  public static final class a
  {
    public String cFp;
    public String description;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    private c cFA = null;
    private f cFB = null;
    c.b.c.a cFC = null;
    private boolean cFD = false;
    public boolean cFE = false;
    int cFF;
    public boolean cFG = false;
    public int cFH = 0;
    private int cFI = 0;
    private String cFJ;
    private c.b.b cFK = null;
    private int cFL = 0;
    private int cFM = c.cFj;
    private String cFN;
    private boolean cFO = false;
    private int cFP;
    private h cFQ;
    private String cFR;
    private String cFS;
    private boolean cFT = false;
    public c.b.a cFU;
    private List<WxaAttributes.WxaEntryInfo> cFV;
    public JSONObject cFq = null;
    private boolean cFr = true;
    public boolean cFs = false;
    private boolean cFt = false;
    public boolean cFu = false;
    private String cFv;
    private String cFw;
    private List<c.b.g> cFx = null;
    private e cFy = null;
    private c.b.d cFz = null;
    
    static b dC(String paramString)
    {
      AppMethodBeat.i(116387);
      b localb = new b();
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(116387);
        return localb;
      }
      try
      {
        System.currentTimeMillis();
        localb.cFq = new JSONObject(paramString);
        AppMethodBeat.o(116387);
        return localb;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ac.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bs.m(paramString) });
        }
      }
    }
    
    public final boolean IJ()
    {
      boolean bool = false;
      AppMethodBeat.i(116380);
      if (this.cFq != null)
      {
        if (bs.getInt(this.cFq.optString("ReportLocationType"), 0) > 0) {
          bool = true;
        }
        this.cFD = bool;
      }
      bool = this.cFD;
      AppMethodBeat.o(116380);
      return bool;
    }
    
    public final boolean IX()
    {
      AppMethodBeat.i(116366);
      if ((this.cFq != null) && (this.cFq.optJSONObject("WifiBizInfo") != null) && (this.cFq.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") == 1)) {
        this.cFT = true;
      }
      boolean bool = this.cFT;
      AppMethodBeat.o(116366);
      return bool;
    }
    
    public final boolean IY()
    {
      AppMethodBeat.i(116367);
      if (this.cFq != null) {
        this.cFt = "1".equals(this.cFq.optString("IsShowMember"));
      }
      boolean bool = this.cFt;
      AppMethodBeat.o(116367);
      return bool;
    }
    
    public final boolean IZ()
    {
      AppMethodBeat.i(116368);
      if (this.cFq != null) {
        this.cFM = bs.getInt(this.cFq.optString("NotifyManage"), c.cFj);
      }
      if (this.cFM == c.cFi)
      {
        AppMethodBeat.o(116368);
        return true;
      }
      AppMethodBeat.o(116368);
      return false;
    }
    
    public final String Ja()
    {
      AppMethodBeat.i(116369);
      if (this.cFq != null) {
        this.cFv = this.cFq.optString("VerifyContactPromptTitle");
      }
      String str = this.cFv;
      AppMethodBeat.o(116369);
      return str;
    }
    
    public final String Jb()
    {
      AppMethodBeat.i(116370);
      if (this.cFq != null) {
        this.cFR = this.cFq.optString("TrademarkUrl");
      }
      String str = this.cFR;
      AppMethodBeat.o(116370);
      return str;
    }
    
    public final String Jc()
    {
      AppMethodBeat.i(116371);
      if (this.cFq != null) {
        this.cFS = this.cFq.optString("TrademarkName");
      }
      String str = this.cFS;
      AppMethodBeat.o(116371);
      return str;
    }
    
    public final String Jd()
    {
      AppMethodBeat.i(116372);
      if (this.cFq != null) {
        this.cFw = this.cFq.optString("ConferenceContactExpireTime");
      }
      String str = this.cFw;
      AppMethodBeat.o(116372);
      return str;
    }
    
    public final List<c.b.g> Je()
    {
      AppMethodBeat.i(116373);
      if ((this.cFq != null) && (this.cFx == null)) {
        this.cFx = c.b.g.d(this.cFq.optJSONArray("Privilege"));
      }
      List localList = this.cFx;
      AppMethodBeat.o(116373);
      return localList;
    }
    
    public final int Jf()
    {
      AppMethodBeat.i(116374);
      if (this.cFq != null) {
        this.cFL = this.cFq.optInt("InteractiveMode");
      }
      int i = this.cFL;
      AppMethodBeat.o(116374);
      return i;
    }
    
    public final f Jg()
    {
      AppMethodBeat.i(116375);
      if ((this.cFq != null) && (this.cFB == null)) {
        this.cFB = f.dJ(this.cFq.optString("PayShowInfo"));
      }
      f localf = this.cFB;
      AppMethodBeat.o(116375);
      return localf;
    }
    
    public final c.b.b Jh()
    {
      AppMethodBeat.i(116376);
      if ((this.cFq != null) && (this.cFK == null))
      {
        localObject = this.cFq.optString("HardwareBizInfo");
        if (localObject != null) {
          this.cFK = c.b.b.dE((String)localObject);
        }
      }
      Object localObject = this.cFK;
      AppMethodBeat.o(116376);
      return localObject;
    }
    
    public final e Ji()
    {
      AppMethodBeat.i(116377);
      if ((this.cFq != null) && (this.cFy == null)) {
        this.cFy = e.dI(this.cFq.optString("VerifySource"));
      }
      e locale = this.cFy;
      AppMethodBeat.o(116377);
      return locale;
    }
    
    public final c.b.d Jj()
    {
      AppMethodBeat.i(116378);
      if ((this.cFq != null) && (this.cFz == null)) {
        this.cFz = c.b.d.dH(this.cFq.optString("PersonVerifyInfo"));
      }
      c.b.d locald = this.cFz;
      AppMethodBeat.o(116378);
      return locald;
    }
    
    public final h Jk()
    {
      AppMethodBeat.i(116379);
      if ((this.cFq != null) && (this.cFQ == null))
      {
        localObject = this.cFq.optString("RegisterSource");
        if (localObject != null) {
          this.cFQ = h.dK((String)localObject);
        }
      }
      Object localObject = this.cFQ;
      AppMethodBeat.o(116379);
      return localObject;
    }
    
    public final boolean Jl()
    {
      boolean bool = true;
      AppMethodBeat.i(116381);
      if (this.cFq != null) {
        if (bs.getInt(this.cFq.optString("IsTrademarkProtection"), 0) != 1) {
          break label51;
        }
      }
      for (;;)
      {
        this.cFO = bool;
        bool = this.cFO;
        AppMethodBeat.o(116381);
        return bool;
        label51:
        bool = false;
      }
    }
    
    public final String Jm()
    {
      AppMethodBeat.i(116383);
      if (this.cFq != null) {
        this.cFJ = this.cFq.optString("SupportEmoticonLinkPrefix");
      }
      String str = this.cFJ;
      AppMethodBeat.o(116383);
      return str;
    }
    
    public final c Jn()
    {
      AppMethodBeat.i(116384);
      if ((this.cFq != null) && (this.cFA == null))
      {
        localObject = this.cFq.optString("MMBizMenu");
        if (localObject != null) {
          this.cFA = c.dF((String)localObject);
        }
      }
      Object localObject = this.cFA;
      AppMethodBeat.o(116384);
      return localObject;
    }
    
    public final String Jo()
    {
      AppMethodBeat.i(116385);
      if (this.cFq != null) {
        this.cFN = this.cFq.optString("ServicePhone");
      }
      String str = this.cFN;
      AppMethodBeat.o(116385);
      return str;
    }
    
    public final boolean Jp()
    {
      AppMethodBeat.i(116386);
      if (this.cFq != null) {
        this.cFP = this.cFq.optInt("FunctionFlag");
      }
      if ((this.cFP & c.cFk) > 0)
      {
        AppMethodBeat.o(116386);
        return true;
      }
      AppMethodBeat.o(116386);
      return false;
    }
    
    public final c.b.c.a Jq()
    {
      AppMethodBeat.i(116388);
      if ((this.cFq != null) && (this.cFC == null))
      {
        localObject = this.cFq.optString("EnterpriseBizInfo");
        if (localObject != null) {
          this.cFC = c.b.c.a.dG((String)localObject);
        }
      }
      Object localObject = this.cFC;
      AppMethodBeat.o(116388);
      return localObject;
    }
    
    public final int getServiceType()
    {
      AppMethodBeat.i(116382);
      if (this.cFq != null) {
        this.cFI = this.cFq.optInt("ServiceType", 0);
      }
      int i = this.cFI;
      AppMethodBeat.o(116382);
      return i;
    }
    
    public final List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
    {
      AppMethodBeat.i(116365);
      Object localObject1;
      if (this.cFV == null)
      {
        this.cFV = new LinkedList();
        if (this.cFq != null)
        {
          localObject1 = this.cFq.optString("BindWxaInfo");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          if (localObject1 == null) {
            break label232;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("wxaEntryInfo");
          if (localObject1 == null) {
            break label219;
          }
          int i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break label219;
          }
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject2 != null)
          {
            String str1 = ((JSONObject)localObject2).optString("username");
            String str2 = ((JSONObject)localObject2).optString("title");
            String str3 = ((JSONObject)localObject2).optString("title_key");
            localObject2 = ((JSONObject)localObject2).optString("icon_url");
            if ((!TextUtils.isEmpty(str1)) && ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3))))
            {
              WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
              localWxaEntryInfo.username = str1;
              localWxaEntryInfo.title = str2;
              localWxaEntryInfo.jFJ = str3;
              localWxaEntryInfo.iconUrl = ((String)localObject2);
              this.cFV.add(localWxaEntryInfo);
            }
          }
          i += 1;
          continue;
          localList = null;
        }
        catch (JSONException localJSONException) {}
        continue;
        label219:
        List localList = this.cFV;
        AppMethodBeat.o(116365);
        return localList;
        label232:
        localList = null;
      }
    }
    
    public static final class c
    {
      public int cGa;
      public List<j> cGb = null;
      public int type;
      
      public static c dF(String paramString)
      {
        AppMethodBeat.i(116359);
        ac.i("MicroMsg.BizInfo", "MenuInfo = ".concat(String.valueOf(paramString)));
        c localc = new c();
        if ((paramString == null) || (paramString.length() <= 0))
        {
          AppMethodBeat.o(116359);
          return localc;
        }
        try
        {
          paramString = new JSONObject(paramString);
          localc.cGa = paramString.optInt("update_time");
          localc.type = paramString.optInt("type", 0);
          localc.cGb = j.e(paramString.optJSONArray("button_list"));
          AppMethodBeat.o(116359);
          return localc;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            ac.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bs.m(paramString) });
          }
        }
      }
      
      public static final class a
      {
        public long appid = 0L;
        public String cGc;
        public String cGd;
        public int cGe;
        public String cGf;
        public String cGg;
        
        public static a dG(String paramString)
        {
          AppMethodBeat.i(116358);
          ac.i("MicroMsg.BizInfo", "EnterpriseBizInfo = ".concat(String.valueOf(paramString)));
          a locala = new a();
          if ((paramString == null) || (paramString.length() <= 0))
          {
            AppMethodBeat.o(116358);
            return locala;
          }
          try
          {
            paramString = new JSONObject(paramString);
            locala.cGc = paramString.optString("belong");
            locala.cGd = paramString.optString("freeze_wording");
            locala.cGe = paramString.optInt("child_type");
            locala.cGf = paramString.optString("home_url");
            paramString = paramString.optString("exattr");
            if (bs.isNullOrNil(paramString)) {
              locala.cGg = null;
            }
            for (;;)
            {
              AppMethodBeat.o(116358);
              return locala;
              paramString = new JSONObject(paramString);
              locala.cGg = paramString.optString("chat_extension_url");
              locala.appid = paramString.optLong("app_id");
            }
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              ac.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bs.m(paramString) });
            }
          }
        }
      }
    }
    
    public static final class e
    {
      public int cGi = 0;
      public String cGj;
      public String cGk;
      public String cGl;
      public String cGm;
      
      public static e dI(String paramString)
      {
        AppMethodBeat.i(116361);
        if (bs.isNullOrNil(paramString))
        {
          AppMethodBeat.o(116361);
          return null;
        }
        ac.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[] { paramString });
        e locale = new e();
        try
        {
          paramString = new JSONObject(paramString);
          locale.cGi = paramString.optInt("Type");
          locale.cGj = paramString.optString("Description");
          locale.cGk = paramString.optString("Name");
          locale.cGl = paramString.optString("IntroUrl");
          locale.cGm = paramString.optString("VerifySubTitle");
          ac.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[] { Integer.valueOf(locale.cGi), locale.cGj, locale.cGk, locale.cGl });
          AppMethodBeat.o(116361);
          return locale;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ac.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bs.m(paramString) });
          }
        }
      }
    }
    
    public static final class f
    {
      public int cGn;
      public String cGo;
      public List<String> cGp;
      public String cGq;
      
      public static f dJ(String paramString)
      {
        AppMethodBeat.i(116362);
        if (bs.isNullOrNil(paramString))
        {
          AppMethodBeat.o(116362);
          return null;
        }
        try
        {
          f localf = new f();
          paramString = new JSONObject(paramString);
          localf.cGn = paramString.optInt("reputation_level", -1);
          localf.cGo = paramString.optString("scope_of_business");
          localf.cGq = paramString.optString("guarantee_detail_h5_url");
          paramString = paramString.optJSONArray("guarantee_info");
          if (paramString != null)
          {
            int j = paramString.length();
            if (j > 0)
            {
              localf.cGp = new ArrayList();
              int i = 0;
              while (i < j)
              {
                String str = paramString.getString(i);
                if (!bs.isNullOrNil(str)) {
                  localf.cGp.add(str);
                }
                i += 1;
              }
            }
          }
          AppMethodBeat.o(116362);
          return localf;
        }
        catch (Exception paramString)
        {
          ac.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bs.m(paramString) });
          AppMethodBeat.o(116362);
        }
        return null;
      }
    }
    
    public static final class h
    {
      public String cGs;
      public String cGt;
      public boolean cGu;
      public String cGv;
      
      public static h dK(String paramString)
      {
        AppMethodBeat.i(116364);
        ac.i("MicroMsg.BizInfo", "RegisterSource = %s", new Object[] { paramString });
        h localh = new h();
        if ((paramString == null) || (paramString.length() <= 0))
        {
          AppMethodBeat.o(116364);
          return localh;
        }
        for (;;)
        {
          try
          {
            paramString = new JSONObject(paramString);
            localh.cGs = paramString.optString("RegisterBody");
            localh.cGt = paramString.optString("IntroUrl");
            if (paramString.optInt("IsClose", 0) != 1) {
              continue;
            }
            bool = true;
            localh.cGu = bool;
            localh.cGv = paramString.optString("AboutBizUrl");
          }
          catch (JSONException paramString)
          {
            boolean bool;
            ac.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", new Object[] { bs.m(paramString) });
            continue;
          }
          AppMethodBeat.o(116364);
          return localh;
          bool = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.c
 * JD-Core Version:    0.7.0.1
 */