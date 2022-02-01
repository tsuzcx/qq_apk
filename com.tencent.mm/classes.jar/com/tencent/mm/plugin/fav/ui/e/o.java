package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;

public final class o
  extends b
{
  private final int wRA;
  private final String wSk;
  
  public o(com.tencent.mm.plugin.fav.ui.o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107486);
    this.wRA = a.aY(paramo.context, s.c.FavIconSize);
    this.wSk = "";
    AppMethodBeat.o(107486);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107487);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, s.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.wOb = ((MMImageView)paramView.findViewById(s.e.fav_icon));
      paramViewGroup.mNb = ((TextView)paramView.findViewById(s.e.fav_title));
      paramViewGroup.mrM = ((TextView)paramView.findViewById(s.e.fav_desc));
      paramViewGroup.wRL = ((TextView)paramView.findViewById(s.e.fav_source));
      paramViewGroup.wRL.setVisibility(0);
      a(paramViewGroup, paramg);
      aol localaol = paramg.field_favProto.Szv;
      if (localaol == null) {
        break label224;
      }
      paramViewGroup.mNb.setText(Util.nullAsNil(localaol.title));
      paramViewGroup.mrM.setText(Util.nullAsNil(localaol.desc));
    }
    for (;;)
    {
      paramViewGroup.wRL.setText(Util.nullAs(com.tencent.mm.plugin.fav.a.b.getAppName(localContext, paramg.field_favProto.SAB.appId), this.wSk));
      this.wJr.a(paramViewGroup.wOb, null, paramg, s.h.app_attach_file_icon_unknow, this.wRA, this.wRA);
      AppMethodBeat.o(107487);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label224:
      paramViewGroup.mNb.setText("");
      paramViewGroup.mrM.setText("");
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107488);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ae(z.class)).a(paramView, locala.wHw, paramaoe);
    AppMethodBeat.o(107488);
  }
  
  public static final class a
    extends b.b
  {
    TextView mNb;
    TextView mrM;
    MMImageView wOb;
    TextView wRL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.o
 * JD-Core Version:    0.7.0.1
 */