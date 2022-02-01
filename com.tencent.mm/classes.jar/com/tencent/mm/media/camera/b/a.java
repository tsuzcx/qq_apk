package com.tencent.mm.media.camera.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/config/CameraKitConfig;", "", "()V", "CameraPictureImageCapture", "", "CameraPictureReadPixel", "TAG", "", "texturePreview", "", "chooseCameraxPictureType", "enableDebug", "getCameraInstance", "performanceMode", "setTexturePreview", "", "value", "cameraX", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a nul;
  private static boolean nun;
  
  static
  {
    AppMethodBeat.i(237142);
    nul = new a();
    nun = true;
    AppMethodBeat.o(237142);
  }
  
  public static boolean bnQ()
  {
    AppMethodBeat.i(237098);
    i locali = i.agtt;
    if (((Integer)i.a(b.a.agrB, Integer.valueOf(0))).intValue() == 1)
    {
      AppMethodBeat.o(237098);
      return true;
    }
    AppMethodBeat.o(237098);
    return false;
  }
  
  public static int bnS()
  {
    int m = 0;
    AppMethodBeat.i(237124);
    i locali = i.agtt;
    int j = ((Integer)i.a(b.a.agrD, Integer.valueOf(0))).intValue();
    int i;
    if (j == 0)
    {
      int k = ((c)h.ax(c.class)).a(c.a.yTA, 0);
      i = m;
      if (k > 0)
      {
        i = m;
        if (k <= 3) {
          i = 1;
        }
      }
      if (i != 0) {
        i = k;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Camera.CameraKitConfig", "getCameraInstance value:" + i + " local:" + j);
      AppMethodBeat.o(237124);
      return i;
      i = 1;
      continue;
      i = j;
    }
  }
  
  public static int bnT()
  {
    int m = 0;
    AppMethodBeat.i(237130);
    if (bnS() == 1)
    {
      Log.i("MicroMsg.Camera.CameraKitConfig", "chooseCameraxPictureType by camera1 CameraPictureReadPixel");
      AppMethodBeat.o(237130);
      return 1;
    }
    i locali = i.agtt;
    int j = ((Integer)i.a(b.a.agrE, Integer.valueOf(0))).intValue();
    int i;
    if (j == 0)
    {
      int k = ((c)h.ax(c.class)).a(c.a.yTC, 1);
      i = m;
      if (k > 0)
      {
        i = m;
        if (k <= 2) {
          i = 1;
        }
      }
      if (i != 0) {
        i = k;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Camera.CameraKitConfig", "chooseCameraxPictureType local:" + j + " value:" + i);
      AppMethodBeat.o(237130);
      return i;
      i = 1;
      continue;
      i = j;
    }
  }
  
  public static boolean bnU()
  {
    AppMethodBeat.i(237136);
    i locali = i.agtt;
    boolean bool;
    switch (((Integer)i.a(b.a.agrF, Integer.valueOf(0))).intValue())
    {
    default: 
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.Camera.CameraKitConfig", s.X("performanceMode:", Boolean.valueOf(bool)));
      AppMethodBeat.o(237136);
      return bool;
      bool = ((c)h.ax(c.class)).a(c.a.yTD, false);
      continue;
      bool = false;
    }
  }
  
  public static boolean gh(boolean paramBoolean)
  {
    AppMethodBeat.i(237106);
    if (paramBoolean)
    {
      AppMethodBeat.o(237106);
      return true;
    }
    i locali = i.agtt;
    int j = ((Integer)i.a(b.a.agrC, Integer.valueOf(0))).intValue();
    int i;
    switch (j)
    {
    default: 
      i = ((c)h.ax(c.class)).a(c.a.yTB, 0);
      switch (i)
      {
      default: 
        paramBoolean = nun;
      }
      break;
    }
    for (;;)
    {
      Log.i("MicroMsg.Camera.CameraKitConfig", "choose texturePreview local:" + j + " choose:" + i + " texturePreview:" + nun + " value:" + paramBoolean);
      AppMethodBeat.o(237106);
      return paramBoolean;
      paramBoolean = true;
      i = 0;
      continue;
      paramBoolean = false;
      i = 0;
      continue;
      paramBoolean = true;
      continue;
      paramBoolean = false;
    }
  }
  
  public static void gi(boolean paramBoolean)
  {
    AppMethodBeat.i(237114);
    nun = paramBoolean;
    Log.i("MicroMsg.Camera.CameraKitConfig", s.X("setTexturePreview:", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(237114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.b.a
 * JD-Core Version:    0.7.0.1
 */