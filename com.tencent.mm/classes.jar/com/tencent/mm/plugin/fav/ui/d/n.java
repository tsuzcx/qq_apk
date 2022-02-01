package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashSet;
import java.util.LinkedList;

public final class n
  extends b
{
  private HashSet<Long> AoV;
  final int Aod;
  
  public n(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(107483);
    this.Aod = a.br(paramFavoriteImageServer.context, q.c.FavImageSize);
    this.AoV = new HashSet();
    AppMethodBeat.o(107483);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, final g paramg)
  {
    AppMethodBeat.i(107484);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, q.f.fav_listitem_shortview, null), paramViewGroup, paramg);
      paramViewGroup.Aop = ((ImageView)paramView.findViewById(q.e.fav_image));
      paramViewGroup.AoX = ((TextView)paramView.findViewById(q.e.fav_video_duration));
      b(paramViewGroup.Aop, paramg);
      LinkedList localLinkedList = paramg.field_favProto.vEn;
      if (localLinkedList.size() <= 0) {
        break label244;
      }
      int i = ((arf)localLinkedList.getFirst()).duration;
      paramViewGroup.AoX.setText(m.Q((Context)localObject, i));
      if ((paramg != null) && (i <= 1)) {
        break label193;
      }
      label130:
      paramViewGroup.AoX.setVisibility(0);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.AfM.a(paramViewGroup.Aop, (arf)localObject, paramg, q.h.app_attach_file_icon_video, this.Aod, this.Aod);
      AppMethodBeat.o(107484);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label193:
      if (this.AoV.contains(Long.valueOf(paramg.field_localId))) {
        break label130;
      }
      this.AoV.add(Long.valueOf(paramg.field_localId));
      h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107482);
          com.tencent.mm.plugin.fav.a.b.o(paramg);
          AppMethodBeat.o(107482);
        }
      });
      break label130;
      label244:
      paramViewGroup.AoX.setVisibility(8);
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107485);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107485);
  }
  
  public static final class a
    extends b.b
  {
    TextView AoX;
    ImageView Aop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.n
 * JD-Core Version:    0.7.0.1
 */