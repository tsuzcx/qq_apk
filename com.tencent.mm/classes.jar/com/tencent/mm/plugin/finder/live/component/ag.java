package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;)V", "getLayoutId", "", "keyboardChange", "", "show", "height", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends UIComponent
{
  private ae.b Czl;
  private ae.a Czu;
  private final String TAG;
  private i lKz;
  private boolean mJk;
  
  public ag(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(353058);
    this.TAG = "FinderLiveLotteryCreateUIC";
    AppMethodBeat.o(353058);
  }
  
  private static final void a(ag paramag)
  {
    AppMethodBeat.i(353080);
    s.u(paramag, "this$0");
    if (paramag.lKz == null)
    {
      paramag.lKz = new i((Activity)paramag.getActivity());
      i locali = paramag.lKz;
      if (locali != null) {
        locali.afIL = new ag..ExternalSyntheticLambda0(paramag);
      }
    }
    paramag = paramag.lKz;
    if (paramag != null) {
      paramag.start();
    }
    AppMethodBeat.o(353080);
  }
  
  private static final void a(ag paramag, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(353068);
    s.u(paramag, "this$0");
    Log.i(paramag.TAG, "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (paramInt > 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramag.mJk != paramBoolean)
      {
        paramag.mJk = paramBoolean;
        paramag = paramag.Czl;
        if (paramag != null) {
          paramag.keyboardChange(paramBoolean, paramInt);
        }
      }
      AppMethodBeat.o(353068);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return p.f.Cdw;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(353120);
    super.onCreate(paramBundle);
    this.Czu = ((ae.a)new af((Activity)getActivity()));
    this.Czl = ((ae.b)new ah(getRootView(), (MMActivity)getActivity(), this.Czu));
    paramBundle = this.Czu;
    if (paramBundle != null)
    {
      ae.b localb = this.Czl;
      s.checkNotNull(localb);
      paramBundle.onAttach(localb);
    }
    AppMethodBeat.o(353120);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(353144);
    super.onDestroy();
    ae.a locala = this.Czu;
    if (locala != null) {
      locala.onDetach();
    }
    AppMethodBeat.o(353144);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(353137);
    super.onPause();
    i locali = this.lKz;
    if (locali != null) {
      locali.close();
    }
    AppMethodBeat.o(353137);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(353130);
    super.onResume();
    Object localObject = getActivity().getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null) {
        ((View)localObject).post(new ag..ExternalSyntheticLambda1(this));
      }
    }
    AppMethodBeat.o(353130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ag
 * JD-Core Version:    0.7.0.1
 */