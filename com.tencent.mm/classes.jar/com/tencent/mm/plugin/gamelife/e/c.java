package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class c
{
  public static final a DhC;
  
  static
  {
    AppMethodBeat.i(203079);
    DhC = new a((byte)0);
    AppMethodBeat.o(203079);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic$Companion;", "", "()V", "TAG", "", "bindConversationWithContactAsync", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "callback", "Lkotlin/Function2;", "", "conversations", "", "getConversations", "offset", "", "nextCount", "preloadSelfAvatar", "plugin-gamelife_release"})
  public static final class a
  {
    public static void a(int paramInt1, int paramInt2, m<? super Boolean, ? super List<a>, x> paramm)
    {
      AppMethodBeat.i(203775);
      p.k(paramm, "callback");
      List localList = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage().en(paramInt1, paramInt2);
      Object localObject = c.DhC;
      localObject = ((Iterable)localList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        a.b.hjf().gJ(locala.field_selfUserName);
      }
      localObject = c.DhC;
      d(localList, (m)new c(paramm));
      AppMethodBeat.o(203775);
    }
    
    public static void a(a parama, m<? super Boolean, ? super a, x> paramm)
    {
      AppMethodBeat.i(203778);
      p.k(parama, "conversation");
      p.k(paramm, "callback");
      d(j.listOf(parama), (m)new a(paramm));
      AppMethodBeat.o(203778);
    }
    
    private static void d(final List<a> paramList, m<? super Boolean, ? super List<a>, x> paramm)
    {
      AppMethodBeat.i(203786);
      p.k(paramList, "conversations");
      p.k(paramm, "callback");
      if (paramList.isEmpty())
      {
        paramm.invoke(Boolean.TRUE, (List)v.aaAd);
        AppMethodBeat.o(203786);
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
          localObject = c.DhC;
          localObject = (Map)localHashMap;
          String str = locala.field_talker;
          p.j(str, "it.field_talker");
          ((Map)localObject).put(str, j.mutableListOf(new a[] { locala }));
        }
      }
      ((b)h.ae(b.class)).a(j.p((Iterable)localHashSet), (b.c)new b(paramm, paramList, localHashMap));
      AppMethodBeat.o(203786);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "result", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "invoke"})
    static final class a
      extends q
      implements m<Boolean, List<? extends a>, x>
    {
      a(m paramm)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    static final class b
      implements b.c
    {
      b(m paramm, List paramList, HashMap paramHashMap) {}
      
      public final void ac(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
      {
        AppMethodBeat.i(203009);
        p.j(paramMap, "map");
        Iterator localIterator1 = paramMap.entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          paramMap = localEntry.getValue();
          p.j(paramMap, "it.value");
          if (!((com.tencent.mm.plugin.gamelife.a.a)paramMap).isValid())
          {
            Log.e("GameLife.ConversationLogic", "invalid contact, bind conversation failed!");
            this.qBo.invoke(Boolean.FALSE, paramList);
            AppMethodBeat.o(203009);
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
                paramMap = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.contact.GameLifeContact");
                AppMethodBeat.o(203009);
                throw paramMap;
              }
              paramMap = (com.tencent.mm.plugin.gamelife.d.a)paramMap;
              p.k(paramMap, "contact");
              locala.DhA = paramMap;
              paramMap = paramMap.eAf();
              locala.nickname = paramMap.ays();
              CharSequence localCharSequence = paramMap.hxW();
              paramMap = localCharSequence;
              if (localCharSequence == null) {
                paramMap = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)locala.nickname);
              }
              locala.xgc = paramMap;
            }
          }
        }
        this.qBo.invoke(Boolean.TRUE, paramList);
        AppMethodBeat.o(203009);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "result", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "invoke", "com/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic$Companion$getConversations$1$1"})
    static final class c
      extends q
      implements m<Boolean, List<? extends a>, x>
    {
      c(m paramm)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.c
 * JD-Core Version:    0.7.0.1
 */