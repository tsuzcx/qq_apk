package com.tencent.mm.plugin.groupsolitaire.b;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
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

public class c
{
  private ConcurrentHashMap<String, c.a> Dpf;
  private ConcurrentLinkedQueue<c.a> Dpg;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.groupsolitaire.c.a> Dph;
  public ConcurrentHashMap<String, com.tencent.mm.plugin.groupsolitaire.c.a> Dpi;
  private ConcurrentHashMap<String, a> Dpj;
  private Pattern Dpk;
  private Pattern Dpl;
  private Pattern Dpm;
  private Pattern Dpo;
  private Pattern Dpp;
  private Pattern Dpq;
  private Pattern numPattern;
  
  public c()
  {
    AppMethodBeat.i(110369);
    this.Dpf = new ConcurrentHashMap();
    this.Dpg = new ConcurrentLinkedQueue();
    this.Dph = new ConcurrentHashMap();
    this.Dpi = new ConcurrentHashMap();
    this.Dpj = new ConcurrentHashMap();
    this.Dpk = Pattern.compile(b.eBa());
    this.Dpl = Pattern.compile(b.eBg());
    this.Dpm = Pattern.compile(b.eBb());
    this.numPattern = Pattern.compile(b.eBd());
    this.Dpo = Pattern.compile(b.eBc());
    this.Dpp = Pattern.compile(b.eBf());
    this.Dpq = Pattern.compile(b.eBe());
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
          if (!Util.isNullOrNil((String)localObject))
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
                c.a locala = new c.a(this, localObject[0], Util.getInt(localObject[1], 0));
                this.Dpf.put(localObject[0], locala);
                this.Dpg.add(locala);
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
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireManager", "GroupSolitatireManager %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(110369);
    }
  }
  
  private List<com.tencent.mm.plugin.groupsolitaire.c.b> a(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(110371);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    Object localObject = this.Dpm.matcher(paramString.trim());
    paramString = this.numPattern.matcher(paramString.trim());
    int j;
    int i;
    if (((Matcher)localObject).find())
    {
      paramString = ((Matcher)localObject).group(0);
      paramString = this.numPattern.matcher(paramString.trim());
      if (paramString.find()) {
        localb.DpK = Util.getInt(paramString.group(0), 0);
      }
      localb.bOX = paramString.replaceFirst("").trim();
      localb.content = ((Matcher)localObject).replaceFirst("").trim();
      if (parama == null) {
        break label465;
      }
      paramString = this.Dpo.matcher(localb.content);
      if (!paramString.find()) {
        break label452;
      }
      paramString = paramString.group(0);
      j = localb.content.indexOf(paramString);
      if (j == -1) {
        break label439;
      }
      paramString = localb.content.substring(0, j);
      if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramString.trim()))) {
        break label426;
      }
      i = 1;
      label203:
      if (i > parama.DpG.size()) {
        break label486;
      }
      if (!com.tencent.mm.plugin.groupsolitaire.c.b.im(((com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i))).content, paramString.trim())) {
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
    for (paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i));; paramString = null)
    {
      if (paramString != null)
      {
        localObject = localb.content;
        localb.content = paramString.content;
        localArrayList.add(localb);
        paramString = ((String)localObject).substring(j);
        if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramString.trim()))) {
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
        localb.DpK = Util.getInt(paramString.group(0), 0);
        localb.content = paramString.replaceFirst("").trim();
        if ((!Util.isNullOrNil(localb.content)) && (!Util.isNullOrNil(localb.content.trim()))) {
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
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateMatchChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if ((Util.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(110377);
      return;
    }
    long l = cm.bfF() - b.eBj() * com.tencent.mm.plugin.groupsolitaire.c.c.DpM.longValue();
    if (parama.Dpd)
    {
      parama.Dpe = l;
      AppMethodBeat.o(110377);
      return;
    }
    if (parama.Dpe < l)
    {
      parama.Dpd = true;
      parama.Dpe = l;
    }
    AppMethodBeat.o(110377);
  }
  
  private void a(List<com.tencent.mm.plugin.groupsolitaire.c.b> paramList, com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(110372);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110372);
      return;
    }
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    paramString = this.Dpo.matcher(paramString);
    Object localObject;
    int j;
    int i;
    if (paramString.find())
    {
      localObject = paramString.group(0);
      localObject = this.Dpp.matcher(((String)localObject).trim());
      if (((Matcher)localObject).find()) {
        localb.DpK = Util.getInt(((Matcher)localObject).group(0), 0);
      }
      localb.bOX = ((Matcher)localObject).replaceFirst("").trim();
      localb.content = paramString.replaceFirst("").trim();
      paramString = this.Dpo.matcher(localb.content);
      if (paramString.find())
      {
        paramString = paramString.group(0);
        j = localb.content.indexOf(paramString);
        if (j != -1)
        {
          paramString = localb.content.substring(0, j);
          if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramString.trim())))
          {
            i = 1;
            if (i > parama.DpG.size()) {
              break label393;
            }
            if (!Util.isEqual(((com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i))).content, paramString.trim())) {}
          }
        }
      }
    }
    label393:
    for (paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.DpG.get(Integer.valueOf(i));; paramString = null)
    {
      if (paramString != null)
      {
        localObject = localb.content;
        localb.content = paramString.content;
        paramList.add(localb);
        paramString = ((String)localObject).substring(j);
        if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramString.trim()))) {
          a(paramList, parama, paramString.trim());
        }
        AppMethodBeat.o(110372);
        return;
        i += 1;
        break;
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
  
  private static String aLc(String paramString)
  {
    AppMethodBeat.i(110379);
    String str = paramString;
    if (paramString.length() > 200) {
      str = paramString.substring(0, 199);
    }
    paramString = g.getMessageDigest(str.getBytes());
    AppMethodBeat.o(110379);
    return paramString;
  }
  
  private static void b(String paramString, a parama)
  {
    AppMethodBeat.i(110378);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateActiveChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if ((Util.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(110378);
      return;
    }
    long l = cm.bfF() - b.eBh() * com.tencent.mm.plugin.groupsolitaire.c.c.DpL.longValue();
    if (parama.Dpb)
    {
      parama.Dpc = l;
      AppMethodBeat.o(110378);
      return;
    }
    if (parama.Dpc < l)
    {
      parama.Dpb = true;
      parama.Dpc = l;
    }
    AppMethodBeat.o(110378);
  }
  
  private void eBr()
  {
    AppMethodBeat.i(110380);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.Dpg.iterator();
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      localStringBuilder.append(locala.key).append(",").append(locala.num).append(";");
    }
    PluginGroupSolitaire.getKV().edit().putString("analyze_crash_content_num", localStringBuilder.toString());
    AppMethodBeat.o(110380);
  }
  
  private Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> k(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(246478);
    int j = paramString.length();
    int i = paramArrayOfString.length - 1;
    Object localObject1;
    int m;
    int k;
    if (i >= 0)
    {
      localObject1 = paramArrayOfString[i];
      j -= ((String)localObject1).length();
      if (this.Dpq.matcher(((String)localObject1).trim()).find())
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
        AppMethodBeat.o(246478);
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
        localObject2 = this.Dpl.matcher(str.trim());
        if (((Matcher)localObject2).find())
        {
          localObject2 = ((Matcher)localObject2).group(0);
          if (Util.isNullOrNil((String)localObject2)) {
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
          if (!b.aKX(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).header)) {
            break label299;
          }
          paramString = new Pair(Boolean.FALSE, null);
          AppMethodBeat.o(246478);
          return paramString;
          i = paramString.indexOf((String)localObject2, m);
          break label196;
          m = m + str.length() + 1;
          i += 1;
          break;
        }
        label299:
        if ((i >= 0) && (i <= j)) {
          ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).DpD = paramString.substring(i, j).trim();
        }
        if ((k >= 0) && (k < paramArrayOfString.length))
        {
          i = paramArrayOfString[k].length() + j;
          if ((i > 0) && (i < paramString.length())) {
            ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).CBX = paramString.substring(i).trim();
          }
        }
        if (b.aKY(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).CBX))
        {
          paramString = new Pair(Boolean.FALSE, null);
          AppMethodBeat.o(246478);
          return paramString;
        }
        ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).DpI += 1;
        paramString = new Pair(Boolean.TRUE, localObject1);
        AppMethodBeat.o(246478);
        return paramString;
        label436:
        i = -1;
      }
      j = 0;
      i = 0;
      k = 0;
    }
  }
  
  public final a aLa(String paramString)
  {
    AppMethodBeat.i(110375);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110375);
      return null;
    }
    Object localObject2 = (a)this.Dpj.get(paramString);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = new a();
      ((a)localObject1).eAZ();
      localObject2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().eN(paramString, 0);
      List localList = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().eN(paramString, 1);
      if (((List)localObject2).size() > b.eBk())
      {
        ((a)localObject1).Dpd = false;
        ((a)localObject1).Dpe = ((com.tencent.mm.plugin.groupsolitaire.c.a)((List)localObject2).get(b.eBk() - 1)).field_lastActiveTime;
        if (localList.size() <= b.eBi()) {
          break label224;
        }
        ((a)localObject1).Dpb = false;
        ((a)localObject1).Dpc = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList.get(b.eBi() - 1)).field_lastActiveTime;
        label178:
        this.Dpj.put(paramString, localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(110375);
      return localObject1;
      ((a)localObject1).Dpd = true;
      ((a)localObject1).Dpe = (cm.bfF() - b.eBj() * com.tencent.mm.plugin.groupsolitaire.c.c.DpM.longValue());
      break;
      label224:
      ((a)localObject1).Dpb = true;
      ((a)localObject1).Dpc = (cm.bfF() - b.eBh() * com.tencent.mm.plugin.groupsolitaire.c.c.DpL.longValue());
      break label178;
      localObject1 = localObject2;
      if (((a)localObject2).lastUpdateTime - cm.bfF() > 10L)
      {
        ((a)localObject2).eAZ();
        a(paramString, (a)localObject2);
        b(paramString, (a)localObject2);
        localObject1 = localObject2;
      }
    }
  }
  
  public final void aLb(String paramString)
  {
    AppMethodBeat.i(110376);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110376);
      return;
    }
    a locala = new a();
    locala.eAZ();
    List localList1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().eN(paramString, 0);
    List localList2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().eN(paramString, 1);
    if (localList1.size() > b.eBk())
    {
      locala.Dpd = false;
      locala.Dpe = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList1.get(b.eBk() - 1)).field_lastActiveTime;
      if (localList2.size() <= b.eBi()) {
        break label206;
      }
      locala.Dpb = false;
    }
    for (locala.Dpc = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList2.get(b.eBi() - 1)).field_lastActiveTime;; locala.Dpc = (cm.bfF() - b.eBh() * com.tencent.mm.plugin.groupsolitaire.c.c.DpL.longValue()))
    {
      this.Dpj.put(paramString, locala);
      AppMethodBeat.o(110376);
      return;
      locala.Dpd = true;
      locala.Dpe = (cm.bfF() - b.eBj() * com.tencent.mm.plugin.groupsolitaire.c.c.DpM.longValue());
      break;
      label206:
      locala.Dpb = true;
    }
  }
  
  public final void c(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(246479);
    if ((parama != null) && (!Util.isNullOrNil(parama.field_key)))
    {
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "putTempGroupSolitatireToCache() username:%s key:%s", new Object[] { paramString, parama.field_key });
      this.Dpi.put(paramString + parama.field_key, parama);
    }
    AppMethodBeat.o(246479);
  }
  
  public final Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> ij(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110370);
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire()");
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = new Pair(Integer.valueOf(0), null);
      AppMethodBeat.o(110370);
      return paramString1;
    }
    String str1 = paramString1.trim();
    if (Util.isNullOrNil(str1))
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
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() contentArray.length > 1000");
      paramString1 = new Pair(Integer.valueOf(0), null);
      AppMethodBeat.o(110370);
      return paramString1;
    }
    if (!Util.isNullOrNil(str1))
    {
      paramString1 = aLc(str1);
      if (this.Dpf.contains(paramString1)) {
        i = ((c.a)this.Dpf.get(paramString1)).num;
      }
    }
    while (i > 3)
    {
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() getCrashNum() > 3");
      paramString1 = new Pair(Integer.valueOf(0), null);
      AppMethodBeat.o(110370);
      return paramString1;
      i = 0;
      continue;
      i = 0;
    }
    long l = cm.bfD();
    com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
    int j;
    Object localObject1;
    boolean bool2;
    for (;;)
    {
      try
      {
        if (Util.isNullOrNil(str1)) {
          break label3408;
        }
        paramString1 = aLc(str1);
        if (!this.Dpf.contains(paramString1)) {
          continue;
        }
        paramString1 = (c.a)this.Dpf.get(paramString1);
        paramString1.num += 1;
        eBr();
      }
      catch (Exception paramString1)
      {
        label396:
        label431:
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire Exception：%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        label527:
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = cm.bfD() - l;
        if (l > 1000L) {
          break label3140;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 0L, 1L, false);
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(110370);
        return paramString1;
        bool2 = bool1;
        if (bool1) {
          break label3392;
        }
        localObject1 = this.Dpl.matcher(paramString1.trim());
        bool1 = ((Matcher)localObject1).find();
        if (!BuildInfo.DEBUG) {
          continue;
        }
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "example str:%s hasExample:%s", new Object[] { paramString1, Boolean.valueOf(bool1) });
        bool2 = bool1;
        if (!bool1) {
          break label3392;
        }
        localObject1 = ((Matcher)localObject1).group(0);
        if (!Util.isNullOrNil((String)localObject1)) {
          continue;
        }
        i = str1.indexOf(paramString1, k);
        k = paramString1.length() + k + 1;
        j += 1;
        continue;
        i = str1.indexOf((String)localObject1, k);
        continue;
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = cm.bfD() - l;
        if (l > 1000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 0L, 1L, false);
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(110370);
        return paramString1;
        if (l > 2000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 1L, 1L, false);
        continue;
        if (l > 3000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 2L, 1L, false);
        continue;
        if (l > 4000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 3L, 1L, false);
        continue;
        if (l > 5000L) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 4L, 1L, false);
        continue;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 5L, 1L, false);
        continue;
        n = str1.length();
        k = arrayOfString.length - 1;
        if (k < j) {
          break label3378;
        }
        paramString1 = arrayOfString[k];
        n -= paramString1.length();
        if (!BuildInfo.DEBUG) {
          continue;
        }
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "str(last):%s", new Object[] { paramString1 });
        bool1 = this.Dpk.matcher(paramString1.trim()).find();
        if (!BuildInfo.DEBUG) {
          continue;
        }
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "mainBody(last) result:%s", new Object[] { Boolean.valueOf(bool1) });
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
        if (!b.aKX(locala.header)) {
          break label1497;
        }
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = cm.bfD() - l;
        if (l > 1000L) {
          break label1378;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 0L, 1L, false);
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
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
        l = cm.bfD() - l;
        if (l > 1000L) {
          break label3259;
        }
      }
      if (j >= arrayOfString.length) {
        break label3399;
      }
      paramString1 = arrayOfString[j];
      localObject1 = this.Dpk.matcher(paramString1.trim());
      if (BuildInfo.DEBUG) {
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "str(first):%s", new Object[] { paramString1 });
      }
      bool2 = ((Matcher)localObject1).find();
      if (BuildInfo.DEBUG) {
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "mainBody(first) result:%s", new Object[] { Boolean.valueOf(bool2) });
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
      paramString1 = k(str1, arrayOfString);
      if (!((Boolean)paramString1.first).booleanValue()) {
        continue;
      }
      paramString1 = (com.tencent.mm.plugin.groupsolitaire.c.a)paramString1.second;
      if ((Util.isNullOrNil(paramString1.bOX)) || (Util.isNullOrNil(paramString1.bOX.trim()))) {
        paramString1.bOX = ".";
      }
      if (!Util.isNullOrNil(str1))
      {
        paramString2 = (c.a)this.Dpf.remove(aLc(str1));
        this.Dpg.remove(paramString2);
        eBr();
      }
      l = cm.bfD() - l;
      if (l > 1000L) {
        break label3021;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 0L, 1L, false);
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
      if (BuildInfo.DEBUG) {
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() groupSolitatire:%s", new Object[] { paramString1 });
      }
      paramString1 = new Pair(Integer.valueOf(paramString1.DpG.size()), paramString1);
      AppMethodBeat.o(110370);
      return paramString1;
      localObject1 = new c.a(this, paramString1, 1);
      this.Dpf.put(paramString1, localObject1);
      this.Dpg.add(localObject1);
    }
    for (;;)
    {
      label704:
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 0L, 1L, false);
      label825:
      label1350:
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
      label1166:
      AppMethodBeat.o(110370);
      throw paramString1;
      label1378:
      if (l <= 2000L) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 1L, 1L, false);
      } else if (l <= 3000L) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 2L, 1L, false);
      } else if (l <= 4000L) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 3L, 1L, false);
      } else if (l <= 5000L) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 4L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 5L, 1L, false);
      }
    }
    label1497:
    if ((i >= 0) && (i <= m)) {
      locala.DpD = str1.substring(i, m).trim();
    }
    label1523:
    int i = n + arrayOfString[i1].length();
    if ((i > 0) && (i < str1.length())) {
      locala.CBX = str1.substring(i).trim();
    }
    if (b.aKY(locala.CBX))
    {
      paramString1 = new Pair(Integer.valueOf(0), null);
      l = cm.bfD() - l;
      if (l <= 1000L) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 0L, 1L, false);
      }
      for (;;)
      {
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(110370);
        return paramString1;
        if (l <= 2000L) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 1L, 1L, false);
        } else if (l <= 3000L) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 2L, 1L, false);
        } else if (l <= 4000L) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 3L, 1L, false);
        } else if (l <= 5000L) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 4L, 1L, false);
        } else {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 5L, 1L, false);
        }
      }
    }
    String str2 = b.a(locala);
    paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().in(paramString2, str2);
    locala.eBs();
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
        if (this.numPattern.matcher(((String)localObject1).trim()).find()) {
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
        if (!Util.isEqual(str2, (String)localObject2)) {
          paramString1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().in(paramString2, (String)localObject2);
        }
        locala.eBs();
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
      if (b.aKW(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content))
      {
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = cm.bfD() - l;
        if (l <= 1000L) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 0L, 1L, false);
        }
        for (;;)
        {
          Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(110370);
          return paramString1;
          if (l <= 2000L) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 1L, 1L, false);
          } else if (l <= 3000L) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 2L, 1L, false);
          } else if (l <= 4000L) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 3L, 1L, false);
          } else if (l <= 5000L) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 4L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 5L, 1L, false);
          }
        }
      }
      if (locala.DpG.size() == 0) {
        locala.bOX = ((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).bOX;
      }
      if (((m == 0) && (Util.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content))) || (Util.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).content.trim())))
      {
        locala.DpI += 1;
        localArrayList.add(Integer.valueOf(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).DpK));
      }
      else
      {
        HashMap localHashMap = locala.DpG;
        k += 1;
        localHashMap.put(Integer.valueOf(k), localObject2);
      }
    }
    else if (locala.DpG.size() + localArrayList.size() >= 4)
    {
      paramString1 = new HashSet();
      i = 0;
      j = 1;
      if (j > locala.DpG.size()) {
        break label3460;
      }
      paramString2 = (com.tencent.mm.plugin.groupsolitaire.c.b)locala.DpG.get(Integer.valueOf(j));
      if (paramString1.contains(Integer.valueOf(paramString2.DpK)))
      {
        k = i + 1;
        i = k;
        if (k < 2) {
          break label3451;
        }
        paramString1 = new Pair(Integer.valueOf(0), null);
        l = cm.bfD() - l;
        if (l <= 1000L) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 0L, 1L, false);
        }
        for (;;)
        {
          Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(110370);
          return paramString1;
          if (l <= 2000L) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 1L, 1L, false);
          } else if (l <= 3000L) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 2L, 1L, false);
          } else if (l <= 4000L) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 3L, 1L, false);
          } else if (l <= 5000L) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 4L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 5L, 1L, false);
          }
        }
      }
      paramString1.add(Integer.valueOf(paramString2.DpK));
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
            l = cm.bfD() - l;
            if (l <= 1000L) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 0L, 1L, false);
            }
            for (;;)
            {
              Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", new Object[] { Long.valueOf(l) });
              AppMethodBeat.o(110370);
              return paramString1;
              if (l <= 2000L) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 1L, 1L, false);
              } else if (l <= 3000L) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 2L, 1L, false);
              } else if (l <= 4000L) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 3L, 1L, false);
              } else if (l <= 5000L) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 4L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 5L, 1L, false);
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
        if ((Util.isNullOrNil(locala.bOX)) && (locala.DpG.size() > 0)) {
          locala.bOX = ((com.tencent.mm.plugin.groupsolitaire.c.b)locala.DpG.get(Integer.valueOf(1))).bOX;
        }
        paramString1 = locala;
        break label431;
        label3021:
        if (l <= 2000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 1L, 1L, false);
          break label527;
        }
        if (l <= 3000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 2L, 1L, false);
          break label527;
        }
        if (l <= 4000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 3L, 1L, false);
          break label527;
        }
        if (l <= 5000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 4L, 1L, false);
          break label527;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 5L, 1L, false);
        break label527;
        label3140:
        if (l <= 2000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 1L, 1L, false);
          break label704;
        }
        if (l <= 3000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 2L, 1L, false);
          break label704;
        }
        if (l <= 4000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 3L, 1L, false);
          break label704;
        }
        if (l <= 5000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 4L, 1L, false);
          break label704;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 5L, 1L, false);
        break label704;
        label3259:
        if (l <= 2000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 1L, 1L, false);
          break label1350;
        }
        if (l <= 3000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 2L, 1L, false);
          break label1350;
        }
        if (l <= 4000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 3L, 1L, false);
          break label1350;
        }
        if (l <= 5000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 4L, 1L, false);
          break label1350;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1174L, 5L, 1L, false);
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
  
  public final com.tencent.mm.plugin.groupsolitaire.c.a ik(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110373);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getGroupSolitatireFromCache() username:%s key:%s", new Object[] { paramString1, paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110373);
      return null;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala2 = (com.tencent.mm.plugin.groupsolitaire.c.a)this.Dph.get(paramString1 + paramString2);
    com.tencent.mm.plugin.groupsolitaire.c.a locala1;
    if (locala2 == null)
    {
      locala2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().t(paramString1, paramString2, true);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.Dph.put(paramString1 + paramString2, locala2);
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
          locala = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().aLa(paramString1);
          locala1 = locala2;
        } while (locala == null);
        if ((locala2.field_active == 1) && (locala2.field_lastActiveTime < locala.Dpc)) {
          break;
        }
        locala1 = locala2;
      } while (locala2.field_active != 0);
      locala1 = locala2;
    } while (locala2.field_lastActiveTime >= locala.Dpe);
    il(paramString1, paramString2);
    com.tencent.e.h.ZvG.be(new c.1(this, paramString1, paramString2));
    AppMethodBeat.o(110373);
    return null;
  }
  
  public final void il(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110374);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "deleteGroupSolitatireInCache() username:%s key:%s", new Object[] { paramString1, paramString2 });
    this.Dph.remove(paramString1 + paramString2);
    AppMethodBeat.o(110374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.c
 * JD-Core Version:    0.7.0.1
 */