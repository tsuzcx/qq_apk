package com.tencent.mm.plugin.finder.activity.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import com.tencent.mm.plugin.finder.view.tabcomp.i;
import com.tencent.mm.plugin.finder.view.tabcomp.l;
import com.tencent.mm.plugin.finder.view.tabcomp.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isWithCover", "", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "notifyFailed", "", "responseCode", "", "errorMsg", "", "notifyHeader", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestTabFailed", "onRequestTabSuc", "tags", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/TopicHashTagInfo;", "isCovered", "request", "topicId", "", "encryptedEventTopicId", "setCoveredStyle", "setNormalStyle", "setTabViews", "Companion", "Provider", "Tab", "TabContainer", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends FinderTabUIC
{
  public static final a Awi;
  private boolean Awj;
  
  static
  {
    AppMethodBeat.i(348151);
    Awi = new a((byte)0);
    AppMethodBeat.o(348151);
  }
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348112);
    AppMethodBeat.o(348112);
  }
  
  private final void pB(boolean paramBoolean)
  {
    AppMethodBeat.i(348118);
    this.Awj = paramBoolean;
    int k = fpi();
    Iterator localIterator = getTabs().iterator();
    int i = 0;
    for (;;)
    {
      int j;
      if (localIterator.hasNext())
      {
        j = i + 1;
        Object localObject = (g)localIterator.next();
        if ((localObject instanceof c))
        {
          if (paramBoolean)
          {
            localObject = (c)localObject;
            if (i == k) {}
            for (bool = true;; bool = false)
            {
              ((c)localObject).pD(bool);
              i = j;
              break;
            }
          }
          localObject = (c)localObject;
          if (i == k) {}
          for (boolean bool = true;; bool = false)
          {
            ((c)localObject).pE(bool);
            i = j;
            break;
          }
        }
      }
      else
      {
        AppMethodBeat.o(348118);
        return;
      }
      i = j;
    }
  }
  
  public final IFinderTabProvider dTN()
  {
    AppMethodBeat.i(348157);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new b();
    AppMethodBeat.o(348157);
    return localIFinderTabProvider;
  }
  
  public final void dTr()
  {
    AppMethodBeat.i(348182);
    TabLayout localTabLayout = fmz();
    if (localTabLayout != null) {
      localTabLayout.setSelectedTabIndicatorColor(getResources().getColor(e.b.FG_0));
    }
    pB(false);
    AppMethodBeat.o(348182);
  }
  
  public final void dTw()
  {
    AppMethodBeat.i(348176);
    TabLayout localTabLayout = fmz();
    if (localTabLayout != null) {
      localTabLayout.setSelectedTabIndicatorColor(getResources().getColor(e.b.finder_activity_covered_white));
    }
    pB(true);
    AppMethodBeat.o(348176);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348165);
    super.onCreate(paramBundle);
    paramBundle = this.dyl;
    if ((paramBundle instanceof FinderViewPager)) {
      ((FinderViewPager)paramBundle).setEnableViewPagerScroll(true);
    }
    final long l = getIntent().getLongExtra("key_activity_id", 0L);
    String str = getIntent().getStringExtra("key_encrypted_topic_id");
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    if (l == 0L) {
      if (((CharSequence)paramBundle).length() != 0) {
        break label139;
      }
    }
    label139:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e("FinderActivityTabUIC", "finderEventTopicId is zero");
        getContext().finish();
      }
      e.launch$default((e)this, null, null, (kotlin.g.a.m)new e(this, l, paramBundle, null), 3, null);
      AppMethodBeat.o(348165);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$Companion;", "", "()V", "TAG", "", "preloadTopicInfo", "", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      extends k
      implements kotlin.g.a.m<aq, d<? super ah>, Object>
    {
      int label;
      
      public a(long paramLong, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(348020);
        paramd = new a(this.ocF, paramd);
        paramd.L$0 = paramObject;
        paramObject = (d)paramd;
        AppMethodBeat.o(348020);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(348019);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(348019);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (aq)this.L$0;
          Log.i("FinderActivityTabUIC", s.X("preloadTopicInfo: preload topic eventTopicId = ", kotlin.d.b.a.b.BF(this.ocF)));
          paramObject = new com.tencent.mm.plugin.datapreloader.b.a((kotlin.g.a.a)new u(this.ocF) {}, (cb)paramObject.getCoroutineContext().get((f.c)cb.ajws), (byte)0);
          d locald = (d)this;
          this.label = 1;
          if (paramObject.X(locald) == locala)
          {
            AppMethodBeat.o(348019);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(348019);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$Provider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC;)V", "isDynamic", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends FinderTabProvider
  {
    public b()
    {
      AppMethodBeat.i(348016);
      setTabContainer((n)new h.d());
      setTabViewAction((com.tencent.mm.plugin.finder.view.tabcomp.m)new l());
      this$1 = new LinkedList();
      ah localah = ah.aiuX;
      setTabs((List)this$1);
      this$1 = new LinkedList();
      localah = ah.aiuX;
      setFragments((List)this$1);
      AppMethodBeat.o(348016);
    }
    
    public final boolean isDynamic()
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$Tab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "title", "", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC;ILjava/lang/String;)V", "isCovered", "", "()Z", "setCovered", "(Z)V", "getLayoutId", "getTabMargin", "", "setCoveredStyle", "", "isSelected", "setNormalStyle", "setTextColor", "isTabSelected", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends i
  {
    boolean Awl;
    
    public c()
    {
      super((byte)0);
      AppMethodBeat.i(348021);
      this.Awl = h.a(h.this);
      AppMethodBeat.o(348021);
    }
    
    public final int[] dTO()
    {
      return new int[] { 0, 6 };
    }
    
    public final int getLayoutId()
    {
      return e.f.finder_profile_normal_tab_text;
    }
    
    public final void pC(boolean paramBoolean)
    {
      AppMethodBeat.i(348030);
      TextView localTextView = getTitleTv();
      if (localTextView != null)
      {
        if (this.Awl)
        {
          if (paramBoolean)
          {
            localTextView.setTextColor(localTextView.getContext().getResources().getColor(e.b.BW_100_Alpha_0_9));
            AppMethodBeat.o(348030);
            return;
          }
          localTextView.setTextColor(localTextView.getContext().getResources().getColor(e.b.BW_100_Alpha_0_5));
          AppMethodBeat.o(348030);
          return;
        }
        if (paramBoolean)
        {
          localTextView.setTextColor(localTextView.getContext().getResources().getColor(e.b.FG_0));
          AppMethodBeat.o(348030);
          return;
        }
        localTextView.setTextColor(localTextView.getContext().getResources().getColor(e.b.FG_1));
      }
      AppMethodBeat.o(348030);
    }
    
    public final void pD(boolean paramBoolean)
    {
      AppMethodBeat.i(348037);
      this.Awl = true;
      pC(paramBoolean);
      AppMethodBeat.o(348037);
    }
    
    public final void pE(boolean paramBoolean)
    {
      AppMethodBeat.i(348043);
      this.Awl = false;
      pC(paramBoolean);
      AppMethodBeat.o(348043);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$TabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "getLayoutId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.finder.view.tabcomp.j
  {
    public final int getLayoutId()
    {
      return e.f.finder_activity_profile_ui;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends k
    implements kotlin.g.a.m<aq, d<? super ah>, Object>
  {
    int label;
    
    e(h paramh, long paramLong, String paramString, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(348034);
      paramd = new e(this.Awk, l, this.Awn, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(348034);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(348028);
      kotlin.d.a.a locala1 = kotlin.d.a.a.aiwj;
      final ah.a locala;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(348028);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        locala = new ah.a();
        paramObject = (com.tencent.mm.plugin.datapreloader.a)new com.tencent.mm.plugin.datapreloader.b.a((kotlin.g.a.a)new a(l, this.Awn), (cb)paramObject.getCoroutineContext().get((f.c)cb.ajws), (byte)0);
        d locald = (d)this;
        this.L$0 = locala;
        this.label = 1;
        paramObject = paramObject.e(true, locald);
        if (paramObject == locala1)
        {
          AppMethodBeat.o(348028);
          return locala1;
        }
        break;
      case 1: 
        locala = (ah.a)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        paramObject = (b.a)paramObject;
        kotlinx.coroutines.j.a(this.Awk.getMainScope(), null, null, (kotlin.g.a.m)new k(paramObject, locala)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(348029);
            paramAnonymousObject = (d)new 1(this.Awo, locala, this.Awk, paramAnonymousd);
            AppMethodBeat.o(348029);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(348025);
            Object localObject1 = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(348025);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            Object localObject2;
            if ((this.Awo.errType == 0) && (this.Awo.errCode == 0))
            {
              paramAnonymousObject = (bbe)this.Awo.ott;
              if (paramAnonymousObject != null)
              {
                paramAnonymousObject = paramAnonymousObject.ZLU;
                if (paramAnonymousObject != null)
                {
                  localObject1 = this.Awk;
                  localObject2 = locala;
                  h.a(paramAnonymousObject);
                  Object localObject3 = paramAnonymousObject.aagK;
                  if (localObject3 != null)
                  {
                    localObject3 = ((awt)localObject3).ZHM;
                    if (localObject3 != null)
                    {
                      ((ah.a)localObject2).aiwY = true;
                      localObject2 = ((bxu)localObject3).lPK;
                      s.s(localObject2, "list");
                      paramAnonymousObject = paramAnonymousObject.aagK;
                      if (paramAnonymousObject != null) {
                        break label220;
                      }
                      paramAnonymousObject = null;
                      if (Util.isNullOrNil(paramAnonymousObject)) {
                        break label228;
                      }
                    }
                  }
                }
              }
            }
            label220:
            label228:
            for (boolean bool = true;; bool = false)
            {
              h.a((h)localObject1, (LinkedList)localObject2, bool);
              if (!locala.aiwY) {
                h.br(this.Awo.errCode, this.Awo.errMsg);
              }
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(348025);
              return paramAnonymousObject;
              paramAnonymousObject = paramAnonymousObject.coverImgUrl;
              break;
            }
          }
        }, 3);
        paramObject = ah.aiuX;
        AppMethodBeat.o(348028);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/datapreloader/cgi/FutureCgi;", "", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicInfoResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<com.tencent.mm.plugin.datapreloader.b.b<String, bbe>>
    {
      a(long paramLong, String paramString)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.h
 * JD-Core Version:    0.7.0.1
 */