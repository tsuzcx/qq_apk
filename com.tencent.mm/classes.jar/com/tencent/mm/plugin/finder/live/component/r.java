package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;)V", "getLayoutId", "", "keyboardChange", "", "show", "height", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class r
  extends UIComponent
{
  final String TAG;
  private i jij;
  private boolean kiD;
  private p.b yaF;
  private p.a yaS;
  
  public r(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(292332);
    this.TAG = "FinderLiveLotteryCreateUIC";
    AppMethodBeat.o(292332);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_create_lottery_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(292328);
    super.onCreate(paramBundle);
    this.yaS = ((p.a)new q((Activity)getActivity()));
    paramBundle = getRootView();
    Object localObject = getActivity();
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(292328);
      throw paramBundle;
    }
    this.yaF = ((p.b)new s(paramBundle, (MMActivity)localObject, this.yaS));
    paramBundle = this.yaS;
    if (paramBundle != null)
    {
      localObject = this.yaF;
      if (localObject == null) {
        p.iCn();
      }
      paramBundle.onAttach(localObject);
      AppMethodBeat.o(292328);
      return;
    }
    AppMethodBeat.o(292328);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(292331);
    super.onDestroy();
    p.a locala = this.yaS;
    if (locala != null)
    {
      locala.onDetach();
      AppMethodBeat.o(292331);
      return;
    }
    AppMethodBeat.o(292331);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(292330);
    super.onPause();
    i locali = this.jij;
    if (locali != null)
    {
      locali.close();
      AppMethodBeat.o(292330);
      return;
    }
    AppMethodBeat.o(292330);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(292329);
    super.onResume();
    Object localObject = getActivity().getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null)
      {
        ((View)localObject).post((Runnable)new a(this));
        AppMethodBeat.o(292329);
        return;
      }
    }
    AppMethodBeat.o(292329);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(r paramr) {}
    
    public final void run()
    {
      AppMethodBeat.i(224856);
      if (r.a(this.yaT) == null)
      {
        r.a(this.yaT, new i((Activity)this.yaT.getActivity()));
        locali = r.a(this.yaT);
        if (locali != null) {
          locali.setKeyboardHeightObserver((h)new h()
          {
            public final void A(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(288025);
              Log.i(this.yaU.yaT.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              r localr = this.yaU.yaT;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                r.a(localr, paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(288025);
                return;
              }
            }
          });
        }
      }
      i locali = r.a(this.yaT);
      if (locali != null)
      {
        locali.start();
        AppMethodBeat.o(224856);
        return;
      }
      AppMethodBeat.o(224856);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.r
 * JD-Core Version:    0.7.0.1
 */