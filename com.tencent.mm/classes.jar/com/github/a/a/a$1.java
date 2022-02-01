package com.github.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d.a;
import io.flutter.plugin.a.d.c;

final class a$1
  implements d.c
{
  a$1(a parama, Activity paramActivity) {}
  
  public final void a(Object paramObject, final d.a parama)
  {
    AppMethodBeat.i(199075);
    this.bbz.bbx = new OrientationEventListener(this.val$activity)
    {
      public final void onOrientationChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(199074);
        d.a locala = parama;
        Object localObject = a.1.this.bbz;
        if (((((a)localObject).bby != 0) || ((paramAnonymousInt < 300) && (paramAnonymousInt > 60))) && ((((a)localObject).bby != 1) || (paramAnonymousInt < 30) || (paramAnonymousInt > 150)) && ((((a)localObject).bby != 2) || (paramAnonymousInt < 120) || (paramAnonymousInt > 240)) && ((((a)localObject).bby != 3) || (paramAnonymousInt < 210) || (paramAnonymousInt > 330))) {
          ((a)localObject).bby = ((paramAnonymousInt + 45) % 360 / 90);
        }
        if (((a)localObject).bby == 0)
        {
          paramAnonymousInt = 1;
          if (paramAnonymousInt != 1) {
            break label197;
          }
          localObject = "DeviceOrientation.portraitUp";
        }
        for (;;)
        {
          if (localObject != null) {
            locala.ba(localObject);
          }
          AppMethodBeat.o(199074);
          return;
          if (((a)localObject).bby == 1)
          {
            paramAnonymousInt = 8;
            break;
          }
          if (((a)localObject).bby == 2)
          {
            paramAnonymousInt = 9;
            break;
          }
          if (((a)localObject).bby == 3)
          {
            paramAnonymousInt = 0;
            break;
          }
          paramAnonymousInt = -1;
          break;
          label197:
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
    if (this.bbz.bbx.canDetectOrientation())
    {
      this.bbz.bbx.enable();
      AppMethodBeat.o(199075);
      return;
    }
    parama.b("SensorError", "Cannot detect sensors. Not enabled", null);
    AppMethodBeat.o(199075);
  }
  
  public final void sT()
  {
    AppMethodBeat.i(199076);
    if (this.bbz.bbx != null)
    {
      this.bbz.bbx.disable();
      this.bbz.bbx = null;
    }
    AppMethodBeat.o(199076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.github.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */