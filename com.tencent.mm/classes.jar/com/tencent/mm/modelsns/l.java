package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.emm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private static boolean lYN;
  private static AtomicInteger mbv;
  public Object mbn;
  public int mbo;
  public int mbp;
  public int mbq;
  public StringBuffer mbr;
  public StringBuffer mbs;
  public StringBuffer mbt;
  public StringBuffer mbu;
  public int opType;
  public int page;
  public long timeStamp;
  
  static
  {
    AppMethodBeat.i(125679);
    lYN = false;
    mbv = new AtomicInteger(0);
    AppMethodBeat.o(125679);
  }
  
  public l(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125659);
    this.mbn = null;
    this.mbo = 1;
    this.opType = 0;
    this.mbr = new StringBuffer();
    this.mbs = new StringBuffer();
    this.mbt = new StringBuffer();
    this.mbu = new StringBuffer();
    this.opType = paramInt1;
    this.page = paramInt2;
    if (!boW())
    {
      AppMethodBeat.o(125659);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      this.mbq = 4;
    }
    for (;;)
    {
      this.mbp = mbv.incrementAndGet();
      AppMethodBeat.o(125659);
      return;
      if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
        this.mbq = 3;
      } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
        this.mbq = 2;
      } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
        this.mbq = 1;
      } else {
        this.mbq = 0;
      }
    }
  }
  
  public static l I(Bundle paramBundle)
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
    emm localemm = new emm();
    try
    {
      localemm.parseFrom(paramArrayOfByte);
      paramArrayOfByte = new l(localemm.opType, localemm.page);
      paramArrayOfByte.mbo = localemm.mbo;
      paramArrayOfByte.timeStamp = localemm.timeStamp;
      paramArrayOfByte.mbp = localemm.mbp;
      paramArrayOfByte.mbq = localemm.mbq;
      paramArrayOfByte.mbr = new StringBuffer(localemm.UoZ);
      paramArrayOfByte.mbu = new StringBuffer(localemm.Upa);
      paramArrayOfByte.mbs = new StringBuffer(localemm.Upb);
      paramArrayOfByte.mbt = new StringBuffer(localemm.Upc);
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
  
  public static void boZ()
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
  
  public static l x(Intent paramIntent)
  {
    AppMethodBeat.i(125675);
    paramIntent = c(paramIntent, "intent_key_StatisticsOplog");
    AppMethodBeat.o(125675);
    return paramIntent;
  }
  
  public final l Xf(String paramString)
  {
    AppMethodBeat.i(125662);
    if (!boW())
    {
      AppMethodBeat.o(125662);
      return this;
    }
    if (this.mbr.length() == 0) {
      if (Util.isNullOrNil(paramString)) {
        this.mbr.append(" ");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125662);
      return this;
      this.mbr.append(paramString);
      continue;
      this.mbr.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final l Xg(String paramString)
  {
    AppMethodBeat.i(125664);
    if (!boW())
    {
      AppMethodBeat.o(125664);
      return this;
    }
    if (this.mbs.length() == 0) {
      this.mbs.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125664);
      return this;
      this.mbs.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final l Xh(String paramString)
  {
    AppMethodBeat.i(125667);
    if (!boW())
    {
      AppMethodBeat.o(125667);
      return this;
    }
    if (this.mbt.length() == 0) {
      this.mbt.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125667);
      return this;
      this.mbt.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final void b(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(125673);
    byte[] arrayOfByte = biB();
    if (arrayOfByte == null)
    {
      AppMethodBeat.o(125673);
      return;
    }
    paramIntent.putExtra(paramString, arrayOfByte);
    AppMethodBeat.o(125673);
  }
  
  public final byte[] biB()
  {
    AppMethodBeat.i(125672);
    Object localObject = new emm();
    ((emm)localObject).opType = this.opType;
    ((emm)localObject).page = this.page;
    ((emm)localObject).mbo = this.mbo;
    ((emm)localObject).timeStamp = this.timeStamp;
    ((emm)localObject).mbp = this.mbp;
    ((emm)localObject).mbq = this.mbq;
    ((emm)localObject).UoZ = this.mbr.toString();
    ((emm)localObject).Upa = this.mbu.toString();
    ((emm)localObject).Upb = this.mbs.toString();
    ((emm)localObject).Upc = this.mbt.toString();
    try
    {
      localObject = ((emm)localObject).toByteArray();
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
  
  public final boolean boW()
  {
    boolean bool2 = true;
    int i = m.mbx;
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
  
  public final l boX()
  {
    AppMethodBeat.i(125665);
    this.mbs = new StringBuffer();
    AppMethodBeat.o(125665);
    return this;
  }
  
  public final l boY()
  {
    AppMethodBeat.i(125666);
    this.mbr = new StringBuffer();
    AppMethodBeat.o(125666);
    return this;
  }
  
  public final boolean bpa()
  {
    AppMethodBeat.i(125671);
    if (!boW())
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
  
  public final l gx(boolean paramBoolean)
  {
    AppMethodBeat.i(125668);
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = Xf((String)localObject);
      AppMethodBeat.o(125668);
      return localObject;
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(125661);
    if (!boW())
    {
      AppMethodBeat.o(125661);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    this.mbp = mbv.incrementAndGet();
    AppMethodBeat.o(125661);
  }
  
  public final boolean wQ(int paramInt)
  {
    AppMethodBeat.i(125660);
    this.mbn = Integer.valueOf(paramInt);
    AppMethodBeat.o(125660);
    return true;
  }
  
  public final l wR(int paramInt)
  {
    AppMethodBeat.i(125663);
    l locall = Xf(String.valueOf(paramInt));
    AppMethodBeat.o(125663);
    return locall;
  }
  
  public final l wS(int paramInt)
  {
    AppMethodBeat.i(125669);
    if (!boW())
    {
      AppMethodBeat.o(125669);
      return this;
    }
    if (this.mbs.length() == 0) {
      this.mbs.append(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(125669);
      return this;
      this.mbs.append("||".concat(String.valueOf(paramInt)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.l
 * JD-Core Version:    0.7.0.1
 */