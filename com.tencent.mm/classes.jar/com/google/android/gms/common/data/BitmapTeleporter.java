package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BitmapTeleporter
  extends com.google.android.gms.common.internal.safeparcel.zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zza();
  ParcelFileDescriptor zzSQ;
  private Bitmap zzaDF;
  private boolean zzaDG;
  private File zzaDH;
  final int zzaiI;
  final int zzakD;
  
  BitmapTeleporter(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2)
  {
    this.zzaiI = paramInt1;
    this.zzSQ = paramParcelFileDescriptor;
    this.zzakD = paramInt2;
    this.zzaDF = null;
    this.zzaDG = false;
  }
  
  public BitmapTeleporter(Bitmap paramBitmap)
  {
    this.zzaiI = 1;
    this.zzSQ = null;
    this.zzakD = 0;
    this.zzaDF = paramBitmap;
    this.zzaDG = true;
  }
  
  private void zza(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  /* Error */
  private java.io.FileOutputStream zzxh()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/google/android/gms/common/data/BitmapTeleporter:zzaDH	Ljava/io/File;
    //   4: ifnonnull +13 -> 17
    //   7: new 60	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 62
    //   13: invokespecial 65	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 67
    //   19: ldc 69
    //   21: aload_0
    //   22: getfield 58	com/google/android/gms/common/data/BitmapTeleporter:zzaDH	Ljava/io/File;
    //   25: invokestatic 75	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   28: astore_1
    //   29: new 77	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_0
    //   39: aload_1
    //   40: ldc 81
    //   42: invokestatic 87	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   45: putfield 36	com/google/android/gms/common/data/BitmapTeleporter:zzSQ	Landroid/os/ParcelFileDescriptor;
    //   48: aload_1
    //   49: invokevirtual 91	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_2
    //   54: areturn
    //   55: astore_1
    //   56: new 60	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 93
    //   62: aload_1
    //   63: invokespecial 96	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore_1
    //   68: new 60	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc 98
    //   74: invokespecial 65	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	BitmapTeleporter
    //   28	21	1	localFile	File
    //   55	8	1	localIOException	IOException
    //   67	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   37	17	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	29	55	java/io/IOException
    //   29	48	67	java/io/FileNotFoundException
  }
  
  public void release()
  {
    if (!this.zzaDG) {}
    try
    {
      this.zzSQ.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bitmap localBitmap;
    Object localObject;
    byte[] arrayOfByte;
    if (this.zzSQ == null)
    {
      localBitmap = this.zzaDF;
      localObject = ByteBuffer.allocate(localBitmap.getRowBytes() * localBitmap.getHeight());
      localBitmap.copyPixelsToBuffer((Buffer)localObject);
      arrayOfByte = ((ByteBuffer)localObject).array();
      localObject = new DataOutputStream(zzxh());
    }
    try
    {
      ((DataOutputStream)localObject).writeInt(arrayOfByte.length);
      ((DataOutputStream)localObject).writeInt(localBitmap.getWidth());
      ((DataOutputStream)localObject).writeInt(localBitmap.getHeight());
      ((DataOutputStream)localObject).writeUTF(localBitmap.getConfig().toString());
      ((DataOutputStream)localObject).write(arrayOfByte);
      zza((Closeable)localObject);
      zza.zza(this, paramParcel, paramInt | 0x1);
      this.zzSQ = null;
      return;
    }
    catch (IOException paramParcel)
    {
      throw new IllegalStateException("Could not write into unlinked file", paramParcel);
    }
    finally
    {
      zza((Closeable)localObject);
    }
  }
  
  public void zzd(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("Cannot set null temp directory");
    }
    this.zzaDH = paramFile;
  }
  
  public Bitmap zzxg()
  {
    Object localObject1;
    if (!this.zzaDG) {
      localObject1 = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzSQ));
    }
    try
    {
      byte[] arrayOfByte = new byte[((DataInputStream)localObject1).readInt()];
      int i = ((DataInputStream)localObject1).readInt();
      int j = ((DataInputStream)localObject1).readInt();
      Object localObject2 = Bitmap.Config.valueOf(((DataInputStream)localObject1).readUTF());
      ((DataInputStream)localObject1).read(arrayOfByte);
      zza((Closeable)localObject1);
      localObject1 = ByteBuffer.wrap(arrayOfByte);
      localObject2 = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject2);
      ((Bitmap)localObject2).copyPixelsFromBuffer((Buffer)localObject1);
      this.zzaDF = ((Bitmap)localObject2);
      this.zzaDG = true;
      return this.zzaDF;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("Could not read from parcel file descriptor", localIOException);
    }
    finally
    {
      zza((Closeable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.data.BitmapTeleporter
 * JD-Core Version:    0.7.0.1
 */