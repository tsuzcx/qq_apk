package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.iw;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.t;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLiveFinishUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "firstOnResume", "", "getFirstOnResume", "()Z", "setFirstOnResume", "(Z)V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setWindowStyle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderGameLiveFinishUI
  extends MMFinderUI
{
  private boolean BnT = true;
  
  private static final void eeZ()
  {
    AppMethodBeat.i(365104);
    iw localiw = new iw();
    localiw.hKx.hKy = true;
    localiw.publish();
    AppMethodBeat.o(365104);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return p.f.CcA;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365150);
    Set localSet = ar.setOf(a.class);
    AppMethodBeat.o(365150);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365123);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      getWindow().getDecorView().setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = findViewById(p.e.BUS);
    t localt = t.GgN;
    t.gO(paramBundle);
    AppMethodBeat.o(365123);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365137);
    super.onResume();
    boolean bool1;
    Object localObject1;
    Object localObject2;
    if (this.BnT)
    {
      bool1 = getIntent().getBooleanExtra("SUCC", false);
      localObject1 = getIntent().getStringExtra("TITLE");
      if (localObject1 != null) {
        break label194;
      }
      localObject1 = "";
      localObject2 = getIntent().getStringExtra("DESC");
      if (localObject2 != null) {
        break label197;
      }
      localObject2 = "";
    }
    label194:
    label197:
    for (;;)
    {
      boolean bool2 = getIntent().getBooleanExtra("IS_MINI_GAME", false);
      Object localObject3 = k.aeZF;
      localObject3 = k.d((AppCompatActivity)this).q(a.class);
      s.s(localObject3, "UICProvider.of(this).get…ameFinishUIC::class.java)");
      localObject3 = (a)localObject3;
      ((a)localObject3).e(bool1, (String)localObject1, (String)localObject2);
      ((a)localObject3).show();
      if (!bool1)
      {
        localObject1 = ((a)localObject3).getDescTv();
        localObject2 = t.GgN;
        localObject2 = getContext();
        s.s(localObject2, "context");
        ((TextView)localObject1).setText((CharSequence)t.d((Context)localObject2, p.h.Cuu, bool2));
      }
      getContentView().postDelayed(FinderGameLiveFinishUI..ExternalSyntheticLambda0.INSTANCE, 500L);
      this.BnT = false;
      AppMethodBeat.o(365137);
      return;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveFinishUI
 * JD-Core Version:    0.7.0.1
 */