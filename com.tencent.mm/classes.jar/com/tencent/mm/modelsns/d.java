package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.atomic.AtomicInteger;

public final class d
{
  private static boolean hRB;
  private static AtomicInteger hTT;
  public Object hTK;
  public int hTL;
  public int hTM;
  public int hTN;
  public int hTO;
  public StringBuffer hTP;
  public StringBuffer hTQ;
  public StringBuffer hTR;
  public StringBuffer hTS;
  public int opType;
  public long timeStamp;
  
  static
  {
    AppMethodBeat.i(125679);
    hRB = false;
    hTT = new AtomicInteger(0);
    AppMethodBeat.o(125679);
  }
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125659);
    this.hTK = null;
    this.hTL = 1;
    this.opType = 0;
    this.hTP = new StringBuffer();
    this.hTQ = new StringBuffer();
    this.hTR = new StringBuffer();
    this.hTS = new StringBuffer();
    this.opType = paramInt1;
    this.hTO = paramInt2;
    if (!aHV())
    {
      AppMethodBeat.o(125659);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    if (ax.isWifi(ai.getContext())) {
      this.hTN = 4;
    }
    for (;;)
    {
      this.hTM = hTT.incrementAndGet();
      AppMethodBeat.o(125659);
      return;
      if (ax.is4G(ai.getContext())) {
        this.hTN = 3;
      } else if (ax.is3G(ai.getContext())) {
        this.hTN = 2;
      } else if (ax.is2G(ai.getContext())) {
        this.hTN = 1;
      } else {
        this.hTN = 0;
      }
    }
  }
  
  public static void aHY()
  {
    AppMethodBeat.i(125670);
    ac.i("MicroMsg.StatisticsOplog", "wait op");
    AppMethodBeat.o(125670);
  }
  
  private static d ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125677);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(125677);
      return null;
    }
    dcr localdcr = new dcr();
    try
    {
      localdcr.parseFrom(paramArrayOfByte);
      paramArrayOfByte = new d(localdcr.opType, localdcr.hTO);
      paramArrayOfByte.hTL = localdcr.hTL;
      paramArrayOfByte.timeStamp = localdcr.timeStamp;
      paramArrayOfByte.hTM = localdcr.hTM;
      paramArrayOfByte.hTN = localdcr.hTN;
      paramArrayOfByte.hTP = new StringBuffer(localdcr.FMn);
      paramArrayOfByte.hTS = new StringBuffer(localdcr.FMo);
      paramArrayOfByte.hTQ = new StringBuffer(localdcr.FMp);
      paramArrayOfByte.hTR = new StringBuffer(localdcr.FMq);
      AppMethodBeat.o(125677);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("MicroMsg.StatisticsOplog", "putIntent " + paramArrayOfByte.getMessage());
      AppMethodBeat.o(125677);
    }
    return null;
  }
  
  public static d c(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(125676);
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null)
    {
      AppMethodBeat.o(125676);
      return null;
    }
    paramIntent = ac(paramIntent);
    AppMethodBeat.o(125676);
    return paramIntent;
  }
  
  public static d ps(int paramInt)
  {
    AppMethodBeat.i(125657);
    d locald = new d(paramInt, 1);
    AppMethodBeat.o(125657);
    return locald;
  }
  
  public static d pt(int paramInt)
  {
    AppMethodBeat.i(125658);
    d locald = new d(paramInt, 4);
    AppMethodBeat.o(125658);
    return locald;
  }
  
  public static d u(Bundle paramBundle)
  {
    AppMethodBeat.i(125674);
    paramBundle = paramBundle.getByteArray("intent_key_StatisticsOplog");
    if (paramBundle == null)
    {
      AppMethodBeat.o(125674);
      return null;
    }
    paramBundle = ac(paramBundle);
    AppMethodBeat.o(125674);
    return paramBundle;
  }
  
  public static d w(Intent paramIntent)
  {
    AppMethodBeat.i(125675);
    paramIntent = c(paramIntent, "intent_key_StatisticsOplog");
    AppMethodBeat.o(125675);
    return paramIntent;
  }
  
  public final d Dn(String paramString)
  {
    AppMethodBeat.i(125662);
    if (!aHV())
    {
      AppMethodBeat.o(125662);
      return this;
    }
    if (this.hTP.length() == 0) {
      if (bs.isNullOrNil(paramString)) {
        this.hTP.append(" ");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125662);
      return this;
      this.hTP.append(paramString);
      continue;
      this.hTP.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final d Do(String paramString)
  {
    AppMethodBeat.i(125664);
    if (!aHV())
    {
      AppMethodBeat.o(125664);
      return this;
    }
    if (this.hTQ.length() == 0) {
      this.hTQ.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125664);
      return this;
      this.hTQ.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final d Dp(String paramString)
  {
    AppMethodBeat.i(125667);
    if (!aHV())
    {
      AppMethodBeat.o(125667);
      return this;
    }
    if (this.hTR.length() == 0) {
      this.hTR.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125667);
      return this;
      this.hTR.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final byte[] aCd()
  {
    AppMethodBeat.i(125672);
    Object localObject = new dcr();
    ((dcr)localObject).opType = this.opType;
    ((dcr)localObject).hTO = this.hTO;
    ((dcr)localObject).hTL = this.hTL;
    ((dcr)localObject).timeStamp = this.timeStamp;
    ((dcr)localObject).hTM = this.hTM;
    ((dcr)localObject).hTN = this.hTN;
    ((dcr)localObject).FMn = this.hTP.toString();
    ((dcr)localObject).FMo = this.hTS.toString();
    ((dcr)localObject).FMp = this.hTQ.toString();
    ((dcr)localObject).FMq = this.hTR.toString();
    try
    {
      localObject = ((dcr)localObject).toByteArray();
      AppMethodBeat.o(125672);
      return localObject;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.StatisticsOplog", "putIntent " + localException.getMessage());
      AppMethodBeat.o(125672);
    }
    return null;
  }
  
  public final boolean aHV()
  {
    boolean bool2 = true;
    int i = e.hTV;
    boolean bool1;
    if (i == 0) {
      bool1 = false;
    }
    label63:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (i != 1) {
                  break label63;
                }
                if (this.opType < 501) {
                  break;
                }
                bool1 = bool2;
              } while (this.opType <= 700);
              if (this.opType < 701) {
                break;
              }
              bool1 = bool2;
            } while (this.opType <= 1000);
            if ((i != 2) || (this.opType < 701)) {
              break;
            }
            bool1 = bool2;
          } while (this.opType <= 1000);
          if ((i != 3) || (this.opType < 501)) {
            break;
          }
          bool1 = bool2;
        } while (this.opType <= 700);
        if (i != 4) {
          break label166;
        }
        if (this.opType < 701) {
          break;
        }
        bool1 = bool2;
      } while (this.opType <= 1000);
      if (this.opType < 501) {
        break;
      }
      bool1 = bool2;
    } while (this.opType <= 700);
    label166:
    return false;
  }
  
  public final d aHW()
  {
    AppMethodBeat.i(125665);
    this.hTQ = new StringBuffer();
    AppMethodBeat.o(125665);
    return this;
  }
  
  public final d aHX()
  {
    AppMethodBeat.i(125666);
    this.hTP = new StringBuffer();
    AppMethodBeat.o(125666);
    return this;
  }
  
  public final boolean aHZ()
  {
    AppMethodBeat.i(125671);
    if (!aHV())
    {
      AppMethodBeat.o(125671);
      return false;
    }
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125656);
        d.a(d.this);
        AppMethodBeat.o(125656);
      }
    }, "StatisticsOplog");
    AppMethodBeat.o(125671);
    return true;
  }
  
  public final void b(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(125673);
    byte[] arrayOfByte = aCd();
    if (arrayOfByte == null)
    {
      AppMethodBeat.o(125673);
      return;
    }
    paramIntent.putExtra(paramString, arrayOfByte);
    AppMethodBeat.o(125673);
  }
  
  public final d eQ(boolean paramBoolean)
  {
    AppMethodBeat.i(125668);
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = Dn((String)localObject);
      AppMethodBeat.o(125668);
      return localObject;
    }
  }
  
  public final boolean pu(int paramInt)
  {
    AppMethodBeat.i(125660);
    this.hTK = Integer.valueOf(paramInt);
    AppMethodBeat.o(125660);
    return true;
  }
  
  public final d pv(int paramInt)
  {
    AppMethodBeat.i(125663);
    d locald = Dn(String.valueOf(paramInt));
    AppMethodBeat.o(125663);
    return locald;
  }
  
  public final d pw(int paramInt)
  {
    AppMethodBeat.i(125669);
    if (!aHV())
    {
      AppMethodBeat.o(125669);
      return this;
    }
    if (this.hTQ.length() == 0) {
      this.hTQ.append(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(125669);
      return this;
      this.hTQ.append("||".concat(String.valueOf(paramInt)));
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(125661);
    if (!aHV())
    {
      AppMethodBeat.o(125661);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    this.hTM = hTT.incrementAndGet();
    AppMethodBeat.o(125661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.d
 * JD-Core Version:    0.7.0.1
 */