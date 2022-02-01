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
  private final m.c bbB;
  final OrientationEventListener bbC;
  d.a bbD;
  int bbE;
  private final Context context;
  
  public a(m.c paramc)
  {
    AppMethodBeat.i(195094);
    this.bbE = -1;
    this.bbB = paramc;
    this.context = paramc.JZ();
    this.bbC = new OrientationEventListener(this.context)
    {
      public final void onOrientationChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(195091);
        d.a locala;
        Object localObject;
        if (a.this.bbD != null)
        {
          locala = a.this.bbD;
          localObject = a.this;
          if (((((a)localObject).bbE != 0) || ((paramAnonymousInt < 300) && (paramAnonymousInt > 60))) && ((((a)localObject).bbE != 1) || (paramAnonymousInt < 30) || (paramAnonymousInt > 150)) && ((((a)localObject).bbE != 2) || (paramAnonymousInt < 120) || (paramAnonymousInt > 240)) && ((((a)localObject).bbE != 3) || (paramAnonymousInt < 210) || (paramAnonymousInt > 330))) {
            ((a)localObject).bbE = ((paramAnonymousInt + 45) % 360 / 90);
          }
          if (((a)localObject).bbE != 0) {
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
            locala.df(localObject);
          }
          AppMethodBeat.o(195091);
          return;
          label161:
          if (((a)localObject).bbE == 1)
          {
            paramAnonymousInt = 8;
            break;
          }
          if (((a)localObject).bbE == 2)
          {
            paramAnonymousInt = 9;
            break;
          }
          if (((a)localObject).bbE == 3)
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
    AppMethodBeat.o(195094);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    int j = 0;
    AppMethodBeat.i(195095);
    String str = paramj.method;
    paramj = paramj.gtF;
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
      if (this.bbB.JY() != null) {
        this.bbB.JY().getWindow().getDecorView().setSystemUiVisibility(k);
      }
      paramd.df(null);
      AppMethodBeat.o(195095);
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
      if (this.bbB.JY() != null) {
        switch (k)
        {
        }
      }
      for (;;)
      {
        paramd.df(null);
        AppMethodBeat.o(195095);
        return;
        this.bbB.JY().setRequestedOrientation(-1);
        continue;
        this.bbB.JY().setRequestedOrientation(1);
        continue;
        this.bbB.JY().setRequestedOrientation(0);
        continue;
        this.bbB.JY().setRequestedOrientation(9);
        continue;
        this.bbB.JY().setRequestedOrientation(12);
        continue;
        this.bbB.JY().setRequestedOrientation(8);
        continue;
        this.bbB.JY().setRequestedOrientation(11);
        continue;
        this.bbB.JY().setRequestedOrientation(2);
        continue;
        this.bbB.JY().setRequestedOrientation(13);
        continue;
        this.bbB.JY().setRequestedOrientation(13);
      }
    }
    if (str.equals("SystemChrome.forceOrientation"))
    {
      paramj = (String)paramj;
      if (this.bbB.JY() != null)
      {
        if (!paramj.equals("DeviceOrientation.portraitUp")) {
          break label633;
        }
        this.bbB.JY().setRequestedOrientation(1);
      }
      for (;;)
      {
        paramd.df(null);
        AppMethodBeat.o(195095);
        return;
        label633:
        if (paramj.equals("DeviceOrientation.portraitDown")) {
          this.bbB.JY().setRequestedOrientation(9);
        } else if (paramj.equals("DeviceOrientation.landscapeLeft")) {
          this.bbB.JY().setRequestedOrientation(8);
        } else if (paramj.equals("DeviceOrientation.landscapeRight")) {
          this.bbB.JY().setRequestedOrientation(0);
        } else {
          this.bbB.JY().setRequestedOrientation(-1);
        }
      }
    }
    paramd.dmQ();
    AppMethodBeat.o(195095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.a.a.a
 * JD-Core Version:    0.7.0.1
 */