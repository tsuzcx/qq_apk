package com.tencent.mm.chatroom.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements p
{
  public static final Pattern gsK;
  
  static
  {
    AppMethodBeat.i(182116);
    gsK = Pattern.compile("\\$\\{(.+)\\}");
    AppMethodBeat.o(182116);
  }
  
  private static CharSequence ag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182114);
    g.aAi();
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString2);
    if (!Util.isNullOrNil(localas.field_conRemark)) {}
    for (paramString2 = localas.field_conRemark;; paramString2 = ah(paramString1, localas.field_username))
    {
      paramString1 = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        paramString1 = localas.field_conRemark;
      }
      paramString2 = paramString1;
      if (Util.isNullOrNil(paramString1)) {
        paramString2 = localas.arI();
      }
      paramString1 = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        paramString1 = localas.field_username;
      }
      paramString1 = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), paramString1);
      AppMethodBeat.o(182114);
      return paramString1;
    }
  }
  
  private static String ah(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182115);
    paramString1 = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(182115);
      return null;
    }
    paramString1 = paramString1.getDisplayName(paramString2);
    AppMethodBeat.o(182115);
    return paramString1;
  }
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(182113);
    Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { Util.nullAs(paramString, "") });
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
    if (Util.nullAsNil(paramString).equals("roomtoolstips"))
    {
      if (!y.ama())
      {
        AppMethodBeat.o(182113);
        return null;
      }
      if (paramMap != null)
      {
        try
        {
          if (!paramMap.containsKey(".sysmsg.todo.todoid")) {
            break label2051;
          }
          paramString = parama.heO;
          parama = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.template")).trim();
          localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.todoid")).trim();
          j = Util.getInt((String)paramMap.get(".sysmsg.todo.op"), 0);
          str1 = com.tencent.mm.platformtools.z.a(paramString.KHl);
          str2 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.scene"));
          str3 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.creator"));
          str4 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.oper"));
          Object localObject4 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          long l1 = 1000L * Util.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L);
          l2 = Util.getLong((String)paramMap.get(".sysmsg.todo.related_msgid"), 0L);
          Object localObject2 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.sharekey"));
          Object localObject3 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.sharename"));
          paramString = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(str1, (String)localObject1);
          String str5;
          if (paramString != null)
          {
            bool1 = true;
            bool2 = y.e(paramString);
            str5 = Util.secPrint(parama);
            if (paramString == null) {
              break label551;
            }
          }
          label551:
          for (i = paramString.field_state;; i = 0)
          {
            Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "scene:%s fromUser:%s todoId:%s appUsername:%s creator:%s operator:%s op:%s related_msgid:%s template:%s exist:%s state:%s shareKey:%s shareName:%s", new Object[] { str2, str1, localObject1, localObject4, str3, str4, Integer.valueOf(j), Long.valueOf(l2), str5, Boolean.valueOf(bool1), Integer.valueOf(i), localObject2, localObject3 });
            if ((paramString == null) || (!paramString.aml())) {
              break label557;
            }
            g.aAi();
            localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str1);
            if ((localObject4 == null) || (((ax)localObject4).fve != 0L)) {
              break label557;
            }
            localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(str1, Long.parseLong(paramString.field_related_msgids));
            if ((Util.isNullOrNil(paramString.field_related_msgids)) || (!paramString.field_related_msgids.contains(((eo)localObject4).field_msgSvrId))) {
              break label557;
            }
            Log.w("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no handle clear roomCard");
            AppMethodBeat.o(182113);
            return null;
            bool1 = false;
            break;
          }
          label557:
          if ((!Util.isEqual(str2, "altertodo_set")) || (paramString == null) || (!paramString.aml()) || (l1 <= paramString.field_createtime)) {
            break label2074;
          }
          bool1 = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().h(paramString);
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(str1, paramString.amk());
          ((ca)localObject4).CK("");
          ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(((eo)localObject4).field_msgId, (ca)localObject4);
          Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "ORIGIN_USERNAME_CHAT_INFO delete result:%s", new Object[] { Boolean.valueOf(bool1) });
          localObject4 = new nt();
          ((nt)localObject4).dTT.dTU = paramString.field_todoid;
          ((nt)localObject4).dTT.dOe = str1;
          ((nt)localObject4).dTT.op = 1;
          EventCenter.instance.asyncPublish((IEvent)localObject4, Looper.getMainLooper());
          paramString = null;
          bool1 = false;
          bool2 = false;
          if ((!Util.isEqual(str2, "sendtodo")) && (!Util.isEqual(str2, "altertodo_set")) && (!Util.isEqual(str2, "altertodo_revert")) && ((!Util.isEqual(str2, "replytodo")) || (!bool1))) {
            break label1326;
          }
          if (paramString != null) {
            break label1253;
          }
          paramString = new com.tencent.mm.chatroom.storage.c();
          paramString.field_todoid = ((String)localObject1);
          paramString.field_roomname = str1;
          paramString.field_createtime = l1;
          paramString.field_updatetime = (Util.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
          paramString.field_username = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          paramString.field_path = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.path"));
          paramString.field_custominfo = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.custominfo"));
          paramString.field_title = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.title"));
          paramString.field_creator = str3;
          paramString.field_shareKey = ((String)localObject2);
          paramString.field_shareName = ((String)localObject3);
          label938:
          paramString.field_manager = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.manager"));
          paramString.field_nreply = Util.getInt((String)paramMap.get(".sysmsg.todo.nreply"), 0);
          paramMap = new nt();
          if ((!Util.isEqual(str2, "replytodo")) && ((j != 0) || (!bool1))) {
            break label1279;
          }
          paramMap.dTT.op = 2;
          label1014:
          paramMap.dTT.dOe = str1;
          paramMap.dTT.dTU = ((String)localObject1);
          if (j != 0) {
            break label1754;
          }
          if (paramString.field_state == 2) {
            paramString.field_state = 0;
          }
          if (!bool2) {
            break label1643;
          }
          paramString.yR(l2);
          bool2 = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().g(paramString);
          localObject2 = paramString.gts.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Long)((Iterator)localObject2).next();
            localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(str1, ((Long)localObject3).longValue());
            if (!Util.isEqual(((eo)localObject4).fRe, paramString.field_todoid))
            {
              ((ca)localObject4).CK((String)localObject1);
              ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(((eo)localObject4).field_msgId, (ca)localObject4);
              Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { localObject3, Long.valueOf(((eo)localObject4).field_msgId) });
            }
          }
          AppMethodBeat.o(182113);
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        }
        break label1326;
      }
    }
    label1291:
    label1326:
    label2096:
    for (;;)
    {
      label1246:
      return null;
      label1253:
      paramString.field_updatetime = (Util.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
      break label938;
      label1279:
      paramMap.dTT.op = j;
      break label1014;
      if (bool2) {
        EventCenter.instance.asyncPublish(paramMap, Looper.getMainLooper());
      }
      Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insertOrUpdateTodo result:%s", new Object[] { Boolean.valueOf(bool2) });
      if (!Util.isNullOrNil(parama))
      {
        j = 0;
        i = j;
        if (Util.isEqual(str2, "altertodo_set"))
        {
          i = j;
          if (Util.isEqual(str3, com.tencent.mm.model.z.aTY()))
          {
            i = j;
            if (Util.isEqual(str4, com.tencent.mm.model.z.aTY())) {
              i = 1;
            }
          }
        }
        boolean bool3;
        if (!Util.isEqual(str2, "replytodo"))
        {
          j = i;
          if (!Util.isEqual(str2, "altertodo_revert")) {}
        }
        else
        {
          bool2 = Util.isEqual(str3, com.tencent.mm.model.z.aTY());
          bool3 = ab.JN(str1);
          j = i;
          if (!Util.isEqual(str4, com.tencent.mm.model.z.aTY()))
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
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(str1, l2);
        if ((paramString.fqJ & 0x4) != 4) {
          if (paramString.getType() == 10000) {
            break label2092;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label2096;
          }
          if ((Util.isEqual(str2, "altertodo_revert")) && (Util.isEqual(str4, com.tencent.mm.model.z.aTY()))) {
            paramString = MMApplicationContext.getContext().getString(2131757256);
          }
          for (;;)
          {
            paramMap = new ca();
            paramMap.nv(0);
            paramMap.Cy(str1);
            paramMap.setStatus(3);
            paramMap.setContent(paramString);
            paramMap.setCreateTime(bp.C(str1, System.currentTimeMillis() / 1000L));
            paramMap.setType(10000);
            paramMap.setFlag(paramMap.field_flag | 0x8);
            Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insert template msgId:%s", new Object[] { Long.valueOf(bp.x(paramMap)) });
            break label1246;
            label1643:
            paramString.field_related_msgids = String.valueOf(l2);
            bool2 = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().f(paramString);
            paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(str1, l2);
            paramString.CK((String)localObject1);
            ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(paramString.field_msgId, paramString);
            Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(l2), Long.valueOf(paramString.field_msgId) });
            break label1291;
            label1754:
            if (!bool2) {
              break;
            }
            bool2 = y.c(paramString);
            Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "delete result:%s", new Object[] { Boolean.valueOf(bool2) });
            if (bool2) {
              EventCenter.instance.asyncPublish(paramMap, Looper.getMainLooper());
            }
            paramString = paramString.gts.iterator();
            while (paramString.hasNext())
            {
              paramMap = (Long)paramString.next();
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(str1, paramMap.longValue());
              ((ca)localObject1).CK("");
              ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(((eo)localObject1).field_msgId, (ca)localObject1);
              Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { paramMap, Long.valueOf(((eo)localObject1).field_msgId) });
            }
            break label1326;
            if ((Util.isEqual(str2, "replytodo")) && (Util.isEqual(str4, com.tencent.mm.model.z.aTY())))
            {
              if (Util.isEqual(str3, com.tencent.mm.model.z.aTY())) {
                paramString = MMApplicationContext.getContext().getString(2131757258);
              } else {
                paramString = MMApplicationContext.getContext().getString(2131757257, new Object[] { ag(str1, str3) });
              }
            }
            else
            {
              paramString = gsK.matcher(parama);
              if (paramString.find())
              {
                paramString = paramString.group(0);
                if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 3))
                {
                  paramString = parama.replace(paramString, ag(str1, paramString.substring(2, paramString.length() - 1)));
                  continue;
                  Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no contains todoid");
                  break label1246;
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
          break label1291;
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.c
 * JD-Core Version:    0.7.0.1
 */