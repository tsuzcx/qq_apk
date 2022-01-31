package com.tencent.mm.plugin.backup.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public abstract class d
  extends a
{
  private static String TAG = "MicroMsg.BackupModel";
  private static boolean eGO = false;
  private static int jyJ = 0;
  private static byte[] jyK = "key".getBytes();
  private static SharedPreferences jyM;
  public String jyF = "id";
  public String jyG = "hello";
  public String jyH = "ok";
  public e jyI;
  public byte[] jyL;
  
  public static int aSO()
  {
    return jyJ;
  }
  
  public static byte[] aSP()
  {
    return jyK;
  }
  
  public static SharedPreferences aSQ()
  {
    if (jyM == null) {
      jyM = ah.getContext().getSharedPreferences("BACKUP_CONFIG", h.Mp());
    }
    return jyM;
  }
  
  public static void aSR()
  {
    ab.i(TAG, "holdReset");
    eGO = true;
  }
  
  public static boolean aSS()
  {
    return eGO;
  }
  
  public static void aST()
  {
    jyK = "key".getBytes();
    jyJ = 0;
    jyM = null;
    eGO = false;
  }
  
  public static void an(byte[] paramArrayOfByte)
  {
    jyK = paramArrayOfByte;
  }
  
  public static void rg(int paramInt)
  {
    jyJ = paramInt;
  }
  
  public final e aSL()
  {
    if (this.jyI == null) {
      this.jyI = new e();
    }
    return this.jyI;
  }
  
  public abstract void aSM();
  
  public abstract void aSN();
  
  public abstract void m(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.d
 * JD-Core Version:    0.7.0.1
 */