package com.tencent.mm.live.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/storage/LiveAnchorStorage;", "", "()V", "EXPIRATION_TIME", "", "FILE_NAME", "", "PATH", "TAG", "cleanCache", "", "getLiveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "hasLiveAnchorInfo", "", "liveFinish", "liveId", "", "liveStart", "roomId", "rotation", "liveName", "createTimeS", "anchorName", "plugin-logic_release"})
public final class a
{
  private static final String FILE_NAME = "anchor.proto";
  private static final String PATH;
  private static final String TAG = "MicroMsg.LiveAnchorStorage";
  private static final int hLb = 86400;
  public static final a hLc;
  
  static
  {
    AppMethodBeat.i(207847);
    hLc = new a();
    TAG = "MicroMsg.LiveAnchorStorage";
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    PATH = locale.getAccPath() + "live/";
    FILE_NAME = "anchor.proto";
    hLb = 86400;
    AppMethodBeat.o(207847);
  }
  
  public static void a(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(207843);
    p.h(paramString1, "roomId");
    p.h(paramString2, "liveName");
    p.h(paramString3, "anchorName");
    Log.i(TAG, "liveStart liveId:" + paramLong + ", roomId:" + paramString1 + ", rotation:" + paramInt1 + ", liveName:" + paramString2 + ", createTime:" + paramInt2);
    if (!s.YS(PATH)) {
      s.boN(PATH);
    }
    cip localcip = new cip();
    localcip.hyH = paramLong;
    localcip.MnB = paramString1;
    localcip.rotation = paramInt1;
    localcip.LpF = paramString2;
    localcip.Gaz = paramInt2;
    localcip.MnC = paramString3;
    paramString1 = localcip.toByteArray();
    s.C(PATH + FILE_NAME, paramString1);
    AppMethodBeat.o(207843);
  }
  
  public static cip aHm()
  {
    AppMethodBeat.i(207845);
    cip localcip = new cip();
    byte[] arrayOfByte = s.aW(PATH + FILE_NAME, 0, -1);
    int i;
    if (arrayOfByte != null)
    {
      if (arrayOfByte.length != 0) {
        break label191;
      }
      i = 1;
    }
    for (;;)
    {
      com.tencent.mm.bw.a locala;
      if (i == 0)
      {
        i = 1;
        if (i != 0) {
          locala = (com.tencent.mm.bw.a)localcip;
        }
      }
      try
      {
        locala.parseFrom(arrayOfByte);
        if ((localcip.Gaz > 0) && (cl.aWB() - localcip.Gaz >= hLb))
        {
          Log.i(TAG, "liveAnchorInfo expirated, liveId:" + localcip.hyH);
          localcip.hyH = 0L;
          localcip.MnB = "";
          localcip.rotation = -1;
          localcip.LpF = "";
          localcip.Gaz = 0;
          localcip.MnC = "";
          arrayOfByte = localcip.toByteArray();
          s.C(PATH + FILE_NAME, arrayOfByte);
        }
        AppMethodBeat.o(207845);
        return localcip;
        label191:
        i = 0;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
  
  public static void aHn()
  {
    AppMethodBeat.i(207846);
    Log.i(TAG, "liveAnchorInfo cleanCache");
    Object localObject = new cip();
    ((cip)localObject).hyH = 0L;
    ((cip)localObject).MnB = "";
    ((cip)localObject).rotation = -1;
    ((cip)localObject).LpF = "";
    ((cip)localObject).Gaz = 0;
    ((cip)localObject).MnC = "";
    localObject = ((cip)localObject).toByteArray();
    s.C(PATH + FILE_NAME, (byte[])localObject);
    AppMethodBeat.o(207846);
  }
  
  public static void zE(long paramLong)
  {
    AppMethodBeat.i(207844);
    Log.i(TAG, "liveFinish liveId:".concat(String.valueOf(paramLong)));
    Object localObject = new cip();
    byte[] arrayOfByte = s.aW(PATH + FILE_NAME, 0, -1);
    int i;
    if (arrayOfByte != null)
    {
      if (arrayOfByte.length != 0) {
        break label174;
      }
      i = 1;
    }
    for (;;)
    {
      com.tencent.mm.bw.a locala;
      if (i == 0)
      {
        i = 1;
        if (i != 0) {
          locala = (com.tencent.mm.bw.a)localObject;
        }
      }
      try
      {
        locala.parseFrom(arrayOfByte);
        if (((cip)localObject).hyH == paramLong)
        {
          ((cip)localObject).hyH = 0L;
          ((cip)localObject).MnB = "";
          ((cip)localObject).rotation = -1;
          ((cip)localObject).LpF = "";
          ((cip)localObject).Gaz = 0;
          ((cip)localObject).MnC = "";
          localObject = ((cip)localObject).toByteArray();
          s.C(PATH + FILE_NAME, (byte[])localObject);
        }
        AppMethodBeat.o(207844);
        return;
        label174:
        i = 0;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.c.a
 * JD-Core Version:    0.7.0.1
 */