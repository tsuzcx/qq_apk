package com.tencent.mm.api;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.k;
import com.tencent.mm.f.c.al;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cs.c;
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
  public static int eYY;
  public static int eYZ;
  public static int eZa;
  private static int eZd;
  private static b eZe;
  public static IAutoDBItem.MAutoDBInfo info;
  private List<a> eZb;
  public b eZc;
  
  static
  {
    AppMethodBeat.i(116408);
    eYY = 1;
    eYZ = 0;
    eZa = 1;
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
    eZd = 0;
    eZe = null;
    AppMethodBeat.o(116408);
  }
  
  private boolean jQ(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  private void jR(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
  
  public final b YO()
  {
    AppMethodBeat.i(196813);
    b localb = dc(false);
    AppMethodBeat.o(196813);
    return localb;
  }
  
  public final boolean YP()
  {
    return (this.field_brandFlag & 0x1) == 0;
  }
  
  public final boolean YQ()
  {
    return (this.field_brandFlag & 0x4) != 0;
  }
  
  public final boolean YR()
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
  
  public final void YS()
  {
    AppMethodBeat.i(116391);
    dc(false);
    b localb = this.eZc;
    if (localb.eZg != null) {
      localb.eZv = localb.eZg.optInt("ConnectorMsgType");
    }
    this.field_acceptType = localb.eZv;
    this.field_type = dc(false).getServiceType();
    if (YZ())
    {
      jR(1);
      AppMethodBeat.o(116391);
      return;
    }
    this.field_bitFlag &= 0xFFFFFFFE;
    AppMethodBeat.o(116391);
  }
  
  public final boolean YT()
  {
    AppMethodBeat.i(116392);
    dc(false);
    Log.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[] { this.field_username, Boolean.valueOf(this.eZc.YT()) });
    boolean bool = this.eZc.YT();
    AppMethodBeat.o(116392);
    return bool;
  }
  
  public final boolean YU()
  {
    AppMethodBeat.i(116393);
    dc(false);
    if (this.field_type == 1)
    {
      AppMethodBeat.o(116393);
      return true;
    }
    AppMethodBeat.o(116393);
    return false;
  }
  
  public final boolean YV()
  {
    AppMethodBeat.i(116394);
    dc(false);
    if (this.field_type == 0)
    {
      AppMethodBeat.o(116394);
      return true;
    }
    AppMethodBeat.o(116394);
    return false;
  }
  
  public final boolean YW()
  {
    AppMethodBeat.i(116395);
    dc(false);
    if ((this.field_type == 2) || (this.field_type == 3))
    {
      AppMethodBeat.o(116395);
      return true;
    }
    AppMethodBeat.o(116395);
    return false;
  }
  
  public final boolean YX()
  {
    AppMethodBeat.i(116396);
    dc(false);
    if (this.field_type == 2)
    {
      AppMethodBeat.o(116396);
      return true;
    }
    AppMethodBeat.o(116396);
    return false;
  }
  
  public final boolean YY()
  {
    AppMethodBeat.i(116397);
    dc(false);
    if (this.field_type == 3)
    {
      AppMethodBeat.o(116397);
      return true;
    }
    AppMethodBeat.o(116397);
    return false;
  }
  
  public final boolean YZ()
  {
    AppMethodBeat.i(116398);
    dc(false);
    boolean bool;
    if ((this.eZc != null) && (this.eZc.Zz() != null)) {
      if (this.eZc.eZs.eZT == 1)
      {
        bool = true;
        if ((bool) && (!jQ(1)))
        {
          jR(1);
          ((p)h.ae(p.class)).a(this);
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
  
  public final boolean Za()
  {
    AppMethodBeat.i(116399);
    dc(false);
    boolean bool;
    if ((this.eZc != null) && (this.eZc.Zz() != null)) {
      if (this.eZc.eZs.eZT == 2)
      {
        bool = true;
        if ((bool) && (!jQ(2)))
        {
          jR(2);
          ((p)h.ae(p.class)).a(this);
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
  
  public final String Zb()
  {
    AppMethodBeat.i(116400);
    dc(false);
    if (this.eZc != null)
    {
      Object localObject = this.eZc.Zz();
      if ((localObject != null) && (((c.b.c.a)localObject).eZU != null) && (!((c.b.c.a)localObject).eZU.isEmpty()))
      {
        localObject = ((c.b.c.a)localObject).eZU;
        AppMethodBeat.o(116400);
        return localObject;
      }
    }
    AppMethodBeat.o(116400);
    return null;
  }
  
  public final long Zc()
  {
    AppMethodBeat.i(116401);
    dc(false);
    if (this.eZc != null)
    {
      c.b.c.a locala = this.eZc.Zz();
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
  
  public final boolean Zd()
  {
    AppMethodBeat.i(116402);
    dc(false);
    if (this.eZc == null)
    {
      Log.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (this.eZc.Zt() == null)
    {
      Log.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (!this.eZc.Zt().fai)
    {
      AppMethodBeat.o(116402);
      return true;
    }
    AppMethodBeat.o(116402);
    return false;
  }
  
  public final String Ze()
  {
    AppMethodBeat.i(116403);
    dc(false);
    if (this.eZc != null)
    {
      Object localObject = this.eZc.Zz();
      if (localObject != null)
      {
        localObject = ((c.b.c.a)localObject).eZV;
        AppMethodBeat.o(116403);
        return localObject;
      }
    }
    AppMethodBeat.o(116403);
    return null;
  }
  
  public final String Zf()
  {
    AppMethodBeat.i(116404);
    try
    {
      String str1 = dc(false).Zz().eZR;
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
  public final List<a> Zg()
  {
    // Byte code:
    //   0: ldc_w 419
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 421	com/tencent/mm/api/c:eZb	Ljava/util/List;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: getfield 421	com/tencent/mm/api/c:eZb	Ljava/util/List;
    //   17: astore_2
    //   18: ldc_w 419
    //   21: invokestatic 211	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_2
    //   25: areturn
    //   26: aload_0
    //   27: new 423	java/util/LinkedList
    //   30: dup
    //   31: invokespecial 424	java/util/LinkedList:<init>	()V
    //   34: putfield 421	com/tencent/mm/api/c:eZb	Ljava/util/List;
    //   37: aload_0
    //   38: getfield 427	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   41: ifnull +13 -> 54
    //   44: aload_0
    //   45: getfield 427	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   48: invokevirtual 430	java/lang/String:length	()I
    //   51: ifne +16 -> 67
    //   54: aload_0
    //   55: getfield 421	com/tencent/mm/api/c:eZb	Ljava/util/List;
    //   58: astore_2
    //   59: ldc_w 419
    //   62: invokestatic 211	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_2
    //   66: areturn
    //   67: new 271	org/json/JSONObject
    //   70: dup
    //   71: aload_0
    //   72: getfield 427	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   75: invokespecial 433	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   78: ldc_w 435
    //   81: invokevirtual 439	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   84: astore_2
    //   85: iconst_0
    //   86: istore_1
    //   87: iload_1
    //   88: aload_2
    //   89: invokevirtual 442	org/json/JSONArray:length	()I
    //   92: if_icmpge +105 -> 197
    //   95: new 6	com/tencent/mm/api/c$a
    //   98: dup
    //   99: invokespecial 443	com/tencent/mm/api/c$a:<init>	()V
    //   102: astore_3
    //   103: aload_2
    //   104: iload_1
    //   105: invokevirtual 447	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   108: astore 4
    //   110: aload_3
    //   111: aload 4
    //   113: ldc_w 449
    //   116: invokevirtual 453	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putfield 455	com/tencent/mm/api/c$a:title	Ljava/lang/String;
    //   122: aload_3
    //   123: aload 4
    //   125: ldc_w 457
    //   128: invokevirtual 453	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 459	com/tencent/mm/api/c$a:url	Ljava/lang/String;
    //   134: aload_3
    //   135: aload 4
    //   137: ldc_w 461
    //   140: invokevirtual 453	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 464	com/tencent/mm/api/c$a:eZf	Ljava/lang/String;
    //   146: aload_3
    //   147: aload 4
    //   149: ldc_w 466
    //   152: invokevirtual 453	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 468	com/tencent/mm/api/c$a:description	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 421	com/tencent/mm/api/c:eZb	Ljava/util/List;
    //   162: aload_3
    //   163: invokeinterface 474 2 0
    //   168: pop
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: goto -86 -> 87
    //   176: astore_2
    //   177: ldc_w 297
    //   180: ldc_w 476
    //   183: iconst_1
    //   184: anewarray 301	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: invokestatic 480	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_0
    //   198: getfield 421	com/tencent/mm/api/c:eZb	Ljava/util/List;
    //   201: astore_2
    //   202: ldc_w 419
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
  
  public final b dc(boolean paramBoolean)
  {
    AppMethodBeat.i(116389);
    b localb;
    if ((this.eZc == null) || (paramBoolean))
    {
      if ((!Util.isNullOrNil(this.field_extInfo)) && (eZd == this.field_extInfo.hashCode())) {
        this.eZc = eZe;
      }
    }
    else
    {
      localb = this.eZc;
      AppMethodBeat.o(116389);
      return localb;
    }
    if ((ab.PN(this.field_username)) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()))
    {
      localb = b.ga(cs.c.bfT());
      this.eZc = localb;
    }
    for (eZe = localb;; eZe = localb)
    {
      eZd = Util.nullAsNil(this.field_extInfo).hashCode();
      break;
      localb = b.ga(this.field_extInfo);
      this.eZc = localb;
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public static final class a
  {
    public String description;
    public String eZf;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    private int eZA = 0;
    private int eZB = c.eYZ;
    private String eZC;
    private boolean eZD = false;
    private int eZE;
    private h eZF;
    private String eZG;
    private String eZH;
    private boolean eZI = false;
    public c.b.a eZJ;
    private List<WxaAttributes.WxaEntryInfo> eZK;
    public JSONObject eZg = null;
    private boolean eZh = true;
    public boolean eZi = false;
    private boolean eZj = false;
    public boolean eZk = false;
    private String eZl;
    private String eZm;
    private List<c.b.g> eZn = null;
    private e eZo = null;
    private d eZp = null;
    private c eZq = null;
    private f eZr = null;
    c.b.c.a eZs = null;
    private boolean eZt = false;
    public boolean eZu = false;
    int eZv;
    public boolean eZw = false;
    public int eZx = 0;
    private String eZy;
    private c.b.b eZz = null;
    private int serviceType = 0;
    
    static b ga(String paramString)
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
        localb.eZg = new JSONObject(paramString);
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
    
    public final boolean YT()
    {
      boolean bool = false;
      AppMethodBeat.i(116380);
      if (this.eZg != null)
      {
        if (Util.getInt(this.eZg.optString("ReportLocationType"), 0) > 0) {
          bool = true;
        }
        this.eZt = bool;
      }
      bool = this.eZt;
      AppMethodBeat.o(116380);
      return bool;
    }
    
    public final boolean Zh()
    {
      AppMethodBeat.i(116366);
      if ((this.eZg != null) && (this.eZg.optJSONObject("WifiBizInfo") != null) && (this.eZg.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") == 1)) {
        this.eZI = true;
      }
      boolean bool = this.eZI;
      AppMethodBeat.o(116366);
      return bool;
    }
    
    public final boolean Zi()
    {
      AppMethodBeat.i(116367);
      if (this.eZg != null) {
        this.eZj = "1".equals(this.eZg.optString("IsShowMember"));
      }
      boolean bool = this.eZj;
      AppMethodBeat.o(116367);
      return bool;
    }
    
    public final boolean Zj()
    {
      AppMethodBeat.i(116368);
      if (this.eZg != null) {
        this.eZB = Util.getInt(this.eZg.optString("NotifyManage"), c.eYZ);
      }
      if (this.eZB == c.eYY)
      {
        AppMethodBeat.o(116368);
        return true;
      }
      AppMethodBeat.o(116368);
      return false;
    }
    
    public final String Zk()
    {
      AppMethodBeat.i(116369);
      if (this.eZg != null) {
        this.eZl = this.eZg.optString("VerifyContactPromptTitle");
      }
      String str = this.eZl;
      AppMethodBeat.o(116369);
      return str;
    }
    
    public final String Zl()
    {
      AppMethodBeat.i(116370);
      if (this.eZg != null) {
        this.eZG = this.eZg.optString("TrademarkUrl");
      }
      String str = this.eZG;
      AppMethodBeat.o(116370);
      return str;
    }
    
    public final String Zm()
    {
      AppMethodBeat.i(116371);
      if (this.eZg != null) {
        this.eZH = this.eZg.optString("TrademarkName");
      }
      String str = this.eZH;
      AppMethodBeat.o(116371);
      return str;
    }
    
    public final String Zn()
    {
      AppMethodBeat.i(116372);
      if (this.eZg != null) {
        this.eZm = this.eZg.optString("ConferenceContactExpireTime");
      }
      String str = this.eZm;
      AppMethodBeat.o(116372);
      return str;
    }
    
    public final List<c.b.g> Zo()
    {
      AppMethodBeat.i(116373);
      if ((this.eZg != null) && (this.eZn == null)) {
        this.eZn = c.b.g.d(this.eZg.optJSONArray("Privilege"));
      }
      List localList = this.eZn;
      AppMethodBeat.o(116373);
      return localList;
    }
    
    public final int Zp()
    {
      AppMethodBeat.i(116374);
      if (this.eZg != null) {
        this.eZA = this.eZg.optInt("InteractiveMode");
      }
      int i = this.eZA;
      AppMethodBeat.o(116374);
      return i;
    }
    
    public final f Zq()
    {
      AppMethodBeat.i(116375);
      if ((this.eZg != null) && (this.eZr == null)) {
        this.eZr = f.gg(this.eZg.optString("PayShowInfo"));
      }
      f localf = this.eZr;
      AppMethodBeat.o(116375);
      return localf;
    }
    
    public final c.b.b Zr()
    {
      AppMethodBeat.i(116376);
      if ((this.eZg != null) && (this.eZz == null))
      {
        localObject = this.eZg.optString("HardwareBizInfo");
        if (localObject != null) {
          this.eZz = c.b.b.gc((String)localObject);
        }
      }
      Object localObject = this.eZz;
      AppMethodBeat.o(116376);
      return localObject;
    }
    
    public final e Zs()
    {
      AppMethodBeat.i(116377);
      if ((this.eZg != null) && (this.eZo == null)) {
        this.eZo = e.gf(this.eZg.optString("VerifySource"));
      }
      e locale = this.eZo;
      AppMethodBeat.o(116377);
      return locale;
    }
    
    public final h Zt()
    {
      AppMethodBeat.i(116379);
      if ((this.eZg != null) && (this.eZF == null))
      {
        localObject = this.eZg.optString("RegisterSource");
        if (localObject != null) {
          this.eZF = h.gh((String)localObject);
        }
      }
      Object localObject = this.eZF;
      AppMethodBeat.o(116379);
      return localObject;
    }
    
    public final boolean Zu()
    {
      boolean bool = true;
      AppMethodBeat.i(116381);
      if (this.eZg != null) {
        if (Util.getInt(this.eZg.optString("IsTrademarkProtection"), 0) != 1) {
          break label51;
        }
      }
      for (;;)
      {
        this.eZD = bool;
        bool = this.eZD;
        AppMethodBeat.o(116381);
        return bool;
        label51:
        bool = false;
      }
    }
    
    public final String Zv()
    {
      AppMethodBeat.i(116383);
      if (this.eZg != null) {
        this.eZy = this.eZg.optString("SupportEmoticonLinkPrefix");
      }
      String str = this.eZy;
      AppMethodBeat.o(116383);
      return str;
    }
    
    public final c Zw()
    {
      AppMethodBeat.i(116384);
      if ((this.eZg != null) && (this.eZq == null))
      {
        localObject = this.eZg.optString("MMBizMenu");
        if (localObject != null) {
          this.eZq = c.gd((String)localObject);
        }
      }
      Object localObject = this.eZq;
      AppMethodBeat.o(116384);
      return localObject;
    }
    
    public final String Zx()
    {
      AppMethodBeat.i(116385);
      if (this.eZg != null) {
        this.eZC = this.eZg.optString("ServicePhone");
      }
      String str = this.eZC;
      AppMethodBeat.o(116385);
      return str;
    }
    
    public final boolean Zy()
    {
      AppMethodBeat.i(116386);
      if (this.eZg != null) {
        this.eZE = this.eZg.optInt("FunctionFlag");
      }
      if ((this.eZE & c.eZa) > 0)
      {
        AppMethodBeat.o(116386);
        return true;
      }
      AppMethodBeat.o(116386);
      return false;
    }
    
    public final c.b.c.a Zz()
    {
      AppMethodBeat.i(116388);
      if ((this.eZg != null) && (this.eZs == null))
      {
        localObject = this.eZg.optString("EnterpriseBizInfo");
        if (localObject != null) {
          this.eZs = c.b.c.a.ge((String)localObject);
        }
      }
      Object localObject = this.eZs;
      AppMethodBeat.o(116388);
      return localObject;
    }
    
    public final int getServiceType()
    {
      AppMethodBeat.i(116382);
      if (this.eZg != null) {
        this.serviceType = this.eZg.optInt("ServiceType", 0);
      }
      int i = this.serviceType;
      AppMethodBeat.o(116382);
      return i;
    }
    
    public final List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
    {
      AppMethodBeat.i(116365);
      Object localObject1;
      if (this.eZK == null)
      {
        this.eZK = new LinkedList();
        if (this.eZg != null)
        {
          localObject1 = this.eZg.optString("BindWxaInfo");
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
              localWxaEntryInfo.obt = str3;
              localWxaEntryInfo.iconUrl = ((String)localObject2);
              this.eZK.add(localWxaEntryInfo);
            }
          }
          i += 1;
          continue;
          localList = null;
        }
        catch (JSONException localJSONException) {}
        continue;
        label219:
        List localList = this.eZK;
        AppMethodBeat.o(116365);
        return localList;
        label232:
        localList = null;
      }
    }
    
    public static final class c
    {
      public int eZP;
      public List<k> eZQ = null;
      public int type;
      
      public static c gd(String paramString)
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
          localc.eZP = paramString.optInt("update_time");
          localc.type = paramString.optInt("type", 0);
          localc.eZQ = k.e(paramString.optJSONArray("button_list"));
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
        public String eZR;
        public String eZS;
        public int eZT;
        public String eZU;
        public String eZV;
        
        public static a ge(String paramString)
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
            locala.eZR = paramString.optString("belong");
            locala.eZS = paramString.optString("freeze_wording");
            locala.eZT = paramString.optInt("child_type");
            locala.eZU = paramString.optString("home_url");
            paramString = paramString.optString("exattr");
            if (Util.isNullOrNil(paramString)) {
              locala.eZV = null;
            }
            for (;;)
            {
              AppMethodBeat.o(116358);
              return locala;
              paramString = new JSONObject(paramString);
              locala.eZV = paramString.optString("chat_extension_url");
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
      public int eZW = 0;
      public String eZX;
      public String eZY;
      public String eZZ;
      public String faa;
      
      public static e gf(String paramString)
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
          locale.eZW = paramString.optInt("Type");
          locale.eZX = paramString.optString("Description");
          locale.eZY = paramString.optString("Name");
          locale.eZZ = paramString.optString("IntroUrl");
          locale.faa = paramString.optString("VerifySubTitle");
          Log.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[] { Integer.valueOf(locale.eZW), locale.eZX, locale.eZY, locale.eZZ });
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
      public int fab;
      public String fac;
      public List<String> fad;
      public String fae;
      
      public static f gg(String paramString)
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
          localf.fab = paramString.optInt("reputation_level", -1);
          localf.fac = paramString.optString("scope_of_business");
          localf.fae = paramString.optString("guarantee_detail_h5_url");
          paramString = paramString.optJSONArray("guarantee_info");
          if (paramString != null)
          {
            int j = paramString.length();
            if (j > 0)
            {
              localf.fad = new ArrayList();
              int i = 0;
              while (i < j)
              {
                String str = paramString.getString(i);
                if (!Util.isNullOrNil(str)) {
                  localf.fad.add(str);
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
    
    public static final class h
    {
      public String fag;
      public String fah;
      public boolean fai;
      public String faj;
      
      public static h gh(String paramString)
      {
        AppMethodBeat.i(116364);
        Log.i("MicroMsg.BizInfo", "RegisterSource = %s", new Object[] { paramString });
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
            localh.fag = paramString.optString("RegisterBody");
            localh.fah = paramString.optString("IntroUrl");
            if (paramString.optInt("IsClose", 0) != 1) {
              continue;
            }
            bool = true;
            localh.fai = bool;
            localh.faj = paramString.optString("AboutBizUrl");
          }
          catch (JSONException paramString)
          {
            boolean bool;
            Log.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", new Object[] { Util.stackTraceToString(paramString) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.c
 * JD-Core Version:    0.7.0.1
 */