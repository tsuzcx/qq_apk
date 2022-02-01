package com.tencent.mm.plugin.finder.view;

import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCommentEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipboard", "Landroid/content/ClipboardManager;", "getClipboard", "()Landroid/content/ClipboardManager;", "clipboard$delegate", "Lkotlin/Lazy;", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "pastedList", "", "Ljava/util/LinkedList;", "", "getPastedList", "()Ljava/util/Map;", "cleanPastedContentList", "", "getPastedContentList", "onTextContextMenuItem", "", "id", "updateFeedId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCommentEditText
  extends MMEditText
{
  private final j GxL;
  private final Map<Long, LinkedList<String>> GxM;
  public long feedId;
  
  public FinderCommentEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344894);
    this.GxL = k.cm((a)new a(this));
    this.GxM = ((Map)new HashMap());
    this.feedId = -1L;
    AppMethodBeat.o(344894);
  }
  
  public FinderCommentEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344902);
    this.GxL = k.cm((a)new a(this));
    this.GxM = ((Map)new HashMap());
    this.feedId = -1L;
    AppMethodBeat.o(344902);
  }
  
  private final ClipboardManager getClipboard()
  {
    AppMethodBeat.i(344908);
    ClipboardManager localClipboardManager = (ClipboardManager)this.GxL.getValue();
    AppMethodBeat.o(344908);
    return localClipboardManager;
  }
  
  public final void fks()
  {
    AppMethodBeat.i(344945);
    this.GxM.clear();
    AppMethodBeat.o(344945);
  }
  
  public final long getFeedId()
  {
    return this.feedId;
  }
  
  public final Map<Long, LinkedList<String>> getPastedList()
  {
    return this.GxM;
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(344933);
    if ((paramInt == 16908322) && (getClipboard().hasText()))
    {
      if (this.GxM.get(Long.valueOf(this.feedId)) == null) {
        this.GxM.put(Long.valueOf(this.feedId), new LinkedList());
      }
      LinkedList localLinkedList = (LinkedList)this.GxM.get(Long.valueOf(this.feedId));
      if (localLinkedList != null) {
        localLinkedList.add(getClipboard().getText().toString());
      }
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(344933);
    return bool;
  }
  
  public final LinkedList<String> ra(long paramLong)
  {
    AppMethodBeat.i(344938);
    LinkedList localLinkedList = (LinkedList)this.GxM.get(Long.valueOf(paramLong));
    if (localLinkedList == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(344938);
      return localLinkedList;
    }
    AppMethodBeat.o(344938);
    return localLinkedList;
  }
  
  public final void setFeedId(long paramLong)
  {
    this.feedId = paramLong;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/content/ClipboardManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ClipboardManager>
  {
    a(FinderCommentEditText paramFinderCommentEditText)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentEditText
 * JD-Core Version:    0.7.0.1
 */