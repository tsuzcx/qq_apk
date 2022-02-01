package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
{
  private static Boolean fsR = null;
  
  public static boolean VQ()
  {
    AppMethodBeat.i(182109);
    if ((h.DEBUG) || (h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182109);
      return true;
    }
    boolean bool;
    if (fsR != null)
    {
      bool = fsR.booleanValue();
      AppMethodBeat.o(182109);
      return bool;
    }
    int i = ((b)g.ab(b.class)).a(b.a.pTt, 1);
    ac.i("MicroMsg.roomtools.RoomToolsHelp", "getRoomToolsSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (fsR = Boolean.TRUE;; fsR = Boolean.FALSE)
    {
      bool = fsR.booleanValue();
      AppMethodBeat.o(182109);
      return bool;
    }
  }
  
  public static void VR()
  {
    AppMethodBeat.i(185967);
    ac.i("MicroMsg.roomtools.RoomToolsHelp", "resetAllGroupToolsRecentUse");
    Object localObject = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().VZ();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        localc.field_queryState = 0;
        ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc, new String[0]);
      }
    }
    AppMethodBeat.o(185967);
  }
  
  public static void a(String paramString, avb paramavb)
  {
    AppMethodBeat.i(182112);
    if (!VQ())
    {
      AppMethodBeat.o(182112);
      return;
    }
    if (paramavb == null)
    {
      AppMethodBeat.o(182112);
      return;
    }
    c localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().sb(paramString);
    if (localc == null)
    {
      localc = new c();
      localc.field_chatroomname = paramString;
      localc.field_queryState = 0;
    }
    for (int i = 0;; i = 1)
    {
      paramavb = paramavb.ENh;
      if ((paramavb == null) || (paramavb.FDU.size() == 0))
      {
        localc.field_stickToollist = "";
        if (i == 0) {
          break label248;
        }
      }
      label248:
      for (boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc, new String[0]);; bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc))
      {
        ac.i("MicroMsg.roomtools.RoomToolsHelp", "updateStickToolsByGetChatRoomInfoDetail roomName:%s result:%s", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(182112);
        return;
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < paramavb.FDU.size())
        {
          crh localcrh = (crh)paramavb.FDU.get(j);
          if (localcrh != null) {
            localArrayList.add(new GroupToolItem(bs.bG(localcrh.Username, ""), bs.bG(localcrh.tlT, "")));
          }
          j += 1;
        }
        localc.field_stickToollist = c.O(localArrayList);
        break;
      }
    }
  }
  
  public static GroupToolItem g(bo parambo)
  {
    AppMethodBeat.i(182110);
    try
    {
      k.b localb = k.b.vA(parambo.field_content);
      if (localb != null)
      {
        GroupToolItem localGroupToolItem = new GroupToolItem();
        localGroupToolItem.username = bs.bG(localb.hke, "");
        localGroupToolItem.path = bs.bG(localb.hkd, "");
        localGroupToolItem.fto = parambo.field_createTime;
        AppMethodBeat.o(182110);
        return localGroupToolItem;
      }
      AppMethodBeat.o(182110);
      return null;
    }
    catch (Exception parambo)
    {
      ac.e("MicroMsg.roomtools.RoomToolsHelp", "getGroupToolItemFromMsg Exception:%s %s", new Object[] { parambo.getClass().getSimpleName(), parambo.getMessage() });
      AppMethodBeat.o(182110);
    }
    return null;
  }
  
  public static boolean h(bo parambo)
  {
    AppMethodBeat.i(182111);
    if (parambo == null)
    {
      AppMethodBeat.o(182111);
      return false;
    }
    if (parambo.getType() == 436207665)
    {
      String str = parambo.field_content;
      k.b localb = null;
      if (str != null) {
        localb = k.b.az(str, parambo.field_reserved);
      }
      if ((localb != null) && ("1001".equals(localb.hjn)))
      {
        AppMethodBeat.o(182111);
        return true;
      }
    }
    AppMethodBeat.o(182111);
    return false;
  }
  
  public static boolean i(bo parambo)
  {
    AppMethodBeat.i(185965);
    if (parambo == null)
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!w.wp(parambo.field_talker))
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!VQ())
    {
      AppMethodBeat.o(185965);
      return false;
    }
    parambo = k.b.vA(parambo.field_content);
    if (parambo == null)
    {
      ac.d("MicroMsg.roomtools.RoomToolsHelp", "content is null");
      AppMethodBeat.o(185965);
      return false;
    }
    if ((a.b(parambo)) || (a.c(parambo)) || ("1001".equals(parambo.hjn)))
    {
      AppMethodBeat.o(185965);
      return true;
    }
    AppMethodBeat.o(185965);
    return false;
  }
  
  public static void rY(String paramString)
  {
    AppMethodBeat.i(185966);
    c localc;
    boolean bool;
    if ((VQ()) && (w.wp(paramString)))
    {
      localc = null;
      if (bs.isNullOrNil(paramString)) {
        break label141;
      }
      localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().sb(paramString);
      if ((localc == null) || (localc.field_queryState == 0)) {
        break label136;
      }
      localc.field_queryState = 0;
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc, new String[0]);
    }
    for (;;)
    {
      String str = bs.bG(paramString, "");
      if (localc == null) {}
      for (paramString = "null";; paramString = "not_null")
      {
        ac.i("MicroMsg.roomtools.RoomToolsHelp", "resetGroupToolsByTalker roomName:%s groupTools:%s result:%s", new Object[] { str, paramString, Boolean.valueOf(bool) });
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
  
  public static c rZ(String paramString)
  {
    AppMethodBeat.i(197041);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(197041);
      return null;
    }
    c localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().sb(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(197041);
      return localc;
    }
    localc = new c();
    localc.field_chatroomname = paramString;
    if (((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc))
    {
      paramString = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().sb(paramString);
      AppMethodBeat.o(197041);
      return paramString;
    }
    AppMethodBeat.o(197041);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.aa
 * JD-Core Version:    0.7.0.1
 */