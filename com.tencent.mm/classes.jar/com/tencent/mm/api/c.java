package com.tencent.mm.api;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.k;
import com.tencent.mm.g.c.al;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cr.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
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
  extends al
{
  public static int dhr;
  public static int dhs;
  public static int dht;
  private static int dhw;
  private static b dhx;
  public static IAutoDBItem.MAutoDBInfo info;
  private List<a> dhu;
  public b dhv;
  
  static
  {
    AppMethodBeat.i(116408);
    dhr = 1;
    dhs = 0;
    dht = 1;
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[20];
    localMAutoDBInfo.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "brandList";
    localMAutoDBInfo.colsMap.put("brandList", "TEXT default '' ");
    localStringBuilder.append(" brandList TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "brandListVersion";
    localMAutoDBInfo.colsMap.put("brandListVersion", "TEXT");
    localStringBuilder.append(" brandListVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "brandListContent";
    localMAutoDBInfo.colsMap.put("brandListContent", "TEXT");
    localStringBuilder.append(" brandListContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "brandFlag";
    localMAutoDBInfo.colsMap.put("brandFlag", "INTEGER");
    localStringBuilder.append(" brandFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "brandInfo";
    localMAutoDBInfo.colsMap.put("brandInfo", "TEXT");
    localStringBuilder.append(" brandInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "brandIconURL";
    localMAutoDBInfo.colsMap.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "hadAlert";
    localMAutoDBInfo.colsMap.put("hadAlert", "INTEGER");
    localStringBuilder.append(" hadAlert INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "acceptType";
    localMAutoDBInfo.colsMap.put("acceptType", "INTEGER default '0' ");
    localStringBuilder.append(" acceptType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "enterpriseFather";
    localMAutoDBInfo.colsMap.put("enterpriseFather", "TEXT");
    localStringBuilder.append(" enterpriseFather TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "kfWorkerId";
    localMAutoDBInfo.colsMap.put("kfWorkerId", "TEXT");
    localStringBuilder.append(" kfWorkerId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "specialType";
    localMAutoDBInfo.colsMap.put("specialType", "INTEGER");
    localStringBuilder.append(" specialType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "attrSyncVersion";
    localMAutoDBInfo.colsMap.put("attrSyncVersion", "TEXT");
    localStringBuilder.append(" attrSyncVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "incrementUpdateTime";
    localMAutoDBInfo.colsMap.put("incrementUpdateTime", "LONG");
    localStringBuilder.append(" incrementUpdateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "bitFlag";
    localMAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localMAutoDBInfo.columns[20] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    dhw = 0;
    dhx = null;
    AppMethodBeat.o(116408);
  }
  
  private boolean iE(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  private void iF(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
  
  public final void UA()
  {
    AppMethodBeat.i(116391);
    cG(false);
    b localb = this.dhv;
    if (localb.dhz != null) {
      localb.dhO = localb.dhz.optInt("ConnectorMsgType");
    }
    this.field_acceptType = localb.dhO;
    this.field_type = cG(false).getServiceType();
    if (UH())
    {
      iF(1);
      AppMethodBeat.o(116391);
      return;
    }
    this.field_bitFlag &= 0xFFFFFFFE;
    AppMethodBeat.o(116391);
  }
  
  public final boolean UB()
  {
    AppMethodBeat.i(116392);
    cG(false);
    Log.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[] { this.field_username, Boolean.valueOf(this.dhv.UB()) });
    boolean bool = this.dhv.UB();
    AppMethodBeat.o(116392);
    return bool;
  }
  
  public final boolean UC()
  {
    AppMethodBeat.i(116393);
    cG(false);
    if (this.field_type == 1)
    {
      AppMethodBeat.o(116393);
      return true;
    }
    AppMethodBeat.o(116393);
    return false;
  }
  
  public final boolean UD()
  {
    AppMethodBeat.i(116394);
    cG(false);
    if (this.field_type == 0)
    {
      AppMethodBeat.o(116394);
      return true;
    }
    AppMethodBeat.o(116394);
    return false;
  }
  
  public final boolean UE()
  {
    AppMethodBeat.i(116395);
    cG(false);
    if ((this.field_type == 2) || (this.field_type == 3))
    {
      AppMethodBeat.o(116395);
      return true;
    }
    AppMethodBeat.o(116395);
    return false;
  }
  
  public final boolean UF()
  {
    AppMethodBeat.i(116396);
    cG(false);
    if (this.field_type == 2)
    {
      AppMethodBeat.o(116396);
      return true;
    }
    AppMethodBeat.o(116396);
    return false;
  }
  
  public final boolean UG()
  {
    AppMethodBeat.i(116397);
    cG(false);
    if (this.field_type == 3)
    {
      AppMethodBeat.o(116397);
      return true;
    }
    AppMethodBeat.o(116397);
    return false;
  }
  
  public final boolean UH()
  {
    AppMethodBeat.i(116398);
    cG(false);
    boolean bool;
    if ((this.dhv != null) && (this.dhv.Vh() != null)) {
      if (this.dhv.dhL.dim == 1)
      {
        bool = true;
        if ((bool) && (!iE(1)))
        {
          iF(1);
          ((p)g.af(p.class)).a(this);
        }
        if (bool) {
          Log.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", new Object[] { this.field_username });
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
  
  public final boolean UI()
  {
    AppMethodBeat.i(116399);
    cG(false);
    boolean bool;
    if ((this.dhv != null) && (this.dhv.Vh() != null)) {
      if (this.dhv.dhL.dim == 2)
      {
        bool = true;
        if ((bool) && (!iE(2)))
        {
          iF(2);
          ((p)g.af(p.class)).a(this);
        }
        if (bool) {
          Log.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", new Object[] { this.field_username });
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
  
  public final String UJ()
  {
    AppMethodBeat.i(116400);
    cG(false);
    if (this.dhv != null)
    {
      Object localObject = this.dhv.Vh();
      if ((localObject != null) && (((c.b.c.a)localObject).din != null) && (!((c.b.c.a)localObject).din.isEmpty()))
      {
        localObject = ((c.b.c.a)localObject).din;
        AppMethodBeat.o(116400);
        return localObject;
      }
    }
    AppMethodBeat.o(116400);
    return null;
  }
  
  public final long UK()
  {
    AppMethodBeat.i(116401);
    cG(false);
    if (this.dhv != null)
    {
      c.b.c.a locala = this.dhv.Vh();
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
  
  public final boolean UL()
  {
    AppMethodBeat.i(116402);
    cG(false);
    if (this.dhv == null)
    {
      Log.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (this.dhv.Vb() == null)
    {
      Log.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (!this.dhv.Vb().diC)
    {
      AppMethodBeat.o(116402);
      return true;
    }
    AppMethodBeat.o(116402);
    return false;
  }
  
  public final String UM()
  {
    AppMethodBeat.i(116403);
    cG(false);
    if (this.dhv != null)
    {
      Object localObject = this.dhv.Vh();
      if (localObject != null)
      {
        localObject = ((c.b.c.a)localObject).dio;
        AppMethodBeat.o(116403);
        return localObject;
      }
    }
    AppMethodBeat.o(116403);
    return null;
  }
  
  public final String UN()
  {
    AppMethodBeat.i(116404);
    try
    {
      String str1 = cG(false).Vh().dik;
      if (Util.isNullOrNil(str1)) {
        Log.e("MicroMsg.BizInfo", "check father: %s, %s", new Object[] { this.field_username, str1 });
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
  public final List<a> UO()
  {
    // Byte code:
    //   0: ldc_w 385
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 387	com/tencent/mm/api/c:dhu	Ljava/util/List;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: getfield 387	com/tencent/mm/api/c:dhu	Ljava/util/List;
    //   17: astore_2
    //   18: ldc_w 385
    //   21: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_2
    //   25: areturn
    //   26: aload_0
    //   27: new 389	java/util/LinkedList
    //   30: dup
    //   31: invokespecial 390	java/util/LinkedList:<init>	()V
    //   34: putfield 387	com/tencent/mm/api/c:dhu	Ljava/util/List;
    //   37: aload_0
    //   38: getfield 393	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   41: ifnull +13 -> 54
    //   44: aload_0
    //   45: getfield 393	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   48: invokevirtual 396	java/lang/String:length	()I
    //   51: ifne +16 -> 67
    //   54: aload_0
    //   55: getfield 387	com/tencent/mm/api/c:dhu	Ljava/util/List;
    //   58: astore_2
    //   59: ldc_w 385
    //   62: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_2
    //   66: areturn
    //   67: new 234	org/json/JSONObject
    //   70: dup
    //   71: aload_0
    //   72: getfield 393	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   75: invokespecial 399	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   78: ldc_w 401
    //   81: invokevirtual 405	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   84: astore_2
    //   85: iconst_0
    //   86: istore_1
    //   87: iload_1
    //   88: aload_2
    //   89: invokevirtual 408	org/json/JSONArray:length	()I
    //   92: if_icmpge +105 -> 197
    //   95: new 6	com/tencent/mm/api/c$a
    //   98: dup
    //   99: invokespecial 409	com/tencent/mm/api/c$a:<init>	()V
    //   102: astore_3
    //   103: aload_2
    //   104: iload_1
    //   105: invokevirtual 413	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   108: astore 4
    //   110: aload_3
    //   111: aload 4
    //   113: ldc_w 415
    //   116: invokevirtual 419	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putfield 421	com/tencent/mm/api/c$a:title	Ljava/lang/String;
    //   122: aload_3
    //   123: aload 4
    //   125: ldc_w 423
    //   128: invokevirtual 419	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 425	com/tencent/mm/api/c$a:url	Ljava/lang/String;
    //   134: aload_3
    //   135: aload 4
    //   137: ldc_w 427
    //   140: invokevirtual 419	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 430	com/tencent/mm/api/c$a:dhy	Ljava/lang/String;
    //   146: aload_3
    //   147: aload 4
    //   149: ldc_w 432
    //   152: invokevirtual 419	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 434	com/tencent/mm/api/c$a:description	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 387	com/tencent/mm/api/c:dhu	Ljava/util/List;
    //   162: aload_3
    //   163: invokeinterface 440 2 0
    //   168: pop
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: goto -86 -> 87
    //   176: astore_2
    //   177: ldc_w 261
    //   180: ldc_w 442
    //   183: iconst_1
    //   184: anewarray 265	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: invokestatic 446	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_0
    //   198: getfield 387	com/tencent/mm/api/c:dhu	Ljava/util/List;
    //   201: astore_2
    //   202: ldc_w 385
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
  
  public final b Uw()
  {
    AppMethodBeat.i(187529);
    b localb = cG(false);
    AppMethodBeat.o(187529);
    return localb;
  }
  
  public final boolean Ux()
  {
    return (this.field_brandFlag & 0x1) == 0;
  }
  
  public final boolean Uy()
  {
    return (this.field_brandFlag & 0x4) != 0;
  }
  
  public final boolean Uz()
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
  
  public final b cG(boolean paramBoolean)
  {
    AppMethodBeat.i(116389);
    b localb;
    if ((this.dhv == null) || (paramBoolean))
    {
      if ((!Util.isNullOrNil(this.field_extInfo)) && (dhw == this.field_extInfo.hashCode())) {
        this.dhv = dhx;
      }
    }
    else
    {
      localb = this.dhv;
      AppMethodBeat.o(116389);
      return localb;
    }
    if ((ab.Iv(this.field_username)) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()))
    {
      localb = b.fp(cr.c.aWN());
      this.dhv = localb;
    }
    for (dhx = localb;; dhx = localb)
    {
      dhw = Util.nullAsNil(this.field_extInfo).hashCode();
      break;
      localb = b.fp(this.field_extInfo);
      this.dhv = localb;
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
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public static final class a
  {
    public String description;
    public String dhy;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    private boolean dhA = true;
    public boolean dhB = false;
    private boolean dhC = false;
    public boolean dhD = false;
    private String dhE;
    private String dhF;
    private List<c.b.g> dhG = null;
    private e dhH = null;
    private d dhI = null;
    private c dhJ = null;
    private f dhK = null;
    c.b.c.a dhL = null;
    private boolean dhM = false;
    public boolean dhN = false;
    int dhO;
    public boolean dhP = false;
    public int dhQ = 0;
    private String dhR;
    private c.b.b dhS = null;
    private int dhT = 0;
    private int dhU = c.dhs;
    private String dhV;
    private boolean dhW = false;
    private int dhX;
    private c.b.h dhY;
    private String dhZ;
    public JSONObject dhz = null;
    private String dia;
    private boolean dib = false;
    public c.b.a dic;
    private List<WxaAttributes.WxaEntryInfo> did;
    private int serviceType = 0;
    
    static b fp(String paramString)
    {
      AppMethodBeat.i(116387);
      b localb = new b();
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(116387);
        return localb;
      }
      try
      {
        System.currentTimeMillis();
        localb.dhz = new JSONObject(paramString);
        AppMethodBeat.o(116387);
        return localb;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.BizInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        }
      }
    }
    
    public final boolean UB()
    {
      boolean bool = false;
      AppMethodBeat.i(116380);
      if (this.dhz != null)
      {
        if (Util.getInt(this.dhz.optString("ReportLocationType"), 0) > 0) {
          bool = true;
        }
        this.dhM = bool;
      }
      bool = this.dhM;
      AppMethodBeat.o(116380);
      return bool;
    }
    
    public final boolean UP()
    {
      AppMethodBeat.i(116366);
      if ((this.dhz != null) && (this.dhz.optJSONObject("WifiBizInfo") != null) && (this.dhz.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") == 1)) {
        this.dib = true;
      }
      boolean bool = this.dib;
      AppMethodBeat.o(116366);
      return bool;
    }
    
    public final boolean UQ()
    {
      AppMethodBeat.i(116367);
      if (this.dhz != null) {
        this.dhC = "1".equals(this.dhz.optString("IsShowMember"));
      }
      boolean bool = this.dhC;
      AppMethodBeat.o(116367);
      return bool;
    }
    
    public final boolean UR()
    {
      AppMethodBeat.i(116368);
      if (this.dhz != null) {
        this.dhU = Util.getInt(this.dhz.optString("NotifyManage"), c.dhs);
      }
      if (this.dhU == c.dhr)
      {
        AppMethodBeat.o(116368);
        return true;
      }
      AppMethodBeat.o(116368);
      return false;
    }
    
    public final String US()
    {
      AppMethodBeat.i(116369);
      if (this.dhz != null) {
        this.dhE = this.dhz.optString("VerifyContactPromptTitle");
      }
      String str = this.dhE;
      AppMethodBeat.o(116369);
      return str;
    }
    
    public final String UT()
    {
      AppMethodBeat.i(116370);
      if (this.dhz != null) {
        this.dhZ = this.dhz.optString("TrademarkUrl");
      }
      String str = this.dhZ;
      AppMethodBeat.o(116370);
      return str;
    }
    
    public final String UU()
    {
      AppMethodBeat.i(116371);
      if (this.dhz != null) {
        this.dia = this.dhz.optString("TrademarkName");
      }
      String str = this.dia;
      AppMethodBeat.o(116371);
      return str;
    }
    
    public final String UV()
    {
      AppMethodBeat.i(116372);
      if (this.dhz != null) {
        this.dhF = this.dhz.optString("ConferenceContactExpireTime");
      }
      String str = this.dhF;
      AppMethodBeat.o(116372);
      return str;
    }
    
    public final List<c.b.g> UW()
    {
      AppMethodBeat.i(116373);
      if ((this.dhz != null) && (this.dhG == null)) {
        this.dhG = c.b.g.d(this.dhz.optJSONArray("Privilege"));
      }
      List localList = this.dhG;
      AppMethodBeat.o(116373);
      return localList;
    }
    
    public final int UX()
    {
      AppMethodBeat.i(116374);
      if (this.dhz != null) {
        this.dhT = this.dhz.optInt("InteractiveMode");
      }
      int i = this.dhT;
      AppMethodBeat.o(116374);
      return i;
    }
    
    public final f UY()
    {
      AppMethodBeat.i(116375);
      if ((this.dhz != null) && (this.dhK == null)) {
        this.dhK = f.fv(this.dhz.optString("PayShowInfo"));
      }
      f localf = this.dhK;
      AppMethodBeat.o(116375);
      return localf;
    }
    
    public final c.b.b UZ()
    {
      AppMethodBeat.i(116376);
      if ((this.dhz != null) && (this.dhS == null))
      {
        localObject = this.dhz.optString("HardwareBizInfo");
        if (localObject != null) {
          this.dhS = c.b.b.fr((String)localObject);
        }
      }
      Object localObject = this.dhS;
      AppMethodBeat.o(116376);
      return localObject;
    }
    
    public final e Va()
    {
      AppMethodBeat.i(116377);
      if ((this.dhz != null) && (this.dhH == null)) {
        this.dhH = e.fu(this.dhz.optString("VerifySource"));
      }
      e locale = this.dhH;
      AppMethodBeat.o(116377);
      return locale;
    }
    
    public final c.b.h Vb()
    {
      AppMethodBeat.i(116379);
      if ((this.dhz != null) && (this.dhY == null))
      {
        localObject = this.dhz.optString("RegisterSource");
        if (localObject != null) {
          this.dhY = c.b.h.fw((String)localObject);
        }
      }
      Object localObject = this.dhY;
      AppMethodBeat.o(116379);
      return localObject;
    }
    
    public final boolean Vc()
    {
      boolean bool = true;
      AppMethodBeat.i(116381);
      if (this.dhz != null) {
        if (Util.getInt(this.dhz.optString("IsTrademarkProtection"), 0) != 1) {
          break label51;
        }
      }
      for (;;)
      {
        this.dhW = bool;
        bool = this.dhW;
        AppMethodBeat.o(116381);
        return bool;
        label51:
        bool = false;
      }
    }
    
    public final String Vd()
    {
      AppMethodBeat.i(116383);
      if (this.dhz != null) {
        this.dhR = this.dhz.optString("SupportEmoticonLinkPrefix");
      }
      String str = this.dhR;
      AppMethodBeat.o(116383);
      return str;
    }
    
    public final c Ve()
    {
      AppMethodBeat.i(116384);
      if ((this.dhz != null) && (this.dhJ == null))
      {
        localObject = this.dhz.optString("MMBizMenu");
        if (localObject != null) {
          this.dhJ = c.fs((String)localObject);
        }
      }
      Object localObject = this.dhJ;
      AppMethodBeat.o(116384);
      return localObject;
    }
    
    public final String Vf()
    {
      AppMethodBeat.i(116385);
      if (this.dhz != null) {
        this.dhV = this.dhz.optString("ServicePhone");
      }
      String str = this.dhV;
      AppMethodBeat.o(116385);
      return str;
    }
    
    public final boolean Vg()
    {
      AppMethodBeat.i(116386);
      if (this.dhz != null) {
        this.dhX = this.dhz.optInt("FunctionFlag");
      }
      if ((this.dhX & c.dht) > 0)
      {
        AppMethodBeat.o(116386);
        return true;
      }
      AppMethodBeat.o(116386);
      return false;
    }
    
    public final c.b.c.a Vh()
    {
      AppMethodBeat.i(116388);
      if ((this.dhz != null) && (this.dhL == null))
      {
        localObject = this.dhz.optString("EnterpriseBizInfo");
        if (localObject != null) {
          this.dhL = c.b.c.a.ft((String)localObject);
        }
      }
      Object localObject = this.dhL;
      AppMethodBeat.o(116388);
      return localObject;
    }
    
    public final int getServiceType()
    {
      AppMethodBeat.i(116382);
      if (this.dhz != null) {
        this.serviceType = this.dhz.optInt("ServiceType", 0);
      }
      int i = this.serviceType;
      AppMethodBeat.o(116382);
      return i;
    }
    
    public final List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
    {
      AppMethodBeat.i(116365);
      Object localObject1;
      if (this.did == null)
      {
        this.did = new LinkedList();
        if (this.dhz != null)
        {
          localObject1 = this.dhz.optString("BindWxaInfo");
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
              localWxaEntryInfo.lgO = str3;
              localWxaEntryInfo.iconUrl = ((String)localObject2);
              this.did.add(localWxaEntryInfo);
            }
          }
          i += 1;
          continue;
          localList = null;
        }
        catch (JSONException localJSONException) {}
        continue;
        label219:
        List localList = this.did;
        AppMethodBeat.o(116365);
        return localList;
        label232:
        localList = null;
      }
    }
    
    public static final class c
    {
      public int dii;
      public List<k> dij = null;
      public int type;
      
      public static c fs(String paramString)
      {
        AppMethodBeat.i(116359);
        Log.i("MicroMsg.BizInfo", "MenuInfo = ".concat(String.valueOf(paramString)));
        c localc = new c();
        if ((paramString == null) || (paramString.length() <= 0))
        {
          AppMethodBeat.o(116359);
          return localc;
        }
        try
        {
          paramString = new JSONObject(paramString);
          localc.dii = paramString.optInt("update_time");
          localc.type = paramString.optInt("type", 0);
          localc.dij = k.e(paramString.optJSONArray("button_list"));
          AppMethodBeat.o(116359);
          return localc;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.BizInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          }
        }
      }
      
      public static final class a
      {
        public long appid = 0L;
        public String dik;
        public String dil;
        public int dim;
        public String din;
        public String dio;
        
        public static a ft(String paramString)
        {
          AppMethodBeat.i(116358);
          Log.i("MicroMsg.BizInfo", "EnterpriseBizInfo = ".concat(String.valueOf(paramString)));
          a locala = new a();
          if ((paramString == null) || (paramString.length() <= 0))
          {
            AppMethodBeat.o(116358);
            return locala;
          }
          try
          {
            paramString = new JSONObject(paramString);
            locala.dik = paramString.optString("belong");
            locala.dil = paramString.optString("freeze_wording");
            locala.dim = paramString.optInt("child_type");
            locala.din = paramString.optString("home_url");
            paramString = paramString.optString("exattr");
            if (Util.isNullOrNil(paramString)) {
              locala.dio = null;
            }
            for (;;)
            {
              AppMethodBeat.o(116358);
              return locala;
              paramString = new JSONObject(paramString);
              locala.dio = paramString.optString("chat_extension_url");
              locala.appid = paramString.optLong("app_id");
            }
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              Log.e("MicroMsg.BizInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
            }
          }
        }
      }
    }
    
    public static final class d {}
    
    public static final class e
    {
      public int dip = 0;
      public String diq;
      public String dis;
      public String dit;
      public String diu;
      
      public static e fu(String paramString)
      {
        AppMethodBeat.i(116361);
        if (Util.isNullOrNil(paramString))
        {
          AppMethodBeat.o(116361);
          return null;
        }
        Log.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[] { paramString });
        e locale = new e();
        try
        {
          paramString = new JSONObject(paramString);
          locale.dip = paramString.optInt("Type");
          locale.diq = paramString.optString("Description");
          locale.dis = paramString.optString("Name");
          locale.dit = paramString.optString("IntroUrl");
          locale.diu = paramString.optString("VerifySubTitle");
          Log.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[] { Integer.valueOf(locale.dip), locale.diq, locale.dis, locale.dit });
          AppMethodBeat.o(116361);
          return locale;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.BizInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          }
        }
      }
    }
    
    public static final class f
    {
      public int div;
      public String diw;
      public List<String> dix;
      public String diy;
      
      public static f fv(String paramString)
      {
        AppMethodBeat.i(116362);
        if (Util.isNullOrNil(paramString))
        {
          AppMethodBeat.o(116362);
          return null;
        }
        try
        {
          f localf = new f();
          paramString = new JSONObject(paramString);
          localf.div = paramString.optInt("reputation_level", -1);
          localf.diw = paramString.optString("scope_of_business");
          localf.diy = paramString.optString("guarantee_detail_h5_url");
          paramString = paramString.optJSONArray("guarantee_info");
          if (paramString != null)
          {
            int j = paramString.length();
            if (j > 0)
            {
              localf.dix = new ArrayList();
              int i = 0;
              while (i < j)
              {
                String str = paramString.getString(i);
                if (!Util.isNullOrNil(str)) {
                  localf.dix.add(str);
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
          Log.e("MicroMsg.BizInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          AppMethodBeat.o(116362);
        }
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.c
 * JD-Core Version:    0.7.0.1
 */