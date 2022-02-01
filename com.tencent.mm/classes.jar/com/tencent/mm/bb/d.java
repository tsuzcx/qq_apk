package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.r;
import com.tencent.mm.am.s;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.z;
import com.tencent.mm.modelpackage.t;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d
  implements com.tencent.mm.am.h
{
  public static int chatType;
  private static final com.tencent.mm.b.f<Integer, a> lNS;
  private static d oUE;
  public boolean mjj = false;
  private int oQk = 3;
  
  static
  {
    AppMethodBeat.i(148389);
    lNS = new com.tencent.mm.b.h(5);
    chatType = 0;
    AppMethodBeat.o(148389);
  }
  
  public static int Pp(String paramString)
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
  
  public static d bMM()
  {
    AppMethodBeat.i(148384);
    if (oUE == null) {
      oUE = new d();
    }
    d locald = oUE;
    AppMethodBeat.o(148384);
    return locald;
  }
  
  public static void bMN()
  {
    AppMethodBeat.i(148387);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().B(16646145, Integer.valueOf(0));
    AppMethodBeat.o(148387);
  }
  
  public static void bMO()
  {
    AppMethodBeat.i(148388);
    com.tencent.mm.kernel.h.baF();
    Integer localInteger2 = Integer.valueOf(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(16646145, null)));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() < 0) {
      localInteger1 = Integer.valueOf(0);
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().B(16646145, Integer.valueOf(localInteger1.intValue() + 1));
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(148386);
    if ((!(paramp instanceof r)) || (((r)paramp).bFO() != 9))
    {
      Log.d("upload", "another scene");
      AppMethodBeat.o(148386);
      return;
    }
    if (paramp.getType() == 159)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(81944, Long.valueOf(Util.nowSecond()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(148386);
      return;
      label91:
      paramInt1 = this.oQk - 1;
      this.oQk = paramInt1;
      if (paramInt1 < 0)
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().B(81944, Long.valueOf((Util.nowMilliSecond() - 86400000L + 3600000L) / 1000L));
        this.oQk = 3;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148385);
    this.mjj = false;
    com.tencent.mm.kernel.h.aZW().b(159, this);
    AppMethodBeat.o(148385);
  }
  
  public static final class a
  {
    public int oUF;
    public int oUG;
    public int oUH;
    public int oUI;
    public int oUJ;
    public int oUK;
    public int oUL;
    public int oUM;
    public int oUN;
    private Random oUO;
    public List<String> oUP;
    public String region;
    public int sex;
    
    public a()
    {
      AppMethodBeat.i(148379);
      this.region = "BeiJing;GuangZhou;ShangHai;";
      this.sex = 0;
      this.oUF = 0;
      this.oUG = 2;
      this.oUH = 2;
      this.oUI = 2;
      this.oUJ = 10240;
      this.oUK = 10240000;
      this.oUL = 100;
      this.oUM = 100;
      this.oUN = 100;
      this.oUO = new Random();
      this.oUP = null;
      AppMethodBeat.o(148379);
    }
    
    private int bMR()
    {
      switch (d.chatType)
      {
      default: 
        return this.oUL;
      case 0: 
        return this.oUL;
      case 1: 
        return this.oUM;
      }
      return this.oUN;
    }
    
    public static a bMT()
    {
      AppMethodBeat.i(148382);
      Log.d("upload", "parseFromFile");
      Object localObject1 = u.bLH();
      localObject1 = t.bLE() + ((t)localObject1).eK(1, 9);
      int i = (int)y.bEl((String)localObject1);
      if (i == -1)
      {
        Log.e("upload", "read file failed " + i + (String)localObject1);
        AppMethodBeat.o(148382);
        return null;
      }
      Object localObject3 = y.bi((String)localObject1, 0, i);
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
        localObject3 = (a)d.bMP().get(Integer.valueOf(k));
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
              break label1155;
            }
            if (!((String)localObject1).equals("region")) {
              continue;
            }
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.region = ((String)((Map)localObject3).get(localObject1));
              if ((locala.region == null) || (locala.region.length() <= 0)) {
                break label1473;
              }
              localObject1 = locala.region.split(";");
              locala.oUP = new ArrayList();
              if ((localObject1 == null) || (localObject1.length <= 0)) {
                break label1473;
              }
              j = 0;
              if (j >= localObject1.length) {
                break label1473;
              }
              if ((localObject1[j] == null) || (localObject1[j].length() <= 0)) {
                break label1466;
              }
              locala.oUP.add(localObject1[j]);
              break label1466;
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
              locala.sex = Util.getInt((String)((Map)localObject3).get(localObject1), 0);
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
              locala.oUF = Util.getInt((String)((Map)localObject3).get(localObject1), 0);
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
            locala.oUJ = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("maxsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.oUK = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.oUL = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.oUM = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.oUN = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.oUG = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.oUH = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.oUI = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
          label1155:
          Log.d("upload", "sex " + locala.sex);
          Log.d("upload", "rate_single " + locala.oUG);
          Log.d("upload", "rate_chatroom " + locala.oUH);
          Log.d("upload", "rate_app " + locala.oUI);
          Log.d("upload", "rate " + locala.oUF);
          Log.d("upload", "minsize " + locala.oUJ);
          Log.d("upload", "maxsize " + locala.oUK);
          Log.d("upload", "daycount_single " + locala.oUL);
          Log.d("upload", "daycount_chatroom " + locala.oUM);
          Log.d("upload", "daycount_app " + locala.oUN);
          Log.d("upload", "region " + locala.region);
          d.bMP().B(Integer.valueOf(k), locala);
          AppMethodBeat.o(148382);
          return locala;
          break;
          label1466:
          j += 1;
          continue;
        }
        label1473:
        i += 1;
      }
    }
    
    public final boolean bMQ()
    {
      AppMethodBeat.i(148380);
      Object localObject2 = z.bBF();
      Object localObject1;
      int i;
      if ("  getRegionCode ".concat(String.valueOf(localObject2)) != null)
      {
        localObject1 = ((az)localObject2).kaj;
        Log.d("upload", (String)localObject1);
        localObject1 = ((az)localObject2).kaj;
        if ((localObject1 != null) && (((String)localObject1).length() > 0) && (this.oUP != null) && (this.oUP.size() > 0))
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
            localObject2 = this.oUP.iterator();
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
    
    public final boolean bMS()
    {
      AppMethodBeat.i(148381);
      if (1 == g.ac("EnableSpeexVoiceUpload", 0))
      {
        AppMethodBeat.o(148381);
        return true;
      }
      Log.d("upload", "type " + d.chatType);
      int j = bMR();
      int i = getRate();
      com.tencent.mm.kernel.h.baF();
      Integer localInteger = Integer.valueOf(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(16646145, null)));
      Log.d("upload", "daycount " + bMR() + "  count " + localInteger + " rate " + i);
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
      com.tencent.mm.kernel.h.baF();
      j = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(12290, null), 0);
      boolean bool;
      if (this.sex == 0) {
        bool = true;
      }
      for (;;)
      {
        Log.d("upload", "fitSex " + this.sex + " " + bool + " " + this.sex);
        if (bool) {
          break;
        }
        AppMethodBeat.o(148381);
        return false;
        if (this.sex == j) {
          bool = true;
        } else {
          bool = false;
        }
      }
      if (!bMQ())
      {
        AppMethodBeat.o(148381);
        return false;
      }
      j = this.oUO.nextInt(i);
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
        return this.oUG;
      case 0: 
        return this.oUG;
      case 1: 
        return this.oUH;
      }
      return this.oUI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.d
 * JD-Core Version:    0.7.0.1
 */