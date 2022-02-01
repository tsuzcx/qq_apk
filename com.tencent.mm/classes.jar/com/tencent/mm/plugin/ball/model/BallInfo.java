package com.tencent.mm.plugin.ball.model;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class BallInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BallInfo> CREATOR;
  public int cIh;
  public long createTime;
  public String desc;
  public View dyK;
  public long egK;
  public long hQO;
  public String icon;
  public String key;
  public boolean lwK;
  public String name;
  public Bundle oSS;
  public int state;
  public String tag;
  public boolean trn;
  public int tus;
  public int type;
  public int vjB;
  public Point vjC;
  public Point vjD;
  public View vjE;
  public long vjF;
  public boolean vjG;
  public boolean vjH;
  public BallReportInfo vjI;
  public a vjJ;
  public boolean vjK;
  
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
    this.vjB = 0;
    this.vjC = null;
    this.vjD = null;
    this.tus = -1;
    this.hQO = -2147483648L;
    this.vjF = 0L;
    this.createTime = 0L;
    this.egK = 0L;
    this.vjG = false;
    this.oSS = new Bundle();
    this.state = 0;
    this.vjH = false;
    this.trn = false;
    this.lwK = false;
    this.vjJ = null;
    this.vjK = false;
    this.type = paramInt;
    this.key = paramString;
    if (paramJSONObject == null) {}
    for (paramString = new BallReportInfo();; paramString = new BallReportInfo(paramJSONObject))
    {
      this.vjI = paramString;
      this.cIh = paramInt;
      AppMethodBeat.o(127528);
      return;
    }
  }
  
  protected BallInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(127542);
    this.vjB = 0;
    this.vjC = null;
    this.vjD = null;
    this.tus = -1;
    this.hQO = -2147483648L;
    this.vjF = 0L;
    this.createTime = 0L;
    this.egK = 0L;
    this.vjG = false;
    this.oSS = new Bundle();
    this.state = 0;
    this.vjH = false;
    this.trn = false;
    this.lwK = false;
    this.vjJ = null;
    this.vjK = false;
    try
    {
      this.type = paramParcel.readInt();
      this.key = paramParcel.readString();
      this.icon = paramParcel.readString();
      this.tus = paramParcel.readInt();
      this.name = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.tag = paramParcel.readString();
      this.hQO = paramParcel.readLong();
      this.oSS = paramParcel.readBundle(getClass().getClassLoader());
      this.state = paramParcel.readInt();
      boolean bool;
      label209:
      BallReportInfo localBallReportInfo;
      if (paramParcel.readInt() == 1)
      {
        bool = true;
        this.vjH = bool;
        if (paramParcel.readInt() != 1) {
          break label257;
        }
        bool = true;
        this.trn = bool;
        localBallReportInfo = (BallReportInfo)paramParcel.readParcelable(getClass().getClassLoader());
        if (localBallReportInfo == null) {
          break label262;
        }
      }
      for (;;)
      {
        this.vjI = localBallReportInfo;
        this.cIh = paramParcel.readInt();
        AppMethodBeat.o(127542);
        return;
        bool = false;
        break;
        label257:
        bool = false;
        break label209;
        label262:
        localBallReportInfo = new BallReportInfo();
      }
      return;
    }
    catch (Exception paramParcel)
    {
      Log.printErrStackTrace("MicroMsg.BallInfo", paramParcel, "readFromParcel fail, exception:%s", new Object[] { paramParcel });
      AppMethodBeat.o(127542);
    }
  }
  
  private void a(BallReportInfo paramBallReportInfo)
  {
    this.vjI.hOH = paramBallReportInfo.hOH;
    this.vjI.ovT = paramBallReportInfo.ovT;
    this.vjI.vjO = paramBallReportInfo.vjO;
    this.vjI.mUU = paramBallReportInfo.mUU;
    this.vjI.vjN = paramBallReportInfo.vjN;
    this.vjI.mUT = paramBallReportInfo.mUT;
    this.vjI.opType = paramBallReportInfo.opType;
  }
  
  public static BallInfo aJ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127544);
    try
    {
      BallInfo localBallInfo = new BallInfo(paramJSONObject.getInt("type"), paramJSONObject.getString("key"), paramJSONObject.optJSONObject("reportInfo"));
      localBallInfo.cIh = paramJSONObject.optInt("contentType", 0);
      localBallInfo.trn = paramJSONObject.optBoolean("hidden", false);
      localBallInfo.vjH = paramJSONObject.optBoolean("passive", false);
      localBallInfo.state = paramJSONObject.optInt("state", 0);
      localBallInfo.icon = paramJSONObject.optString("icon");
      localBallInfo.tus = paramJSONObject.optInt("iconResId", -1);
      localBallInfo.name = paramJSONObject.optString("name");
      localBallInfo.desc = paramJSONObject.optString("desc");
      localBallInfo.tag = paramJSONObject.optString("tag");
      localBallInfo.hQO = paramJSONObject.optLong("progress");
      localBallInfo.vjF = paramJSONObject.optLong("activeTime", 0L);
      localBallInfo.createTime = paramJSONObject.optLong("createTime", 0L);
      localBallInfo.oSS = aK(paramJSONObject.optJSONObject("extra"));
      AppMethodBeat.o(127544);
      return localBallInfo;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.BallInfo", paramJSONObject, "convertJSONObjectToBallInfo fail, exception:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(127544);
    }
    return null;
  }
  
  private static Bundle aK(JSONObject paramJSONObject)
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
            BallInfo.b.a(localBundle, str, paramJSONObject.getJSONObject(str));
          }
        }
        AppMethodBeat.o(127547);
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.BallInfo", paramJSONObject, "convertJSONObjectToBundle fail, exception:%s", new Object[] { paramJSONObject });
      }
    }
    return localBundle;
  }
  
  private static JSONObject ah(Bundle paramBundle)
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
            localJSONObject.put(str, new BallInfo.b(paramBundle.get(str)));
          }
        }
        AppMethodBeat.o(127546);
      }
      catch (Exception paramBundle)
      {
        Log.printErrStackTrace("MicroMsg.BallInfo", paramBundle, "convertBallInfoToJSONObject fail, exception:%s", new Object[] { paramBundle });
      }
    }
    return localJSONObject;
  }
  
  private void cYe()
  {
    try
    {
      AppMethodBeat.i(127530);
      if (this.oSS == null) {
        this.oSS = new Bundle();
      }
      AppMethodBeat.o(127530);
      return;
    }
    finally {}
  }
  
  public static JSONObject x(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(127545);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", paramBallInfo.type);
      localJSONObject.put("contentType", paramBallInfo.cIh);
      localJSONObject.put("key", paramBallInfo.key);
      localJSONObject.put("name", paramBallInfo.name);
      localJSONObject.put("desc", paramBallInfo.desc);
      localJSONObject.put("tag", paramBallInfo.tag);
      localJSONObject.put("progress", paramBallInfo.hQO);
      localJSONObject.put("icon", paramBallInfo.icon);
      localJSONObject.put("iconResId", paramBallInfo.tus);
      localJSONObject.put("state", paramBallInfo.state);
      localJSONObject.put("activeTime", paramBallInfo.vjF);
      localJSONObject.put("createTime", paramBallInfo.createTime);
      localJSONObject.put("passive", paramBallInfo.vjH);
      localJSONObject.put("hidden", paramBallInfo.trn);
      localJSONObject.put("extra", ah(paramBallInfo.oSS));
      localJSONObject.put("reportInfo", paramBallInfo.vjI.cYf());
      AppMethodBeat.o(127545);
      return localJSONObject;
    }
    catch (Exception paramBallInfo)
    {
      Log.printErrStackTrace("MicroMsg.BallInfo", paramBallInfo, "convertBallInfoToJSONObject fail, exception:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(127545);
    }
    return null;
  }
  
  public final void ac(String paramString, long paramLong)
  {
    try
    {
      AppMethodBeat.i(127537);
      if (!Util.isNullOrNil(paramString))
      {
        cYe();
        this.oSS.putLong(paramString, paramLong);
      }
      AppMethodBeat.o(127537);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean ahQ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 360
    //   5: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 100	com/tencent/mm/plugin/ball/model/BallInfo:oSS	Landroid/os/Bundle;
    //   12: ifnull +29 -> 41
    //   15: aload_1
    //   16: invokestatic 353	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   19: ifne +22 -> 41
    //   22: aload_0
    //   23: getfield 100	com/tencent/mm/plugin/ball/model/BallInfo:oSS	Landroid/os/Bundle;
    //   26: aload_1
    //   27: invokevirtual 363	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   30: istore_2
    //   31: ldc_w 360
    //   34: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_2
    //   40: ireturn
    //   41: iconst_0
    //   42: istore_2
    //   43: ldc_w 360
    //   46: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  /* Error */
  public final long ahR(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 365
    //   7: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 367	com/tencent/mm/plugin/ball/model/BallInfo:ahQ	(Ljava/lang/String;)Z
    //   15: ifeq +23 -> 38
    //   18: aload_0
    //   19: getfield 100	com/tencent/mm/plugin/ball/model/BallInfo:oSS	Landroid/os/Bundle;
    //   22: aload_1
    //   23: lconst_0
    //   24: invokevirtual 370	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   27: lstore_2
    //   28: ldc_w 365
    //   31: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: lload_2
    //   37: lreturn
    //   38: ldc_w 365
    //   41: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(288413);
      a(paramBallReportInfo);
      AppMethodBeat.o(288413);
      return;
    }
    finally
    {
      paramBallReportInfo = finally;
      throw paramBallReportInfo;
    }
  }
  
  public final String cYc()
  {
    AppMethodBeat.i(127529);
    String str = String.format("%s#%s", new Object[] { Integer.valueOf(this.type), this.key });
    AppMethodBeat.o(127529);
    return str;
  }
  
  public final int cYd()
  {
    if ((this.state == 8) || (this.state == 4)) {
      return 4;
    }
    return this.state;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void dv(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(127535);
      if (!Util.isNullOrNil(paramString))
      {
        cYe();
        this.oSS.putInt(paramString, paramInt);
      }
      AppMethodBeat.o(127535);
      return;
    }
    finally {}
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(127540);
    if ((paramObject instanceof BallInfo))
    {
      paramObject = (BallInfo)paramObject;
      if ((this.type == paramObject.type) && (!Util.isNullOrNil(this.key)) && (!Util.isNullOrNil(paramObject.key)) && (this.key.equals(paramObject.key)))
      {
        AppMethodBeat.o(127540);
        return true;
      }
    }
    AppMethodBeat.o(127540);
    return false;
  }
  
  public final void fx(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(127532);
      if (!Util.isNullOrNil(paramString1))
      {
        cYe();
        this.oSS.putString(paramString1, paramString2);
      }
      AppMethodBeat.o(127532);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final String fy(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 410
    //   5: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 367	com/tencent/mm/plugin/ball/model/BallInfo:ahQ	(Ljava/lang/String;)Z
    //   13: ifeq +23 -> 36
    //   16: aload_0
    //   17: getfield 100	com/tencent/mm/plugin/ball/model/BallInfo:oSS	Landroid/os/Bundle;
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 412	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_2
    //   26: ldc_w 410
    //   29: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: ldc_w 410
    //   39: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  /* Error */
  public final byte[] getByteArrayExtra(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 415
    //   5: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 367	com/tencent/mm/plugin/ball/model/BallInfo:ahQ	(Ljava/lang/String;)Z
    //   13: ifeq +22 -> 35
    //   16: aload_0
    //   17: getfield 100	com/tencent/mm/plugin/ball/model/BallInfo:oSS	Landroid/os/Bundle;
    //   20: aload_1
    //   21: invokevirtual 418	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   24: astore_1
    //   25: ldc_w 415
    //   28: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aconst_null
    //   36: astore_1
    //   37: ldc_w 415
    //   40: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 420
    //   5: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 367	com/tencent/mm/plugin/ball/model/BallInfo:ahQ	(Ljava/lang/String;)Z
    //   13: ifeq +23 -> 36
    //   16: aload_0
    //   17: getfield 100	com/tencent/mm/plugin/ball/model/BallInfo:oSS	Landroid/os/Bundle;
    //   20: aload_1
    //   21: iload_2
    //   22: invokevirtual 422	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   25: istore_2
    //   26: ldc_w 420
    //   29: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: ldc_w 420
    //   39: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void p(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(127539);
      if (!Util.isNullOrNil(paramString))
      {
        cYe();
        this.oSS.putByteArray(paramString, paramArrayOfByte);
      }
      AppMethodBeat.o(127539);
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    AppMethodBeat.i(127541);
    String str = "BallInfo{type=" + this.type + ", key='" + this.key + '\'' + ", contentType='" + this.cIh + '\'' + ", passive=" + this.vjH + ", hidden=" + this.trn + ", icon='" + this.icon + '\'' + ", iconResId=" + this.tus + ", name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + ", tag='" + this.tag + '\'' + ", progress='" + this.hQO + '\'' + ", state=" + this.state + ", activeTime=" + this.vjF + ", createTime=" + this.createTime + ", reportInfo=" + this.vjI.toString() + '}';
    AppMethodBeat.o(127541);
    return str;
  }
  
  public final void w(BallInfo paramBallInfo)
  {
    try
    {
      AppMethodBeat.i(288408);
      if (paramBallInfo != null)
      {
        this.icon = paramBallInfo.icon;
        this.tus = paramBallInfo.tus;
        this.name = paramBallInfo.name;
        this.desc = paramBallInfo.desc;
        this.tag = paramBallInfo.tag;
        this.hQO = paramBallInfo.hQO;
        this.oSS = paramBallInfo.oSS;
        this.state = paramBallInfo.state;
        this.vjH = paramBallInfo.vjH;
        this.dyK = paramBallInfo.dyK;
        this.cIh = paramBallInfo.cIh;
        this.vjC = paramBallInfo.vjC;
        a(paramBallInfo.vjI);
      }
      AppMethodBeat.o(288408);
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
        paramParcel.writeString(this.icon);
        paramParcel.writeInt(this.tus);
        paramParcel.writeString(this.name);
        paramParcel.writeString(this.desc);
        paramParcel.writeString(this.tag);
        paramParcel.writeLong(this.hQO);
        Bundle localBundle;
        if (this.oSS != null)
        {
          localBundle = this.oSS;
          paramParcel.writeBundle(localBundle);
          paramParcel.writeInt(this.state);
          if (this.vjH)
          {
            i = 1;
            paramParcel.writeInt(i);
            if (!this.trn) {
              break label191;
            }
            i = 1;
            paramParcel.writeInt(i);
            paramParcel.writeParcelable(this.vjI, paramInt);
            paramParcel.writeInt(this.cIh);
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
        Log.printErrStackTrace("MicroMsg.BallInfo", paramParcel, "writeToParcel fail, exception:%s", new Object[] { paramParcel });
        AppMethodBeat.o(127543);
        return;
      }
      continue;
      label191:
      int i = 0;
    }
  }
  
  public static final class a
  {
    public Point vjL;
    public Point vjM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.model.BallInfo
 * JD-Core Version:    0.7.0.1
 */