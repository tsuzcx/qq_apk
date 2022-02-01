package com.tencent.mm.bh;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.b.h;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d
  implements com.tencent.mm.al.f
{
  public static int chatType;
  private static final com.tencent.mm.b.f<Integer, a> fTI;
  private static d inC;
  public boolean glB = false;
  private int iiN = 3;
  
  static
  {
    AppMethodBeat.i(148389);
    fTI = new h(5);
    chatType = 0;
    AppMethodBeat.o(148389);
  }
  
  public static int GA(String paramString)
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
    ad.d("upload", "type ".concat(String.valueOf(i)));
    AppMethodBeat.o(148383);
    return i;
  }
  
  public static d aLp()
  {
    AppMethodBeat.i(148384);
    if (inC == null) {
      inC = new d();
    }
    d locald = inC;
    AppMethodBeat.o(148384);
    return locald;
  }
  
  public static void aLq()
  {
    AppMethodBeat.i(148387);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(16646145, Integer.valueOf(0));
    AppMethodBeat.o(148387);
  }
  
  public static void aLr()
  {
    AppMethodBeat.i(148388);
    com.tencent.mm.kernel.g.ajD();
    Integer localInteger2 = Integer.valueOf(bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(16646145, null)));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() < 0) {
      localInteger1 = Integer.valueOf(0);
    }
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(16646145, Integer.valueOf(localInteger1.intValue() + 1));
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(148386);
    if ((!(paramn instanceof com.tencent.mm.al.p)) || (((com.tencent.mm.al.p)paramn).aEM() != 9))
    {
      ad.d("upload", "another scene");
      AppMethodBeat.o(148386);
      return;
    }
    if (paramn.getType() == 159)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(81944, Long.valueOf(bt.aQJ()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(148386);
      return;
      label91:
      paramInt1 = this.iiN - 1;
      this.iiN = paramInt1;
      if (paramInt1 < 0)
      {
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(81944, Long.valueOf((bt.flT() - 86400000L + 3600000L) / 1000L));
        this.iiN = 3;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148385);
    this.glB = false;
    com.tencent.mm.kernel.g.aiU().b(159, this);
    AppMethodBeat.o(148385);
  }
  
  public static final class a
  {
    public int ePk;
    public String inD;
    public int inE;
    public int inF;
    public int inG;
    public int inH;
    public int inI;
    public int inJ;
    public int inK;
    public int inL;
    public int inM;
    private Random inN;
    public List<String> inO;
    
    public a()
    {
      AppMethodBeat.i(148379);
      this.inD = "BeiJing;GuangZhou;ShangHai;";
      this.ePk = 0;
      this.inE = 0;
      this.inF = 2;
      this.inG = 2;
      this.inH = 2;
      this.inI = 10240;
      this.inJ = 10240000;
      this.inK = 100;
      this.inL = 100;
      this.inM = 100;
      this.inN = new Random();
      this.inO = null;
      AppMethodBeat.o(148379);
    }
    
    private int aLu()
    {
      switch (d.chatType)
      {
      default: 
        return this.inK;
      case 0: 
        return this.inK;
      case 1: 
        return this.inL;
      }
      return this.inM;
    }
    
    public static a aLw()
    {
      AppMethodBeat.i(148382);
      ad.d("upload", "parseFromFile");
      Object localObject1 = t.aJZ();
      localObject1 = com.tencent.mm.bc.p.aJW() + ((com.tencent.mm.bc.p)localObject1).dl(1, 9);
      int i = (int)i.aYo((String)localObject1);
      if (i == -1)
      {
        ad.e("upload", "read file failed " + i + (String)localObject1);
        AppMethodBeat.o(148382);
        return null;
      }
      Object localObject3 = i.aY((String)localObject1, 0, i);
      if (localObject3 == null)
      {
        ad.e("upload", "read file failed " + i + (String)localObject1);
        AppMethodBeat.o(148382);
        return null;
      }
      localObject1 = new String((byte[])localObject3);
      if (bt.isNullOrNil((String)localObject1))
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
        localObject3 = (a)d.aLs().get(Integer.valueOf(k));
        if (localObject3 != null)
        {
          AppMethodBeat.o(148382);
          return localObject3;
        }
        localObject3 = bw.M((String)localObject1, "Config");
        if (localObject3 == null)
        {
          ad.e("upload", "parse msg failed");
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
            ad.d("upload", "key ".concat(String.valueOf(localObject1)));
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
              locala.inD = ((String)((Map)localObject3).get(localObject1));
              if ((locala.inD == null) || (locala.inD.length() <= 0)) {
                break label1473;
              }
              localObject1 = locala.inD.split(";");
              locala.inO = new ArrayList();
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
              locala.inO.add(localObject1[j]);
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
              locala.ePk = bt.getInt((String)((Map)localObject3).get(localObject1), 0);
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
              locala.inE = bt.getInt((String)((Map)localObject3).get(localObject1), 0);
            }
          }
        }
        catch (Exception localException)
        {
          ad.e("upload", "exception:%s", new Object[] { bt.n(localException) });
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
            locala.inI = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("maxsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.inJ = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.inK = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.inL = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.inM = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.inF = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.inG = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.inH = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
          label1155:
          ad.d("upload", "sex " + locala.ePk);
          ad.d("upload", "rate_single " + locala.inF);
          ad.d("upload", "rate_chatroom " + locala.inG);
          ad.d("upload", "rate_app " + locala.inH);
          ad.d("upload", "rate " + locala.inE);
          ad.d("upload", "minsize " + locala.inI);
          ad.d("upload", "maxsize " + locala.inJ);
          ad.d("upload", "daycount_single " + locala.inK);
          ad.d("upload", "daycount_chatroom " + locala.inL);
          ad.d("upload", "daycount_app " + locala.inM);
          ad.d("upload", "region " + locala.inD);
          d.aLs().q(Integer.valueOf(k), locala);
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
    
    public final boolean aLt()
    {
      AppMethodBeat.i(148380);
      Object localObject2 = u.aAY();
      Object localObject1;
      int i;
      if ("  getRegionCode ".concat(String.valueOf(localObject2)) != null)
      {
        localObject1 = ((aw)localObject2).ePA;
        ad.d("upload", (String)localObject1);
        localObject1 = ((aw)localObject2).ePA;
        if ((localObject1 != null) && (((String)localObject1).length() > 0) && (this.inO != null) && (this.inO.size() > 0))
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
            localObject2 = this.inO.iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext()) {
                if (((String)((Iterator)localObject2).next()).trim().toLowerCase().equals(localObject1[i].trim().toLowerCase()))
                {
                  ad.d("upload", "isInRegion");
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
    
    public final boolean aLv()
    {
      AppMethodBeat.i(148381);
      if (1 == com.tencent.mm.audio.b.g.z("EnableSpeexVoiceUpload", 0))
      {
        AppMethodBeat.o(148381);
        return true;
      }
      ad.d("upload", "type " + d.chatType);
      int j = aLu();
      int i = getRate();
      com.tencent.mm.kernel.g.ajD();
      Integer localInteger = Integer.valueOf(bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(16646145, null)));
      ad.d("upload", "daycount " + aLu() + "  count " + localInteger + " rate " + i);
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
      if (!ay.isWifi(aj.getContext()))
      {
        AppMethodBeat.o(148381);
        return false;
      }
      com.tencent.mm.kernel.g.ajD();
      j = bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(12290, null), 0);
      boolean bool;
      if (this.ePk == 0) {
        bool = true;
      }
      for (;;)
      {
        ad.d("upload", "fitSex " + this.ePk + " " + bool + " " + this.ePk);
        if (bool) {
          break;
        }
        AppMethodBeat.o(148381);
        return false;
        if (this.ePk == j) {
          bool = true;
        } else {
          bool = false;
        }
      }
      if (!aLt())
      {
        AppMethodBeat.o(148381);
        return false;
      }
      j = this.inN.nextInt(i);
      ad.d("upload", "luck ".concat(String.valueOf(j)));
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
        return this.inF;
      case 0: 
        return this.inF;
      case 1: 
        return this.inG;
      }
      return this.inH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bh.d
 * JD-Core Version:    0.7.0.1
 */