package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ayz;
import com.tencent.mm.protocal.protobuf.cwg;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
{
  private static Boolean fLr = null;
  
  public static boolean Yh()
  {
    AppMethodBeat.i(182109);
    if ((i.DEBUG) || (i.IS_FLAVOR_RED) || (i.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182109);
      return true;
    }
    boolean bool;
    if (fLr != null)
    {
      bool = fLr.booleanValue();
      AppMethodBeat.o(182109);
      return bool;
    }
    int i = ((b)g.ab(b.class)).a(b.a.qxZ, 1);
    ad.i("MicroMsg.roomtools.RoomToolsHelp", "getRoomToolsSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (fLr = Boolean.TRUE;; fLr = Boolean.FALSE)
    {
      bool = fLr.booleanValue();
      AppMethodBeat.o(182109);
      return bool;
    }
  }
  
  public static void Yi()
  {
    AppMethodBeat.i(185967);
    ad.i("MicroMsg.roomtools.RoomToolsHelp", "resetAllGroupToolsRecentUse");
    Object localObject = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().Yt();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        e locale = (e)((Iterator)localObject).next();
        locale.field_queryState = 0;
        ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
      }
    }
    AppMethodBeat.o(185967);
  }
  
  public static void a(String paramString, ayz paramayz)
  {
    AppMethodBeat.i(182112);
    if (!Yh())
    {
      AppMethodBeat.o(182112);
      return;
    }
    if (paramayz == null)
    {
      AppMethodBeat.o(182112);
      return;
    }
    e locale = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().uR(paramString);
    if (locale == null)
    {
      locale = new e();
      locale.field_chatroomname = paramString;
      locale.field_queryState = 0;
    }
    for (int i = 0;; i = 1)
    {
      paramayz = paramayz.Gwl;
      if ((paramayz == null) || (paramayz.Hoj.size() == 0))
      {
        locale.field_stickToollist = "";
        if (i == 0) {
          break label248;
        }
      }
      label248:
      for (boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);; bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale))
      {
        ad.i("MicroMsg.roomtools.RoomToolsHelp", "updateStickToolsByGetChatRoomInfoDetail roomName:%s result:%s", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(182112);
        return;
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < paramayz.Hoj.size())
        {
          cwo localcwo = (cwo)paramayz.Hoj.get(j);
          if (localcwo != null) {
            localArrayList.add(new GroupToolItem(bt.bI(localcwo.Username, ""), bt.bI(localcwo.ujc, "")));
          }
          j += 1;
        }
        locale.field_stickToollist = e.Q(localArrayList);
        break;
      }
    }
  }
  
  public static GroupToolItem g(bu parambu)
  {
    AppMethodBeat.i(182110);
    try
    {
      k.b localb = k.b.yr(parambu.field_content);
      if (localb != null)
      {
        GroupToolItem localGroupToolItem = new GroupToolItem();
        localGroupToolItem.username = bt.bI(localb.hCn, "");
        localGroupToolItem.path = bt.bI(localb.hCm, "");
        localGroupToolItem.fMf = parambu.field_createTime;
        AppMethodBeat.o(182110);
        return localGroupToolItem;
      }
      AppMethodBeat.o(182110);
      return null;
    }
    catch (Exception parambu)
    {
      ad.e("MicroMsg.roomtools.RoomToolsHelp", "getGroupToolItemFromMsg Exception:%s %s", new Object[] { parambu.getClass().getSimpleName(), parambu.getMessage() });
      AppMethodBeat.o(182110);
    }
    return null;
  }
  
  public static boolean h(bu parambu)
  {
    AppMethodBeat.i(182111);
    if (parambu == null)
    {
      AppMethodBeat.o(182111);
      return false;
    }
    if (parambu.getType() == 436207665)
    {
      String str = parambu.field_content;
      k.b localb = null;
      if (str != null) {
        localb = k.b.aA(str, parambu.field_reserved);
      }
      if ((localb != null) && ("1001".equals(localb.hBw)))
      {
        AppMethodBeat.o(182111);
        return true;
      }
    }
    AppMethodBeat.o(182111);
    return false;
  }
  
  public static boolean i(bu parambu)
  {
    AppMethodBeat.i(185965);
    if (parambu == null)
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!w.zk(parambu.field_talker))
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!Yh())
    {
      AppMethodBeat.o(185965);
      return false;
    }
    parambu = k.b.yr(parambu.field_content);
    if (parambu == null)
    {
      ad.d("MicroMsg.roomtools.RoomToolsHelp", "content is null");
      AppMethodBeat.o(185965);
      return false;
    }
    if ((a.b(parambu)) || (a.c(parambu)) || ("1001".equals(parambu.hBw)))
    {
      AppMethodBeat.o(185965);
      return true;
    }
    AppMethodBeat.o(185965);
    return false;
  }
  
  public static void uM(String paramString)
  {
    AppMethodBeat.i(185966);
    e locale;
    boolean bool;
    if ((Yh()) && (w.zk(paramString)))
    {
      locale = null;
      if (bt.isNullOrNil(paramString)) {
        break label141;
      }
      locale = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().uR(paramString);
      if ((locale == null) || (locale.field_queryState == 0)) {
        break label136;
      }
      locale.field_queryState = 0;
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
    }
    for (;;)
    {
      String str = bt.bI(paramString, "");
      if (locale == null) {}
      for (paramString = "null";; paramString = "not_null")
      {
        ad.i("MicroMsg.roomtools.RoomToolsHelp", "resetGroupToolsByTalker roomName:%s groupTools:%s result:%s", new Object[] { str, paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(185966);
        return;
      }
      label136:
      bool = false;
      continue;
      label141:
      bool = false;
    }
  }
  
  public static e uN(String paramString)
  {
    AppMethodBeat.i(213413);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213413);
      return null;
    }
    e locale = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().uR(paramString);
    if (locale != null)
    {
      AppMethodBeat.o(213413);
      return locale;
    }
    locale = new e();
    locale.field_chatroomname = paramString;
    if (((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale))
    {
      paramString = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().uR(paramString);
      AppMethodBeat.o(213413);
      return paramString;
    }
    AppMethodBeat.o(213413);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.aa
 * JD-Core Version:    0.7.0.1
 */