package com.tencent.mm.plugin.emoji.g;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.j;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/utils/EmojiStoreV3UIUtil;", "", "()V", "createRadiusRectangleDrawable", "Landroid/graphics/drawable/GradientDrawable;", "colorInt", "", "leftTopRadiusPx", "", "rightTopRadiusPx", "leftBottomRadiusPx", "rightBottomRadiusPx", "createSelectorRectangleDrawable", "Landroid/graphics/drawable/Drawable;", "normalColor", "pressColor", "getSingleProductEmotionDialogIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/protocal/protobuf/EmojiInfo;", "userName", "", "scene", "searchId", "entranceScene", "showNormalShareMenu", "", "Landroid/app/Activity;", "setId", "setTitle", "setDesc", "setIconURL", "setAdURL", "pageType", "request_code_select_contact_shared", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ydF;
  
  static
  {
    AppMethodBeat.i(269819);
    ydF = new a();
    AppMethodBeat.o(269819);
  }
  
  public static Drawable a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(269772);
    Object localObject = new StateListDrawable();
    Drawable localDrawable = (Drawable)a(paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = (Drawable)a(paramInt1, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    localObject = (Drawable)localObject;
    AppMethodBeat.o(269772);
    return localObject;
  }
  
  private static GradientDrawable a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(269778);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setColor(paramInt);
    localGradientDrawable.setCornerRadii(new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat4, paramFloat4, paramFloat3, paramFloat3 });
    AppMethodBeat.o(269778);
    return localGradientDrawable;
  }
  
  private static final void a(int paramInt1, Activity paramActivity, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, MenuItem paramMenuItem, int paramInt6)
  {
    AppMethodBeat.i(269811);
    kotlin.g.b.s.u(paramActivity, "$context");
    kotlin.g.b.s.u(paramString1, "$setTitle");
    kotlin.g.b.s.u(paramString2, "$setDesc");
    kotlin.g.b.s.u(paramString3, "$setIconURL");
    kotlin.g.b.s.u(paramString4, "$setAdURL");
    paramInt6 = paramMenuItem.getItemId();
    if (paramInt6 == paramInt1)
    {
      j.ai((Context)paramActivity, paramInt2);
      paramActivity.overridePendingTransition(h.a.push_up_in, h.a.fast_faded_out);
      h.OAn.b(13224, new Object[] { Integer.valueOf(2), Integer.valueOf(2), "", Integer.valueOf(paramInt3) });
      AppMethodBeat.o(269811);
      return;
    }
    if (paramInt6 == paramInt4)
    {
      paramActivity = (Context)paramActivity;
      com.tencent.mm.plugin.emoji.model.s.dAl();
      j.a(paramActivity, paramString1, paramString2, paramString3, com.tencent.mm.plugin.emoji.mgr.f.dzu(), EmojiLogic.b(paramInt3, paramString1, paramString2, paramString3, paramString4, paramInt5), 12);
      h.OAn.b(13224, new Object[] { Integer.valueOf(2), Integer.valueOf(1), "", Integer.valueOf(paramInt3) });
    }
    AppMethodBeat.o(269811);
  }
  
  private static final void a(int paramInt1, Activity paramActivity, int paramInt2, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(269805);
    kotlin.g.b.s.u(paramActivity, "$context");
    params.a(paramInt1, (CharSequence)paramActivity.getString(h.h.emoji_share_to_friend), h.g.bottomsheet_icon_transmit);
    params.a(paramInt2, (CharSequence)paramActivity.getString(h.h.emoji_share_to_timeline), h.g.bottomsheet_icon_moment);
    AppMethodBeat.o(269805);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(269798);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(paramString1, "setTitle");
    kotlin.g.b.s.u(paramString2, "setDesc");
    kotlin.g.b.s.u(paramString3, "setIconURL");
    kotlin.g.b.s.u(paramString4, "setAdURL");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)paramActivity, 1, false);
    localf.Vtg = new a..ExternalSyntheticLambda0(1001, paramActivity, 1000);
    localf.GAC = new a..ExternalSyntheticLambda1(1001, paramActivity, paramInt3, paramInt1, 1000, paramString1, paramString2, paramString3, paramString4, paramInt2);
    localf.dDn();
    h.OAn.b(13224, new Object[] { Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(paramInt1) });
    AppMethodBeat.o(269798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.a
 * JD-Core Version:    0.7.0.1
 */