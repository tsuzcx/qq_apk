package com.tencent.mm.chatroom.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
  implements o
{
  public static final Pattern fpt;
  
  static
  {
    AppMethodBeat.i(182116);
    fpt = Pattern.compile("\\$\\{(.+)\\}");
    AppMethodBeat.o(182116);
  }
  
  private static CharSequence aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182114);
    g.afC();
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString2);
    if (!bt.isNullOrNil(localaf.field_conRemark)) {}
    for (paramString2 = localaf.field_conRemark;; paramString2 = ab(paramString1, localaf.field_username))
    {
      paramString1 = paramString2;
      if (bt.isNullOrNil(paramString2)) {
        paramString1 = localaf.field_conRemark;
      }
      paramString2 = paramString1;
      if (bt.isNullOrNil(paramString1)) {
        paramString2 = localaf.ZW();
      }
      paramString1 = paramString2;
      if (bt.isNullOrNil(paramString2)) {
        paramString1 = localaf.field_username;
      }
      paramString1 = com.tencent.mm.pluginsdk.ui.span.k.c(com.tencent.mm.sdk.platformtools.aj.getContext(), paramString1);
      AppMethodBeat.o(182114);
      return paramString1;
    }
  }
  
  private static String ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182115);
    paramString1 = ((c)g.ab(c.class)).apV().tH(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(182115);
      return null;
    }
    paramString1 = paramString1.sh(paramString2);
    AppMethodBeat.o(182115);
    return paramString1;
  }
  
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(182113);
    ad.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { bt.by(paramString, "") });
    Object localObject1;
    int j;
    String str1;
    String str2;
    String str3;
    String str4;
    Object localObject2;
    long l2;
    boolean bool1;
    boolean bool3;
    Object localObject3;
    int i;
    label283:
    boolean bool2;
    if (bt.nullAsNil(paramString).equals("roomtoolstips"))
    {
      if (!y.UQ())
      {
        AppMethodBeat.o(182113);
        return null;
      }
      if (paramMap != null)
      {
        try
        {
          if (!paramMap.containsKey(".sysmsg.todo.todoid")) {
            break label1975;
          }
          paramString = parama.fTo;
          parama = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.template")).trim();
          localObject1 = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.todoid")).trim();
          j = bt.getInt((String)paramMap.get(".sysmsg.todo.op"), 0);
          str1 = z.a(paramString.Cxx);
          str2 = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.scene"));
          str3 = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.creator"));
          str4 = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.oper"));
          localObject2 = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          long l1 = 1000L * bt.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L);
          l2 = bt.getLong((String)paramMap.get(".sysmsg.todo.related_msgid"), 0L);
          paramString = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ac(str1, (String)localObject1);
          if (paramString == null) {
            break label967;
          }
          bool1 = true;
          bool3 = y.e(paramString);
          localObject3 = bt.aGs(parama);
          if (paramString == null) {
            break label973;
          }
          i = paramString.field_state;
          ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "scene:%s fromUser:%s todoId:%s appUsername:%s creator:%s operator:%s op:%s related_msgid:%s template:%s exist:%s state:%s", new Object[] { str2, str1, localObject1, localObject2, str3, str4, Integer.valueOf(j), Long.valueOf(l2), localObject3, Boolean.valueOf(bool1), Integer.valueOf(i) });
          if ((!bt.kU(str2, "altertodo_set")) || (paramString == null) || (!paramString.UY()) || (l1 <= paramString.field_createtime)) {
            break label1998;
          }
          bool1 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(paramString);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(str1, paramString.UX());
          ((bl)localObject2).oh("");
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(((du)localObject2).field_msgId, (bl)localObject2);
          ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "ORIGIN_USERNAME_CHAT_INFO delete result:%s", new Object[] { Boolean.valueOf(bool1) });
          localObject2 = new mk();
          ((mk)localObject2).drB.drC = paramString.field_todoid;
          ((mk)localObject2).drB.dlX = str1;
          ((mk)localObject2).drB.op = 1;
          com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
          paramString = null;
          bool2 = false;
          bool1 = false;
          if ((!bt.kU(str2, "sendtodo")) && (!bt.kU(str2, "altertodo_set")) && (!bt.kU(str2, "altertodo_revert")) && ((!bt.kU(str2, "replytodo")) || (!bool1))) {
            break label1239;
          }
          if (paramString != null) {
            break label979;
          }
          paramString = new com.tencent.mm.chatroom.storage.a();
          paramString.field_todoid = ((String)localObject1);
          paramString.field_roomname = str1;
          paramString.field_createtime = l1;
          paramString.field_updatetime = (bt.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
          paramString.field_username = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          paramString.field_path = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.path"));
          paramString.field_custominfo = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.custominfo"));
          paramString.field_title = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.title"));
          paramString.field_creator = str3;
          label736:
          paramString.field_manager = bt.nullAsNil((String)paramMap.get(".sysmsg.todo.manager"));
          paramString.field_nreply = bt.getInt((String)paramMap.get(".sysmsg.todo.nreply"), 0);
          paramMap = new mk();
          if ((!bt.kU(str2, "replytodo")) && ((j != 0) || (!bool1))) {
            break label1005;
          }
          paramMap.drB.op = 2;
          label812:
          paramMap.drB.dlX = str1;
          paramMap.drB.drC = ((String)localObject1);
          if (j != 0) {
            break label1667;
          }
          if (!bool2) {
            break label1556;
          }
          if (paramString.fpJ.contains(Long.valueOf(l2))) {
            break label1049;
          }
          paramString.fpJ.add(Long.valueOf(l2));
          localObject2 = new StringBuilder();
          localObject3 = paramString.fpJ.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((StringBuilder)localObject2).append(((Long)((Iterator)localObject3).next()).longValue()).append(",");
          }
          AppMethodBeat.o(182113);
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        }
        break label1239;
      }
    }
    label960:
    label967:
    label973:
    label979:
    label1239:
    label2012:
    label2016:
    for (;;)
    {
      return null;
      bool1 = false;
      break;
      i = 0;
      break label283;
      paramString.field_updatetime = (bt.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
      break label736;
      label1005:
      paramMap.drB.op = j;
      break label812;
      if (((StringBuilder)localObject2).length() - 1 >= 0) {
        ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
      }
      paramString.field_related_msgids = ((StringBuilder)localObject2).toString();
      bool2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(paramString);
      localObject2 = paramString.fpJ.iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(str1, ((Long)localObject3).longValue());
          if (!bt.kU(localbl.ePg, paramString.field_todoid))
          {
            localbl.oh((String)localObject1);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(localbl.field_msgId, localbl);
            ad.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { localObject3, Long.valueOf(localbl.field_msgId) });
            continue;
            if (bool2) {
              com.tencent.mm.sdk.b.a.ESL.a(paramMap, Looper.getMainLooper());
            }
            ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insertOrUpdateTodo result:%s", new Object[] { Boolean.valueOf(bool2) });
            if (bt.isNullOrNil(parama)) {
              break;
            }
            j = 0;
            i = j;
            if (bt.kU(str2, "altertodo_set"))
            {
              i = j;
              if (bt.kU(str3, u.aqG()))
              {
                i = j;
                if (bt.kU(str4, u.aqG())) {
                  i = 1;
                }
              }
            }
            if (!bt.kU(str2, "replytodo"))
            {
              j = i;
              if (!bt.kU(str2, "altertodo_revert")) {}
            }
            else
            {
              bool2 = bt.kU(str3, u.aqG());
              bool3 = com.tencent.mm.model.w.tx(str1);
              j = i;
              if (!bt.kU(str4, u.aqG()))
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
            paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(str1, l2);
            if ((paramString.esg & 0x4) == 4) {
              break label2012;
            }
            if (paramString.getType() == 10000) {
              break label2012;
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label2016;
        }
        if ((bt.kU(str2, "altertodo_revert")) && (bt.kU(str4, u.aqG()))) {
          paramString = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131757059);
        }
        for (;;)
        {
          paramMap = new bl();
          paramMap.jV(0);
          paramMap.nY(str1);
          paramMap.setStatus(3);
          paramMap.setContent(paramString);
          paramMap.kY(bi.y(str1, System.currentTimeMillis() / 1000L));
          paramMap.setType(10000);
          paramMap.setFlag(paramMap.field_flag | 0x8);
          ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insert template msgId:%s", new Object[] { Long.valueOf(bi.u(paramMap)) });
          break label960;
          paramString.field_related_msgids = String.valueOf(l2);
          bool2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().f(paramString);
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(str1, l2);
          paramString.oh((String)localObject1);
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramString.field_msgId, paramString);
          ad.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(l2), Long.valueOf(paramString.field_msgId) });
          break label1204;
          if (!bool2) {
            break;
          }
          bool2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(paramString);
          ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "delete result:%s", new Object[] { Boolean.valueOf(bool2) });
          if (bool2) {
            com.tencent.mm.sdk.b.a.ESL.a(paramMap, Looper.getMainLooper());
          }
          paramString = paramString.fpJ.iterator();
          while (paramString.hasNext())
          {
            paramMap = (Long)paramString.next();
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(str1, paramMap.longValue());
            ((bl)localObject1).oh("");
            ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(((du)localObject1).field_msgId, (bl)localObject1);
            ad.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { paramMap, Long.valueOf(((du)localObject1).field_msgId) });
          }
          break label1239;
          if ((bt.kU(str2, "replytodo")) && (bt.kU(str4, u.aqG())))
          {
            if (bt.kU(str3, u.aqG())) {
              paramString = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131757061);
            } else {
              paramString = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131757060, new Object[] { aa(str1, str3) });
            }
          }
          else
          {
            paramString = fpt.matcher(parama);
            if (paramString.find())
            {
              paramString = paramString.group(0);
              if ((!bt.isNullOrNil(paramString)) && (paramString.length() > 3))
              {
                paramString = parama.replace(paramString, aa(str1, paramString.substring(2, paramString.length() - 1)));
                continue;
                ad.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no contains todoid");
                break label960;
              }
            }
            paramString = parama;
          }
        }
        i = j;
        continue;
        bool2 = bool1;
        bool1 = bool3;
        break;
        break label1204;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.b
 * JD-Core Version:    0.7.0.1
 */