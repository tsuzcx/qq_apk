package com.google.android.exoplayer2.h;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.i.l;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class n
  implements q
{
  private static final Pattern aRx = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  private static final AtomicReference<byte[]> aRy = new AtomicReference();
  private i aJa;
  private final t<? super n> aQN;
  private InputStream aQO;
  private final int aRA;
  private final int aRB;
  private final String aRC;
  private final l<String> aRD;
  private final q.f aRE;
  private final q.f aRF;
  private HttpURLConnection aRG;
  private long aRH;
  private long aRI;
  private long aRJ;
  private long aRK;
  private final boolean aRz;
  private boolean opened;
  
  public n(String paramString, t<? super n> paramt, int paramInt1, int paramInt2, boolean paramBoolean, q.f paramf)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException();
    }
    this.aRC = paramString;
    this.aRD = null;
    this.aQN = paramt;
    this.aRF = new q.f();
    this.aRA = paramInt1;
    this.aRB = paramInt2;
    this.aRz = paramBoolean;
    this.aRE = paramf;
  }
  
  /* Error */
  private static long a(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc2_w 96
    //   3: lstore_3
    //   4: aload_0
    //   5: ldc 99
    //   7: invokevirtual 105	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 7
    //   12: lload_3
    //   13: lstore_1
    //   14: aload 7
    //   16: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +9 -> 28
    //   22: aload 7
    //   24: invokestatic 111	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   27: lstore_1
    //   28: aload_0
    //   29: ldc 113
    //   31: invokevirtual 105	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_0
    //   35: lload_1
    //   36: lstore_3
    //   37: aload_0
    //   38: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne +60 -> 101
    //   44: getstatic 51	com/google/android/exoplayer2/h/n:aRx	Ljava/util/regex/Pattern;
    //   47: aload_0
    //   48: invokevirtual 117	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   51: astore 8
    //   53: lload_1
    //   54: lstore_3
    //   55: aload 8
    //   57: invokevirtual 123	java/util/regex/Matcher:find	()Z
    //   60: ifeq +41 -> 101
    //   63: aload 8
    //   65: iconst_2
    //   66: invokevirtual 127	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   69: invokestatic 111	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: lstore_3
    //   73: aload 8
    //   75: iconst_1
    //   76: invokevirtual 127	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   79: invokestatic 111	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: lstore 5
    //   84: lload_3
    //   85: lload 5
    //   87: lsub
    //   88: lconst_1
    //   89: ladd
    //   90: lstore 5
    //   92: lload_1
    //   93: lconst_0
    //   94: lcmp
    //   95: ifge +46 -> 141
    //   98: lload 5
    //   100: lstore_3
    //   101: lload_3
    //   102: lreturn
    //   103: astore 8
    //   105: ldc 129
    //   107: new 131	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 133
    //   113: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload 7
    //   118: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 142
    //   123: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: iconst_0
    //   130: anewarray 4	java/lang/Object
    //   133: invokestatic 152	com/google/android/exoplayer2/d/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: lload_3
    //   137: lstore_1
    //   138: goto -110 -> 28
    //   141: lload_1
    //   142: lstore_3
    //   143: lload_1
    //   144: lload 5
    //   146: lcmp
    //   147: ifeq -46 -> 101
    //   150: ldc 129
    //   152: new 131	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 154
    //   158: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload 7
    //   163: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 156
    //   168: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 142
    //   177: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokestatic 159	com/google/android/exoplayer2/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: lload_1
    //   191: lload 5
    //   193: invokestatic 165	java/lang/Math:max	(JJ)J
    //   196: lstore_3
    //   197: lload_3
    //   198: lreturn
    //   199: astore 7
    //   201: ldc 129
    //   203: new 131	java/lang/StringBuilder
    //   206: dup
    //   207: ldc 167
    //   209: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: aload_0
    //   213: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 142
    //   218: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 152	com/google/android/exoplayer2/d/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: lload_1
    //   232: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramHttpURLConnection	HttpURLConnection
    //   13	219	1	l1	long
    //   3	195	3	l2	long
    //   82	110	5	l3	long
    //   10	152	7	str	String
    //   199	1	7	localNumberFormatException1	java.lang.NumberFormatException
    //   51	23	8	localMatcher	java.util.regex.Matcher
    //   103	1	8	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   22	28	103	java/lang/NumberFormatException
    //   63	84	199	java/lang/NumberFormatException
    //   150	197	199	java/lang/NumberFormatException
  }
  
  private HttpURLConnection a(URL paramURL, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.aRA);
    localHttpURLConnection.setReadTimeout(this.aRB);
    Object localObject;
    if (this.aRE != null)
    {
      paramURL = this.aRE.nY().entrySet().iterator();
      while (paramURL.hasNext())
      {
        localObject = (Map.Entry)paramURL.next();
        localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramURL = this.aRF.nY().entrySet().iterator();
    while (paramURL.hasNext())
    {
      localObject = (Map.Entry)paramURL.next();
      localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      localObject = "bytes=" + paramLong1 + "-";
      paramURL = (URL)localObject;
      if (paramLong2 != -1L) {
        paramURL = (String)localObject + (paramLong1 + paramLong2 - 1L);
      }
      localHttpURLConnection.setRequestProperty("Range", paramURL);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.aRC);
    if (!paramBoolean1) {
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean2);
    if (paramArrayOfByte != null) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localHttpURLConnection.setDoOutput(paramBoolean1);
      if (paramArrayOfByte == null) {
        break;
      }
      localHttpURLConnection.setRequestMethod("POST");
      if (paramArrayOfByte.length == 0) {
        break;
      }
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.connect();
      paramURL = localHttpURLConnection.getOutputStream();
      paramURL.write(paramArrayOfByte);
      paramURL.close();
      return localHttpURLConnection;
    }
    localHttpURLConnection.connect();
    return localHttpURLConnection;
  }
  
  private void nX()
  {
    if (this.aRG != null) {}
    try
    {
      this.aRG.disconnect();
      this.aRG = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.e("DefaultHttpDataSource", "Unexpected error while disconnecting", new Object[] { localException });
      }
    }
  }
  
  public final long a(i parami)
  {
    this.aJa = parami;
    this.aRK = 0L;
    this.aRJ = 0L;
    long l1;
    Object localObject2;
    int j;
    try
    {
      localObject1 = new URL(parami.uri.toString());
      arrayOfByte = parami.aQU;
      l1 = parami.position;
      l2 = parami.aQW;
      bool = parami.nR();
      if (!this.aRz)
      {
        localObject2 = a((URL)localObject1, arrayOfByte, l1, l2, bool, true);
        this.aRG = ((HttpURLConnection)localObject2);
      }
    }
    catch (IOException localIOException1)
    {
      Object localObject1;
      byte[] arrayOfByte;
      long l2;
      boolean bool;
      throw new q.c("Unable to connect to " + parami.uri.toString(), localIOException1, parami);
    }
    try
    {
      i = this.aRG.getResponseCode();
      b.i("DefaultHttpDataSource", "open, responseCode:%d", new Object[] { Integer.valueOf(i) });
      if ((i < 200) || (i > 299))
      {
        localObject1 = this.aRG.getHeaderFields();
        nX();
        parami = new q.e(i, (Map)localObject1, parami);
        if (i == 416) {
          parami.initCause(new g());
        }
        throw parami;
      }
    }
    catch (IOException localIOException2)
    {
      nX();
      throw new q.c("Unable to connect to " + parami.uri.toString(), localIOException2, parami);
    }
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (i <= 20)
      {
        HttpURLConnection localHttpURLConnection = a((URL)localObject1, arrayOfByte, l1, l2, bool, false);
        i = localHttpURLConnection.getResponseCode();
        if ((i != 300) && (i != 301) && (i != 302) && (i != 303))
        {
          localObject2 = localHttpURLConnection;
          if (arrayOfByte != null) {
            break;
          }
          if (i != 307)
          {
            localObject2 = localHttpURLConnection;
            if (i != 308) {
              break;
            }
          }
        }
        arrayOfByte = null;
        localObject2 = localHttpURLConnection.getHeaderField("Location");
        localHttpURLConnection.disconnect();
        if (localObject2 == null) {
          throw new ProtocolException("Null location redirect");
        }
        URL localURL = new URL(localIOException1, (String)localObject2);
        localObject2 = localURL.getProtocol();
        if (("https".equals(localObject2)) || ("http".equals(localObject2))) {
          continue;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + (String)localObject2);
      }
      throw new NoRouteToHostException("Too many redirects: " + j);
      String str = this.aRG.getContentType();
      if ((this.aRD != null) && (!this.aRD.R(str)))
      {
        nX();
        throw new q.d(str, parami);
      }
      if ((i == 200) && (parami.position != 0L))
      {
        l1 = parami.position;
        this.aRH = l1;
        if (parami.nR()) {
          break label651;
        }
        if (parami.aQW == -1L) {
          break label607;
        }
        this.aRI = parami.aQW;
      }
      for (;;)
      {
        try
        {
          this.aQO = this.aRG.getInputStream();
          this.opened = true;
          if (this.aQN != null) {
            this.aQN.nT();
          }
          return this.aRI;
        }
        catch (IOException localIOException3)
        {
          label607:
          nX();
          label651:
          throw new q.c(localIOException3, parami, 1);
        }
        l1 = 0L;
        break;
        l1 = a(this.aRG);
        if (l1 != -1L)
        {
          l1 -= this.aRH;
          this.aRI = l1;
        }
        else
        {
          l1 = -1L;
          continue;
          this.aRI = parami.aQW;
        }
      }
    }
  }
  
  /* Error */
  public final void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 404	com/google/android/exoplayer2/h/n:aQO	Ljava/io/InputStream;
    //   4: ifnull +76 -> 80
    //   7: aload_0
    //   8: getfield 272	com/google/android/exoplayer2/h/n:aRG	Ljava/net/HttpURLConnection;
    //   11: astore 6
    //   13: aload_0
    //   14: getfield 398	com/google/android/exoplayer2/h/n:aRI	J
    //   17: ldc2_w 96
    //   20: lcmp
    //   21: ifne +97 -> 118
    //   24: aload_0
    //   25: getfield 398	com/google/android/exoplayer2/h/n:aRI	J
    //   28: lstore_2
    //   29: getstatic 421	com/google/android/exoplayer2/i/t:SDK_INT	I
    //   32: bipush 19
    //   34: if_icmpeq +13 -> 47
    //   37: getstatic 421	com/google/android/exoplayer2/i/t:SDK_INT	I
    //   40: istore_1
    //   41: iload_1
    //   42: bipush 20
    //   44: if_icmpne +29 -> 73
    //   47: aload 6
    //   49: invokevirtual 402	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   52: astore 6
    //   54: lload_2
    //   55: ldc2_w 96
    //   58: lcmp
    //   59: ifne +78 -> 137
    //   62: aload 6
    //   64: invokevirtual 426	java/io/InputStream:read	()I
    //   67: istore_1
    //   68: iload_1
    //   69: iconst_m1
    //   70: if_icmpne +75 -> 145
    //   73: aload_0
    //   74: getfield 404	com/google/android/exoplayer2/h/n:aQO	Ljava/io/InputStream;
    //   77: invokevirtual 427	java/io/InputStream:close	()V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 404	com/google/android/exoplayer2/h/n:aQO	Ljava/io/InputStream;
    //   85: aload_0
    //   86: invokespecial 331	com/google/android/exoplayer2/h/n:nX	()V
    //   89: aload_0
    //   90: getfield 406	com/google/android/exoplayer2/h/n:opened	Z
    //   93: ifeq +24 -> 117
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 406	com/google/android/exoplayer2/h/n:opened	Z
    //   101: aload_0
    //   102: getfield 76	com/google/android/exoplayer2/h/n:aQN	Lcom/google/android/exoplayer2/h/t;
    //   105: ifnull +12 -> 117
    //   108: aload_0
    //   109: getfield 76	com/google/android/exoplayer2/h/n:aQN	Lcom/google/android/exoplayer2/h/t;
    //   112: invokeinterface 430 1 0
    //   117: return
    //   118: aload_0
    //   119: getfield 398	com/google/android/exoplayer2/h/n:aRI	J
    //   122: lstore_2
    //   123: aload_0
    //   124: getfield 284	com/google/android/exoplayer2/h/n:aRK	J
    //   127: lstore 4
    //   129: lload_2
    //   130: lload 4
    //   132: lsub
    //   133: lstore_2
    //   134: goto -105 -> 29
    //   137: lload_2
    //   138: ldc2_w 431
    //   141: lcmp
    //   142: ifle -69 -> 73
    //   145: aload 6
    //   147: invokevirtual 436	java/lang/Object:getClass	()Ljava/lang/Class;
    //   150: invokevirtual 441	java/lang/Class:getName	()Ljava/lang/String;
    //   153: astore 7
    //   155: aload 7
    //   157: ldc_w 443
    //   160: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   163: ifne +14 -> 177
    //   166: aload 7
    //   168: ldc_w 445
    //   171: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifeq -101 -> 73
    //   177: aload 6
    //   179: invokevirtual 436	java/lang/Object:getClass	()Ljava/lang/Class;
    //   182: invokevirtual 448	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   185: ldc_w 450
    //   188: iconst_0
    //   189: anewarray 438	java/lang/Class
    //   192: invokevirtual 454	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   195: astore 7
    //   197: aload 7
    //   199: iconst_1
    //   200: invokevirtual 459	java/lang/reflect/Method:setAccessible	(Z)V
    //   203: aload 7
    //   205: aload 6
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokevirtual 463	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   214: pop
    //   215: goto -142 -> 73
    //   218: astore 6
    //   220: goto -147 -> 73
    //   223: astore 6
    //   225: new 352	com/google/android/exoplayer2/h/q$c
    //   228: dup
    //   229: aload 6
    //   231: aload_0
    //   232: getfield 282	com/google/android/exoplayer2/h/n:aJa	Lcom/google/android/exoplayer2/h/i;
    //   235: iconst_3
    //   236: invokespecial 416	com/google/android/exoplayer2/h/q$c:<init>	(Ljava/io/IOException;Lcom/google/android/exoplayer2/h/i;I)V
    //   239: athrow
    //   240: astore 6
    //   242: aload_0
    //   243: aconst_null
    //   244: putfield 404	com/google/android/exoplayer2/h/n:aQO	Ljava/io/InputStream;
    //   247: aload_0
    //   248: invokespecial 331	com/google/android/exoplayer2/h/n:nX	()V
    //   251: aload_0
    //   252: getfield 406	com/google/android/exoplayer2/h/n:opened	Z
    //   255: ifeq +24 -> 279
    //   258: aload_0
    //   259: iconst_0
    //   260: putfield 406	com/google/android/exoplayer2/h/n:opened	Z
    //   263: aload_0
    //   264: getfield 76	com/google/android/exoplayer2/h/n:aQN	Lcom/google/android/exoplayer2/h/t;
    //   267: ifnull +12 -> 279
    //   270: aload_0
    //   271: getfield 76	com/google/android/exoplayer2/h/n:aQN	Lcom/google/android/exoplayer2/h/t;
    //   274: invokeinterface 430 1 0
    //   279: aload 6
    //   281: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	n
    //   40	31	1	i	int
    //   28	110	2	l1	long
    //   127	4	4	l2	long
    //   11	195	6	localObject1	Object
    //   218	1	6	localException	Exception
    //   223	7	6	localIOException	IOException
    //   240	40	6	localObject2	Object
    //   153	51	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	54	218	java/lang/Exception
    //   62	68	218	java/lang/Exception
    //   145	177	218	java/lang/Exception
    //   177	215	218	java/lang/Exception
    //   73	80	223	java/io/IOException
    //   0	29	240	finally
    //   29	41	240	finally
    //   47	54	240	finally
    //   62	68	240	finally
    //   73	80	240	finally
    //   118	129	240	finally
    //   145	177	240	finally
    //   177	215	240	finally
    //   225	240	240	finally
  }
  
  public final Uri getUri()
  {
    if (this.aRG == null) {
      return null;
    }
    return Uri.parse(this.aRG.getURL().toString());
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte1;
    int i;
    for (;;)
    {
      try
      {
        if (this.aRJ == this.aRH) {
          break label284;
        }
        byte[] arrayOfByte2 = (byte[])aRy.getAndSet(null);
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null) {
          arrayOfByte1 = new byte[4096];
        }
        if (this.aRJ == this.aRH) {
          break;
        }
        i = (int)Math.min(this.aRH - this.aRJ, arrayOfByte1.length);
        i = this.aQO.read(arrayOfByte1, 0, i);
        if (Thread.interrupted()) {
          throw new InterruptedIOException();
        }
      }
      catch (IOException paramArrayOfByte)
      {
        throw new q.c(paramArrayOfByte, this.aJa, 2);
      }
      if (i == -1) {
        throw new EOFException();
      }
      this.aRJ += i;
      if (this.aQN != null) {
        this.aQN.dx(i);
      }
    }
    aRy.set(arrayOfByte1);
    label284:
    while (paramInt2 != 0)
    {
      i = paramInt2;
      if (this.aRI != -1L)
      {
        long l = this.aRI - this.aRK;
        if (l == 0L) {
          return -1;
        }
        i = (int)Math.min(paramInt2, l);
      }
      paramInt2 = this.aQO.read(paramArrayOfByte, paramInt1, i);
      if (paramInt2 == -1)
      {
        if (this.aRI == -1L) {
          break label292;
        }
        throw new EOFException();
      }
      this.aRK += paramInt2;
      paramInt1 = paramInt2;
      if (this.aQN == null) {
        break;
      }
      this.aQN.dx(paramInt2);
      return paramInt2;
    }
    paramInt1 = 0;
    return paramInt1;
    label292:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.n
 * JD-Core Version:    0.7.0.1
 */