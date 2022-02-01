package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
{
  private static Boolean iWS = null;
  
  public static void Kp(String paramString)
  {
    AppMethodBeat.i(185966);
    e locale;
    boolean bool;
    if ((asf()) && (ab.PP(paramString)))
    {
      locale = null;
      if (Util.isNullOrNil(paramString)) {
        break label136;
      }
      locale = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().Kv(paramString);
      if ((locale == null) || (locale.field_queryState == 0)) {
        break label131;
      }
      locale.field_queryState = 0;
      bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
    }
    for (;;)
    {
      String str = Util.nullAs(paramString, "");
      if (locale == null) {}
      for (paramString = "null";; paramString = "not_null")
      {
        Log.i("MicroMsg.roomtools.RoomToolsHelp", "resetGroupToolsByTalker roomName:%s groupTools:%s result:%s", new Object[] { str, paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(185966);
        return;
      }
      label131:
      bool = false;
      continue;
      label136:
      bool = false;
    }
  }
  
  public static e Kq(String paramString)
  {
    AppMethodBeat.i(191821);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(191821);
      return null;
    }
    e locale = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().Kv(paramString);
    if (locale != null)
    {
      AppMethodBeat.o(191821);
      return locale;
    }
    locale = new e();
    locale.field_chatroomname = paramString;
    if (((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(locale))
    {
      paramString = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().Kv(paramString);
      AppMethodBeat.o(191821);
      return paramString;
    }
    AppMethodBeat.o(191821);
    return null;
  }
  
  public static void a(String paramString, bsi parambsi)
  {
    AppMethodBeat.i(182112);
    if (!asf())
    {
      AppMethodBeat.o(182112);
      return;
    }
    if (parambsi == null)
    {
      AppMethodBeat.o(182112);
      return;
    }
    e locale = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().Kv(paramString);
    if (locale == null)
    {
      locale = new e();
      locale.field_chatroomname = paramString;
      locale.field_queryState = 0;
    }
    for (int i = 0;; i = 1)
    {
      parambsi = parambsi.TcA;
      if ((parambsi == null) || (parambsi.Ufc.size() == 0))
      {
        locale.field_stickToollist = "";
        if (i == 0) {
          break label248;
        }
      }
      label248:
      for (boolean bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);; bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(locale))
      {
        Log.i("MicroMsg.roomtools.RoomToolsHelp", "updateStickToolsByGetChatRoomInfoDetail roomName:%s result:%s", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(182112);
        return;
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < parambsi.Ufc.size())
        {
          dzy localdzy = (dzy)parambsi.Ufc.get(j);
          if (localdzy != null) {
            localArrayList.add(new GroupToolItem(Util.nullAs(localdzy.Username, ""), Util.nullAs(localdzy.CqK, "")));
          }
          j += 1;
        }
        locale.field_stickToollist = e.T(localArrayList);
        break;
      }
    }
  }
  
  public static boolean asf()
  {
    AppMethodBeat.i(182109);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182109);
      return true;
    }
    boolean bool;
    if (iWS != null)
    {
      bool = iWS.booleanValue();
      AppMethodBeat.o(182109);
      return bool;
    }
    int i = ((b)h.ae(b.class)).a(b.a.vFn, 1);
    Log.i("MicroMsg.roomtools.RoomToolsHelp", "getRoomToolsSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (iWS = Boolean.TRUE;; iWS = Boolean.FALSE)
    {
      bool = iWS.booleanValue();
      AppMethodBeat.o(182109);
      return bool;
    }
  }
  
  public static void asg()
  {
    AppMethodBeat.i(185967);
    Log.i("MicroMsg.roomtools.RoomToolsHelp", "resetAllGroupToolsRecentUse");
    Object localObject = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().asq();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        e locale = (e)((Iterator)localObject).next();
        locale.field_queryState = 0;
        ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
      }
    }
    AppMethodBeat.o(185967);
  }
  
  public static GroupToolItem g(ca paramca)
  {
    AppMethodBeat.i(182110);
    try
    {
      k.b localb = k.b.OQ(paramca.field_content);
      if (localb != null)
      {
        GroupToolItem localGroupToolItem = new GroupToolItem();
        localGroupToolItem.username = Util.nullAs(localb.loA, "");
        localGroupToolItem.path = Util.nullAs(localb.loz, "");
        localGroupToolItem.coZ = paramca.field_createTime;
        AppMethodBeat.o(182110);
        return localGroupToolItem;
      }
      AppMethodBeat.o(182110);
      return null;
    }
    catch (Exception paramca)
    {
      Log.e("MicroMsg.roomtools.RoomToolsHelp", "getGroupToolItemFromMsg Exception:%s %s", new Object[] { paramca.getClass().getSimpleName(), paramca.getMessage() });
      AppMethodBeat.o(182110);
    }
    return null;
  }
  
  public static boolean h(ca paramca)
  {
    AppMethodBeat.i(182111);
    if (paramca == null)
    {
      AppMethodBeat.o(182111);
      return false;
    }
    if (paramca.getType() == 436207665)
    {
      String str = paramca.field_content;
      k.b localb = null;
      if (str != null) {
        localb = k.b.aG(str, paramca.field_reserved);
      }
      if ((localb != null) && ("1001".equals(localb.lnG)))
      {
        AppMethodBeat.o(182111);
        return true;
      }
    }
    AppMethodBeat.o(182111);
    return false;
  }
  
  public static boolean i(ca paramca)
  {
    AppMethodBeat.i(185965);
    if (paramca == null)
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!ab.PP(paramca.field_talker))
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!asf())
    {
      AppMethodBeat.o(185965);
      return false;
    }
    paramca = k.b.OQ(paramca.field_content);
    if (paramca == null)
    {
      Log.d("MicroMsg.roomtools.RoomToolsHelp", "content is null");
      AppMethodBeat.o(185965);
      return false;
    }
    if ((a.b(paramca)) || (a.c(paramca)) || ("1001".equals(paramca.lnG)))
    {
      AppMethodBeat.o(185965);
      return true;
    }
    AppMethodBeat.o(185965);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.aa
 * JD-Core Version:    0.7.0.1
 */