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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import d.a.j;
import d.g.a.m;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MAX_COMMENT_COUNT", "getMAX_COMMENT_COUNT", "()I", "TAG", "", "commentIconContainer", "Landroid/view/View;", "getCommentIconContainer", "()Landroid/view/View;", "setCommentIconContainer", "(Landroid/view/View;)V", "commentsLayout", "getCommentsLayout", "()Landroid/widget/LinearLayout;", "setCommentsLayout", "(Landroid/widget/LinearLayout;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "lastClickExposeCommentTime", "", "likeClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Lkotlin/ParameterName;", "name", "comment", "", "isLike", "", "likeLayout", "likeTv", "Landroid/widget/TextView;", "onCommentClickListener", "view", "getOnCommentClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnCommentClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onCommentLongClickListener", "getOnCommentLongClickListener", "setOnCommentLongClickListener", "seeAllCommentsTv", "getSeeAllCommentsTv", "()Landroid/widget/TextView;", "setSeeAllCommentsTv", "(Landroid/widget/TextView;)V", "viewHolderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "Lkotlin/collections/ArrayList;", "attachStyle", "contentBuilder", "Landroid/text/SpannableStringBuilder;", "onFriendClick", "Lkotlin/Function1;", "holder", "start", "end", "fillCommentsLayout", "list", "Ljava/util/LinkedList;", "totalCommentCount", "fillLikeTv", "totalLikeCount", "friendLikeCount", "isFriend", "username", "isPoster", "isReplyPoster", "isSelf", "setExposeInfo", "feedConvert", "commentList", "setSpanTouch", "text", "Landroid/text/Spannable;", "updateCommentCount", "ViewHolder", "plugin-finder_release"})
public final class FinderFeedExposeLayout
  extends LinearLayout
{
  private final int Odk;
  private final String TAG;
  private FinderItem feed;
  private TextView gUd;
  private View sCI;
  private final ArrayList<a> sTU;
  private LinearLayout sTV;
  public TextView sTW;
  public View sTX;
  private m<? super FinderCommentInfo, ? super Boolean, d.z> sTY;
  private m<? super View, ? super FinderCommentInfo, d.z> sTZ;
  private m<? super View, ? super FinderCommentInfo, d.z> sUa;
  private long sUb;
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168349);
    setOrientation(1);
    paramContext = com.tencent.mm.ui.z.jO(getContext()).inflate(2131496185, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299883);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.sTV = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299885);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.sCI = paramAttributeSet;
    paramContext = paramContext.findViewById(2131299884);
    d.g.b.p.g(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.gUd = ((TextView)paramContext);
    al.a((Paint)this.gUd.getPaint(), 0.8F);
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.sTU = new ArrayList();
    this.Odk = 3;
    AppMethodBeat.o(168349);
  }
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168350);
    setOrientation(1);
    paramContext = com.tencent.mm.ui.z.jO(getContext()).inflate(2131496185, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299883);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.sTV = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299885);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.sCI = paramAttributeSet;
    paramContext = paramContext.findViewById(2131299884);
    d.g.b.p.g(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.gUd = ((TextView)paramContext);
    al.a((Paint)this.gUd.getPaint(), 0.8F);
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.sTU = new ArrayList();
    this.Odk = 3;
    AppMethodBeat.o(168350);
  }
  
  private final void a(SpannableStringBuilder paramSpannableStringBuilder, FinderCommentInfo paramFinderCommentInfo, d.g.a.b<? super String, d.z> paramb, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205133);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cGd())
    {
      paramFinderCommentInfo = paramFinderCommentInfo.username;
      d.g.b.p.g(paramFinderCommentInfo, "comment.username");
      localObject = getContext();
      d.g.b.p.g(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(2131099773);
      localObject = getContext();
      d.g.b.p.g(localObject, "context");
      paramSpannableStringBuilder.setSpan(new i(paramFinderCommentInfo, i, ((Context)localObject).getResources().getColor(2131099658), true, paramb), paramInt1, paramInt2, 17);
      a(parama, (Spannable)paramSpannableStringBuilder);
    }
    AppMethodBeat.o(205133);
  }
  
  private final void a(a parama, Spannable paramSpannable)
  {
    AppMethodBeat.i(168346);
    paramSpannable = (View.OnTouchListener)new FinderFeedExposeLayout.l(this, paramSpannable, parama);
    parama.opA.setOnTouchListener(paramSpannable);
    AppMethodBeat.o(168346);
  }
  
  private static boolean b(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(178493);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
    boolean bool = com.tencent.mm.plugin.finder.utils.p.FP(paramFinderCommentInfo.displayFlag);
    AppMethodBeat.o(178493);
    return bool;
  }
  
  private final void f(LinkedList<FinderCommentInfo> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(168344);
    Ge(paramInt);
    if (paramLinkedList.size() == 0)
    {
      this.sTV.setVisibility(8);
      AppMethodBeat.o(168344);
      return;
    }
    this.sTV.setVisibility(0);
    paramInt = this.sTU.size();
    int i = Math.max(paramLinkedList.size(), this.Odk);
    Object localObject2;
    while (paramInt < i)
    {
      localObject1 = com.tencent.mm.ui.z.jO(getContext()).inflate(2131495755, null);
      localObject2 = this.sTU;
      d.g.b.p.g(localObject1, "view");
      ((ArrayList)localObject2).add(new a((View)localObject1));
      this.sTV.addView((View)localObject1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
      paramInt += 1;
    }
    Object localObject1 = ((Iterable)this.sTU).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((a)((Iterator)localObject1).next()).auu.setVisibility(8);
    }
    ad.i(this.TAG, "fillCommentsLayout");
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
          j.gfB();
        }
        localObject2 = (FinderCommentInfo)paramLinkedList;
        if (paramInt < this.Odk)
        {
          paramLinkedList = this.sTU.get(paramInt);
          d.g.b.p.g(paramLinkedList, "viewHolderList[index]");
          a locala = (a)paramLinkedList;
          locala.auu.setVisibility(0);
          Object localObject3 = (d.g.a.b)new b(this);
          locala.opA.setOnTouchListener(null);
          paramLinkedList = com.tencent.mm.plugin.finder.storage.b.sxa;
          if (((Number)com.tencent.mm.plugin.finder.storage.b.eQq().value()).intValue() == 1)
          {
            paramLinkedList = locala.opA;
            d.g.b.p.g(paramLinkedList, "holder.nicknameTv");
            paramLinkedList.setMaxLines(2);
          }
          if (((FinderCommentInfo)localObject2).replyCommentId == 0L)
          {
            paramLinkedList = com.tencent.mm.plugin.finder.convert.a.rLR;
            paramLinkedList = locala.opA;
            d.g.b.p.g(paramLinkedList, "holder.nicknameTv");
            paramLinkedList = paramLinkedList.getPaint();
            d.g.b.p.g(paramLinkedList, "holder.nicknameTv.paint");
            localObject4 = ((FinderCommentInfo)localObject2).nickname;
            Object localObject5 = com.tencent.mm.plugin.finder.convert.a.rLR;
            localObject5 = getContext();
            d.g.b.p.g(localObject5, "context");
            com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
            paramInt = com.tencent.mm.plugin.finder.convert.a.U((Context)localObject5, com.tencent.mm.plugin.finder.storage.b.cGs());
            localObject5 = com.tencent.mm.plugin.finder.convert.a.rLR;
            localObject5 = getContext();
            d.g.b.p.g(localObject5, "context");
            localb = com.tencent.mm.plugin.finder.storage.b.sxa;
            paramLinkedList = com.tencent.mm.plugin.finder.convert.a.a(paramLinkedList, (String)localObject4, paramInt, com.tencent.mm.plugin.finder.convert.a.U((Context)localObject5, com.tencent.mm.plugin.finder.storage.b.cGs() + 1));
            paramLinkedList = new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)paramLinkedList));
            if ((!bt.isNullOrNil(((FinderCommentInfo)localObject2).username)) && (b((FinderCommentInfo)localObject2))) {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)e.sUd, locala, 0, paramLinkedList.length());
            }
            for (;;)
            {
              paramLinkedList.append((CharSequence)getContext().getString(2131759161)).append((CharSequence)com.tencent.mm.plugin.finder.model.k.a((FinderCommentInfo)localObject2));
              localObject3 = locala.opA;
              d.g.b.p.g(localObject3, "holder.nicknameTv");
              ((TextView)localObject3).setText((CharSequence)paramLinkedList);
              paramLinkedList = locala.opA;
              d.g.b.p.g(paramLinkedList, "holder.nicknameTv");
              paramLinkedList.setTag(((FinderCommentInfo)localObject2).username);
              locala.auu.setOnClickListener((View.OnClickListener)new c((FinderCommentInfo)localObject2, this));
              locala.auu.setOnLongClickListener((View.OnLongClickListener)new d((FinderCommentInfo)localObject2, this));
              paramInt = i;
              break;
              if (isFriend(((FinderCommentInfo)localObject2).username))
              {
                a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
              }
              else
              {
                localObject4 = com.tencent.mm.plugin.finder.utils.p.sMo;
                if (com.tencent.mm.plugin.finder.utils.p.aiY(((FinderCommentInfo)localObject2).username)) {
                  a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
                } else {
                  a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)f.sUe, locala, 0, paramLinkedList.length());
                }
              }
            }
          }
          Object localObject4 = getContext();
          paramLinkedList = ((FinderCommentInfo)localObject2).nickname;
          label759:
          int j;
          label922:
          if (paramLinkedList != null)
          {
            paramLinkedList = (CharSequence)paramLinkedList;
            paramLinkedList = new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject4, paramLinkedList));
            if (!b((FinderCommentInfo)localObject2)) {
              break label1015;
            }
            a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)g.sUf, locala, 0, paramLinkedList.length());
            label804:
            if ((!bt.ai((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)((FinderCommentInfo)localObject2).replyNickname))) && (((FinderCommentInfo)localObject2).replyCommentId != 0L))
            {
              paramLinkedList.append((CharSequence)(" " + getContext().getString(2131759169) + ' '));
              localObject4 = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)((FinderCommentInfo)localObject2).replyNickname);
              j = paramLinkedList.length();
              paramLinkedList.append((CharSequence)localObject4);
              if ((((FinderCommentInfo)localObject2).displayFlag & 0x4) == 0) {
                break label1103;
              }
              paramInt = 1;
              if (paramInt == 0) {
                break label1108;
              }
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)i.sUh, locala, j, paramLinkedList.length());
            }
          }
          for (;;)
          {
            paramLinkedList.append((CharSequence)getContext().getString(2131759161));
            paramLinkedList.append((CharSequence)com.tencent.mm.plugin.finder.model.k.a((FinderCommentInfo)localObject2));
            localObject3 = locala.opA;
            d.g.b.p.g(localObject3, "holder.nicknameTv");
            ((TextView)localObject3).setText((CharSequence)paramLinkedList);
            break;
            paramLinkedList = (CharSequence)"";
            break label759;
            label1015:
            if (isFriend(((FinderCommentInfo)localObject2).username))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
              break label804;
            }
            localObject4 = com.tencent.mm.plugin.finder.utils.p.sMo;
            if (com.tencent.mm.plugin.finder.utils.p.aiY(((FinderCommentInfo)localObject2).username))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
              break label804;
            }
            a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)h.sUg, locala, 0, paramLinkedList.length());
            break label804;
            label1103:
            paramInt = 0;
            break label922;
            label1108:
            if (isFriend(((FinderCommentInfo)localObject2).reply_username))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, j, paramLinkedList.length());
            }
            else
            {
              localObject4 = com.tencent.mm.plugin.finder.utils.p.sMo;
              if (com.tencent.mm.plugin.finder.utils.p.aiY(((FinderCommentInfo)localObject2).reply_username)) {
                a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, j, paramLinkedList.length());
              } else {
                a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)j.sUi, locala, j, paramLinkedList.length());
              }
            }
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
    boolean bool = ((PluginFinder)g.ad(PluginFinder.class)).isFriend(paramString);
    AppMethodBeat.o(168347);
    return bool;
  }
  
  public final void Ge(int paramInt)
  {
    AppMethodBeat.i(168343);
    Object localObject;
    if (paramInt > 0)
    {
      localObject = this.sTW;
      if (localObject == null) {
        d.g.b.p.bcb("seeAllCommentsTv");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.sTW;
      if (localObject == null) {
        d.g.b.p.bcb("seeAllCommentsTv");
      }
      ((TextView)localObject).setText((CharSequence)h.fR(2, paramInt));
      localObject = this.sTW;
      if (localObject == null) {
        d.g.b.p.bcb("seeAllCommentsTv");
      }
      al.a((Paint)((TextView)localObject).getPaint(), 0.8F);
    }
    for (;;)
    {
      localObject = this.sTX;
      if (localObject == null) {
        d.g.b.p.bcb("commentIconContainer");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new m(this));
      AppMethodBeat.o(168343);
      return;
      localObject = this.sTW;
      if (localObject == null) {
        d.g.b.p.bcb("seeAllCommentsTv");
      }
      ((TextView)localObject).setText((CharSequence)getContext().getString(2131766541));
      localObject = this.sTW;
      if (localObject == null) {
        d.g.b.p.bcb("seeAllCommentsTv");
      }
      al.b((Paint)((TextView)localObject).getPaint());
    }
  }
  
  public final void a(View paramView, FinderItem paramFinderItem, LinkedList<FinderCommentInfo> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, m<? super FinderCommentInfo, ? super Boolean, d.z> paramm)
  {
    AppMethodBeat.i(205132);
    d.g.b.p.h(paramView, "feedConvert");
    d.g.b.p.h(paramFinderItem, "feed");
    d.g.b.p.h(paramLinkedList, "commentList");
    d.g.b.p.h(paramm, "likeClickListener");
    ad.i(this.TAG, "setExposeInfo " + paramFinderItem.getId() + ", commentList size: " + paramLinkedList.size() + ", totalCommentCount: " + paramInt1 + ", totalLikeCount: " + paramInt2 + ", friendLikeCount: " + paramInt3);
    this.feed = paramFinderItem;
    this.sTY = paramm;
    paramm = paramView.findViewById(2131298511);
    d.g.b.p.g(paramm, "feedConvert.findViewById(R.id.comment_count_tv)");
    this.sTW = ((TextView)paramm);
    paramView = paramView.findViewById(2131298522);
    d.g.b.p.g(paramView, "feedConvert.findViewById…d.comment_icon_container)");
    this.sTX = paramView;
    if (paramFinderItem.isCommentClose())
    {
      paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (!com.tencent.mm.plugin.finder.utils.p.aiX(paramFinderItem.field_username))
      {
        paramInt1 = 0;
        paramView = new LinkedList();
      }
    }
    for (;;)
    {
      paramFinderItem = (List)paramView;
      if (paramFinderItem.size() > 1) {
        j.a(paramFinderItem, (Comparator)new FinderFeedExposeLayout.n());
      }
      this.sCI.setVisibility(8);
      this.gUd.setVisibility(8);
      f(paramView, paramInt1);
      AppMethodBeat.o(205132);
      return;
      paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.eQq().value()).intValue() == 1)
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
              j.gfB();
            }
            paramm = (FinderCommentInfo)paramm;
            if (paramView.size() < this.Odk)
            {
              com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
              if ((com.tencent.mm.plugin.finder.utils.p.amf(paramm.extFlag)) || (d.g.b.p.i(paramm.username, u.aAm()))) {}
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
              paramFinderItem = (FinderCommentInfo)j.jd((List)paramLinkedList);
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
    AppMethodBeat.i(205131);
    View localView = this.sTX;
    if (localView == null) {
      d.g.b.p.bcb("commentIconContainer");
    }
    AppMethodBeat.o(205131);
    return localView;
  }
  
  public final LinearLayout getCommentsLayout()
  {
    return this.sTV;
  }
  
  public final int getMAX_COMMENT_COUNT()
  {
    return this.Odk;
  }
  
  public final m<View, FinderCommentInfo, d.z> getOnCommentClickListener()
  {
    return this.sTZ;
  }
  
  public final m<View, FinderCommentInfo, d.z> getOnCommentLongClickListener()
  {
    return this.sUa;
  }
  
  public final TextView getSeeAllCommentsTv()
  {
    AppMethodBeat.i(205130);
    TextView localTextView = this.sTW;
    if (localTextView == null) {
      d.g.b.p.bcb("seeAllCommentsTv");
    }
    AppMethodBeat.o(205130);
    return localTextView;
  }
  
  public final void setCommentIconContainer(View paramView)
  {
    AppMethodBeat.i(178492);
    d.g.b.p.h(paramView, "<set-?>");
    this.sTX = paramView;
    AppMethodBeat.o(178492);
  }
  
  public final void setCommentsLayout(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(168340);
    d.g.b.p.h(paramLinearLayout, "<set-?>");
    this.sTV = paramLinearLayout;
    AppMethodBeat.o(168340);
  }
  
  public final void setOnCommentClickListener(m<? super View, ? super FinderCommentInfo, d.z> paramm)
  {
    this.sTZ = paramm;
  }
  
  public final void setOnCommentLongClickListener(m<? super View, ? super FinderCommentInfo, d.z> paramm)
  {
    this.sUa = paramm;
  }
  
  public final void setSeeAllCommentsTv(TextView paramTextView)
  {
    AppMethodBeat.i(168341);
    d.g.b.p.h(paramTextView, "<set-?>");
    this.sTW = paramTextView;
    AppMethodBeat.o(168341);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "nicknameTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getNicknameTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
  public final class a
  {
    final View auu;
    final TextView opA;
    
    public a()
    {
      AppMethodBeat.i(168333);
      this.auu = localObject;
      this.opA = ((TextView)this.auu.findViewById(2131302863));
      AppMethodBeat.o(168333);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "username", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$onFriendClick$1"})
  static final class b
    extends q
    implements d.g.a.b<String, d.z>
  {
    b(FinderFeedExposeLayout paramFinderFeedExposeLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$7"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168335);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      long l = System.currentTimeMillis();
      ad.d(FinderFeedExposeLayout.b(jdField_this), "lastClickExposeCommentTime " + FinderFeedExposeLayout.c(jdField_this) + ", curTime:" + l);
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
        d.g.b.p.g(paramView, "it");
        ((m)localObject).p(paramView, this.rMQ);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168335);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$8"})
  static final class d
    implements View.OnLongClickListener
  {
    d(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(168336);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = jdField_this.getOnCommentLongClickListener();
      if (localObject != null)
      {
        d.g.b.p.g(paramView, "it");
        ((m)localObject).p(paramView, this.rMQ);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(168336);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<String, d.z>
  {
    public static final e sUd;
    
    static
    {
      AppMethodBeat.i(205119);
      sUd = new e();
      AppMethodBeat.o(205119);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<String, d.z>
  {
    public static final f sUe;
    
    static
    {
      AppMethodBeat.i(205121);
      sUe = new f();
      AppMethodBeat.o(205121);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<String, d.z>
  {
    public static final g sUf;
    
    static
    {
      AppMethodBeat.i(205123);
      sUf = new g();
      AppMethodBeat.o(205123);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.b<String, d.z>
  {
    public static final h sUg;
    
    static
    {
      AppMethodBeat.i(205125);
      sUg = new h();
      AppMethodBeat.o(205125);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.b<String, d.z>
  {
    public static final i sUh;
    
    static
    {
      AppMethodBeat.i(205127);
      sUh = new i();
      AppMethodBeat.o(205127);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<String, d.z>
  {
    public static final j sUi;
    
    static
    {
      AppMethodBeat.i(205129);
      sUi = new j();
      AppMethodBeat.o(205129);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168339);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$updateCommentCount$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = FinderFeedExposeLayout.a(this.sUc);
      if ((paramView != null) && (paramView.isCommentClose() == true)) {
        this.sUc.getSeeAllCommentsTv().setVisibility(8);
      }
      paramView = this.sUc.getOnCommentClickListener();
      if (paramView != null) {
        paramView.p(this.sUc.getSeeAllCommentsTv(), null);
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