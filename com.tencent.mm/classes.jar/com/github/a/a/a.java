package com.github.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d.a;
import io.flutter.plugin.a.d.c;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.m.c;
import java.util.List;

public final class a
  implements k.c
{
  private final m.c aRg;
  final OrientationEventListener aRh;
  d.a aRi;
  int aRj;
  private final Context context;
  
  public a(m.c paramc)
  {
    AppMethodBeat.i(192747);
    this.aRj = -1;
    this.aRg = paramc;
    this.context = paramc.Ir();
    this.aRh = new OrientationEventListener(this.context)
    {
      public final void onOrientationChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(192744);
        d.a locala;
        Object localObject;
        if (a.this.aRi != null)
        {
          locala = a.this.aRi;
          localObject = a.this;
          if (((((a)localObject).aRj != 0) || ((paramAnonymousInt < 300) && (paramAnonymousInt > 60))) && ((((a)localObject).aRj != 1) || (paramAnonymousInt < 30) || (paramAnonymousInt > 150)) && ((((a)localObject).aRj != 2) || (paramAnonymousInt < 120) || (paramAnonymousInt > 240)) && ((((a)localObject).aRj != 3) || (paramAnonymousInt < 210) || (paramAnonymousInt > 330))) {
            ((a)localObject).aRj = ((paramAnonymousInt + 45) % 360 / 90);
          }
          if (((a)localObject).aRj != 0) {
            break label161;
          }
          paramAnonymousInt = 1;
          if (paramAnonymousInt != 1) {
            break label207;
          }
          localObject = "DeviceOrientation.portraitUp";
        }
        for (;;)
        {
          if (localObject != null) {
            locala.db(localObject);
          }
          AppMethodBeat.o(192744);
          return;
          label161:
          if (((a)localObject).aRj == 1)
          {
            paramAnonymousInt = 8;
            break;
          }
          if (((a)localObject).aRj == 2)
          {
            paramAnonymousInt = 9;
            break;
          }
          if (((a)localObject).aRj == 3)
          {
            paramAnonymousInt = 0;
            break;
          }
          paramAnonymousInt = -1;
          break;
          label207:
          if (paramAnonymousInt == 9) {
            localObject = "DeviceOrientation.portraitDown";
          } else if (paramAnonymousInt == 0) {
            localObject = "DeviceOrientation.landscapeRight";
          } else if (paramAnonymousInt == 8) {
            localObject = "DeviceOrientation.landscapeLeft";
          } else {
            localObject = null;
          }
        }
      }
    };
    AppMethodBeat.o(192747);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    int j = 0;
    AppMethodBeat.i(192748);
    String str = paramj.method;
    paramj = paramj.fXJ;
    int k;
    int i;
    if (str.equals("SystemChrome.setEnabledSystemUIOverlays"))
    {
      paramj = (List)paramj;
      k = 7942;
      if (j < paramj.size())
      {
        if (paramj.get(j).equals("SystemUiOverlay.top")) {
          i = k & 0xFFFFFFFB;
        }
        for (;;)
        {
          j += 1;
          k = i;
          break;
          i = k;
          if (paramj.get(j).equals("SystemUiOverlay.bottom")) {
            i = k & 0xFFFFFFFD;
          }
        }
      }
      if (this.aRg.Iq() != null) {
        this.aRg.Iq().getWindow().getDecorView().setSystemUiVisibility(k);
      }
      paramd.db(null);
      AppMethodBeat.o(192748);
      return;
    }
    if (str.equals("SystemChrome.setPreferredOrientations"))
    {
      paramj = (List)paramj;
      j = 0;
      k = 0;
      if (j < paramj.size())
      {
        if (paramj.get(j).equals("DeviceOrientation.portraitUp")) {
          i = k | 0x1;
        }
        for (;;)
        {
          j += 1;
          k = i;
          break;
          if (paramj.get(j).equals("DeviceOrientation.landscapeLeft"))
          {
            i = k | 0x2;
          }
          else if (paramj.get(j).equals("DeviceOrientation.portraitDown"))
          {
            i = k | 0x4;
          }
          else
          {
            i = k;
            if (paramj.get(j).equals("DeviceOrientation.landscapeRight")) {
              i = k | 0x8;
            }
          }
        }
      }
      if (this.aRg.Iq() != null) {
        switch (k)
        {
        }
      }
      for (;;)
      {
        paramd.db(null);
        AppMethodBeat.o(192748);
        return;
        this.aRg.Iq().setRequestedOrientation(-1);
        continue;
        this.aRg.Iq().setRequestedOrientation(1);
        continue;
        this.aRg.Iq().setRequestedOrientation(0);
        continue;
        this.aRg.Iq().setRequestedOrientation(9);
        continue;
        this.aRg.Iq().setRequestedOrientation(12);
        continue;
        this.aRg.Iq().setRequestedOrientation(8);
        continue;
        this.aRg.Iq().setRequestedOrientation(11);
        continue;
        this.aRg.Iq().setRequestedOrientation(2);
        continue;
        this.aRg.Iq().setRequestedOrientation(13);
        continue;
        this.aRg.Iq().setRequestedOrientation(13);
      }
    }
    if (str.equals("SystemChrome.forceOrientation"))
    {
      paramj = (String)paramj;
      if (this.aRg.Iq() != null)
      {
        if (!paramj.equals("DeviceOrientation.portraitUp")) {
          break label633;
        }
        this.aRg.Iq().setRequestedOrientation(1);
      }
      for (;;)
      {
        paramd.db(null);
        AppMethodBeat.o(192748);
        return;
        label633:
        if (paramj.equals("DeviceOrientation.portraitDown")) {
          this.aRg.Iq().setRequestedOrientation(9);
        } else if (paramj.equals("DeviceOrientation.landscapeLeft")) {
          this.aRg.Iq().setRequestedOrientation(8);
        } else if (paramj.equals("DeviceOrientation.landscapeRight")) {
          this.aRg.Iq().setRequestedOrientation(0);
        } else {
          this.aRg.Iq().setRequestedOrientation(-1);
        }
      }
    }
    paramd.daE();
    AppMethodBeat.o(192748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.a.a.a
 * JD-Core Version:    0.7.0.1
 */