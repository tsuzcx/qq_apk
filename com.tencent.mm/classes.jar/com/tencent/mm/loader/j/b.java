package com.tencent.mm.loader.j;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;

public class b
{
  public static String eQA;
  public static final String eQu;
  public static final String eQv = eQu + "MicroMsg/";
  public static final String eQw;
  public static String eQx;
  public static String eQy;
  public static String eQz;
  
  static
  {
    Object localObject = ah.getContext();
    if (localObject == null) {
      throw new RuntimeException("MMApplicationContext not initialized.");
    }
    eQu = ((Context)localObject).getFilesDir().getParentFile().getAbsolutePath() + "/";
    try
    {
      localObject = new File(eQv);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      label96:
      eQw = eQu + "files/public/";
      if (ah.dsV()) {}
      for (localObject = "/sdcard";; localObject = Environment.getExternalStorageDirectory().getAbsolutePath())
      {
        eQx = (String)localObject;
        eQy = "/tencent/MicroMsg/";
        eQz = eQx + eQy;
        eQA = eQz + "crash/";
        return;
      }
    }
    catch (Error localError)
    {
      break label96;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.j.b
 * JD-Core Version:    0.7.0.1
 */