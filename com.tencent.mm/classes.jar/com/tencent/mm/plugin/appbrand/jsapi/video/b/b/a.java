package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class a
  implements t
{
  private InputStream aFw;
  private final AssetManager bok;
  private long bom;
  private boolean opened;
  private String path;
  private String pvQ;
  private final s pwh;
  private long pwi;
  private long pwj;
  private Uri uri;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(230134);
    this.pwi = -1L;
    this.pwj = -1L;
    this.pvQ = "";
    this.bok = paramContext.getAssets();
    this.pwh = null;
    AppMethodBeat.o(230134);
  }
  
  /* Error */
  public final long a(g paramg)
  {
    // Byte code:
    //   0: ldc 69
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:uri	Landroid/net/Uri;
    //   10: putfield 74	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:uri	Landroid/net/Uri;
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 74	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:uri	Landroid/net/Uri;
    //   18: invokevirtual 80	android/net/Uri:getPath	()Ljava/lang/String;
    //   21: putfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:path	Ljava/lang/String;
    //   24: aload_0
    //   25: getfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:path	Ljava/lang/String;
    //   28: ldc 84
    //   30: invokevirtual 90	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   33: ifeq +167 -> 200
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:path	Ljava/lang/String;
    //   41: bipush 15
    //   43: invokevirtual 94	java/lang/String:substring	(I)Ljava/lang/String;
    //   46: putfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:path	Ljava/lang/String;
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 60	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:bok	Landroid/content/res/AssetManager;
    //   54: aload_0
    //   55: getfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:path	Ljava/lang/String;
    //   58: iconst_1
    //   59: invokevirtual 100	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   62: putfield 102	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:aFw	Ljava/io/InputStream;
    //   65: aload_0
    //   66: ldc2_w 43
    //   69: putfield 46	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:pwi	J
    //   72: aconst_null
    //   73: astore 5
    //   75: aconst_null
    //   76: astore 4
    //   78: aload_0
    //   79: getfield 60	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:bok	Landroid/content/res/AssetManager;
    //   82: aload_0
    //   83: getfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:path	Ljava/lang/String;
    //   86: invokevirtual 106	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   89: astore 6
    //   91: aload 6
    //   93: astore 4
    //   95: aload 6
    //   97: astore 5
    //   99: aload_0
    //   100: aload 6
    //   102: invokevirtual 112	android/content/res/AssetFileDescriptor:getLength	()J
    //   105: putfield 46	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:pwi	J
    //   108: aload 6
    //   110: ifnull +8 -> 118
    //   113: aload 6
    //   115: invokevirtual 115	android/content/res/AssetFileDescriptor:close	()V
    //   118: aload_0
    //   119: getfield 46	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:pwi	J
    //   122: ldc2_w 43
    //   125: lcmp
    //   126: ifne +10 -> 136
    //   129: aload_0
    //   130: ldc2_w 43
    //   133: putfield 46	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:pwi	J
    //   136: aload_0
    //   137: aload_0
    //   138: getfield 46	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:pwi	J
    //   141: aload_1
    //   142: getfield 118	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:position	J
    //   145: lsub
    //   146: putfield 48	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:pwj	J
    //   149: aload_0
    //   150: getfield 102	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:aFw	Ljava/io/InputStream;
    //   153: aload_1
    //   154: getfield 118	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:position	J
    //   157: invokevirtual 124	java/io/InputStream:skip	(J)J
    //   160: aload_1
    //   161: getfield 118	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:position	J
    //   164: lcmp
    //   165: ifge +100 -> 265
    //   168: new 126	java/io/EOFException
    //   171: dup
    //   172: invokespecial 127	java/io/EOFException:<init>	()V
    //   175: astore_1
    //   176: ldc 69
    //   178: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: new 8	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a$a
    //   187: dup
    //   188: aload_1
    //   189: invokespecial 130	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a$a:<init>	(Ljava/io/IOException;)V
    //   192: astore_1
    //   193: ldc 69
    //   195: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload_1
    //   199: athrow
    //   200: aload_0
    //   201: getfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:path	Ljava/lang/String;
    //   204: ldc 132
    //   206: invokevirtual 90	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   209: ifeq -160 -> 49
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:path	Ljava/lang/String;
    //   217: iconst_1
    //   218: invokevirtual 94	java/lang/String:substring	(I)Ljava/lang/String;
    //   221: putfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:path	Ljava/lang/String;
    //   224: goto -175 -> 49
    //   227: astore 5
    //   229: aload 4
    //   231: ifnull -113 -> 118
    //   234: aload 4
    //   236: invokevirtual 115	android/content/res/AssetFileDescriptor:close	()V
    //   239: goto -121 -> 118
    //   242: astore 4
    //   244: goto -126 -> 118
    //   247: astore_1
    //   248: aload 5
    //   250: ifnull +8 -> 258
    //   253: aload 5
    //   255: invokevirtual 115	android/content/res/AssetFileDescriptor:close	()V
    //   258: ldc 69
    //   260: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_1
    //   264: athrow
    //   265: aload_1
    //   266: getfield 135	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:aFL	J
    //   269: ldc2_w 43
    //   272: lcmp
    //   273: ifeq +44 -> 317
    //   276: aload_0
    //   277: aload_1
    //   278: getfield 135	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:aFL	J
    //   281: putfield 137	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:bom	J
    //   284: aload_0
    //   285: iconst_1
    //   286: putfield 139	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:opened	Z
    //   289: aload_0
    //   290: getfield 62	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:pwh	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/s;
    //   293: ifnull +12 -> 305
    //   296: aload_0
    //   297: getfield 62	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:pwh	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/s;
    //   300: invokeinterface 144 1 0
    //   305: aload_0
    //   306: getfield 137	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:bom	J
    //   309: lstore_2
    //   310: ldc 69
    //   312: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: lload_2
    //   316: lreturn
    //   317: aload_0
    //   318: aload_0
    //   319: getfield 102	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:aFw	Ljava/io/InputStream;
    //   322: invokevirtual 148	java/io/InputStream:available	()I
    //   325: i2l
    //   326: putfield 137	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:bom	J
    //   329: aload_0
    //   330: getfield 137	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:bom	J
    //   333: ldc2_w 149
    //   336: lcmp
    //   337: ifne -53 -> 284
    //   340: aload_0
    //   341: ldc2_w 43
    //   344: putfield 137	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/a:bom	J
    //   347: goto -63 -> 284
    //   350: astore 4
    //   352: goto -234 -> 118
    //   355: astore 4
    //   357: goto -99 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	a
    //   0	360	1	paramg	g
    //   309	7	2	l	long
    //   76	159	4	localObject1	Object
    //   242	1	4	localIOException1	IOException
    //   350	1	4	localIOException2	IOException
    //   355	1	4	localIOException3	IOException
    //   73	25	5	localObject2	Object
    //   227	27	5	localIOException4	IOException
    //   89	25	6	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    // Exception table:
    //   from	to	target	type
    //   5	49	183	java/io/IOException
    //   49	72	183	java/io/IOException
    //   118	136	183	java/io/IOException
    //   136	183	183	java/io/IOException
    //   200	224	183	java/io/IOException
    //   258	265	183	java/io/IOException
    //   265	284	183	java/io/IOException
    //   317	347	183	java/io/IOException
    //   78	91	227	java/io/IOException
    //   99	108	227	java/io/IOException
    //   234	239	242	java/io/IOException
    //   78	91	247	finally
    //   99	108	247	finally
    //   113	118	350	java/io/IOException
    //   253	258	355	java/io/IOException
  }
  
  public final long available()
  {
    return this.pwj;
  }
  
  public final c bVy()
  {
    AppMethodBeat.i(230146);
    Object localObject = null;
    String str = MimeTypeMap.getFileExtensionFromUrl(this.path);
    if (str != null) {
      localObject = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = c.pwP;
      AppMethodBeat.o(230146);
      return localObject;
    }
    localObject = c.aiX((String)localObject);
    AppMethodBeat.o(230146);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(230138);
    this.uri = null;
    try
    {
      if (this.aFw != null) {
        this.aFw.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      a locala = new a(localIOException);
      AppMethodBeat.o(230138);
      throw locala;
    }
    finally
    {
      this.aFw = null;
      if (this.opened)
      {
        this.opened = false;
        if (this.pwh != null) {
          this.pwh.onTransferEnd();
        }
      }
      AppMethodBeat.o(230138);
    }
    AppMethodBeat.o(230138);
  }
  
  public final long getTotalLength()
  {
    return this.pwi;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(230143);
    if (this.uri != null)
    {
      String str = this.uri.toString();
      AppMethodBeat.o(230143);
      return str;
    }
    AppMethodBeat.o(230143);
    return null;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230141);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(230141);
      return 0;
    }
    if (this.bom == 0L)
    {
      AppMethodBeat.o(230141);
      return -1;
    }
    try
    {
      if (this.bom == -1L) {}
      for (;;)
      {
        paramInt1 = this.aFw.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.bom == -1L) {
          break;
        }
        paramArrayOfByte = new a(new EOFException());
        AppMethodBeat.o(230141);
        throw paramArrayOfByte;
        long l = Math.min(this.bom, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(230141);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(230141);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.bom != -1L) {
      this.bom -= paramInt1;
    }
    if (this.pwh != null) {
      this.pwh.AU(paramInt1);
    }
    AppMethodBeat.o(230141);
    return paramInt1;
  }
  
  public final void setLogTag(String paramString)
  {
    this.pvQ = paramString;
  }
  
  public static final class a
    extends IOException
  {
    public a(IOException paramIOException)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.a
 * JD-Core Version:    0.7.0.1
 */