package com.tencent.mm.plugin.groupsolitaire.b;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  private static final f<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> fAs;
  
  static
  {
    AppMethodBeat.i(110365);
    fAs = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(110365);
  }
  
  public static boolean Q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(192990);
    paramString2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hb(paramString1, paramString2);
    paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().aif(paramString1);
    if (paramString2 == null)
    {
      AppMethodBeat.o(192990);
      return true;
    }
    boolean bool;
    if (paramString1 == null) {
      bool = true;
    }
    while ((!bool) && (bs.lr(paramString2.field_creator, u.axw())) && (paramInt <= 1))
    {
      AppMethodBeat.o(192990);
      return true;
      int i;
      if ((paramString2.field_active == 1) && (paramString2.field_lastActiveTime >= paramString1.tyn) && (paramString2.tyS.size() < cSg()))
      {
        i = 1;
        label121:
        if ((paramString2.field_active != 0) || (paramString2.field_lastActiveTime < paramString1.typ)) {
          break label163;
        }
      }
      label163:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          break label169;
        }
        bool = true;
        break;
        i = 0;
        break label121;
      }
      label169:
      bool = false;
    }
    AppMethodBeat.o(192990);
    return bool;
  }
  
  public static com.tencent.mm.plugin.groupsolitaire.c.a a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, com.tencent.mm.plugin.groupsolitaire.c.a parama3)
  {
    AppMethodBeat.i(178794);
    if ((parama1 == null) && (parama3 == null))
    {
      AppMethodBeat.o(178794);
      return null;
    }
    if ((parama1 == null) && (parama3 != null))
    {
      AppMethodBeat.o(178794);
      return parama3;
    }
    if ((parama1 != null) && (parama3 == null))
    {
      AppMethodBeat.o(178794);
      return parama1;
    }
    if (!bs.lr(parama1.field_key, parama3.field_key))
    {
      AppMethodBeat.o(178794);
      return parama1;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = parama3.cSn();
    Object localObject1 = new LinkedHashSet();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject2 = new LinkedHashSet();
    Object localObject3 = new LinkedHashSet();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    if (i <= parama3.tyS.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = ((com.tencent.mm.plugin.groupsolitaire.c.b)parama3.tyS.get(Integer.valueOf(i))).cSo();
      if (bs.lr(localb.username, u.axw()))
      {
        localLinkedHashSet.add(localb);
        localHashMap.put(localb.content, localb);
        localArrayList.add(localb);
      }
      for (;;)
      {
        i += 1;
        break;
        ((Set)localObject1).add(localb);
      }
    }
    if (parama2 != null)
    {
      i = 1;
      while (i <= parama2.tyS.size())
      {
        ((Set)localObject3).add(((com.tencent.mm.plugin.groupsolitaire.c.b)parama2.tyS.get(Integer.valueOf(i))).cSo());
        i += 1;
      }
    }
    i = 1;
    while (i <= parama1.tyS.size())
    {
      parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.tyS.get(Integer.valueOf(i));
      if ((!((Set)localObject1).contains(parama2)) && ((!((Set)localObject3).contains(parama2)) || (localLinkedHashSet.contains(parama2)))) {
        ((Set)localObject2).add(parama2);
      }
      i += 1;
    }
    parama2 = ((Set)localObject2).iterator();
    while (parama2.hasNext())
    {
      parama3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama2.next();
      if (localLinkedHashSet.contains(parama3)) {
        localArrayList.remove(parama3);
      }
    }
    parama3 = ((Set)localObject2).iterator();
    while (parama3.hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama3.next();
      if (localLinkedHashSet.contains(localObject2))
      {
        parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)localHashMap.get(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content);
        if (parama2 == null) {
          ((Set)localObject1).add(localObject2);
        } else {
          ((Set)localObject1).add(parama2);
        }
      }
      else
      {
        localObject3 = localArrayList.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)((Iterator)localObject3).next();
        } while (!bs.jl(parama2.tyW, ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).tyW));
      }
    }
    for (;;)
    {
      if (parama2 == null)
      {
        ((Set)localObject1).add(localObject2);
        break;
      }
      localArrayList.remove(parama2);
      parama2.content = ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content;
      ((Set)localObject1).add(parama2);
      break;
      locala.tyS.clear();
      parama2 = new ArrayList();
      parama3 = ((Set)localObject1).iterator();
      while (parama3.hasNext()) {
        parama2.add((com.tencent.mm.plugin.groupsolitaire.c.b)parama3.next());
      }
      Collections.sort(parama2, new Comparator() {});
      parama2 = parama2.iterator();
      i = 0;
      while (parama2.hasNext())
      {
        parama3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama2.next();
        localObject1 = locala.tyS;
        i += 1;
        ((HashMap)localObject1).put(Integer.valueOf(i), parama3);
      }
      locala.tyU = parama1.tyU;
      AppMethodBeat.o(178794);
      return locala;
      parama2 = null;
    }
  }
  
  public static com.tencent.mm.plugin.groupsolitaire.c.a a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, String paramString)
  {
    AppMethodBeat.i(110348);
    parama1 = a(parama1, parama2, paramString, true, false);
    AppMethodBeat.o(110348);
    return parama1;
  }
  
  public static com.tencent.mm.plugin.groupsolitaire.c.a a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, String paramString, int paramInt)
  {
    AppMethodBeat.i(174561);
    if ((parama1 == null) || (parama2 == null))
    {
      AppMethodBeat.o(174561);
      return parama2;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYW, 1);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLossEfficacySwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(174561);
      return parama2;
    }
    if (paramInt == 1)
    {
      if (!bs.lr(paramString, parama2.field_creator))
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
      if (parama1.tyS.size() > 1)
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
    }
    else if (paramInt != 2)
    {
      if (paramInt == 3)
      {
        if (!parama1.tyR)
        {
          AppMethodBeat.o(174561);
          return parama2;
        }
      }
      else
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
    }
    parama1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage();
    boolean bool;
    if (parama2 == null) {
      bool = true;
    }
    for (;;)
    {
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "handleSolitatireLossEfficacy key:%s result:%s", new Object[] { parama2.field_key, Boolean.valueOf(bool) });
      AppMethodBeat.o(174561);
      return null;
      bool = parama1.delete(parama2.systemRowid);
      if (bool) {
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hc(parama2.field_username, parama2.field_key);
      }
    }
  }
  
  private static com.tencent.mm.plugin.groupsolitaire.c.a a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(192993);
    if ((parama1 == null) && (parama2 == null))
    {
      AppMethodBeat.o(192993);
      return null;
    }
    if ((parama1 == null) && (parama2 != null))
    {
      AppMethodBeat.o(192993);
      return parama2;
    }
    if ((parama1 != null) && (parama2 == null))
    {
      AppMethodBeat.o(192993);
      return parama1;
    }
    if (!bs.lr(parama1.field_key, parama2.field_key))
    {
      AppMethodBeat.o(192993);
      return parama1;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = parama2.cSn();
    Object localObject1 = new LinkedHashSet();
    if (paramBoolean2) {
      while (i <= parama1.tyS.size())
      {
        parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.tyS.get(Integer.valueOf(i));
        if (!((Set)localObject1).contains(parama2)) {
          ((Set)localObject1).add(parama2);
        }
        i += 1;
      }
    }
    Object localObject2 = new HashSet();
    HashMap localHashMap = new HashMap();
    i = 1;
    if (i <= parama2.tyS.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama2.tyS.get(Integer.valueOf(i));
      if (!bs.lr(localb.username, paramString)) {
        ((Set)localObject1).add(localb);
      }
      for (;;)
      {
        i += 1;
        break;
        ((Set)localObject2).add(localb);
        localHashMap.put(localb.content, localb);
      }
    }
    i = 1;
    if (i <= parama1.tyS.size())
    {
      parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.tyS.get(Integer.valueOf(i));
      if ((!((Set)localObject1).contains(parama2)) && (bs.lr(parama2.username, paramString)))
      {
        if (!paramBoolean1) {
          break label338;
        }
        ((Set)localObject1).add(parama2);
      }
      for (;;)
      {
        i += 1;
        break;
        label338:
        localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)localHashMap.get(parama2.content);
        if (localObject2 == null) {
          ((Set)localObject1).add(parama2);
        } else {
          ((Set)localObject1).add(localObject2);
        }
      }
    }
    locala.tyS.clear();
    parama2 = new ArrayList();
    paramString = ((Set)localObject1).iterator();
    while (paramString.hasNext()) {
      parama2.add((com.tencent.mm.plugin.groupsolitaire.c.b)paramString.next());
    }
    Collections.sort(parama2, new Comparator() {});
    parama2 = parama2.iterator();
    i = 0;
    while (parama2.hasNext())
    {
      paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama2.next();
      localObject1 = locala.tyS;
      i += 1;
      ((HashMap)localObject1).put(Integer.valueOf(i), paramString);
    }
    locala.tyU = parama1.tyU;
    AppMethodBeat.o(192993);
    return locala;
  }
  
  private static brb a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.b paramb, int paramInt)
  {
    AppMethodBeat.i(192995);
    brb localbrb = new brb();
    localbrb.Fgi = (paramInt + paramString2 + " ");
    a(localbrb, paramString1, paramb.content);
    AppMethodBeat.o(192995);
    return localbrb;
  }
  
  public static String a(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110334);
    if ((bs.isNullOrNil(parama.header)) && (bs.isNullOrNil(parama.tyO)) && (bs.isNullOrNil(parama.tyP)) && (parama.tyQ == 1))
    {
      parama.tyQ = 0;
      if (parama.tyS.size() > 0)
      {
        parama.header = ((com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(1))).content;
        ((com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(1))).tyV = 1;
      }
    }
    parama = com.tencent.mm.b.g.getMessageDigest(ai.getContext().getString(2131760100, new Object[] { parama.header.trim(), parama.tyQ, parama.tyO.trim(), parama.tyP.trim() }).getBytes());
    AppMethodBeat.o(110334);
    return parama;
  }
  
  public static String a(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(174560);
    if (parama == null)
    {
      AppMethodBeat.o(174560);
      return "";
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("<solitaire_info>");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("<solitaire>");
    localStringBuilder2.append("<tt>").append(gY(paramString, parama.header)).append("</tt>");
    localStringBuilder2.append("<ex>").append(gY(paramString, parama.tyO)).append("</ex>");
    localStringBuilder2.append("<tl>").append(gY(paramString, parama.tyP)).append("</tl>");
    localStringBuilder2.append("<s>").append(bs.aLw(parama.separator)).append("</s>");
    localStringBuilder2.append("<au>").append(parama.field_creator).append("</au>");
    localStringBuilder2.append("<hrt>").append(parama.tyQ).append("</hrt>");
    Object localObject = localStringBuilder2.append("<loss>");
    int i;
    label285:
    Pair localPair;
    if (paramBoolean)
    {
      i = 1;
      ((StringBuilder)localObject).append(i).append("</loss>");
      localStringBuilder2.append("<content>");
      localStringBuilder2.append("<s>").append(parama.tyS.size()).append("</s>");
      i = j;
      if (i > parama.tyS.size()) {
        break label510;
      }
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i));
      if (localObject != null)
      {
        localStringBuilder2.append("<i>");
        localStringBuilder2.append("<u>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).username).append("</u>");
        localStringBuilder2.append("<h>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).tyV).append("</h>");
        localStringBuilder2.append("<s>").append(bs.aLw(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).separator)).append("</s>");
        localStringBuilder2.append("<t>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).createtime).append("</t>");
        localPair = gX(paramString, ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content);
        if (localPair != null) {
          break label484;
        }
        localStringBuilder2.append("<c>").append(bs.aLw(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content)).append("</c>");
      }
    }
    for (;;)
    {
      localStringBuilder2.append("</i>");
      i += 1;
      break label285;
      i = 0;
      break;
      label484:
      localStringBuilder2.append("<r>").append(c(localPair)).append("</r>");
    }
    label510:
    localStringBuilder2.append("</content>");
    localStringBuilder2.append("</solitaire>");
    localStringBuilder1.append("<![CDATA[").append(localStringBuilder2.toString()).append("]]>");
    localStringBuilder1.append("</solitaire_info>");
    paramString = localStringBuilder1.toString();
    AppMethodBeat.o(174560);
    return paramString;
  }
  
  public static void a(long paramLong, String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(192994);
    if (parama == null)
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: groupSolitatire is null");
      AppMethodBeat.o(192994);
      return;
    }
    bo localbo;
    Object localObject3;
    bra localbra;
    Object localObject1;
    if (paramLong != 0L)
    {
      localbo = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(paramLong);
      localObject3 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(parama.field_username, parama.field_key, false);
      localbra = new bra();
      if (localbo.isText()) {
        localObject1 = localbo.field_content;
      }
    }
    for (;;)
    {
      if (bs.isNullOrNil((String)localObject1))
      {
        ac.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: content is null");
        AppMethodBeat.o(192994);
        return;
        if (localbo.fbM())
        {
          localObject1 = k.b.vA(localbo.field_content);
          if (localObject1 == null)
          {
            ac.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: amc is null");
            AppMethodBeat.o(192994);
            return;
          }
          localObject1 = ((k.b)localObject1).title;
        }
      }
      else
      {
        Object localObject2;
        int i;
        if (localObject3 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).separator;
          if ((parama == null) || (localObject3 == null))
          {
            if (parama.tyQ != 0) {
              break label1045;
            }
            i = 2;
          }
        }
        for (;;)
        {
          if (i <= parama.tyS.size())
          {
            localObject3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i));
            if ((!bs.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content)) && (!bs.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content.trim())))
            {
              ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content = ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content.trim();
              if (bs.lr(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).username, paramString)) {
                localbra.Fgf.add(a((String)localObject1, (String)localObject2, (com.tencent.mm.plugin.groupsolitaire.c.b)localObject3, i));
              }
            }
            i += 1;
            continue;
            LinkedHashSet localLinkedHashSet = new LinkedHashSet();
            i = 1;
            while (i <= ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).tyS.size())
            {
              com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).tyS.get(Integer.valueOf(i));
              if ((localb != null) && (bs.lr(localb.username, paramString))) {
                localLinkedHashSet.add(localb);
              }
              i += 1;
            }
            i = 1;
            if (i <= parama.tyS.size())
            {
              localObject3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i));
              if (localObject3 != null) {
                if (!localLinkedHashSet.contains(localObject3)) {
                  break label455;
                }
              }
              label455:
              for (((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).username = paramString;; ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).username = "")
              {
                i += 1;
                break;
              }
            }
            break;
            localObject2 = parama.separator;
            break;
          }
          if (localbra.Fgf.size() <= 0)
          {
            paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(parama.tyS.size()));
            localbra.Fgf.add(a((String)localObject1, (String)localObject2, paramString, parama.tyS.size()));
          }
          if (parama.tyQ == 0) {}
          for (i = parama.tyS.size() - localbra.Fgf.size() - 1; i < 2; i = parama.tyS.size() - localbra.Fgf.size())
          {
            ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg fold condition min num is not");
            AppMethodBeat.o(192994);
            return;
          }
          localbra.tyQ = parama.tyQ;
          localbra.Fgh = (parama.tyS.size() - localbra.Fgf.size());
          localbra.dpl = parama.field_msgSvrId;
          localbra.key = parama.field_key;
          if (parama.tyQ == 0)
          {
            paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(1));
            localbra.Fge.add(a((String)localObject1, (String)localObject2, paramString, 1));
          }
          for (;;)
          {
            if ((parama.tyP != null) && (!bs.isNullOrNil(parama.tyP.trim())))
            {
              paramString = new brb();
              a(paramString, (String)localObject1, parama.tyP.trim());
              localbra.Fgg = paramString;
            }
            localbo.field_solitaireFoldInfo = localbra;
            localbo.eRU = true;
            try
            {
              ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(localbo.field_msgId, localbo);
              ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId:%s", new Object[] { Long.valueOf(localbo.field_msgId) });
              AppMethodBeat.o(192994);
              return;
              if ((parama.header != null) && (!bs.isNullOrNil(parama.header.trim())))
              {
                paramString = new brb();
                a(paramString, (String)localObject1, parama.header.trim());
                localbra.Fge.add(paramString);
              }
              if ((parama.tyO != null) && (!bs.isNullOrNil(parama.tyO.trim())))
              {
                paramString = gX((String)localObject1, parama.tyO.trim());
                localObject2 = new brb();
                if (paramString == null) {
                  ((brb)localObject2).start = 0;
                }
                for (((brb)localObject2).end = 0;; ((brb)localObject2).end = (((Integer)paramString.second).intValue() + i))
                {
                  localbra.Fge.add(localObject2);
                  break;
                  if (localbra.Fge.size() > 0) {
                    ((brb)localObject2).Fgi = "\n";
                  }
                  ((brb)localObject2).start = ((Integer)paramString.first).intValue();
                  i = ((Integer)paramString.first).intValue();
                }
              }
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                ac.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
              }
            }
          }
          ac.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId == 0");
          AppMethodBeat.o(192994);
          return;
          label1045:
          i = 1;
        }
      }
      localObject1 = "";
    }
  }
  
  private static void a(brb parambrb, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192996);
    paramString1 = gX(paramString1, paramString2);
    if (paramString1 == null)
    {
      parambrb.start = 0;
      parambrb.end = 0;
      AppMethodBeat.o(192996);
      return;
    }
    parambrb.start = ((Integer)paramString1.first).intValue();
    int i = ((Integer)paramString1.first).intValue();
    parambrb.end = (((Integer)paramString1.second).intValue() + i);
    AppMethodBeat.o(192996);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110346);
    if (parama == null)
    {
      AppMethodBeat.o(110346);
      return;
    }
    String str = u.axw();
    if (bs.isNullOrNil(parama.field_creator)) {
      parama.field_creator = str;
    }
    if (bs.isNullOrNil(parama.field_username)) {
      parama.field_username = paramString;
    }
    int i = 1;
    while (i <= parama.tyS.size())
    {
      paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i));
      if (bs.isNullOrNil(paramString.username)) {
        paramString.username = str;
      }
      i += 1;
    }
    AppMethodBeat.o(110346);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110338);
    b(paramString1, paramString2, parama, ce.azK(), true);
    AppMethodBeat.o(110338);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110337);
    long l = ce.azK();
    if (paramLong != 0L) {
      l = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(paramLong).field_createTime / 1000L;
    }
    b(paramString1, paramString2, parama, l, paramBoolean);
    AppMethodBeat.o(110337);
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, long paramLong1, boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong2)
  {
    AppMethodBeat.i(192991);
    paramBoolean1 = a(parama1, parama2, paramLong1, paramBoolean1, paramString, paramBoolean2, false, paramLong2);
    AppMethodBeat.o(192991);
    return paramBoolean1;
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, long paramLong1, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, long paramLong2)
  {
    AppMethodBeat.i(192992);
    com.tencent.mm.plugin.groupsolitaire.c.a locala = a(parama1, parama2, paramString, paramBoolean2, paramBoolean3);
    if ((locala != null) && (locala.field_firstMsgId == 0L)) {
      locala.field_firstMsgId = paramLong1;
    }
    locala.field_lastActiveTime = paramLong2;
    if (parama2 != null)
    {
      paramBoolean2 = true;
      paramBoolean2 = a(locala, paramBoolean2, paramBoolean1);
      if ((paramLong1 != 0L) && (paramBoolean2))
      {
        bo localbo = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(paramLong1);
        localbo.rm(parama1.field_key);
        ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(paramLong1, localbo);
        if ((paramBoolean1) && (parama2 != null) && (parama2.field_active == 0) && (locala.tyS.size() > 1))
        {
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          d.b(locala, paramString);
        }
        if ((parama2 == null) && (locala != null))
        {
          parama1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(locala.field_username, locala.field_key, true);
          if (parama1.field_msgSvrId == 0L)
          {
            parama1.field_msgSvrId = localbo.field_msgSvrId;
            ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama1, true);
          }
        }
      }
      if (locala != null) {
        break label301;
      }
    }
    label301:
    for (parama1 = "null";; parama1 = locala.field_key)
    {
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mergeAndSaveGroupSolitatire() key:%s msgId:%s ret:%s", new Object[] { parama1, Long.valueOf(paramLong1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(192992);
      return paramBoolean2;
      paramBoolean2 = false;
      break;
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(110344);
    if (parama == null)
    {
      AppMethodBeat.o(110344);
      return false;
    }
    if (!((i)com.tencent.mm.kernel.g.ab(i.class)).ahZ(parama.field_username))
    {
      AppMethodBeat.o(110344);
      return false;
    }
    ac.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire key:%s exist:%s supportOnlyOne:%s num:%s", new Object[] { parama.field_key, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(parama.tyS.size()) });
    if (paramBoolean1) {
      if (parama.tyS.size() > cSg()) {
        paramBoolean1 = false;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() ret:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
      if (paramBoolean1)
      {
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().aig(parama.field_username);
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hc(parama.field_username, parama.field_key);
        aia(parama.field_username);
      }
      ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() groupSolitatire:%s", new Object[] { parama });
      AppMethodBeat.o(110344);
      return paramBoolean1;
      paramBoolean1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, false);
      continue;
      if ((paramBoolean2) && (parama.tyS.size() > 1)) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().i(parama);
      }
    }
  }
  
  public static boolean aA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(110335);
    if ((bs.isNullOrNil(paramString)) || (paramContext == null))
    {
      AppMethodBeat.o(110335);
      return false;
    }
    paramString = paramString.trim();
    if ((bs.lr(paramString, paramContext.getString(2131760093))) || (bs.lr(paramString, paramContext.getString(2131760094))))
    {
      AppMethodBeat.o(110335);
      return true;
    }
    AppMethodBeat.o(110335);
    return false;
  }
  
  public static boolean aB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(110336);
    if ((bs.isNullOrNil(paramString)) || (paramContext == null))
    {
      AppMethodBeat.o(110336);
      return false;
    }
    paramString = paramString.trim();
    if ((paramString.startsWith(paramContext.getString(2131760093))) || (paramString.startsWith(paramContext.getString(2131760094))))
    {
      AppMethodBeat.o(110336);
      return true;
    }
    AppMethodBeat.o(110336);
    return false;
  }
  
  public static com.tencent.mm.plugin.groupsolitaire.c.a af(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(110355);
    if (bs.isNullOrNil(paramString3))
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
      AppMethodBeat.o(110355);
      return null;
    }
    int j = (paramString3 + bs.bG(paramString2, "")).hashCode();
    Object localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)fAs.get(Integer.valueOf(j));
    if (localObject != null)
    {
      ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "get GroupSolitatire data from cache");
      AppMethodBeat.o(110355);
      return localObject;
    }
    if (!paramString3.trim().contains("<solitaire>"))
    {
      AppMethodBeat.o(110355);
      return null;
    }
    localObject = bv.L(paramString3, "solitaire");
    if (localObject == null)
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "newValues is null: %s", new Object[] { paramString3 });
      AppMethodBeat.o(110355);
      return null;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
    locala.header = gZ(paramString2, (String)((Map)localObject).get(".solitaire.tt"));
    locala.tyO = gZ(paramString2, (String)((Map)localObject).get(".solitaire.ex"));
    locala.tyP = gZ(paramString2, (String)((Map)localObject).get(".solitaire.tl"));
    locala.separator = ((String)((Map)localObject).get(".solitaire.s"));
    locala.field_creator = ((String)((Map)localObject).get(".solitaire.au"));
    locala.field_username = paramString1;
    locala.tyQ = bs.getInt((String)((Map)localObject).get(".solitaire.hrt"), 1);
    boolean bool;
    int k;
    ArrayList localArrayList;
    label408:
    com.tencent.mm.plugin.groupsolitaire.c.b localb;
    if (bs.getInt((String)((Map)localObject).get(".solitaire.loss"), 0) == 1)
    {
      bool = true;
      locala.tyR = bool;
      if (!((Map)localObject).containsKey(".solitaire.content" + ".s")) {
        break label1007;
      }
      k = bs.getInt((String)((Map)localObject).get(".solitaire.content" + ".s"), 0);
      localArrayList = new ArrayList();
      i = 0;
      if (i >= k) {
        break label952;
      }
      localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
      if (i != 0) {
        break label683;
      }
      localb.username = ((String)((Map)localObject).get(".solitaire.content.i" + ".u"));
      localb.tyV = bs.getInt((String)((Map)localObject).get(".solitaire.content.i" + ".h"), 0);
      localb.separator = ((String)((Map)localObject).get(".solitaire.content.i" + ".s"));
      localb.createtime = bs.getLong((String)((Map)localObject).get(".solitaire.content.i" + ".t"), 0L);
      paramString1 = (String)((Map)localObject).get(".solitaire.content.i" + ".c");
      paramString3 = (String)((Map)localObject).get(".solitaire.content.i" + ".r");
      label649:
      if (bs.isNullOrNil(paramString1)) {
        break label932;
      }
      localb.content = paramString1;
    }
    for (;;)
    {
      localArrayList.add(localb);
      i += 1;
      break label408;
      bool = false;
      break;
      label683:
      localb.username = ((String)((Map)localObject).get(".solitaire.content.i" + i + ".u"));
      localb.tyV = bs.getInt((String)((Map)localObject).get(".solitaire.content.i" + i + ".h"), 0);
      localb.separator = ((String)((Map)localObject).get(".solitaire.content.i" + i + ".s"));
      localb.createtime = bs.getLong((String)((Map)localObject).get(".solitaire.content.i" + i + ".t"), 0L);
      paramString1 = (String)((Map)localObject).get(".solitaire.content.i" + i + ".c");
      paramString3 = (String)((Map)localObject).get(".solitaire.content.i" + i + ".r");
      break label649;
      label932:
      if (!bs.isNullOrNil(paramString3)) {
        localb.content = gZ(paramString2, paramString3);
      }
    }
    label952:
    Collections.sort(localArrayList, new Comparator() {});
    int i = 0;
    while (i < k)
    {
      locala.tyS.put(Integer.valueOf(locala.tyS.size() + 1), localArrayList.get(i));
      i += 1;
    }
    label1007:
    locala.field_key = a(locala);
    fAs.put(Integer.valueOf(j), locala);
    AppMethodBeat.o(110355);
    return locala;
  }
  
  public static void aia(String paramString)
  {
    AppMethodBeat.i(110345);
    ac.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() batch delete expire data!! (%s)", new Object[] { paramString });
    if ((bs.isNullOrNil(paramString)) || (!w.sQ(paramString)))
    {
      AppMethodBeat.o(110345);
      return;
    }
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110317);
        a locala = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().aif(this.fur);
        if (locala == null)
        {
          ac.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() chatRoomGroupSolitatire == null");
          AppMethodBeat.o(110317);
          return;
        }
        List localList = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().k(this.fur, 1, locala.tyn);
        boolean bool2;
        if (localList.size() > 0)
        {
          bool2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().l(this.fur, 1, locala.tyn);
          if (locala.tym)
          {
            ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.q(localList, 2);
          }
        }
        for (;;)
        {
          localList = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().k(this.fur, 0, locala.typ);
          boolean bool1;
          if (localList.size() > 0)
          {
            bool1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().l(this.fur, 0, locala.typ);
            if (locala.tyo)
            {
              ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              d.q(localList, 2);
            }
          }
          for (;;)
          {
            ac.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() activeResult:%s unActiveResult:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            AppMethodBeat.o(110317);
            return;
            ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.q(localList, 1);
            break;
            ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.q(localList, 1);
            continue;
            bool1 = false;
          }
          bool2 = false;
        }
      }
    }, 1000L);
    AppMethodBeat.o(110345);
  }
  
  public static boolean aib(String paramString)
  {
    AppMethodBeat.i(110360);
    if (aie(paramString) > cSh() * 2)
    {
      AppMethodBeat.o(110360);
      return true;
    }
    AppMethodBeat.o(110360);
    return false;
  }
  
  public static boolean aic(String paramString)
  {
    AppMethodBeat.i(110361);
    if (aie(paramString) > cSi() * 2)
    {
      AppMethodBeat.o(110361);
      return true;
    }
    AppMethodBeat.o(110361);
    return false;
  }
  
  public static boolean aid(String paramString)
  {
    AppMethodBeat.i(178795);
    if (aie(paramString) > cSj() * 2)
    {
      AppMethodBeat.o(178795);
      return true;
    }
    AppMethodBeat.o(178795);
    return false;
  }
  
  public static int aie(String paramString)
  {
    AppMethodBeat.i(110363);
    if (paramString == null)
    {
      AppMethodBeat.o(110363);
      return 0;
    }
    try
    {
      i = paramString.getBytes("GBK").length;
      ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "length:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(110363);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getStringByteLen Exception：%s，%s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        int i = paramString.getBytes().length;
      }
    }
  }
  
  public static boolean al(bo parambo)
  {
    AppMethodBeat.i(110341);
    if (parambo == null)
    {
      AppMethodBeat.o(110341);
      return false;
    }
    Object localObject1 = parambo.field_talker;
    Object localObject2 = parambo.eSn;
    if (((i)com.tencent.mm.kernel.g.ab(i.class)).ahZ((String)localObject1))
    {
      localObject2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hb((String)localObject1, (String)localObject2);
      localObject1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().aif((String)localObject1);
      if (localObject2 == null)
      {
        AppMethodBeat.o(110341);
        return false;
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(110341);
        return false;
      }
      if ((((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_active == 1) && (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_lastActiveTime >= ((a)localObject1).tyn) && (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).tyS.size() < cSg()) && (parambo.field_msgId >= ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_firstMsgId))
      {
        AppMethodBeat.o(110341);
        return true;
      }
      AppMethodBeat.o(110341);
      return false;
    }
    AppMethodBeat.o(110341);
    return false;
  }
  
  public static String b(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110353);
    paramString = a(paramString, parama, false);
    AppMethodBeat.o(110353);
    return paramString;
  }
  
  public static void b(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(161734);
    if ((parama != null) && (parama.field_msgSvrId == 0L))
    {
      parama.field_msgSvrId = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(parama.field_firstMsgId).field_msgSvrId;
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "fixMsgSvrId ret:%s", new Object[] { Boolean.valueOf(((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true)) });
    }
    AppMethodBeat.o(161734);
  }
  
  private static void b(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110339);
    if (parama == null)
    {
      AppMethodBeat.o(110339);
      return;
    }
    parama.field_key = a(parama);
    parama.field_lastActiveTime = paramLong;
    if (paramBoolean) {}
    for (parama.field_active = 1;; parama.field_active = 0)
    {
      if (bs.isNullOrNil(parama.field_username)) {
        parama.field_username = paramString1;
      }
      if (bs.isNullOrNil(parama.field_creator)) {
        parama.field_creator = paramString2;
      }
      paramString1 = new HashMap();
      HashSet localHashSet = new HashSet();
      parama.tyT = false;
      parama.header = parama.header.trim();
      parama.tyO = parama.tyO.trim();
      parama.tyP = parama.tyP.trim();
      int i = 1;
      while (i <= parama.tyS.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i));
        if ((!bs.isNullOrNil(localb.content)) && (!bs.isNullOrNil(localb.content.trim())))
        {
          localb.content = localb.content.trim();
          if (localHashSet.contains(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Xw(localb.content))) {
            parama.tyT = true;
          }
          localHashSet.add(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Xw(localb.content));
          paramString1.put(Integer.valueOf(paramString1.size() + 1), localb);
          if (localb.createtime == 9223372036854775807L) {
            localb.createtime = paramLong;
          }
          if (bs.isNullOrNil(localb.username)) {
            localb.username = paramString2;
          }
        }
        i += 1;
      }
    }
    parama.tyS = paramString1;
    AppMethodBeat.o(110339);
  }
  
  private static String c(Pair<Integer, Integer> paramPair)
  {
    AppMethodBeat.i(174562);
    if (paramPair == null)
    {
      AppMethodBeat.o(174562);
      return "";
    }
    paramPair = paramPair.first + "-" + paramPair.second;
    AppMethodBeat.o(174562);
    return paramPair;
  }
  
  public static void c(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110340);
    if ((parama != null) && (parama.tyT))
    {
      HashMap localHashMap = new HashMap();
      HashSet localHashSet = new HashSet();
      parama.tyT = false;
      int i = 1;
      while (i <= parama.tyS.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i));
        if (!localHashSet.contains(localb.content))
        {
          localHashSet.add(localb.content);
          localHashMap.put(Integer.valueOf(localHashMap.size() + 1), localb);
        }
        i += 1;
      }
      parama.tyS = localHashMap;
    }
    AppMethodBeat.o(110340);
  }
  
  public static String cRV()
  {
    AppMethodBeat.i(110322);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYE, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])(\\s*)");
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mainBodyRegex:%s", new Object[] { str });
    AppMethodBeat.o(110322);
    return str;
  }
  
  public static String cRW()
  {
    AppMethodBeat.i(110323);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYF, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])");
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "separatorRegex:%s", new Object[] { str });
    AppMethodBeat.o(110323);
    return str;
  }
  
  public static String cRX()
  {
    AppMethodBeat.i(110324);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYG, "([0-9]{1,3})(\\s*)([.。;；、:,，])");
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentSeparatorRegex:%s", new Object[] { str });
    AppMethodBeat.o(110324);
    return str;
  }
  
  public static String cRY()
  {
    AppMethodBeat.i(110325);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYH, "^\\d{1,3}");
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "numRegex:%s", new Object[] { str });
    AppMethodBeat.o(110325);
    return str;
  }
  
  public static String cRZ()
  {
    AppMethodBeat.i(192988);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYI, "^\\d{1,3}$");
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "SingleNum:%s", new Object[] { str });
    AppMethodBeat.o(192988);
    return str;
  }
  
  public static String cSa()
  {
    AppMethodBeat.i(110326);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYJ, "\\d{1,3}");
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentNumRegex:%s", new Object[] { str });
    AppMethodBeat.o(110326);
    return str;
  }
  
  public static String cSb()
  {
    AppMethodBeat.i(110327);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYK, "(例|例如|如|格式|格式如)(\\s*)([,.:，：、 ])(.+)");
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", new Object[] { str });
    AppMethodBeat.o(110327);
    return str;
  }
  
  public static int cSc()
  {
    AppMethodBeat.i(110328);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYL, 3);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireActiveIntervalTime() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110328);
    return i;
  }
  
  public static int cSd()
  {
    AppMethodBeat.i(110329);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYM, 5);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireActiveNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110329);
    return i;
  }
  
  public static int cSe()
  {
    AppMethodBeat.i(110330);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYN, 24);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireMatchIntervalTime() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110330);
    return i;
  }
  
  public static int cSf()
  {
    AppMethodBeat.i(110331);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYO, 10);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireMatchNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110331);
    return i;
  }
  
  public static int cSg()
  {
    AppMethodBeat.i(110332);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYD, 500);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110332);
    return i;
  }
  
  public static int cSh()
  {
    AppMethodBeat.i(110333);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYS, 150);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110333);
    return i;
  }
  
  public static int cSi()
  {
    AppMethodBeat.i(178792);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYT, 500);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(178792);
    return i;
  }
  
  public static int cSj()
  {
    AppMethodBeat.i(178793);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYU, 500);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(178793);
    return i;
  }
  
  public static String cSk()
  {
    AppMethodBeat.i(192989);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYX, "(\\.|。|,|，|:|：|;|；|、|-|\\s)");
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "equalStrWhiteListRegex:%s", new Object[] { str });
    AppMethodBeat.o(192989);
    return str;
  }
  
  public static boolean d(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110351);
    if (parama == null)
    {
      AppMethodBeat.o(110351);
      return false;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYC, 0);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getKeywordCheckSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (i = 1; i != 0; i = 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (parama.tyQ == 1) {
        localStringBuilder.append(parama.header);
      }
      localStringBuilder.append(parama.tyO).append(parama.tyP);
      parama = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYV, "(接龙|报名|参加|参与|活动|组织|投票|回复|统计)");
      ac.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", new Object[] { parama });
      boolean bool = Pattern.compile(parama).matcher(localStringBuilder.toString()).find();
      AppMethodBeat.o(110351);
      return bool;
    }
    AppMethodBeat.o(110351);
    return true;
  }
  
  public static int dA(String paramString, int paramInt)
  {
    AppMethodBeat.i(110364);
    int j = paramString.length();
    int i = 0;
    while (i <= j)
    {
      int m = (i + j) / 2;
      int n = aie(paramString.substring(0, m));
      if (n == paramInt)
      {
        AppMethodBeat.o(110364);
        return m;
      }
      int k = j;
      if (n > paramInt) {
        k = m - 1;
      }
      j = k;
      if (n < paramInt)
      {
        i = m + 1;
        j = k;
      }
    }
    AppMethodBeat.o(110364);
    return j;
  }
  
  public static String e(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110352);
    if (parama == null)
    {
      AppMethodBeat.o(110352);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<solitaire>");
    localStringBuilder.append("<tt>").append(bs.aLw(parama.header)).append("</tt>");
    localStringBuilder.append("<ex>").append(bs.aLw(parama.tyO)).append("</ex>");
    localStringBuilder.append("<tl>").append(bs.aLw(parama.tyP)).append("</tl>");
    localStringBuilder.append("<s>").append(bs.aLw(parama.separator)).append("</s>");
    localStringBuilder.append("<au>").append(parama.field_creator).append("</au>");
    localStringBuilder.append("<hrt>").append(parama.tyQ).append("</hrt>");
    localStringBuilder.append("<content>");
    localStringBuilder.append("<s>").append(parama.tyS.size()).append("</s>");
    int i = 1;
    while (i <= parama.tyS.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i));
      if (localb != null)
      {
        localStringBuilder.append("<i>");
        localStringBuilder.append("<u>").append(localb.username).append("</u>");
        localStringBuilder.append("<h>").append(localb.tyV).append("</h>");
        localStringBuilder.append("<s>").append(bs.aLw(localb.separator)).append("</s>");
        localStringBuilder.append("<t>").append(localb.createtime).append("</t>");
        localStringBuilder.append("<c>").append(bs.aLw(localb.content)).append("</c>");
        localStringBuilder.append("<o>").append(localb.tyW).append("</o>");
        localStringBuilder.append("</i>");
      }
      i += 1;
    }
    localStringBuilder.append("</content>");
    localStringBuilder.append("</solitaire>");
    parama = localStringBuilder.toString();
    AppMethodBeat.o(110352);
    return parama;
  }
  
  public static void f(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110354);
    Object localObject = parama.field_content;
    if (bs.isNullOrNil((String)localObject))
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
      AppMethodBeat.o(110354);
      return;
    }
    if (!((String)localObject).trim().contains("<solitaire>"))
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "<solitaire> no contains");
      AppMethodBeat.o(110354);
      return;
    }
    Map localMap = bv.L((String)localObject, "solitaire");
    if (localMap == null)
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "newValues is null: %s", new Object[] { localObject });
      AppMethodBeat.o(110354);
      return;
    }
    parama.header = ((String)localMap.get(".solitaire.tt"));
    parama.tyO = ((String)localMap.get(".solitaire.ex"));
    parama.tyP = ((String)localMap.get(".solitaire.tl"));
    parama.separator = ((String)localMap.get(".solitaire.s"));
    parama.field_creator = ((String)localMap.get(".solitaire.au"));
    parama.tyQ = bs.getInt((String)localMap.get(".solitaire.hrt"), 1);
    if (localMap.containsKey(".solitaire.content" + ".s"))
    {
      int j = bs.getInt((String)localMap.get(".solitaire.content" + ".s"), 0);
      localObject = new ArrayList();
      int i = 0;
      if (i < j)
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
        if (i == 0)
        {
          localb.username = ((String)localMap.get(".solitaire.content.i" + ".u"));
          localb.tyV = bs.getInt((String)localMap.get(".solitaire.content.i" + ".h"), 0);
          localb.separator = ((String)localMap.get(".solitaire.content.i" + ".s"));
          localb.createtime = bs.getLong((String)localMap.get(".solitaire.content.i" + ".t"), 0L);
          localb.content = ((String)localMap.get(".solitaire.content.i" + ".c"));
        }
        for (localb.tyW = bs.getInt((String)localMap.get(".solitaire.content.i" + ".o"), 0);; localb.tyW = bs.getInt((String)localMap.get(".solitaire.content.i" + i + ".o"), 0))
        {
          ((ArrayList)localObject).add(localb);
          i += 1;
          break;
          localb.username = ((String)localMap.get(".solitaire.content.i" + i + ".u"));
          localb.tyV = bs.getInt((String)localMap.get(".solitaire.content.i" + i + ".h"), 0);
          localb.separator = ((String)localMap.get(".solitaire.content.i" + i + ".s"));
          localb.createtime = bs.getLong((String)localMap.get(".solitaire.content.i" + i + ".t"), 0L);
          localb.content = ((String)localMap.get(".solitaire.content.i" + i + ".c"));
        }
      }
      Collections.sort((List)localObject, new Comparator() {});
      i = 0;
      while (i < j)
      {
        parama.tyS.put(Integer.valueOf(parama.tyS.size() + 1), ((ArrayList)localObject).get(i));
        i += 1;
      }
    }
    AppMethodBeat.o(110354);
  }
  
  public static String g(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110356);
    if (parama == null)
    {
      AppMethodBeat.o(110356);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((parama.header != null) && (!bs.isNullOrNil(parama.header.trim())) && (parama.tyQ == 1))
    {
      parama.header = parama.header.trim();
      localStringBuilder.append(parama.header).append("\n");
    }
    if ((parama.tyO != null) && (!bs.isNullOrNil(parama.tyO.trim())))
    {
      parama.tyO = parama.tyO.trim();
      localStringBuilder.append(parama.tyO).append("\n");
    }
    if (!bs.isNullOrNil(localStringBuilder.toString())) {
      localStringBuilder.append("\n");
    }
    if (parama.tyS.size() > 0)
    {
      int i = 1;
      while (i <= parama.tyS.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i));
        localStringBuilder.append(i).append(parama.separator).append(" ").append(localb.content);
        if (i < parama.tyS.size()) {
          localStringBuilder.append("\n");
        }
        i += 1;
      }
    }
    if ((parama.tyP != null) && (!bs.isNullOrNil(parama.tyP.trim())))
    {
      parama.tyP = parama.tyP.trim();
      localStringBuilder.append("\n");
      localStringBuilder.append("\n");
      localStringBuilder.append(parama.tyP);
    }
    parama = localStringBuilder.toString();
    AppMethodBeat.o(110356);
    return parama;
  }
  
  public static Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> gW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110350);
    if (bs.isNullOrNil(paramString2))
    {
      paramString1 = new Pair(Boolean.FALSE, null);
      AppMethodBeat.o(110350);
      return paramString1;
    }
    paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hb(paramString1, paramString2);
    if (paramString1 == null)
    {
      paramString1 = new Pair(Boolean.FALSE, null);
      AppMethodBeat.o(110350);
      return paramString1;
    }
    paramString1 = new Pair(Boolean.TRUE, paramString1);
    AppMethodBeat.o(110350);
    return paramString1;
  }
  
  private static Pair<Integer, Integer> gX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110357);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(110357);
      return null;
    }
    int i = paramString1.indexOf(paramString2);
    if (i >= 0)
    {
      paramString1 = new Pair(Integer.valueOf(i), Integer.valueOf(paramString2.length()));
      AppMethodBeat.o(110357);
      return paramString1;
    }
    AppMethodBeat.o(110357);
    return null;
  }
  
  private static String gY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110358);
    paramString1 = gX(paramString1, paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(110358);
      return paramString2;
    }
    paramString1 = paramString1.first + "-" + paramString1.second;
    AppMethodBeat.o(110358);
    return paramString1;
  }
  
  private static String gZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110359);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110359);
      return "";
    }
    paramString2 = paramString2.split("-");
    if ((paramString2 != null) && (paramString2.length == 2))
    {
      int i = bs.getInt(paramString2[0], 0);
      int j = bs.getInt(paramString2[1], 0) + i;
      if ((i >= 0) && (j <= paramString1.length()))
      {
        paramString1 = paramString1.substring(i, j);
        AppMethodBeat.o(110359);
        return paramString1;
      }
    }
    AppMethodBeat.o(110359);
    return "";
  }
  
  public static boolean h(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110362);
    if (parama == null)
    {
      AppMethodBeat.o(110362);
      return false;
    }
    if ((parama.tyQ == 1) && (aic(parama.header)))
    {
      AppMethodBeat.o(110362);
      return true;
    }
    AppMethodBeat.o(110362);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.b
 * JD-Core Version:    0.7.0.1
 */