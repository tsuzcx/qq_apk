package com.tencent.mm.plugin.fav.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Set<Ljava.lang.Integer;>;
import junit.framework.Assert;

public final class d
  extends MAutoStorage<g>
  implements y
{
  private static final String AeS;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(101719);
    AeS = "xml,edittime,ext,favProto" + ",flag,fromUser,id,itemStatus" + ",localId,localSeq,realChatName,sourceCreateTime" + ",sourceId,sourceType,toUser,type" + ",updateSeq,updateTime,tagProto,sessionId" + ",datatotalsize,rowid";
    AppMethodBeat.o(101719);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, g.info, "FavItemInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  private static boolean MF(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.Acc;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final void A(g paramg)
  {
    AppMethodBeat.i(101706);
    String str = "delete from FavItemInfo where localId = " + paramg.field_localId;
    Log.i("MicroMsg.Fav.FavItemInfoStorage", "delete sql: ".concat(String.valueOf(str)));
    this.db.execSQL("FavItemInfo", str);
    doNotify(paramg.field_localId, 5, Long.valueOf(paramg.field_localId));
    AppMethodBeat.o(101706);
  }
  
  public final boolean L(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101697);
    String str = "select count(updateTime) from FavItemInfo where updateTime < ".concat(String.valueOf(paramLong));
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101697);
      return true;
    }
    ((Cursor)localObject).moveToFirst();
    if (((Cursor)localObject).getInt(0) == 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(101697);
      return true;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(101697);
    return false;
  }
  
  public final long M(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101698);
    if (this.db == null)
    {
      Log.e("MicroMsg.Fav.FavItemInfoStorage", "getNextUpdateTime, but db is null, return");
      AppMethodBeat.o(101698);
      return 0L;
    }
    if (paramLong == 0L)
    {
      localObject = "select updateTime from FavItemInfo where itemStatus > 0";
      if (paramInt != -1) {
        localObject = "select updateTime from FavItemInfo where itemStatus > 0" + " and type = " + paramInt;
      }
      localObject = (String)localObject + " order by updateTime desc limit 20";
      localObject = this.db.rawQuery((String)localObject, null);
      if (localObject == null)
      {
        AppMethodBeat.o(101698);
        return 0L;
      }
      if (((Cursor)localObject).getCount() == 0)
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(101698);
        return 0L;
      }
      ((Cursor)localObject).moveToLast();
      paramLong = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(101698);
      return paramLong;
    }
    String str = "select updateTime from FavItemInfo where updateTime < ".concat(String.valueOf(paramLong));
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = (String)localObject + " and itemStatus > 0";
    localObject = (String)localObject + " order by updateTime desc limit 20";
    localObject = this.db.rawQuery((String)localObject, null);
    if ((localObject != null) && (((Cursor)localObject).getCount() > 0))
    {
      ((Cursor)localObject).moveToLast();
      paramLong = ((Cursor)localObject).getLong(0);
    }
    for (;;)
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
      AppMethodBeat.o(101698);
      return paramLong;
    }
  }
  
  public final int ME(int paramInt)
  {
    AppMethodBeat.i(101716);
    Object localObject1 = "select count(*) from FavItemInfo where id>".concat(String.valueOf(paramInt));
    try
    {
      localObject1 = this.db.rawQuery((String)localObject1, null, 2);
      if (localObject1 == null)
      {
        AppMethodBeat.o(101716);
        return -1;
      }
      if (((Cursor)localObject1).getCount() == 0)
      {
        ((Cursor)localObject1).close();
        AppMethodBeat.o(101716);
        return -1;
      }
      ((Cursor)localObject1).moveToNext();
      paramInt = ((Cursor)localObject1).getInt(0);
      ((Cursor)localObject1).close();
      AppMethodBeat.o(101716);
      return paramInt;
    }
    finally
    {
      Log.w("MicroMsg.Fav.FavItemInfoStorage", "getFavHomePosition failed with throwable: " + localObject2.getMessage());
      AppMethodBeat.o(101716);
    }
    return -1;
  }
  
  public final LinkedList<Integer> N(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101700);
    LinkedList localLinkedList = new LinkedList();
    String str = "select id from FavItemInfo where updateTime >= ".concat(String.valueOf(paramLong));
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = (String)localObject + " and updateSeq > localSeq";
    localObject = (String)localObject + " order by updateTime desc";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101700);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext()) {
      localLinkedList.add(Integer.valueOf(((Cursor)localObject).getInt(0)));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(101700);
    return localLinkedList;
  }
  
  public final long O(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101701);
    if (this.db == null)
    {
      Log.e("MicroMsg.Fav.FavItemInfoStorage", "getMinBatchGetUpdateTime, but db is null, return");
      AppMethodBeat.o(101701);
      return 0L;
    }
    if (paramLong == 0L)
    {
      localObject = "select updateTime from (select * from FavItemInfo";
      if (paramInt != -1) {
        localObject = "select updateTime from (select * from FavItemInfo" + " where type = " + paramInt;
      }
      localObject = (String)localObject + " order by updateTime desc limit 20";
      localObject = (String)localObject + ") where updateSeq > localSeq";
      localObject = this.db.rawQuery((String)localObject, null);
      if (localObject == null)
      {
        AppMethodBeat.o(101701);
        return 0L;
      }
      if (((Cursor)localObject).getCount() == 0)
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(101701);
        return 0L;
      }
      ((Cursor)localObject).moveToLast();
      paramLong = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(101701);
      return paramLong;
    }
    String str = "select updateTime from (select * from FavItemInfo where updateTime < ".concat(String.valueOf(paramLong));
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = (String)localObject + " order by updateTime desc ";
    localObject = (String)localObject + ") where updateSeq > localSeq";
    localObject = this.db.rawQuery((String)localObject, null);
    if (localObject == null)
    {
      AppMethodBeat.o(101701);
      return 0L;
    }
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(101701);
      return 0L;
    }
    ((Cursor)localObject).moveToLast();
    paramLong = ((Cursor)localObject).getLong(0);
    ((Cursor)localObject).close();
    AppMethodBeat.o(101701);
    return paramLong;
  }
  
  public final ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, x paramx, boolean paramBoolean)
  {
    AppMethodBeat.i(274379);
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() > 20))
    {
      AppMethodBeat.o(274379);
      return null;
    }
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("select ").append(AeS).append(" from FavItemInfo where ");
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      ((StringBuffer)localObject).append("( 1=1");
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        Integer localInteger = (Integer)paramSet.next();
        ((StringBuffer)localObject).append(" and type != ").append(localInteger);
      }
      ((StringBuffer)localObject).append(") and ");
    }
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      if (i == 0) {
        ((StringBuffer)localObject).append("( ");
      }
      if (i == j - 1) {
        ((StringBuffer)localObject).append("localId = ").append(paramList.get(i)).append(" )");
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuffer)localObject).append("localId = ").append(paramList.get(i)).append(" or ");
      }
    }
    if (paramBoolean)
    {
      ((StringBuffer)localObject).append("order by case FavItemInfo.localId ");
      i = 0;
      while (i < paramList.size())
      {
        ((StringBuffer)localObject).append(" when '").append(paramList.get(i)).append("' then ").append(i);
        i += 1;
      }
      ((StringBuffer)localObject).append(" end");
    }
    for (;;)
    {
      paramList = ((StringBuffer)localObject).toString();
      Log.d("MicroMsg.Fav.FavItemInfoStorage", "get list by id list sql %s", new Object[] { paramList });
      localObject = this.db.rawQuery(paramList, null, 2);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(274379);
      return null;
      ((StringBuffer)localObject).append(" order by updateTime desc");
    }
    paramList = null;
    if (((Cursor)localObject).moveToFirst()) {
      paramSet = new ArrayList();
    }
    label516:
    label523:
    for (;;)
    {
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        paramList = new g();
        paramList.convertFrom((Cursor)localObject);
        if ((paramx == null) || (!paramx.u(paramList))) {
          break label516;
        }
        Log.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[] { Integer.valueOf(paramList.field_id), Integer.valueOf(paramList.field_type) });
      }
      for (;;)
      {
        if (((Cursor)localObject).moveToNext()) {
          break label523;
        }
        paramList = paramSet;
        ((Cursor)localObject).close();
        AppMethodBeat.o(274379);
        return paramList;
        paramList = (g)paramList1.remove(0);
        break;
        paramSet.add(paramList);
      }
    }
  }
  
  public final List<g> a(int paramInt, Set<Integer> paramSet, x paramx)
  {
    AppMethodBeat.i(101699);
    if ((paramSet != null) && (paramSet.contains(Integer.valueOf(paramInt))))
    {
      Log.w("MicroMsg.Fav.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
      AppMethodBeat.o(101699);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select " + AeS + " from FavItemInfo where itemStatus > 0";
    if (paramInt != -1) {
      paramSet = (String)localObject + " and type = " + paramInt;
    }
    for (;;)
    {
      paramSet = paramSet + " order by updateTime desc limit 20";
      paramSet = this.db.rawQuery(paramSet, null, 2);
      if (paramSet == null)
      {
        AppMethodBeat.o(101699);
        return localArrayList;
        if (paramSet != null)
        {
          Iterator localIterator = paramSet.iterator();
          for (;;)
          {
            paramSet = (Set<Integer>)localObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramInt = ((Integer)localIterator.next()).intValue();
            localObject = (String)localObject + " and type != " + paramInt;
          }
        }
      }
      else
      {
        while (paramSet.moveToNext())
        {
          localObject = new g();
          ((g)localObject).convertFrom(paramSet);
          if ((paramx != null) && (paramx.u((g)localObject))) {
            Log.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[] { Integer.valueOf(((g)localObject).field_id), Integer.valueOf(((g)localObject).field_type) });
          } else {
            localArrayList.add(localObject);
          }
        }
        paramSet.close();
        AppMethodBeat.o(101699);
        return localArrayList;
      }
      paramSet = (Set<Integer>)localObject;
    }
  }
  
  public final boolean a(g paramg, String... paramVarArgs)
  {
    AppMethodBeat.i(101696);
    asb localasb;
    if (paramg.field_favProto.ZBt != null)
    {
      localasb = paramg.field_favProto.ZBt;
      if (localasb.sourceType > 0) {
        break label166;
      }
      Log.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localasb.sourceType) });
      localasb.axH(1);
    }
    for (;;)
    {
      b.a(paramg);
      boolean bool = super.updateNotify(paramg, false, paramVarArgs);
      if (bool) {
        doNotify(paramg.field_localId, 3, Long.valueOf(paramg.field_localId));
      }
      Log.d("MicroMsg.Fav.FavItemInfoStorage", "update result[%B]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(101696);
      return bool;
      label166:
      localasb.axH(localasb.sourceType);
    }
  }
  
  public final void ak(int paramInt, long paramLong)
  {
    AppMethodBeat.i(101705);
    Log.d("MicroMsg.Fav.FavItemInfoStorage", "setStatus status:%d,localId:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    String str = "update FavItemInfo set itemStatus = " + paramInt + " where localId = " + paramLong;
    this.db.execSQL("FavItemInfo", str);
    doNotify(String.valueOf(paramLong));
    AppMethodBeat.o(101705);
  }
  
  public final g auj(String paramString)
  {
    AppMethodBeat.i(101694);
    Cursor localCursor = this.db.query("FavItemInfo", null, "sourceId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      paramString = new g();
      paramString.convertFrom(localCursor);
      localCursor.close();
      AppMethodBeat.o(101694);
      return paramString;
    }
    Log.w("MicroMsg.Fav.FavItemInfoStorage", "klem getBySourceId:%s, no data", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(101694);
    return null;
  }
  
  /* Error */
  public final List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, x paramx)
  {
    // Byte code:
    //   0: ldc_w 427
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload 4
    //   8: ifnull +33 -> 41
    //   11: aload 4
    //   13: iload_3
    //   14: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 352 2 0
    //   22: ifeq +19 -> 41
    //   25: ldc 88
    //   27: ldc_w 429
    //   30: invokestatic 202	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc_w 427
    //   36: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aconst_null
    //   40: areturn
    //   41: new 316	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 317	java/util/ArrayList:<init>	()V
    //   48: astore 7
    //   50: new 22	java/lang/StringBuilder
    //   53: dup
    //   54: ldc 252
    //   56: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: getstatic 48	com/tencent/mm/plugin/fav/model/e/d:AeS	Ljava/lang/String;
    //   62: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 431
    //   68: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: lload_1
    //   72: invokevirtual 86	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 6
    //   80: iload_3
    //   81: iconst_m1
    //   82: if_icmpeq +102 -> 184
    //   85: new 22	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   92: aload 6
    //   94: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 132
    //   99: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload_3
    //   103: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 4
    //   111: new 22	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   118: aload 4
    //   120: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 182
    //   125: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore 4
    //   133: new 22	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   140: aload 4
    //   142: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 214
    //   147: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore 4
    //   155: aload_0
    //   156: getfield 66	com/tencent/mm/plugin/fav/model/e/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   159: aload 4
    //   161: aconst_null
    //   162: iconst_2
    //   163: invokeinterface 139 4 0
    //   168: astore 4
    //   170: aload 4
    //   172: ifnonnull +94 -> 266
    //   175: ldc_w 427
    //   178: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload 7
    //   183: areturn
    //   184: aload 4
    //   186: ifnull +152 -> 338
    //   189: aload 4
    //   191: invokeinterface 266 1 0
    //   196: astore 8
    //   198: aload 6
    //   200: astore 4
    //   202: aload 8
    //   204: invokeinterface 271 1 0
    //   209: ifeq -98 -> 111
    //   212: aload 8
    //   214: invokeinterface 275 1 0
    //   219: checkcast 216	java/lang/Integer
    //   222: invokevirtual 359	java/lang/Integer:intValue	()I
    //   225: istore_3
    //   226: new 22	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   233: aload 6
    //   235: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 277
    //   241: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload_3
    //   245: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: astore 6
    //   253: goto -55 -> 198
    //   256: astore 6
    //   258: ldc 88
    //   260: ldc_w 433
    //   263: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload 4
    //   268: invokeinterface 192 1 0
    //   273: ifeq +49 -> 322
    //   276: new 55	com/tencent/mm/plugin/fav/a/g
    //   279: dup
    //   280: invokespecial 321	com/tencent/mm/plugin/fav/a/g:<init>	()V
    //   283: astore 6
    //   285: aload 6
    //   287: aload 4
    //   289: invokevirtual 325	com/tencent/mm/plugin/fav/a/g:convertFrom	(Landroid/database/Cursor;)V
    //   292: aload 5
    //   294: ifnull +15 -> 309
    //   297: aload 5
    //   299: aload 6
    //   301: invokeinterface 331 2 0
    //   306: ifne -40 -> 266
    //   309: aload 7
    //   311: aload 6
    //   313: invokeinterface 360 2 0
    //   318: pop
    //   319: goto -53 -> 266
    //   322: aload 4
    //   324: invokeinterface 152 1 0
    //   329: ldc_w 427
    //   332: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aload 7
    //   337: areturn
    //   338: aload 6
    //   340: astore 4
    //   342: goto -231 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	d
    //   0	345	1	paramLong	long
    //   0	345	3	paramInt	int
    //   0	345	4	paramSet	Set<Integer>
    //   0	345	5	paramx	x
    //   78	174	6	str	String
    //   256	1	6	localException	Exception
    //   283	56	6	localg	g
    //   48	288	7	localArrayList	ArrayList
    //   196	17	8	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   285	292	256	java/lang/Exception
  }
  
  public final boolean b(g paramg, String... paramVarArgs)
  {
    AppMethodBeat.i(101711);
    asb localasb;
    if (paramg.field_favProto.ZBt != null)
    {
      localasb = paramg.field_favProto.ZBt;
      if (localasb.sourceType > 0) {
        break label109;
      }
      Log.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localasb.sourceType) });
      localasb.axH(1);
    }
    for (;;)
    {
      boolean bool = super.updateNotify(paramg, false, paramVarArgs);
      AppMethodBeat.o(101711);
      return bool;
      label109:
      localasb.axH(localasb.sourceType);
    }
  }
  
  public final ISQLiteDatabase dQF()
  {
    return this.db;
  }
  
  public final int dQG()
  {
    AppMethodBeat.i(101693);
    Cursor localCursor = rawQuery("select count(*) from FavItemInfo where type = 2", new String[0]);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      int i = localCursor.getInt(0);
      localCursor.close();
      AppMethodBeat.o(101693);
      return i;
    }
    AppMethodBeat.o(101693);
    return 0;
  }
  
  public final List<g> dQH()
  {
    AppMethodBeat.i(101703);
    Object localObject = "select " + AeS + " from FavItemInfo where itemStatus=3";
    localObject = this.db.rawQuery((String)localObject, null);
    if (localObject == null)
    {
      AppMethodBeat.o(101703);
      return null;
    }
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(101703);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext())
    {
      g localg = new g();
      localg.convertFrom((Cursor)localObject);
      localLinkedList.add(localg);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(101703);
    return localLinkedList;
  }
  
  public final List<g> dQI()
  {
    LinkedList localLinkedList = null;
    AppMethodBeat.i(101704);
    Object localObject = "select " + AeS + " from FavItemInfo where itemStatus=1";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101704);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localLinkedList = new LinkedList();
      do
      {
        g localg = new g();
        localg.convertFrom((Cursor)localObject);
        localLinkedList.add(localg);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(101704);
    return localLinkedList;
  }
  
  public final List<g> dQJ()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(101707);
    Object localObject = "select " + AeS + " from FavItemInfo where (itemStatus=9 or itemStatus" + "=12)";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101707);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        g localg = new g();
        localg.convertFrom((Cursor)localObject);
        localArrayList.add(localg);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(101707);
    return localArrayList;
  }
  
  public final List<g> dQK()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(101708);
    Object localObject = "select " + AeS + " from FavItemInfo where itemStatus=17";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101708);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        g localg = new g();
        localg.convertFrom((Cursor)localObject);
        localArrayList.add(localg);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(101708);
    return localArrayList;
  }
  
  public final List<g> dQL()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(101709);
    Object localObject = "select " + AeS + " from FavItemInfo where itemStatus=3 or itemStatus" + "=6 or itemStatus=11 or itemStatus" + "=14 or itemStatus=16 or itemStatus" + "=18";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101709);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        g localg = new g();
        localg.convertFrom((Cursor)localObject);
        localArrayList.add(localg);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(101709);
    return localArrayList;
  }
  
  public final List<g> dQM()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(101712);
    Object localObject = "select " + AeS + " from FavItemInfo where flag =  -1 and itemStatus = 0 ";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101712);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        g localg = new g();
        localg.convertFrom((Cursor)localObject);
        localArrayList.add(localg);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(101712);
    return localArrayList;
  }
  
  public final List<Long> dQN()
  {
    AppMethodBeat.i(101713);
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = "";
    Object localObject2 = a.Acc;
    int j = localObject2.length;
    int i = 0;
    int k;
    while (i < j)
    {
      k = localObject2[i];
      localObject1 = (String)localObject1 + k + ",";
      i += 1;
    }
    localObject2 = localObject1;
    if (((String)localObject1).endsWith(",")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    localObject1 = "select localId from FavItemInfo where " + " itemStatus in (" + (String)localObject2 + ")";
    String str = (String)localObject1 + " and datatotalsize > 0 ";
    localObject1 = "";
    localObject2 = a.Acb;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject1 = (String)localObject1 + k + ",";
      i += 1;
    }
    localObject2 = localObject1;
    if (((String)localObject1).endsWith(",")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    localObject1 = str + " and type in (" + (String)localObject2 + ")";
    localObject1 = (String)localObject1 + " order by datatotalsize desc";
    localObject1 = this.db.rawQuery((String)localObject1, null);
    if (localObject1 == null)
    {
      AppMethodBeat.o(101713);
      return localArrayList;
    }
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(101713);
      return localArrayList;
    }
    while (((Cursor)localObject1).moveToNext()) {
      localArrayList.add(Long.valueOf(((Cursor)localObject1).getLong(0)));
    }
    ((Cursor)localObject1).close();
    long l2 = System.currentTimeMillis();
    Log.i("MicroMsg.Fav.FavItemInfoStorage", "getCleanList cu.getCount() = %d,used %dms", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(l2 - l1) });
    AppMethodBeat.o(101713);
    return localArrayList;
  }
  
  public final void dQO()
  {
    AppMethodBeat.i(101714);
    Log.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength");
    Object localObject3 = "select " + AeS + " from FavItemInfo where ";
    Object localObject1 = "";
    Object localObject2 = a.Acc;
    int j = localObject2.length;
    int i = 0;
    int k;
    while (i < j)
    {
      k = localObject2[i];
      localObject1 = (String)localObject1 + k + ",";
      i += 1;
    }
    localObject2 = localObject1;
    if (((String)localObject1).endsWith(",")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    localObject3 = (String)localObject3 + "itemStatus in (" + (String)localObject2 + ")";
    localObject1 = "";
    localObject2 = a.Acb;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject1 = (String)localObject1 + k + ",";
      i += 1;
    }
    localObject2 = localObject1;
    if (((String)localObject1).endsWith(",")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    localObject1 = (String)localObject3 + " and type in (" + (String)localObject2 + ")";
    localObject1 = this.db.rawQuery((String)localObject1, null);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
      AppMethodBeat.o(101714);
      return;
    }
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      Log.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
      AppMethodBeat.o(101714);
      return;
    }
    Log.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = " + ((Cursor)localObject1).getCount());
    long l2;
    if ((this.db instanceof h)) {
      l2 = ((h)this.db).beginTransaction(Thread.currentThread().getId());
    }
    for (;;)
    {
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new g();
        ((g)localObject2).convertFrom((Cursor)localObject1);
        if (MF(((g)localObject2).field_itemStatus))
        {
          if (((g)localObject2).field_favProto != null)
          {
            localObject3 = ((g)localObject2).field_favProto.vEn.iterator();
            for (long l1 = 0L;; l1 = ((arf)((Iterator)localObject3).next()).Zza + l1)
            {
              l3 = l1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            }
          }
          long l3 = 0L;
          ((g)localObject2).field_datatotalsize = l3;
          a((g)localObject2, new String[] { "localId" });
        }
      }
      else
      {
        if ((this.db instanceof h)) {
          ((h)this.db).endTransaction(l2);
        }
        ((Cursor)localObject1).close();
        Log.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength end");
        AppMethodBeat.o(101714);
        return;
        l2 = 0L;
      }
    }
  }
  
  public final List<Long> dQP()
  {
    AppMethodBeat.i(101715);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select localId from FavItemInfo" + " order by updateTime desc";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101715);
      return localArrayList;
    }
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(101715);
      return localArrayList;
    }
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(Long.valueOf(((Cursor)localObject).getLong(0)));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(101715);
    return localArrayList;
  }
  
  public final List<g> hj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(274370);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "SELECT " + AeS + " FROM FavItemInfo WHERE itemStatus > 0";
    localObject = (String)localObject + " AND (type = 8";
    localObject = (String)localObject + " OR type = 14";
    localObject = (String)localObject + " OR type = 18)";
    localObject = (String)localObject + " ORDER BY updateTime DESC LIMIT " + paramInt1 + " , " + paramInt2;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(274370);
      return localArrayList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      g localg = new g();
      localg.convertFrom((Cursor)localObject);
      localArrayList.add(localg);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(274370);
    return localArrayList;
  }
  
  public final g mK(long paramLong)
  {
    AppMethodBeat.i(101691);
    if (this.db == null)
    {
      Log.e("MicroMsg.Fav.FavItemInfoStorage", "getBtLocalId, but db is null, return");
      AppMethodBeat.o(101691);
      return null;
    }
    Cursor localCursor = this.db.query("FavItemInfo", null, "localId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      g localg = new g();
      try
      {
        localg.convertFrom(localCursor);
        localCursor.close();
        AppMethodBeat.o(101691);
        return localg;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Fav.FavItemInfoStorage", "getByLocalId convertFrom(cu) cause IlleagalStateException, return null");
        localCursor.close();
        AppMethodBeat.o(101691);
        return null;
      }
    }
    Log.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByLocalId:%d, no data", new Object[] { Long.valueOf(paramLong) });
    localCursor.close();
    AppMethodBeat.o(101691);
    return null;
  }
  
  public final g mL(long paramLong)
  {
    AppMethodBeat.i(101692);
    Object localObject = "Select * from FavItemInfo where id = ".concat(String.valueOf(paramLong));
    localObject = this.db.rawQuery((String)localObject, null);
    if (((Cursor)localObject).getCount() != 0)
    {
      g localg = new g();
      ((Cursor)localObject).moveToFirst();
      try
      {
        localg.convertFrom((Cursor)localObject);
        ((Cursor)localObject).close();
        AppMethodBeat.o(101692);
        return localg;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Fav.FavItemInfoStorage", localException, "", new Object[0]);
        Log.e("MicroMsg.Fav.FavItemInfoStorage", "getByFavId(%d),info.convertFrom error", new Object[] { Long.valueOf(paramLong) });
        ((Cursor)localObject).close();
        AppMethodBeat.o(101692);
        return null;
      }
    }
    Log.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByFavId:%d, no data", new Object[] { Long.valueOf(paramLong) });
    ((Cursor)localObject).close();
    AppMethodBeat.o(101692);
    return null;
  }
  
  public final boolean z(g paramg)
  {
    AppMethodBeat.i(101695);
    boolean bool;
    asb localasb;
    if (paramg.field_localId > 0L)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramg.field_favProto.ZBt != null)
      {
        localasb = paramg.field_favProto.ZBt;
        if (localasb.sourceType > 0) {
          break label162;
        }
        Log.w("MicroMsg.Fav.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localasb.sourceType) });
        localasb.axH(1);
      }
    }
    for (;;)
    {
      b.a(paramg);
      bool = insertNotify(paramg, false);
      if (bool) {
        doNotify(paramg.field_localId, 2, Long.valueOf(paramg.field_localId));
      }
      AppMethodBeat.o(101695);
      return bool;
      bool = false;
      break;
      label162:
      localasb.axH(localasb.sourceType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.e.d
 * JD-Core Version:    0.7.0.1
 */