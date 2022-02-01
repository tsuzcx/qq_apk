package com.tencent.mm.bz;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.av.h;
import com.tencent.mm.av.i;
import com.tencent.mm.av.i.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements f, com.tencent.mm.api.t
{
  public static final a Ipg;
  public ConcurrentHashMap<String, cuz> wYT;
  
  static
  {
    AppMethodBeat.i(9329);
    Ipg = new a();
    AppMethodBeat.o(9329);
  }
  
  public a()
  {
    AppMethodBeat.i(9324);
    this.wYT = new ConcurrentHashMap();
    AppMethodBeat.o(9324);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
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
      if ((paramn instanceof com.tencent.mm.av.n))
      {
        paramString = (com.tencent.mm.av.n)paramn;
        if ((paramString != null) && (paramString.ieu))
        {
          localObject1 = paramString.iet;
          paramn = (cuz)this.wYT.remove(paramString.iey);
          if ((localObject1 != null) && (paramn != null))
          {
            localObject1 = bx.M((String)localObject1, "msg");
            if (localObject1 == null)
            {
              ae.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
            }
            localObject2 = paramn.HFD;
            ((cut)localObject2).GCa = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
            ((cut)localObject2).AesKey = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
            ((cut)localObject2).MD5 = "";
            ae.i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", new Object[] { paramString.iey });
            new b(paramn).doScene(com.tencent.mm.kernel.g.ajj().hRo, new f()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
              {
                AppMethodBeat.i(9322);
                paramAnonymousn.setHasCallbackToQueue(true);
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                {
                  ae.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(paramn) });
                  AppMethodBeat.o(9322);
                  return;
                }
                ae.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(paramn) });
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
          localObject1 = (cuz)this.wYT.remove(paramn.fileName);
          if (paramn.ive == null) {
            paramString = "";
          }
          while ((paramString != null) && (localObject1 != null))
          {
            localObject2 = bx.M(paramString, "msg");
            if (localObject2 == null)
            {
              ae.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
              paramString = paramn.ive.aNt();
            }
            else
            {
              paramString = ((cuz)localObject1).HFE;
              paramString.AesKey = ((String)((Map)localObject2).get(".msg.videomsg.$aeskey"));
              paramString.GCa = ((String)((Map)localObject2).get(".msg.videomsg.$cdnvideourll"));
              localObject2 = paramn.ive;
              paramString.MD5 = ((s)localObject2).dJw;
              paramString.HGr = "";
              paramString.HGs = ((s)localObject2).hKI;
              paramString.Hvf = paramString.GCa;
              paramString.Hvg = paramString.AesKey;
              o.aNh();
              paramString.HGt = h.FL(com.tencent.mm.modelvideo.t.HK(((s)localObject2).getFileName()));
              ae.i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", new Object[] { paramn.fileName });
              new b((cuz)localObject1).doScene(com.tencent.mm.kernel.g.ajj().hRo, new f()
              {
                public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
                {
                  AppMethodBeat.i(9323);
                  paramAnonymousn.setHasCallbackToQueue(true);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                  {
                    ae.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(this.Iph) });
                    AppMethodBeat.o(9323);
                    return;
                  }
                  ae.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(this.Iph) });
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
      Object localObject2 = com.tencent.mm.av.q.aIX();
      String str = h.FL(paramString1);
      localObject1 = new com.tencent.mm.av.g();
      localObject2 = ((i)localObject2).a(i.d.FW(""), null, "origImgMD5=?", new String[] { String.valueOf(str) });
      if (((Cursor)localObject2).moveToFirst()) {
        ((com.tencent.mm.av.g)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
    while (((com.tencent.mm.av.g)localObject1).doE > 0L)
    {
      localObject1 = bx.M(((com.tencent.mm.av.g)localObject1).icA, "msg");
      if (localObject1 == null)
      {
        ae.w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
        AppMethodBeat.o(9326);
        return;
        localObject1 = com.tencent.mm.av.q.aIX().c(Long.valueOf(paramLong));
      }
      else
      {
        paramString1 = new cuz();
        paramString1.nJA = 1;
        paramString1.FZl = paramString4;
        paramString1.EmotionList = new LinkedList(bu.U(paramString3.split(",")));
        paramString3 = new cut();
        paramString3.HFu = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
        paramString3.HFv = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
        paramString3.HFw = "";
        paramString1.HFD = paramString3;
        this.wYT.put(paramString2, paramString1);
        AppMethodBeat.o(9326);
        return;
      }
    }
    ae.w("MicroMsg.MediaSecurityReport", "[recordImage] imgInfo is null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
    AppMethodBeat.o(9326);
  }
  
  public final void recordVideo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(9325);
    s locals = u.Ia(paramString1);
    if ((locals != null) && (locals.iwZ > 0))
    {
      Map localMap = bx.M(locals.aNt(), "msg");
      if (localMap == null)
      {
        ae.w("MicroMsg.MediaSecurityReport", "attrs == null! %s", new Object[] { paramString1 });
        AppMethodBeat.o(9325);
        return;
      }
      cuz localcuz = new cuz();
      localcuz.nJA = 2;
      localcuz.FZl = paramString4;
      localcuz.EmotionList = new LinkedList(bu.U(paramString3.split(",")));
      paramString3 = new cvp();
      paramString3.HFw = locals.dJw;
      paramString3.HGu = "";
      paramString3.HGy = locals.hKI;
      o.aNh();
      paramString3.HGx = h.FL(com.tencent.mm.modelvideo.t.HK(paramString1));
      paramString3.HGv = ((String)localMap.get(".msg.videomsg.$cdnvideourl"));
      paramString3.HGw = ((String)localMap.get(".msg.videomsg.$aeskey"));
      localcuz.HFE = paramString3;
      this.wYT.put(paramString2, localcuz);
      AppMethodBeat.o(9325);
      return;
    }
    ae.w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", new Object[] { paramString1 });
    AppMethodBeat.o(9325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bz.a
 * JD-Core Version:    0.7.0.1
 */