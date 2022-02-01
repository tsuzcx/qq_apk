package com.tencent.liteav.basic.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCBuild
{
  private static String BOARD = "";
  private static String BRAND;
  private static String HARDWARE;
  private static String MANUFACTURER;
  private static String MODEL = "";
  private static final String TAG = "TXCBuild";
  private static String VERSION;
  private static int VERSION_INT;
  
  static
  {
    BRAND = "";
    MANUFACTURER = "";
    HARDWARE = "";
    VERSION = "";
    VERSION_INT = 0;
  }
  
  public static String Board()
  {
    AppMethodBeat.i(230232);
    if ((BOARD == null) || (BOARD.isEmpty())) {}
    try
    {
      if ((BOARD == null) || (BOARD.isEmpty()))
      {
        BOARD = Build.BOARD;
        TXCLog.i("TXCBuild", "get BOARD by Build.BOARD :" + BOARD);
      }
      String str = BOARD;
      AppMethodBeat.o(230232);
      return str;
    }
    finally
    {
      AppMethodBeat.o(230232);
    }
  }
  
  public static String Brand()
  {
    AppMethodBeat.i(230177);
    if ((BRAND == null) || (BRAND.isEmpty())) {}
    try
    {
      if ((BRAND == null) || (BRAND.isEmpty()))
      {
        BRAND = Build.BRAND;
        TXCLog.i("TXCBuild", "get BRAND by Build.BRAND :" + BRAND);
      }
      String str = BRAND;
      AppMethodBeat.o(230177);
      return str;
    }
    finally
    {
      AppMethodBeat.o(230177);
    }
  }
  
  public static String Hardware()
  {
    AppMethodBeat.i(230195);
    if ((HARDWARE == null) || (HARDWARE.isEmpty())) {}
    try
    {
      if ((HARDWARE == null) || (HARDWARE.isEmpty()))
      {
        HARDWARE = Build.HARDWARE;
        TXCLog.i("TXCBuild", "get HARDWARE by Build.HARDWARE :" + HARDWARE);
      }
      String str = HARDWARE;
      AppMethodBeat.o(230195);
      return str;
    }
    finally
    {
      AppMethodBeat.o(230195);
    }
  }
  
  public static String Manufacturer()
  {
    AppMethodBeat.i(230185);
    if ((MANUFACTURER == null) || (MANUFACTURER.isEmpty())) {}
    try
    {
      if ((MANUFACTURER == null) || (MANUFACTURER.isEmpty()))
      {
        MANUFACTURER = Build.MANUFACTURER;
        TXCLog.i("TXCBuild", "get MANUFACTURER by Build.MANUFACTURER :" + MANUFACTURER);
      }
      String str = MANUFACTURER;
      AppMethodBeat.o(230185);
      return str;
    }
    finally
    {
      AppMethodBeat.o(230185);
    }
  }
  
  public static String Model()
  {
    AppMethodBeat.i(230168);
    if ((MODEL == null) || (MODEL.isEmpty())) {}
    try
    {
      if ((MODEL == null) || (MODEL.isEmpty()))
      {
        MODEL = Build.MODEL;
        TXCLog.i("TXCBuild", "get MODEL by Build.MODEL :" + MODEL);
      }
      String str = MODEL;
      AppMethodBeat.o(230168);
      return str;
    }
    finally
    {
      AppMethodBeat.o(230168);
    }
  }
  
  public static void SetBoard(String paramString)
  {
    try
    {
      BOARD = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void SetBrand(String paramString)
  {
    try
    {
      BRAND = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void SetHardware(String paramString)
  {
    try
    {
      HARDWARE = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void SetManufacturer(String paramString)
  {
    try
    {
      MANUFACTURER = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void SetModel(String paramString)
  {
    try
    {
      MODEL = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void SetVersion(String paramString)
  {
    try
    {
      VERSION = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void SetVersionInt(int paramInt)
  {
    try
    {
      VERSION_INT = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String Version()
  {
    AppMethodBeat.i(230208);
    if ((VERSION == null) || (VERSION.isEmpty())) {}
    try
    {
      if ((VERSION == null) || (VERSION.isEmpty()))
      {
        VERSION = Build.VERSION.RELEASE;
        TXCLog.i("TXCBuild", "get VERSION by Build.VERSION.RELEASE :" + VERSION);
      }
      String str = VERSION;
      AppMethodBeat.o(230208);
      return str;
    }
    finally
    {
      AppMethodBeat.o(230208);
    }
  }
  
  public static int VersionInt()
  {
    AppMethodBeat.i(230220);
    if (VERSION_INT == 0) {}
    try
    {
      if (VERSION_INT == 0)
      {
        VERSION_INT = Build.VERSION.SDK_INT;
        TXCLog.i("TXCBuild", "get VERSION_INT by Build.VERSION.SDK_INT :" + VERSION_INT);
      }
      int i = VERSION_INT;
      AppMethodBeat.o(230220);
      return i;
    }
    finally
    {
      AppMethodBeat.o(230220);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXCBuild
 * JD-Core Version:    0.7.0.1
 */