package com.tencent.mm.plugin.groupsolitaire.b;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private ConcurrentHashMap<String, c.a> JiO;
  private ConcurrentLinkedQueue<c.a> JiP;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.groupsolitaire.c.a> JiQ;
  public ConcurrentHashMap<String, com.tencent.mm.plugin.groupsolitaire.c.a> JiR;
  private ConcurrentHashMap<String, a> JiS;
  private Pattern JiT;
  private Pattern JiU;
  private Pattern JiV;
  private Pattern JiW;
  private Pattern JiX;
  private Pattern JiY;
  private Pattern numPattern;
  
  public c()
  {
    AppMethodBeat.i(110369);
    this.JiO = new ConcurrentHashMap();
    this.JiP = new ConcurrentLinkedQueue();
    this.JiQ = new ConcurrentHashMap();
    this.JiR = new ConcurrentHashMap();
    this.JiS = new ConcurrentHashMap();
    this.JiT = Pattern.compile(b.fJc());
    this.JiU = Pattern.compile(b.fJi());
    this.JiV = Pattern.compile(b.fJd());
    this.numPattern = Pattern.compile(b.fJf());
    this.JiW = Pattern.compile(b.fJe());
    this.JiX = Pattern.compile(b.fJh());
    this.JiY = Pattern.compile(b.fJg());
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
                this.JiO.put(localObject[0], locala);
                this.JiP.add(locala);
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
    Object localObject = this.JiV.matcher(paramString.trim());
    paramString = this.numPattern.matcher(paramString.trim());
    int j;
    int i;
    if (((Matcher)localObject).find())
    {
      paramString = ((Matcher)localObject).group(0);
      paramString = this.numPattern.matcher(paramString.trim());
      if (paramString.find()) {
        localb.Jjs = Util.getInt(paramString.group(0), 0);
      }
      localb.dIC = paramString.replaceFirst("").trim();
      localb.content = ((Matcher)localObject).replaceFirst("").trim();
      if (parama == null) {
        break label465;
      }
      paramString = this.JiW.matcher(localb.content);
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
      if (i > parama.Jjo.size()) {
        break label486;
      }
      if (!com.tencent.mm.plugin.groupsolitaire.c.b.jt(((com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i))).content, paramString.trim())) {
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
    for (paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i));; paramString = null)
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
        localb.Jjs = Util.getInt(paramString.group(0), 0);
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
    long l = cn.getSyncServerTimeSecond() - b.fJl() * com.tencent.mm.plugin.groupsolitaire.c.c.Jju.longValue();
    if (parama.JiM)
    {
      parama.JiN = l;
      AppMethodBeat.o(110377);
      return;
    }
    if (parama.JiN < l)
    {
      parama.JiM = true;
      parama.JiN = l;
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
    paramString = this.JiW.matcher(paramString);
    Object localObject;
    int j;
    int i;
    if (paramString.find())
    {
      localObject = paramString.group(0);
      localObject = this.JiX.matcher(((String)localObject).trim());
      if (((Matcher)localObject).find()) {
        localb.Jjs = Util.getInt(((Matcher)localObject).group(0), 0);
      }
      localb.dIC = ((Matcher)localObject).replaceFirst("").trim();
      localb.content = paramString.replaceFirst("").trim();
      paramString = this.JiW.matcher(localb.content);
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
            if (i > parama.Jjo.size()) {
              break label393;
            }
            if (!Util.isEqual(((com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i))).content, paramString.trim())) {}
          }
        }
      }
    }
    label393:
    for (paramString = (com.tencent.mm.plugin.groupsolitaire.c.b)parama.Jjo.get(Integer.valueOf(i));; paramString = null)
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
  
  private static String aHT(String paramString)
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
    long l = cn.getSyncServerTimeSecond() - b.fJj() * com.tencent.mm.plugin.groupsolitaire.c.c.Jjt.longValue();
    if (parama.JiK)
    {
      parama.JiL = l;
      AppMethodBeat.o(110378);
      return;
    }
    if (parama.JiL < l)
    {
      parama.JiK = true;
      parama.JiL = l;
    }
    AppMethodBeat.o(110378);
  }
  
  private void fJt()
  {
    AppMethodBeat.i(110380);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.JiP.iterator();
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
    AppMethodBeat.i(262647);
    int j = paramString.length();
    int i = paramArrayOfString.length - 1;
    Object localObject1;
    int m;
    int k;
    if (i >= 0)
    {
      localObject1 = paramArrayOfString[i];
      j -= ((String)localObject1).length();
      if (this.JiY.matcher(((String)localObject1).trim()).find())
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
        AppMethodBeat.o(262647);
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
        localObject2 = this.JiU.matcher(str.trim());
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
          if (!b.aHO(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).header)) {
            break label299;
          }
          paramString = new Pair(Boolean.FALSE, null);
          AppMethodBeat.o(262647);
          return paramString;
          i = paramString.indexOf((String)localObject2, m);
          break label196;
          m = m + str.length() + 1;
          i += 1;
          break;
        }
        label299:
        if ((i >= 0) && (i <= j)) {
          ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).Jjl = paramString.substring(i, j).trim();
        }
        if ((k >= 0) && (k < paramArrayOfString.length))
        {
          i = paramArrayOfString[k].length() + j;
          if ((i > 0) && (i < paramString.length())) {
            ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).IvM = paramString.substring(i).trim();
          }
        }
        if (b.aHP(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).IvM))
        {
          paramString = new Pair(Boolean.FALSE, null);
          AppMethodBeat.o(262647);
          return paramString;
        }
        ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject1).Jjq += 1;
        paramString = new Pair(Boolean.TRUE, localObject1);
        AppMethodBeat.o(262647);
        return paramString;
        label436:
        i = -1;
      }
      j = 0;
      i = 0;
      k = 0;
    }
  }
  
  public final a aHR(String paramString)
  {
    AppMethodBeat.i(110375);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110375);
      return null;
    }
    Object localObject2 = (a)this.JiS.get(paramString);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = new a();
      ((a)localObject1).fJb();
      localObject2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().fF(paramString, 0);
      List localList = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().fF(paramString, 1);
      if (((List)localObject2).size() > b.fJm())
      {
        ((a)localObject1).JiM = false;
        ((a)localObject1).JiN = ((com.tencent.mm.plugin.groupsolitaire.c.a)((List)localObject2).get(b.fJm() - 1)).field_lastActiveTime;
        if (localList.size() <= b.fJk()) {
          break label224;
        }
        ((a)localObject1).JiK = false;
        ((a)localObject1).JiL = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList.get(b.fJk() - 1)).field_lastActiveTime;
        label178:
        this.JiS.put(paramString, localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(110375);
      return localObject1;
      ((a)localObject1).JiM = true;
      ((a)localObject1).JiN = (cn.getSyncServerTimeSecond() - b.fJl() * com.tencent.mm.plugin.groupsolitaire.c.c.Jju.longValue());
      break;
      label224:
      ((a)localObject1).JiK = true;
      ((a)localObject1).JiL = (cn.getSyncServerTimeSecond() - b.fJj() * com.tencent.mm.plugin.groupsolitaire.c.c.Jjt.longValue());
      break label178;
      localObject1 = localObject2;
      if (((a)localObject2).lastUpdateTime - cn.getSyncServerTimeSecond() > 10L)
      {
        ((a)localObject2).fJb();
        a(paramString, (a)localObject2);
        b(paramString, (a)localObject2);
        localObject1 = localObject2;
      }
    }
  }
  
  public final void aHS(String paramString)
  {
    AppMethodBeat.i(110376);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateChatRoomGroupSolitatire() username:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110376);
      return;
    }
    a locala = new a();
    locala.fJb();
    List localList1 = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().fF(paramString, 0);
    List localList2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().fF(paramString, 1);
    if (localList1.size() > b.fJm())
    {
      locala.JiM = false;
      locala.JiN = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList1.get(b.fJm() - 1)).field_lastActiveTime;
      if (localList2.size() <= b.fJk()) {
        break label206;
      }
      locala.JiK = false;
    }
    for (locala.JiL = ((com.tencent.mm.plugin.groupsolitaire.c.a)localList2.get(b.fJk() - 1)).field_lastActiveTime;; locala.JiL = (cn.getSyncServerTimeSecond() - b.fJj() * com.tencent.mm.plugin.groupsolitaire.c.c.Jjt.longValue()))
    {
      this.JiS.put(paramString, locala);
      AppMethodBeat.o(110376);
      return;
      locala.JiM = true;
      locala.JiN = (cn.getSyncServerTimeSecond() - b.fJl() * com.tencent.mm.plugin.groupsolitaire.c.c.Jju.longValue());
      break;
      label206:
      locala.JiK = true;
    }
  }
  
  public final void c(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    AppMethodBeat.i(262669);
    if ((parama != null) && (!Util.isNullOrNil(parama.field_key)))
    {
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "putTempGroupSolitatireToCache() username:%s key:%s", new Object[] { paramString, parama.field_key });
      this.JiR.put(paramString + parama.field_key, parama);
    }
    AppMethodBeat.o(262669);
  }
  
  /* Error */
  public final Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> jq(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 474
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 150
    //   8: ldc_w 476
    //   11: invokestatic 479	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   18: ifeq +24 -> 42
    //   21: new 381	android/util/Pair
    //   24: dup
    //   25: iconst_0
    //   26: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aconst_null
    //   30: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   33: astore_1
    //   34: ldc_w 474
    //   37: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_1
    //   41: areturn
    //   42: aload_1
    //   43: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   46: astore 18
    //   48: aload 18
    //   50: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   53: ifeq +24 -> 77
    //   56: new 381	android/util/Pair
    //   59: dup
    //   60: iconst_0
    //   61: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   64: aconst_null
    //   65: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   68: astore_1
    //   69: ldc_w 474
    //   72: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: areturn
    //   77: aload 18
    //   79: ldc_w 481
    //   82: invokevirtual 122	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   85: astore 19
    //   87: iconst_0
    //   88: istore 11
    //   90: iconst_m1
    //   91: istore 7
    //   93: iconst_0
    //   94: istore 6
    //   96: iconst_0
    //   97: istore 8
    //   99: iconst_0
    //   100: istore 5
    //   102: aload 19
    //   104: arraylength
    //   105: sipush 1000
    //   108: if_icmple +32 -> 140
    //   111: ldc 150
    //   113: ldc_w 483
    //   116: invokestatic 479	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: new 381	android/util/Pair
    //   122: dup
    //   123: iconst_0
    //   124: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aconst_null
    //   128: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   131: astore_1
    //   132: ldc_w 474
    //   135: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_1
    //   139: areturn
    //   140: aload 18
    //   142: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   145: ifne +74 -> 219
    //   148: aload 18
    //   150: invokestatic 485	com/tencent/mm/plugin/groupsolitaire/b/c:aHT	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 43	com/tencent/mm/plugin/groupsolitaire/b/c:JiO	Ljava/util/concurrent/ConcurrentHashMap;
    //   158: aload_1
    //   159: invokevirtual 488	java/util/concurrent/ConcurrentHashMap:contains	(Ljava/lang/Object;)Z
    //   162: ifeq +52 -> 214
    //   165: aload_0
    //   166: getfield 43	com/tencent/mm/plugin/groupsolitaire/b/c:JiO	Ljava/util/concurrent/ConcurrentHashMap;
    //   169: aload_1
    //   170: invokevirtual 419	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   173: checkcast 6	com/tencent/mm/plugin/groupsolitaire/b/c$a
    //   176: getfield 358	com/tencent/mm/plugin/groupsolitaire/b/c$a:num	I
    //   179: istore_3
    //   180: iload_3
    //   181: iconst_3
    //   182: if_icmple +42 -> 224
    //   185: ldc 150
    //   187: ldc_w 490
    //   190: invokestatic 479	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: new 381	android/util/Pair
    //   196: dup
    //   197: iconst_0
    //   198: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: aconst_null
    //   202: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   205: astore_1
    //   206: ldc_w 474
    //   209: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_1
    //   213: areturn
    //   214: iconst_0
    //   215: istore_3
    //   216: goto -36 -> 180
    //   219: iconst_0
    //   220: istore_3
    //   221: goto -41 -> 180
    //   224: invokestatic 493	com/tencent/mm/model/cn:bDv	()J
    //   227: lstore 13
    //   229: new 222	com/tencent/mm/plugin/groupsolitaire/c/a
    //   232: dup
    //   233: invokespecial 391	com/tencent/mm/plugin/groupsolitaire/c/a:<init>	()V
    //   236: astore 16
    //   238: aload 16
    //   240: astore 15
    //   242: aload 18
    //   244: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   247: ifne +3816 -> 4063
    //   250: aload 16
    //   252: astore 15
    //   254: aload 18
    //   256: invokestatic 485	com/tencent/mm/plugin/groupsolitaire/b/c:aHT	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore_1
    //   260: aload 16
    //   262: astore 15
    //   264: aload_0
    //   265: getfield 43	com/tencent/mm/plugin/groupsolitaire/b/c:JiO	Ljava/util/concurrent/ConcurrentHashMap;
    //   268: aload_1
    //   269: invokevirtual 488	java/util/concurrent/ConcurrentHashMap:contains	(Ljava/lang/Object;)Z
    //   272: ifeq +443 -> 715
    //   275: aload 16
    //   277: astore 15
    //   279: aload_0
    //   280: getfield 43	com/tencent/mm/plugin/groupsolitaire/b/c:JiO	Ljava/util/concurrent/ConcurrentHashMap;
    //   283: aload_1
    //   284: invokevirtual 419	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   287: checkcast 6	com/tencent/mm/plugin/groupsolitaire/b/c$a
    //   290: astore_1
    //   291: aload 16
    //   293: astore 15
    //   295: aload_1
    //   296: aload_1
    //   297: getfield 358	com/tencent/mm/plugin/groupsolitaire/b/c$a:num	I
    //   300: iconst_1
    //   301: iadd
    //   302: putfield 358	com/tencent/mm/plugin/groupsolitaire/b/c$a:num	I
    //   305: aload 16
    //   307: astore 15
    //   309: aload_0
    //   310: invokespecial 495	com/tencent/mm/plugin/groupsolitaire/b/c:fJt	()V
    //   313: goto +3750 -> 4063
    //   316: aload 16
    //   318: astore 15
    //   320: iload 4
    //   322: aload 19
    //   324: arraylength
    //   325: if_icmpge +3729 -> 4054
    //   328: aload 19
    //   330: iload 4
    //   332: aaload
    //   333: astore_1
    //   334: aload 16
    //   336: astore 15
    //   338: aload_0
    //   339: getfield 68	com/tencent/mm/plugin/groupsolitaire/b/c:JiT	Ljava/util/regex/Pattern;
    //   342: aload_1
    //   343: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   346: invokevirtual 187	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   349: astore 17
    //   351: aload 16
    //   353: astore 15
    //   355: getstatic 500	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   358: ifeq +23 -> 381
    //   361: aload 16
    //   363: astore 15
    //   365: ldc 150
    //   367: ldc_w 502
    //   370: iconst_1
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload_1
    //   377: aastore
    //   378: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: aload 16
    //   383: astore 15
    //   385: aload 17
    //   387: invokevirtual 193	java/util/regex/Matcher:find	()Z
    //   390: istore 12
    //   392: aload 16
    //   394: astore 15
    //   396: getstatic 500	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   399: ifeq +27 -> 426
    //   402: aload 16
    //   404: astore 15
    //   406: ldc 150
    //   408: ldc_w 504
    //   411: iconst_1
    //   412: anewarray 4	java/lang/Object
    //   415: dup
    //   416: iconst_0
    //   417: iload 12
    //   419: invokestatic 507	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   422: aastore
    //   423: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   426: iload 12
    //   428: ifeq +468 -> 896
    //   431: iconst_1
    //   432: istore 7
    //   434: aload 16
    //   436: astore 15
    //   438: aload 18
    //   440: aload_1
    //   441: iload 5
    //   443: invokevirtual 379	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   446: istore 6
    //   448: iload 7
    //   450: istore 5
    //   452: iload 5
    //   454: ifne +817 -> 1271
    //   457: aload 16
    //   459: astore 15
    //   461: aload_0
    //   462: aload 18
    //   464: aload 19
    //   466: invokespecial 509	com/tencent/mm/plugin/groupsolitaire/b/c:k	(Ljava/lang/String;[Ljava/lang/String;)Landroid/util/Pair;
    //   469: astore_1
    //   470: aload 16
    //   472: astore 15
    //   474: aload_1
    //   475: getfield 513	android/util/Pair:first	Ljava/lang/Object;
    //   478: checkcast 383	java/lang/Boolean
    //   481: invokevirtual 516	java/lang/Boolean:booleanValue	()Z
    //   484: ifeq +574 -> 1058
    //   487: aload 16
    //   489: astore 15
    //   491: aload_1
    //   492: getfield 519	android/util/Pair:second	Ljava/lang/Object;
    //   495: checkcast 222	com/tencent/mm/plugin/groupsolitaire/c/a
    //   498: astore_1
    //   499: aload_1
    //   500: astore 15
    //   502: aload_1
    //   503: getfield 520	com/tencent/mm/plugin/groupsolitaire/c/a:dIC	Ljava/lang/String;
    //   506: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   509: ifne +19 -> 528
    //   512: aload_1
    //   513: astore 15
    //   515: aload_1
    //   516: getfield 520	com/tencent/mm/plugin/groupsolitaire/c/a:dIC	Ljava/lang/String;
    //   519: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   522: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   525: ifeq +13 -> 538
    //   528: aload_1
    //   529: astore 15
    //   531: aload_1
    //   532: ldc_w 522
    //   535: putfield 520	com/tencent/mm/plugin/groupsolitaire/c/a:dIC	Ljava/lang/String;
    //   538: aload_1
    //   539: astore 15
    //   541: aload 18
    //   543: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   546: ifne +41 -> 587
    //   549: aload_1
    //   550: astore 15
    //   552: aload_0
    //   553: getfield 43	com/tencent/mm/plugin/groupsolitaire/b/c:JiO	Ljava/util/concurrent/ConcurrentHashMap;
    //   556: aload 18
    //   558: invokestatic 485	com/tencent/mm/plugin/groupsolitaire/b/c:aHT	(Ljava/lang/String;)Ljava/lang/String;
    //   561: invokevirtual 525	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   564: checkcast 6	com/tencent/mm/plugin/groupsolitaire/b/c$a
    //   567: astore_2
    //   568: aload_1
    //   569: astore 15
    //   571: aload_0
    //   572: getfield 48	com/tencent/mm/plugin/groupsolitaire/b/c:JiP	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   575: aload_2
    //   576: invokevirtual 527	java/util/concurrent/ConcurrentLinkedQueue:remove	(Ljava/lang/Object;)Z
    //   579: pop
    //   580: aload_1
    //   581: astore 15
    //   583: aload_0
    //   584: invokespecial 495	com/tencent/mm/plugin/groupsolitaire/b/c:fJt	()V
    //   587: invokestatic 493	com/tencent/mm/model/cn:bDv	()J
    //   590: lload 13
    //   592: lsub
    //   593: lstore 13
    //   595: lload 13
    //   597: ldc2_w 528
    //   600: lcmp
    //   601: ifgt +3046 -> 3647
    //   604: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   607: ldc2_w 536
    //   610: lconst_0
    //   611: lconst_1
    //   612: iconst_0
    //   613: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   616: aload_1
    //   617: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   620: invokevirtual 232	java/util/HashMap:size	()I
    //   623: istore_3
    //   624: aload_1
    //   625: ifnull +3141 -> 3766
    //   628: iconst_1
    //   629: istore 11
    //   631: ldc 150
    //   633: ldc_w 543
    //   636: iconst_3
    //   637: anewarray 4	java/lang/Object
    //   640: dup
    //   641: iconst_0
    //   642: lload 13
    //   644: invokestatic 546	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   647: aastore
    //   648: dup
    //   649: iconst_1
    //   650: iload_3
    //   651: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   654: aastore
    //   655: dup
    //   656: iconst_2
    //   657: iload 11
    //   659: invokestatic 507	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   662: aastore
    //   663: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   666: getstatic 500	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   669: ifeq +19 -> 688
    //   672: ldc 150
    //   674: ldc_w 550
    //   677: iconst_1
    //   678: anewarray 4	java/lang/Object
    //   681: dup
    //   682: iconst_0
    //   683: aload_1
    //   684: aastore
    //   685: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   688: new 381	android/util/Pair
    //   691: dup
    //   692: aload_1
    //   693: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   696: invokevirtual 232	java/util/HashMap:size	()I
    //   699: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   702: aload_1
    //   703: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   706: astore_1
    //   707: ldc_w 474
    //   710: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   713: aload_1
    //   714: areturn
    //   715: aload 16
    //   717: astore 15
    //   719: new 6	com/tencent/mm/plugin/groupsolitaire/b/c$a
    //   722: dup
    //   723: aload_0
    //   724: aload_1
    //   725: iconst_1
    //   726: invokespecial 137	com/tencent/mm/plugin/groupsolitaire/b/c$a:<init>	(Lcom/tencent/mm/plugin/groupsolitaire/b/c;Ljava/lang/String;I)V
    //   729: astore 17
    //   731: aload 16
    //   733: astore 15
    //   735: aload_0
    //   736: getfield 43	com/tencent/mm/plugin/groupsolitaire/b/c:JiO	Ljava/util/concurrent/ConcurrentHashMap;
    //   739: aload_1
    //   740: aload 17
    //   742: invokevirtual 141	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   745: pop
    //   746: aload 16
    //   748: astore 15
    //   750: aload_0
    //   751: getfield 48	com/tencent/mm/plugin/groupsolitaire/b/c:JiP	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   754: aload 17
    //   756: invokevirtual 145	java/util/concurrent/ConcurrentLinkedQueue:add	(Ljava/lang/Object;)Z
    //   759: pop
    //   760: goto -455 -> 305
    //   763: astore_2
    //   764: aload 16
    //   766: astore_1
    //   767: ldc 150
    //   769: ldc_w 552
    //   772: iconst_2
    //   773: anewarray 4	java/lang/Object
    //   776: dup
    //   777: iconst_0
    //   778: aload_2
    //   779: invokevirtual 156	java/lang/Object:getClass	()Ljava/lang/Class;
    //   782: invokevirtual 161	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   785: aastore
    //   786: dup
    //   787: iconst_1
    //   788: aload_2
    //   789: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   792: aastore
    //   793: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   796: new 381	android/util/Pair
    //   799: dup
    //   800: iconst_0
    //   801: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   804: aconst_null
    //   805: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   808: astore_2
    //   809: invokestatic 493	com/tencent/mm/model/cn:bDv	()J
    //   812: lload 13
    //   814: lsub
    //   815: lstore 13
    //   817: lload 13
    //   819: ldc2_w 528
    //   822: lcmp
    //   823: ifgt +2949 -> 3772
    //   826: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   829: ldc2_w 536
    //   832: lconst_0
    //   833: lconst_1
    //   834: iconst_0
    //   835: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   838: aload_1
    //   839: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   842: invokevirtual 232	java/util/HashMap:size	()I
    //   845: istore_3
    //   846: aload_1
    //   847: ifnull +3044 -> 3891
    //   850: iconst_1
    //   851: istore 11
    //   853: ldc 150
    //   855: ldc_w 543
    //   858: iconst_3
    //   859: anewarray 4	java/lang/Object
    //   862: dup
    //   863: iconst_0
    //   864: lload 13
    //   866: invokestatic 546	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   869: aastore
    //   870: dup
    //   871: iconst_1
    //   872: iload_3
    //   873: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   876: aastore
    //   877: dup
    //   878: iconst_2
    //   879: iload 11
    //   881: invokestatic 507	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   884: aastore
    //   885: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   888: ldc_w 474
    //   891: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   894: aload_2
    //   895: areturn
    //   896: iload 11
    //   898: istore 12
    //   900: iload 11
    //   902: ifne +3145 -> 4047
    //   905: aload 16
    //   907: astore 15
    //   909: aload_0
    //   910: getfield 73	com/tencent/mm/plugin/groupsolitaire/b/c:JiU	Ljava/util/regex/Pattern;
    //   913: aload_1
    //   914: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   917: invokevirtual 187	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   920: astore 17
    //   922: aload 16
    //   924: astore 15
    //   926: aload 17
    //   928: invokevirtual 193	java/util/regex/Matcher:find	()Z
    //   931: istore 11
    //   933: aload 16
    //   935: astore 15
    //   937: getstatic 500	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   940: ifeq +31 -> 971
    //   943: aload 16
    //   945: astore 15
    //   947: ldc 150
    //   949: ldc_w 554
    //   952: iconst_2
    //   953: anewarray 4	java/lang/Object
    //   956: dup
    //   957: iconst_0
    //   958: aload_1
    //   959: aastore
    //   960: dup
    //   961: iconst_1
    //   962: iload 11
    //   964: invokestatic 507	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   967: aastore
    //   968: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   971: iload 11
    //   973: istore 12
    //   975: iload 11
    //   977: ifeq +3070 -> 4047
    //   980: aload 16
    //   982: astore 15
    //   984: aload 17
    //   986: iconst_0
    //   987: invokevirtual 197	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   990: astore 17
    //   992: aload 16
    //   994: astore 15
    //   996: aload 17
    //   998: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1001: ifeq +40 -> 1041
    //   1004: aload 16
    //   1006: astore 15
    //   1008: aload 18
    //   1010: aload_1
    //   1011: iload 5
    //   1013: invokevirtual 379	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   1016: istore_3
    //   1017: aload 16
    //   1019: astore 15
    //   1021: aload_1
    //   1022: invokevirtual 304	java/lang/String:length	()I
    //   1025: iload 5
    //   1027: iadd
    //   1028: iconst_1
    //   1029: iadd
    //   1030: istore 5
    //   1032: iload 4
    //   1034: iconst_1
    //   1035: iadd
    //   1036: istore 4
    //   1038: goto -722 -> 316
    //   1041: aload 16
    //   1043: astore 15
    //   1045: aload 18
    //   1047: aload 17
    //   1049: iload 5
    //   1051: invokevirtual 379	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   1054: istore_3
    //   1055: goto -38 -> 1017
    //   1058: aload 16
    //   1060: astore 15
    //   1062: new 381	android/util/Pair
    //   1065: dup
    //   1066: iconst_0
    //   1067: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1070: aconst_null
    //   1071: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1074: astore_1
    //   1075: invokestatic 493	com/tencent/mm/model/cn:bDv	()J
    //   1078: lload 13
    //   1080: lsub
    //   1081: lstore 13
    //   1083: lload 13
    //   1085: ldc2_w 528
    //   1088: lcmp
    //   1089: ifgt +63 -> 1152
    //   1092: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1095: ldc2_w 536
    //   1098: lconst_0
    //   1099: lconst_1
    //   1100: iconst_0
    //   1101: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1104: ldc 150
    //   1106: ldc_w 543
    //   1109: iconst_3
    //   1110: anewarray 4	java/lang/Object
    //   1113: dup
    //   1114: iconst_0
    //   1115: lload 13
    //   1117: invokestatic 546	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1120: aastore
    //   1121: dup
    //   1122: iconst_1
    //   1123: aload 16
    //   1125: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   1128: invokevirtual 232	java/util/HashMap:size	()I
    //   1131: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1134: aastore
    //   1135: dup
    //   1136: iconst_2
    //   1137: getstatic 412	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1140: aastore
    //   1141: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1144: ldc_w 474
    //   1147: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1150: aload_1
    //   1151: areturn
    //   1152: lload 13
    //   1154: ldc2_w 555
    //   1157: lcmp
    //   1158: ifgt +18 -> 1176
    //   1161: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1164: ldc2_w 536
    //   1167: lconst_1
    //   1168: lconst_1
    //   1169: iconst_0
    //   1170: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1173: goto -69 -> 1104
    //   1176: lload 13
    //   1178: ldc2_w 557
    //   1181: lcmp
    //   1182: ifgt +20 -> 1202
    //   1185: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1188: ldc2_w 536
    //   1191: ldc2_w 559
    //   1194: lconst_1
    //   1195: iconst_0
    //   1196: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1199: goto -95 -> 1104
    //   1202: lload 13
    //   1204: ldc2_w 561
    //   1207: lcmp
    //   1208: ifgt +20 -> 1228
    //   1211: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1214: ldc2_w 536
    //   1217: ldc2_w 563
    //   1220: lconst_1
    //   1221: iconst_0
    //   1222: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1225: goto -121 -> 1104
    //   1228: lload 13
    //   1230: ldc2_w 565
    //   1233: lcmp
    //   1234: ifgt +20 -> 1254
    //   1237: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1240: ldc2_w 536
    //   1243: ldc2_w 567
    //   1246: lconst_1
    //   1247: iconst_0
    //   1248: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1251: goto -147 -> 1104
    //   1254: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1257: ldc2_w 536
    //   1260: ldc2_w 569
    //   1263: lconst_1
    //   1264: iconst_0
    //   1265: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1268: goto -164 -> 1104
    //   1271: aload 16
    //   1273: astore 15
    //   1275: aload 18
    //   1277: invokevirtual 304	java/lang/String:length	()I
    //   1280: istore 7
    //   1282: aload 16
    //   1284: astore 15
    //   1286: aload 19
    //   1288: arraylength
    //   1289: iconst_1
    //   1290: isub
    //   1291: istore 5
    //   1293: iload 5
    //   1295: iload 4
    //   1297: if_icmplt +2736 -> 4033
    //   1300: aload 19
    //   1302: iload 5
    //   1304: aaload
    //   1305: astore_1
    //   1306: aload 16
    //   1308: astore 15
    //   1310: iload 7
    //   1312: aload_1
    //   1313: invokevirtual 304	java/lang/String:length	()I
    //   1316: isub
    //   1317: istore 7
    //   1319: aload 16
    //   1321: astore 15
    //   1323: getstatic 500	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   1326: ifeq +23 -> 1349
    //   1329: aload 16
    //   1331: astore 15
    //   1333: ldc 150
    //   1335: ldc_w 572
    //   1338: iconst_1
    //   1339: anewarray 4	java/lang/Object
    //   1342: dup
    //   1343: iconst_0
    //   1344: aload_1
    //   1345: aastore
    //   1346: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1349: aload 16
    //   1351: astore 15
    //   1353: aload_0
    //   1354: getfield 68	com/tencent/mm/plugin/groupsolitaire/b/c:JiT	Ljava/util/regex/Pattern;
    //   1357: aload_1
    //   1358: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   1361: invokevirtual 187	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   1364: invokevirtual 193	java/util/regex/Matcher:find	()Z
    //   1367: istore 11
    //   1369: aload 16
    //   1371: astore 15
    //   1373: getstatic 500	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   1376: ifeq +27 -> 1403
    //   1379: aload 16
    //   1381: astore 15
    //   1383: ldc 150
    //   1385: ldc_w 574
    //   1388: iconst_1
    //   1389: anewarray 4	java/lang/Object
    //   1392: dup
    //   1393: iconst_0
    //   1394: iload 11
    //   1396: invokestatic 507	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1399: aastore
    //   1400: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1403: iload 11
    //   1405: ifeq +178 -> 1583
    //   1408: aload 16
    //   1410: astore 15
    //   1412: aload 18
    //   1414: aload_1
    //   1415: iload 7
    //   1417: invokevirtual 379	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   1420: istore 7
    //   1422: iload 5
    //   1424: istore 8
    //   1426: iload 6
    //   1428: ifle +431 -> 1859
    //   1431: aload 16
    //   1433: astore 15
    //   1435: iload 6
    //   1437: aload 18
    //   1439: invokevirtual 304	java/lang/String:length	()I
    //   1442: if_icmpgt +417 -> 1859
    //   1445: iload_3
    //   1446: ifeq +28 -> 1474
    //   1449: iload_3
    //   1450: iconst_m1
    //   1451: if_icmpne +147 -> 1598
    //   1454: aload 16
    //   1456: astore 15
    //   1458: aload 16
    //   1460: aload 18
    //   1462: iconst_0
    //   1463: iload 6
    //   1465: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   1468: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   1471: putfield 394	com/tencent/mm/plugin/groupsolitaire/c/a:header	Ljava/lang/String;
    //   1474: aload 16
    //   1476: astore 15
    //   1478: aload 16
    //   1480: getfield 394	com/tencent/mm/plugin/groupsolitaire/c/a:header	Ljava/lang/String;
    //   1483: invokestatic 397	com/tencent/mm/plugin/groupsolitaire/b/b:aHO	(Ljava/lang/String;)Z
    //   1486: ifeq +343 -> 1829
    //   1489: aload 16
    //   1491: astore 15
    //   1493: new 381	android/util/Pair
    //   1496: dup
    //   1497: iconst_0
    //   1498: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1501: aconst_null
    //   1502: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1505: astore_1
    //   1506: invokestatic 493	com/tencent/mm/model/cn:bDv	()J
    //   1509: lload 13
    //   1511: lsub
    //   1512: lstore 13
    //   1514: lload 13
    //   1516: ldc2_w 528
    //   1519: lcmp
    //   1520: ifgt +190 -> 1710
    //   1523: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1526: ldc2_w 536
    //   1529: lconst_0
    //   1530: lconst_1
    //   1531: iconst_0
    //   1532: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1535: ldc 150
    //   1537: ldc_w 543
    //   1540: iconst_3
    //   1541: anewarray 4	java/lang/Object
    //   1544: dup
    //   1545: iconst_0
    //   1546: lload 13
    //   1548: invokestatic 546	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1551: aastore
    //   1552: dup
    //   1553: iconst_1
    //   1554: aload 16
    //   1556: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   1559: invokevirtual 232	java/util/HashMap:size	()I
    //   1562: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1565: aastore
    //   1566: dup
    //   1567: iconst_2
    //   1568: getstatic 412	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1571: aastore
    //   1572: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1575: ldc_w 474
    //   1578: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1581: aload_1
    //   1582: areturn
    //   1583: iload 7
    //   1585: iconst_1
    //   1586: isub
    //   1587: istore 7
    //   1589: iload 5
    //   1591: iconst_1
    //   1592: isub
    //   1593: istore 5
    //   1595: goto -302 -> 1293
    //   1598: aload 16
    //   1600: astore 15
    //   1602: aload 16
    //   1604: aload 18
    //   1606: iconst_0
    //   1607: iload_3
    //   1608: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   1611: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   1614: putfield 394	com/tencent/mm/plugin/groupsolitaire/c/a:header	Ljava/lang/String;
    //   1617: goto -143 -> 1474
    //   1620: astore_2
    //   1621: invokestatic 493	com/tencent/mm/model/cn:bDv	()J
    //   1624: lload 13
    //   1626: lsub
    //   1627: lstore 13
    //   1629: lload 13
    //   1631: ldc2_w 528
    //   1634: lcmp
    //   1635: ifgt +2262 -> 3897
    //   1638: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1641: ldc2_w 536
    //   1644: lconst_0
    //   1645: lconst_1
    //   1646: iconst_0
    //   1647: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1650: aload 15
    //   1652: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   1655: invokevirtual 232	java/util/HashMap:size	()I
    //   1658: istore_3
    //   1659: aload 15
    //   1661: ifnull +2355 -> 4016
    //   1664: iconst_1
    //   1665: istore 11
    //   1667: ldc 150
    //   1669: ldc_w 543
    //   1672: iconst_3
    //   1673: anewarray 4	java/lang/Object
    //   1676: dup
    //   1677: iconst_0
    //   1678: lload 13
    //   1680: invokestatic 546	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1683: aastore
    //   1684: dup
    //   1685: iconst_1
    //   1686: iload_3
    //   1687: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1690: aastore
    //   1691: dup
    //   1692: iconst_2
    //   1693: iload 11
    //   1695: invokestatic 507	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1698: aastore
    //   1699: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1702: ldc_w 474
    //   1705: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1708: aload_2
    //   1709: athrow
    //   1710: lload 13
    //   1712: ldc2_w 555
    //   1715: lcmp
    //   1716: ifgt +18 -> 1734
    //   1719: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1722: ldc2_w 536
    //   1725: lconst_1
    //   1726: lconst_1
    //   1727: iconst_0
    //   1728: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1731: goto -196 -> 1535
    //   1734: lload 13
    //   1736: ldc2_w 557
    //   1739: lcmp
    //   1740: ifgt +20 -> 1760
    //   1743: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1746: ldc2_w 536
    //   1749: ldc2_w 559
    //   1752: lconst_1
    //   1753: iconst_0
    //   1754: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1757: goto -222 -> 1535
    //   1760: lload 13
    //   1762: ldc2_w 561
    //   1765: lcmp
    //   1766: ifgt +20 -> 1786
    //   1769: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1772: ldc2_w 536
    //   1775: ldc2_w 563
    //   1778: lconst_1
    //   1779: iconst_0
    //   1780: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1783: goto -248 -> 1535
    //   1786: lload 13
    //   1788: ldc2_w 565
    //   1791: lcmp
    //   1792: ifgt +20 -> 1812
    //   1795: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1798: ldc2_w 536
    //   1801: ldc2_w 567
    //   1804: lconst_1
    //   1805: iconst_0
    //   1806: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1809: goto -274 -> 1535
    //   1812: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1815: ldc2_w 536
    //   1818: ldc2_w 569
    //   1821: lconst_1
    //   1822: iconst_0
    //   1823: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1826: goto -291 -> 1535
    //   1829: iload_3
    //   1830: iflt +29 -> 1859
    //   1833: iload_3
    //   1834: iload 6
    //   1836: if_icmpgt +23 -> 1859
    //   1839: aload 16
    //   1841: astore 15
    //   1843: aload 16
    //   1845: aload 18
    //   1847: iload_3
    //   1848: iload 6
    //   1850: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   1853: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   1856: putfield 400	com/tencent/mm/plugin/groupsolitaire/c/a:Jjl	Ljava/lang/String;
    //   1859: aload 16
    //   1861: astore 15
    //   1863: iload 7
    //   1865: aload 19
    //   1867: iload 8
    //   1869: aaload
    //   1870: invokevirtual 304	java/lang/String:length	()I
    //   1873: iadd
    //   1874: istore_3
    //   1875: iload_3
    //   1876: ifle +34 -> 1910
    //   1879: aload 16
    //   1881: astore 15
    //   1883: iload_3
    //   1884: aload 18
    //   1886: invokevirtual 304	java/lang/String:length	()I
    //   1889: if_icmpge +21 -> 1910
    //   1892: aload 16
    //   1894: astore 15
    //   1896: aload 16
    //   1898: aload 18
    //   1900: iload_3
    //   1901: invokevirtual 251	java/lang/String:substring	(I)Ljava/lang/String;
    //   1904: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   1907: putfield 403	com/tencent/mm/plugin/groupsolitaire/c/a:IvM	Ljava/lang/String;
    //   1910: aload 16
    //   1912: astore 15
    //   1914: aload 16
    //   1916: getfield 403	com/tencent/mm/plugin/groupsolitaire/c/a:IvM	Ljava/lang/String;
    //   1919: invokestatic 406	com/tencent/mm/plugin/groupsolitaire/b/b:aHP	(Ljava/lang/String;)Z
    //   1922: ifeq +216 -> 2138
    //   1925: aload 16
    //   1927: astore 15
    //   1929: new 381	android/util/Pair
    //   1932: dup
    //   1933: iconst_0
    //   1934: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1937: aconst_null
    //   1938: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1941: astore_1
    //   1942: invokestatic 493	com/tencent/mm/model/cn:bDv	()J
    //   1945: lload 13
    //   1947: lsub
    //   1948: lstore 13
    //   1950: lload 13
    //   1952: ldc2_w 528
    //   1955: lcmp
    //   1956: ifgt +63 -> 2019
    //   1959: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1962: ldc2_w 536
    //   1965: lconst_0
    //   1966: lconst_1
    //   1967: iconst_0
    //   1968: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1971: ldc 150
    //   1973: ldc_w 543
    //   1976: iconst_3
    //   1977: anewarray 4	java/lang/Object
    //   1980: dup
    //   1981: iconst_0
    //   1982: lload 13
    //   1984: invokestatic 546	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1987: aastore
    //   1988: dup
    //   1989: iconst_1
    //   1990: aload 16
    //   1992: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   1995: invokevirtual 232	java/util/HashMap:size	()I
    //   1998: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2001: aastore
    //   2002: dup
    //   2003: iconst_2
    //   2004: getstatic 412	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2007: aastore
    //   2008: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2011: ldc_w 474
    //   2014: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2017: aload_1
    //   2018: areturn
    //   2019: lload 13
    //   2021: ldc2_w 555
    //   2024: lcmp
    //   2025: ifgt +18 -> 2043
    //   2028: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2031: ldc2_w 536
    //   2034: lconst_1
    //   2035: lconst_1
    //   2036: iconst_0
    //   2037: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2040: goto -69 -> 1971
    //   2043: lload 13
    //   2045: ldc2_w 557
    //   2048: lcmp
    //   2049: ifgt +20 -> 2069
    //   2052: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2055: ldc2_w 536
    //   2058: ldc2_w 559
    //   2061: lconst_1
    //   2062: iconst_0
    //   2063: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2066: goto -95 -> 1971
    //   2069: lload 13
    //   2071: ldc2_w 561
    //   2074: lcmp
    //   2075: ifgt +20 -> 2095
    //   2078: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2081: ldc2_w 536
    //   2084: ldc2_w 563
    //   2087: lconst_1
    //   2088: iconst_0
    //   2089: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2092: goto -121 -> 1971
    //   2095: lload 13
    //   2097: ldc2_w 565
    //   2100: lcmp
    //   2101: ifgt +20 -> 2121
    //   2104: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2107: ldc2_w 536
    //   2110: ldc2_w 567
    //   2113: lconst_1
    //   2114: iconst_0
    //   2115: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2118: goto -147 -> 1971
    //   2121: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2124: ldc2_w 536
    //   2127: ldc2_w 569
    //   2130: lconst_1
    //   2131: iconst_0
    //   2132: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2135: goto -164 -> 1971
    //   2138: aload 16
    //   2140: astore 15
    //   2142: aload 16
    //   2144: invokestatic 577	com/tencent/mm/plugin/groupsolitaire/b/b:a	(Lcom/tencent/mm/plugin/groupsolitaire/c/a;)Ljava/lang/String;
    //   2147: astore 21
    //   2149: aload 16
    //   2151: astore 15
    //   2153: ldc 100
    //   2155: invokestatic 429	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   2158: checkcast 100	com/tencent/mm/plugin/groupsolitaire/PluginGroupSolitaire
    //   2161: invokevirtual 433	com/tencent/mm/plugin/groupsolitaire/PluginGroupSolitaire:getGroupSolitatireStorage	()Lcom/tencent/mm/plugin/groupsolitaire/c/c;
    //   2164: aload_2
    //   2165: aload 21
    //   2167: invokevirtual 581	com/tencent/mm/plugin/groupsolitaire/c/c:ju	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/groupsolitaire/c/a;
    //   2170: astore_1
    //   2171: aload 16
    //   2173: astore 15
    //   2175: aload 16
    //   2177: invokevirtual 584	com/tencent/mm/plugin/groupsolitaire/c/a:fJu	()V
    //   2180: iconst_0
    //   2181: istore 9
    //   2183: aload 16
    //   2185: astore 15
    //   2187: new 176	java/util/ArrayList
    //   2190: dup
    //   2191: invokespecial 177	java/util/ArrayList:<init>	()V
    //   2194: astore 20
    //   2196: aload 16
    //   2198: astore 15
    //   2200: aload 18
    //   2202: aload 19
    //   2204: iload 4
    //   2206: aaload
    //   2207: invokevirtual 216	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2210: istore 5
    //   2212: iload 4
    //   2214: istore 6
    //   2216: iload 6
    //   2218: iload 8
    //   2220: if_icmpgt +716 -> 2936
    //   2223: aload 16
    //   2225: astore 15
    //   2227: aload 19
    //   2229: iload 6
    //   2231: aaload
    //   2232: invokevirtual 304	java/lang/String:length	()I
    //   2235: iload 5
    //   2237: iadd
    //   2238: iconst_1
    //   2239: iadd
    //   2240: istore 7
    //   2242: iload 6
    //   2244: iconst_1
    //   2245: iadd
    //   2246: istore 4
    //   2248: iload 4
    //   2250: iload 8
    //   2252: if_icmpgt +60 -> 2312
    //   2255: aload 19
    //   2257: iload 4
    //   2259: aaload
    //   2260: astore 17
    //   2262: aload 16
    //   2264: astore 15
    //   2266: aload_0
    //   2267: getfield 83	com/tencent/mm/plugin/groupsolitaire/b/c:numPattern	Ljava/util/regex/Pattern;
    //   2270: aload 17
    //   2272: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   2275: invokevirtual 187	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   2278: invokevirtual 193	java/util/regex/Matcher:find	()Z
    //   2281: ifne +31 -> 2312
    //   2284: aload 16
    //   2286: astore 15
    //   2288: iload 7
    //   2290: aload 19
    //   2292: iload 4
    //   2294: aaload
    //   2295: invokevirtual 304	java/lang/String:length	()I
    //   2298: iadd
    //   2299: iconst_1
    //   2300: iadd
    //   2301: istore 7
    //   2303: iload 4
    //   2305: iconst_1
    //   2306: iadd
    //   2307: istore 4
    //   2309: goto -61 -> 2248
    //   2312: iload 4
    //   2314: iload 8
    //   2316: if_icmple +157 -> 2473
    //   2319: aload 16
    //   2321: astore 15
    //   2323: iload_3
    //   2324: istore 7
    //   2326: iload_3
    //   2327: aload 18
    //   2329: invokevirtual 304	java/lang/String:length	()I
    //   2332: if_icmple +14 -> 2346
    //   2335: aload 16
    //   2337: astore 15
    //   2339: aload 18
    //   2341: invokevirtual 304	java/lang/String:length	()I
    //   2344: istore 7
    //   2346: aload 16
    //   2348: astore 15
    //   2350: aload 18
    //   2352: aload 18
    //   2354: aload 19
    //   2356: iload 6
    //   2358: aaload
    //   2359: iload 5
    //   2361: invokevirtual 379	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   2364: iload 7
    //   2366: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   2369: astore 17
    //   2371: iload 7
    //   2373: istore_3
    //   2374: aload 16
    //   2376: astore 15
    //   2378: iload 5
    //   2380: aload 17
    //   2382: invokevirtual 304	java/lang/String:length	()I
    //   2385: iadd
    //   2386: istore 7
    //   2388: aload 16
    //   2390: astore 15
    //   2392: aload 16
    //   2394: invokestatic 577	com/tencent/mm/plugin/groupsolitaire/b/b:a	(Lcom/tencent/mm/plugin/groupsolitaire/c/a;)Ljava/lang/String;
    //   2397: astore 22
    //   2399: aload 16
    //   2401: astore 15
    //   2403: aload 21
    //   2405: aload 22
    //   2407: invokestatic 298	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2410: ifne +25 -> 2435
    //   2413: aload 16
    //   2415: astore 15
    //   2417: ldc 100
    //   2419: invokestatic 429	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   2422: checkcast 100	com/tencent/mm/plugin/groupsolitaire/PluginGroupSolitaire
    //   2425: invokevirtual 433	com/tencent/mm/plugin/groupsolitaire/PluginGroupSolitaire:getGroupSolitatireStorage	()Lcom/tencent/mm/plugin/groupsolitaire/c/c;
    //   2428: aload_2
    //   2429: aload 22
    //   2431: invokevirtual 581	com/tencent/mm/plugin/groupsolitaire/c/c:ju	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/groupsolitaire/c/a;
    //   2434: astore_1
    //   2435: aload 16
    //   2437: astore 15
    //   2439: aload 16
    //   2441: invokevirtual 584	com/tencent/mm/plugin/groupsolitaire/c/a:fJu	()V
    //   2444: aload 16
    //   2446: astore 15
    //   2448: aload_0
    //   2449: aload_1
    //   2450: aload 17
    //   2452: invokespecial 586	com/tencent/mm/plugin/groupsolitaire/b/c:a	(Lcom/tencent/mm/plugin/groupsolitaire/c/a;Ljava/lang/String;)Ljava/util/List;
    //   2455: astore 17
    //   2457: aload 17
    //   2459: ifnonnull +1613 -> 4072
    //   2462: iload 7
    //   2464: istore 5
    //   2466: iload 4
    //   2468: istore 6
    //   2470: goto -254 -> 2216
    //   2473: aload 16
    //   2475: astore 15
    //   2477: iload 7
    //   2479: istore 10
    //   2481: iload 7
    //   2483: aload 18
    //   2485: invokevirtual 304	java/lang/String:length	()I
    //   2488: if_icmplt +7 -> 2495
    //   2491: iload 5
    //   2493: istore 10
    //   2495: aload 16
    //   2497: astore 15
    //   2499: aload 18
    //   2501: aload 18
    //   2503: aload 19
    //   2505: iload 6
    //   2507: aaload
    //   2508: iload 5
    //   2510: invokevirtual 379	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   2513: aload 18
    //   2515: aload 19
    //   2517: iload 4
    //   2519: aaload
    //   2520: iload 10
    //   2522: invokevirtual 379	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   2525: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   2528: astore 17
    //   2530: goto -156 -> 2374
    //   2533: aload 16
    //   2535: astore 15
    //   2537: iload 6
    //   2539: aload 17
    //   2541: invokeinterface 255 1 0
    //   2546: if_icmpge +1545 -> 4091
    //   2549: aload 16
    //   2551: astore 15
    //   2553: aload 17
    //   2555: iload 6
    //   2557: invokeinterface 443 2 0
    //   2562: checkcast 179	com/tencent/mm/plugin/groupsolitaire/c/b
    //   2565: astore 22
    //   2567: aload 16
    //   2569: astore 15
    //   2571: aload 22
    //   2573: getfield 212	com/tencent/mm/plugin/groupsolitaire/c/b:content	Ljava/lang/String;
    //   2576: invokestatic 589	com/tencent/mm/plugin/groupsolitaire/b/b:aHN	(Ljava/lang/String;)Z
    //   2579: ifeq +216 -> 2795
    //   2582: aload 16
    //   2584: astore 15
    //   2586: new 381	android/util/Pair
    //   2589: dup
    //   2590: iconst_0
    //   2591: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2594: aconst_null
    //   2595: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   2598: astore_1
    //   2599: invokestatic 493	com/tencent/mm/model/cn:bDv	()J
    //   2602: lload 13
    //   2604: lsub
    //   2605: lstore 13
    //   2607: lload 13
    //   2609: ldc2_w 528
    //   2612: lcmp
    //   2613: ifgt +63 -> 2676
    //   2616: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2619: ldc2_w 536
    //   2622: lconst_0
    //   2623: lconst_1
    //   2624: iconst_0
    //   2625: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2628: ldc 150
    //   2630: ldc_w 543
    //   2633: iconst_3
    //   2634: anewarray 4	java/lang/Object
    //   2637: dup
    //   2638: iconst_0
    //   2639: lload 13
    //   2641: invokestatic 546	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2644: aastore
    //   2645: dup
    //   2646: iconst_1
    //   2647: aload 16
    //   2649: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   2652: invokevirtual 232	java/util/HashMap:size	()I
    //   2655: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2658: aastore
    //   2659: dup
    //   2660: iconst_2
    //   2661: getstatic 412	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2664: aastore
    //   2665: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2668: ldc_w 474
    //   2671: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2674: aload_1
    //   2675: areturn
    //   2676: lload 13
    //   2678: ldc2_w 555
    //   2681: lcmp
    //   2682: ifgt +18 -> 2700
    //   2685: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2688: ldc2_w 536
    //   2691: lconst_1
    //   2692: lconst_1
    //   2693: iconst_0
    //   2694: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2697: goto -69 -> 2628
    //   2700: lload 13
    //   2702: ldc2_w 557
    //   2705: lcmp
    //   2706: ifgt +20 -> 2726
    //   2709: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2712: ldc2_w 536
    //   2715: ldc2_w 559
    //   2718: lconst_1
    //   2719: iconst_0
    //   2720: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2723: goto -95 -> 2628
    //   2726: lload 13
    //   2728: ldc2_w 561
    //   2731: lcmp
    //   2732: ifgt +20 -> 2752
    //   2735: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2738: ldc2_w 536
    //   2741: ldc2_w 563
    //   2744: lconst_1
    //   2745: iconst_0
    //   2746: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2749: goto -121 -> 2628
    //   2752: lload 13
    //   2754: ldc2_w 565
    //   2757: lcmp
    //   2758: ifgt +20 -> 2778
    //   2761: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2764: ldc2_w 536
    //   2767: ldc2_w 567
    //   2770: lconst_1
    //   2771: iconst_0
    //   2772: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2775: goto -147 -> 2628
    //   2778: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2781: ldc2_w 536
    //   2784: ldc2_w 569
    //   2787: lconst_1
    //   2788: iconst_0
    //   2789: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2792: goto -164 -> 2628
    //   2795: aload 16
    //   2797: astore 15
    //   2799: aload 16
    //   2801: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   2804: invokevirtual 232	java/util/HashMap:size	()I
    //   2807: ifne +17 -> 2824
    //   2810: aload 16
    //   2812: astore 15
    //   2814: aload 16
    //   2816: aload 22
    //   2818: getfield 209	com/tencent/mm/plugin/groupsolitaire/c/b:dIC	Ljava/lang/String;
    //   2821: putfield 520	com/tencent/mm/plugin/groupsolitaire/c/a:dIC	Ljava/lang/String;
    //   2824: iload 6
    //   2826: ifne +18 -> 2844
    //   2829: aload 16
    //   2831: astore 15
    //   2833: aload 22
    //   2835: getfield 212	com/tencent/mm/plugin/groupsolitaire/c/b:content	Ljava/lang/String;
    //   2838: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   2841: ifne +21 -> 2862
    //   2844: aload 16
    //   2846: astore 15
    //   2848: aload 22
    //   2850: getfield 212	com/tencent/mm/plugin/groupsolitaire/c/b:content	Ljava/lang/String;
    //   2853: invokevirtual 183	java/lang/String:trim	()Ljava/lang/String;
    //   2856: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   2859: ifeq +40 -> 2899
    //   2862: aload 16
    //   2864: astore 15
    //   2866: aload 16
    //   2868: aload 16
    //   2870: getfield 409	com/tencent/mm/plugin/groupsolitaire/c/a:Jjq	I
    //   2873: iconst_1
    //   2874: iadd
    //   2875: putfield 409	com/tencent/mm/plugin/groupsolitaire/c/a:Jjq	I
    //   2878: aload 16
    //   2880: astore 15
    //   2882: aload 20
    //   2884: aload 22
    //   2886: getfield 201	com/tencent/mm/plugin/groupsolitaire/c/b:Jjs	I
    //   2889: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2892: invokevirtual 590	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2895: pop
    //   2896: goto +1186 -> 4082
    //   2899: aload 16
    //   2901: astore 15
    //   2903: aload 16
    //   2905: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   2908: astore 23
    //   2910: iload 5
    //   2912: iconst_1
    //   2913: iadd
    //   2914: istore 5
    //   2916: aload 16
    //   2918: astore 15
    //   2920: aload 23
    //   2922: iload 5
    //   2924: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2927: aload 22
    //   2929: invokevirtual 591	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2932: pop
    //   2933: goto +1149 -> 4082
    //   2936: aload 16
    //   2938: astore 15
    //   2940: aload 16
    //   2942: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   2945: invokevirtual 232	java/util/HashMap:size	()I
    //   2948: aload 20
    //   2950: invokevirtual 592	java/util/ArrayList:size	()I
    //   2953: iadd
    //   2954: iconst_4
    //   2955: if_icmplt +623 -> 3578
    //   2958: aload 16
    //   2960: astore 15
    //   2962: new 594	java/util/HashSet
    //   2965: dup
    //   2966: invokespecial 595	java/util/HashSet:<init>	()V
    //   2969: astore_1
    //   2970: iconst_0
    //   2971: istore_3
    //   2972: iconst_1
    //   2973: istore 4
    //   2975: aload 16
    //   2977: astore 15
    //   2979: iload 4
    //   2981: aload 16
    //   2983: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   2986: invokevirtual 232	java/util/HashMap:size	()I
    //   2989: if_icmpgt +1126 -> 4115
    //   2992: aload 16
    //   2994: astore 15
    //   2996: aload 16
    //   2998: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   3001: iload 4
    //   3003: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3006: invokevirtual 242	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3009: checkcast 179	com/tencent/mm/plugin/groupsolitaire/c/b
    //   3012: astore_2
    //   3013: aload 16
    //   3015: astore 15
    //   3017: aload_1
    //   3018: aload_2
    //   3019: getfield 201	com/tencent/mm/plugin/groupsolitaire/c/b:Jjs	I
    //   3022: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3025: invokeinterface 598 2 0
    //   3030: ifeq +230 -> 3260
    //   3033: iload_3
    //   3034: iconst_1
    //   3035: iadd
    //   3036: istore 5
    //   3038: iload 5
    //   3040: istore_3
    //   3041: iload 5
    //   3043: iconst_2
    //   3044: if_icmplt +1062 -> 4106
    //   3047: aload 16
    //   3049: astore 15
    //   3051: new 381	android/util/Pair
    //   3054: dup
    //   3055: iconst_0
    //   3056: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3059: aconst_null
    //   3060: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   3063: astore_1
    //   3064: invokestatic 493	com/tencent/mm/model/cn:bDv	()J
    //   3067: lload 13
    //   3069: lsub
    //   3070: lstore 13
    //   3072: lload 13
    //   3074: ldc2_w 528
    //   3077: lcmp
    //   3078: ifgt +63 -> 3141
    //   3081: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3084: ldc2_w 536
    //   3087: lconst_0
    //   3088: lconst_1
    //   3089: iconst_0
    //   3090: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3093: ldc 150
    //   3095: ldc_w 543
    //   3098: iconst_3
    //   3099: anewarray 4	java/lang/Object
    //   3102: dup
    //   3103: iconst_0
    //   3104: lload 13
    //   3106: invokestatic 546	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3109: aastore
    //   3110: dup
    //   3111: iconst_1
    //   3112: aload 16
    //   3114: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   3117: invokevirtual 232	java/util/HashMap:size	()I
    //   3120: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3123: aastore
    //   3124: dup
    //   3125: iconst_2
    //   3126: getstatic 412	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   3129: aastore
    //   3130: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3133: ldc_w 474
    //   3136: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3139: aload_1
    //   3140: areturn
    //   3141: lload 13
    //   3143: ldc2_w 555
    //   3146: lcmp
    //   3147: ifgt +18 -> 3165
    //   3150: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3153: ldc2_w 536
    //   3156: lconst_1
    //   3157: lconst_1
    //   3158: iconst_0
    //   3159: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3162: goto -69 -> 3093
    //   3165: lload 13
    //   3167: ldc2_w 557
    //   3170: lcmp
    //   3171: ifgt +20 -> 3191
    //   3174: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3177: ldc2_w 536
    //   3180: ldc2_w 559
    //   3183: lconst_1
    //   3184: iconst_0
    //   3185: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3188: goto -95 -> 3093
    //   3191: lload 13
    //   3193: ldc2_w 561
    //   3196: lcmp
    //   3197: ifgt +20 -> 3217
    //   3200: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3203: ldc2_w 536
    //   3206: ldc2_w 563
    //   3209: lconst_1
    //   3210: iconst_0
    //   3211: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3214: goto -121 -> 3093
    //   3217: lload 13
    //   3219: ldc2_w 565
    //   3222: lcmp
    //   3223: ifgt +20 -> 3243
    //   3226: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3229: ldc2_w 536
    //   3232: ldc2_w 567
    //   3235: lconst_1
    //   3236: iconst_0
    //   3237: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3240: goto -147 -> 3093
    //   3243: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3246: ldc2_w 536
    //   3249: ldc2_w 569
    //   3252: lconst_1
    //   3253: iconst_0
    //   3254: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3257: goto -164 -> 3093
    //   3260: aload 16
    //   3262: astore 15
    //   3264: aload_1
    //   3265: aload_2
    //   3266: getfield 201	com/tencent/mm/plugin/groupsolitaire/c/b:Jjs	I
    //   3269: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3272: invokeinterface 599 2 0
    //   3277: pop
    //   3278: goto +828 -> 4106
    //   3281: aload 16
    //   3283: astore 15
    //   3285: iload 4
    //   3287: aload 20
    //   3289: invokevirtual 592	java/util/ArrayList:size	()I
    //   3292: if_icmpge +286 -> 3578
    //   3295: aload 16
    //   3297: astore 15
    //   3299: aload 20
    //   3301: iload 4
    //   3303: invokevirtual 600	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3306: checkcast 234	java/lang/Integer
    //   3309: invokevirtual 603	java/lang/Integer:intValue	()I
    //   3312: istore 5
    //   3314: aload 16
    //   3316: astore 15
    //   3318: aload_1
    //   3319: iload 5
    //   3321: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3324: invokeinterface 598 2 0
    //   3329: ifeq +230 -> 3559
    //   3332: iload_3
    //   3333: iconst_1
    //   3334: iadd
    //   3335: istore 5
    //   3337: iload 5
    //   3339: istore_3
    //   3340: iload 5
    //   3342: iconst_2
    //   3343: if_icmplt +778 -> 4121
    //   3346: aload 16
    //   3348: astore 15
    //   3350: new 381	android/util/Pair
    //   3353: dup
    //   3354: iconst_0
    //   3355: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3358: aconst_null
    //   3359: invokespecial 390	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   3362: astore_1
    //   3363: invokestatic 493	com/tencent/mm/model/cn:bDv	()J
    //   3366: lload 13
    //   3368: lsub
    //   3369: lstore 13
    //   3371: lload 13
    //   3373: ldc2_w 528
    //   3376: lcmp
    //   3377: ifgt +63 -> 3440
    //   3380: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3383: ldc2_w 536
    //   3386: lconst_0
    //   3387: lconst_1
    //   3388: iconst_0
    //   3389: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3392: ldc 150
    //   3394: ldc_w 543
    //   3397: iconst_3
    //   3398: anewarray 4	java/lang/Object
    //   3401: dup
    //   3402: iconst_0
    //   3403: lload 13
    //   3405: invokestatic 546	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3408: aastore
    //   3409: dup
    //   3410: iconst_1
    //   3411: aload 16
    //   3413: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   3416: invokevirtual 232	java/util/HashMap:size	()I
    //   3419: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3422: aastore
    //   3423: dup
    //   3424: iconst_2
    //   3425: getstatic 412	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   3428: aastore
    //   3429: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3432: ldc_w 474
    //   3435: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3438: aload_1
    //   3439: areturn
    //   3440: lload 13
    //   3442: ldc2_w 555
    //   3445: lcmp
    //   3446: ifgt +18 -> 3464
    //   3449: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3452: ldc2_w 536
    //   3455: lconst_1
    //   3456: lconst_1
    //   3457: iconst_0
    //   3458: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3461: goto -69 -> 3392
    //   3464: lload 13
    //   3466: ldc2_w 557
    //   3469: lcmp
    //   3470: ifgt +20 -> 3490
    //   3473: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3476: ldc2_w 536
    //   3479: ldc2_w 559
    //   3482: lconst_1
    //   3483: iconst_0
    //   3484: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3487: goto -95 -> 3392
    //   3490: lload 13
    //   3492: ldc2_w 561
    //   3495: lcmp
    //   3496: ifgt +20 -> 3516
    //   3499: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3502: ldc2_w 536
    //   3505: ldc2_w 563
    //   3508: lconst_1
    //   3509: iconst_0
    //   3510: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3513: goto -121 -> 3392
    //   3516: lload 13
    //   3518: ldc2_w 565
    //   3521: lcmp
    //   3522: ifgt +20 -> 3542
    //   3525: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3528: ldc2_w 536
    //   3531: ldc2_w 567
    //   3534: lconst_1
    //   3535: iconst_0
    //   3536: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3539: goto -147 -> 3392
    //   3542: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3545: ldc2_w 536
    //   3548: ldc2_w 569
    //   3551: lconst_1
    //   3552: iconst_0
    //   3553: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3556: goto -164 -> 3392
    //   3559: aload 16
    //   3561: astore 15
    //   3563: aload_1
    //   3564: iload 5
    //   3566: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3569: invokeinterface 599 2 0
    //   3574: pop
    //   3575: goto +546 -> 4121
    //   3578: aload 16
    //   3580: astore_1
    //   3581: aload 16
    //   3583: astore 15
    //   3585: aload 16
    //   3587: getfield 520	com/tencent/mm/plugin/groupsolitaire/c/a:dIC	Ljava/lang/String;
    //   3590: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3593: ifeq -3094 -> 499
    //   3596: aload 16
    //   3598: astore_1
    //   3599: aload 16
    //   3601: astore 15
    //   3603: aload 16
    //   3605: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   3608: invokevirtual 232	java/util/HashMap:size	()I
    //   3611: ifle -3112 -> 499
    //   3614: aload 16
    //   3616: astore 15
    //   3618: aload 16
    //   3620: aload 16
    //   3622: getfield 226	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   3625: iconst_1
    //   3626: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3629: invokevirtual 242	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3632: checkcast 179	com/tencent/mm/plugin/groupsolitaire/c/b
    //   3635: getfield 209	com/tencent/mm/plugin/groupsolitaire/c/b:dIC	Ljava/lang/String;
    //   3638: putfield 520	com/tencent/mm/plugin/groupsolitaire/c/a:dIC	Ljava/lang/String;
    //   3641: aload 16
    //   3643: astore_1
    //   3644: goto -3145 -> 499
    //   3647: lload 13
    //   3649: ldc2_w 555
    //   3652: lcmp
    //   3653: ifgt +18 -> 3671
    //   3656: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3659: ldc2_w 536
    //   3662: lconst_1
    //   3663: lconst_1
    //   3664: iconst_0
    //   3665: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3668: goto -3052 -> 616
    //   3671: lload 13
    //   3673: ldc2_w 557
    //   3676: lcmp
    //   3677: ifgt +20 -> 3697
    //   3680: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3683: ldc2_w 536
    //   3686: ldc2_w 559
    //   3689: lconst_1
    //   3690: iconst_0
    //   3691: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3694: goto -3078 -> 616
    //   3697: lload 13
    //   3699: ldc2_w 561
    //   3702: lcmp
    //   3703: ifgt +20 -> 3723
    //   3706: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3709: ldc2_w 536
    //   3712: ldc2_w 563
    //   3715: lconst_1
    //   3716: iconst_0
    //   3717: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3720: goto -3104 -> 616
    //   3723: lload 13
    //   3725: ldc2_w 565
    //   3728: lcmp
    //   3729: ifgt +20 -> 3749
    //   3732: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3735: ldc2_w 536
    //   3738: ldc2_w 567
    //   3741: lconst_1
    //   3742: iconst_0
    //   3743: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3746: goto -3130 -> 616
    //   3749: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3752: ldc2_w 536
    //   3755: ldc2_w 569
    //   3758: lconst_1
    //   3759: iconst_0
    //   3760: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3763: goto -3147 -> 616
    //   3766: iconst_0
    //   3767: istore 11
    //   3769: goto -3138 -> 631
    //   3772: lload 13
    //   3774: ldc2_w 555
    //   3777: lcmp
    //   3778: ifgt +18 -> 3796
    //   3781: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3784: ldc2_w 536
    //   3787: lconst_1
    //   3788: lconst_1
    //   3789: iconst_0
    //   3790: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3793: goto -2955 -> 838
    //   3796: lload 13
    //   3798: ldc2_w 557
    //   3801: lcmp
    //   3802: ifgt +20 -> 3822
    //   3805: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3808: ldc2_w 536
    //   3811: ldc2_w 559
    //   3814: lconst_1
    //   3815: iconst_0
    //   3816: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3819: goto -2981 -> 838
    //   3822: lload 13
    //   3824: ldc2_w 561
    //   3827: lcmp
    //   3828: ifgt +20 -> 3848
    //   3831: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3834: ldc2_w 536
    //   3837: ldc2_w 563
    //   3840: lconst_1
    //   3841: iconst_0
    //   3842: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3845: goto -3007 -> 838
    //   3848: lload 13
    //   3850: ldc2_w 565
    //   3853: lcmp
    //   3854: ifgt +20 -> 3874
    //   3857: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3860: ldc2_w 536
    //   3863: ldc2_w 567
    //   3866: lconst_1
    //   3867: iconst_0
    //   3868: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3871: goto -3033 -> 838
    //   3874: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3877: ldc2_w 536
    //   3880: ldc2_w 569
    //   3883: lconst_1
    //   3884: iconst_0
    //   3885: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3888: goto -3050 -> 838
    //   3891: iconst_0
    //   3892: istore 11
    //   3894: goto -3041 -> 853
    //   3897: lload 13
    //   3899: ldc2_w 555
    //   3902: lcmp
    //   3903: ifgt +18 -> 3921
    //   3906: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3909: ldc2_w 536
    //   3912: lconst_1
    //   3913: lconst_1
    //   3914: iconst_0
    //   3915: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3918: goto -2268 -> 1650
    //   3921: lload 13
    //   3923: ldc2_w 557
    //   3926: lcmp
    //   3927: ifgt +20 -> 3947
    //   3930: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3933: ldc2_w 536
    //   3936: ldc2_w 559
    //   3939: lconst_1
    //   3940: iconst_0
    //   3941: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3944: goto -2294 -> 1650
    //   3947: lload 13
    //   3949: ldc2_w 561
    //   3952: lcmp
    //   3953: ifgt +20 -> 3973
    //   3956: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3959: ldc2_w 536
    //   3962: ldc2_w 563
    //   3965: lconst_1
    //   3966: iconst_0
    //   3967: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3970: goto -2320 -> 1650
    //   3973: lload 13
    //   3975: ldc2_w 565
    //   3978: lcmp
    //   3979: ifgt +20 -> 3999
    //   3982: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3985: ldc2_w 536
    //   3988: ldc2_w 567
    //   3991: lconst_1
    //   3992: iconst_0
    //   3993: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   3996: goto -2346 -> 1650
    //   3999: getstatic 535	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   4002: ldc2_w 536
    //   4005: ldc2_w 569
    //   4008: lconst_1
    //   4009: iconst_0
    //   4010: invokevirtual 541	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   4013: goto -2363 -> 1650
    //   4016: iconst_0
    //   4017: istore 11
    //   4019: goto -2352 -> 1667
    //   4022: astore_2
    //   4023: aload_1
    //   4024: astore 15
    //   4026: goto -2405 -> 1621
    //   4029: astore_2
    //   4030: goto -3263 -> 767
    //   4033: iconst_0
    //   4034: istore 5
    //   4036: iload 8
    //   4038: istore 7
    //   4040: iload 5
    //   4042: istore 8
    //   4044: goto -2618 -> 1426
    //   4047: iload 12
    //   4049: istore 11
    //   4051: goto -3034 -> 1017
    //   4054: iconst_0
    //   4055: istore 4
    //   4057: iconst_0
    //   4058: istore 5
    //   4060: goto -3608 -> 452
    //   4063: iconst_0
    //   4064: istore 4
    //   4066: iload 7
    //   4068: istore_3
    //   4069: goto -3753 -> 316
    //   4072: iconst_0
    //   4073: istore 6
    //   4075: iload 9
    //   4077: istore 5
    //   4079: goto -1546 -> 2533
    //   4082: iload 6
    //   4084: iconst_1
    //   4085: iadd
    //   4086: istore 6
    //   4088: goto -1555 -> 2533
    //   4091: iload 5
    //   4093: istore 9
    //   4095: iload 7
    //   4097: istore 5
    //   4099: iload 4
    //   4101: istore 6
    //   4103: goto -1887 -> 2216
    //   4106: iload 4
    //   4108: iconst_1
    //   4109: iadd
    //   4110: istore 4
    //   4112: goto -1137 -> 2975
    //   4115: iconst_0
    //   4116: istore 4
    //   4118: goto -837 -> 3281
    //   4121: iload 4
    //   4123: iconst_1
    //   4124: iadd
    //   4125: istore 4
    //   4127: goto -846 -> 3281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4130	0	this	c
    //   0	4130	1	paramString1	String
    //   0	4130	2	paramString2	String
    //   179	3890	3	i	int
    //   320	3806	4	j	int
    //   100	3998	5	k	int
    //   94	4008	6	m	int
    //   91	4005	7	n	int
    //   97	3946	8	i1	int
    //   2181	1913	9	i2	int
    //   2479	42	10	i3	int
    //   88	3962	11	bool1	boolean
    //   390	3658	12	bool2	boolean
    //   227	3747	13	l	long
    //   240	3785	15	localObject1	Object
    //   236	3406	16	locala	com.tencent.mm.plugin.groupsolitaire.c.a
    //   349	2205	17	localObject2	Object
    //   46	2468	18	str1	String
    //   85	2431	19	arrayOfString	String[]
    //   2194	1106	20	localArrayList	ArrayList
    //   2147	257	21	str2	String
    //   2397	531	22	localObject3	Object
    //   2908	13	23	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   242	250	763	java/lang/Exception
    //   254	260	763	java/lang/Exception
    //   264	275	763	java/lang/Exception
    //   279	291	763	java/lang/Exception
    //   295	305	763	java/lang/Exception
    //   309	313	763	java/lang/Exception
    //   320	328	763	java/lang/Exception
    //   338	351	763	java/lang/Exception
    //   355	361	763	java/lang/Exception
    //   365	381	763	java/lang/Exception
    //   385	392	763	java/lang/Exception
    //   396	402	763	java/lang/Exception
    //   406	426	763	java/lang/Exception
    //   438	448	763	java/lang/Exception
    //   461	470	763	java/lang/Exception
    //   474	487	763	java/lang/Exception
    //   491	499	763	java/lang/Exception
    //   719	731	763	java/lang/Exception
    //   735	746	763	java/lang/Exception
    //   750	760	763	java/lang/Exception
    //   909	922	763	java/lang/Exception
    //   926	933	763	java/lang/Exception
    //   937	943	763	java/lang/Exception
    //   947	971	763	java/lang/Exception
    //   984	992	763	java/lang/Exception
    //   996	1004	763	java/lang/Exception
    //   1008	1017	763	java/lang/Exception
    //   1021	1032	763	java/lang/Exception
    //   1045	1055	763	java/lang/Exception
    //   1062	1075	763	java/lang/Exception
    //   1275	1282	763	java/lang/Exception
    //   1286	1293	763	java/lang/Exception
    //   1310	1319	763	java/lang/Exception
    //   1323	1329	763	java/lang/Exception
    //   1333	1349	763	java/lang/Exception
    //   1353	1369	763	java/lang/Exception
    //   1373	1379	763	java/lang/Exception
    //   1383	1403	763	java/lang/Exception
    //   1412	1422	763	java/lang/Exception
    //   1435	1445	763	java/lang/Exception
    //   1458	1474	763	java/lang/Exception
    //   1478	1489	763	java/lang/Exception
    //   1493	1506	763	java/lang/Exception
    //   1602	1617	763	java/lang/Exception
    //   1843	1859	763	java/lang/Exception
    //   1863	1875	763	java/lang/Exception
    //   1883	1892	763	java/lang/Exception
    //   1896	1910	763	java/lang/Exception
    //   1914	1925	763	java/lang/Exception
    //   1929	1942	763	java/lang/Exception
    //   2142	2149	763	java/lang/Exception
    //   2153	2171	763	java/lang/Exception
    //   2175	2180	763	java/lang/Exception
    //   2187	2196	763	java/lang/Exception
    //   2200	2212	763	java/lang/Exception
    //   2227	2242	763	java/lang/Exception
    //   2266	2284	763	java/lang/Exception
    //   2288	2303	763	java/lang/Exception
    //   2326	2335	763	java/lang/Exception
    //   2339	2346	763	java/lang/Exception
    //   2350	2371	763	java/lang/Exception
    //   2378	2388	763	java/lang/Exception
    //   2392	2399	763	java/lang/Exception
    //   2403	2413	763	java/lang/Exception
    //   2417	2435	763	java/lang/Exception
    //   2439	2444	763	java/lang/Exception
    //   2448	2457	763	java/lang/Exception
    //   2481	2491	763	java/lang/Exception
    //   2499	2530	763	java/lang/Exception
    //   2537	2549	763	java/lang/Exception
    //   2553	2567	763	java/lang/Exception
    //   2571	2582	763	java/lang/Exception
    //   2586	2599	763	java/lang/Exception
    //   2799	2810	763	java/lang/Exception
    //   2814	2824	763	java/lang/Exception
    //   2833	2844	763	java/lang/Exception
    //   2848	2862	763	java/lang/Exception
    //   2866	2878	763	java/lang/Exception
    //   2882	2896	763	java/lang/Exception
    //   2903	2910	763	java/lang/Exception
    //   2920	2933	763	java/lang/Exception
    //   2940	2958	763	java/lang/Exception
    //   2962	2970	763	java/lang/Exception
    //   2979	2992	763	java/lang/Exception
    //   2996	3013	763	java/lang/Exception
    //   3017	3033	763	java/lang/Exception
    //   3051	3064	763	java/lang/Exception
    //   3264	3278	763	java/lang/Exception
    //   3285	3295	763	java/lang/Exception
    //   3299	3314	763	java/lang/Exception
    //   3318	3332	763	java/lang/Exception
    //   3350	3363	763	java/lang/Exception
    //   3563	3575	763	java/lang/Exception
    //   3585	3596	763	java/lang/Exception
    //   3603	3614	763	java/lang/Exception
    //   3618	3641	763	java/lang/Exception
    //   242	250	1620	finally
    //   254	260	1620	finally
    //   264	275	1620	finally
    //   279	291	1620	finally
    //   295	305	1620	finally
    //   309	313	1620	finally
    //   320	328	1620	finally
    //   338	351	1620	finally
    //   355	361	1620	finally
    //   365	381	1620	finally
    //   385	392	1620	finally
    //   396	402	1620	finally
    //   406	426	1620	finally
    //   438	448	1620	finally
    //   461	470	1620	finally
    //   474	487	1620	finally
    //   491	499	1620	finally
    //   502	512	1620	finally
    //   515	528	1620	finally
    //   531	538	1620	finally
    //   541	549	1620	finally
    //   552	568	1620	finally
    //   571	580	1620	finally
    //   583	587	1620	finally
    //   719	731	1620	finally
    //   735	746	1620	finally
    //   750	760	1620	finally
    //   909	922	1620	finally
    //   926	933	1620	finally
    //   937	943	1620	finally
    //   947	971	1620	finally
    //   984	992	1620	finally
    //   996	1004	1620	finally
    //   1008	1017	1620	finally
    //   1021	1032	1620	finally
    //   1045	1055	1620	finally
    //   1062	1075	1620	finally
    //   1275	1282	1620	finally
    //   1286	1293	1620	finally
    //   1310	1319	1620	finally
    //   1323	1329	1620	finally
    //   1333	1349	1620	finally
    //   1353	1369	1620	finally
    //   1373	1379	1620	finally
    //   1383	1403	1620	finally
    //   1412	1422	1620	finally
    //   1435	1445	1620	finally
    //   1458	1474	1620	finally
    //   1478	1489	1620	finally
    //   1493	1506	1620	finally
    //   1602	1617	1620	finally
    //   1843	1859	1620	finally
    //   1863	1875	1620	finally
    //   1883	1892	1620	finally
    //   1896	1910	1620	finally
    //   1914	1925	1620	finally
    //   1929	1942	1620	finally
    //   2142	2149	1620	finally
    //   2153	2171	1620	finally
    //   2175	2180	1620	finally
    //   2187	2196	1620	finally
    //   2200	2212	1620	finally
    //   2227	2242	1620	finally
    //   2266	2284	1620	finally
    //   2288	2303	1620	finally
    //   2326	2335	1620	finally
    //   2339	2346	1620	finally
    //   2350	2371	1620	finally
    //   2378	2388	1620	finally
    //   2392	2399	1620	finally
    //   2403	2413	1620	finally
    //   2417	2435	1620	finally
    //   2439	2444	1620	finally
    //   2448	2457	1620	finally
    //   2481	2491	1620	finally
    //   2499	2530	1620	finally
    //   2537	2549	1620	finally
    //   2553	2567	1620	finally
    //   2571	2582	1620	finally
    //   2586	2599	1620	finally
    //   2799	2810	1620	finally
    //   2814	2824	1620	finally
    //   2833	2844	1620	finally
    //   2848	2862	1620	finally
    //   2866	2878	1620	finally
    //   2882	2896	1620	finally
    //   2903	2910	1620	finally
    //   2920	2933	1620	finally
    //   2940	2958	1620	finally
    //   2962	2970	1620	finally
    //   2979	2992	1620	finally
    //   2996	3013	1620	finally
    //   3017	3033	1620	finally
    //   3051	3064	1620	finally
    //   3264	3278	1620	finally
    //   3285	3295	1620	finally
    //   3299	3314	1620	finally
    //   3318	3332	1620	finally
    //   3350	3363	1620	finally
    //   3563	3575	1620	finally
    //   3585	3596	1620	finally
    //   3603	3614	1620	finally
    //   3618	3641	1620	finally
    //   767	809	4022	finally
    //   502	512	4029	java/lang/Exception
    //   515	528	4029	java/lang/Exception
    //   531	538	4029	java/lang/Exception
    //   541	549	4029	java/lang/Exception
    //   552	568	4029	java/lang/Exception
    //   571	580	4029	java/lang/Exception
    //   583	587	4029	java/lang/Exception
  }
  
  public final com.tencent.mm.plugin.groupsolitaire.c.a jr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110373);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getGroupSolitatireFromCache() username:%s key:%s", new Object[] { paramString1, paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110373);
      return null;
    }
    com.tencent.mm.plugin.groupsolitaire.c.a locala2 = (com.tencent.mm.plugin.groupsolitaire.c.a)this.JiQ.get(paramString1 + paramString2);
    com.tencent.mm.plugin.groupsolitaire.c.a locala1;
    if (locala2 == null)
    {
      locala2 = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().A(paramString1, paramString2, true);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.JiQ.put(paramString1 + paramString2, locala2);
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
          locala = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().aHR(paramString1);
          locala1 = locala2;
        } while (locala == null);
        if ((locala2.field_active == 1) && (locala2.field_lastActiveTime < locala.JiL)) {
          break;
        }
        locala1 = locala2;
      } while (locala2.field_active != 0);
      locala1 = locala2;
    } while (locala2.field_lastActiveTime >= locala.JiN);
    js(paramString1, paramString2);
    com.tencent.threadpool.h.ahAA.bm(new c.1(this, paramString1, paramString2));
    AppMethodBeat.o(110373);
    return null;
  }
  
  public final void js(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110374);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "deleteGroupSolitatireInCache() username:%s key:%s", new Object[] { paramString1, paramString2 });
    this.JiQ.remove(paramString1 + paramString2);
    AppMethodBeat.o(110374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.c
 * JD-Core Version:    0.7.0.1
 */