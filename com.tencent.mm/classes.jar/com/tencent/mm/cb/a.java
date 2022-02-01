package com.tencent.mm.cb;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.f;
import com.tencent.mm.aw.l;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.al.g, com.tencent.mm.api.t
{
  public static final a ELZ;
  public ConcurrentHashMap<String, cjt> utQ;
  
  static
  {
    AppMethodBeat.i(9329);
    ELZ = new a();
    AppMethodBeat.o(9329);
  }
  
  public a()
  {
    AppMethodBeat.i(9324);
    this.utQ = new ConcurrentHashMap();
    AppMethodBeat.o(9324);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
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
      if ((paramn instanceof l))
      {
        paramString = (l)paramn;
        if ((paramString != null) && (paramString.hik))
        {
          localObject1 = paramString.hij;
          paramn = (cjt)this.utQ.remove(paramString.hio);
          if ((localObject1 != null) && (paramn != null))
          {
            localObject1 = bw.K((String)localObject1, "msg");
            if (localObject1 == null)
            {
              ad.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
            }
            localObject2 = paramn.EeO;
            ((cjn)localObject2).Diz = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
            ((cjn)localObject2).AesKey = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
            ((cjn)localObject2).MD5 = "";
            ad.i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", new Object[] { paramString.hio });
            new b(paramn).doScene(com.tencent.mm.kernel.g.aeS().gVH, new com.tencent.mm.al.g()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
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
          localObject1 = (cjt)this.utQ.remove(paramn.fileName);
          if (paramn.hyn == null) {
            paramString = "";
          }
          while ((paramString != null) && (localObject1 != null))
          {
            localObject2 = bw.K(paramString, "msg");
            if (localObject2 == null)
            {
              ad.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
              paramString = paramn.hyn.aCT();
            }
            else
            {
              paramString = ((cjt)localObject1).EeP;
              paramString.AesKey = ((String)((Map)localObject2).get(".msg.videomsg.$aeskey"));
              paramString.Diz = ((String)((Map)localObject2).get(".msg.videomsg.$cdnvideourll"));
              localObject2 = paramn.hyn;
              paramString.MD5 = ((s)localObject2).dyw;
              paramString.EfC = "";
              paramString.EfD = ((s)localObject2).gOY;
              paramString.EfE = paramString.Diz;
              paramString.EfF = paramString.AesKey;
              com.tencent.mm.modelvideo.o.aCI();
              paramString.EfG = f.yf(com.tencent.mm.modelvideo.t.zR(((s)localObject2).getFileName()));
              ad.i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", new Object[] { paramn.fileName });
              new b((cjt)localObject1).doScene(com.tencent.mm.kernel.g.aeS().gVH, new com.tencent.mm.al.g()
              {
                public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
                {
                  AppMethodBeat.i(9323);
                  paramAnonymousn.setHasCallbackToQueue(true);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                  {
                    ad.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(this.EMa) });
                    AppMethodBeat.o(9323);
                    return;
                  }
                  ad.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(this.EMa) });
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
      Object localObject2 = com.tencent.mm.aw.o.ayF();
      String str = f.yf(paramString1);
      localObject1 = new e();
      localObject2 = ((com.tencent.mm.aw.g)localObject2).a("ImgInfo2", null, "origImgMD5=?", new String[] { String.valueOf(str) });
      if (((Cursor)localObject2).moveToFirst()) {
        ((e)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
    while (((e)localObject1).deI > 0L)
    {
      localObject1 = bw.K(((e)localObject1).hgv, "msg");
      if (localObject1 == null)
      {
        ad.w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
        AppMethodBeat.o(9326);
        return;
        localObject1 = com.tencent.mm.aw.o.ayF().b(Long.valueOf(paramLong));
      }
      else
      {
        paramString1 = new cjt();
        paramString1.mBH = 1;
        paramString1.CIE = paramString4;
        paramString1.EmotionList = new LinkedList(bt.S(paramString3.split(",")));
        paramString3 = new cjn();
        paramString3.EeF = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
        paramString3.EeG = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
        paramString3.EeH = "";
        paramString1.EeO = paramString3;
        this.utQ.put(paramString2, paramString1);
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
    s locals = u.Ae(paramString1);
    if ((locals != null) && (locals.hAi > 0))
    {
      Map localMap = bw.K(locals.aCT(), "msg");
      if (localMap == null)
      {
        ad.w("MicroMsg.MediaSecurityReport", "attrs == null! %s", new Object[] { paramString1 });
        AppMethodBeat.o(9325);
        return;
      }
      cjt localcjt = new cjt();
      localcjt.mBH = 2;
      localcjt.CIE = paramString4;
      localcjt.EmotionList = new LinkedList(bt.S(paramString3.split(",")));
      paramString3 = new ckj();
      paramString3.EeH = locals.dyw;
      paramString3.EfH = "";
      paramString3.EfL = locals.gOY;
      com.tencent.mm.modelvideo.o.aCI();
      paramString3.EfK = f.yf(com.tencent.mm.modelvideo.t.zR(paramString1));
      paramString3.EfI = ((String)localMap.get(".msg.videomsg.$cdnvideourl"));
      paramString3.EfJ = ((String)localMap.get(".msg.videomsg.$aeskey"));
      localcjt.EeP = paramString3;
      this.utQ.put(paramString2, localcjt);
      AppMethodBeat.o(9325);
      return;
    }
    ad.w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", new Object[] { paramString1 });
    AppMethodBeat.o(9325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cb.a
 * JD-Core Version:    0.7.0.1
 */