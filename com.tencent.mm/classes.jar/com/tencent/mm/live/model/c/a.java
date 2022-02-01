package com.tencent.mm.live.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/storage/LiveAnchorStorage;", "", "()V", "EXPIRATION_TIME", "", "FILE_NAME", "", "PATH", "TAG", "cleanCache", "", "getLiveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "hasLiveAnchorInfo", "", "liveFinish", "liveId", "", "liveStart", "roomId", "rotation", "liveName", "createTimeS", "anchorName", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String FILE_NAME;
  private static final String TAG;
  public static final a nbR;
  private static final String nbS;
  private static final int nbT;
  
  static
  {
    AppMethodBeat.i(246814);
    nbR = new a();
    TAG = "MicroMsg.LiveAnchorStorage";
    nbS = s.X(h.baE().mCJ, "live/");
    FILE_NAME = "anchor.proto";
    nbT = 86400;
    AppMethodBeat.o(246814);
  }
  
  public static void a(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(246789);
    s.u(paramString1, "roomId");
    s.u(paramString2, "liveName");
    s.u(paramString3, "anchorName");
    Log.i(TAG, "liveStart liveId:" + paramLong + ", roomId:" + paramString1 + ", rotation:" + paramInt1 + ", liveName:" + paramString2 + ", createTime:" + paramInt2);
    if (!y.ZC(nbS)) {
      y.bDX(nbS);
    }
    dig localdig = new dig();
    localdig.mMJ = paramLong;
    localdig.aaNe = paramString1;
    localdig.rotation = paramInt1;
    localdig.Zqd = paramString2;
    localdig.HTK = paramInt2;
    localdig.aaNf = paramString3;
    paramString1 = localdig.toByteArray();
    y.f(s.X(nbS, FILE_NAME), paramString1, paramString1.length);
    AppMethodBeat.o(246789);
  }
  
  public static dig biZ()
  {
    AppMethodBeat.i(246804);
    dig localdig = new dig();
    byte[] arrayOfByte = y.bi(s.X(nbS, FILE_NAME), 0, -1);
    int i;
    if (arrayOfByte != null)
    {
      if (arrayOfByte.length != 0) {
        break label160;
      }
      i = 1;
    }
    for (;;)
    {
      com.tencent.mm.bx.a locala;
      if (i == 0)
      {
        i = 1;
        if (i != 0) {
          locala = (com.tencent.mm.bx.a)localdig;
        }
      }
      try
      {
        locala.parseFrom(arrayOfByte);
        if ((localdig.HTK > 0) && (cn.getSyncServerTimeSecond() - localdig.HTK >= nbT))
        {
          Log.i(TAG, s.X("liveAnchorInfo expirated, liveId:", Long.valueOf(localdig.mMJ)));
          localdig.mMJ = 0L;
          localdig.aaNe = "";
          localdig.rotation = -1;
          localdig.Zqd = "";
          localdig.HTK = 0;
          localdig.aaNf = "";
          arrayOfByte = localdig.toByteArray();
          y.f(s.X(nbS, FILE_NAME), arrayOfByte, arrayOfByte.length);
        }
        AppMethodBeat.o(246804);
        return localdig;
        label160:
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
  
  public static void bja()
  {
    AppMethodBeat.i(246808);
    Log.i(TAG, "liveAnchorInfo cleanCache");
    Object localObject = new dig();
    ((dig)localObject).mMJ = 0L;
    ((dig)localObject).aaNe = "";
    ((dig)localObject).rotation = -1;
    ((dig)localObject).Zqd = "";
    ((dig)localObject).HTK = 0;
    ((dig)localObject).aaNf = "";
    localObject = ((dig)localObject).toByteArray();
    y.f(s.X(nbS, FILE_NAME), (byte[])localObject, localObject.length);
    AppMethodBeat.o(246808);
  }
  
  public static void hS(long paramLong)
  {
    AppMethodBeat.i(246799);
    Log.i(TAG, s.X("liveFinish liveId:", Long.valueOf(paramLong)));
    Object localObject = new dig();
    byte[] arrayOfByte = y.bi(s.X(nbS, FILE_NAME), 0, -1);
    int i;
    if (arrayOfByte != null)
    {
      if (arrayOfByte.length != 0) {
        break label150;
      }
      i = 1;
    }
    for (;;)
    {
      com.tencent.mm.bx.a locala;
      if (i == 0)
      {
        i = 1;
        if (i != 0) {
          locala = (com.tencent.mm.bx.a)localObject;
        }
      }
      try
      {
        locala.parseFrom(arrayOfByte);
        if (((dig)localObject).mMJ == paramLong)
        {
          ((dig)localObject).mMJ = 0L;
          ((dig)localObject).aaNe = "";
          ((dig)localObject).rotation = -1;
          ((dig)localObject).Zqd = "";
          ((dig)localObject).HTK = 0;
          ((dig)localObject).aaNf = "";
          localObject = ((dig)localObject).toByteArray();
          y.f(s.X(nbS, FILE_NAME), (byte[])localObject, localObject.length);
        }
        AppMethodBeat.o(246799);
        return;
        label150:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.live.model.c.a
 * JD-Core Version:    0.7.0.1
 */