package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.q;
import java.util.HashSet;
import java.util.Set;

public final class i
  extends b
{
  private final int qkA;
  private Set<ImageView> qkP;
  private View.OnClickListener qkQ;
  
  public i(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107465);
    this.qkQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107464);
        if (!com.tencent.mm.compatible.util.e.XG())
        {
          t.g(i.this.qcI.context, null);
          AppMethodBeat.o(107464);
          return;
        }
        Object localObject;
        agu localagu;
        afy localafy;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g))
        {
          localObject = (com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag();
          localagu = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.DiD;
          localafy = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject);
          if (localafy == null)
          {
            ad.w("MicroMsg.FavBaseListItem", "data item is null");
            AppMethodBeat.o(107464);
            return;
          }
          if (com.tencent.mm.plugin.fav.a.b.f(localafy))
          {
            ad.i("MicroMsg.FavBaseListItem", "same song, do release");
            com.tencent.mm.az.a.azD();
            i.a(i.this, null);
            AppMethodBeat.o(107464);
            return;
          }
          localObject = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localafy));
          if (((com.tencent.mm.vfs.e)localObject).exists()) {
            break label301;
          }
          if (localafy.deE != null) {
            break label239;
          }
          localObject = "";
        }
        for (;;)
        {
          localObject = com.tencent.mm.az.g.a(6, null, localafy.title, localafy.desc, localafy.Dgg, localafy.Dgk, localafy.Dgi, localafy.dkb, com.tencent.mm.plugin.fav.a.b.chv(), (String)localObject, "", localagu.appId);
          ((f)localObject).hnG = localafy.songAlbumUrl;
          ((f)localObject).hny = localafy.songLyric;
          ((f)localObject).hnQ = localafy.dkb;
          com.tencent.mm.az.a.c((f)localObject);
          i.a(i.this, (ImageView)paramAnonymousView);
          AppMethodBeat.o(107464);
          return;
          label239:
          localObject = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.chp() + com.tencent.mm.b.g.getMessageDigest(localafy.deE.getBytes()));
          if (((com.tencent.mm.vfs.e)localObject).exists()) {}
          for (localObject = q.B(((com.tencent.mm.vfs.e)localObject).fhU());; localObject = "") {
            break;
          }
          label301:
          localObject = q.B(((com.tencent.mm.vfs.e)localObject).fhU());
        }
      }
    };
    this.qkA = com.tencent.mm.cd.a.ao(paramo.context, 2131165358);
    this.qkP = new HashSet();
    AppMethodBeat.o(107465);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107466);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131493955, null), paramViewGroup, paramg);
      paramViewGroup.kXS = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.ica = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.hJe = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.qkS = ((ImageView)paramView.findViewById(2131299798));
      paramViewGroup.qkL = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.qkL.setVisibility(8);
      paramViewGroup.qkS.setOnClickListener(this.qkQ);
      paramViewGroup.qkS.setVisibility(0);
      this.qkP.add(paramViewGroup.qkS);
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramViewGroup.ica.setText(((afy)localObject).title);
      paramViewGroup.hJe.setText(((afy)localObject).desc);
      paramViewGroup.hJe.setVisibility(0);
      this.qcI.a(paramViewGroup.kXS, (afy)localObject, paramg, 2131689564, this.qkA, this.qkA);
      paramViewGroup.qkS.setTag(paramg);
      if (!com.tencent.mm.plugin.fav.a.b.f((afy)localObject)) {
        break label256;
      }
      paramViewGroup.qkS.setImageResource(2131233393);
    }
    for (;;)
    {
      AppMethodBeat.o(107466);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label256:
      paramViewGroup.qkS.setImageResource(2131233395);
    }
  }
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(107467);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qaS, paramagq);
    AppMethodBeat.o(107467);
  }
  
  public static final class a
    extends b.b
  {
    TextView hJe;
    TextView ica;
    ImageView kXS;
    TextView qkL;
    ImageView qkS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.i
 * JD-Core Version:    0.7.0.1
 */