package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d
  implements i
{
  public static int chatType;
  private static final f<Integer, a> gAU;
  private static d jlH;
  public boolean gYQ = false;
  private int jgF = 3;
  
  static
  {
    AppMethodBeat.i(148389);
    gAU = new h(5);
    chatType = 0;
    AppMethodBeat.o(148389);
  }
  
  public static int PP(String paramString)
  {
    int i = 5;
    AppMethodBeat.i(148383);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(148383);
      return 5;
    }
    if ((!paramString.startsWith("single")) || (paramString.startsWith("chatroom"))) {
      i = 7;
    }
    if (paramString.startsWith("app")) {
      i = 8;
    }
    Log.d("upload", "type ".concat(String.valueOf(i)));
    AppMethodBeat.o(148383);
    return i;
  }
  
  public static d bfP()
  {
    AppMethodBeat.i(148384);
    if (jlH == null) {
      jlH = new d();
    }
    d locald = jlH;
    AppMethodBeat.o(148384);
    return locald;
  }
  
  public static void bfQ()
  {
    AppMethodBeat.i(148387);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(16646145, Integer.valueOf(0));
    AppMethodBeat.o(148387);
  }
  
  public static void bfR()
  {
    AppMethodBeat.i(148388);
    com.tencent.mm.kernel.g.aAi();
    Integer localInteger2 = Integer.valueOf(Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(16646145, null)));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() < 0) {
      localInteger1 = Integer.valueOf(0);
    }
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(16646145, Integer.valueOf(localInteger1.intValue() + 1));
    AppMethodBeat.o(148388);
  }
  
  public static String getPrefix()
  {
    switch (chatType)
    {
    default: 
      return "single_";
    case 0: 
      return "single_";
    case 1: 
      return "chatroom_";
    }
    return "app_";
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(148386);
    if ((!(paramq instanceof com.tencent.mm.ak.s)) || (((com.tencent.mm.ak.s)paramq).aYR() != 9))
    {
      Log.d("upload", "another scene");
      AppMethodBeat.o(148386);
      return;
    }
    if (paramq.getType() == 159)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(81944, Long.valueOf(Util.nowSecond()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(148386);
      return;
      label91:
      paramInt1 = this.jgF - 1;
      this.jgF = paramInt1;
      if (paramInt1 < 0)
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(81944, Long.valueOf((Util.nowMilliSecond() - 86400000L + 3600000L) / 1000L));
        this.jgF = 3;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148385);
    this.gYQ = false;
    com.tencent.mm.kernel.g.azz().b(159, this);
    AppMethodBeat.o(148385);
  }
  
  public static final class a
  {
    public int fuA;
    public String jlI;
    public int jlJ;
    public int jlK;
    public int jlL;
    public int jlM;
    public int jlN;
    public int jlO;
    public int jlP;
    public int jlQ;
    public int jlR;
    private Random jlS;
    public List<String> jlT;
    
    public a()
    {
      AppMethodBeat.i(148379);
      this.jlI = "BeiJing;GuangZhou;ShangHai;";
      this.fuA = 0;
      this.jlJ = 0;
      this.jlK = 2;
      this.jlL = 2;
      this.jlM = 2;
      this.jlN = 10240;
      this.jlO = 10240000;
      this.jlP = 100;
      this.jlQ = 100;
      this.jlR = 100;
      this.jlS = new Random();
      this.jlT = null;
      AppMethodBeat.o(148379);
    }
    
    private int bfU()
    {
      switch (d.chatType)
      {
      default: 
        return this.jlP;
      case 0: 
        return this.jlP;
      case 1: 
        return this.jlQ;
      }
      return this.jlR;
    }
    
    public static a bfW()
    {
      AppMethodBeat.i(148382);
      Log.d("upload", "parseFromFile");
      Object localObject1 = v.bev();
      localObject1 = r.bes() + ((r)localObject1).dv(1, 9);
      int i = (int)com.tencent.mm.vfs.s.boW((String)localObject1);
      if (i == -1)
      {
        Log.e("upload", "read file failed " + i + (String)localObject1);
        AppMethodBeat.o(148382);
        return null;
      }
      Object localObject3 = com.tencent.mm.vfs.s.aW((String)localObject1, 0, i);
      if (localObject3 == null)
      {
        Log.e("upload", "read file failed " + i + (String)localObject1);
        AppMethodBeat.o(148382);
        return null;
      }
      localObject1 = new String((byte[])localObject3);
      if (Util.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(148382);
        return null;
      }
      i = ((String)localObject1).indexOf('<');
      int k;
      if (i > 0)
      {
        localObject1 = ((String)localObject1).substring(i);
        k = ((String)localObject1).hashCode();
        localObject3 = (a)d.bfS().get(Integer.valueOf(k));
        if (localObject3 != null)
        {
          AppMethodBeat.o(148382);
          return localObject3;
        }
        localObject3 = XmlParser.parseXml((String)localObject1, "Config", null);
        if (localObject3 == null)
        {
          Log.e("upload", "parse msg failed");
          AppMethodBeat.o(148382);
          return null;
        }
      }
      for (;;)
      {
        a locala;
        StringBuilder localStringBuilder;
        int j;
        try
        {
          locala = new a();
          i = 0;
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0)
          {
            localObject1 = "";
            localObject1 = (String)((Map)localObject3).get(localObject1 + ".$key");
            Log.d("upload", "key ".concat(String.valueOf(localObject1)));
            if (localObject1 == null) {
              break label1156;
            }
            if (!((String)localObject1).equals("region")) {
              continue;
            }
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.jlI = ((String)((Map)localObject3).get(localObject1));
              if ((locala.jlI == null) || (locala.jlI.length() <= 0)) {
                break label1474;
              }
              localObject1 = locala.jlI.split(";");
              locala.jlT = new ArrayList();
              if ((localObject1 == null) || (localObject1.length <= 0)) {
                break label1474;
              }
              j = 0;
              if (j >= localObject1.length) {
                break label1474;
              }
              if ((localObject1[j] == null) || (localObject1[j].length() <= 0)) {
                break label1467;
              }
              locala.jlT.add(localObject1[j]);
              break label1467;
            }
          }
          else
          {
            localObject1 = Integer.valueOf(i);
            continue;
          }
          localObject1 = Integer.valueOf(i);
          continue;
          if (((String)localObject1).equals("sex"))
          {
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.fuA = Util.getInt((String)((Map)localObject3).get(localObject1), 0);
            }
            else
            {
              localObject1 = Integer.valueOf(i);
              continue;
            }
          }
          else if (((String)localObject1).equals("rate"))
          {
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.jlJ = Util.getInt((String)((Map)localObject3).get(localObject1), 0);
            }
          }
        }
        catch (Exception localException)
        {
          Log.e("upload", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
          AppMethodBeat.o(148382);
          return null;
        }
        Object localObject2 = Integer.valueOf(i);
        continue;
        if (((String)localObject2).equals("minsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.jlN = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("maxsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.jlO = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.jlP = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.jlQ = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.jlR = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.jlK = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.jlL = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.jlM = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
          label1156:
          Log.d("upload", "sex " + locala.fuA);
          Log.d("upload", "rate_single " + locala.jlK);
          Log.d("upload", "rate_chatroom " + locala.jlL);
          Log.d("upload", "rate_app " + locala.jlM);
          Log.d("upload", "rate " + locala.jlJ);
          Log.d("upload", "minsize " + locala.jlN);
          Log.d("upload", "maxsize " + locala.jlO);
          Log.d("upload", "daycount_single " + locala.jlP);
          Log.d("upload", "daycount_chatroom " + locala.jlQ);
          Log.d("upload", "daycount_app " + locala.jlR);
          Log.d("upload", "region " + locala.jlI);
          d.bfS().x(Integer.valueOf(k), locala);
          AppMethodBeat.o(148382);
          return locala;
          break;
          label1467:
          j += 1;
          continue;
        }
        label1474:
        i += 1;
      }
    }
    
    public final boolean bfT()
    {
      AppMethodBeat.i(148380);
      Object localObject2 = z.aUL();
      Object localObject1;
      int i;
      if ("  getRegionCode ".concat(String.valueOf(localObject2)) != null)
      {
        localObject1 = ((ax)localObject2).fuO;
        Log.d("upload", (String)localObject1);
        localObject1 = ((ax)localObject2).fuO;
        if ((localObject1 != null) && (((String)localObject1).length() > 0) && (this.jlT != null) && (this.jlT.size() > 0))
        {
          localObject1 = ((String)localObject1).split("_");
          if ((localObject1 != null) && (localObject1.length > 0)) {
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i >= localObject1.length) {
            break label187;
          }
          if ((localObject1[i] != null) && (localObject1[i].length() > 0))
          {
            localObject2 = this.jlT.iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext()) {
                if (((String)((Iterator)localObject2).next()).trim().toLowerCase().equals(localObject1[i].trim().toLowerCase()))
                {
                  Log.d("upload", "isInRegion");
                  AppMethodBeat.o(148380);
                  return true;
                  localObject1 = "";
                  break;
                }
              }
            }
          }
          i += 1;
        }
      }
      label187:
      AppMethodBeat.o(148380);
      return false;
    }
    
    public final boolean bfV()
    {
      AppMethodBeat.i(148381);
      if (1 == com.tencent.mm.audio.b.g.B("EnableSpeexVoiceUpload", 0))
      {
        AppMethodBeat.o(148381);
        return true;
      }
      Log.d("upload", "type " + d.chatType);
      int j = bfU();
      int i = getRate();
      com.tencent.mm.kernel.g.aAi();
      Integer localInteger = Integer.valueOf(Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(16646145, null)));
      Log.d("upload", "daycount " + bfU() + "  count " + localInteger + " rate " + i);
      if (localInteger.intValue() > j)
      {
        AppMethodBeat.o(148381);
        return false;
      }
      if (i == 0)
      {
        AppMethodBeat.o(148381);
        return false;
      }
      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
      {
        AppMethodBeat.o(148381);
        return false;
      }
      com.tencent.mm.kernel.g.aAi();
      j = Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(12290, null), 0);
      boolean bool;
      if (this.fuA == 0) {
        bool = true;
      }
      for (;;)
      {
        Log.d("upload", "fitSex " + this.fuA + " " + bool + " " + this.fuA);
        if (bool) {
          break;
        }
        AppMethodBeat.o(148381);
        return false;
        if (this.fuA == j) {
          bool = true;
        } else {
          bool = false;
        }
      }
      if (!bfT())
      {
        AppMethodBeat.o(148381);
        return false;
      }
      j = this.jlS.nextInt(i);
      Log.d("upload", "luck ".concat(String.valueOf(j)));
      if (j == i / 2)
      {
        AppMethodBeat.o(148381);
        return true;
      }
      AppMethodBeat.o(148381);
      return false;
    }
    
    public final int getRate()
    {
      switch (d.chatType)
      {
      default: 
        return this.jlK;
      case 0: 
        return this.jlK;
      case 1: 
        return this.jlL;
      }
      return this.jlM;
    }
  }
  
  public static final class b
  {
    public int audioFormat = 0;
    public int jlA = 0;
    public String prefix = "";
    public int sampleRate = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bg.d
 * JD-Core Version:    0.7.0.1
 */