package com.tencent.mm.cg;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.i.d;
import com.tencent.mm.ay.n;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.protocal.protobuf.dxe;
import com.tencent.mm.protocal.protobuf.dxk;
import com.tencent.mm.protocal.protobuf.dyc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.an.i, com.tencent.mm.api.w
{
  public static final a UQg;
  public ConcurrentHashMap<String, dxk> zKV;
  
  static
  {
    AppMethodBeat.i(9329);
    UQg = new a();
    AppMethodBeat.o(9329);
  }
  
  public a()
  {
    AppMethodBeat.i(9324);
    this.zKV = new ConcurrentHashMap();
    AppMethodBeat.o(9324);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(9327);
    if ((paramq.getType() != 110) && (paramq.getType() != 149))
    {
      AppMethodBeat.o(9327);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      Object localObject2;
      if ((paramq instanceof n))
      {
        paramString = (n)paramq;
        if ((paramString != null) && (paramString.lPL))
        {
          localObject1 = paramString.lPK;
          paramq = (dxk)this.zKV.remove(paramString.lPO);
          if ((localObject1 != null) && (paramq != null))
          {
            localObject1 = XmlParser.parseXml((String)localObject1, "msg", null);
            if (localObject1 == null)
            {
              Log.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
            }
            localObject2 = paramq.UcU;
            ((dxe)localObject2).SAx = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
            ((dxe)localObject2).AesKey = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
            ((dxe)localObject2).MD5 = "";
            Log.i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", new Object[] { paramString.lPO });
            new b(paramq).doScene(com.tencent.mm.kernel.h.aGY().lCD, new com.tencent.mm.an.i()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
              {
                AppMethodBeat.i(9322);
                paramAnonymousq.setHasCallbackToQueue(true);
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                {
                  Log.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(paramq) });
                  AppMethodBeat.o(9322);
                  return;
                }
                Log.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(paramq) });
                AppMethodBeat.o(9322);
              }
            });
          }
        }
        AppMethodBeat.o(9327);
        return;
      }
      if ((paramq instanceof k))
      {
        paramq = (k)paramq;
        if (paramq != null)
        {
          localObject1 = (dxk)this.zKV.remove(paramq.fileName);
          if (paramq.mfR == null) {
            paramString = "";
          }
          while ((paramString != null) && (localObject1 != null))
          {
            localObject2 = XmlParser.parseXml(paramString, "msg", null);
            if (localObject2 == null)
            {
              Log.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
              paramString = paramq.mfR.bqO();
            }
            else
            {
              paramString = ((dxk)localObject1).UcV;
              paramString.AesKey = ((String)((Map)localObject2).get(".msg.videomsg.$aeskey"));
              paramString.SAx = ((String)((Map)localObject2).get(".msg.videomsg.$cdnvideourll"));
              localObject2 = paramq.mfR;
              paramString.MD5 = ((com.tencent.mm.modelvideo.w)localObject2).fVg;
              paramString.UdI = "";
              paramString.UdJ = ((com.tencent.mm.modelvideo.w)localObject2).lvw;
              paramString.TPM = paramString.SAx;
              paramString.TPN = paramString.AesKey;
              s.bqB();
              paramString.UdK = com.tencent.mm.ay.h.VT(x.XU(((com.tencent.mm.modelvideo.w)localObject2).getFileName()));
              Log.i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", new Object[] { paramq.fileName });
              new b((dxk)localObject1).doScene(com.tencent.mm.kernel.h.aGY().lCD, new com.tencent.mm.an.i()
              {
                public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
                {
                  AppMethodBeat.i(9323);
                  paramAnonymousq.setHasCallbackToQueue(true);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                  {
                    Log.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(this.UQh) });
                    AppMethodBeat.o(9323);
                    return;
                  }
                  Log.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(this.UQh) });
                  AppMethodBeat.o(9323);
                }
              });
            }
          }
        }
      }
    }
    AppMethodBeat.o(9327);
  }
  
  public final void recordImage(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(9326);
    Object localObject1;
    if (paramLong <= 0L)
    {
      Object localObject2 = com.tencent.mm.ay.q.bmh();
      String str = com.tencent.mm.ay.h.VT(paramString1);
      localObject1 = new g();
      localObject2 = ((com.tencent.mm.ay.i)localObject2).a(i.d.Wf(""), null, "origImgMD5=?", new String[] { String.valueOf(str) });
      if (((Cursor)localObject2).moveToFirst()) {
        ((g)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
    while (((g)localObject1).localId > 0L)
    {
      localObject1 = XmlParser.parseXml(((g)localObject1).lNS, "msg", null);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
        AppMethodBeat.o(9326);
        return;
        localObject1 = com.tencent.mm.ay.q.bmh().b(Long.valueOf(paramLong));
      }
      else
      {
        paramString1 = new dxk();
        paramString1.rWu = 1;
        paramString1.RUd = paramString4;
        paramString1.Tek = new LinkedList(Util.stringsToList(paramString3.split(",")));
        paramString3 = new dxe();
        paramString3.UcL = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
        paramString3.UcM = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
        paramString3.UcN = "";
        paramString1.UcU = paramString3;
        this.zKV.put(paramString2, paramString1);
        AppMethodBeat.o(9326);
        return;
      }
    }
    Log.w("MicroMsg.MediaSecurityReport", "[recordImage] imgInfo is null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
    AppMethodBeat.o(9326);
  }
  
  public final void recordVideo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(9325);
    com.tencent.mm.modelvideo.w localw = y.Yk(paramString1);
    if ((localw != null) && (localw.mhR > 0))
    {
      Map localMap = XmlParser.parseXml(localw.bqO(), "msg", null);
      if (localMap == null)
      {
        Log.w("MicroMsg.MediaSecurityReport", "attrs == null! %s", new Object[] { paramString1 });
        AppMethodBeat.o(9325);
        return;
      }
      dxk localdxk = new dxk();
      localdxk.rWu = 2;
      localdxk.RUd = paramString4;
      localdxk.Tek = new LinkedList(Util.stringsToList(paramString3.split(",")));
      paramString3 = new dyc();
      paramString3.UcN = localw.fVg;
      paramString3.UdL = "";
      paramString3.UdP = localw.lvw;
      s.bqB();
      paramString3.UdO = com.tencent.mm.ay.h.VT(x.XU(paramString1));
      paramString3.UdM = ((String)localMap.get(".msg.videomsg.$cdnvideourl"));
      paramString3.UdN = ((String)localMap.get(".msg.videomsg.$aeskey"));
      localdxk.UcV = paramString3;
      this.zKV.put(paramString2, localdxk);
      AppMethodBeat.o(9325);
      return;
    }
    Log.w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", new Object[] { paramString1 });
    AppMethodBeat.o(9325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cg.a
 * JD-Core Version:    0.7.0.1
 */