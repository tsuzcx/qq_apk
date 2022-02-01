package com.tencent.mm.plugin.finder.megavideo.uic;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.finder.megavideo.multitask.a.a;
import com.tencent.mm.plugin.finder.megavideo.multitask.b;
import com.tencent.mm.plugin.finder.megavideo.ui.h.a;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "getFloatBallInfo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "setFloatBallInfo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;)V", "isMultiTask", "", "multiTaskHelpter", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "getMultiTaskHelpter", "()Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "setMultiTaskHelpter", "(Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;)V", "multiTaskIntent", "Landroid/content/Intent;", "getMultiTaskIntent", "()Landroid/content/Intent;", "setMultiTaskIntent", "(Landroid/content/Intent;)V", "needToReinit", "getNeedToReinit", "()Z", "setNeedToReinit", "(Z)V", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getPresenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "initFloatBallData", "", "initMultiTaskData", "key", "", "positon", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onResume", "supportMultiTaskType", "multiTaskType", "", "Companion", "plugin-finder_release"})
public abstract class BaseMegaVideoTLUIC
  extends MultiTaskUIComponent
{
  public static final a uMR = new a((byte)0);
  private cnu uLY = new cnu();
  protected com.tencent.mm.plugin.finder.megavideo.multitask.a uMN;
  Intent uMO;
  private boolean uMP;
  boolean uMQ;
  
  public BaseMegaVideoTLUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  private void aue(String paramString)
  {
    if (((BaseMegaVideoTLUIC)this).uMN == null) {
      if (paramString == null)
      {
        paramString = getActivity().getIntent().getByteArrayExtra("KEY_FLOAT_BALL_INFO");
        if (paramString != null) {
          this.uMQ = true;
        }
      }
    }
    try
    {
      this.uLY.parseFrom(paramString);
      paramString = this.uLY.key;
      if (paramString != null) {
        this.uMP = true;
      }
      this.uMN = new com.tencent.mm.plugin.finder.megavideo.multitask.a((Context)getActivity(), (com.tencent.mm.plugin.multitask.a.a)new b((Activity)getActivity(), this.zZC, getRootView()));
      com.tencent.mm.plugin.finder.megavideo.multitask.a locala = this.uMN;
      if (locala == null) {
        p.btv("multiTaskHelpter");
      }
      if (paramString == null)
      {
        paramString = k.vfA;
        paramString = k.doc();
        locala.G(22, paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Log.e("BaseMegaVideoUIC", "initFloatBallData", new Object[] { paramString });
        paramString = x.SXb;
      }
    }
  }
  
  public final boolean Js(int paramInt)
  {
    return paramInt == 22;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Object paramObject)
  {
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    p.h(paramcrq, "animateData");
    paramObject = com.tencent.mm.plugin.finder.megavideo.multitask.a.uLw;
    if (paramView != null) {}
    for (paramView = paramView.getContext();; paramView = null)
    {
      paramObject = paramView;
      if (!(paramView instanceof Activity)) {
        paramObject = null;
      }
      a.a.a(paramMultiTaskInfo, paramcrq, true, (Activity)paramObject);
      return;
    }
  }
  
  public final void dk(Object paramObject)
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
          this.uLY = new cnu();
          this.uLY.parseFrom(paramObject.field_data);
          Intent localIntent = new Intent();
          localObject1 = y.vXH;
          localObject1 = this.uLY.Muf;
          p.g(localObject1, "floatBallInfo.cacheNewVideoList");
          Object localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            FinderObject localFinderObject = (FinderObject)((Iterator)localObject2).next();
            p.g(localFinderObject, "it");
            ((Collection)localObject1).add(new bm(localFinderObject));
          }
        }
        catch (Throwable localThrowable)
        {
          Object localObject1;
          for (;;)
          {
            Log.e("BaseMegaVideoUIC", "onMultiTaskInit", new Object[] { localThrowable });
          }
          y.a(0, (List)localObject1, null, localThrowable);
          this.uMO = localThrowable;
          a(this, paramObject.field_id, 2);
        }
      }
      this.uMP = true;
      paramObject = com.tencent.mm.ui.component.a.PRN;
      paramObject = com.tencent.mm.ui.component.a.b(getActivity()).get(FinderCommentDrawerUIC.class);
      p.g(paramObject, "UICProvider.of(activity)…entDrawerUIC::class.java)");
      new com.tencent.mm.plugin.finder.viewmodel.component.a((FinderCommentDrawerUIC)paramObject);
      return;
    }
  }
  
  public abstract h.a dkq();
  
  public final void dkr() {}
  
  public final a.b dks()
  {
    return a.b.Ach;
  }
  
  public boolean onBackPressed()
  {
    return dkq().nJ(false);
  }
  
  public void onBeforeFinish(Intent paramIntent)
  {
    long l3 = 0L;
    super.onBeforeFinish(paramIntent);
    paramIntent = dkq().dko().getRecyclerView();
    Object localObject = paramIntent.getLayoutManager();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    }
    localObject = paramIntent.ch(((LinearLayoutManager)localObject).ks());
    paramIntent = (Intent)localObject;
    if (!(localObject instanceof h)) {
      paramIntent = null;
    }
    localObject = (h)paramIntent;
    paramIntent = new Intent();
    r localr;
    if (localObject != null)
    {
      localObject = (FinderVideoLayout)((h)localObject).Mn(2131300776);
      if (localObject != null)
      {
        localr = ((FinderVideoLayout)localObject).getVideoView();
        if (localr == null) {
          break label197;
        }
      }
    }
    label197:
    for (long l1 = localr.getCurrentPlayMs();; l1 = 0L)
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
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    h.a locala = dkq();
    if (paramConfiguration.orientation == 2) {}
    for (boolean bool = true;; bool = false)
    {
      locala.nI(bool);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    a(this, null, 3);
  }
  
  public void onCreateAfter(Bundle paramBundle)
  {
    paramBundle = dkq();
    com.tencent.mm.plugin.finder.megavideo.multitask.a locala = this.uMN;
    if (locala == null) {
      p.btv("multiTaskHelpter");
    }
    paramBundle.a(locala, this.uLY, this.uMP);
  }
  
  public void onDestroy()
  {
    if ((((BaseMegaVideoTLUIC)this).uMN != null) && (this.uMN == null)) {
      p.btv("multiTaskHelpter");
    }
  }
  
  public void onPause()
  {
    Object localObject;
    if (getActivity().isFinishing())
    {
      localObject = af.viA;
      af.doU();
    }
    if (((BaseMegaVideoTLUIC)this).uMN != null)
    {
      localObject = this.uMN;
      if (localObject == null) {
        p.btv("multiTaskHelpter");
      }
      ((com.tencent.mm.plugin.finder.megavideo.multitask.a)localObject).aGj();
    }
  }
  
  public void onResume()
  {
    if (((BaseMegaVideoTLUIC)this).uMN != null)
    {
      com.tencent.mm.plugin.finder.megavideo.multitask.a locala = this.uMN;
      if (locala == null) {
        p.btv("multiTaskHelpter");
      }
      locala.bCA();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.BaseMegaVideoTLUIC
 * JD-Core Version:    0.7.0.1
 */