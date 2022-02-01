package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.be.w;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d
  implements i
{
  public static int chatType;
  private static final com.tencent.mm.b.f<Integer, a> jla;
  private static d mbJ;
  public boolean jJQ = false;
  private int lXi = 3;
  
  static
  {
    AppMethodBeat.i(148389);
    jla = new com.tencent.mm.b.h(5);
    chatType = 0;
    AppMethodBeat.o(148389);
  }
  
  public static int Xn(String paramString)
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
  
  public static d bpf()
  {
    AppMethodBeat.i(148384);
    if (mbJ == null) {
      mbJ = new d();
    }
    d locald = mbJ;
    AppMethodBeat.o(148384);
    return locald;
  }
  
  public static void bpg()
  {
    AppMethodBeat.i(148387);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().i(16646145, Integer.valueOf(0));
    AppMethodBeat.o(148387);
  }
  
  public static void bph()
  {
    AppMethodBeat.i(148388);
    com.tencent.mm.kernel.h.aHH();
    Integer localInteger2 = Integer.valueOf(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(16646145, null)));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() < 0) {
      localInteger1 = Integer.valueOf(0);
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().i(16646145, Integer.valueOf(localInteger1.intValue() + 1));
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
    if ((!(paramq instanceof com.tencent.mm.an.s)) || (((com.tencent.mm.an.s)paramq).big() != 9))
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
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(81944, Long.valueOf(Util.nowSecond()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(148386);
      return;
      label91:
      paramInt1 = this.lXi - 1;
      this.lXi = paramInt1;
      if (paramInt1 < 0)
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().i(81944, Long.valueOf((Util.nowMilliSecond() - 86400000L + 3600000L) / 1000L));
        this.lXi = 3;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148385);
    this.jJQ = false;
    com.tencent.mm.kernel.h.aGY().b(159, this);
    AppMethodBeat.o(148385);
  }
  
  public static final class a
  {
    public int mbK;
    public int mbL;
    public int mbM;
    public int mbN;
    public int mbO;
    public int mbP;
    public int mbQ;
    public int mbR;
    public int mbS;
    private Random mbT;
    public List<String> mbU;
    public String region;
    public int sex;
    
    public a()
    {
      AppMethodBeat.i(148379);
      this.region = "BeiJing;GuangZhou;ShangHai;";
      this.sex = 0;
      this.mbK = 0;
      this.mbL = 2;
      this.mbM = 2;
      this.mbN = 2;
      this.mbO = 10240;
      this.mbP = 10240000;
      this.mbQ = 100;
      this.mbR = 100;
      this.mbS = 100;
      this.mbT = new Random();
      this.mbU = null;
      AppMethodBeat.o(148379);
    }
    
    private int bpk()
    {
      switch (d.chatType)
      {
      default: 
        return this.mbQ;
      case 0: 
        return this.mbQ;
      case 1: 
        return this.mbR;
      }
      return this.mbS;
    }
    
    public static a bpm()
    {
      AppMethodBeat.i(148382);
      Log.d("upload", "parseFromFile");
      Object localObject1 = w.bnU();
      localObject1 = com.tencent.mm.be.s.bnR() + ((com.tencent.mm.be.s)localObject1).dS(1, 9);
      int i = (int)u.bBQ((String)localObject1);
      if (i == -1)
      {
        Log.e("upload", "read file failed " + i + (String)localObject1);
        AppMethodBeat.o(148382);
        return null;
      }
      Object localObject3 = u.aY((String)localObject1, 0, i);
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
        localObject3 = (a)d.bpi().get(Integer.valueOf(k));
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
              locala.mbU = new ArrayList();
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
              locala.mbU.add(localObject1[j]);
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
              locala.mbK = Util.getInt((String)((Map)localObject3).get(localObject1), 0);
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
            locala.mbO = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("maxsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.mbP = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.mbQ = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.mbR = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.mbS = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.mbL = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.mbM = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.mbN = Util.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
          label1155:
          Log.d("upload", "sex " + locala.sex);
          Log.d("upload", "rate_single " + locala.mbL);
          Log.d("upload", "rate_chatroom " + locala.mbM);
          Log.d("upload", "rate_app " + locala.mbN);
          Log.d("upload", "rate " + locala.mbK);
          Log.d("upload", "minsize " + locala.mbO);
          Log.d("upload", "maxsize " + locala.mbP);
          Log.d("upload", "daycount_single " + locala.mbQ);
          Log.d("upload", "daycount_chatroom " + locala.mbR);
          Log.d("upload", "daycount_app " + locala.mbS);
          Log.d("upload", "region " + locala.region);
          d.bpi().q(Integer.valueOf(k), locala);
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
    
    public final boolean bpj()
    {
      AppMethodBeat.i(148380);
      Object localObject2 = z.bdN();
      Object localObject1;
      int i;
      if ("  getRegionCode ".concat(String.valueOf(localObject2)) != null)
      {
        localObject1 = ((ax)localObject2).hDn;
        Log.d("upload", (String)localObject1);
        localObject1 = ((ax)localObject2).hDn;
        if ((localObject1 != null) && (((String)localObject1).length() > 0) && (this.mbU != null) && (this.mbU.size() > 0))
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
            localObject2 = this.mbU.iterator();
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
    
    public final boolean bpl()
    {
      AppMethodBeat.i(148381);
      if (1 == g.T("EnableSpeexVoiceUpload", 0))
      {
        AppMethodBeat.o(148381);
        return true;
      }
      Log.d("upload", "type " + d.chatType);
      int j = bpk();
      int i = getRate();
      com.tencent.mm.kernel.h.aHH();
      Integer localInteger = Integer.valueOf(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(16646145, null)));
      Log.d("upload", "daycount " + bpk() + "  count " + localInteger + " rate " + i);
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
      com.tencent.mm.kernel.h.aHH();
      j = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(12290, null), 0);
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
      if (!bpj())
      {
        AppMethodBeat.o(148381);
        return false;
      }
      j = this.mbT.nextInt(i);
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
        return this.mbL;
      case 0: 
        return this.mbL;
      case 1: 
        return this.mbM;
      }
      return this.mbN;
    }
  }
  
  public static final class b
  {
    public int audioFormat = 0;
    public int mbC = 0;
    public String prefix = "";
    public int sampleRate = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bi.d
 * JD-Core Version:    0.7.0.1
 */