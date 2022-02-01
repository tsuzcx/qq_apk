package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.floatball.b.a;
import com.tencent.mm.plugin.finder.floatball.b.d;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFloatBallNormalUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "attachLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getAttachLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setAttachLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "enterFeedId", "", "hasSaveData", "", "hasTriggerAdd", "isCurrFloatBallUI", "isFromFloatBall", "()Z", "setFromFloatBall", "(Z)V", "savedBundle", "Landroid/os/Bundle;", "addFloatBall", "", "needTriggerBack", "isPassive", "onBeforeFinish", "resultIntent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "onDestroy", "onFinished", "onNewIntent", "intent", "onPause", "onResume", "saveBundle", "bundle", "saveData", "checkAutoPlay", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends UIComponent
{
  public static final a GPU;
  public boolean AEE;
  public Bundle BtW;
  private boolean GPV;
  private boolean GPW;
  private long GPX;
  public BaseFinderFeedLoader GPY;
  private boolean GPZ;
  
  static
  {
    AppMethodBeat.i(338011);
    GPU = new a((byte)0);
    AppMethodBeat.o(338011);
  }
  
  public w(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337977);
    AppMethodBeat.o(337977);
  }
  
  private final void aY(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(370294);
    if ((getActivity() instanceof FinderHomeUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.floatball.b.BtK;
      localObject2 = b.a.egt();
      localObject1 = k.aeZF;
      localObject3 = ((FinderHomeUIC)k.d(getActivity()).q(FinderHomeUIC.class)).getActiveFragment();
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)getActivity());
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!paramBoolean2) {
          break label116;
        }
      }
      label116:
      for (l = this.GPX;; l = 0L)
      {
        ((com.tencent.mm.plugin.finder.floatball.b)localObject2).a((FinderHomeTabFragment)localObject3, (bui)localObject1, paramBoolean1, l);
        AppMethodBeat.o(370294);
        return;
        localObject1 = ((as)localObject1).fou();
        break;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.finder.floatball.b.BtK;
    Object localObject3 = b.a.egt();
    AppCompatActivity localAppCompatActivity = getActivity();
    localObject1 = this.GPY;
    List localList;
    if (localObject1 == null)
    {
      localObject1 = null;
      localList = (List)localObject1;
      localObject1 = this.GPY;
      if (localObject1 != null) {
        break label219;
      }
    }
    label219:
    for (localObject1 = localObject2;; localObject1 = ((BaseFinderFeedLoader)localObject1).getLastBuffer())
    {
      localObject2 = this.BtW;
      if (paramBoolean2) {
        l = this.GPX;
      }
      ((com.tencent.mm.plugin.finder.floatball.b)localObject3).a(localAppCompatActivity, localList, (com.tencent.mm.bx.b)localObject1, (Bundle)localObject2, paramBoolean1, l);
      AppMethodBeat.o(370294);
      return;
      localObject1 = ((BaseFinderFeedLoader)localObject1).getDataListJustForAdapter();
      break;
    }
  }
  
  private void ap(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(337986);
    if ((!(getActivity() instanceof FinderHomeUI)) && (!(getActivity() instanceof FinderShareFeedRelUI)))
    {
      localObject = new RuntimeException(s.X("Not allow to add float ball in other activity, activity=", getActivity()));
      AppMethodBeat.o(337986);
      throw ((Throwable)localObject);
    }
    if (!this.GPW)
    {
      aY(paramBoolean2, true);
      this.GPW = true;
    }
    Object localObject = com.tencent.mm.plugin.finder.floatball.b.BtK;
    paramBoolean2 = com.tencent.mm.plugin.finder.floatball.b.a(b.a.egt(), paramBoolean2);
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.GPV = true;
      getActivity().onBackPressed();
    }
    AppMethodBeat.o(337986);
  }
  
  public final void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(338041);
    if ((!this.GPV) && (this.AEE) && (this.GPZ)) {
      ap(false, true);
    }
    AppMethodBeat.o(338041);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(338022);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getStringExtra("FLOAT_BALL_KEY");
    this.AEE = true;
    Object localObject2 = com.tencent.mm.plugin.finder.floatball.b.BtK;
    int i;
    if (b.a.egt().cYo())
    {
      paramBundle = (CharSequence)paramBundle;
      if ((paramBundle == null) || (paramBundle.length() == 0))
      {
        i = 1;
        if (i != 0)
        {
          paramBundle = com.tencent.mm.plugin.finder.floatball.b.BtK;
          localObject2 = b.a.egt();
          s.u((Activity)getActivity(), "activity");
          paramBundle = ((com.tencent.mm.plugin.finder.floatball.b)localObject2).BtO;
          if (paramBundle != null) {
            break label264;
          }
          paramBundle = null;
          label101:
          if (!s.p(FinderHomeAffinityUI.class, paramBundle))
          {
            paramBundle = ((com.tencent.mm.plugin.finder.floatball.b)localObject2).BtO;
            if (paramBundle != null) {
              break label272;
            }
            paramBundle = (Bundle)localObject1;
            label123:
            if (!s.p(FinderHomeUI.class, paramBundle)) {
              break label280;
            }
          }
          i = 1;
          label134:
          if (i == 0) {
            this.AEE = false;
          }
        }
        paramBundle = com.tencent.mm.plugin.finder.floatball.b.BtK;
        paramBundle = b.a.egt().vjV.key;
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.floatball.b.BtK;
      this.GPZ = b.a.egt().ax((Activity)getActivity());
      this.GPX = getIntent().getLongExtra("KEY_ENTER_PLAYING_FEED_ID", 0L);
      localObject1 = paramBundle;
      if (paramBundle == null)
      {
        paramBundle = com.tencent.mm.plugin.finder.floatball.b.BtK;
        b.a.egt().ego();
        paramBundle = z.FrZ;
        localObject1 = z.bUm();
        this.AEE = false;
      }
      Log.i("SimpleUIComponent", "initFinderFloatBall key: %s", new Object[] { localObject1 });
      paramBundle = com.tencent.mm.plugin.finder.floatball.b.BtK;
      b.a.egt().J(32, (String)localObject1);
      AppMethodBeat.o(338022);
      return;
      i = 0;
      break;
      label264:
      paramBundle = paramBundle.BtV;
      break label101;
      label272:
      paramBundle = paramBundle.BtV;
      break label123;
      label280:
      i = 0;
      break label134;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338057);
    super.onDestroy();
    b.a locala = com.tencent.mm.plugin.finder.floatball.b.BtK;
    b.a.egt().onDestroy();
    AppMethodBeat.o(338057);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(338061);
    super.onFinished();
    b.a locala = com.tencent.mm.plugin.finder.floatball.b.BtK;
    b.a.egt().finish();
    AppMethodBeat.o(338061);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(338029);
    Object localObject;
    int i;
    if (paramIntent == null)
    {
      localObject = null;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label104;
      }
      i = 1;
      label37:
      if (i != 0) {
        break label109;
      }
    }
    label104:
    label109:
    for (boolean bool = true;; bool = false)
    {
      this.AEE = bool;
      localObject = com.tencent.mm.plugin.finder.floatball.b.BtK;
      this.GPZ = b.a.egt().ax((Activity)getActivity());
      if (paramIntent != null) {
        this.GPX = paramIntent.getLongExtra("KEY_ENTER_PLAYING_FEED_ID", 0L);
      }
      AppMethodBeat.o(338029);
      return;
      localObject = paramIntent.getStringExtra("FLOAT_BALL_KEY");
      break;
      i = 0;
      break label37;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(338050);
    if (!this.GPW) {
      aY(true, false);
    }
    if ((this.GPZ) && (this.AEE))
    {
      locala = com.tencent.mm.plugin.finder.floatball.b.BtK;
      b.a.egt().bhW();
    }
    b.a locala = com.tencent.mm.plugin.finder.floatball.b.BtK;
    b.a.egt().cYs();
    AppMethodBeat.o(338050);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338036);
    super.onResume();
    if ((this.GPZ) && (this.AEE))
    {
      locala = com.tencent.mm.plugin.finder.floatball.b.BtK;
      b.a.egt().ego();
      locala = com.tencent.mm.plugin.finder.floatball.b.BtK;
      b.a.egt().coi();
      AppMethodBeat.o(338036);
      return;
    }
    b.a locala = com.tencent.mm.plugin.finder.floatball.b.BtK;
    b.a.egt().qh(true);
    AppMethodBeat.o(338036);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFloatBallNormalUIC$Companion;", "", "()V", "FLOAT_BALL_KEY", "", "IS_PASSIVE_KEY", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.w
 * JD-Core Version:    0.7.0.1
 */