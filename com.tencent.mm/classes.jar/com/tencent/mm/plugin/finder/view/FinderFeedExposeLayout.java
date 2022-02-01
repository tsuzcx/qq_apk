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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "COMMENT_FRIEND_CAN_CLICK_VALUE", "", "LIKE_COMMENT_EDU_VALUE", "MAX_COMMENT_COUNT", "getMAX_COMMENT_COUNT", "()I", "MAX_COMMENT_NAME_COUNT_VALUE", "REAL_NAME_LIKE_AVATAR_RADIUS_VALUE", "TAG", "", "commentIconContainer", "Landroid/view/View;", "getCommentIconContainer", "()Landroid/view/View;", "setCommentIconContainer", "(Landroid/view/View;)V", "commentsLayout", "getCommentsLayout", "()Landroid/widget/LinearLayout;", "setCommentsLayout", "(Landroid/widget/LinearLayout;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "lastClickExposeCommentTime", "", "likeClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Lkotlin/ParameterName;", "name", "comment", "isLike", "", "likeLayout", "likeTv", "Landroid/widget/TextView;", "onCommentClickListener", "view", "getOnCommentClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnCommentClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onCommentLongClickListener", "getOnCommentLongClickListener", "setOnCommentLongClickListener", "seeAllCommentsTv", "getSeeAllCommentsTv", "()Landroid/widget/TextView;", "setSeeAllCommentsTv", "(Landroid/widget/TextView;)V", "viewHolderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "Lkotlin/collections/ArrayList;", "attachStyle", "contentBuilder", "Landroid/text/SpannableStringBuilder;", "onFriendClick", "Lkotlin/Function1;", "holder", "start", "end", "fillCommentsLayout", "list", "Ljava/util/LinkedList;", "totalCommentCount", "fillLikeTv", "totalLikeCount", "friendLikeCount", "isFriend", "username", "isPoster", "isReplyPoster", "isSelf", "setExposeInfo", "feedConvert", "commentList", "setSpanTouch", "text", "Landroid/text/Spannable;", "updateCommentCount", "ViewHolder", "plugin-finder_release"})
public final class FinderFeedExposeLayout
  extends LinearLayout
{
  private final String TAG;
  private TextView hPG;
  private FinderItem tHo;
  private View vKh;
  private final int wmg;
  private final int wmh;
  private final int wmi;
  private final boolean wmj;
  private final ArrayList<a> wmk;
  private LinearLayout wml;
  public TextView wmm;
  public View wmn;
  private kotlin.g.a.m<? super FinderCommentInfo, ? super Boolean, x> wmo;
  private kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> wmp;
  private kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> wmq;
  private final int wmr;
  private long wms;
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168349);
    setOrientation(1);
    paramContext = aa.jQ(getContext()).inflate(2131494258, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131300567);
    p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.wml = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131300569);
    p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.vKh = paramAttributeSet;
    paramContext = paramContext.findViewById(2131300568);
    p.g(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.hPG = ((TextView)paramContext);
    ao.a((Paint)this.hPG.getPaint(), 0.8F);
    paramContext = c.vCb;
    this.wmg = ((Number)c.dux().value()).intValue();
    paramContext = c.vCb;
    this.wmh = ((Number)c.dsq().value()).intValue();
    paramContext = c.vCb;
    this.wmi = c.drZ();
    paramContext = c.vCb;
    this.wmj = c.drL();
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.wmk = new ArrayList();
    this.wmr = 3;
    AppMethodBeat.o(168349);
  }
  
  public FinderFeedExposeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168350);
    setOrientation(1);
    paramContext = aa.jQ(getContext()).inflate(2131494258, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131300567);
    p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_comment)");
    this.wml = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131300569);
    p.g(paramAttributeSet, "view.findViewById(R.id.feed_expose_like_layout)");
    this.vKh = paramAttributeSet;
    paramContext = paramContext.findViewById(2131300568);
    p.g(paramContext, "view.findViewById(R.id.feed_expose_like)");
    this.hPG = ((TextView)paramContext);
    ao.a((Paint)this.hPG.getPaint(), 0.8F);
    paramContext = c.vCb;
    this.wmg = ((Number)c.dux().value()).intValue();
    paramContext = c.vCb;
    this.wmh = ((Number)c.dsq().value()).intValue();
    paramContext = c.vCb;
    this.wmi = c.drZ();
    paramContext = c.vCb;
    this.wmj = c.drL();
    this.TAG = "Finder.FinderFeedExposeLayout";
    this.wmk = new ArrayList();
    this.wmr = 3;
    AppMethodBeat.o(168350);
  }
  
  private final void a(SpannableStringBuilder paramSpannableStringBuilder, FinderCommentInfo paramFinderCommentInfo, kotlin.g.a.b<? super String, x> paramb, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254814);
    if (this.wmj)
    {
      Object localObject = paramFinderCommentInfo.username;
      paramFinderCommentInfo = (FinderCommentInfo)localObject;
      if (localObject == null) {
        paramFinderCommentInfo = "";
      }
      localObject = getContext();
      p.g(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(2131099787);
      localObject = getContext();
      p.g(localObject, "context");
      paramSpannableStringBuilder.setSpan(new l(paramFinderCommentInfo, i, ((Context)localObject).getResources().getColor(2131099660), true, false, paramb), paramInt1, paramInt2, 17);
      a(parama, (Spannable)paramSpannableStringBuilder);
    }
    AppMethodBeat.o(254814);
  }
  
  private final void a(a parama, Spannable paramSpannable)
  {
    AppMethodBeat.i(168346);
    paramSpannable = (View.OnTouchListener)new FinderFeedExposeLayout.m(this, paramSpannable, parama);
    parama.pIN.setOnTouchListener(paramSpannable);
    AppMethodBeat.o(168346);
  }
  
  private static boolean b(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(178493);
    y localy = y.vXH;
    boolean bool = y.LG(paramFinderCommentInfo.displayFlag);
    AppMethodBeat.o(178493);
    return bool;
  }
  
  private static boolean c(FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(254815);
    y localy = y.vXH;
    boolean bool = y.LI(paramFinderCommentInfo.extFlag);
    AppMethodBeat.o(254815);
    return bool;
  }
  
  private final void f(LinkedList<FinderCommentInfo> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(168344);
    Mo(paramInt);
    if (paramLinkedList.size() == 0)
    {
      this.wml.setVisibility(8);
      AppMethodBeat.o(168344);
      return;
    }
    this.wml.setVisibility(0);
    Object localObject1 = this.wml;
    Object localObject2 = getContext();
    p.g(localObject2, "context");
    ((LinearLayout)localObject1).setDividerDrawable(((Context)localObject2).getResources().getDrawable(2131232504));
    this.wml.setShowDividers(2);
    localObject1 = this.wml;
    localObject2 = getContext();
    p.g(localObject2, "context");
    ((LinearLayout)localObject1).setDividerPadding(((Context)localObject2).getResources().getDimensionPixelSize(2131165314));
    paramInt = this.wmk.size();
    int i = Math.max(paramLinkedList.size(), this.wmr);
    while (paramInt < i)
    {
      localObject1 = aa.jQ(getContext()).inflate(2131496713, null);
      localObject2 = this.wmk;
      p.g(localObject1, "view");
      ((ArrayList)localObject2).add(new a((View)localObject1));
      this.wml.addView((View)localObject1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
      paramInt += 1;
    }
    localObject1 = ((Iterable)this.wmk).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((a)((Iterator)localObject1).next()).aus.setVisibility(8);
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
          j.hxH();
        }
        localObject2 = (FinderCommentInfo)paramLinkedList;
        if (paramInt < this.wmr)
        {
          paramLinkedList = this.wmk.get(paramInt);
          p.g(paramLinkedList, "viewHolderList[index]");
          a locala = (a)paramLinkedList;
          locala.aus.setVisibility(0);
          Object localObject3 = (kotlin.g.a.b)new b(this);
          locala.pIN.setOnTouchListener(null);
          if (this.wmg == 1)
          {
            paramLinkedList = locala.pIN;
            p.g(paramLinkedList, "holder.nicknameTv");
            paramLinkedList.setMaxLines(2);
          }
          Object localObject4;
          Object localObject5;
          if (((FinderCommentInfo)localObject2).replyCommentId == 0L)
          {
            paramLinkedList = com.tencent.mm.plugin.finder.convert.d.tyZ;
            paramLinkedList = locala.pIN;
            p.g(paramLinkedList, "holder.nicknameTv");
            paramLinkedList = paramLinkedList.getPaint();
            p.g(paramLinkedList, "holder.nicknameTv.paint");
            localObject4 = ((FinderCommentInfo)localObject2).nickname;
            localObject5 = com.tencent.mm.plugin.finder.convert.d.tyZ;
            localObject5 = getContext();
            p.g(localObject5, "context");
            paramInt = com.tencent.mm.plugin.finder.convert.d.Z((Context)localObject5, this.wmi);
            localObject5 = com.tencent.mm.plugin.finder.convert.d.tyZ;
            localObject5 = getContext();
            p.g(localObject5, "context");
            paramLinkedList = com.tencent.mm.plugin.finder.convert.d.a(paramLinkedList, (String)localObject4, paramInt, com.tencent.mm.plugin.finder.convert.d.Z((Context)localObject5, this.wmi + 1));
            paramLinkedList = new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)paramLinkedList));
            if ((!Util.isNullOrNil(((FinderCommentInfo)localObject2).username)) && (b((FinderCommentInfo)localObject2)))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)e.wmv, locala, 0, paramLinkedList.length());
              label588:
              paramLinkedList.append((CharSequence)getContext().getString(2131759593)).append((CharSequence)o.a((FinderCommentInfo)localObject2));
              localObject3 = locala.pIN;
              p.g(localObject3, "holder.nicknameTv");
              ((TextView)localObject3).setText((CharSequence)paramLinkedList);
              if (!c((FinderCommentInfo)localObject2)) {
                break label1426;
              }
              paramLinkedList = locala.wmt;
              p.g(paramLinkedList, "holder.headerIv");
              paramLinkedList.setVisibility(0);
              if (this.wmh != 1) {
                break label1367;
              }
              paramLinkedList = com.tencent.mm.plugin.finder.loader.m.uJa;
              paramLinkedList = com.tencent.mm.plugin.finder.loader.m.dkb();
              localObject3 = new com.tencent.mm.plugin.finder.loader.a(((FinderCommentInfo)localObject2).headUrl);
              localObject4 = locala.wmt;
              p.g(localObject4, "holder.headerIv");
              localObject5 = com.tencent.mm.plugin.finder.loader.m.uJa;
              paramLinkedList.a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJg));
              label731:
              paramLinkedList = locala.pIN;
              p.g(paramLinkedList, "holder.nicknameTv");
              paramLinkedList.setMaxLines(1);
            }
          }
          for (;;)
          {
            paramLinkedList = locala.pIN;
            p.g(paramLinkedList, "holder.nicknameTv");
            paramLinkedList.setTag(((FinderCommentInfo)localObject2).username);
            locala.aus.setOnClickListener((View.OnClickListener)new c((FinderCommentInfo)localObject2, this));
            locala.aus.setOnLongClickListener((View.OnLongClickListener)new d((FinderCommentInfo)localObject2, this));
            paramInt = i;
            break;
            if (isFriend(((FinderCommentInfo)localObject2).username))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)localObject3, locala, 0, paramLinkedList.length());
              break label588;
            }
            localObject4 = y.vXH;
            if (y.awn(((FinderCommentInfo)localObject2).username))
            {
              a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)localObject3, locala, 0, paramLinkedList.length());
              break label588;
            }
            a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)f.wmw, locala, 0, paramLinkedList.length());
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
              a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)g.wmx, locala, 0, paramLinkedList.length());
              if ((!Util.isNullOrNil((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)((FinderCommentInfo)localObject2).replyNickname))) && (((FinderCommentInfo)localObject2).replyCommentId != 0L))
              {
                paramLinkedList.append((CharSequence)(" " + getContext().getString(2131759605) + ' '));
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
                a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)i.wmz, locala, j, paramLinkedList.length());
              }
            }
            for (;;)
            {
              paramLinkedList.append((CharSequence)getContext().getString(2131759593));
              paramLinkedList.append((CharSequence)o.a((FinderCommentInfo)localObject2));
              localObject3 = locala.pIN;
              p.g(localObject3, "holder.nicknameTv");
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
              localObject4 = y.vXH;
              if (y.awn(((FinderCommentInfo)localObject2).username))
              {
                a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)localObject3, locala, 0, paramLinkedList.length());
                break label972;
              }
              a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)h.wmy, locala, 0, paramLinkedList.length());
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
                localObject4 = y.vXH;
                if (y.awn(((FinderCommentInfo)localObject2).reply_username)) {
                  a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)localObject3, locala, j, paramLinkedList.length());
                } else {
                  a(paramLinkedList, (FinderCommentInfo)localObject2, (kotlin.g.a.b)j.wmA, locala, j, paramLinkedList.length());
                }
              }
            }
            label1367:
            paramLinkedList = com.tencent.mm.plugin.finder.loader.m.uJa;
            paramLinkedList = com.tencent.mm.plugin.finder.loader.m.dka();
            localObject3 = new com.tencent.mm.plugin.finder.loader.a(((FinderCommentInfo)localObject2).headUrl);
            localObject4 = locala.wmt;
            p.g(localObject4, "holder.headerIv");
            localObject5 = com.tencent.mm.plugin.finder.loader.m.uJa;
            paramLinkedList.a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
            break label731;
            label1426:
            paramLinkedList = locala.wmt;
            p.g(paramLinkedList, "holder.headerIv");
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
    boolean bool = ((PluginFinder)g.ah(PluginFinder.class)).isFriend(paramString);
    AppMethodBeat.o(168347);
    return bool;
  }
  
  public final void Mo(int paramInt)
  {
    AppMethodBeat.i(168343);
    Object localObject;
    if (paramInt > 0)
    {
      localObject = this.wmm;
      if (localObject == null) {
        p.btv("seeAllCommentsTv");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.wmm;
      if (localObject == null) {
        p.btv("seeAllCommentsTv");
      }
      ((TextView)localObject).setText((CharSequence)k.gm(2, paramInt));
      localObject = this.wmm;
      if (localObject == null) {
        p.btv("seeAllCommentsTv");
      }
      ao.a((Paint)((TextView)localObject).getPaint(), 0.8F);
    }
    for (;;)
    {
      localObject = this.wmn;
      if (localObject == null) {
        p.btv("commentIconContainer");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new n(this));
      AppMethodBeat.o(168343);
      return;
      localObject = this.wmm;
      if (localObject == null) {
        p.btv("seeAllCommentsTv");
      }
      ((TextView)localObject).setText((CharSequence)getContext().getString(2131759594));
      localObject = this.wmm;
      if (localObject == null) {
        p.btv("seeAllCommentsTv");
      }
      ao.b((Paint)((TextView)localObject).getPaint());
    }
  }
  
  public final void a(View paramView, FinderItem paramFinderItem, LinkedList<FinderCommentInfo> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, kotlin.g.a.m<? super FinderCommentInfo, ? super Boolean, x> paramm)
  {
    AppMethodBeat.i(254813);
    p.h(paramView, "feedConvert");
    p.h(paramFinderItem, "feed");
    p.h(paramLinkedList, "commentList");
    p.h(paramm, "likeClickListener");
    Log.i(this.TAG, "setExposeInfo " + paramFinderItem.getId() + ", commentList size: " + paramLinkedList.size() + ", totalCommentCount: " + paramInt1 + ", totalLikeCount: " + paramInt2 + ", friendLikeCount: " + paramInt3);
    this.tHo = paramFinderItem;
    this.wmo = paramm;
    paramm = paramView.findViewById(2131300558);
    p.g(paramm, "feedConvert.findViewById…id.feed_comment_count_tv)");
    this.wmm = ((TextView)paramm);
    paramView = paramView.findViewById(2131298948);
    p.g(paramView, "feedConvert.findViewById…d.comment_icon_container)");
    this.wmn = paramView;
    if (paramFinderItem.isCommentClose())
    {
      paramView = y.vXH;
      if (!y.In(paramFinderItem.field_username))
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
      this.vKh.setVisibility(8);
      this.hPG.setVisibility(8);
      f(paramView, paramInt1);
      AppMethodBeat.o(254813);
      return;
      if (this.wmg == 1)
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
              j.hxH();
            }
            paramm = (FinderCommentInfo)paramm;
            if (paramView.size() < this.wmr)
            {
              if ((c(paramm)) || (p.j(paramm.username, z.aTY()))) {}
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
              paramFinderItem = (FinderCommentInfo)j.kt((List)paramLinkedList);
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
    AppMethodBeat.i(254812);
    View localView = this.wmn;
    if (localView == null) {
      p.btv("commentIconContainer");
    }
    AppMethodBeat.o(254812);
    return localView;
  }
  
  public final LinearLayout getCommentsLayout()
  {
    return this.wml;
  }
  
  public final int getMAX_COMMENT_COUNT()
  {
    return this.wmr;
  }
  
  public final kotlin.g.a.m<View, FinderCommentInfo, x> getOnCommentClickListener()
  {
    return this.wmp;
  }
  
  public final kotlin.g.a.m<View, FinderCommentInfo, x> getOnCommentLongClickListener()
  {
    return this.wmq;
  }
  
  public final TextView getSeeAllCommentsTv()
  {
    AppMethodBeat.i(254811);
    TextView localTextView = this.wmm;
    if (localTextView == null) {
      p.btv("seeAllCommentsTv");
    }
    AppMethodBeat.o(254811);
    return localTextView;
  }
  
  public final void setCommentIconContainer(View paramView)
  {
    AppMethodBeat.i(178492);
    p.h(paramView, "<set-?>");
    this.wmn = paramView;
    AppMethodBeat.o(178492);
  }
  
  public final void setCommentsLayout(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(168340);
    p.h(paramLinearLayout, "<set-?>");
    this.wml = paramLinearLayout;
    AppMethodBeat.o(168340);
  }
  
  public final void setOnCommentClickListener(kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> paramm)
  {
    this.wmp = paramm;
  }
  
  public final void setOnCommentLongClickListener(kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> paramm)
  {
    this.wmq = paramm;
  }
  
  public final void setSeeAllCommentsTv(TextView paramTextView)
  {
    AppMethodBeat.i(168341);
    p.h(paramTextView, "<set-?>");
    this.wmm = paramTextView;
    AppMethodBeat.o(168341);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;Landroid/view/View;)V", "headerIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getHeaderIv", "()Landroid/widget/ImageView;", "getItemView", "()Landroid/view/View;", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
  public final class a
  {
    final View aus;
    final TextView pIN;
    final ImageView wmt;
    
    public a()
    {
      AppMethodBeat.i(168333);
      this.aus = localObject;
      this.pIN = ((TextView)this.aus.findViewById(2131305436));
      this.wmt = ((ImageView)this.aus.findViewById(2131302293));
      AppMethodBeat.o(168333);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "username", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$onFriendClick$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, x>
  {
    b(FinderFeedExposeLayout paramFinderFeedExposeLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$7"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168335);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
        p.g(paramView, "it");
        ((kotlin.g.a.m)localObject).invoke(paramView, this.tAq);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168335);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$8"})
  static final class d
    implements View.OnLongClickListener
  {
    d(FinderCommentInfo paramFinderCommentInfo, FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(168336);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = jdField_this.getOnCommentLongClickListener();
      if (localObject != null)
      {
        p.g(paramView, "it");
        ((kotlin.g.a.m)localObject).invoke(paramView, this.tAq);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(168336);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final e wmv;
    
    static
    {
      AppMethodBeat.i(254799);
      wmv = new e();
      AppMethodBeat.o(254799);
    }
    
    e()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final f wmw;
    
    static
    {
      AppMethodBeat.i(254801);
      wmw = new f();
      AppMethodBeat.o(254801);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final g wmx;
    
    static
    {
      AppMethodBeat.i(254803);
      wmx = new g();
      AppMethodBeat.o(254803);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final h wmy;
    
    static
    {
      AppMethodBeat.i(254805);
      wmy = new h();
      AppMethodBeat.o(254805);
    }
    
    h()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final i wmz;
    
    static
    {
      AppMethodBeat.i(254807);
      wmz = new i();
      AppMethodBeat.o(254807);
    }
    
    i()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final j wmA;
    
    static
    {
      AppMethodBeat.i(254809);
      wmA = new j();
      AppMethodBeat.o(254809);
    }
    
    j()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class l<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(254810);
      int i = kotlin.b.a.a((Comparable)Long.valueOf(((FinderCommentInfo)paramT2).displayid), (Comparable)Long.valueOf(((FinderCommentInfo)paramT1).displayid));
      AppMethodBeat.o(254810);
      return i;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderFeedExposeLayout paramFinderFeedExposeLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168339);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$updateCommentCount$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = FinderFeedExposeLayout.a(this.wmu);
      if ((paramView != null) && (paramView.isCommentClose() == true)) {
        this.wmu.getSeeAllCommentsTv().setVisibility(8);
      }
      paramView = this.wmu.getOnCommentClickListener();
      if (paramView != null) {
        paramView.invoke(this.wmu.getSeeAllCommentsTv(), null);
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