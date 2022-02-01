package com.tencent.mm.plugin.groupsolitaire.b;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.b.f;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
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
  private static final f<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> lNS;
  
  static
  {
    AppMethodBeat.i(110365);
    lNS = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(110365);
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
    com.tencent.mm.plugin.groupsolitaire.c.a locala = parama3.fJv();
    Object localObject1 = new LinkedHashSet();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject2 = new LinkedHashSet();
    Object localObject3 = new LinkedHashSet();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    if (i <= parama3.Jjo.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = ((com.tencent.mm.plugin.groupsolitaire.c.b)parama3.Jjo.get(Integer.valueOf(i))).fJw();
      if (Util.isEqual(localb.username, z.bAM()))
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
      while (i <= parama2.Jjo.size())
      {
        ((Set)localObject3).add(((com.tencent.mm.plugin.groupsolitaire.c.b)parama2.Jjo.get(Integer.valueOf(i))).fJw());
        i += 1;
      }
    }
    i = 1;
    while (i <= parama1.Jjo.size())
    {
      parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.Jjo.get(Integer.valueOf(i));
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
        } while (!Util.isEqual(parama2.Jjs, ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).Jjs));
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
      locala.Jjo.clear();
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
        localObject1 = locala.Jjo;
        i += 1;
        ((HashMap)localObject1).put(Integer.valueOf(i), parama3);
      }
      locala.Jjq = parama1.Jjq;
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
    if (paramInt == 1)
    {
      if (!Util.isEqual(paramString, parama2.field_creator))
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
      if (parama1.Jjo.size() > 1)
      {
        AppMethodBeat.o(174561);
        return parama2;
      }
    }
    else if (paramInt != 2)
    {
      if (paramInt == 3)
      {
        if (!parama1.Jjn)
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
    parama1 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage();
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
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireStorage", "deleteSolitatire ret:%s deleteRet:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(parama1.db.delete("GroupSolitatire", "username=? and key=?", new String[] { parama2.field_username, parama2.field_key })) });
      if (bool) {
        ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().js(parama2.field_username, parama2.field_key);
      }
    }
  }
  
  private static com.tencent.mm.plugin.groupsolitaire.c.a a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(262685);
    if ((parama1 == null) && (parama2 == null))
    {
      AppMethodBeat.o(262685);
      return null;
    }
    if ((parama1 == null) && (parama2 != null))
    {
      AppMethodBeat.o(262685);
      return parama2;
    }
    if ((parama1 != null) && (parama2 == null))
    {
      AppMethodBeat.o(262685);
      return parama1;
    }
    if (!Util.isEqual(parama1.field_key, parama2.field_key))
    {
      AppMethodBeat.o(262685);
      return parama1;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala = parama2.fJv();
    Object localObject1 = new LinkedHashSet();
    if (paramBoolean2) {
      while (i <= parama1.Jjo.size())
      {
        parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.Jjo.get(Integer.valueOf(i));
        if (!((Set)localObject1).contains(parama2)) {
          ((Set)localObject1).add(parama2);
        }
        i += 1;
      }
    }
    Object localObject2 = new HashSet();
    HashMap localHashMap = new HashMap();
    i = 1;
    if (i <= parama2.Jjo.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama2.Jjo.get(Integer.valueOf(i));
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
    if (i <= parama1.Jjo.size())
    {
      parama2 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama1.Jjo.get(Integer.valueOf(i));
      if ((!((Set)localObject1).contains(parama2)) && (Util.isEqual(parama2.username, paramString)))
      {
        if (!paramBoolean1) {
          break label333;
        }
        ((Set)localObject1).add(parama2);
      }
      for (;;)
      {
        i += 1;
        break;
        label333:
        localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)localHashMap.get(parama2.content);
        if (localObject2 == null) {
          ((Set)localObject1).add(parama2);
        } else {
          ((Set)localObject1).add(localObject2);
        }
      }
    }
    locala.Jjo.clear();
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
      localObject1 = locala.Jjo;
      i += 1;
      ((HashMap)localObject1).put(Integer.valueOf(i), paramString);
    }
    locala.Jjq = parama1.Jjq;
    AppMethodBeat.o(262685);
    return locala;
  }
  
  private static djt a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.b paramb, int paramInt)
  {
    AppMethodBeat.i(262691);
    djt localdjt = new djt();
    localdjt.aaPI = (paramInt + paramString2 + " ");
    a(localdjt, paramString1, paramb.content);
    AppMethodBeat.o(262691);
    return localdjt;
  }
  
  public static String a(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110334);
    if ((Util.isNullOrNil(parama.header)) && (Util.isNullOrNil(parama.Jjl)) && (Util.isNullOrNil(parama.IvM)) && (parama.Jjm == 1))
    {
      parama.Jjm = 0;
      if (parama.Jjo.size() > 0)
      {
        parama.header = ((com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(1))).content;
        ((com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(1))).Jjr = 1;
      }
    }
    parama = g.getMessageDigest(MMApplicationContext.getContext().getString(b.g.Jiz, new Object[] { parama.header.trim(), parama.Jjm, parama.Jjl.trim(), parama.IvM.trim() }).getBytes());
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
    localStringBuilder2.append("<tt>").append(jo(paramString, parama.header)).append("</tt>");
    localStringBuilder2.append("<ex>").append(jo(paramString, parama.Jjl)).append("</ex>");
    localStringBuilder2.append("<tl>").append(jo(paramString, parama.IvM)).append("</tl>");
    localStringBuilder2.append("<s>").append(Util.escapeStringForXml(parama.dIC)).append("</s>");
    localStringBuilder2.append("<au>").append(parama.field_creator).append("</au>");
    localStringBuilder2.append("<hrt>").append(parama.Jjm).append("</hrt>");
    Object localObject = localStringBuilder2.append("<loss>");
    int i;
    label285:
    Pair localPair;
    if (paramBoolean)
    {
      i = 1;
      ((StringBuilder)localObject).append(i).append("</loss>");
      localStringBuilder2.append("<content>");
      localStringBuilder2.append("<s>").append(parama.Jjo.size()).append("</s>");
      i = j;
      if (i > parama.Jjo.size()) {
        break label510;
      }
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i));
      if (localObject != null)
      {
        localStringBuilder2.append("<i>");
        localStringBuilder2.append("<u>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).username).append("</u>");
        localStringBuilder2.append("<h>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).Jjr).append("</h>");
        localStringBuilder2.append("<s>").append(Util.escapeStringForXml(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).dIC)).append("</s>");
        localStringBuilder2.append("<t>").append(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).createtime).append("</t>");
        localPair = jn(paramString, ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content);
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
    AppMethodBeat.i(262690);
    if (parama == null)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: groupSolitatire is null");
      AppMethodBeat.o(262690);
      return;
    }
    cc localcc;
    Object localObject3;
    djs localdjs;
    Object localObject1;
    if (paramLong != 0L)
    {
      localcc = ((n)h.ax(n.class)).gaZ().sl(paramLong);
      if (localcc == null)
      {
        Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: msg is null");
        AppMethodBeat.o(262690);
        return;
      }
      localObject3 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().A(parama.field_username, parama.field_key, false);
      localdjs = new djs();
      if (localcc.iYl()) {
        localObject1 = localcc.field_content;
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: content is null");
        AppMethodBeat.o(262690);
        return;
        if (localcc.jbR())
        {
          localObject1 = k.b.Hf(localcc.field_content);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: amc is null");
            AppMethodBeat.o(262690);
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
          localObject2 = ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).dIC;
          if ((parama == null) || (localObject3 == null))
          {
            if (parama.Jjm != 0) {
              break label1065;
            }
            i = 2;
          }
        }
        for (;;)
        {
          if (i <= parama.Jjo.size())
          {
            localObject3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i));
            if ((!Util.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content)) && (!Util.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content.trim())))
            {
              ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content = ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).content.trim();
              if (Util.isEqual(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).username, paramString)) {
                localdjs.aaPF.add(a((String)localObject1, (String)localObject2, (com.tencent.mm.plugin.groupsolitaire.c.b)localObject3, i));
              }
            }
            i += 1;
            continue;
            LinkedHashSet localLinkedHashSet = new LinkedHashSet();
            i = 1;
            while (i <= ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).Jjo.size())
            {
              com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((com.tencent.mm.plugin.groupsolitaire.c.a)localObject3).Jjo.get(Integer.valueOf(i));
              if ((localb != null) && (Util.isEqual(localb.username, paramString))) {
                localLinkedHashSet.add(localb);
              }
              i += 1;
            }
            i = 1;
            if (i <= parama.Jjo.size())
            {
              localObject3 = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i));
              if (localObject3 != null) {
                if (!localLinkedHashSet.contains(localObject3)) {
                  break label475;
                }
              }
              label475:
              for (((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).username = paramString;; ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject3).username = "")
              {
                i += 1;
                break;
              }
            }
            break;
            localObject2 = parama.dIC;
            break;
          }
          if (localdjs.aaPF.size() <= 0)
          {
            paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(parama.Jjo.size()));
            localdjs.aaPF.add(a((String)localObject1, (String)localObject2, paramString, parama.Jjo.size()));
          }
          if (parama.Jjm == 0) {}
          for (i = parama.Jjo.size() - localdjs.aaPF.size() - 1; i < 2; i = parama.Jjo.size() - localdjs.aaPF.size())
          {
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg fold condition min num is not");
            AppMethodBeat.o(262690);
            return;
          }
          localdjs.Jjm = parama.Jjm;
          localdjs.aaPH = (parama.Jjo.size() - localdjs.aaPF.size());
          localdjs.hTh = parama.field_msgSvrId;
          localdjs.key = parama.field_key;
          if (parama.Jjm == 0)
          {
            paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(1));
            localdjs.aaPE.add(a((String)localObject1, (String)localObject2, paramString, 1));
          }
          for (;;)
          {
            if ((parama.IvM != null) && (!Util.isNullOrNil(parama.IvM.trim())))
            {
              paramString = new djt();
              a(paramString, (String)localObject1, parama.IvM.trim());
              localdjs.aaPG = paramString;
            }
            localcc.field_solitaireFoldInfo = localdjs;
            localcc.kLa = true;
            try
            {
              ((n)h.ax(n.class)).gaZ().a(localcc.field_msgId, localcc);
              Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId:%s", new Object[] { Long.valueOf(localcc.field_msgId) });
              AppMethodBeat.o(262690);
              return;
              if ((parama.header != null) && (!Util.isNullOrNil(parama.header.trim())))
              {
                paramString = new djt();
                a(paramString, (String)localObject1, parama.header.trim());
                localdjs.aaPE.add(paramString);
              }
              if ((parama.Jjl != null) && (!Util.isNullOrNil(parama.Jjl.trim())))
              {
                paramString = jn((String)localObject1, parama.Jjl.trim());
                localObject2 = new djt();
                if (paramString == null) {
                  ((djt)localObject2).start = 0;
                }
                for (((djt)localObject2).end = 0;; ((djt)localObject2).end = (((Integer)paramString.second).intValue() + i))
                {
                  localdjs.aaPE.add(localObject2);
                  break;
                  if (localdjs.aaPE.size() > 0) {
                    ((djt)localObject2).aaPI = "\n";
                  }
                  ((djt)localObject2).start = ((Integer)paramString.first).intValue();
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
          AppMethodBeat.o(262690);
          return;
          label1065:
          i = 1;
        }
      }
      localObject1 = "";
    }
  }
  
  private static void a(djt paramdjt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(262692);
    paramString1 = jn(paramString1, paramString2);
    if (paramString1 == null)
    {
      paramdjt.start = 0;
      paramdjt.end = 0;
      AppMethodBeat.o(262692);
      return;
    }
    paramdjt.start = ((Integer)paramString1.first).intValue();
    int i = ((Integer)paramString1.first).intValue();
    paramdjt.end = (((Integer)paramString1.second).intValue() + i);
    AppMethodBeat.o(262692);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(110346);
    if (parama == null)
    {
      AppMethodBeat.o(110346);
      return;
    }
    String str = z.bAM();
    if (Util.isNullOrNil(parama.field_creator)) {
      parama.field_creator = str;
    }
    if (Util.isNullOrNil(parama.field_username)) {
      parama.field_username = paramString;
    }
    int i = 1;
    while (i <= parama.Jjo.size())
    {
      paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i));
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
    b(paramString1, paramString2, parama, cn.getSyncServerTimeSecond(), true);
    AppMethodBeat.o(110338);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110337);
    long l2 = cn.getSyncServerTimeSecond();
    long l1 = l2;
    if (paramLong != 0L)
    {
      cc localcc = ((n)h.ax(n.class)).gaZ().sl(paramLong);
      l1 = l2;
      if (localcc != null) {
        l1 = localcc.getCreateTime() / 1000L;
      }
    }
    b(paramString1, paramString2, parama, l1, paramBoolean);
    AppMethodBeat.o(110337);
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, long paramLong1, boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong2)
  {
    AppMethodBeat.i(262676);
    paramBoolean1 = a(parama1, parama2, paramLong1, paramBoolean1, paramString, paramBoolean2, false, paramLong2);
    AppMethodBeat.o(262676);
    return paramBoolean1;
  }
  
  public static boolean a(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, long paramLong1, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, long paramLong2)
  {
    AppMethodBeat.i(262679);
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
        cc localcc = ((n)h.ax(n.class)).gaZ().sl(paramLong1);
        if (localcc != null)
        {
          localcc.Cd(parama1.field_key);
          ((n)h.ax(n.class)).gaZ().a(paramLong1, localcc);
        }
        if ((paramBoolean1) && (parama2 != null) && (parama2.field_active == 0) && (locala.Jjo.size() > 1))
        {
          ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          if (localcc == null) {
            paramString = "";
          }
          d.b(locala, paramString);
        }
        if ((parama2 == null) && (localcc != null) && (locala != null))
        {
          parama1 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().A(locala.field_username, locala.field_key, true);
          if (parama1.field_msgSvrId == 0L)
          {
            parama1.field_msgSvrId = localcc.field_msgSvrId;
            ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama1, true);
          }
        }
      }
      if (locala != null) {
        break label321;
      }
    }
    label321:
    for (parama1 = "null";; parama1 = locala.field_key)
    {
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mergeAndSaveGroupSolitatire() key:%s msgId:%s ret:%s", new Object[] { parama1, Long.valueOf(paramLong1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(262679);
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
    if (!((l)h.ax(l.class)).aHL(parama.field_username))
    {
      AppMethodBeat.o(110344);
      return false;
    }
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire key:%s exist:%s supportOnlyOne:%s num:%s", new Object[] { parama.field_key, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(parama.Jjo.size()) });
    if (paramBoolean1) {
      if (parama.Jjo.size() > fJn()) {
        paramBoolean1 = false;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() ret:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
      if (paramBoolean1)
      {
        ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().aHS(parama.field_username);
        ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().js(parama.field_username, parama.field_key);
        aHM(parama.field_username);
      }
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() groupSolitatire:%s", new Object[] { parama });
      AppMethodBeat.o(110344);
      return paramBoolean1;
      paramBoolean1 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, false);
      continue;
      if ((paramBoolean2) && (parama.Jjo.size() > 1)) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().i(parama);
      }
    }
  }
  
  public static void aHM(String paramString)
  {
    AppMethodBeat.i(110345);
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() batch delete expire data!! (%s)", new Object[] { paramString });
    if ((Util.isNullOrNil(paramString)) || (!au.bwE(paramString)))
    {
      AppMethodBeat.o(110345);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110317);
        a locala = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().aHR(b.this);
        if (locala == null)
        {
          Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() chatRoomGroupSolitatire == null");
          AppMethodBeat.o(110317);
          return;
        }
        List localList = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().G(b.this, 1, locala.JiL);
        boolean bool2;
        if (localList.size() > 0)
        {
          bool2 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().H(b.this, 1, locala.JiL);
          if (locala.JiK)
          {
            ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.Q(localList, 2);
          }
        }
        for (;;)
        {
          localList = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().G(b.this, 0, locala.JiN);
          boolean bool1;
          if (localList.size() > 0)
          {
            bool1 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().H(b.this, 0, locala.JiN);
            if (locala.JiM)
            {
              ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              d.Q(localList, 2);
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() activeResult:%s unActiveResult:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            AppMethodBeat.o(110317);
            return;
            ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.Q(localList, 1);
            break;
            ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.Q(localList, 1);
            continue;
            bool1 = false;
          }
          bool2 = false;
        }
      }
    }, 1000L);
    AppMethodBeat.o(110345);
  }
  
  public static boolean aHN(String paramString)
  {
    AppMethodBeat.i(110360);
    if (aHQ(paramString) > fJo() * 2)
    {
      AppMethodBeat.o(110360);
      return true;
    }
    AppMethodBeat.o(110360);
    return false;
  }
  
  public static boolean aHO(String paramString)
  {
    AppMethodBeat.i(110361);
    if (aHQ(paramString) > fJp() * 2)
    {
      AppMethodBeat.o(110361);
      return true;
    }
    AppMethodBeat.o(110361);
    return false;
  }
  
  public static boolean aHP(String paramString)
  {
    AppMethodBeat.i(178795);
    if (aHQ(paramString) > fJq() * 2)
    {
      AppMethodBeat.o(178795);
      return true;
    }
    AppMethodBeat.o(178795);
    return false;
  }
  
  public static int aHQ(String paramString)
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
  
  public static boolean aW(cc paramcc)
  {
    AppMethodBeat.i(110341);
    if (paramcc == null)
    {
      AppMethodBeat.o(110341);
      return false;
    }
    Object localObject1 = paramcc.field_talker;
    Object localObject2 = paramcc.kLs;
    if (((l)h.ax(l.class)).aHL((String)localObject1))
    {
      localObject2 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().jr((String)localObject1, (String)localObject2);
      localObject1 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().aHR((String)localObject1);
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
      if ((((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_active == 1) && (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_lastActiveTime >= ((a)localObject1).JiL) && (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).Jjo.size() < fJn()) && (paramcc.field_msgId >= ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject2).field_firstMsgId))
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
  
  public static boolean af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(262674);
    paramString2 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().jr(paramString1, paramString2);
    paramString1 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().aHR(paramString1);
    if (paramString2 == null)
    {
      AppMethodBeat.o(262674);
      return true;
    }
    boolean bool;
    if (paramString1 == null) {
      bool = true;
    }
    while ((!bool) && (Util.isEqual(paramString2.field_creator, z.bAM())) && (paramInt <= 1))
    {
      AppMethodBeat.o(262674);
      return true;
      int i;
      if ((paramString2.field_active == 1) && (paramString2.field_lastActiveTime >= paramString1.JiL) && (paramString2.Jjo.size() < fJn()))
      {
        i = 1;
        label124:
        if ((paramString2.field_active != 0) || (paramString2.field_lastActiveTime < paramString1.JiN)) {
          break label166;
        }
      }
      label166:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          break label172;
        }
        bool = true;
        break;
        i = 0;
        break label124;
      }
      label172:
      bool = false;
    }
    AppMethodBeat.o(262674);
    return bool;
  }
  
  public static com.tencent.mm.plugin.groupsolitaire.c.a ay(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(110355);
    if (Util.isNullOrNil(paramString3))
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
      AppMethodBeat.o(110355);
      return null;
    }
    int j = (paramString3 + Util.nullAs(paramString2, "")).hashCode();
    Object localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)lNS.get(Integer.valueOf(j));
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
    locala.header = jp(paramString2, (String)((Map)localObject).get(".solitaire.tt"));
    locala.Jjl = jp(paramString2, (String)((Map)localObject).get(".solitaire.ex"));
    locala.IvM = jp(paramString2, (String)((Map)localObject).get(".solitaire.tl"));
    locala.dIC = ((String)((Map)localObject).get(".solitaire.s"));
    locala.field_creator = ((String)((Map)localObject).get(".solitaire.au"));
    locala.field_username = paramString1;
    locala.Jjm = Util.getInt((String)((Map)localObject).get(".solitaire.hrt"), 1);
    boolean bool;
    int k;
    ArrayList localArrayList;
    label409:
    com.tencent.mm.plugin.groupsolitaire.c.b localb;
    if (Util.getInt((String)((Map)localObject).get(".solitaire.loss"), 0) == 1)
    {
      bool = true;
      locala.Jjn = bool;
      if (!((Map)localObject).containsKey(".solitaire.content" + ".s")) {
        break label1011;
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
      localb.Jjr = Util.getInt((String)((Map)localObject).get(".solitaire.content.i" + ".h"), 0);
      localb.dIC = ((String)((Map)localObject).get(".solitaire.content.i" + ".s"));
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
      localb.Jjr = Util.getInt((String)((Map)localObject).get(".solitaire.content.i" + i + ".h"), 0);
      localb.dIC = ((String)((Map)localObject).get(".solitaire.content.i" + i + ".s"));
      localb.createtime = Util.getLong((String)((Map)localObject).get(".solitaire.content.i" + i + ".t"), 0L);
      paramString1 = (String)((Map)localObject).get(".solitaire.content.i" + i + ".c");
      paramString3 = (String)((Map)localObject).get(".solitaire.content.i" + i + ".r");
      break label650;
      label933:
      if (!Util.isNullOrNil(paramString3)) {
        localb.content = jp(paramString2, paramString3);
      }
    }
    label953:
    Collections.sort(localArrayList, new Comparator() {});
    int i = 0;
    while (i < k)
    {
      locala.Jjo.put(Integer.valueOf(locala.Jjo.size() + 1), (com.tencent.mm.plugin.groupsolitaire.c.b)localArrayList.get(i));
      i += 1;
    }
    label1011:
    locala.field_key = a(locala);
    lNS.put(Integer.valueOf(j), locala);
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
      cc localcc = ((n)h.ax(n.class)).gaZ().sl(parama.field_firstMsgId);
      if (localcc != null)
      {
        parama.field_msgSvrId = localcc.field_msgSvrId;
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "fixMsgSvrId ret:%s", new Object[] { Boolean.valueOf(((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true)) });
      }
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
      parama.Jjp = false;
      parama.header = parama.header.trim();
      parama.Jjl = parama.Jjl.trim();
      parama.IvM = parama.IvM.trim();
      int i = 1;
      while (i <= parama.Jjo.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i));
        if ((!Util.isNullOrNil(localb.content)) && (!Util.isNullOrNil(localb.content.trim())))
        {
          localb.content = localb.content.trim();
          if (localHashSet.contains(((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).anH(localb.content))) {
            parama.Jjp = true;
          }
          localHashSet.add(((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).anH(localb.content));
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
    parama.Jjo = paramString1;
    AppMethodBeat.o(110339);
  }
  
  public static boolean bc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(110335);
    if ((Util.isNullOrNil(paramString)) || (paramContext == null))
    {
      AppMethodBeat.o(110335);
      return false;
    }
    paramString = paramString.trim();
    if ((Util.isEqual(paramString, paramContext.getString(b.g.gJg))) || (Util.isEqual(paramString, paramContext.getString(b.g.Jiw))))
    {
      AppMethodBeat.o(110335);
      return true;
    }
    AppMethodBeat.o(110335);
    return false;
  }
  
  public static boolean bd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(110336);
    if ((Util.isNullOrNil(paramString)) || (paramContext == null))
    {
      AppMethodBeat.o(110336);
      return false;
    }
    paramString = paramString.trim();
    if ((paramString.startsWith(paramContext.getString(b.g.gJg))) || (paramString.startsWith(paramContext.getString(b.g.Jiw))))
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
    if ((parama != null) && (parama.Jjp))
    {
      HashMap localHashMap = new HashMap();
      HashSet localHashSet = new HashSet();
      parama.Jjp = false;
      int i = 1;
      while (i <= parama.Jjo.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i));
        if (!localHashSet.contains(localb.content))
        {
          localHashSet.add(localb.content);
          localHashMap.put(Integer.valueOf(localHashMap.size() + 1), localb);
        }
        i += 1;
      }
      parama.Jjo = localHashMap;
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
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.Jjm == 1) {
      localStringBuilder.append(parama.header);
    }
    localStringBuilder.append(parama.Jjl).append(parama.IvM);
    parama = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkD, "(接龙|报名|参加|参与|活动|组织|投票|回复|统计)");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", new Object[] { parama });
    boolean bool = Pattern.compile(parama).matcher(localStringBuilder.toString()).find();
    AppMethodBeat.o(110351);
    return bool;
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
    localStringBuilder.append("<ex>").append(Util.escapeStringForXml(parama.Jjl)).append("</ex>");
    localStringBuilder.append("<tl>").append(Util.escapeStringForXml(parama.IvM)).append("</tl>");
    localStringBuilder.append("<s>").append(Util.escapeStringForXml(parama.dIC)).append("</s>");
    localStringBuilder.append("<au>").append(parama.field_creator).append("</au>");
    localStringBuilder.append("<hrt>").append(parama.Jjm).append("</hrt>");
    localStringBuilder.append("<content>");
    localStringBuilder.append("<s>").append(parama.Jjo.size()).append("</s>");
    int i = 1;
    while (i <= parama.Jjo.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i));
      if (localb != null)
      {
        localStringBuilder.append("<i>");
        localStringBuilder.append("<u>").append(localb.username).append("</u>");
        localStringBuilder.append("<h>").append(localb.Jjr).append("</h>");
        localStringBuilder.append("<s>").append(Util.escapeStringForXml(localb.dIC)).append("</s>");
        localStringBuilder.append("<t>").append(localb.createtime).append("</t>");
        localStringBuilder.append("<c>").append(Util.escapeStringForXml(localb.content)).append("</c>");
        localStringBuilder.append("<o>").append(localb.Jjs).append("</o>");
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
    int j = 0;
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
    parama.Jjl = ((String)localMap.get(".solitaire.ex"));
    parama.IvM = ((String)localMap.get(".solitaire.tl"));
    parama.dIC = ((String)localMap.get(".solitaire.s"));
    parama.field_creator = ((String)localMap.get(".solitaire.au"));
    parama.Jjm = Util.getInt((String)localMap.get(".solitaire.hrt"), 1);
    if (localMap.containsKey(".solitaire.content" + ".s"))
    {
      int k = Util.getInt((String)localMap.get(".solitaire.content" + ".s"), 0);
      localObject = new ArrayList();
      int i = 0;
      if (i < k)
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
        if (i == 0)
        {
          localb.username = ((String)localMap.get(".solitaire.content.i" + ".u"));
          localb.Jjr = Util.getInt((String)localMap.get(".solitaire.content.i" + ".h"), 0);
          localb.dIC = ((String)localMap.get(".solitaire.content.i" + ".s"));
          localb.createtime = Util.getLong((String)localMap.get(".solitaire.content.i" + ".t"), 0L);
          localb.content = ((String)localMap.get(".solitaire.content.i" + ".c"));
        }
        for (localb.Jjs = Util.getInt((String)localMap.get(".solitaire.content.i" + ".o"), 0);; localb.Jjs = Util.getInt((String)localMap.get(".solitaire.content.i" + i + ".o"), 0))
        {
          ((ArrayList)localObject).add(localb);
          i += 1;
          break;
          localb.username = ((String)localMap.get(".solitaire.content.i" + i + ".u"));
          localb.Jjr = Util.getInt((String)localMap.get(".solitaire.content.i" + i + ".h"), 0);
          localb.dIC = ((String)localMap.get(".solitaire.content.i" + i + ".s"));
          localb.createtime = Util.getLong((String)localMap.get(".solitaire.content.i" + i + ".t"), 0L);
          localb.content = ((String)localMap.get(".solitaire.content.i" + i + ".c"));
        }
      }
      Collections.sort((List)localObject, new Comparator() {});
      i = j;
      while (i < k)
      {
        parama.Jjo.put(Integer.valueOf(parama.Jjo.size() + 1), (com.tencent.mm.plugin.groupsolitaire.c.b)((ArrayList)localObject).get(i));
        i += 1;
      }
    }
    AppMethodBeat.o(110354);
  }
  
  public static int fD(String paramString, int paramInt)
  {
    AppMethodBeat.i(110364);
    int j = paramString.length();
    int i = 0;
    while (i <= j)
    {
      int m = (i + j) / 2;
      int n = aHQ(paramString.substring(0, m));
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
  
  public static String fJc()
  {
    AppMethodBeat.i(110322);
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkm, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])(\\s*)");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mainBodyRegex:%s", new Object[] { str });
    AppMethodBeat.o(110322);
    return str;
  }
  
  public static String fJd()
  {
    AppMethodBeat.i(110323);
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkn, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "separatorRegex:%s", new Object[] { str });
    AppMethodBeat.o(110323);
    return str;
  }
  
  public static String fJe()
  {
    AppMethodBeat.i(110324);
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zko, "([0-9]{1,3})(\\s*)([.。;；、:,，])");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentSeparatorRegex:%s", new Object[] { str });
    AppMethodBeat.o(110324);
    return str;
  }
  
  public static String fJf()
  {
    AppMethodBeat.i(110325);
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkp, "^\\d{1,3}");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "numRegex:%s", new Object[] { str });
    AppMethodBeat.o(110325);
    return str;
  }
  
  public static String fJg()
  {
    AppMethodBeat.i(262650);
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkq, "^\\d{1,3}$");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "SingleNum:%s", new Object[] { str });
    AppMethodBeat.o(262650);
    return str;
  }
  
  public static String fJh()
  {
    AppMethodBeat.i(110326);
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkr, "\\d{1,3}");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentNumRegex:%s", new Object[] { str });
    AppMethodBeat.o(110326);
    return str;
  }
  
  public static String fJi()
  {
    AppMethodBeat.i(110327);
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zks, "(例|例如|如|格式|格式如)(\\s*)([,.:，：、 ])(.+)");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", new Object[] { str });
    AppMethodBeat.o(110327);
    return str;
  }
  
  public static int fJj()
  {
    AppMethodBeat.i(110328);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkt, 3);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireActiveIntervalTime() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110328);
    return i;
  }
  
  public static int fJk()
  {
    AppMethodBeat.i(110329);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zku, 5);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireActiveNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110329);
    return i;
  }
  
  public static int fJl()
  {
    AppMethodBeat.i(110330);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkv, 24);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireMatchIntervalTime() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110330);
    return i;
  }
  
  public static int fJm()
  {
    AppMethodBeat.i(110331);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkw, 10);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireMatchNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110331);
    return i;
  }
  
  public static int fJn()
  {
    AppMethodBeat.i(110332);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkl, 500);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110332);
    return i;
  }
  
  public static int fJo()
  {
    AppMethodBeat.i(110333);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkA, 150);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(110333);
    return i;
  }
  
  public static int fJp()
  {
    AppMethodBeat.i(178792);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkB, 500);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(178792);
    return i;
  }
  
  public static int fJq()
  {
    AppMethodBeat.i(178793);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkC, 500);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(178793);
    return i;
  }
  
  private static boolean fJr()
  {
    AppMethodBeat.i(262661);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkF, 0);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "isXmlForceUseCTagSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(262661);
      return true;
    }
    AppMethodBeat.o(262661);
    return false;
  }
  
  public static String fJs()
  {
    AppMethodBeat.i(262663);
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkE, "(\\.|。|,|，|:|：|;|；|、|-|\\s)");
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "equalStrWhiteListRegex:%s", new Object[] { str });
    AppMethodBeat.o(262663);
    return str;
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
    if ((parama.header != null) && (!Util.isNullOrNil(parama.header.trim())) && (parama.Jjm == 1))
    {
      parama.header = parama.header.trim();
      localStringBuilder.append(parama.header).append("\n");
    }
    if ((parama.Jjl != null) && (!Util.isNullOrNil(parama.Jjl.trim())))
    {
      parama.Jjl = parama.Jjl.trim();
      localStringBuilder.append(parama.Jjl).append("\n");
    }
    if (!Util.isNullOrNil(localStringBuilder.toString())) {
      localStringBuilder.append("\n");
    }
    if (parama.Jjo.size() > 0)
    {
      int i = 1;
      while (i <= parama.Jjo.size())
      {
        com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i));
        localStringBuilder.append(i).append(parama.dIC).append(" ").append(localb.content);
        if (i < parama.Jjo.size()) {
          localStringBuilder.append("\n");
        }
        i += 1;
      }
    }
    if ((parama.IvM != null) && (!Util.isNullOrNil(parama.IvM.trim())))
    {
      parama.IvM = parama.IvM.trim();
      localStringBuilder.append("\n");
      localStringBuilder.append("\n");
      localStringBuilder.append(parama.IvM);
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
    if ((parama.Jjm == 1) && (aHO(parama.header)))
    {
      AppMethodBeat.o(110362);
      return true;
    }
    AppMethodBeat.o(110362);
    return false;
  }
  
  public static Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> jm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110350);
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = new Pair(Boolean.FALSE, null);
      AppMethodBeat.o(110350);
      return paramString1;
    }
    paramString1 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().jr(paramString1, paramString2);
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
  
  private static Pair<Integer, Integer> jn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110357);
    if (fJr())
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
  
  private static String jo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110358);
    paramString1 = jn(paramString1, paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(110358);
      return paramString2;
    }
    paramString1 = paramString1.first + "-" + paramString1.second;
    AppMethodBeat.o(110358);
    return paramString1;
  }
  
  private static String jp(String paramString1, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.b
 * JD-Core Version:    0.7.0.1
 */