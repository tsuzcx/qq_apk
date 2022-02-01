package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;

public final class s
  extends MAutoStorage<o>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(41499);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(o.info, "GameRawMessage") };
    AppMethodBeat.o(41499);
  }
  
  public s(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, o.info, "GameRawMessage", null);
  }
  
  public static String H(int... paramVarArgs)
  {
    AppMethodBeat.i(41498);
    String str = "" + "(";
    int i = 0;
    while (i < 5)
    {
      str = str + "msgType=" + paramVarArgs[i] + " or ";
      i += 1;
    }
    paramVarArgs = str + "msgType=" + paramVarArgs[5];
    paramVarArgs = paramVarArgs + ")";
    AppMethodBeat.o(41498);
    return paramVarArgs;
  }
  
  public final Cursor XA(int paramInt)
  {
    AppMethodBeat.i(183866);
    Cursor localCursor = rawQuery("select * from GameRawMessage where showType = " + paramInt + " and showInMsgList = 1 and isHidden = 0" + " order by isRead, createTime desc", new String[0]);
    AppMethodBeat.o(183866);
    return localCursor;
  }
  
  public final o XB(int paramInt)
  {
    o localo = null;
    AppMethodBeat.i(275420);
    Cursor localCursor = XA(paramInt);
    if (localCursor == null)
    {
      AppMethodBeat.o(275420);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localo = new o();
      localo.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(275420);
    return localo;
  }
  
  public final int XC(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(184805);
    Cursor localCursor = XA(paramInt);
    if (localCursor == null)
    {
      AppMethodBeat.o(184805);
      return 0;
    }
    paramInt = i;
    if (localCursor.moveToFirst()) {
      paramInt = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(184805);
    return paramInt;
  }
  
  public final int XD(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(183867);
    Cursor localCursor = rawQuery("select count(*) from GameRawMessage where showType = " + paramInt + " and isRead=0 and showInMsgList = 1 and isHidden" + " = 0", new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(183867);
      return 0;
    }
    paramInt = i;
    if (localCursor.moveToFirst()) {
      paramInt = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(183867);
    return paramInt;
  }
  
  public final boolean XE(int paramInt)
  {
    AppMethodBeat.i(275427);
    boolean bool = execSQL("GameRawMessage", "delete from GameRawMessage where showType = ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(275427);
    return bool;
  }
  
  public final o aGL(String paramString)
  {
    AppMethodBeat.i(184804);
    paramString = rawQuery("select * from GameRawMessage where gameMsgId = \"" + paramString + "\"", new String[0]);
    if (paramString == null)
    {
      AppMethodBeat.o(184804);
      return null;
    }
    o localo = new o();
    if (paramString.moveToFirst()) {
      localo.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(184804);
    return localo;
  }
  
  public final LinkedList<o> b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(41493);
    Object localObject2;
    Object localObject1;
    if (paramLong == 0L)
    {
      localObject2 = "9223372036854775807";
      if (paramInt2 != 0) {
        break label154;
      }
      localObject1 = "(isRead=1 or isRead=0) ";
    }
    Object localObject3;
    for (;;)
    {
      localObject3 = "";
      if (paramInt1 != 65536) {
        localObject3 = "msgType=" + paramInt1 + " and ";
      }
      localObject2 = String.format("select * from GameRawMessage where " + (String)localObject3 + "msgId<%s and " + (String)localObject1 + "order by createTime desc limit %s", new Object[] { localObject2, String.valueOf(paramInt3) });
      localObject1 = new LinkedList();
      localObject2 = rawQuery((String)localObject2, new String[0]);
      if (localObject2 != null) {
        break label187;
      }
      AppMethodBeat.o(41493);
      return localObject1;
      localObject2 = String.valueOf(paramLong);
      break;
      label154:
      if (paramInt2 == 1)
      {
        localObject1 = "isRead=0 ";
      }
      else
      {
        if (paramInt2 != 2) {
          break label180;
        }
        localObject1 = "isRead=1 ";
      }
    }
    label180:
    AppMethodBeat.o(41493);
    return null;
    label187:
    if (((Cursor)localObject2).moveToFirst()) {
      do
      {
        localObject3 = new o();
        ((o)localObject3).convertFrom((Cursor)localObject2);
        ((LinkedList)localObject1).add(localObject3);
      } while (((Cursor)localObject2).moveToNext());
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(41493);
    return localObject1;
  }
  
  public final boolean e(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(41494);
    if (paramArrayOfLong.length != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgId in (");
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        localStringBuilder.append(paramArrayOfLong[i]);
        if (i != paramArrayOfLong.length - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      localStringBuilder.append(")");
      boolean bool = execSQL("GameRawMessage", String.format("update GameRawMessage set isRead=1 where %s", new Object[] { localStringBuilder.toString() }));
      AppMethodBeat.o(41494);
      return bool;
    }
    AppMethodBeat.o(41494);
    return false;
  }
  
  public final boolean f(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(275425);
    if (paramArrayOfLong.length != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgId in (");
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        localStringBuilder.append(paramArrayOfLong[i]);
        if (i != paramArrayOfLong.length - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      localStringBuilder.append(")");
      boolean bool = execSQL("GameRawMessage", String.format("delete from GameRawMessage where %s", new Object[] { localStringBuilder.toString() }));
      AppMethodBeat.o(275425);
      return bool;
    }
    AppMethodBeat.o(275425);
    return false;
  }
  
  public final void fGA()
  {
    AppMethodBeat.i(41495);
    execSQL("GameRawMessage", "update GameRawMessage set isHidden = 0 where isHidden = 1");
    AppMethodBeat.o(41495);
  }
  
  public final void fGB()
  {
    AppMethodBeat.i(41496);
    String str = H(new int[] { 2, 5, 6, 10, 11, 100 });
    execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where isRead=0 and " + str + " and isHidden = 0");
    AppMethodBeat.o(41496);
  }
  
  public final void fGC()
  {
    AppMethodBeat.i(183865);
    String str = "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 100000,1" + ")";
    Log.i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", new Object[] { Boolean.valueOf(execSQL("GameRawMessage", str)), str });
    AppMethodBeat.o(183865);
  }
  
  public final int fGD()
  {
    int i = 0;
    AppMethodBeat.i(41497);
    Object localObject = H(new int[] { 2, 5, 6, 10, 11, 100 });
    localObject = rawQuery("select count(*) from GameRawMessage where " + (String)localObject + " and isRead=0 and showInMsgList = 1 and isHidden" + " = 0", new String[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(41497);
      return 0;
    }
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(41497);
    return i;
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(275424);
    execSQL("GameRawMessage", "delete from GameRawMessage");
    AppMethodBeat.o(275424);
  }
  
  public final c.b fGF()
  {
    AppMethodBeat.i(275430);
    c.b localb = new c.b();
    try
    {
      long l = System.currentTimeMillis();
      Cursor localCursor = rawQuery("select count(*) from GameRawMessage where rawXML like \"%<chatmsg%\" and isRead=0", new String[0]);
      if (localCursor != null)
      {
        if (localCursor.moveToFirst())
        {
          int i = localCursor.getInt(0);
          if (i > 0)
          {
            localb.Icz = true;
            localb.IcA = i;
          }
        }
        localCursor.close();
        if (localb.Icz)
        {
          Log.i("MicroMsg.GameMessageStorage", "unread logic costtime:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(275430);
          return localb;
        }
      }
      localCursor = rawQuery("select count(*) from GameRawMessage where rawXML like \"%<chatmsg%\"", new String[0]);
      if (localCursor == null)
      {
        AppMethodBeat.o(275430);
        return localb;
      }
      if ((localCursor.moveToFirst()) && (localCursor.getInt(0) > 0)) {
        localb.Icz = true;
      }
      localCursor.close();
      Log.i("MicroMsg.GameMessageStorage", "loop logic costtime:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.GameMessageStorage", "errMsg:%s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(275430);
    return localb;
  }
  
  public final o rG(long paramLong)
  {
    AppMethodBeat.i(41492);
    o localo = new o();
    localo.field_msgId = paramLong;
    if (get(localo, new String[0]))
    {
      AppMethodBeat.o(41492);
      return localo;
    }
    AppMethodBeat.o(41492);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.s
 * JD-Core Version:    0.7.0.1
 */