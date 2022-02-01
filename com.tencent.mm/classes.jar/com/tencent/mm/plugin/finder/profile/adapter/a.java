package com.tencent.mm.plugin.finder.profile.adapter;

import android.text.SpannableString;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper;", "", "header", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "getHeader", "()Landroid/view/ViewGroup;", "visibleStateRecorder", "", "changeBtnPos", "", "isDown", "", "view", "Landroid/view/View;", "changePosition", "spannableStr", "Landroid/text/SpannableString;", "locationText", "", "lltext", "isRecordStat", "getChangeLeftRegionWidth", "", "text", "getChangeRightRegionWidth", "", "getEditWidth", "getLocationTextWidth", "getTotalAvailableWidth", "recordVisibleState", "isShouldRecord", "restoreVisibleState", "setProfileTextWidth", "availableWidth", "nameExtWidth", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a zQc;
  private final int[] zQa;
  final ViewGroup zQb;
  
  static
  {
    AppMethodBeat.i(276510);
    zQc = new a((byte)0);
    AppMethodBeat.o(276510);
  }
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(276509);
    this.zQb = paramViewGroup;
    this.zQa = new int[] { 0, 0 };
    AppMethodBeat.o(276509);
  }
  
  private final void pZ(boolean paramBoolean)
  {
    AppMethodBeat.i(276508);
    if (paramBoolean)
    {
      Object localObject = this.zQa;
      FrameLayout localFrameLayout = (FrameLayout)((View)this.zQb).findViewById(b.f.sendMsgBtn);
      p.j(localFrameLayout, "header.sendMsgBtn");
      localObject[0] = localFrameLayout.getVisibility();
      localObject = this.zQa;
      localFrameLayout = (FrameLayout)((View)this.zQb).findViewById(b.f.finder_profile_follow_btn);
      p.j(localFrameLayout, "header.finder_profile_follow_btn");
      localObject[1] = localFrameLayout.getVisibility();
      localObject = (FrameLayout)((View)this.zQb).findViewById(b.f.sendMsgBtn);
      p.j(localObject, "header.sendMsgBtn");
      if (((FrameLayout)localObject).getVisibility() == 0)
      {
        localObject = (FrameLayout)((View)this.zQb).findViewById(b.f.sendMsgBtn);
        p.j(localObject, "header.sendMsgBtn");
        ((FrameLayout)localObject).setVisibility(4);
      }
      localObject = (FrameLayout)((View)this.zQb).findViewById(b.f.finder_profile_follow_btn);
      p.j(localObject, "header.finder_profile_follow_btn");
      if (((FrameLayout)localObject).getVisibility() == 0)
      {
        localObject = (FrameLayout)((View)this.zQb).findViewById(b.f.finder_profile_follow_btn);
        p.j(localObject, "header.finder_profile_follow_btn");
        ((FrameLayout)localObject).setVisibility(4);
      }
    }
    AppMethodBeat.o(276508);
  }
  
  public final void a(SpannableString paramSpannableString, String paramString)
  {
    AppMethodBeat.i(276506);
    p.k(paramString, "locationText");
    a(paramSpannableString, paramString, true);
    AppMethodBeat.o(276506);
  }
  
  public final void a(final SpannableString paramSpannableString, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(276507);
    p.k(paramString, "lltext");
    if ((paramSpannableString == null) || (Util.isNullOrNil(paramSpannableString.toString())))
    {
      AppMethodBeat.o(276507);
      return;
    }
    final aa.f localf = new aa.f();
    paramSpannableString = paramSpannableString.toString();
    p.j(paramSpannableString, "spannableStr.toString()");
    localf.aaBC = paramSpannableString;
    paramSpannableString = new aa.f();
    paramSpannableString.aaBC = paramString;
    pZ(paramBoolean);
    if ((String)localf.aaBC != null) {
      this.zQb.post((Runnable)new b(this, localf, paramSpannableString, paramBoolean));
    }
    AppMethodBeat.o(276507);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper$changePosition$1$1"})
  static final class b
    implements Runnable
  {
    b(a parama, aa.f paramf1, aa.f paramf2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(285043);
      int i = a.a(this.zQd);
      int j = i - a.b(this.zQd);
      float f1 = a.c(this.zQd);
      Object localObject = (TextView)((View)this.zQd.zQb).findViewById(b.f.finder_profile_name_tv);
      p.j(localObject, "header.finder_profile_name_tv");
      float f2 = ((TextView)localObject).getPaint().measureText((String)localf.aaBC);
      float f3 = a.a(this.zQd, (String)paramSpannableString.aaBC);
      FrameLayout localFrameLayout;
      if ((f2 + f1 > j) || (f3 > j))
      {
        localObject = this.zQd;
        localFrameLayout = (FrameLayout)((View)this.zQd.zQb).findViewById(b.f.sendMsgBtn);
        p.j(localFrameLayout, "header.sendMsgBtn");
        a.a((a)localObject, true, (View)localFrameLayout);
        localObject = this.zQd;
        localFrameLayout = (FrameLayout)((View)this.zQd.zQb).findViewById(b.f.finder_profile_follow_btn);
        p.j(localFrameLayout, "header.finder_profile_follow_btn");
        a.a((a)localObject, true, (View)localFrameLayout);
        j = com.tencent.mm.ci.a.aZ(this.zQd.zQb.getContext(), b.d.Edge_2A);
        a.a(this.zQd, (String)localf.aaBC, (String)paramSpannableString.aaBC, i - j, (int)f1);
      }
      for (;;)
      {
        a.a(this.zQd, paramBoolean);
        AppMethodBeat.o(285043);
        return;
        localObject = this.zQd;
        localFrameLayout = (FrameLayout)((View)this.zQd.zQb).findViewById(b.f.sendMsgBtn);
        p.j(localFrameLayout, "header.sendMsgBtn");
        a.a((a)localObject, false, (View)localFrameLayout);
        localObject = this.zQd;
        localFrameLayout = (FrameLayout)((View)this.zQd.zQb).findViewById(b.f.finder_profile_follow_btn);
        p.j(localFrameLayout, "header.finder_profile_follow_btn");
        a.a((a)localObject, false, (View)localFrameLayout);
        a.a(this.zQd, (String)localf.aaBC, (String)paramSpannableString.aaBC, j, (int)f1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.adapter.a
 * JD-Core Version:    0.7.0.1
 */