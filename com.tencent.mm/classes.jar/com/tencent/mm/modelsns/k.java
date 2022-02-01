package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ecl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.concurrent.atomic.AtomicInteger;

public final class k
{
  private static boolean jiQ;
  private static AtomicInteger jlt;
  public Object jlk;
  public int jll;
  public int jlm;
  public int jln;
  public int jlo;
  public StringBuffer jlp;
  public StringBuffer jlq;
  public StringBuffer jlr;
  public StringBuffer jls;
  public int opType;
  public long timeStamp;
  
  static
  {
    AppMethodBeat.i(125679);
    jiQ = false;
    jlt = new AtomicInteger(0);
    AppMethodBeat.o(125679);
  }
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125659);
    this.jlk = null;
    this.jll = 1;
    this.opType = 0;
    this.jlp = new StringBuffer();
    this.jlq = new StringBuffer();
    this.jlr = new StringBuffer();
    this.jls = new StringBuffer();
    this.opType = paramInt1;
    this.jlo = paramInt2;
    if (!bfG())
    {
      AppMethodBeat.o(125659);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      this.jln = 4;
    }
    for (;;)
    {
      this.jlm = jlt.incrementAndGet();
      AppMethodBeat.o(125659);
      return;
      if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
        this.jln = 3;
      } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
        this.jln = 2;
      } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
        this.jln = 1;
      } else {
        this.jln = 0;
      }
    }
  }
  
  public static k C(Bundle paramBundle)
  {
    AppMethodBeat.i(125674);
    paramBundle = paramBundle.getByteArray("intent_key_StatisticsOplog");
    if (paramBundle == null)
    {
      AppMethodBeat.o(125674);
      return null;
    }
    paramBundle = ar(paramBundle);
    AppMethodBeat.o(125674);
    return paramBundle;
  }
  
  private static k ar(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125677);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(125677);
      return null;
    }
    ecl localecl = new ecl();
    try
    {
      localecl.parseFrom(paramArrayOfByte);
      paramArrayOfByte = new k(localecl.opType, localecl.jlo);
      paramArrayOfByte.jll = localecl.jll;
      paramArrayOfByte.timeStamp = localecl.timeStamp;
      paramArrayOfByte.jlm = localecl.jlm;
      paramArrayOfByte.jln = localecl.jln;
      paramArrayOfByte.jlp = new StringBuffer(localecl.NcC);
      paramArrayOfByte.jls = new StringBuffer(localecl.NcD);
      paramArrayOfByte.jlq = new StringBuffer(localecl.NcE);
      paramArrayOfByte.jlr = new StringBuffer(localecl.NcF);
      AppMethodBeat.o(125677);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.StatisticsOplog", "putIntent " + paramArrayOfByte.getMessage());
      AppMethodBeat.o(125677);
    }
    return null;
  }
  
  public static void bfJ()
  {
    AppMethodBeat.i(125670);
    Log.i("MicroMsg.StatisticsOplog", "wait op");
    AppMethodBeat.o(125670);
  }
  
  public static k c(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(125676);
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null)
    {
      AppMethodBeat.o(125676);
      return null;
    }
    paramIntent = ar(paramIntent);
    AppMethodBeat.o(125676);
    return paramIntent;
  }
  
  public static k tO(int paramInt)
  {
    AppMethodBeat.i(125657);
    k localk = new k(paramInt, 1);
    AppMethodBeat.o(125657);
    return localk;
  }
  
  public static k tP(int paramInt)
  {
    AppMethodBeat.i(125658);
    k localk = new k(paramInt, 4);
    AppMethodBeat.o(125658);
    return localk;
  }
  
  public static k w(Intent paramIntent)
  {
    AppMethodBeat.i(125675);
    paramIntent = c(paramIntent, "intent_key_StatisticsOplog");
    AppMethodBeat.o(125675);
    return paramIntent;
  }
  
  public final k PH(String paramString)
  {
    AppMethodBeat.i(125662);
    if (!bfG())
    {
      AppMethodBeat.o(125662);
      return this;
    }
    if (this.jlp.length() == 0) {
      if (Util.isNullOrNil(paramString)) {
        this.jlp.append(" ");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125662);
      return this;
      this.jlp.append(paramString);
      continue;
      this.jlp.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final k PI(String paramString)
  {
    AppMethodBeat.i(125664);
    if (!bfG())
    {
      AppMethodBeat.o(125664);
      return this;
    }
    if (this.jlq.length() == 0) {
      this.jlq.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125664);
      return this;
      this.jlq.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final k PJ(String paramString)
  {
    AppMethodBeat.i(125667);
    if (!bfG())
    {
      AppMethodBeat.o(125667);
      return this;
    }
    if (this.jlr.length() == 0) {
      this.jlr.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125667);
      return this;
      this.jlr.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final byte[] aZm()
  {
    AppMethodBeat.i(125672);
    Object localObject = new ecl();
    ((ecl)localObject).opType = this.opType;
    ((ecl)localObject).jlo = this.jlo;
    ((ecl)localObject).jll = this.jll;
    ((ecl)localObject).timeStamp = this.timeStamp;
    ((ecl)localObject).jlm = this.jlm;
    ((ecl)localObject).jln = this.jln;
    ((ecl)localObject).NcC = this.jlp.toString();
    ((ecl)localObject).NcD = this.jls.toString();
    ((ecl)localObject).NcE = this.jlq.toString();
    ((ecl)localObject).NcF = this.jlr.toString();
    try
    {
      localObject = ((ecl)localObject).toByteArray();
      AppMethodBeat.o(125672);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.StatisticsOplog", "putIntent " + localException.getMessage());
      AppMethodBeat.o(125672);
    }
    return null;
  }
  
  public final void b(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(125673);
    byte[] arrayOfByte = aZm();
    if (arrayOfByte == null)
    {
      AppMethodBeat.o(125673);
      return;
    }
    paramIntent.putExtra(paramString, arrayOfByte);
    AppMethodBeat.o(125673);
  }
  
  public final boolean bfG()
  {
    boolean bool2 = true;
    int i = l.jlv;
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
  
  public final k bfH()
  {
    AppMethodBeat.i(125665);
    this.jlq = new StringBuffer();
    AppMethodBeat.o(125665);
    return this;
  }
  
  public final k bfI()
  {
    AppMethodBeat.i(125666);
    this.jlp = new StringBuffer();
    AppMethodBeat.o(125666);
    return this;
  }
  
  public final boolean bfK()
  {
    AppMethodBeat.i(125671);
    if (!bfG())
    {
      AppMethodBeat.o(125671);
      return false;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125656);
        k.a(k.this);
        AppMethodBeat.o(125656);
      }
    }, "StatisticsOplog");
    AppMethodBeat.o(125671);
    return true;
  }
  
  public final k fL(boolean paramBoolean)
  {
    AppMethodBeat.i(125668);
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = PH((String)localObject);
      AppMethodBeat.o(125668);
      return localObject;
    }
  }
  
  public final boolean tQ(int paramInt)
  {
    AppMethodBeat.i(125660);
    this.jlk = Integer.valueOf(paramInt);
    AppMethodBeat.o(125660);
    return true;
  }
  
  public final k tR(int paramInt)
  {
    AppMethodBeat.i(125663);
    k localk = PH(String.valueOf(paramInt));
    AppMethodBeat.o(125663);
    return localk;
  }
  
  public final k tS(int paramInt)
  {
    AppMethodBeat.i(125669);
    if (!bfG())
    {
      AppMethodBeat.o(125669);
      return this;
    }
    if (this.jlq.length() == 0) {
      this.jlq.append(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(125669);
      return this;
      this.jlq.append("||".concat(String.valueOf(paramInt)));
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(125661);
    if (!bfG())
    {
      AppMethodBeat.o(125661);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    this.jlm = jlt.incrementAndGet();
    AppMethodBeat.o(125661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsns.k
 * JD-Core Version:    0.7.0.1
 */