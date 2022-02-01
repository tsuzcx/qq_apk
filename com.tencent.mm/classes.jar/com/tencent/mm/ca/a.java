package com.tencent.mm.ca;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.aw.h;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.i.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements f, com.tencent.mm.api.t
{
  public static final a HUY;
  public ConcurrentHashMap<String, cuf> wJi;
  
  static
  {
    AppMethodBeat.i(9329);
    HUY = new a();
    AppMethodBeat.o(9329);
  }
  
  public a()
  {
    AppMethodBeat.i(9324);
    this.wJi = new ConcurrentHashMap();
    AppMethodBeat.o(9324);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(9327);
    if ((paramn.getType() != 110) && (paramn.getType() != 149))
    {
      AppMethodBeat.o(9327);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      Object localObject2;
      if ((paramn instanceof com.tencent.mm.aw.n))
      {
        paramString = (com.tencent.mm.aw.n)paramn;
        if ((paramString != null) && (paramString.ibB))
        {
          localObject1 = paramString.ibA;
          paramn = (cuf)this.wJi.remove(paramString.ibF);
          if ((localObject1 != null) && (paramn != null))
          {
            localObject1 = bw.M((String)localObject1, "msg");
            if (localObject1 == null)
            {
              ad.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
            }
            localObject2 = paramn.Hmd;
            ((ctz)localObject2).Gjr = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
            ((ctz)localObject2).AesKey = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
            ((ctz)localObject2).MD5 = "";
            ad.i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", new Object[] { paramString.ibF });
            new b(paramn).doScene(com.tencent.mm.kernel.g.aiU().hOv, new f()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
              {
                AppMethodBeat.i(9322);
                paramAnonymousn.setHasCallbackToQueue(true);
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                {
                  ad.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(paramn) });
                  AppMethodBeat.o(9322);
                  return;
                }
                ad.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(paramn) });
                AppMethodBeat.o(9322);
              }
            });
          }
        }
        AppMethodBeat.o(9327);
        return;
      }
      if ((paramn instanceof com.tencent.mm.modelvideo.g))
      {
        paramn = (com.tencent.mm.modelvideo.g)paramn;
        if (paramn != null)
        {
          localObject1 = (cuf)this.wJi.remove(paramn.fileName);
          if (paramn.isk == null) {
            paramString = "";
          }
          while ((paramString != null) && (localObject1 != null))
          {
            localObject2 = bw.M(paramString, "msg");
            if (localObject2 == null)
            {
              ad.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
              paramString = paramn.isk.aMV();
            }
            else
            {
              paramString = ((cuf)localObject1).Hme;
              paramString.AesKey = ((String)((Map)localObject2).get(".msg.videomsg.$aeskey"));
              paramString.Gjr = ((String)((Map)localObject2).get(".msg.videomsg.$cdnvideourll"));
              localObject2 = paramn.isk;
              paramString.MD5 = ((s)localObject2).dIs;
              paramString.HmR = "";
              paramString.HmS = ((s)localObject2).hHQ;
              paramString.HbF = paramString.Gjr;
              paramString.HbG = paramString.AesKey;
              o.aMJ();
              paramString.HmT = h.Fj(com.tencent.mm.modelvideo.t.Hi(((s)localObject2).getFileName()));
              ad.i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", new Object[] { paramn.fileName });
              new b((cuf)localObject1).doScene(com.tencent.mm.kernel.g.aiU().hOv, new f()
              {
                public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
                {
                  AppMethodBeat.i(9323);
                  paramAnonymousn.setHasCallbackToQueue(true);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                  {
                    ad.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(this.HUZ) });
                    AppMethodBeat.o(9323);
                    return;
                  }
                  ad.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(this.HUZ) });
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
      Object localObject2 = com.tencent.mm.aw.q.aIF();
      String str = h.Fj(paramString1);
      localObject1 = new com.tencent.mm.aw.g();
      localObject2 = ((i)localObject2).a(i.d.Fu(""), null, "origImgMD5=?", new String[] { String.valueOf(str) });
      if (((Cursor)localObject2).moveToFirst()) {
        ((com.tencent.mm.aw.g)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
    while (((com.tencent.mm.aw.g)localObject1).dnz > 0L)
    {
      localObject1 = bw.M(((com.tencent.mm.aw.g)localObject1).hZI, "msg");
      if (localObject1 == null)
      {
        ad.w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
        AppMethodBeat.o(9326);
        return;
        localObject1 = com.tencent.mm.aw.q.aIF().c(Long.valueOf(paramLong));
      }
      else
      {
        paramString1 = new cuf();
        paramString1.nEf = 1;
        paramString1.FGP = paramString4;
        paramString1.EmotionList = new LinkedList(bt.U(paramString3.split(",")));
        paramString3 = new ctz();
        paramString3.HlU = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
        paramString3.HlV = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
        paramString3.HlW = "";
        paramString1.Hmd = paramString3;
        this.wJi.put(paramString2, paramString1);
        AppMethodBeat.o(9326);
        return;
      }
    }
    ad.w("MicroMsg.MediaSecurityReport", "[recordImage] imgInfo is null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
    AppMethodBeat.o(9326);
  }
  
  public final void recordVideo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(9325);
    s locals = u.Hy(paramString1);
    if ((locals != null) && (locals.iuf > 0))
    {
      Map localMap = bw.M(locals.aMV(), "msg");
      if (localMap == null)
      {
        ad.w("MicroMsg.MediaSecurityReport", "attrs == null! %s", new Object[] { paramString1 });
        AppMethodBeat.o(9325);
        return;
      }
      cuf localcuf = new cuf();
      localcuf.nEf = 2;
      localcuf.FGP = paramString4;
      localcuf.EmotionList = new LinkedList(bt.U(paramString3.split(",")));
      paramString3 = new cuv();
      paramString3.HlW = locals.dIs;
      paramString3.HmU = "";
      paramString3.HmY = locals.hHQ;
      o.aMJ();
      paramString3.HmX = h.Fj(com.tencent.mm.modelvideo.t.Hi(paramString1));
      paramString3.HmV = ((String)localMap.get(".msg.videomsg.$cdnvideourl"));
      paramString3.HmW = ((String)localMap.get(".msg.videomsg.$aeskey"));
      localcuf.Hme = paramString3;
      this.wJi.put(paramString2, localcuf);
      AppMethodBeat.o(9325);
      return;
    }
    ad.w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", new Object[] { paramString1 });
    AppMethodBeat.o(9325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ca.a
 * JD-Core Version:    0.7.0.1
 */