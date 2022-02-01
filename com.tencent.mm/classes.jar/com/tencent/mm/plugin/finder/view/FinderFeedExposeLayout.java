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
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import d.g.a.m;
import d.g.b.q;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MAX_COMMENT_COUNT", "getMAX_COMMENT_COUNT", "()I", "TAG", "", "commentIconContainer", "Landroid/view/View;", "getCommentIconContainer", "()Landroid/view/View;", "setCommentIconContainer", "(Landroid/view/View;)V", "commentsLayout", "getCommentsLayout", "()Landroid/widget/LinearLayout;", "setCommentsLayout", "(Landroid/widget/LinearLayout;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "lastClickExposeCommentTime", "", "likeClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Lkotlin/ParameterName;", "name", "comment", "", "isLike", "", "likeLayout", "likeTv", "Landroid/widget/TextView;", "onCommentClickListener", "view", "getOnCommentClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnCommentClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onCommentLongClickListener", "getOnCommentLongClickListener", "setOnCommentLongClickListener", "seeAllCommentsTv", "getSeeAllCommentsTv", "()Landroid/widget/TextView;", "setSeeAllCommentsTv", "(Landroid/widget/TextView;)V", "viewHolderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "Lkotlin/collections/ArrayList;", "attachStyle", "contentBuilder", "Landroid/text/SpannableStringBuilder;", "onFriendClick", "Lkotlin/Function1;", "holder", "start", "end", "fillCommentsLayout", "list", "Ljava/util/LinkedList;", "totalCommentCount", "fillLikeTv", "totalLikeCount", "friendLikeCount", "isFriend", "username", "isPoster", "isReplyPoster", "isSelf", "setExposeInfo", "feedConvert", "commentList", "setSpanTouch", "text", "Landroid/text/Spannable;", "updateCommentCount", "ViewHolder", "plugin-finder_release"})
public final class FinderFeedExposeLayout
  extends LinearLayout
{
  private final String TAG;
  private FinderItem feed;
  private TextView gWM;
  private View sNH;
  private final ArrayList<FinderFeedExposeLayout.a> tfg;
  private LinearLayout tfh;
  public TextView tfi;
  public View tfj;
  private m<? super FinderCommentInfo, ? super Boolean, d.z> tfk;
  private m<? super View, ? super FinderCommentInfo, d.z> tfl;
  private m<? super View, ? super FinderCommentInfo, d.z> tfm;
  private final int tfn;
  private long tfo;
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168349);
    setOrientation(1);
    paramContext = com.tencent.mm.ui.z.jV(getContext()).inflate(2131496185, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299883);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.tfh = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299885);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.sNH = paramAttributeSet;
    paramContext = paramContext.findViewById(2131299884);
    d.g.b.p.g(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.gWM = ((TextView)paramContext);
    al.a((Paint)this.gWM.getPaint(), 0.8F);
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.tfg = new ArrayList();
    this.tfn = 3;
    AppMethodBeat.o(168349);
  }
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168350);
    setOrientation(1);
    paramContext = com.tencent.mm.ui.z.jV(getContext()).inflate(2131496185, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299883);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.tfh = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299885);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.sNH = paramAttributeSet;
    paramContext = paramContext.findViewById(2131299884);
    d.g.b.p.g(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.gWM = ((TextView)paramContext);
    al.a((Paint)this.gWM.getPaint(), 0.8F);
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.tfg = new ArrayList();
    this.tfn = 3;
    AppMethodBeat.o(168350);
  }
  
  private final void a(SpannableStringBuilder paramSpannableStringBuilder, FinderCommentInfo paramFinderCommentInfo, d.g.a.b<? super String, d.z> paramb, FinderFeedExposeLayout.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205766);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cIa())
    {
      localObject = paramFinderCommentInfo.username;
      paramFinderCommentInfo = (FinderCommentInfo)localObject;
      if (localObject == null) {
        paramFinderCommentInfo = "";
      }
      localObject = getContext();
      d.g.b.p.g(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(2131099773);
      localObject = getContext();
      d.g.b.p.g(localObject, "context");
      paramSpannableStringBuilder.setSpan(new j(paramFinderCommentInfo, i, ((Context)localObject).getResources().getColor(2131099658), true, paramb), paramInt1, paramInt2, 17);
      a(parama, (Spannable)paramSpannableStringBuilder);
    }
    AppMethodBeat.o(205766);
  }
  
  private final void a(FinderFeedExposeLayout.a parama, Spannable paramSpannable)
  {
    AppMethodBeat.i(168346);
    paramSpannable = (View.OnTouchListener)new FinderFeedExposeLayout.m(this, paramSpannable, parama);
    parama.ovs.setOnTouchListener(paramSpannable);
    AppMethodBeat.o(168346);
  }
  
  private static boolean b(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(178493);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
    boolean bool = com.tencent.mm.plugin.finder.utils.p.Gn(paramFinderCommentInfo.displayFlag);
    AppMethodBeat.o(178493);
    return bool;
  }
  
  private static boolean c(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(205767);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
    boolean bool = com.tencent.mm.plugin.finder.utils.p.Gp(paramFinderCommentInfo.extFlag);
    AppMethodBeat.o(205767);
    return bool;
  }
  
  private final void g(LinkedList<FinderCommentInfo> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(168344);
    GE(paramInt);
    if (paramLinkedList.size() == 0)
    {
      this.tfh.setVisibility(8);
      AppMethodBeat.o(168344);
      return;
    }
    this.tfh.setVisibility(0);
    Object localObject1 = this.tfh;
    Object localObject2 = getContext();
    d.g.b.p.g(localObject2, "context");
    ((LinearLayout)localObject1).setDividerDrawable(((Context)localObject2).getResources().getDrawable(2131235094));
    this.tfh.setShowDividers(2);
    localObject1 = this.tfh;
    localObject2 = getContext();
    d.g.b.p.g(localObject2, "context");
    ((LinearLayout)localObject1).setDividerPadding(((Context)localObject2).getResources().getDimensionPixelSize(2131165303));
    paramInt = this.tfg.size();
    int i = Math.max(paramLinkedList.size(), this.tfn);
    while (paramInt < i)
    {
      localObject1 = com.tencent.mm.ui.z.jV(getContext()).inflate(2131495755, null);
      localObject2 = this.tfg;
      d.g.b.p.g(localObject1, "view");
      ((ArrayList)localObject2).add(new FinderFeedExposeLayout.a(this, (View)localObject1));
      this.tfh.addView((View)localObject1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
      paramInt += 1;
    }
    localObject1 = ((Iterable)this.tfg).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((FinderFeedExposeLayout.a)((Iterator)localObject1).next()).auu.setVisibility(8);
    }
    ae.i(this.TAG, "fillCommentsLayout");
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
          d.a.j.gkd();
        }
        localObject2 = (FinderCommentInfo)paramLinkedList;
        if (paramInt < this.tfn)
        {
          paramLinkedList = this.tfg.get(paramInt);
          d.g.b.p.g(paramLinkedList, "viewHolderList[index]");
          FinderFeedExposeLayout.a locala = (FinderFeedExposeLayout.a)paramLinkedList;
          locala.auu.setVisibility(0);
          Object localObject3 = (d.g.a.b)new b(this);
          locala.ovs.setOnTouchListener(null);
          paramLinkedList = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (((Number)com.tencent.mm.plugin.finder.storage.b.cKD().value()).intValue() == 1)
          {
            paramLinkedList = locala.ovs;
            d.g.b.p.g(paramLinkedList, "holder.nicknameTv");
            paramLinkedList.setMaxLines(2);
          }
          Object localObject4;
          Object localObject5;
          if (((FinderCommentInfo)localObject2).replyCommentId == 0L)
          {
            paramLinkedList = com.tencent.mm.plugin.finder.convert.a.rUe;
            paramLinkedList = locala.ovs;
            d.g.b.p.g(paramLinkedList, "holder.nicknameTv");
            paramLinkedList = paramLinkedList.getPaint();
            d.g.b.p.g(paramLinkedList, "holder.nicknameTv.paint");
            localObject4 = ((FinderCommentInfo)localObject2).nickname;
            localObject5 = com.tencent.mm.plugin.finder.convert.a.rUe;
            localObject5 = getContext();
            d.g.b.p.g(localObject5, "context");
            com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
            paramInt = com.tencent.mm.plugin.finder.convert.a.U((Context)localObject5, com.tencent.mm.plugin.finder.storage.b.cIp());
            localObject5 = com.tencent.mm.plugin.finder.convert.a.rUe;
            localObject5 = getContext();
            d.g.b.p.g(localObject5, "context");
            localb = com.tencent.mm.plugin.finder.storage.b.sHP;
            paramLinkedList = com.tencent.mm.plugin.finder.convert.a.a(paramLinkedList, (String)localObject4, paramInt, com.tencent.mm.plugin.finder.convert.a.U((Context)localObject5, com.tencent.mm.plugin.finder.storage.b.cIp() + 1));
            paramLinkedList = new SpannableStringBuilder((CharSequence)k.c(getContext(), (CharSequence)paramLinkedList));
            if ((!bu.isNullOrNil(((FinderCommentInfo)localObject2).username)) && (b((FinderCommentInfo)localObject2)))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.e.tfr, locala, 0, paramLinkedList.length());
              label604:
              paramLinkedList.append((CharSequence)getContext().getString(2131759161)).append((CharSequence)com.tencent.mm.plugin.finder.model.l.a((FinderCommentInfo)localObject2));
              localObject3 = locala.ovs;
              d.g.b.p.g(localObject3, "holder.nicknameTv");
              ((TextView)localObject3).setText((CharSequence)paramLinkedList);
              if (!c((FinderCommentInfo)localObject2)) {
                break label1453;
              }
              paramLinkedList = locala.tfp;
              d.g.b.p.g(paramLinkedList, "holder.headerIv");
              paramLinkedList.setVisibility(0);
              paramLinkedList = com.tencent.mm.plugin.finder.storage.b.sHP;
              if (((Number)com.tencent.mm.plugin.finder.storage.b.cIK().value()).intValue() != 1) {
                break label1394;
              }
              paramLinkedList = i.srW;
              paramLinkedList = i.cEp();
              localObject3 = new com.tencent.mm.plugin.finder.loader.a(((FinderCommentInfo)localObject2).headUrl);
              localObject4 = locala.tfp;
              d.g.b.p.g(localObject4, "holder.headerIv");
              localObject5 = i.srW;
              paramLinkedList.a(localObject3, (ImageView)localObject4, i.a(i.a.ssb));
              label759:
              paramLinkedList = locala.ovs;
              d.g.b.p.g(paramLinkedList, "holder.nicknameTv");
              paramLinkedList.setMaxLines(1);
            }
          }
          for (;;)
          {
            paramLinkedList = locala.ovs;
            d.g.b.p.g(paramLinkedList, "holder.nicknameTv");
            paramLinkedList.setTag(((FinderCommentInfo)localObject2).username);
            locala.auu.setOnClickListener((View.OnClickListener)new c((FinderCommentInfo)localObject2, this));
            locala.auu.setOnLongClickListener((View.OnLongClickListener)new d((FinderCommentInfo)localObject2, this));
            paramInt = i;
            break;
            if (isFriend(((FinderCommentInfo)localObject2).username))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
              break label604;
            }
            localObject4 = com.tencent.mm.plugin.finder.utils.p.sXz;
            if (com.tencent.mm.plugin.finder.utils.p.ajV(((FinderCommentInfo)localObject2).username))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
              break label604;
            }
            a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.f.tfs, locala, 0, paramLinkedList.length());
            break label604;
            localObject4 = getContext();
            paramLinkedList = ((FinderCommentInfo)localObject2).nickname;
            label955:
            label1000:
            int j;
            if (paramLinkedList != null)
            {
              paramLinkedList = (CharSequence)paramLinkedList;
              paramLinkedList = new SpannableStringBuilder((CharSequence)k.c((Context)localObject4, paramLinkedList));
              if (!b((FinderCommentInfo)localObject2)) {
                break label1210;
              }
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.g.tft, locala, 0, paramLinkedList.length());
              if ((!bu.ah((CharSequence)k.c(getContext(), (CharSequence)((FinderCommentInfo)localObject2).replyNickname))) && (((FinderCommentInfo)localObject2).replyCommentId != 0L))
              {
                paramLinkedList.append((CharSequence)(" " + getContext().getString(2131759169) + ' '));
                localObject4 = k.c(getContext(), (CharSequence)((FinderCommentInfo)localObject2).replyNickname);
                j = paramLinkedList.length();
                paramLinkedList.append((CharSequence)localObject4);
                if ((((FinderCommentInfo)localObject2).displayFlag & 0x4) == 0) {
                  break label1298;
                }
                paramInt = 1;
                label1118:
                if (paramInt == 0) {
                  break label1303;
                }
                a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.i.tfv, locala, j, paramLinkedList.length());
              }
            }
            for (;;)
            {
              paramLinkedList.append((CharSequence)getContext().getString(2131759161));
              paramLinkedList.append((CharSequence)com.tencent.mm.plugin.finder.model.l.a((FinderCommentInfo)localObject2));
              localObject3 = locala.ovs;
              d.g.b.p.g(localObject3, "holder.nicknameTv");
              ((TextView)localObject3).setText((CharSequence)paramLinkedList);
              break;
              paramLinkedList = (CharSequence)"";
              break label955;
              label1210:
              if (isFriend(((FinderCommentInfo)localObject2).username))
              {
                a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
                break label1000;
              }
              localObject4 = com.tencent.mm.plugin.finder.utils.p.sXz;
              if (com.tencent.mm.plugin.finder.utils.p.ajV(((FinderCommentInfo)localObject2).username))
              {
                a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, 0, paramLinkedList.length());
                break label1000;
              }
              a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.h.tfu, locala, 0, paramLinkedList.length());
              break label1000;
              label1298:
              paramInt = 0;
              break label1118;
              label1303:
              if (isFriend(((FinderCommentInfo)localObject2).reply_username))
              {
                a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, j, paramLinkedList.length());
              }
              else
              {
                localObject4 = com.tencent.mm.plugin.finder.utils.p.sXz;
                if (com.tencent.mm.plugin.finder.utils.p.ajV(((FinderCommentInfo)localObject2).reply_username)) {
                  a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)localObject3, locala, j, paramLinkedList.length());
                } else {
                  a(paramLinkedList, (FinderCommentInfo)localObject2, (d.g.a.b)FinderFeedExposeLayout.j.tfw, locala, j, paramLinkedList.length());
                }
              }
            }
            label1394:
            paramLinkedList = i.srW;
            paramLinkedList = i.cEo();
            localObject3 = new com.tencent.mm.plugin.finder.loader.a(((FinderCommentInfo)localObject2).headUrl);
            localObject4 = locala.tfp;
            d.g.b.p.g(localObject4, "holder.headerIv");
            localObject5 = i.srW;
            paramLinkedList.a(localObject3, (ImageView)localObject4, i.a(i.a.srZ));
            break label759;
            label1453:
            paramLinkedList = locala.tfp;
            d.g.b.p.g(paramLinkedList, "holder.headerIv");
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
    boolean bool = ((PluginFinder)g.ad(PluginFinder.class)).isFriend(paramString);
    AppMethodBeat.o(168347);
    return bool;
  }
  
  public final void GE(int paramInt)
  {
    AppMethodBeat.i(168343);
    Object localObject;
    if (paramInt > 0)
    {
      localObject = this.tfi;
      if (localObject == null) {
        d.g.b.p.bdF("seeAllCommentsTv");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.tfi;
      if (localObject == null) {
        d.g.b.p.bdF("seeAllCommentsTv");
      }
      ((TextView)localObject).setText((CharSequence)h.fR(2, paramInt));
      localObject = this.tfi;
      if (localObject == null) {
        d.g.b.p.bdF("seeAllCommentsTv");
      }
      al.a((Paint)((TextView)localObject).getPaint(), 0.8F);
    }
    for (;;)
    {
      localObject = this.tfj;
      if (localObject == null) {
        d.g.b.p.bdF("commentIconContainer");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new n(this));
      AppMethodBeat.o(168343);
      return;
      localObject = this.tfi;
      if (localObject == null) {
        d.g.b.p.bdF("seeAllCommentsTv");
      }
      ((TextView)localObject).setText((CharSequence)getContext().getString(2131766541));
      localObject = this.tfi;
      if (localObject == null) {
        d.g.b.p.bdF("seeAllCommentsTv");
      }
      al.b((Paint)((TextView)localObject).getPaint());
    }
  }
  
  public final void a(View paramView, FinderItem paramFinderItem, LinkedList<FinderCommentInfo> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, m<? super FinderCommentInfo, ? super Boolean, d.z> paramm)
  {
    AppMethodBeat.i(205765);
    d.g.b.p.h(paramView, "feedConvert");
    d.g.b.p.h(paramFinderItem, "feed");
    d.g.b.p.h(paramLinkedList, "commentList");
    d.g.b.p.h(paramm, "likeClickListener");
    ae.i(this.TAG, "setExposeInfo " + paramFinderItem.getId() + ", commentList size: " + paramLinkedList.size() + ", totalCommentCount: " + paramInt1 + ", totalLikeCount: " + paramInt2 + ", friendLikeCount: " + paramInt3);
    this.feed = paramFinderItem;
    this.tfk = paramm;
    paramm = paramView.findViewById(2131298511);
    d.g.b.p.g(paramm, "feedConvert.findViewById(R.id.comment_count_tv)");
    this.tfi = ((TextView)paramm);
    paramView = paramView.findViewById(2131298522);
    d.g.b.p.g(paramView, "feedConvert.findViewById…d.comment_icon_container)");
    this.tfj = paramView;
    if (paramFinderItem.isCommentClose())
    {
      paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (!com.tencent.mm.plugin.finder.utils.p.ajU(paramFinderItem.field_username))
      {
        paramInt1 = 0;
        paramView = new LinkedList();
      }
    }
    for (;;)
    {
      paramFinderItem = (List)paramView;
      if (paramFinderItem.size() > 1) {
        d.a.j.a(paramFinderItem, (Comparator)new l());
      }
      this.sNH.setVisibility(8);
      this.gWM.setVisibility(8);
      g(paramView, paramInt1);
      AppMethodBeat.o(205765);
      return;
      paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cKD().value()).intValue() == 1)
      {
        paramView = (List)paramLinkedList;
        if (paramView.size() > 1) {
          d.a.j.a(paramView, (Comparator)new k());
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
              d.a.j.gkd();
            }
            paramm = (FinderCommentInfo)paramm;
            if (paramView.size() < this.tfn)
            {
              if ((c(paramm)) || (d.g.b.p.i(paramm.username, v.aAC()))) {}
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
              paramFinderItem = (FinderCommentInfo)d.a.j.jm((List)paramLinkedList);
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
    AppMethodBeat.i(205764);
    View localView = this.tfj;
    if (localView == null) {
      d.g.b.p.bdF("commentIconContainer");
    }
    AppMethodBeat.o(205764);
    return localView;
  }
  
  public final LinearLayout getCommentsLayout()
  {
    return this.tfh;
  }
  
  public final int getMAX_COMMENT_COUNT()
  {
    return this.tfn;
  }
  
  public final m<View, FinderCommentInfo, d.z> getOnCommentClickListener()
  {
    return this.tfl;
  }
  
  public final m<View, FinderCommentInfo, d.z> getOnCommentLongClickListener()
  {
    return this.tfm;
  }
  
  public final TextView getSeeAllCommentsTv()
  {
    AppMethodBeat.i(205763);
    TextView localTextView = this.tfi;
    if (localTextView == null) {
      d.g.b.p.bdF("seeAllCommentsTv");
    }
    AppMethodBeat.o(205763);
    return localTextView;
  }
  
  public final void setCommentIconContainer(View paramView)
  {
    AppMethodBeat.i(178492);
    d.g.b.p.h(paramView, "<set-?>");
    this.tfj = paramView;
    AppMethodBeat.o(178492);
  }
  
  public final void setCommentsLayout(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(168340);
    d.g.b.p.h(paramLinearLayout, "<set-?>");
    this.tfh = paramLinearLayout;
    AppMethodBeat.o(168340);
  }
  
  public final void setOnCommentClickListener(m<? super View, ? super FinderCommentInfo, d.z> paramm)
  {
    this.tfl = paramm;
  }
  
  public final void setOnCommentLongClickListener(m<? super View, ? super FinderCommentInfo, d.z> paramm)
  {
    this.tfm = paramm;
  }
  
  public final void setSeeAllCommentsTv(TextView paramTextView)
  {
    AppMethodBeat.i(168341);
    d.g.b.p.h(paramTextView, "<set-?>");
    this.tfi = paramTextView;
    AppMethodBeat.o(168341);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "username", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$onFriendClick$1"})
  static final class b
    extends q
    implements d.g.a.b<String, d.z>
  {
    b(FinderFeedExposeLayout paramFinderFeedExposeLayout)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$7"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168335);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      long l = System.currentTimeMillis();
      ae.d(FinderFeedExposeLayout.b(jdField_this), "lastClickExposeCommentTime " + FinderFeedExposeLayout.c(jdField_this) + ", curTime:" + l);
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
        ((m)localObject).p(paramView, this.rVe);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168335);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$8"})
  static final class d
    implements View.OnLongClickListener
  {
    d(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(168336);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = jdField_this.getOnCommentLongClickListener();
      if (localObject != null)
      {
        d.g.b.p.g(paramView, "it");
        ((m)localObject).p(paramView, this.rVe);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(168336);
      return true;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class l<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(205762);
      int i = d.b.a.a((Comparable)Long.valueOf(((FinderCommentInfo)paramT2).displayid), (Comparable)Long.valueOf(((FinderCommentInfo)paramT1).displayid));
      AppMethodBeat.o(205762);
      return i;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168339);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$updateCommentCount$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = FinderFeedExposeLayout.a(this.tfq);
      if ((paramView != null) && (paramView.isCommentClose() == true)) {
        this.tfq.getSeeAllCommentsTv().setVisibility(8);
      }
      paramView = this.tfq.getOnCommentClickListener();
      if (paramView != null) {
        paramView.p(this.tfq.getSeeAllCommentsTv(), null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$updateCommentCount$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout
 * JD-Core Version:    0.7.0.1
 */