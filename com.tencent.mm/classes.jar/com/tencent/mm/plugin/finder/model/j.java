package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"value", "Landroid/text/SpannableString;", "contentSpan", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "getContentSpan", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)Landroid/text/SpannableString;", "setContentSpan", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Landroid/text/SpannableString;)V", "displayNameSpan", "getDisplayNameSpan", "setDisplayNameSpan", "replyDisplayNameSpan", "getReplyDisplayNameSpan", "setReplyDisplayNameSpan", "plugin-finder_release"})
public final class j
{
  public static final SpannableString a(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(166379);
    d.g.b.k.h(paramFinderCommentInfo, "$this$contentSpan");
    Object localObject1 = i.ruE;
    Object localObject2 = (SpannableString)i.cws().get(paramFinderCommentInfo.content);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.d.f.h.ep("{displayNameSpan} username=" + paramFinderCommentInfo.username + " get SpannableString without cache!");
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c(ai.getContext(), (CharSequence)paramFinderCommentInfo.content);
      localObject2 = i.ruE;
      i.cws().put(paramFinderCommentInfo.content, localObject1);
    }
    d.g.b.k.g(localObject1, "value");
    AppMethodBeat.o(166379);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.j
 * JD-Core Version:    0.7.0.1
 */