package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import org.apache.commons.b.g;

public final class c
  implements com.tencent.mm.ipcinvoker.extension.a
{
  static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(146411);
    MultiProcessMMKV localMultiProcessMMKV = a.aFH();
    AppMethodBeat.o(146411);
    return localMultiProcessMMKV;
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
    Object localObject = (com.tencent.mm.cd.a)paramObject;
    paramParcel.writeString(localObject.getClass().getName());
    for (;;)
    {
      try
      {
        localObject = ((com.tencent.mm.cd.a)localObject).toByteArray();
        localMultiProcessMMKV = a.aFH();
        i = k;
        if (localObject.length > 102400)
        {
          i = k;
          if (localMultiProcessMMKV == null) {}
        }
        try
        {
          long l = localMultiProcessMMKV.totalSize();
          if (l < 20971520L) {
            continue;
          }
          Log.e("MicroMsg.XIPC.MMProtoBufTransfer", "mmkv totalSize[%d] too large, skip use mmkv", new Object[] { Long.valueOf(l) });
          i = k;
        }
        catch (Throwable paramObject)
        {
          for (;;)
          {
            byte[] arrayOfByte;
            Log.printErrStackTrace("MicroMsg.XIPC.MMProtoBufTransfer", paramObject, "encode bytes to mmkv", new Object[0]);
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
        MultiProcessMMKV localMultiProcessMMKV;
        Log.e("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", new Object[] { localException });
        arrayOfByte = new byte[0];
        continue;
        paramObject = g.a(new String[] { MMApplicationContext.getProcessName(), paramObject.getClass().getName(), paramObject.hashCode(), SystemClock.elapsedRealtimeNanos() }, "$");
        localMultiProcessMMKV.encode(paramObject, arrayOfByte);
        if (!localMultiProcessMMKV.containsKey(paramObject)) {
          break;
        }
      }
      paramParcel.writeString(paramObject);
      i = j;
    }
  }
  
  public final boolean bp(Object paramObject)
  {
    return paramObject instanceof com.tencent.mm.cd.a;
  }
  
  /* Error */
  public final Object d(Parcel paramParcel)
  {
    // Byte code:
    //   0: ldc 146
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 149	android/os/Parcel:readString	()Ljava/lang/String;
    //   9: astore_3
    //   10: aload_3
    //   11: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +10 -> 24
    //   17: ldc 146
    //   19: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aconst_null
    //   23: areturn
    //   24: aload_1
    //   25: invokevirtual 149	android/os/Parcel:readString	()Ljava/lang/String;
    //   28: astore 4
    //   30: aload 4
    //   32: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +207 -> 242
    //   38: invokestatic 26	com/tencent/mm/ipcinvoker/wx_extension/c$a:aFH	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   41: astore 5
    //   43: aload 5
    //   45: aload 4
    //   47: invokevirtual 159	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBytes	(Ljava/lang/String;)[B
    //   50: astore_1
    //   51: aload_1
    //   52: ifnonnull +51 -> 103
    //   55: aload_1
    //   56: astore_2
    //   57: ldc 68
    //   59: ldc 161
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload 5
    //   69: aastore
    //   70: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload 5
    //   75: aload 4
    //   77: invokevirtual 164	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:removeValueForKey	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: ifnull +15 -> 96
    //   84: aload_1
    //   85: arraylength
    //   86: ldc 165
    //   88: if_icmplt +8 -> 96
    //   91: aload 5
    //   93: invokevirtual 168	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:trim	()V
    //   96: ldc 146
    //   98: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aconst_null
    //   102: areturn
    //   103: aload 5
    //   105: aload 4
    //   107: invokevirtual 164	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:removeValueForKey	(Ljava/lang/String;)V
    //   110: aload_1
    //   111: astore_2
    //   112: aload_1
    //   113: ifnull +19 -> 132
    //   116: aload_1
    //   117: astore_2
    //   118: aload_1
    //   119: arraylength
    //   120: ldc 165
    //   122: if_icmplt +10 -> 132
    //   125: aload 5
    //   127: invokevirtual 168	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:trim	()V
    //   130: aload_1
    //   131: astore_2
    //   132: aload_3
    //   133: invokestatic 174	org/a/a:bIA	(Ljava/lang/String;)Ljava/lang/Class;
    //   136: invokestatic 178	org/a/a:ce	(Ljava/lang/Class;)Lorg/a/a;
    //   139: invokevirtual 182	org/a/a:iVg	()Lorg/a/a;
    //   142: getfield 186	org/a/a:object	Ljava/lang/Object;
    //   145: checkcast 43	com/tencent/mm/cd/a
    //   148: astore_1
    //   149: aload_1
    //   150: aload_2
    //   151: invokevirtual 190	com/tencent/mm/cd/a:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   154: pop
    //   155: ldc 146
    //   157: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: areturn
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_1
    //   165: aload_1
    //   166: astore_2
    //   167: ldc 68
    //   169: aload_3
    //   170: ldc 192
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload 5
    //   181: aload 4
    //   183: invokevirtual 164	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:removeValueForKey	(Ljava/lang/String;)V
    //   186: aload_1
    //   187: ifnull +15 -> 202
    //   190: aload_1
    //   191: arraylength
    //   192: ldc 165
    //   194: if_icmplt +8 -> 202
    //   197: aload 5
    //   199: invokevirtual 168	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:trim	()V
    //   202: ldc 146
    //   204: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aconst_null
    //   208: areturn
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_2
    //   212: aload 5
    //   214: aload 4
    //   216: invokevirtual 164	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:removeValueForKey	(Ljava/lang/String;)V
    //   219: aload_2
    //   220: ifnull +15 -> 235
    //   223: aload_2
    //   224: arraylength
    //   225: ldc 165
    //   227: if_icmplt +8 -> 235
    //   230: aload 5
    //   232: invokevirtual 168	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:trim	()V
    //   235: ldc 146
    //   237: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload_1
    //   241: athrow
    //   242: aload_1
    //   243: invokevirtual 195	android/os/Parcel:readInt	()I
    //   246: newarray byte
    //   248: astore_2
    //   249: aload_1
    //   250: aload_2
    //   251: invokevirtual 198	android/os/Parcel:readByteArray	([B)V
    //   254: goto -122 -> 132
    //   257: astore_1
    //   258: ldc 68
    //   260: ldc 200
    //   262: iconst_1
    //   263: anewarray 4	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload_1
    //   269: aastore
    //   270: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: aconst_null
    //   274: astore_1
    //   275: goto -120 -> 155
    //   278: astore_2
    //   279: goto -44 -> 235
    //   282: astore_1
    //   283: goto -71 -> 212
    //   286: astore_1
    //   287: goto -85 -> 202
    //   290: astore_3
    //   291: goto -126 -> 165
    //   294: astore_2
    //   295: aload_1
    //   296: astore_2
    //   297: goto -165 -> 132
    //   300: astore_1
    //   301: goto -205 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	c
    //   0	304	1	paramParcel	Parcel
    //   56	195	2	localObject	Object
    //   278	1	2	localThrowable1	Throwable
    //   294	1	2	localThrowable2	Throwable
    //   296	1	2	localParcel	Parcel
    //   9	124	3	str1	String
    //   162	8	3	localThrowable3	Throwable
    //   290	1	3	localThrowable4	Throwable
    //   28	187	4	str2	String
    //   41	190	5	localMultiProcessMMKV	MultiProcessMMKV
    // Exception table:
    //   from	to	target	type
    //   43	51	162	java/lang/Throwable
    //   43	51	209	finally
    //   132	155	257	java/lang/Throwable
    //   212	219	278	java/lang/Throwable
    //   223	235	278	java/lang/Throwable
    //   57	73	282	finally
    //   167	179	282	finally
    //   179	186	286	java/lang/Throwable
    //   190	202	286	java/lang/Throwable
    //   57	73	290	java/lang/Throwable
    //   103	110	294	java/lang/Throwable
    //   118	130	294	java/lang/Throwable
    //   73	80	300	java/lang/Throwable
    //   84	96	300	java/lang/Throwable
  }
  
  static final class a
  {
    private static final MultiProcessMMKV jZA;
    
    static
    {
      AppMethodBeat.i(146410);
      jZA = MultiProcessMMKV.getMMKV("MicroMsg_XIPC_MMProtoBufTransfer");
      AppMethodBeat.o(146410);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.c
 * JD-Core Version:    0.7.0.1
 */