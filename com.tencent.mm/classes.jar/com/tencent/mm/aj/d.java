package com.tencent.mm.aj;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends af
{
  public static int fuU;
  public static int fuV;
  public static int fuW;
  private static int fuZ;
  private static d.b fva;
  protected static c.a info;
  private List<d.a> fuX;
  public d.b fuY;
  
  static
  {
    AppMethodBeat.i(11321);
    fuU = 1;
    fuV = 0;
    fuW = 1;
    c.a locala = new c.a();
    locala.yrK = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.yrM.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "username";
    locala.columns[1] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandList";
    locala.yrM.put("brandList", "TEXT default '' ");
    localStringBuilder.append(" brandList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "brandListVersion";
    locala.yrM.put("brandListVersion", "TEXT");
    localStringBuilder.append(" brandListVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "brandListContent";
    locala.yrM.put("brandListContent", "TEXT");
    localStringBuilder.append(" brandListContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandFlag";
    locala.yrM.put("brandFlag", "INTEGER");
    localStringBuilder.append(" brandFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "extInfo";
    locala.yrM.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "brandInfo";
    locala.yrM.put("brandInfo", "TEXT");
    localStringBuilder.append(" brandInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "brandIconURL";
    locala.yrM.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "updateTime";
    locala.yrM.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "hadAlert";
    locala.yrM.put("hadAlert", "INTEGER");
    localStringBuilder.append(" hadAlert INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "acceptType";
    locala.yrM.put("acceptType", "INTEGER default '0' ");
    localStringBuilder.append(" acceptType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "type";
    locala.yrM.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "status";
    locala.yrM.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "enterpriseFather";
    locala.yrM.put("enterpriseFather", "TEXT");
    localStringBuilder.append(" enterpriseFather TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "kfWorkerId";
    locala.yrM.put("kfWorkerId", "TEXT");
    localStringBuilder.append(" kfWorkerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "specialType";
    locala.yrM.put("specialType", "INTEGER");
    localStringBuilder.append(" specialType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "attrSyncVersion";
    locala.yrM.put("attrSyncVersion", "TEXT");
    localStringBuilder.append(" attrSyncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "incrementUpdateTime";
    locala.yrM.put("incrementUpdateTime", "LONG");
    localStringBuilder.append(" incrementUpdateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[19] = "bitFlag";
    locala.yrM.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    fuZ = 0;
    fva = null;
    AppMethodBeat.o(11321);
  }
  
  private boolean kY(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  private void kZ(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
  
  public final boolean adY()
  {
    return (this.field_brandFlag & 0x1) == 0;
  }
  
  public final boolean adZ()
  {
    return (this.field_brandFlag & 0x4) != 0;
  }
  
  public final boolean aea()
  {
    AppMethodBeat.i(11303);
    if (System.currentTimeMillis() - this.field_updateTime > 86400000L)
    {
      AppMethodBeat.o(11303);
      return true;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    if (this.field_updateTime < localCalendar.getTimeInMillis())
    {
      AppMethodBeat.o(11303);
      return true;
    }
    AppMethodBeat.o(11303);
    return false;
  }
  
  public final void aeb()
  {
    AppMethodBeat.i(11304);
    cU(false);
    d.b localb = this.fuY;
    if (localb.fvc != null) {
      localb.fvq = localb.fvc.optInt("ConnectorMsgType");
    }
    this.field_acceptType = localb.fvq;
    this.field_type = cU(false).getServiceType();
    if (aei())
    {
      kZ(1);
      AppMethodBeat.o(11304);
      return;
    }
    this.field_bitFlag &= 0xFFFFFFFE;
    AppMethodBeat.o(11304);
  }
  
  public final boolean aec()
  {
    AppMethodBeat.i(11305);
    cU(false);
    ab.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[] { this.field_username, Boolean.valueOf(this.fuY.aec()) });
    boolean bool = this.fuY.aec();
    AppMethodBeat.o(11305);
    return bool;
  }
  
  public final boolean aed()
  {
    AppMethodBeat.i(11306);
    cU(false);
    if (this.field_type == 1)
    {
      AppMethodBeat.o(11306);
      return true;
    }
    AppMethodBeat.o(11306);
    return false;
  }
  
  public final boolean aee()
  {
    AppMethodBeat.i(11307);
    cU(false);
    if (this.field_type == 0)
    {
      AppMethodBeat.o(11307);
      return true;
    }
    AppMethodBeat.o(11307);
    return false;
  }
  
  public final boolean aef()
  {
    AppMethodBeat.i(11308);
    cU(false);
    if ((this.field_type == 2) || (this.field_type == 3))
    {
      AppMethodBeat.o(11308);
      return true;
    }
    AppMethodBeat.o(11308);
    return false;
  }
  
  public final boolean aeg()
  {
    AppMethodBeat.i(11309);
    cU(false);
    if (this.field_type == 2)
    {
      AppMethodBeat.o(11309);
      return true;
    }
    AppMethodBeat.o(11309);
    return false;
  }
  
  public final boolean aeh()
  {
    AppMethodBeat.i(11310);
    cU(false);
    if (this.field_type == 3)
    {
      AppMethodBeat.o(11310);
      return true;
    }
    AppMethodBeat.o(11310);
    return false;
  }
  
  public final boolean aei()
  {
    AppMethodBeat.i(11311);
    cU(false);
    boolean bool1;
    if ((this.fuY != null) && (this.fuY.aeI() != null)) {
      if (this.fuY.fvn.fvO == 1)
      {
        bool1 = true;
        if ((bool1) && (!kY(1)))
        {
          kZ(1);
          z.afi().e(this);
        }
        bool2 = bool1;
        if (bool1) {
          ab.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", new Object[] { this.field_username });
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      AppMethodBeat.o(11311);
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  public final boolean aej()
  {
    AppMethodBeat.i(11312);
    cU(false);
    boolean bool1;
    if ((this.fuY != null) && (this.fuY.aeI() != null)) {
      if (this.fuY.fvn.fvO == 2)
      {
        bool1 = true;
        if ((bool1) && (!kY(2)))
        {
          kZ(2);
          z.afi().e(this);
        }
        bool2 = bool1;
        if (bool1) {
          ab.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", new Object[] { this.field_username });
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      AppMethodBeat.o(11312);
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  public final String aek()
  {
    AppMethodBeat.i(11313);
    cU(false);
    if (this.fuY != null)
    {
      Object localObject = this.fuY.aeI();
      if ((localObject != null) && (((d.b.c.a)localObject).fvP != null) && (!((d.b.c.a)localObject).fvP.isEmpty()))
      {
        localObject = ((d.b.c.a)localObject).fvP;
        AppMethodBeat.o(11313);
        return localObject;
      }
    }
    AppMethodBeat.o(11313);
    return null;
  }
  
  public final long ael()
  {
    AppMethodBeat.i(11314);
    cU(false);
    if (this.fuY != null)
    {
      d.b.c.a locala = this.fuY.aeI();
      if ((locala != null) && (locala.appid != 0L))
      {
        long l = locala.appid;
        AppMethodBeat.o(11314);
        return l;
      }
    }
    AppMethodBeat.o(11314);
    return 0L;
  }
  
  public final boolean aem()
  {
    AppMethodBeat.i(11315);
    cU(false);
    if (this.fuY == null)
    {
      ab.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
      AppMethodBeat.o(11315);
      return true;
    }
    if (this.fuY.aeC() == null)
    {
      ab.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
      AppMethodBeat.o(11315);
      return true;
    }
    if (!this.fuY.aeC().fwd)
    {
      AppMethodBeat.o(11315);
      return true;
    }
    AppMethodBeat.o(11315);
    return false;
  }
  
  public final String aen()
  {
    AppMethodBeat.i(11316);
    cU(false);
    if (this.fuY != null)
    {
      Object localObject = this.fuY.aeI();
      if (localObject != null)
      {
        localObject = ((d.b.c.a)localObject).fvQ;
        AppMethodBeat.o(11316);
        return localObject;
      }
    }
    AppMethodBeat.o(11316);
    return null;
  }
  
  public final String aeo()
  {
    AppMethodBeat.i(11317);
    String str = cU(false).aeI().fvM;
    if (bo.isNullOrNil(str)) {
      ab.e("MicroMsg.BizInfo", "check father: %s, %s", new Object[] { this.field_username, str });
    }
    AppMethodBeat.o(11317);
    return str;
  }
  
  /* Error */
  public final List<d.a> aep()
  {
    // Byte code:
    //   0: sipush 11320
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 378	com/tencent/mm/aj/d:fuX	Ljava/util/List;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: getfield 378	com/tencent/mm/aj/d:fuX	Ljava/util/List;
    //   17: astore_2
    //   18: sipush 11320
    //   21: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_2
    //   25: areturn
    //   26: aload_0
    //   27: new 380	java/util/LinkedList
    //   30: dup
    //   31: invokespecial 381	java/util/LinkedList:<init>	()V
    //   34: putfield 378	com/tencent/mm/aj/d:fuX	Ljava/util/List;
    //   37: aload_0
    //   38: getfield 384	com/tencent/mm/aj/d:field_brandInfo	Ljava/lang/String;
    //   41: ifnull +13 -> 54
    //   44: aload_0
    //   45: getfield 384	com/tencent/mm/aj/d:field_brandInfo	Ljava/lang/String;
    //   48: invokevirtual 387	java/lang/String:length	()I
    //   51: ifne +16 -> 67
    //   54: aload_0
    //   55: getfield 378	com/tencent/mm/aj/d:fuX	Ljava/util/List;
    //   58: astore_2
    //   59: sipush 11320
    //   62: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_2
    //   66: areturn
    //   67: new 240	org/json/JSONObject
    //   70: dup
    //   71: aload_0
    //   72: getfield 384	com/tencent/mm/aj/d:field_brandInfo	Ljava/lang/String;
    //   75: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   78: ldc_w 392
    //   81: invokevirtual 396	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   84: astore_2
    //   85: iconst_0
    //   86: istore_1
    //   87: iload_1
    //   88: aload_2
    //   89: invokevirtual 399	org/json/JSONArray:length	()I
    //   92: if_icmpge +105 -> 197
    //   95: new 6	com/tencent/mm/aj/d$a
    //   98: dup
    //   99: invokespecial 400	com/tencent/mm/aj/d$a:<init>	()V
    //   102: astore_3
    //   103: aload_2
    //   104: iload_1
    //   105: invokevirtual 404	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   108: astore 4
    //   110: aload_3
    //   111: aload 4
    //   113: ldc_w 406
    //   116: invokevirtual 410	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putfield 412	com/tencent/mm/aj/d$a:title	Ljava/lang/String;
    //   122: aload_3
    //   123: aload 4
    //   125: ldc_w 414
    //   128: invokevirtual 410	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 416	com/tencent/mm/aj/d$a:url	Ljava/lang/String;
    //   134: aload_3
    //   135: aload 4
    //   137: ldc_w 418
    //   140: invokevirtual 410	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 421	com/tencent/mm/aj/d$a:fvb	Ljava/lang/String;
    //   146: aload_3
    //   147: aload 4
    //   149: ldc_w 423
    //   152: invokevirtual 410	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 425	com/tencent/mm/aj/d$a:description	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 378	com/tencent/mm/aj/d:fuX	Ljava/util/List;
    //   162: aload_3
    //   163: invokeinterface 431 2 0
    //   168: pop
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: goto -86 -> 87
    //   176: astore_2
    //   177: ldc_w 265
    //   180: ldc_w 433
    //   183: iconst_1
    //   184: anewarray 269	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: invokestatic 437	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 372	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_0
    //   198: getfield 378	com/tencent/mm/aj/d:fuX	Ljava/util/List;
    //   201: astore_2
    //   202: sipush 11320
    //   205: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_2
    //   209: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	d
    //   86	87	1	i	int
    //   17	87	2	localObject	Object
    //   176	14	2	localException	java.lang.Exception
    //   201	8	2	localList	List
    //   102	61	3	locala	d.a
    //   108	40	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   67	85	176	java/lang/Exception
    //   87	169	176	java/lang/Exception
  }
  
  public final d.b cU(boolean paramBoolean)
  {
    AppMethodBeat.i(11302);
    if ((this.fuY == null) || (paramBoolean))
    {
      if ((bo.isNullOrNil(this.field_extInfo)) || (fuZ != this.field_extInfo.hashCode())) {
        break label60;
      }
      this.fuY = fva;
    }
    for (;;)
    {
      d.b localb = this.fuY;
      AppMethodBeat.o(11302);
      return localb;
      label60:
      localb = d.b.rC(this.field_extInfo);
      this.fuY = localb;
      fva = localb;
      fuZ = bo.nullAsNil(this.field_extInfo).hashCode();
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(11318);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(11318);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(11319);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(11319);
    return localContentValues;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.d
 * JD-Core Version:    0.7.0.1
 */