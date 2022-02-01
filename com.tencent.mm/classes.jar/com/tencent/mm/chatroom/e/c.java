package com.tencent.mm.chatroom.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements p
{
  public static final Pattern fNz;
  
  static
  {
    AppMethodBeat.i(182116);
    fNz = Pattern.compile("\\$\\{(.+)\\}");
    AppMethodBeat.o(182116);
  }
  
  private static CharSequence ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182114);
    g.ajS();
    an localan = ((l)g.ab(l.class)).azF().BH(paramString2);
    if (!bu.isNullOrNil(localan.field_conRemark)) {}
    for (paramString2 = localan.field_conRemark;; paramString2 = af(paramString1, localan.field_username))
    {
      paramString1 = paramString2;
      if (bu.isNullOrNil(paramString2)) {
        paramString1 = localan.field_conRemark;
      }
      paramString2 = paramString1;
      if (bu.isNullOrNil(paramString1)) {
        paramString2 = localan.adF();
      }
      paramString1 = paramString2;
      if (bu.isNullOrNil(paramString2)) {
        paramString1 = localan.field_username;
      }
      paramString1 = k.c(ak.getContext(), paramString1);
      AppMethodBeat.o(182114);
      return paramString1;
    }
  }
  
  private static String af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182115);
    paramString1 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(182115);
      return null;
    }
    paramString1 = paramString1.zP(paramString2);
    AppMethodBeat.o(182115);
    return paramString1;
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(182113);
    ae.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { bu.bI(paramString, "") });
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
    if (bu.nullAsNil(paramString).equals("roomtoolstips"))
    {
      if (!y.Yn())
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
          paramString = parama.gte;
          parama = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.template")).trim();
          localObject1 = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.todoid")).trim();
          j = bu.getInt((String)paramMap.get(".sysmsg.todo.op"), 0);
          str1 = z.a(paramString.FNG);
          str2 = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.scene"));
          str3 = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.creator"));
          str4 = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.oper"));
          Object localObject4 = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          long l1 = 1000L * bu.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L);
          l2 = bu.getLong((String)paramMap.get(".sysmsg.todo.related_msgid"), 0L);
          Object localObject2 = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.sharekey"));
          Object localObject3 = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.sharename"));
          paramString = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(str1, (String)localObject1);
          String str5;
          if (paramString != null)
          {
            bool1 = true;
            bool2 = y.e(paramString);
            str5 = bu.aSM(parama);
            if (paramString == null) {
              break label551;
            }
          }
          label551:
          for (i = paramString.field_state;; i = 0)
          {
            ae.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "scene:%s fromUser:%s todoId:%s appUsername:%s creator:%s operator:%s op:%s related_msgid:%s template:%s exist:%s state:%s shareKey:%s shareName:%s", new Object[] { str2, str1, localObject1, localObject4, str3, str4, Integer.valueOf(j), Long.valueOf(l2), str5, Boolean.valueOf(bool1), Integer.valueOf(i), localObject2, localObject3 });
            if ((paramString == null) || (!paramString.Yy())) {
              break label557;
            }
            g.ajS();
            localObject4 = ((l)g.ab(l.class)).azF().BH(str1);
            if ((localObject4 == null) || (((aw)localObject4).eRB != 0L)) {
              break label557;
            }
            localObject4 = ((l)g.ab(l.class)).doJ().aJ(str1, Long.parseLong(paramString.field_related_msgids));
            if ((bu.isNullOrNil(paramString.field_related_msgids)) || (!paramString.field_related_msgids.contains(((ei)localObject4).field_msgSvrId))) {
              break label557;
            }
            ae.w("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no handle clear roomCard");
            AppMethodBeat.o(182113);
            return null;
            bool1 = false;
            break;
          }
          label557:
          if ((!bu.lX(str2, "altertodo_set")) || (paramString == null) || (!paramString.Yy()) || (l1 <= paramString.field_createtime)) {
            break label2074;
          }
          bool1 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(paramString);
          localObject4 = ((l)g.ab(l.class)).doJ().aJ(str1, paramString.Yx());
          ((bv)localObject4).uu("");
          ((l)g.ab(l.class)).doJ().a(((ei)localObject4).field_msgId, (bv)localObject4);
          ae.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "ORIGIN_USERNAME_CHAT_INFO delete result:%s", new Object[] { Boolean.valueOf(bool1) });
          localObject4 = new nc();
          ((nc)localObject4).dCe.dCf = paramString.field_todoid;
          ((nc)localObject4).dCe.dwx = str1;
          ((nc)localObject4).dCe.op = 1;
          a.IvT.a((b)localObject4, Looper.getMainLooper());
          paramString = null;
          bool1 = false;
          bool2 = false;
          if ((!bu.lX(str2, "sendtodo")) && (!bu.lX(str2, "altertodo_set")) && (!bu.lX(str2, "altertodo_revert")) && ((!bu.lX(str2, "replytodo")) || (!bool1))) {
            break label1326;
          }
          if (paramString != null) {
            break label1253;
          }
          paramString = new com.tencent.mm.chatroom.storage.c();
          paramString.field_todoid = ((String)localObject1);
          paramString.field_roomname = str1;
          paramString.field_createtime = l1;
          paramString.field_updatetime = (bu.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
          paramString.field_username = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          paramString.field_path = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.path"));
          paramString.field_custominfo = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.custominfo"));
          paramString.field_title = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.title"));
          paramString.field_creator = str3;
          paramString.field_shareKey = ((String)localObject2);
          paramString.field_shareName = ((String)localObject3);
          label938:
          paramString.field_manager = bu.nullAsNil((String)paramMap.get(".sysmsg.todo.manager"));
          paramString.field_nreply = bu.getInt((String)paramMap.get(".sysmsg.todo.nreply"), 0);
          paramMap = new nc();
          if ((!bu.lX(str2, "replytodo")) && ((j != 0) || (!bool1))) {
            break label1279;
          }
          paramMap.dCe.op = 2;
          label1014:
          paramMap.dCe.dwx = str1;
          paramMap.dCe.dCf = ((String)localObject1);
          if (j != 0) {
            break label1754;
          }
          if (paramString.field_state == 2) {
            paramString.field_state = 0;
          }
          if (!bool2) {
            break label1643;
          }
          paramString.qZ(l2);
          bool2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(paramString);
          localObject2 = paramString.fOh.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Long)((Iterator)localObject2).next();
            localObject4 = ((l)g.ab(l.class)).doJ().aJ(str1, ((Long)localObject3).longValue());
            if (!bu.lX(((ei)localObject4).fmA, paramString.field_todoid))
            {
              ((bv)localObject4).uu((String)localObject1);
              ((l)g.ab(l.class)).doJ().a(((ei)localObject4).field_msgId, (bv)localObject4);
              ae.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { localObject3, Long.valueOf(((ei)localObject4).field_msgId) });
            }
          }
          AppMethodBeat.o(182113);
        }
        catch (Exception paramString)
        {
          ae.e("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
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
      paramString.field_updatetime = (bu.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
      break label938;
      label1279:
      paramMap.dCe.op = j;
      break label1014;
      if (bool2) {
        a.IvT.a(paramMap, Looper.getMainLooper());
      }
      ae.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insertOrUpdateTodo result:%s", new Object[] { Boolean.valueOf(bool2) });
      if (!bu.isNullOrNil(parama))
      {
        j = 0;
        i = j;
        if (bu.lX(str2, "altertodo_set"))
        {
          i = j;
          if (bu.lX(str3, v.aAC()))
          {
            i = j;
            if (bu.lX(str4, v.aAC())) {
              i = 1;
            }
          }
        }
        boolean bool3;
        if (!bu.lX(str2, "replytodo"))
        {
          j = i;
          if (!bu.lX(str2, "altertodo_revert")) {}
        }
        else
        {
          bool2 = bu.lX(str3, v.aAC());
          bool3 = x.Bi(str1);
          j = i;
          if (!bu.lX(str4, v.aAC()))
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
        paramString = ((l)g.ab(l.class)).doJ().aJ(str1, l2);
        if ((paramString.eNc & 0x4) != 4) {
          if (paramString.getType() == 10000) {
            break label2092;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label2096;
          }
          if ((bu.lX(str2, "altertodo_revert")) && (bu.lX(str4, v.aAC()))) {
            paramString = ak.getContext().getString(2131757059);
          }
          for (;;)
          {
            paramMap = new bv();
            paramMap.kt(0);
            paramMap.ui(str1);
            paramMap.setStatus(3);
            paramMap.setContent(paramString);
            paramMap.qN(bl.B(str1, System.currentTimeMillis() / 1000L));
            paramMap.setType(10000);
            paramMap.setFlag(paramMap.field_flag | 0x8);
            ae.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insert template msgId:%s", new Object[] { Long.valueOf(bl.v(paramMap)) });
            break label1246;
            label1643:
            paramString.field_related_msgids = String.valueOf(l2);
            bool2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().f(paramString);
            paramString = ((l)g.ab(l.class)).doJ().aJ(str1, l2);
            paramString.uu((String)localObject1);
            ((l)g.ab(l.class)).doJ().a(paramString.field_msgId, paramString);
            ae.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(l2), Long.valueOf(paramString.field_msgId) });
            break label1291;
            label1754:
            if (!bool2) {
              break;
            }
            bool2 = y.c(paramString);
            ae.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "delete result:%s", new Object[] { Boolean.valueOf(bool2) });
            if (bool2) {
              a.IvT.a(paramMap, Looper.getMainLooper());
            }
            paramString = paramString.fOh.iterator();
            while (paramString.hasNext())
            {
              paramMap = (Long)paramString.next();
              localObject1 = ((l)g.ab(l.class)).doJ().aJ(str1, paramMap.longValue());
              ((bv)localObject1).uu("");
              ((l)g.ab(l.class)).doJ().a(((ei)localObject1).field_msgId, (bv)localObject1);
              ae.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { paramMap, Long.valueOf(((ei)localObject1).field_msgId) });
            }
            break label1326;
            if ((bu.lX(str2, "replytodo")) && (bu.lX(str4, v.aAC())))
            {
              if (bu.lX(str3, v.aAC())) {
                paramString = ak.getContext().getString(2131757061);
              } else {
                paramString = ak.getContext().getString(2131757060, new Object[] { ae(str1, str3) });
              }
            }
            else
            {
              paramString = fNz.matcher(parama);
              if (paramString.find())
              {
                paramString = paramString.group(0);
                if ((!bu.isNullOrNil(paramString)) && (paramString.length() > 3))
                {
                  paramString = parama.replace(paramString, ae(str1, paramString.substring(2, paramString.length() - 1)));
                  continue;
                  ae.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no contains todoid");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.c
 * JD-Core Version:    0.7.0.1
 */