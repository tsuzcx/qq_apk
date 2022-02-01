package com.tencent.mm.plugin.groupsolitaire.b;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
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
  private ConcurrentHashMap<String, a> uMF;
  private ConcurrentLinkedQueue<a> uMG;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.groupsolitaire.c.a> uMH;
  public ConcurrentHashMap<String, com.tencent.mm.plugin.groupsolitaire.c.a> uMI;
  private ConcurrentHashMap<String, a> uMJ;
  private Pattern uMK;
  private Pattern uML;
  private Pattern uMM;
  private Pattern uMN;
  private Pattern uMO;
  private Pattern uMP;
  private Pattern uMQ;
  
  public c()
  {
    AppMethodBeat.i(110369);
    this.uMF = new ConcurrentHashMap();
    this.uMG = new ConcurrentLinkedQueue();
    this.uMH = new ConcurrentHashMap();
    this.uMI = new ConcurrentHashMap();
    this.uMJ = new ConcurrentHashMap();
    this.uMK = Pattern.compile(b.ddS());
    this.uML = Pattern.compile(b.ddY());
    this.uMM = Pattern.compile(b.ddT());
    this.uMN = Pattern.compile(b.ddV());
    this.uMO = Pattern.compile(b.ddU());
    this.uMP = Pattern.compile(b.ddX());
    this.uMQ = Pattern.compile(b.ddW());
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
          if (!bu.isNullOrNil((String)localObject))
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
                a locala = new a(localObject[0], bu.getInt(localObject[1], 0));
                this.uMF.put(localObject[0], locala);
                this.uMG.add(locala);
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
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireManager", "GroupSolitatireManager %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(110369);
    }
  }
  
  private List<com.tencent.mm.plugin.groupsolitaire.c.b> a(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(110371);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    Object localObject = this.uMM.matcher(paramString.trim());
    paramString = this.uMN.matcher(paramString.trim());
    int j;
    int i;
    if (((Matcher)localObject).find())
    {
      paramString = ((Matcher)localObject).group(0);
      paramString = this.uMN.matcher(paramString.trim());
      if (paramString.find()) {
        localb.uNk = bu.getInt(paramString.group(0), 0);
      }
      localb.separator = paramString.replaceFirst("").trim();
      localb.content = ((Matcher)localObject).replaceFirst("").trim();
      if (parama == null) {
        break label465;
      }
      paramString = this.uMO.matcher(localb.content);
      if (!paramString.find()) {
        break label452;
      }
      paramString = paramString.group(0);
      j = localb.content.indexOf(paramString);
      if (j == -1) {
        break label439;
      }
      paramString = localb.content.substring(0, j);
      if ((bu.isNullOrNil(paramString)) || (bu.isNullOrNil(paramString.trim()))) {
        break label426;
      }
      i = 1;
      label203:
      if (i > parama.uNg.size()) {
        break label486;
      }
      if (!com.tencent.mm.plugin.groupsolitaire.c.b.hw(((com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i))).content, paramString.trim())) {
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
    for (paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i));; paramString = null)
    {
      if (paramString != null)
      {
        localObject = localb.content;
        localb.content = paramString.content;
        localArrayList.add(localb);
        paramString = ((String)localObject).substring(j);
        if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(paramString.trim()))) {
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
        localb.uNk = bu.getInt(paramString.group(0), 0);
        localb.content = paramString.replaceFirst("").trim();
        if ((!bu.isNullOrNil(localb.content)) && (!bu.isNullOrNil(localb.content.trim()))) {
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
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateMatchChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if ((bu.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(110377);
      return;
    }
    long l = ch.aDd() - b.deb() * com.tencent.mm.plugin.groupsolitaire.c.c.uNm.longValue();
    if (parama.uMD)
    {
      parama.uME = l;
      AppMethodBeat.o(110377);
      return;
    }
    if (parama.uME < l)
    {
      parama.uMD = true;
      parama.uME = l;
    }
    AppMethodBeat.o(110377);
  }
  
  private void a(List<com.tencent.mm.plugin.groupsolitaire.c.b> paramList, com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(110372);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110372);
      return;
    }
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    paramString = this.uMO.matcher(paramString);
    Object localObject;
    int j;
    int i;
    if (paramString.find())
    {
      localObject = paramString.group(0);
      localObject = this.uMP.matcher(((String)localObject).trim());
      if (((Matcher)localObject).find()) {
        localb.uNk = bu.getInt(((Matcher)localObject).group(0), 0);
      }
      localb.separator = ((Matcher)localObject).replaceFirst("").trim();
      localb.content = paramString.replaceFirst("").trim();
      paramString = this.uMO.matcher(localb.content);
      if (paramString.find())
      {
        paramString = paramString.group(0);
        j = localb.content.indexOf(paramString);
        if (j != -1)
        {
          paramString = localb.content.substring(0, j);
          if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(paramString.trim())))
          {
            i = 1;
            label193:
            if (i > parama.uNg.size()) {
              break label391;
            }
            if (!bu.lX(((com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i))).content, paramString.trim())) {}
          }
        }
      }
    }
    label391:
    for (paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.uNg.get(Integer.valueOf(i));; paramString = null)
    {
      if (paramString != null)
      {
        localObject = localb.content;
        localb.content = paramString.content;
        paramList.add(localb);
        paramString = ((String)localObject).substring(j);
        if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(paramString.trim())))
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
  
  private static String anV(String paramString)
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
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateActiveChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if ((bu.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(110378);
      return;
    }
    long l = ch.aDd() - b.ddZ() * com.tencent.mm.plugin.groupsolitaire.c.c.uNl.longValue();
    if (parama.uMB)
    {
      parama.uMC = l;
      AppMethodBeat.o(110378);
      return;
    }
    if (parama.uMC < l)
    {
      parama.uMB = true;
      parama.uMC = l;
    }
    AppMethodBeat.o(110378);
  }
  
  private void dej()
  {
    AppMethodBeat.i(110380);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.uMG.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      localStringBuilder.append(locala.key).append(",").append(locala.hiV).append(";");
    }
    PluginGroupSolitaire.getKV().edit().putString("analyze_crash_content_num", localStringBuilder.toString());
    AppMethodBeat.o(110380);
  }
  
  private Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> l(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(221111);
    int j = paramString.length();
    int i = paramArrayOfString.length - 1;
    Object localObject1;
    int m;
    int k;
    if (i >= 0)
    {
      localObject1 = paramArrayOfString[i];
      j -= ((String)localObject1).length();
      if (this.uMQ.matcher(((String)localObject1).trim()).find())
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
        AppMethodBeat.o(221111);
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
        localObject2 = this.uML.matcher(str.trim());
        if (((Matcher)localObject2).find())
        {
          localObject2 = ((Matcher)localObject2).group(0);
          if (bu.isNullOrNil((String)localObject2)) {
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
          if (!b.anQ(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).header)) {
            break label299;
          }
          paramString = new Pair(Boolean.FALSE, null);
          AppMethodBeat.o(221111);
          return paramString;
          i = paramString.indexOf((String)localObject2, m);
          break label196;
          m = m + str.length() + 1;
          i += 1;
          break;
        }
        label299:
        if ((i >= 0) && (i <= j)) {
          ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).uNd = paramString.substring(i, j).trim();
        }
        if ((k >= 0) && (k < paramArrayOfString.length))
        {
          i = paramArrayOfString[k].length() + j;
          if ((i > 0) && (i < paramString.length())) {
            ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).ufC = paramString.substring(i).trim();
          }
        }
        if (b.anR(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).ufC))
        {
          paramString = new Pair(Boolean.FALSE, null);
          AppMethodBeat.o(221111);
          return paramString;
        }
        ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).uNi += 1;
        paramString = new Pair(Boolean.TRUE, localObject1);
        AppMethodBeat.o(221111);
        return paramString;
        label436:
        i = -1;
      }
      j = 0;
      i = 0;
      k = 0;
    }
  }
  
  public final a anT(String paramString)
  {
    AppMethodBeat.i(110375);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110375);
      return null;
    }
    Object localObject2 = (a)this.uMJ.get(paramString);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = new a();
      ((a)localObject1).ddR();
      localObject2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().dZ(paramString, 0);
      List localList = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().dZ(paramString, 1);
      if (((List)localObject2).size() > b.dec())
      {
        ((a)localObject1).uMD = false;
        ((a)localObject1).uME = ((com.tencent.mm.plugin.groupsolitaire.c.a)((List)localObject2).get(b.dec() - 1)).field_lastActiveTime;
        if (localList.size() <= b.dea()) {
          break label224;
        }
        ((a)localObject1).uMB = false;
        ((a)localObject1).uMC = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList.get(b.dea() - 1)).field_lastActiveTime;
        label178:
        this.uMJ.put(paramString, localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(110375);
      return localObject1;
      ((a)localObject1).uMD = true;
      ((a)localObject1).uME = (ch.aDd() - b.deb() * com.tencent.mm.plugin.groupsolitaire.c.c.uNm.longValue());
      break;
      label224:
      ((a)localObject1).uMB = true;
      ((a)localObject1).uMC = (ch.aDd() - b.ddZ() * com.tencent.mm.plugin.groupsolitaire.c.c.uNl.longValue());
      break label178;
      localObject1 = localObject2;
      if (((a)localObject2).lastUpdateTime - ch.aDd() > 10L)
      {
        ((a)localObject2).ddR();
        a(paramString, (a)localObject2);
        b(paramString, (a)localObject2);
        localObject1 = localObject2;
      }
    }
  }
  
  public final void anU(String paramString)
  {
    AppMethodBeat.i(110376);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110376);
      return;
    }
    a locala = new a();
    locala.ddR();
    List localList1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().dZ(paramString, 0);
    List localList2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().dZ(paramString, 1);
    if (localList1.size() > b.dec())
    {
      locala.uMD = false;
      locala.uME = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList1.get(b.dec() - 1)).field_lastActiveTime;
      if (localList2.size() <= b.dea()) {
        break label206;
      }
      locala.uMB = false;
    }
    for (locala.uMC = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList2.get(b.dea() - 1)).field_lastActiveTime;; locala.uMC = (ch.aDd() - b.ddZ() * com.tencent.mm.plugin.groupsolitaire.c.c.uNl.longValue()))
    {
      this.uMJ.put(paramString, locala);
      AppMethodBeat.o(110376);
      return;
      locala.uMD = true;
      locala.uME = (ch.aDd() - b.deb() * com.tencent.mm.plugin.groupsolitaire.c.c.uNm.longValue());
      break;
      label206:
      locala.uMB = true;
    }
  }
  
  public final void c(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(221112);
    if ((parama != null) && (!bu.isNullOrNil(parama.field_key)))
    {
      ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "putTempGroupSolitatireToCache() username:%s key:%s", new Object[] { paramString, parama.field_key });
      this.uMI.put(paramString + parama.field_key, parama);
    }
    AppMethodBeat.o(221112);
  }
  
  public final Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> ht(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110370);
    ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire()");
    if (bu.isNullOrNil(paramString1))
    {
      paramString1 = new Pair(Integer.valueOf(0), null);
      AppMethodBeat.o(110370);
      return paramString1;
    }
    String str1 = paramString1.trim();
    if (bu.isNullOrNil(str1))
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
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() contentArray.length > 1000");
      paramString1 = new Pair(Integer.valueOf(0), null);
      AppMethodBeat.o(110370);
      return paramString1;
    }
    if (!bu.isNullOrNil(str1))
    {
      paramString1 = anV(str1);
      if (this.uMF.contains(paramString1)) {
        i = ((a)this.uMF.get(paramString1)).hiV;
      }
    }
    while (i > 3)
    {
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() getCrashNum() > 3");
      paramString1 = new Pair(Integer.valueOf(0), null);
      AppMethodBeat.o(110370);
      return paramString1;
      i = 0;
      continue;
      i = 0;
    }
    long l = ch.aDb();
    com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
    int j;
    Object localObject1;
    boolean bool2;
    for (;;)
    {
      try
      {
        if (bu.isNullOrNil(str1)) {
          break label3408;
        }
        paramString1 = anV(str1);
        if (!this.uMF.contains(paramString1)) {
          continue;
        }
        paramString1 = (a)this.uMF.get(paramString1);
        paramString1.hiV += 1;
        dej();
      }
      catch (Exception paramString1)
      {
        label396:
        label431:
        ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire Exception：%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        label527:
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = ch.aDb() - l;
        if (l > 1000L) {
          break label3140;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 0L, 1L, false);
        ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(110370);
        return paramString1;
        bool2 = bool1;
        if (bool1) {
          break label3392;
        }
        localObject1 = this.uML.matcher(paramString1.trim());
        bool1 = ((Matcher)localObject1).find();
        if (!j.DEBUG) {
          continue;
        }
        ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "example str:%s hasExample:%s", new Object[] { paramString1, Boolean.valueOf(bool1) });
        bool2 = bool1;
        if (!bool1) {
          break label3392;
        }
        localObject1 = ((Matcher)localObject1).group(0);
        if (!bu.isNullOrNil((String)localObject1)) {
          continue;
        }
        i = str1.indexOf(paramString1, k);
        k = paramString1.length() + k + 1;
        j += 1;
        continue;
        i = str1.indexOf((String)localObject1, k);
        continue;
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = ch.aDb() - l;
        if (l > 1000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 0L, 1L, false);
        ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(110370);
        return paramString1;
        if (l > 2000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 1L, 1L, false);
        continue;
        if (l > 3000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 2L, 1L, false);
        continue;
        if (l > 4000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 3L, 1L, false);
        continue;
        if (l > 5000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 4L, 1L, false);
        continue;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 5L, 1L, false);
        continue;
        n = str1.length();
        k = arrayOfString.length - 1;
        if (k < j) {
          break label3378;
        }
        paramString1 = arrayOfString[k];
        n -= paramString1.length();
        if (!j.DEBUG) {
          continue;
        }
        ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "str(last):%s", new Object[] { paramString1 });
        bool1 = this.uMK.matcher(paramString1.trim()).find();
        if (!j.DEBUG) {
          continue;
        }
        ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "mainBody(last) result:%s", new Object[] { Boolean.valueOf(bool1) });
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
        if (!b.anQ(locala.header)) {
          break label1497;
        }
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = ch.aDb() - l;
        if (l > 1000L) {
          break label1378;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 0L, 1L, false);
        ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
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
        l = ch.aDb() - l;
        if (l > 1000L) {
          break label3259;
        }
      }
      if (j >= arrayOfString.length) {
        break label3399;
      }
      paramString1 = arrayOfString[j];
      localObject1 = this.uMK.matcher(paramString1.trim());
      if (j.DEBUG) {
        ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "str(first):%s", new Object[] { paramString1 });
      }
      bool2 = ((Matcher)localObject1).find();
      if (j.DEBUG) {
        ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "mainBody(first) result:%s", new Object[] { Boolean.valueOf(bool2) });
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
      if ((bu.isNullOrNil(paramString1.separator)) || (bu.isNullOrNil(paramString1.separator.trim()))) {
        paramString1.separator = ".";
      }
      if (!bu.isNullOrNil(str1))
      {
        paramString2 = (a)this.uMF.remove(anV(str1));
        this.uMG.remove(paramString2);
        dej();
      }
      l = ch.aDb() - l;
      if (l > 1000L) {
        break label3021;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 0L, 1L, false);
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
      if (j.DEBUG) {
        ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() groupSolitatire:%s", new Object[] { paramString1 });
      }
      paramString1 = new Pair(Integer.valueOf(paramString1.uNg.size()), paramString1);
      AppMethodBeat.o(110370);
      return paramString1;
      localObject1 = new a(paramString1, 1);
      this.uMF.put(paramString1, localObject1);
      this.uMG.add(localObject1);
    }
    for (;;)
    {
      label704:
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 0L, 1L, false);
      label825:
      label1350:
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
      label1166:
      AppMethodBeat.o(110370);
      throw paramString1;
      label1378:
      if (l <= 2000L) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 1L, 1L, false);
      } else if (l <= 3000L) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 2L, 1L, false);
      } else if (l <= 4000L) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 3L, 1L, false);
      } else if (l <= 5000L) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 4L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 5L, 1L, false);
      }
    }
    label1497:
    if ((i >= 0) && (i <= m)) {
      locala.uNd = str1.substring(i, m).trim();
    }
    label1523:
    int i = n + arrayOfString[i1].length();
    if ((i > 0) && (i < str1.length())) {
      locala.ufC = str1.substring(i).trim();
    }
    if (b.anR(locala.ufC))
    {
      paramString1 = new Pair(Integer.valueOf(0), null);
      l = ch.aDb() - l;
      if (l <= 1000L) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 0L, 1L, false);
      }
      for (;;)
      {
        ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(110370);
        return paramString1;
        if (l <= 2000L) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 1L, 1L, false);
        } else if (l <= 3000L) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 2L, 1L, false);
        } else if (l <= 4000L) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 3L, 1L, false);
        } else if (l <= 5000L) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 4L, 1L, false);
        } else {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 5L, 1L, false);
        }
      }
    }
    String str2 = b.a(locala);
    paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().hx(paramString2, str2);
    locala.dek();
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
        if (this.uMN.matcher(((String)localObject1).trim()).find()) {
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
        if (!bu.lX(str2, (String)localObject2)) {
          paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().hx(paramString2, (String)localObject2);
        }
        locala.dek();
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
      if (b.anP(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content))
      {
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = ch.aDb() - l;
        if (l <= 1000L) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 0L, 1L, false);
        }
        for (;;)
        {
          ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(110370);
          return paramString1;
          if (l <= 2000L) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 1L, 1L, false);
          } else if (l <= 3000L) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 2L, 1L, false);
          } else if (l <= 4000L) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 3L, 1L, false);
          } else if (l <= 5000L) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 4L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 5L, 1L, false);
          }
        }
      }
      if (locala.uNg.size() == 0) {
        locala.separator = ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).separator;
      }
      if (((m == 0) && (bu.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content))) || (bu.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content.trim())))
      {
        locala.uNi += 1;
        localArrayList.add(Integer.valueOf(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).uNk));
      }
      else
      {
        HashMap localHashMap = locala.uNg;
        k += 1;
        localHashMap.put(Integer.valueOf(k), localObject2);
      }
    }
    else if (locala.uNg.size() + localArrayList.size() >= 4)
    {
      paramString1 = new HashSet();
      i = 0;
      j = 1;
      if (j > locala.uNg.size()) {
        break label3460;
      }
      paramString2 = (com.tencent.mm.plugin.groupsolitaire.c.b)locala.uNg.get(Integer.valueOf(j));
      if (paramString1.contains(Integer.valueOf(paramString2.uNk)))
      {
        k = i + 1;
        i = k;
        if (k < 2) {
          break label3451;
        }
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = ch.aDb() - l;
        if (l <= 1000L) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 0L, 1L, false);
        }
        for (;;)
        {
          ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(110370);
          return paramString1;
          if (l <= 2000L) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 1L, 1L, false);
          } else if (l <= 3000L) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 2L, 1L, false);
          } else if (l <= 4000L) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 3L, 1L, false);
          } else if (l <= 5000L) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 4L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 5L, 1L, false);
          }
        }
      }
      paramString1.add(Integer.valueOf(paramString2.uNk));
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
            l = ch.aDb() - l;
            if (l <= 1000L) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 0L, 1L, false);
            }
            for (;;)
            {
              ae.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
              AppMethodBeat.o(110370);
              return paramString1;
              if (l <= 2000L) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 1L, 1L, false);
              } else if (l <= 3000L) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 2L, 1L, false);
              } else if (l <= 4000L) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 3L, 1L, false);
              } else if (l <= 5000L) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 4L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 5L, 1L, false);
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
        if ((bu.isNullOrNil(locala.separator)) && (locala.uNg.size() > 0)) {
          locala.separator = ((com.tencent.mm.plugin.groupsolitaire.c.b)locala.uNg.get(Integer.valueOf(1))).separator;
        }
        paramString1 = locala;
        break label431;
        label3021:
        if (l <= 2000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 1L, 1L, false);
          break label527;
        }
        if (l <= 3000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 2L, 1L, false);
          break label527;
        }
        if (l <= 4000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 3L, 1L, false);
          break label527;
        }
        if (l <= 5000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 4L, 1L, false);
          break label527;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 5L, 1L, false);
        break label527;
        label3140:
        if (l <= 2000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 1L, 1L, false);
          break label704;
        }
        if (l <= 3000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 2L, 1L, false);
          break label704;
        }
        if (l <= 4000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 3L, 1L, false);
          break label704;
        }
        if (l <= 5000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 4L, 1L, false);
          break label704;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 5L, 1L, false);
        break label704;
        label3259:
        if (l <= 2000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 1L, 1L, false);
          break label1350;
        }
        if (l <= 3000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 2L, 1L, false);
          break label1350;
        }
        if (l <= 4000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 3L, 1L, false);
          break label1350;
        }
        if (l <= 5000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 4L, 1L, false);
          break label1350;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1174L, 5L, 1L, false);
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
  
  public final com.tencent.mm.plugin.groupsolitaire.c.a hu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110373);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getGroupSolitatireFromCache() username:%s key:%s", new Object[] { paramString1, paramString2 });
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110373);
      return null;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala2 = (com.tencent.mm.plugin.groupsolitaire.c.a)this.uMH.get(paramString1 + paramString2);
    com.tencent.mm.plugin.groupsolitaire.c.a locala1;
    if (locala2 == null)
    {
      locala2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(paramString1, paramString2, true);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.uMH.put(paramString1 + paramString2, locala2);
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
          locala = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().anT(paramString1);
          locala1 = locala2;
        } while (locala == null);
        if ((locala2.field_active == 1) && (locala2.field_lastActiveTime < locala.uMC)) {
          break;
        }
        locala1 = locala2;
      } while (locala2.field_active != 0);
      locala1 = locala2;
    } while (locala2.field_lastActiveTime >= locala.uME);
    hv(paramString1, paramString2);
    h.MqF.aO(new c.1(this, paramString1, paramString2));
    AppMethodBeat.o(110373);
    return null;
  }
  
  public final void hv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110374);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "deleteGroupSolitatireInCache() username:%s key:%s", new Object[] { paramString1, paramString2 });
    this.uMH.remove(paramString1 + paramString2);
    AppMethodBeat.o(110374);
  }
  
  final class a
  {
    int hiV = 0;
    String key = "";
    
    public a(String paramString, int paramInt)
    {
      this.key = paramString;
      this.hiV = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(110368);
      paramObject = (a)paramObject;
      if (bu.lX(this.key, paramObject.key))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.c
 * JD-Core Version:    0.7.0.1
 */