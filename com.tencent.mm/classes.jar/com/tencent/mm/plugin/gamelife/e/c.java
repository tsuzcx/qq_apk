package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class c
{
  public static final a ybX;
  
  static
  {
    AppMethodBeat.i(241351);
    ybX = new a((byte)0);
    AppMethodBeat.o(241351);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic$Companion;", "", "()V", "TAG", "", "bindConversationWithContactAsync", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "callback", "Lkotlin/Function2;", "", "conversations", "", "getConversations", "offset", "", "nextCount", "preloadSelfAvatar", "plugin-gamelife_release"})
  public static final class a
  {
    public static void a(int paramInt1, int paramInt2, m<? super Boolean, ? super List<a>, x> paramm)
    {
      AppMethodBeat.i(241348);
      p.h(paramm, "callback");
      List localList = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage().dP(paramInt1, paramInt2);
      Object localObject = c.ybX;
      localObject = ((Iterable)localList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        a.b.gov().fZ(locala.field_selfUserName);
      }
      localObject = c.ybX;
      d(localList, (m)new c.a.c(paramm));
      AppMethodBeat.o(241348);
    }
    
    public static void a(a parama, m<? super Boolean, ? super a, x> paramm)
    {
      AppMethodBeat.i(241349);
      p.h(parama, "conversation");
      p.h(paramm, "callback");
      d(j.listOf(parama), (m)new c.a.a(paramm));
      AppMethodBeat.o(241349);
    }
    
    private static void d(final List<a> paramList, m<? super Boolean, ? super List<a>, x> paramm)
    {
      AppMethodBeat.i(241350);
      p.h(paramList, "conversations");
      p.h(paramm, "callback");
      if (paramList.isEmpty())
      {
        paramm.invoke(Boolean.TRUE, (List)v.SXr);
        AppMethodBeat.o(241350);
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
          localObject = c.ybX;
          localObject = (Map)localHashMap;
          String str = locala.field_talker;
          p.g(str, "it.field_talker");
          ((Map)localObject).put(str, j.mutableListOf(new a[] { locala }));
        }
      }
      ((b)g.af(b.class)).a(j.p((Iterable)localHashSet), (b.c)new b(paramm, paramList, localHashMap));
      AppMethodBeat.o(241350);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    static final class b
      implements b.c
    {
      b(m paramm, List paramList, HashMap paramHashMap) {}
      
      public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
      {
        AppMethodBeat.i(241346);
        p.g(paramMap, "map");
        Iterator localIterator1 = paramMap.entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          paramMap = localEntry.getValue();
          p.g(paramMap, "it.value");
          if (!((com.tencent.mm.plugin.gamelife.a.a)paramMap).isValid())
          {
            Log.e("GameLife.ConversationLogic", "invalid contact, bind conversation failed!");
            this.nzd.invoke(Boolean.FALSE, paramList);
            AppMethodBeat.o(241346);
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
                AppMethodBeat.o(241346);
                throw paramMap;
              }
              paramMap = (com.tencent.mm.plugin.gamelife.d.a)paramMap;
              p.h(paramMap, "contact");
              locala.ybV = paramMap;
              paramMap = paramMap.dWW();
              locala.nickname = paramMap.arJ();
              CharSequence localCharSequence = paramMap.gBL();
              paramMap = localCharSequence;
              if (localCharSequence == null) {
                paramMap = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)locala.nickname);
              }
              locala.tyr = paramMap;
            }
          }
        }
        this.nzd.invoke(Boolean.TRUE, paramList);
        AppMethodBeat.o(241346);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.c
 * JD-Core Version:    0.7.0.1
 */