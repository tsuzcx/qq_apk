package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.fth;
import com.tencent.mm.protocal.protobuf.fti;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/CgiUploadEmojiPrepare;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UploadEmojiPrepareResponse;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Z)V", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b<fti>
{
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(105501);
    fth localfth = new fth();
    fti localfti = new fti();
    localfth.MD5 = paramEmojiInfo.field_md5;
    localfth.abRA = true;
    localfth.abRv = paramBoolean;
    ArrayList localArrayList = paramEmojiInfo.kMm();
    if (localArrayList != null) {
      localfth.abRw.addAll((Collection)localArrayList);
    }
    localfth.AttachedText = paramEmojiInfo.field_attachedText;
    localfth.AttachedTextColor = paramEmojiInfo.field_attachTextColor;
    localfth.abRx = paramEmojiInfo.field_imitateMd5;
    localfth.LensId = paramEmojiInfo.field_lensId;
    localfth.IJG = 0;
    paramEmojiInfo = new c.a();
    paramEmojiInfo.otE = ((a)localfth);
    paramEmojiInfo.otF = ((a)localfti);
    paramEmojiInfo.uri = "/cgi-bin/micromsg-bin/mmuploademojiprepare";
    paramEmojiInfo.funcId = 3886;
    c(paramEmojiInfo.bEF());
    AppMethodBeat.o(105501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.f
 * JD-Core Version:    0.7.0.1
 */