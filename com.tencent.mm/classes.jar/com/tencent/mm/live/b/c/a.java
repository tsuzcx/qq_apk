package com.tencent.mm.live.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/storage/LiveAnchorStorage;", "", "()V", "EXPIRATION_TIME", "", "FILE_NAME", "", "PATH", "TAG", "cleanCache", "", "getLiveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "hasLiveAnchorInfo", "", "liveFinish", "liveId", "", "liveStart", "roomId", "rotation", "liveName", "createTimeS", "anchorName", "plugin-logic_release"})
public final class a
{
  private static final String FILE_NAME = "anchor.proto";
  private static final String PATH;
  private static final String TAG = "MicroMsg.LiveAnchorStorage";
  private static final int gTH = 86400;
  public static final a gTI;
  
  static
  {
    AppMethodBeat.i(215894);
    gTI = new a();
    TAG = "MicroMsg.LiveAnchorStorage";
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    PATH = locale.getAccPath() + "live/";
    FILE_NAME = "anchor.proto";
    gTH = 86400;
    AppMethodBeat.o(215894);
  }
  
  public static void a(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(215890);
    p.h(paramString1, "roomId");
    p.h(paramString2, "liveName");
    p.h(paramString3, "anchorName");
    ae.i(TAG, "liveStart liveId:" + paramLong + ", roomId:" + paramString1 + ", rotation:" + paramInt1 + ", liveName:" + paramString2 + ", createTime:" + paramInt2);
    if (!o.fB(PATH)) {
      o.aZI(PATH);
    }
    bvh localbvh = new bvh();
    localbvh.FKy = paramLong;
    localbvh.HhZ = paramString1;
    localbvh.rotation = paramInt1;
    localbvh.Gud = paramString2;
    localbvh.FZN = paramInt2;
    localbvh.Hia = paramString3;
    paramString1 = localbvh.toByteArray();
    o.C(PATH + FILE_NAME, paramString1);
    AppMethodBeat.o(215890);
  }
  
  public static bvh aoL()
  {
    AppMethodBeat.i(215892);
    bvh localbvh = new bvh();
    byte[] arrayOfByte = o.bb(PATH + FILE_NAME, 0, -1);
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
          locala = (com.tencent.mm.bw.a)localbvh;
        }
      }
      try
      {
        locala.parseFrom(arrayOfByte);
        if ((localbvh.FZN > 0) && (ch.aDd() - localbvh.FZN >= gTH))
        {
          ae.i(TAG, "liveAnchorInfo expirated, liveId:" + localbvh.FKy);
          localbvh.FKy = 0L;
          localbvh.HhZ = "";
          localbvh.rotation = -1;
          localbvh.Gud = "";
          localbvh.FZN = 0;
          localbvh.Hia = "";
          arrayOfByte = localbvh.toByteArray();
          o.C(PATH + FILE_NAME, arrayOfByte);
        }
        AppMethodBeat.o(215892);
        return localbvh;
        label191:
        i = 0;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
  
  public static void aoM()
  {
    AppMethodBeat.i(215893);
    ae.i(TAG, "liveAnchorInfo cleanCache");
    Object localObject = new bvh();
    ((bvh)localObject).FKy = 0L;
    ((bvh)localObject).HhZ = "";
    ((bvh)localObject).rotation = -1;
    ((bvh)localObject).Gud = "";
    ((bvh)localObject).FZN = 0;
    ((bvh)localObject).Hia = "";
    localObject = ((bvh)localObject).toByteArray();
    o.C(PATH + FILE_NAME, (byte[])localObject);
    AppMethodBeat.o(215893);
  }
  
  public static void rz(long paramLong)
  {
    AppMethodBeat.i(215891);
    ae.i(TAG, "liveFinish liveId:".concat(String.valueOf(paramLong)));
    Object localObject = new bvh();
    byte[] arrayOfByte = o.bb(PATH + FILE_NAME, 0, -1);
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
        if (((bvh)localObject).FKy == paramLong)
        {
          ((bvh)localObject).FKy = 0L;
          ((bvh)localObject).HhZ = "";
          ((bvh)localObject).rotation = -1;
          ((bvh)localObject).Gud = "";
          ((bvh)localObject).FZN = 0;
          ((bvh)localObject).Hia = "";
          localObject = ((bvh)localObject).toByteArray();
          o.C(PATH + FILE_NAME, (byte[])localObject);
        }
        AppMethodBeat.o(215891);
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
          ae.l("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.b.c.a
 * JD-Core Version:    0.7.0.1
 */