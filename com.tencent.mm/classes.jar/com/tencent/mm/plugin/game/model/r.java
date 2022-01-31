package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.LinkedList;

public final class r
  extends j<n>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(111334);
    SQL_CREATE = new String[] { j.getCreateSQLs(n.info, "GameRawMessage") };
    AppMethodBeat.o(111334);
  }
  
  public r(e parame)
  {
    super(parame, n.info, "GameRawMessage", null);
  }
  
  public static String x(int... paramVarArgs)
  {
    AppMethodBeat.i(111333);
    String str = "" + "(";
    int i = 0;
    while (i < 5)
    {
      str = str + "msgType=" + paramVarArgs[i] + " or ";
      i += 1;
    }
    paramVarArgs = str + "msgType=" + paramVarArgs[5];
    paramVarArgs = paramVarArgs + ")";
    AppMethodBeat.o(111333);
    return paramVarArgs;
  }
  
  public final LinkedList<n> b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111328);
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
      AppMethodBeat.o(111328);
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
    AppMethodBeat.o(111328);
    return null;
    label187:
    if (((Cursor)localObject2).moveToFirst()) {
      do
      {
        localObject3 = new n();
        ((n)localObject3).convertFrom((Cursor)localObject2);
        ((LinkedList)localObject1).add(localObject3);
      } while (((Cursor)localObject2).moveToNext());
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(111328);
    return localObject1;
  }
  
  public final void bGv()
  {
    AppMethodBeat.i(111330);
    execSQL("GameRawMessage", "update GameRawMessage set isHidden = 0 where isHidden = 1");
    AppMethodBeat.o(111330);
  }
  
  public final void bGw()
  {
    AppMethodBeat.i(111331);
    String str = x(new int[] { 2, 5, 6, 10, 11, 100 });
    execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where isRead=0 and " + str + " and isHidden = 0");
    AppMethodBeat.o(111331);
  }
  
  public final int bGx()
  {
    int i = 0;
    AppMethodBeat.i(111332);
    Object localObject = x(new int[] { 2, 5, 6, 10, 11, 100 });
    localObject = rawQuery("select count(*) from GameRawMessage where " + (String)localObject + " and isRead=0 and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(111332);
      return 0;
    }
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(111332);
    return i;
  }
  
  public final boolean d(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(111329);
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
      AppMethodBeat.o(111329);
      return bool;
    }
    AppMethodBeat.o(111329);
    return false;
  }
  
  public final n kl(long paramLong)
  {
    AppMethodBeat.i(111327);
    n localn = new n();
    localn.field_msgId = paramLong;
    if (get(localn, new String[0]))
    {
      AppMethodBeat.o(111327);
      return localn;
    }
    AppMethodBeat.o(111327);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.r
 * JD-Core Version:    0.7.0.1
 */