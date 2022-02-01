package com.tencent.mm.plugin.gamelife.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic;", "", "()V", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a Jbt;
  
  static
  {
    AppMethodBeat.i(268127);
    Jbt = new a((byte)0);
    AppMethodBeat.o(268127);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic$Companion;", "", "()V", "TAG", "", "bindConversationWithContactAsync", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "callback", "Lkotlin/Function2;", "", "conversations", "", "getConversations", "offset", "", "nextCount", "preloadSelfAvatar", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(int paramInt1, int paramInt2, m<? super Boolean, ? super List<a>, ah> paramm)
    {
      AppMethodBeat.i(268115);
      s.u(paramm, "callback");
      List localList = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage().fg(paramInt1, paramInt2);
      Object localObject = c.Jbt;
      localObject = ((Iterable)localList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        a.b.iKa().loadBitmap(locala.field_selfUserName);
      }
      localObject = c.Jbt;
      d(localList, (m)new c.a.b(paramm));
      AppMethodBeat.o(268115);
    }
    
    public static void a(a parama, m<? super Boolean, ? super a, ah> paramm)
    {
      AppMethodBeat.i(268121);
      s.u(parama, "conversation");
      s.u(paramm, "callback");
      d(kotlin.a.p.listOf(parama), (m)new c.a.a(paramm));
      AppMethodBeat.o(268121);
    }
    
    private static final void a(m paramm, List paramList, HashMap paramHashMap, Map paramMap)
    {
      AppMethodBeat.i(268193);
      s.u(paramm, "$callback");
      s.u(paramList, "$conversations");
      s.u(paramHashMap, "$conversationMap");
      s.s(paramMap, "map");
      Iterator localIterator1 = paramMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        if (!((com.tencent.mm.plugin.gamelife.a.a)localEntry.getValue()).isValid())
        {
          Log.e("GameLife.ConversationLogic", "invalid contact, bind conversation failed!");
          paramm.invoke(Boolean.FALSE, paramList);
          AppMethodBeat.o(268193);
          return;
        }
        paramMap = (List)paramHashMap.get(localEntry.getKey());
        if (paramMap != null)
        {
          Iterator localIterator2 = ((Iterable)paramMap).iterator();
          while (localIterator2.hasNext())
          {
            a locala = (a)localIterator2.next();
            paramMap = localEntry.getValue();
            if (paramMap == null)
            {
              paramm = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.contact.GameLifeContact");
              AppMethodBeat.o(268193);
              throw paramm;
            }
            paramMap = (com.tencent.mm.plugin.gamelife.e.a)paramMap;
            s.u(paramMap, "contact");
            locala.Jbs = paramMap;
            paramMap = paramMap.bSb();
            locala.nickname = paramMap.aSV();
            CharSequence localCharSequence = paramMap.acDG;
            paramMap = localCharSequence;
            if (localCharSequence == null) {
              paramMap = (CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)locala.nickname);
            }
            locala.AFy = paramMap;
          }
        }
      }
      paramm.invoke(Boolean.TRUE, paramList);
      AppMethodBeat.o(268193);
    }
    
    private static void d(List<a> paramList, m<? super Boolean, ? super List<a>, ah> paramm)
    {
      AppMethodBeat.i(268178);
      s.u(paramList, "conversations");
      s.u(paramm, "callback");
      if (paramList.isEmpty())
      {
        paramm.invoke(Boolean.TRUE, (List)ab.aivy);
        AppMethodBeat.o(268178);
        return;
      }
      HashSet localHashSet = new HashSet();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((Iterable)paramList).iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        Object localObject = (List)localHashMap.get(locala.field_talker);
        if (localObject == null) {}
        for (localObject = null;; localObject = Boolean.valueOf(((List)localObject).add(locala)))
        {
          if (localObject == null)
          {
            localObject = c.Jbt;
            localObject = (Map)localHashMap;
            String str = locala.field_talker;
            s.s(str, "it.field_talker");
            ((Map)localObject).put(str, kotlin.a.p.mutableListOf(new a[] { locala }));
          }
          localHashSet.add(locala.field_talker);
          localHashSet.add(locala.field_selfUserName);
          break;
        }
      }
      ((b)h.ax(b.class)).a(kotlin.a.p.p((Iterable)localHashSet), new c.a..ExternalSyntheticLambda0(paramm, paramList, localHashMap));
      AppMethodBeat.o(268178);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.c
 * JD-Core Version:    0.7.0.1
 */