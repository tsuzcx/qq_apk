package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class b
{
  public static final a uJG;
  
  static
  {
    AppMethodBeat.i(212107);
    uJG = new a((byte)0);
    AppMethodBeat.o(212107);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic$Companion;", "", "()V", "TAG", "", "bindConversationWithContactAsync", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "callback", "Lkotlin/Function2;", "", "conversations", "", "getConversations", "offset", "", "nextCount", "preloadSelfAvatar", "plugin-gamelife_release"})
  public static final class a
  {
    public static void a(int paramInt1, int paramInt2, m<? super Boolean, ? super List<a>, z> paramm)
    {
      AppMethodBeat.i(212104);
      p.h(paramm, "callback");
      List localList = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().dE(paramInt1, paramInt2);
      Object localObject = b.uJG;
      localObject = ((Iterable)localList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        a.b.ffl().fl(locala.field_selfUserName);
      }
      localObject = b.uJG;
      d(localList, (m)new b.a.c(paramm));
      AppMethodBeat.o(212104);
    }
    
    public static void a(a parama, m<? super Boolean, ? super a, z> paramm)
    {
      AppMethodBeat.i(212105);
      p.h(parama, "conversation");
      p.h(paramm, "callback");
      d(j.listOf(parama), (m)new b.a.a(paramm));
      AppMethodBeat.o(212105);
    }
    
    private static void d(final List<a> paramList, m<? super Boolean, ? super List<a>, z> paramm)
    {
      AppMethodBeat.i(212106);
      p.h(paramList, "conversations");
      p.h(paramm, "callback");
      if (paramList.isEmpty())
      {
        paramm.p(Boolean.TRUE, (List)d.a.v.NhH);
        AppMethodBeat.o(212106);
        return;
      }
      HashSet localHashSet = new HashSet();
      final HashMap localHashMap = new HashMap();
      Iterator localIterator = ((Iterable)paramList).iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        Object localObject = (List)localHashMap.get(locala.field_talker);
        if (localObject != null) {
          ((List)localObject).add(locala);
        }
        for (;;)
        {
          localHashSet.add(locala.field_talker);
          localHashSet.add(locala.field_selfUserName);
          break;
          localObject = b.uJG;
          localObject = (Map)localHashMap;
          String str = locala.field_talker;
          p.g(str, "it.field_talker");
          ((Map)localObject).put(str, j.mutableListOf(new a[] { locala }));
        }
      }
      ((com.tencent.mm.plugin.gamelife.a.b)g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(j.l((Iterable)localHashSet), (b.c)new b(paramm, paramList, localHashMap));
      AppMethodBeat.o(212106);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    static final class b
      implements b.c
    {
      b(m paramm, List paramList, HashMap paramHashMap) {}
      
      public final void ah(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
      {
        AppMethodBeat.i(212102);
        p.g(paramMap, "map");
        Iterator localIterator1 = paramMap.entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          paramMap = localEntry.getValue();
          p.g(paramMap, "it.value");
          if (!((com.tencent.mm.plugin.gamelife.a.a)paramMap).isValid())
          {
            ae.e("GameLife.ConversationLogic", "invalid contact, bind conversation failed!");
            this.mor.p(Boolean.FALSE, paramList);
            AppMethodBeat.o(212102);
            return;
          }
          paramMap = (List)localHashMap.get(localEntry.getKey());
          if (paramMap != null)
          {
            Iterator localIterator2 = ((Iterable)paramMap).iterator();
            while (localIterator2.hasNext())
            {
              a locala = (a)localIterator2.next();
              paramMap = localEntry.getValue();
              if (paramMap == null)
              {
                paramMap = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.contact.GameLifeContact");
                AppMethodBeat.o(212102);
                throw paramMap;
              }
              paramMap = (com.tencent.mm.plugin.gamelife.d.a)paramMap;
              p.h(paramMap, "contact");
              locala.uJE = paramMap;
              paramMap = paramMap.ddm();
              locala.nickname = paramMap.adG();
              CharSequence localCharSequence = paramMap.fuf();
              paramMap = localCharSequence;
              if (localCharSequence == null) {
                paramMap = (CharSequence)k.c(ak.getContext(), (CharSequence)locala.nickname);
              }
              locala.rTA = paramMap;
            }
          }
        }
        this.mor.p(Boolean.TRUE, paramList);
        AppMethodBeat.o(212102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.b
 * JD-Core Version:    0.7.0.1
 */