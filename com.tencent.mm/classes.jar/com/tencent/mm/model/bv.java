package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.o.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bv
{
  private e db;
  private bq hHY;
  
  public bv(e parame, bq parambq)
  {
    this.db = parame;
    this.hHY = parambq;
  }
  
  private String Bx(String paramString)
  {
    AppMethodBeat.i(20392);
    Object localObject1 = new ArrayList();
    String str = "select username from rcontact where (username like '%" + paramString + "%' or nickname like '%" + paramString + "%' or alias like '%" + paramString + "%' or pyInitial like '%" + paramString + "%' or quanPin like '%" + paramString + "%' or conRemark like '%" + paramString + "%' )and username not like '%@%' and type & " + b.adg() + "=0 ";
    Object localObject2 = this.db.a(str, null, 2);
    ad.v("Micro.SimpleSearchConversationModel", "contactsql %s", new Object[] { str });
    while (((Cursor)localObject2).moveToNext())
    {
      str = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("username"));
      if (!str.endsWith("@chatroom")) {
        ((ArrayList)localObject1).add(str);
      }
    }
    ((Cursor)localObject2).close();
    if (((ArrayList)localObject1).size() != 0)
    {
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(" ( rconversation.username in ( select chatroomname from chatroom where ");
      ((StringBuffer)localObject2).append("memberlist like '%" + paramString + "%'");
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        ((StringBuffer)localObject2).append(" or memberlist like '%" + str + "%'");
      }
      ((StringBuffer)localObject2).append("))");
    }
    for (localObject1 = "" + ((StringBuffer)localObject2).toString() + " or ";; localObject1 = "")
    {
      paramString = " and ( rconversation.username like '%" + paramString + "%' or " + (String)localObject1 + "rconversation.content like '%" + paramString + "%' or rcontact.nickname like '%" + paramString + "%' or rcontact.alias like '%" + paramString + "%' or rcontact.pyInitial like '%" + paramString + "%' or rcontact.quanPin like '%" + paramString + "%' or rcontact.conRemark like '%" + paramString + "%'  ) ";
      AppMethodBeat.o(20392);
      return paramString;
    }
  }
  
  public final Cursor a(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(20391);
    String str2 = " ";
    String str1 = str2;
    if (paramString2 != null)
    {
      str1 = str2;
      if (paramString2.length() > 0) {
        str1 = " and rconversation.username = rcontact.username ";
      }
    }
    str2 = "select 1,unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rcontact.nickname from rconversation," + "rcontact" + " " + " where rconversation.username = rcontact.username" + str1 + bt.nullAsNil(paramString1);
    str1 = "";
    paramString1 = str1;
    if (paramList != null)
    {
      paramString1 = str1;
      if (paramList.size() > 0)
      {
        paramList = paramList.iterator();
        for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + " and rconversation.username != '" + str1 + "'") {
          str1 = (String)paramList.next();
        }
      }
    }
    paramList = str2 + paramString1;
    paramString1 = paramList;
    if (paramString2 != null)
    {
      paramString1 = paramList;
      if (paramString2.length() > 0) {
        paramString1 = paramList + Bx(paramString2);
      }
    }
    paramString1 = paramString1 + " order by ";
    paramString1 = paramString1 + "rconversation.username like '%@chatroom' asc, ";
    paramString1 = paramString1 + "flag desc, conversationTime desc";
    ad.v("Micro.SimpleSearchConversationModel", "convsql %s", new Object[] { paramString1 });
    paramString1 = this.db.rawQuery(paramString1, null);
    AppMethodBeat.o(20391);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bv
 * JD-Core Version:    0.7.0.1
 */