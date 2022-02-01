package com.tencent.mm.plugin.finder.viewmodel.component;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAddHistoryUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "addToHistoryOffset", "", "getAddToHistoryOffset", "()I", "addToHistoryOffset$delegate", "Lkotlin/Lazy;", "deleteFromHistoryOffset", "getDeleteFromHistoryOffset", "deleteFromHistoryOffset$delegate", "eventObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderAddHistoryUIC$eventObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAddHistoryUIC$eventObserver$1;", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "isFromMultiTask", "", "()Z", "setFromMultiTask", "(Z)V", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "taskInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addOrUpdateHistory", "", "addToTaskbar", "video", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCurrPlayTimes", "checkRemoveHistory", "feedId", "onBackPressed", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
{
  public static final a GMP;
  private final dnq BtU;
  private final kotlin.j CNQ;
  private com.tencent.mm.plugin.finder.megavideo.multitask.a EAM;
  private final kotlin.j EAT;
  private final kotlin.j EAU;
  private final ConcurrentHashMap<Long, MultiTaskInfo> GMQ;
  public boolean GMR;
  private final f GMS;
  
  static
  {
    AppMethodBeat.i(337959);
    GMP = new a((byte)0);
    AppMethodBeat.o(337959);
  }
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337848);
    this.BtU = new dnq();
    this.CNQ = k.cm((kotlin.g.a.a)new g(this));
    this.EAT = k.cm((kotlin.g.a.a)c.GMX);
    this.EAU = k.cm((kotlin.g.a.a)e.GMZ);
    this.GMQ = new ConcurrentHashMap();
    this.GMS = new f(this);
    AppMethodBeat.o(337848);
  }
  
  public f(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(337858);
    this.BtU = new dnq();
    this.CNQ = k.cm((kotlin.g.a.a)new g(this));
    this.EAT = k.cm((kotlin.g.a.a)c.GMX);
    this.EAU = k.cm((kotlin.g.a.a)e.GMZ);
    this.GMQ = new ConcurrentHashMap();
    this.GMS = new f(this);
    AppMethodBeat.o(337858);
  }
  
  private final void fng()
  {
    AppMethodBeat.i(337874);
    Object localObject1 = getRecyclerView();
    final Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((RecyclerView)localObject1).getLayoutManager();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(337874);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((RecyclerView)localObject1).fU(((LinearLayoutManager)localObject2).Ju());
      if (!(localObject1 instanceof com.tencent.mm.view.recyclerview.j)) {
        break label155;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).CSA;
        if (((localObject2 instanceof com.tencent.mm.plugin.finder.model.ah)) && (((com.tencent.mm.plugin.finder.model.ah)localObject2).feedObject.getMegaVideo() != null) && ((!((com.tencent.mm.plugin.finder.model.ah)localObject2).ECR) || (this.GMR)))
        {
          localObject1 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.finder_banner_video_layout);
          if (localObject1 != null) {
            break label160;
          }
        }
      }
    }
    label155:
    label160:
    for (final int i = 0;; i = ((FinderVideoLayout)localObject1).getCurrentPosSec())
    {
      com.tencent.mm.ae.d.d("addHistory", (kotlin.g.a.a)new b(this, localObject2, i));
      AppMethodBeat.o(337874);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(337863);
    RecyclerView localRecyclerView = (RecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(337863);
    return localRecyclerView;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(337981);
    if (this.GMR)
    {
      fng();
      com.tencent.mm.plugin.finder.megavideo.multitask.a locala2 = this.EAM;
      com.tencent.mm.plugin.finder.megavideo.multitask.a locala1 = locala2;
      if (locala2 == null)
      {
        s.bIx("multiTaskHelper");
        locala1 = null;
      }
      locala1.af(2, false);
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(337981);
    return bool;
  }
  
  /* Error */
  public final void onCreateAfter(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 545
    //   5: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 547	com/tencent/mm/ui/component/UIComponent:onCreateAfter	(Landroid/os/Bundle;)V
    //   13: aload_0
    //   14: invokevirtual 551	com/tencent/mm/plugin/finder/viewmodel/component/f:getIntent	()Landroid/content/Intent;
    //   17: ldc_w 553
    //   20: invokevirtual 559	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   23: astore_3
    //   24: getstatic 565	com/tencent/mm/plugin/finder/report/z:FrZ	Lcom/tencent/mm/plugin/finder/report/z;
    //   27: astore_1
    //   28: invokestatic 568	com/tencent/mm/plugin/finder/report/z:bUm	()Ljava/lang/String;
    //   31: astore_1
    //   32: aload_3
    //   33: ifnull +301 -> 334
    //   36: aload_0
    //   37: getfield 137	com/tencent/mm/plugin/finder/viewmodel/component/f:BtU	Lcom/tencent/mm/protocal/protobuf/dnq;
    //   40: aload_3
    //   41: invokevirtual 572	com/tencent/mm/protocal/protobuf/dnq:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   44: pop
    //   45: aload_0
    //   46: getfield 137	com/tencent/mm/plugin/finder/viewmodel/component/f:BtU	Lcom/tencent/mm/protocal/protobuf/dnq;
    //   49: getfield 575	com/tencent/mm/protocal/protobuf/dnq:key	Ljava/lang/String;
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull +275 -> 329
    //   57: getstatic 439	kotlin/ah:aiuX	Lkotlin/ah;
    //   60: astore_1
    //   61: aload_3
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual 211	com/tencent/mm/plugin/finder/viewmodel/component/f:getContext	()Landroid/app/Activity;
    //   67: checkcast 225	android/content/Context
    //   70: astore_3
    //   71: aload_0
    //   72: invokevirtual 211	com/tencent/mm/plugin/finder/viewmodel/component/f:getContext	()Landroid/app/Activity;
    //   75: astore 4
    //   77: aload_0
    //   78: invokevirtual 211	com/tencent/mm/plugin/finder/viewmodel/component/f:getContext	()Landroid/app/Activity;
    //   81: invokevirtual 579	android/app/Activity:getWindow	()Landroid/view/Window;
    //   84: invokevirtual 585	android/view/Window:getDecorView	()Landroid/view/View;
    //   87: astore 5
    //   89: aload 5
    //   91: ldc_w 587
    //   94: invokestatic 590	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   97: aload_0
    //   98: new 394	com/tencent/mm/plugin/finder/megavideo/multitask/a
    //   101: dup
    //   102: aload_3
    //   103: new 592	com/tencent/mm/plugin/finder/megavideo/multitask/b
    //   106: dup
    //   107: aload 4
    //   109: aconst_null
    //   110: aload 5
    //   112: invokespecial 595	com/tencent/mm/plugin/finder/megavideo/multitask/b:<init>	(Landroid/app/Activity;Lcom/tencent/mm/ui/base/CustomViewPager;Landroid/view/View;)V
    //   115: checkcast 597	com/tencent/mm/plugin/multitask/a/a
    //   118: invokespecial 600	com/tencent/mm/plugin/finder/megavideo/multitask/a:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/multitask/a/a;)V
    //   121: putfield 305	com/tencent/mm/plugin/finder/viewmodel/component/f:EAM	Lcom/tencent/mm/plugin/finder/megavideo/multitask/a;
    //   124: aload_0
    //   125: getfield 305	com/tencent/mm/plugin/finder/viewmodel/component/f:EAM	Lcom/tencent/mm/plugin/finder/megavideo/multitask/a;
    //   128: astore 4
    //   130: aload 4
    //   132: astore_3
    //   133: aload 4
    //   135: ifnonnull +11 -> 146
    //   138: ldc_w 306
    //   141: invokestatic 310	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_3
    //   147: bipush 22
    //   149: aload_1
    //   150: invokevirtual 603	com/tencent/mm/plugin/finder/megavideo/multitask/a:J	(ILjava/lang/String;)V
    //   153: iload_2
    //   154: ifeq +50 -> 204
    //   157: aload_0
    //   158: getfield 305	com/tencent/mm/plugin/finder/viewmodel/component/f:EAM	Lcom/tencent/mm/plugin/finder/megavideo/multitask/a;
    //   161: astore_3
    //   162: aload_3
    //   163: astore_1
    //   164: aload_3
    //   165: ifnonnull +11 -> 176
    //   168: ldc_w 306
    //   171: invokestatic 310	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
    //   174: aconst_null
    //   175: astore_1
    //   176: aload_1
    //   177: getfield 316	com/tencent/mm/plugin/multitask/b/a:LCE	Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;
    //   180: astore_1
    //   181: aload_1
    //   182: ifnull +22 -> 204
    //   185: aload_0
    //   186: getfield 167	com/tencent/mm/plugin/finder/viewmodel/component/f:GMQ	Ljava/util/concurrent/ConcurrentHashMap;
    //   189: aload_1
    //   190: getfield 332	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_id	Ljava/lang/String;
    //   193: invokestatic 607	com/tencent/mm/ae/d:FK	(Ljava/lang/String;)J
    //   196: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   199: aload_1
    //   200: invokevirtual 343	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   203: pop
    //   204: aload_0
    //   205: invokevirtual 611	com/tencent/mm/plugin/finder/viewmodel/component/f:getFragment	()Landroidx/fragment/app/Fragment;
    //   208: astore_1
    //   209: aload_1
    //   210: instanceof 613
    //   213: ifeq +91 -> 304
    //   216: aload_1
    //   217: checkcast 613	com/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment
    //   220: astore_1
    //   221: aload_1
    //   222: ifnonnull +87 -> 309
    //   225: iconst_m1
    //   226: istore_2
    //   227: getstatic 619	com/tencent/mm/ui/component/k:aeZF	Lcom/tencent/mm/ui/component/k;
    //   230: astore_1
    //   231: aload_0
    //   232: invokevirtual 211	com/tencent/mm/plugin/finder/viewmodel/component/f:getContext	()Landroid/app/Activity;
    //   235: checkcast 225	android/content/Context
    //   238: invokestatic 623	com/tencent/mm/ui/component/k:nq	(Landroid/content/Context;)Lcom/tencent/mm/ui/component/k$b;
    //   241: ldc_w 625
    //   244: invokevirtual 631	com/tencent/mm/ui/component/k$b:q	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   247: checkcast 625	com/tencent/mm/plugin/finder/viewmodel/component/as
    //   250: iload_2
    //   251: invokevirtual 635	com/tencent/mm/plugin/finder/viewmodel/component/as:Vm	(I)Lcom/tencent/mm/plugin/finder/event/base/c;
    //   254: astore_1
    //   255: aload_1
    //   256: ifnull +14 -> 270
    //   259: aload_1
    //   260: aload_0
    //   261: getfield 170	com/tencent/mm/plugin/finder/viewmodel/component/f:GMS	Lcom/tencent/mm/plugin/finder/viewmodel/component/f$f;
    //   264: checkcast 637	com/tencent/mm/plugin/finder/event/base/d
    //   267: invokevirtual 642	com/tencent/mm/plugin/finder/event/base/c:a	(Lcom/tencent/mm/plugin/finder/event/base/d;)V
    //   270: ldc_w 545
    //   273: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: return
    //   277: astore_3
    //   278: iconst_0
    //   279: istore_2
    //   280: ldc_w 399
    //   283: ldc_w 643
    //   286: iconst_1
    //   287: anewarray 231	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: aload_3
    //   293: aastore
    //   294: invokestatic 646	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: getstatic 439	kotlin/ah:aiuX	Lkotlin/ah;
    //   300: astore_3
    //   301: goto -238 -> 63
    //   304: aconst_null
    //   305: astore_1
    //   306: goto -85 -> 221
    //   309: aload_1
    //   310: getfield 649	com/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment:hJx	I
    //   313: istore_2
    //   314: goto -87 -> 227
    //   317: astore 4
    //   319: iconst_1
    //   320: istore_2
    //   321: aload_3
    //   322: astore_1
    //   323: aload 4
    //   325: astore_3
    //   326: goto -46 -> 280
    //   329: iconst_0
    //   330: istore_2
    //   331: goto -268 -> 63
    //   334: iconst_0
    //   335: istore_2
    //   336: goto -273 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	f
    //   0	339	1	paramBundle	android.os.Bundle
    //   1	335	2	i	int
    //   23	142	3	localObject1	Object
    //   277	16	3	localObject2	Object
    //   300	26	3	localObject3	Object
    //   75	59	4	localObject4	Object
    //   317	7	4	localObject5	Object
    //   87	24	5	localView	android.view.View
    // Exception table:
    //   from	to	target	type
    //   36	53	277	finally
    //   57	61	317	finally
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(337996);
    super.onPause();
    com.tencent.mm.plugin.finder.megavideo.multitask.a locala2 = this.EAM;
    com.tencent.mm.plugin.finder.megavideo.multitask.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("multiTaskHelper");
      locala1 = null;
    }
    locala1.bhW();
    AppMethodBeat.o(337996);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(337989);
    super.onResume();
    com.tencent.mm.plugin.finder.megavideo.multitask.a locala2 = this.EAM;
    com.tencent.mm.plugin.finder.megavideo.multitask.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("multiTaskHelper");
      locala1 = null;
    }
    locala1.coi();
    AppMethodBeat.o(337989);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAddHistoryUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(f paramf, Object paramObject, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final c GMX;
    
    static
    {
      AppMethodBeat.i(338547);
      GMX = new c();
      AppMethodBeat.o(338547);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(f paramf, long paramLong)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<kotlin.ah>
    {
      a(f paramf, MultiTaskInfo paramMultiTaskInfo)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final e GMZ;
    
    static
    {
      AppMethodBeat.i(338534);
      GMZ = new e();
      AppMethodBeat.o(338534);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderAddHistoryUIC$eventObserver$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    f(f paramf) {}
    
    public final void a(final b paramb)
    {
      Object localObject2 = null;
      AppMethodBeat.i(338551);
      s.u(paramb, "ev");
      Object localObject1;
      label64:
      f localf;
      label93:
      int i;
      if (((paramb instanceof c.a)) && (((c.a)paramb).type == 3))
      {
        localObject1 = f.c(this.GMU);
        Object localObject3;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (!(localObject1 instanceof WxRecyclerAdapter)) {
            break label197;
          }
          localObject1 = (WxRecyclerAdapter)localObject1;
          if (localObject1 == null) {
            break label396;
          }
          localf = this.GMU;
          localObject3 = ((Iterable)((WxRecyclerAdapter)localObject1).data).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label208;
          }
          localObject1 = ((Iterator)localObject3).next();
          if (((cc)localObject1).bZA() != ((c.a)paramb).feedId) {
            break label203;
          }
          i = 1;
          label135:
          if (i == 0) {
            break label206;
          }
        }
        for (;;)
        {
          localObject3 = (cc)localObject1;
          localObject1 = localObject2;
          if ((localObject3 instanceof com.tencent.mm.plugin.finder.model.ah)) {
            localObject1 = (com.tencent.mm.plugin.finder.model.ah)localObject3;
          }
          if (localObject1 == null) {
            break label396;
          }
          if (((BaseFinderFeed)localObject1).feedObject.getMegaVideo() != null) {
            break label214;
          }
          AppMethodBeat.o(338551);
          return;
          localObject1 = ((RecyclerView)localObject1).getAdapter();
          break;
          label197:
          localObject1 = null;
          break label64;
          label203:
          i = 0;
          break label135;
          label206:
          break label93;
          label208:
          localObject1 = null;
        }
        label214:
        i = f.d(localf);
        int j = ((c.a)paramb).total;
        int k = f.e(localf);
        int m = ((c.a)paramb).offset;
        if (i > m) {
          break label407;
        }
        if (m > j - k) {
          break label402;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          ((com.tencent.mm.plugin.finder.model.ah)localObject1).ECR = false;
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(localf));
        }
        if ((((c.a)paramb).offset >= ((c.a)paramb).total - f.e(localf)) && (!((com.tencent.mm.plugin.finder.model.ah)localObject1).ECR))
        {
          Log.i("FinderAddHistoryUIC", "onEventHappen: delete from history, offset = " + ((c.a)paramb).offset + ", total = " + ((c.a)paramb).total + ", feedId = " + ((c.a)paramb).feedId);
          ((com.tencent.mm.plugin.finder.model.ah)localObject1).ECR = true;
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(localf, paramb));
        }
        label396:
        AppMethodBeat.o(338551);
        return;
        label402:
        i = 0;
        continue;
        label407:
        i = 0;
      }
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(338557);
      s.u(paramc, "dispatcher");
      s.u(paramb, "event");
      if (((paramb instanceof c.a)) && (((c.a)paramb).type == 3))
      {
        AppMethodBeat.o(338557);
        return true;
      }
      AppMethodBeat.o(338557);
      return false;
    }
    
    public final boolean dXA()
    {
      return false;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<kotlin.ah>
    {
      a(f paramf)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<kotlin.ah>
    {
      b(f paramf, b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    g(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.f
 * JD-Core Version:    0.7.0.1
 */