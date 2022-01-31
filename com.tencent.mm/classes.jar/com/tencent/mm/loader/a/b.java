package com.tencent.mm.loader.a;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.File;

public class b
{
  public static String bkF;
  public static String bkG;
  public static String bkH;
  public static final String dOO;
  public static final String dOP = dOO + "MicroMsg/";
  public static final String dOQ;
  public static String dOR;
  
  static
  {
    Object localObject = ae.getContext();
    if (localObject == null) {
      throw new RuntimeException("MMApplicationContext not initialized.");
    }
    dOO = ((Context)localObject).getFilesDir().getParentFile().getAbsolutePath() + "/";
    try
    {
      localObject = new File(dOP);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      label96:
      dOQ = dOO + "files/public/";
      bkF = Environment.getExternalStorageDirectory().getAbsolutePath();
      bkG = "/tencent/MicroMsg/";
      bkH = bkF + bkG;
      dOR = bkH + "crash/";
      return;
    }
    catch (Error localError)
    {
      break label96;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.a.b
 * JD-Core Version:    0.7.0.1
 */