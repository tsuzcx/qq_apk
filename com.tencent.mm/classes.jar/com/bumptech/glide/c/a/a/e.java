package com.bumptech.glide.c.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

final class e
{
  private static final a aCW;
  private final b aCQ;
  private final ContentResolver aCR;
  private final a aCX;
  private final d aCY;
  private final List<f> aCZ;
  
  static
  {
    AppMethodBeat.i(76913);
    aCW = new a();
    AppMethodBeat.o(76913);
  }
  
  private e(List<f> paramList, a parama, d paramd, b paramb, ContentResolver paramContentResolver)
  {
    this.aCX = parama;
    this.aCY = paramd;
    this.aCQ = paramb;
    this.aCR = paramContentResolver;
    this.aCZ = paramList;
  }
  
  e(List<f> paramList, d paramd, b paramb, ContentResolver paramContentResolver)
  {
    this(paramList, aCW, paramd, paramb, paramContentResolver);
  }
  
  private String k(Uri paramUri)
  {
    AppMethodBeat.i(76912);
    paramUri = this.aCY.h(paramUri);
    if (paramUri != null) {}
    try
    {
      if (paramUri.moveToFirst())
      {
        String str = paramUri.getString(0);
        return str;
      }
      return null;
    }
    finally
    {
      if (paramUri != null) {
        paramUri.close();
      }
      AppMethodBeat.o(76912);
    }
  }
  
  /* Error */
  final int i(Uri paramUri)
  {
    // Byte code:
    //   0: ldc 82
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 46	com/bumptech/glide/c/a/a/e:aCR	Landroid/content/ContentResolver;
    //   11: aload_1
    //   12: invokevirtual 88	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   15: astore 4
    //   17: aload 4
    //   19: astore_3
    //   20: aload_3
    //   21: astore 4
    //   23: aload_0
    //   24: getfield 48	com/bumptech/glide/c/a/a/e:aCZ	Ljava/util/List;
    //   27: aload_3
    //   28: aload_0
    //   29: getfield 44	com/bumptech/glide/c/a/a/e:aCQ	Lcom/bumptech/glide/c/b/a/b;
    //   32: invokestatic 94	com/bumptech/glide/c/g:b	(Ljava/util/List;Ljava/io/InputStream;Lcom/bumptech/glide/c/b/a/b;)I
    //   35: istore_2
    //   36: aload_3
    //   37: ifnull +7 -> 44
    //   40: aload_3
    //   41: invokevirtual 97	java/io/InputStream:close	()V
    //   44: ldc 82
    //   46: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iload_2
    //   50: ireturn
    //   51: astore 4
    //   53: aload_3
    //   54: astore 4
    //   56: ldc 99
    //   58: iconst_3
    //   59: invokestatic 105	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   62: ifeq +20 -> 82
    //   65: aload_3
    //   66: astore 4
    //   68: new 107	java/lang/StringBuilder
    //   71: dup
    //   72: ldc 109
    //   74: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_1
    //   78: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: ifnull +7 -> 90
    //   86: aload_3
    //   87: invokevirtual 97	java/io/InputStream:close	()V
    //   90: ldc 82
    //   92: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: iconst_m1
    //   96: ireturn
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_3
    //   100: aload_3
    //   101: ifnull +7 -> 108
    //   104: aload_3
    //   105: invokevirtual 97	java/io/InputStream:close	()V
    //   108: ldc 82
    //   110: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: goto -72 -> 44
    //   119: astore_1
    //   120: goto -30 -> 90
    //   123: astore_3
    //   124: goto -16 -> 108
    //   127: astore_1
    //   128: aload 4
    //   130: astore_3
    //   131: goto -31 -> 100
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_3
    //   137: goto -84 -> 53
    //   140: astore 4
    //   142: goto -89 -> 53
    //   145: astore 4
    //   147: goto -94 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	e
    //   0	150	1	paramUri	Uri
    //   35	15	2	i	int
    //   6	99	3	localObject1	Object
    //   123	1	3	localIOException1	java.io.IOException
    //   130	1	3	localObject2	Object
    //   134	1	3	localNullPointerException1	NullPointerException
    //   136	1	3	localObject3	Object
    //   15	7	4	localObject4	Object
    //   51	1	4	localIOException2	java.io.IOException
    //   54	75	4	localObject5	Object
    //   140	1	4	localNullPointerException2	NullPointerException
    //   145	1	4	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   7	17	51	java/io/IOException
    //   7	17	97	finally
    //   40	44	115	java/io/IOException
    //   86	90	119	java/io/IOException
    //   104	108	123	java/io/IOException
    //   23	36	127	finally
    //   56	65	127	finally
    //   68	82	127	finally
    //   7	17	134	java/lang/NullPointerException
    //   23	36	140	java/lang/NullPointerException
    //   23	36	145	java/io/IOException
  }
  
  public final InputStream j(Uri paramUri)
  {
    AppMethodBeat.i(76911);
    Object localObject = k(paramUri);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AppMethodBeat.o(76911);
      return null;
    }
    localObject = new File((String)localObject);
    if ((((File)localObject).exists()) && (0L < ((File)localObject).length())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(76911);
      return null;
    }
    localObject = Uri.fromFile((File)localObject);
    try
    {
      InputStream localInputStream = this.aCR.openInputStream((Uri)localObject);
      AppMethodBeat.o(76911);
      return localInputStream;
    }
    catch (NullPointerException localNullPointerException)
    {
      paramUri = (FileNotFoundException)new FileNotFoundException("NPE opening uri: " + paramUri + " -> " + localObject).initCause(localNullPointerException);
      AppMethodBeat.o(76911);
      throw paramUri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.a.a.e
 * JD-Core Version:    0.7.0.1
 */