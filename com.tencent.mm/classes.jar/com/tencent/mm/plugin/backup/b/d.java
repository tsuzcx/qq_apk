package com.tencent.mm.plugin.backup.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public abstract class d
  extends a
{
  private static String TAG = "MicroMsg.BackupModel";
  private static boolean mBG = false;
  private static int uWc = 0;
  private static byte[] uWd = "key".getBytes();
  private static SharedPreferences uWf;
  public String uVY = "id";
  public String uVZ = "hello";
  public String uWa = "ok";
  public e uWb;
  public byte[] uWe;
  
  public static void Fd(int paramInt)
  {
    uWc = paramInt;
  }
  
  public static void bf(byte[] paramArrayOfByte)
  {
    uWd = paramArrayOfByte;
  }
  
  public static int cUM()
  {
    return uWc;
  }
  
  public static byte[] cUN()
  {
    return uWd;
  }
  
  public static SharedPreferences cUO()
  {
    if (uWf == null) {
      uWf = MMApplicationContext.getContext().getSharedPreferences("BACKUP_CONFIG", g.aQe());
    }
    return uWf;
  }
  
  public static void cUP()
  {
    Log.i(TAG, "holdReset");
    mBG = true;
  }
  
  public static boolean cUQ()
  {
    return mBG;
  }
  
  public static void cUR()
  {
    uWd = "key".getBytes();
    uWc = 0;
    uWf = null;
    mBG = false;
  }
  
  public final e cUJ()
  {
    if (this.uWb == null) {
      this.uWb = new e();
    }
    return this.uWb;
  }
  
  public abstract void cUK();
  
  public abstract void cUL();
  
  public abstract void p(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.d
 * JD-Core Version:    0.7.0.1
 */