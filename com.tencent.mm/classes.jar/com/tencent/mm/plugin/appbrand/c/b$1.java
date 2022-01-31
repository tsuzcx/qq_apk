package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

final class b$1
  implements g.a
{
  b$1(b paramb) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(129813);
    Object localObject1;
    Object localObject2;
    if (paramc == null)
    {
      localObject1 = "null";
      if (paramd != null) {
        break label112;
      }
      localObject2 = "null";
      label22:
      ab.i("MicroMsg.AppbrandCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), localObject1, localObject2 });
      localObject1 = g.auO();
      if (!bo.isNullOrNil(paramString)) {
        break label122;
      }
      ab.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByMediaID error, media id is null or nil");
      label72:
      break label137;
      label73:
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label177;
      }
      ab.e("MicroMsg.AppbrandCdnService", "get item by media id failed, media is : %s", new Object[] { paramString });
      AppMethodBeat.o(129813);
      return 0;
      localObject1 = paramc.toString();
      break;
      label112:
      localObject2 = paramd.toString();
      break label22;
      label122:
      localObject2 = ((c)localObject1).hgu.values().iterator();
      label137:
      if (!((Iterator)localObject2).hasNext()) {
        break label73;
      }
      localObject1 = (a)((Iterator)localObject2).next();
      if (!bo.nullAsNil(((a)localObject1).cBO).equals(paramString)) {
        break label72;
      }
    }
    label177:
    if (paramInt == -21005)
    {
      ab.i("MicroMsg.AppbrandCdnService", "duplicate request, ignore this request, media id is %s", new Object[] { paramString });
      AppMethodBeat.o(129813);
      return 0;
    }
    if (paramInt != 0)
    {
      ab.e("MicroMsg.AppbrandCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
      b.a(this.hgt, false, ((a)localObject1).ctV, ((a)localObject1).cBO, null);
      AppMethodBeat.o(129813);
      return 0;
    }
    if (paramc != null)
    {
      ab.i("MicroMsg.AppbrandCdnService", "progressInfo : %s", new Object[] { paramc.toString() });
      paramInt = 0;
      if (paramc.field_toltalLength > 0) {
        paramInt = paramc.field_finishedLength * 100 / paramc.field_toltalLength;
      }
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
    label521:
    label678:
    for (;;)
    {
      paramc = this.hgt;
      paramBoolean = ((a)localObject1).hgm;
      int i = ((a)localObject1).cth;
      paramString = ((a)localObject1).ctV;
      ab.i("MicroMsg.AppbrandCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(paramInt), paramString, ((a)localObject1).cBO });
      if ((paramc.hgq != null) && (paramc.hgq.size() > 0))
      {
        paramc = paramc.hgq.iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            ((d.a)paramc.next()).M(paramInt, paramString);
            continue;
            if (paramInt <= 100) {
              break label678;
            }
            paramInt = 100;
            break;
          }
        }
      }
      AppMethodBeat.o(129813);
      return 0;
      if (paramd != null)
      {
        if (paramd.field_retCode == 0) {
          break label521;
        }
        ab.e("MicroMsg.AppbrandCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramString, Integer.valueOf(paramd.field_retCode), paramd });
        b.a(this.hgt, false, ((a)localObject1).ctV, ((a)localObject1).cBO, null);
      }
      do
      {
        AppMethodBeat.o(129813);
        return 0;
        ab.i("MicroMsg.AppbrandCdnService", "cdn trans suceess, media id : %s", new Object[] { paramString });
      } while (localObject1 == null);
      if (((a)localObject1).hgl == null) {
        ((a)localObject1).hgl = new a.a();
      }
      if (paramd == null) {
        ab.e("MicroMsg.AppBrandMediaCdnItem", "sceneResult info is null");
      }
      for (;;)
      {
        g.auO().a((a)localObject1);
        b.a(this.hgt, true, ((a)localObject1).ctV, ((a)localObject1).hgk, ((a)localObject1).hgl.field_fileUrl);
        break;
        ((a)localObject1).hgl.field_aesKey = paramd.field_aesKey;
        ((a)localObject1).hgl.field_fileId = paramd.field_fileId;
        ((a)localObject1).hgl.field_fileUrl = paramd.field_fileUrl;
        ((a)localObject1).hgl.field_fileLength = paramd.field_fileLength;
        ((a)localObject1).hgk = ((a)localObject1).hgl.field_fileId;
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(129811);
    ab.i("MicroMsg.AppbrandCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramString });
    AppMethodBeat.o(129811);
  }
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(129812);
    ab.i("MicroMsg.AppbrandCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramString });
    AppMethodBeat.o(129812);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b.1
 * JD-Core Version:    0.7.0.1
 */