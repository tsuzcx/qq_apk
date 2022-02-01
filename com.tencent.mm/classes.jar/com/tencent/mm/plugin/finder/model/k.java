package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"value", "Landroid/text/SpannableString;", "contentSpan", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "getContentSpan", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)Landroid/text/SpannableString;", "setContentSpan", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Landroid/text/SpannableString;)V", "displayNameSpan", "getDisplayNameSpan", "setDisplayNameSpan", "replyDisplayNameSpan", "getReplyDisplayNameSpan", "setReplyDisplayNameSpan", "plugin-finder_release"})
public final class k
{
  public static final SpannableString a(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(166379);
    p.h(paramFinderCommentInfo, "$this$contentSpan");
    Object localObject1 = j.sjX;
    Object localObject2 = (SpannableString)j.cCI().get(paramFinderCommentInfo.content);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.d.f.h.es("{displayNameSpan} username=" + paramFinderCommentInfo.username + " get SpannableString without cache!");
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)paramFinderCommentInfo.content);
      localObject2 = j.sjX;
      j.cCI().put(paramFinderCommentInfo.content, localObject1);
    }
    p.g(localObject1, "value");
    AppMethodBeat.o(166379);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.k
 * JD-Core Version:    0.7.0.1
 */