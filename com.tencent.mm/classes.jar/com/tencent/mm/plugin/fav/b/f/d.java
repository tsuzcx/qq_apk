package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Set<Ljava.lang.Integer;>;
import junit.framework.Assert;

public final class d
  extends j<g>
  implements x
{
  private static final String qbW;
  private e db;
  
  static
  {
    AppMethodBeat.i(101719);
    qbW = "xml,edittime,ext,favProto,flag,fromUser,id,itemStatus,localId,localSeq,realChatName,sourceCreateTime,sourceId,sourceType,toUser,type" + ",updateSeq,updateTime,tagProto,sessionId,datatotalsize,rowid";
    AppMethodBeat.o(101719);
  }
  
  public d(e parame)
  {
    super(parame, g.info, "FavItemInfo", null);
    this.db = parame;
  }
  
  private static boolean Cn(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.pZq;
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
  
  public final long A(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101698);
    if (this.db == null)
    {
      ad.e("MicroMsg.Fav.FavItemInfoStorage", "getNextUpdateTime, but db is null, return");
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
  
  public final void A(g paramg)
  {
    AppMethodBeat.i(101706);
    String str = "delete from FavItemInfo where localId = " + paramg.field_localId;
    ad.i("MicroMsg.Fav.FavItemInfoStorage", "delete sql: ".concat(String.valueOf(str)));
    this.db.execSQL("FavItemInfo", str);
    doNotify(paramg.field_localId, 5, Long.valueOf(paramg.field_localId));
    AppMethodBeat.o(101706);
  }
  
  public final LinkedList<Integer> B(long paramLong, int paramInt)
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
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final long C(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101701);
    if (this.db == null)
    {
      ad.e("MicroMsg.Fav.FavItemInfoStorage", "getMinBatchGetUpdateTime, but db is null, return");
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
  
  public final int Cm(int paramInt)
  {
    AppMethodBeat.i(101716);
    Object localObject = "select count(*) from FavItemInfo where id>".concat(String.valueOf(paramInt));
    try
    {
      localObject = this.db.a((String)localObject, null, 2);
      if (localObject == null)
      {
        AppMethodBeat.o(101716);
        return -1;
      }
      if (((Cursor)localObject).getCount() == 0)
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(101716);
        return -1;
      }
      ((Cursor)localObject).moveToNext();
      paramInt = ((Cursor)localObject).getInt(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(101716);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      ad.w("MicroMsg.Fav.FavItemInfoStorage", "getFavHomePosition failed with throwable: " + localThrowable.getMessage());
      AppMethodBeat.o(101716);
    }
    return -1;
  }
  
  public final g Yl(String paramString)
  {
    AppMethodBeat.i(101694);
    Cursor localCursor = this.db.a("FavItemInfo", null, "sourceId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      paramString = new g();
      paramString.convertFrom(localCursor);
      localCursor.close();
      AppMethodBeat.o(101694);
      return paramString;
    }
    ad.w("MicroMsg.Fav.FavItemInfoStorage", "klem getBySourceId:%s, no data", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(101694);
    return null;
  }
  
  public final ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(101710);
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() > 20))
    {
      AppMethodBeat.o(101710);
      return null;
    }
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("select ").append(qbW).append(" from FavItemInfo where ");
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
    ((StringBuffer)localObject).append(" order by updateTime desc");
    paramList = ((StringBuffer)localObject).toString();
    ad.d("MicroMsg.Fav.FavItemInfoStorage", "get list by id list sql %s", new Object[] { paramList });
    localObject = this.db.a(paramList, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101710);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramSet = new ArrayList();
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        paramList = new g();
        label341:
        paramList.convertFrom((Cursor)localObject);
        if ((paramw == null) || (!paramw.u(paramList))) {
          break label435;
        }
        ad.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[] { Integer.valueOf(paramList.field_id), Integer.valueOf(paramList.field_type) });
        label395:
        if (((Cursor)localObject).moveToNext()) {
          break label442;
        }
      }
    }
    for (paramList = paramSet;; paramList = null)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(101710);
      return paramList;
      paramList = (g)paramList1.remove(0);
      break label341;
      label435:
      paramSet.add(paramList);
      break label395;
      label442:
      break;
    }
  }
  
  public final List<g> a(int paramInt, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(101699);
    if ((paramSet != null) && (paramSet.contains(Integer.valueOf(paramInt))))
    {
      ad.w("MicroMsg.Fav.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
      AppMethodBeat.o(101699);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select " + qbW + " from FavItemInfo where itemStatus > 0";
    if (paramInt != -1) {
      paramSet = (String)localObject + " and type = " + paramInt;
    }
    for (;;)
    {
      paramSet = paramSet + " order by updateTime desc limit 20";
      paramSet = this.db.a(paramSet, null, 2);
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
          if ((paramw != null) && (paramw.u((g)localObject))) {
            ad.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[] { Integer.valueOf(((g)localObject).field_id), Integer.valueOf(((g)localObject).field_type) });
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
    agu localagu;
    if (paramg.field_favProto.DiD != null)
    {
      localagu = paramg.field_favProto.DiD;
      if (localagu.sourceType > 0) {
        break label166;
      }
      ad.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localagu.sourceType) });
      localagu.VM(1);
    }
    for (;;)
    {
      b.a(paramg);
      boolean bool = super.updateNotify(paramg, false, paramVarArgs);
      if (bool) {
        doNotify(paramg.field_localId, 3, Long.valueOf(paramg.field_localId));
      }
      ad.d("MicroMsg.Fav.FavItemInfoStorage", "update result[%B]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(101696);
      return bool;
      label166:
      localagu.VM(localagu.sourceType);
    }
  }
  
  public final void ab(int paramInt, long paramLong)
  {
    AppMethodBeat.i(101705);
    ad.d("MicroMsg.Fav.FavItemInfoStorage", "setStatus status:%d,localId:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    String str = "update FavItemInfo set itemStatus = " + paramInt + " where localId = " + paramLong;
    this.db.execSQL("FavItemInfo", str);
    doNotify(String.valueOf(paramLong));
    AppMethodBeat.o(101705);
  }
  
  /* Error */
  public final List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, w paramw)
  {
    // Byte code:
    //   0: ldc_w 401
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload 4
    //   8: ifnull +33 -> 41
    //   11: aload 4
    //   13: iload_3
    //   14: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 337 2 0
    //   22: ifeq +19 -> 41
    //   25: ldc 71
    //   27: ldc_w 403
    //   30: invokestatic 223	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc_w 401
    //   36: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aconst_null
    //   40: areturn
    //   41: new 308	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 309	java/util/ArrayList:<init>	()V
    //   48: astore 7
    //   50: new 22	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 258
    //   57: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: getstatic 40	com/tencent/mm/plugin/fav/b/f/d:qbW	Ljava/lang/String;
    //   63: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 405
    //   69: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_1
    //   73: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore 6
    //   81: iload_3
    //   82: iconst_m1
    //   83: if_icmpeq +102 -> 185
    //   86: new 22	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   93: aload 6
    //   95: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 85
    //   100: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: iload_3
    //   104: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 4
    //   112: new 22	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   119: aload 4
    //   121: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 127
    //   126: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 4
    //   134: new 22	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   141: aload 4
    //   143: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 170
    //   148: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 4
    //   156: aload_0
    //   157: getfield 58	com/tencent/mm/plugin/fav/b/f/d:db	Lcom/tencent/mm/sdk/e/e;
    //   160: aload 4
    //   162: aconst_null
    //   163: iconst_2
    //   164: invokeinterface 174 4 0
    //   169: astore 4
    //   171: aload 4
    //   173: ifnonnull +94 -> 267
    //   176: ldc_w 401
    //   179: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload 7
    //   184: areturn
    //   185: aload 4
    //   187: ifnull +152 -> 339
    //   190: aload 4
    //   192: invokeinterface 272 1 0
    //   197: astore 8
    //   199: aload 6
    //   201: astore 4
    //   203: aload 8
    //   205: invokeinterface 277 1 0
    //   210: ifeq -98 -> 112
    //   213: aload 8
    //   215: invokeinterface 281 1 0
    //   220: checkcast 183	java/lang/Integer
    //   223: invokevirtual 344	java/lang/Integer:intValue	()I
    //   226: istore_3
    //   227: new 22	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   234: aload 6
    //   236: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 283
    //   242: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: iload_3
    //   246: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: astore 6
    //   254: goto -55 -> 199
    //   257: astore 6
    //   259: ldc 71
    //   261: ldc_w 407
    //   264: invokestatic 79	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload 4
    //   269: invokeinterface 177 1 0
    //   274: ifeq +49 -> 323
    //   277: new 47	com/tencent/mm/plugin/fav/a/g
    //   280: dup
    //   281: invokespecial 235	com/tencent/mm/plugin/fav/a/g:<init>	()V
    //   284: astore 6
    //   286: aload 6
    //   288: aload 4
    //   290: invokevirtual 239	com/tencent/mm/plugin/fav/a/g:convertFrom	(Landroid/database/Cursor;)V
    //   293: aload 5
    //   295: ifnull +15 -> 310
    //   298: aload 5
    //   300: aload 6
    //   302: invokeinterface 318 2 0
    //   307: ifne -40 -> 267
    //   310: aload 7
    //   312: aload 6
    //   314: invokeinterface 345 2 0
    //   319: pop
    //   320: goto -53 -> 267
    //   323: aload 4
    //   325: invokeinterface 105 1 0
    //   330: ldc_w 401
    //   333: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aload 7
    //   338: areturn
    //   339: aload 6
    //   341: astore 4
    //   343: goto -231 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	d
    //   0	346	1	paramLong	long
    //   0	346	3	paramInt	int
    //   0	346	4	paramSet	Set<Integer>
    //   0	346	5	paramw	w
    //   79	174	6	str	String
    //   257	1	6	localException	Exception
    //   284	56	6	localg	g
    //   48	289	7	localArrayList	ArrayList
    //   197	17	8	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   286	293	257	java/lang/Exception
  }
  
  public final boolean b(g paramg, String... paramVarArgs)
  {
    AppMethodBeat.i(101711);
    agu localagu;
    if (paramg.field_favProto.DiD != null)
    {
      localagu = paramg.field_favProto.DiD;
      if (localagu.sourceType > 0) {
        break label109;
      }
      ad.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localagu.sourceType) });
      localagu.VM(1);
    }
    for (;;)
    {
      boolean bool = super.updateNotify(paramg, false, paramVarArgs);
      AppMethodBeat.o(101711);
      return bool;
      label109:
      localagu.VM(localagu.sourceType);
    }
  }
  
  public final e chY()
  {
    return this.db;
  }
  
  public final int chZ()
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
  
  public final List<g> cia()
  {
    AppMethodBeat.i(101703);
    Object localObject = "select " + qbW + " from FavItemInfo where itemStatus=3";
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
  
  public final List<g> cib()
  {
    LinkedList localLinkedList = null;
    AppMethodBeat.i(101704);
    Object localObject = "select " + qbW + " from FavItemInfo where itemStatus=1";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final List<g> cic()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(101707);
    Object localObject = "select " + qbW + " from FavItemInfo where (itemStatus=9 or itemStatus=12)";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final List<g> cid()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(101708);
    Object localObject = "select " + qbW + " from FavItemInfo where itemStatus=17";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final List<g> cie()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(101709);
    Object localObject = "select " + qbW + " from FavItemInfo where itemStatus=3 or itemStatus=6 or itemStatus=11 or itemStatus=14 or itemStatus=16 or itemStatus=18";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final List<g> cif()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(101712);
    Object localObject = "select " + qbW + " from FavItemInfo where flag =  -1 and itemStatus = 0 ";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final List<Long> cig()
  {
    AppMethodBeat.i(101713);
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = "";
    Object localObject2 = a.pZq;
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
    localObject2 = a.pZp;
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
    ad.i("MicroMsg.Fav.FavItemInfoStorage", "getCleanList cu.getCount() = %d,used %dms", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(l2 - l1) });
    AppMethodBeat.o(101713);
    return localArrayList;
  }
  
  public final void cih()
  {
    AppMethodBeat.i(101714);
    ad.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength");
    Object localObject3 = "select " + qbW + " from FavItemInfo where ";
    Object localObject1 = "";
    Object localObject2 = a.pZq;
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
    localObject2 = a.pZp;
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
      ad.e("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
      AppMethodBeat.o(101714);
      return;
    }
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      ad.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
      AppMethodBeat.o(101714);
      return;
    }
    ad.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = " + ((Cursor)localObject1).getCount());
    long l2;
    if ((this.db instanceof h)) {
      l2 = ((h)this.db).rb(Thread.currentThread().getId());
    }
    for (;;)
    {
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new g();
        ((g)localObject2).convertFrom((Cursor)localObject1);
        if (Cn(((g)localObject2).field_itemStatus))
        {
          if (((g)localObject2).field_favProto != null)
          {
            localObject3 = ((g)localObject2).field_favProto.mVb.iterator();
            for (long l1 = 0L;; l1 = ((afy)((Iterator)localObject3).next()).Dgu + l1)
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
          ((h)this.db).mX(l2);
        }
        ((Cursor)localObject1).close();
        ad.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength end");
        AppMethodBeat.o(101714);
        return;
        l2 = 0L;
      }
    }
  }
  
  public final List<Long> cii()
  {
    AppMethodBeat.i(101715);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select localId from FavItemInfo" + " order by updateTime desc";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final g pS(long paramLong)
  {
    AppMethodBeat.i(101691);
    if (this.db == null)
    {
      ad.e("MicroMsg.Fav.FavItemInfoStorage", "getBtLocalId, but db is null, return");
      AppMethodBeat.o(101691);
      return null;
    }
    Cursor localCursor = this.db.a("FavItemInfo", null, "localId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
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
        ad.e("MicroMsg.Fav.FavItemInfoStorage", "getByLocalId convertFrom(cu) cause IlleagalStateException, return null");
        localCursor.close();
        AppMethodBeat.o(101691);
        return null;
      }
    }
    ad.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByLocalId:%d, no data", new Object[] { Long.valueOf(paramLong) });
    localCursor.close();
    AppMethodBeat.o(101691);
    return null;
  }
  
  public final g pT(long paramLong)
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
        ad.printErrStackTrace("MicroMsg.Fav.FavItemInfoStorage", localException, "", new Object[0]);
        ad.e("MicroMsg.Fav.FavItemInfoStorage", "getByFavId(%d),info.convertFrom error", new Object[] { Long.valueOf(paramLong) });
        ((Cursor)localObject).close();
        AppMethodBeat.o(101692);
        return null;
      }
    }
    ad.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByFavId:%d, no data", new Object[] { Long.valueOf(paramLong) });
    ((Cursor)localObject).close();
    AppMethodBeat.o(101692);
    return null;
  }
  
  public final boolean z(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101697);
    String str = "select count(updateTime) from FavItemInfo where updateTime < ".concat(String.valueOf(paramLong));
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final boolean z(g paramg)
  {
    AppMethodBeat.i(101695);
    boolean bool;
    agu localagu;
    if (paramg.field_localId > 0L)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramg.field_favProto.DiD != null)
      {
        localagu = paramg.field_favProto.DiD;
        if (localagu.sourceType > 0) {
          break label162;
        }
        ad.w("MicroMsg.Fav.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localagu.sourceType) });
        localagu.VM(1);
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
      localagu.VM(localagu.sourceType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.d
 * JD-Core Version:    0.7.0.1
 */