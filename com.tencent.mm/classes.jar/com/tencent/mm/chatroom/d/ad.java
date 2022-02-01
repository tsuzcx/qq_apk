package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.esw;
import com.tencent.mm.protocal.protobuf.ete;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ad
{
  public static void CU(String paramString)
  {
    AppMethodBeat.i(185966);
    e locale;
    boolean bool;
    if (au.bwG(paramString))
    {
      locale = null;
      if (Util.isNullOrNil(paramString)) {
        break label130;
      }
      locale = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().Db(paramString);
      if ((locale == null) || (locale.field_queryState == 0)) {
        break label125;
      }
      locale.field_queryState = 0;
      bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
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
      label125:
      bool = false;
      continue;
      label130:
      bool = false;
    }
  }
  
  public static e CV(String paramString)
  {
    AppMethodBeat.i(241467);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(241467);
      return null;
    }
    e locale = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().Db(paramString);
    if (locale != null)
    {
      AppMethodBeat.o(241467);
      return locale;
    }
    locale = new e();
    locale.field_chatroomname = paramString;
    if (((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(locale))
    {
      paramString = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().Db(paramString);
      AppMethodBeat.o(241467);
      return paramString;
    }
    AppMethodBeat.o(241467);
    return null;
  }
  
  public static void a(String paramString, chb paramchb)
  {
    AppMethodBeat.i(182112);
    if (paramchb == null)
    {
      AppMethodBeat.o(182112);
      return;
    }
    e locale = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().Db(paramString);
    if (locale == null)
    {
      locale = new e();
      locale.field_chatroomname = paramString;
      locale.field_queryState = 0;
    }
    for (int i = 0;; i = 1)
    {
      paramchb = paramchb.aapP;
      if ((paramchb == null) || (paramchb.abwp.size() == 0))
      {
        locale.field_stickToollist = "";
        if (i == 0) {
          break label236;
        }
      }
      label236:
      for (boolean bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);; bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(locale))
      {
        Log.i("MicroMsg.roomtools.RoomToolsHelp", "updateStickToolsByGetChatRoomInfoDetail roomName:%s result:%s", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(182112);
        return;
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < paramchb.abwp.size())
        {
          ete localete = (ete)paramchb.abwp.get(j);
          if (localete != null) {
            localArrayList.add(new GroupToolItem(Util.nullAs(localete.Username, ""), Util.nullAs(localete.IcT, "")));
          }
          j += 1;
        }
        locale.field_stickToollist = e.bt(localArrayList);
        break;
      }
    }
  }
  
  public static GroupToolItem g(cc paramcc)
  {
    AppMethodBeat.i(182110);
    try
    {
      k.b localb = k.b.Hf(paramcc.field_content);
      if (localb != null)
      {
        GroupToolItem localGroupToolItem = new GroupToolItem();
        localGroupToolItem.username = Util.nullAs(localb.nTD, "");
        localGroupToolItem.path = Util.nullAs(localb.nTC, "");
        localGroupToolItem.egK = paramcc.getCreateTime();
        AppMethodBeat.o(182110);
        return localGroupToolItem;
      }
      AppMethodBeat.o(182110);
      return null;
    }
    catch (Exception paramcc)
    {
      Log.e("MicroMsg.roomtools.RoomToolsHelp", "getGroupToolItemFromMsg Exception:%s %s", new Object[] { paramcc.getClass().getSimpleName(), paramcc.getMessage() });
      AppMethodBeat.o(182110);
    }
    return null;
  }
  
  public static boolean h(cc paramcc)
  {
    AppMethodBeat.i(182111);
    if (paramcc == null)
    {
      AppMethodBeat.o(182111);
      return false;
    }
    if (paramcc.getType() == 436207665)
    {
      String str = paramcc.field_content;
      k.b localb = null;
      if (str != null) {
        localb = k.b.aP(str, paramcc.field_reserved);
      }
      if ((localb != null) && ("1001".equals(localb.nSK)))
      {
        AppMethodBeat.o(182111);
        return true;
      }
    }
    AppMethodBeat.o(182111);
    return false;
  }
  
  public static boolean i(cc paramcc)
  {
    AppMethodBeat.i(185965);
    if (paramcc == null)
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!au.bwG(paramcc.field_talker))
    {
      AppMethodBeat.o(185965);
      return false;
    }
    paramcc = k.b.Hf(paramcc.field_content);
    if (paramcc == null)
    {
      Log.d("MicroMsg.roomtools.RoomToolsHelp", "content is null");
      AppMethodBeat.o(185965);
      return false;
    }
    if ((b.b(paramcc)) || (b.c(paramcc)) || ("1001".equals(paramcc.nSK)))
    {
      AppMethodBeat.o(185965);
      return true;
    }
    AppMethodBeat.o(185965);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.ad
 * JD-Core Version:    0.7.0.1
 */