package com.tencent.mm.plugin.finder.profile.adapter;

import android.text.SpannableString;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper;", "", "header", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "getHeader", "()Landroid/view/ViewGroup;", "visibleStateRecorder", "", "changeBtnPos", "", "isDown", "", "view", "Landroid/view/View;", "changePosition", "spannableStr", "Landroid/text/SpannableString;", "locationText", "", "lltext", "isRecordStat", "getChangeLeftRegionWidth", "", "text", "getChangeRightRegionWidth", "", "getEditWidth", "getLocationTextWidth", "getTotalAvailableWidth", "recordVisibleState", "isShouldRecord", "restoreVisibleState", "setProfileTextWidth", "availableWidth", "nameExtWidth", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a uZI;
  private final int[] uZG;
  final ViewGroup uZH;
  
  static
  {
    AppMethodBeat.i(250016);
    uZI = new a((byte)0);
    AppMethodBeat.o(250016);
  }
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(250015);
    this.uZH = paramViewGroup;
    this.uZG = new int[] { 0, 0 };
    AppMethodBeat.o(250015);
  }
  
  private final void nP(boolean paramBoolean)
  {
    AppMethodBeat.i(250014);
    if (paramBoolean)
    {
      Object localObject = this.uZG;
      FrameLayout localFrameLayout = (FrameLayout)((View)this.uZH).findViewById(2131307600);
      p.g(localFrameLayout, "header.sendMsgBtn");
      localObject[0] = localFrameLayout.getVisibility();
      localObject = this.uZG;
      localFrameLayout = (FrameLayout)((View)this.uZH).findViewById(2131301440);
      p.g(localFrameLayout, "header.finder_profile_follow_btn");
      localObject[1] = localFrameLayout.getVisibility();
      localObject = (FrameLayout)((View)this.uZH).findViewById(2131307600);
      p.g(localObject, "header.sendMsgBtn");
      if (((FrameLayout)localObject).getVisibility() == 0)
      {
        localObject = (FrameLayout)((View)this.uZH).findViewById(2131307600);
        p.g(localObject, "header.sendMsgBtn");
        ((FrameLayout)localObject).setVisibility(4);
      }
      localObject = (FrameLayout)((View)this.uZH).findViewById(2131301440);
      p.g(localObject, "header.finder_profile_follow_btn");
      if (((FrameLayout)localObject).getVisibility() == 0)
      {
        localObject = (FrameLayout)((View)this.uZH).findViewById(2131301440);
        p.g(localObject, "header.finder_profile_follow_btn");
        ((FrameLayout)localObject).setVisibility(4);
      }
    }
    AppMethodBeat.o(250014);
  }
  
  public final void a(SpannableString paramSpannableString, String paramString)
  {
    AppMethodBeat.i(250012);
    p.h(paramString, "locationText");
    a(paramSpannableString, paramString, true);
    AppMethodBeat.o(250012);
  }
  
  public final void a(final SpannableString paramSpannableString, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(250013);
    p.h(paramString, "lltext");
    if ((paramSpannableString == null) || (Util.isNullOrNil(paramSpannableString.toString())))
    {
      AppMethodBeat.o(250013);
      return;
    }
    final z.f localf = new z.f();
    paramSpannableString = paramSpannableString.toString();
    p.g(paramSpannableString, "spannableStr.toString()");
    localf.SYG = paramSpannableString;
    paramSpannableString = new z.f();
    paramSpannableString.SYG = paramString;
    nP(paramBoolean);
    if ((String)localf.SYG != null) {
      this.uZH.post((Runnable)new b(this, localf, paramSpannableString, paramBoolean));
    }
    AppMethodBeat.o(250013);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper$changePosition$1$1"})
  static final class b
    implements Runnable
  {
    b(a parama, z.f paramf1, z.f paramf2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(250011);
      int i = a.a(this.uZJ);
      int j = i - a.b(this.uZJ);
      float f1 = a.c(this.uZJ);
      Object localObject = (TextView)((View)this.uZJ.uZH).findViewById(2131301454);
      p.g(localObject, "header.finder_profile_name_tv");
      float f2 = ((TextView)localObject).getPaint().measureText((String)localf.SYG);
      float f3 = a.a(this.uZJ, (String)paramSpannableString.SYG);
      FrameLayout localFrameLayout;
      if ((f2 + f1 > j) || (f3 > j))
      {
        localObject = this.uZJ;
        localFrameLayout = (FrameLayout)((View)this.uZJ.uZH).findViewById(2131307600);
        p.g(localFrameLayout, "header.sendMsgBtn");
        a.a((a)localObject, true, (View)localFrameLayout);
        localObject = this.uZJ;
        localFrameLayout = (FrameLayout)((View)this.uZJ.uZH).findViewById(2131301440);
        p.g(localFrameLayout, "header.finder_profile_follow_btn");
        a.a((a)localObject, true, (View)localFrameLayout);
        j = com.tencent.mm.cb.a.aH(this.uZJ.uZH.getContext(), 2131165296);
        a.a(this.uZJ, (String)localf.SYG, (String)paramSpannableString.SYG, i - j, (int)f1);
      }
      for (;;)
      {
        a.a(this.uZJ, paramBoolean);
        AppMethodBeat.o(250011);
        return;
        localObject = this.uZJ;
        localFrameLayout = (FrameLayout)((View)this.uZJ.uZH).findViewById(2131307600);
        p.g(localFrameLayout, "header.sendMsgBtn");
        a.a((a)localObject, false, (View)localFrameLayout);
        localObject = this.uZJ;
        localFrameLayout = (FrameLayout)((View)this.uZJ.uZH).findViewById(2131301440);
        p.g(localFrameLayout, "header.finder_profile_follow_btn");
        a.a((a)localObject, false, (View)localFrameLayout);
        a.a(this.uZJ, (String)localf.SYG, (String)paramSpannableString.SYG, j, (int)f1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.adapter.a
 * JD-Core Version:    0.7.0.1
 */