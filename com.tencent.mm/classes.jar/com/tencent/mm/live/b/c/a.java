package com.tencent.mm.live.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/storage/LiveAnchorStorage;", "", "()V", "EXPIRATION_TIME", "", "FILE_NAME", "", "PATH", "TAG", "cleanCache", "", "getLiveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "hasLiveAnchorInfo", "", "liveFinish", "liveId", "", "liveStart", "roomId", "rotation", "liveName", "createTimeS", "anchorName", "plugin-logic_release"})
public final class a
{
  private static final String FILE_NAME = "anchor.proto";
  private static final String PATH;
  private static final String TAG = "MicroMsg.LiveAnchorStorage";
  private static final int kyv = 86400;
  public static final a kyw;
  
  static
  {
    AppMethodBeat.i(193123);
    kyw = new a();
    TAG = "MicroMsg.LiveAnchorStorage";
    StringBuilder localStringBuilder = new StringBuilder();
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    PATH = localf.getAccPath() + "live/";
    FILE_NAME = "anchor.proto";
    kyv = 86400;
    AppMethodBeat.o(193123);
  }
  
  public static void FL(long paramLong)
  {
    AppMethodBeat.i(193098);
    Log.i(TAG, "liveFinish liveId:".concat(String.valueOf(paramLong)));
    Object localObject = new crl();
    byte[] arrayOfByte = u.aY(PATH + FILE_NAME, 0, -1);
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
      com.tencent.mm.cd.a locala;
      if (i == 0)
      {
        i = 1;
        if (i != 0) {
          locala = (com.tencent.mm.cd.a)localObject;
        }
      }
      try
      {
        locala.parseFrom(arrayOfByte);
        if (((crl)localObject).klE == paramLong)
        {
          ((crl)localObject).klE = 0L;
          ((crl)localObject).Tyw = "";
          ((crl)localObject).rotation = -1;
          ((crl)localObject).Srb = "";
          ((crl)localObject).ChC = 0;
          ((crl)localObject).Tyx = "";
          localObject = ((crl)localObject).toByteArray();
          u.H(PATH + FILE_NAME, (byte[])localObject);
        }
        AppMethodBeat.o(193098);
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
  
  public static void a(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(193093);
    p.k(paramString1, "roomId");
    p.k(paramString2, "liveName");
    p.k(paramString3, "anchorName");
    Log.i(TAG, "liveStart liveId:" + paramLong + ", roomId:" + paramString1 + ", rotation:" + paramInt1 + ", liveName:" + paramString2 + ", createTime:" + paramInt2);
    if (!u.agG(PATH)) {
      u.bBD(PATH);
    }
    crl localcrl = new crl();
    localcrl.klE = paramLong;
    localcrl.Tyw = paramString1;
    localcrl.rotation = paramInt1;
    localcrl.Srb = paramString2;
    localcrl.ChC = paramInt2;
    localcrl.Tyx = paramString3;
    paramString1 = localcrl.toByteArray();
    u.H(PATH + FILE_NAME, paramString1);
    AppMethodBeat.o(193093);
  }
  
  public static crl aPm()
  {
    AppMethodBeat.i(193107);
    crl localcrl = new crl();
    byte[] arrayOfByte = u.aY(PATH + FILE_NAME, 0, -1);
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
      com.tencent.mm.cd.a locala;
      if (i == 0)
      {
        i = 1;
        if (i != 0) {
          locala = (com.tencent.mm.cd.a)localcrl;
        }
      }
      try
      {
        locala.parseFrom(arrayOfByte);
        if ((localcrl.ChC > 0) && (cm.bfF() - localcrl.ChC >= kyv))
        {
          Log.i(TAG, "liveAnchorInfo expirated, liveId:" + localcrl.klE);
          localcrl.klE = 0L;
          localcrl.Tyw = "";
          localcrl.rotation = -1;
          localcrl.Srb = "";
          localcrl.ChC = 0;
          localcrl.Tyx = "";
          arrayOfByte = localcrl.toByteArray();
          u.H(PATH + FILE_NAME, arrayOfByte);
        }
        AppMethodBeat.o(193107);
        return localcrl;
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
  
  public static void aPn()
  {
    AppMethodBeat.i(193113);
    Log.i(TAG, "liveAnchorInfo cleanCache");
    Object localObject = new crl();
    ((crl)localObject).klE = 0L;
    ((crl)localObject).Tyw = "";
    ((crl)localObject).rotation = -1;
    ((crl)localObject).Srb = "";
    ((crl)localObject).ChC = 0;
    ((crl)localObject).Tyx = "";
    localObject = ((crl)localObject).toByteArray();
    u.H(PATH + FILE_NAME, (byte[])localObject);
    AppMethodBeat.o(193113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.c.a
 * JD-Core Version:    0.7.0.1
 */