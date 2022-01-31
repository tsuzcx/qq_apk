package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

@SafeParcelable.Class(creator="BitmapTeleporterCreator")
public class BitmapTeleporter
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR;
  @SafeParcelable.Field(id=3)
  private final int zzac;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @SafeParcelable.Field(id=2)
  private ParcelFileDescriptor zznb;
  private Bitmap zznc;
  private boolean zznd;
  private File zzne;
  
  static
  {
    AppMethodBeat.i(61016);
    CREATOR = new BitmapTeleporterCreator();
    AppMethodBeat.o(61016);
  }
  
  @SafeParcelable.Constructor
  BitmapTeleporter(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) ParcelFileDescriptor paramParcelFileDescriptor, @SafeParcelable.Param(id=3) int paramInt2)
  {
    this.zzal = paramInt1;
    this.zznb = paramParcelFileDescriptor;
    this.zzac = paramInt2;
    this.zznc = null;
    this.zznd = false;
  }
  
  public BitmapTeleporter(Bitmap paramBitmap)
  {
    this.zzal = 1;
    this.zznb = null;
    this.zzac = 0;
    this.zznc = paramBitmap;
    this.zznd = true;
  }
  
  private static void zza(Closeable paramCloseable)
  {
    AppMethodBeat.i(61015);
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(61015);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(61015);
    }
  }
  
  /* Error */
  private final java.io.FileOutputStream zzcj()
  {
    // Byte code:
    //   0: ldc 81
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 83	com/google/android/gms/common/data/BitmapTeleporter:zzne	Ljava/io/File;
    //   9: ifnonnull +20 -> 29
    //   12: new 85	java/lang/IllegalStateException
    //   15: dup
    //   16: ldc 87
    //   18: invokespecial 90	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: ldc 81
    //   24: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: ldc 92
    //   31: ldc 94
    //   33: aload_0
    //   34: getfield 83	com/google/android/gms/common/data/BitmapTeleporter:zzne	Ljava/io/File;
    //   37: invokestatic 100	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   40: astore_1
    //   41: new 102	java/io/FileOutputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: astore_2
    //   50: aload_0
    //   51: aload_1
    //   52: ldc 106
    //   54: invokestatic 112	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   57: putfield 57	com/google/android/gms/common/data/BitmapTeleporter:zznb	Landroid/os/ParcelFileDescriptor;
    //   60: aload_1
    //   61: invokevirtual 116	java/io/File:delete	()Z
    //   64: pop
    //   65: ldc 81
    //   67: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_2
    //   71: areturn
    //   72: astore_1
    //   73: new 85	java/lang/IllegalStateException
    //   76: dup
    //   77: ldc 118
    //   79: aload_1
    //   80: invokespecial 121	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: astore_1
    //   84: ldc 81
    //   86: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: new 85	java/lang/IllegalStateException
    //   95: dup
    //   96: ldc 123
    //   98: invokespecial 90	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   101: astore_1
    //   102: ldc 81
    //   104: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	BitmapTeleporter
    //   21	40	1	localObject	Object
    //   72	8	1	localIOException	IOException
    //   83	7	1	localIllegalStateException1	IllegalStateException
    //   91	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   101	7	1	localIllegalStateException2	IllegalStateException
    //   49	22	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   29	41	72	java/io/IOException
    //   41	60	91	java/io/FileNotFoundException
  }
  
  public Bitmap get()
  {
    AppMethodBeat.i(61010);
    Object localObject1;
    if (!this.zznd) {
      localObject1 = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zznb));
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
      this.zznc = ((Bitmap)localObject2);
      this.zznd = true;
      localObject1 = this.zznc;
      AppMethodBeat.o(61010);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Could not read from parcel file descriptor", localIOException);
      AppMethodBeat.o(61010);
      throw localIllegalStateException;
    }
    finally
    {
      zza((Closeable)localObject1);
      AppMethodBeat.o(61010);
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(61012);
    if (!this.zznd) {
      try
      {
        this.zznb.close();
        AppMethodBeat.o(61012);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(61012);
  }
  
  public void setTempDir(File paramFile)
  {
    AppMethodBeat.i(61013);
    if (paramFile == null)
    {
      paramFile = new NullPointerException("Cannot set null temp directory");
      AppMethodBeat.o(61013);
      throw paramFile;
    }
    this.zzne = paramFile;
    AppMethodBeat.o(61013);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61011);
    Bitmap localBitmap;
    Object localObject;
    byte[] arrayOfByte;
    if (this.zznb == null)
    {
      localBitmap = this.zznc;
      localObject = ByteBuffer.allocate(localBitmap.getRowBytes() * localBitmap.getHeight());
      localBitmap.copyPixelsToBuffer((Buffer)localObject);
      arrayOfByte = ((ByteBuffer)localObject).array();
      localObject = new DataOutputStream(new BufferedOutputStream(zzcj()));
    }
    try
    {
      ((DataOutputStream)localObject).writeInt(arrayOfByte.length);
      ((DataOutputStream)localObject).writeInt(localBitmap.getWidth());
      ((DataOutputStream)localObject).writeInt(localBitmap.getHeight());
      ((DataOutputStream)localObject).writeUTF(localBitmap.getConfig().toString());
      ((DataOutputStream)localObject).write(arrayOfByte);
      zza((Closeable)localObject);
      int i = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
      SafeParcelWriter.writeParcelable(paramParcel, 2, this.zznb, paramInt | 0x1, false);
      SafeParcelWriter.writeInt(paramParcel, 3, this.zzac);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      this.zznb = null;
      AppMethodBeat.o(61011);
      return;
    }
    catch (IOException paramParcel)
    {
      paramParcel = new IllegalStateException("Could not write into unlinked file", paramParcel);
      AppMethodBeat.o(61011);
      throw paramParcel;
    }
    finally
    {
      zza((Closeable)localObject);
      AppMethodBeat.o(61011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.data.BitmapTeleporter
 * JD-Core Version:    0.7.0.1
 */