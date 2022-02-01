package com.tencent.mm.plugin.finder.megavideo.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.megavideo.ui.h.a;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.plugin.finder.report.ax;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "getFloatBallInfo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "setFloatBallInfo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;)V", "isFromVideoFloatBall", "", "()Z", "isFromVideoFloatBall$delegate", "Lkotlin/Lazy;", "isMultiTask", "multiTaskHelpter", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "getMultiTaskHelpter", "()Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "setMultiTaskHelpter", "(Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;)V", "multiTaskIntent", "Landroid/content/Intent;", "getMultiTaskIntent", "()Landroid/content/Intent;", "setMultiTaskIntent", "(Landroid/content/Intent;)V", "needToReinit", "getNeedToReinit", "setNeedToReinit", "(Z)V", "videoFloatBallHelper", "Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;", "getVideoFloatBallHelper", "()Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;", "setVideoFloatBallHelper", "(Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;)V", "videoFloatBallInfo", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getPresenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "initMultiTaskData", "", "key", "", "positon", "initVideoFloatBallData", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onResume", "onStart", "onStop", "supportMultiTaskType", "multiTaskType", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends com.tencent.mm.plugin.multitask.ui.c
{
  public static final a EBC = new a((byte)0);
  private boolean BmH;
  private dnq BtU = new dnq();
  private dnq EAN = new dnq();
  protected com.tencent.mm.plugin.finder.megavideo.multitask.a EBD;
  protected com.tencent.mm.plugin.finder.megavideo.floatball.b EBE;
  private Intent EBF;
  private boolean EBG;
  private final kotlin.j EBH = k.cm((kotlin.g.a.a)new b(this));
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  private void ayM(String paramString)
  {
    if (this.EBD == null) {
      if (paramString == null)
      {
        paramString = getActivity().getIntent().getByteArrayExtra("KEY_FLOAT_BALL_INFO");
        if (paramString != null) {
          this.EBG = true;
        }
      }
    }
    try
    {
      this.BtU.parseFrom(paramString);
      paramString = this.BtU.key;
      if (paramString != null) {
        this.BmH = true;
      }
      com.tencent.mm.plugin.finder.megavideo.multitask.a locala = new com.tencent.mm.plugin.finder.megavideo.multitask.a((Context)getActivity(), (com.tencent.mm.plugin.multitask.a.a)new com.tencent.mm.plugin.finder.megavideo.multitask.b((Activity)getActivity(), this.LBs, getRootView()));
      s.u(locala, "<set-?>");
      this.EBD = locala;
      locala = eCX();
      if (paramString == null)
      {
        paramString = z.FrZ;
        paramString = z.bUm();
        locala.J(22, paramString);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("BaseMegaVideoUIC", "initFloatBallData", new Object[] { paramString });
        paramString = ah.aiuX;
      }
    }
  }
  
  private com.tencent.mm.plugin.finder.megavideo.multitask.a eCX()
  {
    com.tencent.mm.plugin.finder.megavideo.multitask.a locala = this.EBD;
    if (locala != null) {
      return locala;
    }
    s.bIx("multiTaskHelpter");
    return null;
  }
  
  private com.tencent.mm.plugin.finder.megavideo.floatball.b eCY()
  {
    com.tencent.mm.plugin.finder.megavideo.floatball.b localb = this.EBE;
    if (localb != null) {
      return localb;
    }
    s.bIx("videoFloatBallHelper");
    return null;
  }
  
  private final boolean eDb()
  {
    return ((Boolean)this.EBH.getValue()).booleanValue();
  }
  
  public final boolean Qs(int paramInt)
  {
    return paramInt == 22;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject)
  {
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    s.u(paramdrt, "animateData");
    paramObject = com.tencent.mm.plugin.finder.megavideo.multitask.a.EzW;
    if (paramView == null)
    {
      paramView = null;
      if (!(paramView instanceof Activity)) {
        break label53;
      }
    }
    label53:
    for (paramView = (Activity)paramView;; paramView = null)
    {
      com.tencent.mm.plugin.finder.megavideo.multitask.a.a.a(paramMultiTaskInfo, paramdrt, true, paramView);
      return;
      paramView = paramView.getContext();
      break;
    }
  }
  
  protected final Intent eCZ()
  {
    return this.EBF;
  }
  
  protected final boolean eDa()
  {
    return this.EBG;
  }
  
  public abstract h.a eDc();
  
  public final void eDd() {}
  
  public final com.tencent.mm.plugin.multitask.ui.a.b eDe()
  {
    return com.tencent.mm.plugin.multitask.ui.a.b.LDq;
  }
  
  /* Error */
  public final void fw(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 309
    //   4: ifeq +152 -> 156
    //   7: aload_1
    //   8: checkcast 309	com/tencent/mm/plugin/multitask/model/MultiTaskInfo
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +196 -> 209
    //   16: new 133	com/tencent/mm/protocal/protobuf/dnq
    //   19: dup
    //   20: invokespecial 135	com/tencent/mm/protocal/protobuf/dnq:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc 213
    //   27: invokestatic 129	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_2
    //   32: putfield 137	com/tencent/mm/plugin/finder/megavideo/uic/a:BtU	Lcom/tencent/mm/protocal/protobuf/dnq;
    //   35: aload_0
    //   36: getfield 137	com/tencent/mm/plugin/finder/megavideo/uic/a:BtU	Lcom/tencent/mm/protocal/protobuf/dnq;
    //   39: aload_1
    //   40: getfield 313	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_data	[B
    //   43: invokevirtual 182	com/tencent/mm/protocal/protobuf/dnq:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   46: pop
    //   47: new 172	android/content/Intent
    //   50: dup
    //   51: invokespecial 314	android/content/Intent:<init>	()V
    //   54: astore_2
    //   55: getstatic 320	com/tencent/mm/plugin/finder/utils/av:GiL	Lcom/tencent/mm/plugin/finder/utils/av;
    //   58: astore_3
    //   59: aload_0
    //   60: getfield 137	com/tencent/mm/plugin/finder/megavideo/uic/a:BtU	Lcom/tencent/mm/protocal/protobuf/dnq;
    //   63: getfield 324	com/tencent/mm/protocal/protobuf/dnq:aaUQ	Ljava/util/LinkedList;
    //   66: astore_3
    //   67: aload_3
    //   68: ldc_w 326
    //   71: invokestatic 329	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   74: aload_3
    //   75: checkcast 331	java/lang/Iterable
    //   78: astore 4
    //   80: new 333	java/util/ArrayList
    //   83: dup
    //   84: aload 4
    //   86: bipush 10
    //   88: invokestatic 338	kotlin/a/p:a	(Ljava/lang/Iterable;I)I
    //   91: invokespecial 341	java/util/ArrayList:<init>	(I)V
    //   94: checkcast 343	java/util/Collection
    //   97: astore_3
    //   98: aload 4
    //   100: invokeinterface 347 1 0
    //   105: astore 4
    //   107: aload 4
    //   109: invokeinterface 352 1 0
    //   114: ifeq +67 -> 181
    //   117: aload 4
    //   119: invokeinterface 355 1 0
    //   124: checkcast 357	com/tencent/mm/protocal/protobuf/FinderObject
    //   127: astore 5
    //   129: aload 5
    //   131: ldc_w 359
    //   134: invokestatic 329	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   137: aload_3
    //   138: new 361	com/tencent/mm/plugin/finder/model/ca
    //   141: dup
    //   142: aload 5
    //   144: invokespecial 364	com/tencent/mm/plugin/finder/model/ca:<init>	(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V
    //   147: invokeinterface 368 2 0
    //   152: pop
    //   153: goto -46 -> 107
    //   156: aconst_null
    //   157: astore_1
    //   158: goto -146 -> 12
    //   161: astore_2
    //   162: ldc 233
    //   164: ldc_w 369
    //   167: iconst_1
    //   168: anewarray 237	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_2
    //   174: aastore
    //   175: invokestatic 243	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: goto -131 -> 47
    //   181: iconst_0
    //   182: aload_3
    //   183: checkcast 371	java/util/List
    //   186: aconst_null
    //   187: aload_2
    //   188: invokestatic 374	com/tencent/mm/plugin/finder/utils/av:a	(ILjava/util/List;Lcom/tencent/mm/bx/b;Landroid/content/Intent;)V
    //   191: getstatic 249	kotlin/ah:aiuX	Lkotlin/ah;
    //   194: astore_3
    //   195: aload_0
    //   196: aload_2
    //   197: putfield 293	com/tencent/mm/plugin/finder/megavideo/uic/a:EBF	Landroid/content/Intent;
    //   200: aload_0
    //   201: aload_1
    //   202: getfield 377	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_id	Ljava/lang/String;
    //   205: iconst_2
    //   206: invokestatic 379	com/tencent/mm/plugin/finder/megavideo/uic/a:a	(Lcom/tencent/mm/plugin/finder/megavideo/uic/a;Ljava/lang/String;I)V
    //   209: aload_0
    //   210: iconst_1
    //   211: putfield 187	com/tencent/mm/plugin/finder/megavideo/uic/a:BmH	Z
    //   214: getstatic 385	com/tencent/mm/ui/component/k:aeZF	Lcom/tencent/mm/ui/component/k;
    //   217: astore_1
    //   218: aload_0
    //   219: invokevirtual 163	com/tencent/mm/plugin/finder/megavideo/uic/a:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   222: invokestatic 389	com/tencent/mm/ui/component/k:d	(Landroidx/appcompat/app/AppCompatActivity;)Lcom/tencent/mm/ui/component/k$b;
    //   225: ldc_w 391
    //   228: invokevirtual 397	com/tencent/mm/ui/component/k$b:q	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   231: astore_1
    //   232: aload_1
    //   233: ldc_w 399
    //   236: invokestatic 329	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   239: new 401	com/tencent/mm/plugin/finder/viewmodel/component/i$b
    //   242: dup
    //   243: aload_1
    //   244: checkcast 391	com/tencent/mm/plugin/finder/viewmodel/component/i
    //   247: invokespecial 403	com/tencent/mm/plugin/finder/viewmodel/component/i$b:<init>	(Ljava/lang/Object;)V
    //   250: pop
    //   251: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	a
    //   0	252	1	paramObject	Object
    //   23	32	2	localObject1	Object
    //   161	36	2	localIntent	Intent
    //   58	137	3	localObject2	Object
    //   78	40	4	localObject3	Object
    //   127	16	5	localFinderObject	com.tencent.mm.protocal.protobuf.FinderObject
    // Exception table:
    //   from	to	target	type
    //   16	47	161	finally
  }
  
  public boolean onBackPressed()
  {
    return eDc().sN(false);
  }
  
  public void onBeforeFinish(Intent paramIntent)
  {
    long l2 = 0L;
    super.onBeforeFinish(paramIntent);
    if (paramIntent != null)
    {
      Log.i("BaseMegaVideoUIC", "onBeforeFinish: has been set result data");
      return;
    }
    paramIntent = eDc().eCR().getRecyclerView();
    Object localObject = paramIntent.getLayoutManager();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }
    paramIntent = paramIntent.fU(((LinearLayoutManager)localObject).Ju());
    t localt;
    long l1;
    if ((paramIntent instanceof com.tencent.mm.view.recyclerview.j))
    {
      paramIntent = (com.tencent.mm.view.recyclerview.j)paramIntent;
      localObject = new Intent();
      if (paramIntent != null)
      {
        paramIntent = (FinderVideoLayout)paramIntent.UH(e.e.finder_banner_video_layout);
        if (paramIntent != null)
        {
          localt = paramIntent.getVideoView();
          if (localt != null) {
            break label170;
          }
          l1 = 0L;
          label124:
          paramIntent = paramIntent.getPlayInfo();
          if (paramIntent != null) {
            break label181;
          }
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("KEY_VIDEO_START_PLAY_TIME_MS", l1);
      ((Intent)localObject).putExtra("KEY_CACHE_OBJECT_ID", l2);
      getContext().setResult(-1, (Intent)localObject);
      return;
      paramIntent = null;
      break;
      label170:
      l1 = localt.getCurrentPlayMs();
      break label124;
      label181:
      paramIntent = paramIntent.feed;
      if (paramIntent != null) {
        l2 = paramIntent.getFeedId();
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    h.a locala = eDc();
    if (paramConfiguration.orientation == 2) {}
    for (boolean bool = true;; bool = false)
    {
      locala.sM(bool);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    a(this, null, 3);
    paramBundle = getActivity().getIntent().getByteArrayExtra("KEY_VIDEO_FLOAT_BALL_INFO");
    if (paramBundle != null) {}
    try
    {
      this.EAN.parseFrom(paramBundle);
      if (Util.isNullOrNil(this.EAN.key))
      {
        paramBundle = this.EAN;
        z localz = z.FrZ;
        paramBundle.key = z.bUm();
      }
      paramBundle = new com.tencent.mm.plugin.finder.megavideo.floatball.b((Context)getActivity(), (f)new com.tencent.mm.plugin.finder.megavideo.floatball.c((Activity)getActivity()));
      s.u(paramBundle, "<set-?>");
      this.EBE = paramBundle;
      eCY().J(22, this.EAN.key);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("BaseMegaVideoUIC", "initFloatBallData", new Object[] { paramBundle });
        paramBundle = ah.aiuX;
      }
    }
  }
  
  public void onCreateAfter(Bundle paramBundle)
  {
    eDc().a(eCX(), this.BtU, this.BmH);
    eDc().a(eCY(), this.EAN);
  }
  
  public void onDestroy()
  {
    if (this.EBD != null) {
      eCX();
    }
    if (this.EBE != null) {
      eCY().onDestroy();
    }
  }
  
  public void onPause()
  {
    eDc().onUIPause();
    Object localObject;
    if (getActivity().isFinishing())
    {
      localObject = ax.Fur;
      ax.eNV();
    }
    if (this.EBD != null) {
      eCX().bhW();
    }
    if (this.EBE != null) {
      eCY().bhW();
    }
    if ((eDb()) && (getActivity().isFinishing()))
    {
      localObject = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a.eCH().Or(eDc().ecg());
    }
  }
  
  public void onResume()
  {
    eDc();
    if (this.EBD != null) {
      eCX().coi();
    }
    if (this.EBE != null) {
      eCY().coi();
    }
  }
  
  public void onStart()
  {
    if (eDb())
    {
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a locala = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a.eCH().egp();
    }
    super.onStart();
  }
  
  public void onStop()
  {
    if (eDb())
    {
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a locala = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a.eCH().Or(eDc().ecg());
    }
    super.onStop();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.a
 * JD-Core Version:    0.7.0.1
 */