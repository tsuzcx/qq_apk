package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;)V", "getLayoutId", "", "keyboardChange", "", "show", "height", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderLiveLotteryCreateUIC
  extends UIComponent
{
  final String TAG;
  private h gyh;
  private boolean hwq;
  private d.b ugD;
  private d.a ugO;
  
  public FinderLiveLotteryCreateUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(245939);
    this.TAG = "FinderLiveLotteryCreateUIC";
    AppMethodBeat.o(245939);
  }
  
  public final int getLayoutId()
  {
    return 2131494391;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245935);
    super.onCreate(paramBundle);
    this.ugO = ((d.a)new e((Activity)getActivity()));
    paramBundle = getRootView();
    Object localObject = getActivity();
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(245935);
      throw paramBundle;
    }
    this.ugD = ((d.b)new f(paramBundle, (MMActivity)localObject, this.ugO));
    paramBundle = this.ugO;
    if (paramBundle != null)
    {
      localObject = this.ugD;
      if (localObject == null) {
        p.hyc();
      }
      paramBundle.onAttach(localObject);
      AppMethodBeat.o(245935);
      return;
    }
    AppMethodBeat.o(245935);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245938);
    super.onDestroy();
    d.a locala = this.ugO;
    if (locala != null)
    {
      locala.onDetach();
      AppMethodBeat.o(245938);
      return;
    }
    AppMethodBeat.o(245938);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245937);
    super.onPause();
    h localh = this.gyh;
    if (localh != null)
    {
      localh.close();
      AppMethodBeat.o(245937);
      return;
    }
    AppMethodBeat.o(245937);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245936);
    super.onResume();
    Object localObject = getActivity().getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null)
      {
        ((View)localObject).post((Runnable)new a(this));
        AppMethodBeat.o(245936);
        return;
      }
    }
    AppMethodBeat.o(245936);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderLiveLotteryCreateUIC paramFinderLiveLotteryCreateUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(245934);
      if (FinderLiveLotteryCreateUIC.a(this.ugP) == null)
      {
        FinderLiveLotteryCreateUIC.a(this.ugP, new h((Activity)this.ugP.getActivity()));
        localh = FinderLiveLotteryCreateUIC.a(this.ugP);
        if (localh != null) {
          localh.setKeyboardHeightObserver((g)new g()
          {
            public final void y(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(245933);
              Log.i(this.ugQ.ugP.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              FinderLiveLotteryCreateUIC localFinderLiveLotteryCreateUIC = this.ugQ.ugP;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                FinderLiveLotteryCreateUIC.a(localFinderLiveLotteryCreateUIC, paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(245933);
                return;
              }
            }
          });
        }
      }
      h localh = FinderLiveLotteryCreateUIC.a(this.ugP);
      if (localh != null)
      {
        localh.start();
        AppMethodBeat.o(245934);
        return;
      }
      AppMethodBeat.o(245934);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.FinderLiveLotteryCreateUIC
 * JD-Core Version:    0.7.0.1
 */