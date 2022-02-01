package com.tencent.mm.plugin.brandservice.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class TransferRequestInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TransferRequestInfo> CREATOR;
  public String scope;
  public int type;
  public String url;
  public String vBk;
  public dev vBl;
  public gol vBm;
  public boolean vBn;
  
  static
  {
    AppMethodBeat.i(301533);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(301533);
  }
  
  public TransferRequestInfo()
  {
    this.type = -1;
    this.url = "";
    this.scope = "";
    this.vBk = "";
    this.vBl = null;
    this.vBm = null;
    this.vBn = false;
  }
  
  public TransferRequestInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(301525);
    this.type = -1;
    this.url = "";
    this.scope = "";
    this.vBk = "";
    this.vBl = null;
    this.vBm = null;
    this.vBn = false;
    this.type = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.scope = paramParcel.readString();
    this.vBk = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.vBn = bool;
    for (;;)
    {
      try
      {
        i = paramParcel.readInt();
        if (i > 0)
        {
          arrayOfByte = new byte[i];
          paramParcel.readByteArray(arrayOfByte);
          this.vBl = new dev();
          this.vBl.parseFrom(arrayOfByte);
        }
      }
      catch (Exception localException)
      {
        int i;
        byte[] arrayOfByte;
        continue;
      }
      try
      {
        i = paramParcel.readInt();
        if (i > 0)
        {
          arrayOfByte = new byte[i];
          paramParcel.readByteArray(arrayOfByte);
          this.vBm = new gol();
          this.vBm.dg(arrayOfByte);
        }
        AppMethodBeat.o(301525);
        return;
      }
      catch (Exception paramParcel)
      {
        AppMethodBeat.o(301525);
        return;
      }
    }
  }
  
  public static TransferRequestInfo aL(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(301531);
    TransferRequestInfo localTransferRequestInfo;
    try
    {
      localTransferRequestInfo = new TransferRequestInfo();
      localTransferRequestInfo.type = paramJSONObject.optInt("type", -1);
      localTransferRequestInfo.url = paramJSONObject.optString("h5Url");
      localTransferRequestInfo.scope = paramJSONObject.optString("scope");
      localTransferRequestInfo.vBl = new dev();
      localTransferRequestInfo.vBl.url = paramJSONObject.optString("reqUrl");
      localTransferRequestInfo.vBl.aaKR = paramJSONObject.optInt("cgiCmdId");
      localTransferRequestInfo.vBl.YSb = paramJSONObject.getJSONObject("reqBody").toString();
      localTransferRequestInfo.vBl.method = paramJSONObject.optInt("method");
      paramJSONObject = paramJSONObject.optString("header");
      if (!Util.isNullOrNil(paramJSONObject))
      {
        paramJSONObject = new JSONObject(paramJSONObject);
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = paramJSONObject.optString(str1);
          czo localczo = new czo();
          localczo.key = str1;
          localczo.value = str2;
          localTransferRequestInfo.vBl.aaKS.push(localczo);
        }
      }
      AppMethodBeat.o(301531);
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.TransferRequestInfo", paramJSONObject, "parseTransferRequestInfo from json exception", new Object[0]);
      AppMethodBeat.o(301531);
      return null;
    }
    return localTransferRequestInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  /* Error */
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 199
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 44	com/tencent/mm/plugin/brandservice/api/TransferRequestInfo:type	I
    //   12: invokevirtual 202	android/os/Parcel:writeInt	(I)V
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 48	com/tencent/mm/plugin/brandservice/api/TransferRequestInfo:url	Ljava/lang/String;
    //   20: invokevirtual 205	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 50	com/tencent/mm/plugin/brandservice/api/TransferRequestInfo:scope	Ljava/lang/String;
    //   28: invokevirtual 205	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   31: aload_1
    //   32: aload_0
    //   33: getfield 52	com/tencent/mm/plugin/brandservice/api/TransferRequestInfo:vBk	Ljava/lang/String;
    //   36: invokevirtual 205	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 58	com/tencent/mm/plugin/brandservice/api/TransferRequestInfo:vBn	Z
    //   43: ifeq +5 -> 48
    //   46: iconst_1
    //   47: istore_3
    //   48: aload_1
    //   49: iload_3
    //   50: invokevirtual 209	android/os/Parcel:writeByte	(B)V
    //   53: aload_0
    //   54: getfield 54	com/tencent/mm/plugin/brandservice/api/TransferRequestInfo:vBl	Lcom/tencent/mm/protocal/protobuf/dev;
    //   57: ifnull +36 -> 93
    //   60: aload_0
    //   61: getfield 54	com/tencent/mm/plugin/brandservice/api/TransferRequestInfo:vBl	Lcom/tencent/mm/protocal/protobuf/dev;
    //   64: invokevirtual 213	com/tencent/mm/protocal/protobuf/dev:toByteArray	()[B
    //   67: astore 4
    //   69: aload 4
    //   71: ifnull +68 -> 139
    //   74: aload 4
    //   76: arraylength
    //   77: ifle +62 -> 139
    //   80: aload_1
    //   81: aload 4
    //   83: arraylength
    //   84: invokevirtual 202	android/os/Parcel:writeInt	(I)V
    //   87: aload_1
    //   88: aload 4
    //   90: invokevirtual 216	android/os/Parcel:writeByteArray	([B)V
    //   93: aload_0
    //   94: getfield 56	com/tencent/mm/plugin/brandservice/api/TransferRequestInfo:vBm	Lcom/tencent/mm/protocal/protobuf/gol;
    //   97: ifnull +60 -> 157
    //   100: aload_0
    //   101: getfield 56	com/tencent/mm/plugin/brandservice/api/TransferRequestInfo:vBm	Lcom/tencent/mm/protocal/protobuf/gol;
    //   104: invokevirtual 217	com/tencent/mm/protocal/protobuf/gol:toByteArray	()[B
    //   107: astore 4
    //   109: aload 4
    //   111: ifnull +41 -> 152
    //   114: aload 4
    //   116: arraylength
    //   117: ifle +35 -> 152
    //   120: aload_1
    //   121: aload 4
    //   123: arraylength
    //   124: invokevirtual 202	android/os/Parcel:writeInt	(I)V
    //   127: aload_1
    //   128: aload 4
    //   130: invokevirtual 216	android/os/Parcel:writeByteArray	([B)V
    //   133: ldc 199
    //   135: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: return
    //   139: aload_1
    //   140: iconst_0
    //   141: invokevirtual 202	android/os/Parcel:writeInt	(I)V
    //   144: goto -51 -> 93
    //   147: astore 4
    //   149: goto -56 -> 93
    //   152: aload_1
    //   153: iconst_0
    //   154: invokevirtual 202	android/os/Parcel:writeInt	(I)V
    //   157: ldc 199
    //   159: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: return
    //   163: astore_1
    //   164: ldc 199
    //   166: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	TransferRequestInfo
    //   0	170	1	paramParcel	Parcel
    //   0	170	2	paramInt	int
    //   1	49	3	b	byte
    //   67	62	4	arrayOfByte	byte[]
    //   147	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   53	69	147	java/lang/Exception
    //   74	93	147	java/lang/Exception
    //   139	144	147	java/lang/Exception
    //   93	109	163	java/lang/Exception
    //   114	138	163	java/lang/Exception
    //   152	157	163	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.api.TransferRequestInfo
 * JD-Core Version:    0.7.0.1
 */