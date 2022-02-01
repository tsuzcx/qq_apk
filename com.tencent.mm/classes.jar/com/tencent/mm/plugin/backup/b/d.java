package com.tencent.mm.plugin.backup.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public abstract class d
  extends a
{
  private static String TAG = "MicroMsg.BackupModel";
  private static boolean gAl = false;
  private static int nsF = 0;
  private static byte[] nsG = "key".getBytes();
  private static SharedPreferences nsI;
  public String nsB = "id";
  public String nsC = "hello";
  public String nsD = "ok";
  public e nsE;
  public byte[] nsH;
  
  public static void aB(byte[] paramArrayOfByte)
  {
    nsG = paramArrayOfByte;
  }
  
  public static int bHa()
  {
    return nsF;
  }
  
  public static byte[] bHb()
  {
    return nsG;
  }
  
  public static SharedPreferences bHc()
  {
    if (nsI == null) {
      nsI = aj.getContext().getSharedPreferences("BACKUP_CONFIG", g.abm());
    }
    return nsI;
  }
  
  public static void bHd()
  {
    ad.i(TAG, "holdReset");
    gAl = true;
  }
  
  public static boolean bHe()
  {
    return gAl;
  }
  
  public static void bHf()
  {
    nsG = "key".getBytes();
    nsF = 0;
    nsI = null;
    gAl = false;
  }
  
  public static void xq(int paramInt)
  {
    nsF = paramInt;
  }
  
  public final e bGX()
  {
    if (this.nsE == null) {
      this.nsE = new e();
    }
    return this.nsE;
  }
  
  public abstract void bGY();
  
  public abstract void bGZ();
  
  public abstract void p(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.d
 * JD-Core Version:    0.7.0.1
 */