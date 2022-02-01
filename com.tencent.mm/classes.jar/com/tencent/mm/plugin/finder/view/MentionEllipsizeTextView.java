package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.avc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/MentionEllipsizeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "finderMention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "getFinderMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "setFinderMention", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setMention", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MentionEllipsizeTextView
  extends AppCompatTextView
{
  public static final a GFi;
  private com.tencent.mm.plugin.finder.storage.av ECa;
  
  static
  {
    AppMethodBeat.i(344402);
    GFi = new a((byte)0);
    AppMethodBeat.o(344402);
  }
  
  public MentionEllipsizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344393);
    AppMethodBeat.o(344393);
  }
  
  public MentionEllipsizeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344397);
    AppMethodBeat.o(344397);
  }
  
  public final com.tencent.mm.plugin.finder.storage.av getFinderMention()
  {
    return this.ECa;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(344434);
    super.onMeasure(paramInt1, paramInt2);
    Object localObject2 = this.ECa;
    Object localObject1 = getLayout();
    Object localObject3;
    if ((localObject2 != null) && (localObject1 != null) && (((com.tencent.mm.plugin.finder.storage.av)localObject2).field_commentMentionedUser != null) && (((Layout)localObject1).getEllipsisCount(((Layout)localObject1).getLineCount() - 1) > 0))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject1 = ((com.tencent.mm.plugin.finder.storage.av)localObject2).field_commentMentionedUser;
      s.s(localObject1, "finderMention.field_commentMentionedUser");
      s.u(localObject1, "user");
      if (((avc)localObject1).ZFt != null)
      {
        localObject3 = ((avc)localObject1).ZFt;
        s.checkNotNull(localObject3);
        if (((b)localObject3).Op.length == 16) {
          break label200;
        }
      }
    }
    for (localObject1 = null;; localObject1 = new ah("", "", com.tencent.mm.plugin.finder.utils.av.q(0, (byte[])localObject1), com.tencent.mm.plugin.finder.utils.av.q(8, (byte[])localObject1)))
    {
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.storage.av)localObject2).field_content;
        localObject2 = localObject3;
        if (((ah)localObject1).start != 0L)
        {
          localObject2 = localObject3;
          if (((ah)localObject1).start < ((String)localObject3).length()) {
            localObject2 = s.X("…", ((String)localObject3).subSequence((int)((ah)localObject1).start, ((String)localObject3).length()));
          }
        }
        setText((CharSequence)p.b(getContext(), (CharSequence)localObject2));
        super.onMeasure(paramInt1, paramInt2);
      }
      AppMethodBeat.o(344434);
      return;
      label200:
      localObject1 = ((avc)localObject1).ZFt;
      s.checkNotNull(localObject1);
      localObject1 = ((b)localObject1).Op;
      s.s(localObject1, "byteArr");
    }
  }
  
  public final void setFinderMention(com.tencent.mm.plugin.finder.storage.av paramav)
  {
    this.ECa = paramav;
  }
  
  public final void setMention(com.tencent.mm.plugin.finder.storage.av paramav)
  {
    AppMethodBeat.i(344422);
    this.ECa = paramav;
    if (paramav != null) {
      setText((CharSequence)p.b(getContext(), (CharSequence)getContext().getString(e.h.finder_comment_msg_item, new Object[] { paramav.field_content })));
    }
    AppMethodBeat.o(344422);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/MentionEllipsizeTextView$Companion;", "", "()V", "ELLIPSIS_NORMAL", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.MentionEllipsizeTextView
 * JD-Core Version:    0.7.0.1
 */