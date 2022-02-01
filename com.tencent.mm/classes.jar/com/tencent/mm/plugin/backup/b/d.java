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
  private static boolean kbA = false;
  private static int rKO = 0;
  private static byte[] rKP = "key".getBytes();
  private static SharedPreferences rKR;
  public String rKK = "id";
  public String rKL = "hello";
  public String rKM = "ok";
  public e rKN;
  public byte[] rKQ;
  
  public static void EC(int paramInt)
  {
    rKO = paramInt;
  }
  
  public static void bf(byte[] paramArrayOfByte)
  {
    rKP = paramArrayOfByte;
  }
  
  public static int csc()
  {
    return rKO;
  }
  
  public static byte[] csd()
  {
    return rKP;
  }
  
  public static SharedPreferences cse()
  {
    if (rKR == null) {
      rKR = MMApplicationContext.getContext().getSharedPreferences("BACKUP_CONFIG", g.avK());
    }
    return rKR;
  }
  
  public static void csf()
  {
    Log.i(TAG, "holdReset");
    kbA = true;
  }
  
  public static boolean csg()
  {
    return kbA;
  }
  
  public static void csh()
  {
    rKP = "key".getBytes();
    rKO = 0;
    rKR = null;
    kbA = false;
  }
  
  public final e crZ()
  {
    if (this.rKN == null) {
      this.rKN = new e();
    }
    return this.rKN;
  }
  
  public abstract void csa();
  
  public abstract void csb();
  
  public abstract void n(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.d
 * JD-Core Version:    0.7.0.1
 */