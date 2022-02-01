package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import org.apache.commons.c.i;

public final class c
  implements com.tencent.mm.ipcinvoker.extension.a
{
  static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(146411);
    MultiProcessMMKV localMultiProcessMMKV = a.aYH();
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
    Object localObject = (com.tencent.mm.bx.a)paramObject;
    paramParcel.writeString(localObject.getClass().getName());
    for (;;)
    {
      try
      {
        localObject = ((com.tencent.mm.bx.a)localObject).toByteArray();
        localMultiProcessMMKV = a.aYH();
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
        finally
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
        paramObject = i.b(new String[] { MMApplicationContext.getProcessName(), paramObject.getClass().getName(), paramObject.hashCode(), SystemClock.elapsedRealtimeNanos() }, "$");
        localMultiProcessMMKV.encode(paramObject, arrayOfByte);
        if (!localMultiProcessMMKV.containsKey(paramObject)) {
          break;
        }
      }
      paramParcel.writeString(paramObject);
      i = j;
    }
  }
  
  public final boolean cJ(Object paramObject)
  {
    return paramObject instanceof com.tencent.mm.bx.a;
  }
  
  /* Error */
  public final Object f(Parcel paramParcel)
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 148	android/os/Parcel:readString	()Ljava/lang/String;
    //   9: astore 5
    //   11: aload 5
    //   13: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +10 -> 26
    //   19: ldc 145
    //   21: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_1
    //   27: invokevirtual 148	android/os/Parcel:readString	()Ljava/lang/String;
    //   30: astore_3
    //   31: aload_3
    //   32: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +197 -> 232
    //   38: invokestatic 26	com/tencent/mm/ipcinvoker/wx_extension/c$a:aYH	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   41: astore 4
    //   43: aload 4
    //   45: aload_3
    //   46: invokevirtual 158	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBytes	(Ljava/lang/String;)[B
    //   49: astore_1
    //   50: aload_1
    //   51: ifnonnull +48 -> 99
    //   54: ldc 66
    //   56: ldc 160
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload 4
    //   66: aastore
    //   67: invokestatic 80	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload 4
    //   72: aload_3
    //   73: invokevirtual 163	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:removeValueForKey	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: ifnull +15 -> 92
    //   80: aload_1
    //   81: arraylength
    //   82: ldc 164
    //   84: if_icmplt +8 -> 92
    //   87: aload 4
    //   89: invokevirtual 167	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:trim	()V
    //   92: ldc 145
    //   94: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aconst_null
    //   98: areturn
    //   99: aload 4
    //   101: aload_3
    //   102: invokevirtual 163	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:removeValueForKey	(Ljava/lang/String;)V
    //   105: aload_1
    //   106: astore_2
    //   107: aload_1
    //   108: ifnull +19 -> 127
    //   111: aload_1
    //   112: astore_2
    //   113: aload_1
    //   114: arraylength
    //   115: ldc 164
    //   117: if_icmplt +10 -> 127
    //   120: aload 4
    //   122: invokevirtual 167	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:trim	()V
    //   125: aload_1
    //   126: astore_2
    //   127: aload 5
    //   129: invokestatic 173	org/a/a:bLw	(Ljava/lang/String;)Ljava/lang/Class;
    //   132: invokestatic 177	org/a/a:cQ	(Ljava/lang/Class;)Lorg/a/a;
    //   135: invokevirtual 181	org/a/a:kJE	()Lorg/a/a;
    //   138: getfield 185	org/a/a:object	Ljava/lang/Object;
    //   141: checkcast 41	com/tencent/mm/bx/a
    //   144: astore_1
    //   145: aload_1
    //   146: aload_2
    //   147: invokevirtual 189	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   150: pop
    //   151: ldc 145
    //   153: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: areturn
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: ldc 66
    //   163: aload_2
    //   164: ldc 191
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload 4
    //   175: aload_3
    //   176: invokevirtual 163	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:removeValueForKey	(Ljava/lang/String;)V
    //   179: aload_1
    //   180: ifnull +15 -> 195
    //   183: aload_1
    //   184: arraylength
    //   185: ldc 164
    //   187: if_icmplt +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 167	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:trim	()V
    //   195: ldc 145
    //   197: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aconst_null
    //   201: areturn
    //   202: astore_2
    //   203: aload 4
    //   205: aload_3
    //   206: invokevirtual 163	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:removeValueForKey	(Ljava/lang/String;)V
    //   209: aload_1
    //   210: ifnull +15 -> 225
    //   213: aload_1
    //   214: arraylength
    //   215: ldc 164
    //   217: if_icmplt +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 167	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:trim	()V
    //   225: ldc 145
    //   227: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_2
    //   231: athrow
    //   232: aload_1
    //   233: invokevirtual 194	android/os/Parcel:readInt	()I
    //   236: newarray byte
    //   238: astore_2
    //   239: aload_1
    //   240: aload_2
    //   241: invokevirtual 197	android/os/Parcel:readByteArray	([B)V
    //   244: goto -117 -> 127
    //   247: astore_1
    //   248: ldc 66
    //   250: ldc 199
    //   252: iconst_1
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_1
    //   259: aastore
    //   260: invokestatic 80	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aconst_null
    //   264: astore_1
    //   265: goto -114 -> 151
    //   268: astore_1
    //   269: goto -44 -> 225
    //   272: astore_1
    //   273: goto -78 -> 195
    //   276: astore_2
    //   277: goto -116 -> 161
    //   280: astore_2
    //   281: aload_1
    //   282: astore_2
    //   283: goto -156 -> 127
    //   286: astore_1
    //   287: goto -195 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	c
    //   0	290	1	paramParcel	Parcel
    //   106	41	2	localParcel1	Parcel
    //   158	6	2	localThrowable	java.lang.Throwable
    //   202	29	2	localObject1	Object
    //   238	3	2	arrayOfByte	byte[]
    //   276	1	2	localObject2	Object
    //   280	1	2	localObject3	Object
    //   282	1	2	localParcel2	Parcel
    //   30	176	3	str1	String
    //   41	180	4	localMultiProcessMMKV	MultiProcessMMKV
    //   9	119	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   43	50	158	finally
    //   161	173	202	finally
    //   127	151	247	finally
    //   203	209	268	finally
    //   213	225	268	finally
    //   173	179	272	finally
    //   183	195	272	finally
    //   54	70	276	finally
    //   99	105	280	finally
    //   113	125	280	finally
    //   70	76	286	finally
    //   80	92	286	finally
  }
  
  static final class a
  {
    private static final MultiProcessMMKV mzE;
    
    static
    {
      AppMethodBeat.i(146410);
      mzE = MultiProcessMMKV.getMMKV("MicroMsg_XIPC_MMProtoBufTransfer");
      AppMethodBeat.o(146410);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.c
 * JD-Core Version:    0.7.0.1
 */