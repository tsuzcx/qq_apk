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
  private static boolean gbV = false;
  private static int mqf = 0;
  private static byte[] mqg = "key".getBytes();
  private static SharedPreferences mqi;
  public String mqb = "id";
  public String mqc = "hello";
  public String mqd = "ok";
  public e mqe;
  public byte[] mqh;
  
  public static void aC(byte[] paramArrayOfByte)
  {
    mqg = paramArrayOfByte;
  }
  
  public static int bvW()
  {
    return mqf;
  }
  
  public static byte[] bvX()
  {
    return mqg;
  }
  
  public static SharedPreferences bvY()
  {
    if (mqi == null) {
      mqi = aj.getContext().getSharedPreferences("BACKUP_CONFIG", g.XN());
    }
    return mqi;
  }
  
  public static void bvZ()
  {
    ad.i(TAG, "holdReset");
    gbV = true;
  }
  
  public static boolean bwa()
  {
    return gbV;
  }
  
  public static void bwb()
  {
    mqg = "key".getBytes();
    mqf = 0;
    mqi = null;
    gbV = false;
  }
  
  public static void vT(int paramInt)
  {
    mqf = paramInt;
  }
  
  public final e bvT()
  {
    if (this.mqe == null) {
      this.mqe = new e();
    }
    return this.mqe;
  }
  
  public abstract void bvU();
  
  public abstract void bvV();
  
  public abstract void o(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.d
 * JD-Core Version:    0.7.0.1
 */