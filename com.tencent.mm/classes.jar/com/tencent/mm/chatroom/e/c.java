package com.tencent.mm.chatroom.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.a.qa;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.chatroom.ui.a.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements s
{
  public static final Pattern lyZ;
  
  static
  {
    AppMethodBeat.i(182116);
    lyZ = Pattern.compile("\\$\\{(.+)\\}");
    AppMethodBeat.o(182116);
  }
  
  private static CharSequence ap(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182114);
    h.baF();
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString2);
    if (!Util.isNullOrNil(localau.field_conRemark)) {}
    for (paramString2 = localau.field_conRemark;; paramString2 = aq(paramString1, localau.field_username))
    {
      paramString1 = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        paramString1 = localau.field_conRemark;
      }
      paramString2 = paramString1;
      if (Util.isNullOrNil(paramString1)) {
        paramString2 = localau.aSU();
      }
      paramString1 = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        paramString1 = localau.field_username;
      }
      paramString1 = p.b(MMApplicationContext.getContext(), paramString1);
      AppMethodBeat.o(182114);
      return paramString1;
    }
  }
  
  private static String aq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182115);
    paramString1 = ((b)h.ax(b.class)).bzK().Ju(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(182115);
      return null;
    }
    paramString1 = paramString1.getDisplayName(paramString2);
    AppMethodBeat.o(182115);
    return paramString1;
  }
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
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
      if (!com.tencent.mm.chatroom.d.ab.aLX())
      {
        AppMethodBeat.o(182113);
        return null;
      }
      if (paramMap != null)
      {
        try
        {
          if (!paramMap.containsKey(".sysmsg.todo.todoid")) {
            break label2047;
          }
          paramString = parama.mpN;
          parama = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.template")).trim();
          localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.todoid")).trim();
          j = Util.getInt((String)paramMap.get(".sysmsg.todo.op"), 0);
          str1 = w.a(paramString.YFE);
          str2 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.scene"));
          str3 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.creator"));
          str4 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.oper"));
          Object localObject4 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.username"));
          long l1 = 1000L * Util.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L);
          l2 = Util.getLong((String)paramMap.get(".sysmsg.todo.related_msgid"), 0L);
          Object localObject2 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.sharekey"));
          Object localObject3 = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.sharename"));
          paramString = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().ar(str1, (String)localObject1);
          String str5;
          if (paramString != null)
          {
            bool1 = true;
            bool2 = com.tencent.mm.chatroom.d.ab.e(paramString);
            str5 = Util.secPrint(parama);
            if (paramString == null) {
              break label556;
            }
          }
          label556:
          for (i = paramString.field_state;; i = 0)
          {
            Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "scene:%s fromUser:%s todoId:%s appUsername:%s creator:%s operator:%s op:%s related_msgid:%s template:%s exist:%s state:%s shareKey:%s shareName:%s", new Object[] { str2, str1, localObject1, localObject4, str3, str4, Integer.valueOf(j), Long.valueOf(l2), str5, Boolean.valueOf(bool1), Integer.valueOf(i), localObject2, localObject3 });
            if ((paramString == null) || (!paramString.aMg())) {
              break label562;
            }
            h.baF();
            localObject4 = ((n)h.ax(n.class)).bzA().JE(str1);
            if ((localObject4 == null) || (((az)localObject4).kay != 0L)) {
              break label562;
            }
            localObject4 = ((n)h.ax(n.class)).gaZ().aU(str1, Long.parseLong(paramString.field_related_msgids));
            if ((localObject4 == null) || (Util.isNullOrNil(paramString.field_related_msgids)) || (!paramString.field_related_msgids.contains(((fi)localObject4).field_msgSvrId))) {
              break label562;
            }
            Log.w("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no handle clear roomCard");
            AppMethodBeat.o(182113);
            return null;
            bool1 = false;
            break;
          }
          label562:
          if ((!Util.isEqual(str2, "altertodo_set")) || (paramString == null) || (!paramString.aMg()) || (l1 <= paramString.field_createtime)) {
            break label2070;
          }
          bool1 = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().h(paramString);
          localObject4 = ((n)h.ax(n.class)).gaZ().aU(str1, paramString.aMf());
          ((cc)localObject4).Ce("");
          ((n)h.ax(n.class)).gaZ().a(((fi)localObject4).field_msgId, (cc)localObject4);
          Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "ORIGIN_USERNAME_CHAT_INFO delete result:%s", new Object[] { Boolean.valueOf(bool1) });
          localObject4 = new qa();
          ((qa)localObject4).hTi.hTj = paramString.field_todoid;
          ((qa)localObject4).hTi.hMM = str1;
          ((qa)localObject4).hTi.op = 1;
          ((qa)localObject4).asyncPublish(Looper.getMainLooper());
          paramString = null;
          bool1 = false;
          bool2 = false;
          if ((!Util.isEqual(str2, "sendtodo")) && (!Util.isEqual(str2, "altertodo_set")) && (!Util.isEqual(str2, "altertodo_revert")) && ((!Util.isEqual(str2, "replytodo")) || (!bool1))) {
            break label1325;
          }
          if (paramString != null) {
            break label1255;
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
          label940:
          paramString.field_manager = Util.nullAsNil((String)paramMap.get(".sysmsg.todo.manager"));
          paramString.field_nreply = Util.getInt((String)paramMap.get(".sysmsg.todo.nreply"), 0);
          paramMap = new qa();
          if ((!Util.isEqual(str2, "replytodo")) && ((j != 0) || (!bool1))) {
            break label1281;
          }
          paramMap.hTi.op = 2;
          label1016:
          paramMap.hTi.hMM = str1;
          paramMap.hTi.hTj = ((String)localObject1);
          if (j != 0) {
            break label1753;
          }
          if (paramString.field_state == 2) {
            paramString.field_state = 0;
          }
          if (!bool2) {
            break label1642;
          }
          paramString.hk(l2);
          bool2 = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().g(paramString);
          localObject2 = paramString.lzA.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Long)((Iterator)localObject2).next();
            localObject4 = ((n)h.ax(n.class)).gaZ().aU(str1, ((Long)localObject3).longValue());
            if (!Util.isEqual(((fi)localObject4).kLt, paramString.field_todoid))
            {
              ((cc)localObject4).Ce((String)localObject1);
              ((n)h.ax(n.class)).gaZ().a(((fi)localObject4).field_msgId, (cc)localObject4);
              Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { localObject3, Long.valueOf(((fi)localObject4).field_msgId) });
            }
          }
          AppMethodBeat.o(182113);
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        }
        break label1325;
      }
    }
    label1281:
    label1293:
    label2070:
    label2088:
    label2092:
    for (;;)
    {
      label1248:
      return null;
      label1255:
      paramString.field_updatetime = (Util.getLong((String)paramMap.get(".sysmsg.todo.time"), 0L) * 1000L);
      break label940;
      paramMap.hTi.op = j;
      break label1016;
      if (bool2) {
        paramMap.asyncPublish(Looper.getMainLooper());
      }
      Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insertOrUpdateTodo result:%s", new Object[] { Boolean.valueOf(bool2) });
      label1325:
      if (!Util.isNullOrNil(parama))
      {
        j = 0;
        i = j;
        if (Util.isEqual(str2, "altertodo_set"))
        {
          i = j;
          if (Util.isEqual(str3, z.bAM()))
          {
            i = j;
            if (Util.isEqual(str4, z.bAM())) {
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
          bool2 = Util.isEqual(str3, z.bAM());
          bool3 = com.tencent.mm.model.ab.Je(str1);
          j = i;
          if (!Util.isEqual(str4, z.bAM()))
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
        paramString = ((n)h.ax(n.class)).gaZ().aU(str1, l2);
        if ((paramString.jUq & 0x4) != 4) {
          if (paramString.getType() == 10000) {
            break label2088;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label2092;
          }
          if ((Util.isEqual(str2, "altertodo_revert")) && (Util.isEqual(str4, z.bAM()))) {
            paramString = MMApplicationContext.getContext().getString(a.i.lHl);
          }
          for (;;)
          {
            paramMap = new cc();
            paramMap.pI(0);
            paramMap.BS(str1);
            paramMap.setStatus(3);
            paramMap.setContent(paramString);
            paramMap.setCreateTime(br.D(str1, System.currentTimeMillis() / 1000L));
            paramMap.setType(10000);
            paramMap.setFlag(paramMap.field_flag | 0x8);
            Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insert template msgId:%s", new Object[] { Long.valueOf(br.B(paramMap)) });
            break label1248;
            label1642:
            paramString.field_related_msgids = String.valueOf(l2);
            bool2 = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().f(paramString);
            paramString = ((n)h.ax(n.class)).gaZ().aU(str1, l2);
            paramString.Ce((String)localObject1);
            ((n)h.ax(n.class)).gaZ().a(paramString.field_msgId, paramString);
            Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(l2), Long.valueOf(paramString.field_msgId) });
            break label1293;
            label1753:
            if (!bool2) {
              break;
            }
            bool2 = com.tencent.mm.chatroom.d.ab.c(paramString);
            Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "delete result:%s", new Object[] { Boolean.valueOf(bool2) });
            if (bool2) {
              paramMap.asyncPublish(Looper.getMainLooper());
            }
            paramString = paramString.lzA.iterator();
            while (paramString.hasNext())
            {
              paramMap = (Long)paramString.next();
              localObject1 = ((n)h.ax(n.class)).gaZ().aU(str1, paramMap.longValue());
              ((cc)localObject1).Ce("");
              ((n)h.ax(n.class)).gaZ().a(((fi)localObject1).field_msgId, (cc)localObject1);
              Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", new Object[] { paramMap, Long.valueOf(((fi)localObject1).field_msgId) });
            }
            break label1325;
            if ((Util.isEqual(str2, "replytodo")) && (Util.isEqual(str4, z.bAM())))
            {
              if (Util.isEqual(str3, z.bAM())) {
                paramString = MMApplicationContext.getContext().getString(a.i.lHn);
              } else {
                paramString = MMApplicationContext.getContext().getString(a.i.lHm, new Object[] { ap(str1, str3) });
              }
            }
            else
            {
              paramString = lyZ.matcher(parama);
              if (paramString.find())
              {
                paramString = paramString.group(0);
                if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 3))
                {
                  paramString = parama.replace(paramString, ap(str1, paramString.substring(2, paramString.length() - 1)));
                  continue;
                  label2047:
                  Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no contains todoid");
                  break label1248;
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
          break label1293;
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.c
 * JD-Core Version:    0.7.0.1
 */