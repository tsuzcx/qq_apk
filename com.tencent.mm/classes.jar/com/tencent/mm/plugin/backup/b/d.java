package com.tencent.mm.plugin.backup.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public abstract class d
  extends a
{
  private static String TAG = "MicroMsg.BackupModel";
  private static boolean ggB = false;
  private static int mSg = 0;
  private static byte[] mSh = "key".getBytes();
  private static SharedPreferences mSj;
  public String mSc = "id";
  public String mSd = "hello";
  public String mSe = "ok";
  public e mSf;
  public byte[] mSi;
  
  public static void aB(byte[] paramArrayOfByte)
  {
    mSh = paramArrayOfByte;
  }
  
  public static int bCS()
  {
    return mSg;
  }
  
  public static byte[] bCT()
  {
    return mSh;
  }
  
  public static SharedPreferences bCU()
  {
    if (mSj == null) {
      mSj = ai.getContext().getSharedPreferences("BACKUP_CONFIG", g.YK());
    }
    return mSj;
  }
  
  public static void bCV()
  {
    ac.i(TAG, "holdReset");
    ggB = true;
  }
  
  public static boolean bCW()
  {
    return ggB;
  }
  
  public static void bCX()
  {
    mSh = "key".getBytes();
    mSg = 0;
    mSj = null;
    ggB = false;
  }
  
  public static void wK(int paramInt)
  {
    mSg = paramInt;
  }
  
  public final e bCP()
  {
    if (this.mSf == null) {
      this.mSf = new e();
    }
    return this.mSf;
  }
  
  public abstract void bCQ();
  
  public abstract void bCR();
  
  public abstract void p(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.d
 * JD-Core Version:    0.7.0.1
 */