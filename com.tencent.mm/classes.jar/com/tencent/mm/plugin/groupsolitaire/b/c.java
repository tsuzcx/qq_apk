package com.tencent.mm.plugin.groupsolitaire.b;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  private Pattern tyA;
  private Pattern tyB;
  private ConcurrentHashMap<String, a> tyq;
  private ConcurrentLinkedQueue<a> tyr;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.groupsolitaire.c.a> tys;
  public ConcurrentHashMap<String, com.tencent.mm.plugin.groupsolitaire.c.a> tyt;
  private ConcurrentHashMap<String, a> tyu;
  private Pattern tyv;
  private Pattern tyw;
  private Pattern tyx;
  private Pattern tyy;
  private Pattern tyz;
  
  public c()
  {
    AppMethodBeat.i(110369);
    this.tyq = new ConcurrentHashMap();
    this.tyr = new ConcurrentLinkedQueue();
    this.tys = new ConcurrentHashMap();
    this.tyt = new ConcurrentHashMap();
    this.tyu = new ConcurrentHashMap();
    this.tyv = Pattern.compile(b.cRV());
    this.tyw = Pattern.compile(b.cSb());
    this.tyx = Pattern.compile(b.cRW());
    this.tyy = Pattern.compile(b.cRY());
    this.tyz = Pattern.compile(b.cRX());
    this.tyA = Pattern.compile(b.cSa());
    this.tyB = Pattern.compile(b.cRZ());
    try
    {
      String[] arrayOfString = PluginGroupSolitaire.getKV().getString("analyze_crash_content_num", "").split(";");
      if (arrayOfString != null)
      {
        int i = arrayOfString.length - 1;
        int j;
        for (int k = 0; i >= 0; k = j)
        {
          Object localObject = arrayOfString[i];
          j = k;
          if (!bs.isNullOrNil((String)localObject))
          {
            k += 1;
            if (k > 20) {
              break;
            }
            localObject = ((String)localObject).split(",");
            j = k;
            if (localObject != null)
            {
              j = k;
              if (localObject.length == 2)
              {
                a locala = new a(localObject[0], bs.getInt(localObject[1], 0));
                this.tyq.put(localObject[0], locala);
                this.tyr.add(locala);
                j = k;
              }
            }
          }
          i -= 1;
        }
      }
      AppMethodBeat.o(110369);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireManager", "GroupSolitatireManager %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(110369);
    }
  }
  
  private List<com.tencent.mm.plugin.groupsolitaire.c.b> a(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(110371);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    Object localObject = this.tyx.matcher(paramString.trim());
    paramString = this.tyy.matcher(paramString.trim());
    int j;
    int i;
    if (((Matcher)localObject).find())
    {
      paramString = ((Matcher)localObject).group(0);
      paramString = this.tyy.matcher(paramString.trim());
      if (paramString.find()) {
        localb.tyW = bs.getInt(paramString.group(0), 0);
      }
      localb.separator = paramString.replaceFirst("").trim();
      localb.content = ((Matcher)localObject).replaceFirst("").trim();
      if (parama == null) {
        break label465;
      }
      paramString = this.tyz.matcher(localb.content);
      if (!paramString.find()) {
        break label452;
      }
      paramString = paramString.group(0);
      j = localb.content.indexOf(paramString);
      if (j == -1) {
        break label439;
      }
      paramString = localb.content.substring(0, j);
      if ((bs.isNullOrNil(paramString)) || (bs.isNullOrNil(paramString.trim()))) {
        break label426;
      }
      i = 1;
      label203:
      if (i > parama.tyS.size()) {
        break label486;
      }
      if (!com.tencent.mm.plugin.groupsolitaire.c.b.hd(((com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i))).content, paramString.trim())) {
        break label406;
      }
    }
    label406:
    label426:
    label439:
    label452:
    label465:
    label478:
    label486:
    for (paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i));; paramString = null)
    {
      if (paramString != null)
      {
        localObject = localb.content;
        localb.content = paramString.content;
        localArrayList.add(localb);
        paramString = ((String)localObject).substring(j);
        if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(paramString.trim()))) {
          a(localArrayList, parama, paramString.trim());
        }
      }
      for (;;)
      {
        if (localArrayList.size() != 0) {
          break label478;
        }
        AppMethodBeat.o(110371);
        return null;
        if (!paramString.find()) {
          break;
        }
        localb.tyW = bs.getInt(paramString.group(0), 0);
        localb.content = paramString.replaceFirst("").trim();
        if ((!bs.isNullOrNil(localb.content)) && (!bs.isNullOrNil(localb.content.trim()))) {
          break;
        }
        AppMethodBeat.o(110371);
        return null;
        i += 1;
        break label203;
        localArrayList.add(localb);
        continue;
        localArrayList.add(localb);
        continue;
        localArrayList.add(localb);
        continue;
        localArrayList.add(localb);
        continue;
        localArrayList.add(localb);
      }
      AppMethodBeat.o(110371);
      return localArrayList;
    }
  }
  
  private static void a(String paramString, a parama)
  {
    AppMethodBeat.i(110377);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateMatchChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if ((bs.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(110377);
      return;
    }
    long l = ce.azK() - b.cSe() * com.tencent.mm.plugin.groupsolitaire.c.c.tyY.longValue();
    if (parama.tyo)
    {
      parama.typ = l;
      AppMethodBeat.o(110377);
      return;
    }
    if (parama.typ < l)
    {
      parama.tyo = true;
      parama.typ = l;
    }
    AppMethodBeat.o(110377);
  }
  
  private void a(List<com.tencent.mm.plugin.groupsolitaire.c.b> paramList, com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(110372);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110372);
      return;
    }
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    paramString = this.tyz.matcher(paramString);
    Object localObject;
    int j;
    int i;
    if (paramString.find())
    {
      localObject = paramString.group(0);
      localObject = this.tyA.matcher(((String)localObject).trim());
      if (((Matcher)localObject).find()) {
        localb.tyW = bs.getInt(((Matcher)localObject).group(0), 0);
      }
      localb.separator = ((Matcher)localObject).replaceFirst("").trim();
      localb.content = paramString.replaceFirst("").trim();
      paramString = this.tyz.matcher(localb.content);
      if (paramString.find())
      {
        paramString = paramString.group(0);
        j = localb.content.indexOf(paramString);
        if (j != -1)
        {
          paramString = localb.content.substring(0, j);
          if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(paramString.trim())))
          {
            i = 1;
            label193:
            if (i > parama.tyS.size()) {
              break label391;
            }
            if (!bs.lr(((com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i))).content, paramString.trim())) {}
          }
        }
      }
    }
    label391:
    for (paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.tyS.get(Integer.valueOf(i));; paramString = null)
    {
      if (paramString != null)
      {
        localObject = localb.content;
        localb.content = paramString.content;
        paramList.add(localb);
        paramString = ((String)localObject).substring(j);
        if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(paramString.trim())))
        {
          paramString = paramString.trim();
          break;
          i += 1;
          break label193;
        }
        AppMethodBeat.o(110372);
        return;
      }
      paramList.add(localb);
      AppMethodBeat.o(110372);
      return;
      paramList.add(localb);
      AppMethodBeat.o(110372);
      return;
      paramList.add(localb);
      AppMethodBeat.o(110372);
      return;
      paramList.add(localb);
      AppMethodBeat.o(110372);
      return;
    }
  }
  
  private static String aih(String paramString)
  {
    AppMethodBeat.i(110379);
    String str = paramString;
    if (paramString.length() > 200) {
      str = paramString.substring(0, 199);
    }
    paramString = com.tencent.mm.b.g.getMessageDigest(str.getBytes());
    AppMethodBeat.o(110379);
    return paramString;
  }
  
  private static void b(String paramString, a parama)
  {
    AppMethodBeat.i(110378);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateActiveChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if ((bs.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(110378);
      return;
    }
    long l = ce.azK() - b.cSc() * com.tencent.mm.plugin.groupsolitaire.c.c.tyX.longValue();
    if (parama.tym)
    {
      parama.tyn = l;
      AppMethodBeat.o(110378);
      return;
    }
    if (parama.tyn < l)
    {
      parama.tym = true;
      parama.tyn = l;
    }
    AppMethodBeat.o(110378);
  }
  
  private void cSl()
  {
    AppMethodBeat.i(110380);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.tyr.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      localStringBuilder.append(locala.key).append(",").append(locala.gMk).append(";");
    }
    PluginGroupSolitaire.getKV().edit().putString("analyze_crash_content_num", localStringBuilder.toString());
    AppMethodBeat.o(110380);
  }
  
  private Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> l(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(192997);
    int j = paramString.length();
    int i = paramArrayOfString.length - 1;
    Object localObject1;
    int m;
    int k;
    if (i >= 0)
    {
      localObject1 = paramArrayOfString[i];
      j -= ((String)localObject1).length();
      if (this.tyB.matcher(((String)localObject1).trim()).find())
      {
        m = 1;
        j = paramString.indexOf((String)localObject1, j);
        k = i;
        i = m;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        paramString = new Pair(Boolean.FALSE, null);
        AppMethodBeat.o(192997);
        return paramString;
        j -= 1;
        i -= 1;
        break;
      }
      localObject1 = new com.tencent.mm.plugin.groupsolitaire.c.a();
      String str;
      Object localObject2;
      if ((j >= 0) && (j <= paramString.length()))
      {
        i = 0;
        m = 0;
        if (i >= k) {
          break label436;
        }
        str = paramArrayOfString[i];
        localObject2 = this.tyw.matcher(str.trim());
        if (((Matcher)localObject2).find())
        {
          localObject2 = ((Matcher)localObject2).group(0);
          if (bs.isNullOrNil((String)localObject2)) {
            i = paramString.indexOf(str, m);
          }
        }
      }
      for (;;)
      {
        label196:
        if (i != 0) {
          if (i != -1) {
            break label282;
          }
        }
        label282:
        for (((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).header = paramString.substring(0, j).trim();; ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).header = paramString.substring(0, i).trim())
        {
          if (!b.aic(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).header)) {
            break label299;
          }
          paramString = new Pair(Boolean.FALSE, null);
          AppMethodBeat.o(192997);
          return paramString;
          i = paramString.indexOf((String)localObject2, m);
          break label196;
          m = m + str.length() + 1;
          i += 1;
          break;
        }
        label299:
        if ((i >= 0) && (i <= j)) {
          ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).tyO = paramString.substring(i, j).trim();
        }
        if ((k >= 0) && (k < paramArrayOfString.length))
        {
          i = paramArrayOfString[k].length() + j;
          if ((i > 0) && (i < paramString.length())) {
            ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).tyP = paramString.substring(i).trim();
          }
        }
        if (b.aid(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).tyP))
        {
          paramString = new Pair(Boolean.FALSE, null);
          AppMethodBeat.o(192997);
          return paramString;
        }
        ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).tyU += 1;
        paramString = new Pair(Boolean.TRUE, localObject1);
        AppMethodBeat.o(192997);
        return paramString;
        label436:
        i = -1;
      }
      j = 0;
      i = 0;
      k = 0;
    }
  }
  
  public final a aif(String paramString)
  {
    AppMethodBeat.i(110375);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110375);
      return null;
    }
    Object localObject2 = (a)this.tyu.get(paramString);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = new a();
      ((a)localObject1).cRU();
      localObject2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().dC(paramString, 0);
      List localList = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().dC(paramString, 1);
      if (((List)localObject2).size() > b.cSf())
      {
        ((a)localObject1).tyo = false;
        ((a)localObject1).typ = ((com.tencent.mm.plugin.groupsolitaire.c.a)((List)localObject2).get(b.cSf() - 1)).field_lastActiveTime;
        if (localList.size() <= b.cSd()) {
          break label224;
        }
        ((a)localObject1).tym = false;
        ((a)localObject1).tyn = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList.get(b.cSd() - 1)).field_lastActiveTime;
        label178:
        this.tyu.put(paramString, localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(110375);
      return localObject1;
      ((a)localObject1).tyo = true;
      ((a)localObject1).typ = (ce.azK() - b.cSe() * com.tencent.mm.plugin.groupsolitaire.c.c.tyY.longValue());
      break;
      label224:
      ((a)localObject1).tym = true;
      ((a)localObject1).tyn = (ce.azK() - b.cSc() * com.tencent.mm.plugin.groupsolitaire.c.c.tyX.longValue());
      break label178;
      localObject1 = localObject2;
      if (((a)localObject2).lastUpdateTime - ce.azK() > 10L)
      {
        ((a)localObject2).cRU();
        a(paramString, (a)localObject2);
        b(paramString, (a)localObject2);
        localObject1 = localObject2;
      }
    }
  }
  
  public final void aig(String paramString)
  {
    AppMethodBeat.i(110376);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110376);
      return;
    }
    a locala = new a();
    locala.cRU();
    List localList1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().dC(paramString, 0);
    List localList2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().dC(paramString, 1);
    if (localList1.size() > b.cSf())
    {
      locala.tyo = false;
      locala.typ = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList1.get(b.cSf() - 1)).field_lastActiveTime;
      if (localList2.size() <= b.cSd()) {
        break label206;
      }
      locala.tym = false;
    }
    for (locala.tyn = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList2.get(b.cSd() - 1)).field_lastActiveTime;; locala.tyn = (ce.azK() - b.cSc() * com.tencent.mm.plugin.groupsolitaire.c.c.tyX.longValue()))
    {
      this.tyu.put(paramString, locala);
      AppMethodBeat.o(110376);
      return;
      locala.tyo = true;
      locala.typ = (ce.azK() - b.cSe() * com.tencent.mm.plugin.groupsolitaire.c.c.tyY.longValue());
      break;
      label206:
      locala.tym = true;
    }
  }
  
  public final void c(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(192998);
    if ((parama != null) && (!bs.isNullOrNil(parama.field_key)))
    {
      ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "putTempGroupSolitatireToCache() username:%s key:%s", new Object[] { paramString, parama.field_key });
      this.tyt.put(paramString + parama.field_key, parama);
    }
    AppMethodBeat.o(192998);
  }
  
  public final Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> ha(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110370);
    ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire()");
    if (bs.isNullOrNil(paramString1))
    {
      paramString1 = new Pair(Integer.valueOf(0), null);
      AppMethodBeat.o(110370);
      return paramString1;
    }
    String str1 = paramString1.trim();
    if (bs.isNullOrNil(str1))
    {
      paramString1 = new Pair(Integer.valueOf(0), null);
      AppMethodBeat.o(110370);
      return paramString1;
    }
    String[] arrayOfString = str1.split("\n");
    boolean bool1 = false;
    int n = -1;
    int m = 0;
    int i1 = 0;
    int k = 0;
    if (arrayOfString.length > 1000)
    {
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() contentArray.length > 1000");
      paramString1 = new Pair(Integer.valueOf(0), null);
      AppMethodBeat.o(110370);
      return paramString1;
    }
    if (!bs.isNullOrNil(str1))
    {
      paramString1 = aih(str1);
      if (this.tyq.contains(paramString1)) {
        i = ((a)this.tyq.get(paramString1)).gMk;
      }
    }
    while (i > 3)
    {
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() getCrashNum() > 3");
      paramString1 = new Pair(Integer.valueOf(0), null);
      AppMethodBeat.o(110370);
      return paramString1;
      i = 0;
      continue;
      i = 0;
    }
    long l = ce.azI();
    com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
    int j;
    Object localObject1;
    boolean bool2;
    for (;;)
    {
      try
      {
        if (bs.isNullOrNil(str1)) {
          break label3408;
        }
        paramString1 = aih(str1);
        if (!this.tyq.contains(paramString1)) {
          continue;
        }
        paramString1 = (a)this.tyq.get(paramString1);
        paramString1.gMk += 1;
        cSl();
      }
      catch (Exception paramString1)
      {
        label396:
        label431:
        ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire Exception：%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        label527:
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = ce.azI() - l;
        if (l > 1000L) {
          break label3140;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 0L, 1L, false);
        ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(110370);
        return paramString1;
        bool2 = bool1;
        if (bool1) {
          break label3392;
        }
        localObject1 = this.tyw.matcher(paramString1.trim());
        bool1 = ((Matcher)localObject1).find();
        if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
          continue;
        }
        ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "example str:%s hasExample:%s", new Object[] { paramString1, Boolean.valueOf(bool1) });
        bool2 = bool1;
        if (!bool1) {
          break label3392;
        }
        localObject1 = ((Matcher)localObject1).group(0);
        if (!bs.isNullOrNil((String)localObject1)) {
          continue;
        }
        i = str1.indexOf(paramString1, k);
        k = paramString1.length() + k + 1;
        j += 1;
        continue;
        i = str1.indexOf((String)localObject1, k);
        continue;
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = ce.azI() - l;
        if (l > 1000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 0L, 1L, false);
        ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(110370);
        return paramString1;
        if (l > 2000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 1L, 1L, false);
        continue;
        if (l > 3000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 2L, 1L, false);
        continue;
        if (l > 4000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 3L, 1L, false);
        continue;
        if (l > 5000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 4L, 1L, false);
        continue;
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 5L, 1L, false);
        continue;
        n = str1.length();
        k = arrayOfString.length - 1;
        if (k < j) {
          break label3378;
        }
        paramString1 = arrayOfString[k];
        n -= paramString1.length();
        if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
          continue;
        }
        ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "str(last):%s", new Object[] { paramString1 });
        bool1 = this.tyv.matcher(paramString1.trim()).find();
        if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
          continue;
        }
        ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "mainBody(last) result:%s", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          continue;
        }
        n = str1.indexOf(paramString1, n);
        i1 = k;
        if ((m <= 0) || (m > str1.length())) {
          break label1523;
        }
        if (i == 0) {
          continue;
        }
        if (i != -1) {
          continue;
        }
        locala.header = str1.substring(0, m).trim();
        if (!b.aic(locala.header)) {
          break label1497;
        }
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = ce.azI() - l;
        if (l > 1000L) {
          break label1378;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 0L, 1L, false);
        ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(110370);
        return paramString1;
        n -= 1;
        k -= 1;
        continue;
        locala.header = str1.substring(0, i).trim();
        continue;
      }
      finally
      {
        l = ce.azI() - l;
        if (l > 1000L) {
          break label3259;
        }
      }
      if (j >= arrayOfString.length) {
        break label3399;
      }
      paramString1 = arrayOfString[j];
      localObject1 = this.tyv.matcher(paramString1.trim());
      if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
        ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "str(first):%s", new Object[] { paramString1 });
      }
      bool2 = ((Matcher)localObject1).find();
      if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
        ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "mainBody(first) result:%s", new Object[] { Boolean.valueOf(bool2) });
      }
      if (!bool2) {
        continue;
      }
      n = 1;
      m = str1.indexOf(paramString1, k);
      k = n;
      if (k != 0) {
        continue;
      }
      paramString1 = l(str1, arrayOfString);
      if (!((Boolean)paramString1.first).booleanValue()) {
        continue;
      }
      paramString1 = (com.tencent.mm.plugin.groupsolitaire.c.a)paramString1.second;
      if ((bs.isNullOrNil(paramString1.separator)) || (bs.isNullOrNil(paramString1.separator.trim()))) {
        paramString1.separator = ".";
      }
      if (!bs.isNullOrNil(str1))
      {
        paramString2 = (a)this.tyq.remove(aih(str1));
        this.tyr.remove(paramString2);
        cSl();
      }
      l = ce.azI() - l;
      if (l > 1000L) {
        break label3021;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 0L, 1L, false);
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
      if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
        ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() groupSolitatire:%s", new Object[] { paramString1 });
      }
      paramString1 = new Pair(Integer.valueOf(paramString1.tyS.size()), paramString1);
      AppMethodBeat.o(110370);
      return paramString1;
      localObject1 = new a(paramString1, 1);
      this.tyq.put(paramString1, localObject1);
      this.tyr.add(localObject1);
    }
    for (;;)
    {
      label704:
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 0L, 1L, false);
      label825:
      label1350:
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
      label1166:
      AppMethodBeat.o(110370);
      throw paramString1;
      label1378:
      if (l <= 2000L) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 1L, 1L, false);
      } else if (l <= 3000L) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 2L, 1L, false);
      } else if (l <= 4000L) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 3L, 1L, false);
      } else if (l <= 5000L) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 4L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 5L, 1L, false);
      }
    }
    label1497:
    if ((i >= 0) && (i <= m)) {
      locala.tyO = str1.substring(i, m).trim();
    }
    label1523:
    int i = n + arrayOfString[i1].length();
    if ((i > 0) && (i < str1.length())) {
      locala.tyP = str1.substring(i).trim();
    }
    if (b.aid(locala.tyP))
    {
      paramString1 = new Pair(Integer.valueOf(0), null);
      l = ce.azI() - l;
      if (l <= 1000L) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 0L, 1L, false);
      }
      for (;;)
      {
        ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(110370);
        return paramString1;
        if (l <= 2000L) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 1L, 1L, false);
        } else if (l <= 3000L) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 2L, 1L, false);
        } else if (l <= 4000L) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 3L, 1L, false);
        } else if (l <= 5000L) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 4L, 1L, false);
        } else {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 5L, 1L, false);
        }
      }
    }
    String str2 = b.a(locala);
    paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().he(paramString2, str2);
    locala.cSm();
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    k = str1.indexOf(arrayOfString[j]);
    m = j;
    label1820:
    if (m <= i1)
    {
      n = arrayOfString[m].length() + k + 1;
      j = m + 1;
      while (j <= i1)
      {
        localObject1 = arrayOfString[j];
        if (this.tyy.matcher(((String)localObject1).trim()).find()) {
          break;
        }
        n = n + arrayOfString[j].length() + 1;
        j += 1;
      }
      if (j > i1)
      {
        n = i;
        if (i > str1.length()) {
          n = str1.length();
        }
        localObject1 = str1.substring(str1.indexOf(arrayOfString[m], k), n);
        i = n;
      }
      for (;;)
      {
        n = k + ((String)localObject1).length();
        localObject2 = b.a(locala);
        if (!bs.lr(str2, (String)localObject2)) {
          paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().he(paramString2, (String)localObject2);
        }
        locala.cSm();
        localObject1 = a(paramString1, (String)localObject1);
        if (localObject1 != null) {
          break label3417;
        }
        k = n;
        m = j;
        break;
        int i3 = n;
        if (n >= str1.length()) {
          i3 = k;
        }
        localObject1 = str1.substring(str1.indexOf(arrayOfString[m], k), str1.indexOf(arrayOfString[j], i3));
      }
      label2081:
      if (m >= ((List)localObject1).size()) {
        break label3436;
      }
      Object localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)((List)localObject1).get(m);
      if (b.aib(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content))
      {
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = ce.azI() - l;
        if (l <= 1000L) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 0L, 1L, false);
        }
        for (;;)
        {
          ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(110370);
          return paramString1;
          if (l <= 2000L) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 1L, 1L, false);
          } else if (l <= 3000L) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 2L, 1L, false);
          } else if (l <= 4000L) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 3L, 1L, false);
          } else if (l <= 5000L) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 4L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 5L, 1L, false);
          }
        }
      }
      if (locala.tyS.size() == 0) {
        locala.separator = ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).separator;
      }
      if (((m == 0) && (bs.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content))) || (bs.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content.trim())))
      {
        locala.tyU += 1;
        localArrayList.add(Integer.valueOf(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).tyW));
      }
      else
      {
        HashMap localHashMap = locala.tyS;
        k += 1;
        localHashMap.put(Integer.valueOf(k), localObject2);
      }
    }
    else if (locala.tyS.size() + localArrayList.size() >= 4)
    {
      paramString1 = new HashSet();
      i = 0;
      j = 1;
      if (j > locala.tyS.size()) {
        break label3460;
      }
      paramString2 = (com.tencent.mm.plugin.groupsolitaire.c.b)locala.tyS.get(Integer.valueOf(j));
      if (paramString1.contains(Integer.valueOf(paramString2.tyW)))
      {
        k = i + 1;
        i = k;
        if (k < 2) {
          break label3451;
        }
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = ce.azI() - l;
        if (l <= 1000L) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 0L, 1L, false);
        }
        for (;;)
        {
          ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(110370);
          return paramString1;
          if (l <= 2000L) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 1L, 1L, false);
          } else if (l <= 3000L) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 2L, 1L, false);
          } else if (l <= 4000L) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 3L, 1L, false);
          } else if (l <= 5000L) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 4L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 5L, 1L, false);
          }
        }
      }
      paramString1.add(Integer.valueOf(paramString2.tyW));
      break label3451;
    }
    for (;;)
    {
      label2447:
      if (j < localArrayList.size())
      {
        k = ((Integer)localArrayList.get(j)).intValue();
        if (paramString1.contains(Integer.valueOf(k)))
        {
          k = i + 1;
          i = k;
          if (k >= 2)
          {
            paramString1 = new Pair(Integer.valueOf(0), null);
            l = ce.azI() - l;
            if (l <= 1000L) {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 0L, 1L, false);
            }
            for (;;)
            {
              ac.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
              AppMethodBeat.o(110370);
              return paramString1;
              if (l <= 2000L) {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 1L, 1L, false);
              } else if (l <= 3000L) {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 2L, 1L, false);
              } else if (l <= 4000L) {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 3L, 1L, false);
              } else if (l <= 5000L) {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 4L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 5L, 1L, false);
              }
            }
          }
        }
        else
        {
          paramString1.add(Integer.valueOf(k));
        }
      }
      else
      {
        if ((bs.isNullOrNil(locala.separator)) && (locala.tyS.size() > 0)) {
          locala.separator = ((com.tencent.mm.plugin.groupsolitaire.c.b)locala.tyS.get(Integer.valueOf(1))).separator;
        }
        paramString1 = locala;
        break label431;
        label3021:
        if (l <= 2000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 1L, 1L, false);
          break label527;
        }
        if (l <= 3000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 2L, 1L, false);
          break label527;
        }
        if (l <= 4000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 3L, 1L, false);
          break label527;
        }
        if (l <= 5000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 4L, 1L, false);
          break label527;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 5L, 1L, false);
        break label527;
        label3140:
        if (l <= 2000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 1L, 1L, false);
          break label704;
        }
        if (l <= 3000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 2L, 1L, false);
          break label704;
        }
        if (l <= 4000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 3L, 1L, false);
          break label704;
        }
        if (l <= 5000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 4L, 1L, false);
          break label704;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 5L, 1L, false);
        break label704;
        label3259:
        if (l <= 2000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 1L, 1L, false);
          break label1350;
        }
        if (l <= 3000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 2L, 1L, false);
          break label1350;
        }
        if (l <= 4000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 3L, 1L, false);
          break label1350;
        }
        if (l <= 5000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 4L, 1L, false);
          break label1350;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1174L, 5L, 1L, false);
        break label1350;
        label3378:
        k = 0;
        n = i1;
        i1 = k;
        break label1166;
        label3392:
        bool1 = bool2;
        break label825;
        label3399:
        j = 0;
        k = 0;
        break label396;
        label3408:
        j = 0;
        i = n;
        break;
        label3417:
        m = 0;
        k = i2;
        break label2081;
        m += 1;
        break label2081;
        label3436:
        i2 = k;
        k = n;
        m = j;
        break label1820;
        label3451:
        j += 1;
        break label2447;
        j = 0;
        continue;
      }
      label3460:
      j += 1;
    }
  }
  
  public final com.tencent.mm.plugin.groupsolitaire.c.a hb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110373);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getGroupSolitatireFromCache() username:%s key:%s", new Object[] { paramString1, paramString2 });
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110373);
      return null;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala2 = (com.tencent.mm.plugin.groupsolitaire.c.a)this.tys.get(paramString1 + paramString2);
    com.tencent.mm.plugin.groupsolitaire.c.a locala1;
    if (locala2 == null)
    {
      locala2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(paramString1, paramString2, true);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.tys.put(paramString1 + paramString2, locala2);
        locala1 = locala2;
      }
    }
    a locala;
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(110373);
          return locala1;
          locala = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().aif(paramString1);
          locala1 = locala2;
        } while (locala == null);
        if ((locala2.field_active == 1) && (locala2.field_lastActiveTime < locala.tyn)) {
          break;
        }
        locala1 = locala2;
      } while (locala2.field_active != 0);
      locala1 = locala2;
    } while (locala2.field_lastActiveTime >= locala.typ);
    hc(paramString1, paramString2);
    com.tencent.e.h.JZN.aS(new c.1(this, paramString1, paramString2));
    AppMethodBeat.o(110373);
    return null;
  }
  
  public final void hc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110374);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "deleteGroupSolitatireInCache() username:%s key:%s", new Object[] { paramString1, paramString2 });
    this.tys.remove(paramString1 + paramString2);
    AppMethodBeat.o(110374);
  }
  
  final class a
  {
    int gMk = 0;
    String key = "";
    
    public a(String paramString, int paramInt)
    {
      this.key = paramString;
      this.gMk = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(110368);
      paramObject = (a)paramObject;
      if (bs.lr(this.key, paramObject.key))
      {
        AppMethodBeat.o(110368);
        return true;
      }
      AppMethodBeat.o(110368);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(110367);
      int i = this.key.hashCode();
      AppMethodBeat.o(110367);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.c
 * JD-Core Version:    0.7.0.1
 */