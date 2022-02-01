package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/CgiUploadEmojiPrepare;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UploadEmojiPrepareResponse;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Z)V", "plugin-emojisdk_release"})
public final class f
  extends com.tencent.mm.ak.a<dtj>
{
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(105501);
    dti localdti = new dti();
    dtj localdtj = new dtj();
    localdti.MD5 = paramEmojiInfo.field_md5;
    localdti.HZb = true;
    localdti.HYW = paramBoolean;
    ArrayList localArrayList = paramEmojiInfo.fSP();
    if (localArrayList != null) {
      localdti.HYX.addAll((Collection)localArrayList);
    }
    localdti.GwG = paramEmojiInfo.field_attachedText;
    localdti.GwH = paramEmojiInfo.field_attachTextColor;
    localdti.HYY = paramEmojiInfo.field_imitateMd5;
    localdti.GwI = paramEmojiInfo.field_lensId;
    localdti.Scene = 0;
    paramEmojiInfo = new b.a();
    paramEmojiInfo.c((com.tencent.mm.bw.a)localdti);
    paramEmojiInfo.d((com.tencent.mm.bw.a)localdtj);
    paramEmojiInfo.DN("/cgi-bin/micromsg-bin/mmuploademojiprepare");
    paramEmojiInfo.oS(3886);
    c(paramEmojiInfo.aDS());
    AppMethodBeat.o(105501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */