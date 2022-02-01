package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"value", "Landroid/text/SpannableString;", "contentSpan", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "getContentSpan", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)Landroid/text/SpannableString;", "setContentSpan", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Landroid/text/SpannableString;)V", "displayNameSpan", "getDisplayNameSpan", "setDisplayNameSpan", "replyDisplayNameSpan", "getReplyDisplayNameSpan", "setReplyDisplayNameSpan", "plugin-finder_release"})
public final class g
{
  public static final SpannableString b(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(166379);
    d.g.b.k.h(paramFinderCommentInfo, "$this$contentSpan");
    Object localObject1 = f.qDu;
    Object localObject2 = (SpannableString)f.cmX().get(paramFinderCommentInfo.content);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.d.f.h.eo("{displayNameSpan} username=" + paramFinderCommentInfo.username + " get SpannableString without cache!");
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)paramFinderCommentInfo.content);
      localObject2 = f.qDu;
      f.cmX().put(paramFinderCommentInfo.content, localObject1);
    }
    d.g.b.k.g(localObject1, "value");
    AppMethodBeat.o(166379);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.g
 * JD-Core Version:    0.7.0.1
 */