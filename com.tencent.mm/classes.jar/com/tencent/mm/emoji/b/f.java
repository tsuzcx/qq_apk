package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.exo;
import com.tencent.mm.protocal.protobuf.exp;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/CgiUploadEmojiPrepare;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UploadEmojiPrepareResponse;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Z)V", "plugin-emojisdk_release"})
public final class f
  extends c<exp>
{
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(105501);
    exo localexo = new exo();
    exp localexp = new exp();
    localexo.MD5 = paramEmojiInfo.field_md5;
    localexo.UxT = true;
    localexo.UxO = paramBoolean;
    ArrayList localArrayList = paramEmojiInfo.ifg();
    if (localArrayList != null) {
      localexo.UxP.addAll((Collection)localArrayList);
    }
    localexo.AttachedText = paramEmojiInfo.field_attachedText;
    localexo.AttachedTextColor = paramEmojiInfo.field_attachTextColor;
    localexo.UxQ = paramEmojiInfo.field_imitateMd5;
    localexo.LensId = paramEmojiInfo.field_lensId;
    localexo.CPw = 0;
    paramEmojiInfo = new d.a();
    paramEmojiInfo.c((a)localexo);
    paramEmojiInfo.d((a)localexp);
    paramEmojiInfo.TW("/cgi-bin/micromsg-bin/mmuploademojiprepare");
    paramEmojiInfo.vD(3886);
    c(paramEmojiInfo.bgN());
    AppMethodBeat.o(105501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.f
 * JD-Core Version:    0.7.0.1
 */