package com.tencent.mm.model;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ca
{
  private ISQLiteDatabase db;
  private bv iFD;
  
  public ca(ISQLiteDatabase paramISQLiteDatabase, bv parambv)
  {
    this.db = paramISQLiteDatabase;
    this.iFD = parambv;
  }
  
  private static String a(String paramString, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    AppMethodBeat.i(20390);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" and (username in (");
    localStringBuffer.append("select chatroomname from chatroom where ");
    if ((paramArrayList2 != null) && (paramArrayList2.size() != 0))
    {
      paramArrayList2 = paramArrayList2.iterator();
      while (paramArrayList2.hasNext())
      {
        String str = (String)paramArrayList2.next();
        localStringBuffer.append("chatroomname != '" + str + "' and ");
      }
    }
    localStringBuffer.append("(memberlist like '%" + paramString + "%'");
    paramString = paramArrayList1.iterator();
    while (paramString.hasNext())
    {
      paramArrayList1 = (String)paramString.next();
      localStringBuffer.append(" or memberlist like '%" + paramArrayList1 + "%'");
    }
    if ((paramArrayList3 != null) && (paramArrayList3.size() != 0))
    {
      paramString = paramArrayList3.iterator();
      while (paramString.hasNext())
      {
        paramArrayList1 = (String)paramString.next();
        localStringBuffer.append(" or chatroomname = '" + paramArrayList1 + "'");
      }
    }
    localStringBuffer.append(")))");
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(20390);
    return paramString;
  }
  
  public final Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(20386);
    paramString1 = a(paramString1, paramString2, paramList1, true, 2, paramList2);
    AppMethodBeat.o(20386);
    return paramString1;
  }
  
  public final Cursor a(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(20385);
    paramString1 = a(paramString1, paramString2, paramList, paramBoolean, 1, null);
    AppMethodBeat.o(20385);
    return paramString1;
  }
  
  public final Cursor a(String paramString1, String paramString2, List<String> paramList1, boolean paramBoolean, int paramInt, List<String> paramList2)
  {
    AppMethodBeat.i(20388);
    Object localObject = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact ";
    if (paramInt == 2) {
      localObject = "select 2, *,rowid from rcontact ";
    }
    paramString2 = (String)localObject + this.iFD.f(paramString2, null, paramList1) + this.iFD.bjR(paramString1) + this.iFD.aZD();
    Log.v("Micro.SimpleSearchConversationModel", paramString2);
    paramString2 = this.db.rawQuery(paramString2, null);
    ArrayList localArrayList;
    if (paramBoolean)
    {
      localObject = new ArrayList();
      localArrayList = new ArrayList();
      while (paramString2.moveToNext())
      {
        String str = paramString2.getString(paramString2.getColumnIndex("username"));
        if (!ab.Eq(str)) {
          ((ArrayList)localObject).add(str);
        } else {
          localArrayList.add(str);
        }
      }
      if ((paramList2 != null) && (paramList2.size() != 0)) {
        ((ArrayList)localObject).addAll(paramList2);
      }
      if (((ArrayList)localObject).size() == 0) {}
    }
    for (paramString1 = new MergeCursor(new Cursor[] { paramString2, a(paramString1, (ArrayList)localObject, localArrayList, null, paramList1) });; paramString1 = paramString2)
    {
      AppMethodBeat.o(20388);
      return paramString1;
    }
  }
  
  public final Cursor a(String paramString, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, List<String> paramList)
  {
    AppMethodBeat.i(20389);
    paramString = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + this.iFD.f("@all.contact.android", "", paramList) + a(paramString, paramArrayList1, paramArrayList2, paramArrayList3) + this.iFD.aZD();
    Log.v("Micro.SimpleSearchConversationModel", "roomsSql ".concat(String.valueOf(paramString)));
    paramString = this.db.rawQuery(paramString, null);
    AppMethodBeat.o(20389);
    return paramString;
  }
  
  public final Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(20387);
    paramString1 = a(paramString1, paramString2, paramList1, true, 2, paramList2);
    AppMethodBeat.o(20387);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ca
 * JD-Core Version:    0.7.0.1
 */