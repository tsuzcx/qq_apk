package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.protocal.c.bvl;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static AtomicInteger eAR = new AtomicInteger(0);
  private static boolean eyq = false;
  public Object eAI = null;
  public int eAJ = 1;
  public int eAK;
  public int eAL;
  public int eAM;
  public StringBuffer eAN = new StringBuffer();
  public StringBuffer eAO = new StringBuffer();
  public StringBuffer eAP = new StringBuffer();
  public StringBuffer eAQ = new StringBuffer();
  public int opType = 0;
  public long timeStamp;
  
  public b(int paramInt1, int paramInt2)
  {
    this.opType = paramInt1;
    this.eAM = paramInt2;
    if (!QT()) {
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    if (aq.isWifi(ae.getContext())) {
      this.eAL = 4;
    }
    for (;;)
    {
      this.eAK = eAR.incrementAndGet();
      return;
      if (aq.is4G(ae.getContext())) {
        this.eAL = 3;
      } else if (aq.is3G(ae.getContext())) {
        this.eAL = 2;
      } else if (aq.is2G(ae.getContext())) {
        this.eAL = 1;
      } else {
        this.eAL = 0;
      }
    }
  }
  
  private static b F(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    bvl localbvl = new bvl();
    try
    {
      localbvl.aH(paramArrayOfByte);
      paramArrayOfByte = new b(localbvl.opType, localbvl.eAM);
      paramArrayOfByte.eAJ = localbvl.eAJ;
      paramArrayOfByte.timeStamp = localbvl.timeStamp;
      paramArrayOfByte.eAK = localbvl.eAK;
      paramArrayOfByte.eAL = localbvl.eAL;
      paramArrayOfByte.eAN = new StringBuffer(localbvl.tMh);
      paramArrayOfByte.eAQ = new StringBuffer(localbvl.tMi);
      paramArrayOfByte.eAO = new StringBuffer(localbvl.tMj);
      paramArrayOfByte.eAP = new StringBuffer(localbvl.tMk);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.StatisticsOplog", "putIntent " + paramArrayOfByte.getMessage());
    }
    return null;
  }
  
  public static void QW()
  {
    y.i("MicroMsg.StatisticsOplog", "wait op");
  }
  
  public static b c(Intent paramIntent, String paramString)
  {
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null) {
      return null;
    }
    return F(paramIntent);
  }
  
  public static b i(Intent paramIntent)
  {
    return c(paramIntent, "intent_key_StatisticsOplog");
  }
  
  public static b i(Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("intent_key_StatisticsOplog");
    if (paramBundle == null) {
      return null;
    }
    return F(paramBundle);
  }
  
  public static b jd(int paramInt)
  {
    return new b(paramInt, 1);
  }
  
  public static b je(int paramInt)
  {
    return new b(paramInt, 4);
  }
  
  public final byte[] KV()
  {
    Object localObject = new bvl();
    ((bvl)localObject).opType = this.opType;
    ((bvl)localObject).eAM = this.eAM;
    ((bvl)localObject).eAJ = this.eAJ;
    ((bvl)localObject).timeStamp = this.timeStamp;
    ((bvl)localObject).eAK = this.eAK;
    ((bvl)localObject).eAL = this.eAL;
    ((bvl)localObject).tMh = this.eAN.toString();
    ((bvl)localObject).tMi = this.eAQ.toString();
    ((bvl)localObject).tMj = this.eAO.toString();
    ((bvl)localObject).tMk = this.eAP.toString();
    try
    {
      localObject = ((bvl)localObject).toByteArray();
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.StatisticsOplog", "putIntent " + localException.getMessage());
    }
    return null;
  }
  
  public final boolean QT()
  {
    boolean bool2 = true;
    int i = c.eAT;
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
  
  public final b QU()
  {
    this.eAO = new StringBuffer();
    return this;
  }
  
  public final b QV()
  {
    this.eAN = new StringBuffer();
    return this;
  }
  
  public final boolean QX()
  {
    if (!QT()) {
      return false;
    }
    e.post(new b.1(this), "StatisticsOplog");
    return true;
  }
  
  public final void b(Intent paramIntent, String paramString)
  {
    byte[] arrayOfByte = KV();
    if (arrayOfByte == null) {
      return;
    }
    paramIntent.putExtra(paramString, arrayOfByte);
  }
  
  public final b cb(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0") {
      return ni(str);
    }
  }
  
  public final boolean jf(int paramInt)
  {
    this.eAI = Integer.valueOf(paramInt);
    return true;
  }
  
  public final b jg(int paramInt)
  {
    return ni(String.valueOf(paramInt));
  }
  
  public final b jh(int paramInt)
  {
    if (!QT()) {
      return this;
    }
    if (this.eAO.length() == 0)
    {
      this.eAO.append(paramInt);
      return this;
    }
    this.eAO.append("||" + paramInt);
    return this;
  }
  
  public final b ni(String paramString)
  {
    if (!QT()) {
      return this;
    }
    if (this.eAN.length() == 0)
    {
      if (bk.bl(paramString))
      {
        this.eAN.append(" ");
        return this;
      }
      this.eAN.append(paramString);
      return this;
    }
    this.eAN.append("||" + paramString);
    return this;
  }
  
  public final b nj(String paramString)
  {
    if (!QT()) {
      return this;
    }
    if (this.eAO.length() == 0)
    {
      this.eAO.append(paramString);
      return this;
    }
    this.eAO.append("||" + paramString);
    return this;
  }
  
  public final b nk(String paramString)
  {
    if (!QT()) {
      return this;
    }
    if (this.eAP.length() == 0)
    {
      this.eAP.append(paramString);
      return this;
    }
    this.eAP.append("||" + paramString);
    return this;
  }
  
  public final void update()
  {
    if (!QT()) {
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    this.eAK = eAR.incrementAndGet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.b
 * JD-Core Version:    0.7.0.1
 */