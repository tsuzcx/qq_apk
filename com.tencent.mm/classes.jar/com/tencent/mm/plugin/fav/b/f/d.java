package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.plugin.fav.a.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
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
  private static final String mvo;
  private e db;
  
  static
  {
    AppMethodBeat.i(5459);
    mvo = "xml,edittime,ext,favProto,flag,fromUser,id,itemStatus,localId,localSeq,realChatName,sourceCreateTime,sourceId,sourceType,toUser,type" + ",updateSeq,updateTime,tagProto,sessionId,datatotalsize,rowid";
    AppMethodBeat.o(5459);
  }
  
  public d(e parame)
  {
    super(parame, g.info, "FavItemInfo", null);
    this.db = parame;
  }
  
  private static boolean vV(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.msI;
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
  
  public final g NQ(String paramString)
  {
    AppMethodBeat.i(5434);
    Cursor localCursor = this.db.a("FavItemInfo", null, "sourceId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      paramString = new g();
      paramString.convertFrom(localCursor);
      localCursor.close();
      AppMethodBeat.o(5434);
      return paramString;
    }
    ab.w("MicroMsg.Fav.FavItemInfoStorage", "klem getBySourceId:%s, no data", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(5434);
    return null;
  }
  
  public final void O(int paramInt, long paramLong)
  {
    AppMethodBeat.i(5445);
    ab.d("MicroMsg.Fav.FavItemInfoStorage", "setStatus status:%d,localId:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    String str = "update FavItemInfo set itemStatus = " + paramInt + " where localId = " + paramLong;
    this.db.execSQL("FavItemInfo", str);
    doNotify(String.valueOf(paramLong));
    AppMethodBeat.o(5445);
  }
  
  public final ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(5450);
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() > 20))
    {
      AppMethodBeat.o(5450);
      return null;
    }
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("select ").append(mvo).append(" from FavItemInfo where ");
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
    ab.d("MicroMsg.Fav.FavItemInfoStorage", "get list by id list sql %s", new Object[] { paramList });
    localObject = this.db.a(paramList, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5450);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramSet = new ArrayList();
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        paramList = new g();
        label333:
        paramList.convertFrom((Cursor)localObject);
        if ((paramw == null) || (!paramw.t(paramList))) {
          break label427;
        }
        ab.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[] { Integer.valueOf(paramList.field_id), Integer.valueOf(paramList.field_type) });
        label386:
        if (((Cursor)localObject).moveToNext()) {
          break label434;
        }
      }
    }
    for (paramList = paramSet;; paramList = null)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(5450);
      return paramList;
      paramList = (g)paramList1.remove(0);
      break label333;
      label427:
      paramSet.add(paramList);
      break label386;
      label434:
      break;
    }
  }
  
  public final List<g> a(int paramInt, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(5439);
    if ((paramSet != null) && (paramSet.contains(Integer.valueOf(paramInt))))
    {
      ab.w("MicroMsg.Fav.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
      AppMethodBeat.o(5439);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select " + mvo + " from FavItemInfo where itemStatus > 0";
    if (paramInt != -1) {
      paramSet = (String)localObject + " and type = " + paramInt;
    }
    for (;;)
    {
      paramSet = paramSet + " order by updateTime desc limit 20";
      paramSet = this.db.a(paramSet, null, 2);
      if (paramSet == null)
      {
        AppMethodBeat.o(5439);
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
          if ((paramw != null) && (paramw.t((g)localObject))) {
            ab.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[] { Integer.valueOf(((g)localObject).field_id), Integer.valueOf(((g)localObject).field_type) });
          } else {
            localArrayList.add(localObject);
          }
        }
        paramSet.close();
        AppMethodBeat.o(5439);
        return localArrayList;
      }
      paramSet = (Set<Integer>)localObject;
    }
  }
  
  public final boolean a(g paramg, String... paramVarArgs)
  {
    AppMethodBeat.i(5436);
    acw localacw;
    if (paramg.field_favProto.wVa != null)
    {
      localacw = paramg.field_favProto.wVa;
      if (localacw.cpG > 0) {
        break label166;
      }
      ab.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localacw.cpG) });
      localacw.MR(1);
    }
    for (;;)
    {
      b.a(paramg);
      boolean bool = super.updateNotify(paramg, false, paramVarArgs);
      if (bool) {
        doNotify(paramg.field_localId, 3, Long.valueOf(paramg.field_localId));
      }
      ab.d("MicroMsg.Fav.FavItemInfoStorage", "update result[%B]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(5436);
      return bool;
      label166:
      localacw.MR(localacw.cpG);
    }
  }
  
  /* Error */
  public final List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, w paramw)
  {
    // Byte code:
    //   0: sipush 5442
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload 4
    //   8: ifnull +33 -> 41
    //   11: aload 4
    //   13: iload_3
    //   14: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 244 2 0
    //   22: ifeq +19 -> 41
    //   25: ldc 98
    //   27: ldc_w 312
    //   30: invokestatic 249	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: sipush 5442
    //   36: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aconst_null
    //   40: areturn
    //   41: new 209	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 210	java/util/ArrayList:<init>	()V
    //   48: astore 7
    //   50: new 21	java/lang/StringBuilder
    //   53: dup
    //   54: ldc 157
    //   56: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: getstatic 39	com/tencent/mm/plugin/fav/b/f/d:mvo	Ljava/lang/String;
    //   62: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 314
    //   68: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: lload_1
    //   72: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 6
    //   80: iload_3
    //   81: iconst_m1
    //   82: if_icmpeq +103 -> 185
    //   85: new 21	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   92: aload 6
    //   94: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 254
    //   99: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload_3
    //   103: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 4
    //   111: new 21	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   118: aload 4
    //   120: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 316
    //   126: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 4
    //   134: new 21	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   141: aload 4
    //   143: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 201
    //   148: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 4
    //   156: aload_0
    //   157: getfield 57	com/tencent/mm/plugin/fav/b/f/d:db	Lcom/tencent/mm/sdk/e/e;
    //   160: aload 4
    //   162: aconst_null
    //   163: iconst_2
    //   164: invokeinterface 207 4 0
    //   169: astore 4
    //   171: aload 4
    //   173: ifnonnull +93 -> 266
    //   176: sipush 5442
    //   179: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload 7
    //   184: areturn
    //   185: aload 4
    //   187: ifnull +151 -> 338
    //   190: aload 4
    //   192: invokeinterface 171 1 0
    //   197: astore 8
    //   199: aload 6
    //   201: astore 4
    //   203: aload 8
    //   205: invokeinterface 176 1 0
    //   210: ifeq -99 -> 111
    //   213: aload 8
    //   215: invokeinterface 180 1 0
    //   220: checkcast 114	java/lang/Integer
    //   223: invokevirtual 259	java/lang/Integer:intValue	()I
    //   226: istore_3
    //   227: new 21	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   234: aload 6
    //   236: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 182
    //   241: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload_3
    //   245: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: astore 6
    //   253: goto -54 -> 199
    //   256: astore 6
    //   258: ldc 98
    //   260: ldc_w 318
    //   263: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload 4
    //   268: invokeinterface 231 1 0
    //   273: ifeq +49 -> 322
    //   276: new 46	com/tencent/mm/plugin/fav/a/g
    //   279: dup
    //   280: invokespecial 89	com/tencent/mm/plugin/fav/a/g:<init>	()V
    //   283: astore 6
    //   285: aload 6
    //   287: aload 4
    //   289: invokevirtual 93	com/tencent/mm/plugin/fav/a/g:convertFrom	(Landroid/database/Cursor;)V
    //   292: aload 5
    //   294: ifnull +15 -> 309
    //   297: aload 5
    //   299: aload 6
    //   301: invokeinterface 219 2 0
    //   306: ifne -40 -> 266
    //   309: aload 7
    //   311: aload 6
    //   313: invokeinterface 260 2 0
    //   318: pop
    //   319: goto -53 -> 266
    //   322: aload 4
    //   324: invokeinterface 96 1 0
    //   329: sipush 5442
    //   332: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	345	5	paramw	w
    //   78	174	6	str	String
    //   256	1	6	localException	Exception
    //   283	56	6	localg	g
    //   48	288	7	localArrayList	ArrayList
    //   197	17	8	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   285	292	256	java/lang/Exception
  }
  
  public final boolean b(g paramg, String... paramVarArgs)
  {
    AppMethodBeat.i(5451);
    acw localacw;
    if (paramg.field_favProto.wVa != null)
    {
      localacw = paramg.field_favProto.wVa;
      if (localacw.cpG > 0) {
        break label109;
      }
      ab.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localacw.cpG) });
      localacw.MR(1);
    }
    for (;;)
    {
      boolean bool = super.updateNotify(paramg, false, paramVarArgs);
      AppMethodBeat.o(5451);
      return bool;
      label109:
      localacw.MR(localacw.cpG);
    }
  }
  
  public final e bwI()
  {
    return this.db;
  }
  
  public final int bwJ()
  {
    AppMethodBeat.i(5433);
    Cursor localCursor = rawQuery("select count(*) from FavItemInfo where type = 2", new String[0]);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      int i = localCursor.getInt(0);
      localCursor.close();
      AppMethodBeat.o(5433);
      return i;
    }
    AppMethodBeat.o(5433);
    return 0;
  }
  
  public final List<g> bwK()
  {
    AppMethodBeat.i(5443);
    Object localObject = "select " + mvo + " from FavItemInfo where itemStatus=3";
    localObject = this.db.rawQuery((String)localObject, null);
    if (localObject == null)
    {
      AppMethodBeat.o(5443);
      return null;
    }
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(5443);
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
    AppMethodBeat.o(5443);
    return localLinkedList;
  }
  
  public final List<g> bwL()
  {
    LinkedList localLinkedList = null;
    AppMethodBeat.i(5444);
    Object localObject = "select " + mvo + " from FavItemInfo where itemStatus=1";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5444);
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
    AppMethodBeat.o(5444);
    return localLinkedList;
  }
  
  public final List<g> bwM()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(5447);
    Object localObject = "select " + mvo + " from FavItemInfo where (itemStatus=9 or itemStatus=12)";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5447);
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
    AppMethodBeat.o(5447);
    return localArrayList;
  }
  
  public final List<g> bwN()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(5448);
    Object localObject = "select " + mvo + " from FavItemInfo where itemStatus=17";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5448);
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
    AppMethodBeat.o(5448);
    return localArrayList;
  }
  
  public final List<g> bwO()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(5449);
    Object localObject = "select " + mvo + " from FavItemInfo where itemStatus=3 or itemStatus=6 or itemStatus=11 or itemStatus=14 or itemStatus=16 or itemStatus=18";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5449);
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
    AppMethodBeat.o(5449);
    return localArrayList;
  }
  
  public final List<g> bwP()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(5452);
    Object localObject = "select " + mvo + " from FavItemInfo where flag =  -1 and itemStatus = 0 ";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5452);
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
    AppMethodBeat.o(5452);
    return localArrayList;
  }
  
  public final List<Long> bwQ()
  {
    AppMethodBeat.i(5453);
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = "";
    Object localObject2 = a.msI;
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
    localObject2 = a.msH;
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
      AppMethodBeat.o(5453);
      return localArrayList;
    }
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(5453);
      return localArrayList;
    }
    while (((Cursor)localObject1).moveToNext()) {
      localArrayList.add(Long.valueOf(((Cursor)localObject1).getLong(0)));
    }
    ((Cursor)localObject1).close();
    long l2 = System.currentTimeMillis();
    ab.i("MicroMsg.Fav.FavItemInfoStorage", "getCleanList cu.getCount() = %d,used %dms", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(l2 - l1) });
    AppMethodBeat.o(5453);
    return localArrayList;
  }
  
  public final void bwR()
  {
    AppMethodBeat.i(5454);
    ab.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength");
    Object localObject3 = "select " + mvo + " from FavItemInfo where ";
    Object localObject1 = "";
    Object localObject2 = a.msI;
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
    localObject2 = a.msH;
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
      ab.e("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
      AppMethodBeat.o(5454);
      return;
    }
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      ab.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
      AppMethodBeat.o(5454);
      return;
    }
    ab.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = " + ((Cursor)localObject1).getCount());
    long l2;
    if ((this.db instanceof h)) {
      l2 = ((h)this.db).kr(Thread.currentThread().getId());
    }
    for (;;)
    {
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new g();
        ((g)localObject2).convertFrom((Cursor)localObject1);
        if (vV(((g)localObject2).field_itemStatus))
        {
          if (((g)localObject2).field_favProto != null)
          {
            localObject3 = ((g)localObject2).field_favProto.wVc.iterator();
            for (long l1 = 0L;; l1 = ((aca)((Iterator)localObject3).next()).wSX + l1)
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
          ((h)this.db).nY(l2);
        }
        ((Cursor)localObject1).close();
        ab.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength end");
        AppMethodBeat.o(5454);
        return;
        l2 = 0L;
      }
    }
  }
  
  public final List<Long> bwS()
  {
    AppMethodBeat.i(5455);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select localId from FavItemInfo" + " order by updateTime desc";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5455);
      return localArrayList;
    }
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(5455);
      return localArrayList;
    }
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(Long.valueOf(((Cursor)localObject).getLong(0)));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(5455);
    return localArrayList;
  }
  
  public final g kb(long paramLong)
  {
    AppMethodBeat.i(5431);
    if (this.db == null)
    {
      ab.e("MicroMsg.Fav.FavItemInfoStorage", "getBtLocalId, but db is null, return");
      AppMethodBeat.o(5431);
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
        AppMethodBeat.o(5431);
        return localg;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.Fav.FavItemInfoStorage", "getByLocalId convertFrom(cu) cause IlleagalStateException, return null");
        localCursor.close();
        AppMethodBeat.o(5431);
        return null;
      }
    }
    ab.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByLocalId:%d, no data", new Object[] { Long.valueOf(paramLong) });
    localCursor.close();
    AppMethodBeat.o(5431);
    return null;
  }
  
  public final g kc(long paramLong)
  {
    AppMethodBeat.i(5432);
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
        AppMethodBeat.o(5432);
        return localg;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Fav.FavItemInfoStorage", localException, "", new Object[0]);
        ab.e("MicroMsg.Fav.FavItemInfoStorage", "getByFavId(%d),info.convertFrom error", new Object[] { Long.valueOf(paramLong) });
        ((Cursor)localObject).close();
        AppMethodBeat.o(5432);
        return null;
      }
    }
    ab.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByFavId:%d, no data", new Object[] { Long.valueOf(paramLong) });
    ((Cursor)localObject).close();
    AppMethodBeat.o(5432);
    return null;
  }
  
  public final boolean v(long paramLong, int paramInt)
  {
    AppMethodBeat.i(5437);
    String str = "select count(updateTime) from FavItemInfo where updateTime < ".concat(String.valueOf(paramLong));
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5437);
      return true;
    }
    ((Cursor)localObject).moveToFirst();
    if (((Cursor)localObject).getInt(0) == 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(5437);
      return true;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(5437);
    return false;
  }
  
  public final int vU(int paramInt)
  {
    AppMethodBeat.i(5456);
    Object localObject = "select count(*) from FavItemInfo where id>".concat(String.valueOf(paramInt));
    try
    {
      localObject = this.db.a((String)localObject, null, 2);
      if (localObject == null)
      {
        AppMethodBeat.o(5456);
        return -1;
      }
      if (((Cursor)localObject).getCount() == 0)
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(5456);
        return -1;
      }
      ((Cursor)localObject).moveToNext();
      paramInt = ((Cursor)localObject).getInt(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(5456);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      ab.w("MicroMsg.Fav.FavItemInfoStorage", "getFavHomePosition failed with throwable: " + localThrowable.getMessage());
      AppMethodBeat.o(5456);
    }
    return -1;
  }
  
  public final long w(long paramLong, int paramInt)
  {
    AppMethodBeat.i(5438);
    if (this.db == null)
    {
      ab.e("MicroMsg.Fav.FavItemInfoStorage", "getNextUpdateTime, but db is null, return");
      AppMethodBeat.o(5438);
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
        AppMethodBeat.o(5438);
        return 0L;
      }
      if (((Cursor)localObject).getCount() == 0)
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(5438);
        return 0L;
      }
      ((Cursor)localObject).moveToLast();
      paramLong = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(5438);
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
      AppMethodBeat.o(5438);
      return paramLong;
    }
  }
  
  public final LinkedList<Integer> x(long paramLong, int paramInt)
  {
    AppMethodBeat.i(5440);
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
      AppMethodBeat.o(5440);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext()) {
      localLinkedList.add(Integer.valueOf(((Cursor)localObject).getInt(0)));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(5440);
    return localLinkedList;
  }
  
  public final long y(long paramLong, int paramInt)
  {
    AppMethodBeat.i(5441);
    if (this.db == null)
    {
      ab.e("MicroMsg.Fav.FavItemInfoStorage", "getMinBatchGetUpdateTime, but db is null, return");
      AppMethodBeat.o(5441);
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
        AppMethodBeat.o(5441);
        return 0L;
      }
      if (((Cursor)localObject).getCount() == 0)
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(5441);
        return 0L;
      }
      ((Cursor)localObject).moveToLast();
      paramLong = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(5441);
      return paramLong;
    }
    String str = "select updateTime from (select * from FavItemInfo where updateTime < ".concat(String.valueOf(paramLong));
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = (String)localObject + " order by updateTime desc limit 20";
    localObject = (String)localObject + ") where updateSeq > localSeq";
    localObject = this.db.rawQuery((String)localObject, null);
    if (localObject == null)
    {
      AppMethodBeat.o(5441);
      return 0L;
    }
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(5441);
      return 0L;
    }
    ((Cursor)localObject).moveToLast();
    paramLong = ((Cursor)localObject).getLong(0);
    ((Cursor)localObject).close();
    AppMethodBeat.o(5441);
    return paramLong;
  }
  
  public final boolean y(g paramg)
  {
    AppMethodBeat.i(5435);
    boolean bool;
    acw localacw;
    if (paramg.field_localId > 0L)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramg.field_favProto.wVa != null)
      {
        localacw = paramg.field_favProto.wVa;
        if (localacw.cpG > 0) {
          break label162;
        }
        ab.w("MicroMsg.Fav.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localacw.cpG) });
        localacw.MR(1);
      }
    }
    for (;;)
    {
      b.a(paramg);
      bool = insertNotify(paramg, false);
      if (bool) {
        doNotify(paramg.field_localId, 2, Long.valueOf(paramg.field_localId));
      }
      AppMethodBeat.o(5435);
      return bool;
      bool = false;
      break;
      label162:
      localacw.MR(localacw.cpG);
    }
  }
  
  public final void z(g paramg)
  {
    AppMethodBeat.i(5446);
    String str = "delete from FavItemInfo where localId = " + paramg.field_localId;
    ab.i("MicroMsg.Fav.FavItemInfoStorage", "delete sql: ".concat(String.valueOf(str)));
    this.db.execSQL("FavItemInfo", str);
    doNotify(paramg.field_localId, 5, Long.valueOf(paramg.field_localId));
    AppMethodBeat.o(5446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.d
 * JD-Core Version:    0.7.0.1
 */