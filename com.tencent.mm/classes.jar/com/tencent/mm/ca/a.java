package com.tencent.mm.ca;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.e;
import com.tencent.mm.av.f;
import com.tencent.mm.av.l;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.ak.g, com.tencent.mm.api.t
{
  public static final a Gjl;
  public ConcurrentHashMap<String, cpa> vDn;
  
  static
  {
    AppMethodBeat.i(9329);
    Gjl = new a();
    AppMethodBeat.o(9329);
  }
  
  public a()
  {
    AppMethodBeat.i(9324);
    this.vDn = new ConcurrentHashMap();
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
        if ((paramString != null) && (paramString.hIN))
        {
          localObject1 = paramString.hIM;
          paramn = (cpa)this.vDn.remove(paramString.hIR);
          if ((localObject1 != null) && (paramn != null))
          {
            localObject1 = bv.L((String)localObject1, "msg");
            if (localObject1 == null)
            {
              ac.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
            }
            localObject2 = paramn.FBO;
            ((cou)localObject2).EBF = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
            ((cou)localObject2).AesKey = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
            ((cou)localObject2).MD5 = "";
            ac.i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", new Object[] { paramString.hIR });
            new b(paramn).doScene(com.tencent.mm.kernel.g.agi().hwg, new com.tencent.mm.ak.g()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
              {
                AppMethodBeat.i(9322);
                paramAnonymousn.setHasCallbackToQueue(true);
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                {
                  ac.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(paramn) });
                  AppMethodBeat.o(9322);
                  return;
                }
                ac.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(paramn) });
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
          localObject1 = (cpa)this.vDn.remove(paramn.fileName);
          if (paramn.hYO == null) {
            paramString = "";
          }
          while ((paramString != null) && (localObject1 != null))
          {
            localObject2 = bv.L(paramString, "msg");
            if (localObject2 == null)
            {
              ac.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
              paramString = paramn.hYO.aJK();
            }
            else
            {
              paramString = ((cpa)localObject1).FBP;
              paramString.AesKey = ((String)((Map)localObject2).get(".msg.videomsg.$aeskey"));
              paramString.EBF = ((String)((Map)localObject2).get(".msg.videomsg.$cdnvideourll"));
              localObject2 = paramn.hYO;
              paramString.MD5 = ((s)localObject2).dwi;
              paramString.FCC = "";
              paramString.FCD = ((s)localObject2).hpy;
              paramString.FCE = paramString.EBF;
              paramString.FCF = paramString.AesKey;
              com.tencent.mm.modelvideo.o.aJy();
              paramString.FCG = f.Ck(com.tencent.mm.modelvideo.t.DW(((s)localObject2).getFileName()));
              ac.i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", new Object[] { paramn.fileName });
              new b((cpa)localObject1).doScene(com.tencent.mm.kernel.g.agi().hwg, new com.tencent.mm.ak.g()
              {
                public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
                {
                  AppMethodBeat.i(9323);
                  paramAnonymousn.setHasCallbackToQueue(true);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                  {
                    ac.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(this.Gjm) });
                    AppMethodBeat.o(9323);
                    return;
                  }
                  ac.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(this.Gjm) });
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
      Object localObject2 = com.tencent.mm.av.o.aFx();
      String str = f.Ck(paramString1);
      localObject1 = new e();
      localObject2 = ((com.tencent.mm.av.g)localObject2).a("ImgInfo2", null, "origImgMD5=?", new String[] { String.valueOf(str) });
      if (((Cursor)localObject2).moveToFirst()) {
        ((e)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
    while (((e)localObject1).dcd > 0L)
    {
      localObject1 = bv.L(((e)localObject1).hGY, "msg");
      if (localObject1 == null)
      {
        ac.w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
        AppMethodBeat.o(9326);
        return;
        localObject1 = com.tencent.mm.av.o.aFx().c(Long.valueOf(paramLong));
      }
      else
      {
        paramString1 = new cpa();
        paramString1.ndI = 1;
        paramString1.Ebg = paramString4;
        paramString1.EmotionList = new LinkedList(bs.S(paramString3.split(",")));
        paramString3 = new cou();
        paramString3.FBF = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
        paramString3.FBG = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
        paramString3.FBH = "";
        paramString1.FBO = paramString3;
        this.vDn.put(paramString2, paramString1);
        AppMethodBeat.o(9326);
        return;
      }
    }
    ac.w("MicroMsg.MediaSecurityReport", "[recordImage] imgInfo is null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
    AppMethodBeat.o(9326);
  }
  
  public final void recordVideo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(9325);
    s locals = u.Ej(paramString1);
    if ((locals != null) && (locals.iaJ > 0))
    {
      Map localMap = bv.L(locals.aJK(), "msg");
      if (localMap == null)
      {
        ac.w("MicroMsg.MediaSecurityReport", "attrs == null! %s", new Object[] { paramString1 });
        AppMethodBeat.o(9325);
        return;
      }
      cpa localcpa = new cpa();
      localcpa.ndI = 2;
      localcpa.Ebg = paramString4;
      localcpa.EmotionList = new LinkedList(bs.S(paramString3.split(",")));
      paramString3 = new cpq();
      paramString3.FBH = locals.dwi;
      paramString3.FCH = "";
      paramString3.FCL = locals.hpy;
      com.tencent.mm.modelvideo.o.aJy();
      paramString3.FCK = f.Ck(com.tencent.mm.modelvideo.t.DW(paramString1));
      paramString3.FCI = ((String)localMap.get(".msg.videomsg.$cdnvideourl"));
      paramString3.FCJ = ((String)localMap.get(".msg.videomsg.$aeskey"));
      localcpa.FBP = paramString3;
      this.vDn.put(paramString2, localcpa);
      AppMethodBeat.o(9325);
      return;
    }
    ac.w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", new Object[] { paramString1 });
    AppMethodBeat.o(9325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ca.a
 * JD-Core Version:    0.7.0.1
 */