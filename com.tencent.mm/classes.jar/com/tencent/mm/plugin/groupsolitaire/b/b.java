package com.tencent.mm.plugin.groupsolitaire.b;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
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
  private static final f<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> fwL;
  
  static
  {
    AppMethodBeat.i(110365);
    fwL = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(110365);
  }
  
  public static boolean P(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(192529);
    paramString2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().gK(paramString1, paramString2);
    paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().adn(paramString1);
    if (paramString2 == null)
    {
      AppMethodBeat.o(192529);
      return true;
    }
    boolean bool;
    if (paramString1 == null) {
      bool = true;
    }
    while ((!bool) && (bt.kU(paramString2.field_creator, u.aqG())) && (paramInt <= 1))
    {
      AppMethodBeat.o(192529);
      return true;
      int i;
      if ((paramString2.field_active == 1) && (paramString2.field_lastActiveTime >= paramString1.sqv) && (paramString2.sra.size() < cEW()))
      {
        i = 1;
        label121:
        if ((paramString2.field_active != 0) || (paramString2.field_lastActiveTime < paramString1.sqx)) {
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
    AppMethodBeat.o(192529);
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
    if (!bt.kU(parama1.field_key, parama3.field_key))
    {
      AppMethodBeat.o(178794);
      return parama1;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = parama3.cFd();
    Object localObject1 = new LinkedHashSet();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject2 = new LinkedHashSet();
    Object localObject3 = new LinkedHashSet();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    if (i <= parama3.sra.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = ((com.tencent.mm.plugin.groupsolitaire.c.b)parama3.sra.get(Integer.valueOf(i))).cFe();
      if (bt.kU(localb.username, u.aqG()))
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
      while (i <= parama2.sra.size())
      {
        ((Set)localObject3).add(((com.tencent.mm.plugin.groupsolitaire.c.b)parama2.sra.get(Integer.valueOf(i))).cFe());
        i += 1;
      }
    }
    i = 1;
    while (i <= parama1.sra.size())
    {
      parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.sra.get(Integer.valueOf(i));
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
        } while (!bt.iY(parama2.srf, ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).srf));
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
      locala.sra.clear();
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
        localObject1 = locala.sra;
        i += 1;
        ((HashMap)localObject1).put(Integer.valueOf(i), parama3);
      }
      locala.srd = parama1.srd;
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
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puI, 1);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLossEfficacySwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(174561);
      return parama2;
    }
    if (paramInt == 1)
    {
      if (!bt.kU(paramString, parama2.field_creator))
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
      if (parama1.sra.size() > 1)
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
    }
    else if (paramInt != 2)
    {
      if (paramInt == 3)
      {
        if (!parama1.sqZ)
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
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "handleSolitatireLossEfficacy key:%s result:%s", new Object[] { parama2.field_key, Boolean.valueOf(bool) });
      AppMethodBeat.o(174561);
      return null;
      bool = parama1.delete(parama2.systemRowid);
      if (bool) {
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().gL(parama2.field_username, parama2.field_key);
      }
    }
  }
  
  private static com.tencent.mm.plugin.groupsolitaire.c.a a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(192532);
    if ((parama1 == null) && (parama2 == null))
    {
      AppMethodBeat.o(192532);
      return null;
    }
    if ((parama1 == null) && (parama2 != null))
    {
      AppMethodBeat.o(192532);
      return parama2;
    }
    if ((parama1 != null) && (parama2 == null))
    {
      AppMethodBeat.o(192532);
      return parama1;
    }
    if (!bt.kU(parama1.field_key, parama2.field_key))
    {
      AppMethodBeat.o(192532);
      return parama1;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = parama2.cFd();
    Object localObject1 = new LinkedHashSet();
    if (paramBoolean2) {
      while (i <= parama1.sra.size())
      {
        parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.sra.get(Integer.valueOf(i));
        if (!((Set)localObject1).contains(parama2)) {
          ((Set)localObject1).add(parama2);
        }
        i += 1;
      }
    }
    Object localObject2 = new HashSet();
    HashMap localHashMap = new HashMap();
    i = 1;
    if (i <= parama2.sra.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama2.sra.get(Integer.valueOf(i));
      if (!bt.kU(localb.username, paramString)) {
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
    if (i <= parama1.sra.size())
    {
      parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.sra.get(Integer.valueOf(i));
      if ((!((Set)localObject1).contains(parama2)) && (bt.kU(parama2.username, paramString)))
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
    locala.sra.clear();
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
      localObject1 = locala.sra;
      i += 1;
      ((HashMap)localObject1).put(Integer.valueOf(i), paramString);
    }
    locala.srd = parama1.srd;
    AppMethodBeat.o(192532);
    return locala;
  }
  
  private static bml a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.b paramb, int paramInt)
  {
    AppMethodBeat.i(192534);
    bml localbml = new bml();
    localbml.DJT = (paramInt + paramString2 + " ");
    a(localbml, paramString1, paramb.content);
    AppMethodBeat.o(192534);
    return localbml;
  }
  
  public static String a(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110334);
    if ((bt.isNullOrNil(parama.header)) && (bt.isNullOrNil(parama.sqW)) && (bt.isNullOrNil(parama.sqX)) && (parama.sqY == 1))
    {
      parama.sqY = 0;
      if (parama.sra.size() > 0)
      {
        parama.header = ((com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(1))).content;
        ((com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(1))).sre = 1;
      }
    }
    parama = com.tencent.mm.b.g.getMessageDigest(aj.getContext().getString(2131760100, new Object[] { parama.header.trim(), parama.sqY, parama.sqW.trim(), parama.sqX.trim() }).getBytes());
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
    localStringBuilder2.append("<tt>").append(gH(paramString, parama.header)).append("</tt>");
    localStringBuilder2.append("<ex>").append(gH(paramString, parama.sqW)).append("</ex>");
    localStringBuilder2.append("<tl>").append(gH(paramString, parama.sqX)).append("</tl>");
    localStringBuilder2.append("<s>").append(bt.aGf(parama.separator)).append("</s>");
    localStringBuilder2.append("<au>").append(parama.field_creator).append("</au>");
    localStringBuilder2.append("<hrt>").append(parama.sqY).append("</hrt>");
    Object localObject = localStringBuilder2.append("<loss>");
    int i;
    label285:
    Pair localPair;
    if (paramBoolean)
    {
      i = 1;
      ((StringBuilder)localObject).append(i).append("</loss>");
      localStringBuilder2.append("<content>");
      localStringBuilder2.append("<s>").append(parama.sra.size()).append("</s>");
      i = j;
      if (i > parama.sra.size()) {
        break label510;
      }
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(i));
      if (localObject != null)
      {
        localStringBuilder2.append("<i>");
        localStringBuilder2.append("<u>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).username).append("</u>");
        localStringBuilder2.append("<h>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).sre).append("</h>");
        localStringBuilder2.append("<s>").append(bt.aGf(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).separator)).append("</s>");
        localStringBuilder2.append("<t>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).createtime).append("</t>");
        localPair = gG(paramString, ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content);
        if (localPair != null) {
          break label484;
        }
        localStringBuilder2.append("<c>").append(bt.aGf(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content)).append("</c>");
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
    AppMethodBeat.i(192533);
    if (parama == null)
    {
      ad.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: groupSolitatire is null");
      AppMethodBeat.o(192533);
      return;
    }
    bl localbl;
    Object localObject3;
    bmk localbmk;
    Object localObject1;
    if (paramLong != 0L)
    {
      localbl = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(paramLong);
      localObject3 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(parama.field_username, parama.field_key, false);
      localbmk = new bmk();
      if (localbl.isText()) {
        localObject1 = localbl.field_content;
      }
    }
    for (;;)
    {
      if (bt.isNullOrNil((String)localObject1))
      {
        ad.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: content is null");
        AppMethodBeat.o(192533);
        return;
        if (localbl.eMh())
        {
          localObject1 = k.b.rx(localbl.field_content);
          if (localObject1 == null)
          {
            ad.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: amc is null");
            AppMethodBeat.o(192533);
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
            if (parama.sqY != 0) {
              break label1045;
            }
            i = 2;
          }
        }
        for (;;)
        {
          if (i <= parama.sra.size())
          {
            localObject3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(i));
            if ((!bt.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content)) && (!bt.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content.trim())))
            {
              ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content = ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content.trim();
              if (bt.kU(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).username, paramString)) {
                localbmk.DJQ.add(a((String)localObject1, (String)localObject2, (com.tencent.mm.plugin.groupsolitaire.c.b)localObject3, i));
              }
            }
            i += 1;
            continue;
            LinkedHashSet localLinkedHashSet = new LinkedHashSet();
            i = 1;
            while (i <= ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).sra.size())
            {
              com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).sra.get(Integer.valueOf(i));
              if ((localb != null) && (bt.kU(localb.username, paramString))) {
                localLinkedHashSet.add(localb);
              }
              i += 1;
            }
            i = 1;
            if (i <= parama.sra.size())
            {
              localObject3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(i));
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
          if (localbmk.DJQ.size() <= 0)
          {
            paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(parama.sra.size()));
            localbmk.DJQ.add(a((String)localObject1, (String)localObject2, paramString, parama.sra.size()));
          }
          if (parama.sqY == 0) {}
          for (i = parama.sra.size() - localbmk.DJQ.size() - 1; i < 2; i = parama.sra.size() - localbmk.DJQ.size())
          {
            ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg fold condition min num is not");
            AppMethodBeat.o(192533);
            return;
          }
          localbmk.sqY = parama.sqY;
          localbmk.DJS = (parama.sra.size() - localbmk.DJQ.size());
          localbmk.drA = parama.field_msgSvrId;
          localbmk.key = parama.field_key;
          if (parama.sqY == 0)
          {
            paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(1));
            localbmk.DJP.add(a((String)localObject1, (String)localObject2, paramString, 1));
          }
          for (;;)
          {
            if ((parama.sqX != null) && (!bt.isNullOrNil(parama.sqX.trim())))
            {
              paramString = new bml();
              a(paramString, (String)localObject1, parama.sqX.trim());
              localbmk.DJR = paramString;
            }
            localbl.field_solitaireFoldInfo = localbmk;
            localbl.eOM = true;
            try
            {
              ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(localbl.field_msgId, localbl);
              ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId:%s", new Object[] { Long.valueOf(localbl.field_msgId) });
              AppMethodBeat.o(192533);
              return;
              if ((parama.header != null) && (!bt.isNullOrNil(parama.header.trim())))
              {
                paramString = new bml();
                a(paramString, (String)localObject1, parama.header.trim());
                localbmk.DJP.add(paramString);
              }
              if ((parama.sqW != null) && (!bt.isNullOrNil(parama.sqW.trim())))
              {
                paramString = gG((String)localObject1, parama.sqW.trim());
                localObject2 = new bml();
                if (paramString == null) {
                  ((bml)localObject2).start = 0;
                }
                for (((bml)localObject2).end = 0;; ((bml)localObject2).end = (((Integer)paramString.second).intValue() + i))
                {
                  localbmk.DJP.add(localObject2);
                  break;
                  if (localbmk.DJP.size() > 0) {
                    ((bml)localObject2).DJT = "\n";
                  }
                  ((bml)localObject2).start = ((Integer)paramString.first).intValue();
                  i = ((Integer)paramString.first).intValue();
                }
              }
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                ad.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
              }
            }
          }
          ad.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId == 0");
          AppMethodBeat.o(192533);
          return;
          label1045:
          i = 1;
        }
      }
      localObject1 = "";
    }
  }
  
  private static void a(bml parambml, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192535);
    paramString1 = gG(paramString1, paramString2);
    if (paramString1 == null)
    {
      parambml.start = 0;
      parambml.end = 0;
      AppMethodBeat.o(192535);
      return;
    }
    parambml.start = ((Integer)paramString1.first).intValue();
    int i = ((Integer)paramString1.first).intValue();
    parambml.end = (((Integer)paramString1.second).intValue() + i);
    AppMethodBeat.o(192535);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110346);
    if (parama == null)
    {
      AppMethodBeat.o(110346);
      return;
    }
    String str = u.aqG();
    if (bt.isNullOrNil(parama.field_creator)) {
      parama.field_creator = str;
    }
    if (bt.isNullOrNil(parama.field_username)) {
      parama.field_username = paramString;
    }
    int i = 1;
    while (i <= parama.sra.size())
    {
      paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(i));
      if (bt.isNullOrNil(paramString.username)) {
        paramString.username = str;
      }
      i += 1;
    }
    AppMethodBeat.o(110346);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110338);
    b(paramString1, paramString2, parama, ce.asT(), true);
    AppMethodBeat.o(110338);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110337);
    long l = ce.asT();
    if (paramLong != 0L) {
      l = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(paramLong).field_createTime / 1000L;
    }
    b(paramString1, paramString2, parama, l, paramBoolean);
    AppMethodBeat.o(110337);
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, long paramLong1, boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong2)
  {
    AppMethodBeat.i(192530);
    paramBoolean1 = a(parama1, parama2, paramLong1, paramBoolean1, paramString, paramBoolean2, false, paramLong2);
    AppMethodBeat.o(192530);
    return paramBoolean1;
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, long paramLong1, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, long paramLong2)
  {
    AppMethodBeat.i(192531);
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
        bl localbl = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(paramLong1);
        localbl.og(parama1.field_key);
        ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(paramLong1, localbl);
        if ((paramBoolean1) && (parama2 != null) && (parama2.field_active == 0) && (locala.sra.size() > 1))
        {
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          d.b(locala, paramString);
        }
        if ((parama2 == null) && (locala != null))
        {
          parama1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(locala.field_username, locala.field_key, true);
          if (parama1.field_msgSvrId == 0L)
          {
            parama1.field_msgSvrId = localbl.field_msgSvrId;
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
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mergeAndSaveGroupSolitatire() key:%s msgId:%s ret:%s", new Object[] { parama1, Long.valueOf(paramLong1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(192531);
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
    if (!((i)com.tencent.mm.kernel.g.ab(i.class)).adh(parama.field_username))
    {
      AppMethodBeat.o(110344);
      return false;
    }
    ad.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire key:%s exist:%s supportOnlyOne:%s num:%s", new Object[] { parama.field_key, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(parama.sra.size()) });
    if (paramBoolean1) {
      if (parama.sra.size() > cEW()) {
        paramBoolean1 = false;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() ret:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
      if (paramBoolean1)
      {
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().ado(parama.field_username);
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().gL(parama.field_username, parama.field_key);
        adi(parama.field_username);
      }
      ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() groupSolitatire:%s", new Object[] { parama });
      AppMethodBeat.o(110344);
      return paramBoolean1;
      paramBoolean1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, false);
      continue;
      if ((paramBoolean2) && (parama.sra.size() > 1)) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().i(parama);
      }
    }
  }
  
  public static boolean aA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(110336);
    if ((bt.isNullOrNil(paramString)) || (paramContext == null))
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
  
  public static void adi(String paramString)
  {
    AppMethodBeat.i(110345);
    ad.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() batch delete expire data!! (%s)", new Object[] { paramString });
    if ((bt.isNullOrNil(paramString)) || (!w.pF(paramString)))
    {
      AppMethodBeat.o(110345);
      return;
    }
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110317);
        a locala = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().adn(this.fqK);
        if (locala == null)
        {
          ad.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() chatRoomGroupSolitatire == null");
          AppMethodBeat.o(110317);
          return;
        }
        List localList = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().k(this.fqK, 1, locala.sqv);
        boolean bool2;
        if (localList.size() > 0)
        {
          bool2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().l(this.fqK, 1, locala.sqv);
          if (locala.squ)
          {
            ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.q(localList, 2);
          }
        }
        for (;;)
        {
          localList = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().k(this.fqK, 0, locala.sqx);
          boolean bool1;
          if (localList.size() > 0)
          {
            bool1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().l(this.fqK, 0, locala.sqx);
            if (locala.sqw)
            {
              ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              d.q(localList, 2);
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() activeResult:%s unActiveResult:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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
  
  public static boolean adj(String paramString)
  {
    AppMethodBeat.i(110360);
    if (adm(paramString) > cEX() * 2)
    {
      AppMethodBeat.o(110360);
      return true;
    }
    AppMethodBeat.o(110360);
    return false;
  }
  
  public static boolean adk(String paramString)
  {
    AppMethodBeat.i(110361);
    if (adm(paramString) > cEY() * 2)
    {
      AppMethodBeat.o(110361);
      return true;
    }
    AppMethodBeat.o(110361);
    return false;
  }
  
  public static boolean adl(String paramString)
  {
    AppMethodBeat.i(178795);
    if (adm(paramString) > cEZ() * 2)
    {
      AppMethodBeat.o(178795);
      return true;
    }
    AppMethodBeat.o(178795);
    return false;
  }
  
  public static int adm(String paramString)
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
      ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "length:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(110363);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getStringByteLen Exception：%s，%s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        int i = paramString.getBytes().length;
      }
    }
  }
  
  public static com.tencent.mm.plugin.groupsolitaire.c.a ae(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(110355);
    if (bt.isNullOrNil(paramString3))
    {
      ad.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
      AppMethodBeat.o(110355);
      return null;
    }
    int j = (paramString3 + bt.by(paramString2, "")).hashCode();
    Object localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)fwL.get(Integer.valueOf(j));
    if (localObject != null)
    {
      ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "get GroupSolitatire data from cache");
      AppMethodBeat.o(110355);
      return localObject;
    }
    if (!paramString3.trim().contains("<solitaire>"))
    {
      AppMethodBeat.o(110355);
      return null;
    }
    localObject = bw.K(paramString3, "solitaire");
    if (localObject == null)
    {
      ad.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "newValues is null: %s", new Object[] { paramString3 });
      AppMethodBeat.o(110355);
      return null;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
    locala.header = gI(paramString2, (String)((Map)localObject).get(".solitaire.tt"));
    locala.sqW = gI(paramString2, (String)((Map)localObject).get(".solitaire.ex"));
    locala.sqX = gI(paramString2, (String)((Map)localObject).get(".solitaire.tl"));
    locala.separator = ((String)((Map)localObject).get(".solitaire.s"));
    locala.field_creator = ((String)((Map)localObject).get(".solitaire.au"));
    locala.field_username = paramString1;
    locala.sqY = bt.getInt((String)((Map)localObject).get(".solitaire.hrt"), 1);
    boolean bool;
    int k;
    ArrayList localArrayList;
    label408:
    com.tencent.mm.plugin.groupsolitaire.c.b localb;
    if (bt.getInt((String)((Map)localObject).get(".solitaire.loss"), 0) == 1)
    {
      bool = true;
      locala.sqZ = bool;
      if (!((Map)localObject).containsKey(".solitaire.content" + ".s")) {
        break label1007;
      }
      k = bt.getInt((String)((Map)localObject).get(".solitaire.content" + ".s"), 0);
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
      localb.sre = bt.getInt((String)((Map)localObject).get(".solitaire.content.i" + ".h"), 0);
      localb.separator = ((String)((Map)localObject).get(".solitaire.content.i" + ".s"));
      localb.createtime = bt.getLong((String)((Map)localObject).get(".solitaire.content.i" + ".t"), 0L);
      paramString1 = (String)((Map)localObject).get(".solitaire.content.i" + ".c");
      paramString3 = (String)((Map)localObject).get(".solitaire.content.i" + ".r");
      label649:
      if (bt.isNullOrNil(paramString1)) {
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
      localb.sre = bt.getInt((String)((Map)localObject).get(".solitaire.content.i" + i + ".h"), 0);
      localb.separator = ((String)((Map)localObject).get(".solitaire.content.i" + i + ".s"));
      localb.createtime = bt.getLong((String)((Map)localObject).get(".solitaire.content.i" + i + ".t"), 0L);
      paramString1 = (String)((Map)localObject).get(".solitaire.content.i" + i + ".c");
      paramString3 = (String)((Map)localObject).get(".solitaire.content.i" + i + ".r");
      break label649;
      label932:
      if (!bt.isNullOrNil(paramString3)) {
        localb.content = gI(paramString2, paramString3);
      }
    }
    label952:
    Collections.sort(localArrayList, new Comparator() {});
    int i = 0;
    while (i < k)
    {
      locala.sra.put(Integer.valueOf(locala.sra.size() + 1), localArrayList.get(i));
      i += 1;
    }
    label1007:
    locala.field_key = a(locala);
    fwL.put(Integer.valueOf(j), locala);
    AppMethodBeat.o(110355);
    return locala;
  }
  
  public static boolean aj(bl parambl)
  {
    AppMethodBeat.i(110341);
    if (parambl == null)
    {
      AppMethodBeat.o(110341);
      return false;
    }
    Object localObject1 = parambl.field_talker;
    Object localObject2 = parambl.ePf;
    if (((i)com.tencent.mm.kernel.g.ab(i.class)).adh((String)localObject1))
    {
      localObject2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().gK((String)localObject1, (String)localObject2);
      localObject1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().adn((String)localObject1);
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
      if ((((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_active == 1) && (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_lastActiveTime >= ((a)localObject1).sqv) && (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).sra.size() < cEW()) && (parambl.field_msgId >= ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_firstMsgId))
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
  
  public static boolean az(Context paramContext, String paramString)
  {
    AppMethodBeat.i(110335);
    if ((bt.isNullOrNil(paramString)) || (paramContext == null))
    {
      AppMethodBeat.o(110335);
      return false;
    }
    paramString = paramString.trim();
    if ((bt.kU(paramString, paramContext.getString(2131760093))) || (bt.kU(paramString, paramContext.getString(2131760094))))
    {
      AppMethodBeat.o(110335);
      return true;
    }
    AppMethodBeat.o(110335);
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
      parama.field_msgSvrId = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(parama.field_firstMsgId).field_msgSvrId;
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "fixMsgSvrId ret:%s", new Object[] { Boolean.valueOf(((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true)) });
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
      if (bt.isNullOrNil(parama.field_username)) {
        parama.field_username = paramString1;
      }
      if (bt.isNullOrNil(parama.field_creator)) {
        parama.field_creator = paramString2;
      }
      paramString1 = new HashMap();
      HashSet localHashSet = new HashSet();
      parama.srb = false;
      parama.header = parama.header.trim();
      parama.sqW = parama.sqW.trim();
      parama.sqX = parama.sqX.trim();
      int i = 1;
      while (i <= parama.sra.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(i));
        if ((!bt.isNullOrNil(localb.content)) && (!bt.isNullOrNil(localb.content.trim())))
        {
          localb.content = localb.content.trim();
          if (localHashSet.contains(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Tk(localb.content))) {
            parama.srb = true;
          }
          localHashSet.add(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Tk(localb.content));
          paramString1.put(Integer.valueOf(paramString1.size() + 1), localb);
          if (localb.createtime == 9223372036854775807L) {
            localb.createtime = paramLong;
          }
          if (bt.isNullOrNil(localb.username)) {
            localb.username = paramString2;
          }
        }
        i += 1;
      }
    }
    parama.sra = paramString1;
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
    if ((parama != null) && (parama.srb))
    {
      HashMap localHashMap = new HashMap();
      HashSet localHashSet = new HashSet();
      parama.srb = false;
      int i = 1;
      while (i <= parama.sra.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(i));
        if (!localHashSet.contains(localb.content))
        {
          localHashSet.add(localb.content);
          localHashMap.put(Integer.valueOf(localHashMap.size() + 1), localb);
        }
        i += 1;
      }
      parama.sra = localHashMap;
    }
    AppMethodBeat.o(110340);
  }
  
  public static String cEL()
  {
    AppMethodBeat.i(110322);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puq, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])(\\s*)");
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mainBodyRegex:%s", new Object[] { str });
    AppMethodBeat.o(110322);
    return str;
  }
  
  public static String cEM()
  {
    AppMethodBeat.i(110323);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pur, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])");
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "separatorRegex:%s", new Object[] { str });
    AppMethodBeat.o(110323);
    return str;
  }
  
  public static String cEN()
  {
    AppMethodBeat.i(110324);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pus, "([0-9]{1,3})(\\s*)([.。;；、:,，])");
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentSeparatorRegex:%s", new Object[] { str });
    AppMethodBeat.o(110324);
    return str;
  }
  
  public static String cEO()
  {
    AppMethodBeat.i(110325);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.put, "^\\d{1,3}");
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "numRegex:%s", new Object[] { str });
    AppMethodBeat.o(110325);
    return str;
  }
  
  public static String cEP()
  {
    AppMethodBeat.i(192527);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puu, "^\\d{1,3}$");
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "SingleNum:%s", new Object[] { str });
    AppMethodBeat.o(192527);
    return str;
  }
  
  public static String cEQ()
  {
    AppMethodBeat.i(110326);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puv, "\\d{1,3}");
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentNumRegex:%s", new Object[] { str });
    AppMethodBeat.o(110326);
    return str;
  }
  
  public static String cER()
  {
    AppMethodBeat.i(110327);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puw, "(例|例如|如|格式|格式如)(\\s*)([,.:，：、 ])(.+)");
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", new Object[] { str });
    AppMethodBeat.o(110327);
    return str;
  }
  
  public static int cES()
  {
    AppMethodBeat.i(110328);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pux, 3);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireActiveIntervalTime() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110328);
    return i;
  }
  
  public static int cET()
  {
    AppMethodBeat.i(110329);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puy, 5);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireActiveNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110329);
    return i;
  }
  
  public static int cEU()
  {
    AppMethodBeat.i(110330);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puz, 24);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireMatchIntervalTime() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110330);
    return i;
  }
  
  public static int cEV()
  {
    AppMethodBeat.i(110331);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puA, 10);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireMatchNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110331);
    return i;
  }
  
  public static int cEW()
  {
    AppMethodBeat.i(110332);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pup, 500);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110332);
    return i;
  }
  
  public static int cEX()
  {
    AppMethodBeat.i(110333);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puE, 150);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110333);
    return i;
  }
  
  public static int cEY()
  {
    AppMethodBeat.i(178792);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puF, 500);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(178792);
    return i;
  }
  
  public static int cEZ()
  {
    AppMethodBeat.i(178793);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puG, 500);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(178793);
    return i;
  }
  
  public static String cFa()
  {
    AppMethodBeat.i(192528);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puJ, "(\\.|。|,|，|:|：|;|；|、|-|\\s)");
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "equalStrWhiteListRegex:%s", new Object[] { str });
    AppMethodBeat.o(192528);
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
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puo, 0);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getKeywordCheckSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (i = 1; i != 0; i = 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (parama.sqY == 1) {
        localStringBuilder.append(parama.header);
      }
      localStringBuilder.append(parama.sqW).append(parama.sqX);
      parama = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puH, "(接龙|报名|参加|参与|活动|组织|投票|回复|统计)");
      ad.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", new Object[] { parama });
      boolean bool = Pattern.compile(parama).matcher(localStringBuilder.toString()).find();
      AppMethodBeat.o(110351);
      return bool;
    }
    AppMethodBeat.o(110351);
    return true;
  }
  
  public static int du(String paramString, int paramInt)
  {
    AppMethodBeat.i(110364);
    int j = paramString.length();
    int i = 0;
    while (i <= j)
    {
      int m = (i + j) / 2;
      int n = adm(paramString.substring(0, m));
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
    localStringBuilder.append("<tt>").append(bt.aGf(parama.header)).append("</tt>");
    localStringBuilder.append("<ex>").append(bt.aGf(parama.sqW)).append("</ex>");
    localStringBuilder.append("<tl>").append(bt.aGf(parama.sqX)).append("</tl>");
    localStringBuilder.append("<s>").append(bt.aGf(parama.separator)).append("</s>");
    localStringBuilder.append("<au>").append(parama.field_creator).append("</au>");
    localStringBuilder.append("<hrt>").append(parama.sqY).append("</hrt>");
    localStringBuilder.append("<content>");
    localStringBuilder.append("<s>").append(parama.sra.size()).append("</s>");
    int i = 1;
    while (i <= parama.sra.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(i));
      if (localb != null)
      {
        localStringBuilder.append("<i>");
        localStringBuilder.append("<u>").append(localb.username).append("</u>");
        localStringBuilder.append("<h>").append(localb.sre).append("</h>");
        localStringBuilder.append("<s>").append(bt.aGf(localb.separator)).append("</s>");
        localStringBuilder.append("<t>").append(localb.createtime).append("</t>");
        localStringBuilder.append("<c>").append(bt.aGf(localb.content)).append("</c>");
        localStringBuilder.append("<o>").append(localb.srf).append("</o>");
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
    if (bt.isNullOrNil((String)localObject))
    {
      ad.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
      AppMethodBeat.o(110354);
      return;
    }
    if (!((String)localObject).trim().contains("<solitaire>"))
    {
      ad.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "<solitaire> no contains");
      AppMethodBeat.o(110354);
      return;
    }
    Map localMap = bw.K((String)localObject, "solitaire");
    if (localMap == null)
    {
      ad.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "newValues is null: %s", new Object[] { localObject });
      AppMethodBeat.o(110354);
      return;
    }
    parama.header = ((String)localMap.get(".solitaire.tt"));
    parama.sqW = ((String)localMap.get(".solitaire.ex"));
    parama.sqX = ((String)localMap.get(".solitaire.tl"));
    parama.separator = ((String)localMap.get(".solitaire.s"));
    parama.field_creator = ((String)localMap.get(".solitaire.au"));
    parama.sqY = bt.getInt((String)localMap.get(".solitaire.hrt"), 1);
    if (localMap.containsKey(".solitaire.content" + ".s"))
    {
      int j = bt.getInt((String)localMap.get(".solitaire.content" + ".s"), 0);
      localObject = new ArrayList();
      int i = 0;
      if (i < j)
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
        if (i == 0)
        {
          localb.username = ((String)localMap.get(".solitaire.content.i" + ".u"));
          localb.sre = bt.getInt((String)localMap.get(".solitaire.content.i" + ".h"), 0);
          localb.separator = ((String)localMap.get(".solitaire.content.i" + ".s"));
          localb.createtime = bt.getLong((String)localMap.get(".solitaire.content.i" + ".t"), 0L);
          localb.content = ((String)localMap.get(".solitaire.content.i" + ".c"));
        }
        for (localb.srf = bt.getInt((String)localMap.get(".solitaire.content.i" + ".o"), 0);; localb.srf = bt.getInt((String)localMap.get(".solitaire.content.i" + i + ".o"), 0))
        {
          ((ArrayList)localObject).add(localb);
          i += 1;
          break;
          localb.username = ((String)localMap.get(".solitaire.content.i" + i + ".u"));
          localb.sre = bt.getInt((String)localMap.get(".solitaire.content.i" + i + ".h"), 0);
          localb.separator = ((String)localMap.get(".solitaire.content.i" + i + ".s"));
          localb.createtime = bt.getLong((String)localMap.get(".solitaire.content.i" + i + ".t"), 0L);
          localb.content = ((String)localMap.get(".solitaire.content.i" + i + ".c"));
        }
      }
      Collections.sort((List)localObject, new Comparator() {});
      i = 0;
      while (i < j)
      {
        parama.sra.put(Integer.valueOf(parama.sra.size() + 1), ((ArrayList)localObject).get(i));
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
    if ((parama.header != null) && (!bt.isNullOrNil(parama.header.trim())) && (parama.sqY == 1))
    {
      parama.header = parama.header.trim();
      localStringBuilder.append(parama.header).append("\n");
    }
    if ((parama.sqW != null) && (!bt.isNullOrNil(parama.sqW.trim())))
    {
      parama.sqW = parama.sqW.trim();
      localStringBuilder.append(parama.sqW).append("\n");
    }
    if (!bt.isNullOrNil(localStringBuilder.toString())) {
      localStringBuilder.append("\n");
    }
    if (parama.sra.size() > 0)
    {
      int i = 1;
      while (i <= parama.sra.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.sra.get(Integer.valueOf(i));
        localStringBuilder.append(i).append(parama.separator).append(" ").append(localb.content);
        if (i < parama.sra.size()) {
          localStringBuilder.append("\n");
        }
        i += 1;
      }
    }
    if ((parama.sqX != null) && (!bt.isNullOrNil(parama.sqX.trim())))
    {
      parama.sqX = parama.sqX.trim();
      localStringBuilder.append("\n");
      localStringBuilder.append("\n");
      localStringBuilder.append(parama.sqX);
    }
    parama = localStringBuilder.toString();
    AppMethodBeat.o(110356);
    return parama;
  }
  
  public static Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> gF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110350);
    if (bt.isNullOrNil(paramString2))
    {
      paramString1 = new Pair(Boolean.FALSE, null);
      AppMethodBeat.o(110350);
      return paramString1;
    }
    paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().gK(paramString1, paramString2);
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
  
  private static Pair<Integer, Integer> gG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110357);
    if (bt.isNullOrNil(paramString1))
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
  
  private static String gH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110358);
    paramString1 = gG(paramString1, paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(110358);
      return paramString2;
    }
    paramString1 = paramString1.first + "-" + paramString1.second;
    AppMethodBeat.o(110358);
    return paramString1;
  }
  
  private static String gI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110359);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110359);
      return "";
    }
    paramString2 = paramString2.split("-");
    if ((paramString2 != null) && (paramString2.length == 2))
    {
      int i = bt.getInt(paramString2[0], 0);
      int j = bt.getInt(paramString2[1], 0) + i;
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
    if ((parama.sqY == 1) && (adk(parama.header)))
    {
      AppMethodBeat.o(110362);
      return true;
    }
    AppMethodBeat.o(110362);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.b
 * JD-Core Version:    0.7.0.1
 */