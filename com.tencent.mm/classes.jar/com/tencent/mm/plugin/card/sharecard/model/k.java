package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class k
  extends j<ShareCardInfo>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(88083);
    SQL_CREATE = new String[] { j.getCreateSQLs(ShareCardInfo.info, "ShareCardInfo") };
    AppMethodBeat.o(88083);
  }
  
  public k(e parame)
  {
    super(parame, ShareCardInfo.info, "ShareCardInfo", null);
    this.db = parame;
  }
  
  public static String tb(int paramInt)
  {
    AppMethodBeat.i(88074);
    Object localObject = new StringBuilder();
    ArrayList localArrayList = b.sY(paramInt);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      ((StringBuilder)localObject).append(" (");
      paramInt = 0;
      while (paramInt < localArrayList.size())
      {
        if (paramInt != 0) {
          ((StringBuilder)localObject).append(" OR ");
        }
        ((StringBuilder)localObject).append("card_id").append(" = '" + (String)localArrayList.get(paramInt) + "' ");
        paramInt += 1;
      }
      ((StringBuilder)localObject).append(") AND ");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(88074);
      return localObject;
    }
    AppMethodBeat.o(88074);
    return "";
  }
  
  public final ArrayList<String> HV(String paramString)
  {
    AppMethodBeat.i(88075);
    ab.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), limit is 99");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" where ( status=0) ");
    ((StringBuilder)localObject).append(" AND (card_tp_id = '" + paramString + "' )");
    ((StringBuilder)localObject).append(" order by share_time desc ");
    ((StringBuilder)localObject).append(" limit 99");
    localObject = "select ShareCardInfo.from_username from ShareCardInfo" + ((StringBuilder)localObject).toString();
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), cursor == null");
      AppMethodBeat.o(88075);
      return null;
    }
    int i = ((Cursor)localObject).getColumnIndex("from_username");
    if (i == -1)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), index is wrong");
      ((Cursor)localObject).close();
      AppMethodBeat.o(88075);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if (((Cursor)localObject).moveToNext())
      {
        String str = ((Cursor)localObject).getString(i);
        if ((TextUtils.isEmpty(str)) || (localArrayList.contains(str))) {
          break label229;
        }
        localArrayList.add(str);
      }
      while (localArrayList.size() >= 99)
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(88075);
        return localArrayList;
        label229:
        ab.e("MicroMsg.ShareCardInfoStorage", "the field_from_username is empty or username is added!, the card id is ".concat(String.valueOf(paramString)));
      }
    }
  }
  
  public final int HW(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(88076);
    ab.i("MicroMsg.ShareCardInfoStorage", "getNormalCount()");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" where ( status=0) ");
    localStringBuilder.append(" AND (card_tp_id = '" + paramString + "' )");
    paramString = "select count(*) from ShareCardInfo" + localStringBuilder.toString();
    paramString = this.db.a(paramString, null, 2);
    if (paramString == null)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", "getNormalCount(), cursor == null");
      AppMethodBeat.o(88076);
      return 0;
    }
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(88076);
    return i;
  }
  
  public final String HX(String paramString)
  {
    AppMethodBeat.i(88077);
    ab.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId()");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" where ( status=0) ");
    ((StringBuilder)localObject).append(" AND (card_tp_id = '" + paramString + "' )");
    ((StringBuilder)localObject).append(" order by share_time desc ");
    ((StringBuilder)localObject).append(" limit 1");
    paramString = "select ShareCardInfo.card_id from ShareCardInfo" + ((StringBuilder)localObject).toString();
    localObject = this.db.a(paramString, null, 2);
    if (localObject == null)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), cursor == null");
      AppMethodBeat.o(88077);
      return "";
    }
    int i = ((Cursor)localObject).getColumnIndex("card_id");
    if (i == -1)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), index is wrong");
      ((Cursor)localObject).close();
      AppMethodBeat.o(88077);
      return "";
    }
    paramString = "";
    if (((Cursor)localObject).moveToFirst()) {
      paramString = ((Cursor)localObject).getString(i);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(88077);
    return paramString;
  }
  
  public final void HY(String paramString)
  {
    AppMethodBeat.i(88081);
    paramString = "delete from ShareCardInfo where card_id = '" + paramString + "'";
    this.db.execSQL("ShareCardInfo", paramString);
    AppMethodBeat.o(88081);
  }
  
  public final ShareCardInfo HZ(String paramString)
  {
    AppMethodBeat.i(88082);
    ShareCardInfo localShareCardInfo = new ShareCardInfo();
    localShareCardInfo.field_card_id = paramString;
    if (super.get(localShareCardInfo, new String[0]))
    {
      AppMethodBeat.o(88082);
      return localShareCardInfo;
    }
    AppMethodBeat.o(88082);
    return null;
  }
  
  public final boolean X(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88080);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" where ( status=0) ");
    localStringBuilder.append(" AND (card_tp_id = '" + paramString + "' )");
    paramString = "update ShareCardInfo set categoryType = '" + paramInt1 + "', itemIndex = '" + paramInt2 + "' " + localStringBuilder.toString();
    boolean bool = this.db.execSQL("ShareCardInfo", paramString);
    paramString = new StringBuilder("updateCategoryInfo updateRet is ");
    if (bool) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", paramInt1);
      AppMethodBeat.o(88080);
      return bool;
    }
  }
  
  public final String dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88078);
    ab.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId()");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" where ( status=0) ");
    ((StringBuilder)localObject).append(" AND (card_tp_id = '" + paramString2 + "' )");
    ((StringBuilder)localObject).append(" order by share_time desc ");
    ((StringBuilder)localObject).append(" limit 2");
    paramString2 = "select ShareCardInfo.card_id from ShareCardInfo" + ((StringBuilder)localObject).toString();
    Cursor localCursor = this.db.a(paramString2, null, 2);
    if (localCursor == null)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), cursor == null");
      AppMethodBeat.o(88078);
      return "";
    }
    int i = localCursor.getColumnIndex("card_id");
    if (i == -1)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), index is wrong");
      localCursor.close();
      AppMethodBeat.o(88078);
      return "";
    }
    paramString2 = "";
    while (localCursor.moveToNext())
    {
      localObject = localCursor.getString(i);
      paramString2 = (String)localObject;
      if (paramString1 != null)
      {
        paramString2 = (String)localObject;
        if (!paramString1.equals(localObject)) {
          paramString2 = (String)localObject;
        }
      }
    }
    localCursor.close();
    AppMethodBeat.o(88078);
    return paramString2;
  }
  
  public final boolean tc(int paramInt)
  {
    AppMethodBeat.i(88079);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" where ( status=0) ");
    ((StringBuilder)localObject).append(" AND (");
    ((StringBuilder)localObject).append("categoryType").append(" = '" + paramInt + "'");
    ((StringBuilder)localObject).append(")");
    localObject = "update ShareCardInfo set categoryType = '0' , itemIndex = '0' " + ((StringBuilder)localObject).toString();
    boolean bool = this.db.execSQL("ShareCardInfo", (String)localObject);
    localObject = new StringBuilder("resetCategoryInfo updateRet is ");
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", paramInt);
      AppMethodBeat.o(88079);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.k
 * JD-Core Version:    0.7.0.1
 */