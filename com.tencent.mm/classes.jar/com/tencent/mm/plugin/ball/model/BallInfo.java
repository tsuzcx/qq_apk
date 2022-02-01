package com.tencent.mm.plugin.ball.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class BallInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BallInfo> CREATOR;
  public int aUt;
  public long createTime;
  public String desc;
  public String drM;
  public boolean fra;
  public long fto;
  public Bundle hSN;
  public String key;
  public int lzV;
  public String name;
  public boolean nfA;
  public boolean nfB;
  public boolean nfC;
  public BallReportInfo nfD;
  public View nfy;
  public long nfz;
  public long progress;
  public int state;
  public String tag;
  public View tk;
  public int type;
  
  static
  {
    AppMethodBeat.i(127548);
    CREATOR = new BallInfo.1();
    AppMethodBeat.o(127548);
  }
  
  public BallInfo(int paramInt, String paramString)
  {
    this(paramInt, paramString, null);
  }
  
  private BallInfo(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127528);
    this.lzV = -1;
    this.progress = -2147483648L;
    this.nfz = 0L;
    this.createTime = 0L;
    this.fto = 0L;
    this.nfA = false;
    this.hSN = new Bundle();
    this.state = 0;
    this.nfB = false;
    this.nfC = false;
    this.fra = false;
    this.type = paramInt;
    this.key = paramString;
    if (paramJSONObject == null) {}
    for (paramString = new BallReportInfo();; paramString = new BallReportInfo(paramJSONObject))
    {
      this.nfD = paramString;
      this.aUt = paramInt;
      AppMethodBeat.o(127528);
      return;
    }
  }
  
  protected BallInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(127542);
    this.lzV = -1;
    this.progress = -2147483648L;
    this.nfz = 0L;
    this.createTime = 0L;
    this.fto = 0L;
    this.nfA = false;
    this.hSN = new Bundle();
    this.state = 0;
    this.nfB = false;
    this.nfC = false;
    this.fra = false;
    try
    {
      this.type = paramParcel.readInt();
      this.key = paramParcel.readString();
      this.drM = paramParcel.readString();
      this.lzV = paramParcel.readInt();
      this.name = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.tag = paramParcel.readString();
      this.progress = paramParcel.readLong();
      this.hSN = paramParcel.readBundle(getClass().getClassLoader());
      this.state = paramParcel.readInt();
      boolean bool;
      label184:
      BallReportInfo localBallReportInfo;
      if (paramParcel.readInt() == 1)
      {
        bool = true;
        this.nfB = bool;
        if (paramParcel.readInt() != 1) {
          break label232;
        }
        bool = true;
        this.nfC = bool;
        localBallReportInfo = (BallReportInfo)paramParcel.readParcelable(getClass().getClassLoader());
        if (localBallReportInfo == null) {
          break label237;
        }
      }
      for (;;)
      {
        this.nfD = localBallReportInfo;
        this.aUt = paramParcel.readInt();
        AppMethodBeat.o(127542);
        return;
        bool = false;
        break;
        label232:
        bool = false;
        break label184;
        label237:
        localBallReportInfo = new BallReportInfo();
      }
      return;
    }
    catch (Exception paramParcel)
    {
      ac.printErrStackTrace("MicroMsg.BallInfo", paramParcel, "readFromParcel fail, exception:%s", new Object[] { paramParcel });
      AppMethodBeat.o(127542);
    }
  }
  
  private static JSONObject L(Bundle paramBundle)
  {
    AppMethodBeat.i(127546);
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle != null) {
      try
      {
        if (!paramBundle.isEmpty())
        {
          Iterator localIterator = paramBundle.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, new BallInfo.a(paramBundle.get(str)));
          }
        }
        AppMethodBeat.o(127546);
      }
      catch (Exception paramBundle)
      {
        ac.printErrStackTrace("MicroMsg.BallInfo", paramBundle, "convertBallInfoToJSONObject fail, exception:%s", new Object[] { paramBundle });
      }
    }
    return localJSONObject;
  }
  
  private void a(BallReportInfo paramBallReportInfo)
  {
    this.nfD.dlk = paramBallReportInfo.dlk;
    this.nfD.hxt = paramBallReportInfo.hxt;
    this.nfD.nfH = paramBallReportInfo.nfH;
    this.nfD.nfG = paramBallReportInfo.nfG;
    this.nfD.nfF = paramBallReportInfo.nfF;
    this.nfD.nfE = paramBallReportInfo.nfE;
    this.nfD.opType = paramBallReportInfo.opType;
  }
  
  public static BallInfo aa(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127544);
    try
    {
      BallInfo localBallInfo = new BallInfo(paramJSONObject.getInt("type"), paramJSONObject.getString("key"), paramJSONObject.optJSONObject("reportInfo"));
      localBallInfo.aUt = paramJSONObject.optInt("contentType", 0);
      localBallInfo.nfC = paramJSONObject.optBoolean("hidden", false);
      localBallInfo.nfB = paramJSONObject.optBoolean("passive", false);
      localBallInfo.state = paramJSONObject.optInt("state", 0);
      localBallInfo.drM = paramJSONObject.optString("icon");
      localBallInfo.lzV = paramJSONObject.optInt("iconResId", -1);
      localBallInfo.name = paramJSONObject.optString("name");
      localBallInfo.desc = paramJSONObject.optString("desc");
      localBallInfo.tag = paramJSONObject.optString("tag");
      localBallInfo.progress = paramJSONObject.optLong("progress");
      localBallInfo.nfz = paramJSONObject.optLong("activeTime", 0L);
      localBallInfo.createTime = paramJSONObject.optLong("createTime", 0L);
      localBallInfo.hSN = ab(paramJSONObject.optJSONObject("extra"));
      AppMethodBeat.o(127544);
      return localBallInfo;
    }
    catch (Exception paramJSONObject)
    {
      ac.printErrStackTrace("MicroMsg.BallInfo", paramJSONObject, "convertJSONObjectToBallInfo fail, exception:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(127544);
    }
    return null;
  }
  
  private static Bundle ab(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127547);
    Bundle localBundle = new Bundle();
    if (paramJSONObject != null) {
      try
      {
        if (paramJSONObject.length() > 0)
        {
          Iterator localIterator = paramJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            BallInfo.a.a(localBundle, str, paramJSONObject.getJSONObject(str));
          }
        }
        AppMethodBeat.o(127547);
      }
      catch (Exception paramJSONObject)
      {
        ac.printErrStackTrace("MicroMsg.BallInfo", paramJSONObject, "convertJSONObjectToBundle fail, exception:%s", new Object[] { paramJSONObject });
      }
    }
    return localBundle;
  }
  
  private void bGf()
  {
    try
    {
      AppMethodBeat.i(127530);
      if (this.hSN == null) {
        this.hSN = new Bundle();
      }
      AppMethodBeat.o(127530);
      return;
    }
    finally {}
  }
  
  public static JSONObject v(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(127545);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", paramBallInfo.type);
      localJSONObject.put("contentType", paramBallInfo.aUt);
      localJSONObject.put("key", paramBallInfo.key);
      localJSONObject.put("name", paramBallInfo.name);
      localJSONObject.put("desc", paramBallInfo.desc);
      localJSONObject.put("tag", paramBallInfo.tag);
      localJSONObject.put("progress", paramBallInfo.progress);
      localJSONObject.put("icon", paramBallInfo.drM);
      localJSONObject.put("iconResId", paramBallInfo.lzV);
      localJSONObject.put("state", paramBallInfo.state);
      localJSONObject.put("activeTime", paramBallInfo.nfz);
      localJSONObject.put("createTime", paramBallInfo.createTime);
      localJSONObject.put("passive", paramBallInfo.nfB);
      localJSONObject.put("hidden", paramBallInfo.nfC);
      localJSONObject.put("extra", L(paramBallInfo.hSN));
      localJSONObject.put("reportInfo", paramBallInfo.nfD.bGg());
      AppMethodBeat.o(127545);
      return localJSONObject;
    }
    catch (Exception paramBallInfo)
    {
      ac.printErrStackTrace("MicroMsg.BallInfo", paramBallInfo, "convertBallInfoToJSONObject fail, exception:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(127545);
    }
    return null;
  }
  
  public final void R(String paramString, long paramLong)
  {
    try
    {
      AppMethodBeat.i(127537);
      if (!bs.isNullOrNil(paramString))
      {
        bGf();
        this.hSN.putLong(paramString, paramLong);
      }
      AppMethodBeat.o(127537);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final long SL(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 341
    //   7: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 344	com/tencent/mm/plugin/ball/model/BallInfo:hasExtra	(Ljava/lang/String;)Z
    //   15: ifeq +23 -> 38
    //   18: aload_0
    //   19: getfield 84	com/tencent/mm/plugin/ball/model/BallInfo:hSN	Landroid/os/Bundle;
    //   22: aload_1
    //   23: lconst_0
    //   24: invokevirtual 347	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   27: lstore_2
    //   28: ldc_w 341
    //   31: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: lload_2
    //   37: lreturn
    //   38: ldc_w 341
    //   41: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -10 -> 34
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	BallInfo
    //   0	52	1	paramString	String
    //   1	36	2	l	long
    // Exception table:
    //   from	to	target	type
    //   4	34	47	finally
    //   38	44	47	finally
  }
  
  public final void b(BallReportInfo paramBallReportInfo)
  {
    try
    {
      AppMethodBeat.i(197151);
      a(paramBallReportInfo);
      AppMethodBeat.o(197151);
      return;
    }
    finally
    {
      paramBallReportInfo = finally;
      throw paramBallReportInfo;
    }
  }
  
  public final String bGd()
  {
    AppMethodBeat.i(127529);
    String str = String.format("%s#%s", new Object[] { Integer.valueOf(this.type), this.key });
    AppMethodBeat.o(127529);
    return str;
  }
  
  public final int bGe()
  {
    if ((this.state == 8) || (this.state == 4)) {
      return 4;
    }
    return this.state;
  }
  
  public final void ck(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(127535);
      if (!bs.isNullOrNil(paramString))
      {
        bGf();
        this.hSN.putInt(paramString, paramInt);
      }
      AppMethodBeat.o(127535);
      return;
    }
    finally {}
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void ep(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(127532);
      if (!bs.isNullOrNil(paramString1))
      {
        bGf();
        this.hSN.putString(paramString1, paramString2);
      }
      AppMethodBeat.o(127532);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final String eq(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 382
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 344	com/tencent/mm/plugin/ball/model/BallInfo:hasExtra	(Ljava/lang/String;)Z
    //   13: ifeq +23 -> 36
    //   16: aload_0
    //   17: getfield 84	com/tencent/mm/plugin/ball/model/BallInfo:hSN	Landroid/os/Bundle;
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 384	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_2
    //   26: ldc_w 382
    //   29: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: ldc_w 382
    //   39: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -10 -> 32
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	BallInfo
    //   0	50	1	paramString1	String
    //   0	50	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	32	45	finally
    //   36	42	45	finally
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(127540);
    if ((paramObject instanceof BallInfo))
    {
      paramObject = (BallInfo)paramObject;
      if ((this.type == paramObject.type) && (!bs.isNullOrNil(this.key)) && (!bs.isNullOrNil(paramObject.key)) && (this.key.equals(paramObject.key)))
      {
        AppMethodBeat.o(127540);
        return true;
      }
    }
    AppMethodBeat.o(127540);
    return false;
  }
  
  /* Error */
  public final byte[] getByteArrayExtra(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 392
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 344	com/tencent/mm/plugin/ball/model/BallInfo:hasExtra	(Ljava/lang/String;)Z
    //   13: ifeq +22 -> 35
    //   16: aload_0
    //   17: getfield 84	com/tencent/mm/plugin/ball/model/BallInfo:hSN	Landroid/os/Bundle;
    //   20: aload_1
    //   21: invokevirtual 395	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   24: astore_1
    //   25: ldc_w 392
    //   28: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aconst_null
    //   36: astore_1
    //   37: ldc_w 392
    //   40: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -12 -> 31
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	BallInfo
    //   0	51	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	31	46	finally
    //   37	43	46	finally
  }
  
  /* Error */
  public final int getIntExtra(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 397
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 344	com/tencent/mm/plugin/ball/model/BallInfo:hasExtra	(Ljava/lang/String;)Z
    //   13: ifeq +23 -> 36
    //   16: aload_0
    //   17: getfield 84	com/tencent/mm/plugin/ball/model/BallInfo:hSN	Landroid/os/Bundle;
    //   20: aload_1
    //   21: iload_2
    //   22: invokevirtual 399	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   25: istore_2
    //   26: ldc_w 397
    //   29: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: ldc_w 397
    //   39: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -10 -> 32
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	BallInfo
    //   0	50	1	paramString	String
    //   0	50	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	32	45	finally
    //   36	42	45	finally
  }
  
  /* Error */
  public final boolean hasExtra(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 400
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 84	com/tencent/mm/plugin/ball/model/BallInfo:hSN	Landroid/os/Bundle;
    //   12: ifnull +29 -> 41
    //   15: aload_1
    //   16: invokestatic 334	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   19: ifne +22 -> 41
    //   22: aload_0
    //   23: getfield 84	com/tencent/mm/plugin/ball/model/BallInfo:hSN	Landroid/os/Bundle;
    //   26: aload_1
    //   27: invokevirtual 403	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   30: istore_2
    //   31: ldc_w 400
    //   34: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_2
    //   40: ireturn
    //   41: iconst_0
    //   42: istore_2
    //   43: ldc_w 400
    //   46: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -12 -> 37
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	BallInfo
    //   0	57	1	paramString	String
    //   30	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	37	52	finally
    //   43	49	52	finally
  }
  
  public final void l(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(127539);
      if (!bs.isNullOrNil(paramString))
      {
        bGf();
        this.hSN.putByteArray(paramString, paramArrayOfByte);
      }
      AppMethodBeat.o(127539);
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    AppMethodBeat.i(127541);
    String str = "BallInfo{type=" + this.type + ", key='" + this.key + '\'' + ", contentType='" + this.aUt + '\'' + ", passive=" + this.nfB + ", hidden=" + this.nfC + ", icon='" + this.drM + '\'' + ", iconResId=" + this.lzV + ", name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + ", tag='" + this.tag + '\'' + ", progress='" + this.progress + '\'' + ", state=" + this.state + ", activeTime=" + this.nfz + ", createTime=" + this.createTime + ", reportInfo=" + this.nfD.toString() + '}';
    AppMethodBeat.o(127541);
    return str;
  }
  
  public final void u(BallInfo paramBallInfo)
  {
    try
    {
      AppMethodBeat.i(197150);
      if (paramBallInfo != null)
      {
        this.drM = paramBallInfo.drM;
        this.lzV = paramBallInfo.lzV;
        this.name = paramBallInfo.name;
        this.desc = paramBallInfo.desc;
        this.tag = paramBallInfo.tag;
        this.progress = paramBallInfo.progress;
        this.hSN = paramBallInfo.hSN;
        this.state = paramBallInfo.state;
        this.nfB = paramBallInfo.nfB;
        this.tk = paramBallInfo.tk;
        this.aUt = paramBallInfo.aUt;
        a(paramBallInfo.nfD);
      }
      AppMethodBeat.o(197150);
      return;
    }
    finally {}
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(127543);
    for (;;)
    {
      try
      {
        paramParcel.writeInt(this.type);
        paramParcel.writeString(this.key);
        paramParcel.writeString(this.drM);
        paramParcel.writeInt(this.lzV);
        paramParcel.writeString(this.name);
        paramParcel.writeString(this.desc);
        paramParcel.writeString(this.tag);
        paramParcel.writeLong(this.progress);
        Bundle localBundle;
        if (this.hSN != null)
        {
          localBundle = this.hSN;
          paramParcel.writeBundle(localBundle);
          paramParcel.writeInt(this.state);
          if (this.nfB)
          {
            i = 1;
            paramParcel.writeInt(i);
            if (!this.nfC) {
              break label191;
            }
            i = 1;
            paramParcel.writeInt(i);
            paramParcel.writeParcelable(this.nfD, paramInt);
            paramParcel.writeInt(this.aUt);
            AppMethodBeat.o(127543);
          }
        }
        else
        {
          localBundle = new Bundle();
          continue;
        }
        i = 0;
      }
      catch (Exception paramParcel)
      {
        ac.printErrStackTrace("MicroMsg.BallInfo", paramParcel, "writeToParcel fail, exception:%s", new Object[] { paramParcel });
        AppMethodBeat.o(127543);
        return;
      }
      continue;
      label191:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.model.BallInfo
 * JD-Core Version:    0.7.0.1
 */