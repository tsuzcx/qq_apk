package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public final class b
{
  public g.a hhW;
  public Vector<d.b> jaA;
  public Vector<d.a> jaB;
  HashMap<String, Object> jaC;
  private h.a jaD;
  
  public b()
  {
    AppMethodBeat.i(44818);
    this.jaB = new Vector();
    this.jaA = new Vector();
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(44813);
        Object localObject1;
        Object localObject2;
        if (paramAnonymousc == null)
        {
          localObject1 = "null";
          if (paramAnonymousd != null) {
            break label112;
          }
          localObject2 = "null";
          label22:
          ad.i("MicroMsg.AppbrandCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), localObject1, localObject2 });
          localObject1 = j.aOM();
          if (!bt.isNullOrNil(paramAnonymousString)) {
            break label122;
          }
          ad.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByMediaID error, media id is null or nil");
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
          ad.e("MicroMsg.AppbrandCdnService", "get item by media id failed, media is : %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(44813);
          return 0;
          localObject1 = paramAnonymousc.toString();
          break;
          label112:
          localObject2 = paramAnonymousd.toString();
          break label22;
          label122:
          localObject2 = ((c)localObject1).jaF.values().iterator();
          label137:
          if (!((Iterator)localObject2).hasNext()) {
            break label73;
          }
          localObject1 = (a)((Iterator)localObject2).next();
          if (!bt.nullAsNil(((a)localObject1).mediaId).equals(paramAnonymousString)) {
            break label72;
          }
        }
        label177:
        if (paramAnonymousInt == -21005)
        {
          ad.i("MicroMsg.AppbrandCdnService", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(44813);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ad.e("MicroMsg.AppbrandCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          b.a(b.this, false, ((a)localObject1).diQ, ((a)localObject1).mediaId, null);
          AppMethodBeat.o(44813);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          ad.i("MicroMsg.AppbrandCdnService", "progressInfo : %s", new Object[] { paramAnonymousc.toString() });
          long l1 = 0L;
          if (paramAnonymousc.field_toltalLength > 0L) {
            l1 = paramAnonymousc.field_finishedLength * 100L / paramAnonymousc.field_toltalLength;
          }
          long l2;
          if (l1 < 0L) {
            l2 = 0L;
          }
          for (;;)
          {
            paramAnonymousc = b.this;
            paramAnonymousBoolean = ((a)localObject1).jax;
            paramAnonymousInt = ((a)localObject1).mediaType;
            int i = (int)l2;
            paramAnonymousString = ((a)localObject1).diQ;
            ad.i("MicroMsg.AppbrandCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousString, ((a)localObject1).mediaId });
            if ((paramAnonymousc.jaB == null) || (paramAnonymousc.jaB.size() <= 0)) {
              break;
            }
            paramAnonymousc = paramAnonymousc.jaB.iterator();
            while (paramAnonymousc.hasNext()) {
              ((d.a)paramAnonymousc.next()).V(i, paramAnonymousString);
            }
            l2 = l1;
            if (l1 > 100L) {
              l2 = 100L;
            }
          }
          AppMethodBeat.o(44813);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label544;
          }
          ad.e("MicroMsg.AppbrandCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          b.a(b.this, false, ((a)localObject1).diQ, ((a)localObject1).mediaId, null);
        }
        label544:
        do
        {
          AppMethodBeat.o(44813);
          return 0;
          ad.i("MicroMsg.AppbrandCdnService", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
        } while (localObject1 == null);
        if (((a)localObject1).jaw == null) {
          ((a)localObject1).jaw = new a.a();
        }
        if (paramAnonymousd == null) {
          ad.e("MicroMsg.AppBrandMediaCdnItem", "sceneResult info is null");
        }
        for (;;)
        {
          j.aOM().a((a)localObject1);
          b.a(b.this, true, ((a)localObject1).diQ, ((a)localObject1).jav, ((a)localObject1).jaw.field_fileUrl);
          break;
          ((a)localObject1).jaw.field_aesKey = paramAnonymousd.field_aesKey;
          ((a)localObject1).jaw.field_fileId = paramAnonymousd.field_fileId;
          ((a)localObject1).jaw.field_fileUrl = paramAnonymousd.field_fileUrl;
          ((a)localObject1).jaw.field_fileLength = ((int)paramAnonymousd.field_fileLength);
          ((a)localObject1).jav = ((a)localObject1).jaw.field_fileId;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(44811);
        ad.i("MicroMsg.AppbrandCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(44811);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(44812);
        ad.i("MicroMsg.AppbrandCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(44812);
        return null;
      }
    };
    this.jaC = new HashMap();
    this.jaD = new b.2(this);
    AppMethodBeat.o(44818);
  }
  
  public static boolean Fu(String paramString)
  {
    AppMethodBeat.i(44821);
    a locala = j.aOM().Fv(paramString);
    if (locala == null)
    {
      ad.e("MicroMsg.AppbrandCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      AppMethodBeat.o(44821);
      return false;
    }
    boolean bool = f.awL().xK(locala.mediaId);
    AppMethodBeat.o(44821);
    return bool;
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(44820);
    if ((this.jaB != null) && (parama != null)) {
      this.jaB.remove(parama);
    }
    AppMethodBeat.o(44820);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(44819);
    if ((this.jaA != null) && (paramb != null)) {
      this.jaA.remove(paramb);
    }
    AppMethodBeat.o(44819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b
 * JD-Core Version:    0.7.0.1
 */