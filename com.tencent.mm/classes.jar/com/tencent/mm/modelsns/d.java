package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicInteger;

public final class d
{
  private static boolean hqZ;
  private static AtomicInteger htr;
  public Object hti;
  public int htj;
  public int htk;
  public int htl;
  public int htm;
  public StringBuffer htn;
  public StringBuffer hto;
  public StringBuffer htp;
  public StringBuffer htq;
  public int opType;
  public long timeStamp;
  
  static
  {
    AppMethodBeat.i(125679);
    hqZ = false;
    htr = new AtomicInteger(0);
    AppMethodBeat.o(125679);
  }
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125659);
    this.hti = null;
    this.htj = 1;
    this.opType = 0;
    this.htn = new StringBuffer();
    this.hto = new StringBuffer();
    this.htp = new StringBuffer();
    this.htq = new StringBuffer();
    this.opType = paramInt1;
    this.htm = paramInt2;
    if (!aBf())
    {
      AppMethodBeat.o(125659);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    if (ay.isWifi(aj.getContext())) {
      this.htl = 4;
    }
    for (;;)
    {
      this.htk = htr.incrementAndGet();
      AppMethodBeat.o(125659);
      return;
      if (ay.is4G(aj.getContext())) {
        this.htl = 3;
      } else if (ay.is3G(aj.getContext())) {
        this.htl = 2;
      } else if (ay.is2G(aj.getContext())) {
        this.htl = 1;
      } else {
        this.htl = 0;
      }
    }
  }
  
  public static void aBi()
  {
    AppMethodBeat.i(125670);
    ad.i("MicroMsg.StatisticsOplog", "wait op");
    AppMethodBeat.o(125670);
  }
  
  private static d ad(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125677);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(125677);
      return null;
    }
    cxf localcxf = new cxf();
    try
    {
      localcxf.parseFrom(paramArrayOfByte);
      paramArrayOfByte = new d(localcxf.opType, localcxf.htm);
      paramArrayOfByte.htj = localcxf.htj;
      paramArrayOfByte.timeStamp = localcxf.timeStamp;
      paramArrayOfByte.htk = localcxf.htk;
      paramArrayOfByte.htl = localcxf.htl;
      paramArrayOfByte.htn = new StringBuffer(localcxf.Epo);
      paramArrayOfByte.htq = new StringBuffer(localcxf.Epp);
      paramArrayOfByte.hto = new StringBuffer(localcxf.Epq);
      paramArrayOfByte.htp = new StringBuffer(localcxf.Epr);
      AppMethodBeat.o(125677);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.StatisticsOplog", "putIntent " + paramArrayOfByte.getMessage());
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
    paramIntent = ad(paramIntent);
    AppMethodBeat.o(125676);
    return paramIntent;
  }
  
  public static d oE(int paramInt)
  {
    AppMethodBeat.i(125657);
    d locald = new d(paramInt, 1);
    AppMethodBeat.o(125657);
    return locald;
  }
  
  public static d oF(int paramInt)
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
    paramBundle = ad(paramBundle);
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
  
  public final boolean aBf()
  {
    boolean bool2 = true;
    int i = e.htt;
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
  
  public final d aBg()
  {
    AppMethodBeat.i(125665);
    this.hto = new StringBuffer();
    AppMethodBeat.o(125665);
    return this;
  }
  
  public final d aBh()
  {
    AppMethodBeat.i(125666);
    this.htn = new StringBuffer();
    AppMethodBeat.o(125666);
    return this;
  }
  
  public final boolean aBj()
  {
    AppMethodBeat.i(125671);
    if (!aBf())
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
  
  public final byte[] avk()
  {
    AppMethodBeat.i(125672);
    Object localObject = new cxf();
    ((cxf)localObject).opType = this.opType;
    ((cxf)localObject).htm = this.htm;
    ((cxf)localObject).htj = this.htj;
    ((cxf)localObject).timeStamp = this.timeStamp;
    ((cxf)localObject).htk = this.htk;
    ((cxf)localObject).htl = this.htl;
    ((cxf)localObject).Epo = this.htn.toString();
    ((cxf)localObject).Epp = this.htq.toString();
    ((cxf)localObject).Epq = this.hto.toString();
    ((cxf)localObject).Epr = this.htp.toString();
    try
    {
      localObject = ((cxf)localObject).toByteArray();
      AppMethodBeat.o(125672);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.StatisticsOplog", "putIntent " + localException.getMessage());
      AppMethodBeat.o(125672);
    }
    return null;
  }
  
  public final void b(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(125673);
    byte[] arrayOfByte = avk();
    if (arrayOfByte == null)
    {
      AppMethodBeat.o(125673);
      return;
    }
    paramIntent.putExtra(paramString, arrayOfByte);
    AppMethodBeat.o(125673);
  }
  
  public final d ew(boolean paramBoolean)
  {
    AppMethodBeat.i(125668);
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = zi((String)localObject);
      AppMethodBeat.o(125668);
      return localObject;
    }
  }
  
  public final boolean oG(int paramInt)
  {
    AppMethodBeat.i(125660);
    this.hti = Integer.valueOf(paramInt);
    AppMethodBeat.o(125660);
    return true;
  }
  
  public final d oH(int paramInt)
  {
    AppMethodBeat.i(125663);
    d locald = zi(String.valueOf(paramInt));
    AppMethodBeat.o(125663);
    return locald;
  }
  
  public final d oI(int paramInt)
  {
    AppMethodBeat.i(125669);
    if (!aBf())
    {
      AppMethodBeat.o(125669);
      return this;
    }
    if (this.hto.length() == 0) {
      this.hto.append(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(125669);
      return this;
      this.hto.append("||".concat(String.valueOf(paramInt)));
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(125661);
    if (!aBf())
    {
      AppMethodBeat.o(125661);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    this.htk = htr.incrementAndGet();
    AppMethodBeat.o(125661);
  }
  
  public final d zi(String paramString)
  {
    AppMethodBeat.i(125662);
    if (!aBf())
    {
      AppMethodBeat.o(125662);
      return this;
    }
    if (this.htn.length() == 0) {
      if (bt.isNullOrNil(paramString)) {
        this.htn.append(" ");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125662);
      return this;
      this.htn.append(paramString);
      continue;
      this.htn.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final d zj(String paramString)
  {
    AppMethodBeat.i(125664);
    if (!aBf())
    {
      AppMethodBeat.o(125664);
      return this;
    }
    if (this.hto.length() == 0) {
      this.hto.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125664);
      return this;
      this.hto.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final d zk(String paramString)
  {
    AppMethodBeat.i(125667);
    if (!aBf())
    {
      AppMethodBeat.o(125667);
      return this;
    }
    if (this.htp.length() == 0) {
      this.htp.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125667);
      return this;
      this.htp.append("||".concat(String.valueOf(paramString)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.d
 * JD-Core Version:    0.7.0.1
 */