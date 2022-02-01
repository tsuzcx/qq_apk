package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class b
{
  public static final a uyd;
  
  static
  {
    AppMethodBeat.i(211338);
    uyd = new a((byte)0);
    AppMethodBeat.o(211338);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic$Companion;", "", "()V", "TAG", "", "bindConversationWithContactAsync", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "callback", "Lkotlin/Function2;", "", "conversations", "", "getConversations", "offset", "", "nextCount", "plugin-gamelife_release"})
  public static final class a
  {
    public static void a(int paramInt1, int paramInt2, m<? super Boolean, ? super List<a>, z> paramm)
    {
      AppMethodBeat.i(211335);
      p.h(paramm, "callback");
      List localList = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().dE(paramInt1, paramInt2);
      a locala = b.uyd;
      d(localList, (m)new b.a.c(paramm));
      AppMethodBeat.o(211335);
    }
    
    public static void a(a parama, m<? super Boolean, ? super a, z> paramm)
    {
      AppMethodBeat.i(211336);
      p.h(parama, "conversation");
      p.h(paramm, "callback");
      d(j.listOf(parama), (m)new b.a.a(paramm));
      AppMethodBeat.o(211336);
    }
    
    private static void d(final List<a> paramList, m<? super Boolean, ? super List<a>, z> paramm)
    {
      AppMethodBeat.i(211337);
      p.h(paramList, "conversations");
      p.h(paramm, "callback");
      if (paramList.isEmpty())
      {
        paramm.p(Boolean.TRUE, (List)d.a.v.MKE);
        AppMethodBeat.o(211337);
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
          localObject = b.uyd;
          localObject = (Map)localHashMap;
          String str = locala.field_talker;
          p.g(str, "it.field_talker");
          ((Map)localObject).put(str, j.mutableListOf(new a[] { locala }));
        }
      }
      ((com.tencent.mm.plugin.gamelife.a.b)g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(j.l((Iterable)localHashSet), (b.c)new b(paramm, paramList, localHashMap));
      AppMethodBeat.o(211337);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    static final class b
      implements b.c
    {
      b(m paramm, List paramList, HashMap paramHashMap) {}
      
      public final void ab(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
      {
        AppMethodBeat.i(211333);
        p.g(paramMap, "map");
        Iterator localIterator1 = paramMap.entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          paramMap = localEntry.getValue();
          p.g(paramMap, "it.value");
          if (!((com.tencent.mm.plugin.gamelife.a.a)paramMap).isValid())
          {
            ad.e("GameLife.ConversationLogic", "invalid contact, bind conversation failed!");
            this.mju.p(Boolean.FALSE, paramList);
            AppMethodBeat.o(211333);
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
                AppMethodBeat.o(211333);
                throw paramMap;
              }
              paramMap = (com.tencent.mm.plugin.gamelife.d.a)paramMap;
              p.h(paramMap, "contact");
              locala.uyb = paramMap;
              paramMap = paramMap.daA();
              locala.nickname = paramMap.adv();
              CharSequence localCharSequence = paramMap.fqf();
              paramMap = localCharSequence;
              if (localCharSequence == null) {
                paramMap = (CharSequence)k.c(aj.getContext(), (CharSequence)locala.nickname);
              }
              locala.rLm = paramMap;
            }
          }
        }
        this.mju.p(Boolean.TRUE, paramList);
        AppMethodBeat.o(211333);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.b
 * JD-Core Version:    0.7.0.1
 */