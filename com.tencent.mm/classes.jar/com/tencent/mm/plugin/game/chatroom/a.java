package com.tencent.mm.plugin.game.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMemberInfoResponse;
import com.tencent.mm.plugin.game.chatroom.c.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.plugin.game.chatroom.b.b
{
  private Map<String, com.tencent.mm.plugin.game.chatroom.b.c> ctm;
  
  public a()
  {
    AppMethodBeat.i(275622);
    this.ctm = new ConcurrentHashMap();
    AppMethodBeat.o(275622);
  }
  
  private void b(final List<String> paramList, final com.tencent.mm.plugin.game.chatroom.b.b.a parama)
  {
    AppMethodBeat.i(275630);
    if (Util.isNullOrNil(paramList))
    {
      if (parama != null) {
        parama.onDone(null);
      }
      AppMethodBeat.o(275630);
      return;
    }
    final HashMap localHashMap = new HashMap();
    new d(new LinkedList(paramList)).bFJ().j(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(275630);
  }
  
  public final void a(ChatroomUserData paramChatroomUserData)
  {
    AppMethodBeat.i(275666);
    if (((PluginGameChatRoom)h.az(PluginGameChatRoom.class)).getContactStorage().a(c.b(paramChatroomUserData))) {
      this.ctm.put(paramChatroomUserData.username, ((PluginGameChatRoom)h.az(PluginGameChatRoom.class)).getContactStorage().aFv(paramChatroomUserData.username));
    }
    AppMethodBeat.o(275666);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.game.chatroom.b.b.a parama)
  {
    AppMethodBeat.i(275655);
    a(Arrays.asList(new String[] { paramString }), parama);
    AppMethodBeat.o(275655);
  }
  
  public final void a(List<String> paramList, final com.tencent.mm.plugin.game.chatroom.b.b.a parama)
  {
    AppMethodBeat.i(275651);
    parama = new com.tencent.mm.plugin.game.chatroom.b.b.a()
    {
      public final void onDone(Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramAnonymousMap)
      {
        AppMethodBeat.i(275647);
        Object localObject = paramAnonymousMap;
        if (paramAnonymousMap == null) {
          localObject = new HashMap();
        }
        if (parama != null) {
          parama.onDone((Map)localObject);
        }
        if (localObject != null) {
          a.a(a.this, ((Map)localObject).values());
        }
        AppMethodBeat.o(275647);
      }
    };
    final HashMap localHashMap = new HashMap();
    if (Util.isNullOrNil(paramList))
    {
      parama.onDone(localHashMap);
      AppMethodBeat.o(275651);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (String)paramList.next();
      localObject2 = (com.tencent.mm.plugin.game.chatroom.b.c)this.ctm.get(localObject1);
      if (localObject2 != null) {
        localHashMap.put(localObject1, localObject2);
      } else {
        localLinkedList.add(localObject1);
      }
    }
    if (Util.isNullOrNil(localLinkedList))
    {
      parama.onDone(localHashMap);
      AppMethodBeat.o(275651);
      return;
    }
    paramList = ((PluginGameChatRoom)h.az(PluginGameChatRoom.class)).getContactStorage().ij(localLinkedList);
    localHashMap.putAll(paramList);
    paramList = paramList.entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject1 = (Map.Entry)paramList.next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      if (localLinkedList.contains(localObject2))
      {
        localLinkedList.remove(localObject2);
        this.ctm.put(localObject2, (com.tencent.mm.plugin.game.chatroom.b.c)((Map.Entry)localObject1).getValue());
      }
    }
    if (Util.isNullOrNil(localLinkedList))
    {
      parama.onDone(localHashMap);
      AppMethodBeat.o(275651);
      return;
    }
    b(localLinkedList, new com.tencent.mm.plugin.game.chatroom.b.b.a()
    {
      public final void onDone(Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramAnonymousMap)
      {
        AppMethodBeat.i(275635);
        if (paramAnonymousMap != null) {
          localHashMap.putAll(paramAnonymousMap);
        }
        parama.onDone(localHashMap);
        AppMethodBeat.o(275635);
      }
    });
    AppMethodBeat.o(275651);
  }
  
  public final com.tencent.mm.plugin.game.chatroom.b.c aFo(String paramString)
  {
    AppMethodBeat.i(275660);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(275660);
      return null;
    }
    com.tencent.mm.plugin.game.chatroom.b.c localc = (com.tencent.mm.plugin.game.chatroom.b.c)this.ctm.get(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(275660);
      return localc;
    }
    localc = ((PluginGameChatRoom)h.az(PluginGameChatRoom.class)).getContactStorage().aFv(paramString);
    if (localc != null) {
      this.ctm.put(paramString, localc);
    }
    AppMethodBeat.o(275660);
    return localc;
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(275677);
    ((PluginGameChatRoom)h.az(PluginGameChatRoom.class)).getContactStorage().remove(paramIOnStorageChange);
    AppMethodBeat.o(275677);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(275671);
    ((PluginGameChatRoom)h.az(PluginGameChatRoom.class)).getContactStorage().add(paramIOnStorageChange);
    AppMethodBeat.o(275671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.a
 * JD-Core Version:    0.7.0.1
 */