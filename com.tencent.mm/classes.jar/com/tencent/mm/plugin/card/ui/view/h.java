package com.tencent.mm.plugin.card.ui.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.b.a.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public abstract class h
  implements ab
{
  protected MMActivity pQZ;
  protected g qjU;
  
  public h(g paramg, MMActivity paramMMActivity)
  {
    this.qjU = paramg;
    this.pQZ = paramMMActivity;
  }
  
  public void c(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    Object localObject1;
    Object localObject2;
    if (cxx())
    {
      localObject1 = (TextView)paramViewGroup.findViewById(2131298817);
      localObject2 = this.qjU.code;
      if ((!paramb.csK()) && ((Util.isNullOrNil((String)localObject2)) || (((String)localObject2).length() > 40))) {
        break label299;
      }
      ((TextView)localObject1).setText(n.akl((String)localObject2));
      if (paramb.csF())
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113672);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
            if (paramAnonymousView.getId() == 2131298817)
            {
              q.TF(paramb.csR().code);
              com.tencent.mm.ui.base.h.cD(h.this.pQZ, p.getString(2131755773));
            }
            a.a(false, this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(113672);
            return false;
          }
        });
        this.qjU.d(c.qkV);
      }
    }
    else if (cxy())
    {
      localObject1 = (LinearLayout)paramViewGroup.findViewById(2131298804);
      if ((paramb == null) || (paramb.csQ() == null) || (paramb.csQ().Lfe == null) || (Util.isNullOrNil(paramb.csQ().Lfe.title))) {
        break label321;
      }
      paramViewGroup.findViewById(2131298796).setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = paramb.csQ().Lfe;
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131298806);
      localTextView.setText(((abz)localObject2).title);
      String str = paramb.csQ().ixw;
      if (!Util.isNullOrNil(str)) {
        localTextView.setTextColor(l.ake(str));
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131298805);
      localObject2 = ((abz)localObject2).pRZ;
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
      ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113673);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if (paramb.csJ())
          {
            paramAnonymousView = new j.b();
            com.tencent.mm.plugin.card.d.b.a(h.this.qjU.pQZ, paramAnonymousView.pRN, paramAnonymousView.pRO, false, paramb);
          }
          for (;;)
          {
            t.finish();
            a.a(this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113673);
            return;
            paramAnonymousView = paramb.csQ().Lfe;
            if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.Lep)) && (!Util.isNullOrNil(paramAnonymousView.Leo)))
            {
              int i;
              if (h.this.pQZ.getIntent() != null)
              {
                i = h.this.pQZ.getIntent().getIntExtra("key_from_scene", 3);
                label171:
                if (h.this.pQZ.getIntent() == null) {
                  break label282;
                }
              }
              label282:
              for (int j = h.this.pQZ.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
              {
                com.tencent.mm.plugin.card.d.b.a(paramb.csU(), paramAnonymousView, i, j);
                com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(20), paramb.csU(), paramb.csV(), "", paramAnonymousView.title });
                break;
                i = 3;
                break label171;
              }
            }
            if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
            {
              localObject = l.Y(paramAnonymousView.url, paramAnonymousView.LfD);
              com.tencent.mm.plugin.card.d.b.a(h.this.qjU.pQZ, (String)localObject, 1);
              com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(9), paramb.csU(), paramb.csV(), "", paramAnonymousView.title });
              if (l.a(paramAnonymousView, paramb.csU()))
              {
                l.akj(paramb.csU());
                com.tencent.mm.plugin.card.d.b.b(h.this.qjU.pQZ, paramb.csQ().gTG);
              }
            }
          }
        }
      });
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
  
  public abstract boolean cxx();
  
  public abstract boolean cxy();
  
  public boolean g(com.tencent.mm.plugin.card.base.b paramb)
  {
    return true;
  }
  
  public void n(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.h
 * JD-Core Version:    0.7.0.1
 */