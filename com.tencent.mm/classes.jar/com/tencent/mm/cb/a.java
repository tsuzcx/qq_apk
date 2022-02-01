package com.tencent.mm.cb;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.api.x;
import com.tencent.mm.modelimage.i;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.j.d;
import com.tencent.mm.modelimage.o;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.protocal.protobuf.eqi;
import com.tencent.mm.protocal.protobuf.eqo;
import com.tencent.mm.protocal.protobuf.erg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.am.h, x
{
  public static final a aclp;
  public ConcurrentHashMap<String, eqo> EVH;
  
  static
  {
    AppMethodBeat.i(9329);
    aclp = new a();
    AppMethodBeat.o(9329);
  }
  
  public a()
  {
    AppMethodBeat.i(9324);
    this.EVH = new ConcurrentHashMap();
    AppMethodBeat.o(9324);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(9327);
    if ((paramp.getType() != 110) && (paramp.getType() != 149))
    {
      AppMethodBeat.o(9327);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      Object localObject2;
      if ((paramp instanceof o))
      {
        paramString = (o)paramp;
        if ((paramString != null) && (paramString.oIu))
        {
          localObject1 = paramString.oIt;
          paramp = (eqo)this.EVH.remove(paramString.oIx);
          if ((localObject1 != null) && (paramp != null))
          {
            localObject1 = XmlParser.parseXml((String)localObject1, "msg", null);
            if (localObject1 == null)
            {
              Log.w("MicroMsg.MediaSecurityReport", "attrs == null!");
              AppMethodBeat.o(9327);
              return;
            }
            localObject2 = paramp.abuo;
            ((eqi)localObject2).ZBp = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
            ((eqi)localObject2).AesKey = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
            ((eqi)localObject2).MD5 = "";
            Log.i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", new Object[] { paramString.oIx });
            new b(paramp).doScene(com.tencent.mm.kernel.h.aZW().oun, new com.tencent.mm.am.h()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
              {
                AppMethodBeat.i(9322);
                paramAnonymousp.setHasCallbackToQueue(true);
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                {
                  Log.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(paramp) });
                  AppMethodBeat.o(9322);
                  return;
                }
                Log.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(paramp) });
                AppMethodBeat.o(9322);
              }
            });
          }
        }
        AppMethodBeat.o(9327);
        return;
      }
      if ((paramp instanceof k))
      {
        paramp = (k)paramp;
        if (paramp != null)
        {
          localObject1 = (eqo)this.EVH.remove(paramp.fileName);
          if (paramp.oYN == null) {
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
              paramString = paramp.oYN.bOu();
            }
            else
            {
              paramString = ((eqo)localObject1).abup;
              paramString.AesKey = ((String)((Map)localObject2).get(".msg.videomsg.$aeskey"));
              paramString.ZBp = ((String)((Map)localObject2).get(".msg.videomsg.$cdnvideourll"));
              localObject2 = paramp.oYN;
              paramString.MD5 = ((z)localObject2).ibd;
              paramString.abuW = "";
              paramString.abuX = ((z)localObject2).omT;
              paramString.abgi = paramString.ZBp;
              paramString.abgj = paramString.AesKey;
              v.bOh();
              paramString.abuY = i.NV(aa.PY(((z)localObject2).getFileName()));
              Log.i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", new Object[] { paramp.fileName });
              new b((eqo)localObject1).doScene(com.tencent.mm.kernel.h.aZW().oun, new com.tencent.mm.am.h()
              {
                public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
                {
                  AppMethodBeat.i(9323);
                  paramAnonymousp.setHasCallbackToQueue(true);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
                  {
                    Log.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), a.a(this.aclq) });
                    AppMethodBeat.o(9323);
                    return;
                  }
                  Log.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(this.aclq) });
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
      Object localObject2 = r.bKa();
      String str = i.NV(paramString1);
      localObject1 = new com.tencent.mm.modelimage.h();
      localObject2 = ((j)localObject2).a(j.d.Og(""), null, "origImgMD5=?", new String[] { String.valueOf(str) });
      if (((Cursor)localObject2).moveToFirst()) {
        ((com.tencent.mm.modelimage.h)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
    while ((localObject1 != null) && (((com.tencent.mm.modelimage.h)localObject1).localId > 0L))
    {
      localObject1 = XmlParser.parseXml(((com.tencent.mm.modelimage.h)localObject1).oGC, "msg", null);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", new Object[] { paramString1, Long.valueOf(paramLong) });
        AppMethodBeat.o(9326);
        return;
        localObject1 = r.bKa().b(Long.valueOf(paramLong));
      }
      else
      {
        paramString1 = new eqo();
        paramString1.vhJ = 1;
        paramString1.YRE = paramString4;
        paramString1.Zvf = new LinkedList(Util.stringsToList(paramString3.split(",")));
        paramString3 = new eqi();
        paramString3.abuf = ((String)((Map)localObject1).get(".msg.img.$cdnmidimgurl"));
        paramString3.abug = ((String)((Map)localObject1).get(".msg.img.$aeskey"));
        paramString3.abuh = "";
        paramString1.abuo = paramString3;
        this.EVH.put(paramString2, paramString1);
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
    z localz = ab.Qo(paramString1);
    if ((localz != null) && (localz.pbc > 0))
    {
      Map localMap = XmlParser.parseXml(localz.bOu(), "msg", null);
      if (localMap == null)
      {
        Log.w("MicroMsg.MediaSecurityReport", "attrs == null! %s", new Object[] { paramString1 });
        AppMethodBeat.o(9325);
        return;
      }
      eqo localeqo = new eqo();
      localeqo.vhJ = 2;
      localeqo.YRE = paramString4;
      localeqo.Zvf = new LinkedList(Util.stringsToList(paramString3.split(",")));
      paramString3 = new erg();
      paramString3.abuh = localz.ibd;
      paramString3.abuZ = "";
      paramString3.abvd = localz.omT;
      v.bOh();
      paramString3.abvc = i.NV(aa.PY(paramString1));
      paramString3.abva = ((String)localMap.get(".msg.videomsg.$cdnvideourl"));
      paramString3.abvb = ((String)localMap.get(".msg.videomsg.$aeskey"));
      localeqo.abup = paramString3;
      this.EVH.put(paramString2, localeqo);
      AppMethodBeat.o(9325);
      return;
    }
    Log.w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", new Object[] { paramString1 });
    AppMethodBeat.o(9325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cb.a
 * JD-Core Version:    0.7.0.1
 */