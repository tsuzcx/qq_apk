package com.tencent.mm.api;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.k;
import com.tencent.mm.autogen.b.am;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ct.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends am
{
  public static int hcA;
  private static int hcD;
  private static b hcE;
  public static int hcy;
  public static int hcz;
  public static IAutoDBItem.MAutoDBInfo info;
  private List<a> hcB;
  public b hcC;
  
  static
  {
    AppMethodBeat.i(116408);
    hcy = 1;
    hcz = 0;
    hcA = 1;
    info = am.aJm();
    hcD = 0;
    hcE = null;
    AppMethodBeat.o(116408);
  }
  
  private boolean nG(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  private void nH(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
  
  public final boolean aAH()
  {
    return (this.field_brandFlag & 0x1) == 0;
  }
  
  public final boolean aAI()
  {
    return (this.field_brandFlag & 0x4) != 0;
  }
  
  public final boolean aAJ()
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
  
  public final void aAK()
  {
    AppMethodBeat.i(116391);
    dO(false);
    b localb = this.hcC;
    if (localb.hcG != null) {
      localb.hcV = localb.hcG.optInt("ConnectorMsgType");
    }
    this.field_acceptType = localb.hcV;
    this.field_type = dO(false).getServiceType();
    if (aAR())
    {
      nH(1);
      AppMethodBeat.o(116391);
      return;
    }
    this.field_bitFlag &= 0xFFFFFFFE;
    AppMethodBeat.o(116391);
  }
  
  public final boolean aAL()
  {
    AppMethodBeat.i(116392);
    dO(false);
    Log.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[] { this.field_username, Boolean.valueOf(this.hcC.aAL()) });
    boolean bool = this.hcC.aAL();
    AppMethodBeat.o(116392);
    return bool;
  }
  
  public final boolean aAM()
  {
    AppMethodBeat.i(116393);
    dO(false);
    if (this.field_type == 1)
    {
      AppMethodBeat.o(116393);
      return true;
    }
    AppMethodBeat.o(116393);
    return false;
  }
  
  public final boolean aAN()
  {
    AppMethodBeat.i(116394);
    dO(false);
    if (this.field_type == 0)
    {
      AppMethodBeat.o(116394);
      return true;
    }
    AppMethodBeat.o(116394);
    return false;
  }
  
  public final boolean aAO()
  {
    AppMethodBeat.i(116395);
    dO(false);
    if ((this.field_type == 2) || (this.field_type == 3))
    {
      AppMethodBeat.o(116395);
      return true;
    }
    AppMethodBeat.o(116395);
    return false;
  }
  
  public final boolean aAP()
  {
    AppMethodBeat.i(116396);
    dO(false);
    if (this.field_type == 2)
    {
      AppMethodBeat.o(116396);
      return true;
    }
    AppMethodBeat.o(116396);
    return false;
  }
  
  public final boolean aAQ()
  {
    AppMethodBeat.i(116397);
    dO(false);
    if (this.field_type == 3)
    {
      AppMethodBeat.o(116397);
      return true;
    }
    AppMethodBeat.o(116397);
    return false;
  }
  
  public final boolean aAR()
  {
    AppMethodBeat.i(116398);
    dO(false);
    boolean bool;
    if ((this.hcC != null) && (this.hcC.aBr() != null)) {
      if (this.hcC.hcS.hdu == 1)
      {
        bool = true;
        if ((bool) && (!nG(1)))
        {
          nH(1);
          ((q)h.ax(q.class)).a(this);
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
  
  public final boolean aAS()
  {
    AppMethodBeat.i(116399);
    dO(false);
    boolean bool;
    if ((this.hcC != null) && (this.hcC.aBr() != null)) {
      if (this.hcC.hcS.hdu == 2)
      {
        bool = true;
        if ((bool) && (!nG(2)))
        {
          nH(2);
          ((q)h.ax(q.class)).a(this);
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
  
  public final String aAT()
  {
    AppMethodBeat.i(116400);
    dO(false);
    if (this.hcC != null)
    {
      Object localObject = this.hcC.aBr();
      if ((localObject != null) && (((c.b.c.a)localObject).hdv != null) && (!((c.b.c.a)localObject).hdv.isEmpty()))
      {
        localObject = ((c.b.c.a)localObject).hdv;
        AppMethodBeat.o(116400);
        return localObject;
      }
    }
    AppMethodBeat.o(116400);
    return null;
  }
  
  public final long aAU()
  {
    AppMethodBeat.i(116401);
    dO(false);
    if (this.hcC != null)
    {
      c.b.c.a locala = this.hcC.aBr();
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
  
  public final boolean aAV()
  {
    AppMethodBeat.i(116402);
    dO(false);
    if (this.hcC == null)
    {
      Log.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (this.hcC.aBl() == null)
    {
      Log.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
      AppMethodBeat.o(116402);
      return true;
    }
    if (!this.hcC.aBl().hdJ)
    {
      AppMethodBeat.o(116402);
      return true;
    }
    AppMethodBeat.o(116402);
    return false;
  }
  
  public final String aAW()
  {
    AppMethodBeat.i(116403);
    dO(false);
    if (this.hcC != null)
    {
      Object localObject = this.hcC.aBr();
      if (localObject != null)
      {
        localObject = ((c.b.c.a)localObject).hdw;
        AppMethodBeat.o(116403);
        return localObject;
      }
    }
    AppMethodBeat.o(116403);
    return null;
  }
  
  public final String aAX()
  {
    AppMethodBeat.i(116404);
    try
    {
      String str1 = dO(false).aBr().hds;
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
  public final List<a> aAY()
  {
    // Byte code:
    //   0: ldc_w 284
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 286	com/tencent/mm/api/c:hcB	Ljava/util/List;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: getfield 286	com/tencent/mm/api/c:hcB	Ljava/util/List;
    //   17: astore_2
    //   18: ldc_w 284
    //   21: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_2
    //   25: areturn
    //   26: aload_0
    //   27: new 288	java/util/LinkedList
    //   30: dup
    //   31: invokespecial 289	java/util/LinkedList:<init>	()V
    //   34: putfield 286	com/tencent/mm/api/c:hcB	Ljava/util/List;
    //   37: aload_0
    //   38: getfield 292	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   41: ifnull +13 -> 54
    //   44: aload_0
    //   45: getfield 292	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   48: invokevirtual 295	java/lang/String:length	()I
    //   51: ifne +16 -> 67
    //   54: aload_0
    //   55: getfield 286	com/tencent/mm/api/c:hcB	Ljava/util/List;
    //   58: astore_2
    //   59: ldc_w 284
    //   62: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_2
    //   66: areturn
    //   67: new 132	org/json/JSONObject
    //   70: dup
    //   71: aload_0
    //   72: getfield 292	com/tencent/mm/api/c:field_brandInfo	Ljava/lang/String;
    //   75: invokespecial 298	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   78: ldc_w 300
    //   81: invokevirtual 304	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   84: astore_2
    //   85: iconst_0
    //   86: istore_1
    //   87: iload_1
    //   88: aload_2
    //   89: invokevirtual 307	org/json/JSONArray:length	()I
    //   92: if_icmpge +104 -> 196
    //   95: new 6	com/tencent/mm/api/c$a
    //   98: dup
    //   99: invokespecial 308	com/tencent/mm/api/c$a:<init>	()V
    //   102: astore_3
    //   103: aload_2
    //   104: iload_1
    //   105: invokevirtual 312	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   108: astore 4
    //   110: aload_3
    //   111: aload 4
    //   113: ldc_w 314
    //   116: invokevirtual 318	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putfield 320	com/tencent/mm/api/c$a:title	Ljava/lang/String;
    //   122: aload_3
    //   123: aload 4
    //   125: ldc_w 322
    //   128: invokevirtual 318	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 324	com/tencent/mm/api/c$a:url	Ljava/lang/String;
    //   134: aload_3
    //   135: aload 4
    //   137: ldc_w 326
    //   140: invokevirtual 318	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 329	com/tencent/mm/api/c$a:hcF	Ljava/lang/String;
    //   146: aload_3
    //   147: aload 4
    //   149: ldc_w 331
    //   152: invokevirtual 318	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 333	com/tencent/mm/api/c$a:description	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 286	com/tencent/mm/api/c:hcB	Ljava/util/List;
    //   162: aload_3
    //   163: invokeinterface 339 2 0
    //   168: pop
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: goto -86 -> 87
    //   176: astore_2
    //   177: ldc 158
    //   179: ldc_w 341
    //   182: iconst_1
    //   183: anewarray 162	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload_2
    //   189: invokestatic 345	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_0
    //   197: getfield 286	com/tencent/mm/api/c:hcB	Ljava/util/List;
    //   200: astore_2
    //   201: ldc_w 284
    //   204: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final b dO(boolean paramBoolean)
  {
    AppMethodBeat.i(116389);
    b localb;
    if ((this.hcC == null) || (paramBoolean))
    {
      if ((!Util.isNullOrNil(this.field_extInfo)) && (hcD == this.field_extInfo.hashCode())) {
        this.hcC = hcE;
      }
    }
    else
    {
      localb = this.hcC;
      AppMethodBeat.o(116389);
      return localb;
    }
    if ((au.bwJ(this.field_username)) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()))
    {
      localb = b.hD(ct.c.bDK());
      this.hcC = localb;
    }
    for (hcE = localb;; hcE = localb)
    {
      hcD = Util.nullAsNil(this.field_extInfo).hashCode();
      break;
      localb = b.hD(this.field_extInfo);
      this.hcC = localb;
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public static final class a
  {
    public String description;
    public String hcF;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    public JSONObject hcG = null;
    private boolean hcH = true;
    public boolean hcI = false;
    private boolean hcJ = false;
    public boolean hcK = false;
    private String hcL;
    private String hcM;
    private List<c.b.g> hcN = null;
    private e hcO = null;
    private d hcP = null;
    private c hcQ = null;
    private f hcR = null;
    c.b.c.a hcS = null;
    private boolean hcT = false;
    public boolean hcU = false;
    int hcV;
    public boolean hcW = false;
    public int hcX = 0;
    private String hcY;
    private c.b.b hcZ = null;
    private int hda = 0;
    private int hdb = c.hcz;
    private String hdc;
    private boolean hdd = false;
    private int hde;
    private c.b.h hdf;
    private String hdg;
    private String hdh;
    private boolean hdi = false;
    public c.b.a hdj;
    private List<WxaAttributes.WxaEntryInfo> hdk;
    private int serviceType = 0;
    
    static b hD(String paramString)
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
        localb.hcG = new JSONObject(paramString);
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
    
    public final boolean aAL()
    {
      boolean bool = false;
      AppMethodBeat.i(116380);
      if (this.hcG != null)
      {
        if (Util.getInt(this.hcG.optString("ReportLocationType"), 0) > 0) {
          bool = true;
        }
        this.hcT = bool;
      }
      bool = this.hcT;
      AppMethodBeat.o(116380);
      return bool;
    }
    
    public final boolean aAZ()
    {
      AppMethodBeat.i(116366);
      if ((this.hcG != null) && (this.hcG.optJSONObject("WifiBizInfo") != null) && (this.hcG.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") == 1)) {
        this.hdi = true;
      }
      boolean bool = this.hdi;
      AppMethodBeat.o(116366);
      return bool;
    }
    
    public final boolean aBa()
    {
      AppMethodBeat.i(116367);
      if (this.hcG != null) {
        this.hcJ = "1".equals(this.hcG.optString("IsShowMember"));
      }
      boolean bool = this.hcJ;
      AppMethodBeat.o(116367);
      return bool;
    }
    
    public final boolean aBb()
    {
      AppMethodBeat.i(116368);
      if (this.hcG != null) {
        this.hdb = Util.getInt(this.hcG.optString("NotifyManage"), c.hcz);
      }
      if (this.hdb == c.hcy)
      {
        AppMethodBeat.o(116368);
        return true;
      }
      AppMethodBeat.o(116368);
      return false;
    }
    
    public final String aBc()
    {
      AppMethodBeat.i(116369);
      if (this.hcG != null) {
        this.hcL = this.hcG.optString("VerifyContactPromptTitle");
      }
      String str = this.hcL;
      AppMethodBeat.o(116369);
      return str;
    }
    
    public final String aBd()
    {
      AppMethodBeat.i(116370);
      if (this.hcG != null) {
        this.hdg = this.hcG.optString("TrademarkUrl");
      }
      String str = this.hdg;
      AppMethodBeat.o(116370);
      return str;
    }
    
    public final String aBe()
    {
      AppMethodBeat.i(116371);
      if (this.hcG != null) {
        this.hdh = this.hcG.optString("TrademarkName");
      }
      String str = this.hdh;
      AppMethodBeat.o(116371);
      return str;
    }
    
    public final String aBf()
    {
      AppMethodBeat.i(116372);
      if (this.hcG != null) {
        this.hcM = this.hcG.optString("ConferenceContactExpireTime");
      }
      String str = this.hcM;
      AppMethodBeat.o(116372);
      return str;
    }
    
    public final List<c.b.g> aBg()
    {
      AppMethodBeat.i(116373);
      if ((this.hcG != null) && (this.hcN == null)) {
        this.hcN = c.b.g.g(this.hcG.optJSONArray("Privilege"));
      }
      List localList = this.hcN;
      AppMethodBeat.o(116373);
      return localList;
    }
    
    public final int aBh()
    {
      AppMethodBeat.i(116374);
      if (this.hcG != null) {
        this.hda = this.hcG.optInt("InteractiveMode");
      }
      int i = this.hda;
      AppMethodBeat.o(116374);
      return i;
    }
    
    public final f aBi()
    {
      AppMethodBeat.i(116375);
      if ((this.hcG != null) && (this.hcR == null)) {
        this.hcR = f.hJ(this.hcG.optString("PayShowInfo"));
      }
      f localf = this.hcR;
      AppMethodBeat.o(116375);
      return localf;
    }
    
    public final c.b.b aBj()
    {
      AppMethodBeat.i(116376);
      if ((this.hcG != null) && (this.hcZ == null))
      {
        localObject = this.hcG.optString("HardwareBizInfo");
        if (localObject != null) {
          this.hcZ = c.b.b.hF((String)localObject);
        }
      }
      Object localObject = this.hcZ;
      AppMethodBeat.o(116376);
      return localObject;
    }
    
    public final e aBk()
    {
      AppMethodBeat.i(116377);
      if ((this.hcG != null) && (this.hcO == null)) {
        this.hcO = e.hI(this.hcG.optString("VerifySource"));
      }
      e locale = this.hcO;
      AppMethodBeat.o(116377);
      return locale;
    }
    
    public final c.b.h aBl()
    {
      AppMethodBeat.i(116379);
      if ((this.hcG != null) && (this.hdf == null))
      {
        localObject = this.hcG.optString("RegisterSource");
        if (localObject != null) {
          this.hdf = c.b.h.hK((String)localObject);
        }
      }
      Object localObject = this.hdf;
      AppMethodBeat.o(116379);
      return localObject;
    }
    
    public final boolean aBm()
    {
      boolean bool = true;
      AppMethodBeat.i(116381);
      if (this.hcG != null) {
        if (Util.getInt(this.hcG.optString("IsTrademarkProtection"), 0) != 1) {
          break label51;
        }
      }
      for (;;)
      {
        this.hdd = bool;
        bool = this.hdd;
        AppMethodBeat.o(116381);
        return bool;
        label51:
        bool = false;
      }
    }
    
    public final String aBn()
    {
      AppMethodBeat.i(116383);
      if (this.hcG != null) {
        this.hcY = this.hcG.optString("SupportEmoticonLinkPrefix");
      }
      String str = this.hcY;
      AppMethodBeat.o(116383);
      return str;
    }
    
    public final c aBo()
    {
      AppMethodBeat.i(116384);
      if ((this.hcG != null) && (this.hcQ == null))
      {
        localObject = this.hcG.optString("MMBizMenu");
        if (localObject != null) {
          this.hcQ = c.hG((String)localObject);
        }
      }
      Object localObject = this.hcQ;
      AppMethodBeat.o(116384);
      return localObject;
    }
    
    public final String aBp()
    {
      AppMethodBeat.i(116385);
      if (this.hcG != null) {
        this.hdc = this.hcG.optString("ServicePhone");
      }
      String str = this.hdc;
      AppMethodBeat.o(116385);
      return str;
    }
    
    public final boolean aBq()
    {
      AppMethodBeat.i(116386);
      if (this.hcG != null) {
        this.hde = this.hcG.optInt("FunctionFlag");
      }
      if ((this.hde & c.hcA) > 0)
      {
        AppMethodBeat.o(116386);
        return true;
      }
      AppMethodBeat.o(116386);
      return false;
    }
    
    public final c.b.c.a aBr()
    {
      AppMethodBeat.i(116388);
      if ((this.hcG != null) && (this.hcS == null))
      {
        localObject = this.hcG.optString("EnterpriseBizInfo");
        if (localObject != null) {
          this.hcS = c.b.c.a.hH((String)localObject);
        }
      }
      Object localObject = this.hcS;
      AppMethodBeat.o(116388);
      return localObject;
    }
    
    public final int getServiceType()
    {
      AppMethodBeat.i(116382);
      if (this.hcG != null) {
        this.serviceType = this.hcG.optInt("ServiceType", 0);
      }
      int i = this.serviceType;
      AppMethodBeat.o(116382);
      return i;
    }
    
    public final List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
    {
      AppMethodBeat.i(116365);
      Object localObject1;
      if (this.hdk == null)
      {
        this.hdk = new LinkedList();
        if (this.hcG != null)
        {
          localObject1 = this.hcG.optString("BindWxaInfo");
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
              localWxaEntryInfo.rcg = str3;
              localWxaEntryInfo.iconUrl = ((String)localObject2);
              this.hdk.add(localWxaEntryInfo);
            }
          }
          i += 1;
          continue;
          localList = null;
        }
        catch (JSONException localJSONException) {}
        continue;
        label219:
        List localList = this.hdk;
        AppMethodBeat.o(116365);
        return localList;
        label232:
        localList = null;
      }
    }
    
    public static final class c
    {
      public int hdp;
      public List<k> hdq = null;
      public int type;
      
      public static c hG(String paramString)
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
          localc.hdp = paramString.optInt("update_time");
          localc.type = paramString.optInt("type", 0);
          localc.hdq = k.h(paramString.optJSONArray("button_list"));
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
        public String hds;
        public String hdt;
        public int hdu;
        public String hdv;
        public String hdw;
        
        public static a hH(String paramString)
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
            locala.hds = paramString.optString("belong");
            locala.hdt = paramString.optString("freeze_wording");
            locala.hdu = paramString.optInt("child_type");
            locala.hdv = paramString.optString("home_url");
            paramString = paramString.optString("exattr");
            if (Util.isNullOrNil(paramString)) {
              locala.hdw = null;
            }
            for (;;)
            {
              AppMethodBeat.o(116358);
              return locala;
              paramString = new JSONObject(paramString);
              locala.hdw = paramString.optString("chat_extension_url");
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
      public String hdA;
      public String hdB;
      public int hdx = 0;
      public String hdy;
      public String hdz;
      
      public static e hI(String paramString)
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
          locale.hdx = paramString.optInt("Type");
          locale.hdy = paramString.optString("Description");
          locale.hdz = paramString.optString("Name");
          locale.hdA = paramString.optString("IntroUrl");
          locale.hdB = paramString.optString("VerifySubTitle");
          Log.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[] { Integer.valueOf(locale.hdx), locale.hdy, locale.hdz, locale.hdA });
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
      public int hdC;
      public String hdD;
      public List<String> hdE;
      public String hdF;
      
      public static f hJ(String paramString)
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
          localf.hdC = paramString.optInt("reputation_level", -1);
          localf.hdD = paramString.optString("scope_of_business");
          localf.hdF = paramString.optString("guarantee_detail_h5_url");
          paramString = paramString.optJSONArray("guarantee_info");
          if (paramString != null)
          {
            int j = paramString.length();
            if (j > 0)
            {
              localf.hdE = new ArrayList();
              int i = 0;
              while (i < j)
              {
                String str = paramString.getString(i);
                if (!Util.isNullOrNil(str)) {
                  localf.hdE.add(str);
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