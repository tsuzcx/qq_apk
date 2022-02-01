package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
{
  private static Boolean fpr = null;
  
  public static boolean UU()
  {
    AppMethodBeat.i(182109);
    if ((h.DEBUG) || (h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182109);
      return true;
    }
    boolean bool;
    if (fpr != null)
    {
      bool = fpr.booleanValue();
      AppMethodBeat.o(182109);
      return bool;
    }
    int i = ((b)g.ab(b.class)).a(b.a.ppI, 1);
    ad.i("MicroMsg.roomtools.RoomToolsHelp", "getRoomToolsSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (fpr = Boolean.TRUE;; fpr = Boolean.FALSE)
    {
      bool = fpr.booleanValue();
      AppMethodBeat.o(182109);
      return bool;
    }
  }
  
  public static void UV()
  {
    AppMethodBeat.i(185967);
    ad.i("MicroMsg.roomtools.RoomToolsHelp", "resetAllGroupToolsRecentUse");
    Object localObject = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().Vc();
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
  
  public static void a(String paramString, arx paramarx)
  {
    AppMethodBeat.i(182112);
    if (!UU())
    {
      AppMethodBeat.o(182112);
      return;
    }
    if (paramarx == null)
    {
      AppMethodBeat.o(182112);
      return;
    }
    c localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().oQ(paramString);
    if (localc == null)
    {
      localc = new c();
      localc.field_chatroomname = paramString;
      localc.field_queryState = 0;
    }
    for (int i = 0;; i = 1)
    {
      paramarx = paramarx.Dsf;
      if ((paramarx == null) || (paramarx.EgV.size() == 0))
      {
        localc.field_stickToollist = "";
        if (i == 0) {
          break label248;
        }
      }
      label248:
      for (boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc, new String[0]);; bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc))
      {
        ad.i("MicroMsg.roomtools.RoomToolsHelp", "updateStickToolsByGetChatRoomInfoDetail roomName:%s result:%s", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(182112);
        return;
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < paramarx.EgV.size())
        {
          cma localcma = (cma)paramarx.EgV.get(j);
          if (localcma != null) {
            localArrayList.add(new GroupToolItem(bt.by(localcma.Username, ""), bt.by(localcma.sdZ, "")));
          }
          j += 1;
        }
        localc.field_stickToollist = c.X(localArrayList);
        break;
      }
    }
  }
  
  public static GroupToolItem g(bl parambl)
  {
    AppMethodBeat.i(182110);
    try
    {
      k.b localb = k.b.rx(parambl.field_content);
      if (localb != null)
      {
        GroupToolItem localGroupToolItem = new GroupToolItem();
        localGroupToolItem.username = bt.by(localb.gJE, "");
        localGroupToolItem.path = bt.by(localb.gJD, "");
        localGroupToolItem.fpL = parambl.field_createTime;
        AppMethodBeat.o(182110);
        return localGroupToolItem;
      }
      AppMethodBeat.o(182110);
      return null;
    }
    catch (Exception parambl)
    {
      ad.e("MicroMsg.roomtools.RoomToolsHelp", "getGroupToolItemFromMsg Exception:%s %s", new Object[] { parambl.getClass().getSimpleName(), parambl.getMessage() });
      AppMethodBeat.o(182110);
    }
    return null;
  }
  
  public static boolean h(bl parambl)
  {
    AppMethodBeat.i(182111);
    if (parambl == null)
    {
      AppMethodBeat.o(182111);
      return false;
    }
    if (parambl.getType() == 436207665)
    {
      String str = parambl.field_content;
      k.b localb = null;
      if (str != null) {
        localb = k.b.ar(str, parambl.field_reserved);
      }
      if ((localb != null) && ("1001".equals(localb.gIN)))
      {
        AppMethodBeat.o(182111);
        return true;
      }
    }
    AppMethodBeat.o(182111);
    return false;
  }
  
  public static boolean i(bl parambl)
  {
    AppMethodBeat.i(185965);
    if (parambl == null)
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!w.sm(parambl.field_talker))
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!UU())
    {
      AppMethodBeat.o(185965);
      return false;
    }
    parambl = k.b.rx(parambl.field_content);
    if (parambl == null)
    {
      ad.d("MicroMsg.roomtools.RoomToolsHelp", "content is null");
      AppMethodBeat.o(185965);
      return false;
    }
    if ((a.b(parambl)) || (a.c(parambl)) || ("1001".equals(parambl.gIN)))
    {
      AppMethodBeat.o(185965);
      return true;
    }
    AppMethodBeat.o(185965);
    return false;
  }
  
  public static void oN(String paramString)
  {
    AppMethodBeat.i(185966);
    c localc;
    boolean bool;
    if ((UU()) && (w.sm(paramString)))
    {
      localc = null;
      if (bt.isNullOrNil(paramString)) {
        break label141;
      }
      localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().oQ(paramString);
      if ((localc == null) || (localc.field_queryState == 0)) {
        break label136;
      }
      localc.field_queryState = 0;
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc, new String[0]);
    }
    for (;;)
    {
      String str = bt.by(paramString, "");
      if (localc == null) {}
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
  
  public static c oO(String paramString)
  {
    AppMethodBeat.i(196575);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(196575);
      return null;
    }
    c localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().oQ(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(196575);
      return localc;
    }
    localc = new c();
    localc.field_chatroomname = paramString;
    if (((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc))
    {
      paramString = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().oQ(paramString);
      AppMethodBeat.o(196575);
      return paramString;
    }
    AppMethodBeat.o(196575);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.aa
 * JD-Core Version:    0.7.0.1
 */