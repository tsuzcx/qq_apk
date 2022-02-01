package com.tencent.mm.live.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/storage/LiveAnchorStorage;", "", "()V", "EXPIRATION_TIME", "", "FILE_NAME", "", "PATH", "TAG", "cleanCache", "", "getLiveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "hasLiveAnchorInfo", "", "liveFinish", "liveId", "", "liveStart", "roomId", "rotation", "liveName", "createTimeS", "anchorName", "plugin-logic_release"})
public final class a
{
  private static final String FILE_NAME = "anchor.proto";
  private static final String PATH;
  private static final String TAG = "MicroMsg.LiveAnchorStorage";
  private static final int gQZ = 86400;
  public static final a gRa;
  
  static
  {
    AppMethodBeat.i(212274);
    gRa = new a();
    TAG = "MicroMsg.LiveAnchorStorage";
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    PATH = locale.getAccPath() + "live/";
    FILE_NAME = "anchor.proto";
    gQZ = 86400;
    AppMethodBeat.o(212274);
  }
  
  public static void a(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(212270);
    p.h(paramString1, "roomId");
    p.h(paramString2, "liveName");
    p.h(paramString3, "anchorName");
    ad.i(TAG, "liveStart liveId:" + paramLong + ", roomId:" + paramString1 + ", rotation:" + paramInt1 + ", liveName:" + paramString2 + ", createTime:" + paramInt2);
    if (!i.fv(PATH)) {
      i.aYg(PATH);
    }
    bun localbun = new bun();
    localbun.Fsa = paramLong;
    localbun.GOz = paramString1;
    localbun.rotation = paramInt1;
    localbun.Gbw = paramString2;
    localbun.FHr = paramInt2;
    localbun.GOA = paramString3;
    paramString1 = localbun.toByteArray();
    i.C(PATH + FILE_NAME, paramString1);
    AppMethodBeat.o(212270);
  }
  
  public static bun aow()
  {
    AppMethodBeat.i(212272);
    bun localbun = new bun();
    byte[] arrayOfByte = i.aY(PATH + FILE_NAME, 0, -1);
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
      com.tencent.mm.bx.a locala;
      if (i == 0)
      {
        i = 1;
        if (i != 0) {
          locala = (com.tencent.mm.bx.a)localbun;
        }
      }
      try
      {
        locala.parseFrom(arrayOfByte);
        if ((localbun.FHr > 0) && (cf.aCN() - localbun.FHr >= gQZ))
        {
          ad.i(TAG, "liveAnchorInfo expirated, liveId:" + localbun.Fsa);
          localbun.Fsa = 0L;
          localbun.GOz = "";
          localbun.rotation = -1;
          localbun.Gbw = "";
          localbun.FHr = 0;
          localbun.GOA = "";
          arrayOfByte = localbun.toByteArray();
          i.C(PATH + FILE_NAME, arrayOfByte);
        }
        AppMethodBeat.o(212272);
        return localbun;
        label191:
        i = 0;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
  
  public static void aox()
  {
    AppMethodBeat.i(212273);
    ad.i(TAG, "liveAnchorInfo cleanCache");
    Object localObject = new bun();
    ((bun)localObject).Fsa = 0L;
    ((bun)localObject).GOz = "";
    ((bun)localObject).rotation = -1;
    ((bun)localObject).Gbw = "";
    ((bun)localObject).FHr = 0;
    ((bun)localObject).GOA = "";
    localObject = ((bun)localObject).toByteArray();
    i.C(PATH + FILE_NAME, (byte[])localObject);
    AppMethodBeat.o(212273);
  }
  
  public static void rm(long paramLong)
  {
    AppMethodBeat.i(212271);
    ad.i(TAG, "liveFinish liveId:".concat(String.valueOf(paramLong)));
    Object localObject = new bun();
    byte[] arrayOfByte = i.aY(PATH + FILE_NAME, 0, -1);
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
        if (((bun)localObject).Fsa == paramLong)
        {
          ((bun)localObject).Fsa = 0L;
          ((bun)localObject).GOz = "";
          ((bun)localObject).rotation = -1;
          ((bun)localObject).Gbw = "";
          ((bun)localObject).FHr = 0;
          ((bun)localObject).GOA = "";
          localObject = ((bun)localObject).toByteArray();
          i.C(PATH + FILE_NAME, (byte[])localObject);
        }
        AppMethodBeat.o(212271);
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
          ad.l("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.c.a
 * JD-Core Version:    0.7.0.1
 */