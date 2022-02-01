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
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.megavideo.ui.h.a;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.s;
import com.tencent.mm.plugin.finder.viewmodel.component.k;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "getFloatBallInfo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "setFloatBallInfo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;)V", "isFromVideoFloatBall", "", "()Z", "isFromVideoFloatBall$delegate", "Lkotlin/Lazy;", "isMultiTask", "multiTaskHelpter", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "getMultiTaskHelpter", "()Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "setMultiTaskHelpter", "(Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;)V", "multiTaskIntent", "Landroid/content/Intent;", "getMultiTaskIntent", "()Landroid/content/Intent;", "setMultiTaskIntent", "(Landroid/content/Intent;)V", "needToReinit", "getNeedToReinit", "setNeedToReinit", "(Z)V", "videoFloatBallHelper", "Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;", "getVideoFloatBallHelper", "()Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;", "setVideoFloatBallHelper", "(Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;)V", "videoFloatBallInfo", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getPresenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "initMultiTaskData", "", "key", "", "positon", "initVideoFloatBallData", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onResume", "onStart", "onStop", "supportMultiTaskType", "multiTaskType", "", "Companion", "plugin-finder_release"})
public abstract class a
  extends com.tencent.mm.plugin.multitask.ui.c
{
  public static final a zyP = new a((byte)0);
  private cwl xMx = new cwl();
  private boolean xMy;
  private cwl zxK = new cwl();
  protected com.tencent.mm.plugin.finder.megavideo.multitask.a zyK;
  protected com.tencent.mm.plugin.finder.megavideo.floatball.b zyL;
  private Intent zyM;
  private boolean zyN;
  private final kotlin.f zyO = kotlin.g.ar((kotlin.g.a.a)new b(this));
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  private void aDq(String paramString)
  {
    if (((a)this).zyK == null) {
      if (paramString == null)
      {
        paramString = getActivity().getIntent().getByteArrayExtra("KEY_FLOAT_BALL_INFO");
        if (paramString != null) {
          this.zyN = true;
        }
      }
    }
    try
    {
      this.xMx.parseFrom(paramString);
      paramString = this.xMx.key;
      if (paramString != null) {
        this.xMy = true;
      }
      this.zyK = new com.tencent.mm.plugin.finder.megavideo.multitask.a((Context)getActivity(), (com.tencent.mm.plugin.multitask.a.a)new com.tencent.mm.plugin.finder.megavideo.multitask.b((Activity)getActivity(), this.FFs, getRootView()));
      com.tencent.mm.plugin.finder.megavideo.multitask.a locala = this.zyK;
      if (locala == null) {
        p.bGy("multiTaskHelpter");
      }
      if (paramString == null)
      {
        paramString = n.zWF;
        paramString = n.dPD();
        locala.I(22, paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Log.e("BaseMegaVideoUIC", "initFloatBallData", new Object[] { paramString });
        paramString = x.aazN;
      }
    }
  }
  
  private final boolean dKm()
  {
    return ((Boolean)this.zyO.getValue()).booleanValue();
  }
  
  public final boolean Of(int paramInt)
  {
    return paramInt == 22;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Object paramObject)
  {
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    p.k(paramdal, "animateData");
    paramObject = com.tencent.mm.plugin.finder.megavideo.multitask.a.zwX;
    if (paramView != null) {}
    for (paramView = paramView.getContext();; paramView = null)
    {
      paramObject = paramView;
      if (!(paramView instanceof Activity)) {
        paramObject = null;
      }
      com.tencent.mm.plugin.finder.megavideo.multitask.a.a.a(paramMultiTaskInfo, paramdal, true, (Activity)paramObject);
      return;
    }
  }
  
  protected final Intent dKk()
  {
    return this.zyM;
  }
  
  protected final boolean dKl()
  {
    return this.zyN;
  }
  
  public abstract h.a dKn();
  
  public final void dKo() {}
  
  public final com.tencent.mm.plugin.multitask.ui.a.b dKp()
  {
    return com.tencent.mm.plugin.multitask.ui.a.b.FHX;
  }
  
  public final void dp(Object paramObject)
  {
    if (!(paramObject instanceof MultiTaskInfo)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (MultiTaskInfo)paramObject;
      if (paramObject != null) {
        try
        {
          this.xMx = new cwl();
          this.xMx.parseFrom(paramObject.field_data);
          Intent localIntent = new Intent();
          localObject1 = aj.AGc;
          localObject1 = this.xMx.TFk;
          p.j(localObject1, "floatBallInfo.cacheNewVideoList");
          Object localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            FinderObject localFinderObject = (FinderObject)((Iterator)localObject2).next();
            p.j(localFinderObject, "it");
            ((Collection)localObject1).add(new bs(localFinderObject));
          }
        }
        catch (Throwable localThrowable)
        {
          Object localObject1;
          for (;;)
          {
            Log.e("BaseMegaVideoUIC", "onMultiTaskInit", new Object[] { localThrowable });
          }
          aj.a(0, (List)localObject1, null, localThrowable);
          this.zyM = localThrowable;
          a(this, paramObject.field_id, 2);
        }
      }
      this.xMy = true;
      paramObject = com.tencent.mm.ui.component.g.Xox;
      paramObject = com.tencent.mm.ui.component.g.b(getActivity()).i(com.tencent.mm.plugin.finder.viewmodel.component.j.class);
      p.j(paramObject, "UICProvider.of(activity)…entDrawerUIC::class.java)");
      new k((com.tencent.mm.plugin.finder.viewmodel.component.j)paramObject);
      return;
    }
  }
  
  public boolean onBackPressed()
  {
    return dKn().pQ(false);
  }
  
  public void onBeforeFinish(Intent paramIntent)
  {
    long l3 = 0L;
    super.onBeforeFinish(paramIntent);
    if (paramIntent != null)
    {
      Log.i("BaseMegaVideoUIC", "onBeforeFinish: has been set result data");
      return;
    }
    paramIntent = dKn().dJY().getRecyclerView();
    Object localObject = paramIntent.getLayoutManager();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }
    localObject = paramIntent.cK(((LinearLayoutManager)localObject).kJ());
    paramIntent = (Intent)localObject;
    if (!(localObject instanceof i)) {
      paramIntent = null;
    }
    localObject = (i)paramIntent;
    paramIntent = new Intent();
    s locals;
    if (localObject != null)
    {
      localObject = (FinderVideoLayout)((i)localObject).RD(b.f.finder_banner_video_layout);
      if (localObject != null)
      {
        locals = ((FinderVideoLayout)localObject).getVideoView();
        if (locals == null) {
          break label210;
        }
      }
    }
    label210:
    for (long l1 = locals.getCurrentPlayMs();; l1 = 0L)
    {
      localObject = ((FinderVideoLayout)localObject).getPlayInfo();
      long l2 = l3;
      if (localObject != null)
      {
        localObject = ((FinderVideoLayout.b)localObject).feed;
        l2 = l3;
        if (localObject != null) {
          l2 = ((FeedData)localObject).getFeedId();
        }
      }
      paramIntent.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", l1);
      paramIntent.putExtra("KEY_CACHE_OBJECT_ID", l2);
      getContext().setResult(-1, paramIntent);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    h.a locala = dKn();
    if (paramConfiguration.orientation == 2) {}
    for (boolean bool = true;; bool = false)
    {
      locala.pP(bool);
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
      this.zxK.parseFrom(paramBundle);
      if (Util.isNullOrNil(this.zxK.key))
      {
        paramBundle = this.zxK;
        n localn = n.zWF;
        paramBundle.key = n.dPD();
      }
      this.zyL = new com.tencent.mm.plugin.finder.megavideo.floatball.b((Context)getActivity(), (com.tencent.mm.plugin.ball.a.f)new com.tencent.mm.plugin.finder.megavideo.floatball.c((Activity)getActivity()));
      paramBundle = this.zyL;
      if (paramBundle == null) {
        p.bGy("videoFloatBallHelper");
      }
      paramBundle.I(22, this.zxK.key);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        Log.e("BaseMegaVideoUIC", "initFloatBallData", new Object[] { paramBundle });
        paramBundle = x.aazN;
      }
    }
  }
  
  public void onCreateAfter(Bundle paramBundle)
  {
    paramBundle = dKn();
    Object localObject = this.zyK;
    if (localObject == null) {
      p.bGy("multiTaskHelpter");
    }
    paramBundle.a((com.tencent.mm.plugin.finder.megavideo.multitask.a)localObject, this.xMx, this.xMy);
    paramBundle = dKn();
    localObject = this.zyL;
    if (localObject == null) {
      p.bGy("videoFloatBallHelper");
    }
    paramBundle.a((com.tencent.mm.plugin.finder.megavideo.floatball.b)localObject, this.zxK);
  }
  
  public void onDestroy()
  {
    if ((((a)this).zyK != null) && (this.zyK == null)) {
      p.bGy("multiTaskHelpter");
    }
    if (((a)this).zyL != null)
    {
      com.tencent.mm.plugin.finder.megavideo.floatball.b localb = this.zyL;
      if (localb == null) {
        p.bGy("videoFloatBallHelper");
      }
      localb.onDestroy();
    }
  }
  
  public void onPause()
  {
    dKn().onUIPause();
    Object localObject;
    if (getActivity().isFinishing())
    {
      localObject = ai.zZt;
      ai.dQx();
    }
    if (((a)this).zyK != null)
    {
      localObject = this.zyK;
      if (localObject == null) {
        p.bGy("multiTaskHelpter");
      }
      ((com.tencent.mm.plugin.finder.megavideo.multitask.a)localObject).aOj();
    }
    if (((a)this).zyL != null)
    {
      localObject = this.zyL;
      if (localObject == null) {
        p.bGy("videoFloatBallHelper");
      }
      ((com.tencent.mm.plugin.finder.megavideo.floatball.b)localObject).aOj();
    }
    if ((dKm()) && (getActivity().isFinishing()))
    {
      localObject = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a.dJH().Oe(dKn().dtf());
    }
  }
  
  public void onResume()
  {
    dKn();
    Object localObject;
    if (((a)this).zyK != null)
    {
      localObject = this.zyK;
      if (localObject == null) {
        p.bGy("multiTaskHelpter");
      }
      ((com.tencent.mm.plugin.finder.megavideo.multitask.a)localObject).bNV();
    }
    if (((a)this).zyL != null)
    {
      localObject = this.zyL;
      if (localObject == null) {
        p.bGy("videoFloatBallHelper");
      }
      ((com.tencent.mm.plugin.finder.megavideo.floatball.b)localObject).bNV();
    }
  }
  
  public void onStart()
  {
    if (dKm())
    {
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a locala = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a.dJH().dJF();
    }
    super.onStart();
  }
  
  public void onStop()
  {
    if (dKm())
    {
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a locala = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a.dJH().Oe(dKn().dtf());
    }
    super.onStop();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.a
 * JD-Core Version:    0.7.0.1
 */