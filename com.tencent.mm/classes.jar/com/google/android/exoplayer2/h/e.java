package com.google.android.exoplayer2.h;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class e
  implements f
{
  private final t<? super e> aQN;
  private InputStream aQO;
  private long aQP;
  private final ContentResolver aQQ;
  private AssetFileDescriptor aQR;
  private boolean opened;
  private Uri uri;
  
  public e(Context paramContext, t<? super e> paramt)
  {
    this.aQQ = paramContext.getContentResolver();
    this.aQN = paramt;
  }
  
  public final long a(i parami)
  {
    try
    {
      this.uri = parami.uri;
      this.aQR = this.aQQ.openAssetFileDescriptor(this.uri, "r");
      if (this.aQR == null) {
        throw new FileNotFoundException("Could not open file descriptor for: " + this.uri);
      }
    }
    catch (IOException parami)
    {
      throw new e.a(parami);
    }
    this.aQO = new FileInputStream(this.aQR.getFileDescriptor());
    long l1 = this.aQR.getStartOffset();
    l1 = this.aQO.skip(parami.position + l1) - l1;
    if (l1 != parami.position) {
      throw new EOFException();
    }
    if (parami.aQW != -1L) {
      this.aQP = parami.aQW;
    }
    for (;;)
    {
      this.opened = true;
      if (this.aQN != null) {
        this.aQN.nT();
      }
      return this.aQP;
      long l2 = this.aQR.getLength();
      if (l2 == -1L)
      {
        this.aQP = this.aQO.available();
        if (this.aQP == 0L) {
          this.aQP = -1L;
        }
      }
      else
      {
        this.aQP = (l2 - l1);
      }
    }
  }
  
  /* Error */
  public final void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 50	com/google/android/exoplayer2/h/e:uri	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 94	com/google/android/exoplayer2/h/e:aQO	Ljava/io/InputStream;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 94	com/google/android/exoplayer2/h/e:aQO	Ljava/io/InputStream;
    //   16: invokevirtual 134	java/io/InputStream:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 94	com/google/android/exoplayer2/h/e:aQO	Ljava/io/InputStream;
    //   24: aload_0
    //   25: getfield 60	com/google/android/exoplayer2/h/e:aQR	Landroid/content/res/AssetFileDescriptor;
    //   28: ifnull +10 -> 38
    //   31: aload_0
    //   32: getfield 60	com/google/android/exoplayer2/h/e:aQR	Landroid/content/res/AssetFileDescriptor;
    //   35: invokevirtual 135	android/content/res/AssetFileDescriptor:close	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 60	com/google/android/exoplayer2/h/e:aQR	Landroid/content/res/AssetFileDescriptor;
    //   43: aload_0
    //   44: getfield 119	com/google/android/exoplayer2/h/e:opened	Z
    //   47: ifeq +24 -> 71
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 119	com/google/android/exoplayer2/h/e:opened	Z
    //   55: aload_0
    //   56: getfield 38	com/google/android/exoplayer2/h/e:aQN	Lcom/google/android/exoplayer2/h/t;
    //   59: ifnull +12 -> 71
    //   62: aload_0
    //   63: getfield 38	com/google/android/exoplayer2/h/e:aQN	Lcom/google/android/exoplayer2/h/t;
    //   66: invokeinterface 138 1 0
    //   71: return
    //   72: astore_1
    //   73: new 8	com/google/android/exoplayer2/h/e$a
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 81	com/google/android/exoplayer2/h/e$a:<init>	(Ljava/io/IOException;)V
    //   81: athrow
    //   82: astore_1
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 60	com/google/android/exoplayer2/h/e:aQR	Landroid/content/res/AssetFileDescriptor;
    //   88: aload_0
    //   89: getfield 119	com/google/android/exoplayer2/h/e:opened	Z
    //   92: ifeq +24 -> 116
    //   95: aload_0
    //   96: iconst_0
    //   97: putfield 119	com/google/android/exoplayer2/h/e:opened	Z
    //   100: aload_0
    //   101: getfield 38	com/google/android/exoplayer2/h/e:aQN	Lcom/google/android/exoplayer2/h/t;
    //   104: ifnull +12 -> 116
    //   107: aload_0
    //   108: getfield 38	com/google/android/exoplayer2/h/e:aQN	Lcom/google/android/exoplayer2/h/t;
    //   111: invokeinterface 138 1 0
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: new 8	com/google/android/exoplayer2/h/e$a
    //   122: dup
    //   123: aload_1
    //   124: invokespecial 81	com/google/android/exoplayer2/h/e$a:<init>	(Ljava/io/IOException;)V
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 94	com/google/android/exoplayer2/h/e:aQO	Ljava/io/InputStream;
    //   134: aload_0
    //   135: getfield 60	com/google/android/exoplayer2/h/e:aQR	Landroid/content/res/AssetFileDescriptor;
    //   138: ifnull +10 -> 148
    //   141: aload_0
    //   142: getfield 60	com/google/android/exoplayer2/h/e:aQR	Landroid/content/res/AssetFileDescriptor;
    //   145: invokevirtual 135	android/content/res/AssetFileDescriptor:close	()V
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield 60	com/google/android/exoplayer2/h/e:aQR	Landroid/content/res/AssetFileDescriptor;
    //   153: aload_0
    //   154: getfield 119	com/google/android/exoplayer2/h/e:opened	Z
    //   157: ifeq +24 -> 181
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 119	com/google/android/exoplayer2/h/e:opened	Z
    //   165: aload_0
    //   166: getfield 38	com/google/android/exoplayer2/h/e:aQN	Lcom/google/android/exoplayer2/h/t;
    //   169: ifnull +12 -> 181
    //   172: aload_0
    //   173: getfield 38	com/google/android/exoplayer2/h/e:aQN	Lcom/google/android/exoplayer2/h/t;
    //   176: invokeinterface 138 1 0
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: new 8	com/google/android/exoplayer2/h/e$a
    //   187: dup
    //   188: aload_1
    //   189: invokespecial 81	com/google/android/exoplayer2/h/e$a:<init>	(Ljava/io/IOException;)V
    //   192: athrow
    //   193: astore_1
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 60	com/google/android/exoplayer2/h/e:aQR	Landroid/content/res/AssetFileDescriptor;
    //   199: aload_0
    //   200: getfield 119	com/google/android/exoplayer2/h/e:opened	Z
    //   203: ifeq +24 -> 227
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 119	com/google/android/exoplayer2/h/e:opened	Z
    //   211: aload_0
    //   212: getfield 38	com/google/android/exoplayer2/h/e:aQN	Lcom/google/android/exoplayer2/h/t;
    //   215: ifnull +12 -> 227
    //   218: aload_0
    //   219: getfield 38	com/google/android/exoplayer2/h/e:aQN	Lcom/google/android/exoplayer2/h/t;
    //   222: invokeinterface 138 1 0
    //   227: aload_1
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	e
    //   72	6	1	localIOException1	IOException
    //   82	35	1	localObject1	Object
    //   118	6	1	localIOException2	IOException
    //   128	54	1	localObject2	Object
    //   183	6	1	localIOException3	IOException
    //   193	35	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   24	38	72	java/io/IOException
    //   24	38	82	finally
    //   73	82	82	finally
    //   5	19	118	java/io/IOException
    //   5	19	128	finally
    //   119	128	128	finally
    //   134	148	183	java/io/IOException
    //   134	148	193	finally
    //   184	193	193	finally
  }
  
  public final Uri getUri()
  {
    return this.uri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = -1;
    int i;
    if (paramInt2 == 0) {
      i = 0;
    }
    for (;;)
    {
      return i;
      i = j;
      if (this.aQP != 0L) {
        try
        {
          if (this.aQP == -1L) {}
          for (;;)
          {
            paramInt1 = this.aQO.read(paramArrayOfByte, paramInt1, paramInt2);
            if (paramInt1 != -1) {
              break label111;
            }
            i = j;
            if (this.aQP == -1L) {
              break;
            }
            throw new e.a(new EOFException());
            long l = Math.min(this.aQP, paramInt2);
            paramInt2 = (int)l;
          }
          if (this.aQP == -1L) {
            break label133;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          throw new e.a(paramArrayOfByte);
        }
      }
    }
    label111:
    this.aQP -= paramInt1;
    label133:
    if (this.aQN != null) {
      this.aQN.dx(paramInt1);
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.h.e
 * JD-Core Version:    0.7.0.1
 */