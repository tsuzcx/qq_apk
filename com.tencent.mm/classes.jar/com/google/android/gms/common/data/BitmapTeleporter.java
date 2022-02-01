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
    AppMethodBeat.i(11508);
    CREATOR = new BitmapTeleporterCreator();
    AppMethodBeat.o(11508);
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
    AppMethodBeat.i(11507);
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(11507);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(11507);
    }
  }
  
  /* Error */
  private final java.io.FileOutputStream zzcj()
  {
    // Byte code:
    //   0: sipush 11506
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 80	com/google/android/gms/common/data/BitmapTeleporter:zzne	Ljava/io/File;
    //   10: ifnonnull +21 -> 31
    //   13: new 82	java/lang/IllegalStateException
    //   16: dup
    //   17: ldc 84
    //   19: invokespecial 87	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: sipush 11506
    //   26: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_1
    //   30: athrow
    //   31: ldc 89
    //   33: ldc 91
    //   35: aload_0
    //   36: getfield 80	com/google/android/gms/common/data/BitmapTeleporter:zzne	Ljava/io/File;
    //   39: invokestatic 97	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   42: astore_1
    //   43: new 99	java/io/FileOutputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   51: astore_2
    //   52: aload_0
    //   53: aload_1
    //   54: ldc 103
    //   56: invokestatic 109	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   59: putfield 56	com/google/android/gms/common/data/BitmapTeleporter:zznb	Landroid/os/ParcelFileDescriptor;
    //   62: aload_1
    //   63: invokevirtual 113	java/io/File:delete	()Z
    //   66: pop
    //   67: sipush 11506
    //   70: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_2
    //   74: areturn
    //   75: astore_1
    //   76: new 82	java/lang/IllegalStateException
    //   79: dup
    //   80: ldc 115
    //   82: aload_1
    //   83: invokespecial 118	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: astore_1
    //   87: sipush 11506
    //   90: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: new 82	java/lang/IllegalStateException
    //   99: dup
    //   100: ldc 120
    //   102: invokespecial 87	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   105: astore_1
    //   106: sipush 11506
    //   109: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	BitmapTeleporter
    //   22	41	1	localObject	Object
    //   75	8	1	localIOException	IOException
    //   86	8	1	localIllegalStateException1	IllegalStateException
    //   95	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   105	8	1	localIllegalStateException2	IllegalStateException
    //   51	23	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	43	75	java/io/IOException
    //   43	62	95	java/io/FileNotFoundException
  }
  
  public Bitmap get()
  {
    AppMethodBeat.i(11502);
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
      AppMethodBeat.o(11502);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Could not read from parcel file descriptor", localIOException);
      AppMethodBeat.o(11502);
      throw localIllegalStateException;
    }
    finally
    {
      zza((Closeable)localObject1);
      AppMethodBeat.o(11502);
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(11504);
    if (!this.zznd) {
      try
      {
        this.zznb.close();
        AppMethodBeat.o(11504);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(11504);
  }
  
  public void setTempDir(File paramFile)
  {
    AppMethodBeat.i(11505);
    if (paramFile == null)
    {
      paramFile = new NullPointerException("Cannot set null temp directory");
      AppMethodBeat.o(11505);
      throw paramFile;
    }
    this.zzne = paramFile;
    AppMethodBeat.o(11505);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(11503);
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
      AppMethodBeat.o(11503);
      return;
    }
    catch (IOException paramParcel)
    {
      paramParcel = new IllegalStateException("Could not write into unlinked file", paramParcel);
      AppMethodBeat.o(11503);
      throw paramParcel;
    }
    finally
    {
      zza((Closeable)localObject);
      AppMethodBeat.o(11503);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.data.BitmapTeleporter
 * JD-Core Version:    0.7.0.1
 */