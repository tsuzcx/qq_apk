package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.protocal.protobuf.enh;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/CgiUploadEmojiPrepare;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UploadEmojiPrepareResponse;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Z)V", "plugin-emojisdk_release"})
public final class f
  extends c<enh>
{
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(105501);
    eng localeng = new eng();
    enh localenh = new enh();
    localeng.MD5 = paramEmojiInfo.field_md5;
    localeng.Nli = true;
    localeng.Nld = paramBoolean;
    ArrayList localArrayList = paramEmojiInfo.hRL();
    if (localArrayList != null) {
      localeng.Nle.addAll((Collection)localArrayList);
    }
    localeng.Lsm = paramEmojiInfo.field_attachedText;
    localeng.Lsn = paramEmojiInfo.field_attachTextColor;
    localeng.Nlf = paramEmojiInfo.field_imitateMd5;
    localeng.Lso = paramEmojiInfo.field_lensId;
    localeng.Scene = 0;
    paramEmojiInfo = new d.a();
    paramEmojiInfo.c((a)localeng);
    paramEmojiInfo.d((a)localenh);
    paramEmojiInfo.MB("/cgi-bin/micromsg-bin/mmuploademojiprepare");
    paramEmojiInfo.sG(3886);
    c(paramEmojiInfo.aXF());
    AppMethodBeat.o(105501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.f
 * JD-Core Version:    0.7.0.1
 */