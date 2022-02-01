package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.z;
import d.g.a.m;
import d.y;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "commentIconContainer", "Landroid/view/View;", "getCommentIconContainer", "()Landroid/view/View;", "setCommentIconContainer", "(Landroid/view/View;)V", "commentsLayout", "getCommentsLayout", "()Landroid/widget/LinearLayout;", "setCommentsLayout", "(Landroid/widget/LinearLayout;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "lastClickExposeCommentTime", "", "likeClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Lkotlin/ParameterName;", "name", "comment", "", "isLike", "", "likeLayout", "likeTv", "Landroid/widget/TextView;", "onCommentClickListener", "view", "getOnCommentClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnCommentClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onCommentLongClickListener", "getOnCommentLongClickListener", "setOnCommentLongClickListener", "seeAllCommentsTv", "getSeeAllCommentsTv", "()Landroid/widget/TextView;", "setSeeAllCommentsTv", "(Landroid/widget/TextView;)V", "viewHolderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "Lkotlin/collections/ArrayList;", "attachStyle", "contentBuilder", "Landroid/text/SpannableStringBuilder;", "onFriendClick", "Lkotlin/Function1;", "holder", "start", "end", "fillCommentsLayout", "list", "Ljava/util/LinkedList;", "totalCommentCount", "fillLikeTv", "totalLikeCount", "friendLikeCount", "isFriend", "username", "isPoster", "isReplyPoster", "setExposeInfo", "feedConvert", "commentList", "setSpanTouch", "text", "Landroid/text/Spannable;", "updateCommentCount", "ViewHolder", "plugin-finder_release"})
public final class FinderFeedExposeLayout
  extends LinearLayout
{
  private final String TAG;
  private FinderItem feed;
  private TextView gAt;
  private View rHK;
  private final ArrayList<a> rXc;
  private LinearLayout rXd;
  public TextView rXe;
  public View rXf;
  private m<? super FinderCommentInfo, ? super Boolean, y> rXg;
  private m<? super View, ? super FinderCommentInfo, y> rXh;
  private m<? super View, ? super FinderCommentInfo, y> rXi;
  private long rXj;
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168349);
    setOrientation(1);
    paramContext = z.jD(getContext()).inflate(2131496185, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299883);
    d.g.b.k.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.rXd = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299885);
    d.g.b.k.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.rHK = paramAttributeSet;
    paramContext = paramContext.findViewById(2131299884);
    d.g.b.k.g(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.gAt = ((TextView)paramContext);
    aj.a((Paint)this.gAt.getPaint(), 0.8F);
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.rXc = new ArrayList();
    AppMethodBeat.o(168349);
  }
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168350);
    setOrientation(1);
    paramContext = z.jD(getContext()).inflate(2131496185, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299883);
    d.g.b.k.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.rXd = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299885);
    d.g.b.k.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.rHK = paramAttributeSet;
    paramContext = paramContext.findViewById(2131299884);
    d.g.b.k.g(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.gAt = ((TextView)paramContext);
    aj.a((Paint)this.gAt.getPaint(), 0.8F);
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.rXc = new ArrayList();
    AppMethodBeat.o(168350);
  }
  
  private final void a(SpannableStringBuilder paramSpannableStringBuilder, FinderCommentInfo paramFinderCommentInfo, d.g.a.b<? super String, y> paramb, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204160);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czi())
    {
      paramFinderCommentInfo = paramFinderCommentInfo.username;
      d.g.b.k.g(paramFinderCommentInfo, "comment.username");
      localObject = getContext();
      d.g.b.k.g(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(2131099773);
      localObject = getContext();
      d.g.b.k.g(localObject, "context");
      paramSpannableStringBuilder.setSpan(new g(paramFinderCommentInfo, i, ((Context)localObject).getResources().getColor(2131099658), true, paramb), paramInt1, paramInt2, 17);
      a(parama, (Spannable)paramSpannableStringBuilder);
    }
    AppMethodBeat.o(204160);
  }
  
  private final void a(a parama, Spannable paramSpannable)
  {
    AppMethodBeat.i(168346);
    paramSpannable = (View.OnTouchListener)new FinderFeedExposeLayout.l(this, paramSpannable, parama);
    parama.nMU.setOnTouchListener(paramSpannable);
    AppMethodBeat.o(168346);
  }
  
  private static boolean b(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(178493);
    n localn = n.rPN;
    boolean bool = n.EF(paramFinderCommentInfo.displayFlag);
    AppMethodBeat.o(178493);
    return bool;
  }
  
  private final void cER()
  {
    AppMethodBeat.i(168348);
    this.rHK.setVisibility(8);
    this.gAt.setVisibility(8);
    AppMethodBeat.o(168348);
  }
  
  private final void f(LinkedList<FinderCommentInfo> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(168344);
    EQ(paramInt);
    if (paramLinkedList.size() == 0)
    {
      this.rXd.setVisibility(8);
      AppMethodBeat.o(168344);
      return;
    }
    this.rXd.setVisibility(0);
    paramInt = this.rXc.size();
    int i = paramLinkedList.size();
    Object localObject2;
    while (paramInt < i)
    {
      localObject1 = z.jD(getContext()).inflate(2131495755, null);
      localObject2 = this.rXc;
      d.g.b.k.g(localObject1, "view");
      ((ArrayList)localObject2).add(new a((View)localObject1));
      if (paramInt == paramLinkedList.size() - 1) {
        ((View)localObject1).setPadding(((View)localObject1).getPaddingLeft(), ((View)localObject1).getPaddingTop(), ((View)localObject1).getPaddingRight(), 0);
      }
      this.rXd.addView((View)localObject1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
      paramInt += 1;
    }
    Object localObject1 = ((Iterable)this.rXc).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((a)((Iterator)localObject1).next()).asD.setVisibility(8);
    }
    ac.i(this.TAG, "fillCommentsLayout");
    paramLinkedList = (Iterable)paramLinkedList;
    paramInt = 0;
    localObject1 = paramLinkedList.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      paramLinkedList = ((Iterator)localObject1).next();
      if (paramInt < 0) {
        d.a.j.fOc();
      }
      localObject2 = (FinderCommentInfo)paramLinkedList;
      paramLinkedList = this.rXc.get(paramInt);
      d.g.b.k.g(paramLinkedList, "viewHolderList[index]");
      a locala = (a)paramLinkedList;
      locala.asD.setVisibility(0);
      Object localObject3 = (d.g.a.b)new b(this);
      locala.nMU.setOnTouchListener(null);
      if (((FinderCommentInfo)localObject2).replyCommentId == 0L)
      {
        paramLinkedList = com.tencent.mm.plugin.finder.convert.a.qZF;
        paramLinkedList = locala.nMU;
        d.g.b.k.g(paramLinkedList, "holder.nicknameTv");
        paramLinkedList = paramLinkedList.getPaint();
        d.g.b.k.g(paramLinkedList, "holder.nicknameTv.paint");
        localObject4 = ((FinderCommentInfo)localObject2).nickname;
        Object localObject5 = com.tencent.mm.plugin.finder.convert.a.qZF;
        localObject5 = getContext();
        d.g.b.k.g(localObject5, "context");
        com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
        i = com.tencent.mm.plugin.finder.convert.a.U((Context)localObject5, com.tencent.mm.plugin.finder.storage.b.czJ());
        localObject5 = com.tencent.mm.plugin.finder.convert.a.qZF;
        localObject5 = getContext();
        d.g.b.k.g(localObject5, "context");
        localb = com.tencent.mm.plugin.finder.storage.b.rCU;
        paramLinkedList = com.tencent.mm.plugin.finder.convert.a.a(paramLinkedList, (String)localObject4, i, com.tencent.mm.plugin.finder.convert.a.U((Context)localObject5, com.tencent.mm.plugin.finder.storage.b.czJ() + 1));
        paramLinkedList = new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)paramLinkedList));
        if ((!bs.isNullOrNil(((FinderCommentInfo)localObject2).username)) && (b((FinderCommentInfo)localObject2))) {
          a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.e.rXl, locala, 0, paramLinkedList.length());
        }
        for (;;)
        {
          paramLinkedList.append((CharSequence)getContext().getString(2131759161)).append((CharSequence)com.tencent.mm.plugin.finder.model.j.a((FinderCommentInfo)localObject2));
          localObject3 = locala.nMU;
          d.g.b.k.g(localObject3, "holder.nicknameTv");
          ((TextView)localObject3).setText((CharSequence)paramLinkedList);
          paramLinkedList = locala.nMU;
          d.g.b.k.g(paramLinkedList, "holder.nicknameTv");
          paramLinkedList.setTag(((FinderCommentInfo)localObject2).username);
          locala.asD.setOnClickListener((View.OnClickListener)new c((FinderCommentInfo)localObject2, this));
          locala.asD.setOnLongClickListener((View.OnLongClickListener)new d((FinderCommentInfo)localObject2, this));
          paramInt += 1;
          break;
          localObject4 = ((FinderCommentInfo)localObject2).username;
          d.g.b.k.g(localObject4, "comment.username");
          if (isFriend((String)localObject4))
          {
            a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
          }
          else
          {
            localObject4 = n.rPN;
            if (n.aeE(((FinderCommentInfo)localObject2).username)) {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
            } else {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.f.rXm, locala, 0, paramLinkedList.length());
            }
          }
        }
      }
      Object localObject4 = getContext();
      paramLinkedList = ((FinderCommentInfo)localObject2).nickname;
      label744:
      int j;
      label907:
      if (paramLinkedList != null)
      {
        paramLinkedList = (CharSequence)paramLinkedList;
        paramLinkedList = new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject4, paramLinkedList));
        if (!b((FinderCommentInfo)localObject2)) {
          break label1000;
        }
        a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.g.rXn, locala, 0, paramLinkedList.length());
        label789:
        if ((!bs.aj((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)((FinderCommentInfo)localObject2).replyNickname))) && (((FinderCommentInfo)localObject2).replyCommentId != 0L))
        {
          paramLinkedList.append((CharSequence)(" " + getContext().getString(2131759169) + ' '));
          localObject4 = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)((FinderCommentInfo)localObject2).replyNickname);
          j = paramLinkedList.length();
          paramLinkedList.append((CharSequence)localObject4);
          if ((((FinderCommentInfo)localObject2).displayFlag & 0x4) == 0) {
            break label1099;
          }
          i = 1;
          if (i == 0) {
            break label1104;
          }
          a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.i.rXp, locala, j, paramLinkedList.length());
        }
      }
      for (;;)
      {
        paramLinkedList.append((CharSequence)getContext().getString(2131759161));
        paramLinkedList.append((CharSequence)com.tencent.mm.plugin.finder.model.j.a((FinderCommentInfo)localObject2));
        localObject3 = locala.nMU;
        d.g.b.k.g(localObject3, "holder.nicknameTv");
        ((TextView)localObject3).setText((CharSequence)paramLinkedList);
        break;
        paramLinkedList = (CharSequence)"";
        break label744;
        label1000:
        localObject4 = ((FinderCommentInfo)localObject2).username;
        d.g.b.k.g(localObject4, "comment.username");
        if (isFriend((String)localObject4))
        {
          a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
          break label789;
        }
        localObject4 = n.rPN;
        if (n.aeE(((FinderCommentInfo)localObject2).username))
        {
          a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
          break label789;
        }
        a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.h.rXo, locala, 0, paramLinkedList.length());
        break label789;
        label1099:
        i = 0;
        break label907;
        label1104:
        localObject4 = ((FinderCommentInfo)localObject2).reply_username;
        d.g.b.k.g(localObject4, "comment.reply_username");
        if (isFriend((String)localObject4))
        {
          a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, j, paramLinkedList.length());
        }
        else
        {
          localObject4 = n.rPN;
          if (n.aeE(((FinderCommentInfo)localObject2).reply_username)) {
            a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, j, paramLinkedList.length());
          } else {
            a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.j.rXq, locala, j, paramLinkedList.length());
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
  
  public final void EQ(int paramInt)
  {
    AppMethodBeat.i(168343);
    Object localObject;
    if (paramInt > 0)
    {
      localObject = this.rXe;
      if (localObject == null) {
        d.g.b.k.aVY("seeAllCommentsTv");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.rXe;
      if (localObject == null) {
        d.g.b.k.aVY("seeAllCommentsTv");
      }
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.g.fD(2, paramInt));
    }
    for (;;)
    {
      localObject = this.rXf;
      if (localObject == null) {
        d.g.b.k.aVY("commentIconContainer");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new m(this));
      AppMethodBeat.o(168343);
      return;
      localObject = this.rXe;
      if (localObject == null) {
        d.g.b.k.aVY("seeAllCommentsTv");
      }
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public final void a(View paramView, FinderItem paramFinderItem, LinkedList<FinderCommentInfo> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, m<? super FinderCommentInfo, ? super Boolean, y> paramm)
  {
    AppMethodBeat.i(204159);
    d.g.b.k.h(paramView, "feedConvert");
    d.g.b.k.h(paramFinderItem, "feed");
    d.g.b.k.h(paramLinkedList, "commentList");
    d.g.b.k.h(paramm, "likeClickListener");
    ac.i(this.TAG, "setExposeInfo " + paramFinderItem.getId() + ", commentList size: " + paramLinkedList.size() + ", totalCommentCount: " + paramInt1 + ", totalLikeCount: " + paramInt2 + ", friendLikeCount: " + paramInt3);
    this.feed = paramFinderItem;
    this.rXg = paramm;
    paramm = paramView.findViewById(2131298511);
    d.g.b.k.g(paramm, "feedConvert.findViewById(R.id.comment_count_tv)");
    this.rXe = ((TextView)paramm);
    paramView = paramView.findViewById(2131298522);
    d.g.b.k.g(paramView, "feedConvert.findViewById…d.comment_icon_container)");
    this.rXf = paramView;
    paramView = this.rXe;
    if (paramView == null) {
      d.g.b.k.aVY("seeAllCommentsTv");
    }
    aj.a((Paint)paramView.getPaint(), 0.8F);
    if (paramFinderItem.isCommentClose())
    {
      paramView = n.rPN;
      if (!n.aeD(paramFinderItem.field_username)) {
        paramInt1 = 0;
      }
    }
    for (paramView = new LinkedList();; paramView = paramLinkedList)
    {
      paramFinderItem = (List)paramView;
      if (paramFinderItem.size() > 1) {
        d.a.j.a(paramFinderItem, (Comparator)new k());
      }
      cER();
      f(paramView, paramInt1);
      AppMethodBeat.o(204159);
      return;
    }
  }
  
  public final View getCommentIconContainer()
  {
    AppMethodBeat.i(204158);
    View localView = this.rXf;
    if (localView == null) {
      d.g.b.k.aVY("commentIconContainer");
    }
    AppMethodBeat.o(204158);
    return localView;
  }
  
  public final LinearLayout getCommentsLayout()
  {
    return this.rXd;
  }
  
  public final m<View, FinderCommentInfo, y> getOnCommentClickListener()
  {
    return this.rXh;
  }
  
  public final m<View, FinderCommentInfo, y> getOnCommentLongClickListener()
  {
    return this.rXi;
  }
  
  public final TextView getSeeAllCommentsTv()
  {
    AppMethodBeat.i(204157);
    TextView localTextView = this.rXe;
    if (localTextView == null) {
      d.g.b.k.aVY("seeAllCommentsTv");
    }
    AppMethodBeat.o(204157);
    return localTextView;
  }
  
  public final void setCommentIconContainer(View paramView)
  {
    AppMethodBeat.i(178492);
    d.g.b.k.h(paramView, "<set-?>");
    this.rXf = paramView;
    AppMethodBeat.o(178492);
  }
  
  public final void setCommentsLayout(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(168340);
    d.g.b.k.h(paramLinearLayout, "<set-?>");
    this.rXd = paramLinearLayout;
    AppMethodBeat.o(168340);
  }
  
  public final void setOnCommentClickListener(m<? super View, ? super FinderCommentInfo, y> paramm)
  {
    this.rXh = paramm;
  }
  
  public final void setOnCommentLongClickListener(m<? super View, ? super FinderCommentInfo, y> paramm)
  {
    this.rXi = paramm;
  }
  
  public final void setSeeAllCommentsTv(TextView paramTextView)
  {
    AppMethodBeat.i(168341);
    d.g.b.k.h(paramTextView, "<set-?>");
    this.rXe = paramTextView;
    AppMethodBeat.o(168341);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "nicknameTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getNicknameTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
  public final class a
  {
    final View asD;
    final TextView nMU;
    
    public a()
    {
      AppMethodBeat.i(168333);
      this.asD = localObject;
      this.nMU = ((TextView)this.asD.findViewById(2131302863));
      AppMethodBeat.o(168333);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "username", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$onFriendClick$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    b(FinderFeedExposeLayout paramFinderFeedExposeLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$7"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168335);
      long l = System.currentTimeMillis();
      ac.d(FinderFeedExposeLayout.b(jdField_this), "lastClickExposeCommentTime " + FinderFeedExposeLayout.c(jdField_this) + ", curTime:" + l);
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
        localm.n(paramView, this.rau);
        AppMethodBeat.o(168335);
        return;
      }
      AppMethodBeat.o(168335);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$8"})
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
        localm.n(paramView, this.rau);
      }
      AppMethodBeat.o(168336);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class k<T>
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168339);
      paramView = FinderFeedExposeLayout.a(this.rXk);
      if ((paramView != null) && (paramView.isCommentClose() == true)) {
        this.rXk.getSeeAllCommentsTv().setVisibility(8);
      }
      paramView = this.rXk.getOnCommentClickListener();
      if (paramView != null)
      {
        paramView.n(this.rXk.getSeeAllCommentsTv(), null);
        AppMethodBeat.o(168339);
        return;
      }
      AppMethodBeat.o(168339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout
 * JD-Core Version:    0.7.0.1
 */