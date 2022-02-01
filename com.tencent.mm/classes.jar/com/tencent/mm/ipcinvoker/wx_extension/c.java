package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mmkv.MMKV;
import org.apache.commons.b.g;

public final class c
  implements com.tencent.mm.ipcinvoker.extension.a
{
  static ax Km()
  {
    AppMethodBeat.i(146411);
    ax localax = a.adI();
    AppMethodBeat.o(146411);
    return localax;
  }
  
  public final void a(Object paramObject, Parcel paramParcel)
  {
    int j = 1;
    k = 0;
    AppMethodBeat.i(146412);
    if (paramObject == null)
    {
      paramParcel.writeString(null);
      AppMethodBeat.o(146412);
      return;
    }
    Object localObject = (com.tencent.mm.bx.a)paramObject;
    paramParcel.writeString(localObject.getClass().getName());
    for (;;)
    {
      try
      {
        localObject = ((com.tencent.mm.bx.a)localObject).toByteArray();
        localax = a.adI();
        i = k;
        if (localObject.length > 102400)
        {
          i = k;
          if (localax == null) {}
        }
        try
        {
          long l = localax.EVG.totalSize();
          if (l < 20971520L) {
            continue;
          }
          ad.e("MicroMsg.XIPC.MMProtoBufTransfer", "mmkv totalSize[%d] too large, skip use mmkv", new Object[] { Long.valueOf(l) });
          i = k;
        }
        catch (Throwable paramObject)
        {
          for (;;)
          {
            byte[] arrayOfByte;
            ad.printErrStackTrace("MicroMsg.XIPC.MMProtoBufTransfer", paramObject, "encode bytes to mmkv", new Object[0]);
            i = k;
            continue;
            i = 0;
          }
        }
        if (i == 0)
        {
          paramParcel.writeString(null);
          paramParcel.writeInt(localObject.length);
          paramParcel.writeByteArray((byte[])localObject);
        }
        AppMethodBeat.o(146412);
        return;
      }
      catch (Exception localException)
      {
        ax localax;
        ad.e("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", new Object[] { localException });
        arrayOfByte = new byte[0];
        continue;
        paramObject = g.a(new String[] { aj.getProcessName(), paramObject.getClass().getName(), paramObject.hashCode(), SystemClock.elapsedRealtimeNanos() }, "$");
        localax.encode(paramObject, arrayOfByte);
        if (!localax.containsKey(paramObject)) {
          break;
        }
      }
      paramParcel.writeString(paramObject);
      i = j;
    }
  }
  
  public final boolean bh(Object paramObject)
  {
    return paramObject instanceof com.tencent.mm.bx.a;
  }
  
  /* Error */
  public final Object c(Parcel paramParcel)
  {
    // Byte code:
    //   0: ldc 152
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 155	android/os/Parcel:readString	()Ljava/lang/String;
    //   9: astore_3
    //   10: aload_3
    //   11: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +10 -> 24
    //   17: ldc 152
    //   19: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aconst_null
    //   23: areturn
    //   24: aload_1
    //   25: invokevirtual 155	android/os/Parcel:readString	()Ljava/lang/String;
    //   28: astore 4
    //   30: aload 4
    //   32: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +219 -> 254
    //   38: invokestatic 26	com/tencent/mm/ipcinvoker/wx_extension/c$a:adI	()Lcom/tencent/mm/sdk/platformtools/ax;
    //   41: astore 5
    //   43: aload 5
    //   45: aload 4
    //   47: invokevirtual 165	com/tencent/mm/sdk/platformtools/ax:decodeBytes	(Ljava/lang/String;)[B
    //   50: astore_1
    //   51: aload_1
    //   52: ifnonnull +54 -> 106
    //   55: aload_1
    //   56: astore_2
    //   57: ldc 74
    //   59: ldc 167
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload 5
    //   69: aastore
    //   70: invokestatic 88	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload 5
    //   75: aload 4
    //   77: invokevirtual 170	com/tencent/mm/sdk/platformtools/ax:removeValueForKey	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: ifnull +18 -> 99
    //   84: aload_1
    //   85: arraylength
    //   86: ldc 171
    //   88: if_icmplt +11 -> 99
    //   91: aload 5
    //   93: getfield 64	com/tencent/mm/sdk/platformtools/ax:EVG	Lcom/tencent/mmkv/MMKV;
    //   96: invokevirtual 174	com/tencent/mmkv/MMKV:trim	()V
    //   99: ldc 152
    //   101: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aconst_null
    //   105: areturn
    //   106: aload 5
    //   108: aload 4
    //   110: invokevirtual 170	com/tencent/mm/sdk/platformtools/ax:removeValueForKey	(Ljava/lang/String;)V
    //   113: aload_1
    //   114: astore_2
    //   115: aload_1
    //   116: ifnull +22 -> 138
    //   119: aload_1
    //   120: astore_2
    //   121: aload_1
    //   122: arraylength
    //   123: ldc 171
    //   125: if_icmplt +13 -> 138
    //   128: aload 5
    //   130: getfield 64	com/tencent/mm/sdk/platformtools/ax:EVG	Lcom/tencent/mmkv/MMKV;
    //   133: invokevirtual 174	com/tencent/mmkv/MMKV:trim	()V
    //   136: aload_1
    //   137: astore_2
    //   138: aload_3
    //   139: invokestatic 180	org/a/a:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   142: invokestatic 184	org/a/a:bA	(Ljava/lang/Class;)Lorg/a/a;
    //   145: invokevirtual 188	org/a/a:fMX	()Lorg/a/a;
    //   148: getfield 192	org/a/a:object	Ljava/lang/Object;
    //   151: checkcast 43	com/tencent/mm/bx/a
    //   154: astore_1
    //   155: aload_1
    //   156: aload_2
    //   157: invokevirtual 196	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   160: pop
    //   161: ldc 152
    //   163: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: areturn
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_1
    //   171: aload_1
    //   172: astore_2
    //   173: ldc 74
    //   175: aload_3
    //   176: ldc 198
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: aload 5
    //   187: aload 4
    //   189: invokevirtual 170	com/tencent/mm/sdk/platformtools/ax:removeValueForKey	(Ljava/lang/String;)V
    //   192: aload_1
    //   193: ifnull +18 -> 211
    //   196: aload_1
    //   197: arraylength
    //   198: ldc 171
    //   200: if_icmplt +11 -> 211
    //   203: aload 5
    //   205: getfield 64	com/tencent/mm/sdk/platformtools/ax:EVG	Lcom/tencent/mmkv/MMKV;
    //   208: invokevirtual 174	com/tencent/mmkv/MMKV:trim	()V
    //   211: ldc 152
    //   213: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_1
    //   219: aconst_null
    //   220: astore_2
    //   221: aload 5
    //   223: aload 4
    //   225: invokevirtual 170	com/tencent/mm/sdk/platformtools/ax:removeValueForKey	(Ljava/lang/String;)V
    //   228: aload_2
    //   229: ifnull +18 -> 247
    //   232: aload_2
    //   233: arraylength
    //   234: ldc 171
    //   236: if_icmplt +11 -> 247
    //   239: aload 5
    //   241: getfield 64	com/tencent/mm/sdk/platformtools/ax:EVG	Lcom/tencent/mmkv/MMKV;
    //   244: invokevirtual 174	com/tencent/mmkv/MMKV:trim	()V
    //   247: ldc 152
    //   249: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_1
    //   253: athrow
    //   254: aload_1
    //   255: invokevirtual 201	android/os/Parcel:readInt	()I
    //   258: newarray byte
    //   260: astore_2
    //   261: aload_1
    //   262: aload_2
    //   263: invokevirtual 204	android/os/Parcel:readByteArray	([B)V
    //   266: goto -128 -> 138
    //   269: astore_1
    //   270: ldc 74
    //   272: ldc 206
    //   274: iconst_1
    //   275: anewarray 4	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: aload_1
    //   281: aastore
    //   282: invokestatic 88	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: aconst_null
    //   286: astore_1
    //   287: goto -126 -> 161
    //   290: astore_2
    //   291: goto -44 -> 247
    //   294: astore_1
    //   295: goto -74 -> 221
    //   298: astore_1
    //   299: goto -88 -> 211
    //   302: astore_3
    //   303: goto -132 -> 171
    //   306: astore_2
    //   307: aload_1
    //   308: astore_2
    //   309: goto -171 -> 138
    //   312: astore_1
    //   313: goto -214 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	c
    //   0	316	1	paramParcel	Parcel
    //   56	207	2	localObject	Object
    //   290	1	2	localThrowable1	Throwable
    //   306	1	2	localThrowable2	Throwable
    //   308	1	2	localParcel	Parcel
    //   9	130	3	str1	String
    //   168	8	3	localThrowable3	Throwable
    //   302	1	3	localThrowable4	Throwable
    //   28	196	4	str2	String
    //   41	199	5	localax	ax
    // Exception table:
    //   from	to	target	type
    //   43	51	168	java/lang/Throwable
    //   43	51	218	finally
    //   138	161	269	java/lang/Throwable
    //   221	228	290	java/lang/Throwable
    //   232	247	290	java/lang/Throwable
    //   57	73	294	finally
    //   173	185	294	finally
    //   185	192	298	java/lang/Throwable
    //   196	211	298	java/lang/Throwable
    //   57	73	302	java/lang/Throwable
    //   106	113	306	java/lang/Throwable
    //   121	136	306	java/lang/Throwable
    //   73	80	312	java/lang/Throwable
    //   84	99	312	java/lang/Throwable
  }
  
  static final class a
  {
    private static final ax fZX;
    
    static
    {
      AppMethodBeat.i(146410);
      fZX = ax.aFC("MicroMsg_XIPC_MMProtoBufTransfer");
      AppMethodBeat.o(146410);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.c
 * JD-Core Version:    0.7.0.1
 */