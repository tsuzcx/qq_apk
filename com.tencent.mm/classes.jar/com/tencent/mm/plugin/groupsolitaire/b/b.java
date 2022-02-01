package com.tencent.mm.plugin.groupsolitaire.b;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.b.g;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
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
  private static final f<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> jla;
  
  static
  {
    AppMethodBeat.i(110365);
    jla = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(110365);
  }
  
  public static boolean Y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(246426);
    paramString2 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().ik(paramString1, paramString2);
    paramString1 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().aLa(paramString1);
    if (paramString2 == null)
    {
      AppMethodBeat.o(246426);
      return true;
    }
    boolean bool;
    if (paramString1 == null) {
      bool = true;
    }
    while ((!bool) && (Util.isEqual(paramString2.field_creator, z.bcZ())) && (paramInt <= 1))
    {
      AppMethodBeat.o(246426);
      return true;
      int i;
      if ((paramString2.field_active == 1) && (paramString2.field_lastActiveTime >= paramString1.Dpc) && (paramString2.DpG.size() < eBl()))
      {
        i = 1;
        label121:
        if ((paramString2.field_active != 0) || (paramString2.field_lastActiveTime < paramString1.Dpe)) {
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
    AppMethodBeat.o(246426);
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
    if (!Util.isEqual(parama1.field_key, parama3.field_key))
    {
      AppMethodBeat.o(178794);
      return parama1;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = parama3.eBt();
    Object localObject1 = new LinkedHashSet();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject2 = new LinkedHashSet();
    Object localObject3 = new LinkedHashSet();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    if (i <= parama3.DpG.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = ((com.tencent.mm.plugin.groupsolitaire.c.b)parama3.DpG.get(Integer.valueOf(i))).eBu();
      if (Util.isEqual(localb.username, z.bcZ()))
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
      while (i <= parama2.DpG.size())
      {
        ((Set)localObject3).add(((com.tencent.mm.plugin.groupsolitaire.c.b)parama2.DpG.get(Integer.valueOf(i))).eBu());
        i += 1;
      }
    }
    i = 1;
    while (i <= parama1.DpG.size())
    {
      parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.DpG.get(Integer.valueOf(i));
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
        } while (!Util.isEqual(parama2.DpK, ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).DpK));
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
      locala.DpG.clear();
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
        localObject1 = locala.DpG;
        i += 1;
        ((HashMap)localObject1).put(Integer.valueOf(i), parama3);
      }
      locala.DpI = parama1.DpI;
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
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSa, 1);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLossEfficacySwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(174561);
      return parama2;
    }
    if (paramInt == 1)
    {
      if (!Util.isEqual(paramString, parama2.field_creator))
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
      if (parama1.DpG.size() > 1)
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
    }
    else if (paramInt != 2)
    {
      if (paramInt == 3)
      {
        if (!parama1.DpF)
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
    parama1 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage();
    boolean bool;
    if (parama2 == null) {
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "handleSolitatireLossEfficacy key:%s result:%s", new Object[] { parama2.field_key, Boolean.valueOf(bool) });
      AppMethodBeat.o(174561);
      return null;
      bool = parama1.delete(parama2.systemRowid);
      if (bool) {
        ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().il(parama2.field_username, parama2.field_key);
      }
    }
  }
  
  private static com.tencent.mm.plugin.groupsolitaire.c.a a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(246440);
    if ((parama1 == null) && (parama2 == null))
    {
      AppMethodBeat.o(246440);
      return null;
    }
    if ((parama1 == null) && (parama2 != null))
    {
      AppMethodBeat.o(246440);
      return parama2;
    }
    if ((parama1 != null) && (parama2 == null))
    {
      AppMethodBeat.o(246440);
      return parama1;
    }
    if (!Util.isEqual(parama1.field_key, parama2.field_key))
    {
      AppMethodBeat.o(246440);
      return parama1;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = parama2.eBt();
    Object localObject1 = new LinkedHashSet();
    if (paramBoolean2) {
      while (i <= parama1.DpG.size())
      {
        parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.DpG.get(Integer.valueOf(i));
        if (!((Set)localObject1).contains(parama2)) {
          ((Set)localObject1).add(parama2);
        }
        i += 1;
      }
    }
    Object localObject2 = new HashSet();
    HashMap localHashMap = new HashMap();
    i = 1;
    if (i <= parama2.DpG.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama2.DpG.get(Integer.valueOf(i));
      if (!Util.isEqual(localb.username, paramString)) {
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
    if (i <= parama1.DpG.size())
    {
      parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.DpG.get(Integer.valueOf(i));
      if ((!((Set)localObject1).contains(parama2)) && (Util.isEqual(parama2.username, paramString)))
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
    locala.DpG.clear();
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
      localObject1 = locala.DpG;
      i += 1;
      ((HashMap)localObject1).put(Integer.valueOf(i), paramString);
    }
    locala.DpI = parama1.DpI;
    AppMethodBeat.o(246440);
    return locala;
  }
  
  private static csr a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.b paramb, int paramInt)
  {
    AppMethodBeat.i(246450);
    csr localcsr = new csr();
    localcsr.TAu = (paramInt + paramString2 + " ");
    a(localcsr, paramString1, paramb.content);
    AppMethodBeat.o(246450);
    return localcsr;
  }
  
  public static String a(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110334);
    if ((Util.isNullOrNil(parama.header)) && (Util.isNullOrNil(parama.DpD)) && (Util.isNullOrNil(parama.CBX)) && (parama.DpE == 1))
    {
      parama.DpE = 0;
      if (parama.DpG.size() > 0)
      {
        parama.header = ((com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(1))).content;
        ((com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(1))).DpJ = 1;
      }
    }
    parama = g.getMessageDigest(MMApplicationContext.getContext().getString(b.g.DoQ, new Object[] { parama.header.trim(), parama.DpE, parama.DpD.trim(), parama.CBX.trim() }).getBytes());
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
    localStringBuilder2.append("<tt>").append(ih(paramString, parama.header)).append("</tt>");
    localStringBuilder2.append("<ex>").append(ih(paramString, parama.DpD)).append("</ex>");
    localStringBuilder2.append("<tl>").append(ih(paramString, parama.CBX)).append("</tl>");
    localStringBuilder2.append("<s>").append(Util.escapeStringForXml(parama.bOX)).append("</s>");
    localStringBuilder2.append("<au>").append(parama.field_creator).append("</au>");
    localStringBuilder2.append("<hrt>").append(parama.DpE).append("</hrt>");
    Object localObject = localStringBuilder2.append("<loss>");
    int i;
    label285:
    Pair localPair;
    if (paramBoolean)
    {
      i = 1;
      ((StringBuilder)localObject).append(i).append("</loss>");
      localStringBuilder2.append("<content>");
      localStringBuilder2.append("<s>").append(parama.DpG.size()).append("</s>");
      i = j;
      if (i > parama.DpG.size()) {
        break label510;
      }
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i));
      if (localObject != null)
      {
        localStringBuilder2.append("<i>");
        localStringBuilder2.append("<u>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).username).append("</u>");
        localStringBuilder2.append("<h>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).DpJ).append("</h>");
        localStringBuilder2.append("<s>").append(Util.escapeStringForXml(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).bOX)).append("</s>");
        localStringBuilder2.append("<t>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).createtime).append("</t>");
        localPair = ig(paramString, ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content);
        if (localPair != null) {
          break label484;
        }
        localStringBuilder2.append("<c>").append(Util.escapeStringForXml(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content)).append("</c>");
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
    AppMethodBeat.i(246449);
    if (parama == null)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: groupSolitatire is null");
      AppMethodBeat.o(246449);
      return;
    }
    ca localca;
    Object localObject3;
    csq localcsq;
    Object localObject1;
    if (paramLong != 0L)
    {
      localca = ((n)h.ae(n.class)).eSe().Oq(paramLong);
      localObject3 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().t(parama.field_username, parama.field_key, false);
      localcsq = new csq();
      if (localca.hwH()) {
        localObject1 = localca.field_content;
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: content is null");
        AppMethodBeat.o(246449);
        return;
        if (localca.hzM())
        {
          localObject1 = k.b.OQ(localca.field_content);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: amc is null");
            AppMethodBeat.o(246449);
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
          localObject2 = ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).bOX;
          if ((parama == null) || (localObject3 == null))
          {
            if (parama.DpE != 0) {
              break label1045;
            }
            i = 2;
          }
        }
        for (;;)
        {
          if (i <= parama.DpG.size())
          {
            localObject3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i));
            if ((!Util.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content)) && (!Util.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content.trim())))
            {
              ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content = ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content.trim();
              if (Util.isEqual(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).username, paramString)) {
                localcsq.TAr.add(a((String)localObject1, (String)localObject2, (com.tencent.mm.plugin.groupsolitaire.c.b)localObject3, i));
              }
            }
            i += 1;
            continue;
            LinkedHashSet localLinkedHashSet = new LinkedHashSet();
            i = 1;
            while (i <= ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).DpG.size())
            {
              com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).DpG.get(Integer.valueOf(i));
              if ((localb != null) && (Util.isEqual(localb.username, paramString))) {
                localLinkedHashSet.add(localb);
              }
              i += 1;
            }
            i = 1;
            if (i <= parama.DpG.size())
            {
              localObject3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i));
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
            localObject2 = parama.bOX;
            break;
          }
          if (localcsq.TAr.size() <= 0)
          {
            paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(parama.DpG.size()));
            localcsq.TAr.add(a((String)localObject1, (String)localObject2, paramString, parama.DpG.size()));
          }
          if (parama.DpE == 0) {}
          for (i = parama.DpG.size() - localcsq.TAr.size() - 1; i < 2; i = parama.DpG.size() - localcsq.TAr.size())
          {
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg fold condition min num is not");
            AppMethodBeat.o(246449);
            return;
          }
          localcsq.DpE = parama.DpE;
          localcsq.TAt = (parama.DpG.size() - localcsq.TAr.size());
          localcsq.fNu = parama.field_msgSvrId;
          localcsq.key = parama.field_key;
          if (parama.DpE == 0)
          {
            paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(1));
            localcsq.TAq.add(a((String)localObject1, (String)localObject2, paramString, 1));
          }
          for (;;)
          {
            if ((parama.CBX != null) && (!Util.isNullOrNil(parama.CBX.trim())))
            {
              paramString = new csr();
              a(paramString, (String)localObject1, parama.CBX.trim());
              localcsq.TAs = paramString;
            }
            localca.field_solitaireFoldInfo = localcsq;
            localca.ilb = true;
            try
            {
              ((n)h.ae(n.class)).eSe().a(localca.field_msgId, localca);
              Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId:%s", new Object[] { Long.valueOf(localca.field_msgId) });
              AppMethodBeat.o(246449);
              return;
              if ((parama.header != null) && (!Util.isNullOrNil(parama.header.trim())))
              {
                paramString = new csr();
                a(paramString, (String)localObject1, parama.header.trim());
                localcsq.TAq.add(paramString);
              }
              if ((parama.DpD != null) && (!Util.isNullOrNil(parama.DpD.trim())))
              {
                paramString = ig((String)localObject1, parama.DpD.trim());
                localObject2 = new csr();
                if (paramString == null) {
                  ((csr)localObject2).start = 0;
                }
                for (((csr)localObject2).end = 0;; ((csr)localObject2).end = (((Integer)paramString.second).intValue() + i))
                {
                  localcsq.TAq.add(localObject2);
                  break;
                  if (localcsq.TAq.size() > 0) {
                    ((csr)localObject2).TAu = "\n";
                  }
                  ((csr)localObject2).start = ((Integer)paramString.first).intValue();
                  i = ((Integer)paramString.first).intValue();
                }
              }
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
              }
            }
          }
          Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId == 0");
          AppMethodBeat.o(246449);
          return;
          label1045:
          i = 1;
        }
      }
      localObject1 = "";
    }
  }
  
  private static void a(csr paramcsr, String paramString1, String paramString2)
  {
    AppMethodBeat.i(246451);
    paramString1 = ig(paramString1, paramString2);
    if (paramString1 == null)
    {
      paramcsr.start = 0;
      paramcsr.end = 0;
      AppMethodBeat.o(246451);
      return;
    }
    paramcsr.start = ((Integer)paramString1.first).intValue();
    int i = ((Integer)paramString1.first).intValue();
    paramcsr.end = (((Integer)paramString1.second).intValue() + i);
    AppMethodBeat.o(246451);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110346);
    if (parama == null)
    {
      AppMethodBeat.o(110346);
      return;
    }
    String str = z.bcZ();
    if (Util.isNullOrNil(parama.field_creator)) {
      parama.field_creator = str;
    }
    if (Util.isNullOrNil(parama.field_username)) {
      parama.field_username = paramString;
    }
    int i = 1;
    while (i <= parama.DpG.size())
    {
      paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i));
      if (Util.isNullOrNil(paramString.username)) {
        paramString.username = str;
      }
      i += 1;
    }
    AppMethodBeat.o(110346);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110338);
    b(paramString1, paramString2, parama, cm.bfF(), true);
    AppMethodBeat.o(110338);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110337);
    long l = cm.bfF();
    if (paramLong != 0L) {
      l = ((n)h.ae(n.class)).eSe().Oq(paramLong).field_createTime / 1000L;
    }
    b(paramString1, paramString2, parama, l, paramBoolean);
    AppMethodBeat.o(110337);
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, long paramLong1, boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong2)
  {
    AppMethodBeat.i(246430);
    paramBoolean1 = a(parama1, parama2, paramLong1, paramBoolean1, paramString, paramBoolean2, false, paramLong2);
    AppMethodBeat.o(246430);
    return paramBoolean1;
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, long paramLong1, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, long paramLong2)
  {
    AppMethodBeat.i(246434);
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
        ca localca = ((n)h.ae(n.class)).eSe().Oq(paramLong1);
        localca.Jx(parama1.field_key);
        ((n)h.ae(n.class)).eSe().a(paramLong1, localca);
        if ((paramBoolean1) && (parama2 != null) && (parama2.field_active == 0) && (locala.DpG.size() > 1))
        {
          ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          d.b(locala, paramString);
        }
        if ((parama2 == null) && (locala != null))
        {
          parama1 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().t(locala.field_username, locala.field_key, true);
          if (parama1.field_msgSvrId == 0L)
          {
            parama1.field_msgSvrId = localca.field_msgSvrId;
            ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama1, true);
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
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mergeAndSaveGroupSolitatire() key:%s msgId:%s ret:%s", new Object[] { parama1, Long.valueOf(paramLong1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(246434);
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
    if (!((l)h.ae(l.class)).aKU(parama.field_username))
    {
      AppMethodBeat.o(110344);
      return false;
    }
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire key:%s exist:%s supportOnlyOne:%s num:%s", new Object[] { parama.field_key, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(parama.DpG.size()) });
    if (paramBoolean1) {
      if (parama.DpG.size() > eBl()) {
        paramBoolean1 = false;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() ret:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
      if (paramBoolean1)
      {
        ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().aLb(parama.field_username);
        ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().il(parama.field_username, parama.field_key);
        aKV(parama.field_username);
      }
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() groupSolitatire:%s", new Object[] { parama });
      AppMethodBeat.o(110344);
      return paramBoolean1;
      paramBoolean1 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, false);
      continue;
      if ((paramBoolean2) && (parama.DpG.size() > 1)) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().i(parama);
      }
    }
  }
  
  public static boolean aI(ca paramca)
  {
    AppMethodBeat.i(110341);
    if (paramca == null)
    {
      AppMethodBeat.o(110341);
      return false;
    }
    Object localObject1 = paramca.field_talker;
    Object localObject2 = paramca.ilt;
    if (((l)h.ae(l.class)).aKU((String)localObject1))
    {
      localObject2 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().ik((String)localObject1, (String)localObject2);
      localObject1 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().aLa((String)localObject1);
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
      if ((((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_active == 1) && (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_lastActiveTime >= ((a)localObject1).Dpc) && (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).DpG.size() < eBl()) && (paramca.field_msgId >= ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_firstMsgId))
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
  
  public static void aKV(String paramString)
  {
    AppMethodBeat.i(110345);
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() batch delete expire data!! (%s)", new Object[] { paramString });
    if ((Util.isNullOrNil(paramString)) || (!ab.Lj(paramString)))
    {
      AppMethodBeat.o(110345);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110317);
        a locala = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().aLa(this.iXG);
        if (locala == null)
        {
          Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() chatRoomGroupSolitatire == null");
          AppMethodBeat.o(110317);
          return;
        }
        List localList = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().F(this.iXG, 1, locala.Dpc);
        boolean bool2;
        if (localList.size() > 0)
        {
          bool2 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().G(this.iXG, 1, locala.Dpc);
          if (locala.Dpb)
          {
            ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.x(localList, 2);
          }
        }
        for (;;)
        {
          localList = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().F(this.iXG, 0, locala.Dpe);
          boolean bool1;
          if (localList.size() > 0)
          {
            bool1 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().G(this.iXG, 0, locala.Dpe);
            if (locala.Dpd)
            {
              ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              d.x(localList, 2);
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() activeResult:%s unActiveResult:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            AppMethodBeat.o(110317);
            return;
            ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.x(localList, 1);
            break;
            ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.x(localList, 1);
            continue;
            bool1 = false;
          }
          bool2 = false;
        }
      }
    }, 1000L);
    AppMethodBeat.o(110345);
  }
  
  public static boolean aKW(String paramString)
  {
    AppMethodBeat.i(110360);
    if (aKZ(paramString) > eBm() * 2)
    {
      AppMethodBeat.o(110360);
      return true;
    }
    AppMethodBeat.o(110360);
    return false;
  }
  
  public static boolean aKX(String paramString)
  {
    AppMethodBeat.i(110361);
    if (aKZ(paramString) > eBn() * 2)
    {
      AppMethodBeat.o(110361);
      return true;
    }
    AppMethodBeat.o(110361);
    return false;
  }
  
  public static boolean aKY(String paramString)
  {
    AppMethodBeat.i(178795);
    if (aKZ(paramString) > eBo() * 2)
    {
      AppMethodBeat.o(178795);
      return true;
    }
    AppMethodBeat.o(178795);
    return false;
  }
  
  public static int aKZ(String paramString)
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
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "length:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(110363);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getStringByteLen Exception：%s，%s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        int i = paramString.getBytes().length;
      }
    }
  }
  
  public static com.tencent.mm.plugin.groupsolitaire.c.a ao(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(110355);
    if (Util.isNullOrNil(paramString3))
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
      AppMethodBeat.o(110355);
      return null;
    }
    int j = (paramString3 + Util.nullAs(paramString2, "")).hashCode();
    Object localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)jla.get(Integer.valueOf(j));
    if (localObject != null)
    {
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "get GroupSolitatire data from cache");
      AppMethodBeat.o(110355);
      return localObject;
    }
    if (!paramString3.trim().contains("<solitaire>"))
    {
      AppMethodBeat.o(110355);
      return null;
    }
    localObject = XmlParser.parseXml(paramString3, "solitaire", null);
    if (localObject == null)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "newValues is null: %s", new Object[] { paramString3 });
      AppMethodBeat.o(110355);
      return null;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
    locala.header = ii(paramString2, (String)((Map)localObject).get(".solitaire.tt"));
    locala.DpD = ii(paramString2, (String)((Map)localObject).get(".solitaire.ex"));
    locala.CBX = ii(paramString2, (String)((Map)localObject).get(".solitaire.tl"));
    locala.bOX = ((String)((Map)localObject).get(".solitaire.s"));
    locala.field_creator = ((String)((Map)localObject).get(".solitaire.au"));
    locala.field_username = paramString1;
    locala.DpE = Util.getInt((String)((Map)localObject).get(".solitaire.hrt"), 1);
    boolean bool;
    int k;
    ArrayList localArrayList;
    label409:
    com.tencent.mm.plugin.groupsolitaire.c.b localb;
    if (Util.getInt((String)((Map)localObject).get(".solitaire.loss"), 0) == 1)
    {
      bool = true;
      locala.DpF = bool;
      if (!((Map)localObject).containsKey(".solitaire.content" + ".s")) {
        break label1008;
      }
      k = Util.getInt((String)((Map)localObject).get(".solitaire.content" + ".s"), 0);
      localArrayList = new ArrayList();
      i = 0;
      if (i >= k) {
        break label953;
      }
      localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
      if (i != 0) {
        break label684;
      }
      localb.username = ((String)((Map)localObject).get(".solitaire.content.i" + ".u"));
      localb.DpJ = Util.getInt((String)((Map)localObject).get(".solitaire.content.i" + ".h"), 0);
      localb.bOX = ((String)((Map)localObject).get(".solitaire.content.i" + ".s"));
      localb.createtime = Util.getLong((String)((Map)localObject).get(".solitaire.content.i" + ".t"), 0L);
      paramString1 = (String)((Map)localObject).get(".solitaire.content.i" + ".c");
      paramString3 = (String)((Map)localObject).get(".solitaire.content.i" + ".r");
      label650:
      if (Util.isNullOrNil(paramString1)) {
        break label933;
      }
      localb.content = paramString1;
    }
    for (;;)
    {
      localArrayList.add(localb);
      i += 1;
      break label409;
      bool = false;
      break;
      label684:
      localb.username = ((String)((Map)localObject).get(".solitaire.content.i" + i + ".u"));
      localb.DpJ = Util.getInt((String)((Map)localObject).get(".solitaire.content.i" + i + ".h"), 0);
      localb.bOX = ((String)((Map)localObject).get(".solitaire.content.i" + i + ".s"));
      localb.createtime = Util.getLong((String)((Map)localObject).get(".solitaire.content.i" + i + ".t"), 0L);
      paramString1 = (String)((Map)localObject).get(".solitaire.content.i" + i + ".c");
      paramString3 = (String)((Map)localObject).get(".solitaire.content.i" + i + ".r");
      break label650;
      label933:
      if (!Util.isNullOrNil(paramString3)) {
        localb.content = ii(paramString2, paramString3);
      }
    }
    label953:
    Collections.sort(localArrayList, new Comparator() {});
    int i = 0;
    while (i < k)
    {
      locala.DpG.put(Integer.valueOf(locala.DpG.size() + 1), localArrayList.get(i));
      i += 1;
    }
    label1008:
    locala.field_key = a(locala);
    jla.put(Integer.valueOf(j), locala);
    AppMethodBeat.o(110355);
    return locala;
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
      parama.field_msgSvrId = ((n)h.ae(n.class)).eSe().Oq(parama.field_firstMsgId).field_msgSvrId;
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "fixMsgSvrId ret:%s", new Object[] { Boolean.valueOf(((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true)) });
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
      if (Util.isNullOrNil(parama.field_username)) {
        parama.field_username = paramString1;
      }
      if (Util.isNullOrNil(parama.field_creator)) {
        parama.field_creator = paramString2;
      }
      paramString1 = new HashMap();
      HashSet localHashSet = new HashSet();
      parama.DpH = false;
      parama.header = parama.header.trim();
      parama.DpD = parama.DpD.trim();
      parama.CBX = parama.CBX.trim();
      int i = 1;
      while (i <= parama.DpG.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i));
        if ((!Util.isNullOrNil(localb.content)) && (!Util.isNullOrNil(localb.content.trim())))
        {
          localb.content = localb.content.trim();
          if (localHashSet.contains(((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).atQ(localb.content))) {
            parama.DpH = true;
          }
          localHashSet.add(((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).atQ(localb.content));
          paramString1.put(Integer.valueOf(paramString1.size() + 1), localb);
          if (localb.createtime == 9223372036854775807L) {
            localb.createtime = paramLong;
          }
          if (Util.isNullOrNil(localb.username)) {
            localb.username = paramString2;
          }
        }
        i += 1;
      }
    }
    parama.DpG = paramString1;
    AppMethodBeat.o(110339);
  }
  
  public static boolean ba(Context paramContext, String paramString)
  {
    AppMethodBeat.i(110335);
    if ((Util.isNullOrNil(paramString)) || (paramContext == null))
    {
      AppMethodBeat.o(110335);
      return false;
    }
    paramString = paramString.trim();
    if ((Util.isEqual(paramString, paramContext.getString(b.g.eGl))) || (Util.isEqual(paramString, paramContext.getString(b.g.DoN))))
    {
      AppMethodBeat.o(110335);
      return true;
    }
    AppMethodBeat.o(110335);
    return false;
  }
  
  public static boolean bb(Context paramContext, String paramString)
  {
    AppMethodBeat.i(110336);
    if ((Util.isNullOrNil(paramString)) || (paramContext == null))
    {
      AppMethodBeat.o(110336);
      return false;
    }
    paramString = paramString.trim();
    if ((paramString.startsWith(paramContext.getString(b.g.eGl))) || (paramString.startsWith(paramContext.getString(b.g.DoN))))
    {
      AppMethodBeat.o(110336);
      return true;
    }
    AppMethodBeat.o(110336);
    return false;
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
    if ((parama != null) && (parama.DpH))
    {
      HashMap localHashMap = new HashMap();
      HashSet localHashSet = new HashSet();
      parama.DpH = false;
      int i = 1;
      while (i <= parama.DpG.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i));
        if (!localHashSet.contains(localb.content))
        {
          localHashSet.add(localb.content);
          localHashMap.put(Integer.valueOf(localHashMap.size() + 1), localb);
        }
        i += 1;
      }
      parama.DpG = localHashMap;
    }
    AppMethodBeat.o(110340);
  }
  
  public static boolean d(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110351);
    if (parama == null)
    {
      AppMethodBeat.o(110351);
      return false;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRG, 0);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getKeywordCheckSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (i = 1; i != 0; i = 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (parama.DpE == 1) {
        localStringBuilder.append(parama.header);
      }
      localStringBuilder.append(parama.DpD).append(parama.CBX);
      parama = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRZ, "(接龙|报名|参加|参与|活动|组织|投票|回复|统计)");
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", new Object[] { parama });
      boolean bool = Pattern.compile(parama).matcher(localStringBuilder.toString()).find();
      AppMethodBeat.o(110351);
      return bool;
    }
    AppMethodBeat.o(110351);
    return true;
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
    localStringBuilder.append("<tt>").append(Util.escapeStringForXml(parama.header)).append("</tt>");
    localStringBuilder.append("<ex>").append(Util.escapeStringForXml(parama.DpD)).append("</ex>");
    localStringBuilder.append("<tl>").append(Util.escapeStringForXml(parama.CBX)).append("</tl>");
    localStringBuilder.append("<s>").append(Util.escapeStringForXml(parama.bOX)).append("</s>");
    localStringBuilder.append("<au>").append(parama.field_creator).append("</au>");
    localStringBuilder.append("<hrt>").append(parama.DpE).append("</hrt>");
    localStringBuilder.append("<content>");
    localStringBuilder.append("<s>").append(parama.DpG.size()).append("</s>");
    int i = 1;
    while (i <= parama.DpG.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i));
      if (localb != null)
      {
        localStringBuilder.append("<i>");
        localStringBuilder.append("<u>").append(localb.username).append("</u>");
        localStringBuilder.append("<h>").append(localb.DpJ).append("</h>");
        localStringBuilder.append("<s>").append(Util.escapeStringForXml(localb.bOX)).append("</s>");
        localStringBuilder.append("<t>").append(localb.createtime).append("</t>");
        localStringBuilder.append("<c>").append(Util.escapeStringForXml(localb.content)).append("</c>");
        localStringBuilder.append("<o>").append(localb.DpK).append("</o>");
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
  
  public static String eBa()
  {
    AppMethodBeat.i(110322);
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRI, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])(\\s*)");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mainBodyRegex:%s", new Object[] { str });
    AppMethodBeat.o(110322);
    return str;
  }
  
  public static String eBb()
  {
    AppMethodBeat.i(110323);
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRJ, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "separatorRegex:%s", new Object[] { str });
    AppMethodBeat.o(110323);
    return str;
  }
  
  public static String eBc()
  {
    AppMethodBeat.i(110324);
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRK, "([0-9]{1,3})(\\s*)([.。;；、:,，])");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentSeparatorRegex:%s", new Object[] { str });
    AppMethodBeat.o(110324);
    return str;
  }
  
  public static String eBd()
  {
    AppMethodBeat.i(110325);
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRL, "^\\d{1,3}");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "numRegex:%s", new Object[] { str });
    AppMethodBeat.o(110325);
    return str;
  }
  
  public static String eBe()
  {
    AppMethodBeat.i(246412);
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRM, "^\\d{1,3}$");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "SingleNum:%s", new Object[] { str });
    AppMethodBeat.o(246412);
    return str;
  }
  
  public static String eBf()
  {
    AppMethodBeat.i(110326);
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRN, "\\d{1,3}");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentNumRegex:%s", new Object[] { str });
    AppMethodBeat.o(110326);
    return str;
  }
  
  public static String eBg()
  {
    AppMethodBeat.i(110327);
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRO, "(例|例如|如|格式|格式如)(\\s*)([,.:，：、 ])(.+)");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", new Object[] { str });
    AppMethodBeat.o(110327);
    return str;
  }
  
  public static int eBh()
  {
    AppMethodBeat.i(110328);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRP, 3);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireActiveIntervalTime() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110328);
    return i;
  }
  
  public static int eBi()
  {
    AppMethodBeat.i(110329);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRQ, 5);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireActiveNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110329);
    return i;
  }
  
  public static int eBj()
  {
    AppMethodBeat.i(110330);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRR, 24);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireMatchIntervalTime() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110330);
    return i;
  }
  
  public static int eBk()
  {
    AppMethodBeat.i(110331);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRS, 10);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireMatchNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110331);
    return i;
  }
  
  public static int eBl()
  {
    AppMethodBeat.i(110332);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRH, 500);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110332);
    return i;
  }
  
  public static int eBm()
  {
    AppMethodBeat.i(110333);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRW, 150);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110333);
    return i;
  }
  
  public static int eBn()
  {
    AppMethodBeat.i(178792);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRX, 500);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(178792);
    return i;
  }
  
  public static int eBo()
  {
    AppMethodBeat.i(178793);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRY, 500);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(178793);
    return i;
  }
  
  private static boolean eBp()
  {
    AppMethodBeat.i(246414);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSc, 0);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "isXmlForceUseCTagSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(246414);
      return true;
    }
    AppMethodBeat.o(246414);
    return false;
  }
  
  public static String eBq()
  {
    AppMethodBeat.i(246415);
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSb, "(\\.|。|,|，|:|：|;|；|、|-|\\s)");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "equalStrWhiteListRegex:%s", new Object[] { str });
    AppMethodBeat.o(246415);
    return str;
  }
  
  public static int eL(String paramString, int paramInt)
  {
    AppMethodBeat.i(110364);
    int j = paramString.length();
    int i = 0;
    while (i <= j)
    {
      int m = (i + j) / 2;
      int n = aKZ(paramString.substring(0, m));
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
  
  public static void f(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110354);
    Object localObject = parama.field_content;
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
      AppMethodBeat.o(110354);
      return;
    }
    if (!((String)localObject).trim().contains("<solitaire>"))
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "<solitaire> no contains");
      AppMethodBeat.o(110354);
      return;
    }
    Map localMap = XmlParser.parseXml((String)localObject, "solitaire", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "newValues is null: %s", new Object[] { localObject });
      AppMethodBeat.o(110354);
      return;
    }
    parama.header = ((String)localMap.get(".solitaire.tt"));
    parama.DpD = ((String)localMap.get(".solitaire.ex"));
    parama.CBX = ((String)localMap.get(".solitaire.tl"));
    parama.bOX = ((String)localMap.get(".solitaire.s"));
    parama.field_creator = ((String)localMap.get(".solitaire.au"));
    parama.DpE = Util.getInt((String)localMap.get(".solitaire.hrt"), 1);
    if (localMap.containsKey(".solitaire.content" + ".s"))
    {
      int j = Util.getInt((String)localMap.get(".solitaire.content" + ".s"), 0);
      localObject = new ArrayList();
      int i = 0;
      if (i < j)
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
        if (i == 0)
        {
          localb.username = ((String)localMap.get(".solitaire.content.i" + ".u"));
          localb.DpJ = Util.getInt((String)localMap.get(".solitaire.content.i" + ".h"), 0);
          localb.bOX = ((String)localMap.get(".solitaire.content.i" + ".s"));
          localb.createtime = Util.getLong((String)localMap.get(".solitaire.content.i" + ".t"), 0L);
          localb.content = ((String)localMap.get(".solitaire.content.i" + ".c"));
        }
        for (localb.DpK = Util.getInt((String)localMap.get(".solitaire.content.i" + ".o"), 0);; localb.DpK = Util.getInt((String)localMap.get(".solitaire.content.i" + i + ".o"), 0))
        {
          ((ArrayList)localObject).add(localb);
          i += 1;
          break;
          localb.username = ((String)localMap.get(".solitaire.content.i" + i + ".u"));
          localb.DpJ = Util.getInt((String)localMap.get(".solitaire.content.i" + i + ".h"), 0);
          localb.bOX = ((String)localMap.get(".solitaire.content.i" + i + ".s"));
          localb.createtime = Util.getLong((String)localMap.get(".solitaire.content.i" + i + ".t"), 0L);
          localb.content = ((String)localMap.get(".solitaire.content.i" + i + ".c"));
        }
      }
      Collections.sort((List)localObject, new Comparator() {});
      i = 0;
      while (i < j)
      {
        parama.DpG.put(Integer.valueOf(parama.DpG.size() + 1), ((ArrayList)localObject).get(i));
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
    if ((parama.header != null) && (!Util.isNullOrNil(parama.header.trim())) && (parama.DpE == 1))
    {
      parama.header = parama.header.trim();
      localStringBuilder.append(parama.header).append("\n");
    }
    if ((parama.DpD != null) && (!Util.isNullOrNil(parama.DpD.trim())))
    {
      parama.DpD = parama.DpD.trim();
      localStringBuilder.append(parama.DpD).append("\n");
    }
    if (!Util.isNullOrNil(localStringBuilder.toString())) {
      localStringBuilder.append("\n");
    }
    if (parama.DpG.size() > 0)
    {
      int i = 1;
      while (i <= parama.DpG.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i));
        localStringBuilder.append(i).append(parama.bOX).append(" ").append(localb.content);
        if (i < parama.DpG.size()) {
          localStringBuilder.append("\n");
        }
        i += 1;
      }
    }
    if ((parama.CBX != null) && (!Util.isNullOrNil(parama.CBX.trim())))
    {
      parama.CBX = parama.CBX.trim();
      localStringBuilder.append("\n");
      localStringBuilder.append("\n");
      localStringBuilder.append(parama.CBX);
    }
    parama = localStringBuilder.toString();
    AppMethodBeat.o(110356);
    return parama;
  }
  
  public static boolean h(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110362);
    if (parama == null)
    {
      AppMethodBeat.o(110362);
      return false;
    }
    if ((parama.DpE == 1) && (aKX(parama.header)))
    {
      AppMethodBeat.o(110362);
      return true;
    }
    AppMethodBeat.o(110362);
    return false;
  }
  
  public static Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> jdMethod_if(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110350);
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = new Pair(Boolean.FALSE, null);
      AppMethodBeat.o(110350);
      return paramString1;
    }
    paramString1 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().ik(paramString1, paramString2);
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
  
  private static Pair<Integer, Integer> ig(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110357);
    if (eBp())
    {
      AppMethodBeat.o(110357);
      return null;
    }
    if (Util.isNullOrNil(paramString1))
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
  
  private static String ih(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110358);
    paramString1 = ig(paramString1, paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(110358);
      return paramString2;
    }
    paramString1 = paramString1.first + "-" + paramString1.second;
    AppMethodBeat.o(110358);
    return paramString1;
  }
  
  private static String ii(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110359);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110359);
      return "";
    }
    String[] arrayOfString = paramString2.split("-");
    if ((arrayOfString != null) && (arrayOfString.length == 2))
    {
      int i = Util.getInt(arrayOfString[0], 0);
      int j = Util.getInt(arrayOfString[1], 0) + i;
      if ((i >= 0) && (j <= paramString1.length()))
      {
        paramString1 = paramString1.substring(i, j);
        AppMethodBeat.o(110359);
        return paramString1;
      }
    }
    AppMethodBeat.o(110359);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.b
 * JD-Core Version:    0.7.0.1
 */