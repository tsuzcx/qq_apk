package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.TimeLogger;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends MStorageEx
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS addr_upload2 ( id int  PRIMARY KEY , md5 text  , peopleid text  , uploadtime long  , realname text  , realnamepyinitial text  , realnamequanpin text  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , type int  , moblie text  , email text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int , lvbuf BLOG , showhead int  ) ", "CREATE INDEX IF NOT EXISTS upload_time_index ON addr_upload2 ( uploadtime ) ", "CREATE INDEX IF NOT EXISTS addr_upload_user_index ON addr_upload2 ( username ) " };
  public final h iFy;
  
  public b(h paramh)
  {
    AppMethodBeat.i(130974);
    this.iFy = paramh;
    Cursor localCursor = paramh.rawQuery("PRAGMA table_info( " + "addr_upload2" + " )", null, 2);
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
    AppMethodBeat.o(130974);
  }
  
  public final a SR(String paramString)
  {
    AppMethodBeat.i(130979);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(130979);
      return null;
    }
    a locala = new a();
    Object localObject = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.username=\"" + Util.escapeSqlValue(paramString) + "\"";
    localObject = this.iFy.rawQuery((String)localObject, null, 2);
    Log.d("MicroMsg.AddrUploadStorage", "get addrUpload :".concat(String.valueOf(paramString)));
    if (((Cursor)localObject).moveToFirst()) {
      locala.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(130979);
    return locala;
  }
  
  public final Cursor SS(String paramString)
  {
    AppMethodBeat.i(130980);
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
    paramString = (String)g.aAh().azQ().get(6, null);
    if ((paramString != null) && (!paramString.equals("")))
    {
      paramString = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + paramString + localStringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null);
      AppMethodBeat.o(130980);
      return paramString;
    }
    paramString = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + localStringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null);
    AppMethodBeat.o(130980);
    return paramString;
  }
  
  public final Cursor ST(String paramString)
  {
    AppMethodBeat.i(130981);
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
    paramString = (String)g.aAh().azQ().get(6, null);
    if ((paramString != null) && (!paramString.equals("")))
    {
      paramString = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + paramString + localStringBuilder.toString() + " order by showhead", null);
      AppMethodBeat.o(130981);
      return paramString;
    }
    paramString = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + localStringBuilder.toString() + " order by showhead", null);
    AppMethodBeat.o(130981);
    return paramString;
  }
  
  public final a SU(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(130982);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(130982);
      return null;
    }
    Object localObject = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.id=" + a.SQ(paramString);
    localObject = this.iFy.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locala = new a();
      locala.convertFrom((Cursor)localObject);
    }
    paramString = new StringBuilder("get addrUpload :").append(paramString).append(", resCnt:");
    if (locala != null) {}
    for (int i = 1;; i = 0)
    {
      Log.d("MicroMsg.AddrUploadStorage", i);
      ((Cursor)localObject).close();
      AppMethodBeat.o(130982);
      return locala;
    }
  }
  
  public final List<a> SV(String paramString)
  {
    AppMethodBeat.i(130984);
    Log.d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(paramString)));
    ArrayList localArrayList = new ArrayList();
    Log.d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(paramString)));
    paramString = this.iFy.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(paramString);
      localArrayList.add(locala);
    }
    paramString.close();
    AppMethodBeat.o(130984);
    return localArrayList;
  }
  
  public final String SW(String paramString)
  {
    AppMethodBeat.i(130986);
    paramString = SU(paramString);
    if (paramString != null)
    {
      paramString = paramString.getUsername();
      AppMethodBeat.o(130986);
      return paramString;
    }
    AppMethodBeat.o(130986);
    return null;
  }
  
  /* Error */
  public final String SX(String paramString)
  {
    // Byte code:
    //   0: ldc 255
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 107	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +91 -> 100
    //   12: aload_0
    //   13: getfield 34	com/tencent/mm/plugin/account/friend/a/b:iFy	Lcom/tencent/mm/storagebase/h;
    //   16: ldc 43
    //   18: aconst_null
    //   19: ldc_w 257
    //   22: iconst_1
    //   23: anewarray 12	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: iconst_2
    //   34: invokevirtual 261	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   37: astore_2
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: invokeinterface 138 1 0
    //   46: ifeq +44 -> 90
    //   49: aload_2
    //   50: astore_1
    //   51: new 109	com/tencent/mm/plugin/account/friend/a/a
    //   54: dup
    //   55: invokespecial 110	com/tencent/mm/plugin/account/friend/a/a:<init>	()V
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: aload_2
    //   63: invokevirtual 142	com/tencent/mm/plugin/account/friend/a/a:convertFrom	(Landroid/database/Cursor;)V
    //   66: aload_2
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 251	com/tencent/mm/plugin/account/friend/a/a:getUsername	()Ljava/lang/String;
    //   72: astore_3
    //   73: aload_2
    //   74: ifnull +9 -> 83
    //   77: aload_2
    //   78: invokeinterface 86 1 0
    //   83: ldc 255
    //   85: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_3
    //   89: areturn
    //   90: aload_2
    //   91: ifnull +9 -> 100
    //   94: aload_2
    //   95: invokeinterface 86 1 0
    //   100: ldc 255
    //   102: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: ldc 120
    //   114: ldc_w 263
    //   117: iconst_1
    //   118: anewarray 265	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_3
    //   124: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   127: aastore
    //   128: invokestatic 272	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_2
    //   132: ifnull -32 -> 100
    //   135: aload_2
    //   136: invokeinterface 86 1 0
    //   141: goto -41 -> 100
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +9 -> 157
    //   151: aload_1
    //   152: invokeinterface 86 1 0
    //   157: ldc 255
    //   159: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_2
    //   163: athrow
    //   164: astore_2
    //   165: goto -18 -> 147
    //   168: astore_3
    //   169: goto -59 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	b
    //   0	172	1	paramString	String
    //   37	99	2	localCursor	Cursor
    //   144	19	2	localObject1	Object
    //   164	1	2	localObject2	Object
    //   58	31	3	localObject3	Object
    //   107	17	3	localException1	Exception
    //   168	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   12	38	107	java/lang/Exception
    //   12	38	144	finally
    //   40	49	164	finally
    //   51	59	164	finally
    //   61	66	164	finally
    //   68	73	164	finally
    //   112	131	164	finally
    //   40	49	168	java/lang/Exception
    //   51	59	168	java/lang/Exception
    //   61	66	168	java/lang/Exception
    //   68	73	168	java/lang/Exception
  }
  
  public final int a(String paramString, a parama)
  {
    int i = 0;
    AppMethodBeat.i(130978);
    ContentValues localContentValues = parama.convertTo();
    if (localContentValues.size() > 0) {
      i = this.iFy.update("addr_upload2", localContentValues, "id=?", new String[] { a.SQ(paramString) });
    }
    if (i > 0)
    {
      if (parama.getMd5().equals(paramString)) {
        break label101;
      }
      doNotify(5, this, paramString);
      doNotify(2, this, parama.getMd5());
    }
    for (;;)
    {
      AppMethodBeat.o(130978);
      return i;
      label101:
      doNotify(3, this, paramString);
    }
  }
  
  public final boolean aT(List<String> paramList)
  {
    AppMethodBeat.i(130975);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(130975);
      return false;
    }
    TimeLogger localTimeLogger = new TimeLogger("MicroMsg.AddrUploadStorage", "delete transaction");
    localTimeLogger.addSplit("begin");
    long l = this.iFy.beginTransaction(Thread.currentThread().getId());
    boolean bool;
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((str != null) && (str.length() > 0))
        {
          int i = this.iFy.delete("addr_upload2", "id =?", new String[] { a.SQ(str) });
          Log.d("MicroMsg.AddrUploadStorage", "delete addr_upload2 md5 :" + str + ", res:" + i);
          if (i > 0)
          {
            doNotify(5, this, str);
            continue;
            this.iFy.endTransaction(l);
          }
        }
      }
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.AddrUploadStorage", paramList, "", new Object[0]);
      bool = false;
    }
    for (;;)
    {
      localTimeLogger.addSplit("end");
      localTimeLogger.dumpToLog();
      AppMethodBeat.o(130975);
      return bool;
      bool = true;
    }
  }
  
  public final boolean aU(List<String> paramList)
  {
    AppMethodBeat.i(130977);
    TimeLogger localTimeLogger = new TimeLogger("MicroMsg.AddrUploadStorage", "set uploaded transaction");
    localTimeLogger.addSplit("transation begin");
    long l = this.iFy.beginTransaction(Thread.currentThread().getId());
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
          ((a)localObject).cSx = 8;
          ((a)localObject).kdO = Util.nowSecond();
          localObject = ((a)localObject).convertTo();
          int i = 0;
          if (((ContentValues)localObject).size() > 0) {
            i = this.iFy.update("addr_upload2", (ContentValues)localObject, "id=?", new String[] { a.SQ(str) });
          }
          Log.i("MicroMsg.AddrUploadStorage", "local contact uploaded : " + str + ", update result: " + i);
          continue;
          this.iFy.endTransaction(l);
        }
      }
    }
    catch (Exception paramList)
    {
      Log.e("MicroMsg.AddrUploadStorage", paramList.getMessage());
      bool = false;
    }
    for (;;)
    {
      localTimeLogger.addSplit("transation end");
      localTimeLogger.dumpToLog();
      if (bool) {
        doNotify(3, this, null);
      }
      AppMethodBeat.o(130977);
      return bool;
      bool = true;
    }
  }
  
  public final boolean av(List<a> paramList)
  {
    AppMethodBeat.i(130976);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(130976);
      return false;
    }
    TimeLogger localTimeLogger = new TimeLogger("MicroMsg.AddrUploadStorage", "transaction");
    localTimeLogger.addSplit("transation begin");
    long l = this.iFy.beginTransaction(Thread.currentThread().getId());
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
        localObject = locala.getMd5();
        localObject = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where addr_upload2.id = " + a.SQ((String)localObject);
        localObject = this.iFy.rawQuery((String)localObject, null, 2);
        if (localObject != null) {
          continue;
        }
        bool = false;
        if (bool) {
          continue;
        }
        locala.cSx = -1;
        localObject = locala.convertTo();
        if ((int)this.iFy.insert("addr_upload2", "id", (ContentValues)localObject) != -1) {
          continue;
        }
        Log.i("MicroMsg.AddrUploadStorage", "batchSet insert failed, num:%s email:%s", new Object[] { locala.bnP(), locala.getEmail() });
        bool = true;
      }
      catch (Exception paramList)
      {
        a locala;
        Log.e("MicroMsg.AddrUploadStorage", paramList.getMessage());
        boolean bool = false;
        continue;
        doNotify(2, this, locala.getMd5());
        continue;
        int k = a.SQ(locala.getMd5());
        Object localObject = locala.convertTo();
        int j = 0;
        if (((ContentValues)localObject).size() <= 0) {
          continue;
        }
        j = this.iFy.update("addr_upload2", (ContentValues)localObject, "id=?", new String[] { String.valueOf(k) });
        if (j != 0) {
          continue;
        }
        Log.i("MicroMsg.AddrUploadStorage", "batchSet update result=0, num:%s email:%s", new Object[] { locala.bnP(), locala.getEmail() });
        continue;
        if (j >= 0) {
          continue;
        }
        Log.i("MicroMsg.AddrUploadStorage", "batchSet update failed, num:%s email:%s", new Object[] { locala.bnP(), locala.getEmail() });
        bool = true;
        continue;
        doNotify(3, this, locala.getMd5());
        continue;
        bool = true;
        continue;
        i += 1;
      }
      this.iFy.endTransaction(l);
      localTimeLogger.addSplit("transation end");
      localTimeLogger.dumpToLog();
      AppMethodBeat.o(130976);
      return bool;
      bool = ((Cursor)localObject).moveToFirst();
      ((Cursor)localObject).close();
    }
  }
  
  public final List<String[]> bnS()
  {
    AppMethodBeat.i(130983);
    Cursor localCursor = this.iFy.rawQuery("select addr_upload2.moblie , addr_upload2.md5 from addr_upload2 where addr_upload2.type = 0", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(new String[] { localCursor.getString(0), localCursor.getString(1) });
    }
    localCursor.close();
    AppMethodBeat.o(130983);
    return localArrayList;
  }
  
  public final boolean shouldProcessEvent()
  {
    AppMethodBeat.i(130985);
    if ((this.iFy == null) || (this.iFy.isClose()))
    {
      if (this.iFy == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.iFy.isClose()))
      {
        Log.w("MicroMsg.AddrUploadStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(130985);
        return false;
      }
    }
    AppMethodBeat.o(130985);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.b
 * JD-Core Version:    0.7.0.1
 */