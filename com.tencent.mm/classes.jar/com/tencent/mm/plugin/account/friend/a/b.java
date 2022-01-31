package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends n
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS addr_upload2 ( id int  PRIMARY KEY , md5 text  , peopleid text  , uploadtime long  , realname text  , realnamepyinitial text  , realnamequanpin text  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , type int  , moblie text  , email text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int , lvbuf BLOG , showhead int  ) ", "CREATE INDEX IF NOT EXISTS upload_time_index ON addr_upload2 ( uploadtime ) ", "CREATE INDEX IF NOT EXISTS addr_upload_user_index ON addr_upload2 ( username ) " };
  public final h fnw;
  
  public b(h paramh)
  {
    AppMethodBeat.i(108309);
    this.fnw = paramh;
    Cursor localCursor = paramh.a("PRAGMA table_info( " + "addr_upload2" + " )", null, 2);
    int k = localCursor.getColumnIndex("name");
    int j = 0;
    int i = 0;
    while (localCursor.moveToNext()) {
      if (k >= 0)
      {
        String str = localCursor.getString(k);
        if ("lvbuf".equalsIgnoreCase(str)) {
          i = 1;
        } else if ("showhead".equalsIgnoreCase(str)) {
          j = 1;
        }
      }
    }
    localCursor.close();
    if (i == 0) {
      paramh.execSQL("addr_upload2", "Alter table " + "addr_upload2" + " add lvbuf BLOB ");
    }
    if (j == 0) {
      paramh.execSQL("addr_upload2", "Alter table " + "addr_upload2" + " add showhead int ");
    }
    AppMethodBeat.o(108309);
  }
  
  public final boolean X(List<a> paramList)
  {
    AppMethodBeat.i(108311);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(108311);
      return false;
    }
    bm localbm = new bm("MicroMsg.AddrUploadStorage", "transaction");
    localbm.addSplit("transation begin");
    long l = this.fnw.kr(Thread.currentThread().getId());
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramList.size()) {
          continue;
        }
        locala = (a)paramList.get(i);
        if (locala == null) {
          continue;
        }
        localObject = locala.Al();
        localObject = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where addr_upload2.id = \"" + a.wV((String)localObject) + "\"";
        localObject = this.fnw.a((String)localObject, null, 2);
        if (localObject != null) {
          continue;
        }
        bool = false;
        if (bool) {
          continue;
        }
        locala.bsY = -1;
        localObject = locala.convertTo();
        if ((int)this.fnw.a("addr_upload2", "id", (ContentValues)localObject) != -1) {
          continue;
        }
        ab.i("MicroMsg.AddrUploadStorage", "batchSet insert failed, num:%s email:%s", new Object[] { locala.aqf(), locala.getEmail() });
        bool = true;
      }
      catch (Exception paramList)
      {
        a locala;
        ab.e("MicroMsg.AddrUploadStorage", paramList.getMessage());
        boolean bool = false;
        continue;
        b(2, this, locala.Al());
        continue;
        int k = a.wV(locala.Al());
        Object localObject = locala.convertTo();
        int j = 0;
        if (((ContentValues)localObject).size() <= 0) {
          continue;
        }
        j = this.fnw.update("addr_upload2", (ContentValues)localObject, "id=?", new String[] { String.valueOf(k) });
        if (j != 0) {
          continue;
        }
        ab.i("MicroMsg.AddrUploadStorage", "batchSet update result=0, num:%s email:%s", new Object[] { locala.aqf(), locala.getEmail() });
        continue;
        if (j >= 0) {
          continue;
        }
        ab.i("MicroMsg.AddrUploadStorage", "batchSet update failed, num:%s email:%s", new Object[] { locala.aqf(), locala.getEmail() });
        bool = true;
        continue;
        b(3, this, locala.Al());
        continue;
        bool = true;
        continue;
        i += 1;
      }
      this.fnw.nY(l);
      localbm.addSplit("transation end");
      localbm.dumpToLog();
      AppMethodBeat.o(108311);
      return bool;
      bool = ((Cursor)localObject).moveToFirst();
      ((Cursor)localObject).close();
    }
  }
  
  public final int a(String paramString, a parama)
  {
    int i = 0;
    AppMethodBeat.i(108313);
    ContentValues localContentValues = parama.convertTo();
    if (localContentValues.size() > 0) {
      i = this.fnw.update("addr_upload2", localContentValues, "id=?", new String[] { a.wV(paramString) });
    }
    if (i > 0)
    {
      if (parama.Al().equals(paramString)) {
        break label98;
      }
      b(5, this, paramString);
      b(2, this, parama.Al());
    }
    for (;;)
    {
      AppMethodBeat.o(108313);
      return i;
      label98:
      b(3, this, paramString);
    }
  }
  
  public final boolean an(List<String> paramList)
  {
    AppMethodBeat.i(108310);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(108310);
      return false;
    }
    bm localbm = new bm("MicroMsg.AddrUploadStorage", "delete transaction");
    localbm.addSplit("begin");
    long l = this.fnw.kr(Thread.currentThread().getId());
    boolean bool;
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((str != null) && (str.length() > 0))
        {
          int i = this.fnw.delete("addr_upload2", "id =?", new String[] { a.wV(str) });
          ab.d("MicroMsg.AddrUploadStorage", "delete addr_upload2 md5 :" + str + ", res:" + i);
          if (i > 0)
          {
            b(5, this, str);
            continue;
            this.fnw.nY(l);
          }
        }
      }
    }
    catch (Exception paramList)
    {
      ab.printErrStackTrace("MicroMsg.AddrUploadStorage", paramList, "", new Object[0]);
      bool = false;
    }
    for (;;)
    {
      localbm.addSplit("end");
      localbm.dumpToLog();
      AppMethodBeat.o(108310);
      return bool;
      bool = true;
    }
  }
  
  public final boolean ao(List<String> paramList)
  {
    AppMethodBeat.i(108312);
    bm localbm = new bm("MicroMsg.AddrUploadStorage", "set uploaded transaction");
    localbm.addSplit("transation begin");
    long l = this.fnw.kr(Thread.currentThread().getId());
    boolean bool;
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((str != null) && (str.length() > 0))
        {
          Object localObject = new a();
          ((a)localObject).bsY = 8;
          ((a)localObject).gwF = bo.aox();
          localObject = ((a)localObject).convertTo();
          int i = 0;
          if (((ContentValues)localObject).size() > 0) {
            i = this.fnw.update("addr_upload2", (ContentValues)localObject, "id=?", new String[] { a.wV(str) });
          }
          ab.i("MicroMsg.AddrUploadStorage", "local contact uploaded : " + str + ", update result: " + i);
          continue;
          this.fnw.nY(l);
        }
      }
    }
    catch (Exception paramList)
    {
      ab.e("MicroMsg.AddrUploadStorage", paramList.getMessage());
      bool = false;
    }
    for (;;)
    {
      localbm.addSplit("transation end");
      localbm.dumpToLog();
      if (bool) {
        b(3, this, null);
      }
      AppMethodBeat.o(108312);
      return bool;
      bool = true;
    }
  }
  
  public final List<String[]> aqi()
  {
    AppMethodBeat.i(108318);
    Cursor localCursor = this.fnw.a("select addr_upload2.moblie , addr_upload2.md5 from addr_upload2 where addr_upload2.type = 0", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(new String[] { localCursor.getString(0), localCursor.getString(1) });
    }
    localCursor.close();
    AppMethodBeat.o(108318);
    return localArrayList;
  }
  
  public final boolean aqj()
  {
    AppMethodBeat.i(108320);
    if ((this.fnw == null) || (this.fnw.dun()))
    {
      if (this.fnw == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.fnw.dun()))
      {
        ab.w("MicroMsg.AddrUploadStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(108320);
        return false;
      }
    }
    AppMethodBeat.o(108320);
    return true;
  }
  
  public final a wX(String paramString)
  {
    AppMethodBeat.i(108314);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(108314);
      return null;
    }
    a locala = new a();
    Object localObject = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.username=\"" + bo.wC(paramString) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    ab.d("MicroMsg.AddrUploadStorage", "get addrUpload :".concat(String.valueOf(paramString)));
    if (((Cursor)localObject).moveToFirst()) {
      locala.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(108314);
    return locala;
  }
  
  public final Cursor wY(String paramString)
  {
    AppMethodBeat.i(108315);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString != null) && (paramString.length() > 0))
    {
      localStringBuilder.append(" and ( ");
      localStringBuilder.append("addr_upload2.realname like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.realnamepyinitial like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.realnamequanpin like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.username like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.nickname like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.nicknamepyinitial like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.nicknamequanpin like '%" + paramString + "%' )");
    }
    localStringBuilder.append(" and (");
    localStringBuilder.append("addr_upload2.status=1");
    localStringBuilder.append(" or ");
    localStringBuilder.append("addr_upload2.status=2");
    localStringBuilder.append(")");
    paramString = (String)g.RL().Ru().get(6, null);
    if ((paramString != null) && (!paramString.equals("")))
    {
      paramString = this.fnw.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + paramString + localStringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
      AppMethodBeat.o(108315);
      return paramString;
    }
    paramString = this.fnw.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + localStringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
    AppMethodBeat.o(108315);
    return paramString;
  }
  
  public final Cursor wZ(String paramString)
  {
    AppMethodBeat.i(108316);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString != null) && (paramString.length() > 0))
    {
      localStringBuilder.append(" and ( ");
      localStringBuilder.append("addr_upload2.realname like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.realnamepyinitial like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.realnamequanpin like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.username like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.nickname like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.nicknamepyinitial like '%" + paramString + "%' or ");
      localStringBuilder.append("addr_upload2.nicknamequanpin like '%" + paramString + "%' )");
    }
    localStringBuilder.append(" and (");
    localStringBuilder.append("addr_upload2.status=1");
    localStringBuilder.append(" or ");
    localStringBuilder.append("addr_upload2.status=2");
    localStringBuilder.append(")");
    paramString = (String)g.RL().Ru().get(6, null);
    if ((paramString != null) && (!paramString.equals("")))
    {
      paramString = this.fnw.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + paramString + localStringBuilder.toString() + " order by showhead", null, 0);
      AppMethodBeat.o(108316);
      return paramString;
    }
    paramString = this.fnw.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + localStringBuilder.toString() + " order by showhead", null, 0);
    AppMethodBeat.o(108316);
    return paramString;
  }
  
  public final a xa(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(108317);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(108317);
      return null;
    }
    Object localObject = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.id=\"" + a.wV(paramString) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locala = new a();
      locala.convertFrom((Cursor)localObject);
    }
    paramString = new StringBuilder("get addrUpload :").append(paramString).append(", resCnt:");
    if (locala != null) {}
    for (int i = 1;; i = 0)
    {
      ab.d("MicroMsg.AddrUploadStorage", i);
      ((Cursor)localObject).close();
      AppMethodBeat.o(108317);
      return locala;
    }
  }
  
  public final List<a> xb(String paramString)
  {
    AppMethodBeat.i(108319);
    ab.d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(paramString)));
    ArrayList localArrayList = new ArrayList();
    ab.d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(paramString)));
    paramString = this.fnw.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(paramString);
      localArrayList.add(locala);
    }
    paramString.close();
    AppMethodBeat.o(108319);
    return localArrayList;
  }
  
  public final String xc(String paramString)
  {
    AppMethodBeat.i(108321);
    paramString = xa(paramString);
    if (paramString != null)
    {
      paramString = paramString.getUsername();
      AppMethodBeat.o(108321);
      return paramString;
    }
    AppMethodBeat.o(108321);
    return null;
  }
  
  /* Error */
  public final String xd(String paramString)
  {
    // Byte code:
    //   0: ldc_w 430
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 331	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +92 -> 102
    //   13: aload_0
    //   14: getfield 34	com/tencent/mm/plugin/account/friend/a/b:fnw	Lcom/tencent/mm/cg/h;
    //   17: ldc 43
    //   19: aconst_null
    //   20: ldc_w 432
    //   23: iconst_1
    //   24: anewarray 12	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: aastore
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: iconst_2
    //   35: invokevirtual 435	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokeinterface 197 1 0
    //   47: ifeq +45 -> 92
    //   50: aload_2
    //   51: astore_1
    //   52: new 144	com/tencent/mm/plugin/account/friend/a/a
    //   55: dup
    //   56: invokespecial 281	com/tencent/mm/plugin/account/friend/a/a:<init>	()V
    //   59: astore_3
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: aload_2
    //   64: invokevirtual 349	com/tencent/mm/plugin/account/friend/a/a:convertFrom	(Landroid/database/Cursor;)V
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 428	com/tencent/mm/plugin/account/friend/a/a:getUsername	()Ljava/lang/String;
    //   73: astore_3
    //   74: aload_2
    //   75: ifnull +9 -> 84
    //   78: aload_2
    //   79: invokeinterface 86 1 0
    //   84: ldc_w 430
    //   87: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_3
    //   91: areturn
    //   92: aload_2
    //   93: ifnull +9 -> 102
    //   96: aload_2
    //   97: invokeinterface 86 1 0
    //   102: ldc_w 430
    //   105: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: astore_1
    //   115: ldc 114
    //   117: ldc_w 437
    //   120: iconst_1
    //   121: anewarray 174	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_3
    //   127: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: aastore
    //   131: invokestatic 439	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: aload_2
    //   135: ifnull -33 -> 102
    //   138: aload_2
    //   139: invokeinterface 86 1 0
    //   144: goto -42 -> 102
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +9 -> 160
    //   154: aload_1
    //   155: invokeinterface 86 1 0
    //   160: ldc_w 430
    //   163: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_2
    //   167: athrow
    //   168: astore_2
    //   169: goto -19 -> 150
    //   172: astore_3
    //   173: goto -60 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	b
    //   0	176	1	paramString	String
    //   38	101	2	localCursor	Cursor
    //   147	20	2	localObject1	Object
    //   168	1	2	localObject2	Object
    //   59	32	3	localObject3	Object
    //   110	17	3	localException1	Exception
    //   172	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   13	39	110	java/lang/Exception
    //   13	39	147	finally
    //   41	50	168	finally
    //   52	60	168	finally
    //   62	67	168	finally
    //   69	74	168	finally
    //   115	134	168	finally
    //   41	50	172	java/lang/Exception
    //   52	60	172	java/lang/Exception
    //   62	67	172	java/lang/Exception
    //   69	74	172	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.b
 * JD-Core Version:    0.7.0.1
 */