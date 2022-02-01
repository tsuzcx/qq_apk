package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicInteger;

public final class e
{
  private static boolean ikP;
  private static AtomicInteger ino;
  public Object inf;
  public int ing;
  public int inh;
  public int ini;
  public int inj;
  public StringBuffer ink;
  public StringBuffer inl;
  public StringBuffer inm;
  public StringBuffer inn;
  public int opType;
  public long timeStamp;
  
  static
  {
    AppMethodBeat.i(125679);
    ikP = false;
    ino = new AtomicInteger(0);
    AppMethodBeat.o(125679);
  }
  
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125659);
    this.inf = null;
    this.ing = 1;
    this.opType = 0;
    this.ink = new StringBuffer();
    this.inl = new StringBuffer();
    this.inm = new StringBuffer();
    this.inn = new StringBuffer();
    this.opType = paramInt1;
    this.inj = paramInt2;
    if (!aLg())
    {
      AppMethodBeat.o(125659);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    if (ay.isWifi(aj.getContext())) {
      this.ini = 4;
    }
    for (;;)
    {
      this.inh = ino.incrementAndGet();
      AppMethodBeat.o(125659);
      return;
      if (ay.is4G(aj.getContext())) {
        this.ini = 3;
      } else if (ay.is3G(aj.getContext())) {
        this.ini = 2;
      } else if (ay.is2G(aj.getContext())) {
        this.ini = 1;
      } else {
        this.ini = 0;
      }
    }
  }
  
  public static void aLj()
  {
    AppMethodBeat.i(125670);
    ad.i("MicroMsg.StatisticsOplog", "wait op");
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
    die localdie = new die();
    try
    {
      localdie.parseFrom(paramArrayOfByte);
      paramArrayOfByte = new e(localdie.opType, localdie.inj);
      paramArrayOfByte.ing = localdie.ing;
      paramArrayOfByte.timeStamp = localdie.timeStamp;
      paramArrayOfByte.inh = localdie.inh;
      paramArrayOfByte.ini = localdie.ini;
      paramArrayOfByte.ink = new StringBuffer(localdie.HwV);
      paramArrayOfByte.inn = new StringBuffer(localdie.HwW);
      paramArrayOfByte.inl = new StringBuffer(localdie.HwX);
      paramArrayOfByte.inm = new StringBuffer(localdie.HwY);
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
  
  public static e pV(int paramInt)
  {
    AppMethodBeat.i(125657);
    e locale = new e(paramInt, 1);
    AppMethodBeat.o(125657);
    return locale;
  }
  
  public static e pW(int paramInt)
  {
    AppMethodBeat.i(125658);
    e locale = new e(paramInt, 4);
    AppMethodBeat.o(125658);
    return locale;
  }
  
  public static e v(Bundle paramBundle)
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
  
  public static e w(Intent paramIntent)
  {
    AppMethodBeat.i(125675);
    paramIntent = c(paramIntent, "intent_key_StatisticsOplog");
    AppMethodBeat.o(125675);
    return paramIntent;
  }
  
  public final e Gs(String paramString)
  {
    AppMethodBeat.i(125662);
    if (!aLg())
    {
      AppMethodBeat.o(125662);
      return this;
    }
    if (this.ink.length() == 0) {
      if (bt.isNullOrNil(paramString)) {
        this.ink.append(" ");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125662);
      return this;
      this.ink.append(paramString);
      continue;
      this.ink.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final e Gt(String paramString)
  {
    AppMethodBeat.i(125664);
    if (!aLg())
    {
      AppMethodBeat.o(125664);
      return this;
    }
    if (this.inl.length() == 0) {
      this.inl.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125664);
      return this;
      this.inl.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final e Gu(String paramString)
  {
    AppMethodBeat.i(125667);
    if (!aLg())
    {
      AppMethodBeat.o(125667);
      return this;
    }
    if (this.inm.length() == 0) {
      this.inm.append(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(125667);
      return this;
      this.inm.append("||".concat(String.valueOf(paramString)));
    }
  }
  
  public final byte[] aFg()
  {
    AppMethodBeat.i(125672);
    Object localObject = new die();
    ((die)localObject).opType = this.opType;
    ((die)localObject).inj = this.inj;
    ((die)localObject).ing = this.ing;
    ((die)localObject).timeStamp = this.timeStamp;
    ((die)localObject).inh = this.inh;
    ((die)localObject).ini = this.ini;
    ((die)localObject).HwV = this.ink.toString();
    ((die)localObject).HwW = this.inn.toString();
    ((die)localObject).HwX = this.inl.toString();
    ((die)localObject).HwY = this.inm.toString();
    try
    {
      localObject = ((die)localObject).toByteArray();
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
  
  public final boolean aLg()
  {
    boolean bool2 = true;
    int i = f.inq;
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
  
  public final e aLh()
  {
    AppMethodBeat.i(125665);
    this.inl = new StringBuffer();
    AppMethodBeat.o(125665);
    return this;
  }
  
  public final e aLi()
  {
    AppMethodBeat.i(125666);
    this.ink = new StringBuffer();
    AppMethodBeat.o(125666);
    return this;
  }
  
  public final boolean aLk()
  {
    AppMethodBeat.i(125671);
    if (!aLg())
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
    byte[] arrayOfByte = aFg();
    if (arrayOfByte == null)
    {
      AppMethodBeat.o(125673);
      return;
    }
    paramIntent.putExtra(paramString, arrayOfByte);
    AppMethodBeat.o(125673);
  }
  
  public final e eS(boolean paramBoolean)
  {
    AppMethodBeat.i(125668);
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = Gs((String)localObject);
      AppMethodBeat.o(125668);
      return localObject;
    }
  }
  
  public final boolean pX(int paramInt)
  {
    AppMethodBeat.i(125660);
    this.inf = Integer.valueOf(paramInt);
    AppMethodBeat.o(125660);
    return true;
  }
  
  public final e pY(int paramInt)
  {
    AppMethodBeat.i(125663);
    e locale = Gs(String.valueOf(paramInt));
    AppMethodBeat.o(125663);
    return locale;
  }
  
  public final e pZ(int paramInt)
  {
    AppMethodBeat.i(125669);
    if (!aLg())
    {
      AppMethodBeat.o(125669);
      return this;
    }
    if (this.inl.length() == 0) {
      this.inl.append(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(125669);
      return this;
      this.inl.append("||".concat(String.valueOf(paramInt)));
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(125661);
    if (!aLg())
    {
      AppMethodBeat.o(125661);
      return;
    }
    this.timeStamp = System.currentTimeMillis();
    this.inh = ino.incrementAndGet();
    AppMethodBeat.o(125661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.e
 * JD-Core Version:    0.7.0.1
 */