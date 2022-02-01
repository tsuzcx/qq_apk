package com.tencent.mm.plugin.game.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMemberInfoResponse;
import com.tencent.mm.plugin.game.chatroom.b.b.a;
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
  private Map<String, com.tencent.mm.plugin.game.chatroom.b.c> axy;
  
  public a()
  {
    AppMethodBeat.i(211402);
    this.axy = new ConcurrentHashMap();
    AppMethodBeat.o(211402);
  }
  
  private void b(final List<String> paramList, final b.a parama)
  {
    AppMethodBeat.i(211419);
    if (Util.isNullOrNil(paramList))
    {
      if (parama != null) {
        parama.ac(null);
      }
      AppMethodBeat.o(211419);
      return;
    }
    final HashMap localHashMap = new HashMap();
    new com.tencent.mm.plugin.game.chatroom.c.c(new LinkedList(paramList)).bhW().j(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(211419);
  }
  
  public final void a(ChatroomUserData paramChatroomUserData)
  {
    AppMethodBeat.i(211413);
    if (((PluginGameChatRoom)h.ag(PluginGameChatRoom.class)).getContactStorage().a(c.b(paramChatroomUserData))) {
      this.axy.put(paramChatroomUserData.username, ((PluginGameChatRoom)h.ag(PluginGameChatRoom.class)).getContactStorage().aIR(paramChatroomUserData.username));
    }
    AppMethodBeat.o(211413);
  }
  
  public final void a(String paramString, b.a parama)
  {
    AppMethodBeat.i(211408);
    a(Arrays.asList(new String[] { paramString }), parama);
    AppMethodBeat.o(211408);
  }
  
  public final void a(List<String> paramList, final b.a parama)
  {
    AppMethodBeat.i(211405);
    parama = new b.a()
    {
      public final void ac(Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramAnonymousMap)
      {
        AppMethodBeat.i(211976);
        Object localObject = paramAnonymousMap;
        if (paramAnonymousMap == null) {
          localObject = new HashMap();
        }
        if (parama != null) {
          parama.ac((Map)localObject);
        }
        if (localObject != null) {
          a.a(a.this, ((Map)localObject).values());
        }
        AppMethodBeat.o(211976);
      }
    };
    final HashMap localHashMap = new HashMap();
    if (Util.isNullOrNil(paramList))
    {
      parama.ac(localHashMap);
      AppMethodBeat.o(211405);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (String)paramList.next();
      localObject2 = (com.tencent.mm.plugin.game.chatroom.b.c)this.axy.get(localObject1);
      if (localObject2 != null) {
        localHashMap.put(localObject1, localObject2);
      } else {
        localLinkedList.add(localObject1);
      }
    }
    if (Util.isNullOrNil(localLinkedList))
    {
      parama.ac(localHashMap);
      AppMethodBeat.o(211405);
      return;
    }
    paramList = ((PluginGameChatRoom)h.ag(PluginGameChatRoom.class)).getContactStorage().fr(localLinkedList);
    localHashMap.putAll(paramList);
    paramList = paramList.entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject1 = (Map.Entry)paramList.next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      if (localLinkedList.contains(localObject2))
      {
        localLinkedList.remove(localObject2);
        this.axy.put(localObject2, ((Map.Entry)localObject1).getValue());
      }
    }
    if (Util.isNullOrNil(localLinkedList))
    {
      parama.ac(localHashMap);
      AppMethodBeat.o(211405);
      return;
    }
    b(localLinkedList, new b.a()
    {
      public final void ac(Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramAnonymousMap)
      {
        AppMethodBeat.i(212370);
        if (paramAnonymousMap != null) {
          localHashMap.putAll(paramAnonymousMap);
        }
        parama.ac(localHashMap);
        AppMethodBeat.o(212370);
      }
    });
    AppMethodBeat.o(211405);
  }
  
  public final com.tencent.mm.plugin.game.chatroom.b.c aIN(String paramString)
  {
    AppMethodBeat.i(211411);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(211411);
      return null;
    }
    com.tencent.mm.plugin.game.chatroom.b.c localc = (com.tencent.mm.plugin.game.chatroom.b.c)this.axy.get(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(211411);
      return localc;
    }
    localc = ((PluginGameChatRoom)h.ag(PluginGameChatRoom.class)).getContactStorage().aIR(paramString);
    if (localc != null) {
      this.axy.put(paramString, localc);
    }
    AppMethodBeat.o(211411);
    return localc;
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(211417);
    ((PluginGameChatRoom)h.ag(PluginGameChatRoom.class)).getContactStorage().remove(paramIOnStorageChange);
    AppMethodBeat.o(211417);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(211415);
    ((PluginGameChatRoom)h.ag(PluginGameChatRoom.class)).getContactStorage().add(paramIOnStorageChange);
    AppMethodBeat.o(211415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.a
 * JD-Core Version:    0.7.0.1
 */