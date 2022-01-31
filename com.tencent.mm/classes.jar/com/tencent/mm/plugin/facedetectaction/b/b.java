package com.tencent.mm.plugin.facedetectaction.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
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
  public int jWb;
  public YTPoseDetectInterface.PoseDetectOnFrame jWc = null;
  a jWd;
  public int status = -1;
  
  static
  {
    k.b("YTCommonEx", b.class.getClassLoader());
    k.b("YTFaceTrace", b.class.getClassLoader());
    k.b("YTNextCV", b.class.getClassLoader());
    k.b("YTPoseDetect", b.class.getClassLoader());
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
  }
  
  final boolean e(MMActivity paramMMActivity)
  {
    y.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
    for (;;)
    {
      try
      {
        InputStream localInputStream1 = ae.getContext().getAssets().open("face_detect" + File.separator + "ufdmtcc.bin");
        InputStream localInputStream2 = ae.getContext().getAssets().open("face_detect" + File.separator + "ufat.bin");
        arrayOfByte2 = new byte[localInputStream1.available()];
        y.i("MicroMsg.FaceCheckActionEngine", "load ufat.bin or ufdmtcc.bin failed" + localIOException1.getMessage());
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
          if (!FileOp.bK(o.aOF()))
          {
            y.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance copy post detect model file");
            o.n(ae.getContext(), "face_detect" + File.separator + "PE.dat", o.aOF());
          }
          y.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel FielPath: %s", new Object[] { o.aOF() });
          i = YTPoseDetectInterface.initModel(o.aOF());
          y.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label288;
          }
          y.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel failed，return:" + i);
          i = 0;
          if (i == 0) {
            break;
          }
          YTCommonExInterface.setAppBrightness(paramMMActivity, 255);
          this.status = 1;
          return true;
        }
        catch (IOException localIOException3)
        {
          break label260;
        }
        localIOException1 = localIOException1;
        arrayOfByte1 = null;
        arrayOfByte2 = null;
      }
      label260:
      continue;
      label288:
      i = YTFaceTraceInterface.initModel(arrayOfByte2, arrayOfByte1);
      if (i != 0)
      {
        y.i("MicroMsg.FaceCheckActionEngine", "YTFaceTraceInterface.initModel failed，return:" + i);
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.b
 * JD-Core Version:    0.7.0.1
 */