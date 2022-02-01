package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/CgiUploadEmojiPrepare;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/UploadEmojiPrepareResponse;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Z)V", "plugin-emojisdk_release"})
public final class f
  extends c<dmv>
{
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(105501);
    dmu localdmu = new dmu();
    dmv localdmv = new dmv();
    localdmu.MD5 = paramEmojiInfo.field_md5;
    localdmu.FUA = true;
    localdmu.FUv = paramBoolean;
    ArrayList localArrayList = paramEmojiInfo.fGt();
    if (localArrayList != null) {
      localdmu.FUw.addAll((Collection)localArrayList);
    }
    localdmu.Eww = paramEmojiInfo.field_attachedText;
    localdmu.Ewx = paramEmojiInfo.field_attachTextColor;
    localdmu.FUx = paramEmojiInfo.field_imitateMd5;
    localdmu.Ewy = paramEmojiInfo.field_lensId;
    localdmu.Scene = 0;
    paramEmojiInfo = new b.a();
    paramEmojiInfo.c((a)localdmu);
    paramEmojiInfo.d((a)localdmv);
    paramEmojiInfo.Am("/cgi-bin/micromsg-bin/mmuploademojiprepare");
    paramEmojiInfo.op(3886);
    c(paramEmojiInfo.aAz());
    AppMethodBeat.o(105501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */