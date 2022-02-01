package com.tencent.mm.api;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.k;
import com.tencent.mm.g.c.ak;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public static int cQX;
  public static int cQY;
  public static int cQZ;
  private static int cRc;
  private static b cRd;
  public static com.tencent.mm.sdk.e.c.a info;
  private List<a> cRa;
  public b cRb;
  
  static
  {
    AppMethodBeat.i(116408);
    cQX = 1;
    cQY = 0;
    cQZ = 1;
    com.tencent.mm.sdk.e.c.a locala = new com.tencent.mm.sdk.e.c.a();
    locala.IBL = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IBN.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "username";
    locala.columns[1] = "appId";
    locala.IBN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandList";
    locala.IBN.put("brandList", "TEXT default '' ");
    localStringBuilder.append(" brandList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "brandListVersion";
    locala.IBN.put("brandListVersion", "TEXT");
    localStringBuilder.append(" brandListVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "brandListContent";
    locala.IBN.put("brandListContent", "TEXT");
    localStringBuilder.append(" brandListContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandFlag";
    locala.IBN.put("brandFlag", "INTEGER");
    localStringBuilder.append(" brandFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "extInfo";
    locala.IBN.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "brandInfo";
    locala.IBN.put("brandInfo", "TEXT");
    localStringBuilder.append(" brandInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "brandIconURL";
    locala.IBN.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "hadAlert";
    locala.IBN.put("hadAlert", "INTEGER");
    localStringBuilder.append(" hadAlert INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "acceptType";
    locala.IBN.put("acceptType", "INTEGER default '0' ");
    localStringBuilder.append(" acceptType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "type";
    locala.IBN.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "status";
    locala.IBN.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "enterpriseFather";
    locala.IBN.put("enterpriseFather", "TEXT");
    localStringBuilder.append(" enterpriseFather TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "kfWorkerId";
    locala.IBN.put("kfWorkerId", "TEXT");
    localStringBuilder.append(" kfWorkerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "specialType";
    locala.IBN.put("specialType", "INTEGER");
    localStringBuilder.append(" specialType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "attrSyncVersion";
    locala.IBN.put("attrSyncVersion", "TEXT");
    localStringBuilder.append(" attrSyncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "incrementUpdateTime";
    locala.IBN.put("incrementUpdateTime", "LONG");
    localStringBuilder.append(" incrementUpdateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[19] = "bitFlag";
    locala.IBN.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    cRc = 0;
    cRd = null;
    AppMethodBeat.o(116408);
  }
  
  private boolean hk(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  private void hl(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
  
  public final long KA()
  {
    AppMethodBeat.i(116401);
    bX(false);
    if (this.cRb != null)
    {
      c.b.c.a locala = this.cRb.KX();
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
  
  public final boolean KB()
  {
    AppMethodBeat.i(116402);
    bX(false);
    if (this.cRb == null)
    {
      ae.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (this.cRb.KR() == null)
    {
      ae.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (!this.cRb.KR().cSi)
    {
      AppMethodBeat.o(116402);
      return true;
    }
    AppMethodBeat.o(116402);
    return false;
  }
  
  public final String KC()
  {
    AppMethodBeat.i(116403);
    bX(false);
    if (this.cRb != null)
    {
      Object localObject = this.cRb.KX();
      if (localObject != null)
      {
        localObject = ((c.b.c.a)localObject).cRV;
        AppMethodBeat.o(116403);
        return localObject;
      }
    }
    AppMethodBeat.o(116403);
    return null;
  }
  
  public final String KD()
  {
    AppMethodBeat.i(116404);
    try
    {
      String str1 = bX(false).KX().cRR;
      if (bu.isNullOrNil(str1)) {
        ae.e("MicroMsg.BizInfo", "check father: %s, %s", new Object[] { this.field_username, str1 });
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
  public final List<a> KE()
  {
    // Byte code:
    //   0: ldc_w 294
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 296	com/tencent/mm/api/c:cRa	Ljava/util/List;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: getfield 296	com/tencent/mm/api/c:cRa	Ljava/util/List;
    //   17: astore_2
    //   18: ldc_w 294
    //   21: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_2
    //   25: areturn
    //   26: aload_0
    //   27: new 298	java/util/LinkedList
    //   30: dup
    //   31: invokespecial 299	java/util/LinkedList:<init>	()V
    //   34: putfield 296	com/tencent/mm/api/c:cRa	Ljava/util/List;
    //   37: aload_0
    //   38: getfield 302	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   41: ifnull +13 -> 54
    //   44: aload_0
    //   45: getfield 302	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   48: invokevirtual 306	java/lang/String:length	()I
    //   51: ifne +16 -> 67
    //   54: aload_0
    //   55: getfield 296	com/tencent/mm/api/c:cRa	Ljava/util/List;
    //   58: astore_2
    //   59: ldc_w 294
    //   62: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_2
    //   66: areturn
    //   67: new 308	org/json/JSONObject
    //   70: dup
    //   71: aload_0
    //   72: getfield 302	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   75: invokespecial 311	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   78: ldc_w 313
    //   81: invokevirtual 317	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   84: astore_2
    //   85: iconst_0
    //   86: istore_1
    //   87: iload_1
    //   88: aload_2
    //   89: invokevirtual 320	org/json/JSONArray:length	()I
    //   92: if_icmpge +104 -> 196
    //   95: new 6	com/tencent/mm/api/c$a
    //   98: dup
    //   99: invokespecial 321	com/tencent/mm/api/c$a:<init>	()V
    //   102: astore_3
    //   103: aload_2
    //   104: iload_1
    //   105: invokevirtual 325	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   108: astore 4
    //   110: aload_3
    //   111: aload 4
    //   113: ldc_w 327
    //   116: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putfield 333	com/tencent/mm/api/c$a:title	Ljava/lang/String;
    //   122: aload_3
    //   123: aload 4
    //   125: ldc_w 335
    //   128: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 337	com/tencent/mm/api/c$a:url	Ljava/lang/String;
    //   134: aload_3
    //   135: aload 4
    //   137: ldc_w 339
    //   140: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 342	com/tencent/mm/api/c$a:cRe	Ljava/lang/String;
    //   146: aload_3
    //   147: aload 4
    //   149: ldc_w 344
    //   152: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 346	com/tencent/mm/api/c$a:description	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 296	com/tencent/mm/api/c:cRa	Ljava/util/List;
    //   162: aload_3
    //   163: invokeinterface 352 2 0
    //   168: pop
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: goto -86 -> 87
    //   176: astore_2
    //   177: ldc 242
    //   179: ldc_w 354
    //   182: iconst_1
    //   183: anewarray 281	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload_2
    //   189: invokestatic 357	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 287	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_0
    //   197: getfield 296	com/tencent/mm/api/c:cRa	Ljava/util/List;
    //   200: astore_2
    //   201: ldc_w 294
    //   204: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_2
    //   208: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	c
    //   86	87	1	i	int
    //   17	87	2	localObject	Object
    //   176	13	2	localException	Exception
    //   200	8	2	localList	List
    //   102	61	3	locala	a
    //   108	40	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   67	85	176	java/lang/Exception
    //   87	169	176	java/lang/Exception
  }
  
  public final boolean Kn()
  {
    return (this.field_brandFlag & 0x1) == 0;
  }
  
  public final boolean Ko()
  {
    return (this.field_brandFlag & 0x4) != 0;
  }
  
  public final boolean Kp()
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
  
  public final void Kq()
  {
    AppMethodBeat.i(116391);
    bX(false);
    b localb = this.cRb;
    if (localb.cRf != null) {
      localb.cRu = localb.cRf.optInt("ConnectorMsgType");
    }
    this.field_acceptType = localb.cRu;
    this.field_type = bX(false).getServiceType();
    if (Kx())
    {
      hl(1);
      AppMethodBeat.o(116391);
      return;
    }
    this.field_bitFlag &= 0xFFFFFFFE;
    AppMethodBeat.o(116391);
  }
  
  public final boolean Kr()
  {
    AppMethodBeat.i(116392);
    bX(false);
    ae.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[] { this.field_username, Boolean.valueOf(this.cRb.Kr()) });
    boolean bool = this.cRb.Kr();
    AppMethodBeat.o(116392);
    return bool;
  }
  
  public final boolean Ks()
  {
    AppMethodBeat.i(116393);
    bX(false);
    if (this.field_type == 1)
    {
      AppMethodBeat.o(116393);
      return true;
    }
    AppMethodBeat.o(116393);
    return false;
  }
  
  public final boolean Kt()
  {
    AppMethodBeat.i(116394);
    bX(false);
    if (this.field_type == 0)
    {
      AppMethodBeat.o(116394);
      return true;
    }
    AppMethodBeat.o(116394);
    return false;
  }
  
  public final boolean Ku()
  {
    AppMethodBeat.i(116395);
    bX(false);
    if ((this.field_type == 2) || (this.field_type == 3))
    {
      AppMethodBeat.o(116395);
      return true;
    }
    AppMethodBeat.o(116395);
    return false;
  }
  
  public final boolean Kv()
  {
    AppMethodBeat.i(116396);
    bX(false);
    if (this.field_type == 2)
    {
      AppMethodBeat.o(116396);
      return true;
    }
    AppMethodBeat.o(116396);
    return false;
  }
  
  public final boolean Kw()
  {
    AppMethodBeat.i(116397);
    bX(false);
    if (this.field_type == 3)
    {
      AppMethodBeat.o(116397);
      return true;
    }
    AppMethodBeat.o(116397);
    return false;
  }
  
  public final boolean Kx()
  {
    AppMethodBeat.i(116398);
    bX(false);
    boolean bool;
    if ((this.cRb != null) && (this.cRb.KX() != null)) {
      if (this.cRb.cRr.cRT == 1)
      {
        bool = true;
        if ((bool) && (!hk(1)))
        {
          hl(1);
          ((o)g.ab(o.class)).a(this);
        }
        if (bool) {
          ae.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", new Object[] { this.field_username });
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
  
  public final boolean Ky()
  {
    AppMethodBeat.i(116399);
    bX(false);
    boolean bool;
    if ((this.cRb != null) && (this.cRb.KX() != null)) {
      if (this.cRb.cRr.cRT == 2)
      {
        bool = true;
        if ((bool) && (!hk(2)))
        {
          hl(2);
          ((o)g.ab(o.class)).a(this);
        }
        if (bool) {
          ae.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", new Object[] { this.field_username });
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
  
  public final String Kz()
  {
    AppMethodBeat.i(116400);
    bX(false);
    if (this.cRb != null)
    {
      Object localObject = this.cRb.KX();
      if ((localObject != null) && (((c.b.c.a)localObject).cRU != null) && (!((c.b.c.a)localObject).cRU.isEmpty()))
      {
        localObject = ((c.b.c.a)localObject).cRU;
        AppMethodBeat.o(116400);
        return localObject;
      }
    }
    AppMethodBeat.o(116400);
    return null;
  }
  
  public final b bX(boolean paramBoolean)
  {
    AppMethodBeat.i(116389);
    if ((this.cRb == null) || (paramBoolean))
    {
      if ((bu.isNullOrNil(this.field_extInfo)) || (cRc != this.field_extInfo.hashCode())) {
        break label60;
      }
      this.cRb = cRd;
    }
    for (;;)
    {
      b localb = this.cRb;
      AppMethodBeat.o(116389);
      return localb;
      label60:
      localb = b.eD(this.field_extInfo);
      this.cRb = localb;
      cRd = localb;
      cRc = bu.nullAsNil(this.field_extInfo).hashCode();
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
    public String cRe;
    public String description;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    private int cRA = 0;
    private int cRB = c.cQY;
    private String cRC;
    private boolean cRD = false;
    private int cRE;
    private h cRF;
    private String cRG;
    private String cRH;
    private boolean cRI = false;
    public c.b.a cRJ;
    private List<WxaAttributes.WxaEntryInfo> cRK;
    public JSONObject cRf = null;
    private boolean cRg = true;
    public boolean cRh = false;
    private boolean cRi = false;
    public boolean cRj = false;
    private String cRk;
    private String cRl;
    private List<g> cRm = null;
    private e cRn = null;
    private d cRo = null;
    private c cRp = null;
    private f cRq = null;
    c.b.c.a cRr = null;
    private boolean cRs = false;
    public boolean cRt = false;
    int cRu;
    public boolean cRv = false;
    public int cRw = 0;
    private int cRx = 0;
    private String cRy;
    private c.b.b cRz = null;
    
    static b eD(String paramString)
    {
      AppMethodBeat.i(116387);
      b localb = new b();
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(116387);
        return localb;
      }
      try
      {
        System.currentTimeMillis();
        localb.cRf = new JSONObject(paramString);
        AppMethodBeat.o(116387);
        return localb;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ae.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bu.o(paramString) });
        }
      }
    }
    
    public final boolean KF()
    {
      AppMethodBeat.i(116366);
      if ((this.cRf != null) && (this.cRf.optJSONObject("WifiBizInfo") != null) && (this.cRf.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") == 1)) {
        this.cRI = true;
      }
      boolean bool = this.cRI;
      AppMethodBeat.o(116366);
      return bool;
    }
    
    public final boolean KG()
    {
      AppMethodBeat.i(116367);
      if (this.cRf != null) {
        this.cRi = "1".equals(this.cRf.optString("IsShowMember"));
      }
      boolean bool = this.cRi;
      AppMethodBeat.o(116367);
      return bool;
    }
    
    public final boolean KH()
    {
      AppMethodBeat.i(116368);
      if (this.cRf != null) {
        this.cRB = bu.getInt(this.cRf.optString("NotifyManage"), c.cQY);
      }
      if (this.cRB == c.cQX)
      {
        AppMethodBeat.o(116368);
        return true;
      }
      AppMethodBeat.o(116368);
      return false;
    }
    
    public final String KI()
    {
      AppMethodBeat.i(116369);
      if (this.cRf != null) {
        this.cRk = this.cRf.optString("VerifyContactPromptTitle");
      }
      String str = this.cRk;
      AppMethodBeat.o(116369);
      return str;
    }
    
    public final String KJ()
    {
      AppMethodBeat.i(116370);
      if (this.cRf != null) {
        this.cRG = this.cRf.optString("TrademarkUrl");
      }
      String str = this.cRG;
      AppMethodBeat.o(116370);
      return str;
    }
    
    public final String KK()
    {
      AppMethodBeat.i(116371);
      if (this.cRf != null) {
        this.cRH = this.cRf.optString("TrademarkName");
      }
      String str = this.cRH;
      AppMethodBeat.o(116371);
      return str;
    }
    
    public final String KL()
    {
      AppMethodBeat.i(116372);
      if (this.cRf != null) {
        this.cRl = this.cRf.optString("ConferenceContactExpireTime");
      }
      String str = this.cRl;
      AppMethodBeat.o(116372);
      return str;
    }
    
    public final List<g> KM()
    {
      AppMethodBeat.i(116373);
      if ((this.cRf != null) && (this.cRm == null)) {
        this.cRm = g.d(this.cRf.optJSONArray("Privilege"));
      }
      List localList = this.cRm;
      AppMethodBeat.o(116373);
      return localList;
    }
    
    public final int KN()
    {
      AppMethodBeat.i(116374);
      if (this.cRf != null) {
        this.cRA = this.cRf.optInt("InteractiveMode");
      }
      int i = this.cRA;
      AppMethodBeat.o(116374);
      return i;
    }
    
    public final f KO()
    {
      AppMethodBeat.i(116375);
      if ((this.cRf != null) && (this.cRq == null)) {
        this.cRq = f.eJ(this.cRf.optString("PayShowInfo"));
      }
      f localf = this.cRq;
      AppMethodBeat.o(116375);
      return localf;
    }
    
    public final c.b.b KP()
    {
      AppMethodBeat.i(116376);
      if ((this.cRf != null) && (this.cRz == null))
      {
        localObject = this.cRf.optString("HardwareBizInfo");
        if (localObject != null) {
          this.cRz = c.b.b.eF((String)localObject);
        }
      }
      Object localObject = this.cRz;
      AppMethodBeat.o(116376);
      return localObject;
    }
    
    public final e KQ()
    {
      AppMethodBeat.i(116377);
      if ((this.cRf != null) && (this.cRn == null)) {
        this.cRn = e.eI(this.cRf.optString("VerifySource"));
      }
      e locale = this.cRn;
      AppMethodBeat.o(116377);
      return locale;
    }
    
    public final h KR()
    {
      AppMethodBeat.i(116379);
      if ((this.cRf != null) && (this.cRF == null))
      {
        localObject = this.cRf.optString("RegisterSource");
        if (localObject != null) {
          this.cRF = h.eK((String)localObject);
        }
      }
      Object localObject = this.cRF;
      AppMethodBeat.o(116379);
      return localObject;
    }
    
    public final boolean KS()
    {
      boolean bool = true;
      AppMethodBeat.i(116381);
      if (this.cRf != null) {
        if (bu.getInt(this.cRf.optString("IsTrademarkProtection"), 0) != 1) {
          break label51;
        }
      }
      for (;;)
      {
        this.cRD = bool;
        bool = this.cRD;
        AppMethodBeat.o(116381);
        return bool;
        label51:
        bool = false;
      }
    }
    
    public final String KT()
    {
      AppMethodBeat.i(116383);
      if (this.cRf != null) {
        this.cRy = this.cRf.optString("SupportEmoticonLinkPrefix");
      }
      String str = this.cRy;
      AppMethodBeat.o(116383);
      return str;
    }
    
    public final c KU()
    {
      AppMethodBeat.i(116384);
      if ((this.cRf != null) && (this.cRp == null))
      {
        localObject = this.cRf.optString("MMBizMenu");
        if (localObject != null) {
          this.cRp = c.eG((String)localObject);
        }
      }
      Object localObject = this.cRp;
      AppMethodBeat.o(116384);
      return localObject;
    }
    
    public final String KV()
    {
      AppMethodBeat.i(116385);
      if (this.cRf != null) {
        this.cRC = this.cRf.optString("ServicePhone");
      }
      String str = this.cRC;
      AppMethodBeat.o(116385);
      return str;
    }
    
    public final boolean KW()
    {
      AppMethodBeat.i(116386);
      if (this.cRf != null) {
        this.cRE = this.cRf.optInt("FunctionFlag");
      }
      if ((this.cRE & c.cQZ) > 0)
      {
        AppMethodBeat.o(116386);
        return true;
      }
      AppMethodBeat.o(116386);
      return false;
    }
    
    public final c.b.c.a KX()
    {
      AppMethodBeat.i(116388);
      if ((this.cRf != null) && (this.cRr == null))
      {
        localObject = this.cRf.optString("EnterpriseBizInfo");
        if (localObject != null) {
          this.cRr = c.b.c.a.eH((String)localObject);
        }
      }
      Object localObject = this.cRr;
      AppMethodBeat.o(116388);
      return localObject;
    }
    
    public final boolean Kr()
    {
      boolean bool = false;
      AppMethodBeat.i(116380);
      if (this.cRf != null)
      {
        if (bu.getInt(this.cRf.optString("ReportLocationType"), 0) > 0) {
          bool = true;
        }
        this.cRs = bool;
      }
      bool = this.cRs;
      AppMethodBeat.o(116380);
      return bool;
    }
    
    public final int getServiceType()
    {
      AppMethodBeat.i(116382);
      if (this.cRf != null) {
        this.cRx = this.cRf.optInt("ServiceType", 0);
      }
      int i = this.cRx;
      AppMethodBeat.o(116382);
      return i;
    }
    
    public final List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
    {
      AppMethodBeat.i(116365);
      Object localObject1;
      if (this.cRK == null)
      {
        this.cRK = new LinkedList();
        if (this.cRf != null)
        {
          localObject1 = this.cRf.optString("BindWxaInfo");
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
              localWxaEntryInfo.kdj = str3;
              localWxaEntryInfo.iconUrl = ((String)localObject2);
              this.cRK.add(localWxaEntryInfo);
            }
          }
          i += 1;
          continue;
          localList = null;
        }
        catch (JSONException localJSONException) {}
        continue;
        label219:
        List localList = this.cRK;
        AppMethodBeat.o(116365);
        return localList;
        label232:
        localList = null;
      }
    }
    
    public static final class c
    {
      public int cRP;
      public List<k> cRQ = null;
      public int type;
      
      public static c eG(String paramString)
      {
        AppMethodBeat.i(116359);
        ae.i("MicroMsg.BizInfo", "MenuInfo = ".concat(String.valueOf(paramString)));
        c localc = new c();
        if ((paramString == null) || (paramString.length() <= 0))
        {
          AppMethodBeat.o(116359);
          return localc;
        }
        try
        {
          paramString = new JSONObject(paramString);
          localc.cRP = paramString.optInt("update_time");
          localc.type = paramString.optInt("type", 0);
          localc.cRQ = k.e(paramString.optJSONArray("button_list"));
          AppMethodBeat.o(116359);
          return localc;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            ae.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bu.o(paramString) });
          }
        }
      }
      
      public static final class a
      {
        public long appid = 0L;
        public String cRR;
        public String cRS;
        public int cRT;
        public String cRU;
        public String cRV;
        
        public static a eH(String paramString)
        {
          AppMethodBeat.i(116358);
          ae.i("MicroMsg.BizInfo", "EnterpriseBizInfo = ".concat(String.valueOf(paramString)));
          a locala = new a();
          if ((paramString == null) || (paramString.length() <= 0))
          {
            AppMethodBeat.o(116358);
            return locala;
          }
          try
          {
            paramString = new JSONObject(paramString);
            locala.cRR = paramString.optString("belong");
            locala.cRS = paramString.optString("freeze_wording");
            locala.cRT = paramString.optInt("child_type");
            locala.cRU = paramString.optString("home_url");
            paramString = paramString.optString("exattr");
            if (bu.isNullOrNil(paramString)) {
              locala.cRV = null;
            }
            for (;;)
            {
              AppMethodBeat.o(116358);
              return locala;
              paramString = new JSONObject(paramString);
              locala.cRV = paramString.optString("chat_extension_url");
              locala.appid = paramString.optLong("app_id");
            }
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              ae.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bu.o(paramString) });
            }
          }
        }
      }
    }
    
    public static final class d {}
    
    public static final class e
    {
      public int cRW = 0;
      public String cRX;
      public String cRY;
      public String cRZ;
      public String cSa;
      
      public static e eI(String paramString)
      {
        AppMethodBeat.i(116361);
        if (bu.isNullOrNil(paramString))
        {
          AppMethodBeat.o(116361);
          return null;
        }
        ae.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[] { paramString });
        e locale = new e();
        try
        {
          paramString = new JSONObject(paramString);
          locale.cRW = paramString.optInt("Type");
          locale.cRX = paramString.optString("Description");
          locale.cRY = paramString.optString("Name");
          locale.cRZ = paramString.optString("IntroUrl");
          locale.cSa = paramString.optString("VerifySubTitle");
          ae.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[] { Integer.valueOf(locale.cRW), locale.cRX, locale.cRY, locale.cRZ });
          AppMethodBeat.o(116361);
          return locale;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ae.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bu.o(paramString) });
          }
        }
      }
    }
    
    public static final class f
    {
      public int cSb;
      public String cSc;
      public List<String> cSd;
      public String cSe;
      
      public static f eJ(String paramString)
      {
        AppMethodBeat.i(116362);
        if (bu.isNullOrNil(paramString))
        {
          AppMethodBeat.o(116362);
          return null;
        }
        try
        {
          f localf = new f();
          paramString = new JSONObject(paramString);
          localf.cSb = paramString.optInt("reputation_level", -1);
          localf.cSc = paramString.optString("scope_of_business");
          localf.cSe = paramString.optString("guarantee_detail_h5_url");
          paramString = paramString.optJSONArray("guarantee_info");
          if (paramString != null)
          {
            int j = paramString.length();
            if (j > 0)
            {
              localf.cSd = new ArrayList();
              int i = 0;
              while (i < j)
              {
                String str = paramString.getString(i);
                if (!bu.isNullOrNil(str)) {
                  localf.cSd.add(str);
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
          ae.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bu.o(paramString) });
          AppMethodBeat.o(116362);
        }
        return null;
      }
    }
    
    public static final class g
    {
      public String cSf;
      public String description;
      public String iconUrl;
      
      public static List<g> d(JSONArray paramJSONArray)
      {
        AppMethodBeat.i(116363);
        localLinkedList = new LinkedList();
        if (paramJSONArray == null)
        {
          AppMethodBeat.o(116363);
          return localLinkedList;
        }
        try
        {
          int j = paramJSONArray.length();
          int i = 0;
          while (i < j)
          {
            g localg = new g();
            JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
            localg.iconUrl = localJSONObject.optString("icon");
            localg.description = localJSONObject.optString("description");
            localg.cSf = localJSONObject.optString("description_key");
            localLinkedList.add(localg);
            i += 1;
          }
          return localLinkedList;
        }
        catch (Exception paramJSONArray)
        {
          ae.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bu.o(paramJSONArray) });
          AppMethodBeat.o(116363);
        }
      }
    }
    
    public static final class h
    {
      public String cSg;
      public String cSh;
      public boolean cSi;
      public String cSj;
      
      public static h eK(String paramString)
      {
        AppMethodBeat.i(116364);
        ae.i("MicroMsg.BizInfo", "RegisterSource = %s", new Object[] { paramString });
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
            localh.cSg = paramString.optString("RegisterBody");
            localh.cSh = paramString.optString("IntroUrl");
            if (paramString.optInt("IsClose", 0) != 1) {
              continue;
            }
            bool = true;
            localh.cSi = bool;
            localh.cSj = paramString.optString("AboutBizUrl");
          }
          catch (JSONException paramString)
          {
            boolean bool;
            ae.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", new Object[] { bu.o(paramString) });
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