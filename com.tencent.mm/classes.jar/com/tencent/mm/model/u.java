package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.ax.a.a;
import com.tencent.mm.ax.e;
import com.tencent.mm.ax.f;
import com.tencent.mm.ax.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class u
{
  public static boolean HZ(String paramString)
  {
    AppMethodBeat.i(184632);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184632);
      return false;
    }
    paramString = Util.stringsToList(paramString.split(","));
    if (paramString == null)
    {
      AppMethodBeat.o(184632);
      return false;
    }
    paramString = paramString.iterator();
    do
    {
      if (!paramString.hasNext()) {
        break;
      }
    } while (au.bwI((String)paramString.next()));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(184632);
      return bool;
    }
  }
  
  public static boolean Ia(String paramString)
  {
    AppMethodBeat.i(101740);
    if ((au.bwI(paramString)) || (au.bwO(paramString)))
    {
      AppMethodBeat.o(101740);
      return true;
    }
    AppMethodBeat.o(101740);
    return false;
  }
  
  public static void a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(101737);
    b(paramString1, paramList, paramString2, paramBoolean, paramString3);
    AppMethodBeat.o(101737);
  }
  
  private static void b(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(241870);
    cc localcc = new cc();
    localcc.BS(paramString1);
    localcc.setType(10000);
    localcc.setCreateTime(System.currentTimeMillis());
    localcc.setStatus(4);
    localcc.pI(2);
    paramString1 = new StringBuffer();
    if (paramList != null)
    {
      String str1 = z.bAM();
      String str2 = MMApplicationContext.getContext().getString(b.a.chatroom_sys_msg_invite_split);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str3 = (String)paramList.next();
        if (!str3.equals(str1))
        {
          au localau = ((n)h.ax(n.class)).bzA().JE(str3);
          if ((localau != null) && ((int)localau.maN != 0))
          {
            if (paramBoolean) {
              paramString1.append("<a href=\"" + paramString3 + str3 + "\">" + p(localau) + "</a>" + str2);
            } else {
              paramString1.append(p(localau) + str2);
            }
          }
          else if (paramBoolean) {
            paramString1.append("<a href=\"" + paramString3 + str3 + "\">" + str3 + "</a>" + str2);
          } else {
            paramString1.append(str3 + str2);
          }
        }
      }
      if (paramString1.length() > 0) {
        paramString1.deleteCharAt(paramString1.lastIndexOf(str2));
      }
    }
    localcc.setContent(paramString2.replace("%s", paramString1));
    ((n)h.ax(n.class)).gaZ().ba(localcc);
    AppMethodBeat.o(241870);
  }
  
  public static List<Boolean> bR(List<String> paramList)
  {
    AppMethodBeat.i(101736);
    if (paramList == null)
    {
      AppMethodBeat.o(101736);
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    String str;
    boolean bool2;
    long l2;
    long l1;
    while (paramList.hasNext())
    {
      str = (String)paramList.next();
      if (!au.bwE(str))
      {
        bool1 = false;
        localArrayList.add(Boolean.valueOf(bool1));
      }
      else
      {
        bool2 = false;
        boolean bool3 = false;
        long l3 = 0L;
        Object localObject = ((n)h.ax(n.class)).bzG().bxM(str);
        l2 = l3;
        if (localObject != null)
        {
          l1 = l3;
          bool1 = bool3;
          if (((bd)localObject).field_lastSeq != 0L)
          {
            cc localcc = ((n)h.ax(n.class)).gaZ().aV(str, ((bd)localObject).field_lastSeq);
            if (localcc != null)
            {
              l1 = l3;
              bool1 = bool3;
              if (localcc.field_msgId != 0L) {}
            }
            else
            {
              l1 = ((bd)localObject).field_lastSeq;
              bool1 = true;
            }
          }
          l2 = l1;
          bool2 = bool1;
          if (((bd)localObject).field_firstUnDeliverSeq != 0L)
          {
            ((bb)localObject).gU(0L);
            ((bb)localObject).gT(0L);
            ((n)h.ax(n.class)).bzG().c((bb)localObject, str);
            Log.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            bool2 = bool1;
            l2 = l1;
          }
        }
        if (bool2) {
          break label408;
        }
        localObject = ((n)h.ax(n.class)).gaZ().aMb(str);
        if ((localObject == null) || (((fi)localObject).field_msgId == 0L)) {
          break label408;
        }
      }
    }
    label408:
    for (boolean bool1 = true;; bool1 = bool2)
    {
      l1 = l2;
      if (l2 == 0L) {
        l1 = ((n)h.ax(n.class)).gaZ().aMa(str);
      }
      if (l1 != 0L) {
        ((n)h.ax(n.class)).bAd().aR(str, l1);
      }
      Log.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", new Object[] { str, Boolean.valueOf(bool1), Long.valueOf(l1) });
      break;
      AppMethodBeat.o(101736);
      return localArrayList;
    }
  }
  
  private static String p(au paramau)
  {
    AppMethodBeat.i(101739);
    if (com.tencent.mm.openim.room.a.a.W(paramau))
    {
      String str = com.tencent.mm.openim.room.a.a.X(paramau);
      if (str != null)
      {
        paramau = paramau.aSV() + str;
        AppMethodBeat.o(101739);
        return paramau;
      }
      paramau = paramau.aSV();
      AppMethodBeat.o(101739);
      return paramau;
    }
    paramau = paramau.aSV();
    AppMethodBeat.o(101739);
    return paramau;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.u
 * JD-Core Version:    0.7.0.1
 */