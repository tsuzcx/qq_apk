package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends b
{
  private final int Aod;
  
  public h(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(107461);
    this.Aod = a.br(paramFavoriteImageServer.context, q.c.FavIconSize);
    AppMethodBeat.o(107461);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107462);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, q.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.ttT = ((ImageView)paramView.findViewById(q.e.fav_icon));
      paramViewGroup.pJJ = ((TextView)paramView.findViewById(q.e.fav_title));
      paramViewGroup.plr = ((TextView)paramView.findViewById(q.e.fav_desc));
      paramViewGroup.Aoo = ((TextView)paramView.findViewById(q.e.fav_source));
      paramViewGroup.Aoo.setVisibility(8);
      am(paramViewGroup.ttT, 11);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = paramg.field_favProto.ZAl;
      paramViewGroup.pJJ.setText(Util.nullAsNil(((aru)localObject).title));
      paramViewGroup.plr.setText(Util.nullAsNil(((aru)localObject).desc));
      paramViewGroup.pJJ.setSingleLine(false);
      paramViewGroup.pJJ.setMaxLines(2);
      this.AfM.a(paramViewGroup.ttT, null, paramg, q.h.app_attach_file_icon_unknow, this.Aod, this.Aod);
      AppMethodBeat.o(107462);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107463);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)com.tencent.mm.kernel.h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107463);
  }
  
  public static final class a
    extends b.b
  {
    TextView Aoo;
    TextView pJJ;
    TextView plr;
    ImageView ttT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.h
 * JD-Core Version:    0.7.0.1
 */