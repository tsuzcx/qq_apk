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
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashSet;
import java.util.LinkedList;

public final class n
  extends b
{
  final int wRA;
  private HashSet<Long> wSs;
  
  public n(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107483);
    this.wRA = a.aY(paramo.context, s.c.FavImageSize);
    this.wSs = new HashSet();
    AppMethodBeat.o(107483);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, final g paramg)
  {
    AppMethodBeat.i(107484);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, s.f.fav_listitem_shortview, null), paramViewGroup, paramg);
      paramViewGroup.wRM = ((ImageView)paramView.findViewById(s.e.fav_image));
      paramViewGroup.wSu = ((TextView)paramView.findViewById(s.e.fav_video_duration));
      LinkedList localLinkedList = paramg.field_favProto.syG;
      if (localLinkedList.size() <= 0) {
        break label235;
      }
      int i = ((anm)localLinkedList.getFirst()).duration;
      paramViewGroup.wSu.setText(m.N((Context)localObject, i));
      if ((paramg != null) && (i <= 1)) {
        break label184;
      }
      label121:
      paramViewGroup.wSu.setVisibility(0);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.wJr.a(paramViewGroup.wRM, (anm)localObject, paramg, s.h.app_attach_file_icon_video, this.wRA, this.wRA);
      AppMethodBeat.o(107484);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label184:
      if (this.wSs.contains(Long.valueOf(paramg.field_localId))) {
        break label121;
      }
      this.wSs.add(Long.valueOf(paramg.field_localId));
      h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107482);
          com.tencent.mm.plugin.fav.a.b.o(paramg);
          AppMethodBeat.o(107482);
        }
      });
      break label121;
      label235:
      paramViewGroup.wSu.setVisibility(8);
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107485);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ae(z.class)).a(paramView, locala.wHw, paramaoe);
    AppMethodBeat.o(107485);
  }
  
  public static final class a
    extends b.b
  {
    ImageView wRM;
    TextView wSu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.n
 * JD-Core Version:    0.7.0.1
 */