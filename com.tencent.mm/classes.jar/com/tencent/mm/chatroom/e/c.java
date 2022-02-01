package com.tencent.mm.chatroom.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements p
{
  public static final Pattern fLv;
  
  static
  {
    AppMethodBeat.i(182116);
    fLv = Pattern.compile("\\$\\{(.+)\\}");
    AppMethodBeat.o(182116);
  }
  
  private static CharSequence ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182114);
    g.ajD();
    am localam = ((l)g.ab(l.class)).azp().Bf(paramString2);
    if (!bt.isNullOrNil(localam.field_conRemark)) {}
    for (paramString2 = localam.field_conRemark;; paramString2 = af(paramString1, localam.field_username))
    {
      paramString1 = paramString2;
      if (bt.isNullOrNil(paramString2)) {
        paramString1 = localam.field_conRemark;
      }
      paramString2 = paramString1;
      if (bt.isNullOrNil(paramString1)) {
        paramString2 = localam.adu();
      }
      paramString1 = paramString2;
      if (bt.isNullOrNil(paramString2)) {
        paramString1 = localam.field_username;
      }
      paramString1 = k.c(aj.getContext(), paramString1);
      AppMethodBeat.o(182114);
      return paramString1;
    }
  }
  
  private static String af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182115);
    paramString1 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(182115);
      return null;
    }
    paramString1 = paramString1.zf(paramString2);
    AppMethodBeat.o(182115);
    return paramString1;
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(182113);
    ad.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { bt.bI(paramString, "") });
    Object localObject1;
    int j;
    String str1;
    String str2;
    String str3;
    String str4;
    long l2;
    boolean bool1;
    boolean bool2;
    int i;
    if (bt.nullAsNil(paramString).equals("roomtoolstips"))
    {
      if (!y.Yd())
      {
        AppMethodBeat.o(182113);
        return null;
      }
      if (paramMap != null)
      {
        try
        {
          if (!paramMap.containsKey(".sysmsg.todo.todoid")) {
            break label1995;
          }
          paramString = parama.gqE;
          parama = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.template")).trim();
          localObject1 = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.todoid")).trim();
          j = bt.getInt((String)paramMap.get(".sysmsg.todo.op"), 0);
          str1 = z.a(paramString.Fvi);
          str2 = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.scene"));
          str3 = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.creator"));
          str4 = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.oper"));
          Object localObject2 = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          long l1 = 1000L * bt.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L);
          l2 = bt.getLong((String)paramMap.get(".sysmsg.todo.related_msgid"), 0L);
          paramString = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(str1, (String)localObject1);
          Object localObject3;
          if (paramString != null)
          {
            bool1 = true;
            bool2 = y.e(paramString);
            localObject3 = bt.aRp(parama);
            if (paramString == null) {
              break label507;
            }
          }
          label507:
          for (i = paramString.field_state;; i = 0)
          {
            ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "scene:%s fromUser:%s todoId:%s appUsername:%s creator:%s operator:%s op:%s related_msgid:%s template:%s exist:%s state:%s", new Object[] { str2, str1, localObject1, localObject2, str3, str4, Integer.valueOf(j), Long.valueOf(l2), localObject3, Boolean.valueOf(bool1), Integer.valueOf(i) });
            if ((paramString == null) || (!paramString.Yo())) {
              break label513;
            }
            g.ajD();
            localObject2 = ((l)g.ab(l.class)).azp().Bf(str1);
            if ((localObject2 == null) || (((aw)localObject2).ePQ != 0L)) {
              break label513;
            }
            localObject2 = ((l)g.ab(l.class)).dlK().aI(str1, Long.parseLong(paramString.field_related_msgids));
            if ((bt.isNullOrNil(paramString.field_related_msgids)) || (!paramString.field_related_msgids.contains(((ei)localObject2).field_msgSvrId))) {
              break label513;
            }
            ad.w("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no handle clear roomCard");
            AppMethodBeat.o(182113);
            return null;
            bool1 = false;
            break;
          }
          label513:
          if ((!bt.lQ(str2, "altertodo_set")) || (paramString == null) || (!paramString.Yo()) || (l1 <= paramString.field_createtime)) {
            break label2018;
          }
          bool1 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(paramString);
          localObject2 = ((l)g.ab(l.class)).dlK().aI(str1, paramString.Yn());
          ((bu)localObject2).tZ("");
          ((l)g.ab(l.class)).dlK().a(((ei)localObject2).field_msgId, (bu)localObject2);
          ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "ORIGIN_USERNAME_CHAT_INFO delete result:%s", new Object[] { Boolean.valueOf(bool1) });
          localObject2 = new nb();
          ((nb)localObject2).dAZ.dBa = paramString.field_todoid;
          ((nb)localObject2).dAZ.dvs = str1;
          ((nb)localObject2).dAZ.op = 1;
          a.IbL.a((b)localObject2, Looper.getMainLooper());
          paramString = null;
          bool1 = false;
          bool2 = false;
          if ((!bt.lQ(str2, "sendtodo")) && (!bt.lQ(str2, "altertodo_set")) && (!bt.lQ(str2, "altertodo_revert")) && ((!bt.lQ(str2, "replytodo")) || (!bool1))) {
            break label1270;
          }
          if (paramString != null) {
            break label1197;
          }
          paramString = new com.tencent.mm.chatroom.storage.c();
          paramString.field_todoid = ((String)localObject1);
          paramString.field_roomname = str1;
          paramString.field_createtime = l1;
          paramString.field_updatetime = (bt.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
          paramString.field_username = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          paramString.field_path = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.path"));
          paramString.field_custominfo = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.custominfo"));
          paramString.field_title = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.title"));
          paramString.field_creator = str3;
          label882:
          paramString.field_manager = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.manager"));
          paramString.field_nreply = bt.getInt((String)paramMap.get(".sysmsg.todo.nreply"), 0);
          paramMap = new nb();
          if ((!bt.lQ(str2, "replytodo")) && ((j != 0) || (!bool1))) {
            break label1223;
          }
          paramMap.dAZ.op = 2;
          label958:
          paramMap.dAZ.dvs = str1;
          paramMap.dAZ.dBa = ((String)localObject1);
          if (j != 0) {
            break label1698;
          }
          if (paramString.field_state == 2) {
            paramString.field_state = 0;
          }
          if (!bool2) {
            break label1587;
          }
          paramString.qM(l2);
          bool2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(paramString);
          localObject2 = paramString.fMd.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Long)((Iterator)localObject2).next();
            bu localbu = ((l)g.ab(l.class)).dlK().aI(str1, ((Long)localObject3).longValue());
            if (!bt.lQ(localbu.fkD, paramString.field_todoid))
            {
              localbu.tZ((String)localObject1);
              ((l)g.ab(l.class)).dlK().a(localbu.field_msgId, localbu);
              ad.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { localObject3, Long.valueOf(localbu.field_msgId) });
            }
          }
          AppMethodBeat.o(182113);
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        }
        break label1270;
      }
    }
    label1190:
    label1197:
    label1223:
    label1235:
    label1270:
    label2040:
    for (;;)
    {
      return null;
      paramString.field_updatetime = (bt.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
      break label882;
      paramMap.dAZ.op = j;
      break label958;
      if (bool2) {
        a.IbL.a(paramMap, Looper.getMainLooper());
      }
      ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insertOrUpdateTodo result:%s", new Object[] { Boolean.valueOf(bool2) });
      if (!bt.isNullOrNil(parama))
      {
        j = 0;
        i = j;
        if (bt.lQ(str2, "altertodo_set"))
        {
          i = j;
          if (bt.lQ(str3, u.aAm()))
          {
            i = j;
            if (bt.lQ(str4, u.aAm())) {
              i = 1;
            }
          }
        }
        boolean bool3;
        if (!bt.lQ(str2, "replytodo"))
        {
          j = i;
          if (!bt.lQ(str2, "altertodo_revert")) {}
        }
        else
        {
          bool2 = bt.lQ(str3, u.aAm());
          bool3 = w.Ay(str1);
          j = i;
          if (!bt.lQ(str4, u.aAm()))
          {
            j = i;
            if (!bool2)
            {
              j = i;
              if (!bool3)
              {
                j = i;
                if (!bool1) {
                  j = 1;
                }
              }
            }
          }
        }
        paramString = ((l)g.ab(l.class)).dlK().aI(str1, l2);
        if ((paramString.eLr & 0x4) != 4) {
          if (paramString.getType() == 10000) {
            break label2036;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label2040;
          }
          if ((bt.lQ(str2, "altertodo_revert")) && (bt.lQ(str4, u.aAm()))) {
            paramString = aj.getContext().getString(2131757059);
          }
          for (;;)
          {
            paramMap = new bu();
            paramMap.kr(0);
            paramMap.tN(str1);
            paramMap.setStatus(3);
            paramMap.setContent(paramString);
            paramMap.qA(bj.B(str1, System.currentTimeMillis() / 1000L));
            paramMap.setType(10000);
            paramMap.setFlag(paramMap.field_flag | 0x8);
            ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insert template msgId:%s", new Object[] { Long.valueOf(bj.v(paramMap)) });
            break label1190;
            paramString.field_related_msgids = String.valueOf(l2);
            bool2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().f(paramString);
            paramString = ((l)g.ab(l.class)).dlK().aI(str1, l2);
            paramString.tZ((String)localObject1);
            ((l)g.ab(l.class)).dlK().a(paramString.field_msgId, paramString);
            ad.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(l2), Long.valueOf(paramString.field_msgId) });
            break label1235;
            if (!bool2) {
              break;
            }
            bool2 = y.c(paramString);
            ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "delete result:%s", new Object[] { Boolean.valueOf(bool2) });
            if (bool2) {
              a.IbL.a(paramMap, Looper.getMainLooper());
            }
            paramString = paramString.fMd.iterator();
            while (paramString.hasNext())
            {
              paramMap = (Long)paramString.next();
              localObject1 = ((l)g.ab(l.class)).dlK().aI(str1, paramMap.longValue());
              ((bu)localObject1).tZ("");
              ((l)g.ab(l.class)).dlK().a(((ei)localObject1).field_msgId, (bu)localObject1);
              ad.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { paramMap, Long.valueOf(((ei)localObject1).field_msgId) });
            }
            break label1270;
            if ((bt.lQ(str2, "replytodo")) && (bt.lQ(str4, u.aAm())))
            {
              if (bt.lQ(str3, u.aAm())) {
                paramString = aj.getContext().getString(2131757061);
              } else {
                paramString = aj.getContext().getString(2131757060, new Object[] { ae(str1, str3) });
              }
            }
            else
            {
              paramString = fLv.matcher(parama);
              if (paramString.find())
              {
                paramString = paramString.group(0);
                if ((!bt.isNullOrNil(paramString)) && (paramString.length() > 3))
                {
                  paramString = parama.replace(paramString, ae(str1, paramString.substring(2, paramString.length() - 1)));
                  continue;
                  ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no contains todoid");
                  break label1190;
                }
              }
              paramString = parama;
            }
          }
          i = j;
          continue;
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          break;
          break label1235;
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.c
 * JD-Core Version:    0.7.0.1
 */