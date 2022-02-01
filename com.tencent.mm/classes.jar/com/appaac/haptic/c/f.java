package com.appaac.haptic.c;

import android.content.Context;
import android.os.DynamicEffect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.HapticPlayer;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.SystemClock;
import android.os.Vibrator;
import com.appaac.haptic.a.g;
import com.appaac.haptic.sync.VibrationPattern;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class f
  implements d
{
  private final boolean DEBUG;
  private Vibrator cqQ;
  com.appaac.haptic.sync.a crI;
  Handler crM;
  HandlerThread crN;
  com.appaac.haptic.sync.c crO;
  a crP;
  com.appaac.haptic.a.f crQ;
  HapticPlayer crY;
  private Context mContext;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(208334);
    this.DEBUG = false;
    this.crP = new a();
    this.mContext = paramContext;
    this.cqQ = ((Vibrator)paramContext.getSystemService("vibrator"));
    AppMethodBeat.o(208334);
  }
  
  private void Nz()
  {
    AppMethodBeat.i(208342);
    if (this.crN != null)
    {
      this.crN.quit();
      this.crN = null;
      this.crM = null;
      this.crO = null;
    }
    if (this.crQ != null)
    {
      this.crQ.quit();
      this.crQ = null;
    }
    AppMethodBeat.o(208342);
  }
  
  private void a(String paramString, final int paramInt1, final int paramInt2, com.appaac.haptic.sync.a parama)
  {
    AppMethodBeat.i(208340);
    this.crI = parama;
    this.crN = new HandlerThread("Tencent-Sync");
    this.crN.start();
    this.crM = new Handler(this.crN.getLooper())
    {
      int crV = 0;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(208358);
        for (;;)
        {
          Object localObject1;
          int i;
          try
          {
            if ((f.this.crM != null) && (f.this.crN != null))
            {
              localObject1 = f.this.crO;
              if (localObject1 != null) {}
            }
            else
            {
              AppMethodBeat.o(208358);
              return;
            }
            i = paramAnonymousMessage.what;
            switch (i)
            {
            default: 
              AppMethodBeat.o(208358);
              return;
            }
          }
          catch (Exception paramAnonymousMessage)
          {
            long l2;
            new StringBuilder("ex in handleMessage:").append(paramAnonymousMessage.toString());
            AppMethodBeat.o(208358);
            return;
          }
          long l1 = ((Long)paramAnonymousMessage.obj).longValue();
          if (f.this.crI != null)
          {
            i = f.this.crI.getCurrentPosition();
            if ((i > 0) && (i >= this.crV))
            {
              paramAnonymousMessage = f.this.crO;
              l2 = i;
              paramAnonymousMessage.csf = l2;
              f.this.crO.x(l2, l1);
              this.crV = i;
              AppMethodBeat.o(208358);
              return;
            }
            if ((i >= 0) && (i < this.crV) && (f.this.crP.crG > 0))
            {
              f.this.gW(i);
              continue;
            }
            f.this.crM.sendMessage(Message.obtain(paramAnonymousMessage));
            continue;
          }
          f.this.crO.csf = l1;
          f.this.crO.x(l1, l1);
          AppMethodBeat.o(208358);
          return;
          if ((paramAnonymousMessage.obj instanceof Parcel))
          {
            paramAnonymousMessage = (Parcel)paramAnonymousMessage.obj;
            if (f.this.crI != null) {
              f.this.crI.getCurrentPosition();
            }
            localObject1 = new VibrationPattern(paramAnonymousMessage);
            localObject1 = "{\"Metadata\": {\"Version\": 1}," + ((VibrationPattern)localObject1).pattern + "}";
            for (;;)
            {
              try
              {
                if (HapticPlayer.isAvailable())
                {
                  localObject1 = DynamicEffect.create((String)localObject1);
                  f.this.crY = new HapticPlayer((DynamicEffect)localObject1);
                }
              }
              finally
              {
                continue;
              }
              try
              {
                localObject1 = f.this.crY;
                if (f.this.crQ == null) {
                  continue;
                }
                i = f.this.crQ.Nu();
                ((HapticPlayer)localObject1).start(1, 0, i, paramInt2);
              }
              catch (NoSuchMethodError localNoSuchMethodError)
              {
                f.this.crY.start(1);
                continue;
              }
              paramAnonymousMessage.recycle();
              AppMethodBeat.o(208358);
              return;
              i = paramInt1;
            }
            if (f.this.crP.crG > 0)
            {
              if ((f.this.crI != null) && (f.this.crI.getCurrentPosition() > g.bi(f.this.crP.crF)))
              {
                f.this.crM.sendEmptyMessageDelayed(102, 10L);
                AppMethodBeat.o(208358);
                return;
              }
              f.this.gW(0);
              AppMethodBeat.o(208358);
              return;
            }
            f.this.crP.mStatus = 9;
          }
        }
      }
    };
    this.crO = new com.appaac.haptic.sync.c(this.crM, paramString, this.crP);
    if (this.crP.crI != null)
    {
      if (this.crP.crI.getCurrentPosition() < 0)
      {
        this.crO.csf = this.crP.crI.getCurrentPosition();
        this.crO.x(this.crP.crI.getCurrentPosition(), this.crP.crJ);
        AppMethodBeat.o(208340);
        return;
      }
      this.crO.csf = this.crP.crJ;
      this.crO.x(this.crP.crJ, this.crP.crJ);
      AppMethodBeat.o(208340);
      return;
    }
    if (parama != null)
    {
      this.crO.csf = parama.getCurrentPosition();
      this.crO.x(parama.getCurrentPosition(), 0L);
      AppMethodBeat.o(208340);
      return;
    }
    this.crO.NC();
    AppMethodBeat.o(208340);
  }
  
  public static boolean isAvailable()
  {
    AppMethodBeat.i(208335);
    try
    {
      boolean bool = HapticPlayer.isAvailable();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(208335);
    }
    return false;
  }
  
  public final void Nn()
  {
    this.crP.crG = 2147483647;
  }
  
  public final void Nx()
  {
    AppMethodBeat.i(208347);
    try
    {
      this.crP.reset();
      HapticPlayer localHapticPlayer = this.crY;
      if (localHapticPlayer == null) {
        return;
      }
      Nz();
      this.crY.stop();
      return;
    }
    finally
    {
      AppMethodBeat.o(208347);
    }
  }
  
  public final void a(File paramFile, com.appaac.haptic.sync.a parama)
  {
    AppMethodBeat.i(208372);
    this.crP.reset();
    this.crP.crK = paramFile;
    this.crP.cqH = 255;
    this.crP.cqI = 50;
    this.crP.crI = parama;
    AppMethodBeat.o(208372);
  }
  
  public final boolean gW(int paramInt)
  {
    AppMethodBeat.i(208385);
    if (!a.a(this.crP.crH))
    {
      AppMethodBeat.o(208385);
      return false;
    }
    if ((paramInt < 0) || (paramInt > this.crP.crH.getDuration()))
    {
      AppMethodBeat.o(208385);
      return false;
    }
    if (this.crY != null) {
      this.crY.stop();
    }
    Nz();
    this.crP.crJ = paramInt;
    String str2 = g.n(this.crP.crF, this.crP.crJ);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!"".equals(str2)) {}
    }
    else
    {
      if (this.crP.crG <= 0) {
        break label156;
      }
      str1 = this.crP.crF;
      this.crP.crJ = 0;
    }
    if (6 != this.crP.mStatus)
    {
      AppMethodBeat.o(208385);
      return true;
      label156:
      this.crP.mStatus = 9;
      AppMethodBeat.o(208385);
      return false;
    }
    this.crP.mStartTime = SystemClock.elapsedRealtime();
    if (this.crP.crI != null) {
      a(this.crP.crF, this.crP.cqH, this.crP.cqI, this.crP.crI);
    }
    for (;;)
    {
      AppMethodBeat.o(208385);
      return true;
      a(str1, this.crP.cqH, this.crP.cqI, null);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(208353);
    if (6 != this.crP.mStatus)
    {
      AppMethodBeat.o(208353);
      return;
    }
    if (this.crY != null) {
      this.crY.stop();
    }
    Nz();
    this.crP.mStatus = 7;
    if (!a.a(this.crP.crH))
    {
      this.crP.crJ = 0;
      AppMethodBeat.o(208353);
      return;
    }
    if (this.crP.crI != null)
    {
      this.crP.crJ = this.crP.crI.getCurrentPosition();
      AppMethodBeat.o(208353);
      return;
    }
    int i = (int)(SystemClock.elapsedRealtime() - this.crP.mStartTime);
    if (i < 0)
    {
      this.crP.crJ = 0;
      AppMethodBeat.o(208353);
      return;
    }
    a locala = this.crP;
    locala.crJ = (i + locala.crJ);
    AppMethodBeat.o(208353);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(208379);
    if (this.crP.crK != null) {
      this.crP.crF = g.r(this.crP.crK);
    }
    if (1 == g.bd(this.crP.crF)) {
      this.crP.crF = g.bb(this.crP.crF);
    }
    this.crP.crF = g.bc(this.crP.crF);
    this.crP.crF = g.bg(this.crP.crF);
    com.appaac.haptic.b.a.c localc = g.ba(this.crP.crF);
    if (!a.a(localc))
    {
      this.crP.reset();
      AppMethodBeat.o(208379);
      return false;
    }
    this.crP.crH = localc;
    AppMethodBeat.o(208379);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(208351);
    this.crP.reset();
    Nz();
    if (this.crY != null) {
      this.crY.stop();
    }
    this.crY = null;
    AppMethodBeat.o(208351);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(208361);
    if (6 == this.crP.mStatus)
    {
      AppMethodBeat.o(208361);
      return false;
    }
    if (!a.a(this.crP.crH))
    {
      AppMethodBeat.o(208361);
      return false;
    }
    if (this.crP.crJ < 0)
    {
      AppMethodBeat.o(208361);
      return false;
    }
    if (9 == this.crP.mStatus) {
      this.crP.crJ = 0;
    }
    String str = g.n(this.crP.crF, this.crP.crJ);
    if ((str == null) || ("".equals(str)))
    {
      this.crP.mStatus = 9;
      AppMethodBeat.o(208361);
      return false;
    }
    this.crP.mStartTime = SystemClock.elapsedRealtime();
    this.crP.mStatus = 6;
    if (this.crP.crI != null) {
      a(this.crP.crF, this.crP.cqH, this.crP.cqI, this.crP.crI);
    }
    for (;;)
    {
      AppMethodBeat.o(208361);
      return true;
      a(str, this.crP.cqH, this.crP.cqI, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.c.f
 * JD-Core Version:    0.7.0.1
 */