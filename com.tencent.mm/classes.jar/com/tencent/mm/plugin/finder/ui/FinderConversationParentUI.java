package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "convFragment", "Lcom/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment;", "getConvFragment", "()Lcom/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment;", "setConvFragment", "(Lcom/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment;)V", "getFragment", "Landroidx/fragment/app/Fragment;", "getLayoutId", "", "getTitleResId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderConversationParentUI
  extends MMFinderUI
{
  public static final a FOZ;
  private FinderBaseConversationFragment FPa;
  
  static
  {
    AppMethodBeat.i(346693);
    FOZ = new a((byte)0);
    AppMethodBeat.o(346693);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public String eeH()
  {
    return "";
  }
  
  public Fragment getFragment()
  {
    AppMethodBeat.i(346741);
    if (this.FPa == null) {
      this.FPa = new FinderBaseConversationFragment();
    }
    Object localObject = this.FPa;
    s.checkNotNull(localObject);
    localObject = (Fragment)localObject;
    AppMethodBeat.o(346741);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return e.f.finder_conversation_fragment_container;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(346712);
    Set localSet = ar.setOf(b.class);
    AppMethodBeat.o(346712);
    return localSet;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(346722);
    super.onCreate(paramBundle);
    paramBundle = getFragment();
    if (paramBundle != null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("KEY_TALKER_TYPE", getIntent().getIntExtra("KEY_TALKER_TYPE", -1));
      ((Bundle)localObject).putInt("KEY_TALKER_SCENE", getIntent().getIntExtra("KEY_TALKER_SCENE", -1));
      ah localah = ah.aiuX;
      paramBundle.setArguments((Bundle)localObject);
      localObject = getSupportFragmentManager().beginTransaction();
      s.s(localObject, "supportFragmentManager.beginTransaction()");
      ((r)localObject).b(e.e.fragment_container, paramBundle);
      ((r)localObject).FY();
    }
    AppMethodBeat.o(346722);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(346731);
    super.onResume();
    setMMTitle(eeH());
    AppMethodBeat.o(346731);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI$Companion;", "", "()V", "KEY_CONV_SCENE", "", "KEY_CONV_TYPE", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
 * JD-Core Version:    0.7.0.1
 */