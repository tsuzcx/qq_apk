package com.appaac.haptic.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.SystemClock;
import android.os.Vibrator;
import com.appaac.haptic.a.f;
import com.appaac.haptic.a.g;
import com.appaac.haptic.sync.VibrationPattern;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.reflect.Method;

public final class e
  implements d
{
  private final boolean DEBUG;
  private Vibrator cqQ;
  com.appaac.haptic.sync.a crI;
  Handler crM;
  HandlerThread crN;
  com.appaac.haptic.sync.c crO;
  a crP;
  f crQ;
  private Class crW;
  Context mContext;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(208338);
    this.DEBUG = false;
    this.crP = new a();
    this.mContext = paramContext;
    this.cqQ = ((Vibrator)paramContext.getSystemService("vibrator"));
    try
    {
      this.crW = Class.forName("android.os.RichTapVibrationEffect");
      if (this.crW == null) {
        this.crW = Class.forName("android.os.VibrationEffect");
      }
      int i;
      int j;
      int k;
      return;
    }
    catch (Exception paramContext)
    {
      try
      {
        i = ((Integer)this.crW.getMethod("checkIfRichTapSupport", new Class[0]).invoke(null, new Object[0])).intValue();
        if (1 == i)
        {
          g.bq(true);
          AppMethodBeat.o(208338);
          return;
        }
        j = (0xFF00 & i) >> 8;
        k = (i & 0xFF) >> 0;
        g.gU(j);
        g.gV(k);
        g.bq(false);
        new StringBuilder("clientCode:").append((0xFF0000 & i) >> 16).append(" majorVersion:").append(j).append(" minorVersion:").append(k);
        AppMethodBeat.o(208338);
        return;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(208338);
      }
      paramContext = paramContext;
      AppMethodBeat.o(208338);
      return;
    }
  }
  
  private void Nz()
  {
    AppMethodBeat.i(208357);
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
    AppMethodBeat.o(208357);
  }
  
  private void a(String paramString, final int paramInt1, final int paramInt2, com.appaac.haptic.sync.a parama)
  {
    AppMethodBeat.i(208352);
    this.crI = parama;
    this.crN = new HandlerThread("Richtap-Sync");
    this.crN.start();
    this.crM = new Handler(this.crN.getLooper())
    {
      int crV = 0;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(208360);
        for (;;)
        {
          Object localObject;
          int i;
          try
          {
            if ((e.this.crM != null) && (e.this.crN != null))
            {
              localObject = e.this.crO;
              if (localObject != null) {}
            }
            else
            {
              AppMethodBeat.o(208360);
              return;
            }
            i = paramAnonymousMessage.what;
            switch (i)
            {
            default: 
              AppMethodBeat.o(208360);
              return;
            }
          }
          catch (Exception paramAnonymousMessage)
          {
            long l2;
            new StringBuilder("ex in handleMessage:").append(paramAnonymousMessage.toString());
            AppMethodBeat.o(208360);
            return;
          }
          long l1 = ((Long)paramAnonymousMessage.obj).longValue();
          if (e.this.crI != null)
          {
            i = e.this.crI.getCurrentPosition();
            if ((i > 0) && (i >= this.crV))
            {
              paramAnonymousMessage = e.this.crO;
              l2 = i;
              paramAnonymousMessage.csf = l2;
              e.this.crO.x(l2, l1);
              this.crV = i;
              AppMethodBeat.o(208360);
              return;
            }
            if ((i >= 0) && (i < this.crV) && (e.this.crP.crG > 0))
            {
              e.this.gW(i);
              continue;
            }
            e.this.crM.sendMessage(Message.obtain(paramAnonymousMessage));
            continue;
          }
          e.this.crO.csf = l1;
          e.this.crO.x(l1, l1);
          AppMethodBeat.o(208360);
          return;
          if ((paramAnonymousMessage.obj instanceof Parcel))
          {
            paramAnonymousMessage = (Parcel)paramAnonymousMessage.obj;
            if (e.this.crI != null) {
              e.this.crI.getCurrentPosition();
            }
            localObject = new VibrationPattern(paramAnonymousMessage);
            new StringBuilder("current pattern:").append(((VibrationPattern)localObject).pattern);
            if (g.getMajorVersion() >= 24)
            {
              localObject = "{\n    \"Metadata\": {\n        \"Created\": \"2020-08-10\",\n        \"Description\": \"Haptic editor design\",\n        \"Version\": 2\n    },\n    \"PatternList\": [\n       {\n        \"AbsoluteTime\": 0,\n          ReplaceMe\n       }\n    ]\n}".replace("ReplaceMe", ((VibrationPattern)localObject).pattern);
              locald = com.appaac.haptic.a.d.aF(e.this.mContext);
              if (e.this.crQ != null) {}
              for (i = e.this.crQ.Nu();; i = paramInt1)
              {
                locald.g((String)localObject, i, paramInt2);
                paramAnonymousMessage.recycle();
                AppMethodBeat.o(208360);
                return;
              }
            }
            localObject = "{\"Metadata\": {\"Version\": 1}," + ((VibrationPattern)localObject).pattern + "}";
            com.appaac.haptic.a.d locald = com.appaac.haptic.a.d.aF(e.this.mContext);
            if (e.this.crQ != null) {}
            for (i = e.this.crQ.Nu();; i = paramInt1)
            {
              locald.f((String)localObject, i, paramInt2);
              break;
            }
            if (e.this.crP.crG > 0)
            {
              if ((e.this.crI != null) && (e.this.crI.getCurrentPosition() > g.bi(e.this.crP.crF)))
              {
                e.this.crM.sendEmptyMessageDelayed(102, 10L);
                AppMethodBeat.o(208360);
                return;
              }
              e.this.gW(0);
              AppMethodBeat.o(208360);
              return;
            }
            e.this.crP.mStatus = 9;
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
        AppMethodBeat.o(208352);
        return;
      }
      this.crO.csf = this.crP.crJ;
      this.crO.x(this.crP.crJ, this.crP.crJ);
      AppMethodBeat.o(208352);
      return;
    }
    if ((parama == null) && (g.getMajorVersion() >= 24))
    {
      com.appaac.haptic.a.d.aF(this.mContext).g(paramString, paramInt1, paramInt2);
      this.crM.sendEmptyMessageDelayed(102, g.bi(paramString));
      AppMethodBeat.o(208352);
      return;
    }
    if (parama != null)
    {
      this.crO.csf = parama.getCurrentPosition();
      this.crO.x(parama.getCurrentPosition(), 0L);
      AppMethodBeat.o(208352);
      return;
    }
    this.crO.NC();
    AppMethodBeat.o(208352);
  }
  
  public static boolean isAvailable()
  {
    AppMethodBeat.i(208343);
    try
    {
      Class localClass2 = Class.forName("android.os.RichTapVibrationEffect");
      Class localClass1 = localClass2;
      if (localClass2 == null) {
        localClass1 = Class.forName("android.os.VibrationEffect");
      }
      int i = ((Integer)localClass1.getMethod("checkIfRichTapSupport", new Class[0]).invoke(null, new Object[0])).intValue();
      if (2 == i)
      {
        AppMethodBeat.o(208343);
        return false;
      }
      AppMethodBeat.o(208343);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(208343);
    }
    return false;
  }
  
  public final void Nn()
  {
    this.crP.crG = 2147483647;
  }
  
  public final void Nx()
  {
    AppMethodBeat.i(208363);
    this.crP.reset();
    Nz();
    com.appaac.haptic.a.d.aF(this.mContext).Nq();
    AppMethodBeat.o(208363);
  }
  
  public final void a(File paramFile, com.appaac.haptic.sync.a parama)
  {
    AppMethodBeat.i(208392);
    this.crP.reset();
    this.crP.crK = paramFile;
    this.crP.cqH = 255;
    this.crP.cqI = 50;
    this.crP.crI = parama;
    AppMethodBeat.o(208392);
  }
  
  public final boolean gW(int paramInt)
  {
    AppMethodBeat.i(208402);
    if (!a.a(this.crP.crH))
    {
      AppMethodBeat.o(208402);
      return false;
    }
    if ((paramInt < 0) || (paramInt > this.crP.crH.getDuration()))
    {
      AppMethodBeat.o(208402);
      return false;
    }
    Nz();
    com.appaac.haptic.a.d.aF(this.mContext).Nq();
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
        break label153;
      }
      str1 = this.crP.crF;
      this.crP.crJ = 0;
    }
    if (6 != this.crP.mStatus)
    {
      AppMethodBeat.o(208402);
      return true;
      label153:
      this.crP.mStatus = 9;
      AppMethodBeat.o(208402);
      return false;
    }
    this.crP.mStartTime = SystemClock.elapsedRealtime();
    if (this.crP.crI != null) {
      a(this.crP.crF, this.crP.cqH, this.crP.cqI, this.crP.crI);
    }
    for (;;)
    {
      AppMethodBeat.o(208402);
      return true;
      a(str1, this.crP.cqH, this.crP.cqI, null);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(208378);
    if (6 != this.crP.mStatus)
    {
      AppMethodBeat.o(208378);
      return;
    }
    Nz();
    com.appaac.haptic.a.d.aF(this.mContext).Nq();
    this.crP.mStatus = 7;
    if (!a.a(this.crP.crH))
    {
      this.crP.crJ = 0;
      AppMethodBeat.o(208378);
      return;
    }
    if (this.crP.crI != null)
    {
      this.crP.crJ = this.crP.crI.getCurrentPosition();
      AppMethodBeat.o(208378);
      return;
    }
    int i = (int)(SystemClock.elapsedRealtime() - this.crP.mStartTime);
    if (i < 0)
    {
      this.crP.crJ = 0;
      AppMethodBeat.o(208378);
      return;
    }
    a locala = this.crP;
    locala.crJ = (i + locala.crJ);
    AppMethodBeat.o(208378);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(208396);
    if (this.crP.crK != null) {
      this.crP.crF = g.r(this.crP.crK);
    }
    if (1 == g.bd(this.crP.crF)) {
      this.crP.crF = g.bb(this.crP.crF);
    }
    if (24 > g.getMajorVersion())
    {
      this.crP.crF = g.bc(this.crP.crF);
      this.crP.crF = g.bg(this.crP.crF);
    }
    com.appaac.haptic.b.a.c localc = g.ba(this.crP.crF);
    if (!a.a(localc))
    {
      this.crP.reset();
      AppMethodBeat.o(208396);
      return false;
    }
    this.crP.crH = localc;
    AppMethodBeat.o(208396);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(208369);
    this.crP.reset();
    Nz();
    AppMethodBeat.o(208369);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(208387);
    if (6 == this.crP.mStatus)
    {
      AppMethodBeat.o(208387);
      return false;
    }
    if (!a.a(this.crP.crH))
    {
      AppMethodBeat.o(208387);
      return false;
    }
    if (this.crP.crJ < 0)
    {
      AppMethodBeat.o(208387);
      return false;
    }
    if (9 == this.crP.mStatus) {
      this.crP.crJ = 0;
    }
    String str = g.n(this.crP.crF, this.crP.crJ);
    if ((str == null) || ("".equals(str)))
    {
      this.crP.mStatus = 9;
      AppMethodBeat.o(208387);
      return false;
    }
    this.crP.mStartTime = SystemClock.elapsedRealtime();
    this.crP.mStatus = 6;
    if (this.crP.crI != null) {
      a(this.crP.crF, this.crP.cqH, this.crP.cqI, this.crP.crI);
    }
    for (;;)
    {
      AppMethodBeat.o(208387);
      return true;
      a(str, this.crP.cqH, this.crP.cqI, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.c.e
 * JD-Core Version:    0.7.0.1
 */