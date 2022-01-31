package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class a$6
  implements g.a
{
  a$6(a parama) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(5331);
    if (paramc != null) {
      ab.i("MicroMsg.Fav.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", new Object[] { paramc.cBO, Integer.valueOf(paramc.field_toltalLength), Integer.valueOf(paramc.field_finishedLength) });
    }
    Object localObject1 = "";
    if (paramc != null) {
      localObject1 = paramc.cBO;
    }
    while ((paramInt == -21006) || (paramInt == -21005))
    {
      this.mvc.NU((String)localObject1);
      AppMethodBeat.o(5331);
      return 0;
      if (paramd != null) {
        localObject1 = paramd.cBO;
      }
    }
    if (bo.isNullOrNil((String)localObject1)) {}
    for (;;)
    {
      localObject1 = ((ae)g.G(ae.class)).getFavCdnStorage().NP(paramString);
      if (localObject1 == null)
      {
        ab.e("MicroMsg.Fav.FavCdnService", "klem onCdnCallback info null");
        this.mvc.NU(paramString);
        AppMethodBeat.o(5331);
        return 0;
      }
      if (paramInt != 0)
      {
        ab.w("MicroMsg.Fav.FavCdnService", "cdn transfer callback, startRet=%d", new Object[] { Integer.valueOf(paramInt) });
        h.qsU.e(10660, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(paramInt) });
        ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 4;
        ((ae)g.G(ae.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
        a.g((com.tencent.mm.plugin.fav.a.c)localObject1);
        this.mvc.NU(paramString);
      }
      do
      {
        for (;;)
        {
          AppMethodBeat.o(5331);
          return 0;
          if (paramc == null) {
            break;
          }
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_offset = paramc.field_finishedLength;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen = paramc.field_toltalLength;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 1;
          ((ae)g.G(ae.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
        }
      } while (paramd == null);
      Object localObject2;
      if (paramd.field_retCode >= 0)
      {
        ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 3;
        Object localObject3;
        if (1 == ((com.tencent.mm.plugin.fav.a.c)localObject1).field_type)
        {
          paramc = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path + ".temp";
          localObject3 = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path;
          paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType;
          if ((paramc != null) && (localObject3 != null)) {}
        }
        for (;;)
        {
          ((ae)g.G(ae.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
          a.a((com.tencent.mm.plugin.fav.a.c)localObject1, paramd);
          ((ae)g.G(ae.class)).getFavCdnStorage().b((com.tencent.mm.plugin.fav.a.c)localObject1, new String[] { "dataId" });
          this.mvc.muW.remove(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
          ab.i("MicroMsg.Fav.FavCdnService", "transfer done, mediaid=%s, md5=%s aeskey=%s completeInfo=%s", new Object[] { paramd.cBO, paramString, paramd.field_aesKey, paramd.toString() });
          a.a(this.mvc, paramString);
          h.qsU.e(10625, new Object[] { Integer.valueOf(1), paramd.field_fileId, "", paramd.field_transInfo });
          break;
          if ((paramInt == -2) && (!a.NT(paramc)) && (a.er(paramc, (String)localObject3)))
          {
            ab.i("MicroMsg.Fav.FavCdnService", "renameAndCopyFile write amr head ok!");
          }
          else
          {
            localObject2 = new b(paramc);
            localObject3 = new b((String)localObject3);
            if (((b)localObject2).exists())
            {
              ab.i("MicroMsg.Fav.FavCdnService", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(((b)localObject2).p((b)localObject3)), paramc, localObject3 });
              continue;
              ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey = paramd.field_aesKey;
              ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl = paramd.field_fileId;
            }
          }
        }
      }
      ab.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:%d", new Object[] { paramd.cBO, Integer.valueOf(paramd.field_retCode) });
      paramc = (a.a)this.mvc.muW.get(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
      if (paramc != null) {
        paramc.errCode = paramd.field_retCode;
      }
      if (-6101 == paramd.field_retCode)
      {
        ((com.tencent.mm.plugin.fav.a.c)localObject1).field_extFlag |= 0x1;
        h.qsU.idkeyStat(141L, 1L, 1L, true);
        localObject2 = paramd.cBO;
        if (paramc != null)
        {
          paramInt = paramc.gjM;
          label806:
          ab.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d", new Object[] { localObject2, Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType) });
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 4;
        h.qsU.e(10660, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(paramd.field_retCode) });
        ((ae)g.G(ae.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
        a.g((com.tencent.mm.plugin.fav.a.c)localObject1);
        break;
        paramInt = 1;
        break label806;
        switch (paramd.field_retCode)
        {
        default: 
          h.qsU.idkeyStat(141L, 0L, 1L, true);
          break;
        case -10003: 
          h.qsU.idkeyStat(141L, 2L, 1L, true);
          break;
        case -10005: 
          h.qsU.idkeyStat(141L, 3L, 1L, true);
          break;
        case -21000: 
          h.qsU.idkeyStat(141L, 4L, 1L, true);
          break;
        case -21009: 
          h.qsU.idkeyStat(141L, 5L, 1L, true);
          break;
        case -21014: 
          h.qsU.idkeyStat(141L, 6L, 1L, true);
          break;
        case -21020: 
          h.qsU.idkeyStat(141L, 7L, 1L, true);
          break;
        case -5103015: 
          h.qsU.idkeyStat(141L, 8L, 1L, true);
        }
      }
      paramString = (String)localObject1;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.6
 * JD-Core Version:    0.7.0.1
 */