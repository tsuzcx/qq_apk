package com.tencent.mm.chatroom.ui.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.chatroom.ui.a.f;
import com.tencent.mm.chatroom.ui.a.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/ui/accessibility/ChatroomInfoUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public static final a.a lPg;
  
  static
  {
    AppMethodBeat.i(241801);
    lPg = new a.a((byte)0);
    AppMethodBeat.o(241801);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(241792);
    AppMethodBeat.o(241792);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(241805);
    root(a.f.actionbar_title_center).view(16908308).descFormat(a.i.actionbar_title_desc).valueByView(16908308).valueByKey("is_mute");
    AppMethodBeat.o(241805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.a.a
 * JD-Core Version:    0.7.0.1
 */