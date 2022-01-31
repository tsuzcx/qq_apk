package com.tencent.mm.plugin.card.d;

import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.List;

final class a$1
  implements f.a
{
  a$1(String paramString1, String paramString2) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    if (paramInt == -21005) {
      y.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", new Object[] { paramString });
    }
    for (;;)
    {
      return 0;
      if (paramInt == 0) {
        break;
      }
      y.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
      paramInt = 0;
      while (paramInt < a.Kd().size())
      {
        paramString = (WeakReference)a.Kd().get(paramInt);
        if (paramString != null)
        {
          paramString = (a.a)paramString.get();
          if (paramString != null) {
            paramString.fail(this.eGX);
          }
        }
        paramInt += 1;
      }
    }
    if (paramc != null)
    {
      y.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", new Object[] { paramc.toString() });
      if (paramc.field_toltalLength <= 0) {
        break label426;
      }
    }
    label426:
    for (int i = paramc.field_finishedLength * 100 / paramc.field_toltalLength;; i = 0)
    {
      if (i < 0) {
        paramInt = 0;
      }
      for (;;)
      {
        i = 0;
        while (i < a.Kd().size())
        {
          paramString = (WeakReference)a.Kd().get(i);
          if (paramString != null)
          {
            paramString = (a.a)paramString.get();
            if (paramString != null) {
              paramString.bm(this.eGX, paramInt);
            }
          }
          i += 1;
        }
        break;
        paramInt = i;
        if (i > 100) {
          paramInt = 100;
        }
      }
      if (paramd == null) {
        break;
      }
      if (paramd.field_retCode != 0)
      {
        y.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", new Object[] { paramString, Integer.valueOf(paramd.field_retCode), paramd });
        paramInt = 0;
        while (paramInt < a.Kd().size())
        {
          paramString = (WeakReference)a.Kd().get(paramInt);
          if (paramString != null)
          {
            paramString = (a.a)paramString.get();
            if (paramString != null) {
              paramString.fail(this.eGX);
            }
          }
          paramInt += 1;
        }
        break;
      }
      y.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", new Object[] { paramd });
      paramInt = 0;
      while (paramInt < a.Kd().size())
      {
        paramString = (WeakReference)a.Kd().get(paramInt);
        if (paramString != null)
        {
          paramString = (a.a)paramString.get();
          if (paramString != null) {
            paramString.cx(this.eGX, this.val$filePath);
          }
        }
        paramInt += 1;
      }
      break;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    y.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", new Object[] { paramString });
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", new Object[] { paramString });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.a.1
 * JD-Core Version:    0.7.0.1
 */