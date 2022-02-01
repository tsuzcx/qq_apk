package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends n
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS addr_upload2 ( id int  PRIMARY KEY , md5 text  , peopleid text  , uploadtime long  , realname text  , realnamepyinitial text  , realnamequanpin text  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , type int  , moblie text  , email text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int , lvbuf BLOG , showhead int  ) ", "CREATE INDEX IF NOT EXISTS upload_time_index ON addr_upload2 ( uploadtime ) ", "CREATE INDEX IF NOT EXISTS addr_upload_user_index ON addr_upload2 ( username ) " };
  public final h hHS;
  
  public b(h paramh)
  {
    AppMethodBeat.i(130974);
    this.hHS = paramh;
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
    AppMethodBeat.o(130974);
  }
  
  /* Error */
  public final String JA(String paramString)
  {
    // Byte code:
    //   0: ldc 104
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 109	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +90 -> 99
    //   12: aload_0
    //   13: getfield 34	com/tencent/mm/plugin/account/friend/a/b:hHS	Lcom/tencent/mm/storagebase/h;
    //   16: ldc 43
    //   18: aconst_null
    //   19: ldc 111
    //   21: iconst_1
    //   22: anewarray 12	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aastore
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: iconst_2
    //   33: invokevirtual 114	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokeinterface 117 1 0
    //   45: ifeq +44 -> 89
    //   48: aload_2
    //   49: astore_1
    //   50: new 119	com/tencent/mm/plugin/account/friend/a/a
    //   53: dup
    //   54: invokespecial 120	com/tencent/mm/plugin/account/friend/a/a:<init>	()V
    //   57: astore_3
    //   58: aload_2
    //   59: astore_1
    //   60: aload_3
    //   61: aload_2
    //   62: invokevirtual 124	com/tencent/mm/plugin/account/friend/a/a:convertFrom	(Landroid/database/Cursor;)V
    //   65: aload_2
    //   66: astore_1
    //   67: aload_3
    //   68: invokevirtual 127	com/tencent/mm/plugin/account/friend/a/a:getUsername	()Ljava/lang/String;
    //   71: astore_3
    //   72: aload_2
    //   73: ifnull +9 -> 82
    //   76: aload_2
    //   77: invokeinterface 86 1 0
    //   82: ldc 104
    //   84: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_3
    //   88: areturn
    //   89: aload_2
    //   90: ifnull +9 -> 99
    //   93: aload_2
    //   94: invokeinterface 86 1 0
    //   99: ldc 104
    //   101: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aconst_null
    //   105: areturn
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: ldc 129
    //   113: ldc 131
    //   115: iconst_1
    //   116: anewarray 133	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_3
    //   122: invokevirtual 136	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   125: aastore
    //   126: invokestatic 142	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_2
    //   130: ifnull -31 -> 99
    //   133: aload_2
    //   134: invokeinterface 86 1 0
    //   139: goto -40 -> 99
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull +9 -> 155
    //   149: aload_1
    //   150: invokeinterface 86 1 0
    //   155: ldc 104
    //   157: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: goto -18 -> 145
    //   166: astore_3
    //   167: goto -58 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	b
    //   0	170	1	paramString	String
    //   36	98	2	localCursor	Cursor
    //   142	19	2	localObject1	Object
    //   162	1	2	localObject2	Object
    //   57	31	3	localObject3	Object
    //   106	16	3	localException1	Exception
    //   166	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   12	37	106	java/lang/Exception
    //   12	37	142	finally
    //   39	48	162	finally
    //   50	58	162	finally
    //   60	65	162	finally
    //   67	72	162	finally
    //   111	129	162	finally
    //   39	48	166	java/lang/Exception
    //   50	58	166	java/lang/Exception
    //   60	65	166	java/lang/Exception
    //   67	72	166	java/lang/Exception
  }
  
  public final a Ju(String paramString)
  {
    AppMethodBeat.i(130979);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(130979);
      return null;
    }
    a locala = new a();
    Object localObject = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.username=\"" + bt.aQN(paramString) + "\"";
    localObject = this.hHS.a((String)localObject, null, 2);
    ad.d("MicroMsg.AddrUploadStorage", "get addrUpload :".concat(String.valueOf(paramString)));
    if (((Cursor)localObject).moveToFirst()) {
      locala.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(130979);
    return locala;
  }
  
  public final Cursor Jv(String paramString)
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
    paramString = (String)g.ajC().ajl().get(6, null);
    if ((paramString != null) && (!paramString.equals("")))
    {
      paramString = this.hHS.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + paramString + localStringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
      AppMethodBeat.o(130980);
      return paramString;
    }
    paramString = this.hHS.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + localStringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
    AppMethodBeat.o(130980);
    return paramString;
  }
  
  public final Cursor Jw(String paramString)
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
    paramString = (String)g.ajC().ajl().get(6, null);
    if ((paramString != null) && (!paramString.equals("")))
    {
      paramString = this.hHS.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + paramString + localStringBuilder.toString() + " order by showhead", null, 0);
      AppMethodBeat.o(130981);
      return paramString;
    }
    paramString = this.hHS.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + localStringBuilder.toString() + " order by showhead", null, 0);
    AppMethodBeat.o(130981);
    return paramString;
  }
  
  public final a Jx(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(130982);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(130982);
      return null;
    }
    Object localObject = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.id=" + a.Js(paramString);
    localObject = this.hHS.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locala = new a();
      locala.convertFrom((Cursor)localObject);
    }
    paramString = new StringBuilder("get addrUpload :").append(paramString).append(", resCnt:");
    if (locala != null) {}
    for (int i = 1;; i = 0)
    {
      ad.d("MicroMsg.AddrUploadStorage", i);
      ((Cursor)localObject).close();
      AppMethodBeat.o(130982);
      return locala;
    }
  }
  
  public final List<a> Jy(String paramString)
  {
    AppMethodBeat.i(130984);
    ad.d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(paramString)));
    ArrayList localArrayList = new ArrayList();
    ad.d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(paramString)));
    paramString = this.hHS.a(paramString, null, 2);
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
  
  public final String Jz(String paramString)
  {
    AppMethodBeat.i(130986);
    paramString = Jx(paramString);
    if (paramString != null)
    {
      paramString = paramString.getUsername();
      AppMethodBeat.o(130986);
      return paramString;
    }
    AppMethodBeat.o(130986);
    return null;
  }
  
  public final int a(String paramString, a parama)
  {
    int i = 0;
    AppMethodBeat.i(130978);
    ContentValues localContentValues = parama.convertTo();
    if (localContentValues.size() > 0) {
      i = this.hHS.update("addr_upload2", localContentValues, "id=?", new String[] { a.Js(paramString) });
    }
    if (i > 0)
    {
      if (parama.Lb().equals(paramString)) {
        break label101;
      }
      b(5, this, paramString);
      b(2, this, parama.Lb());
    }
    for (;;)
    {
      AppMethodBeat.o(130978);
      return i;
      label101:
      b(3, this, paramString);
    }
  }
  
  public final boolean aK(List<String> paramList)
  {
    AppMethodBeat.i(130975);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(130975);
      return false;
    }
    br localbr = new br("MicroMsg.AddrUploadStorage", "delete transaction");
    localbr.addSplit("begin");
    long l = this.hHS.xO(Thread.currentThread().getId());
    boolean bool;
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((str != null) && (str.length() > 0))
        {
          int i = this.hHS.delete("addr_upload2", "id =?", new String[] { a.Js(str) });
          ad.d("MicroMsg.AddrUploadStorage", "delete addr_upload2 md5 :" + str + ", res:" + i);
          if (i > 0)
          {
            b(5, this, str);
            continue;
            this.hHS.sJ(l);
          }
        }
      }
    }
    catch (Exception paramList)
    {
      ad.printErrStackTrace("MicroMsg.AddrUploadStorage", paramList, "", new Object[0]);
      bool = false;
    }
    for (;;)
    {
      localbr.addSplit("end");
      localbr.dumpToLog();
      AppMethodBeat.o(130975);
      return bool;
      bool = true;
    }
  }
  
  public final boolean aL(List<String> paramList)
  {
    AppMethodBeat.i(130977);
    br localbr = new br("MicroMsg.AddrUploadStorage", "set uploaded transaction");
    localbr.addSplit("transation begin");
    long l = this.hHS.xO(Thread.currentThread().getId());
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
          ((a)localObject).dDp = 8;
          ((a)localObject).jcS = bt.aQJ();
          localObject = ((a)localObject).convertTo();
          int i = 0;
          if (((ContentValues)localObject).size() > 0) {
            i = this.hHS.update("addr_upload2", (ContentValues)localObject, "id=?", new String[] { a.Js(str) });
          }
          ad.i("MicroMsg.AddrUploadStorage", "local contact uploaded : " + str + ", update result: " + i);
          continue;
          this.hHS.sJ(l);
        }
      }
    }
    catch (Exception paramList)
    {
      ad.e("MicroMsg.AddrUploadStorage", paramList.getMessage());
      bool = false;
    }
    for (;;)
    {
      localbr.addSplit("transation end");
      localbr.dumpToLog();
      if (bool) {
        b(3, this, null);
      }
      AppMethodBeat.o(130977);
      return bool;
      bool = true;
    }
  }
  
  public final List<String[]> aSG()
  {
    AppMethodBeat.i(130983);
    Cursor localCursor = this.hHS.a("select addr_upload2.moblie , addr_upload2.md5 from addr_upload2 where addr_upload2.type = 0", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(new String[] { localCursor.getString(0), localCursor.getString(1) });
    }
    localCursor.close();
    AppMethodBeat.o(130983);
    return localArrayList;
  }
  
  public final boolean aSH()
  {
    AppMethodBeat.i(130985);
    if ((this.hHS == null) || (this.hHS.fmj()))
    {
      if (this.hHS == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.hHS.fmj()))
      {
        ad.w("MicroMsg.AddrUploadStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(130985);
        return false;
      }
    }
    AppMethodBeat.o(130985);
    return true;
  }
  
  public final boolean am(List<a> paramList)
  {
    AppMethodBeat.i(130976);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(130976);
      return false;
    }
    br localbr = new br("MicroMsg.AddrUploadStorage", "transaction");
    localbr.addSplit("transation begin");
    long l = this.hHS.xO(Thread.currentThread().getId());
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
        localObject = locala.Lb();
        localObject = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where addr_upload2.id = " + a.Js((String)localObject);
        localObject = this.hHS.a((String)localObject, null, 2);
        if (localObject != null) {
          continue;
        }
        bool = false;
        if (bool) {
          continue;
        }
        locala.dDp = -1;
        localObject = locala.convertTo();
        if ((int)this.hHS.a("addr_upload2", "id", (ContentValues)localObject) != -1) {
          continue;
        }
        ad.i("MicroMsg.AddrUploadStorage", "batchSet insert failed, num:%s email:%s", new Object[] { locala.aSD(), locala.getEmail() });
        bool = true;
      }
      catch (Exception paramList)
      {
        a locala;
        ad.e("MicroMsg.AddrUploadStorage", paramList.getMessage());
        boolean bool = false;
        continue;
        b(2, this, locala.Lb());
        continue;
        int k = a.Js(locala.Lb());
        Object localObject = locala.convertTo();
        int j = 0;
        if (((ContentValues)localObject).size() <= 0) {
          continue;
        }
        j = this.hHS.update("addr_upload2", (ContentValues)localObject, "id=?", new String[] { String.valueOf(k) });
        if (j != 0) {
          continue;
        }
        ad.i("MicroMsg.AddrUploadStorage", "batchSet update result=0, num:%s email:%s", new Object[] { locala.aSD(), locala.getEmail() });
        continue;
        if (j >= 0) {
          continue;
        }
        ad.i("MicroMsg.AddrUploadStorage", "batchSet update failed, num:%s email:%s", new Object[] { locala.aSD(), locala.getEmail() });
        bool = true;
        continue;
        b(3, this, locala.Lb());
        continue;
        bool = true;
        continue;
        i += 1;
      }
      this.hHS.sJ(l);
      localbr.addSplit("transation end");
      localbr.dumpToLog();
      AppMethodBeat.o(130976);
      return bool;
      bool = ((Cursor)localObject).moveToFirst();
      ((Cursor)localObject).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.b
 * JD-Core Version:    0.7.0.1
 */