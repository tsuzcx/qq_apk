package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;

public final class o
  extends b
{
  private final String AoN;
  private final int Aod;
  
  public o(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(107486);
    this.Aod = a.br(paramFavoriteImageServer.context, q.c.FavIconSize);
    this.AoN = "";
    AppMethodBeat.o(107486);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107487);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, q.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.AkD = ((MMImageView)paramView.findViewById(q.e.fav_icon));
      paramViewGroup.pJJ = ((TextView)paramView.findViewById(q.e.fav_title));
      paramViewGroup.plr = ((TextView)paramView.findViewById(q.e.fav_desc));
      paramViewGroup.Aoo = ((TextView)paramView.findViewById(q.e.fav_source));
      paramViewGroup.Aoo.setVisibility(0);
      b(paramViewGroup.pJJ, paramg);
      a(paramViewGroup, paramg);
      ase localase = paramg.field_favProto.ZAn;
      if (localase == null) {
        break label233;
      }
      paramViewGroup.pJJ.setText(Util.nullAsNil(localase.title));
      paramViewGroup.plr.setText(Util.nullAsNil(localase.desc));
    }
    for (;;)
    {
      paramViewGroup.Aoo.setText(Util.nullAs(com.tencent.mm.plugin.fav.a.b.getAppName(localContext, paramg.field_favProto.ZBt.appId), this.AoN));
      this.AfM.a(paramViewGroup.AkD, null, paramg, q.h.app_attach_file_icon_unknow, this.Aod, this.Aod);
      AppMethodBeat.o(107487);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label233:
      paramViewGroup.pJJ.setText("");
      paramViewGroup.plr.setText("");
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107488);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107488);
  }
  
  public static final class a
    extends b.b
  {
    MMImageView AkD;
    TextView Aoo;
    TextView pJJ;
    TextView plr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.o
 * JD-Core Version:    0.7.0.1
 */