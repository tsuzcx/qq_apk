package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;

public final class s
  extends i<o>
{
  public static final String[] dXp = { i.a(o.buS, "GameRawMessage") };
  
  public s(e parame)
  {
    super(parame, o.buS, "GameRawMessage", null);
  }
  
  public static String n(int... paramVarArgs)
  {
    String str = "" + "(";
    int i = 0;
    while (i < 5)
    {
      str = str + "msgType=" + paramVarArgs[i] + " or ";
      i += 1;
    }
    paramVarArgs = str + "msgType=" + paramVarArgs[5];
    return paramVarArgs + ")";
  }
  
  public final void aZt()
  {
    gk("GameRawMessage", "update GameRawMessage set isHidden = 0 where isHidden = 1");
  }
  
  public final void aZu()
  {
    String str = n(new int[] { 2, 5, 6, 10, 11, 100 });
    gk("GameRawMessage", "update GameRawMessage set isRead=1 where isRead=0 and " + str + " and isHidden = 0");
  }
  
  public final int aZv()
  {
    int i = 0;
    Object localObject = n(new int[] { 2, 5, 6, 10, 11, 100 });
    localObject = rawQuery("select count(*) from GameRawMessage where " + (String)localObject + " and isRead=0 and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (localObject == null) {
      return 0;
    }
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    return i;
  }
  
  public final LinkedList<o> b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject2;
    Object localObject1;
    if (paramLong == 0L)
    {
      localObject2 = "9223372036854775807";
      if (paramInt2 != 0) {
        break label144;
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
        break label172;
      }
      return localObject1;
      localObject2 = String.valueOf(paramLong);
      break;
      label144:
      if (paramInt2 == 1)
      {
        localObject1 = "isRead=0 ";
      }
      else
      {
        if (paramInt2 != 2) {
          break label170;
        }
        localObject1 = "isRead=1 ";
      }
    }
    label170:
    return null;
    label172:
    if (((Cursor)localObject2).moveToFirst()) {
      do
      {
        localObject3 = new o();
        ((o)localObject3).d((Cursor)localObject2);
        ((LinkedList)localObject1).add(localObject3);
      } while (((Cursor)localObject2).moveToNext());
    }
    ((Cursor)localObject2).close();
    return localObject1;
  }
  
  public final o eP(long paramLong)
  {
    o localo = new o();
    localo.field_msgId = paramLong;
    if (b(localo, new String[0])) {
      return localo;
    }
    return null;
  }
  
  public final boolean f(long[] paramArrayOfLong)
  {
    boolean bool = false;
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
      bool = gk("GameRawMessage", String.format("update GameRawMessage set isRead=1 where %s", new Object[] { localStringBuilder.toString() }));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.s
 * JD-Core Version:    0.7.0.1
 */