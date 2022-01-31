package com.tencent.mm.bz;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.e;
import com.tencent.mm.at.l;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.ai.f, com.tencent.mm.api.o
{
  public static final a yix;
  public ConcurrentHashMap<String, bug> yiy;
  
  static
  {
    AppMethodBeat.i(116352);
    yix = new a();
    AppMethodBeat.o(116352);
  }
  
  public a()
  {
    AppMethodBeat.i(116347);
    this.yiy = new ConcurrentHashMap();
    AppMethodBeat.o(116347);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final m paramm)
  {
    AppMethodBeat.i(116350);
    if ((paramm.getType() != 110) && (paramm.getType() != 149))
    {
      AppMethodBeat.o(116350);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      Object localObject2;
      if ((paramm instanceof l))
      {
        paramString = (l)paramm;
        if ((paramString != null) && (paramString.fFM))
        {
          localObject1 = paramString.fFL;
          paramm = (bug)this.yiy.remove(paramString.fFQ);
          if ((localObject1 != null) && (paramm != null))
          {
            localObject1 = br.F((String)localObject1, "msg");
            if (localObject1 == null)
            {
              ab.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(116350);
              return;
            }
            localObject2 = paramm.xHz;
            ((bub)localObject2).wUW = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
            ((bub)localObject2).AesKey = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
            ((bub)localObject2).wQr = "";
            ab.i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", new Object[] { paramString.fFQ });
            new b(paramm).doScene(com.tencent.mm.kernel.g.Rc().ftA, new com.tencent.mm.ai.f()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
              {
                AppMethodBeat.i(116345);
                paramAnonymousm.setHasCallbackToQueue(true);
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                {
                  ab.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(paramm) });
                  AppMethodBeat.o(116345);
                  return;
                }
                ab.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(paramm) });
                AppMethodBeat.o(116345);
              }
            });
          }
        }
        AppMethodBeat.o(116350);
        return;
      }
      if ((paramm instanceof com.tencent.mm.modelvideo.g))
      {
        paramm = (com.tencent.mm.modelvideo.g)paramm;
        if (paramm != null)
        {
          localObject1 = (bug)this.yiy.remove(paramm.fileName);
          if (paramm.fVD == null) {
            paramString = "";
          }
          while ((paramString != null) && (localObject1 != null))
          {
            localObject2 = br.F(paramString, "msg");
            if (localObject2 == null)
            {
              ab.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(116350);
              return;
              paramString = paramm.fVD.alP();
            }
            else
            {
              paramString = ((bug)localObject1).xHA;
              paramString.AesKey = ((String)((Map)localObject2).get(".msg.videomsg.$aeskey"));
              paramString.wUW = ((String)((Map)localObject2).get(".msg.videomsg.$cdnvideourll"));
              localObject2 = paramm.fVD;
              paramString.wQr = ((s)localObject2).cHH;
              paramString.xIn = "";
              paramString.xIo = ((s)localObject2).fXx;
              paramString.xIp = paramString.wUW;
              paramString.xIq = paramString.AesKey;
              com.tencent.mm.modelvideo.o.alE();
              paramString.xIr = com.tencent.mm.at.f.tc(t.vg(((s)localObject2).getFileName()));
              ab.i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", new Object[] { paramm.fileName });
              new b((bug)localObject1).doScene(com.tencent.mm.kernel.g.Rc().ftA, new a.2(this, (bug)localObject1));
            }
          }
        }
      }
    }
    AppMethodBeat.o(116350);
  }
  
  public final void recordImage(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(116349);
    Object localObject1;
    if (paramLong <= 0L)
    {
      Object localObject2 = com.tencent.mm.at.o.ahC();
      String str = com.tencent.mm.at.f.tc(paramString1);
      localObject1 = new e();
      localObject2 = ((com.tencent.mm.at.g)localObject2).a("ImgInfo2", null, "origImgMD5=?", new String[] { String.valueOf(str) });
      if (((Cursor)localObject2).moveToFirst()) {
        ((e)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
    while (((e)localObject1).fDL > 0L)
    {
      localObject1 = br.F(((e)localObject1).fDX, "msg");
      if (localObject1 == null)
      {
        ab.w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
        AppMethodBeat.o(116349);
        return;
        localObject1 = com.tencent.mm.at.o.ahC().b(Long.valueOf(paramLong));
      }
      else
      {
        paramString1 = new bug();
        paramString1.jKs = 1;
        paramString1.wxW = paramString4;
        paramString1.EmotionList = new LinkedList(bo.P(paramString3.split(",")));
        paramString3 = new bub();
        paramString3.xHr = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
        paramString3.xHs = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
        paramString3.xHt = "";
        paramString1.xHz = paramString3;
        this.yiy.put(paramString2, paramString1);
        AppMethodBeat.o(116349);
        return;
      }
    }
    ab.w("MicroMsg.MediaSecurityReport", "[recordImage] imgInfo is null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
    AppMethodBeat.o(116349);
  }
  
  public final void recordVideo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(116348);
    s locals = u.vr(paramString1);
    if ((locals != null) && (locals.fXy > 0))
    {
      Map localMap = br.F(locals.alP(), "msg");
      if (localMap == null)
      {
        ab.w("MicroMsg.MediaSecurityReport", "attrs == null! %s", new Object[] { paramString1 });
        AppMethodBeat.o(116348);
        return;
      }
      bug localbug = new bug();
      localbug.jKs = 2;
      localbug.wxW = paramString4;
      localbug.EmotionList = new LinkedList(bo.P(paramString3.split(",")));
      paramString3 = new bus();
      paramString3.xHt = locals.cHH;
      paramString3.xIs = "";
      paramString3.xIw = locals.fXx;
      com.tencent.mm.modelvideo.o.alE();
      paramString3.xIv = com.tencent.mm.at.f.tc(t.vg(paramString1));
      paramString3.xIt = ((String)localMap.get(".msg.videomsg.$cdnvideourl"));
      paramString3.xIu = ((String)localMap.get(".msg.videomsg.$aeskey"));
      localbug.xHA = paramString3;
      this.yiy.put(paramString2, localbug);
      AppMethodBeat.o(116348);
      return;
    }
    ab.w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", new Object[] { paramString1 });
    AppMethodBeat.o(116348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.a
 * JD-Core Version:    0.7.0.1
 */