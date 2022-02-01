package com.tencent.mm.live.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/storage/LiveAnchorStorage;", "", "()V", "EXPIRATION_TIME", "", "FILE_NAME", "", "PATH", "TAG", "cleanCache", "", "getLiveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "hasLiveAnchorInfo", "", "liveFinish", "liveId", "", "liveStart", "roomId", "rotation", "liveName", "createTimeS", "anchorName", "plugin-logic_release"})
public final class a
{
  private static final String FILE_NAME = "anchor.proto";
  private static final String PATH;
  private static final String TAG = "MicroMsg.LiveAnchorStorage";
  private static final int gxo = 86400;
  public static final a gxp;
  
  static
  {
    AppMethodBeat.i(189988);
    gxp = new a();
    TAG = "MicroMsg.LiveAnchorStorage";
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    PATH = locale.getAccPath() + "live/";
    FILE_NAME = "anchor.proto";
    gxo = 86400;
    AppMethodBeat.o(189988);
  }
  
  public static void a(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(189984);
    k.h(paramString1, "roomId");
    k.h(paramString2, "liveName");
    k.h(paramString3, "anchorName");
    ac.i(TAG, "liveStart liveId:" + paramLong + ", roomId:" + paramString1 + ", rotation:" + paramInt1 + ", liveName:" + paramString2 + ", createTime:" + paramInt2);
    if (!i.eA(PATH)) {
      i.aSh(PATH);
    }
    bqa localbqa = new bqa();
    localbqa.DMV = paramLong;
    localbqa.FeV = paramString1;
    localbqa.rotation = paramInt1;
    localbqa.Eud = paramString2;
    localbqa.EbF = paramInt2;
    localbqa.FeW = paramString3;
    paramString1 = localbqa.toByteArray();
    i.B(PATH + FILE_NAME, paramString1);
    AppMethodBeat.o(189984);
  }
  
  public static bqa alJ()
  {
    AppMethodBeat.i(189986);
    bqa localbqa = new bqa();
    byte[] arrayOfByte = i.aU(PATH + FILE_NAME, 0, -1);
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
          locala = (com.tencent.mm.bw.a)localbqa;
        }
      }
      try
      {
        locala.parseFrom(arrayOfByte);
        if ((localbqa.EbF > 0) && (ce.azK() - localbqa.EbF >= gxo))
        {
          ac.i(TAG, "liveAnchorInfo expirated, liveId:" + localbqa.DMV);
          localbqa.DMV = 0L;
          localbqa.FeV = "";
          localbqa.rotation = -1;
          localbqa.Eud = "";
          localbqa.EbF = 0;
          localbqa.FeW = "";
          arrayOfByte = localbqa.toByteArray();
          i.B(PATH + FILE_NAME, arrayOfByte);
        }
        AppMethodBeat.o(189986);
        return localbqa;
        label191:
        i = 0;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
  
  public static void alK()
  {
    AppMethodBeat.i(189987);
    ac.i(TAG, "liveAnchorInfo cleanCache");
    Object localObject = new bqa();
    ((bqa)localObject).DMV = 0L;
    ((bqa)localObject).FeV = "";
    ((bqa)localObject).rotation = -1;
    ((bqa)localObject).Eud = "";
    ((bqa)localObject).EbF = 0;
    ((bqa)localObject).FeW = "";
    localObject = ((bqa)localObject).toByteArray();
    i.B(PATH + FILE_NAME, (byte[])localObject);
    AppMethodBeat.o(189987);
  }
  
  public static void pl(long paramLong)
  {
    AppMethodBeat.i(189985);
    ac.i(TAG, "liveFinish liveId:".concat(String.valueOf(paramLong)));
    Object localObject = new bqa();
    byte[] arrayOfByte = i.aU(PATH + FILE_NAME, 0, -1);
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
        if (((bqa)localObject).DMV == paramLong)
        {
          ((bqa)localObject).DMV = 0L;
          ((bqa)localObject).FeV = "";
          ((bqa)localObject).rotation = -1;
          ((bqa)localObject).Eud = "";
          ((bqa)localObject).EbF = 0;
          ((bqa)localObject).FeW = "";
          localObject = ((bqa)localObject).toByteArray();
          i.B(PATH + FILE_NAME, (byte[])localObject);
        }
        AppMethodBeat.o(189985);
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
          ac.l("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.c.a
 * JD-Core Version:    0.7.0.1
 */