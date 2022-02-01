package com.tencent.mm.plugin.flash.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flash/config/FaceFlashActionAccessiBility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "lastText", "", "getLastText", "()Ljava/lang/String;", "setLastText", "(Ljava/lang/String;)V", "initConfig", "", "Companion", "plugin-face_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public static final b.a HiU;
  private static final String TAG;
  String mph;
  
  static
  {
    AppMethodBeat.i(264683);
    HiU = new b.a((byte)0);
    TAG = "FaceFlashActionAccessiBility";
    AppMethodBeat.o(264683);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(264675);
    this.mph = "";
    AppMethodBeat.o(264675);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(264696);
    root(a.g.face_flash_action_layout).view(a.e.flash_cancel).type(ViewType.Button).desc(a.i.close_btn);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.face_flash_action_recognize_layout);
    localConfigHelper.view(a.e.flash_tip_view_before).talkOn((kotlin.g.a.b)new b(this));
    localConfigHelper.view(a.e.flash_tip_view_after).talkOn((kotlin.g.a.b)new c(this));
    root(a.g.face_flash_action_upload_layout).view(a.e.face_flash_header_tip).talkOn((kotlin.g.a.b)b.d.HiW);
    AppMethodBeat.o(264696);
  }
  
  public final void setLastText(String paramString)
  {
    AppMethodBeat.i(264688);
    s.u(paramString, "<set-?>");
    this.mph = paramString;
    AppMethodBeat.o(264688);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<View, Boolean>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<View, Boolean>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.a.b
 * JD-Core Version:    0.7.0.1
 */