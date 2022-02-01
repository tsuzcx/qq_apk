package com.tencent.mm.chatroom.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements o
{
  public static final Pattern fsV;
  
  static
  {
    AppMethodBeat.i(182116);
    fsV = Pattern.compile("\\$\\{(.+)\\}");
    AppMethodBeat.o(182116);
  }
  
  private static CharSequence ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182114);
    g.agS();
    com.tencent.mm.storage.ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString2);
    if (!bs.isNullOrNil(localai.field_conRemark)) {}
    for (paramString2 = localai.field_conRemark;; paramString2 = ae(paramString1, localai.field_username))
    {
      paramString1 = paramString2;
      if (bs.isNullOrNil(paramString2)) {
        paramString1 = localai.field_conRemark;
      }
      paramString2 = paramString1;
      if (bs.isNullOrNil(paramString1)) {
        paramString2 = localai.aaR();
      }
      paramString1 = paramString2;
      if (bs.isNullOrNil(paramString2)) {
        paramString1 = localai.field_username;
      }
      paramString1 = com.tencent.mm.pluginsdk.ui.span.k.c(com.tencent.mm.sdk.platformtools.ai.getContext(), paramString1);
      AppMethodBeat.o(182114);
      return paramString1;
    }
  }
  
  private static String ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182115);
    paramString1 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(182115);
      return null;
    }
    paramString1 = paramString1.wk(paramString2);
    AppMethodBeat.o(182115);
    return paramString1;
  }
  
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(182113);
    ac.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { bs.bG(paramString, "") });
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
    if (bs.nullAsNil(paramString).equals("roomtoolstips"))
    {
      if (!y.VM())
      {
        AppMethodBeat.o(182113);
        return null;
      }
      if (paramMap != null)
      {
        try
        {
          if (!paramMap.containsKey(".sysmsg.todo.todoid")) {
            break label1982;
          }
          paramString = parama.fXi;
          parama = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.template")).trim();
          localObject1 = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.todoid")).trim();
          j = bs.getInt((String)paramMap.get(".sysmsg.todo.op"), 0);
          str1 = z.a(paramString.DPT);
          str2 = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.scene"));
          str3 = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.creator"));
          str4 = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.oper"));
          Object localObject2 = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          long l1 = 1000L * bs.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L);
          l2 = bs.getLong((String)paramMap.get(".sysmsg.todo.related_msgid"), 0L);
          paramString = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().af(str1, (String)localObject1);
          Object localObject3;
          if (paramString != null)
          {
            bool1 = true;
            bool2 = y.e(paramString);
            localObject3 = bs.aLJ(parama);
            if (paramString == null) {
              break label507;
            }
          }
          label507:
          for (i = paramString.field_state;; i = 0)
          {
            ac.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "scene:%s fromUser:%s todoId:%s appUsername:%s creator:%s operator:%s op:%s related_msgid:%s template:%s exist:%s state:%s", new Object[] { str2, str1, localObject1, localObject2, str3, str4, Integer.valueOf(j), Long.valueOf(l2), localObject3, Boolean.valueOf(bool1), Integer.valueOf(i) });
            if ((paramString == null) || (!paramString.VU())) {
              break label513;
            }
            g.agS();
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str1);
            if ((localObject2 == null) || (((av)localObject2).eys != 0L)) {
              break label513;
            }
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(str1, Long.parseLong(paramString.field_related_msgids));
            if ((bs.isNullOrNil(paramString.field_related_msgids)) || (!paramString.field_related_msgids.contains(((dy)localObject2).field_msgSvrId))) {
              break label513;
            }
            ac.w("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no handle clear roomCard");
            AppMethodBeat.o(182113);
            return null;
            bool1 = false;
            break;
          }
          label513:
          if ((!bs.lr(str2, "altertodo_set")) || (paramString == null) || (!paramString.VU()) || (l1 <= paramString.field_createtime)) {
            break label2005;
          }
          bool1 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(paramString);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(str1, paramString.VT());
          ((bo)localObject2).rn("");
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(((dy)localObject2).field_msgId, (bo)localObject2);
          ac.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "ORIGIN_USERNAME_CHAT_INFO delete result:%s", new Object[] { Boolean.valueOf(bool1) });
          localObject2 = new mt();
          ((mt)localObject2).dpm.dpn = paramString.field_todoid;
          ((mt)localObject2).dpm.djF = str1;
          ((mt)localObject2).dpm.op = 1;
          com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
          paramString = null;
          bool1 = false;
          bool2 = false;
          if ((!bs.lr(str2, "sendtodo")) && (!bs.lr(str2, "altertodo_set")) && (!bs.lr(str2, "altertodo_revert")) && ((!bs.lr(str2, "replytodo")) || (!bool1))) {
            break label1257;
          }
          if (paramString != null) {
            break label1184;
          }
          paramString = new com.tencent.mm.chatroom.storage.a();
          paramString.field_todoid = ((String)localObject1);
          paramString.field_roomname = str1;
          paramString.field_createtime = l1;
          paramString.field_updatetime = (bs.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
          paramString.field_username = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          paramString.field_path = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.path"));
          paramString.field_custominfo = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.custominfo"));
          paramString.field_title = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.title"));
          paramString.field_creator = str3;
          label882:
          paramString.field_manager = bs.nullAsNil((String)paramMap.get(".sysmsg.todo.manager"));
          paramString.field_nreply = bs.getInt((String)paramMap.get(".sysmsg.todo.nreply"), 0);
          paramMap = new mt();
          if ((!bs.lr(str2, "replytodo")) && ((j != 0) || (!bool1))) {
            break label1210;
          }
          paramMap.dpm.op = 2;
          label958:
          paramMap.dpm.djF = str1;
          paramMap.dpm.dpn = ((String)localObject1);
          if (j != 0) {
            break label1685;
          }
          if (!bool2) {
            break label1574;
          }
          paramString.oM(l2);
          bool2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(paramString);
          localObject2 = paramString.ftm.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Long)((Iterator)localObject2).next();
            bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(str1, ((Long)localObject3).longValue());
            if (!bs.lr(localbo.eSo, paramString.field_todoid))
            {
              localbo.rn((String)localObject1);
              ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(localbo.field_msgId, localbo);
              ac.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { localObject3, Long.valueOf(localbo.field_msgId) });
            }
          }
          AppMethodBeat.o(182113);
        }
        catch (Exception paramString)
        {
          ac.e("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        }
        break label1257;
      }
    }
    label1177:
    label1184:
    label1210:
    label1222:
    label1257:
    label2027:
    for (;;)
    {
      return null;
      paramString.field_updatetime = (bs.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
      break label882;
      paramMap.dpm.op = j;
      break label958;
      if (bool2) {
        com.tencent.mm.sdk.b.a.GpY.a(paramMap, Looper.getMainLooper());
      }
      ac.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insertOrUpdateTodo result:%s", new Object[] { Boolean.valueOf(bool2) });
      if (!bs.isNullOrNil(parama))
      {
        j = 0;
        i = j;
        if (bs.lr(str2, "altertodo_set"))
        {
          i = j;
          if (bs.lr(str3, u.axw()))
          {
            i = j;
            if (bs.lr(str4, u.axw())) {
              i = 1;
            }
          }
        }
        boolean bool3;
        if (!bs.lr(str2, "replytodo"))
        {
          j = i;
          if (!bs.lr(str2, "altertodo_revert")) {}
        }
        else
        {
          bool2 = bs.lr(str3, u.axw());
          bool3 = w.xA(str1);
          j = i;
          if (!bs.lr(str4, u.axw()))
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
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(str1, l2);
        if ((paramString.euk & 0x4) != 4) {
          if (paramString.getType() == 10000) {
            break label2023;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label2027;
          }
          if ((bs.lr(str2, "altertodo_revert")) && (bs.lr(str4, u.axw()))) {
            paramString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757059);
          }
          for (;;)
          {
            paramMap = new bo();
            paramMap.jT(0);
            paramMap.re(str1);
            paramMap.setStatus(3);
            paramMap.setContent(paramString);
            paramMap.oA(bi.z(str1, System.currentTimeMillis() / 1000L));
            paramMap.setType(10000);
            paramMap.setFlag(paramMap.field_flag | 0x8);
            ac.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insert template msgId:%s", new Object[] { Long.valueOf(bi.u(paramMap)) });
            break label1177;
            paramString.field_related_msgids = String.valueOf(l2);
            bool2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().f(paramString);
            paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(str1, l2);
            paramString.rn((String)localObject1);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramString.field_msgId, paramString);
            ac.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(l2), Long.valueOf(paramString.field_msgId) });
            break label1222;
            if (!bool2) {
              break;
            }
            bool2 = y.c(paramString);
            ac.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "delete result:%s", new Object[] { Boolean.valueOf(bool2) });
            if (bool2) {
              com.tencent.mm.sdk.b.a.GpY.a(paramMap, Looper.getMainLooper());
            }
            paramString = paramString.ftm.iterator();
            while (paramString.hasNext())
            {
              paramMap = (Long)paramString.next();
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(str1, paramMap.longValue());
              ((bo)localObject1).rn("");
              ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(((dy)localObject1).field_msgId, (bo)localObject1);
              ac.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { paramMap, Long.valueOf(((dy)localObject1).field_msgId) });
            }
            break label1257;
            if ((bs.lr(str2, "replytodo")) && (bs.lr(str4, u.axw())))
            {
              if (bs.lr(str3, u.axw())) {
                paramString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757061);
              } else {
                paramString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757060, new Object[] { ad(str1, str3) });
              }
            }
            else
            {
              paramString = fsV.matcher(parama);
              if (paramString.find())
              {
                paramString = paramString.group(0);
                if ((!bs.isNullOrNil(paramString)) && (paramString.length() > 3))
                {
                  paramString = parama.replace(paramString, ad(str1, paramString.substring(2, paramString.length() - 1)));
                  continue;
                  ac.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no contains todoid");
                  break label1177;
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
          break label1222;
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