package com.tencent.mm.bz;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.w;
import com.tencent.mm.av.h;
import com.tencent.mm.av.i.d;
import com.tencent.mm.av.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.dnm;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.ak.i, w
{
  public static final a NCE;
  public ConcurrentHashMap<String, dns> uUF;
  
  static
  {
    AppMethodBeat.i(9329);
    NCE = new a();
    AppMethodBeat.o(9329);
  }
  
  public a()
  {
    AppMethodBeat.i(9324);
    this.uUF = new ConcurrentHashMap();
    AppMethodBeat.o(9324);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
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
        if ((paramString != null) && (paramString.iZq))
        {
          localObject1 = paramString.iZp;
          paramq = (dns)this.uUF.remove(paramString.iZt);
          if ((localObject1 != null) && (paramq != null))
          {
            localObject1 = XmlParser.parseXml((String)localObject1, "msg", null);
            if (localObject1 == null)
            {
              Log.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
            }
            localObject2 = paramq.MQN;
            ((dnm)localObject2).LxW = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
            ((dnm)localObject2).AesKey = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
            ((dnm)localObject2).MD5 = "";
            Log.i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", new Object[] { paramString.iZt });
            new b(paramq).doScene(com.tencent.mm.kernel.g.azz().iMw, new com.tencent.mm.ak.i()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
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
      if ((paramq instanceof com.tencent.mm.modelvideo.g))
      {
        paramq = (com.tencent.mm.modelvideo.g)paramq;
        if (paramq != null)
        {
          localObject1 = (dns)this.uUF.remove(paramq.fileName);
          if (paramq.jqq == null) {
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
              paramString = paramq.jqq.bhv();
            }
            else
            {
              paramString = ((dns)localObject1).MQO;
              paramString.AesKey = ((String)((Map)localObject2).get(".msg.videomsg.$aeskey"));
              paramString.LxW = ((String)((Map)localObject2).get(".msg.videomsg.$cdnvideourll"));
              localObject2 = paramq.jqq;
              paramString.MD5 = ((s)localObject2).ebj;
              paramString.MRB = "";
              paramString.MRC = ((s)localObject2).iFw;
              paramString.MEd = paramString.LxW;
              paramString.MEe = paramString.AesKey;
              o.bhj();
              paramString.MRD = h.Ow(com.tencent.mm.modelvideo.t.Qx(((s)localObject2).getFileName()));
              Log.i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", new Object[] { paramq.fileName });
              new b((dns)localObject1).doScene(com.tencent.mm.kernel.g.azz().iMw, new com.tencent.mm.ak.i()
              {
                public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
                {
                  AppMethodBeat.i(9323);
                  paramAnonymousq.setHasCallbackToQueue(true);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                  {
                    Log.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(this.NCF) });
                    AppMethodBeat.o(9323);
                    return;
                  }
                  Log.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(this.NCF) });
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
      Object localObject2 = com.tencent.mm.av.q.bcR();
      String str = h.Ow(paramString1);
      localObject1 = new com.tencent.mm.av.g();
      localObject2 = ((com.tencent.mm.av.i)localObject2).a(i.d.OH(""), null, "origImgMD5=?", new String[] { String.valueOf(str) });
      if (((Cursor)localObject2).moveToFirst()) {
        ((com.tencent.mm.av.g)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
    while (((com.tencent.mm.av.g)localObject1).localId > 0L)
    {
      localObject1 = XmlParser.parseXml(((com.tencent.mm.av.g)localObject1).iXy, "msg", null);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
        AppMethodBeat.o(9326);
        return;
        localObject1 = com.tencent.mm.av.q.bcR().c(Long.valueOf(paramLong));
      }
      else
      {
        paramString1 = new dns();
        paramString1.oUv = 1;
        paramString1.KTg = paramString4;
        paramString1.EmotionList = new LinkedList(Util.stringsToList(paramString3.split(",")));
        paramString3 = new dnm();
        paramString3.MQE = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
        paramString3.MQF = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
        paramString3.MQG = "";
        paramString1.MQN = paramString3;
        this.uUF.put(paramString2, paramString1);
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
    s locals = u.QN(paramString1);
    if ((locals != null) && (locals.jso > 0))
    {
      Map localMap = XmlParser.parseXml(locals.bhv(), "msg", null);
      if (localMap == null)
      {
        Log.w("MicroMsg.MediaSecurityReport", "attrs == null! %s", new Object[] { paramString1 });
        AppMethodBeat.o(9325);
        return;
      }
      dns localdns = new dns();
      localdns.oUv = 2;
      localdns.KTg = paramString4;
      localdns.EmotionList = new LinkedList(Util.stringsToList(paramString3.split(",")));
      paramString3 = new doi();
      paramString3.MQG = locals.ebj;
      paramString3.MRE = "";
      paramString3.MRI = locals.iFw;
      o.bhj();
      paramString3.MRH = h.Ow(com.tencent.mm.modelvideo.t.Qx(paramString1));
      paramString3.MRF = ((String)localMap.get(".msg.videomsg.$cdnvideourl"));
      paramString3.MRG = ((String)localMap.get(".msg.videomsg.$aeskey"));
      localdns.MQO = paramString3;
      this.uUF.put(paramString2, localdns);
      AppMethodBeat.o(9325);
      return;
    }
    Log.w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", new Object[] { paramString1 });
    AppMethodBeat.o(9325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.a
 * JD-Core Version:    0.7.0.1
 */