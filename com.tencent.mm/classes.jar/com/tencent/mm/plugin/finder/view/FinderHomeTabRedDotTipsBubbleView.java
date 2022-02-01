package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jr;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tipsReportJson", "Lorg/json/JSONObject;", "tipsShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTipsShowInfo;", "visibilityListener", "Lcom/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView$IVisibilityListener;", "getVisibilityListener", "()Lcom/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView$IVisibilityListener;", "setVisibilityListener", "(Lcom/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView$IVisibilityListener;)V", "dismiss", "", "withAnim", "getReportJson", "getView", "T", "Landroid/view/View;", "id", "(I)Landroid/view/View;", "isFollowBubble", "onDetachedFromWindow", "", "setArrowLayoutGravity", "gravity", "setVisibility", "visibility", "show", "info", "update", "Companion", "IVisibilityListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderHomeTabRedDotTipsBubbleView
  extends FrameLayout
{
  public static final a GzN;
  private static boolean akij;
  private static boolean akik;
  private static boolean fhR;
  public bwk Bjn;
  private b GzO;
  public JSONObject GzP;
  
  static
  {
    AppMethodBeat.i(345033);
    GzN = new a((byte)0);
    AppMethodBeat.o(345033);
  }
  
  public FinderHomeTabRedDotTipsBubbleView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(344965);
    setVisibility(8);
    af.mU(getContext()).inflate(e.f.finder_friend_collapse_reddot_tips_layout, (ViewGroup)this, true);
    setOnClickListener(new FinderHomeTabRedDotTipsBubbleView..ExternalSyntheticLambda0(this));
    this.GzP = new JSONObject();
    AppMethodBeat.o(344965);
  }
  
  public FinderHomeTabRedDotTipsBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344973);
    setVisibility(8);
    af.mU(getContext()).inflate(e.f.finder_friend_collapse_reddot_tips_layout, (ViewGroup)this, true);
    setOnClickListener(new FinderHomeTabRedDotTipsBubbleView..ExternalSyntheticLambda0(this));
    this.GzP = new JSONObject();
    AppMethodBeat.o(344973);
  }
  
  public FinderHomeTabRedDotTipsBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344978);
    setVisibility(8);
    af.mU(getContext()).inflate(e.f.finder_friend_collapse_reddot_tips_layout, (ViewGroup)this, true);
    setOnClickListener(new FinderHomeTabRedDotTipsBubbleView..ExternalSyntheticLambda0(this));
    this.GzP = new JSONObject();
    AppMethodBeat.o(344978);
  }
  
  private final <T extends View> T UH(int paramInt)
  {
    AppMethodBeat.i(344994);
    View localView = findViewById(paramInt);
    s.s(localView, "findViewById(id)");
    AppMethodBeat.o(344994);
    return localView;
  }
  
  private static final void a(FinderHomeTabRedDotTipsBubbleView paramFinderHomeTabRedDotTipsBubbleView, View paramView)
  {
    AppMethodBeat.i(370635);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderHomeTabRedDotTipsBubbleView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderHomeTabRedDotTipsBubbleView, "this$0");
    if (paramFinderHomeTabRedDotTipsBubbleView.fkI())
    {
      akij = true;
      paramView = new jr();
      paramView.hLn.hJx = 3;
      paramView.publish();
      if (!paramFinderHomeTabRedDotTipsBubbleView.fkI()) {
        break label191;
      }
      paramView = k.aeZF;
      paramView = paramFinderHomeTabRedDotTipsBubbleView.getContext();
      s.s(paramView, "context");
      paramView = ((as)k.nq(paramView).q(as.class)).Vl(3);
      localObject = bb.FuK;
      bb.a(paramView, "followtab_tl_bubble", 1, paramFinderHomeTabRedDotTipsBubbleView.GzP);
    }
    for (;;)
    {
      a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(370635);
      return;
      akik = true;
      paramView = new jr();
      paramView.hLn.hJx = 1;
      paramView.publish();
      break;
      label191:
      paramView = k.aeZF;
      paramView = paramFinderHomeTabRedDotTipsBubbleView.getContext();
      s.s(paramView, "context");
      paramView = ((as)k.nq(paramView).q(as.class)).Vl(1);
      localObject = bb.FuK;
      bb.a(paramView, "friendtab_tl_bubble", 1, paramFinderHomeTabRedDotTipsBubbleView.GzP);
    }
  }
  
  private final void setArrowLayoutGravity(int paramInt)
  {
    AppMethodBeat.i(344985);
    Object localObject = findViewById(e.e.v_arrow).getLayoutParams();
    if ((localObject instanceof LinearLayout.LayoutParams))
    {
      localObject = (LinearLayout.LayoutParams)localObject;
      if (localObject != null)
      {
        if (paramInt != 3) {
          break label91;
        }
        findViewById(e.e.tips_container).setMinimumWidth((int)getResources().getDimension(e.c.Edge_16A));
        ((LinearLayout.LayoutParams)localObject).setMarginStart(-(int)getResources().getDimension(e.c.Edge_6A));
      }
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(344985);
      return;
      localObject = null;
      break;
      label91:
      findViewById(e.e.tips_container).setMinimumWidth(0);
      findViewById(e.e.tips_container).setMinimumWidth(0);
      ((LinearLayout.LayoutParams)localObject).setMarginStart(0);
    }
  }
  
  public final boolean Qa(boolean paramBoolean)
  {
    AppMethodBeat.i(370636);
    if (getVisibility() == 0)
    {
      if (paramBoolean)
      {
        animate().cancel();
        animate().alpha(0.0F).setDuration(250L).setListener((Animator.AnimatorListener)new c(this)).start();
      }
      for (;;)
      {
        AppMethodBeat.o(370636);
        return true;
        setVisibility(8);
      }
    }
    AppMethodBeat.o(370636);
    return false;
  }
  
  public final void a(bwk parambwk)
  {
    Object localObject3 = null;
    AppMethodBeat.i(345063);
    this.Bjn = parambwk;
    bxq localbxq;
    label28:
    Object localObject1;
    int i;
    label59:
    label70:
    label90:
    label103:
    Object localObject2;
    ImageView localImageView1;
    ImageView localImageView2;
    Object localObject4;
    if (parambwk == null)
    {
      localbxq = null;
      if (localbxq != null) {
        break label434;
      }
      parambwk = null;
      localObject1 = parambwk;
      if (parambwk == null) {
        localObject1 = new LinkedList();
      }
      if (!((Collection)localObject1).isEmpty()) {
        break label443;
      }
      i = 1;
      if (i != 0)
      {
        if (localbxq != null) {
          break label448;
        }
        parambwk = null;
        parambwk = (CharSequence)parambwk;
        if ((parambwk != null) && (parambwk.length() != 0)) {
          break label457;
        }
        i = 1;
        if (i == 0)
        {
          if (localbxq != null) {
            break label462;
          }
          parambwk = "";
          ((LinkedList)localObject1).add(parambwk);
        }
      }
      if (((LinkedList)localObject1).isEmpty()) {
        setVisibility(8);
      }
      localObject2 = (ImageView)UH(e.e.friend_square_avatar_1);
      localImageView1 = (ImageView)UH(e.e.friend_square_avatar_2);
      localImageView2 = (ImageView)UH(e.e.friend_square_avatar_3);
      ((ImageView)localObject2).setVisibility(8);
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localObject4 = (TextView)UH(e.e.tips_tv);
      if (localbxq != null) {
        break label484;
      }
      parambwk = (bwk)localObject3;
      label201:
      if (parambwk != null) {
        break label493;
      }
      parambwk = (CharSequence)getContext().getResources().getString(e.h.finder_feed_like_tip);
      label222:
      ((TextView)localObject4).setText(parambwk);
      com.tencent.mm.plugin.finder.utils.i.setTextBold((TextView)localObject4);
      parambwk = ((TextView)localObject4).getResources();
      if (((LinkedList)localObject1).size() <= 1) {
        break label501;
      }
      i = e.c.Edge_24A;
      label252:
      ((TextView)localObject4).setMaxWidth((int)parambwk.getDimension(i));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
    }
    for (;;)
    {
      label277:
      if (!((Iterator)localObject1).hasNext()) {
        break label594;
      }
      parambwk = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject3 = (String)parambwk;
      switch (i)
      {
      default: 
        localImageView2.setVisibility(0);
        parambwk = localImageView2;
        label345:
        if (fkI())
        {
          setArrowLayoutGravity(3);
          label357:
          if ((localbxq == null) || (localbxq.show_type != 4)) {
            break label541;
          }
        }
        break;
      }
      label541:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label546;
        }
        localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject4 = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject3 = new com.tencent.mm.plugin.finder.loader.b((String)localObject3, v.FLF);
        localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject4).a(localObject3, parambwk, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        i = j;
        break label277;
        localbxq = parambwk.aafu;
        break;
        label434:
        parambwk = localbxq.aagt;
        break label28;
        label443:
        i = 0;
        break label59;
        label448:
        parambwk = localbxq.icon_url;
        break label70;
        label457:
        i = 0;
        break label90;
        label462:
        localObject2 = localbxq.icon_url;
        parambwk = (bwk)localObject2;
        if (localObject2 != null) {
          break label103;
        }
        parambwk = "";
        break label103;
        label484:
        parambwk = localbxq.title;
        break label201;
        label493:
        parambwk = (CharSequence)parambwk;
        break label222;
        label501:
        i = e.c.finder_36A;
        break label252;
        ((ImageView)localObject2).setVisibility(0);
        parambwk = (bwk)localObject2;
        break label345;
        localImageView1.setVisibility(0);
        parambwk = localImageView1;
        break label345;
        setArrowLayoutGravity(17);
        break label357;
      }
      label546:
      localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject4 = com.tencent.mm.plugin.finder.loader.p.eCq();
      localObject3 = new com.tencent.mm.plugin.finder.loader.b((String)localObject3, v.FLF);
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject4).a(localObject3, parambwk, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
      i = j;
    }
    label594:
    AppMethodBeat.o(345063);
  }
  
  public final boolean fkI()
  {
    bwk localbwk = this.Bjn;
    return (localbwk != null) && (localbwk.aaft == 2);
  }
  
  public final JSONObject getReportJson()
  {
    Object localObject3 = null;
    AppMethodBeat.i(345087);
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = this.Bjn;
    Object localObject2;
    label42:
    label69:
    long l;
    label93:
    label114:
    Object localObject4;
    label153:
    int i;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label289;
      }
      localObject1 = "";
      localJSONObject.put("wording", localObject1);
      localObject1 = this.Bjn;
      if (localObject1 != null) {
        break label313;
      }
      localObject1 = "";
      localJSONObject.put("tipsid", localObject1);
      localObject1 = this.Bjn;
      if (localObject1 != null) {
        break label337;
      }
      l = 0L;
      localJSONObject.put("feedid", com.tencent.mm.ae.d.hF(l));
      if (localObject2 != null) {
        break label346;
      }
      localObject1 = null;
      if ((localObject1 == null) || (((bxq)localObject2).aagr != 1)) {
        break label463;
      }
      localObject4 = new FinderTipsShowEntranceExtInfo();
      localObject1 = ((bxq)localObject2).aags;
      if (localObject1 != null) {
        break label356;
      }
      localObject1 = localObject3;
      ((FinderTipsShowEntranceExtInfo)localObject4).parseFrom((byte[])localObject1);
      localObject1 = (CharSequence)((FinderTipsShowEntranceExtInfo)localObject4).username;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label366;
      }
      i = 1;
    }
    label289:
    label313:
    for (;;)
    {
      label188:
      if (i != 0)
      {
        localObject1 = ((FinderTipsShowEntranceExtInfo)localObject4).multi_username;
        s.s(localObject1, "ext.multi_username");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            ((Collection)localObject1).add(s.X((String)((Iterator)localObject2).next(), "|"));
            continue;
            localObject2 = ((bwk)localObject1).aafu;
            break;
            localObject4 = ((bxq)localObject2).title;
            localObject1 = localObject4;
            if (localObject4 != null) {
              break label42;
            }
            localObject1 = "";
            break label42;
            localObject4 = ((bwk)localObject1).ZYN;
            localObject1 = localObject4;
            if (localObject4 != null) {
              break label69;
            }
            localObject1 = "";
            break label69;
            label337:
            l = ((bwk)localObject1).ZNj;
            break label93;
            label346:
            localObject1 = ((bxq)localObject2).aags;
            break label114;
            label356:
            localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray();
            break label153;
            label366:
            i = 0;
            break label188;
          }
        }
        localObject1 = (List)localObject1;
        if (!((List)localObject1).isEmpty())
        {
          localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
          while (((ListIterator)localObject2).hasPrevious()) {
            if (!s.p((String)((ListIterator)localObject2).previous(), "|"))
            {
              localObject1 = kotlin.a.p.c((Iterable)localObject1, ((ListIterator)localObject2).nextIndex() + 1);
              localJSONObject.put("friendusername", localObject1);
            }
          }
        }
      }
    }
    for (;;)
    {
      label463:
      AppMethodBeat.o(345087);
      return localJSONObject;
      localObject1 = (List)ab.aivy;
      break;
      localJSONObject.put("friendusername", String.valueOf(((FinderTipsShowEntranceExtInfo)localObject4).username));
    }
  }
  
  public final b getVisibilityListener()
  {
    return this.GzO;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(345071);
    super.onDetachedFromWindow();
    boolean bool = fhR;
    a.Qc(false);
    if (fhR != bool)
    {
      b localb = this.GzO;
      if (localb != null) {
        localb.onVisibilityChange(false);
      }
    }
    AppMethodBeat.o(345071);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(345067);
    super.setVisibility(paramInt);
    boolean bool2 = fhR;
    if (paramInt == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.Qc(bool1);
      if (fhR != bool2)
      {
        b localb = this.GzO;
        if (localb != null) {
          localb.onVisibilityChange(fhR);
        }
      }
      AppMethodBeat.o(345067);
      return;
    }
  }
  
  public final void setVisibilityListener(b paramb)
  {
    this.GzO = paramb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView$Companion;", "", "()V", "TAG", "", "isFollowBubbleClicked", "", "()Z", "setFollowBubbleClicked", "(Z)V", "isFriendBubbleClicked", "setFriendBubbleClicked", "value", "isShowing", "setShowing", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void Qc(boolean paramBoolean)
    {
      AppMethodBeat.i(370619);
      ConcurrentSkipListSet localConcurrentSkipListSet = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().DIg;
      if (paramBoolean)
      {
        localConcurrentSkipListSet.add("TLRecommendTab");
        localConcurrentSkipListSet.add("TLFollow");
      }
      for (;;)
      {
        FinderHomeTabRedDotTipsBubbleView.Qb(paramBoolean);
        AppMethodBeat.o(370619);
        return;
        localConcurrentSkipListSet.remove("TLRecommendTab");
        localConcurrentSkipListSet.remove("TLFollow");
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView$IVisibilityListener;", "", "onVisibilityChange", "", "isShow", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void onVisibilityChange(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(FinderHomeTabRedDotTipsBubbleView paramFinderHomeTabRedDotTipsBubbleView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(344400);
      this.GzQ.setVisibility(8);
      AppMethodBeat.o(344400);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderHomeTabRedDotTipsBubbleView
 * JD-Core Version:    0.7.0.1
 */