package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public abstract class h
  implements ab
{
  protected MMActivity jpX;
  protected g kBe;
  
  public h(g paramg, MMActivity paramMMActivity)
  {
    this.kBe = paramg;
    this.jpX = paramMMActivity;
  }
  
  public abstract boolean bfr();
  
  public abstract boolean bfs();
  
  public void c(ViewGroup paramViewGroup, final b paramb)
  {
    Object localObject1;
    Object localObject2;
    if (bfr())
    {
      localObject1 = (TextView)paramViewGroup.findViewById(2131822013);
      localObject2 = this.kBe.code;
      if ((!paramb.baY()) && ((bo.isNullOrNil((String)localObject2)) || (((String)localObject2).length() > 40))) {
        break label299;
      }
      ((TextView)localObject1).setText(m.II((String)localObject2));
      if (paramb.baT())
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(88745);
            if (paramAnonymousView.getId() == 2131822013)
            {
              com.tencent.mm.plugin.card.d.p.xJ(paramb.bbe().code);
              com.tencent.mm.ui.base.h.bO(h.this.jpX, com.tencent.mm.a.p.getString(2131296896));
            }
            AppMethodBeat.o(88745);
            return false;
          }
        });
        this.kBe.d(c.kCf);
      }
    }
    else if (bfs())
    {
      localObject1 = (LinearLayout)paramViewGroup.findViewById(2131822025);
      if ((paramb == null) || (paramb.bbd() == null) || (paramb.bbd().wGD == null) || (bo.isNullOrNil(paramb.bbd().wGD.title))) {
        break label321;
      }
      paramViewGroup.findViewById(2131822024).setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = paramb.bbd().wGD;
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131822026);
      localTextView.setText(((uo)localObject2).title);
      String str = paramb.bbd().color;
      if (!bo.isNullOrNil(str)) {
        localTextView.setTextColor(l.IB(str));
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131822027);
      localObject2 = ((uo)localObject2).kmo;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label308;
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setText((CharSequence)localObject2);
        paramViewGroup.setVisibility(0);
      }
    }
    for (;;)
    {
      ((LinearLayout)localObject1).setOnClickListener(new h.2(this, paramb));
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      label299:
      ((TextView)localObject1).setVisibility(8);
      break;
      label308:
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(8);
      }
    }
    label321:
    ((LinearLayout)localObject1).setVisibility(8);
  }
  
  public boolean g(b paramb)
  {
    return true;
  }
  
  public void l(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.h
 * JD-Core Version:    0.7.0.1
 */