package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.cxa;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
{
  private static Boolean fNv = null;
  
  public static boolean Yr()
  {
    AppMethodBeat.i(182109);
    if ((j.DEBUG) || (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182109);
      return true;
    }
    boolean bool;
    if (fNv != null)
    {
      bool = fNv.booleanValue();
      AppMethodBeat.o(182109);
      return bool;
    }
    int i = ((b)g.ab(b.class)).a(b.a.qFf, 1);
    ae.i("MicroMsg.roomtools.RoomToolsHelp", "getRoomToolsSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (fNv = Boolean.TRUE;; fNv = Boolean.FALSE)
    {
      bool = fNv.booleanValue();
      AppMethodBeat.o(182109);
      return bool;
    }
  }
  
  public static void Ys()
  {
    AppMethodBeat.i(185967);
    ae.i("MicroMsg.roomtools.RoomToolsHelp", "resetAllGroupToolsRecentUse");
    Object localObject = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().YC();
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
  
  public static void a(String paramString, azp paramazp)
  {
    AppMethodBeat.i(182112);
    if (!Yr())
    {
      AppMethodBeat.o(182112);
      return;
    }
    if (paramazp == null)
    {
      AppMethodBeat.o(182112);
      return;
    }
    e locale = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().vn(paramString);
    if (locale == null)
    {
      locale = new e();
      locale.field_chatroomname = paramString;
      locale.field_queryState = 0;
    }
    for (int i = 0;; i = 1)
    {
      paramazp = paramazp.GPK;
      if ((paramazp == null) || (paramazp.HHJ.size() == 0))
      {
        locale.field_stickToollist = "";
        if (i == 0) {
          break label248;
        }
      }
      label248:
      for (boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);; bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale))
      {
        ae.i("MicroMsg.roomtools.RoomToolsHelp", "updateStickToolsByGetChatRoomInfoDetail roomName:%s result:%s", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(182112);
        return;
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < paramazp.HHJ.size())
        {
          cxi localcxi = (cxi)paramazp.HHJ.get(j);
          if (localcxi != null) {
            localArrayList.add(new GroupToolItem(bu.bI(localcxi.Username, ""), bu.bI(localcxi.uuA, "")));
          }
          j += 1;
        }
        locale.field_stickToollist = e.Q(localArrayList);
        break;
      }
    }
  }
  
  public static GroupToolItem g(bv parambv)
  {
    AppMethodBeat.i(182110);
    try
    {
      k.b localb = k.b.zb(parambv.field_content);
      if (localb != null)
      {
        GroupToolItem localGroupToolItem = new GroupToolItem();
        localGroupToolItem.username = bu.bI(localb.hFc, "");
        localGroupToolItem.path = bu.bI(localb.hFb, "");
        localGroupToolItem.fOl = parambv.field_createTime;
        AppMethodBeat.o(182110);
        return localGroupToolItem;
      }
      AppMethodBeat.o(182110);
      return null;
    }
    catch (Exception parambv)
    {
      ae.e("MicroMsg.roomtools.RoomToolsHelp", "getGroupToolItemFromMsg Exception:%s %s", new Object[] { parambv.getClass().getSimpleName(), parambv.getMessage() });
      AppMethodBeat.o(182110);
    }
    return null;
  }
  
  public static boolean h(bv parambv)
  {
    AppMethodBeat.i(182111);
    if (parambv == null)
    {
      AppMethodBeat.o(182111);
      return false;
    }
    if (parambv.getType() == 436207665)
    {
      String str = parambv.field_content;
      k.b localb = null;
      if (str != null) {
        localb = k.b.aB(str, parambv.field_reserved);
      }
      if ((localb != null) && ("1001".equals(localb.hEk)))
      {
        AppMethodBeat.o(182111);
        return true;
      }
    }
    AppMethodBeat.o(182111);
    return false;
  }
  
  public static boolean i(bv parambv)
  {
    AppMethodBeat.i(185965);
    if (parambv == null)
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!x.zU(parambv.field_talker))
    {
      AppMethodBeat.o(185965);
      return false;
    }
    if (!Yr())
    {
      AppMethodBeat.o(185965);
      return false;
    }
    parambv = k.b.zb(parambv.field_content);
    if (parambv == null)
    {
      ae.d("MicroMsg.roomtools.RoomToolsHelp", "content is null");
      AppMethodBeat.o(185965);
      return false;
    }
    if ((a.b(parambv)) || (a.c(parambv)) || ("1001".equals(parambv.hEk)))
    {
      AppMethodBeat.o(185965);
      return true;
    }
    AppMethodBeat.o(185965);
    return false;
  }
  
  public static void vh(String paramString)
  {
    AppMethodBeat.i(185966);
    e locale;
    boolean bool;
    if ((Yr()) && (x.zU(paramString)))
    {
      locale = null;
      if (bu.isNullOrNil(paramString)) {
        break label141;
      }
      locale = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().vn(paramString);
      if ((locale == null) || (locale.field_queryState == 0)) {
        break label136;
      }
      locale.field_queryState = 0;
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
    }
    for (;;)
    {
      String str = bu.bI(paramString, "");
      if (locale == null) {}
      for (paramString = "null";; paramString = "not_null")
      {
        ae.i("MicroMsg.roomtools.RoomToolsHelp", "resetGroupToolsByTalker roomName:%s groupTools:%s result:%s", new Object[] { str, paramString, Boolean.valueOf(bool) });
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
  
  public static e vi(String paramString)
  {
    AppMethodBeat.i(217126);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(217126);
      return null;
    }
    e locale = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().vn(paramString);
    if (locale != null)
    {
      AppMethodBeat.o(217126);
      return locale;
    }
    locale = new e();
    locale.field_chatroomname = paramString;
    if (((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale))
    {
      paramString = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().vn(paramString);
      AppMethodBeat.o(217126);
      return paramString;
    }
    AppMethodBeat.o(217126);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.aa
 * JD-Core Version:    0.7.0.1
 */