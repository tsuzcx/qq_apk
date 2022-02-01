package com.tencent.mm.plugin.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.protocal.protobuf.gjd;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginBox
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, d
{
  private static List<Pattern> vzU;
  private static int[] vzV;
  private static HashMap<String, String> vzW;
  private static long vzX;
  private boolean isLoading;
  private IListener pWI;
  a vzT;
  private IListener vzY;
  private boolean vzZ;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(278710);
    vzU = new ArrayList();
    vzV = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 6, 6, 6, 6, 6, 6, 6, 6 };
    vzW = new HashMap();
    vzX = 0L;
    while (i < 16)
    {
      Pattern localPattern = Pattern.compile(new String[] { "(|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?“(.{2,36}?)”(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?【(.{2,36}?)】(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?\\[(.{2,36}?)\\](微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?\\((.{2,36}?)\\)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?（(.{2,36}?)）(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?\"(.{2,36}?)\"(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?「(.{2,36}?)」(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?'(.{2,36}?)'(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?“(.{2,36}?)”", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?\"(.{2,36}?)\"", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?【(.{2,36}?)】", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?\\[(.{2,36}?)\\]", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?\\((.{2,36}?)\\)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?（(.{2,36}?)）", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?「(.{2,36}?)」", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?'(.{2,36}?)'" }[i]);
      vzU.add(localPattern);
      i += 1;
    }
    AppMethodBeat.o(278710);
  }
  
  public PluginBox()
  {
    AppMethodBeat.i(76320);
    this.vzT = new a();
    this.pWI = new PluginBox.1(this, com.tencent.mm.app.f.hfK);
    this.vzY = new PluginBox.2(this, com.tencent.mm.app.f.hfK);
    this.vzZ = false;
    this.isLoading = false;
    AppMethodBeat.o(76320);
  }
  
  public static String getBoxFlightResPath()
  {
    AppMethodBeat.i(76326);
    String str = ah.v(new u(new u(aj.asW(2).iqp()).jKP(), "flight.txt").jKT());
    AppMethodBeat.o(76326);
    return str;
  }
  
  private String getHotWordHighPriority(String paramString)
  {
    AppMethodBeat.i(278701);
    if (!isSupportHotWordPrioritySwt())
    {
      AppMethodBeat.o(278701);
      return null;
    }
    if (vzW.containsKey(paramString))
    {
      Log.i("MicroMsg.Box.PluginBox", " getHotWordHighPriority text = %s, hit = %s.", new Object[] { paramString, vzW.get(paramString) });
      paramString = (String)vzW.get(paramString);
      AppMethodBeat.o(278701);
      return paramString;
    }
    if ((vzW.size() > 32) || (vzX > 500L))
    {
      vzW.clear();
      vzX = 0L;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    int j;
    if (i < vzU.size())
    {
      localObject = (Pattern)vzU.get(i);
      j = vzV[i];
      localObject = ((Pattern)localObject).matcher(paramString);
      if ((((Matcher)localObject).find()) && (j <= ((Matcher)localObject).groupCount()))
      {
        localObject = ((Matcher)localObject).group(j);
        if ((!Util.isNullOrNil((String)localObject)) && (!localArrayList.contains(localObject)))
        {
          j = 0;
          label203:
          if (j >= localArrayList.size()) {
            break label404;
          }
          String str = (String)localArrayList.get(j);
          if ((Util.isNullOrNil(str)) || (!str.contains((CharSequence)localObject))) {
            break label271;
          }
        }
      }
    }
    label271:
    label404:
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        localArrayList.remove(j);
        localArrayList.add(j, localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        j += 1;
        break label203;
        localArrayList.add(localObject);
      }
      Log.i("MicroMsg.Box.PluginBox", "getHotWordHighPriority time = " + (System.currentTimeMillis() - l));
      if ((localArrayList.size() > 0) && (!Util.isNullOrNil((String)localArrayList.get(0))))
      {
        l = vzX;
        vzX = ((String)localArrayList.get(0)).length() + l;
        vzW.put(paramString, (String)localArrayList.get(0));
        paramString = (String)localArrayList.get(0);
        AppMethodBeat.o(278701);
        return paramString;
      }
      AppMethodBeat.o(278701);
      return null;
    }
  }
  
  public static boolean isSupportHotWordPrioritySwt()
  {
    AppMethodBeat.i(278700);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkU, 0);
    Log.d("MicroMsg.Box.PluginBox", "isSupportHotWordPrioritySwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(278700);
      return true;
    }
    AppMethodBeat.o(278700);
    return false;
  }
  
  private void loadFlightNumberAsync()
  {
    AppMethodBeat.i(76324);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(278697);
        long l = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            int i;
            if (!PluginBox.this.isLoading)
            {
              Log.i("MicroMsg.Box.PluginBox", "start to load flight number");
              PluginBox.access$202(PluginBox.this, true);
              if (!y.ZC(PluginBox.getBoxFlightResPath()))
              {
                Log.i("MicroMsg.Box.PluginBox", "flight number file not exist");
                return;
              }
              String[] arrayOfString = new String(y.bi(PluginBox.getBoxFlightResPath(), 0, -1)).split("\n");
              com.tencent.mm.pluginsdk.ui.span.c localc = com.tencent.mm.pluginsdk.ui.span.c.YnV;
              localc.YnU = null;
              localc.YnS = 0;
              localc.YnT = 0;
              i = 0;
              if (i < arrayOfString.length)
              {
                if (!Util.isNullOrNil(arrayOfString[i])) {
                  com.tencent.mm.pluginsdk.ui.span.c.YnV.brp(arrayOfString[i]);
                }
              }
              else
              {
                PluginBox.access$302(PluginBox.this, true);
                Log.i("MicroMsg.Box.PluginBox", "load flight number success NodeCount：%d CharacterCount：%d useTime: %d", new Object[] { Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.c.YnV.YnT), Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.c.YnV.YnS), Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            else
            {
              Log.i("MicroMsg.Box.PluginBox", "flight number is loading");
              continue;
            }
            i += 1;
          }
          catch (Exception localException)
          {
            com.tencent.mm.plugin.box.a.a.rG(0);
            Log.printErrStackTrace("MicroMsg.Box.PluginBox", localException, localException.getMessage(), new Object[0]);
            return;
          }
          finally
          {
            PluginBox.access$202(PluginBox.this, false);
            AppMethodBeat.o(278697);
          }
        }
      }
    }, "Box.LoadFlightNumberAsync");
    AppMethodBeat.o(76324);
  }
  
  private void loadWordBankAsync()
  {
    AppMethodBeat.i(278698);
    com.tencent.threadpool.h.ahAA.g(c.vzK, "box.HotWordSearchModel");
    AppMethodBeat.o(278698);
  }
  
  private void updateWordBankRes(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(278690);
    int i = c.dbi();
    int j = c.aiu(paramString);
    if ((j >= i) || (paramBoolean))
    {
      Log.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, start to update", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(278692);
          try
          {
            if (c.aiv(paramString) == 0)
            {
              c.mK(true);
              c.aiq(c.mL(false));
            }
            AppMethodBeat.o(278692);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.Box.PluginBox", localException, "[updateWordBankRes]", new Object[0]);
            AppMethodBeat.o(278692);
          }
        }
      }, "box.HotWordSearchModel");
      AppMethodBeat.o(278690);
      return;
    }
    Log.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, pass", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    AppMethodBeat.o(278690);
  }
  
  public d.a checkAllHotWords(String paramString)
  {
    AppMethodBeat.i(278718);
    d.a locala = new d.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = "";
    int i = -1;
    Object localObject2 = com.tencent.mm.plugin.box.a.b.vAb.matcher(paramString);
    if (((Matcher)localObject2).find())
    {
      localObject2 = ((Matcher)localObject2).group();
      if ((((String)localObject2).length() <= 15) && (((String)localObject2).length() >= 13))
      {
        localObject1 = "$Express$";
        localArrayList1.add("$Express$");
        localArrayList2.add("2");
        i = 2;
      }
    }
    for (int k = 1;; k = 0)
    {
      String str = getHotWordHighPriority(paramString);
      int j = i;
      localObject2 = localObject1;
      if (!Util.isNullOrNil(str))
      {
        localArrayList1.add(str);
        if (k == 0)
        {
          i = 3;
          localObject1 = str;
        }
        localArrayList2.add("3");
        localObject2 = localObject1;
        j = i;
      }
      localObject1 = c.ait(paramString);
      Collections.sort((List)localObject1, new Comparator() {});
      paramString = ((LinkedList)localObject1).iterator();
      while (paramString.hasNext())
      {
        localArrayList1.add(((gjd)paramString.next()).vFa);
        localArrayList2.add("1");
      }
      paramString = (String)localObject2;
      i = j;
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString = (String)localObject2;
        i = j;
        if (k == 0)
        {
          paramString = ((gjd)((LinkedList)localObject1).get(0)).vFa;
          i = 1;
        }
      }
      locala.vzR = Util.listToString(localArrayList1, "|");
      locala.vzS = Util.listToString(localArrayList2, "|");
      locala.vzP = paramString;
      locala.vzQ = i;
      AppMethodBeat.o(278718);
      return locala;
    }
  }
  
  public String checkFirstHotWord(String paramString)
  {
    AppMethodBeat.i(278720);
    Object localObject = com.tencent.mm.plugin.box.a.b.vAb.matcher(paramString);
    if (((Matcher)localObject).find())
    {
      localObject = ((Matcher)localObject).group();
      if ((((String)localObject).length() <= 15) && (((String)localObject).length() >= 13))
      {
        AppMethodBeat.o(278720);
        return "$Express$";
      }
    }
    localObject = getHotWordHighPriority(paramString);
    if (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(278720);
      return localObject;
    }
    paramString = c.ais(paramString);
    AppMethodBeat.o(278720);
    return paramString;
  }
  
  public boolean checkIfHasHotWord(String paramString)
  {
    AppMethodBeat.i(278716);
    boolean bool = c.air(paramString);
    AppMethodBeat.o(278716);
    return bool;
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(76323);
    if (paramg.bbA()) {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.box.a.c.class, new b());
    }
    AppMethodBeat.o(76323);
  }
  
  public String getExposedFingerWord(String paramString)
  {
    AppMethodBeat.i(278724);
    if ("$Express$".equals(paramString))
    {
      paramString = ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).getExposedWord("express");
      AppMethodBeat.o(278724);
      return paramString;
    }
    AppMethodBeat.o(278724);
    return paramString;
  }
  
  public String getMatchedFingerWord(String paramString1, String paramString2)
  {
    AppMethodBeat.i(278722);
    if ("$Express$".equals(paramString1))
    {
      Object localObject = com.tencent.mm.plugin.box.a.b.vAb.matcher(paramString2);
      if (((Matcher)localObject).find())
      {
        localObject = ((Matcher)localObject).group();
        if ((((String)localObject).length() <= 15) && (((String)localObject).length() >= 13))
        {
          AppMethodBeat.o(278722);
          return localObject;
        }
      }
    }
    paramString2 = getHotWordHighPriority(paramString2);
    if (!Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(278722);
      return paramString2;
    }
    AppMethodBeat.o(278722);
    return paramString1;
  }
  
  public int getSearchDuration()
  {
    AppMethodBeat.i(278728);
    int i = c.getSearchDuration();
    AppMethodBeat.o(278728);
    return i;
  }
  
  public String getWordBankVersionForStat()
  {
    AppMethodBeat.i(278726);
    String str = c.getWordBankVersionForStat();
    AppMethodBeat.o(278726);
    return str;
  }
  
  public boolean isInitBox()
  {
    AppMethodBeat.i(76325);
    if ((this.vzZ) && (aj.asY(2) != 1))
    {
      AppMethodBeat.o(76325);
      return true;
    }
    AppMethodBeat.o(76325);
    return false;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(76321);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("functionmsg", this.vzT.vzv);
    this.pWI.alive();
    this.vzY.alive();
    loadFlightNumberAsync();
    loadWordBankAsync();
    AppMethodBeat.o(76321);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(76322);
    this.pWI.dead();
    this.vzY.dead();
    AppMethodBeat.o(76322);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.PluginBox
 * JD-Core Version:    0.7.0.1
 */