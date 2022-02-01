package com.tencent.mm.plugin.groupsolitaire.b;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv;
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
  private static final f<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> fVO;
  
  static
  {
    AppMethodBeat.i(110365);
    fVO = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(110365);
  }
  
  public static boolean T(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(221104);
    paramString2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hu(paramString1, paramString2);
    paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().anT(paramString1);
    if (paramString2 == null)
    {
      AppMethodBeat.o(221104);
      return true;
    }
    boolean bool;
    if (paramString1 == null) {
      bool = true;
    }
    while ((!bool) && (bu.lX(paramString2.field_creator, v.aAC())) && (paramInt <= 1))
    {
      AppMethodBeat.o(221104);
      return true;
      int i;
      if ((paramString2.field_active == 1) && (paramString2.field_lastActiveTime >= paramString1.uMC) && (paramString2.uNg.size() < ded()))
      {
        i = 1;
        label121:
        if ((paramString2.field_active != 0) || (paramString2.field_lastActiveTime < paramString1.uME)) {
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
    AppMethodBeat.o(221104);
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
    if (!bu.lX(parama1.field_key, parama3.field_key))
    {
      AppMethodBeat.o(178794);
      return parama1;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = parama3.del();
    Object localObject1 = new LinkedHashSet();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject2 = new LinkedHashSet();
    Object localObject3 = new LinkedHashSet();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    if (i <= parama3.uNg.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = ((com.tencent.mm.plugin.groupsolitaire.c.b)parama3.uNg.get(Integer.valueOf(i))).dem();
      if (bu.lX(localb.username, v.aAC()))
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
      while (i <= parama2.uNg.size())
      {
        ((Set)localObject3).add(((com.tencent.mm.plugin.groupsolitaire.c.b)parama2.uNg.get(Integer.valueOf(i))).dem());
        i += 1;
      }
    }
    i = 1;
    while (i <= parama1.uNg.size())
    {
      parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.uNg.get(Integer.valueOf(i));
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
        } while (!bu.jB(parama2.uNk, ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).uNk));
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
      locala.uNg.clear();
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
        localObject1 = locala.uNg;
        i += 1;
        ((HashMap)localObject1).put(Integer.valueOf(i), parama3);
      }
      locala.uNi = parama1.uNi;
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
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLM, 1);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLossEfficacySwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(174561);
      return parama2;
    }
    if (paramInt == 1)
    {
      if (!bu.lX(paramString, parama2.field_creator))
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
      if (parama1.uNg.size() > 1)
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
    }
    else if (paramInt != 2)
    {
      if (paramInt == 3)
      {
        if (!parama1.uNf)
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
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "handleSolitatireLossEfficacy key:%s result:%s", new Object[] { parama2.field_key, Boolean.valueOf(bool) });
      AppMethodBeat.o(174561);
      return null;
      bool = parama1.delete(parama2.systemRowid);
      if (bool) {
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hv(parama2.field_username, parama2.field_key);
      }
    }
  }
  
  private static com.tencent.mm.plugin.groupsolitaire.c.a a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(221107);
    if ((parama1 == null) && (parama2 == null))
    {
      AppMethodBeat.o(221107);
      return null;
    }
    if ((parama1 == null) && (parama2 != null))
    {
      AppMethodBeat.o(221107);
      return parama2;
    }
    if ((parama1 != null) && (parama2 == null))
    {
      AppMethodBeat.o(221107);
      return parama1;
    }
    if (!bu.lX(parama1.field_key, parama2.field_key))
    {
      AppMethodBeat.o(221107);
      return parama1;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = parama2.del();
    Object localObject1 = new LinkedHashSet();
    if (paramBoolean2) {
      while (i <= parama1.uNg.size())
      {
        parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.uNg.get(Integer.valueOf(i));
        if (!((Set)localObject1).contains(parama2)) {
          ((Set)localObject1).add(parama2);
        }
        i += 1;
      }
    }
    Object localObject2 = new HashSet();
    HashMap localHashMap = new HashMap();
    i = 1;
    if (i <= parama2.uNg.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama2.uNg.get(Integer.valueOf(i));
      if (!bu.lX(localb.username, paramString)) {
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
    if (i <= parama1.uNg.size())
    {
      parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.uNg.get(Integer.valueOf(i));
      if ((!((Set)localObject1).contains(parama2)) && (bu.lX(parama2.username, paramString)))
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
    locala.uNg.clear();
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
      localObject1 = locala.uNg;
      i += 1;
      ((HashMap)localObject1).put(Integer.valueOf(i), paramString);
    }
    locala.uNi = parama1.uNi;
    AppMethodBeat.o(221107);
    return locala;
  }
  
  private static bwi a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.b paramb, int paramInt)
  {
    AppMethodBeat.i(221109);
    bwi localbwi = new bwi();
    localbwi.Hjm = (paramInt + paramString2 + " ");
    a(localbwi, paramString1, paramb.content);
    AppMethodBeat.o(221109);
    return localbwi;
  }
  
  public static String a(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110334);
    if ((bu.isNullOrNil(parama.header)) && (bu.isNullOrNil(parama.uNd)) && (bu.isNullOrNil(parama.ufC)) && (parama.uNe == 1))
    {
      parama.uNe = 0;
      if (parama.uNg.size() > 0)
      {
        parama.header = ((com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(1))).content;
        ((com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(1))).uNj = 1;
      }
    }
    parama = com.tencent.mm.b.g.getMessageDigest(ak.getContext().getString(2131760100, new Object[] { parama.header.trim(), parama.uNe, parama.uNd.trim(), parama.ufC.trim() }).getBytes());
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
    localStringBuilder2.append("<tt>").append(hr(paramString, parama.header)).append("</tt>");
    localStringBuilder2.append("<ex>").append(hr(paramString, parama.uNd)).append("</ex>");
    localStringBuilder2.append("<tl>").append(hr(paramString, parama.ufC)).append("</tl>");
    localStringBuilder2.append("<s>").append(bu.aSz(parama.separator)).append("</s>");
    localStringBuilder2.append("<au>").append(parama.field_creator).append("</au>");
    localStringBuilder2.append("<hrt>").append(parama.uNe).append("</hrt>");
    Object localObject = localStringBuilder2.append("<loss>");
    int i;
    label285:
    Pair localPair;
    if (paramBoolean)
    {
      i = 1;
      ((StringBuilder)localObject).append(i).append("</loss>");
      localStringBuilder2.append("<content>");
      localStringBuilder2.append("<s>").append(parama.uNg.size()).append("</s>");
      i = j;
      if (i > parama.uNg.size()) {
        break label510;
      }
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i));
      if (localObject != null)
      {
        localStringBuilder2.append("<i>");
        localStringBuilder2.append("<u>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).username).append("</u>");
        localStringBuilder2.append("<h>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).uNj).append("</h>");
        localStringBuilder2.append("<s>").append(bu.aSz(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).separator)).append("</s>");
        localStringBuilder2.append("<t>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).createtime).append("</t>");
        localPair = hq(paramString, ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content);
        if (localPair != null) {
          break label484;
        }
        localStringBuilder2.append("<c>").append(bu.aSz(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content)).append("</c>");
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
    AppMethodBeat.i(221108);
    if (parama == null)
    {
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: groupSolitatire is null");
      AppMethodBeat.o(221108);
      return;
    }
    bv localbv;
    Object localObject3;
    bwh localbwh;
    Object localObject1;
    if (paramLong != 0L)
    {
      localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramLong);
      localObject3 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(parama.field_username, parama.field_key, false);
      localbwh = new bwh();
      if (localbv.isText()) {
        localObject1 = localbv.field_content;
      }
    }
    for (;;)
    {
      if (bu.isNullOrNil((String)localObject1))
      {
        ae.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: content is null");
        AppMethodBeat.o(221108);
        return;
        if (localbv.fvQ())
        {
          localObject1 = k.b.zb(localbv.field_content);
          if (localObject1 == null)
          {
            ae.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: amc is null");
            AppMethodBeat.o(221108);
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
            if (parama.uNe != 0) {
              break label1045;
            }
            i = 2;
          }
        }
        for (;;)
        {
          if (i <= parama.uNg.size())
          {
            localObject3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i));
            if ((!bu.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content)) && (!bu.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content.trim())))
            {
              ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content = ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content.trim();
              if (bu.lX(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).username, paramString)) {
                localbwh.Hjj.add(a((String)localObject1, (String)localObject2, (com.tencent.mm.plugin.groupsolitaire.c.b)localObject3, i));
              }
            }
            i += 1;
            continue;
            LinkedHashSet localLinkedHashSet = new LinkedHashSet();
            i = 1;
            while (i <= ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).uNg.size())
            {
              com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).uNg.get(Integer.valueOf(i));
              if ((localb != null) && (bu.lX(localb.username, paramString))) {
                localLinkedHashSet.add(localb);
              }
              i += 1;
            }
            i = 1;
            if (i <= parama.uNg.size())
            {
              localObject3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i));
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
          if (localbwh.Hjj.size() <= 0)
          {
            paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(parama.uNg.size()));
            localbwh.Hjj.add(a((String)localObject1, (String)localObject2, paramString, parama.uNg.size()));
          }
          if (parama.uNe == 0) {}
          for (i = parama.uNg.size() - localbwh.Hjj.size() - 1; i < 2; i = parama.uNg.size() - localbwh.Hjj.size())
          {
            ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg fold condition min num is not");
            AppMethodBeat.o(221108);
            return;
          }
          localbwh.uNe = parama.uNe;
          localbwh.Hjl = (parama.uNg.size() - localbwh.Hjj.size());
          localbwh.dCd = parama.field_msgSvrId;
          localbwh.key = parama.field_key;
          if (parama.uNe == 0)
          {
            paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(1));
            localbwh.Hji.add(a((String)localObject1, (String)localObject2, paramString, 1));
          }
          for (;;)
          {
            if ((parama.ufC != null) && (!bu.isNullOrNil(parama.ufC.trim())))
            {
              paramString = new bwi();
              a(paramString, (String)localObject1, parama.ufC.trim());
              localbwh.Hjk = paramString;
            }
            localbv.field_solitaireFoldInfo = localbwh;
            localbv.fmj = true;
            try
            {
              ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(localbv.field_msgId, localbv);
              ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId:%s", new Object[] { Long.valueOf(localbv.field_msgId) });
              AppMethodBeat.o(221108);
              return;
              if ((parama.header != null) && (!bu.isNullOrNil(parama.header.trim())))
              {
                paramString = new bwi();
                a(paramString, (String)localObject1, parama.header.trim());
                localbwh.Hji.add(paramString);
              }
              if ((parama.uNd != null) && (!bu.isNullOrNil(parama.uNd.trim())))
              {
                paramString = hq((String)localObject1, parama.uNd.trim());
                localObject2 = new bwi();
                if (paramString == null) {
                  ((bwi)localObject2).start = 0;
                }
                for (((bwi)localObject2).end = 0;; ((bwi)localObject2).end = (((Integer)paramString.second).intValue() + i))
                {
                  localbwh.Hji.add(localObject2);
                  break;
                  if (localbwh.Hji.size() > 0) {
                    ((bwi)localObject2).Hjm = "\n";
                  }
                  ((bwi)localObject2).start = ((Integer)paramString.first).intValue();
                  i = ((Integer)paramString.first).intValue();
                }
              }
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                ae.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
              }
            }
          }
          ae.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId == 0");
          AppMethodBeat.o(221108);
          return;
          label1045:
          i = 1;
        }
      }
      localObject1 = "";
    }
  }
  
  private static void a(bwi parambwi, String paramString1, String paramString2)
  {
    AppMethodBeat.i(221110);
    paramString1 = hq(paramString1, paramString2);
    if (paramString1 == null)
    {
      parambwi.start = 0;
      parambwi.end = 0;
      AppMethodBeat.o(221110);
      return;
    }
    parambwi.start = ((Integer)paramString1.first).intValue();
    int i = ((Integer)paramString1.first).intValue();
    parambwi.end = (((Integer)paramString1.second).intValue() + i);
    AppMethodBeat.o(221110);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110346);
    if (parama == null)
    {
      AppMethodBeat.o(110346);
      return;
    }
    String str = v.aAC();
    if (bu.isNullOrNil(parama.field_creator)) {
      parama.field_creator = str;
    }
    if (bu.isNullOrNil(parama.field_username)) {
      parama.field_username = paramString;
    }
    int i = 1;
    while (i <= parama.uNg.size())
    {
      paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i));
      if (bu.isNullOrNil(paramString.username)) {
        paramString.username = str;
      }
      i += 1;
    }
    AppMethodBeat.o(110346);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110338);
    b(paramString1, paramString2, parama, ch.aDd(), true);
    AppMethodBeat.o(110338);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110337);
    long l = ch.aDd();
    if (paramLong != 0L) {
      l = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramLong).field_createTime / 1000L;
    }
    b(paramString1, paramString2, parama, l, paramBoolean);
    AppMethodBeat.o(110337);
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, long paramLong1, boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong2)
  {
    AppMethodBeat.i(221105);
    paramBoolean1 = a(parama1, parama2, paramLong1, paramBoolean1, paramString, paramBoolean2, false, paramLong2);
    AppMethodBeat.o(221105);
    return paramBoolean1;
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, long paramLong1, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, long paramLong2)
  {
    AppMethodBeat.i(221106);
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
        bv localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramLong1);
        localbv.ut(parama1.field_key);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(paramLong1, localbv);
        if ((paramBoolean1) && (parama2 != null) && (parama2.field_active == 0) && (locala.uNg.size() > 1))
        {
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          d.b(locala, paramString);
        }
        if ((parama2 == null) && (locala != null))
        {
          parama1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(locala.field_username, locala.field_key, true);
          if (parama1.field_msgSvrId == 0L)
          {
            parama1.field_msgSvrId = localbv.field_msgSvrId;
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
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mergeAndSaveGroupSolitatire() key:%s msgId:%s ret:%s", new Object[] { parama1, Long.valueOf(paramLong1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(221106);
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
    if (!((j)com.tencent.mm.kernel.g.ab(j.class)).anN(parama.field_username))
    {
      AppMethodBeat.o(110344);
      return false;
    }
    ae.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire key:%s exist:%s supportOnlyOne:%s num:%s", new Object[] { parama.field_key, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(parama.uNg.size()) });
    if (paramBoolean1) {
      if (parama.uNg.size() > ded()) {
        paramBoolean1 = false;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() ret:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
      if (paramBoolean1)
      {
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().anU(parama.field_username);
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hv(parama.field_username, parama.field_key);
        anO(parama.field_username);
      }
      ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() groupSolitatire:%s", new Object[] { parama });
      AppMethodBeat.o(110344);
      return paramBoolean1;
      paramBoolean1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, false);
      continue;
      if ((paramBoolean2) && (parama.uNg.size() > 1)) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().i(parama);
      }
    }
  }
  
  public static boolean aF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(110335);
    if ((bu.isNullOrNil(paramString)) || (paramContext == null))
    {
      AppMethodBeat.o(110335);
      return false;
    }
    paramString = paramString.trim();
    if ((bu.lX(paramString, paramContext.getString(2131760093))) || (bu.lX(paramString, paramContext.getString(2131760094))))
    {
      AppMethodBeat.o(110335);
      return true;
    }
    AppMethodBeat.o(110335);
    return false;
  }
  
  public static boolean aG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(110336);
    if ((bu.isNullOrNil(paramString)) || (paramContext == null))
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
  
  public static com.tencent.mm.plugin.groupsolitaire.c.a am(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(110355);
    if (bu.isNullOrNil(paramString3))
    {
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
      AppMethodBeat.o(110355);
      return null;
    }
    int j = (paramString3 + bu.bI(paramString2, "")).hashCode();
    Object localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)fVO.get(Integer.valueOf(j));
    if (localObject != null)
    {
      ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "get GroupSolitatire data from cache");
      AppMethodBeat.o(110355);
      return localObject;
    }
    if (!paramString3.trim().contains("<solitaire>"))
    {
      AppMethodBeat.o(110355);
      return null;
    }
    localObject = bx.M(paramString3, "solitaire");
    if (localObject == null)
    {
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "newValues is null: %s", new Object[] { paramString3 });
      AppMethodBeat.o(110355);
      return null;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
    locala.header = hs(paramString2, (String)((Map)localObject).get(".solitaire.tt"));
    locala.uNd = hs(paramString2, (String)((Map)localObject).get(".solitaire.ex"));
    locala.ufC = hs(paramString2, (String)((Map)localObject).get(".solitaire.tl"));
    locala.separator = ((String)((Map)localObject).get(".solitaire.s"));
    locala.field_creator = ((String)((Map)localObject).get(".solitaire.au"));
    locala.field_username = paramString1;
    locala.uNe = bu.getInt((String)((Map)localObject).get(".solitaire.hrt"), 1);
    boolean bool;
    int k;
    ArrayList localArrayList;
    label408:
    com.tencent.mm.plugin.groupsolitaire.c.b localb;
    if (bu.getInt((String)((Map)localObject).get(".solitaire.loss"), 0) == 1)
    {
      bool = true;
      locala.uNf = bool;
      if (!((Map)localObject).containsKey(".solitaire.content" + ".s")) {
        break label1007;
      }
      k = bu.getInt((String)((Map)localObject).get(".solitaire.content" + ".s"), 0);
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
      localb.uNj = bu.getInt((String)((Map)localObject).get(".solitaire.content.i" + ".h"), 0);
      localb.separator = ((String)((Map)localObject).get(".solitaire.content.i" + ".s"));
      localb.createtime = bu.getLong((String)((Map)localObject).get(".solitaire.content.i" + ".t"), 0L);
      paramString1 = (String)((Map)localObject).get(".solitaire.content.i" + ".c");
      paramString3 = (String)((Map)localObject).get(".solitaire.content.i" + ".r");
      label649:
      if (bu.isNullOrNil(paramString1)) {
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
      localb.uNj = bu.getInt((String)((Map)localObject).get(".solitaire.content.i" + i + ".h"), 0);
      localb.separator = ((String)((Map)localObject).get(".solitaire.content.i" + i + ".s"));
      localb.createtime = bu.getLong((String)((Map)localObject).get(".solitaire.content.i" + i + ".t"), 0L);
      paramString1 = (String)((Map)localObject).get(".solitaire.content.i" + i + ".c");
      paramString3 = (String)((Map)localObject).get(".solitaire.content.i" + i + ".r");
      break label649;
      label932:
      if (!bu.isNullOrNil(paramString3)) {
        localb.content = hs(paramString2, paramString3);
      }
    }
    label952:
    Collections.sort(localArrayList, new Comparator() {});
    int i = 0;
    while (i < k)
    {
      locala.uNg.put(Integer.valueOf(locala.uNg.size() + 1), localArrayList.get(i));
      i += 1;
    }
    label1007:
    locala.field_key = a(locala);
    fVO.put(Integer.valueOf(j), locala);
    AppMethodBeat.o(110355);
    return locala;
  }
  
  public static boolean an(bv parambv)
  {
    AppMethodBeat.i(110341);
    if (parambv == null)
    {
      AppMethodBeat.o(110341);
      return false;
    }
    Object localObject1 = parambv.field_talker;
    Object localObject2 = parambv.fmz;
    if (((j)com.tencent.mm.kernel.g.ab(j.class)).anN((String)localObject1))
    {
      localObject2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hu((String)localObject1, (String)localObject2);
      localObject1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().anT((String)localObject1);
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
      if ((((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_active == 1) && (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_lastActiveTime >= ((a)localObject1).uMC) && (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).uNg.size() < ded()) && (parambv.field_msgId >= ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_firstMsgId))
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
  
  public static void anO(String paramString)
  {
    AppMethodBeat.i(110345);
    ae.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() batch delete expire data!! (%s)", new Object[] { paramString });
    if ((bu.isNullOrNil(paramString)) || (!x.wb(paramString)))
    {
      AppMethodBeat.o(110345);
      return;
    }
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110317);
        a locala = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().anT(this.fOj);
        if (locala == null)
        {
          ae.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() chatRoomGroupSolitatire == null");
          AppMethodBeat.o(110317);
          return;
        }
        List localList = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().F(this.fOj, 1, locala.uMC);
        boolean bool2;
        if (localList.size() > 0)
        {
          bool2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().G(this.fOj, 1, locala.uMC);
          if (locala.uMB)
          {
            ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.t(localList, 2);
          }
        }
        for (;;)
        {
          localList = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().F(this.fOj, 0, locala.uME);
          boolean bool1;
          if (localList.size() > 0)
          {
            bool1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().G(this.fOj, 0, locala.uME);
            if (locala.uMD)
            {
              ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              d.t(localList, 2);
            }
          }
          for (;;)
          {
            ae.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() activeResult:%s unActiveResult:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            AppMethodBeat.o(110317);
            return;
            ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.t(localList, 1);
            break;
            ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.t(localList, 1);
            continue;
            bool1 = false;
          }
          bool2 = false;
        }
      }
    }, 1000L);
    AppMethodBeat.o(110345);
  }
  
  public static boolean anP(String paramString)
  {
    AppMethodBeat.i(110360);
    if (anS(paramString) > dee() * 2)
    {
      AppMethodBeat.o(110360);
      return true;
    }
    AppMethodBeat.o(110360);
    return false;
  }
  
  public static boolean anQ(String paramString)
  {
    AppMethodBeat.i(110361);
    if (anS(paramString) > def() * 2)
    {
      AppMethodBeat.o(110361);
      return true;
    }
    AppMethodBeat.o(110361);
    return false;
  }
  
  public static boolean anR(String paramString)
  {
    AppMethodBeat.i(178795);
    if (anS(paramString) > deg() * 2)
    {
      AppMethodBeat.o(178795);
      return true;
    }
    AppMethodBeat.o(178795);
    return false;
  }
  
  public static int anS(String paramString)
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
      ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "length:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(110363);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getStringByteLen Exception：%s，%s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        int i = paramString.getBytes().length;
      }
    }
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
      parama.field_msgSvrId = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(parama.field_firstMsgId).field_msgSvrId;
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "fixMsgSvrId ret:%s", new Object[] { Boolean.valueOf(((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true)) });
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
      if (bu.isNullOrNil(parama.field_username)) {
        parama.field_username = paramString1;
      }
      if (bu.isNullOrNil(parama.field_creator)) {
        parama.field_creator = paramString2;
      }
      paramString1 = new HashMap();
      HashSet localHashSet = new HashSet();
      parama.uNh = false;
      parama.header = parama.header.trim();
      parama.uNd = parama.uNd.trim();
      parama.ufC = parama.ufC.trim();
      int i = 1;
      while (i <= parama.uNg.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i));
        if ((!bu.isNullOrNil(localb.content)) && (!bu.isNullOrNil(localb.content.trim())))
        {
          localb.content = localb.content.trim();
          if (localHashSet.contains(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).abU(localb.content))) {
            parama.uNh = true;
          }
          localHashSet.add(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).abU(localb.content));
          paramString1.put(Integer.valueOf(paramString1.size() + 1), localb);
          if (localb.createtime == 9223372036854775807L) {
            localb.createtime = paramLong;
          }
          if (bu.isNullOrNil(localb.username)) {
            localb.username = paramString2;
          }
        }
        i += 1;
      }
    }
    parama.uNg = paramString1;
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
    if ((parama != null) && (parama.uNh))
    {
      HashMap localHashMap = new HashMap();
      HashSet localHashSet = new HashSet();
      parama.uNh = false;
      int i = 1;
      while (i <= parama.uNg.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i));
        if (!localHashSet.contains(localb.content))
        {
          localHashSet.add(localb.content);
          localHashMap.put(Integer.valueOf(localHashMap.size() + 1), localb);
        }
        i += 1;
      }
      parama.uNg = localHashMap;
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
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLs, 0);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getKeywordCheckSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (i = 1; i != 0; i = 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (parama.uNe == 1) {
        localStringBuilder.append(parama.header);
      }
      localStringBuilder.append(parama.uNd).append(parama.ufC);
      parama = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLL, "(接龙|报名|参加|参与|活动|组织|投票|回复|统计)");
      ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", new Object[] { parama });
      boolean bool = Pattern.compile(parama).matcher(localStringBuilder.toString()).find();
      AppMethodBeat.o(110351);
      return bool;
    }
    AppMethodBeat.o(110351);
    return true;
  }
  
  public static int dX(String paramString, int paramInt)
  {
    AppMethodBeat.i(110364);
    int j = paramString.length();
    int i = 0;
    while (i <= j)
    {
      int m = (i + j) / 2;
      int n = anS(paramString.substring(0, m));
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
  
  public static String ddS()
  {
    AppMethodBeat.i(110322);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLu, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])(\\s*)");
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mainBodyRegex:%s", new Object[] { str });
    AppMethodBeat.o(110322);
    return str;
  }
  
  public static String ddT()
  {
    AppMethodBeat.i(110323);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLv, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])");
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "separatorRegex:%s", new Object[] { str });
    AppMethodBeat.o(110323);
    return str;
  }
  
  public static String ddU()
  {
    AppMethodBeat.i(110324);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLw, "([0-9]{1,3})(\\s*)([.。;；、:,，])");
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentSeparatorRegex:%s", new Object[] { str });
    AppMethodBeat.o(110324);
    return str;
  }
  
  public static String ddV()
  {
    AppMethodBeat.i(110325);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLx, "^\\d{1,3}");
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "numRegex:%s", new Object[] { str });
    AppMethodBeat.o(110325);
    return str;
  }
  
  public static String ddW()
  {
    AppMethodBeat.i(221101);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLy, "^\\d{1,3}$");
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "SingleNum:%s", new Object[] { str });
    AppMethodBeat.o(221101);
    return str;
  }
  
  public static String ddX()
  {
    AppMethodBeat.i(110326);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLz, "\\d{1,3}");
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentNumRegex:%s", new Object[] { str });
    AppMethodBeat.o(110326);
    return str;
  }
  
  public static String ddY()
  {
    AppMethodBeat.i(110327);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLA, "(例|例如|如|格式|格式如)(\\s*)([,.:，：、 ])(.+)");
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", new Object[] { str });
    AppMethodBeat.o(110327);
    return str;
  }
  
  public static int ddZ()
  {
    AppMethodBeat.i(110328);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLB, 3);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireActiveIntervalTime() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110328);
    return i;
  }
  
  public static int dea()
  {
    AppMethodBeat.i(110329);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLC, 5);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireActiveNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110329);
    return i;
  }
  
  public static int deb()
  {
    AppMethodBeat.i(110330);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLD, 24);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireMatchIntervalTime() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110330);
    return i;
  }
  
  public static int dec()
  {
    AppMethodBeat.i(110331);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLE, 10);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireMatchNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110331);
    return i;
  }
  
  public static int ded()
  {
    AppMethodBeat.i(110332);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLt, 500);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110332);
    return i;
  }
  
  public static int dee()
  {
    AppMethodBeat.i(110333);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLI, 150);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110333);
    return i;
  }
  
  public static int def()
  {
    AppMethodBeat.i(178792);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLJ, 500);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(178792);
    return i;
  }
  
  public static int deg()
  {
    AppMethodBeat.i(178793);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLK, 500);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(178793);
    return i;
  }
  
  private static boolean deh()
  {
    AppMethodBeat.i(221102);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLO, 0);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "isXmlForceUseCTagSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(221102);
      return true;
    }
    AppMethodBeat.o(221102);
    return false;
  }
  
  public static String dei()
  {
    AppMethodBeat.i(221103);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLN, "(\\.|。|,|，|:|：|;|；|、|-|\\s)");
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "equalStrWhiteListRegex:%s", new Object[] { str });
    AppMethodBeat.o(221103);
    return str;
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
    localStringBuilder.append("<tt>").append(bu.aSz(parama.header)).append("</tt>");
    localStringBuilder.append("<ex>").append(bu.aSz(parama.uNd)).append("</ex>");
    localStringBuilder.append("<tl>").append(bu.aSz(parama.ufC)).append("</tl>");
    localStringBuilder.append("<s>").append(bu.aSz(parama.separator)).append("</s>");
    localStringBuilder.append("<au>").append(parama.field_creator).append("</au>");
    localStringBuilder.append("<hrt>").append(parama.uNe).append("</hrt>");
    localStringBuilder.append("<content>");
    localStringBuilder.append("<s>").append(parama.uNg.size()).append("</s>");
    int i = 1;
    while (i <= parama.uNg.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i));
      if (localb != null)
      {
        localStringBuilder.append("<i>");
        localStringBuilder.append("<u>").append(localb.username).append("</u>");
        localStringBuilder.append("<h>").append(localb.uNj).append("</h>");
        localStringBuilder.append("<s>").append(bu.aSz(localb.separator)).append("</s>");
        localStringBuilder.append("<t>").append(localb.createtime).append("</t>");
        localStringBuilder.append("<c>").append(bu.aSz(localb.content)).append("</c>");
        localStringBuilder.append("<o>").append(localb.uNk).append("</o>");
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
    if (bu.isNullOrNil((String)localObject))
    {
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
      AppMethodBeat.o(110354);
      return;
    }
    if (!((String)localObject).trim().contains("<solitaire>"))
    {
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "<solitaire> no contains");
      AppMethodBeat.o(110354);
      return;
    }
    Map localMap = bx.M((String)localObject, "solitaire");
    if (localMap == null)
    {
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "newValues is null: %s", new Object[] { localObject });
      AppMethodBeat.o(110354);
      return;
    }
    parama.header = ((String)localMap.get(".solitaire.tt"));
    parama.uNd = ((String)localMap.get(".solitaire.ex"));
    parama.ufC = ((String)localMap.get(".solitaire.tl"));
    parama.separator = ((String)localMap.get(".solitaire.s"));
    parama.field_creator = ((String)localMap.get(".solitaire.au"));
    parama.uNe = bu.getInt((String)localMap.get(".solitaire.hrt"), 1);
    if (localMap.containsKey(".solitaire.content" + ".s"))
    {
      int j = bu.getInt((String)localMap.get(".solitaire.content" + ".s"), 0);
      localObject = new ArrayList();
      int i = 0;
      if (i < j)
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
        if (i == 0)
        {
          localb.username = ((String)localMap.get(".solitaire.content.i" + ".u"));
          localb.uNj = bu.getInt((String)localMap.get(".solitaire.content.i" + ".h"), 0);
          localb.separator = ((String)localMap.get(".solitaire.content.i" + ".s"));
          localb.createtime = bu.getLong((String)localMap.get(".solitaire.content.i" + ".t"), 0L);
          localb.content = ((String)localMap.get(".solitaire.content.i" + ".c"));
        }
        for (localb.uNk = bu.getInt((String)localMap.get(".solitaire.content.i" + ".o"), 0);; localb.uNk = bu.getInt((String)localMap.get(".solitaire.content.i" + i + ".o"), 0))
        {
          ((ArrayList)localObject).add(localb);
          i += 1;
          break;
          localb.username = ((String)localMap.get(".solitaire.content.i" + i + ".u"));
          localb.uNj = bu.getInt((String)localMap.get(".solitaire.content.i" + i + ".h"), 0);
          localb.separator = ((String)localMap.get(".solitaire.content.i" + i + ".s"));
          localb.createtime = bu.getLong((String)localMap.get(".solitaire.content.i" + i + ".t"), 0L);
          localb.content = ((String)localMap.get(".solitaire.content.i" + i + ".c"));
        }
      }
      Collections.sort((List)localObject, new Comparator() {});
      i = 0;
      while (i < j)
      {
        parama.uNg.put(Integer.valueOf(parama.uNg.size() + 1), ((ArrayList)localObject).get(i));
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
    if ((parama.header != null) && (!bu.isNullOrNil(parama.header.trim())) && (parama.uNe == 1))
    {
      parama.header = parama.header.trim();
      localStringBuilder.append(parama.header).append("\n");
    }
    if ((parama.uNd != null) && (!bu.isNullOrNil(parama.uNd.trim())))
    {
      parama.uNd = parama.uNd.trim();
      localStringBuilder.append(parama.uNd).append("\n");
    }
    if (!bu.isNullOrNil(localStringBuilder.toString())) {
      localStringBuilder.append("\n");
    }
    if (parama.uNg.size() > 0)
    {
      int i = 1;
      while (i <= parama.uNg.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i));
        localStringBuilder.append(i).append(parama.separator).append(" ").append(localb.content);
        if (i < parama.uNg.size()) {
          localStringBuilder.append("\n");
        }
        i += 1;
      }
    }
    if ((parama.ufC != null) && (!bu.isNullOrNil(parama.ufC.trim())))
    {
      parama.ufC = parama.ufC.trim();
      localStringBuilder.append("\n");
      localStringBuilder.append("\n");
      localStringBuilder.append(parama.ufC);
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
    if ((parama.uNe == 1) && (anQ(parama.header)))
    {
      AppMethodBeat.o(110362);
      return true;
    }
    AppMethodBeat.o(110362);
    return false;
  }
  
  public static Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> hp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110350);
    if (bu.isNullOrNil(paramString2))
    {
      paramString1 = new Pair(Boolean.FALSE, null);
      AppMethodBeat.o(110350);
      return paramString1;
    }
    paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hu(paramString1, paramString2);
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
  
  private static Pair<Integer, Integer> hq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110357);
    if (deh())
    {
      AppMethodBeat.o(110357);
      return null;
    }
    if (bu.isNullOrNil(paramString1))
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
  
  private static String hr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110358);
    paramString1 = hq(paramString1, paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(110358);
      return paramString2;
    }
    paramString1 = paramString1.first + "-" + paramString1.second;
    AppMethodBeat.o(110358);
    return paramString1;
  }
  
  private static String hs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110359);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110359);
      return "";
    }
    String[] arrayOfString = paramString2.split("-");
    if ((arrayOfString != null) && (arrayOfString.length == 2))
    {
      int i = bu.getInt(arrayOfString[0], 0);
      int j = bu.getInt(arrayOfString[1], 0) + i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.b
 * JD-Core Version:    0.7.0.1
 */