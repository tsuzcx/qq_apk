package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static boolean fOd;
  private static AtomicInteger fQK;
  public Object fQB;
  public int fQC;
  public int fQD;
  public int fQE;
  public int fQF;
  public StringBuffer fQG;
  public StringBuffer fQH;
  public StringBuffer fQI;
  public StringBuffer fQJ;
  public int opType;
  public long timeStamp;
  
  static
  {
    AppMethodBeat.i(94480);
    fOd = false;
    fQK = new AtomicInteger(0);
    AppMethodBeat.o(94480);
  }
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94460);
    this.fQB = null;
    this.fQC = 1;
    this.opType = 0;
    this.fQG = new StringBuffer();
    this.fQH = new StringBuffer();
    this.fQI = new StringBuffer();
    this.fQJ = new StringBuffer();
    this.opType = paramInt1;
    this.fQF = paramInt2;
    if (!aka())
    {
      AppMethodBeat.o(94460);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    if (at.isWifi(ah.getContext())) {
      this.fQE = 4;
    }
    for (;;)
    {
      this.fQD = fQK.incrementAndGet();
      AppMethodBeat.o(94460);
      return;
      if (at.is4G(ah.getContext())) {
        this.fQE = 3;
      } else if (at.is3G(ah.getContext())) {
        this.fQE = 2;
      } else if (at.is2G(ah.getContext())) {
        this.fQE = 1;
      } else {
        this.fQE = 0;
      }
    }
  }
  
  private static b V(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94478);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(94478);
      return null;
    }
    cge localcge = new cge();
    try
    {
      localcge.parseFrom(paramArrayOfByte);
      paramArrayOfByte = new b(localcge.opType, localcge.fQF);
      paramArrayOfByte.fQC = localcge.fQC;
      paramArrayOfByte.timeStamp = localcge.timeStamp;
      paramArrayOfByte.fQD = localcge.fQD;
      paramArrayOfByte.fQE = localcge.fQE;
      paramArrayOfByte.fQG = new StringBuffer(localcge.xQT);
      paramArrayOfByte.fQJ = new StringBuffer(localcge.xQU);
      paramArrayOfByte.fQH = new StringBuffer(localcge.xQV);
      paramArrayOfByte.fQI = new StringBuffer(localcge.xQW);
      AppMethodBeat.o(94478);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.StatisticsOplog", "putIntent " + paramArrayOfByte.getMessage());
      AppMethodBeat.o(94478);
    }
    return null;
  }
  
  public static void akd()
  {
    AppMethodBeat.i(94471);
    ab.i("MicroMsg.StatisticsOplog", "wait op");
    AppMethodBeat.o(94471);
  }
  
  public static b c(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(94477);
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null)
    {
      AppMethodBeat.o(94477);
      return null;
    }
    paramIntent = V(paramIntent);
    AppMethodBeat.o(94477);
    return paramIntent;
  }
  
  public static b lV(int paramInt)
  {
    AppMethodBeat.i(94458);
    b localb = new b(paramInt, 1);
    AppMethodBeat.o(94458);
    return localb;
  }
  
  public static b lW(int paramInt)
  {
    AppMethodBeat.i(94459);
    b localb = new b(paramInt, 4);
    AppMethodBeat.o(94459);
    return localb;
  }
  
  public static b s(Bundle paramBundle)
  {
    AppMethodBeat.i(94475);
    paramBundle = paramBundle.getByteArray("intent_key_StatisticsOplog");
    if (paramBundle == null)
    {
      AppMethodBeat.o(94475);
      return null;
    }
    paramBundle = V(paramBundle);
    AppMethodBeat.o(94475);
    return paramBundle;
  }
  
  public static b w(Intent paramIntent)
  {
    AppMethodBeat.i(94476);
    paramIntent = c(paramIntent, "intent_key_StatisticsOplog");
    AppMethodBeat.o(94476);
    return paramIntent;
  }
  
  public final byte[] adM()
  {
    AppMethodBeat.i(94473);
    Object localObject = new cge();
    ((cge)localObject).opType = this.opType;
    ((cge)localObject).fQF = this.fQF;
    ((cge)localObject).fQC = this.fQC;
    ((cge)localObject).timeStamp = this.timeStamp;
    ((cge)localObject).fQD = this.fQD;
    ((cge)localObject).fQE = this.fQE;
    ((cge)localObject).xQT = this.fQG.toString();
    ((cge)localObject).xQU = this.fQJ.toString();
    ((cge)localObject).xQV = this.fQH.toString();
    ((cge)localObject).xQW = this.fQI.toString();
    try
    {
      localObject = ((cge)localObject).toByteArray();
      AppMethodBeat.o(94473);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.StatisticsOplog", "putIntent " + localException.getMessage());
      AppMethodBeat.o(94473);
    }
    return null;
  }
  
  public final boolean aka()
  {
    boolean bool2 = true;
    int i = c.fQM;
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
  
  public final b akb()
  {
    AppMethodBeat.i(94466);
    this.fQH = new StringBuffer();
    AppMethodBeat.o(94466);
    return this;
  }
  
  public final b akc()
  {
    AppMethodBeat.i(94467);
    this.fQG = new StringBuffer();
    AppMethodBeat.o(94467);
    return this;
  }
  
  public final boolean ake()
  {
    AppMethodBeat.i(94472);
    if (!aka())
    {
      AppMethodBeat.o(94472);
      return false;
    }
    d.post(new b.1(this), "StatisticsOplog");
    AppMethodBeat.o(94472);
    return true;
  }
  
  public final void b(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(94474);
    byte[] arrayOfByte = adM();
    if (arrayOfByte == null)
    {
      AppMethodBeat.o(94474);
      return;
    }
    paramIntent.putExtra(paramString, arrayOfByte);
    AppMethodBeat.o(94474);
  }
  
  public final b de(boolean paramBoolean)
  {
    AppMethodBeat.i(94469);
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = uv((String)localObject);
      AppMethodBeat.o(94469);
      return localObject;
    }
  }
  
  public final boolean lX(int paramInt)
  {
    AppMethodBeat.i(94461);
    this.fQB = Integer.valueOf(paramInt);
    AppMethodBeat.o(94461);
    return true;
  }
  
  public final b lY(int paramInt)
  {
    AppMethodBeat.i(94464);
    b localb = uv(String.valueOf(paramInt));
    AppMethodBeat.o(94464);
    return localb;
  }
  
  public final b lZ(int paramInt)
  {
    AppMethodBeat.i(94470);
    if (!aka())
    {
      AppMethodBeat.o(94470);
      return this;
    }
    if (this.fQH.length() == 0) {
      this.fQH.append(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(94470);
      return this;
      this.fQH.append("||".concat(String.valueOf(paramInt)));
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(94462);
    if (!aka())
    {
      AppMethodBeat.o(94462);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    this.fQD = fQK.incrementAndGet();
    AppMethodBeat.o(94462);
  }
  
  public final b uv(String paramString)
  {
    AppMethodBeat.i(94463);
    if (!aka())
    {
      AppMethodBeat.o(94463);
      return this;
    }
    if (this.fQG.length() == 0) {
      if (bo.isNullOrNil(paramString)) {
        this.fQG.append(" ");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(94463);
      return this;
      this.fQG.append(paramString);
      continue;
      this.fQG.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final b uw(String paramString)
  {
    AppMethodBeat.i(94465);
    if (!aka())
    {
      AppMethodBeat.o(94465);
      return this;
    }
    if (this.fQH.length() == 0) {
      this.fQH.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(94465);
      return this;
      this.fQH.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final b ux(String paramString)
  {
    AppMethodBeat.i(94468);
    if (!aka())
    {
      AppMethodBeat.o(94468);
      return this;
    }
    if (this.fQI.length() == 0) {
      this.fQI.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(94468);
      return this;
      this.fQI.append("||".concat(String.valueOf(paramString)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.b
 * JD-Core Version:    0.7.0.1
 */