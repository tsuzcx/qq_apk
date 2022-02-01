package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashSet;
import java.util.LinkedList;

public final class n
  extends b
{
  private HashSet<Long> tlU;
  final int tlc;
  
  public n(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107483);
    this.tlc = a.aG(paramo.context, 2131165370);
    this.tlU = new HashSet();
    AppMethodBeat.o(107483);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107484);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131494133, null), paramViewGroup, paramg);
      paramViewGroup.tlo = ((ImageView)paramView.findViewById(2131300476));
      paramViewGroup.tlW = ((TextView)paramView.findViewById(2131300535));
      LinkedList localLinkedList = paramg.field_favProto.ppH;
      if (localLinkedList.size() <= 0) {
        break label231;
      }
      int i = ((aml)localLinkedList.getFirst()).duration;
      paramViewGroup.tlW.setText(m.J((Context)localObject, i));
      if ((paramg != null) && (i <= 1)) {
        break label180;
      }
      label118:
      paramViewGroup.tlW.setVisibility(0);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.tdg.a(paramViewGroup.tlo, (aml)localObject, paramg, 2131689584, this.tlc, this.tlc);
      AppMethodBeat.o(107484);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label180:
      if (this.tlU.contains(Long.valueOf(paramg.field_localId))) {
        break label118;
      }
      this.tlU.add(Long.valueOf(paramg.field_localId));
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107482);
          com.tencent.mm.plugin.fav.a.b.o(paramg);
          AppMethodBeat.o(107482);
        }
      });
      break label118;
      label231:
      paramViewGroup.tlW.setVisibility(8);
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107485);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(107485);
  }
  
  public static final class a
    extends b.b
  {
    TextView tlW;
    ImageView tlo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.n
 * JD-Core Version:    0.7.0.1
 */