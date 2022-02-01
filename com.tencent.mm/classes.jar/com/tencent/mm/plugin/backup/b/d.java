package com.tencent.mm.plugin.backup.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public abstract class d
  extends a
{
  private static String TAG = "MicroMsg.BackupModel";
  private static boolean gCS = false;
  private static int nya = 0;
  private static byte[] nyb = "key".getBytes();
  private static SharedPreferences nyd;
  public String nxW = "id";
  public String nxX = "hello";
  public String nxY = "ok";
  public e nxZ;
  public byte[] nyc;
  
  public static void aB(byte[] paramArrayOfByte)
  {
    nyb = paramArrayOfByte;
  }
  
  public static int bHY()
  {
    return nya;
  }
  
  public static byte[] bHZ()
  {
    return nyb;
  }
  
  public static SharedPreferences bIa()
  {
    if (nyd == null) {
      nyd = ak.getContext().getSharedPreferences("BACKUP_CONFIG", g.abv());
    }
    return nyd;
  }
  
  public static void bIb()
  {
    ae.i(TAG, "holdReset");
    gCS = true;
  }
  
  public static boolean bIc()
  {
    return gCS;
  }
  
  public static void bId()
  {
    nyb = "key".getBytes();
    nya = 0;
    nyd = null;
    gCS = false;
  }
  
  public static void xv(int paramInt)
  {
    nya = paramInt;
  }
  
  public final e bHV()
  {
    if (this.nxZ == null) {
      this.nxZ = new e();
    }
    return this.nxZ;
  }
  
  public abstract void bHW();
  
  public abstract void bHX();
  
  public abstract void o(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.d
 * JD-Core Version:    0.7.0.1
 */