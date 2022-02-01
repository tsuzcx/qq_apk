package com.tencent.mm.plugin.editor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.ConcurrentHashMap;

final class EditorUI$19
  implements g.a
{
  EditorUI$19(EditorUI paramEditorUI) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(181537);
    if (paramInt != 0)
    {
      Log.e("MicroMsg.EditorUI", "transfer err! startRet: %s.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(181537);
      return 0;
    }
    paramc = (com.tencent.mm.plugin.fav.a.c)EditorUI.s(this.upk).get(paramString);
    if (paramc == null)
    {
      Log.e("MicroMsg.EditorUI", "cdn info is null!!!");
      AppMethodBeat.o(181537);
      return 0;
    }
    anm localanm = (anm)EditorUI.t(this.upk).get(paramString);
    if (localanm == null)
    {
      Log.e("MicroMsg.EditorUI", "data item is null!!!");
      AppMethodBeat.o(181537);
      return 0;
    }
    String str;
    Object localObject;
    if ((paramd != null) && (paramd.field_retCode >= 0))
    {
      if (1 != paramc.field_type) {
        break label374;
      }
      str = paramc.field_path + ".temp";
      localObject = paramc.field_path;
      paramInt = paramc.field_dataType;
      if ((str != null) && (localObject != null)) {
        break label273;
      }
      if (!paramString.endsWith("_t")) {
        break label395;
      }
      localanm.bsA(paramc.field_cdnKey);
      localanm.bsz(paramc.field_cdnUrl);
      label197:
      EditorUI.s(this.upk).remove(paramc.field_dataId);
      Log.i("MicroMsg.EditorUI", "transfer done, mediaId=%s completeResult.mediaId=%s aesKey=%s completeInfo=%s", new Object[] { paramString, paramd.mediaId, paramd.field_aesKey, paramd.toString() });
      if (1 != paramc.field_type) {
        break label462;
      }
      EditorUI.u(this.upk);
    }
    for (;;)
    {
      AppMethodBeat.o(181537);
      return 0;
      label273:
      if ((paramInt == -2) && (!EditorUI.atA(str)) && (EditorUI.fW(str, (String)localObject)))
      {
        Log.i("MicroMsg.EditorUI", "renameAndCopyFile write amr head ok!");
        break;
      }
      q localq = new q(str);
      localObject = new q((String)localObject);
      if (!localq.ifE()) {
        break;
      }
      Log.i("MicroMsg.EditorUI", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(localq.aj((q)localObject)), str, localObject });
      break;
      label374:
      paramc.field_cdnKey = paramd.field_aesKey;
      paramc.field_cdnUrl = paramd.field_fileId;
      break;
      label395:
      localanm.bsC(paramc.field_cdnKey);
      localanm.bsB(paramc.field_cdnUrl);
      if ((paramc.field_type != 0) || (!paramc.djx())) {
        break label197;
      }
      Log.i("MicroMsg.EditorUI", "video stream, id:%s", new Object[] { paramd.field_videoFileId });
      localanm.bsQ(paramd.field_videoFileId);
      break label197;
      label462:
      EditorUI.v(this.upk);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI.19
 * JD-Core Version:    0.7.0.1
 */