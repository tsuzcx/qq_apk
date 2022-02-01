package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import d.a.j;
import d.g.a.m;
import d.v;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "commentIconContainer", "Landroid/view/View;", "getCommentIconContainer", "()Landroid/view/View;", "setCommentIconContainer", "(Landroid/view/View;)V", "commentsLayout", "getCommentsLayout", "()Landroid/widget/LinearLayout;", "setCommentsLayout", "(Landroid/widget/LinearLayout;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "lastClickExposeCommentTime", "", "likeClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Lkotlin/ParameterName;", "name", "comment", "", "isLike", "", "likeLayout", "likeTv", "Landroid/widget/TextView;", "onCommentClickListener", "view", "getOnCommentClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnCommentClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onCommentLongClickListener", "getOnCommentLongClickListener", "setOnCommentLongClickListener", "seeAllCommentsTv", "getSeeAllCommentsTv", "()Landroid/widget/TextView;", "setSeeAllCommentsTv", "(Landroid/widget/TextView;)V", "viewHolderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "Lkotlin/collections/ArrayList;", "attachStyle", "contentBuilder", "Landroid/text/SpannableStringBuilder;", "onFriendClick", "Lkotlin/Function1;", "holder", "start", "end", "fillCommentsLayout", "list", "Ljava/util/LinkedList;", "totalCommentCount", "fillLikeTv", "totalLikeCount", "friendLikeCount", "isFriend", "username", "isPoster", "isReplyPoster", "setExposeInfo", "feedConvert", "commentList", "setSpanTouch", "text", "Landroid/text/Spannable;", "updateCommentCount", "ViewHolder", "plugin-finder_release"})
public final class FinderFeedExposeLayout
  extends LinearLayout
{
  private final String TAG;
  private FinderItem feed;
  private final ArrayList<a> qWO;
  private LinearLayout qWP;
  private View qWQ;
  private TextView qWT;
  public TextView qWU;
  public View qWV;
  private m<? super FinderCommentInfo, ? super Boolean, d.y> qWW;
  private m<? super View, ? super FinderCommentInfo, d.y> qWX;
  private m<? super View, ? super FinderCommentInfo, d.y> qWY;
  private long qWZ;
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168349);
    setOrientation(1);
    paramContext = com.tencent.mm.ui.y.js(getContext()).inflate(2131496184, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299883);
    d.g.b.k.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.qWP = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299885);
    d.g.b.k.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.qWQ = paramAttributeSet;
    paramContext = paramContext.findViewById(2131299884);
    d.g.b.k.g(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.qWT = ((TextView)paramContext);
    ai.a((Paint)this.qWT.getPaint(), 0.8F);
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.qWO = new ArrayList();
    AppMethodBeat.o(168349);
  }
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168350);
    setOrientation(1);
    paramContext = com.tencent.mm.ui.y.js(getContext()).inflate(2131496184, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299883);
    d.g.b.k.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.qWP = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299885);
    d.g.b.k.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.qWQ = paramAttributeSet;
    paramContext = paramContext.findViewById(2131299884);
    d.g.b.k.g(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.qWT = ((TextView)paramContext);
    ai.a((Paint)this.qWT.getPaint(), 0.8F);
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.qWO = new ArrayList();
    AppMethodBeat.o(168350);
  }
  
  private final void a(SpannableStringBuilder paramSpannableStringBuilder, FinderCommentInfo paramFinderCommentInfo, d.g.a.b<? super String, d.y> paramb, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200089);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cpI())
    {
      paramFinderCommentInfo = paramFinderCommentInfo.username;
      d.g.b.k.g(paramFinderCommentInfo, "comment.username");
      localObject = getContext();
      d.g.b.k.g(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(2131099773);
      localObject = getContext();
      d.g.b.k.g(localObject, "context");
      paramSpannableStringBuilder.setSpan(new e(paramFinderCommentInfo, i, ((Context)localObject).getResources().getColor(2131099658), true, paramb), paramInt1, paramInt2, 17);
      a(parama, (Spannable)paramSpannableStringBuilder);
    }
    AppMethodBeat.o(200089);
  }
  
  private final void a(final a parama, final Spannable paramSpannable)
  {
    AppMethodBeat.i(168346);
    paramSpannable = (View.OnTouchListener)new f(this, paramSpannable, parama);
    parama.nkb.setOnTouchListener(paramSpannable);
    AppMethodBeat.o(168346);
  }
  
  private final void csQ()
  {
    AppMethodBeat.i(168348);
    this.qWQ.setVisibility(8);
    this.qWT.setVisibility(8);
    AppMethodBeat.o(168348);
  }
  
  private static boolean d(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(178493);
    i locali = i.qTa;
    boolean bool = i.Dm(paramFinderCommentInfo.displayFlag);
    AppMethodBeat.o(178493);
    return bool;
  }
  
  private final void f(LinkedList<FinderCommentInfo> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(168344);
    Dp(paramInt);
    if (paramLinkedList.size() == 0)
    {
      this.qWP.setVisibility(8);
      AppMethodBeat.o(168344);
      return;
    }
    this.qWP.setVisibility(0);
    paramInt = this.qWO.size();
    int i = paramLinkedList.size();
    Object localObject2;
    while (paramInt < i)
    {
      localObject1 = com.tencent.mm.ui.y.js(getContext()).inflate(2131495755, null);
      localObject2 = this.qWO;
      d.g.b.k.g(localObject1, "view");
      ((ArrayList)localObject2).add(new a((View)localObject1));
      if (paramInt == paramLinkedList.size() - 1) {
        ((View)localObject1).setPadding(((View)localObject1).getPaddingLeft(), ((View)localObject1).getPaddingTop(), ((View)localObject1).getPaddingRight(), 0);
      }
      this.qWP.addView((View)localObject1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
      paramInt += 1;
    }
    Object localObject1 = ((Iterable)this.qWO).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((a)((Iterator)localObject1).next()).arI.setVisibility(8);
    }
    ad.i(this.TAG, "fillCommentsLayout");
    paramLinkedList = (Iterable)paramLinkedList;
    paramInt = 0;
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      localObject1 = paramLinkedList.next();
      if (paramInt < 0) {
        j.fvx();
      }
      localObject1 = (FinderCommentInfo)localObject1;
      localObject2 = this.qWO.get(paramInt);
      d.g.b.k.g(localObject2, "viewHolderList[index]");
      localObject2 = (a)localObject2;
      ((a)localObject2).arI.setVisibility(0);
      Object localObject3 = (d.g.a.b)new b(this);
      ((a)localObject2).nkb.setOnTouchListener(null);
      Object localObject5;
      if (((FinderCommentInfo)localObject1).replyCommentId == 0L)
      {
        localObject4 = com.tencent.mm.plugin.finder.convert.a.qpY;
        localObject4 = ((a)localObject2).nkb;
        d.g.b.k.g(localObject4, "holder.nicknameTv");
        localObject4 = ((TextView)localObject4).getPaint();
        d.g.b.k.g(localObject4, "holder.nicknameTv.paint");
        localObject5 = ((FinderCommentInfo)localObject1).nickname;
        d.g.b.k.g(localObject5, "comment.nickname");
        Object localObject6 = com.tencent.mm.plugin.finder.convert.a.qpY;
        localObject6 = getContext();
        d.g.b.k.g(localObject6, "context");
        com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
        i = com.tencent.mm.plugin.finder.convert.a.Q((Context)localObject6, com.tencent.mm.plugin.finder.storage.b.cqi());
        localObject6 = com.tencent.mm.plugin.finder.convert.a.qpY;
        localObject6 = getContext();
        d.g.b.k.g(localObject6, "context");
        localb = com.tencent.mm.plugin.finder.storage.b.qJA;
        localObject4 = com.tencent.mm.plugin.finder.convert.a.a((TextPaint)localObject4, (String)localObject5, i, com.tencent.mm.plugin.finder.convert.a.Q((Context)localObject6, com.tencent.mm.plugin.finder.storage.b.cqi() + 1));
        localObject4 = new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)localObject4));
        if ((!bt.isNullOrNil(((FinderCommentInfo)localObject1).username)) && (d((FinderCommentInfo)localObject1))) {
          a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)h.LeJ, (a)localObject2, 0, ((SpannableStringBuilder)localObject4).length());
        }
        for (;;)
        {
          ((SpannableStringBuilder)localObject4).append((CharSequence)getContext().getString(2131759161)).append((CharSequence)com.tencent.mm.plugin.finder.model.g.b((FinderCommentInfo)localObject1));
          localObject3 = ((a)localObject2).nkb;
          d.g.b.k.g(localObject3, "holder.nicknameTv");
          ((TextView)localObject3).setText((CharSequence)localObject4);
          localObject3 = ((a)localObject2).nkb;
          d.g.b.k.g(localObject3, "holder.nicknameTv");
          ((TextView)localObject3).setTag(((FinderCommentInfo)localObject1).username);
          ((a)localObject2).arI.setOnClickListener((View.OnClickListener)new c((FinderCommentInfo)localObject1, this));
          ((a)localObject2).arI.setOnLongClickListener((View.OnLongClickListener)new d((FinderCommentInfo)localObject1, this));
          paramInt += 1;
          break;
          localObject5 = ((FinderCommentInfo)localObject1).username;
          d.g.b.k.g(localObject5, "comment.username");
          if (isFriend((String)localObject5))
          {
            a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)localObject3, (a)localObject2, 0, ((SpannableStringBuilder)localObject4).length());
          }
          else
          {
            localObject5 = i.qTa;
            if (i.ZS(((FinderCommentInfo)localObject1).username)) {
              a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)localObject3, (a)localObject2, 0, ((SpannableStringBuilder)localObject4).length());
            } else {
              a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)FinderFeedExposeLayout.i.LeK, (a)localObject2, 0, ((SpannableStringBuilder)localObject4).length());
            }
          }
        }
      }
      Object localObject4 = new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)((FinderCommentInfo)localObject1).nickname));
      label813:
      int j;
      if (d((FinderCommentInfo)localObject1))
      {
        a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)FinderFeedExposeLayout.j.LeL, (a)localObject2, 0, ((SpannableStringBuilder)localObject4).length());
        if ((!bt.ai((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)((FinderCommentInfo)localObject1).replyNickname))) && (((FinderCommentInfo)localObject1).replyCommentId != 0L))
        {
          ((SpannableStringBuilder)localObject4).append((CharSequence)(" " + getContext().getString(2131759169) + ' '));
          localObject5 = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)((FinderCommentInfo)localObject1).replyNickname);
          j = ((SpannableStringBuilder)localObject4).length();
          ((SpannableStringBuilder)localObject4).append((CharSequence)localObject5);
          if ((((FinderCommentInfo)localObject1).displayFlag & 0x4) == 0) {
            break label1127;
          }
          i = 1;
          label934:
          if (i == 0) {
            break label1132;
          }
          a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)FinderFeedExposeLayout.l.LeN, (a)localObject2, j, ((SpannableStringBuilder)localObject4).length());
        }
      }
      for (;;)
      {
        ((SpannableStringBuilder)localObject4).append((CharSequence)getContext().getString(2131759161));
        ((SpannableStringBuilder)localObject4).append((CharSequence)com.tencent.mm.plugin.finder.model.g.b((FinderCommentInfo)localObject1));
        localObject3 = ((a)localObject2).nkb;
        d.g.b.k.g(localObject3, "holder.nicknameTv");
        ((TextView)localObject3).setText((CharSequence)localObject4);
        break;
        localObject5 = ((FinderCommentInfo)localObject1).username;
        d.g.b.k.g(localObject5, "comment.username");
        if (isFriend((String)localObject5))
        {
          a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)localObject3, (a)localObject2, 0, ((SpannableStringBuilder)localObject4).length());
          break label813;
        }
        localObject5 = i.qTa;
        if (i.ZS(((FinderCommentInfo)localObject1).username))
        {
          a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)localObject3, (a)localObject2, 0, ((SpannableStringBuilder)localObject4).length());
          break label813;
        }
        a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)FinderFeedExposeLayout.k.LeM, (a)localObject2, 0, ((SpannableStringBuilder)localObject4).length());
        break label813;
        label1127:
        i = 0;
        break label934;
        label1132:
        localObject5 = ((FinderCommentInfo)localObject1).reply_username;
        d.g.b.k.g(localObject5, "comment.reply_username");
        if (isFriend((String)localObject5))
        {
          a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)localObject3, (a)localObject2, j, ((SpannableStringBuilder)localObject4).length());
        }
        else
        {
          localObject5 = i.qTa;
          if (i.ZS(((FinderCommentInfo)localObject1).reply_username)) {
            a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)localObject3, (a)localObject2, j, ((SpannableStringBuilder)localObject4).length());
          } else {
            a((SpannableStringBuilder)localObject4, (FinderCommentInfo)localObject1, (d.g.a.b)FinderFeedExposeLayout.m.LeO, (a)localObject2, j, ((SpannableStringBuilder)localObject4).length());
          }
        }
      }
    }
    AppMethodBeat.o(168344);
  }
  
  private static boolean isFriend(String paramString)
  {
    AppMethodBeat.i(168347);
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isFriend(paramString);
    AppMethodBeat.o(168347);
    return bool;
  }
  
  public final void Dp(int paramInt)
  {
    AppMethodBeat.i(168343);
    Object localObject;
    if (paramInt > 0)
    {
      localObject = this.qWU;
      if (localObject == null) {
        d.g.b.k.aPZ("seeAllCommentsTv");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.qWU;
      if (localObject == null) {
        d.g.b.k.aPZ("seeAllCommentsTv");
      }
      ((TextView)localObject).setText((CharSequence)String.valueOf(paramInt));
    }
    for (;;)
    {
      localObject = this.qWV;
      if (localObject == null) {
        d.g.b.k.aPZ("commentIconContainer");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new g(this));
      AppMethodBeat.o(168343);
      return;
      localObject = this.qWU;
      if (localObject == null) {
        d.g.b.k.aPZ("seeAllCommentsTv");
      }
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public final void a(View paramView, FinderItem paramFinderItem, LinkedList<FinderCommentInfo> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, m<? super FinderCommentInfo, ? super Boolean, d.y> paramm)
  {
    AppMethodBeat.i(200088);
    d.g.b.k.h(paramView, "feedConvert");
    d.g.b.k.h(paramFinderItem, "feed");
    d.g.b.k.h(paramLinkedList, "commentList");
    d.g.b.k.h(paramm, "likeClickListener");
    ad.i(this.TAG, "setExposeInfo " + paramFinderItem.getId() + ", commentList size: " + paramLinkedList.size() + ", totalCommentCount: " + paramInt1 + ", totalLikeCount: " + paramInt2 + ", friendLikeCount: " + paramInt3);
    this.feed = paramFinderItem;
    this.qWW = paramm;
    paramm = paramView.findViewById(2131298511);
    d.g.b.k.g(paramm, "feedConvert.findViewById(R.id.comment_count_tv)");
    this.qWU = ((TextView)paramm);
    paramView = paramView.findViewById(2131298522);
    d.g.b.k.g(paramView, "feedConvert.findViewById…d.comment_icon_container)");
    this.qWV = paramView;
    paramView = this.qWU;
    if (paramView == null) {
      d.g.b.k.aPZ("seeAllCommentsTv");
    }
    ai.a((Paint)paramView.getPaint(), 0.8F);
    if (paramFinderItem.isCommentClose())
    {
      paramView = i.qTa;
      if (!i.ZR(paramFinderItem.field_username)) {
        paramInt1 = 0;
      }
    }
    for (paramView = new LinkedList();; paramView = paramLinkedList)
    {
      paramFinderItem = (List)paramView;
      if (paramFinderItem.size() > 1) {
        j.a(paramFinderItem, (Comparator)new e());
      }
      csQ();
      f(paramView, paramInt1);
      AppMethodBeat.o(200088);
      return;
    }
  }
  
  public final View getCommentIconContainer()
  {
    AppMethodBeat.i(200087);
    View localView = this.qWV;
    if (localView == null) {
      d.g.b.k.aPZ("commentIconContainer");
    }
    AppMethodBeat.o(200087);
    return localView;
  }
  
  public final LinearLayout getCommentsLayout()
  {
    return this.qWP;
  }
  
  public final m<View, FinderCommentInfo, d.y> getOnCommentClickListener()
  {
    return this.qWX;
  }
  
  public final m<View, FinderCommentInfo, d.y> getOnCommentLongClickListener()
  {
    return this.qWY;
  }
  
  public final TextView getSeeAllCommentsTv()
  {
    AppMethodBeat.i(200086);
    TextView localTextView = this.qWU;
    if (localTextView == null) {
      d.g.b.k.aPZ("seeAllCommentsTv");
    }
    AppMethodBeat.o(200086);
    return localTextView;
  }
  
  public final void setCommentIconContainer(View paramView)
  {
    AppMethodBeat.i(178492);
    d.g.b.k.h(paramView, "<set-?>");
    this.qWV = paramView;
    AppMethodBeat.o(178492);
  }
  
  public final void setCommentsLayout(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(168340);
    d.g.b.k.h(paramLinearLayout, "<set-?>");
    this.qWP = paramLinearLayout;
    AppMethodBeat.o(168340);
  }
  
  public final void setOnCommentClickListener(m<? super View, ? super FinderCommentInfo, d.y> paramm)
  {
    this.qWX = paramm;
  }
  
  public final void setOnCommentLongClickListener(m<? super View, ? super FinderCommentInfo, d.y> paramm)
  {
    this.qWY = paramm;
  }
  
  public final void setSeeAllCommentsTv(TextView paramTextView)
  {
    AppMethodBeat.i(168341);
    d.g.b.k.h(paramTextView, "<set-?>");
    this.qWU = paramTextView;
    AppMethodBeat.o(168341);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "nicknameTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getNicknameTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
  public final class a
  {
    final View arI;
    final TextView nkb;
    
    public a()
    {
      AppMethodBeat.i(168333);
      this.arI = localObject;
      this.nkb = ((TextView)this.arI.findViewById(2131302863));
      AppMethodBeat.o(168333);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "username", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$onFriendClick$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    b(FinderFeedExposeLayout paramFinderFeedExposeLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$7"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168335);
      long l = System.currentTimeMillis();
      ad.d(FinderFeedExposeLayout.b(jdField_this), "lastClickExposeCommentTime " + FinderFeedExposeLayout.c(jdField_this) + ", curTime:" + l);
      if (l - FinderFeedExposeLayout.c(jdField_this) < 1000L)
      {
        AppMethodBeat.o(168335);
        return;
      }
      FinderFeedExposeLayout.a(jdField_this, l);
      m localm = jdField_this.getOnCommentClickListener();
      if (localm != null)
      {
        d.g.b.k.g(paramView, "it");
        localm.n(paramView, this.qqN);
        AppMethodBeat.o(168335);
        return;
      }
      AppMethodBeat.o(168335);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$8"})
  static final class d
    implements View.OnLongClickListener
  {
    d(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(168336);
      m localm = jdField_this.getOnCommentLongClickListener();
      if (localm != null)
      {
        d.g.b.k.g(paramView, "it");
        localm.n(paramView, this.qqN);
      }
      AppMethodBeat.o(168336);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(168337);
      int i = d.b.a.a((Comparable)Long.valueOf(((FinderCommentInfo)paramT2).displayid), (Comparable)Long.valueOf(((FinderCommentInfo)paramT1).displayid));
      AppMethodBeat.o(168337);
      return i;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class f
    implements View.OnTouchListener
  {
    f(FinderFeedExposeLayout paramFinderFeedExposeLayout, Spannable paramSpannable, FinderFeedExposeLayout.a parama) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(168338);
      d.g.b.k.g(paramMotionEvent, "event");
      int j = paramMotionEvent.getAction();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(168338);
        throw paramView;
      }
      paramView = (TextView)paramView;
      Spannable localSpannable = paramSpannable;
      Object localObject1;
      int k;
      int i;
      if ((j == 1) || (j == 3))
      {
        localObject1 = (ClickableSpan[])localSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
        if (localObject1 != null)
        {
          k = localObject1.length;
          i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 instanceof o))
            {
              ((o)localObject2).setIsPressed(false);
              parama.nkb.invalidate();
            }
            i += 1;
          }
        }
      }
      if ((j == 1) || (j == 0))
      {
        i = (int)paramMotionEvent.getX();
        k = (int)paramMotionEvent.getY();
        int m = paramView.getTotalPaddingLeft();
        int n = paramView.getTotalPaddingTop();
        int i1 = paramView.getScrollX();
        int i2 = paramView.getScrollY();
        localObject1 = paramView.getLayout();
        i = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(k - n + i2), i - m + i1);
        localObject1 = (ClickableSpan[])localSpannable.getSpans(i, i, ClickableSpan.class);
        if (localObject1.length != 0)
        {
          localObject1 = localObject1[0];
          if (j == 1) {
            ((ClickableSpan)localObject1).onClick((View)paramView);
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ad.i(FinderFeedExposeLayout.b(this.qXa), "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
        AppMethodBeat.o(168338);
        return bool;
        if (j != 0) {
          break;
        }
        if ((localObject1 instanceof o))
        {
          ((o)localObject1).setIsPressed(true);
          parama.nkb.invalidate();
        }
        Selection.setSelection(localSpannable, localSpannable.getSpanStart(localObject1), localSpannable.getSpanEnd(localObject1));
        break;
        Selection.removeSelection(localSpannable);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168339);
      paramView = FinderFeedExposeLayout.a(this.qXa);
      if ((paramView != null) && (paramView.isCommentClose() == true)) {
        this.qXa.getSeeAllCommentsTv().setVisibility(8);
      }
      paramView = this.qXa.getOnCommentClickListener();
      if (paramView != null)
      {
        paramView.n(this.qXa.getSeeAllCommentsTv(), null);
        AppMethodBeat.o(168339);
        return;
      }
      AppMethodBeat.o(168339);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    public static final h LeJ;
    
    static
    {
      AppMethodBeat.i(200075);
      LeJ = new h();
      AppMethodBeat.o(200075);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout
 * JD-Core Version:    0.7.0.1
 */