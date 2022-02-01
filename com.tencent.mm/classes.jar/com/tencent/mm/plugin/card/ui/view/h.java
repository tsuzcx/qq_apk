package com.tencent.mm.plugin.card.ui.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public abstract class h
  implements ab
{
  protected g tFQ;
  protected MMActivity tmY;
  
  public h(g paramg, MMActivity paramMMActivity)
  {
    this.tFQ = paramg;
    this.tmY = paramMMActivity;
  }
  
  public void c(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    Object localObject1;
    Object localObject2;
    if (cKZ())
    {
      localObject1 = (TextView)paramViewGroup.findViewById(a.d.tfp);
      localObject2 = this.tFQ.code;
      if ((!paramb.cGl()) && ((Util.isNullOrNil((String)localObject2)) || (((String)localObject2).length() > 40))) {
        break label304;
      }
      ((TextView)localObject1).setText(n.arY((String)localObject2));
      if (paramb.cGg())
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113672);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
            if (paramAnonymousView.getId() == a.d.tfp)
            {
              q.abo(paramb.cGt().code);
              com.tencent.mm.ui.base.h.cO(h.this.tmY, p.getString(a.g.app_copy_ok));
            }
            a.a(false, this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(113672);
            return false;
          }
        });
        this.tFQ.d(c.tGR);
      }
    }
    else if (cLa())
    {
      localObject1 = (LinearLayout)paramViewGroup.findViewById(a.d.tfd);
      if ((paramb == null) || (paramb.cGs() == null) || (paramb.cGs().Sgs == null) || (Util.isNullOrNil(paramb.cGs().Sgs.title))) {
        break label326;
      }
      paramViewGroup.findViewById(a.d.tfb).setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = paramb.cGs().Sgs;
      TextView localTextView = (TextView)paramViewGroup.findViewById(a.d.tff);
      localTextView.setText(((acg)localObject2).title);
      String str = paramb.cGs().lmL;
      if (!Util.isNullOrNil(str)) {
        localTextView.setTextColor(l.arR(str));
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(a.d.tfe);
      localObject2 = ((acg)localObject2).tnZ;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label313;
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setText((CharSequence)localObject2);
        paramViewGroup.setVisibility(0);
      }
    }
    for (;;)
    {
      ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113673);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (paramb.cGk())
          {
            paramAnonymousView = new j.b();
            com.tencent.mm.plugin.card.d.b.a(h.this.tFQ.tmY, paramAnonymousView.tnN, paramAnonymousView.tnO, false, paramb);
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113673);
            return;
            paramAnonymousView = paramb.cGs().Sgs;
            if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.SfC)) && (!Util.isNullOrNil(paramAnonymousView.SfB)))
            {
              int i;
              if (h.this.tmY.getIntent() != null)
              {
                i = h.this.tmY.getIntent().getIntExtra("key_from_scene", 3);
                label168:
                if (h.this.tmY.getIntent() == null) {
                  break label279;
                }
              }
              label279:
              for (int j = h.this.tmY.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
              {
                com.tencent.mm.plugin.card.d.b.a(paramb.cGw(), paramAnonymousView, i, j);
                com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(20), paramb.cGw(), paramb.cGx(), "", paramAnonymousView.title });
                break;
                i = 3;
                break label168;
              }
            }
            if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
            {
              localObject = l.Z(paramAnonymousView.url, paramAnonymousView.SgR);
              com.tencent.mm.plugin.card.d.b.a(h.this.tFQ.tmY, (String)localObject, 1);
              com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(9), paramb.cGw(), paramb.cGx(), "", paramAnonymousView.title });
              if (l.a(paramAnonymousView, paramb.cGw()))
              {
                l.arW(paramb.cGw());
                com.tencent.mm.plugin.card.d.b.b(h.this.tFQ.tmY, paramb.cGs().jEi);
              }
            }
          }
        }
      });
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      label304:
      ((TextView)localObject1).setVisibility(8);
      break;
      label313:
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(8);
      }
    }
    label326:
    ((LinearLayout)localObject1).setVisibility(8);
  }
  
  public abstract boolean cKZ();
  
  public abstract boolean cLa();
  
  public boolean g(com.tencent.mm.plugin.card.base.b paramb)
  {
    return true;
  }
  
  public void o(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.h
 * JD-Core Version:    0.7.0.1
 */