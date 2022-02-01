package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "COMMENT_FRIEND_CAN_CLICK_VALUE", "", "LIKE_COMMENT_EDU_VALUE", "MAX_COMMENT_COUNT", "getMAX_COMMENT_COUNT", "()I", "MAX_COMMENT_NAME_COUNT_VALUE", "REAL_NAME_LIKE_AVATAR_RADIUS_VALUE", "TAG", "", "commentIconContainer", "Landroid/view/View;", "getCommentIconContainer", "()Landroid/view/View;", "setCommentIconContainer", "(Landroid/view/View;)V", "commentsLayout", "getCommentsLayout", "()Landroid/widget/LinearLayout;", "setCommentsLayout", "(Landroid/widget/LinearLayout;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "lastClickExposeCommentTime", "", "likeClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Lkotlin/ParameterName;", "name", "comment", "isLike", "", "likeLayout", "likeTv", "Landroid/widget/TextView;", "onCommentClickListener", "view", "getOnCommentClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnCommentClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onCommentLongClickListener", "getOnCommentLongClickListener", "setOnCommentLongClickListener", "seeAllCommentsTv", "getSeeAllCommentsTv", "()Landroid/widget/TextView;", "setSeeAllCommentsTv", "(Landroid/widget/TextView;)V", "viewHolderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "Lkotlin/collections/ArrayList;", "attachStyle", "contentBuilder", "Landroid/text/SpannableStringBuilder;", "onFriendClick", "Lkotlin/Function1;", "holder", "start", "end", "fillCommentsLayout", "list", "Ljava/util/LinkedList;", "totalCommentCount", "fillLikeTv", "totalLikeCount", "friendLikeCount", "isFriend", "username", "isPoster", "isReplyPoster", "isSelf", "setExposeInfo", "feedConvert", "commentList", "setSpanTouch", "text", "Landroid/text/Spannable;", "updateCommentCount", "ViewHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedExposeLayout
  extends LinearLayout
{
  private View FQD;
  private final int GyN;
  private final int GyO;
  private final int GyP;
  private final boolean GyQ;
  private final ArrayList<Object> GyR;
  private LinearLayout GyS;
  public TextView GyT;
  public View GyU;
  private m<? super View, ? super FinderCommentInfo, ah> GyV;
  private m<? super View, ? super FinderCommentInfo, ah> GyW;
  private final int GyX;
  private final String TAG;
  private TextView nhq;
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168349);
    setOrientation(1);
    paramContext = af.mU(getContext()).inflate(e.f.finder_feed_expose_view_new, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(e.e.feed_expose_comment);
    s.s(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.GyS = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(e.e.feed_expose_like_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.FQD = paramAttributeSet;
    paramContext = paramContext.findViewById(e.e.feed_expose_like);
    s.s(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.nhq = ((TextView)paramContext);
    aw.a((Paint)this.nhq.getPaint(), 0.8F);
    paramContext = d.FAy;
    this.GyN = ((Number)d.eUg().bmg()).intValue();
    paramContext = d.FAy;
    this.GyO = ((Number)d.eRW().bmg()).intValue();
    paramContext = d.FAy;
    this.GyP = d.eRC();
    paramContext = d.FAy;
    this.GyQ = d.eRq();
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.GyR = new ArrayList();
    this.GyX = 3;
    AppMethodBeat.o(168349);
  }
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168350);
    setOrientation(1);
    paramContext = af.mU(getContext()).inflate(e.f.finder_feed_expose_view_new, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(e.e.feed_expose_comment);
    s.s(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.GyS = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(e.e.feed_expose_like_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.FQD = paramAttributeSet;
    paramContext = paramContext.findViewById(e.e.feed_expose_like);
    s.s(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.nhq = ((TextView)paramContext);
    aw.a((Paint)this.nhq.getPaint(), 0.8F);
    paramContext = d.FAy;
    this.GyN = ((Number)d.eUg().bmg()).intValue();
    paramContext = d.FAy;
    this.GyO = ((Number)d.eRW().bmg()).intValue();
    paramContext = d.FAy;
    this.GyP = d.eRC();
    paramContext = d.FAy;
    this.GyQ = d.eRq();
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.GyR = new ArrayList();
    this.GyX = 3;
    AppMethodBeat.o(168350);
  }
  
  public final View getCommentIconContainer()
  {
    AppMethodBeat.i(344770);
    View localView = this.GyU;
    if (localView != null)
    {
      AppMethodBeat.o(344770);
      return localView;
    }
    s.bIx("commentIconContainer");
    AppMethodBeat.o(344770);
    return null;
  }
  
  public final LinearLayout getCommentsLayout()
  {
    return this.GyS;
  }
  
  public final int getMAX_COMMENT_COUNT()
  {
    return this.GyX;
  }
  
  public final m<View, FinderCommentInfo, ah> getOnCommentClickListener()
  {
    return this.GyV;
  }
  
  public final m<View, FinderCommentInfo, ah> getOnCommentLongClickListener()
  {
    return this.GyW;
  }
  
  public final TextView getSeeAllCommentsTv()
  {
    AppMethodBeat.i(344757);
    TextView localTextView = this.GyT;
    if (localTextView != null)
    {
      AppMethodBeat.o(344757);
      return localTextView;
    }
    s.bIx("seeAllCommentsTv");
    AppMethodBeat.o(344757);
    return null;
  }
  
  public final void setCommentIconContainer(View paramView)
  {
    AppMethodBeat.i(178492);
    s.u(paramView, "<set-?>");
    this.GyU = paramView;
    AppMethodBeat.o(178492);
  }
  
  public final void setCommentsLayout(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(168340);
    s.u(paramLinearLayout, "<set-?>");
    this.GyS = paramLinearLayout;
    AppMethodBeat.o(168340);
  }
  
  public final void setOnCommentClickListener(m<? super View, ? super FinderCommentInfo, ah> paramm)
  {
    this.GyV = paramm;
  }
  
  public final void setOnCommentLongClickListener(m<? super View, ? super FinderCommentInfo, ah> paramm)
  {
    this.GyW = paramm;
  }
  
  public final void setSeeAllCommentsTv(TextView paramTextView)
  {
    AppMethodBeat.i(168341);
    s.u(paramTextView, "<set-?>");
    this.GyT = paramTextView;
    AppMethodBeat.o(168341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout
 * JD-Core Version:    0.7.0.1
 */