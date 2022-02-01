package com.tencent.mm.plugin.finder.viewmodel.teenmode;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeTempAuthUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "bizKey", "", "getBizKey", "()Ljava/lang/String;", "setBizKey", "(Ljava/lang/String;)V", "checkFeedShouldGuard", "", "feedId", "", "jumpToAuthorization", "", "authContent", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
{
  public static final a GWS;
  public String bizKey;
  
  static
  {
    AppMethodBeat.i(337339);
    GWS = new a((byte)0);
    AppMethodBeat.o(337339);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337329);
    this.bizKey = "";
    AppMethodBeat.o(337329);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(337351);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.FinderTeenModeTempAuthMgr", "requestCode " + paramInt1 + ", resultCode " + paramInt2);
    if ((paramInt1 == 10013) && (paramInt2 == 0) && (!getActivity().isFinishing()) && (!getActivity().isDestroyed()))
    {
      getActivity().finish();
      getActivity().overridePendingTransition(0, com.tencent.mm.plugin.finder.e.a.slide_right_out);
    }
    AppMethodBeat.o(337351);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeTempAuthUIC$Companion;", "", "()V", "REQUEST_AUTH", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.teenmode.e
 * JD-Core Version:    0.7.0.1
 */