package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.sdk.platformtools.Util;

public final class r
  extends b
{
  private final int wRA;
  
  public r(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107493);
    this.wRA = a.aY(paramo.context, s.c.FavIconSize);
    AppMethodBeat.o(107493);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107494);
    Object localObject1 = paramViewGroup.getContext();
    TextView localTextView;
    Object localObject2;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localObject1 = a(View.inflate((Context)localObject1, s.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.qps = ((ImageView)((View)localObject1).findViewById(s.e.fav_icon));
      paramViewGroup.wRS = ((ImageView)((View)localObject1).findViewById(s.e.fav_icon_mask));
      paramViewGroup.mNb = ((TextView)((View)localObject1).findViewById(s.e.fav_title));
      paramViewGroup.mNb.setMaxLines(2);
      a(paramViewGroup, paramg);
      anm localanm1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      aor localaor = paramg.field_favProto.Szr;
      localTextView = paramViewGroup.mNb;
      anm localanm2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramView = "";
      if (localaor != null) {
        paramView = localaor.title;
      }
      localObject2 = paramView;
      if (Util.isNullOrNil(paramView))
      {
        localObject2 = paramView;
        if (localanm2 != null) {
          localObject2 = localanm2.title;
        }
      }
      if (!Util.isNullOrNil((String)localObject2)) {
        break label317;
      }
      localTextView.setVisibility(8);
      label180:
      int j = f.boX(localanm1.Syc);
      paramView = this.wJr;
      localObject2 = paramViewGroup.qps;
      int i = j;
      if (j == f.hfL()) {
        i = s.h.app_attach_file_icon_webpage;
      }
      paramView.a((ImageView)localObject2, localanm1, paramg, i, this.wRA, this.wRA);
      if (((paramg.field_favProto.PTL == null) || (paramg.field_favProto.PTL.llp != 5)) && ((localaor == null) || (Util.isNullOrNil(localaor.SBh)))) {
        break label333;
      }
      paramViewGroup.wRS.setImageResource(s.h.shortvideo_play_btn);
      paramViewGroup.wRS.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(107494);
      return localObject1;
      paramViewGroup = (a)paramView.getTag();
      localObject1 = paramView;
      break;
      label317:
      localTextView.setText((CharSequence)localObject2);
      localTextView.setVisibility(0);
      break label180;
      label333:
      paramViewGroup.wRS.setVisibility(8);
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107496);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    Object localObject = locala.qps;
    g localg = locala.wHw;
    if ((localg.field_favProto == null) || (localg.field_favProto.PTL == null) || (localg.field_favProto.PTL.llp < 0)) {}
    for (;;)
    {
      ((z)h.ae(z.class)).a(paramView, locala.wHw, paramaoe);
      AppMethodBeat.o(107496);
      return;
      int[] arrayOfInt = new int[2];
      if (localObject != null)
      {
        int i = ((View)localObject).getWidth();
        int j = ((View)localObject).getHeight();
        ((View)localObject).getLocationInWindow(arrayOfInt);
        localObject = localg.field_favProto.PTL;
        ((anu)localObject).SAt = new anv();
        ((anu)localObject).SAt.left = arrayOfInt[0];
        ((anu)localObject).SAt.top = arrayOfInt[1];
        ((anu)localObject).SAt.width = i;
        ((anu)localObject).SAt.height = j;
      }
    }
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(107495);
    try
    {
      aor localaor = paramb.wHw.field_favProto.Szr;
      if ((localaor != null) && (!Util.isNullOrNil(localaor.SBh)))
      {
        paramb.mYd.setText(s.i.topstory);
        AppMethodBeat.o(107495);
        return;
      }
      super.a(paramb);
      AppMethodBeat.o(107495);
      return;
    }
    catch (Exception paramb)
    {
      AppMethodBeat.o(107495);
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView mNb;
    ImageView qps;
    ImageView wRS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.r
 * JD-Core Version:    0.7.0.1
 */