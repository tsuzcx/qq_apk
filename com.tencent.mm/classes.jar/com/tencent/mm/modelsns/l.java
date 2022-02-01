package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fhk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private static boolean oRS;
  private static AtomicInteger oUq;
  public Object oUh;
  public int oUi;
  public int oUj;
  public int oUk;
  public int oUl;
  public StringBuffer oUm;
  public StringBuffer oUn;
  public StringBuffer oUo;
  public StringBuffer oUp;
  public int opType;
  public long timeStamp;
  
  static
  {
    AppMethodBeat.i(125679);
    oRS = false;
    oUq = new AtomicInteger(0);
    AppMethodBeat.o(125679);
  }
  
  public l(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125659);
    this.oUh = null;
    this.oUi = 1;
    this.opType = 0;
    this.oUm = new StringBuffer();
    this.oUn = new StringBuffer();
    this.oUo = new StringBuffer();
    this.oUp = new StringBuffer();
    this.opType = paramInt1;
    this.oUl = paramInt2;
    if (!bMD())
    {
      AppMethodBeat.o(125659);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      this.oUk = 4;
    }
    for (;;)
    {
      this.oUj = oUq.incrementAndGet();
      AppMethodBeat.o(125659);
      return;
      if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
        this.oUk = 3;
      } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
        this.oUk = 2;
      } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
        this.oUk = 1;
      } else {
        this.oUk = 0;
      }
    }
  }
  
  public static l P(Bundle paramBundle)
  {
    AppMethodBeat.i(125674);
    paramBundle = paramBundle.getByteArray("intent_key_StatisticsOplog");
    if (paramBundle == null)
    {
      AppMethodBeat.o(125674);
      return null;
    }
    paramBundle = aB(paramBundle);
    AppMethodBeat.o(125674);
    return paramBundle;
  }
  
  private static l aB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125677);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(125677);
      return null;
    }
    fhk localfhk = new fhk();
    try
    {
      localfhk.parseFrom(paramArrayOfByte);
      paramArrayOfByte = new l(localfhk.opType, localfhk.oUl);
      paramArrayOfByte.oUi = localfhk.oUi;
      paramArrayOfByte.timeStamp = localfhk.timeStamp;
      paramArrayOfByte.oUj = localfhk.oUj;
      paramArrayOfByte.oUk = localfhk.oUk;
      paramArrayOfByte.oUm = new StringBuffer(localfhk.abHX);
      paramArrayOfByte.oUp = new StringBuffer(localfhk.abHY);
      paramArrayOfByte.oUn = new StringBuffer(localfhk.abHZ);
      paramArrayOfByte.oUo = new StringBuffer(localfhk.abIa);
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
  
  public static void bMG()
  {
    AppMethodBeat.i(125670);
    Log.i("MicroMsg.StatisticsOplog", "wait op");
    AppMethodBeat.o(125670);
  }
  
  public static l c(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(125676);
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null)
    {
      AppMethodBeat.o(125676);
      return null;
    }
    paramIntent = aB(paramIntent);
    AppMethodBeat.o(125676);
    return paramIntent;
  }
  
  public static l wO(int paramInt)
  {
    AppMethodBeat.i(125657);
    l locall = new l(paramInt, 1);
    AppMethodBeat.o(125657);
    return locall;
  }
  
  public static l wP(int paramInt)
  {
    AppMethodBeat.i(125658);
    l locall = new l(paramInt, 4);
    AppMethodBeat.o(125658);
    return locall;
  }
  
  public static l y(Intent paramIntent)
  {
    AppMethodBeat.i(125675);
    paramIntent = c(paramIntent, "intent_key_StatisticsOplog");
    AppMethodBeat.o(125675);
    return paramIntent;
  }
  
  public final l Ph(String paramString)
  {
    AppMethodBeat.i(125662);
    if (!bMD())
    {
      AppMethodBeat.o(125662);
      return this;
    }
    if (this.oUm.length() == 0) {
      if (Util.isNullOrNil(paramString)) {
        this.oUm.append(" ");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125662);
      return this;
      this.oUm.append(paramString);
      continue;
      this.oUm.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final l Pi(String paramString)
  {
    AppMethodBeat.i(125664);
    if (!bMD())
    {
      AppMethodBeat.o(125664);
      return this;
    }
    if (this.oUn.length() == 0) {
      this.oUn.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125664);
      return this;
      this.oUn.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final l Pj(String paramString)
  {
    AppMethodBeat.i(125667);
    if (!bMD())
    {
      AppMethodBeat.o(125667);
      return this;
    }
    if (this.oUo.length() == 0) {
      this.oUo.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125667);
      return this;
      this.oUo.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final void b(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(125673);
    byte[] arrayOfByte = bGl();
    if (arrayOfByte == null)
    {
      AppMethodBeat.o(125673);
      return;
    }
    paramIntent.putExtra(paramString, arrayOfByte);
    AppMethodBeat.o(125673);
  }
  
  public final byte[] bGl()
  {
    AppMethodBeat.i(125672);
    Object localObject = new fhk();
    ((fhk)localObject).opType = this.opType;
    ((fhk)localObject).oUl = this.oUl;
    ((fhk)localObject).oUi = this.oUi;
    ((fhk)localObject).timeStamp = this.timeStamp;
    ((fhk)localObject).oUj = this.oUj;
    ((fhk)localObject).oUk = this.oUk;
    ((fhk)localObject).abHX = this.oUm.toString();
    ((fhk)localObject).abHY = this.oUp.toString();
    ((fhk)localObject).abHZ = this.oUn.toString();
    ((fhk)localObject).abIa = this.oUo.toString();
    try
    {
      localObject = ((fhk)localObject).toByteArray();
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
  
  public final boolean bMD()
  {
    boolean bool2 = true;
    int i = m.oUs;
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
  
  public final l bME()
  {
    AppMethodBeat.i(125665);
    this.oUn = new StringBuffer();
    AppMethodBeat.o(125665);
    return this;
  }
  
  public final l bMF()
  {
    AppMethodBeat.i(125666);
    this.oUm = new StringBuffer();
    AppMethodBeat.o(125666);
    return this;
  }
  
  public final boolean bMH()
  {
    AppMethodBeat.i(125671);
    if (!bMD())
    {
      AppMethodBeat.o(125671);
      return false;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125656);
        l.a(l.this);
        AppMethodBeat.o(125656);
      }
    }, "StatisticsOplog");
    AppMethodBeat.o(125671);
    return true;
  }
  
  public final l hm(boolean paramBoolean)
  {
    AppMethodBeat.i(125668);
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = Ph((String)localObject);
      AppMethodBeat.o(125668);
      return localObject;
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(125661);
    if (!bMD())
    {
      AppMethodBeat.o(125661);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    this.oUj = oUq.incrementAndGet();
    AppMethodBeat.o(125661);
  }
  
  public final boolean wQ(int paramInt)
  {
    AppMethodBeat.i(125660);
    this.oUh = Integer.valueOf(paramInt);
    AppMethodBeat.o(125660);
    return true;
  }
  
  public final l wR(int paramInt)
  {
    AppMethodBeat.i(125663);
    l locall = Ph(String.valueOf(paramInt));
    AppMethodBeat.o(125663);
    return locall;
  }
  
  public final l wS(int paramInt)
  {
    AppMethodBeat.i(125669);
    if (!bMD())
    {
      AppMethodBeat.o(125669);
      return this;
    }
    if (this.oUn.length() == 0) {
      this.oUn.append(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(125669);
      return this;
      this.oUn.append("||".concat(String.valueOf(paramInt)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.l
 * JD-Core Version:    0.7.0.1
 */