package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"value", "Landroid/text/SpannableString;", "contentSpan", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "getContentSpan", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)Landroid/text/SpannableString;", "setContentSpan", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Landroid/text/SpannableString;)V", "displayNameSpan", "getDisplayNameSpan", "setDisplayNameSpan", "replyDisplayNameSpan", "getReplyDisplayNameSpan", "setReplyDisplayNameSpan", "plugin-finder_release"})
public final class o
{
  public static final SpannableString a(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(166379);
    p.k(paramFinderCommentInfo, "$this$contentSpan");
    Object localObject1 = n.zAi;
    Object localObject2 = (SpannableString)n.dKs().get(paramFinderCommentInfo.content);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.d.f.h.eF("{displayNameSpan} username=" + paramFinderCommentInfo.username + " get SpannableString without cache!");
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramFinderCommentInfo.content);
      localObject2 = n.zAi;
      n.dKs().put(paramFinderCommentInfo.content, localObject1);
    }
    p.j(localObject1, "value");
    AppMethodBeat.o(166379);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.o
 * JD-Core Version:    0.7.0.1
 */