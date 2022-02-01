package com.tencent.mm.plugin.finder.view.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.ah;
import com.tencent.mm.emoji.c.b.ak;
import com.tencent.mm.emoji.c.q;
import com.tencent.mm.emoji.panel.a.ab;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.w.a.a.a.e;
import com.tencent.mm.w.a.a.a.f;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/emoji/FinderEmojiPickView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/view/emoji/FinderEmojiPanelItemAdapter;", "canShowEmoji", "", "getCanShowEmoji", "()Z", "setCanShowEmoji", "(Z)V", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "contentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiStr", "", "layoutManager", "Lcom/tencent/mm/plugin/finder/view/emoji/FinderEmojiLayoutManager;", "panelLifeCycle", "Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "recycler", "Lcom/tencent/mm/plugin/finder/view/emoji/FinderEmojiPanelRecyclerView;", "smileyItemSize", "Lcom/tencent/mm/emoji/panel/adapter/SmileyPanelItemSizeResolver;", "getImeEmojiConfig", "initData", "", "onDetachedFromWindow", "setOnTextOperationListener", "listener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setVisibility", "visibility", "updateData", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderEmojiPickView
  extends FrameLayout
{
  public static final FinderEmojiPickView.a GHa;
  public final a GHb;
  private final ab GHc;
  private final ah GHd;
  private FinderEmojiPanelRecyclerView GHe;
  private FinderEmojiLayoutManager GHf;
  private d GHg;
  private String GHh;
  private boolean GHi;
  public final LinkedList<ae> mio;
  
  static
  {
    AppMethodBeat.i(345341);
    GHa = new FinderEmojiPickView.a((byte)0);
    AppMethodBeat.o(345341);
  }
  
  public FinderEmojiPickView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345308);
    this.GHb = new a();
    this.GHc = new ab();
    this.GHd = new ah();
    this.GHg = new d(0);
    this.mio = new LinkedList();
    this.GHh = "";
    af.mU(getContext()).inflate(a.f.finder_emoji_pick_layout, (ViewGroup)this, true);
    paramContext = findViewById(a.e.recycler_emoji_group);
    s.s(paramContext, "findViewById(R.id.recycler_emoji_group)");
    this.GHe = ((FinderEmojiPanelRecyclerView)paramContext);
    this.GHf = new FinderEmojiLayoutManager(getContext(), this.GHc.spanCount);
    this.GHe.setHasFixedSize(true);
    this.GHe.setAdapter((RecyclerView.a)this.GHb);
    this.GHe.setSizeResolver((o)this.GHc);
    this.GHe.setPanelLifeCycle((b)this.GHd);
    this.GHe.setLayoutManager((RecyclerView.LayoutManager)this.GHf);
    this.GHe.setFocusable(false);
    this.GHe.setItemAnimator(null);
    this.GHb.mkY = ((n)this.GHg);
    this.GHh = getImeEmojiConfig();
    aNi();
    AppMethodBeat.o(345308);
  }
  
  public FinderEmojiPickView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345320);
    this.GHb = new a();
    this.GHc = new ab();
    this.GHd = new ah();
    this.GHg = new d(0);
    this.mio = new LinkedList();
    this.GHh = "";
    af.mU(getContext()).inflate(a.f.finder_emoji_pick_layout, (ViewGroup)this, true);
    paramContext = findViewById(a.e.recycler_emoji_group);
    s.s(paramContext, "findViewById(R.id.recycler_emoji_group)");
    this.GHe = ((FinderEmojiPanelRecyclerView)paramContext);
    this.GHf = new FinderEmojiLayoutManager(getContext(), this.GHc.spanCount);
    this.GHe.setHasFixedSize(true);
    this.GHe.setAdapter((RecyclerView.a)this.GHb);
    this.GHe.setSizeResolver((o)this.GHc);
    this.GHe.setPanelLifeCycle((b)this.GHd);
    this.GHe.setLayoutManager((RecyclerView.LayoutManager)this.GHf);
    this.GHe.setFocusable(false);
    this.GHe.setItemAnimator(null);
    this.GHb.mkY = ((n)this.GHg);
    this.GHh = getImeEmojiConfig();
    aNi();
    AppMethodBeat.o(345320);
  }
  
  private final void aNi()
  {
    AppMethodBeat.i(345332);
    setVisibility(8);
    if (((CharSequence)this.GHh).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(345332);
      return;
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.ad.f localf = new com.tencent.mm.ad.i(this.GHh).Fq("default");
        int k = localf.length();
        int j;
        if (k > 0)
        {
          i = 0;
          j = i + 1;
          String str = localf.getString(i);
          this.mio.add(new ak(new q(str), false, i + 1));
          if (j < k) {}
        }
        else if (!((Collection)this.mio).isEmpty())
        {
          i = 1;
          if (i != 0)
          {
            this.GHi = true;
            AppMethodBeat.o(345332);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        i = j;
      }
      catch (Exception localException)
      {
        Log.e("FinderEmojiPickView", "parse data error, exception : %s", new Object[] { localException });
        AppMethodBeat.o(345332);
        return;
      }
    }
  }
  
  public final boolean getCanShowEmoji()
  {
    return this.GHi;
  }
  
  public final String getImeEmojiConfig()
  {
    AppMethodBeat.i(345369);
    String str = com.tencent.mm.k.i.aRC().getValue("IMEmoji");
    if (str == null)
    {
      AppMethodBeat.o(345369);
      return "";
    }
    AppMethodBeat.o(345369);
    return str;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(345352);
    super.onDetachedFromWindow();
    this.GHd.clear();
    AppMethodBeat.o(345352);
  }
  
  public final void setCanShowEmoji(boolean paramBoolean)
  {
    this.GHi = paramBoolean;
  }
  
  public final void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(345356);
    s.u(parama, "listener");
    this.GHg.mkD = parama;
    AppMethodBeat.o(345356);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(345363);
    if ((paramInt == 0) && (this.GHi))
    {
      super.setVisibility(paramInt);
      AppMethodBeat.o(345363);
      return;
    }
    super.setVisibility(8);
    AppMethodBeat.o(345363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.emoji.FinderEmojiPickView
 * JD-Core Version:    0.7.0.1
 */