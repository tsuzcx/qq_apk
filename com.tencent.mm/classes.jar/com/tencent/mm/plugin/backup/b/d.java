package com.tencent.mm.plugin.backup.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public abstract class d
  extends a
{
  private static String TAG = "MicroMsg.BackupModel";
  private static boolean dJq = false;
  private static int hFq = 0;
  private static byte[] hFr = "key".getBytes();
  private static SharedPreferences hFt;
  public String hFm = "id";
  public String hFn = "hello";
  public String hFo = "ok";
  public e hFp;
  public byte[] hFs;
  
  public static void T(byte[] paramArrayOfByte)
  {
    hFr = paramArrayOfByte;
  }
  
  public static int atq()
  {
    return hFq;
  }
  
  public static byte[] atr()
  {
    return hFr;
  }
  
  public static SharedPreferences ats()
  {
    if (hFt == null) {
      hFt = ae.getContext().getSharedPreferences("BACKUP_CONFIG", 4);
    }
    return hFt;
  }
  
  public static void att()
  {
    y.i(TAG, "holdReset");
    dJq = true;
  }
  
  public static boolean atu()
  {
    return dJq;
  }
  
  public static void atv()
  {
    hFr = "key".getBytes();
    hFq = 0;
    hFt = null;
    dJq = false;
  }
  
  public static void nu(int paramInt)
  {
    hFq = paramInt;
  }
  
  public final e atn()
  {
    if (this.hFp == null) {
      this.hFp = new e();
    }
    return this.hFp;
  }
  
  public abstract void ato();
  
  public abstract void atp();
  
  public abstract void l(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.d
 * JD-Core Version:    0.7.0.1
 */