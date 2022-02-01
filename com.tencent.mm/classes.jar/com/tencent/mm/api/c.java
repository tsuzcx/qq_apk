package com.tencent.mm.api;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.k;
import com.tencent.mm.g.c.ak;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public static int cQn;
  public static int cQo;
  public static int cQp;
  private static int cQs;
  private static b cQt;
  public static com.tencent.mm.sdk.e.c.a info;
  private List<a> cQq;
  public b cQr;
  
  static
  {
    AppMethodBeat.i(116408);
    cQn = 1;
    cQo = 0;
    cQp = 1;
    com.tencent.mm.sdk.e.c.a locala = new com.tencent.mm.sdk.e.c.a();
    locala.IhA = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IhC.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "username";
    locala.columns[1] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandList";
    locala.IhC.put("brandList", "TEXT default '' ");
    localStringBuilder.append(" brandList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "brandListVersion";
    locala.IhC.put("brandListVersion", "TEXT");
    localStringBuilder.append(" brandListVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "brandListContent";
    locala.IhC.put("brandListContent", "TEXT");
    localStringBuilder.append(" brandListContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandFlag";
    locala.IhC.put("brandFlag", "INTEGER");
    localStringBuilder.append(" brandFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "extInfo";
    locala.IhC.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "brandInfo";
    locala.IhC.put("brandInfo", "TEXT");
    localStringBuilder.append(" brandInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "brandIconURL";
    locala.IhC.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "hadAlert";
    locala.IhC.put("hadAlert", "INTEGER");
    localStringBuilder.append(" hadAlert INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "acceptType";
    locala.IhC.put("acceptType", "INTEGER default '0' ");
    localStringBuilder.append(" acceptType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "type";
    locala.IhC.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "status";
    locala.IhC.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "enterpriseFather";
    locala.IhC.put("enterpriseFather", "TEXT");
    localStringBuilder.append(" enterpriseFather TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "kfWorkerId";
    locala.IhC.put("kfWorkerId", "TEXT");
    localStringBuilder.append(" kfWorkerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "specialType";
    locala.IhC.put("specialType", "INTEGER");
    localStringBuilder.append(" specialType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "attrSyncVersion";
    locala.IhC.put("attrSyncVersion", "TEXT");
    localStringBuilder.append(" attrSyncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "incrementUpdateTime";
    locala.IhC.put("incrementUpdateTime", "LONG");
    localStringBuilder.append(" incrementUpdateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[19] = "bitFlag";
    locala.IhC.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    cQs = 0;
    cQt = null;
    AppMethodBeat.o(116408);
  }
  
  private boolean hj(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  private void hk(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
  
  public final boolean Kf()
  {
    return (this.field_brandFlag & 0x1) == 0;
  }
  
  public final boolean Kg()
  {
    return (this.field_brandFlag & 0x4) != 0;
  }
  
  public final boolean Kh()
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
  
  public final void Ki()
  {
    AppMethodBeat.i(116391);
    bX(false);
    b localb = this.cQr;
    if (localb.cQv != null) {
      localb.cQK = localb.cQv.optInt("ConnectorMsgType");
    }
    this.field_acceptType = localb.cQK;
    this.field_type = bX(false).getServiceType();
    if (Kp())
    {
      hk(1);
      AppMethodBeat.o(116391);
      return;
    }
    this.field_bitFlag &= 0xFFFFFFFE;
    AppMethodBeat.o(116391);
  }
  
  public final boolean Kj()
  {
    AppMethodBeat.i(116392);
    bX(false);
    ad.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[] { this.field_username, Boolean.valueOf(this.cQr.Kj()) });
    boolean bool = this.cQr.Kj();
    AppMethodBeat.o(116392);
    return bool;
  }
  
  public final boolean Kk()
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
  
  public final boolean Kl()
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
  
  public final boolean Km()
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
  
  public final boolean Kn()
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
  
  public final boolean Ko()
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
  
  public final boolean Kp()
  {
    AppMethodBeat.i(116398);
    bX(false);
    boolean bool;
    if ((this.cQr != null) && (this.cQr.KP() != null)) {
      if (this.cQr.cQH.cRj == 1)
      {
        bool = true;
        if ((bool) && (!hj(1)))
        {
          hk(1);
          ((o)g.ab(o.class)).a(this);
        }
        if (bool) {
          ad.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", new Object[] { this.field_username });
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
  
  public final boolean Kq()
  {
    AppMethodBeat.i(116399);
    bX(false);
    boolean bool;
    if ((this.cQr != null) && (this.cQr.KP() != null)) {
      if (this.cQr.cQH.cRj == 2)
      {
        bool = true;
        if ((bool) && (!hj(2)))
        {
          hk(2);
          ((o)g.ab(o.class)).a(this);
        }
        if (bool) {
          ad.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", new Object[] { this.field_username });
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
  
  public final String Kr()
  {
    AppMethodBeat.i(116400);
    bX(false);
    if (this.cQr != null)
    {
      Object localObject = this.cQr.KP();
      if ((localObject != null) && (((c.b.c.a)localObject).cRk != null) && (!((c.b.c.a)localObject).cRk.isEmpty()))
      {
        localObject = ((c.b.c.a)localObject).cRk;
        AppMethodBeat.o(116400);
        return localObject;
      }
    }
    AppMethodBeat.o(116400);
    return null;
  }
  
  public final long Ks()
  {
    AppMethodBeat.i(116401);
    bX(false);
    if (this.cQr != null)
    {
      c.b.c.a locala = this.cQr.KP();
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
  
  public final boolean Kt()
  {
    AppMethodBeat.i(116402);
    bX(false);
    if (this.cQr == null)
    {
      ad.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (this.cQr.KJ() == null)
    {
      ad.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (!this.cQr.KJ().cRy)
    {
      AppMethodBeat.o(116402);
      return true;
    }
    AppMethodBeat.o(116402);
    return false;
  }
  
  public final String Ku()
  {
    AppMethodBeat.i(116403);
    bX(false);
    if (this.cQr != null)
    {
      Object localObject = this.cQr.KP();
      if (localObject != null)
      {
        localObject = ((c.b.c.a)localObject).cRl;
        AppMethodBeat.o(116403);
        return localObject;
      }
    }
    AppMethodBeat.o(116403);
    return null;
  }
  
  public final String Kv()
  {
    AppMethodBeat.i(116404);
    try
    {
      String str1 = bX(false).KP().cRh;
      if (bt.isNullOrNil(str1)) {
        ad.e("MicroMsg.BizInfo", "check father: %s, %s", new Object[] { this.field_username, str1 });
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
  public final List<a> Kw()
  {
    // Byte code:
    //   0: ldc_w 416
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 418	com/tencent/mm/api/c:cQq	Ljava/util/List;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: getfield 418	com/tencent/mm/api/c:cQq	Ljava/util/List;
    //   17: astore_2
    //   18: ldc_w 416
    //   21: invokestatic 211	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_2
    //   25: areturn
    //   26: aload_0
    //   27: new 420	java/util/LinkedList
    //   30: dup
    //   31: invokespecial 421	java/util/LinkedList:<init>	()V
    //   34: putfield 418	com/tencent/mm/api/c:cQq	Ljava/util/List;
    //   37: aload_0
    //   38: getfield 424	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   41: ifnull +13 -> 54
    //   44: aload_0
    //   45: getfield 424	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   48: invokevirtual 427	java/lang/String:length	()I
    //   51: ifne +16 -> 67
    //   54: aload_0
    //   55: getfield 418	com/tencent/mm/api/c:cQq	Ljava/util/List;
    //   58: astore_2
    //   59: ldc_w 416
    //   62: invokestatic 211	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_2
    //   66: areturn
    //   67: new 268	org/json/JSONObject
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
    //   143: putfield 461	com/tencent/mm/api/c$a:cQu	Ljava/lang/String;
    //   146: aload_3
    //   147: aload 4
    //   149: ldc_w 463
    //   152: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 465	com/tencent/mm/api/c$a:description	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 418	com/tencent/mm/api/c:cQq	Ljava/util/List;
    //   162: aload_3
    //   163: invokeinterface 471 2 0
    //   168: pop
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: goto -86 -> 87
    //   176: astore_2
    //   177: ldc_w 294
    //   180: ldc_w 473
    //   183: iconst_1
    //   184: anewarray 298	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: invokestatic 477	com/tencent/mm/sdk/platformtools/bt:n	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 409	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_0
    //   198: getfield 418	com/tencent/mm/api/c:cQq	Ljava/util/List;
    //   201: astore_2
    //   202: ldc_w 416
    //   205: invokestatic 211	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final b bX(boolean paramBoolean)
  {
    AppMethodBeat.i(116389);
    if ((this.cQr == null) || (paramBoolean))
    {
      if ((bt.isNullOrNil(this.field_extInfo)) || (cQs != this.field_extInfo.hashCode())) {
        break label60;
      }
      this.cQr = cQt;
    }
    for (;;)
    {
      b localb = this.cQr;
      AppMethodBeat.o(116389);
      return localb;
      label60:
      localb = b.ey(this.field_extInfo);
      this.cQr = localb;
      cQt = localb;
      cQs = bt.nullAsNil(this.field_extInfo).hashCode();
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
    public String cQu;
    public String description;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    private String cQA;
    private String cQB;
    private List<c.b.g> cQC = null;
    private e cQD = null;
    private d cQE = null;
    private c cQF = null;
    private f cQG = null;
    c.b.c.a cQH = null;
    private boolean cQI = false;
    public boolean cQJ = false;
    int cQK;
    public boolean cQL = false;
    public int cQM = 0;
    private int cQN = 0;
    private String cQO;
    private c.b.b cQP = null;
    private int cQQ = 0;
    private int cQR = c.cQo;
    private String cQS;
    private boolean cQT = false;
    private int cQU;
    private h cQV;
    private String cQW;
    private String cQX;
    private boolean cQY = false;
    public c.b.a cQZ;
    public JSONObject cQv = null;
    private boolean cQw = true;
    public boolean cQx = false;
    private boolean cQy = false;
    public boolean cQz = false;
    private List<WxaAttributes.WxaEntryInfo> cRa;
    
    static b ey(String paramString)
    {
      AppMethodBeat.i(116387);
      b localb = new b();
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(116387);
        return localb;
      }
      try
      {
        System.currentTimeMillis();
        localb.cQv = new JSONObject(paramString);
        AppMethodBeat.o(116387);
        return localb;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bt.n(paramString) });
        }
      }
    }
    
    public final String KA()
    {
      AppMethodBeat.i(116369);
      if (this.cQv != null) {
        this.cQA = this.cQv.optString("VerifyContactPromptTitle");
      }
      String str = this.cQA;
      AppMethodBeat.o(116369);
      return str;
    }
    
    public final String KB()
    {
      AppMethodBeat.i(116370);
      if (this.cQv != null) {
        this.cQW = this.cQv.optString("TrademarkUrl");
      }
      String str = this.cQW;
      AppMethodBeat.o(116370);
      return str;
    }
    
    public final String KC()
    {
      AppMethodBeat.i(116371);
      if (this.cQv != null) {
        this.cQX = this.cQv.optString("TrademarkName");
      }
      String str = this.cQX;
      AppMethodBeat.o(116371);
      return str;
    }
    
    public final String KD()
    {
      AppMethodBeat.i(116372);
      if (this.cQv != null) {
        this.cQB = this.cQv.optString("ConferenceContactExpireTime");
      }
      String str = this.cQB;
      AppMethodBeat.o(116372);
      return str;
    }
    
    public final List<c.b.g> KE()
    {
      AppMethodBeat.i(116373);
      if ((this.cQv != null) && (this.cQC == null)) {
        this.cQC = c.b.g.d(this.cQv.optJSONArray("Privilege"));
      }
      List localList = this.cQC;
      AppMethodBeat.o(116373);
      return localList;
    }
    
    public final int KF()
    {
      AppMethodBeat.i(116374);
      if (this.cQv != null) {
        this.cQQ = this.cQv.optInt("InteractiveMode");
      }
      int i = this.cQQ;
      AppMethodBeat.o(116374);
      return i;
    }
    
    public final f KG()
    {
      AppMethodBeat.i(116375);
      if ((this.cQv != null) && (this.cQG == null)) {
        this.cQG = f.eE(this.cQv.optString("PayShowInfo"));
      }
      f localf = this.cQG;
      AppMethodBeat.o(116375);
      return localf;
    }
    
    public final c.b.b KH()
    {
      AppMethodBeat.i(116376);
      if ((this.cQv != null) && (this.cQP == null))
      {
        localObject = this.cQv.optString("HardwareBizInfo");
        if (localObject != null) {
          this.cQP = c.b.b.eA((String)localObject);
        }
      }
      Object localObject = this.cQP;
      AppMethodBeat.o(116376);
      return localObject;
    }
    
    public final e KI()
    {
      AppMethodBeat.i(116377);
      if ((this.cQv != null) && (this.cQD == null)) {
        this.cQD = e.eD(this.cQv.optString("VerifySource"));
      }
      e locale = this.cQD;
      AppMethodBeat.o(116377);
      return locale;
    }
    
    public final h KJ()
    {
      AppMethodBeat.i(116379);
      if ((this.cQv != null) && (this.cQV == null))
      {
        localObject = this.cQv.optString("RegisterSource");
        if (localObject != null) {
          this.cQV = h.eF((String)localObject);
        }
      }
      Object localObject = this.cQV;
      AppMethodBeat.o(116379);
      return localObject;
    }
    
    public final boolean KK()
    {
      boolean bool = true;
      AppMethodBeat.i(116381);
      if (this.cQv != null) {
        if (bt.getInt(this.cQv.optString("IsTrademarkProtection"), 0) != 1) {
          break label51;
        }
      }
      for (;;)
      {
        this.cQT = bool;
        bool = this.cQT;
        AppMethodBeat.o(116381);
        return bool;
        label51:
        bool = false;
      }
    }
    
    public final String KL()
    {
      AppMethodBeat.i(116383);
      if (this.cQv != null) {
        this.cQO = this.cQv.optString("SupportEmoticonLinkPrefix");
      }
      String str = this.cQO;
      AppMethodBeat.o(116383);
      return str;
    }
    
    public final c KM()
    {
      AppMethodBeat.i(116384);
      if ((this.cQv != null) && (this.cQF == null))
      {
        localObject = this.cQv.optString("MMBizMenu");
        if (localObject != null) {
          this.cQF = c.eB((String)localObject);
        }
      }
      Object localObject = this.cQF;
      AppMethodBeat.o(116384);
      return localObject;
    }
    
    public final String KN()
    {
      AppMethodBeat.i(116385);
      if (this.cQv != null) {
        this.cQS = this.cQv.optString("ServicePhone");
      }
      String str = this.cQS;
      AppMethodBeat.o(116385);
      return str;
    }
    
    public final boolean KO()
    {
      AppMethodBeat.i(116386);
      if (this.cQv != null) {
        this.cQU = this.cQv.optInt("FunctionFlag");
      }
      if ((this.cQU & c.cQp) > 0)
      {
        AppMethodBeat.o(116386);
        return true;
      }
      AppMethodBeat.o(116386);
      return false;
    }
    
    public final c.b.c.a KP()
    {
      AppMethodBeat.i(116388);
      if ((this.cQv != null) && (this.cQH == null))
      {
        localObject = this.cQv.optString("EnterpriseBizInfo");
        if (localObject != null) {
          this.cQH = c.b.c.a.eC((String)localObject);
        }
      }
      Object localObject = this.cQH;
      AppMethodBeat.o(116388);
      return localObject;
    }
    
    public final boolean Kj()
    {
      boolean bool = false;
      AppMethodBeat.i(116380);
      if (this.cQv != null)
      {
        if (bt.getInt(this.cQv.optString("ReportLocationType"), 0) > 0) {
          bool = true;
        }
        this.cQI = bool;
      }
      bool = this.cQI;
      AppMethodBeat.o(116380);
      return bool;
    }
    
    public final boolean Kx()
    {
      AppMethodBeat.i(116366);
      if ((this.cQv != null) && (this.cQv.optJSONObject("WifiBizInfo") != null) && (this.cQv.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") == 1)) {
        this.cQY = true;
      }
      boolean bool = this.cQY;
      AppMethodBeat.o(116366);
      return bool;
    }
    
    public final boolean Ky()
    {
      AppMethodBeat.i(116367);
      if (this.cQv != null) {
        this.cQy = "1".equals(this.cQv.optString("IsShowMember"));
      }
      boolean bool = this.cQy;
      AppMethodBeat.o(116367);
      return bool;
    }
    
    public final boolean Kz()
    {
      AppMethodBeat.i(116368);
      if (this.cQv != null) {
        this.cQR = bt.getInt(this.cQv.optString("NotifyManage"), c.cQo);
      }
      if (this.cQR == c.cQn)
      {
        AppMethodBeat.o(116368);
        return true;
      }
      AppMethodBeat.o(116368);
      return false;
    }
    
    public final int getServiceType()
    {
      AppMethodBeat.i(116382);
      if (this.cQv != null) {
        this.cQN = this.cQv.optInt("ServiceType", 0);
      }
      int i = this.cQN;
      AppMethodBeat.o(116382);
      return i;
    }
    
    public final List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
    {
      AppMethodBeat.i(116365);
      Object localObject1;
      if (this.cRa == null)
      {
        this.cRa = new LinkedList();
        if (this.cQv != null)
        {
          localObject1 = this.cQv.optString("BindWxaInfo");
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
              localWxaEntryInfo.jZS = str3;
              localWxaEntryInfo.iconUrl = ((String)localObject2);
              this.cRa.add(localWxaEntryInfo);
            }
          }
          i += 1;
          continue;
          localList = null;
        }
        catch (JSONException localJSONException) {}
        continue;
        label219:
        List localList = this.cRa;
        AppMethodBeat.o(116365);
        return localList;
        label232:
        localList = null;
      }
    }
    
    public static final class c
    {
      public int cRf;
      public List<k> cRg = null;
      public int type;
      
      public static c eB(String paramString)
      {
        AppMethodBeat.i(116359);
        ad.i("MicroMsg.BizInfo", "MenuInfo = ".concat(String.valueOf(paramString)));
        c localc = new c();
        if ((paramString == null) || (paramString.length() <= 0))
        {
          AppMethodBeat.o(116359);
          return localc;
        }
        try
        {
          paramString = new JSONObject(paramString);
          localc.cRf = paramString.optInt("update_time");
          localc.type = paramString.optInt("type", 0);
          localc.cRg = k.e(paramString.optJSONArray("button_list"));
          AppMethodBeat.o(116359);
          return localc;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            ad.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bt.n(paramString) });
          }
        }
      }
      
      public static final class a
      {
        public long appid = 0L;
        public String cRh;
        public String cRi;
        public int cRj;
        public String cRk;
        public String cRl;
        
        public static a eC(String paramString)
        {
          AppMethodBeat.i(116358);
          ad.i("MicroMsg.BizInfo", "EnterpriseBizInfo = ".concat(String.valueOf(paramString)));
          a locala = new a();
          if ((paramString == null) || (paramString.length() <= 0))
          {
            AppMethodBeat.o(116358);
            return locala;
          }
          try
          {
            paramString = new JSONObject(paramString);
            locala.cRh = paramString.optString("belong");
            locala.cRi = paramString.optString("freeze_wording");
            locala.cRj = paramString.optInt("child_type");
            locala.cRk = paramString.optString("home_url");
            paramString = paramString.optString("exattr");
            if (bt.isNullOrNil(paramString)) {
              locala.cRl = null;
            }
            for (;;)
            {
              AppMethodBeat.o(116358);
              return locala;
              paramString = new JSONObject(paramString);
              locala.cRl = paramString.optString("chat_extension_url");
              locala.appid = paramString.optLong("app_id");
            }
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              ad.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bt.n(paramString) });
            }
          }
        }
      }
    }
    
    public static final class d {}
    
    public static final class e
    {
      public int cRm = 0;
      public String cRn;
      public String cRo;
      public String cRp;
      public String cRq;
      
      public static e eD(String paramString)
      {
        AppMethodBeat.i(116361);
        if (bt.isNullOrNil(paramString))
        {
          AppMethodBeat.o(116361);
          return null;
        }
        ad.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[] { paramString });
        e locale = new e();
        try
        {
          paramString = new JSONObject(paramString);
          locale.cRm = paramString.optInt("Type");
          locale.cRn = paramString.optString("Description");
          locale.cRo = paramString.optString("Name");
          locale.cRp = paramString.optString("IntroUrl");
          locale.cRq = paramString.optString("VerifySubTitle");
          ad.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[] { Integer.valueOf(locale.cRm), locale.cRn, locale.cRo, locale.cRp });
          AppMethodBeat.o(116361);
          return locale;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ad.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bt.n(paramString) });
          }
        }
      }
    }
    
    public static final class f
    {
      public int cRr;
      public String cRs;
      public List<String> cRt;
      public String cRu;
      
      public static f eE(String paramString)
      {
        AppMethodBeat.i(116362);
        if (bt.isNullOrNil(paramString))
        {
          AppMethodBeat.o(116362);
          return null;
        }
        try
        {
          f localf = new f();
          paramString = new JSONObject(paramString);
          localf.cRr = paramString.optInt("reputation_level", -1);
          localf.cRs = paramString.optString("scope_of_business");
          localf.cRu = paramString.optString("guarantee_detail_h5_url");
          paramString = paramString.optJSONArray("guarantee_info");
          if (paramString != null)
          {
            int j = paramString.length();
            if (j > 0)
            {
              localf.cRt = new ArrayList();
              int i = 0;
              while (i < j)
              {
                String str = paramString.getString(i);
                if (!bt.isNullOrNil(str)) {
                  localf.cRt.add(str);
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
          ad.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bt.n(paramString) });
          AppMethodBeat.o(116362);
        }
        return null;
      }
    }
    
    public static final class h
    {
      public String cRw;
      public String cRx;
      public boolean cRy;
      public String cRz;
      
      public static h eF(String paramString)
      {
        AppMethodBeat.i(116364);
        ad.i("MicroMsg.BizInfo", "RegisterSource = %s", new Object[] { paramString });
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
            localh.cRw = paramString.optString("RegisterBody");
            localh.cRx = paramString.optString("IntroUrl");
            if (paramString.optInt("IsClose", 0) != 1) {
              continue;
            }
            bool = true;
            localh.cRy = bool;
            localh.cRz = paramString.optString("AboutBizUrl");
          }
          catch (JSONException paramString)
          {
            boolean bool;
            ad.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", new Object[] { bt.n(paramString) });
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