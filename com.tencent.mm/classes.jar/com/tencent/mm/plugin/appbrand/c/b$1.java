package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

final class b$1
  implements f.a
{
  b$1(b paramb) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, d paramd, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramc == null)
    {
      localObject1 = "null";
      if (paramd != null) {
        break label102;
      }
      localObject2 = "null";
      label17:
      y.i("MicroMsg.AppbrandCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), localObject1, localObject2 });
      localObject1 = e.abd();
      if (!bk.bl(paramString)) {
        break label112;
      }
      y.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByMediaID error, media id is null or nil");
      label67:
      break label127;
      label68:
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label167;
      }
      y.e("MicroMsg.AppbrandCdnService", "get item by media id failed, media is : %s", new Object[] { paramString });
      return 0;
      localObject1 = paramc.toString();
      break;
      label102:
      localObject2 = paramd.toString();
      break label17;
      label112:
      localObject2 = ((c)localObject1).fNk.values().iterator();
      label127:
      if (!((Iterator)localObject2).hasNext()) {
        break label68;
      }
      localObject1 = (a)((Iterator)localObject2).next();
      if (!bk.pm(((a)localObject1).bUi).equals(paramString)) {
        break label67;
      }
    }
    label167:
    if (paramInt == -21005)
    {
      y.i("MicroMsg.AppbrandCdnService", "duplicate request, ignore this request, media id is %s", new Object[] { paramString });
      return 0;
    }
    if (paramInt != 0)
    {
      y.e("MicroMsg.AppbrandCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
      b.a(this.fNj, false, ((a)localObject1).bMB, ((a)localObject1).bUi, null);
      return 0;
    }
    if (paramc != null)
    {
      y.i("MicroMsg.AppbrandCdnService", "progressInfo : %s", new Object[] { paramc.toString() });
      paramInt = 0;
      if (paramc.field_toltalLength > 0) {
        paramInt = paramc.field_finishedLength * 100 / paramc.field_toltalLength;
      }
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
    label648:
    for (;;)
    {
      paramc = this.fNj;
      paramBoolean = ((a)localObject1).fNc;
      int i = ((a)localObject1).bLN;
      paramString = ((a)localObject1).bMB;
      y.i("MicroMsg.AppbrandCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(paramInt), paramString, ((a)localObject1).bUi });
      if ((paramc.fNg != null) && (paramc.fNg.size() > 0))
      {
        paramc = paramc.fNg.iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            ((d.a)paramc.next()).z(paramInt, paramString);
            continue;
            if (paramInt <= 100) {
              break label648;
            }
            paramInt = 100;
            break;
          }
        }
      }
      return 0;
      if (paramd != null)
      {
        if (paramd.field_retCode == 0) {
          break label491;
        }
        y.e("MicroMsg.AppbrandCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramString, Integer.valueOf(paramd.field_retCode), paramd });
        b.a(this.fNj, false, ((a)localObject1).bMB, ((a)localObject1).bUi, null);
      }
      label491:
      do
      {
        return 0;
        y.i("MicroMsg.AppbrandCdnService", "cdn trans suceess, media id : %s", new Object[] { paramString });
      } while (localObject1 == null);
      if (((a)localObject1).fNb == null) {
        ((a)localObject1).fNb = new a.a();
      }
      if (paramd == null) {
        y.e("MicroMsg.AppBrandMediaCdnItem", "sceneResult info is null");
      }
      for (;;)
      {
        e.abd().a((a)localObject1);
        b.a(this.fNj, true, ((a)localObject1).bMB, ((a)localObject1).fNa, ((a)localObject1).fNb.field_fileUrl);
        break;
        ((a)localObject1).fNb.field_aesKey = paramd.field_aesKey;
        ((a)localObject1).fNb.field_fileId = paramd.field_fileId;
        ((a)localObject1).fNb.field_fileUrl = paramd.field_fileUrl;
        ((a)localObject1).fNb.field_fileLength = paramd.field_fileLength;
        ((a)localObject1).fNa = ((a)localObject1).fNb.field_fileId;
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    y.i("MicroMsg.AppbrandCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramString });
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.AppbrandCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramString });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b.1
 * JD-Core Version:    0.7.0.1
 */