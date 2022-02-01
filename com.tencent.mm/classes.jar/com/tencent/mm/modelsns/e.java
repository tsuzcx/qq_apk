package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.atomic.AtomicInteger;

public final class e
{
  private static boolean inI;
  private static AtomicInteger iqi;
  public Object ipZ;
  public int iqa;
  public int iqb;
  public int iqc;
  public int iqd;
  public StringBuffer iqe;
  public StringBuffer iqf;
  public StringBuffer iqg;
  public StringBuffer iqh;
  public int opType;
  public long timeStamp;
  
  static
  {
    AppMethodBeat.i(125679);
    inI = false;
    iqi = new AtomicInteger(0);
    AppMethodBeat.o(125679);
  }
  
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125659);
    this.ipZ = null;
    this.iqa = 1;
    this.opType = 0;
    this.iqe = new StringBuffer();
    this.iqf = new StringBuffer();
    this.iqg = new StringBuffer();
    this.iqh = new StringBuffer();
    this.opType = paramInt1;
    this.iqd = paramInt2;
    if (!aLD())
    {
      AppMethodBeat.o(125659);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    if (az.isWifi(ak.getContext())) {
      this.iqc = 4;
    }
    for (;;)
    {
      this.iqb = iqi.incrementAndGet();
      AppMethodBeat.o(125659);
      return;
      if (az.is4G(ak.getContext())) {
        this.iqc = 3;
      } else if (az.is3G(ak.getContext())) {
        this.iqc = 2;
      } else if (az.is2G(ak.getContext())) {
        this.iqc = 1;
      } else {
        this.iqc = 0;
      }
    }
  }
  
  public static void aLG()
  {
    AppMethodBeat.i(125670);
    ae.i("MicroMsg.StatisticsOplog", "wait op");
    AppMethodBeat.o(125670);
  }
  
  private static e ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125677);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(125677);
      return null;
    }
    diz localdiz = new diz();
    try
    {
      localdiz.parseFrom(paramArrayOfByte);
      paramArrayOfByte = new e(localdiz.opType, localdiz.iqd);
      paramArrayOfByte.iqa = localdiz.iqa;
      paramArrayOfByte.timeStamp = localdiz.timeStamp;
      paramArrayOfByte.iqb = localdiz.iqb;
      paramArrayOfByte.iqc = localdiz.iqc;
      paramArrayOfByte.iqe = new StringBuffer(localdiz.HQE);
      paramArrayOfByte.iqh = new StringBuffer(localdiz.HQF);
      paramArrayOfByte.iqf = new StringBuffer(localdiz.HQG);
      paramArrayOfByte.iqg = new StringBuffer(localdiz.HQH);
      AppMethodBeat.o(125677);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.StatisticsOplog", "putIntent " + paramArrayOfByte.getMessage());
      AppMethodBeat.o(125677);
    }
    return null;
  }
  
  public static e c(Intent paramIntent, String paramString)
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
  
  public static e pY(int paramInt)
  {
    AppMethodBeat.i(125657);
    e locale = new e(paramInt, 1);
    AppMethodBeat.o(125657);
    return locale;
  }
  
  public static e pZ(int paramInt)
  {
    AppMethodBeat.i(125658);
    e locale = new e(paramInt, 4);
    AppMethodBeat.o(125658);
    return locale;
  }
  
  public static e w(Intent paramIntent)
  {
    AppMethodBeat.i(125675);
    paramIntent = c(paramIntent, "intent_key_StatisticsOplog");
    AppMethodBeat.o(125675);
    return paramIntent;
  }
  
  public static e w(Bundle paramBundle)
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
  
  public final e GU(String paramString)
  {
    AppMethodBeat.i(125662);
    if (!aLD())
    {
      AppMethodBeat.o(125662);
      return this;
    }
    if (this.iqe.length() == 0) {
      if (bu.isNullOrNil(paramString)) {
        this.iqe.append(" ");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125662);
      return this;
      this.iqe.append(paramString);
      continue;
      this.iqe.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final e GV(String paramString)
  {
    AppMethodBeat.i(125664);
    if (!aLD())
    {
      AppMethodBeat.o(125664);
      return this;
    }
    if (this.iqf.length() == 0) {
      this.iqf.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125664);
      return this;
      this.iqf.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final e GW(String paramString)
  {
    AppMethodBeat.i(125667);
    if (!aLD())
    {
      AppMethodBeat.o(125667);
      return this;
    }
    if (this.iqg.length() == 0) {
      this.iqg.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125667);
      return this;
      this.iqg.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final byte[] aFw()
  {
    AppMethodBeat.i(125672);
    Object localObject = new diz();
    ((diz)localObject).opType = this.opType;
    ((diz)localObject).iqd = this.iqd;
    ((diz)localObject).iqa = this.iqa;
    ((diz)localObject).timeStamp = this.timeStamp;
    ((diz)localObject).iqb = this.iqb;
    ((diz)localObject).iqc = this.iqc;
    ((diz)localObject).HQE = this.iqe.toString();
    ((diz)localObject).HQF = this.iqh.toString();
    ((diz)localObject).HQG = this.iqf.toString();
    ((diz)localObject).HQH = this.iqg.toString();
    try
    {
      localObject = ((diz)localObject).toByteArray();
      AppMethodBeat.o(125672);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.StatisticsOplog", "putIntent " + localException.getMessage());
      AppMethodBeat.o(125672);
    }
    return null;
  }
  
  public final boolean aLD()
  {
    boolean bool2 = true;
    int i = f.iqk;
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
  
  public final e aLE()
  {
    AppMethodBeat.i(125665);
    this.iqf = new StringBuffer();
    AppMethodBeat.o(125665);
    return this;
  }
  
  public final e aLF()
  {
    AppMethodBeat.i(125666);
    this.iqe = new StringBuffer();
    AppMethodBeat.o(125666);
    return this;
  }
  
  public final boolean aLH()
  {
    AppMethodBeat.i(125671);
    if (!aLD())
    {
      AppMethodBeat.o(125671);
      return false;
    }
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125656);
        e.a(e.this);
        AppMethodBeat.o(125656);
      }
    }, "StatisticsOplog");
    AppMethodBeat.o(125671);
    return true;
  }
  
  public final void b(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(125673);
    byte[] arrayOfByte = aFw();
    if (arrayOfByte == null)
    {
      AppMethodBeat.o(125673);
      return;
    }
    paramIntent.putExtra(paramString, arrayOfByte);
    AppMethodBeat.o(125673);
  }
  
  public final e eV(boolean paramBoolean)
  {
    AppMethodBeat.i(125668);
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = GU((String)localObject);
      AppMethodBeat.o(125668);
      return localObject;
    }
  }
  
  public final boolean qa(int paramInt)
  {
    AppMethodBeat.i(125660);
    this.ipZ = Integer.valueOf(paramInt);
    AppMethodBeat.o(125660);
    return true;
  }
  
  public final e qb(int paramInt)
  {
    AppMethodBeat.i(125663);
    e locale = GU(String.valueOf(paramInt));
    AppMethodBeat.o(125663);
    return locale;
  }
  
  public final e qc(int paramInt)
  {
    AppMethodBeat.i(125669);
    if (!aLD())
    {
      AppMethodBeat.o(125669);
      return this;
    }
    if (this.iqf.length() == 0) {
      this.iqf.append(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(125669);
      return this;
      this.iqf.append("||".concat(String.valueOf(paramInt)));
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(125661);
    if (!aLD())
    {
      AppMethodBeat.o(125661);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    this.iqb = iqi.incrementAndGet();
    AppMethodBeat.o(125661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.e
 * JD-Core Version:    0.7.0.1
 */