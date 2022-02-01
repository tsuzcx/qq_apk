package com.tencent.mm.plugin.box;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.mo;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.protobuf.fml;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginBox
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, d
{
  private static List<Pattern> snW;
  private static int[] snX;
  private static HashMap<String, String> snY;
  private static long snZ;
  private boolean isLoading;
  private IListener mZZ;
  a snV;
  private IListener soa;
  private boolean sob;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(250412);
    snW = new ArrayList();
    snX = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 6, 6, 6, 6, 6, 6, 6, 6 };
    snY = new HashMap();
    snZ = 0L;
    while (i < 16)
    {
      Pattern localPattern = Pattern.compile(new String[] { "(|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?“(.{2,36}?)”(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?【(.{2,36}?)】(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?\\[(.{2,36}?)\\](微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?\\((.{2,36}?)\\)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?（(.{2,36}?)）(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?\"(.{2,36}?)\"(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?「(.{2,36}?)」(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)( )?'(.{2,36}?)'(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?“(.{2,36}?)”", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?\"(.{2,36}?)\"", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?【(.{2,36}?)】", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?\\[(.{2,36}?)\\]", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?\\((.{2,36}?)\\)", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?（(.{2,36}?)）", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?「(.{2,36}?)」", "(搜索并关注|搜索关注|搜索|搜一搜|搜一下|关注一下|关注|进入|打开|前往|登录|登陆|进)(微信)?(官方)?(公众号|小程序|视频号|公众服务平台|公众平台)( )?'(.{2,36}?)'" }[i]);
      snW.add(localPattern);
      i += 1;
    }
    AppMethodBeat.o(250412);
  }
  
  public PluginBox()
  {
    AppMethodBeat.i(76320);
    this.snV = new a();
    this.mZZ = new IListener() {};
    this.soa = new IListener() {};
    this.sob = false;
    this.isLoading = false;
    AppMethodBeat.o(76320);
  }
  
  public static String getBoxFlightResPath()
  {
    AppMethodBeat.i(76326);
    String str = new q(new q(ai.anf(2).gRd()).ifB(), "flight.txt").bOF();
    AppMethodBeat.o(76326);
    return str;
  }
  
  private String getHotWordHighPriority(String paramString)
  {
    AppMethodBeat.i(250401);
    if (!isSupportHotWordPrioritySwt())
    {
      AppMethodBeat.o(250401);
      return null;
    }
    if (snY.containsKey(paramString))
    {
      Log.i("MicroMsg.Box.PluginBox", " getHotWordHighPriority text = %s, hit = %s.", new Object[] { paramString, snY.get(paramString) });
      paramString = (String)snY.get(paramString);
      AppMethodBeat.o(250401);
      return paramString;
    }
    if ((snY.size() > 32) || (snZ > 500L))
    {
      snY.clear();
      snZ = 0L;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    int j;
    if (i < snW.size())
    {
      localObject = (Pattern)snW.get(i);
      j = snX[i];
      localObject = ((Pattern)localObject).matcher(paramString);
      if ((((Matcher)localObject).find()) && (j <= ((Matcher)localObject).groupCount()))
      {
        localObject = ((Matcher)localObject).group(j);
        if ((!Util.isNullOrNil((String)localObject)) && (!localArrayList.contains(localObject)))
        {
          j = 0;
          label203:
          if (j >= localArrayList.size()) {
            break label401;
          }
          String str = (String)localArrayList.get(j);
          if ((Util.isNullOrNil(str)) || (!str.contains((CharSequence)localObject))) {
            break label271;
          }
        }
      }
    }
    label271:
    label401:
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
        l = snZ;
        snZ = ((String)localArrayList.get(0)).length() + l;
        snY.put(paramString, localArrayList.get(0));
        paramString = (String)localArrayList.get(0);
        AppMethodBeat.o(250401);
        return paramString;
      }
      AppMethodBeat.o(250401);
      return null;
    }
  }
  
  public static boolean isSupportHotWordPrioritySwt()
  {
    AppMethodBeat.i(250396);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSq, 0);
    Log.d("MicroMsg.Box.PluginBox", "isSupportHotWordPrioritySwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(250396);
      return true;
    }
    AppMethodBeat.o(250396);
    return false;
  }
  
  private void loadFlightNumberAsync()
  {
    AppMethodBeat.i(76324);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRC, 0) == 0)
    {
      AppMethodBeat.o(76324);
      return;
    }
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250456);
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
              if (!u.agG(PluginBox.getBoxFlightResPath()))
              {
                Log.i("MicroMsg.Box.PluginBox", "flight number file not exist");
                return;
              }
              String[] arrayOfString = new String(u.aY(PluginBox.getBoxFlightResPath(), 0, -1)).split("\n");
              com.tencent.mm.pluginsdk.ui.span.c localc = com.tencent.mm.pluginsdk.ui.span.c.RrH;
              localc.RrG = null;
              localc.RrE = 0;
              localc.RrF = 0;
              i = 0;
              if (i < arrayOfString.length)
              {
                if (!Util.isNullOrNil(arrayOfString[i])) {
                  com.tencent.mm.pluginsdk.ui.span.c.RrH.brB(arrayOfString[i]);
                }
              }
              else
              {
                PluginBox.access$302(PluginBox.this, true);
                Log.i("MicroMsg.Box.PluginBox", "load flight number success NodeCount：%d CharacterCount：%d useTime: %d", new Object[] { Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.c.RrH.RrF), Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.c.RrH.RrE), Long.valueOf(System.currentTimeMillis() - l) });
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
            com.tencent.mm.plugin.box.a.a.rE(0);
            Log.printErrStackTrace("MicroMsg.Box.PluginBox", localException, localException.getMessage(), new Object[0]);
            return;
          }
          finally
          {
            PluginBox.access$202(PluginBox.this, false);
            AppMethodBeat.o(250456);
          }
        }
      }
    }, "Box.LoadFlightNumberAsync");
    AppMethodBeat.o(76324);
  }
  
  private void loadWordBankAsync()
  {
    AppMethodBeat.i(250388);
    com.tencent.e.h.ZvG.d(c.snM, "box.HotWordSearchModel");
    AppMethodBeat.o(250388);
  }
  
  private void updateWordBankRes(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(250386);
    int i = c.cyr();
    int j = c.aoY(paramString);
    if ((j >= i) || (paramBoolean))
    {
      Log.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, start to update", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.e.h.ZvG.d(new PluginBox.3(this, paramString), "box.HotWordSearchModel");
      AppMethodBeat.o(250386);
      return;
    }
    Log.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, pass", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    AppMethodBeat.o(250386);
  }
  
  public d.a checkAllHotWords(String paramString)
  {
    AppMethodBeat.i(250393);
    d.a locala = new d.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = "";
    int i = -1;
    Object localObject2 = com.tencent.mm.plugin.box.a.b.sod.matcher(paramString);
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
      localObject1 = c.aoX(paramString);
      Collections.sort((List)localObject1, new PluginBox.5(this));
      paramString = ((LinkedList)localObject1).iterator();
      while (paramString.hasNext())
      {
        localArrayList1.add(((fml)paramString.next()).szv);
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
          paramString = ((fml)((LinkedList)localObject1).get(0)).szv;
          i = 1;
        }
      }
      locala.snT = Util.listToString(localArrayList1, "|");
      locala.snU = Util.listToString(localArrayList2, "|");
      locala.snR = paramString;
      locala.snS = i;
      AppMethodBeat.o(250393);
      return locala;
    }
  }
  
  public String checkFirstHotWord(String paramString)
  {
    AppMethodBeat.i(250394);
    Object localObject = com.tencent.mm.plugin.box.a.b.sod.matcher(paramString);
    if (((Matcher)localObject).find())
    {
      localObject = ((Matcher)localObject).group();
      if ((((String)localObject).length() <= 15) && (((String)localObject).length() >= 13))
      {
        AppMethodBeat.o(250394);
        return "$Express$";
      }
    }
    localObject = getHotWordHighPriority(paramString);
    if (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(250394);
      return localObject;
    }
    paramString = c.aoW(paramString);
    AppMethodBeat.o(250394);
    return paramString;
  }
  
  public boolean checkIfHasHotWord(String paramString)
  {
    AppMethodBeat.i(250389);
    boolean bool = c.aoV(paramString);
    AppMethodBeat.o(250389);
    return bool;
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(76323);
    if (paramg.aIE()) {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.box.a.c.class, new b());
    }
    AppMethodBeat.o(76323);
  }
  
  public String getExposedFingerWord(String paramString)
  {
    AppMethodBeat.i(250403);
    if ("$Express$".equals(paramString))
    {
      paramString = ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).getExposedWord("express");
      AppMethodBeat.o(250403);
      return paramString;
    }
    AppMethodBeat.o(250403);
    return paramString;
  }
  
  public String getMatchedFingerWord(String paramString1, String paramString2)
  {
    AppMethodBeat.i(250395);
    if ("$Express$".equals(paramString1))
    {
      Object localObject = com.tencent.mm.plugin.box.a.b.sod.matcher(paramString2);
      if (((Matcher)localObject).find())
      {
        localObject = ((Matcher)localObject).group();
        if ((((String)localObject).length() <= 15) && (((String)localObject).length() >= 13))
        {
          AppMethodBeat.o(250395);
          return localObject;
        }
      }
    }
    paramString2 = getHotWordHighPriority(paramString2);
    if (!Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(250395);
      return paramString2;
    }
    AppMethodBeat.o(250395);
    return paramString1;
  }
  
  public int getSearchDuration()
  {
    AppMethodBeat.i(250407);
    int i = c.getSearchDuration();
    AppMethodBeat.o(250407);
    return i;
  }
  
  public String getWordBankVersionForStat()
  {
    AppMethodBeat.i(250405);
    String str = c.getWordBankVersionForStat();
    AppMethodBeat.o(250405);
    return str;
  }
  
  public boolean isInitBox()
  {
    AppMethodBeat.i(76325);
    if ((this.sob) && (ai.anh(2) != 1))
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
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("functionmsg", this.snV.snx);
    this.mZZ.alive();
    this.soa.alive();
    loadFlightNumberAsync();
    loadWordBankAsync();
    AppMethodBeat.o(76321);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(76322);
    this.mZZ.dead();
    this.soa.dead();
    AppMethodBeat.o(76322);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.box.PluginBox
 * JD-Core Version:    0.7.0.1
 */