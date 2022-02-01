package com.tencent.mm.chatroom.ui.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.chatroom.ui.a.e;
import com.tencent.mm.chatroom.ui.a.f;
import kotlin.Metadata;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/ui/accessibility/SelectMemberUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(241794);
    AppMethodBeat.o(241794);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(241800);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.f.lGB);
    localConfigHelper.view(a.e.item).checkOn((kotlin.g.a.b)a.lPh);
    localConfigHelper.view(a.e.lEo).disableChildren();
    localConfigHelper.view(a.e.lEo).disable();
    localConfigHelper.view(a.e.lFy).disable();
    AppMethodBeat.o(241800);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<View, Boolean>
  {
    public static final a lPh;
    
    static
    {
      AppMethodBeat.i(241803);
      lPh = new a();
      AppMethodBeat.o(241803);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.a.b
 * JD-Core Version:    0.7.0.1
 */