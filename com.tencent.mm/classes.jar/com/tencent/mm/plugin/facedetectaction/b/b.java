package com.tencent.mm.plugin.facedetectaction.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class b
{
  public int mqt;
  public YTPoseDetectInterface.PoseDetectOnFrame mqu = null;
  b.a mqv;
  public int status = -1;
  
  static
  {
    AppMethodBeat.i(686);
    k.a("YTCommonEx", b.class.getClassLoader());
    k.a("YTFaceTrace", b.class.getClassLoader());
    k.a("YTNextCV", b.class.getClassLoader());
    k.a("YTPoseDetect", b.class.getClassLoader());
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
    AppMethodBeat.o(686);
  }
  
  final boolean f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(685);
    ab.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
    for (;;)
    {
      try
      {
        InputStream localInputStream1 = ah.getContext().getAssets().open("face_detect" + File.separator + "ufdmtcc.bin");
        InputStream localInputStream2 = ah.getContext().getAssets().open("face_detect" + File.separator + "ufat.bin");
        arrayOfByte2 = new byte[localInputStream1.available()];
        ab.i("MicroMsg.FaceCheckActionEngine", "load ufat.bin or ufdmtcc.bin failed" + localIOException1.getMessage());
      }
      catch (IOException localIOException1)
      {
        try
        {
          localInputStream1.read(arrayOfByte2);
          arrayOfByte1 = new byte[localInputStream2.available()];
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            byte[] arrayOfByte2;
            int i;
            byte[] arrayOfByte1 = null;
          }
        }
        try
        {
          localInputStream2.read(arrayOfByte1);
          localInputStream1.close();
          localInputStream2.close();
          if (!FileOp.cN(p.buJ()))
          {
            ab.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance copy post detect model file");
            p.p(ah.getContext(), "face_detect" + File.separator + "PE.dat", p.buJ());
          }
          ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel FielPath: %s", new Object[] { p.buJ() });
          i = YTPoseDetectInterface.initModel(p.buJ());
          ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label293;
          }
          ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel failed，return:".concat(String.valueOf(i)));
          i = 0;
          if (i == 0) {
            break;
          }
          YTCommonExInterface.setAppBrightness(paramMMActivity, 255);
          this.status = 1;
          AppMethodBeat.o(685);
          return true;
        }
        catch (IOException localIOException3)
        {
          break label265;
        }
        localIOException1 = localIOException1;
        arrayOfByte1 = null;
        arrayOfByte2 = null;
      }
      label265:
      continue;
      label293:
      i = YTFaceTraceInterface.initModel(arrayOfByte2, arrayOfByte1);
      if (i != 0)
      {
        ab.i("MicroMsg.FaceCheckActionEngine", "YTFaceTraceInterface.initModel failed，return:".concat(String.valueOf(i)));
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    AppMethodBeat.o(685);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.b
 * JD-Core Version:    0.7.0.1
 */