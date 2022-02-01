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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "COMMENT_FRIEND_CAN_CLICK_VALUE", "", "LIKE_COMMENT_EDU_VALUE", "MAX_COMMENT_COUNT", "getMAX_COMMENT_COUNT", "()I", "MAX_COMMENT_NAME_COUNT_VALUE", "REAL_NAME_LIKE_AVATAR_RADIUS_VALUE", "TAG", "", "commentIconContainer", "Landroid/view/View;", "getCommentIconContainer", "()Landroid/view/View;", "setCommentIconContainer", "(Landroid/view/View;)V", "commentsLayout", "getCommentsLayout", "()Landroid/widget/LinearLayout;", "setCommentsLayout", "(Landroid/widget/LinearLayout;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "lastClickExposeCommentTime", "", "likeClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Lkotlin/ParameterName;", "name", "comment", "isLike", "", "likeLayout", "likeTv", "Landroid/widget/TextView;", "onCommentClickListener", "view", "getOnCommentClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnCommentClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onCommentLongClickListener", "getOnCommentLongClickListener", "setOnCommentLongClickListener", "seeAllCommentsTv", "getSeeAllCommentsTv", "()Landroid/widget/TextView;", "setSeeAllCommentsTv", "(Landroid/widget/TextView;)V", "viewHolderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "Lkotlin/collections/ArrayList;", "attachStyle", "contentBuilder", "Landroid/text/SpannableStringBuilder;", "onFriendClick", "Lkotlin/Function1;", "holder", "start", "end", "fillCommentsLayout", "list", "Ljava/util/LinkedList;", "totalCommentCount", "fillLikeTv", "totalLikeCount", "friendLikeCount", "isFriend", "username", "isPoster", "isReplyPoster", "isSelf", "setExposeInfo", "feedConvert", "commentList", "setSpanTouch", "text", "Landroid/text/Spannable;", "updateCommentCount", "ViewHolder", "plugin-finder_release"})
public final class FinderFeedExposeLayout
  extends LinearLayout
{
  private final int AXj;
  private final int AXk;
  private final int AXl;
  private final boolean AXm;
  private final ArrayList<a> AXn;
  private LinearLayout AXo;
  public TextView AXp;
  public View AXq;
  private kotlin.g.a.m<? super FinderCommentInfo, ? super Boolean, x> AXr;
  private kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> AXs;
  private kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> AXt;
  private final int AXu;
  private long AXv;
  private View AqZ;
  private final String TAG;
  private TextView kEc;
  private FinderItem xpY;
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168349);
    setOrientation(1);
    paramContext = ad.kS(getContext()).inflate(b.g.finder_feed_expose_view_new, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(b.f.feed_expose_comment);
    p.j(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.AXo = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.feed_expose_like_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.AqZ = paramAttributeSet;
    paramContext = paramContext.findViewById(b.f.feed_expose_like);
    p.j(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.kEc = ((TextView)paramContext);
    ar.a((Paint)this.kEc.getPaint(), 0.8F);
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AXj = ((Number)com.tencent.mm.plugin.finder.storage.d.dVF().aSr()).intValue();
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AXk = ((Number)com.tencent.mm.plugin.finder.storage.d.dTF().aSr()).intValue();
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AXl = com.tencent.mm.plugin.finder.storage.d.dTn();
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AXm = com.tencent.mm.plugin.finder.storage.d.dTb();
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.AXn = new ArrayList();
    this.AXu = 3;
    AppMethodBeat.o(168349);
  }
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168350);
    setOrientation(1);
    paramContext = ad.kS(getContext()).inflate(b.g.finder_feed_expose_view_new, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(b.f.feed_expose_comment);
    p.j(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.AXo = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.feed_expose_like_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.AqZ = paramAttributeSet;
    paramContext = paramContext.findViewById(b.f.feed_expose_like);
    p.j(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.kEc = ((TextView)paramContext);
    ar.a((Paint)this.kEc.getPaint(), 0.8F);
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AXj = ((Number)com.tencent.mm.plugin.finder.storage.d.dVF().aSr()).intValue();
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AXk = ((Number)com.tencent.mm.plugin.finder.storage.d.dTF().aSr()).intValue();
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AXl = com.tencent.mm.plugin.finder.storage.d.dTn();
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AXm = com.tencent.mm.plugin.finder.storage.d.dTb();
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.AXn = new ArrayList();
    this.AXu = 3;
    AppMethodBeat.o(168350);
  }
  
  private final void a(SpannableStringBuilder paramSpannableStringBuilder, FinderCommentInfo paramFinderCommentInfo, kotlin.g.a.b<? super String, x> paramb, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(289621);
    if (this.AXm)
    {
      Object localObject = paramFinderCommentInfo.username;
      paramFinderCommentInfo = (FinderCommentInfo)localObject;
      if (localObject == null) {
        paramFinderCommentInfo = "";
      }
      localObject = getContext();
      p.j(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(b.c.Link_80);
      localObject = getContext();
      p.j(localObject, "context");
      paramSpannableStringBuilder.setSpan(new o(paramFinderCommentInfo, i, ((Context)localObject).getResources().getColor(b.c.BW_0_Alpha_0_2), true, false, paramb), paramInt1, paramInt2, 17);
      a(parama, (Spannable)paramSpannableStringBuilder);
    }
    AppMethodBeat.o(289621);
  }
  
  private final void a(a parama, Spannable paramSpannable)
  {
    AppMethodBeat.i(168346);
    paramSpannable = (View.OnTouchListener)new FinderFeedExposeLayout.m(this, paramSpannable, parama);
    parama.xoK.setOnTouchListener(paramSpannable);
    AppMethodBeat.o(168346);
  }
  
  private static boolean b(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(178493);
    aj localaj = aj.AGc;
    boolean bool = aj.QU(paramFinderCommentInfo.displayFlag);
    AppMethodBeat.o(178493);
    return bool;
  }
  
  private static boolean c(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(289622);
    aj localaj = aj.AGc;
    boolean bool = aj.QV(paramFinderCommentInfo.extFlag);
    AppMethodBeat.o(289622);
    return bool;
  }
  
  private final void g(LinkedList<FinderCommentInfo> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(168344);
    RE(paramInt);
    if (paramLinkedList.size() == 0)
    {
      this.AXo.setVisibility(8);
      AppMethodBeat.o(168344);
      return;
    }
    this.AXo.setVisibility(0);
    Object localObject1 = this.AXo;
    Object localObject2 = getContext();
    p.j(localObject2, "context");
    ((LinearLayout)localObject1).setDividerDrawable(((Context)localObject2).getResources().getDrawable(b.e.finder_comment_expose_divider_shape));
    this.AXo.setShowDividers(2);
    localObject1 = this.AXo;
    localObject2 = getContext();
    p.j(localObject2, "context");
    ((LinearLayout)localObject1).setDividerPadding(((Context)localObject2).getResources().getDimensionPixelSize(b.d.Edge_A));
    paramInt = this.AXn.size();
    int i = Math.max(paramLinkedList.size(), this.AXu);
    while (paramInt < i)
    {
      localObject1 = ad.kS(getContext()).inflate(b.g.timeline_comment_view, null);
      localObject2 = this.AXn;
      p.j(localObject1, "view");
      ((ArrayList)localObject2).add(new a((View)localObject1));
      this.AXo.addView((View)localObject1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
      paramInt += 1;
    }
    localObject1 = ((Iterable)this.AXn).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((a)((Iterator)localObject1).next()).amk.setVisibility(8);
    }
    Log.i(this.TAG, "fillCommentsLayout");
    paramLinkedList = (Iterable)paramLinkedList;
    paramInt = 0;
    localObject1 = paramLinkedList.iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        paramLinkedList = ((Iterator)localObject1).next();
        i = paramInt + 1;
        if (paramInt < 0) {
          j.iBO();
        }
        localObject2 = (FinderCommentInfo)paramLinkedList;
        if (paramInt < this.AXu)
        {
          paramLinkedList = this.AXn.get(paramInt);
          p.j(paramLinkedList, "viewHolderList[index]");
          a locala = (a)paramLinkedList;
          locala.amk.setVisibility(0);
          Object localObject3 = (kotlin.g.a.b)new b(this);
          locala.xoK.setOnTouchListener(null);
          if (this.AXj == 1)
          {
            paramLinkedList = locala.xoK;
            p.j(paramLinkedList, "holder.nicknameTv");
            paramLinkedList.setMaxLines(2);
          }
          Object localObject4;
          Object localObject5;
          if (((FinderCommentInfo)localObject2).replyCommentId == 0L)
          {
            paramLinkedList = com.tencent.mm.plugin.finder.convert.d.xgJ;
            paramLinkedList = locala.xoK;
            p.j(paramLinkedList, "holder.nicknameTv");
            paramLinkedList = paramLinkedList.getPaint();
            p.j(paramLinkedList, "holder.nicknameTv.paint");
            localObject4 = ((FinderCommentInfo)localObject2).nickname;
            localObject5 = com.tencent.mm.plugin.finder.convert.d.xgJ;
            localObject5 = getContext();
            p.j(localObject5, "context");
            paramInt = com.tencent.mm.plugin.finder.convert.d.ae((Context)localObject5, this.AXl);
            localObject5 = com.tencent.mm.plugin.finder.convert.d.xgJ;
            localObject5 = getContext();
            p.j(localObject5, "context");
            paramLinkedList = com.tencent.mm.plugin.finder.convert.d.a(paramLinkedList, (String)localObject4, paramInt, com.tencent.mm.plugin.finder.convert.d.ae((Context)localObject5, this.AXl + 1));
            paramLinkedList = new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)paramLinkedList));
            if ((!Util.isNullOrNil(((FinderCommentInfo)localObject2).username)) && (b((FinderCommentInfo)localObject2)))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)e.AXy, locala, 0, paramLinkedList.length());
              label588:
              paramLinkedList.append((CharSequence)getContext().getString(b.j.finder_comment_colon)).append((CharSequence)com.tencent.mm.plugin.finder.model.o.a((FinderCommentInfo)localObject2));
              localObject3 = locala.xoK;
              p.j(localObject3, "holder.nicknameTv");
              ((TextView)localObject3).setText((CharSequence)paramLinkedList);
              if (!c((FinderCommentInfo)localObject2)) {
                break label1426;
              }
              paramLinkedList = locala.AXw;
              p.j(paramLinkedList, "holder.headerIv");
              paramLinkedList.setVisibility(0);
              if (this.AXk != 1) {
                break label1367;
              }
              paramLinkedList = t.ztT;
              paramLinkedList = t.dJi();
              localObject3 = new e(((FinderCommentInfo)localObject2).headUrl);
              localObject4 = locala.AXw;
              p.j(localObject4, "holder.headerIv");
              localObject5 = t.ztT;
              paramLinkedList.a(localObject3, (ImageView)localObject4, t.a(t.a.ztZ));
              label731:
              paramLinkedList = locala.xoK;
              p.j(paramLinkedList, "holder.nicknameTv");
              paramLinkedList.setMaxLines(1);
            }
          }
          for (;;)
          {
            paramLinkedList = locala.xoK;
            p.j(paramLinkedList, "holder.nicknameTv");
            paramLinkedList.setTag(((FinderCommentInfo)localObject2).username);
            locala.amk.setOnClickListener((View.OnClickListener)new c((FinderCommentInfo)localObject2, this));
            locala.amk.setOnLongClickListener((View.OnLongClickListener)new d((FinderCommentInfo)localObject2, this));
            paramInt = i;
            break;
            if (isFriend(((FinderCommentInfo)localObject2).username))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)localObject3, locala, 0, paramLinkedList.length());
              break label588;
            }
            localObject4 = aj.AGc;
            if (aj.aFJ(((FinderCommentInfo)localObject2).username))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)localObject3, locala, 0, paramLinkedList.length());
              break label588;
            }
            a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)f.AXz, locala, 0, paramLinkedList.length());
            break label588;
            localObject4 = getContext();
            paramLinkedList = ((FinderCommentInfo)localObject2).nickname;
            label927:
            label972:
            int j;
            if (paramLinkedList != null)
            {
              paramLinkedList = (CharSequence)paramLinkedList;
              paramLinkedList = new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject4, paramLinkedList));
              if (!b((FinderCommentInfo)localObject2)) {
                break label1183;
              }
              a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)g.AXA, locala, 0, paramLinkedList.length());
              if ((!Util.isNullOrNil((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)((FinderCommentInfo)localObject2).replyNickname))) && (((FinderCommentInfo)localObject2).replyCommentId != 0L))
              {
                paramLinkedList.append((CharSequence)(" " + getContext().getString(b.j.finder_comment_reply) + ' '));
                localObject4 = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)((FinderCommentInfo)localObject2).replyNickname);
                j = paramLinkedList.length();
                paramLinkedList.append((CharSequence)localObject4);
                if ((((FinderCommentInfo)localObject2).displayFlag & 0x4) == 0) {
                  break label1271;
                }
                paramInt = 1;
                label1090:
                if (paramInt == 0) {
                  break label1276;
                }
                a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)i.AXC, locala, j, paramLinkedList.length());
              }
            }
            for (;;)
            {
              paramLinkedList.append((CharSequence)getContext().getString(b.j.finder_comment_colon));
              paramLinkedList.append((CharSequence)com.tencent.mm.plugin.finder.model.o.a((FinderCommentInfo)localObject2));
              localObject3 = locala.xoK;
              p.j(localObject3, "holder.nicknameTv");
              ((TextView)localObject3).setText((CharSequence)paramLinkedList);
              break;
              paramLinkedList = (CharSequence)"";
              break label927;
              label1183:
              if (isFriend(((FinderCommentInfo)localObject2).username))
              {
                a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)localObject3, locala, 0, paramLinkedList.length());
                break label972;
              }
              localObject4 = aj.AGc;
              if (aj.aFJ(((FinderCommentInfo)localObject2).username))
              {
                a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)localObject3, locala, 0, paramLinkedList.length());
                break label972;
              }
              a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)h.AXB, locala, 0, paramLinkedList.length());
              break label972;
              label1271:
              paramInt = 0;
              break label1090;
              label1276:
              if (isFriend(((FinderCommentInfo)localObject2).reply_username))
              {
                a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)localObject3, locala, j, paramLinkedList.length());
              }
              else
              {
                localObject4 = aj.AGc;
                if (aj.aFJ(((FinderCommentInfo)localObject2).reply_username)) {
                  a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)localObject3, locala, j, paramLinkedList.length());
                } else {
                  a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)j.AXD, locala, j, paramLinkedList.length());
                }
              }
            }
            label1367:
            paramLinkedList = t.ztT;
            paramLinkedList = t.dJh();
            localObject3 = new e(((FinderCommentInfo)localObject2).headUrl);
            localObject4 = locala.AXw;
            p.j(localObject4, "holder.headerIv");
            localObject5 = t.ztT;
            paramLinkedList.a(localObject3, (ImageView)localObject4, t.a(t.a.ztX));
            break label731;
            label1426:
            paramLinkedList = locala.AXw;
            p.j(paramLinkedList, "holder.headerIv");
            paramLinkedList.setVisibility(8);
          }
        }
      }
      else
      {
        AppMethodBeat.o(168344);
        return;
      }
      paramInt = i;
    }
  }
  
  private static boolean isFriend(String paramString)
  {
    AppMethodBeat.i(168347);
    boolean bool = ((PluginFinder)h.ag(PluginFinder.class)).isFriend(paramString);
    AppMethodBeat.o(168347);
    return bool;
  }
  
  public final void RE(int paramInt)
  {
    AppMethodBeat.i(168343);
    Object localObject;
    if (paramInt > 0)
    {
      localObject = this.AXp;
      if (localObject == null) {
        p.bGy("seeAllCommentsTv");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.AXp;
      if (localObject == null) {
        p.bGy("seeAllCommentsTv");
      }
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.m.gY(2, paramInt));
      localObject = this.AXp;
      if (localObject == null) {
        p.bGy("seeAllCommentsTv");
      }
      ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
    }
    for (;;)
    {
      localObject = this.AXq;
      if (localObject == null) {
        p.bGy("commentIconContainer");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new n(this));
      AppMethodBeat.o(168343);
      return;
      localObject = this.AXp;
      if (localObject == null) {
        p.bGy("seeAllCommentsTv");
      }
      ((TextView)localObject).setText((CharSequence)getContext().getString(b.j.finder_comment_count_text));
      localObject = this.AXp;
      if (localObject == null) {
        p.bGy("seeAllCommentsTv");
      }
      ar.b((Paint)((TextView)localObject).getPaint());
    }
  }
  
  public final void a(View paramView, FinderItem paramFinderItem, LinkedList<FinderCommentInfo> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, kotlin.g.a.m<? super FinderCommentInfo, ? super Boolean, x> paramm)
  {
    AppMethodBeat.i(289620);
    p.k(paramView, "feedConvert");
    p.k(paramFinderItem, "feed");
    p.k(paramLinkedList, "commentList");
    p.k(paramm, "likeClickListener");
    Log.i(this.TAG, "setExposeInfo " + paramFinderItem.getId() + ", commentList size: " + paramLinkedList.size() + ", totalCommentCount: " + paramInt1 + ", totalLikeCount: " + paramInt2 + ", friendLikeCount: " + paramInt3);
    this.xpY = paramFinderItem;
    this.AXr = paramm;
    paramm = paramView.findViewById(b.f.feed_comment_count_tv);
    p.j(paramm, "feedConvert.findViewById…id.feed_comment_count_tv)");
    this.AXp = ((TextView)paramm);
    paramView = paramView.findViewById(b.f.comment_icon_container);
    p.j(paramView, "feedConvert.findViewById…d.comment_icon_container)");
    this.AXq = paramView;
    if (paramFinderItem.isCommentClose())
    {
      paramView = aj.AGc;
      if (!aj.PE(paramFinderItem.field_username))
      {
        paramInt1 = 0;
        paramView = new LinkedList();
      }
    }
    for (;;)
    {
      paramFinderItem = (List)paramView;
      if (paramFinderItem.size() > 1) {
        j.a(paramFinderItem, (Comparator)new l());
      }
      this.AqZ.setVisibility(8);
      this.kEc.setVisibility(8);
      g(paramView, paramInt1);
      AppMethodBeat.o(289620);
      return;
      if (this.AXj == 1)
      {
        paramView = (List)paramLinkedList;
        if (paramView.size() > 1) {
          j.a(paramView, (Comparator)new k());
        }
        paramView = new LinkedList();
        paramFinderItem = (Iterable)paramLinkedList;
        paramInt2 = 0;
        paramFinderItem = paramFinderItem.iterator();
        for (;;)
        {
          if (paramFinderItem.hasNext())
          {
            paramm = paramFinderItem.next();
            paramInt3 = paramInt2 + 1;
            if (paramInt2 < 0) {
              j.iBO();
            }
            paramm = (FinderCommentInfo)paramm;
            if (paramView.size() < this.AXu)
            {
              if ((c(paramm)) || (p.h(paramm.username, z.bcZ()))) {}
              for (paramInt2 = 1;; paramInt2 = 0)
              {
                if (paramInt2 != 0) {
                  paramView.add(paramm);
                }
                paramInt2 = paramInt3;
                break;
              }
            }
          }
          else
          {
            if (paramView.isEmpty())
            {
              paramFinderItem = (FinderCommentInfo)j.lp((List)paramLinkedList);
              if (paramFinderItem != null) {
                paramView.add(paramFinderItem);
              }
            }
            break;
          }
          paramInt2 = paramInt3;
        }
      }
      paramView = paramLinkedList;
    }
  }
  
  public final View getCommentIconContainer()
  {
    AppMethodBeat.i(289619);
    View localView = this.AXq;
    if (localView == null) {
      p.bGy("commentIconContainer");
    }
    AppMethodBeat.o(289619);
    return localView;
  }
  
  public final LinearLayout getCommentsLayout()
  {
    return this.AXo;
  }
  
  public final int getMAX_COMMENT_COUNT()
  {
    return this.AXu;
  }
  
  public final kotlin.g.a.m<View, FinderCommentInfo, x> getOnCommentClickListener()
  {
    return this.AXs;
  }
  
  public final kotlin.g.a.m<View, FinderCommentInfo, x> getOnCommentLongClickListener()
  {
    return this.AXt;
  }
  
  public final TextView getSeeAllCommentsTv()
  {
    AppMethodBeat.i(289618);
    TextView localTextView = this.AXp;
    if (localTextView == null) {
      p.bGy("seeAllCommentsTv");
    }
    AppMethodBeat.o(289618);
    return localTextView;
  }
  
  public final void setCommentIconContainer(View paramView)
  {
    AppMethodBeat.i(178492);
    p.k(paramView, "<set-?>");
    this.AXq = paramView;
    AppMethodBeat.o(178492);
  }
  
  public final void setCommentsLayout(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(168340);
    p.k(paramLinearLayout, "<set-?>");
    this.AXo = paramLinearLayout;
    AppMethodBeat.o(168340);
  }
  
  public final void setOnCommentClickListener(kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> paramm)
  {
    this.AXs = paramm;
  }
  
  public final void setOnCommentLongClickListener(kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> paramm)
  {
    this.AXt = paramm;
  }
  
  public final void setSeeAllCommentsTv(TextView paramTextView)
  {
    AppMethodBeat.i(168341);
    p.k(paramTextView, "<set-?>");
    this.AXp = paramTextView;
    AppMethodBeat.o(168341);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;Landroid/view/View;)V", "headerIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getHeaderIv", "()Landroid/widget/ImageView;", "getItemView", "()Landroid/view/View;", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
  public final class a
  {
    final ImageView AXw;
    final View amk;
    final TextView xoK;
    
    public a()
    {
      AppMethodBeat.i(168333);
      this.amk = localObject;
      this.xoK = ((TextView)this.amk.findViewById(b.f.nickname));
      this.AXw = ((ImageView)this.amk.findViewById(b.f.header_iv));
      AppMethodBeat.o(168333);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "username", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$onFriendClick$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, x>
  {
    b(FinderFeedExposeLayout paramFinderFeedExposeLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$7"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168335);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      long l = System.currentTimeMillis();
      Log.d(FinderFeedExposeLayout.b(jdField_this), "lastClickExposeCommentTime " + FinderFeedExposeLayout.c(jdField_this) + ", curTime:" + l);
      if (l - FinderFeedExposeLayout.c(jdField_this) < 1000L)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168335);
        return;
      }
      FinderFeedExposeLayout.a(jdField_this, l);
      localObject = jdField_this.getOnCommentClickListener();
      if (localObject != null)
      {
        p.j(paramView, "it");
        ((kotlin.g.a.m)localObject).invoke(paramView, this.xib);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168335);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$8"})
  static final class d
    implements View.OnLongClickListener
  {
    d(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(168336);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = jdField_this.getOnCommentLongClickListener();
      if (localObject != null)
      {
        p.j(paramView, "it");
        ((kotlin.g.a.m)localObject).invoke(paramView, this.xib);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(168336);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final e AXy;
    
    static
    {
      AppMethodBeat.i(285843);
      AXy = new e();
      AppMethodBeat.o(285843);
    }
    
    e()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final f AXz;
    
    static
    {
      AppMethodBeat.i(277620);
      AXz = new f();
      AppMethodBeat.o(277620);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final g AXA;
    
    static
    {
      AppMethodBeat.i(270679);
      AXA = new g();
      AppMethodBeat.o(270679);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final h AXB;
    
    static
    {
      AppMethodBeat.i(289775);
      AXB = new h();
      AppMethodBeat.o(289775);
    }
    
    h()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final i AXC;
    
    static
    {
      AppMethodBeat.i(227188);
      AXC = new i();
      AppMethodBeat.o(227188);
    }
    
    i()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final j AXD;
    
    static
    {
      AppMethodBeat.i(277353);
      AXD = new j();
      AppMethodBeat.o(277353);
    }
    
    j()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class k<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(168337);
      int i = kotlin.b.a.a((Comparable)Long.valueOf(((FinderCommentInfo)paramT2).displayid), (Comparable)Long.valueOf(((FinderCommentInfo)paramT1).displayid));
      AppMethodBeat.o(168337);
      return i;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class l<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(226919);
      int i = kotlin.b.a.a((Comparable)Long.valueOf(((FinderCommentInfo)paramT2).displayid), (Comparable)Long.valueOf(((FinderCommentInfo)paramT1).displayid));
      AppMethodBeat.o(226919);
      return i;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168339);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$updateCommentCount$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = FinderFeedExposeLayout.a(this.AXx);
      if ((paramView != null) && (paramView.isCommentClose() == true)) {
        this.AXx.getSeeAllCommentsTv().setVisibility(8);
      }
      paramView = this.AXx.getOnCommentClickListener();
      if (paramView != null) {
        paramView.invoke(this.AXx.getSeeAllCommentsTv(), null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$updateCommentCount$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout
 * JD-Core Version:    0.7.0.1
 */